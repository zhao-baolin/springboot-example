package com.example.springbootjdbc.enums;

/**
 * @Description
 * @Author zhaobaolin
 * @Date 2019/6/19
 */
public enum SexEnum {
    MAN(1,"男"),
    WOMAN(2,"女"),
    UNKNOW(3,"未知")
    ;

    private int key;
    private String value;

    SexEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }


    public static SexEnum getValueByKey(int key){
        for(SexEnum e : SexEnum.values()){
            if(e.key == key){
                return e;
            }
        }
        return null;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }}
