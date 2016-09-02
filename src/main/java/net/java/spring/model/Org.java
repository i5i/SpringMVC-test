package net.java.spring.model;


public class Org{
    private int id;
    private String type;
    private String location;
    private String name;
    private int rate;
    private Integer grade;
    private Float average;
    private Integer count;
    
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}



	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type =type;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getGrade() {
		if (grade != null) {
			  return grade.intValue();}
			else
			  return 0;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public int getCount() {
		if (count != null) {
			  return count.intValue();}
			else
			  return 0;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public Float getAverage() {
		if(average != null){
			return average;
		}else{
			return (float) 0;
		}
        
	}

	public void setAverage(Float average) {
		this.average = average;
	}




}
