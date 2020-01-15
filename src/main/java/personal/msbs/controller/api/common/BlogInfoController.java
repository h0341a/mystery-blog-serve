package personal.msbs.controller.api.common;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import personal.msbs.model.dto.CommentDto;
import personal.msbs.model.vo.BlogInfoVo;
import personal.msbs.model.vo.CategoryVo;
import personal.msbs.response.ErrorCodeEnum;
import personal.msbs.response.Result;
import personal.msbs.service.BlogService;

import java.io.EOFException;
import java.util.List;

/**
 * @author ling
 */
@Api(tags = "通用的且不需要任何用户权限获取博客信息的api接口")
@RestController
@RequestMapping("/api/common")
public class BlogInfoController {

    private final BlogService blogService;

    public BlogInfoController(BlogService blogService) {
        this.blogService = blogService;
    }

    @ApiOperation("获取博客分类列表")
    @GetMapping("/categoryList")
    public Result categoryList() {
        return Result.ofSuccess(blogService.getCategoryList());
    }

    @ApiOperation("获取博客列表的api接口")
    @GetMapping("/blogList")
    public Result blogList() {
        List<BlogInfoVo> blogInfoVoList = blogService.getBlogList();
        return Result.ofSuccess(blogInfoVoList);
    }

    @ApiOperation("根据分类名获取博客列表")
    @GetMapping("/blogList/{name}")
    public Result blogListByCategory(@PathVariable String name) {
        List<BlogInfoVo> blogInfoVoList = blogService.getBlogList();
        return Result.ofSuccess(blogInfoVoList);
    }

    @ApiOperation("根据博客id获取博客内容")
    @GetMapping("/blog/{bid}")
    public Result blog(@PathVariable int bid) {
        return Result.ofSuccess(blogService.getBlog(bid));
    }

    @ApiOperation("添加评论,如果是回复评论则需要传入被回复评论id")
    @PostMapping("/blog/{bid}/comment")
    public Result comment(@PathVariable int bid, CommentDto commentDto) {
        if (commentDto == null ||
                StringUtils.isEmpty(commentDto.getNickname()) ||
                StringUtils.isEmpty(commentDto.getContent())) {
            return Result.ofFail(ErrorCodeEnum.PARAMETER_NOT_NULL);
        }
        commentDto.setBlogId(bid);
        if(blogService.addComment(commentDto)){
            return Result.ofSuccess("添加新评论成功");
        }else{
            return Result.ofFail(ErrorCodeEnum.COMMENT_INSERT_FAIL);
        }
    }
}
