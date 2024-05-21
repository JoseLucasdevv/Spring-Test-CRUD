package crud.com.example.crudspring.DTO;

import crud.com.example.crudspring.entity.UserEntity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class UserDTO {
    @Id
    private Long id;
    @NotBlank(message ="This field may not be empty")
    private String name;
    @NotNull(message="This field may not be empty")
    private Integer age;
    @NotBlank(message="This field may not be empty")
    private String cpf;

    public UserDTO(Long id,String name,Integer age, String cpf){
    
    this.id = id;
    this.name = name;
    this.age = age;
    this.cpf = cpf;
    }

    public UserDTO(UserEntity user){
        id = user.getId();
        name = user.getName();
        cpf = user.getCpf();
        age = user.getAge(); 
    }

    public Long getId(){
        return this.id;
    };

    public void setId(Long id){
        this.id = id;
    };

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Integer getAge(){
        return this.age;
    }
    public void setAge(Integer age){
        this.age = age;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }
   }
