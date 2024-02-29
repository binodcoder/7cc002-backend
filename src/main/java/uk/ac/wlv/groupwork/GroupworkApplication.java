package uk.ac.wlv.groupwork;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
public class GroupworkApplication extends SpringBootServletInitializer {

    @RequestMapping("/")
    @ResponseBody
    String home(){
        return "Helloooo";
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(GroupworkApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(GroupworkApplication.class, args);
    }

}
