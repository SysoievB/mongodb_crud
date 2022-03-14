package com.sample.mongodb_crud;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getAllStudents() {

        return studentRepository.findAll();
    }

    public Student saveStudent(Student student) {
       return studentRepository.save(student);
    }

    public void updateStudent(String id, Student updatedStudent) {
        Student student = getByIdStudent(id);

        if (updatedStudent.getFirstName() != null) student.setFirstName(updatedStudent.getFirstName());

        if (updatedStudent.getLastName() != null) student.setLastName(updatedStudent.getLastName());

        if (updatedStudent.getEmail() != null) student.setEmail(updatedStudent.getEmail());

        if (updatedStudent.getGender() != null) student.setGender(updatedStudent.getGender());

        if (updatedStudent.getAddress() != null) student.setAddress(updatedStudent.getAddress());

        if (updatedStudent.getFavouriteSubjects() != null)
            student.setFavouriteSubjects(updatedStudent.getFavouriteSubjects());

        if (updatedStudent.getTotalSpendInBooks() != null)
            student.setTotalSpendInBooks(updatedStudent.getTotalSpendInBooks());

        if (updatedStudent.getCreated() != null) student.setCreated(LocalDateTime.now());

        studentRepository.save(student);
    }

    public void deleteStudent(String id) {
        Student student = getByIdStudent(id);
        studentRepository.delete(student);
    }

    public Student getByIdStudent(String id) {

        return studentRepository.findById(id).get();
    }
}
