/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.Model;

import es.Utilities.DBHelper;
import java.sql.Connection;
import java.sql.Date;
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
public class reportDAO {
    private List<reportDTO> reports;

    public List<reportDTO> getReports() {
        return reports;
    }

    public void showReportInfo() throws NamingException, SQLException {
        Connection con = null;
        PreparedStatement stm = null;
        ResultSet rs = null;
        try {
            con = DBHelper.createConnection();
            String sql = "select r.name, r.createdDate, p.personName from Report r\n"
                    + "join Person p on p.ID = r.personID";
            stm = con.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                String reportName = rs.getNString("name");
                Date createdDate = rs.getDate("createdDate");
                String personName = rs.getNString("personName");
                reportDTO dto = new reportDTO(reportName, createdDate, personName);
                if(this.reports == null){
                    this.reports = new ArrayList<>();
                }
                this.reports.add(dto);
            }
        } finally {
            if(rs != null){
                rs.close();
            }
            if(stm != null){
                stm.close();
            }
            if(con != null){
                con.close();
            }
        }
    }
}
