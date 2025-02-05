package com.exo1.exo1.service;


import com.exo1.exo1.dto.StudentDto;
import com.exo1.exo1.entity.Student;
import com.exo1.exo1.mapper.StudentMapper;
import com.exo1.exo1.repository.StudentRepository;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import lombok.AllArgsConstructor;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.webjars.NotFoundException;

import java.awt.print.Pageable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final RestTemplate restTemplate;
    private final DiscoveryClient discoveryClient;

    private StudentMapper studentMapper;
    public List<StudentDto> findAll() {
        return studentMapper.toDtos(studentRepository.findAll());
    }
    public StudentDto save(StudentDto studentDto) {
        Student student = studentMapper.toEntity(studentDto);
        return studentMapper.toDto(studentRepository.save(student));
    }

    public Map<String, Object> findById(String id) {
        ServiceInstance serviceInstance = discoveryClient.getInstances("EXO1").get(0);
        Optional<Student> student = studentRepository.findById(id);
        Map<String, Object> school = restTemplate.getForObject(serviceInstance.getUri() + "/school/" +student.get().getSchool_id(), Map.class);

        // 5. Ajouter les infos de School au Student sous forme de Map
        Map<String, Object> response = new HashMap<>();
        response.put("student", student);
        response.put("school", school);
        return response;
    }
    public  StudentDto UpdateStudent(String id, StudentDto studentDto) {
        return studentMapper.toDto(studentRepository.findById(id).map(x -> {
            x.setName(studentDto.getName());
            x.setGender(studentDto.getGender());
            return studentRepository.save(x); // Enregistre en base
        }).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID: " + id)));
    }
    public void delete(String id) {
        studentRepository.deleteById(id);
    }
}
