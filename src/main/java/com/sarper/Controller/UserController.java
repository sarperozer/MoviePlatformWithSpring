package com.sarper.Controller;

import com.sarper.Controller.interfaces.IUserController;
import com.sarper.Model.User;
import com.sarper.Service.interfaces.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/users")
public class UserController implements IUserController {
    @Autowired
    private IUserService userService;

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    @Override
    public User addUser(@RequestBody User user) {
        return userService.addUser(user);
    }
}
