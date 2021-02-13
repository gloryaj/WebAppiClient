package com.example.service;



import com.example.demo.Clients;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<Clients> listAll() { return repository.findAll();}

    public void save(Clients user) {
        repository.save(user);
    }

    public Clients get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }

}
