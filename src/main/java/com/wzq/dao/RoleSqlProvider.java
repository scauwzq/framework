package com.wzq.dao;

import static org.apache.ibatis.jdbc.SqlBuilder.BEGIN;
import static org.apache.ibatis.jdbc.SqlBuilder.INSERT_INTO;
import static org.apache.ibatis.jdbc.SqlBuilder.SET;
import static org.apache.ibatis.jdbc.SqlBuilder.SQL;
import static org.apache.ibatis.jdbc.SqlBuilder.UPDATE;
import static org.apache.ibatis.jdbc.SqlBuilder.VALUES;
import static org.apache.ibatis.jdbc.SqlBuilder.WHERE;

import com.wzq.model.Role;

public class RoleSqlProvider {

    public String insertSelective(Role record) {
        BEGIN();
        INSERT_INTO("role");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=BIGINT}");
        }
        
        if (record.getRoleName() != null) {
            VALUES("role_name", "#{roleName,jdbcType=VARCHAR}");
        }
        
        if (record.getIsDel() != null) {
            VALUES("is_del", "#{isDel,jdbcType=BIT}");
        }
        
        if (record.getMainUrl() != null) {
            VALUES("main_url", "#{mainUrl,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(Role record) {
        BEGIN();
        UPDATE("role");
        
        if (record.getRoleName() != null) {
            SET("role_name = #{roleName,jdbcType=VARCHAR}");
        }
        
        if (record.getIsDel() != null) {
            SET("is_del = #{isDel,jdbcType=BIT}");
        }
        
        if (record.getMainUrl() != null) {
            SET("main_url = #{mainUrl,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=BIGINT}");
        
        return SQL();
    }
}