package crud.com.example.crudspring.mapper;

import org.springframework.stereotype.Component;

import crud.com.example.crudspring.DTO.UserDTO;
import crud.com.example.crudspring.entity.UserEntity;

@Component
public class UserMapper {

    public UserDTO entityToDto(UserEntity userEntity){
        if(userEntity == null){
            return null;
        };

        return new UserDTO(userEntity.getId(),userEntity.getName(),userEntity.getAge(),userEntity.getCpf());

    }
    

    public UserEntity dtoToEntity (UserDTO userDTO){
        if(userDTO == null){
            return null;
        }
        UserEntity user = new UserEntity();
        if(userDTO.getId() != null){
            user.setId(userDTO.getId());
        };
        user.setCpf(userDTO.getCpf());
        user.setAge(userDTO.getAge());
        user.setName(userDTO.getName());

        return user;
    

    }
    
}
