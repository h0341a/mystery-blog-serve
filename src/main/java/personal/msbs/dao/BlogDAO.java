package personal.msbs.dao;

import org.springframework.stereotype.Repository;
import personal.msbs.model.entity.Blog;

/**
 * @author ling
 */
@Repository
public interface BlogDAO {
    /**
     * 插入新博客
     * @param blog 博客信息
     * @return 数据库中受影响的条数
     */
    public int insert(Blog blog);
}
