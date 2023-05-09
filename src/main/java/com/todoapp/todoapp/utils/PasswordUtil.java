package com.todoapp.todoapp.utils;

import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Objects;

@Component
public class PasswordUtil {

    public String encryptPassword(String password)  {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
            return Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
    }

    public boolean passwordChecker(String existingPassword, String inputPassword) {
        return Objects.equals(encryptPassword(existingPassword),encryptPassword(inputPassword));
    }
}
