package com.gomdolstudio.travelkorea.data.entity;

import java.util.List;

public class Body {
    private List<Item> items;
    private long numOfRows;
    private long pageNo;
    private long totalCount;

    public List<Item> getItems() {
        return items;
    }

    public long getNumOfRows() {
        return numOfRows;
    }

    public long getPageNo() {
        return pageNo;
    }

    public long getTotalCount() {
        return totalCount;
    }
}
