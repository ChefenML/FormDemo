package org.example.formdemo;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ValidationController {

    @Autowired
    private ValidMsgRepo ValidMsgRepo;

    @GetMapping("/validation")
    public String showAddPersonForm(Model model) {
        model.addAttribute("MessageModel",new MessageModel());
        return "validation";
    }

    @PostMapping("/validation")
    public String addPerson(@Valid @ModelAttribute("MessageModel") MessageModel MessageModel,
                            BindingResult bindingResult, RedirectAttributes redirectAttributes) {

        redirectAttributes.addFlashAttribute("MessageModel", MessageModel);

        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
            return "validation";
        }
        ValidMsgRepo.save(MessageModel);
        return "redirect:/validation";
    }
}
