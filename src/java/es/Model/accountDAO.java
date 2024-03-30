/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.Model;

import es.Utilities.DBHelper;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.naming.NamingException;

/**
 *
 * @author nakyumdepzaii
 */
public class accountDAO {

    private List<accountDTO> accounts;

    public List<accountDTO> getAccounts() {
        return accounts;
    }

    public void searchAccount(String searchValue) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            //1. create connect
            con = DBHelper.createConnection();
            if (con != null) { //connection is available
                //2. connect sql string
                String sql = "Select ID, username, password, role From Account Where username Like ?";
                //3. create statement obj
                stm = con.prepareStatement(sql);
                stm.setString(1, "%" + searchValue + "%");
                //4. execute query
                rs = stm.executeQuery();
                //5. process
                //1 dong if nhieu dong while username la primary key
                while (rs.next()) {
                    //5.1 get data from rs
                    int ID = rs.getInt("ID");
                    String username = rs.getNString("username");
                    String password = rs.getNString("password");
                    int role = rs.getInt("role");
                    //5.2 set data into dto
                    accountDTO dto = new accountDTO(ID, username, password, role);
                    //5.3 add dto into list
                    if (this.accounts == null) {
                        this.accounts = new ArrayList<>();
                    }//end account is not existed
                    this.accounts.add(dto);
                }//end traverse rs to get all row               
            }//connection is available
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (stm != null) {
                stm.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }
}
