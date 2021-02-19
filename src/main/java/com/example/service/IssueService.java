package com.example.service;

import com.example.domain.Issue;
import com.example.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class IssueService {

    @Autowired
    private IssueRepository repository;

    public List<Issue> listAll() { return repository.findAll();}

    public void save(Issue user) {
        repository.save(user);
    }

    public Issue get(int id) {
        return repository.findById(id).get();
    }

    public void delete(int id) {
        repository.deleteById(id);
    }
}
