package com.timecoder.repository;

import com.timecoder.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppUserRepository extends JpaRepository<AppUser, Long> {

    AppUser findOneByEmail(String email);

}
