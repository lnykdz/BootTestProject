package com.abc.dingzheng.jdbc;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BasicJdbc {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException, ClassNotFoundException, SQLException {
        //参数1
        String sql = "select id,name, countryCode,district,population from city where CountryCode=?";
        //参数2
        String[] strArray = {"AFG"};
        //参数3
        Class clazz = conn.class;
        List queryList = queryList(sql, strArray, clazz);
    }

    public static List queryList(String sql, String[] strArray, Class clazz) throws SQLException, ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Connection connection = getConnect("mysql");
        List list = new ArrayList();
        Method[] methods = clazz.getMethods();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        int len =sql.length()- sql.replace("?","").length();
        for(int i=0;i<len;i++){
            preparedStatement.setString(i+1,strArray[i]);
        }
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            Object instance = clazz.newInstance();
            for(Method method:methods){
                if(method.getName().indexOf("set")!=-1){
                    method.invoke(instance,resultSet.getString(method.getName().substring(3,4).toLowerCase()+method.getName().substring(4)));
                }
            }
            list.add(instance);
        }
        System.out.println(list);
        preparedStatement.close();
        connection.close();
        return list;
    }

    private static Connection getConnect(String database) throws ClassNotFoundException, SQLException {
        String url = "jdbc:mysql://localhost:3306/world";
        String user="root";
        String password="root";
        String drivername="com.mysql.cj.jdbc.Driver";
        Class.forName(drivername);
        return DriverManager.getConnection(url, user, password);
    }
}
