package com.xinlei.service;

import com.xinlei.entity.User;

import java.util.List;

public interface CsvToMysqlService {

    Integer insert(String sql);

    List<User> getUser();


}
