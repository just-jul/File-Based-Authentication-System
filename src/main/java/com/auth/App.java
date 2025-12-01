package com.auth;

public class App 
{
    public static void main( String[] args )
    {
       UserDatabase db = new UserDatabase();

       UI ui = new UI(db);

       ui.start();

    }
}
