package com.zzf.demobeetl.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author zzf
 * @date 2021/3/12 11:13 下午
 */
@Data
@AllArgsConstructor
public class User {

    private String name;

    private String password;

    public User(String name) {
        this.name = name;
    }
}
