package org.example.hocbaajp.rowmapper;

import org.example.hocbaajp.object.GV_TKB_Object;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class GV_TKB_RowMapper implements RowMapper<GV_TKB_Object> {
	@Override
	public GV_TKB_Object mapRow(ResultSet rs, int rowNum) throws SQLException {
		GV_TKB_Object tkb = new GV_TKB_Object();
		tkb.setThoigian(rs.getInt("thoigian"));
		tkb.setTiethoc(rs.getInt("tiethoc"));
		tkb.setMonhoc_name(rs.getString("monhoc_name"));
		tkb.setLop_name(rs.getString("lop_name"));
		tkb.setMonhoc_id(rs.getString("monhoc_id"));
		tkb.setLop_id(rs.getString("lop_id"));
		return tkb;
	}
}
