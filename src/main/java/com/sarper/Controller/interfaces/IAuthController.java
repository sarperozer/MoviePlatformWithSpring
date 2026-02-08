package com.sarper.Controller.interfaces;

import com.sarper.Dto.LoginRequest;
import com.sarper.Dto.RegisterRequest;
import com.sarper.Dto.UserDto;

public interface IAuthController {

    UserDto register(RegisterRequest registerRequest);

    String authenticate(LoginRequest loginRequest);
}
