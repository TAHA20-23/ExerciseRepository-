package com.example.exerciserepository.Controllar;


import com.example.exerciserepository.Model.ApiResponse;
import com.example.exerciserepository.Model.User;
import com.example.exerciserepository.Service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;

    @GetMapping("/get")
    public ResponseEntity getAllUsers(){
        return ResponseEntity.status(200).body(userService.getAllUser());
    }

    @PostMapping("add")
    public ResponseEntity addUser(@RequestBody @Valid User user, Errors errors){
        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());

        }
        userService.addUser(user);

            return ResponseEntity.status(200).body(new ApiResponse("User Added"));

        }

    @PutMapping("/update/{id}")
    public ResponseEntity updateUSer(@PathVariable Integer id, @RequestBody @Valid User user, Errors errors){

        if(errors.hasErrors()){
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());
        }
        Boolean isUpdate= userService.upDateUser(id, user);
        if(isUpdate!= null){
            return ResponseEntity.status(200).body(new ApiResponse("User updated"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("User Not found"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id){
        Boolean isDeleted= userService.deleteUser(id);

        if(isDeleted){
            return ResponseEntity.status(200).body(new ApiResponse("User Deleted"));
        }
        return ResponseEntity.status(400).body(new ApiResponse("User not found"));
    }

    @GetMapping("/get-email/{email}")
    public ResponseEntity findByEmail(@PathVariable String email){
        User isEmail= userService.findByEmail(email);

        if(isEmail!= null){
            return ResponseEntity.status(200).body(email);
        }
        return ResponseEntity.status(400).body(new ApiResponse("Email not found"));
    }


    @GetMapping("/get-Role/{role}")
    public ResponseEntity findUserByRole(@PathVariable String role){

        return ResponseEntity.status(200).body(userService.findUserByRole(role));

    }
    @GetMapping("/get-age/{age}")
    public ResponseEntity getByAge(@PathVariable Integer age){
        return ResponseEntity.status(200).body(userService.findByAge(age));
    }

    @GetMapping("get-username-password/{username}/{password}")
    public ResponseEntity findUserNameAndPassword(@PathVariable String username, @PathVariable String password){
        User isFind = userService.findUserByUsernameAndPassword(username, password);
        if (isFind != null){
//            return ResponseEntity.status(200).body(findUserNameAndPassword(username,password));
            return ResponseEntity.status(200).body(new ApiResponse("User name and user are found"));

        }
        return ResponseEntity.status(400).body(new ApiResponse("User name and password not found"));
    }

}

