package org.example.formdemo;

import java.time.LocalDateTime;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TimeController {
    public TimeController() {
    }

    @GetMapping({"/second"})
    public String second(Model model) {
        int second = LocalDateTime.now().getSecond();
        model.addAttribute("second", second);
        return "second";
    }
}
