package idv.chou.chou_springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
//以下為直接springboot直接啟用server
@SpringBootApplication
public class MainApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(MainApplication.class, args);
	}
}


//以下為另外透過tomcat啟用server
/*@SpringBootApplication
public class Application extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}*/