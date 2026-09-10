package org.example.formdemo;


import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DateController {
    public DateController() {
    }

    @GetMapping({"/day"})
    public String today(Model model) {
        String day = LocalDate.now().getDayOfWeek().toString();
        model.addAttribute("day", day);
        return "day";
    }
}
