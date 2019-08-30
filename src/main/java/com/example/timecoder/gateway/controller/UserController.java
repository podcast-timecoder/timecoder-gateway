package com.example.timecoder.gateway.controller;

import com.example.timecoder.gateway.model.User;
import com.example.timecoder.gateway.payload.auth.UpdatePassword;
import com.example.timecoder.gateway.payload.auth.UserIdentityAvailability;
import com.example.timecoder.gateway.payload.auth.UserSummary;
import com.example.timecoder.gateway.repository.UserRepository;
import com.example.timecoder.gateway.security.CurrentUser;
import com.example.timecoder.gateway.security.UserPrincipal;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping("/user/me")
    @PreAuthorize("isAuthenticated()")
    public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
        List<String> roleList = currentUser.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(toList());
        UserSummary userSummary = new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
        userSummary.setPriviledged(roleList.contains("USER_ADMIN"));
        return userSummary;
    }

    @GetMapping("/user/checkUsernameAvailability")
    public UserIdentityAvailability checkUsernameAvailability(@RequestParam(value = "username") String username) {
        Boolean isAvailable = !userRepository.existsByUsername(username);
        return new UserIdentityAvailability(isAvailable);
    }

    @GetMapping("/user/checkEmailAvailability")
    public UserIdentityAvailability checkEmailAvailability(@RequestParam(value = "email") String email) {
        Boolean isAvailable = !userRepository.existsByEmail(email);
        return new UserIdentityAvailability(isAvailable);
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header")})
    @GetMapping("/users/list")
    @PreAuthorize("isAuthenticated()")
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    @ApiImplicitParams({
            @ApiImplicitParam(name = "Authorization", value = "Authorization token",
                    required = true, dataType = "string", paramType = "header")})
    @PreAuthorize("isAuthenticated()")
    @PostMapping("user/{id}/changePassword")
    public ResponseEntity changePassword(@PathVariable Long id, @Valid @RequestBody UpdatePassword updatePassword){
        User user = userRepository.getOne(id);
        user.setPassword(passwordEncoder.encode(updatePassword.getPassword()));
        userRepository.save(user);

        return ResponseEntity.ok("changed: true");
    }
}
