package personal.msbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import personal.msbs.dao.VisitDataDAO;
import personal.msbs.model.vo.VisitDataVo;
import personal.msbs.service.VisitDataService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

/**
 * @author ling
 */
@Service
public class VisitDataServiceImpl implements VisitDataService {
    private final static int DATA_FOR_SEVEN_DAYS = 7;
    private final VisitDataDAO visitDataDAO;

    public VisitDataServiceImpl(VisitDataDAO visitDataDAO) {
        this.visitDataDAO = visitDataDAO;
    }

    @Override
    public VisitDataVo getDailyVisit() {
        Date date = new Date();
        SimpleDateFormat  simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String today = simpleDateFormat.format(date);
        return makeVisitDateVo(today);
    }

    @Override
    public VisitDataVo getAllVisit() {
        int visits = visitDataDAO.selectVisits();
        int comments = visitDataDAO.selectComments();
        int stars = visitDataDAO.selectStars();
        VisitDataVo visitDataVo = new VisitDataVo();
        visitDataVo.setVisits(visits);
        visitDataVo.setStars(stars);
        visitDataVo.setComments(comments);
        return visitDataVo;
    }

    @Override
    public List<VisitDataVo> getSevenDaysVisit() {
        List<VisitDataVo> visitDataVos = new ArrayList<>();
        int past = 1;
        while (past <= DATA_FOR_SEVEN_DAYS){
            String date = getPastDate(past);
            visitDataVos.add(makeVisitDateVo(date));
            past+=1;
        }
        return visitDataVos;
    }

    /**
     * 根据某日期构建访问量数据对象
     * @param date 日期
     * @return 访问量数据对象
     */
    private VisitDataVo makeVisitDateVo(String date){
        int visits = visitDataDAO.selectVisitsByOneDay(date);
        int comments = visitDataDAO.selectCommentsByOneDay(date);
        int stars = visitDataDAO.selectStarsByOneDay(date);
        VisitDataVo visitDataVo = new VisitDataVo();
        visitDataVo.setDate(date);
        visitDataVo.setVisits(visits);
        visitDataVo.setStars(stars);
        visitDataVo.setComments(comments);
        return visitDataVo;
    }
    /**
     * 利用calendar来获取前几天的日期
     * @param past 天数
     * @return 返回当天日期
     */
    private String getPastDate(int past){
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.DAY_OF_YEAR, calendar.get(Calendar.DAY_OF_YEAR) - past);
        Date day = calendar.getTime();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(day);
    }
}
