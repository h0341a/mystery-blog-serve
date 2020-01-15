package personal.msbs.controller.api.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.msbs.model.dto.BlogDto;
import personal.msbs.model.entity.Blog;
import personal.msbs.model.vo.BlogInfoVo;
import personal.msbs.response.ErrorCodeEnum;
import personal.msbs.response.Result;
import personal.msbs.service.BlogService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author ling
 */
@Api(tags = "管理员对博客进行编辑的api接口")
@RestController
@RequestMapping("/api/admin/")
public class BlogController {
    private final HttpServletRequest req;
    private final BlogService blogService;

    public BlogController(BlogService blogService, HttpServletRequest req) {
        this.blogService = blogService;
        this.req = req;
    }

    @ApiOperation("获取博客列表的api接口")
    @GetMapping("/blogList")
    public Result blogList() {
        List<BlogInfoVo> blogInfoVoList = blogService.getBlogList();
        return Result.ofSuccess(blogInfoVoList);
    }

    @PostMapping("/blog")
    public Result addNewBlog(BlogDto blogDto) {
        Object uid = req.getSession().getAttribute("uid");
        if (uid == null) {
            return Result.ofFail(ErrorCodeEnum.USER_NOT_LOGIN);
        }
        if (blogDto == null ||
                StringUtils.isEmpty(blogDto.getCategory()) ||
                StringUtils.isEmpty(blogDto.getContent()) ||
                StringUtils.isEmpty(blogDto.getTitle())) {
            return Result.ofFail(ErrorCodeEnum.PARAMETER_NOT_NULL);
        }
        if (blogService.addNewBlog(blogDto)) {
            return Result.ofSuccess("添加新博客成功");
        }
        return Result.ofFail(ErrorCodeEnum.BLOG_INSERT_FAIL);
    }

}
