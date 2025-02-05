package com.exo1.exo1.mapper;

import com.exo1.exo1.dto.SchoolDto;
import com.exo1.exo1.entity.School;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;

import java.util.List;

@Mapper(componentModel = "spring",
        nullValueMappingStrategy = NullValueMappingStrategy.RETURN_DEFAULT)
public interface SchoolMapper {
    SchoolDto toDto(School school);
    School toEntity(SchoolDto schoolDto);
    List<SchoolDto> toDtos(List<School> schools);
    List<School> toEntities(List<SchoolDto> schoolDtos);
}
