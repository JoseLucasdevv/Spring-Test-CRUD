package crud.com.example.crudspring.controllers;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

import crud.com.example.crudspring.DTO.UserDTO;

import crud.com.example.crudspring.services.UserService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("api/user")
public class UserController {

   
    final private UserService _userService;

    public UserController(UserService UserService){
        this._userService = UserService;
    }

    @GetMapping()   
    public List<UserDTO> getUser(){
        return this._userService.list();
    }

    @PostMapping()
    public List<UserDTO> createUser(@Valid @RequestBody UserDTO UserDTO) {
        return this._userService.createUser(UserDTO);
    }

    @PutMapping()
    public List<UserDTO> updateUser(@RequestBody UserDTO UserDTO) {
        
        return this._userService.updateUser(UserDTO);
    }

    @DeleteMapping("{id}")
    public List<UserDTO> deleteUser(@PathVariable("id") Long id){
        return this._userService.deleteUser(id);
    }

    @GetMapping("{id}")
    public UserDTO findUserById(@PathVariable("id") Long id) {
        return this._userService.findByIdUser(id);
    }
    
}
