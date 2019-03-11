package com.cognizant.login.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ProfessorEntiryRepository extends CrudRepository<ProfessorEntity,String> {
   ProfessorEntity findProfessorByUserName(String userName);
}
