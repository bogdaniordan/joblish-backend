package com.codecool.travelish.controller;

import com.codecool.travelish.model.company.Company;
import com.codecool.travelish.model.user.AppUser;
import com.codecool.travelish.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @CrossOrigin()
    @GetMapping("/all")
    public ResponseEntity<List<Company>> getAll() {
        return ResponseEntity.ok(companyService.findAll());
    }

//    @CrossOrigin()
//    @GetMapping("/userby")
//    public ResponseEntity<List<AppUser>> usersBy() {
//        System.out.println(companyService.findAllUsersByCompany(1L));
//        return ResponseEntity.ok(companyService.findAllUsersByCompany(1L));
//    }


}
