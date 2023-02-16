	package com.stackroute.authenticationservice.util;

import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.function.Function;


@Service
public class JwtUtil {

    private String SECRET_KEY = "secret";

    //takes in the token and extracts username from that token 
    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    //takes in token and extracts Expiration from that token
    public Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    //takes in the token and uses claimsResolver to figure out what the claims are
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }
    
    private Claims extractAllClaims(String token) {
        return Jwts.parser()
        		.setSigningKey(SECRET_KEY)
        		.parseClaimsJws(token)
        		.getBody();
    }

    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public String generateToken(UserDetails userDetails) { //userDetails object will be given by userDetailsService
        return Jwts.builder()
        		.setSubject(userDetails.getUsername())
        		.claim("role",userDetails.getAuthorities())
        		.setIssuedAt(new Date(System.currentTimeMillis())) //setExpiration -> sets Expirydate
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) //10hrs
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact(); //sign with HS256 algorithm and SECRET_KEY is secret (which can be set to anything)
    }

    //takes in token and userDetails obj , extractsUsername from token and  compares it with username from userDetail obj and also checks if token is expired and return true
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
    
    
    
}