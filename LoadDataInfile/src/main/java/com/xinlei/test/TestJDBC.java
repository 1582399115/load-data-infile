package com.xinlei.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJDBC {
    public static void main(String[] args) {
        Connection connection=null;
        Statement statement=null;
        String sql;
/*        String url="jdbc:mysql://127.0.0.1/loaddatainfile?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&autoReconnect=true";
        String str="LOAD DATA INFILE 'C:/ProgramData/MySQL/MySQL Server 5.7/Uploads/P_Set_Branch.txt' REPLACE INTO TABLE P_Set_Branch FIELDS TERMINATED BY ',' LINES TERMINATED BY '\n" +
                "' (`Groupno`,`Branchcode`,`ApprovalDate`) SET ApprovalDate = DATE_FORMAT(ApprovalDate,'%Y%m%d') ;";*/
        String url="jdbc:mysql://192.168.0.222:3306/ctf?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8&autoReconnect=true";
        String str="LOAD DATA INFILE '/csv/P_Set_Branch.csv' REPLACE INTO TABLE P_Set_Branch FIELDS TERMINATED BY ',' " +
                "(`Groupno`,`Branchcode`,@ApprovalDate) SET ApprovalDate = STR_TO_DATE(@ApprovalDate,'%Y%m%d %H:%i:%s')";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, "root", "123456");
//            connection = DriverManager.getConnection(url, "root", "root");
            statement = connection.createStatement();
            statement.execute(str);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
