package com.zch.entity;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by chensuo on 2018-7-31.
 */
public class Authority {

    private int authorityId;
    private String authorityName;
    private String authorityEntrance;
    private String authorityEntranceDesc;

    public int getAuthorityId() {
        return authorityId;
    }

    public void setAuthorityId(int authorityId) {
        this.authorityId = authorityId;
    }

    public String getAuthorityName() {
        return authorityName;
    }

    public void setAuthorityName(String authorityName) {
        this.authorityName = authorityName;
    }

    public String getAuthorityEntrance() {
        return authorityEntrance;
    }

    public void setAuthorityEntrance(String authorityEntrance) {
        this.authorityEntrance = authorityEntrance;
    }

    public String getAuthorityEntranceDesc() {
        return authorityEntranceDesc;
    }

    public void setAuthorityEntranceDesc(String authorityEntranceDesc) {
        this.authorityEntranceDesc = authorityEntranceDesc;
    }
}
