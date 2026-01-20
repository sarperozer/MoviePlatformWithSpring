package com.sarper.Service;

import com.sarper.Model.User;
import com.sarper.Repository.ReviewRepository;
import com.sarper.Repository.UserRepository;
import com.sarper.Service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }
}
