package personal.msbs.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import personal.msbs.dao.UserDAO;
import personal.msbs.model.entity.User;
import personal.msbs.service.UserService;
import personal.msbs.utils.PasswordUtils;

import java.security.NoSuchAlgorithmException;

/**
 * @author ling
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserDAO userDAO;

    public UserServiceImpl(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public int checkUser(String username, String password) throws NoSuchAlgorithmException {
        password = PasswordUtils.toMd5Code(password);
        User user = userDAO.selectByName(username);
        if (user == null){
            return 0;
        }else {
            if (password.equals(user.getPassword())){
                return user.getUid();
            }
        }
        return 0;
    }
}
