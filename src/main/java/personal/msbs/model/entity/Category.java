package personal.msbs.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.util.StringUtils;

/**
 * @author ling
 */
@Getter
@Setter
@ToString
public class Category {
    private int id;
    private String name;
    private String description;
}
