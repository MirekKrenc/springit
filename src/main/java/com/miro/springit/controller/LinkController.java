package com.miro.springit.controller;

import com.miro.springit.domain.Link;
import com.miro.springit.repository.LinkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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
        linkRepository.deleteById(id);
    }
}
