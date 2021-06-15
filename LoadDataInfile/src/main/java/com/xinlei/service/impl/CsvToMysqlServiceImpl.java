package com.xinlei.service.impl;

import com.xinlei.entity.User;
import com.xinlei.mapper.CsvToMysqlMapper;
import com.xinlei.service.CsvToMysqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CsvToMysqlServiceImpl implements CsvToMysqlService {
    @Autowired
    private CsvToMysqlMapper csvToMysqlMapper;

    @Override
    public Integer insert(String sql) {
      return csvToMysqlMapper.insertData(sql);
    }

    @Override
    public List<User> getUser() {
        List<User> user = csvToMysqlMapper.getUser();
        return user;
    }
}
