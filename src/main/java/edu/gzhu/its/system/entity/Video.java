package edu.gzhu.its.system.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Video")
public class Video {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long videoId;
	
	@Column(name = "videoName")
	private String videoName;
	private int videoType;//视频格式
	private String videoTime;//视频时长
	private String videoContentText;//视频内容文本
	private long videoTextNum;//视频文本字数
	private String videoSplitVoiceSpeed;//分割视频语速
	private long videoSplitWordNum;//分割视频字数
	private long videoOnceVariance;//分割视频一次方差
	private long videoTotalTwiceVariance;//总视频二次方差
	private long videoSplitNum;//视频分割数量
	private String videoWave;//视频波动
	private String videoTone;//
	private String videoPath;//视频本地地址
	private String videoUrl;//视频Url
	private long videoAuthorId;//视频作者Id
	public long getVideoAuthorId() {
		return videoAuthorId;
	}
	public void setVideoAuthorId(long videoAuthorId) {
		this.videoAuthorId = videoAuthorId;
	}
	public long getVideoId() {
		return videoId;
	}
	public void setVideoId(long videoId) {
		this.videoId = videoId;
	}
	public String getVideoName() {
		return videoName;
	}
	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}
	public int getVideoType() {
		return videoType;
	}
	public void setVideoType(int videoType) {
		this.videoType = videoType;
	}
	public String getVideoTime() {
		return videoTime;
	}
	public void setVideoTime(String videoTime) {
		this.videoTime = videoTime;
	}
	public String getVideoContentText() {
		return videoContentText;
	}
	public void setVideoContentText(String videoContentText) {
		this.videoContentText = videoContentText;
	}
	public long getVideoTextNum() {
		return videoTextNum;
	}
	public void setVideoTextNum(long videoTextNum) {
		this.videoTextNum = videoTextNum;
	}
	public String getVideoSplitVoiceSpeed() {
		return videoSplitVoiceSpeed;
	}
	public void setVideoSplitVoiceSpeed(String videoSplitVoiceSpeed) {
		this.videoSplitVoiceSpeed = videoSplitVoiceSpeed;
	}
	public long getVideoSplitWordNum() {
		return videoSplitWordNum;
	}
	public void setVideoSplitWordNum(long videoSplitWordNum) {
		this.videoSplitWordNum = videoSplitWordNum;
	}
	public long getVideoOnceVariance() {
		return videoOnceVariance;
	}
	public void setVideoOnceVariance(long videoOnceVariance) {
		this.videoOnceVariance = videoOnceVariance;
	}
	public long getVideoTotalTwiceVariance() {
		return videoTotalTwiceVariance;
	}
	public void setVideoTotalTwiceVariance(long videoTotalTwiceVariance) {
		this.videoTotalTwiceVariance = videoTotalTwiceVariance;
	}
	public long getVideoSplitNum() {
		return videoSplitNum;
	}
	public void setVideoSplitNum(long videoSplitNum) {
		this.videoSplitNum = videoSplitNum;
	}
	public String getVideoWave() {
		return videoWave;
	}
	public void setVideoWave(String videoWave) {
		this.videoWave = videoWave;
	}
	public String getVideoTone() {
		return videoTone;
	}
	public void setVideoTone(String videoTone) {
		this.videoTone = videoTone;
	}
	public String getVideoPath() {
		return videoPath;
	}
	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	@Override
	public String toString() {
		return "Video [videoId=" + videoId + ", videoName=" + videoName + ", videoType=" + videoType + ", videoTime="
				+ videoTime + ", videoContentText=" + videoContentText + ", videoTextNum=" + videoTextNum
				+ ", videoSplitVoiceSpeed=" + videoSplitVoiceSpeed + ", videoSplitWordNum=" + videoSplitWordNum
				+ ", videoOnceVariance=" + videoOnceVariance + ", videoTotalTwiceVariance=" + videoTotalTwiceVariance
				+ ", videoSplitNum=" + videoSplitNum + ", videoWave=" + videoWave + ", videoTone=" + videoTone
				+ ", videoPath=" + videoPath + ", videoUrl=" + videoUrl + ", videoAuthorId=" + videoAuthorId + "]";
	}
	
}
