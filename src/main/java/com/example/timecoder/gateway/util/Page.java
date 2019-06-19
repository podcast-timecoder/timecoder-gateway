package com.example.timecoder.gateway.util;

import io.swagger.annotations.ApiModelProperty;
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.data.domain.Sort;

public class Page {

    private int pageSize;
    private int pageNumber;
    @ApiModelProperty(example = "id")
    private String sortBy = "id";
    private Sort.Direction orderBy;

    public Page(int pageSize, int pageNumber, String sortBy, Sort.Direction orderBy) {
        this.pageSize = pageSize;
        this.pageNumber = pageNumber;
        this.sortBy = sortBy;
        this.orderBy = orderBy;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public String getSortBy() {
        return sortBy;
    }

    public void setSortBy(String sortBy) {
        this.sortBy = sortBy;
    }

    public Sort.Direction getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(Sort.Direction orderBy) {
        this.orderBy = orderBy;
    }
}
