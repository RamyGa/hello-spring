package or.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class HelloController {



    //handler that handles request paths at hello
    @GetMapping("hello")//this method should handle get requests
    @ResponseBody//plain text response
    public String hello(){
        return "Hello, Spring!";
    }

    @GetMapping("goodbye")//this method should handle get requests
    @ResponseBody
    public String goodBye(){
        return "goodbye, Spring!";
    }

    //handler that handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, "+ name + "!";
    }

    //handler that handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")//we will take that dynamic variable name (which can be anything)
    @ResponseBody                //and set that var value to the String name below
    public String helloWithPathParam(@PathVariable String name){

        return "Hello "+ name + "!";
    }

    @GetMapping("/form")
    @ResponseBody
    public String helloForm(){
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" +//submit a request to /hello
                "<input type='text' name='name'>" +
                "<input type='submit' value='greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }





}
