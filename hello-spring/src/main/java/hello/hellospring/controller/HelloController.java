package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller

public class HelloController {
    @GetMapping("hello")
    public String hello(Model model) {
        model.addAttribute("data", "hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    // 외부에서 직접 받기
    public String helloMvc(@RequestParam(value = "name") String name, Model model) {
        // 외부에서 받아온 name을 name 키값에 넘겨 주기
        model.addAttribute("name", name);
        return "hello-template";
    }
}
