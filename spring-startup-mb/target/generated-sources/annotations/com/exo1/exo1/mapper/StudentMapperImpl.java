package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.StudentDto;
import com.exo1.exo1.entity.Student;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-05T13:59:30+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 23.0.2 (Homebrew)"
)
@Component
public class StudentMapperImpl implements StudentMapper {

    @Override
    public StudentDto toDto(Student student) {

        StudentDto studentDto = new StudentDto();

        if ( student != null ) {
            studentDto.setId( student.getId() );
            studentDto.setName( student.getName() );
            studentDto.setGender( student.getGender() );
            studentDto.setSchool_id( student.getSchool_id() );
        }

        return studentDto;
    }

    @Override
    public Student toEntity(StudentDto studentDto) {

        Student student = new Student();

        if ( studentDto != null ) {
            student.setId( studentDto.getId() );
            student.setName( studentDto.getName() );
            student.setGender( studentDto.getGender() );
            student.setSchool_id( studentDto.getSchool_id() );
        }

        return student;
    }

    @Override
    public List<StudentDto> toDtos(List<Student> students) {
        if ( students == null ) {
            return new ArrayList<StudentDto>();
        }

        List<StudentDto> list = new ArrayList<StudentDto>( students.size() );
        for ( Student student : students ) {
            list.add( toDto( student ) );
        }

        return list;
    }

    @Override
    public List<Student> toEntities(List<StudentDto> studentDtoList) {
        if ( studentDtoList == null ) {
            return new ArrayList<Student>();
        }

        List<Student> list = new ArrayList<Student>( studentDtoList.size() );
        for ( StudentDto studentDto : studentDtoList ) {
            list.add( toEntity( studentDto ) );
        }

        return list;
    }
}
