package personal.msbs.dao;

import org.springframework.stereotype.Repository;

import java.util.Date;

/**
 * @author ling
 */
@Repository
public interface VisitDataDAO {
    /**
     * 统计查询某一天的访问量
     * @param date 日期
     * @return 访问量
     */
    public int selectVisitsByOneDay(String date);
    public int selectVisits();
    /**
     * 查询某一天的评论数
     * @param date 日期
     * @return 评论数
     */
    public int selectCommentsByOneDay(String date);
    public int selectComments();
    /**
     * 查询某一天的点赞数
     * @param date 日期
     * @return 点赞数
     */
    public int selectStarsByOneDay(String date);
    public int selectStars();
}
