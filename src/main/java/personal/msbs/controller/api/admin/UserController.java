package personal.msbs.controller.api.admin;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import personal.msbs.response.ErrorCodeEnum;
import personal.msbs.response.Result;
import personal.msbs.service.UserService;
import personal.msbs.utils.PasswordUtils;

import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;

/**
 * @author ling
 */
@Api(tags = "管理员用户的相关操作")
@RestController
@RequestMapping("/api/admin/user")
public class UserController {

    private final UserService userService;
    private final HttpServletRequest req;

    public UserController(UserService userService, HttpServletRequest req) {
        this.userService = userService;
        this.req = req;
    }

    @ApiOperation("用户登录接口")
    @PostMapping("/login")
    public Result login(String username, String password) throws NoSuchAlgorithmException {
        //检查参数
        if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
            return Result.ofFail(ErrorCodeEnum.PARAMETER_NOT_NULL);
        }
        //判断账号密码是否匹配,不匹配uid=0
        int uid = userService.checkUser(username, password);
        if(uid == 0){
            return Result.ofFail(ErrorCodeEnum.USER_CHECKING_FAIL);
        }
        req.getSession().setAttribute("uid", uid);
        req.getSession().setAttribute("username", username);
        return Result.ofSuccess("登录成功");
    }

    @ApiOperation("用户注销接口")
    @GetMapping("/logout")
    public Result logout(){
        //判断session是否保存了用户id
        Object uid = req.getSession().getAttribute("uid");
        if(uid == null){
            return Result.ofFail(ErrorCodeEnum.USER_NOT_LOGIN);
        }else{
            //session失效
            req.getSession().invalidate();
            return Result.ofSuccess("注销成功");
        }
    }

    @ApiOperation("验证是否登录的接口")
    @GetMapping("/isLogin")
    public Result isLogin(){
        Object uid = req.getSession().getAttribute("uid");
        if (uid == null){
            return Result.ofSuccess(false);
        }
        return Result.ofSuccess(true);
    }
}
