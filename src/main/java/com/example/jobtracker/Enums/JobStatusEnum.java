package com.example.jobtracker.Enums;

import com.example.jobtracker.Entity.JobTrackerEntity;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.util.List;

@JsonDeserialize(using = JobStatusEnumDeserializer.class)
public enum JobStatusEnum {
    AVAILABLE,
    INTERVIEW,
    REVIEW,
    CLOSED;

    public static boolean isValid(String status) {
        try {
            JobStatusEnum.valueOf(status.toUpperCase());
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public static List<JobStatusEnum> getActiveStatuses(){
        return List.of(AVAILABLE, INTERVIEW, REVIEW);
    }
}
