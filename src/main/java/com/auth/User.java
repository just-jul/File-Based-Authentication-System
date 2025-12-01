package com.auth;

import org.json.JSONObject;

public class User {
    private String username;
    private String hashedPassword;

    public User(String username, String password){
        this.username = username;
        this.hashedPassword = password;
    }
    public void login(){
        System.out.println("Logged in!");
    }
    public String getUsername(){
        return this.username; 
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getHashedPswd(){
        return hashedPassword;
    }
    public void setHashedPswd(String newPassword){
        this.hashedPassword = newPassword;
    }

    // turning User object into JSON object 
    public JSONObject toJSON(){
        JSONObject jo = new JSONObject();

        jo.put("username", this.username);
        jo.put("hashedPassword", this.hashedPassword);

        return jo;
    }

}

