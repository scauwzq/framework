package com.wzq.dao;

import com.wzq.model.Role;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface RoleMapper {
    @Delete({
        "delete from role",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into role (id, role_name, ",
        "is_del, main_url)",
        "values (#{id,jdbcType=BIGINT}, #{roleName,jdbcType=VARCHAR}, ",
        "#{isDel,jdbcType=BIT}, #{mainUrl,jdbcType=VARCHAR})"
    })
    int insert(Role record);

    @InsertProvider(type=RoleSqlProvider.class, method="insertSelective")
    int insertSelective(Role record);

    @Select({
        "select",
        "id, role_name, is_del, main_url",
        "from role",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.BIT),
        @Result(column="main_url", property="mainUrl", jdbcType=JdbcType.VARCHAR)
    })
    Role selectByPrimaryKey(Long id);

    @UpdateProvider(type=RoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Role record);

    @Update({
        "update role",
        "set role_name = #{roleName,jdbcType=VARCHAR},",
          "is_del = #{isDel,jdbcType=BIT},",
          "main_url = #{mainUrl,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(Role record);
}