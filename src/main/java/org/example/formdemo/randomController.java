package org.example.formdemo;

import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class randomController {
    public randomController() {
    }

    @GetMapping({"/random"})
    public String random(Model model) {
        Random random = new Random();
        model.addAttribute("random", random.nextInt(60));
        return "random";
    }
}

