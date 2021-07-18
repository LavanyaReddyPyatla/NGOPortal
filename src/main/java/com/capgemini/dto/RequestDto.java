package com.capgemini.dto;

public class RequestDto {

	private Integer id;
	private String title;
	private String description;
	private Double raised;
	private Double goal;
	private int needyPersonId;
	private boolean status;

	public int getNeedyPersonId() {
		return needyPersonId;
	}

	public void setNeedyPersonId(int needyPersonId) {
		this.needyPersonId = needyPersonId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getRaised() {
		return raised;
	}

	public void setRaised(Double raised) {
		this.raised = raised;
	}

	public Double getGoal() {
		return goal;
	}

	public void setGoal(Double goal) {
		this.goal = goal;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
	

}
