package DBClass;

import com.example.javafxtest2.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBAccess {
    UsersDao dao;
    Connection connection;


        public static void main(String[] args) {

        }

        public List<User> findAll(){

            // JDBCドライバの読み込みと接続。(DbUtilにまかす。)
            var connection = DbUtil.getConnection();
            //daoのインスタンス作成
            this.dao = new UsersDao(connection);
            //daoのfindAllを呼び出す
            var userList =dao.findAll();

            //userListをリターン。
            return userList;
        }


    }

