package net.java.spring;



public class PageLoader {
private String sortby;
private String[] sortable={"name","type","location","average","count"};
private String[] headers={"Nimi","Tüüp","Asukoht","Keskmine hinne","Kordi hinnatud"};
private Boolean asc=true;
private String type;
private String search;
private int page=0;
private int maxpage;

public String getSortby() {
	return sortby;
}

public void setSortby(String sortby) {
	this.sortby = sortby;
}

public int getPage() {
	return page;
}

public void setPage(int page) {
	this.page = page;
}

public int getMaxpage() {
	return maxpage;
}

public void setMaxpage(int maxpage) {
	this.maxpage = maxpage;
}

public String getSearch() {
	return search;
}

public void setSearch(String search) {
	this.search = search;
}
public Boolean getAsc() {
	return asc;
}

public void setAsc(Boolean asc) {
	this.asc = asc;
}

public String[] getSortable() {
	return sortable;
}

public void setSortable(String[] sortable) {
	this.sortable = sortable;
}

public String getType() {
	return type;
}

public void setType(String type) {
	this.type = type;
}

public String[] getHeaders() {
	return headers;
}

public void setHeaders(String[] headers) {
	this.headers = headers;
}
}
