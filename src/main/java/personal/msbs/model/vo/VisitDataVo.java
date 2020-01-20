package personal.msbs.model.vo;

import io.swagger.models.auth.In;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author ling
 */
@Getter
@Setter
public class VisitDataVo {
    String date;
    int visits;
    int comments;
    int stars;
}
