package personal.msbs.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author ling
 */
public class PasswordUtils {

    /**
     * 将用户输入的密码转换为32位的md5字符串
     * @param password 输入的密码
     * @return 返回32位MD5Code
     * @throws NoSuchAlgorithmException 可能出现的异常
     */
    public static String toMd5Code(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        return new BigInteger(1, md.digest()).toString(16);
    }

}
