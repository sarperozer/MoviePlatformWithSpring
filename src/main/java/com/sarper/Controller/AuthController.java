package com.sarper.Controller;

import com.sarper.Controller.interfaces.IAuthController;
import com.sarper.Dto.AuthRequest;
import com.sarper.Dto.UserDto;
import com.sarper.Model.User;
import com.sarper.Service.AuthService;
import com.sarper.Service.UserService;
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
    public UserDto register(@Valid @RequestBody AuthRequest authRequest) {
        return authService.register(authRequest);
    }


}
