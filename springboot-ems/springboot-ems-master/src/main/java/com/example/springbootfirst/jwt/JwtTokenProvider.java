package com.example.springbootfirst.jwt;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.jar.JarException;

@Component
public class JwtTokenProvider {
    @Value("${app.jet-secret}")
    private String jwtSecret;

    @Value("${app.jwt-expiration-milliseconds}")
    private long jwtExpirationDate;

    private Key secretKey(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public String generateToken(org.springframework.security.core.Authentication autenticate){
        UserDetails userPrincipal = (UserDetails) autenticate
                .getPrincipal();

        return Jwts.builder()
                .setSubject(userPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()+jwtExpirationDate))
                .signWith(secretKey(), SignatureAlgorithm.HS256)
                .compact();
    }
    public String getUserNameFromToken(String tocken){
        return Jwts.parserBuilder()
                .setSigningKey(secretKey())
                .build()
                .parseClaimsJws(tocken)
                .getBody()
                .getSubject();
    }
    public boolean validationToken(String token){
        try{
            Jwts.parserBuilder()
                    .setSigningKey(secretKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        }catch (JarException | IllegalArgumentException e){

            e.printStackTrace();
        }
        return false;
    }
}
