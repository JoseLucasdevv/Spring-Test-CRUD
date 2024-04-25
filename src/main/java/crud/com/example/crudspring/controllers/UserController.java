package crud.com.example.crudspring.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import crud.com.example.crudspring.entity.UserEntity;
import crud.com.example.crudspring.services.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;



@RestController
@RequestMapping("api/user")
public class UserController {

    private UserService _userService;

UserController(UserService _userService){
}


    @GetMapping()
    public List<UserEntity> getUser(){
        return this._userService.list();
    }

    @PostMapping()
    public List<UserEntity> createUser(@RequestBody UserEntity entity) {
        return this._userService.createUser(entity);
    }

    @PutMapping()
    public List<UserEntity> updateUser(@RequestBody UserEntity entity) {
        
        return this._userService.updateUser(entity);
    }

    @DeleteMapping("{id}")
    public List<UserEntity> deleteUser(@PathVariable("id") Long id){
        return this._userService.deleteUser(id);
    }

    @GetMapping("{id}")
    public UserEntity findUserById(@PathVariable("id") Long id) {
        return this._userService.findByIdUser(id);
    }
    

}
