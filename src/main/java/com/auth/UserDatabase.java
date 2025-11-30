package com.auth;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;


public class UserDatabase {
    private static final String JSONFILEPATH = "data/userDB.json";
    private JSONArray users;

    public UserDatabase(){
        this.users = new JSONArray();
        this.loadFile();
    }

    // add user
    public void addUser(User user){
        this.users.put(user.toJSON());
        save();
    }

    // saving user into JSON file 
    // works!
    public void save(){
        try(FileWriter file = new FileWriter(JSONFILEPATH)){
            file.write(users.toString());
            System.out.println("Successfully Copied JSON Object to File...");
            System.out.println("\nJSON Object: " + users);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void loadFile(){
        try {
            String fileContent = new String(Files.readAllBytes(Paths.get(JSONFILEPATH)));

            this.users = new JSONArray(fileContent);;

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public JSONObject findUser(String username){
        for(Object user : this.users){
            JSONObject person = (JSONObject) user;

            if (person.get("username").equals(username)){
                return person;
            }
        }
        return null;


    }
}

