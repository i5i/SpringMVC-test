package net.java.spring.model;

public class ListRequest {
private String[] sortable={"name","type","location","average","count"};
private String[] headers;
private String type;
private String search;	
private String sortby;
private Boolean asc;
private int page;
private int perpage;
private int itemcount;

public ListRequest(){
	this.sortby=sortable[0];
	this.asc=true;
	this.page=0;
}

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

public void setItemcount(int itemcount){
	this.itemcount=itemcount;
}

public int getPerpage() {
	return perpage;
}

public void setPerpage(int perpage) {
	this.perpage = perpage;
}

public int getItemcount() {
	return itemcount;
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

public int getMaxpage() {
	if(this.itemcount%this.perpage!=0){return (this.itemcount/this.perpage)+1;}
	return this.itemcount/this.perpage;
}

@Override
public String toString(){
	StringBuilder returnstr=new StringBuilder();
	returnstr.append("Sort by:")
	.append(this.sortby)
	.append(" Asc?:")
	.append(this.asc)
	.append(" Page:")
	.append(this.page)
	.append("itemcount:")
	.append(this.itemcount)
	.append("perpage:")
	.append(this.perpage)
	.append(" Type:")
	.append(this.type)
	.append(" Search: ")
	.append(this.search);
	return returnstr.toString();
}

}
