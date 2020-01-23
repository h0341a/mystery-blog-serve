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
     * 根据id获取博客信息
     * @param id 博客id
     * @return 返回查找到的博客对象
     */
    public Blog selectById(int id);

    /**
     * 根据主键即博客id获取博客信息
     * @param bid 博客id
     * @return 返回获取到的博客
     */
    public String selectContentById(int bid);
    /**
     * 根据分类id获取博客列表
     * @param categoryId 分类id
     * @return 获取到的blog列表
     */
    public List<Blog> selectByCategory(int categoryId);

    /**
     * 根据id查询标题
     * @param bid 博客id
     * @return 博客标题
     */
    public String selectTitleById(int bid);
    /**
     * 插入新博客
     * @param blog 博客信息
     * @return 数据库中受影响的条数
     */
    public int insert(Blog blog);

    /**
     * 根据博客id修改博客内容
     * @param blog 博客对象
     * @return 数据库中受影响的条数
     */
    public int update(Blog blog);

    /**
     * 根据博客id删除博客
     * @param bid 博客id
     * @return 数据库中受影响的条数
     */
    public int delete(int bid);
}
