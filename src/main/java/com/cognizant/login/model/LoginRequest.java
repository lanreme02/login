package com.cognizant.login.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginRequest {

    private String userName;
    private String passWord;

    @JsonCreator
    public LoginRequest(@JsonProperty("username") final String userName, @JsonProperty("password") final String passWord) {
        this.userName= userName;
        this.passWord = passWord;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}
