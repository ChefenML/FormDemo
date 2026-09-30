package org.example.formdemo;

import org.springframework.boot.webmvc.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CustomErrorController implements ErrorController {


    @RequestMapping("/404")
    public String handleNotFoundError(Model model) {
        model.addAttribute("errorCode", "404");
        model.addAttribute("errorMessage", "Page Not Found");
        return "error"; // Thymeleaf template name
    }
//    @GetMapping
//    public String getErrorPath() {
//        return "/error";
//    }

}
