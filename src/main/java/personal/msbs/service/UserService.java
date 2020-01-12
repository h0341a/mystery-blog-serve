package personal.msbs.service;


import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

/**
 * @author ling
 */
public interface UserService {

    /**
     * 验证用户的账号密码
     * @param username 账号
     * @param password 密码
     * @return 用户id
     * @throws NoSuchAlgorithmException md5加密异常
     */
    public int checkUser(String username, String password) throws NoSuchAlgorithmException;

}
