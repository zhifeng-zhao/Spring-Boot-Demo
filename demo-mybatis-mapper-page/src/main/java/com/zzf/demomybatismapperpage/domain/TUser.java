package com.zzf.demomybatismapperpage.domain;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;

/**
 * @author zzf
 * @date 2021/3/17 10:33 上午
 */
@Data
public class TUser {

    @Id
    @KeySql(useGeneratedKeys = true)
    private Integer id;

    private String username;

    private String password;
}
