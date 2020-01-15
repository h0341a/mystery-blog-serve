package personal.msbs.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author ling
 */
@Getter
@Setter
@ToString
public class CommentDto {
    private String nickname;
    private String email;
    private String content;
    private int blogId;
    private int parentCid;
}
