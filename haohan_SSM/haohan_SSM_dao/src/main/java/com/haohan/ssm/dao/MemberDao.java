package com.haohan.ssm.dao;

import com.haohan.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

public interface MemberDao {
    @Select("select * from member where id = #{memberId}")
    Member findById(String memberId);
}
