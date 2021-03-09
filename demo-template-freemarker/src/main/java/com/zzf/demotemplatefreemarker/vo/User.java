package com.zzf.demotemplatefreemarker.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author zzf
 * @date 2021/3/9 10:30 上午
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
