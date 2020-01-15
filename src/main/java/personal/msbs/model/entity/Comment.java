package personal.msbs.model.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author ling
 */
@Getter
@Setter
public class Comment {
    private int cid;
    private String nickname;
    private String email;
    private String content;
    private int blogId;
    private int starCount;
    private int parentCid;
    private Date createDate;
}
