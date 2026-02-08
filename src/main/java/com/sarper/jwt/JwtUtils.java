package com.sarper.jwt;

import com.sarper.Model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.time.DateTimeException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.function.Function;

@Component
public class JwtUtils {


    @Value("${SECRET_KEY}")
    private String SECRET_KEY;

    @PostConstruct
    public void init() {
        System.out.println("SECRET_KEY loaded: " + SECRET_KEY);
    }

    public String generateToken(User user){

        HashMap<String, Object> claims = new HashMap<>();
        claims.put("role", user.getRole());

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(getSigningKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public Key getSigningKey(){
        byte[] decodedKey = Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(decodedKey);
    }

    public String getUsernameFromToken(String token){
        return extractAllClaims(token).getSubject();
    }

    public boolean isTokenExpired(String token){
        return getExpirationDateFromToken(token).before(new Date());
    }

    public Date getExpirationDateFromToken(String token){
        return extractAllClaims(token).getExpiration();
    }

    public String getRole(String token){
        return extractAllClaims(token).get("role", String.class);
    }

    private Claims extractAllClaims(String token){
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token).getBody();
    }
}
