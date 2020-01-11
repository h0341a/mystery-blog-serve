# Project build notes.
### Maven
+ dependency:   
*//Java web auto configuration module provided by springboot*
spring-boot-starter-web  
*//swagger module*   
springfox-swagger2   
*//good ui module by swagger*   
springfox-swagger-ui   
*//tool to spice up java*  
lombok   
*//mybatis module*   
mybatis-spring-boot-starter   
*//mysql connector*
mysql-connector-java
## usage notes
+ use swagger intro:   
code SwaggerConfig.   
Add instructions for controller by use @Api   
Add instructions for methods by use @ApiOperation  
And you can to use @ApiModel to description model.   
Finally, you can to see the apis at http://localhost:{port}/swagger-ui.html.   
More examples reference https://www.ibm.com/developerworks/cn/java/j-using-swagger-in-a-spring-boot-project/index.html   