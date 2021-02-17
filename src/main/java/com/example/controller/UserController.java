package com.example.controller;

import com.example.demo.Clients;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;


//@RequestMapping(path= "/api/users")
//@CrossOrigin(origins = "*", allowedHeaders = "*")
//@CrossOrigin //(origins = "http:localhost:4200")
@RestController
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/users")
    public List<Clients> list() {
        return service.listAll();
    }

   // @PostMapping("/add")
    //public void add(Clients user) { service.save(user);}

// @ResponseBody
   @GetMapping("/users/{id}")
   public ResponseEntity<Clients> get(@PathVariable Integer id) {
       try {
           Clients user = service.get(id);
           return new ResponseEntity<Clients>(user, HttpStatus.OK);
       } catch (NoSuchElementException e) {
           return new ResponseEntity<Clients>(HttpStatus.NOT_FOUND);
       }
   }

    @RequestMapping(path = "/add", method = RequestMethod.POST)
    public int add(Clients client) {
        try {
            service.save(client);
            return 1;
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    //@RequestMapping(value = "/updateCliente", method = RequestMethod.PUT)
    @PutMapping("/update/{id}")
    public ResponseEntity<Clients> update(@RequestBody Clients student, @PathVariable Integer id) {
        try {
            Clients existingUser = service.get(id);
            service.save(existingUser);
            return new ResponseEntity<Clients>(student, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Clients>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
