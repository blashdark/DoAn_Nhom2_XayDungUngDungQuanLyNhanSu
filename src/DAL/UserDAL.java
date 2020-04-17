/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import DTO.UserDTO;
import UTILS.ConnectionUtil;

public class UserDAL {

	private ConnectionUtil conUtil;
	
	private Connection con;
	
	private PreparedStatement preparedStatement;
	
	private ResultSet resultset;
	
	public ResultSet GetUserByNameNPass(UserDTO userDTO) throws ClassNotFoundException {
		ResultSet result = null;
		
		String sql = "Select * from user where username=? and password=?";
		try {
			conUtil = new ConnectionUtil();
			con = conUtil.getConnection();
			
			preparedStatement=con.prepareStatement(sql);
			preparedStatement.setString(1, (String) userDTO.getUsername());
			preparedStatement.setString(2, (String) userDTO.getPassword());
			
			result = preparedStatement.executeQuery();
			
		} catch (SQLException e) {
			e.printStackTrace();
			}
		
		finally {
			try {
				con.close();
				preparedStatement.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}

		}
			
		return result;
		
	}
	
	
}