package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NameController {
    @GetMapping("name")
    public String name(Model model)
    {
        model.addAttribute("name", "하ss하하");
        return "name";
    }

}
