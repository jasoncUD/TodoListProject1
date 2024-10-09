package backend_project1.backend_project1.classes;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.util.Date;

@Component
public class JwtUtil {

    private final SecretKey secretKey = Keys.hmacShaKeyFor("your_256_bit_secret_key_your_256_bit_secret_key".getBytes()); // Use a secure, 256-bit secret key
    private final long expirationMs = 86400000; // 24 hours

    // Generate JWT token
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs)) // Token expires after 24 hours
                .signWith(secretKey, SignatureAlgorithm.HS256) // Use SecretKey instead of raw string
                .compact();
    }

    // Extract username from the token
    public String getUsernameFromToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(secretKey) // Use SecretKey to verify the token
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Validate the token
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                .setSigningKey(secretKey) // Use SecretKey to verify the token
                .build()
                .parseClaimsJws(token);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            // Handle invalid token
            return false;
        }
    }
}


