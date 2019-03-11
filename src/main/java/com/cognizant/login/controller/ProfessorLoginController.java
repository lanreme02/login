package com.cognizant.login.controller;

import com.cognizant.login.model.LoginRequest;
import com.cognizant.login.service.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfessorLoginController {

    @Autowired
    ProfessorService professorService;

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request){

      return  professorService.validate(request.getUserName()) &&
              professorService.login(request.getUserName(),request.getPassWord())
              ? "SUCCESS" : "FAILURE";

    }
}
