package com.sarper.Controller.interfaces;

import com.sarper.Dto.AuthRequest;
import com.sarper.Dto.UserDto;
import com.sarper.Model.User;

public interface IAuthController {

    UserDto register(AuthRequest authRequest);
}
