package dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.ResultSet;

import entity.employee;

public class EmplayeeDAO {
	public List<employee> findAll(){
		List<employee> emps=new ArrayList<employee>();
		Connection conn=null;
		PreparedStatement stmt=null;
		ResultSet rs=null;
		conn=DBUtil.getConnection();
		try {
			stmt=(PreparedStatement) conn.prepareStatement("select * from t_emp");
			rs=(ResultSet) stmt.executeQuery();
			while(rs.next()){
				
				employee emp = new employee(
						rs.getInt("id"),
						rs.getString("name"),
						rs.getDouble("salary"),
						rs.getInt("age")
						);
				emps.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.close(conn);
		}
		
		
		return emps;
		
	}
	public void save(employee emp){
		Connection conn=null;
		PreparedStatement stmt=null;
		conn=DBUtil.getConnection();
		try {
			stmt=(PreparedStatement) conn.prepareStatement("insert into t_emp values(null,?,?,?)");
			stmt.setString(1, emp.getName());
			stmt.setDouble(2, emp.getSalary());
            stmt.setInt(3, emp.getAge());
            stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
            DBUtil.close(conn);
        }
		
	}
	
	public employee findById(int id) throws Exception{
        employee emp = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try{
            conn = DBUtil.getConnection();
            stmt = (PreparedStatement) conn.prepareStatement("select * from t_emp where id=?");
            stmt.setInt(1, id);
            rs = (ResultSet) stmt.executeQuery();
            if(rs.next()){
                emp = new employee(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getDouble("salary"),
                            rs.getInt("age")
                        );
            }
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }finally{
            DBUtil.close(conn);
        }
        return emp;
    }
	
	public void modify(employee emp)throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = DBUtil.getConnection();
            stmt = (PreparedStatement) conn.prepareStatement("update t_emp set name=?,salary=?,age=? where id=?");
            stmt.setString(1, emp.getName());
            stmt.setDouble(2, emp.getSalary());
            stmt.setInt(3, emp.getAge());
            stmt.setInt(4, emp.getId());
            stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }finally{
            DBUtil.close(conn);
        }
    }
	
	public void delete(int id) throws Exception{
        Connection conn = null;
        PreparedStatement stmt = null;
        try{
            conn = DBUtil.getConnection();
            stmt = (PreparedStatement) conn.prepareStatement("delete from t_emp where id=?");
            stmt.setInt(1, id);
            stmt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
            throw e;
        }finally{
            DBUtil.close(conn);
        }
    }
	
}
