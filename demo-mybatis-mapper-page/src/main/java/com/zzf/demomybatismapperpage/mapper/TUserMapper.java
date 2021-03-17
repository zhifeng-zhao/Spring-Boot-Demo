package com.zzf.demomybatismapperpage.mapper;

import com.zzf.demomybatismapperpage.domain.TUser;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

/**
 * @author zzf
 * @date 2021/3/17 10:34 上午
 */
@Mapper
public interface TUserMapper extends BaseMapper<TUser> {

}
