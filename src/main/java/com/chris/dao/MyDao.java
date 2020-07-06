package com.chris.dao;

import org.springframework.stereotype.Repository;

//默认的名字为：类名首字母小写
@Repository
public class MyDao {

    private String label = "1";

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Override
    public String toString() {
        return "MyDao{" +
                "label='" + label + '\'' +
                '}';
    }
}
