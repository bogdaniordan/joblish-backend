package com.codecool.travelish.model.job;

import com.codecool.travelish.model.company.Company;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private LocalDate date;
    private String country;
    private String jobType;
    @Enumerated(EnumType.STRING)
    private ExperienceType experienceType;
    private String companyImage;
    private String category;
    private String description;
    private int salary;
    private String city;

    @ManyToOne
    private Company company;

    public Job(String name, LocalDate date, String country, String jobType, ExperienceType experienceType, String companyImage, String category, String description, int salary, String city) {
        this.name = name;
        this.date = date;
        this.country = country;
        this.jobType = jobType;
        this.experienceType = experienceType;
        this.companyImage = companyImage;
        this.category = category;
        this.description = description;
        this.salary = salary;
        this.city = city;
    }

}