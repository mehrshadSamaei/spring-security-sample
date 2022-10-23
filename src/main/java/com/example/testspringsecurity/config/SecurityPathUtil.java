package com.example.testspringsecurity.config;

public class SecurityPathUtil {
    private SecurityPathUtil() {
    }
    public static String[] getAdminPaths() {
        return new String[]{
                "/admin/**", "/customer/**"
        };
    }
        public static String[] getCustomerPaths(){
        return new String[]{
                "/customer/**"
        };
    }
}
