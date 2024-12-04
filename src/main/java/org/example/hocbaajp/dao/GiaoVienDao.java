package org.example.hocbaajp.dao;

import org.example.hocbaajp.object.GiaoVienObject;
import org.example.hocbaajp.rowmapper.GiaoVienRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class GiaoVienDao extends JdbcDao {
	public GiaoVienObject getGiaoVienByTDN(String tendangnhap) {
		String SQL = "SELECT * "
				+ "FROM giaovien "
				+ "JOIN user "
				+ "ON giaovien.user_tendangnhap = user.user_tendangnhap "
				+ "WHERE user.user_tendangnhap = ? ";
		
		return getJdbcTemplate().queryForObject(SQL, new GiaoVienRowMapper(), tendangnhap);
	}
}
