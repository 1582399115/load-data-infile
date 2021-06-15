package com.xinlei.controller;

import com.xinlei.entity.User;
import com.xinlei.service.CsvToMysqlService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Slf4j
@Api(tags = "把.csv文件信息导入到mysql中")
@RequestMapping("/test")
public class CsvToMysqlController {
    @Autowired
    private CsvToMysqlService csvToMysqlService;

    @GetMapping("/goto")
    @ResponseBody
    @ApiOperation(value = "数据导入的方法")
    @ApiResponses({@ApiResponse(code = 200, message = "请求成功"),
            @ApiResponse(code = 404, message = "Not Found，请求的资源不存在"),
            @ApiResponse(code = 500, message = "服务器出错")})
    public String csvToMysql() {
        String sql = "LOAD DATA INFILE '/csv/P_Set_Branch.csv' IGNORE INTO TABLE P_Set_Branch FIELDS TERMINATED BY ',' " +
                "(`Groupno`,`Branchcode`,@ApprovalDate) SET ApprovalDate = STR_TO_DATE(@ApprovalDate,'%Y%m%d %H:%i:%s')";
        System.out.println(sql);
        Integer i = csvToMysqlService.insert(sql);
        return "导入成功了";
    }

    @PostMapping("/user")
    @ResponseBody
    @ApiOperation(value = "查询导入数据的方法")
    public List<User> test() {
        return csvToMysqlService.getUser();
    }
}
