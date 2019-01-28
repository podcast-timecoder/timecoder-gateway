package com.timecoder.web;

import com.timecoder.model.AppUser;
import com.timecoder.model.Credentials;
import com.timecoder.repository.AppUserRepository;
import com.timecoder.service.AppUserService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AppUserService appUserService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello() {
        return "Hello from Auth service!";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<Map<String, Object>> login(@RequestBody Credentials credentials) {
        String token = null;

        AppUser appUser = appUserService.findUserByEmail(credentials.getEmail());

        Map<String, Object> tokenMap = new HashMap<>();
        if (appUser != null && appUser.getPassword().equals(credentials.getPassword())) {
            token = Jwts.builder().setSubject(credentials.getEmail()).claim("roles", appUser.getRole()).setIssuedAt(new Date())
                    .signWith(SignatureAlgorithm.HS256, "secretkey").compact();
            tokenMap.put("token", token);
            tokenMap.put("user", appUser);
            return new ResponseEntity<>(tokenMap, HttpStatus.OK);
        } else {
            tokenMap.put("token", null);
            return new ResponseEntity<>(tokenMap, HttpStatus.UNAUTHORIZED);
        }
    }
}
