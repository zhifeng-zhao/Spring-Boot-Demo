package com.zzf.demomybatisplus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zzf.demomybatisplus.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zzf
 * @date 2021/3/20 11:40 下午
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
