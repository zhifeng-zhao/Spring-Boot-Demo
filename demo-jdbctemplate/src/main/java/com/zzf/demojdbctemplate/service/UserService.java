package com.zzf.demojdbctemplate.service;

import lombok.AllArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author zzf
 * @date 2021/3/14 3:15 上午
 */
@Service
@AllArgsConstructor
public class UserService {
    private final JdbcTemplate jdbcTemplate;

    public void insert(String username, String password) {
        jdbcTemplate.update("insert into t_user (username,password) values (?,?)", username, password);
    }

    public void delete(Integer id) {
        jdbcTemplate.update("delete from t_user where ?", id);
    }

    public void update(Integer id, String password) {
        jdbcTemplate.update("update t_user set password = ? where id = ?", password, id);
    }

    public Map<String, Object> query(Integer id) {
        return jdbcTemplate.queryForMap("select * from t_user where id = ?", id);
    }
}
