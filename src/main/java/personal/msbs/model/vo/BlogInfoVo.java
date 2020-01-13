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
    private int uid;
    private Date date;
    private String title;
    private String category;
}
