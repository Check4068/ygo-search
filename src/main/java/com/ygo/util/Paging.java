package com.ygo.util;

import java.util.List;

public class Paging<E> {

	private Long currentPage;
	
	private Long total;
	
	private Long totalPage;
	
	private List<E> data;

	public Paging(Long currentPage, Long total, Integer row, List<E> data) {
		this.setCurrentPage(currentPage);
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

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}

	public Long getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(Long currentPage) {
		this.currentPage = currentPage;
	}
}
