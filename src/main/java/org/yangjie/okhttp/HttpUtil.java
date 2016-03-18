package org.yangjie.okhttp;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class HttpUtil {

	private static final OkHttpClient client = new OkHttpClient();
	
    /**
     * get
     * @param url
     * @return
     * @throws Exception
     */
    public static String get(String url) throws Exception{
    	return client.newCall(new Request.Builder().url(url).get().build()).execute().body().string();
    }

    /**
     * post
     * @param url
     * @param form
     * @return
     * @throws Exception
     */
//    public static String post(String url, Form form) throws Exception{
//    	return client.newCall(new Request.Builder().url(url).post(RequestBody.create(mediaType, body)).build()).execute().body().string();
//    }
    
    /**
     * post
     * @param url
     * @param body
     * @param mediaType
     * @return
     * @throws Exception
     */
    public static String post(String url, String body, MediaType mediaType) throws Exception{
    	return client.newCall(new Request.Builder().url(url).post(RequestBody.create(mediaType, body)).build()).execute().body().string();
    }
    
    /**
     * post (json)
     * @param url
     * @param body
     * @return
     * @throws Exception
     */
    public static String postJson(String url, String body) throws Exception{
    	return post(url, body, MediaType.parse("application/json; charset=utf-8"));
    }
    
    /**
     * post (xml)
     * @param url
     * @param body
     * @return
     * @throws Exception 
     */
    public static String postXml(String url, String body) throws Exception {
    	return post(url, body, MediaType.parse("application/xml; charset=utf-8"));
    }
    
}
