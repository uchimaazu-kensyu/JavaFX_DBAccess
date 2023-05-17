package DBClass;

import com.example.javafxtest2.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsersDao{
    final private Connection connection;
    static List<User> userList = new ArrayList<User>();


    public UsersDao(Connection connection){
        this.connection =connection;
    }

    public List<User> findAll(){
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users");) {

            // SQL実行
            ResultSet rs = stmt.executeQuery();

            // 結果の取得
            while (rs.next()) {
                var id = rs.getInt("id");
                var company = rs.getString("company");
                var name = rs.getString("name");
                var score = rs.getInt("score");

                User user = new User(company,name,score);
                userList.add(user);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }


}
