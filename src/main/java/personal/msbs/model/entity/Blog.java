package personal.msbs.model.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author ling
 */
@Getter
@Setter
@ToString
public class Blog {
    private int bid;
    private String title;
    private int categoryId;
    private String description;
    private String content;
    private Date createDate;
}
