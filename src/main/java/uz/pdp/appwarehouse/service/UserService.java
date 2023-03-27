package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.User;
import uz.pdp.appwarehouse.entity.Warehouse;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.payload.UserDto;
import uz.pdp.appwarehouse.repository.UserRepository;
import uz.pdp.appwarehouse.repository.WarehouseRepository;

import java.util.*;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    WarehouseRepository warehouseRepository;

    String s = UUID.randomUUID().toString();
 public Result add(UserDto userDto){
   boolean existsByPhoneNumber = userRepository.existsByPhoneNumber(userDto.getPhoneNumber());
   if (existsByPhoneNumber)
       return new Result("Such a phone number already exists", false);


   User user = new User();
   user.setFirstName(userDto.getFirstName());
   user.setLastName(userDto.getLastName());
   user.setPhoneNumber(userDto.getPhoneNumber());
   user.setPassword(userDto.getPassword());
   user.setCode(s);






   userRepository.save(user);
   return new Result("Saved user", true);



  }

    public List<User> getAll(){
        List<User> allUsers = userRepository.findAll();
        return allUsers;
    }

   // public Result update(Integer id, UserDto userDto){
    //}

    public Result delete(Integer id){
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()){
            userRepository.deleteById(id);
            return new Result("Delete user", true);
        }
        return new Result("User not found", false);
    }
}
