package com.sample.mongodb_crud;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public List<Student> fetchAllStudents() {

        return studentService.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student get(@PathVariable String id) {

        return studentService.getByIdStudent(id);
    }

    @PostMapping
    public void save(@RequestBody Student student) {
        studentService.saveStudent(student);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable String id) {
        studentService.deleteStudent(id);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable String id, @RequestBody Student student) {
        studentService.updateStudent(id, student);
    }
}
