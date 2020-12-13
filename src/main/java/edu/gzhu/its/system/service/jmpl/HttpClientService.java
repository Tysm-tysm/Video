package edu.gzhu.its.system.service.jmpl;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import edu.gzhu.its.system.service.IHttpClientService;

@Service("HttpClientService")
@Transactional
public class HttpClientService implements IHttpClientService {

	@Override
	public String Client(String url, HttpMethod method, MultiValueMap<String, String> params) {
		// TODO Auto-generated method stub
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> response1=template.getForEntity(url, String.class);
		return response1.getBody();
	}

}
