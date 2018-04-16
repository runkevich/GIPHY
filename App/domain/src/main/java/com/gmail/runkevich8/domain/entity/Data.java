package com.gmail.runkevich8.domain.entity;

import java.util.List;


public class Data {

    List<Gif> data;

    public List<Gif> getData() {
        return data;
    }

    public void setData(List<Gif> data) {
        this.data = data;
    }

    public Data(List<Gif> data) {
        this.data = data;
    }

}
