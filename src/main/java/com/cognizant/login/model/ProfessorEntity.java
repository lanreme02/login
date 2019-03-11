package com.cognizant.login.model;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProfessorEntity {

    @Id
    private  String userName;
    private String passWord;

   public  ProfessorEntity(){}

    public  ProfessorEntity(String username, String passWord){
       this.userName = username.toLowerCase();
       this.passWord = passWord;
    }

    public void setUserName(String userName) {
        this.userName = userName.toLowerCase();
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }
}
