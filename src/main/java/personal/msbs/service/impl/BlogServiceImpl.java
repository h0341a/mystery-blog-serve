package personal.msbs.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.msbs.dao.BlogDAO;
import personal.msbs.dao.CategoryDAO;
import personal.msbs.model.dto.BlogDto;
import personal.msbs.model.entity.Blog;
import personal.msbs.model.entity.Category;
import personal.msbs.model.vo.BlogInfoVo;
import personal.msbs.service.BlogService;

import java.util.List;

/**
 * @author ling
 */
@Service
public class BlogServiceImpl implements BlogService {
    private final BlogDAO blogDao;
    private final CategoryDAO categoryDAO;
    public BlogServiceImpl(BlogDAO blogDao, CategoryDAO categoryDAO) {
        this.blogDao = blogDao;
        this.categoryDAO = categoryDAO;
    }

    @Override
    public List<BlogInfoVo> getBlogList() {
        return null;
    }

    @Override
    public boolean addNewBlog(BlogDto blogDto) {
        Blog blog = blogDtoConvertBlog(blogDto);
        return blogDao.insert(blog) == 1;
    }

    /**
     * 将blogDto对象转换为Blog对象
     * @param blogDto 传入的dto对象
     * @return 转换完成的do对象
     */
    private Blog blogDtoConvertBlog(BlogDto blogDto){
        Blog blog = new Blog();
        //取出分组名,根据分组名查询分组，为空则新建分组
        String name = blogDto.getCategory();
        Category category = categoryDAO.selectByName(name);
        if (category == null){
            category = new Category();
            category.setName(name);
            categoryDAO.insert(category);
        }
        blog.setCategoryId(category.getId());
        //将相同的属性复制到Blog对象中
        BeanUtils.copyProperties(blogDto, blog);
        System.out.println(blog);
        return blog;
    }
}
