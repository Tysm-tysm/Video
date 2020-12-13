package edu.gzhu.its.system.service;

import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;

public interface IHttpClientService {
	public String Client(String url,HttpMethod method,MultiValueMap<String,String> params);
}
