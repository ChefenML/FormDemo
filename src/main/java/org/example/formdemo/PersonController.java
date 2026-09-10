package org.example.formdemo;


import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonController {
    public PersonController() {
    }

    @GetMapping
    public String getPeople(Model model) {
        model.addAttribute("something", "this is coming from the controller");
        model.addAttribute("people", Arrays.asList(new Person("John", 20), new Person("Sarah", 22), new Person("Simon", 23), new Person("SnotUnge", 15)));
        return "people";
    }
}
