

# Enable Cross Origin Requests for Springboot
Enabling Cross Origin Requests for a RESTful Web Service in Springboot

### What is Cross Origin?
Cross-origin Resource Sharing (CORS) is a W3C specification implemented by most browsers that allows you to specify in a flexible way what kind of cross domain requests are authorized, instead of using some less secured and less powerful hacks like IFrame or JSONP.

<p align="center" width="100%">
    <img width="50%" src="https://user-images.githubusercontent.com/9518132/177003644-182eab35-c743-48ad-bcad-e438696338d4.png">
</p>

Spring Framework provides first class support for CORS out-of-the-box, giving you an easier and more powerful way to configure it than typical filter based solutions.

* origins `@CrossOrigin(origins=["localhost:8080"])`List of origins IPs with ports.
* methods `@CrossOrigin(methods=["GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS"])` By default, all origins and GET, HEAD, and POST methods are allowed.
* allowedHeaders `@CrossOrigin(allowedHeaders=["Authorization", "Cache-Control", "Content-Type"])` list of allowed headers
* exposedHeaders `@CrossOrigin(exposedHeaders=["Authorization"])` List of exposed headers
* allowCredentials `@CrossOrigin(allowCredentials=true)` allowed credentials true or false.
* maxAge `@CrossOrigin(maxAge=3600)` maximum age of API 3600 seconds.


### Method Cross Origin Resource Sharing
You can apply CORS to the specific methods of the RestController
```aidl
@RestController
public class HelloController {
    private static final String template1 = "Hello, %s!";
    private static final String template2 = "Hi, %s!";

    private final AtomicLong counter = new AtomicLong();
    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/hello")
    public Greeting hello(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== get greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template1, name));
    }
    
    @GetMapping("/hi")
    public Greeting hi(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== get greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template2, name));
    }
}
```
### Controller Path Cross Origin Resource Sharing

You can apply CORS to the all APIs of a RestController
```aidl
@RestController
@CrossOrigin(origins = {"http://localhost:4200", "http://127.0.0.1:80", "http://example.com"})
public class HelloController {
    @GetMapping("/hello")
    public Greeting hello(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== get greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template1, name));
    }
    @GetMapping("/hi")
    public Greeting hi(@RequestParam(required = false, defaultValue = "World") String name) {
        System.out.println("==== get greeting ====");
        return new Greeting(counter.incrementAndGet(), String.format(template2, name));
    }
}
```

### Global Cross Origin Resource Sharing

Create `WebSecurityConfig` java class and extends WebSecurityConfigurerAdapter
```aidl
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import java.util.List;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*")
                .allowedMethods("HEAD", "GET", "PUT", "POST",
                        "DELETE", "PATCH").allowedHeaders("*");
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.cors().configurationSource(request -> {
            var cors = new CorsConfiguration();
            cors.setAllowedOrigins(List.of("http://localhost:4200", "http://127.0.0.1:80", "http://example.com"));
            cors.setAllowedMethods(List.of("GET","POST", "PUT", "DELETE", "OPTIONS"));
            cors.setAllowedHeaders(List.of("*"));
            return cors;
        }).and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/images/**").permitAll()
                .antMatchers(HttpMethod.POST,"/api/login").permitAll()
                .antMatchers(HttpMethod.POST,"/api/user").permitAll()
                .and()
                .authorizeRequests().anyRequest().authenticated();
    }
}
```

### Learn More

* [spring.io](https://spring.io/guides/gs/rest-service-cors/)  Descriptive article about cors for springboot.
* [spring.io](https://spring.io/blog/2015/06/08/cors-support-in-spring-framework) More detail cors
* [spring.io](https://spring.io/blog/2015/06/08/cors-support-in-spring-framework) More detail
* [Stackoverflow](https://stackoverflow.com/questions/36968963/how-to-configure-cors-in-a-spring-boot-spring-security-application) Global CORS
