package org.yangjie.httpclient;

import org.apache.http.Consts;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

public class HttpUtil {

    /**
     * get
     * @param url
     * @return
     * @throws Exception
     */
    public static String get(String url) throws Exception{
    	return new String(Request.Get(url).execute().returnContent().asBytes(), Consts.UTF_8);
    }
    
    /**
     * post
     * @param url
     * @param form
     * @return
     * @throws Exception
     */
    public static String post(String url, Form form) throws Exception{
    	return new String(Request.Post(url).bodyForm(form.build()).execute().returnContent().asBytes(), Consts.UTF_8);
    }
    
    /**
     * post
     * @param url
     * @param body 发送内容
     * @return
     * @throws Exception
     */
    public static String post(String url, String body) throws Exception{
    	return new String(Request.Post(url).bodyString(body, ContentType.TEXT_HTML).execute().returnContent().asBytes(), Consts.UTF_8);
    }
    
    /**
     * post
     * @param url
     * @param body 发送内容
     * @param contentType 请求内容类型
     * @return
     * @throws Exception
     */
    public static String post(String url, String body, ContentType contentType) throws Exception{
    	return new String(Request.Post(url).bodyString(body, contentType).execute().returnContent().asBytes(), Consts.UTF_8);
    }
    
    /**
     * post (json)
     * @param url
     * @param body 发送内容
     * @return
     * @throws Exception
     */
    public static String postJson(String url, String body) throws Exception{
    	return post(url, body, ContentType.APPLICATION_JSON);
    }
    
    /**
     * post (xml)
     * @param url
     * @param body 发送内容
     * @return
     * @throws Exception 
     */
    public static String postXml(String url, String body) throws Exception {
		return post(url, body, ContentType.create("application/xml", Consts.UTF_8));
    }
    
}
