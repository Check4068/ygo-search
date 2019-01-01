package com.ygo.util;

import java.util.List;

public class Paging<E> {

	private Integer currentPage;
	
	private Integer total;
	
	private Integer totalPage;
	
	private List<E> data;

	public Paging(Integer currentPage, Integer total, Integer row, List<E> data) {
		this.currentPage = currentPage;
		this.total = total;
		this.totalPage = total % row == 0 ? total / row : total / row + 1;
		this.data = data;
	}

	public List<E> getData() {
		return data;
	}

	public void setData(List<E> data) {
		this.data = data;
	}

	public Integer getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Integer totalPage) {
		this.totalPage = totalPage;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}

	public Integer getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Integer currentPage) {
		this.currentPage = currentPage;
	}
}
