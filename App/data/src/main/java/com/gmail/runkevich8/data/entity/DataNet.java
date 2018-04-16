package com.gmail.runkevich8.data.entity;


import java.util.List;

public class DataNet {

    List<GifNet> data;

    public List<GifNet> getData() {
        return data;
    }

    public void setData(List<GifNet> data) {
        this.data = data;
    }

    public DataNet(List<GifNet> data) {
        this.data = data;
    }
}
