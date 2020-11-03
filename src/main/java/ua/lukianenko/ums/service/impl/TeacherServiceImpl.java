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
import ua.lukianenko.ums.converter.impl.teacher_converter.ToTeacherConverter;
import ua.lukianenko.ums.converter.impl.teacher_converter.ToTeacherDTOConverter;
import ua.lukianenko.ums.dto.TeacherDTO;
import ua.lukianenko.ums.exceptions.ObjectNotFoundException;
import ua.lukianenko.ums.model.persons.Student;
import ua.lukianenko.ums.model.persons.Teacher;
import ua.lukianenko.ums.repositorys.TeacherRepository;
import ua.lukianenko.ums.service.TeacherService;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    @NonNull
    private final TeacherRepository teacherRepository;
    @NonNull
    private final ToTeacherConverter toTeacherConverter;
    @NonNull
    private final ToTeacherDTOConverter toTeacherDTOConverter;
    @Transactional
    @Override
    public ResponseEntity<TeacherDTO> getById(Long id) {
        log.info("IN TeacherServiceImpl getById {}", id);
        return new ResponseEntity<>(toTeacherDTOConverter.convert(teacherRepository.findById(id)
        .orElseThrow(()-> new ObjectNotFoundException(id, Teacher.class))), HttpStatus.OK);
    }
    @Transactional
    @Override
    public ResponseEntity<Long> save(TeacherDTO teacherDTO) {
        log.info("IN TeacherServiceImpl saveGroup {}", teacherDTO);
        return new ResponseEntity<>(teacherRepository.save(toTeacherConverter.convert(teacherDTO)).getId()
        ,HttpStatus.CREATED);
    }
    @Transactional
    @Override
    public ResponseEntity<Long> updateById(Long id, TeacherDTO teacherDTO) {
        log.info("IN TeacherServiceImpl saveStudentDTO {}", teacherDTO);
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException(id, Teacher.class));

        teacher.setFirstName(teacherDTO.getFirstName());
        teacher.setLastName(teacherDTO.getLastName());
        teacher.setDateOfBirth(teacherDTO.getDateOfBirth());
        teacher.setPhoneNumber(teacherDTO.getPhoneNumber());

        return new ResponseEntity<>(teacherRepository.save(teacher).getId(), HttpStatus.OK);
    }
    @Transactional
    @Override
    public ResponseEntity<Long> deleteById(Long id) {
        log.info("IN TeacherServiceImpl deleteById {}", id);
        Teacher teacher = teacherRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException(id, Student.class));
        teacherRepository.deleteById(id);
        return new ResponseEntity<>(teacher.getId(), HttpStatus.NO_CONTENT);
    }
    @Transactional
    @Override
    public ResponseEntity<List<TeacherDTO>> getAll() {
        log.info("IN TeacherServiceImpl getAll");
        List<TeacherDTO> teacherDTOList = toTeacherDTOConverter.convert(teacherRepository.findAll());
        if(teacherDTOList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(teacherDTOList, HttpStatus.OK);
    }

    @Override
    public PageResponse<TeacherDTO> getPage(int pageNo, int pageSize, String sorting, String name) {
        log.info("IN TeacherServiceImpl getPage with sorting");
        Sort sort = name.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sorting).ascending():
                Sort.by(sorting).descending();
        Pageable pageable = PageRequest.of(pageNo-1, pageSize, sort);
        Page<Teacher> teacherPage = teacherRepository.findAll(pageable);
        return new PageResponse<>(
                toTeacherDTOConverter.convert(teacherPage.getContent()),
                teacherPage.getTotalElements(),
                teacherPage.getNumber()+1,
                teacherPage.getSize());
    }
}
