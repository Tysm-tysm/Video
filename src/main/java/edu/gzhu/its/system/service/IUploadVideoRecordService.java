package edu.gzhu.its.system.service;

import edu.gzhu.its.system.entity.VideoUploadRecord;

public interface IUploadVideoRecordService {
	public void saveVideoRecord(VideoUploadRecord videoUploadRecord);
    public void updateVideoStatuByVideoId(Long videoId,String videoStatu);
}
