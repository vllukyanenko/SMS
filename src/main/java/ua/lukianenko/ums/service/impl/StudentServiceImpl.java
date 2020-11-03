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
import ua.lukianenko.ums.converter.impl.students_converter.ToStudentConverter;
import ua.lukianenko.ums.converter.impl.students_converter.ToStudentDTOConverter;
import ua.lukianenko.ums.dto.StudentDTO;
import ua.lukianenko.ums.exceptions.ObjectNotFoundException;
import ua.lukianenko.ums.model.persons.Student;
import ua.lukianenko.ums.repositorys.StudentRepository;
import ua.lukianenko.ums.service.StudentService;

import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {
    @NonNull
    private final StudentRepository studentRepository;
    @NonNull
    private final ToStudentConverter toStudentConverter;
    @NonNull
    private final ToStudentDTOConverter toStudentDTOConverter;

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<StudentDTO> getById(Long id) {
        log.info("IN StudentServiceImpl getById {}", id);
        return new ResponseEntity<>(toStudentDTOConverter.convert(studentRepository.findById(id)
        .orElseThrow(()-> new ObjectNotFoundException(id, Student.class))), HttpStatus.OK);
    }
    @Transactional
    @Override
    public ResponseEntity<Long> save(StudentDTO studentDTO) {
        log.info("IN StudentServiceImpl saveGroup {}", studentDTO);
        return new ResponseEntity<>(studentRepository.save(toStudentConverter.convert(studentDTO)).getId()
                , HttpStatus.CREATED);
    }

    @Transactional
    @Override
    public ResponseEntity<Long> updateById(Long id, StudentDTO studentDTO) {
        log.info("IN StudentServiceImpl saveStudentDTO {}", studentDTO);
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException(id, Student.class));

        student.setFirstName(studentDTO.getFirstName());
        student.setLastName(studentDTO.getLastName());
        student.setDateOfBirth(studentDTO.getDateOfBirth());
        student.setPhoneNumber(studentDTO.getPhoneNumber());
        student.setGroup(studentDTO.getGroup());

        return new ResponseEntity<>(toStudentDTOConverter.convert(studentRepository.save(student)).getId(),HttpStatus.OK);
    }

    @Transactional
    @Override
    public ResponseEntity<Long> deleteById(Long id) {
        log.info("IN StudentServiceImpl deleteById {}", id);
        Student student = studentRepository.findById(id)
                .orElseThrow(()-> new ObjectNotFoundException(id, Student.class));
        studentRepository.deleteById(id);
        return new ResponseEntity<>(student.getId(), HttpStatus.NO_CONTENT);
    }

    @Transactional(readOnly = true)
    @Override
    public ResponseEntity<List<StudentDTO>> getAll() {
        log.info("IN StudentServiceImpl getAll");
        List<StudentDTO> students = toStudentDTOConverter.convert(studentRepository.findAll());
        if(students.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(students, HttpStatus.OK);
    }

    @Transactional
    @Override
    public PageResponse<StudentDTO> getPage(int pageNo, int pageSize, String sorting, String name) {
        log.info("IN StudentServiceImpl getPage with sorting");
        Sort sort = name.equalsIgnoreCase(Sort.Direction.ASC.name())? Sort.by(sorting).ascending():
                Sort.by(sorting).descending();
        Pageable pageable = PageRequest.of(pageNo-1, pageSize, sort);
        Page<Student> studentPage = studentRepository.findAll(pageable);
        return new PageResponse<>(
                toStudentDTOConverter.convert(studentPage.getContent()),
                studentPage.getTotalElements(),
                studentPage.getNumber()+1,
                studentPage.getSize());
    }
}
