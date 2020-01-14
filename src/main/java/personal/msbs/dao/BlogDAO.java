package personal.msbs.dao;

import org.springframework.stereotype.Repository;
import personal.msbs.model.entity.Blog;

import java.util.List;

/**
 * @author ling
 */
@Repository
public interface BlogDAO {
    /**
     * 查询所有博客
     * @return 博客列表
     */
    public List<Blog> select();

    /**
     * 根据分类id获取博客列表
     * @param categoryId 分类id
     * @return 获取到的blog列表
     */
    public List<Blog> selectByCategory(int categoryId);
    /**
     * 插入新博客
     * @param blog 博客信息
     * @return 数据库中受影响的条数
     */
    public int insert(Blog blog);
}
