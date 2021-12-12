package com.example.reto1jeremy1.Controller;


import com.example.reto1jeremy1.Model.User;
import com.example.reto1jeremy1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping("api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/all")
    public List<User> getAll(){
        return userService.getAll();
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User save(@RequestBody User user) {
        return userService.save(user);
    }

    @GetMapping("/{email}")
    public boolean exitsEmail(@PathVariable("email") String email){
        return userService.exitsEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public User auenticarUsuario(@PathVariable("email")String email,@PathVariable("password") String password){
        return userService.autenticarUsuario(email, password);
    }

}
