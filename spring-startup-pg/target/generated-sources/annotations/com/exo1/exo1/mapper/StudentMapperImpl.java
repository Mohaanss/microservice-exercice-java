package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.SchoolDto;
import com.exo1.exo1.entity.School;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-04T13:52:18+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
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
            studentDto.setSchool( schoolToSchoolDto( student.getSchool() ) );
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
            student.setSchool( schoolDtoToSchool( studentDto.getSchool() ) );
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

    protected List<StudentDto> studentSetToStudentDtoList(Set<Student> set) {
        if ( set == null ) {
            return new ArrayList<StudentDto>();
        }

        List<StudentDto> list = new ArrayList<StudentDto>( set.size() );
        for ( Student student : set ) {
            list.add( toDto( student ) );
        }

        return list;
    }

    protected SchoolDto schoolToSchoolDto(School school) {

        SchoolDto schoolDto = new SchoolDto();

        if ( school != null ) {
            schoolDto.setId( school.getId() );
            schoolDto.setName( school.getName() );
            schoolDto.setAddress( school.getAddress() );
            schoolDto.setDirectorName( school.getDirectorName() );
            schoolDto.setStudents( studentSetToStudentDtoList( school.getStudents() ) );
        }

        return schoolDto;
    }

    protected Set<Student> studentDtoListToStudentSet(List<StudentDto> list) {
        if ( list == null ) {
            return new LinkedHashSet<Student>();
        }

        Set<Student> set = new LinkedHashSet<Student>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( StudentDto studentDto : list ) {
            set.add( toEntity( studentDto ) );
        }

        return set;
    }

    protected School schoolDtoToSchool(SchoolDto schoolDto) {

        School school = new School();

        if ( schoolDto != null ) {
            school.setId( schoolDto.getId() );
            school.setName( schoolDto.getName() );
            school.setAddress( schoolDto.getAddress() );
            school.setDirectorName( schoolDto.getDirectorName() );
            school.setStudents( studentDtoListToStudentSet( schoolDto.getStudents() ) );
        }

        return school;
    }
}
