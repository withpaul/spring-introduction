package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ApiController {
    @GetMapping("api-string")
    @ResponseBody
    public String apiString(@RequestParam(value = "name",defaultValue = "jongjin") String name)
    {
        return name;
    }

    @GetMapping("api-object")
    @ResponseBody
    public User apiObject(@RequestParam(value = "name", defaultValue = "jongjin") String name, Model model)
    {
        User user = new User();
        user.setName(name);
        return user;
    }

    public class User {
        String name;
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
