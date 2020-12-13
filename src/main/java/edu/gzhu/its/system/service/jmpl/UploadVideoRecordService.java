package edu.gzhu.its.system.service.jmpl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.gzhu.its.system.Dao.UploadVideoRecordJpaRepository;
import edu.gzhu.its.system.entity.VideoUploadRecord;
import edu.gzhu.its.system.service.IUploadVideoRecordService;

@Service("UploadVideoRecordService")
@Transactional
public class UploadVideoRecordService implements IUploadVideoRecordService {

	@Resource
	private UploadVideoRecordJpaRepository uploadVideoRecordJpaRepository;
	
	@Override
	public void saveVideoRecord(VideoUploadRecord videoUploadRecord){
		// TODO Auto-generated method stub
		this.uploadVideoRecordJpaRepository.save(videoUploadRecord);
	}

	@Override
	public void updateVideoStatuByVideoId(Long videoId, String videoStatu) {
		// TODO Auto-generated method stub
		this.uploadVideoRecordJpaRepository.updateVideoStatuByVideoId(videoId, videoStatu);
	}

}
