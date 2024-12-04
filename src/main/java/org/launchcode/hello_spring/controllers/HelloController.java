
package org.launchcode.hello_spring.controllers;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
//@ResponseBody
//@RequestMapping("hello")
public class HelloController {

    //    lives /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }


    //    live /hello/hello
//    Handles request of the form /hello?name=LaunchCode
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello")
    public String helloWithQueryParam(@RequestParam String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "Hello";
    }


    // Handles requests of the form /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloWithPathParam(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "Hello";
    }


//    @RequestMapping(value="hello", method = RequestMethod.POST)
//    public String helloPost(@RequestParam String name, @RequestParam String language) {
//        if (name == null) {
//            name = "World";
//        }
//        return createMessage(name, language);
//    }


    public static String createMessage(String n, String l) {
        String greeting = "";

        if(l.equals("english")) {
            greeting = "Hello";
        }
        else if(l.equals("french")) {
            greeting = "Bonjour";
        }
        else if(l.equals("italian")) {
            greeting = "Bonjourno";
        }
        else if(l.equals("spanish")) {
            greeting = "Hola";
        }
        else if(l.equals("german")) {
            greeting = "Hallo";
        }
        return greeting + ", " + n;
    }


    // /hello/form
    @GetMapping("form")
    public String helloForm() {
        return "form";
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) {
        ArrayList<String> names = new ArrayList<>();
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names);
        return "hello-list";
    }
}
