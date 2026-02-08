package com.sarper.Service;

import com.sarper.Dto.LoginRequest;
import com.sarper.Dto.RegisterRequest;
import com.sarper.Dto.UserDto;
import com.sarper.Model.User;
import com.sarper.Repository.UserRepository;
import com.sarper.Service.interfaces.IAuthService;
import com.sarper.jwt.JwtUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthService implements IAuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private AuthenticationProvider authenticationProvider;
    @Override
    public UserDto register(RegisterRequest registerRequest) {
        User user = new User();
        UserDto userDto = new UserDto();
        user.setUsername(registerRequest.getUsername());
        user.setRole(registerRequest.getRole());
        user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(user);

        BeanUtils.copyProperties(user, userDto);
        return userDto;
    }

    @Override
    public String authenticate(LoginRequest loginRequest) {
        try {

            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword());

            authenticationProvider.authenticate(auth);
        } catch (Exception e) {
            System.out.println("Error authenticating user!");
            return null;
        }

        Optional<User> optionalUser = userRepository.findByUsername(loginRequest.getUsername());

        if (!optionalUser.isPresent()){
            System.out.println("Error loading user!");
            return null;
        }

        return jwtUtils.generateToken(optionalUser.get());
    }
}
