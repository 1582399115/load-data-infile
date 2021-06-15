package com.xinlei.mapper;

import com.xinlei.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CsvToMysqlMapper {

    Integer insertData(@Param("sql") String sql);

    List<User> getUser();

}
