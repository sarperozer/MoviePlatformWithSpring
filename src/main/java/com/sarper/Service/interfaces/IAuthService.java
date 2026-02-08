package com.sarper.Service.interfaces;

import com.sarper.Dto.LoginRequest;
import com.sarper.Dto.RegisterRequest;
import com.sarper.Dto.UserDto;

public interface IAuthService {
    UserDto register(RegisterRequest registerRequest);

    String authenticate(LoginRequest loginRequest);
}
