package com.auth;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;


public class UserDatabase {
    private static final String JSONFILEPATH = "data/userDB.json";
    // changed JSONArray to ArrayList 
    private ArrayList<User> users;

    public UserDatabase(){
        this.users = new ArrayList<>();
        this.loadFile();
    }

    // add user
    public void addUser(User user){
        this.users.add(user);
        save();
    }

    // saving user into JSON file 
    // 
    public void save(){
        JSONArray jsonArray = new JSONArray();
        for(User u : users){
            JSONObject obj = new JSONObject();
            obj.put("username", u.getUsername());
            obj.put("hashedPassword", u.getHashedPswd());
            jsonArray.put(obj);
        }
        try(FileWriter file = new FileWriter(JSONFILEPATH)){
            file.write(jsonArray.toString());
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    // loads the content of JSON data into memory 
    public void loadFile(){
        try {
            String fileContent = new String(Files.readAllBytes(Paths.get(JSONFILEPATH)));

            JSONArray jsonArray = new JSONArray(fileContent);

            for(Object o : jsonArray){
                JSONObject person = (JSONObject) o;

                String username = (String) person.get("username");

                String hashedPassword = (String) person.get("hashedPassword");

                User user = new User(username, hashedPassword);

                users.add(user);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    // change return from JSONObject to User
    public User findUser(String username){
        for(Object user : this.users){
            User person = (User) user;

            if (person.getUsername().equals(username)){
                return person;
            }
        }
        return null;
    }
}

