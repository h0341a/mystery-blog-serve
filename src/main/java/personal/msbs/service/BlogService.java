package personal.msbs.service;

import personal.msbs.model.dto.BlogDto;
import personal.msbs.model.dto.CommentDto;
import personal.msbs.model.entity.Blog;
import personal.msbs.model.entity.Category;
import personal.msbs.model.entity.Comment;
import personal.msbs.model.vo.BlogInfoVo;
import personal.msbs.model.vo.CategoryVo;

import java.util.List;

/**
 * @author ling
 */
public interface BlogService {

    /**
     * 获取博客列表
     * @return 返回博客在页面中展示所需的数据
     */
    public List<BlogInfoVo> getBlogList();
    /**
     * 根据分类名获取博客列表
     * @param categoryName 分类名字
     * @return 返回博客在页面中展示所需的数据
     */
    public List<BlogInfoVo> getBlogListByCategory(String categoryName);

    /**
     * 添加博客
     * @param blogDto 传入的博客信息
     * @return 返回是否添加成功
     */
    public boolean addNewBlog(BlogDto blogDto);

    /**
     * 获取博客分类列表
     * @return 返回分类名字列表
     */
    public List<String> getCategoryList();

    /**
     * 根据博客id获取博客内容
     * @param bid 博客id
     * @return 返回博客内容
     */
    public String getBlog(int bid);

    /**
     * 添加评论
     * @param commentDto  提交的评论信息
     * @return 返回是否添加成功
     */
    public Boolean addComment(CommentDto commentDto);

}
