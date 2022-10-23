package com.example.testspringsecurity.base64;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class Test {
    public static void main(String[] args) {
        System.out.println(
                new String(
                        Base64.getEncoder().encode(
                                "mmad:123".getBytes(StandardCharsets.UTF_8)
                        )
                )
        );
    }
}
