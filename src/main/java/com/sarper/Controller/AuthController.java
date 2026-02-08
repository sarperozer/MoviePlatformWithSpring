package com.sarper.Controller;

import com.sarper.Controller.interfaces.IAuthController;
import com.sarper.Dto.LoginRequest;
import com.sarper.Dto.RegisterRequest;
import com.sarper.Dto.UserDto;
import com.sarper.Service.interfaces.IAuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/auth")
public class AuthController implements IAuthController {

    @Autowired
    private IAuthService authService;
    @Override
    @PostMapping("/register")
    public UserDto register(@Valid @RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }

    @Override
    @PostMapping("/authenticate")
    public String authenticate(@Valid @RequestBody LoginRequest loginRequest) {
        return authService.authenticate(loginRequest);
    }


}
