package personal.msbs.model.entity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author ling
 */
@Getter
@Setter
public class User {
    private int uid;
    private String username;
    private String password;

    public User(int uid, String username, String password) {
        this.uid = uid;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User() {
    }
}
