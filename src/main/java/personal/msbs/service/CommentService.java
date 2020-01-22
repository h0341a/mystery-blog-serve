package personal.msbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import personal.msbs.model.vo.CommentVo;

import java.util.List;

/**
 * @author ling
 */
public interface CommentService {
    /**
     * 获取所有评论
     * @return 返回结果集
     */
    public List<CommentVo> getAllComment();
}
