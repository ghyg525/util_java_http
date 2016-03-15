package org.yangjie.util;

import org.apache.http.Consts;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

public class HttpUtil {

    /**
     * 发生get请求
     * @param url
     * @return
     * @throws Exception
     */
    public static String sendGet(String url) throws Exception{
    	return new String(Request.Get(url).execute().returnContent().asBytes(), Consts.UTF_8);
    }
    
    /**
     * 发送post请求
     * @param url
     * @param form
     * @return
     * @throws Exception
     */
    public static String sendPost(String url, Form form) throws Exception{
    	return new String(Request.Post(url).bodyForm(form.build()).execute().returnContent().asBytes(), Consts.UTF_8);
    }
    
    /**
     * 发送post请求
     * @param url
     * @param body 发送内容
     * @return
     * @throws Exception
     */
    public static String sendPost(String url, String body) throws Exception{
    	return new String(Request.Post(url).bodyString(body, ContentType.TEXT_HTML).execute().returnContent().asBytes(), Consts.UTF_8);
    }
    
    /**
     * 发送post请求
     * @param url
     * @param body 发送内容
     * @param contentType 请求内容类型
     * @return
     * @throws Exception
     */
    public static String sendPost(String url, String body, ContentType contentType) throws Exception{
    	return new String(Request.Post(url).bodyString(body, contentType).execute().returnContent().asBytes(), Consts.UTF_8);
    }
    
    /**
     * 发送post请求(json格式)
     * @param url
     * @param body 发送内容
     * @return
     * @throws Exception
     */
    public static String sendPostJson(String url, String body) throws Exception{
    	return sendPost(url, body, ContentType.APPLICATION_JSON);
    }
    
    /**
     * 发送post请求(xml格式)
     * @param url
     * @param body 发送内容
     * @return
     * @throws Exception 
     */
    public static String sendPostXml(String url, String body) throws Exception {
		return sendPost(url, body, ContentType.create("application/xml", Consts.UTF_8));
    }
    
}
