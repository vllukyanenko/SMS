package ua.lukianenko.ums.service.impl;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.lukianenko.ums.controllers.responses.PageResponse;
import ua.lukianenko.ums.converter.impl.sabject_converter.ToSubjectConverter;
import ua.lukianenko.ums.converter.impl.sabject_converter.ToSubjectDTOConverter;
import ua.lukianenko.ums.dto.SubjectDTO;
import ua.lukianenko.ums.exceptions.ObjectNotFoundException;
import ua.lukianenko.ums.model.Subject;
import ua.lukianenko.ums.repositorys.SubjectRepository;
import ua.lukianenko.ums.service.SubjectService;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    @NonNull
    private final SubjectRepository subjectRepository;
    @NonNull
    private final ToSubjectConverter toSubjectConverter;
    @NonNull
    private final ToSubjectDTOConverter toSubjectDTOConverter;

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<SubjectDTO> getById(Long id) {
        return new ResponseEntity<>(toSubjectDTOConverter.convert(subjectRepository.findById(id)
        .orElseThrow(()->new ObjectNotFoundException(id, Subject.class))), HttpStatus.OK);
    }
    @Transactional
    @Override
    public ResponseEntity<Long> save(SubjectDTO subjectDTO) {
        return new ResponseEntity<>(subjectRepository.save(toSubjectConverter.convert(subjectDTO)).getId()
                ,HttpStatus.CREATED);
    }
    @Transactional
    @Override
    public ResponseEntity<Long> updateById(Long id, SubjectDTO subjectDTO) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException(id, Subject.class));
        subject.setName(subjectDTO.getName());
        subject.setDescription(subjectDTO.getDescription());
        subject.setTeachers(subjectDTO.getTeachers());
        return new ResponseEntity<>(subjectRepository.save(subject).getId(), HttpStatus.OK);
    }
    @Transactional
    @Override
    public ResponseEntity<Long> deleteById(Long id) {
        Subject subject = subjectRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException(id, Subject.class));
        subjectRepository.deleteById(id);
        return new ResponseEntity<>(subject.getId(), HttpStatus.NO_CONTENT);
    }
    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<List<SubjectDTO>> getAll() {
        List<SubjectDTO> subjectDTOList = toSubjectDTOConverter.convert(subjectRepository.findAll());
        if(subjectDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(subjectDTOList, HttpStatus.OK);
    }
    @Transactional
    @Override
    public PageResponse<SubjectDTO> getPage(int pageNo, int pageSize, String sorting, String name) {

        Sort sort = name.equalsIgnoreCase(Sort.Direction.ASC.name())
                ?Sort.by(sorting).ascending()
                :Sort.by(sorting).descending();
        Pageable pageable = PageRequest.of(pageNo-1, pageSize, sort);
        Page<Subject> subjectPage = subjectRepository.findAll(pageable);

        return new PageResponse<>(
                toSubjectDTOConverter.convert(subjectPage.getContent()),
                subjectPage.getTotalElements(),
                subjectPage.getNumber()+1,
                subjectPage.getSize());
    }
}
