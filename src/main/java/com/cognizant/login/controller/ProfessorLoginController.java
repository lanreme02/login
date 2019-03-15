package com.cognizant.login.controller;

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
    public String login(@RequestBody Request request){

      return  professorService.validate(request.getUserName()) &&
              professorService.login(request.getUserName(),request.getPassWord())
              ? "SUCCESS" : "FAILURE";

    }

    @PostMapping("/login/add")
    public String add(@RequestBody Request request){

        if( !professorService.validate(request.getUserName()))
           return MessageConstant.FAILURE;

        professorService.add(request.getUserName(),request.getPassWord());

        return MessageConstant.SUCCESS;
    }
}
