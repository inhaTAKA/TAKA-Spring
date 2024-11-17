package com.example.napoli.controller;

import jakarta.servlet.http.HttpSession;

public class ControllerUtils {
    public boolean verifyUserSession(HttpSession session) {
        return session.getAttribute("userId") == null;
    }
}
