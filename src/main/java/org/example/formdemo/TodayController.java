package org.example.formdemo;


import java.io.IOException;
import java.time.LocalDate;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.example.formdemo.api.CurrencyRates;
import org.example.formdemo.api.CurrencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
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
    public String socialPost(@Valid @ModelAttribute("messageModel") MessageModel messageModel,
                             BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("messageModel", messageModel);

        if (bindingResult.hasErrors()){
            return "social";
        }

        msgRepo.save(messageModel);
        return "redirect:/socialpost";
    }
//
//    @PutMapping("/social")
//    public String socialPut(@Valid @ModelAttribute("MessageModel") MessageModel messageModel,
//                             BindingResult br, RedirectAttributes redirectAttributes) {
//        redirectAttributes.addFlashAttribute("messageModel", messageModel);
//
//        msgRepo.save(messageModel);
//        return "redirect:/socialpost";
//    }

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

    @PostMapping("/messagesfilter/{id}/like")
    public String likeMessageFilter(@PathVariable int id, HttpServletRequest request, Model model) {

        MessageModel message = msgRepo.findById(id);

        message.likePost();

        return "redirect:/messages/" + message.getPrivpub();
    }

    @GetMapping("/messages/{filter}")
    public String filterMessages(@PathVariable String filter, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("msgRepo", msgRepo.filterList(filter));

        return "redirect:/viewall-filter";
    }


    @GetMapping("/viewall-filter")
    public String viewallFilter(Model model){

        return "viewall-filter";
    }

    @GetMapping("/currencycalc")
    public String currencycalc(){
        return "currencycalc";
    }

    @PostMapping("/currencycalc")
    public String calculateCurrency(@RequestParam("amount") double amount,
                                    @RequestParam("fromcurrency") String fromcurrency,
                                    @RequestParam("tocurrency") String tocurrency,
                                    Model model) throws IOException
    {
        //set up currency service
        CurrencyService service = new CurrencyService();
        CurrencyRates rates = service.getRates();

        //use currency to/from
        double fromCur = 0;
        double toCur = 0;

        //Get rate from rate service, converting string to double
        fromCur = getFromCur(fromcurrency, rates);
        toCur = getFromCur(tocurrency, rates);
        double currencyRatio = toCur/fromCur; //what is diff in fromcurrency to currency, becoz only having USD conversion available

        System.out.println(amount + " from " + fromcurrency + " to " + tocurrency + " " + currencyRatio * amount);
        System.out.println(rates.getRates());
        System.out.println("fromcurrency: " + fromcurrency);
        System.out.println("tocurrency: " + tocurrency);
        System.out.println("currencyRatio: " + currencyRatio);

        // Gemmer input fra @reqparam amount i (key:value) (amount:amount) (var:double)
        model.addAttribute("amount", amount);
        model.addAttribute("rates", rates.getRates());
        model.addAttribute("fromcurrency",fromcurrency);
        model.addAttribute("tocurrency",tocurrency);
        model.addAttribute("result",currencyRatio * amount);

        // Beregn værdi før html eller efter ^^?
        model.addAttribute("eurResult", amount * rates.getRates().getEUR());
        model.addAttribute("dkkResult", amount * rates.getRates().getDKK());
        model.addAttribute("nokResult", amount * rates.getRates().getNOK());
        model.addAttribute("sekResult", amount * rates.getRates().getSEK());

        return "currencycalc";
    }

    private double getFromCur(String currency, CurrencyRates rates) {
        return switch(currency){
            case "DKK" -> rates.getRates().getDKK();
            case "EUR" -> rates.getRates().getEUR();
            case "NOK" -> rates.getRates().getNOK();
            case "SEK" -> rates.getRates().getSEK();
            case "USD" -> rates.getRates().getUSD();
            default -> rates.getRates().getDKK();
        };

    }

}
