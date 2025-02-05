package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.SchoolDto;
import com.exo1.exo1.entity.School;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-04T14:51:48+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class SchoolMapperImpl implements SchoolMapper {

    @Override
    public SchoolDto toDto(School school) {

        SchoolDto schoolDto = new SchoolDto();

        if ( school != null ) {
            schoolDto.setId( school.getId() );
            schoolDto.setName( school.getName() );
            schoolDto.setAddress( school.getAddress() );
            schoolDto.setDirectorName( school.getDirectorName() );
            schoolDto.setStudent_id( school.getStudent_id() );
        }

        return schoolDto;
    }

    @Override
    public School toEntity(SchoolDto schoolDto) {

        School school = new School();

        if ( schoolDto != null ) {
            school.setId( schoolDto.getId() );
            school.setName( schoolDto.getName() );
            school.setAddress( schoolDto.getAddress() );
            school.setDirectorName( schoolDto.getDirectorName() );
            school.setStudent_id( schoolDto.getStudent_id() );
        }

        return school;
    }

    @Override
    public List<SchoolDto> toDtos(List<School> schools) {
        if ( schools == null ) {
            return new ArrayList<SchoolDto>();
        }

        List<SchoolDto> list = new ArrayList<SchoolDto>( schools.size() );
        for ( School school : schools ) {
            list.add( toDto( school ) );
        }

        return list;
    }

    @Override
    public List<School> toEntities(List<SchoolDto> schoolDtos) {
        if ( schoolDtos == null ) {
            return new ArrayList<School>();
        }

        List<School> list = new ArrayList<School>( schoolDtos.size() );
        for ( SchoolDto schoolDto : schoolDtos ) {
            list.add( toEntity( schoolDto ) );
        }

        return list;
    }
}
