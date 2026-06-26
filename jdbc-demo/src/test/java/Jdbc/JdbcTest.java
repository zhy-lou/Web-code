package Jdbc;

import SQL.User;
import org.junit.jupiter.api.Test;

import java.sql.*;

public class JdbcTest {

    @Test
    public void  testUpdate() throws Exception {
        //1.加载驱动
        //Class.forName("com.mysql.jdbc.Driver");

        //2.获取连接
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "Root123!@#";
        Connection connection = DriverManager.getConnection(url, username, password);

        //3.获取执行SQL语句对象
        Statement statement = connection.createStatement();

        int i = statement.executeUpdate("update user set age = 26 where id = 1");//DML

        System.out.println("SQL执行完毕影响的记录数"+i);

        //4.关闭连接
        statement.close();
        connection.close();
    }

    @Test
    public void testSelect(){
        String url = "jdbc:mysql://localhost:3306/web01";
        String username = "root";
        String password = "Root123!@#";

        Connection conn =null;
        PreparedStatement stmt =null;
        ResultSet rs = null;

        try {
            conn =DriverManager.getConnection(url, username, password);
            String sql = "SELECT id,username,password,name,age FROM user WHERE username = ?AND password = ?";

            stmt = conn.prepareStatement(sql);
            stmt.setString(1, "daqiao");
            stmt.setString(2,"123456");

            rs = stmt.executeQuery();

            while (rs.next()){
                User user = new User(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getInt("age")
                );
                System.out.println(user);
            }
        } catch (SQLException se) {
            se.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null)stmt.close();
                if (conn != null)conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
