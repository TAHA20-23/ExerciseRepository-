package com.example.exerciserepository.Model;


import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull(message = "Name can't be null ")
    @Length(min = 5, message = "Length must be mor than 4 ")
    private String name;

    @NotNull(message = "User Name can't be null ")
    @Length(min = 5, message = "Length must be mor than 4 ")
    @Column(unique = true)
    private String username;

    @NotNull(message = "password can't be null")
    private String password;

    @NotNull(message = "Email can't be null")
    @Email(message = "Must be valid email")
    @Column(unique = true)
    private String email;

    @NotNull(message = "role can't be null")
    @Pattern(regexp = "user|admin", message = "Role must be User or admin Only!!")
    private String role;

    @NotNull(message = "age can't be null")
    @Positive(message = "Age must be a positive integer")
    private Integer age;
}
