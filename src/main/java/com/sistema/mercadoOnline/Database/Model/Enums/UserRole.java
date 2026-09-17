package com.sistema.mercadoOnline.Database.Model.Enums;

public enum UserRole {

    ADMIN("admin"),
    CLIENTE("Cliente"),
    VIP("Vip");

    private String roles;

    UserRole(String role){
        this.roles = role;
    }

    public String getRoles(){
        return roles;
    }
}
