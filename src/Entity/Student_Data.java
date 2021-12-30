package Entity;/*
Author-:dilus
Date:-29/12/2021
*/

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Student_Data implements Serializable {
    @Id
    private String st_id;
    @Id
    private String p_id;
    private String reg_date;
    private String paid_amount;

    public Student_Data() {
    }

    public Student_Data(String st_id, String p_id, String reg_date, String paid_amount) {
        this.st_id = st_id;
        this.p_id = p_id;
        this.reg_date = reg_date;
        this.paid_amount = paid_amount;
    }

    public String getSt_id() {
        return st_id;
    }

    public void setSt_id(String st_id) {
        this.st_id = st_id;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getReg_date() {
        return reg_date;
    }

    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    public String getPaid_amount() {
        return paid_amount;
    }

    public void setPaid_amount(String paid_amount) {
        this.paid_amount = paid_amount;
    }
}
