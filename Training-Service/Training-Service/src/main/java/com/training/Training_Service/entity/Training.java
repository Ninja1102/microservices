package com.training.Training_Service.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Training {

        @Id
        @Column(length = 5)
        private int trainingId;  // 5-digit ID

        private String name;

        @ElementCollection
        private List<String> skills;  // List of skills

        @Enumerated(EnumType.STRING)
        private DurationType duration;  // Enum: hours/day/months

        private LocalDate startDate;

        private LocalDate endDate;

        @Enumerated(EnumType.STRING)
        private StudentType studentType;  // Enum: lateral/fresher

        private Long numberOfBatch;

        private Long numberOfStudentsPerBatch;

        private double budget;

        private String tableOfContent;  // URL as string

        private String organisationName;

        private String poc;

        @Email
        private String email;

        @Pattern(regexp = "^\\+?[0-9]{10,15}$", message = "Invalid mobile number")
        private String mobileNumber;

        @Enumerated(EnumType.STRING)
        private TrainingStatus status;  // Auto-updated status

        @PrePersist
        @PreUpdate
        public void updateStatus() {
                LocalDate today = LocalDate.now();
                if (today.isBefore(startDate)) {
                        status = TrainingStatus.UPCOMING;
                } else if ((today.isEqual(startDate) || today.isAfter(startDate)) && today.isBefore(endDate)) {
                        status = TrainingStatus.IN_PROGRESS;
                } else if (today.isEqual(endDate) || today.isAfter(endDate)) {
                        status = TrainingStatus.COMPLETED;
                }
        }

        // Enums inside the same file
        public enum DurationType {
                HOURS, DAY, MONTHS
        }

        public enum StudentType {
                LATERAL, FRESHER
        }

        public enum TrainingStatus {
                ONHOLD, IN_PROGRESS, COMPLETED, UPCOMING
        }
}
