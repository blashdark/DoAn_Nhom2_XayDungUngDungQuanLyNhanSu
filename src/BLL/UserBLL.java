/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.UserDAL;
import GUI.UserGUI;

/**
 *
 * @author Admin
 */

   import java.sql.ResultSet;

import DAL.UserDAL;
import DTO.UserDTO;

public class UserBLL {
	
	UserDAL userDAL;
	
	public ResultSet Login(UserDTO userDTO) throws ClassNotFoundException {
		ResultSet result = null;
		
		if(userDTO.getUsername().equals("")) {
			return result;
		}
		else if (userDTO.getPassword().equals("")) {
			return result;
		}
		else {
			userDAL=new UserDAL();
			result =userDAL.GetUserByNameNPass(userDTO);
		}
		return result;
	}
	

}
