package com.walker.ecommerce.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Service
public class JwtTokenAutenticationService { //Criar a autenticação e retornar também a autenticação Jwt

    private static final long EXPIRATION_TIME = 864000000; //Token de validade de 10 dias:
    private static final String SECRET_KEY = "ss/-*-*sds565dsd-s/d-s*dsds"; //Pode ser qualquer coisa
    private static final String TOKEN_PREFIX = "Bearer";
    private static final String HEADER = "Authorization";

    public void addAuthentication(HttpServletResponse httpServletResponse, String username) throws Exception {
        String jwt = Jwts.builder()
                                  .setSubject(username)
                                  .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                                  .signWith(SignatureAlgorithm.ES512, SECRET_KEY).compact();
        String token = TOKEN_PREFIX + " " + jwt;
        httpServletResponse.addHeader(HEADER, token);
        httpServletResponse.getWriter().write("{\"Authorization\": \"" + token + "\"}");
    }
}
