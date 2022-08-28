package com.goit.productstore.models.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User create(User user){
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        return userRepository.save(user);
    }
    public User getById(UUID uuid){
        return userRepository.findById(uuid).get();
    }

    public List<User> getAll(){
        return userRepository.findAll();
    }

    public void deleteById(UUID uuid){
        userRepository.deleteById(uuid);
    }

}
