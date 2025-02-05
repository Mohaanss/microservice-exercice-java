package com.exo1.exo1.service;

import com.exo1.exo1.dto.SchoolDto;
import com.exo1.exo1.entity.School;
import com.exo1.exo1.mapper.SchoolMapper;
import com.exo1.exo1.repository.SchoolRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;
    private SchoolMapper schoolMapper;

    public List<SchoolDto> findAll() {
        return schoolMapper.toDtos(schoolRepository.findAll());
    }
    public SchoolDto save(SchoolDto schoolDto) {
        School school = schoolMapper.toEntity(schoolDto);
        return schoolMapper.toDto(schoolRepository.save(school));
    }

    public SchoolDto findById(Long id) {
        return schoolMapper.toDto(schoolRepository.findById(id).get());
    }
    public  SchoolDto UpdateSchool(Long id, SchoolDto schoolDto) {
        return schoolMapper.toDto(schoolRepository.findById(id).map(x -> {
            x.setName(schoolDto.getName());
            x.setAddress(schoolDto.getAddress());
            x.setDirectorName(schoolDto.getDirectorName());
            return schoolRepository.save(x); // Enregistre en base
        }).orElseThrow(() -> new RuntimeException("Utilisateur non trouvé avec l'ID: " + id)));
    }
    public void delete(Long id) {
        schoolRepository.deleteById(id);
    }
}
