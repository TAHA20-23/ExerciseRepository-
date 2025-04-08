package com.example.exerciserepository.Repository;

import com.example.exerciserepository.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    User findUserById(Integer id);

    User findByEmail(String email);

    @Query("select r from User r where r.role=?1")
    List<User> findUserByRole(String role);

    List<User> findByAge(Integer age);

    @Query("select up from User up where up.username=?1 and up.password=?2")
    User findUserByUsernameAndPassword(String userName, String password);
}
