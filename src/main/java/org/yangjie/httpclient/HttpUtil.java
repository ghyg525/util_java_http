package org.yangjie.httpclient;

import java.io.IOException;
import java.util.Map;

import org.apache.http.Consts;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

public class HttpUtil {

    /**
     * execute
     * @param request
     * @return
     */
    public static String execute(Request request) {
    	try {
			return new String(request.execute().returnContent().asBytes(), Consts.UTF_8);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
    	return null;
    }
    
    /**
     * get
     * @param url
     * @return
     */
    public static String get(String url) {
    	return execute(Request.Get(url));
    }
    
    /**
     * post
     * @param url
     * @param form
     * @return
     */
    public static String post(String url, Form form) {
    	return execute(Request.Post(url).bodyForm(form.build()));
    }
    
    /**
     * post
     * @param url
     * @param formMap
     * @return
     */
    public static String post(String url, Map<String, String> formMap) {
    	Form form = Form.form();
    	if (formMap!=null && !formMap.isEmpty()) {
    		for(String key : formMap.keySet()){
    			form.add(key, formMap.get(key));
    		}
			return post(url, form);
		}
    	return null;
    }
    
    /**
     * post
     * @param url
     * @param body
     * @param contentType
     * @return
     */
    public static String post(String url, String body, ContentType contentType) {
    	return execute(Request.Post(url).bodyString(body, contentType));
    }
    
    /**
     * post (json)
     * @param url
     * @param body
     * @return
     */
    public static String postJson(String url, String body) {
    	return post(url, body, ContentType.APPLICATION_JSON);
    }
    
    /**
     * post (xml)
     * @param url
     * @param body
     * @return
     */
    public static String postXml(String url, String body) {
		return post(url, body, ContentType.create("application/xml", Consts.UTF_8));
    }
    
}
