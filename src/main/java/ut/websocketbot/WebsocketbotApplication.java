package ut.websocketbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
//public class WebsocketbotApplication {

//@SpringBootApplication(scanBasePackages = "ut.websocketbot")
public class WebsocketbotApplication extends SpringBootServletInitializer {

//    //comment below if deploying outside web container -->
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(WebsocketbotApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(WebsocketbotApplication.class, args);
    }

}
