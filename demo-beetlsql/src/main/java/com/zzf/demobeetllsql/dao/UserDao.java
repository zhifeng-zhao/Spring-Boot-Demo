package com.zzf.demobeetllsql.dao;

import com.zzf.demobeetllsql.domian.User;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zzf
 * @date 2021/3/21 7:28 下午
 */
@Component
public interface UserDao extends BaseMapper<User>{
    List<User> selectByUsername(String username);
}
