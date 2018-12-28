
package dao;

import java.sql.Connection;
import java.util.List;
import model.UserDetail;
import java.sql.*;
import java.util.ArrayList;
import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.sql.DataSource;

public class UserDetailDaoImpl implements IUserDetailDao{

    @Override
    public  Connection getConnection() {
        Context context=null;
        Connection connection=null;
        try{
           // context=new InitialContext();
           // DataSource ds=(DataSource)context.lookup("jdbc:mysql://localhost:3306/jspdb");
           // connection=ds.getConnection();
           
           Class.forName("com.mysql.jdbc.Driver");
           connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/jspdb","root","root");
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return connection;
    }

    @Override
    public int save(UserDetail user) {
        int status=0;
        try{
            Connection con= getConnection();
            PreparedStatement pst=con.prepareStatement("insert into userdetail values(?,?,?,?,?,?)");
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());
            pst.setString(3, user.getFullname());
            pst.setString(4, user.getEmail());
            pst.setString(5, user.getAddress());
            pst.setString(6, user.getRole());
            
            status=pst.executeUpdate();
            con.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return status;
    }
/*
    @Override
    public int update(UserDetail user) {
         int status=0;
        try{
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return status;
    }

    @Override
    public int delete(String username) {
         int status=0;
        try{
            
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return status;
    }

    @Override
    public UserDetail getUserByUserName(String username) {
        
    }
*/
    @Override
    public List<UserDetail> getAllUser() {
        List<UserDetail> list=new ArrayList<UserDetail>();
        
        try{
            Connection con=getConnection();
            PreparedStatement pst=con.prepareStatement("select * from UserDetail");
            ResultSet rst=pst.executeQuery();
            while(rst.next()){
                UserDetail user=new UserDetail();
                user.setUsername(rst.getString(1));
                user.setPassword(rst.getString(2));
                user.setFullname(rst.getString(3));
                user.setEmail(rst.getString(4));
                user.setAddress(rst.getString(5));
                user.setRole(rst.getString(6));
                list.add(user);
                
            }
            con.close();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return list;
    }
   
}
