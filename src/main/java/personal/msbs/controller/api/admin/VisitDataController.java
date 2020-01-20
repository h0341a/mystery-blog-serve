package personal.msbs.controller.api.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.msbs.response.Result;
import personal.msbs.service.VisitDataService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ling
 */
@Api(tags = "网站访问数据接口")
@RestController
@RequestMapping("/api/admin/visitData/")
public class VisitDataController {

    private final HttpServletRequest req;
    private final VisitDataService visitDataService;

    public VisitDataController(HttpServletRequest req, VisitDataService visitDataService) {
        this.req = req;
        this.visitDataService = visitDataService;
    }

    @ApiOperation("每日数据")
    @GetMapping("/dailyData")
    public Result dailyData(){
        return Result.ofSuccess(visitDataService.getDailyVisit());
    }
    @ApiOperation("总数据")
    @GetMapping("/allData")
    public Result allData(){
        return Result.ofSuccess(visitDataService.getAllVisit());
    }

    @ApiOperation("历史七天数据")
    @GetMapping("/sevenDaysData")
    public Result sevenDaysData(){
        return Result.ofSuccess(visitDataService.getSevenDaysVisit());
    }
}
