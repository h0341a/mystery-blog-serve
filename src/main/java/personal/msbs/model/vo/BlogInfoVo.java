package personal.msbs.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author ling
 */
@Getter
@Setter
public class BlogInfoVo {
    private int bid;
    private Date createDate;
    private String title;
    private String description;
    private String category;
}
