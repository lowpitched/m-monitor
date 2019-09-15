package com.example.monitor.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
public class PaginationVo<T> {
    //当前页码
    private long currentPage;
    //总页数
    private long totalPage;
    //总条目
    private long totalCount;
    //单页条目
    private long pageSize;

    private List<T> records;

    public PaginationVo(IPage<T> page){
        this.currentPage = page.getCurrent();
        this.totalPage = page.getPages();
        this.totalCount = page.getTotal();
        this.pageSize = page.getSize();
        this.records = page.getRecords();
    }

    public PaginationVo(List<T> data,int pageSize,int currentPage,int totalCount){
        this.records = data;
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.totalCount = totalCount;
        this.totalPage = totalCount%pageSize==0?totalCount/pageSize:totalCount/pageSize+1;
    }
}
