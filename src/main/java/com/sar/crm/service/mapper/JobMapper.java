package com.sar.crm.service.mapper;


import com.sar.crm.domain.*;
import com.sar.crm.service.dto.JobDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link Job} and its DTO {@link JobDTO}.
 */
@Mapper(componentModel = "spring", uses = {PerformanceMapper.class, PersonMapper.class})
public interface JobMapper extends EntityMapper<JobDTO, Job> {

    @Mapping(source = "performance.id", target = "performanceId")
    @Mapping(source = "creator.id", target = "creatorId")
    JobDTO toDto(Job job);

    @Mapping(source = "performanceId", target = "performance")
    @Mapping(target = "jobHistories", ignore = true)
    @Mapping(target = "removeJobHistory", ignore = true)
    @Mapping(source = "creatorId", target = "creator")
    Job toEntity(JobDTO jobDTO);

    default Job fromId(Long id) {
        if (id == null) {
            return null;
        }
        Job job = new Job();
        job.setId(id);
        return job;
    }
}
