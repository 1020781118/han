package com.haohan.ssm.dao;

import com.haohan.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface RoleDao {
    @Select("select * from role where id in (select roleId from users_role where userId = #{userId})")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = java.util.List.class,
            many = @Many(select = "com.haohan.ssm.dao.PermissionDao.findByRoleId"))
    })
    List<Role> findByUserId(String userId) throws Exception;

    @Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = java.util.List.class,
                    many = @Many(select = "com.haohan.ssm.dao.PermissionDao.findByRoleId"))
    })
    Role findById(String id) throws Exception;

    @Select("select * from role where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = java.util.List.class,
                    many = @Many(select = "com.haohan.ssm.dao.PermissionDao.findByRoleIdNo"))
    })
    Role findByIdNo(String id) throws Exception;

    @Delete("delete from role where id = #{id}")
    void deleteByRoleIdFromRole(String id);

    @Delete("delete from role_permission where roleId = #{id}")
    void deleteByRoleIdFromRolePermission(String id);

    @Delete("delete from users_role where roleId = #{id}")
    void deleteByRoleIdFromUsersRole(String id);
}
