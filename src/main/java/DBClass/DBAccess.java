package DBClass;

import com.example.javafxtest2.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBAccess {
    static List<User> userList = new ArrayList<User>();


        public static void main(String[] args) {

        }

        public static List<User> findAll(){

            // JDBCドライバの読み込みと接続。(DbUtilにまかす。)
            var con = DbUtil.getConnection();

            try (PreparedStatement stmt = con.prepareStatement("SELECT * FROM users");) {

                // SQL実行
                ResultSet rs = stmt.executeQuery();
                System.out.println("id | name | email");

                // 結果の取得
                while (rs.next()) {
                    var id = rs.getInt("id");
                    var company = rs.getString("company");
                    var name = rs.getString("name");
                    var score = rs.getInt("score");

//                    System.out.println( id +  " | " + company + " | " + name + " | " + score + " | ");


                    User user = new User(company,name,score);
                    userList.add(user);

                }


            } catch (SQLException e) {
                e.printStackTrace();
            }
            return userList;
        }


    }

