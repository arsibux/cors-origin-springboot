# Enable Cross Origin Requests for Springboot
Enabling Cross Origin Requests for a RESTful Web Service in Springboot

### What is Cross Origin?
Cross-origin Resource Sharing (CORS) is a W3C specification implemented by most browsers that allows you to specify in a flexible way what kind of cross domain requests are authorized, instead of using some less secured and less powerful hacks like IFrame or JSONP.

Spring Framework provides first class support for CORS out-of-the-box, giving you an easier and more powerful way to configure it than typical filter based solutions.

* origins `@CrossOrigin(origins=["localhost:8080"])`List of origins IPs with ports.
* methods `@CrossOrigin(methods=["GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS"])` By default, all origins and GET, HEAD, and POST methods are allowed.
* allowedHeaders `@CrossOrigin(allowedHeaders=["Authorization", "Cache-Control", "Content-Type"])` list of allowed headers
* exposedHeaders `@CrossOrigin(exposedHeaders=["Authorization"])` List of exposed headers
* allowCredentials `@CrossOrigin(allowCredentials=true)` allowed credentials true or false.
* maxAge `@CrossOrigin(maxAge=3600)` maximum age of API 3600 seconds.


### Method Cross Origin Resource Sharing

### Controller Path Cross Origin Resource Sharing

### Global Cross Origin Resource Sharing

### Learn More
* [spring.io](https://spring.io/guides/gs/rest-service-cors/) Very descriptive article about cors for springboot.
* [spring.io](https://spring.io/blog/2015/06/08/cors-support-in-spring-framework) More detail
* [spring.io](https://spring.io/blog/2015/06/08/cors-support-in-spring-framework) More detail
* [Stackoverflow](https://stackoverflow.com/questions/36968963/how-to-configure-cors-in-a-spring-boot-spring-security-application) Global CORS