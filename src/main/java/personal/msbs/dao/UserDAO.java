package personal.msbs.dao;

import org.springframework.stereotype.Repository;
import personal.msbs.model.entity.User;

/**
 * @author ling
 */
@Repository
public interface UserDAO {

    /**
     * 插入新用户
     *
     * @param newUser 新用户信息
     * @return 影响的sql条数
     */
    public int insert(User newUser);

    /**
     * 根据用户名获取用户信息
     *
     * @param username 用户名
     * @return 用户信息
     */
    public User selectByName(String username);

    /**
     * 根据用户id获取用户信息
     *
     * @param id 用户id
     * @return 用户信息
     */
    public User selectById(int id);

    /**
     * 根据用户名删除用户
     *
     * @param username 用户名
     * @return 影响的sql条数
     */
    public int deleteByName(String username);
}
