package personal.msbs;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import personal.msbs.dao.UserDAO;
import personal.msbs.model.entity.User;
import personal.msbs.service.UserService;
import personal.msbs.utils.PasswordUtils;
import java.security.NoSuchAlgorithmException;

@RunWith(SpringRunner.class)
@SpringBootTest()
public class UserDAOTest {

    @Autowired
    UserDAO userDAO;

    @Test
    @Rollback
    public void insertTest() throws NoSuchAlgorithmException {
        User user = new User("admin", PasswordUtils.toMd5Code("admin"));
        userDAO.insert(user);
    }

}
