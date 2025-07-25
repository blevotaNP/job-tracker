package com.example.jobtracker.Entity;

import com.example.jobtracker.Enums.JobStatusEnum;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@Builder
public class JobTrackerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 3, message = "Position must be at least 3 characters")
    private String position;

    private String company;

    //@NotBlank(message = "Status is required")
    @Enumerated(EnumType.STRING)
    private JobStatusEnum status;

    private String location;

    private LocalDate applicationDate;

    @NotBlank(message = "Job URL is required")
    private String jobURL;

}

