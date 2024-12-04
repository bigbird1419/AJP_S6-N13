package org.example.hocbaajp.dao;

import org.example.hocbaajp.object.UserObject;
import org.example.hocbaajp.rowmapper.UserRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends JdbcDao {
    public UserObject getUserByTendangnhap(String user_tendangnhap) {
        String SQL = "SELECT * FROM user WHERE user_tendangnhap = ?";
        return getJdbcTemplate().queryForObject(SQL, new UserRowMapper(), user_tendangnhap);
    }
}
