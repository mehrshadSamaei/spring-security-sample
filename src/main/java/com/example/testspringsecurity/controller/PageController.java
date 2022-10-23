package com.example.testspringsecurity.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PageController {
    @GetMapping("/")
    public ModelAndView getHome() {
        ModelAndView modelAndView = new ModelAndView("home");

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(50000);
                    System.out.println(SecurityContextHolder.getContext().getAuthentication().getName());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        modelAndView.addObject("currentUsername", currentUsername);
        return modelAndView;
    }
}
