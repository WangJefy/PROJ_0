package com.zch.repository;

import com.zch.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by chensuo on 2018-7-31.
 */
@Repository
public class UserRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public User getUserByLoginId(String loginId) {
        String sql = "SELECT ID USER_ID, USER_NAME, USER_PASSWORD, USER_LOGINID FROM ZCH_USER WHERE USER_LOGINID=?";
        List<User> userList = jdbcTemplate.query(sql, new UserRowMapper(), loginId);
        return userList.size() == 0 ? null : userList.get(0);
    }

    public User getUserByLoginIdAndPassword(String loginId, String password) {
        String sql = "SELECT ID USER_ID, USER_NAME, USER_PASSWORD, USER_LOGINID" +
                " FROM ZCH_USER" +
                " WHERE USER_LOGINID=? AND USER_PASSWORD=?";
        List<User> userList = jdbcTemplate.query(sql, new UserRowMapper(), loginId, password);
        return userList.size() == 0 ? null : userList.get(0);
    }
}

class UserRowMapper implements RowMapper<User> {
    public User mapRow(ResultSet rs, int i) throws SQLException {
        User User = new User();
        User.setUserId(rs.getInt("user_id"));
        User.setUserName(rs.getString("user_name"));
        User.setUserPassword(rs.getString("user_password"));
        User.setUserLoginId(rs.getString("user_loginid"));
        return User;
    }
}