package dto;/*
Author-:dilus
Date:-28/12/2021
*/

import Entity.Student;

public class StudentDTO {
    private String st_id;
    private String name;
    private String address;
    private String telephone;

    public StudentDTO() {
    }

    public StudentDTO(String st_id, String name, String address, String telephone) {
        this.st_id = st_id;
        this.name = name;
        this.address = address;
        this.telephone = telephone;
    }

    public String getSt_id() {
        return st_id;
    }

    public void setSt_id(String st_id) {
        this.st_id = st_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "st_id='" + st_id + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
