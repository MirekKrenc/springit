package com.miro.springit.controller;

import com.miro.springit.domain.Link;
import com.miro.springit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/viewlinks")
public class LinkControllerView {

    private static final Logger logger = LoggerFactory.getLogger(LinkController.class);
    private LinkRepository linkRepository;

    @Autowired
    public LinkControllerView(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @GetMapping("")
    public String listAll(Model model)
    {
        model.addAttribute("links", linkRepository.findAll());
        return "link/list";
    }

    @GetMapping("/{id}")
    public String getOne(@PathVariable Long id, Model model)
    {
        Optional<Link> link = linkRepository.findById(id);
        if (link.isPresent())
        {
            model.addAttribute("link", link.get())
                    .addAttribute("success", model.containsAttribute("success"));
            return "link/view";
        } else {
            return "redirect:/viewlinks/";
        }
    }

    @GetMapping("/submit")
    public String newLinkForm(Model model)
    {
        model.addAttribute("link", new Link());
        return "link/submit";
    }

    @PostMapping("/submit")
    public String createLink(@Valid Link link, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes)
    {
        if (bindingResult.hasErrors())
        {
            logger.info("Validation errors while submitting a new link");
            logger.info(bindingResult.getAllErrors().toString());
            logger.info("============================================================================================");
            model.addAttribute("link", link);
            return "/link/submit";
        } else {
            linkRepository.save(link);
            logger.info("New link was saved");
            redirectAttributes.addAttribute("id", link.getId())
                    .addFlashAttribute("success", true);
            return "redirect:/viewlinks/{id}";
        }

    }

}
