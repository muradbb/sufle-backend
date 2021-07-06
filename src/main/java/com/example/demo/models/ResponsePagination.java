package com.example.demo.models;

public class ResponsePagination {
    private Long total;
    private Object dataList;

    public ResponsePagination() {
    }

    public Long getTotal() {
        return total;
    }

    public ResponsePagination setTotal(Long total) {
        this.total = total;
        return this;
    }

    public Object getDataList() {
        return dataList;
    }

    public ResponsePagination setDataList(Object dataList) {
        this.dataList = dataList;
        return this;
    }

    @Override
    public String toString() {
        return "ResponsePagination{" +
                "total=" + total +
                ", dataList=" + dataList +
                '}';
    }
}
