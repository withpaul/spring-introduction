package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("age") int age, Model model)
    {
        model.addAttribute("age", age);
        return "hello-mvc";
    }

    @GetMapping("hello-mvc-required")
    public String helloMvcRequired(@RequestParam(value = "age", required = false) Integer age, Model model)
    {
        model.addAttribute("age", age);
        return "hello-mvc";
    }

    @GetMapping("hello-mvc-default")
    public String helloMvcDefault(@RequestParam(value = "age", defaultValue = "5") Integer age, Model model)
    {
        model.addAttribute("age", age);
        return "hello-mvc";
    }


    /**
     * age는 필수 요소이다
     * 이름은 필수는 아니고 디폴트는 김종진으로
     */
    @GetMapping("test")
    public String test(
        @RequestParam("age") Integer age,
        @RequestParam(value = "name", required = false, defaultValue = "김종진") String name,
        Model model
    ) {
        model.addAttribute("age", age);
        model.addAttribute("name", name);
        return "test";
    }

    @GetMapping("hello-integer-year")
    @ResponseBody
    public Integer returnIntegerYear(@RequestParam(name = "year", required = false, defaultValue = "2022") Integer year)
    {
        return year;
    }

    @GetMapping("hello-object-person")
    @ResponseBody
    public Person returnHelloObjectPerson(
            @RequestParam(name="age", required = false, defaultValue = "32") Integer age,
            @RequestParam("name") String name
    )  {
        // getter가 없으면 HttpMediaTypeNotAcceptableException 에러남
        return new Person(age, name);
    }

    static class Person {
        private Integer age;
        private String name;

        public Person(Integer age, String name) {
            this.age = age;
            this.name = name;
        }

        public Integer getAge() {
            return age;
        }

        public String getName() {
            return name;
        }
    }
}
