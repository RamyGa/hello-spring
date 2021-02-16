package or.launchcode.hellospring.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("hello")
public class HelloController {



    //handler that handles request paths at hello
    @GetMapping("hello")//this method should handle get requests
    @ResponseBody//plain text response
    public String hello(){
        return "Hello, Spring!";
    }

    @GetMapping("goodbye")//this method should handle get requests
    @ResponseBody // this can be added to the top of the class as a single annotation
    public String goodBye(){
        return "goodbye, Spring!";
    }

    //handler that handles requests of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    @ResponseBody// this can be added to the top of the class as a single annotation
    public String helloWithQueryParam(@RequestParam String name){
        return "Hello, "+ name + "!";
    }

    //handler that handles request of the form /hello/LaunchCode
    @GetMapping("hello/{name}")//we will take that dynamic variable name (which can be anything)
    @ResponseBody // this can be added to the top of the class as a single annotation               //and set that var value to the String name below
    public String helloWithPathParam(@PathVariable String name){

        return "Hello "+ name + "!";
    }

    @GetMapping("/form")
    @ResponseBody// this can be added to the top of the class as a single annotation
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

    @GetMapping("/exercise_form")
    @ResponseBody
    public String greetingForm(){

        return "<html>" +
                "<body>" +
                "<form action='greeting_response' method='post'>" +
                "<input type'text' name='name'>" +
                "<select name='language' id='language'>" + // grabbing language value &
                                                           //applying it to name=language
                "    <option value='english'>English</option>" +
                "    <option value='french'>French</option>" +
                "    <option value='spanish'>Spanish</option>" +
                "    <option value='arabic'>Arabic</option>" +
                "  </select>" +
                "<input type='submit' value='greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

    //if its a form the output of the url will be /hello?name=LaunchCode
    @PostMapping("/greeting_response")
    @ResponseBody
    public String greetingResponse(@RequestParam String name, @RequestParam String language){

         return languageGreeting(name, language);
    }


    public String languageGreeting(String name, String language){
        if(language.equals("english")){
            return "Hello "+ name;
        }
        else if(language.equals("french")){
            return "Bonjour "+ name;
        }
        else if(language.equals("spanish")){
            return "Hola "+ name;
        }
        else {
            return "Marhaba "+ name;
        }

    }





}
