package com.zzf.ehcache.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author zzf
 * @date 2021/4/2 10:33 下午
 */
@AllArgsConstructor
@Data
@NoArgsConstructor
public class User implements Serializable {

    private static final long serialVersionUID = -4244201017812030863L;

    private long id;

    private String userName;
}
