package com.zzf.demomybatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (TUser)实体类
 *
 * @author makejava
 * @since 2021-03-16 14:15:25
 */
@Data
public class TUser implements Serializable {
    private static final long serialVersionUID = 870293961590498507L;

    private Integer id;

    private String username;

    private String password;

}