package com.wdq.crm.courseType.page;

import java.util.List;

/**
 * Created by haier on 2017/7/12.
 */
public class PageBean<T> {
    //必选项，第几页、每页多少条记录、总记录数
    private int pageNum;
    private int pageSize;
    private int totalRecord;

    //由以上3项计算来
    private int startIndex;
    private int totalPage;

    private int start;
    private int end;

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    private List<T> data;

    public PageBean(int pageNum, int pageSize, int totalRecord) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.totalRecord = totalRecord;

        this.startIndex = (pageNum - 1) * pageSize;
        this.totalPage = (totalRecord + pageSize - 1) / pageSize;

        this.start = 1;
        this.end = 10;
        if (this.totalPage <= 10) {
            this.end = this.totalPage;
        } else {
            this.start = this.pageNum - 4;
            this.end = this.pageNum + 5;
            if (this.start < 1) {
                this.start = 1;
                this.end = 10;
            }
            if (this.end > totalPage) {
                this.start = this.totalPage - 9;
                this.end = this.totalPage;
            }
        }

    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
