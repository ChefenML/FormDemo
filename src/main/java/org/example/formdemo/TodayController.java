package org.example.formdemo;


import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TodayController {
    msgRepo msgRepo;
    public TodayController(msgRepo msgRepo) {
        this.msgRepo = msgRepo;
    }

    @GetMapping({"/social"})
    public String today(Model model) {
        model.addAttribute("today", LocalDate.now());
        model.addAttribute("messageModel", new MessageModel());
        return "social";
    }



    @PostMapping("/social")
    public String socialPost(RedirectAttributes redirectAttributes,
                             @ModelAttribute("messageModel") MessageModel messageModel) {
        redirectAttributes.addFlashAttribute("messageModel", messageModel);
        messageModel.setPrivpub("Private");
        System.out.println(
                "UserName: " + messageModel.getName()
                        + " has posted: " + messageModel.getMessage()
                        + " Private: " + messageModel.getPrivpub()
        );
        msgRepo.save(messageModel);
        return "redirect:/socialpost";
    }
    @GetMapping("/socialpost")
    public String postCreated(){
        return "socialpost";
    }

    @GetMapping("/viewall")
    public String viewAll(Model model){
        model.addAttribute("msgRepo",msgRepo.getAll());
        return "viewall";
    }


    @PostMapping("/messages/{id}/like")
    public String likeMessage(@PathVariable int id) {
        MessageModel message = msgRepo.findById(id);

        message.likePost();

        return "redirect:/viewall";
    }

    @GetMapping("/messages/{filter}")
    public String filterMessages(@PathVariable String filter, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msgRepo", msgRepo.filterList(filter));

        return "redirect:/viewall-filter";
    }

    @GetMapping("/viewall-filter")
    public String viewallFilter(){
        return "viewall-filter";
    }


}
