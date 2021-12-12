package com.example.reto1jeremy1.Repository;


import com.example.reto1jeremy1.Model.User;
import com.example.reto1jeremy1.Repository.Crud.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private UserCrudRepository userCrudRepository;

    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }

    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }

    public User save(User user) {
        return userCrudRepository.save(user);
    }

    public boolean ExitsEmail(String email){
        Optional<User> usuario = userCrudRepository.findByEmail(email);

        return !usuario.isEmpty();
        }

    public Optional<User>  autenticarUsuario(String email, String password){
        return userCrudRepository.findByEmailAndPassword(email, password);
    }

}
