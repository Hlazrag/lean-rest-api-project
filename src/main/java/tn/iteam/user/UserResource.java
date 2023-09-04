package tn.iteam.user;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

//@RestController
public class UserResource {

    private final UserDaoService userDaoService;

    public UserResource(UserDaoService userDaoService) {
        this.userDaoService = userDaoService;
    }

    // GET /users
    @GetMapping("/users")
    public List<User> retrieveAllUsers(){
        return userDaoService.findAll();
    }

//    // POST /user
//    @PostMapping("/users")
//    public User createUser(@RequestBody User user){
//        return userDaoService.save(user);
//    }

    // POST /user
    @PostMapping("/users")
    public ResponseEntity<User> CreateUser(@Valid @RequestBody User user){
        var savedUser = userDaoService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id")
                .buildAndExpand(savedUser.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }

    // GET /user
    @GetMapping("/users/{id}")
    public User retrieveUser(@PathVariable int id){
        var user = userDaoService.findOne(id);
        if(user == null)
            throw new UserNotFoundException("id:"+id);
        return user;
    }

    // DELETE /user
    @DeleteMapping ("/users/{id}")
    public void deleteUser(@PathVariable int id){
        userDaoService.deletById(id);
    }



}
