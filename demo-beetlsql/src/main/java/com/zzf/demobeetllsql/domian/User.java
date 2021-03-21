package com.zzf.demobeetllsql.domian;

import lombok.Data;
import org.beetl.sql.core.annotatoin.Table;

/**
 * @author zzf
 * @date 2021/3/21 7:20 下午
 */
@Data
@Table(name = "t_user")
public class User {

    private Integer id;

    private String username;

    private String password;
}
