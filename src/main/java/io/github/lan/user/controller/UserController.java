package io.github.lan.user.controller;

import io.github.lan.user.entity.User;
import io.github.lan.user.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {

  private final UserRepository userRepository;

  @PostMapping
  public String addUser(@RequestParam String name, @RequestParam String email) {
    User user = User.builder()
        .name(name)
        .email(email)
        .build();
    userRepository.save(user);
    return "User added successfully";
  }

  @GetMapping
  public List<User> getUsers() {
    return (List<User>) userRepository.findAll();
  }
}
