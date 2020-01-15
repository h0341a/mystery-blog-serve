package personal.msbs.dao;

import org.springframework.stereotype.Repository;
import personal.msbs.model.entity.Comment;

/**
 * @author ling
 */
@Repository
public interface CommentDAO {
    /**
     * 插入新评论
     * @param comment 评论内容
     * @return 插入的条数
     */
    public int insert(Comment comment);

    /**
     * 根据评论id查询
     * @param cid id
     * @return 查询结果
     */
    public Comment selectByCid(int cid);
}
