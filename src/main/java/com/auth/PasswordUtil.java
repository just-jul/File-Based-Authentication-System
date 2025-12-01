package com.auth;

import java.security.MessageDigest;

// SHA-256 password hashing
public class PasswordUtil {
    public static String hash(String password){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] encodedhash = digest.digest(password.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : encodedhash) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
}

