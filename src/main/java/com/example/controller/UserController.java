package com.example.controller;

import com.example.domain.User;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


//@RequestMapping(path= "/users")
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
//EnableCors(origins: "http://mywebclient.azurewebsites.net", headers: "*", methods: "*")
//@CrossOrigin (origins = "http:localhost:4200")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<User> list() {
        return service.listAll();
    }

   // @PostMapping("/add")
    //public void add(User user) { service.save(user);}

// @ResponseBody
   @GetMapping("/users/{id}")
   public ResponseEntity<User> get(@PathVariable Integer id) {
       try {
           User user = service.get(id);
           return new ResponseEntity<User>(user, HttpStatus.OK);
       } catch (NoSuchElementException e) {
           return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
       }
   }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public int add(User client) {
        try {
            service.save(client);
            return 1;
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    //@RequestMapping(value = "/updateCliente", method = RequestMethod.PUT)
    @PutMapping("/update/{id}")
    public ResponseEntity<User> update(@RequestBody User student, @PathVariable Integer id) {
        try {
            User existingUser = service.get(id);
            service.save(existingUser);
            return new ResponseEntity<User>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
