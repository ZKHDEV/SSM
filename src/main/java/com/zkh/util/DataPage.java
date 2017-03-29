package com.zkh.util;

import java.io.Serializable;
import java.util.List;

/**
 * 分页包装类
 */
public class DataPage<T> implements Serializable {
    private Integer pageNum;    //页码
    private Integer pageCount;  //总页数
    private Integer pageSize;   //每页数据数目
    private Integer indexCount; //显示页码索引数
    private List<T> data;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        this.pageCount = pageCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getIndexCount() {
        return indexCount;
    }

    public void setIndexCount(Integer indexCount) {
        this.indexCount = indexCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
