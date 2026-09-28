package org.example.formdemo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ValidationController {

    @Autowired
    private ValidMsgRepo ValidMsgRepo;

    @GetMapping("/validation")
    public String showAddPersonForm(Model model) {
        model.addAttribute("MessageModel",new MessageModel());
        return "ValidationMsg";
    }

    @PostMapping("/validation")
    public String addPerson(@Valid @ModelAttribute("MessageModel") MessageModel msgmodel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "ValidationMsg";
        }
        ValidMsgRepo.save(msgmodel);
        return "redirect:/index";
    }
}
