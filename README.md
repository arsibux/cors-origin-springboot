# Enable Cross Origin Requests for Springboot
Enabling Cross Origin Requests for a RESTful Web Service in Springboot

### What is Cross Origin?
Cross-origin Resource Sharing (CORS) is a W3C specification implemented by most browsers that allows you to specify in a flexible way what kind of cross domain requests are authorized, instead of using some less secured and less powerful hacks like IFrame or JSONP.

* origins `@CrossOrigin(origins="localhost:8080")` specify the domain with port.
* methods `@CrossOrigin(methods="GET")` By default, all origins and GET, HEAD, and POST methods are allowed.
* allowedHeaders `@CrossOrigin(allowedHeaders="")`
* exposedHeaders `@CrossOrigin(exposedHeaders="")`
* allowCredentials `@CrossOrigin(allowCredentials="")`
* maxAge `@CrossOrigin(maxAge=3600)` maximum age of API 3600 seconds.


### Method Cross Origin Resource Sharing

### Controller Path Cross Origin Resource Sharing

### Global Cross Origin Resource Sharing

### Resources
* [spring.io](https://spring.io/guides/gs/rest-service-cors/) Very descriptive article about cors for springboot.
