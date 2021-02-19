package ru.bardyzh.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/first")
public class FirstController {
    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model){

        //System.out.println(("Hello, " + name + " " + surname));

        model.addAttribute("message", "Hello, " + name + " " + surname);
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(){
        return "first/goodbye";
    }

    @GetMapping("/calculator")
    public String calculatorPage(@RequestParam(value = "a", required = false) int a,
                                 @RequestParam(value = "b", required = false) int b,
                                 @RequestParam(value = "action", required = false) String action,
                                 Model model){
        int result;
        double resultd;
        switch (action){
            case("multiplication"):
                result = a*b;
                model.addAttribute("result", "Result " + result);
                return "first/calculator";
            case("division"):
                if (b==0){
                    model.addAttribute("result", "Делитель не может быть равен 0");
                }else{
                    resultd = a/(double)b;
                    model.addAttribute("result", "Result " + resultd);
                }
                return "first/calculator";
            case("addition"):
                result = a+b;
                model.addAttribute("result", "Result " + result);
                return "first/calculator";
            case("subtraction"):
                result = a-b;
                model.addAttribute("result", "Result " + result);
                return "first/calculator";
            default:
                model.addAttribute("result", "Parameter action is not defined");
                return "first/calculator";
        }
    }
}
