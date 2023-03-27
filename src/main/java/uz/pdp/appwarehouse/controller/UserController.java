package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.User;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.payload.UserDto;
import uz.pdp.appwarehouse.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //@PostMapping("/add")
    //public Result add(@RequestBody UserDto userDto) {
    //   Result result = userService.add(userDto);
    //   return result;
    //

    @GetMapping("/getAll")
    public List<User> getAll(){
        List<User> allUsers = userService.getAll();
        return allUsers;
    }

    //@PutMapping("/update/{id}")
   // public Result update(@PathVariable Integer id, @RequestBody UserDto userDto){
   //     Result result = userService.update(id, userDto);
  //      return result;
  //  }

    @DeleteMapping("/deleted/{id}")
    public Result delete(@PathVariable Integer id){
        Result result = userService.delete(id);
        return result;
    }
}