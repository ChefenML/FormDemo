package org.example.formdemo;


import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class TodayController {
    public TodayController() {
    }

    @GetMapping({"/social"})
    public String today(Model model) {
        model.addAttribute("today", LocalDate.now());
        model.addAttribute("messageModel", new MessageModel());
        return "social";
    }



    @PostMapping("/socialpost")
    public String socialPost(Model model,
            @ModelAttribute("messageModel") MessageModel messageModel) {
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
