package com.exo1.exo1.controller;

import com.exo1.exo1.dto.StudentDto;
import com.exo1.exo1.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @GetMapping
    public ResponseEntity<List<StudentDto>> findAll()
    {
        return ResponseEntity.ok(studentService.findAll());
    }
    @PostMapping
    public ResponseEntity<StudentDto> save(@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(studentService.save(studentDto));
    }
    @GetMapping("/{id}")
    public Map<String, Object> findById(@PathVariable String id){
        return studentService.findById(id);
    }
    @PutMapping("/{id}")
    public ResponseEntity<StudentDto> update(@PathVariable String id,@RequestBody StudentDto studentDto) {
        return ResponseEntity.ok(studentService.UpdateStudent(id, studentDto));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        studentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
