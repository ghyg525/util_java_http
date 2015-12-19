package org.yangjie.util;

import org.apache.http.HttpStatus;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;

public class HttpUtil {

    public static void main(String[] args) throws Exception {
//        System.out.println(sendGet("http://www.moko.cc"));
//        System.out.println(sendPost("http://www.moko.cc", Form.form().add("username",  "vip").add("password",  "secret")));;
//        System.out.println(sendPost("http://www.moko.cc", ""));;
//        System.out.println(sendPost("http://www.moko.cc", "{\"id\":\"123\"}"));;
    }
    
    /**
     * 发生get请求
     * @param url
     * @return
     * @throws Exception
     */
    public static String sendGet(String url) throws Exception{
    	return Request.Get(url).execute().returnContent().asString();
    }
    
    /**
     * 发送post请求
     * @param url
     * @param form
     * @return
     * @throws Exception
     */
    public static boolean sendPost(String url, Form form) throws Exception{
    	return Request.Post(url).bodyForm(form.build()).execute().returnResponse().getStatusLine().getStatusCode()==HttpStatus.SC_OK;
    }
    
    /**
     * 发送post请求
     * @param url
     * @param body 发送内容
     * @return
     * @throws Exception
     */
    public static boolean sendPost(String url, String body) throws Exception{
    	return sendPost(url, body, ContentType.TEXT_HTML);
    }
    
    /**
     * 发送post请求
     * @param url
     * @param body 发送内容
     * @param contentType 请求内容类型
     * @return
     * @throws Exception
     */
    public static boolean sendPost(String url, String body, ContentType contentType) throws Exception{
    	return Request.Post(url).bodyString(body, contentType).execute().returnResponse().getStatusLine().getStatusCode()==HttpStatus.SC_OK;
    }
    
    
    
}
