package com.auth;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;


public class UserDatabase {
    private static final String JSONFILEPATH = "data/userDB.json";
    private JSONArray users;

    public UserDatabase(){
        this.users = new JSONArray();
    }

    // add user
    public void addUser(User user){
        this.users.put(user.toJSON());
        save();
    }

    // saving user into JSON file
    public void save(){
        try(FileWriter file = new FileWriter(JSONFILEPATH)){
            file.write(users.toString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + users);
        }catch(Exception e){
            System.out.println(e);
        }
    }

    public void readFile(){

    }
}

