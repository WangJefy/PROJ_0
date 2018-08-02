package com.zch.repository;

import com.zch.entity.Authority;
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
public class AuthorityRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    public List<Authority> getAllAuthorityList() {
        String sql = "SELECT ZA.ID AUTHORITY_ID," +
                " ZA.AUTHORITY_NAME AUTHORITY_NAME," +
                " ZAE.AUTHORITY_ENTRANCE AUTHORITY_ENTRANCE," +
                " ZAE.AUTHORITY_ENTRANCE_DESC AUTHORITY_ENTRANCE_NAME" +
                " FROM ZCH_AUTHORITY ZA, ZCH_AUTHORITY_ENTRANCE ZAE" +
                " WHERE ZA.AUTHORITY_ENTRANCE_ID=ZAE.ID";
        List<Authority> authorityList = jdbcTemplate.query(sql, new AuthorityRowMapper());
        return authorityList;
    }
}

class AuthorityRowMapper implements RowMapper<Authority> {
    public Authority mapRow(ResultSet rs, int i) throws SQLException {
        Authority authority = new Authority();
        authority.setAuthorityId(rs.getInt("authority_id"));
        authority.setAuthorityName(rs.getString("authority_name"));
        authority.setAuthorityEntrance(rs.getString("authority_entrance"));
        authority.setAuthorityEntranceDesc(rs.getString("authority_entrance_name"));
        return authority;
    }
}