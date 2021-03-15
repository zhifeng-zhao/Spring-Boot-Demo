package com.zzf.demojpa.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author zzf
 * @date 2021/3/15 3:46 下午
 */
@Entity
@Data
@Table(name = "t_user")
public class SysUser {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String username;

    private String password;
}
