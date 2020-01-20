package personal.msbs.service;

import personal.msbs.model.vo.VisitDataVo;

import java.util.List;

/**
 * @author ling
 */
public interface VisitDataService {
    /**
     * 获取每日访问数据
     * @return 存储访问量的对象
     */
    public VisitDataVo getDailyVisit();

    /**
     * 获取全部访问量
     * @return 访问量对象
     */
    public VisitDataVo getAllVisit();

    /**
     * 获取过去七天的访问量数据
     * @return 返回的数据
     */
    public List<VisitDataVo> getSevenDaysVisit();
}
