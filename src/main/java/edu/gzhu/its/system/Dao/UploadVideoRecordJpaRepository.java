package edu.gzhu.its.system.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import edu.gzhu.its.system.entity.VideoUploadRecord;

public interface UploadVideoRecordJpaRepository extends JpaRepository<VideoUploadRecord, Long>{
	@Modifying
	@Query("update VideoUploadRecord set videoStatu=?2 where videoId=?1")
	public void updateVideoStatuByVideoId(Long videoId,String videoStatu);
}
