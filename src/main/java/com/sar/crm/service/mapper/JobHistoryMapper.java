package com.sar.crm.service.mapper;


import com.sar.crm.domain.*;
import com.sar.crm.service.dto.JobHistoryDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity {@link JobHistory} and its DTO {@link JobHistoryDTO}.
 */
@Mapper(componentModel = "spring", uses = {PersonMapper.class, JobMapper.class})
public interface JobHistoryMapper extends EntityMapper<JobHistoryDTO, JobHistory> {

    @Mapping(source = "performer.id", target = "performerId")
    @Mapping(source = "job.id", target = "jobId")
    JobHistoryDTO toDto(JobHistory jobHistory);

    @Mapping(source = "performerId", target = "performer")
    @Mapping(source = "jobId", target = "job")
    JobHistory toEntity(JobHistoryDTO jobHistoryDTO);

    default JobHistory fromId(Long id) {
        if (id == null) {
            return null;
        }
        JobHistory jobHistory = new JobHistory();
        jobHistory.setId(id);
        return jobHistory;
    }
}
