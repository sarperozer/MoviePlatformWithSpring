package com.sarper.Service.interfaces;

import com.sarper.Dto.AuthRequest;
import com.sarper.Dto.UserDto;
import com.sarper.Model.User;

public interface IAuthService {
    UserDto register(AuthRequest authRequest);
}
