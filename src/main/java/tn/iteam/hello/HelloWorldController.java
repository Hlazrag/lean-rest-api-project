package tn.iteam.hello;
import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

//    @RequestMapping(path = "/hello-world", method = RequestMethod.GET)
//    public String helloWorld(){
//        return "Hello World";
//    }

    @GetMapping(path = "/hello-world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWorldBean(){
        return new HelloWorldBean("Hello World");
    }

    @GetMapping(path = "/hello-world/path-variable/{myname}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable(value = "myname") String name){
        return new HelloWorldBean(String.format("Hello World, %s", name));
    }
}
