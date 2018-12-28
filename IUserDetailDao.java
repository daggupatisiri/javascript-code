
package dao;

import java.sql.Connection;
import model.UserDetail;
import java.util.*;

public interface IUserDetailDao {
    Connection getConnection();
    int save(UserDetail user);
    //int update(UserDetail user);
    //int delete(String username);
    //UserDetail getUserByUserName(String username);
    List<UserDetail> getAllUser();
}
