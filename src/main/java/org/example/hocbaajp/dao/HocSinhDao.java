package org.example.hocbaajp.dao;

import org.example.hocbaajp.object.HocSinhObject;
import org.example.hocbaajp.rowmapper.HocSinhRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class HocSinhDao extends JdbcDao {
	public HocSinhObject getHocSinhByTDN(String tendangnhap) {
		String SQL = "SELECT * "
				+ "FROM hocsinh "
				+ "JOIN user "
				+ "ON hocsinh.user_tendangnhap = user.user_tendangnhap "
				+ "WHERE user.user_tendangnhap = ?";
		return getJdbcTemplate().queryForObject(SQL, new HocSinhRowMapper(), tendangnhap);
	}
}
