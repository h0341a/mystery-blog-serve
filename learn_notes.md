# Project build notes.
### Maven
+ dependency:   
spring-boot-starter-web   
springfox-swagger2   
springfox-swagger-ui
## usage notes
+ use swagger intro:   
code SwaggerConfig.   
Add instructions for controller by use @Api   
Add instructions for methods by use @ApiOperation  
And you can to use @ApiModel to description model.   
Finally, you can to see the apis at http://localhost:8080/swagger-ui.html.   
More examples reference https://www.ibm.com/developerworks/cn/java/j-using-swagger-in-a-spring-boot-project/index.html