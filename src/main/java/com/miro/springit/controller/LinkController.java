package com.miro.springit.controller;

import com.miro.springit.domain.Link;
import com.miro.springit.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/links")
public class LinkController {

    private LinkRepository linkRepository;

    @Autowired
    public LinkController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    // list
    @GetMapping("")
    public List<Link> list() {
        return linkRepository.findAll() ;
    }

    // CRUD
    @PostMapping("/create")
    public Link create(@RequestBody Link link) {
        return linkRepository.save(link);
    }

    @GetMapping("/{id}")
    public Optional<Link> read(@PathVariable Long id) {
        return linkRepository.findById(id);
    }

    @PutMapping("/update/{id}")
    public Link update(@PathVariable Long id, @RequestBody Link link) {
        return linkRepository.save(link);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
//        Optional<Link> linkToDelete = linkRepository.findById(id);
//        linkRepository.delete(linkToDelete.get());

        linkRepository.deleteById(id);
    }
}
