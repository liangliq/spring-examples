package com.example.liangl.controller;


import com.example.liangl.data.SpitterRepository;
import com.example.liangl.model.Spitter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute("spitter", new Spitter());
        return "registerForm";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegistration(
            @Valid @ModelAttribute("spitter") Spitter spitter,
            BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "registerForm";
        }
        spitterRepository.save(spitter);
        // 重定向到新的页面
        return "redirect:/spitter/" + spitter.getUsername();
    }

    @RequestMapping(value = "/{username}", method = RequestMethod.GET)
    public String showSpitterPrfile(
            @PathVariable String username,Model model
    ){
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }

  /*  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String showSpitterPrfileById(
            @PathVariable String id,Model model
    ){
        Spitter spitter = spitterRepository.findOne(Long.valueOf(id));
        model.addAttribute(spitter);
        return "profile";
    }*/

}
