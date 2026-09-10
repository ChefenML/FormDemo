package org.example.formdemo;


import java.io.PrintStream;
import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TodayController {
    public TodayController() {
    }

    @GetMapping({"/social"})
    public String today(Model model) {
        model.addAttribute("today", LocalDate.now());
        return "social";
    }

    @PostMapping({"/social/post"})
    @ResponseBody
    public String socialPost(Model model, @ModelAttribute("messageModel") messageModel messageModel) {
        messageModel mm = new messageModel();
        model.addAttribute("messagemodel", mm);
        PrintStream var10000 = System.out;
        String var10001 = mm.getName();
        var10000.println("UserName: " + var10001 + " has posted: " + mm.getMessage() + " Private: " + mm.isPrivpub());
        return "redirect:/socialpost";
    }
}
