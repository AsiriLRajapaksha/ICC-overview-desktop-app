import java.sql.*;

public  class DBconnection {
    public static Connection connect(){

        Connection con = null;

        try{

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cricket","root","");


            return con;

        }catch(ClassNotFoundException | SQLException e){

            System.out.println(e);

        }
        return null;
    }

}
