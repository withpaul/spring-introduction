package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SampleController {
    @GetMapping("sample.html2")
    public String sample(@RequestParam(value = "name", defaultValue = "zz") String name, Model model) {
        model.addAttribute("name", name);
        return "sample";
    }
}
