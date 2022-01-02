package com.yuce.envanter.model;

public enum RoleEnum {

    ROLE_ADMIN(0, "ROLE_ADMIN"),
    ROLE_EMPLOYEE(1, "ROLE_EMPLOYEE"),
    ROLE_USER(2, "ROLE_CUSTOMER");

    private final int id;
    private final String name;

    RoleEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
