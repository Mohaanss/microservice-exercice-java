package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.StudentDto;
import com.exo1.exo1.entity.Student;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;
@Mapper(componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface StudentMapper {
    StudentDto toDto(Student student);
    Student toEntity(StudentDto studentDto);
    List<StudentDto> toDtos(List<Student> students);
    List<Student> toEntities(List<StudentDto> studentDtoList);
}
