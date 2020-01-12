package personal.msbs;

import org.mapstruct.Mapping;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author ling
 */
@SpringBootApplication
@MapperScan("personal.msbs.dao")
public class MysteryBlogServeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysteryBlogServeApplication.class, args);
    }

}
