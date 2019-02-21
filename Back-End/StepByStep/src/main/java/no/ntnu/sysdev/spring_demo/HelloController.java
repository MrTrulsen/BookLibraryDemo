package no.ntnu.sysdev.spring_demo;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    /**
     * This method will be called when someone accesses REST backend URL /hello
     * @return A static message that will be returned to the REST client
     */
    @RequestMapping("/hello")
    public String hello()
    {
        return "Hello from the Spring world";
    }

    @RequestMapping("/hei")
    public String hei()
    {
        return "Hei på deg!";
    }
}
