package uz.pdp.dars1_vazifa2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.dars1_vazifa2.entity.User;
import uz.pdp.dars1_vazifa2.payload.Result;
import uz.pdp.dars1_vazifa2.service.UserService;

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