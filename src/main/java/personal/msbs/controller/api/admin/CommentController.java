package personal.msbs.controller.api.admin;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.msbs.response.Result;
import personal.msbs.service.CommentService;

/**
 * @author ling
 */
@RestController
@RequestMapping("/api/admin/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    /**
     * 获取所有评论
     * @return 按时间先后倒序返回评论列表
     */
    @GetMapping("/all")
    public Result allComment(){
        return Result.ofSuccess(commentService.getAllComment());
    }
}
