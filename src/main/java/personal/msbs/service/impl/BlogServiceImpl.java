package personal.msbs.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import personal.msbs.dao.BlogDAO;
import personal.msbs.dao.CategoryDAO;
import personal.msbs.dao.CommentDAO;
import personal.msbs.model.dto.BlogDto;
import personal.msbs.model.dto.CommentDto;
import personal.msbs.model.entity.Blog;
import personal.msbs.model.entity.Category;
import personal.msbs.model.entity.Comment;
import personal.msbs.model.vo.BlogInfoVo;
import personal.msbs.model.vo.CategoryVo;
import personal.msbs.service.BlogService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ling
 */
@Service
public class BlogServiceImpl implements BlogService {
    private final BlogDAO blogDao;
    private final CategoryDAO categoryDAO;
    private final CommentDAO commentDAO;

    public BlogServiceImpl(BlogDAO blogDao, CategoryDAO categoryDAO, CommentDAO commentDAO) {
        this.blogDao = blogDao;
        this.categoryDAO = categoryDAO;
        this.commentDAO = commentDAO;
    }

    @Override
    public boolean alterBlog(int bid, BlogDto blogDto) {
        //根据博客id查询原有的博客信息
        Blog blog = blogDao.selectById(bid);
        if (blog == null) {
            return false;
        }
        //将可能会被修改的值赋值到博客对象中
        if (blogDto.getTitle() != null) {
            blog.setTitle(blogDto.getTitle());
        }
        if (blogDto.getContent() != null) {
            blog.setContent(blogDto.getContent());
        }
        if (blogDto.getDescription() != null) {
            blog.setDescription(blogDto.getDescription());
        }
        //设定修改后的分类
        if (blogDto.getCategory() != null) {
            Category category = categoryDAO.selectByName(blogDto.getCategory());
            //如果该分类不存在,那就插入一个新分组
            if (category == null) {
                category = new Category();
                category.setName(blogDto.getCategory());
                categoryDAO.insert(category);
            }
            blog.setCategoryId(category.getId());
        }
        return blogDao.update(blog) == 1;
    }

    @Override
    public List<BlogInfoVo> getBlogList() {
        List<Blog> blogList = blogDao.select();
        return blogListConvertBlogVoList(blogList);
    }

    @Override
    public List<BlogInfoVo> getBlogListByCategory(String categoryName) {
        Category category = categoryDAO.selectByName(categoryName);
        if (category == null) {
            return null;
        }
        List<Blog> blogListByCategory = blogDao.selectByCategory(category.getId());
        return blogListConvertBlogVoList(blogListByCategory);
    }

    @Override
    public boolean addNewBlog(BlogDto blogDto) {
        Blog blog = blogDtoConvertBlog(blogDto);
        return blogDao.insert(blog) == 1;
    }

    @Override
    public List<String> getCategoryList() {
        return categoryDAO.select();
    }

    @Override
    public String getBlog(int bid) {
        return blogDao.selectContentById(bid);
    }

    @Override
    public Boolean addComment(CommentDto commentDto) {
        //该博客是否存在,通过博客内容是否为空来判断
        String blogContent = blogDao.selectContentById(commentDto.getBlogId());
        if (StringUtils.isEmpty(blogContent)) {
            return false;
        }
        if (commentDto.getParentCid() != 0) {
            if (commentDAO.selectByCid(commentDto.getParentCid()) == null) {
                return false;
            }
        }
        return commentDAO.insert(commentDtoConvert(commentDto)) == 1;
    }

    @Override
    public Boolean deleteBlog(int bid) {
        return blogDao.delete(bid) == 1;
    }

    /**
     * 将commentDto转换为comment
     *
     * @param commentDto 被转换对象
     * @return 转换后结果
     */
    private Comment commentDtoConvert(CommentDto commentDto) {
        Comment comment = new Comment();
        BeanUtils.copyProperties(commentDto, comment);
        return comment;
    }

    /**
     * 将blogDto对象转换为Blog对象
     *
     * @param blogDto 传入的dto对象
     * @return 转换完成的do对象
     */
    private Blog blogDtoConvertBlog(BlogDto blogDto) {
        Blog blog = new Blog();
        //取出分组名,根据分组名查询分组，为空则新建分组
        String name = blogDto.getCategory();
        Category category = categoryDAO.selectByName(name);
        if (category == null) {
            category = new Category();
            category.setName(name);
            categoryDAO.insert(category);
        }
        blog.setCategoryId(category.getId());
        //将相同的属性复制到Blog对象中
        BeanUtils.copyProperties(blogDto, blog);
        return blog;
    }

    /**
     * 将博客列表转换为blogVo列表
     *
     * @param blogList 博客列表
     * @return blogVo列表
     */
    private List<BlogInfoVo> blogListConvertBlogVoList(List<Blog> blogList) {
        if (blogList == null) {
            return null;
        }
        List<BlogInfoVo> blogInfoVos = new ArrayList<>();
        for (Blog b : blogList) {
            BlogInfoVo blogInfoVo = new BlogInfoVo();
            BeanUtils.copyProperties(b, blogInfoVo);
            //根据blog中的分类id查询分类名字
            Category category = categoryDAO.selectById(b.getCategoryId());
            blogInfoVo.setCategory(category.getName());
            blogInfoVos.add(blogInfoVo);
        }
        return blogInfoVos;
    }
}
