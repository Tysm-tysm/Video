package edu.gzhu.its.system.service;

import java.util.List;

import edu.gzhu.its.system.entity.Video;

public interface IUploadVideoService {
	public void insertUrl(Video video) throws Exception;//插入url
	public List<Video> getVideos();//获得数据库中视频表
	public void deleteVideo(Video video);//删除数据库中表项
	public Video getVideoByVideoName(String videoName);//根据视频名获得视频对象
	public void updateVideoName(Long videoId,String videoName);//根据视频id更改视频名
	public Video getViedoByVideoId(Long videoId);//根据视频id获得视频对象
	public void updateVideoUrl(Long videoId,String videoUrl);//根据视频id更改视频Url
	public void updateVideoPath(Long videoId,String videoPath);//根据视频id更改视频Path
	public List<Video> getVideoByAuthorId(Long videoAuthorId);//获得某一作者的所有视频
}
