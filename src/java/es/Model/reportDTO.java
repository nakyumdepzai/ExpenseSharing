/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package es.Model;

import java.sql.Date;
/**
 *
 * @author nakyumdepzaii
 */
public class reportDTO {
    private String reportName;
    private Date createdDate;
    private String personName;

    public reportDTO() {
    }

    public reportDTO(String reportName, Date createdDate, String personName) {
        this.reportName = reportName;
        this.createdDate = createdDate;
        this.personName = personName;
    }

    public String getReportName() {
        return reportName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public String getPersonName() {
        return personName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }
    
    
    
}
