package empapp;

import java.sql.Connection; // sql connection lib
import java.sql.PreparedStatement; // sql prepared statement
import java.sql.ResultSet; // represent the result set of sql statement
import java.sql.Statement; // execute SQL statements against a database

public class EmployeeDaoImpl implements EmployeeDaoIntrf{ // implements for interface
    Connection con; // refer to sql connection

    @Override
    public void createEmployee(Employee emp) {
        con =DBConnection.createDBConnetion();
        String query="insert into employee values(?,?,?,?)"; // employee table k andr value insert
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,emp.getId());
            pstm.setString(2,emp.getName());
            pstm.setDouble(3,emp.getSalary());
            pstm.setInt(4,emp.getAge()); // executing a update func in sql
            int cnt= pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Employee Inserted Successfully !!!");


        }catch (Exception ex){
            ex.printStackTrace(); //execption handling use hui h
        }

    }

    @Override
    public void showAllEmployee() {
        con=DBConnection.createDBConnetion();
        String query="select * from employee"; // defining sql query
        System.out.println("Employee Details :");
        System.out.println("---------------------------------------------");

        System.out.format("%s\t%s\t%s\t%s\n","ID","Name","Salary","age");
        System.out.println("---------------------------------------------");
        // execute query and displaying results
        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
                System.out.println("---------------------------------------------");

            }

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void showEmployeeBasedOnID(int id) {
        con=DBConnection.createDBConnetion();
        String query="select * from employee where id="+id; // sql query with id parameter
        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while (result.next()){
                System.out.format("%d\t%s\t%f\t%d\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getDouble(3),
                        result.getInt(4));
            }
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void updateEmployee(int id, String name) {
        con=DBConnection.createDBConnetion();
        String query="update employee set name=? where id=?"; // query updates name col in employee table
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setString(1,name);
            pstm.setInt(2,id);
            int cnt=pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Employee Details updated successfully !!");

        }catch (Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void deleteEmployee(int id) {
        con=DBConnection.createDBConnetion();
        String query="delete from employee where id=?"; // deletes the row where id matches with the input
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,id);
            int cnt= pstm.executeUpdate();
            if(cnt!=0)
                System.out.println("Employee Deleted Successfully!!! "+id);

        }catch (Exception ex){
            ex.printStackTrace();
        }


    }
}