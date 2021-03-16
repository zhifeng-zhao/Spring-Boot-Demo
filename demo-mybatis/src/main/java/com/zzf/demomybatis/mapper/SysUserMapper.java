package com.zzf.demomybatis.mapper;

import com.zzf.demomybatis.domain.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author zzf
 * @date 2021/3/16 1:26 上午
 */
@Mapper
public interface SysUserMapper {

    List<SysUser> queryAll();

    Integer saveSysUser(@Param("user") SysUser user);
}
