package com.example.controller;

import com.example.domain.Issue;
import com.example.service.IssueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

//@RequestMapping(path= "/issue")
//@CrossOrigin (origins = "http:localhost:4200")
@RestController
public class IssueController {

    @Autowired
    private IssueService service;

    @GetMapping("/issues")
    public List<Issue> list() {
        return service.listAll();
    }

    // @PostMapping("/add")
    //public void add(User user) { service.save(user);}

    // @ResponseBody
    @GetMapping("/issue/{id}")
    public ResponseEntity<Issue> get(@PathVariable Integer id) {
        try {
            Issue user = service.get(id);
            return new ResponseEntity<Issue>(user, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Issue>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(path = "/addIssue", method = RequestMethod.POST)
    public int add(Issue client) {
        try {
            service.save(client);
            return 1;
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    //@RequestMapping(value = "/updateCliente", method = RequestMethod.PUT)
    @PutMapping("/updateIssue/{id}")
    public ResponseEntity<Issue> update(@RequestBody Issue issue, @PathVariable Integer id) {
        try {
            Issue existingIssue = service.get(id);
            service.save(existingIssue);
            return new ResponseEntity<Issue>(issue, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Issue>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteIssue/{id}")
    public void delete(@PathVariable Integer id) {
        service.delete(id);
    }

}
