package edu.gzhu.its;

import java.io.IOException;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

import edu.gzhu.its.system.entity.User;
import edu.gzhu.its.system.entity.Video;
import edu.gzhu.its.system.service.jmpl.UserService;

@RunWith(SpringRunner.class)//表示spring 的測試
@SpringBootTest//表示spring boot的測試
class ItsApplicationTests {

	
    /**
	 * GET---无参测试
	 *
	 * @date 2018年7月13日 下午4:18:50
	 */
	@Test
	public void hello()throws Exception {
    	CloseableHttpClient httpClient = HttpClientBuilder.create().build();
    	String url="http://127.0.0.1:8080/hello1";
    	HttpPost httpPost=new HttpPost(url);
    	Video video6=new Video();
    	video6.setVideoName("夺冠");
    	video6.setVideoPath("D:/fileUpload");
    	video6.setVideoId(100);
    	String jsonString=JSON.toJSONString(video6);
    	StringEntity entity =new StringEntity(jsonString,"UTF-8");
    	httpPost.setEntity(entity);
    	httpPost.setHeader("Content-Type", "application/json;charset=utf8");
    	// 响应模型
    			CloseableHttpResponse response = null;
    			try {
    				// 由客户端执行(发送)Post请求
    				response = httpClient.execute(httpPost);
    				// 从响应模型中获取响应实体
    				HttpEntity responseEntity = response.getEntity();
    	 
    				System.out.println("响应状态为:" + response.getStatusLine());
    				if (responseEntity != null) {
    					System.out.println("响应内容长度为:" + responseEntity.getContentLength());
    					System.out.println("响应内容为:" + EntityUtils.toString(responseEntity));
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

//    	System.out.print(jsonString);
//    	return "/login";
//    	HttpMethod method=HttpMethod.GET;
//    	MultiValueMap<String, String> params =new LinkedMultiValueMap<>();
    }
}