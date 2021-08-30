package com.codecool.travelish.controller;

import com.codecool.travelish.model.job.Job;
import com.codecool.travelish.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@CrossOrigin("*")
@RequestMapping("/jobs")
public class JobController {
    private final JobService jobService;

    @Autowired
    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Job>> getAllJobs(){
        return ResponseEntity.ok(jobService.findAllJobs());
    }

    @GetMapping("/search")
    public ResponseEntity<List<Job>> searchJobs(@RequestParam(required=false, name="category") String category, @RequestParam(required=false, name="name") String name){
        if (category != null && name != null) {
            return ResponseEntity.ok(jobService.findAllJobsByNameAndCategory(category, name));
        }
        if (name != null) {
            return ResponseEntity.ok(jobService.findAllJobsByName(name));
        }
        if (category != null) {
            return ResponseEntity.ok(jobService.findAllJobsByCategory(category));
        }
        return ResponseEntity.ok(jobService.findAllJobs());
    }
}
