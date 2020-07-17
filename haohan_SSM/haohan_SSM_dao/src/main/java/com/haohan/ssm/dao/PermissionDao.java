package com.haohan.ssm.dao;

import com.haohan.ssm.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PermissionDao {
    @Select("select * from permission where id in (select permissionId from ROLE_PERMISSION where roleId = #{id})")
    List<Permission> findByRoleId(String id) throws Exception;

    @Select("select * from permission where id not in (select permissionId from ROLE_PERMISSION where roleId = #{id})")
    List<Permission> findByRoleIdNo(String id) throws Exception;

    @Select("select * from permission")
    List<Permission> findAll();

    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;

    @Insert("insert into role_permission(permissionId,roleId) values(#{param2},#{param1})")
    void saveRolePermission(String roleId, String permissionId);

    @Delete("delete from role_permission where permissionId = #{id}")
    void deleteByPermissionIdFromRolePermission(String id);

    @Delete("delete from permission where id = #{id}")
    void deleteByIdFromPermission(String id);
}
