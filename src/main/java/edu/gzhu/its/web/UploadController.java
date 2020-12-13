package edu.gzhu.its.web;


import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;

import edu.gzhu.its.system.Dao.UploadVideoJpaRepository;
import edu.gzhu.its.system.entity.JsonResult;
import edu.gzhu.its.system.entity.MyThread;
import edu.gzhu.its.system.entity.User;
import edu.gzhu.its.system.entity.Video;
import edu.gzhu.its.system.entity.VideoUploadRecord;
import edu.gzhu.its.system.service.IHttpClientService;
import edu.gzhu.its.system.service.IUploadVideoRecordService;
import edu.gzhu.its.system.service.IUploadVideoService;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.MultimediaInfo;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller

public class UploadController {

	private String url;

//	private Video video;

	@Resource
	private UploadVideoJpaRepository uploadVideoJpaRepository;

	@Resource
	private IUploadVideoService iUploadVideoService;

	@Resource
	private IUploadVideoRecordService iUploadVideoRecordService;

	@Resource
	private HttpSession httpSession;

	@Resource
	private HttpServletRequest request;

	@Resource
	private IHttpClientService iHttpClientService;

	@RequestMapping("/upload")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "World") String name,
			Model model) {
		model.addAttribute("name", name);
		System.out.print("上传视频" + "\n");
		return "upload/UploadVideo";
	}

	@RequestMapping("/VideoManage")
	public String VideoManage() {
		return "upload/VideoManage";
	}

	@RequestMapping("/VideoDelete")
	public String VideoDetele() {
		return "upload/DeteleVideo";
	}

	@RequestMapping("/VideoUpdata")
	public String VideoUpdata() {
		return "upload/UpdataVideo";
	}

	// private static final Logger logger =
	// LoggerFactory.getLogger(UploadController.class);//记录日志
	// 视频上传相关代码
	@RequestMapping(value = "/upload/video", produces = "application/json;charset=UTF-8")
	public String upload(@RequestParam("fileName") MultipartFile file) throws Exception {
		Video video = new Video();
		System.out.print("上传视频===" + "\n");
		// 判断视频是否为空
		if (file.isEmpty()) {
			return "上传视频不可为空";
		}
		// 获取视频名
		String fileName = file.getOriginalFilename();
//        System.out.print("上传的视频名为: "+fileName+"\n");

		fileName = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
		System.out.print("（加个时间戳，尽量避免文件名称重复）保存的视频名为: " + fileName + "\n");
		// 加个时间戳，尽量避免视频名称重复

		String path = "D:/fileUpload/" + fileName;
		// String path = "D:/fileUpload/" + new
		// SimpleDateFormat("yyyyMMddHHmmss").format(new Date()) + "_" + fileName;
		// 视频绝对路径
		System.out.print("保存文件绝对路径" + path + "\n");

		// 创建视频路径
		File dest = new File(path);

		// 判断视频是否已经存在
		if (dest.exists()) {
			return "视频已经存在";
		}

		// 判断视频父目录是否存在
		if (!dest.getParentFile().exists()) {
			dest.getParentFile().mkdir();
		}

		try {
			// 上传视频
			file.transferTo(dest); // 保存视频
			System.out.print("保存文件路径" + path + "\n");
			url = "http://127.0.0.1:8080/images/" + fileName;
			System.out.print("查看url====" + url + "\n");
			// 获取视频时长
			Encoder encoder = new Encoder();
			MultimediaInfo m = encoder.getInfo(dest);
			System.out.print("视频长度" + m + "\n");
			long ls = m.getDuration() / 1000;
			System.out.print("视频时间" + ls + "\n");
			int hour = (int) (ls / 3600);
			System.out.print("视频时长" + hour + "\n");
			int minute = (int) (ls % 3600) / 60;
			System.out.print("视频分钟" + minute + "\n");
			int second = (int) (ls - hour * 3600 - minute * 60);
			System.out.print("视频秒" + second + "\n");

			User user = (User) httpSession.getAttribute("currentUser");// 获取上传该视频的作者
			System.out.print("上传者" + user.getUsername() + "\n");

			video.setVideoName(fileName);
			video.setVideoAuthorId(user.getId());
			video.setVideoPath(path);
			video.setVideoUrl(url);
			video.setVideoTime(hour + ":" + minute + ":" + second);

			iUploadVideoService.insertUrl(video);// 插入数据库

			// 向记录表中插入信息
			Video video2 = this.iUploadVideoService.getVideoByVideoName(fileName);
			VideoUploadRecord videoRecord1 = new VideoUploadRecord();
			videoRecord1.setUserId(user.getId());
			videoRecord1.setVideoId(video2.getVideoId());
			videoRecord1.setVideoStatu("未处理");
			System.out.print(videoRecord1.getVideoRecordId() + "+" + videoRecord1.getVideoStatu() + "\n");
			iUploadVideoRecordService.saveVideoRecord(videoRecord1);

			System.out.print("保存的完整url====" + url + "\n");
			
//			hello(path);
//			doGet(path);
			MyThread myThread = new MyThread(path);
			Thread mThread=new Thread(myThread);
			mThread.start();
			
		} catch (IOException e) {
			return "上传失败";
		}

		return "upload/VideoManage";
	}

	@SuppressWarnings("rawtypes")
	@RequestMapping("/upload/check")
	@ResponseBody
	private JsonResult<List> check(Model model) {
		User user = (User) httpSession.getAttribute("currentUser");// 获取上传该视频的作者
		Long videoAuthorId = user.getId();
		int userIdentity = user.getUserIdentity();
		List<Video> videoList = new ArrayList<>();
		if (userIdentity == 1) {// 如果是管理员，输出所有视频
			videoList = this.iUploadVideoService.getVideos();
			System.out.print("查询到的视频数量==" + videoList.size() + "\n");
		} else if (userIdentity == 0) {
			videoList = this.iUploadVideoService.getVideoByAuthorId(videoAuthorId);
			System.out.print("查询到的视频数量==" + videoList.size() + "\n");
		}
//    	request.setAttribute("Videos", videoList);

		return new JsonResult<>(videoList, "获取用户列表成功");
	}

	@RequestMapping("/upload/delete")
	private String deteleVideoByName(Video video) {
		Video video1Video = this.iUploadVideoService.getViedoByVideoId(video.getVideoId());
		File videoFile = new File("D:/fileUpload/" + video1Video.getVideoName());
		if (videoFile.exists()) {// 如果视频存在
			videoFile.delete();// 从本地删除
			System.out.print("已从本地删除" + video1Video.getVideoName() + "\n");
		}
		this.iUploadVideoService.deleteVideo(video1Video);// 从数据库删除
		return "upload/VideoManage";
	}

	@RequestMapping("/upload/update")
	private String updataVideoById(Video video) {
		Video video2Video = this.iUploadVideoService.getViedoByVideoId(video.getVideoId());
		String video2Path = video2Video.getVideoPath();// 获得video对象的文件路径
		File video2File = new File(video2Path);
		if (video2File.exists()) {
			String video3Path = "D:/fileUpload/" + video.getVideoName();
			System.out.print("更改名字后的路径" + video3Path + "\n");
			String video3Url = "http://127.0.0.1:8080/images/" + video.getVideoName();
			File video3File = new File(video3Path);
			video2File.renameTo(video3File);
			this.iUploadVideoService.updateVideoPath(video.getVideoId(), video3Path);
			this.iUploadVideoService.updateVideoUrl(video.getVideoId(), video3Url);
			this.iUploadVideoService.updateVideoName(video.getVideoId(), video.getVideoName());
			// this.iUploadVideoRecordService.updateVideoStatuByVideoId(video.getVideoId(),
			// "已处理");
		} else {
			System.out.print("文件不存在" + "\n");
		}

		return "upload/VideoManage";
	}

	
    /**
	 * GET---无参
	 */
	@RequestMapping("/hellog")
	@ResponseBody
	public String doGet(String path) {
		// 获得Http客户端(可以理解为:你得先有一个浏览器;注意:实际上HttpClient与浏览器是不一样的)
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();
		// 创建Get请求
		String url="http://127.0.0.1:8080/hello2";
		
		HttpGet httpGet = new HttpGet(url);
 
		// 响应模型
		CloseableHttpResponse response = null;
		try {
			// 由客户端执行(发送)Get请求
			response = httpClient.execute(httpGet);
			// 从响应模型中获取响应实体
			HttpEntity responseEntity = response.getEntity();
			System.out.println("响应状态为:" + response.getStatusLine());
			if (responseEntity != null) {
				String respondJson = EntityUtils.toString(responseEntity);
				System.out.println("响应内容长度为:" + responseEntity.getContentLength());
				System.out.println("响应内容为:" + respondJson);
//				Video video6 = JSONObject.parseObject(respondJson, Video.class);
				
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				// 释放资源
				if (httpClient != null) {
					httpClient.close();
				}
				if (response != null) {
					response.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return "1221";
	}
	
	@RequestMapping("/hello2")
	@ResponseBody
	private String hello2() {
		return "嘻嘻";
	}
	

}
