package com.huifer.jenkinsspringboot.util;

import com.huifer.jenkinsspringboot.entity.rescuetime.DailySummaryFeedRest;

import java.io.IOException;
import java.lang.reflect.Field;

public class GenerateSqlMapperUtil {
    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        generateSqlMapper(DailySummaryFeedRest.class, null);

    }

    public static void generateSqlMapper(Class obj,String tableName) throws IOException{
        Field[] fields = obj.getDeclaredFields();
        String param = null;
        String cameCaseColumn = null;
        String underScoreCaseColumn = null;
        StringBuilder sql = new StringBuilder();
        if(tableName==null||tableName.equals("")){
            tableName = obj.getName().substring(obj.getName().lastIndexOf(".")+1);
        }

        sql.append("drop table if exists ").append(tableName).append(";\r\n");
        sql.append("create table ").append(tableName).append("( \r\n");
        boolean firstId = true;
        for(Field f : fields){
            cameCaseColumn = f.getName();
            underScoreCaseColumn = cameCaseColumn;
            for(int i = 0; i < cameCaseColumn.length(); i++)
                if(Character.isUpperCase(cameCaseColumn.charAt(i)))
                    // 将javabean中小驼峰命名变量的“大写字母”转换为“_小写字母”
                    underScoreCaseColumn = cameCaseColumn.substring(0, i) + '_' + cameCaseColumn.substring(i, i+1).toLowerCase() + cameCaseColumn.substring(i+1, cameCaseColumn.length());
            sql.append(underScoreCaseColumn).append(" ");
            param = f.getType().getTypeName();
            if(param.equals("java.lang.Integer")){
                sql.append("INTEGER");
            }else if(param.equals("java.math.BigDecimal")){
                sql.append("decimal(10, 0)");
            }else if(param.equals("java.util.Date")){
                sql.append("datetime(0)");
            }else{
                // 根据需要自行修改
                sql.append("VARCHAR(255)");
            }
            if(firstId){
                // 默认第一个字段为ID主键
                sql.append(" PRIMARY KEY AUTO_INCREMENT");
                firstId = false;
            }
            sql.append(",\n");
        }
        sql.delete(sql.lastIndexOf(","), sql.length()).append("\n)ENGINE=INNODB DEFAULT CHARSET=UTF8 AUTO_INCREMENT=1;\r\n");
        System.out.println(sql);

    }
}