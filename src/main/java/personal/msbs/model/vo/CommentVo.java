package personal.msbs.model.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author ling
 */
@Getter
@Setter
public class CommentVo {
    private int cid;
    /**
     * 用以表示本评论是回复博客还是回复某一评论
     */
    private String parent;
    private Date createDate;
    private String blogTitle;
    private String content;
}
