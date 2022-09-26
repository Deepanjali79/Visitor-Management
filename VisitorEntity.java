package com.demo.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "visitor_entity")
public class VisitorEntity extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private String ownerName;
	private String flatNo;
	private Date date;
	private String arrivalTime;
	private String departureTime;

	public VisitorEntity() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getFlatNo() {
		return flatNo;
	}

	public void setFlatNo(String flatNo) {
		this.flatNo = flatNo;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public String getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}

	@Override
	public String toString() {
		return "VisitorEntity [id=" + id + ", name=" + name + ", ownerName=" + ownerName + ", flatNo=" + flatNo
				+ ", date=" + date + ", arrivalTime=" + arrivalTime + ", departureTime=" + departureTime + "]";
	}

	public VisitorEntity(String name, String ownerName, String flatNo, Date date, String arrivalTime,
			String departureTime) {
		super();
		this.name = name;
		this.ownerName = ownerName;
		this.flatNo = flatNo;
		this.date = date;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
	}

}
