package personal.msbs.service;

import personal.msbs.model.dto.BlogDto;
import personal.msbs.model.entity.Blog;
import personal.msbs.model.vo.BlogInfoVo;

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
     * 添加博客
     * @param blogDto 传入的博客信息
     * @return 返回是否添加成功
     */
    public boolean addNewBlog(BlogDto blogDto);

}
