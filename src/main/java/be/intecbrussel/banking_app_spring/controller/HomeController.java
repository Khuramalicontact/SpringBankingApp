package be.intecbrussel.banking_app_spring.controller;

import be.intecbrussel.banking_app_spring.model.Client;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String homePage(Model model){
//        model.addAttribute("client",new Client());
        return "index";
    }
}
