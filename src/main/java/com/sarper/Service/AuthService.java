package com.sarper.Service;

import com.sarper.Dto.AuthRequest;
import com.sarper.Dto.UserDto;
import com.sarper.Model.User;
import com.sarper.Repository.UserRepository;
import com.sarper.Service.interfaces.IAuthService;
import org.apache.catalina.mbeans.MBeanUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDto register(AuthRequest authRequest) {
        User user = new User();
        UserDto userDto = new UserDto();
        user.setUsername(authRequest.getUsername());
        user.setPassword(passwordEncoder.encode(authRequest.getPassword()));
        userRepository.save(user);

        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }
}
