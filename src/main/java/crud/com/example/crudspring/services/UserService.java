package crud.com.example.crudspring.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


import crud.com.example.crudspring.entity.UserEntity;
import crud.com.example.crudspring.repositories.UserRepository;


@Service
public class UserService {
    
private UserRepository _UserRepository;

 public UserService( UserRepository UserRepository){
    this._UserRepository = UserRepository;
 }

 
public List<UserEntity> list(){
Sort sort = Sort.by("name").descending().and(Sort.by("age").ascending());

return this._UserRepository.findAll(sort);

}

public List<UserEntity> createUser(UserEntity user){
    this._UserRepository.save(user);
    
    return list();
 }

 public List<UserEntity> deleteUser(Long id){
   this._UserRepository.deleteById(id);
   
   return list();
}



public UserEntity findByIdUser(Long id){
   UserEntity user;

   user = this._UserRepository.findById(id).get();

   return user;
}

public List<UserEntity> updateUser(UserEntity user){
   this._UserRepository.save(user);
   
   return list();
}
 
}
