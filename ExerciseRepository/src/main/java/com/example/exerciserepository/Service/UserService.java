package com.example.exerciserepository.Service;

import com.example.exerciserepository.Model.User;
import com.example.exerciserepository.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<User> getAllUser(){
        return userRepository.findAll();

    }

    public void addUser(User user){

        userRepository.save(user);
    }

    public Boolean upDateUser(Integer id, User user){
        User oldUser = userRepository.findUserById(id);

        if (oldUser==null){
            return false;
        }
        oldUser.setName(user.getName());
        oldUser.setAge(user.getAge());
        oldUser.setRole(user.getRole());
        oldUser.setEmail(user.getEmail());
        oldUser.setPassword(user.getPassword());
        oldUser.setUsername(user.getUsername());

        userRepository.save(oldUser);
        return true;
    }

    public Boolean deleteUser(Integer id){
        User user = userRepository.findUserById(id);

        if(user!=null){
            userRepository.delete(user);
            return true;
        }
        return false;
    }
    public User findByEmail(String email){

        User email1 = userRepository.findByEmail(email);

        if(email1 != null){
            return email1;
        }

        return null;
    }

    public List<User> findUserByRole(String role){

        return userRepository.findUserByRole(role);
    }

    public List<User> findByAge(Integer age) {

       return userRepository.findByAge(age);


    }

    public Boolean findUserByUsernameAndPassword(String username, String password){

        User up = userRepository.findUserByUsernameAndPassword(username, password);
        if(up != null){
            return true;
        }
        return false;
    }

}
