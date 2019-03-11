package com.cognizant.login;

import com.cognizant.login.model.ProfessorEntiryRepository;
import com.cognizant.login.model.ProfessorEntity;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ControllerTest {

    @Autowired
    ProfessorEntiryRepository repository;

    @Autowired
    MockMvc mvc;

    @Before
    public void before(){
        repository.deleteAll();
    }

    @After
    public void after(){
        repository.deleteAll();
    }

    @Test
    public void modelReturnsSUCCESSWhenCredentialIsValid() throws Exception{

        repository.save(new ProfessorEntity("lanre","jumoke"));

        String content = mvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\" :  \"lanre\", \"password\" : \"jumoke\"}"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertThat(content, is("SUCCESS"));
    }

    @Test
    public void modelReturnsFailureWhenCredentialIsInValid() throws Exception{

        repository.save(new ProfessorEntity("lanre","jumoke"));

        String content = mvc.perform(post("/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\" :  \"lanre\", \"password\" : \"UNKNOWN\"}"))
                .andExpect(status().isOk())
                .andReturn()
                .getResponse()
                .getContentAsString();

        assertThat(content, is("FAILURE"));
    }
}
