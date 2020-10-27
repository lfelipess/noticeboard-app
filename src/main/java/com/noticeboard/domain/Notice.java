package com.noticeboard.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "notice")
public class Notice {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String title;
	private String description;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date publishDate;
	@JsonFormat(pattern="dd-MM-yyyy")
	private Date visualizationDate;
	
	public Notice() {}
	
	public Notice(String title, String description, Date publishDate, Date visualizationDate) {
		this.title = title;
		this.description = description;
		this.publishDate = publishDate;
		this.visualizationDate = visualizationDate;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
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
	public Date getPublishDate() {
		return publishDate;
	}
	public void setPublishDate(Date publishDate) {
		this.publishDate = publishDate;
	}
	public Date getVisualizationDate() {
		return visualizationDate;
	}
	public void setVisualizationDate(Date visualizationDate) {
		this.visualizationDate = visualizationDate;
	}
	
	
}
