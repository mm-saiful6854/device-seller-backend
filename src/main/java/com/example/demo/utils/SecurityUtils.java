package com.example.demo.utils;

import antlr.StringUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import javax.servlet.http.HttpServletRequest;

public class SecurityUtils {
    public static final String ROLE_PREFIX = "ROLE_";

    public static final String AUTH_HEADER = "authorization";
    public static final String AUTH_TOKEN_TYPE ="Bearer";
    public static final String AUTH_TOKEN_PREFIX = AUTH_TOKEN_TYPE + " ";

    public static SimpleGrantedAuthority convertToAuthority(String role)
    {
        String formattedRole =  role.startsWith(ROLE_PREFIX)? role : ROLE_PREFIX+role;

        return new SimpleGrantedAuthority(formattedRole);
    }


    public static String extractAuthTokenFromRequest(HttpServletRequest request)
    {
        String bearerToken = request.getHeader(AUTH_HEADER);

        if(bearerToken!=null && bearerToken.startsWith(AUTH_TOKEN_PREFIX))
        {
            return bearerToken.substring(AUTH_TOKEN_PREFIX.length()-1);
        }
        return null;
    }
}
