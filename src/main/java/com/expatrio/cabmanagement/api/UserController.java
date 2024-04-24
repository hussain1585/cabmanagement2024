package com.expatrio.cabmanagement.api;

import com.expatrio.cabmanagement.dto.customer.AddUserInfoRequest;
import com.expatrio.cabmanagement.dto.customer.AddUserInfoResponse;
import com.expatrio.cabmanagement.dto.customer.UserInfoDTO;
import com.expatrio.cabmanagement.mappers.UserInfoDtoToEntity;
import com.expatrio.cabmanagement.usecases.JwtService;
import com.expatrio.cabmanagement.ports.jpa.entity.customer.UserInfoEntity;
import com.expatrio.cabmanagement.usecases.UserInfoService;
import com.expatrio.cabmanagement.dto.auth.AuthRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class UserController {

    private final UserInfoService service;

    private final JwtService jwtService;

    private final AuthenticationManager authenticationManager;

    private final UserInfoDtoToEntity userMapper;

    @GetMapping("/welcome")
    public String welcome() {
        return "Welcome this endpoint is not secure";
    }

    @PostMapping("/addNewUser")
    public AddUserInfoResponse addNewUser(@RequestBody AddUserInfoRequest addUserInfoRequest) {
        UserInfoEntity userInfoEntity = service.addUser(addUserInfoRequest.getUserInfo());
        UserInfoDTO userInfoDTO = userMapper.entityToDto(userInfoEntity);
        return AddUserInfoResponse.builder().userInfo(userInfoDTO).build();
    }

    @GetMapping("/user/userProfile")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    public String userProfile() {
        return "Welcome to User Profile";
    }

    @GetMapping("/admin/adminProfile")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public String adminProfile() {
        return "Welcome to Admin Profile";
    }

    @PostMapping("/generateToken")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest) {
        UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(authRequest.getUsername(), authRequest.getPassword());
        Authentication authentication = authenticationManager.authenticate(authToken);
//        String s = Optional.of(authentication)
//                .filter(Authentication::isAuthenticated)
//                .map(auth -> jwtService.generateToken(authRequest.getUsername()))
//                .orElseThrow(() -> new UsernameNotFoundException("invalid user request !"));
        if (authentication.isAuthenticated()) {
            return jwtService.generateToken(authRequest.getUsername());
        } else {
            throw new UsernameNotFoundException("invalid user request !");
        }
    }

}

