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
    private List<User> userList = new ArrayList<User>();


    public UsersDao(Connection connection){
        this.connection =connection;
    }

    public List<User> findAll(){
        userList.clear();
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users ORDER BY id");) {

            // SQL実行
            ResultSet rs = stmt.executeQuery();

            // 結果の取得
            while (rs.next()) {
                int id = rs.getInt("id");
                var company = rs.getString("company");
                var name = rs.getString("name");
                var score = rs.getInt("score");

                User user = new User(id,company,name,score);
                userList.add(user);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }


    public int insert(String company, String name, int score){
        int rs =0;
        try (PreparedStatement stmt = connection.prepareStatement("INSERT INTO users (company,name,score) VALUES (?,?,?)");) {

            stmt.setString(1,company);
            stmt.setString(2,name);
            stmt.setInt(3,score);
            // SQL実行と件数をリターン。
            rs = stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }

    public int update(int id,String company, String name, int score){
        int rs =0;
        try (PreparedStatement stmt = connection.prepareStatement("UPDATE users SET company =?, name =?,score=? WHERE id = ?");) {

            stmt.setString(1,company);
            stmt.setString(2,name);
            stmt.setInt(3,score);
            stmt.setInt(4,id);

            // SQL実行と件数をリターン。
            rs = stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }



    public int delete(int id){
        int rs =0;
        try (PreparedStatement stmt = connection.prepareStatement("DELETE FROM users WHERE id = ?;")) {

            stmt.setInt(1,id);

            // SQL実行と件数をリターン。
            rs = stmt.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rs;
    }


    public List<User> findByName(String inputName){
        List<User> result  =new ArrayList<User>();
        try (PreparedStatement stmt = connection.prepareStatement("SELECT * FROM users WHERE name LIKE '%"+inputName+"%' ORDER BY id;")) {


            // SQL実行
            ResultSet rs = stmt.executeQuery();

            // 結果の取得
            while (rs.next()) {
                int id = rs.getInt("id");
                var company = rs.getString("company");
                var name = rs.getString("name");
                var score = rs.getInt("score");

                User user = new User(id,company,name,score);
                System.out.println(user.getId()+user.getName()+ user.getAffiliation()+ user.getScore());
                result.add(user);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }


}
