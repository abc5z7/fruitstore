package fruitstore.domain;

/**
 * @author: caibao
 * @date: 2020-05-08
 * @email: abcwzcb@163.com
 * @version: 1.0.0
 * @description:
 */
public class UserItem {
    private String id;
    private String username;
    private String pwd;
    public UserItem(){

    }
    public UserItem(String id, String username, String pwd) {
        super();
        this.id = id;
        this.username = username;
        this.pwd = pwd;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
