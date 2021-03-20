package com.zzf.demomybatisplus.domain;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

/**
 * @author zzf
 * @date 2021/3/20 11:38 下午
 */
@Data
@TableName("t_user")
public class User extends Model<User> {

    private Integer id;

    private String username;

    private String password;
}
