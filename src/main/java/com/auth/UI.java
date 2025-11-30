package com.auth;

import java.util.Scanner;

public class UI {
    private Scanner scanner;
    private UserDatabase db;

    public UI(UserDatabase db){
        this.scanner = new Scanner(System.in);
        this.db = db;
    }
    
    public void start(){
    
        
        while (true) {

            System.out.println();
            System.out.println("-----*-----");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Change username");
            System.out.println("4. Change password");
            System.out.println("5. Exit");

            int choice = Integer.valueOf(scanner.nextLine());

            if(choice == 5){
                break;
            }
        
            switch (choice) {
                case 1:{
                    System.out.print("Username: ");
                    String username = scanner.nextLine();

                    while (true) {
                        System.out.print("Password: ");
                        String password = scanner.nextLine();

                        System.out.print("Repeat password: ");
                        String repeatedPswd = scanner.nextLine();

                        if(!repeatedPswd.equals(password)){
                        System.out.println("Passwords don't match. Try again.");
                        }else{
                            String hashed = PasswordUtil.hash(password);
                            User user = new User(username, hashed);
                            break;
                        }
                    }
                    break;
                }                
                case 2: {
                    System.out.println("Username: ");
                    String username = scanner.nextLine();

                    // if username exists, proceed
                    // findUser() 



                    System.out.println("Password: ");
                    String password = scanner.nextLine();

                    String hashed = PasswordUtil.hash(password);
                    // check if the hashed password (entered) matches the one in the database
                    // if yes -> display "Logged in!"
                    // if not, ask again - max 3 tries 

                    
                    break;
                }
                default:
                    break;
            }
        }
        
    }
}

