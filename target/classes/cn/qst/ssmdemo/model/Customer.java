package cn.qst.ssmdemo.model;

import org.springframework.format.annotation.DateTimeFormat;
import sun.awt.SunHints;

import java.util.Date;

public class Customer {
    private Integer customerId;

    private String customerName;

    private String customerPass;

    private String customerSex;

    private Integer customerAge;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPass() {
        return customerPass;
    }

    public void setCustomerPass(String customerPass) {
        this.customerPass = customerPass;
    }

    public String getCustomerSex() {
        return customerSex;
    }

    public void setCustomerSex(String customerSex) {
        this.customerSex = customerSex;
    }

    public Integer getCustomerAge() {
        return customerAge;
    }

    public void setCustomerAge(Integer customerAge) {
        this.customerAge = customerAge;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", customerPass='" + customerPass + '\'' +
                ", customerSex='" + customerSex + '\'' +
                ", customerAge=" + customerAge +
                ", date=" + date +
                '}';
    }

    public Customer() {
    }
}