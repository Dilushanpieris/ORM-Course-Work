package dto;/*
Author-:dilus
Date:-28/12/2021
*/

import Entity.Program;

public class ProgramDTO {
    private String p_id;
    private String p_name;
    private String durarion;
    private String fee;

    public ProgramDTO() {
    }

    public ProgramDTO(String p_id, String p_name, String durarion, String fee) {
        this.p_id = p_id;
        this.p_name = p_name;
        this.durarion = durarion;
        this.fee = fee;
    }

    public String getP_id() {
        return p_id;
    }

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    public String getP_name() {
        return p_name;
    }

    public void setP_name(String p_name) {
        this.p_name = p_name;
    }

    public String getDurarion() {
        return durarion;
    }

    public void setDurarion(String durarion) {
        this.durarion = durarion;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    @Override
    public String toString() {
        return "ProgramDTO{" +
                "p_id='" + p_id + '\'' +
                ", p_name='" + p_name + '\'' +
                ", durarion='" + durarion + '\'' +
                ", fee='" + fee + '\'' +
                '}';
    }
}
