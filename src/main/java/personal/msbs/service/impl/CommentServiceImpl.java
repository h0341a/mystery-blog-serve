package personal.msbs.service.impl;


import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.msbs.dao.BlogDAO;
import personal.msbs.dao.CommentDAO;
import personal.msbs.model.entity.Comment;
import personal.msbs.model.vo.CommentVo;
import personal.msbs.service.CommentService;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ling
 */
@Service
public class CommentServiceImpl implements CommentService {

    private final CommentDAO commentDAO;
    private final BlogDAO blogDAO;

    public CommentServiceImpl(CommentDAO commentDAO, BlogDAO blogDAO) {
        this.commentDAO = commentDAO;
        this.blogDAO = blogDAO;
    }

    @Override
    public List<CommentVo> getAllComment() {
        List<CommentVo> commentVoList = new ArrayList<>();
        List<Comment> commentList = commentDAO.select();
        for (Comment comment: commentList){
            commentVoList.add(commentConvert(comment));
        }
        return commentVoList;
    }

    private CommentVo commentConvert(Comment comment){
        CommentVo commentVo = new CommentVo();
        commentVo.setCid(comment.getCid());
        commentVo.setContent(comment.getContent());
        commentVo.setCreateDate(comment.getCreateDate());
        commentVo.setParent(comment.getParentCid() == 0?"true":"false");
        commentVo.setBlogTitle(blogDAO.selectTitleById(comment.getBlogId()));
        return commentVo;
    }
}
