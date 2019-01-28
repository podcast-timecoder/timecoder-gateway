package com.timecoder.service;

import com.timecoder.model.AppUser;
import com.timecoder.repository.AppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppUserService {

    private final AppUserRepository appUserRepository;

    public AppUser findUserByEmail(String email) {
        return new AppUser("demo@gmail.com", "12345", "ADMIN");
    }

}
