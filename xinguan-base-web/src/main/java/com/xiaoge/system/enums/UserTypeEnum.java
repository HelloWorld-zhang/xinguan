package com.xiaoge.system.enums;

public enum UserTypeEnum {

    SYSTEM_ADMIN(0),
    SYSTEM_USER(1);

    private int typeCode;

    UserTypeEnum(int typeCode){
        this.typeCode = typeCode;
    }

    public int getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(int typeCode) {
        this.typeCode = typeCode;
    }
}
