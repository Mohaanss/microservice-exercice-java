package com.exo1.exo1.controller;

import com.exo1.exo1.dto.SchoolDto;
import com.exo1.exo1.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/school")
public class SchoolController {
    @Autowired
    private SchoolService schoolService;
    @GetMapping
    public ResponseEntity<List<SchoolDto>> findAll()
    {
        return ResponseEntity.ok(schoolService.findAll());
    }
    @PostMapping
    public ResponseEntity<SchoolDto> save(@RequestBody SchoolDto schoolDto) {
        return ResponseEntity.ok(schoolService.save(schoolDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity<SchoolDto> findById(@PathVariable Long id){
        return ResponseEntity.ok(schoolService.findById(id));
    }
    @PutMapping("/{id}")
    public ResponseEntity<SchoolDto> update(@PathVariable Long id,@RequestBody SchoolDto schoolDto) {
        return ResponseEntity.ok(schoolService.UpdateSchool(id, schoolDto));
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        schoolService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
