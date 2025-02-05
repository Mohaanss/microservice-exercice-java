package com.exo1.exo1.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-02-04T11:28:04+0100",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.13 (Amazon.com Inc.)"
)
@Component
public class TaskCountPerProjectMapperImpl implements TaskCountPerProjectMapper {

    @Override
    public TaskCountPerProjectDto toDto(TaskCountPerProject task) {
        if ( task == null ) {
            return null;
        }

        TaskCountPerProjectDto taskCountPerProjectDto = new TaskCountPerProjectDto();

        taskCountPerProjectDto.setProjetId( task.getProjetId() );
        taskCountPerProjectDto.setTaskCount( task.getTaskCount() );

        return taskCountPerProjectDto;
    }

    @Override
    public TaskCountPerProject toEntity(TaskCountPerProjectDto taskDto) {
        if ( taskDto == null ) {
            return null;
        }

        TaskCountPerProject taskCountPerProject = new TaskCountPerProject();

        taskCountPerProject.setProjetId( taskDto.getProjetId() );
        taskCountPerProject.setTaskCount( taskDto.getTaskCount() );

        return taskCountPerProject;
    }

    @Override
    public List<TaskCountPerProjectDto> toDtos(List<TaskCountPerProject> tasks) {
        if ( tasks == null ) {
            return null;
        }

        List<TaskCountPerProjectDto> list = new ArrayList<TaskCountPerProjectDto>( tasks.size() );
        for ( TaskCountPerProject taskCountPerProject : tasks ) {
            list.add( toDto( taskCountPerProject ) );
        }

        return list;
    }

    @Override
    public List<TaskCountPerProject> toEntities(List<TaskCountPerProjectDto> taskDtos) {
        if ( taskDtos == null ) {
            return null;
        }

        List<TaskCountPerProject> list = new ArrayList<TaskCountPerProject>( taskDtos.size() );
        for ( TaskCountPerProjectDto taskCountPerProjectDto : taskDtos ) {
            list.add( toEntity( taskCountPerProjectDto ) );
        }

        return list;
    }
}
