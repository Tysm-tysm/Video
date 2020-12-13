package edu.gzhu.its.system.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.gzhu.its.system.entity.Video;

public interface UploadVideoJpaRepository extends JpaRepository<Video,Long>{
	@Modifying
	@Query("update Video set videoName = ?2 where videoId= ?1")
	public void updateVideoName(Long videoId,String videoName );
	
	@Modifying
	@Query("update Video set videoPath = ?2 where videoId= ?1")
	public void updateVideoPath(Long videoId,String videoPath );
	
	@Modifying
	@Query("update Video set videoUrl = ?2 where videoId= ?1")
	public void updateVideoUrl(Long videoId,String videoUrl );
	
	@Query("select u from Video u where u.videoName=?1")
	public Video getVideoByVideoName(String videoName);
	
	@Query("select u from Video u where u.videoId=?1")
	public Video getVideoByVideoId(Long videoId);
	
	@Query("select u from Video u where u.videoAuthorId=?1")
	public List<Video> getVideoByAuthorId(Long videoAuthorId);
	
	
}
