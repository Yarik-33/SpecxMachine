package by.kuchinskiy.speczmachine.controller;

import by.kuchinskiy.speczmachine.entity.Role;
import by.kuchinskiy.speczmachine.entity.User;
import by.kuchinskiy.speczmachine.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping("/userSave")
    public String addUser(@RequestParam(name = "login") String login,
                          @RequestParam(name = "password") String password) {
        Role role = new Role();
        role.setName("USER");
        User user = new User();
        user.setLogin(login);
        user.setPassword(password);
        user.setRole(role);
        userService.save(user);
        return "index";
    }
}