package DBClass;

import com.example.javafxtest2.User;

import java.sql.*;
import java.util.List;

public class UserService {
    UsersDao dao;
    Connection connection;





        public List<User> findAll(){

            // JDBCドライバの読み込みと接続。(DbUtilにまかす。)
            var connection = DbUtil.getConnection();
            //daoのインスタンス作成
            this.dao = new UsersDao(connection);
            //daoのfindAllを呼び出す
            var userList =dao.findAll();

            //接続クローズ。
            try {
                connection.close();
            }catch (RuntimeException | SQLException e){
                e.printStackTrace();
            }

            //userListをリターン。
            return userList;
        }

    public int insert(String company,String name,int score){

        // JDBCドライバの読み込みと接続。(DbUtilにまかす。)
        var connection = DbUtil.getConnection();
        //daoのインスタンス作成
        this.dao = new UsersDao(connection);
        //daoのfindAllを呼び出す
        int result = dao.insert(company,name,score);

        //接続クローズ。
        try {
            connection.close();
        }catch (RuntimeException | SQLException e){
            e.printStackTrace();
        }

        //userListをリターン。
        return result;
    }

    public int delete(int id){

        // JDBCドライバの読み込みと接続。(DbUtilにまかす。)
        var connection = DbUtil.getConnection();
        //daoのインスタンス作成
        this.dao = new UsersDao(connection);
        //daoのfindAllを呼び出す
        int result = dao.delete(id);

        //接続クローズ。
        try {
            connection.close();
        }catch (RuntimeException | SQLException e){
            e.printStackTrace();
        }

        //userListをリターン。
        return result;
    }
    public int update(int id,String company,String name, int score){

        // JDBCドライバの読み込みと接続。(DbUtilにまかす。)
        var connection = DbUtil.getConnection();
        //daoのインスタンス作成
        this.dao = new UsersDao(connection);
        //daoのfindAllを呼び出す
        int result = dao.update(id,company,name,score);

        //接続クローズ。
        try {
            connection.close();
        }catch (RuntimeException | SQLException e){
            e.printStackTrace();
        }

        //userListをリターン。
        return result;
    }

    public List<User> findByName(String name){

        // JDBCドライバの読み込みと接続。(DbUtilにまかす。)
        var connection = DbUtil.getConnection();
        //daoのインスタンス作成
        this.dao = new UsersDao(connection);
        //daoのfindAllを呼び出す
        List<User> result = dao.findByName(name);

        //接続クローズ。
        try {
            connection.close();
        }catch (RuntimeException | SQLException e){
            e.printStackTrace();
        }

        //userListをリターン。
        return result;
    }



    }

