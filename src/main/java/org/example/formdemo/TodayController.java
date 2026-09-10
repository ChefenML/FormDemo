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
        model.addAttribute("messageModel", new messageModel());
        return "social";
    }



    @PostMapping("/social")
    public String socialPost(
            @ModelAttribute("messageModel") messageModel messageModel) {

        System.out.println(
                "UserName: " + messageModel.getName()
                        + " has posted: " + messageModel.getMessage()
                        + " Private: " + messageModel.isPrivpub()
        );

        return "redirect:/socialpost";
    }

    @GetMapping("/socialpost")
    public String socialCreatedSuccess() {
        return "socialpost"; // socialpost.html
    }
}
