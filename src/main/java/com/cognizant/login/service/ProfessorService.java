package com.cognizant.login.service;

import com.cognizant.login.model.ProfessorEntiryRepository;
import com.cognizant.login.model.ProfessorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProfessorService {

    @Autowired
    ProfessorEntiryRepository repository;

    public boolean login(String userName, String password){
      ProfessorEntity entity =  repository.findProfessorByUserName(userName.trim().toLowerCase());
     return  entity != null &&
             entity.getPassWord().equals(password);

    }

    public void add(String userName, String password){
         repository.save(new ProfessorEntity(userName,password));

    }

    public boolean validate(String data ){

        return !(data.contains(".") || data.contains("-") || data.contains("_") || data.contains("#"));
    }
}
