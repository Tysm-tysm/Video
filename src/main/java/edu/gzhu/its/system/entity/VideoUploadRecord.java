package edu.gzhu.its.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="videoUploadRecord")
public class VideoUploadRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long videoRecordId;
	
	@Column(name = "videoId")
	private long videoId;
	private long userId;
	private String videoStatu;
	
	
	public long getVideoRecordId() {
		return videoRecordId;
	}
	public void setVideoRecordId(long videoRecordId) {
		this.videoRecordId = videoRecordId;
	}
	public long getVideoId() {
		return videoId;
	}
	public void setVideoId(long videoId) {
		this.videoId = videoId;
	}
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getVideoStatu() {
		return videoStatu;
	}
	public void setVideoStatu(String videoStatu) {
		this.videoStatu = videoStatu;
	}
}
