package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
@Service

public class StudentService {
    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository =studentRepository;
    }
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentOptional = studentRepository.findStudentByName(student.getName());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("name taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists =  studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException(
                    "student with id" + studentId + " does not exists ");
        }
        studentRepository.deleteById(studentId);
    }

    @Transactional
    public void UpdateStudent(Long studentId,
                              String name) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new IllegalStateException("" +
                        "student with id" + studentId + " does not exist "));
        if (name !=null &&
                name.length() > 0 &&
                !Objects.equals(student.getName(), name)) {
            student.setName(name);
        }
    }
}

