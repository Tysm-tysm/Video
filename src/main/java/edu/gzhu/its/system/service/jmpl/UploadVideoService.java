package edu.gzhu.its.system.service.jmpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.gzhu.its.system.Dao.UploadVideoJpaRepository;
import edu.gzhu.its.system.entity.Video;
import edu.gzhu.its.system.service.IUploadVideoService;

@Service("UploadVideoService")
@Transactional
public class UploadVideoService implements IUploadVideoService {

	@Resource
	private UploadVideoJpaRepository uploadVideoJpaRepository;
	
	@Override
	public void insertUrl(Video video) throws Exception{
		// TODO Auto-generated method stub
		this.uploadVideoJpaRepository.save(video);
	}
	
	

	@Override
	public List<Video> getVideos(){
		// TODO Auto-generated method stub
		List<Video> video = uploadVideoJpaRepository.findAll();
		return video;
	}
    
	@Override
	public List<Video> getVideoByAuthorId(Long videoAuthorId) {
		// TODO Auto-generated method stub
		List<Video> video = uploadVideoJpaRepository.getVideoByAuthorId(videoAuthorId);
		return video;
	}

	@Override
	public void deleteVideo(Video video) {
		// TODO Auto-generated method stub
		this.uploadVideoJpaRepository.delete(video);
	}



	@Override
	public Video getVideoByVideoName(String videoName) {
		// TODO Auto-generated method stub		
		return this.uploadVideoJpaRepository.getVideoByVideoName(videoName);
	}



	@Override
	public void updateVideoName(Long videoId, String videoName) {
		// TODO Auto-generated method stub
		this.uploadVideoJpaRepository.updateVideoName(videoId, videoName);
	}



	@Override
	public Video getViedoByVideoId(Long videoId) {
		// TODO Auto-generated method stub
		return this.uploadVideoJpaRepository.getVideoByVideoId(videoId);
	}



	@Override
	public void updateVideoUrl(Long videoId, String videoUrl) {
		// TODO Auto-generated method stub
		this.uploadVideoJpaRepository.updateVideoUrl(videoId, videoUrl);
	}



	@Override
	public void updateVideoPath(Long videoId, String videoPath) {
		// TODO Auto-generated method stub
		this.uploadVideoJpaRepository.updateVideoPath(videoId, videoPath);
	}


}
