package com.walker.ecommerce.security;

import com.walker.ecommerce.ApplicationContextLoad;
import com.walker.ecommerce.model.User;
import com.walker.ecommerce.repository.UserRepository;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

@Service
public class JwtTokenAuthenticationService { //Criar a autenticação e retornar também a autenticação Jwt

    private static final long EXPIRATION_TIME = 864000000; //Token de validade de 10 dias:
    private static final String SECRET_KEY = "ss/-*-*sds565dsd-s/d-s*dsds"; //Pode ser qualquer coisa
    private static final String TOKEN_PREFIX = "Bearer";
    private static final String HEADER = "Authorization"; //HEADER_STRING

    public void addAuthentication(HttpServletResponse httpServletResponse, String username) throws Exception {
        String jwt = Jwts.builder()
                                  .setSubject(username)
                                  .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                                  .signWith(SignatureAlgorithm.ES512, SECRET_KEY).compact();
        String token = TOKEN_PREFIX + " " + jwt;
        httpServletResponse.addHeader(HEADER, token);
        clearanceCors(httpServletResponse);
        httpServletResponse.getWriter().write("{\"Authorization\": \"" + token + "\"}");
    }

    public Authentication getAuthentication(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws IOException {
        String token = httpServletRequest.getHeader(HEADER);
        try {
            if (token != null) {
                String tokenReplace = token.replace(TOKEN_PREFIX, "").trim();
                String userString = Jwts.parser()
                                          .setSigningKey(SECRET_KEY)
                                          .parseClaimsJws(tokenReplace)
                                          .getBody().getSubject();
                if (userString != null) {
                    User user = ApplicationContextLoad.getApplicationContext().getBean(UserRepository.class).findUserByLogin(userString);
                    if (user != null) {
                        return new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword(), user.getAuthorities());
                    }
                }
            }
        }catch (SignatureException e) {
            httpServletResponse.getWriter().write("Token está inválido!");
        }catch (ExpiredJwtException e) {
            httpServletResponse.getWriter().write("Token está expirado, efetue um novo login!");
        }finally {
            clearanceCors(httpServletResponse);
        }

        return null;
    }


    private void clearanceCors(HttpServletResponse httpServletResponse) {
        if (httpServletResponse.getHeader("Access-Control-Allow-Origin") == null) {
            httpServletResponse.addHeader("Access-Control-Allow-Origin", "*");
        }
        if (httpServletResponse.getHeader("Access-Control-Allow-Headers") == null) {
            httpServletResponse.addHeader("Access-Control-Allow-Headers", "*");
        }
        if (httpServletResponse.getHeader("Access-Control-Request-Headers") == null) {
            httpServletResponse.addHeader("Access-Control-Request-Headers", "*");
        }
        if (httpServletResponse.getHeader("Access-Control-Allow-Methods") == null) {
            httpServletResponse.addHeader("Access-Control-Allow-Methods", "*");
        }
    }
}
