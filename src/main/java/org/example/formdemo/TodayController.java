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



    @PostMapping("/socialpost")
    public String socialPost(Model model,
            @ModelAttribute("messageModel") messageModel messageModel) {
        model.addAttribute("messageModel", messageModel);
        messageModel.setPrivpub("Private");
        System.out.println(
                "UserName: " + messageModel.getName()
                        + " has posted: " + messageModel.getMessage()
                        + " Private: " + messageModel.isPrivpub()
        );

        return "socialpost";
    }
}
