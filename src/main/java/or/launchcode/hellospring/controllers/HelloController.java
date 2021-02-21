package or.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {



    //handler that handles request paths at hello
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")//this method should handle get requests
    public String hello(@RequestParam String name, Model model){
        String greeting = "Hello, "+ name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("goodbye")//this method should handle get requests
    @ResponseBody//plain text response
    public String goodBye(){
        return "goodbye, Spring!";
    }

    //handler that handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello2")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String frog, String dog){
        return "Hello, "+ frog + dog+"!";
    }

    //handler that handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")//we will take that dynamic variable name (which can be anything)
    @ResponseBody                //and set that var value to the String name below
    public String helloWithPathParam(@PathVariable String name){

        return "Hello "+ name + "!";
    }

    @GetMapping("form")
    public String helloForm(){
        return "form";
    }

    @GetMapping("indexController")
    public String indexController(){
        return "index";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> arrayListNames = new ArrayList<>();
        arrayListNames.add("Bob");
        arrayListNames.add("Billy");
        arrayListNames.add("Charlie");
        model.addAttribute("names", arrayListNames);
        return "hello-list";

    }







}
