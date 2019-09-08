package com.example.monitor.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class PaginationVo<T> {
    //当前页码
    private int currentPage;
    //总页数
    private int totalPage;
    //总条目
    private int totalCount;
    //单页条目
    private int pageSize;

    private List<T> data;

    public PaginationVo(List<T> data,int pageSize,int currentPage,int totalCount){
        this.data = data;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
    }
}
