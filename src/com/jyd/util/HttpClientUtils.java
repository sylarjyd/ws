/**
 * Project Name:ego-common
 * File Name:HttpClientUtils.java
 * Package Name:com.jyd.utils
 * Date:2017年8月15日下午9:46:14
 * Copyright (c) 2017
 *
 */
package com.jyd.util;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.sf.json.JSONObject;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

/**
 * 类名: HttpClientUtils
 * 备注:
 * 时间: 2017年8月15日 下午9:46:14
 * 作者:sylar
 * @version 
 * @since JDK 1.8
 */
public class HttpClientUtils {
	/**
	 * 
	 * 方法名:httpUtils
	 * 备注:
	 * 作者:sylar
	 * 时间:2017年8月15日下午9:46:47
	 * @param url
	 * @param param
	 * @param method
	 * @return
	 * @since JDK 1.8
	 */
	public static Object httpUtils(String url,
			Map<String,String> param,String method){
		HttpResponse response=null;
		try {
			//创建客户端对象
			HttpClient httpClient = HttpClients.createDefault();
			if("POST".equals(method)){
				//创建List集合
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				//遍历Map集合
				for (Entry<String,String> e : param.entrySet()){
					String name = e.getKey();
					String value = e.getValue();
					NameValuePair nvp = new BasicNameValuePair(name, value);
					params.add(nvp);
					//将url封装为对应的请求方式
					HttpPost httpPost = new HttpPost(url);
					//对发送到服务器的参数进行编码
					StringEntity entity= new UrlEncodedFormEntity(params);
					//将参数设置到httpPost中
					httpPost.setEntity(entity);
					response = httpClient.execute(httpPost);
				}
			}else{
				
			}
			//获得服务端响应的数据
			Long size=response.getEntity().getContentLength();
			InputStream is = response.getEntity().getContent();
			System.out.println("size="+size);
			byte[] b = new byte[1024*2];
			int len=0; // 实际读取长度
			Object obj=null;
			while((len=is.read(b))!=-1){
				byte[]buf=Arrays.copyOf(b, len);
				obj=BinaryObjectUtils.byteArrayToObj(buf);
			}
			is.close();
			return obj;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	/****
	 * 远程调用获得Map集合
	 * ***/
	public static <T> Map<String,T> httpUtilsJsonToMap(String url,Map<String,String> param,
			String method,Class<T> cls,String cookieValue){
		HttpResponse response=null;
		try{
			//1创建客户端对象
			HttpClient httpClient = HttpClients.createDefault();
			if("POST".equals(method)){
				//创建List集合
				List<NameValuePair> params = new ArrayList<NameValuePair>();
				//遍历Map集合
				for(Entry<String,String> e:param.entrySet()){
					String name=e.getKey();
					String value=e.getValue();
					NameValuePair nvp = new BasicNameValuePair(name, value);
					params.add(nvp);
				}
				//将url封装为对应的请求方式
				HttpPost httpPost = new HttpPost(url);
				httpPost.setHeader("Cookie", "sso_token="+cookieValue);
				//对发送到服务器的参数进行编码
				StringEntity entity= new UrlEncodedFormEntity(params);
				//将参数设置到httpPost中
				httpPost.setEntity(entity);
				response = httpClient.execute(httpPost);
			}else{
				//url?a=b&c=d
			}
			//获得服务端响应的数据
			InputStream is = response.getEntity().getContent();
			//将字节流is，转化为字符流
			Reader reader=new InputStreamReader(is);
			char[] b = new char[1024];
			int len=0; // 实际读取长度
			StringBuffer json = new StringBuffer(); 
			while((len=reader.read(b))!=-1){
				//System.out.println(new String(b,0,len));
				json.append(String.valueOf(b,0,len));
			}
			System.out.println(json);
			System.out.println("==============="+json.toString());
			//将json字符串转化为需要的数据格式
			JSONObject carMap=JSONObject.fromObject(json.toString());
			/*System.out.println(carMap.keySet());*/
			Map<String,T> map = new HashMap<String,T>();
			//carMap集合key的迭代器
			Iterator<String> it = carMap.keys();
			while(it.hasNext()){
				String key = it.next();
				Object carItemObj = carMap.get(key);
				//将carItemObj对象转化为CarItem对象
				T carItem = (T) JSONObject.
						toBean(JSONObject.fromObject(carItemObj), cls);
				map.put(key,carItem);
				//System.out.println(key+"   -------------------   "+carItem);
			}
			is.close();
			return map; 
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}
		/***
		 * 远程调用清空购物车
		 * **/
		public static Object httpUtilsClearCar(String url,Map<String,String> param,
				String method,String cookieValue){
			HttpResponse response=null;
			try{
				//1创建客户端对象
				HttpClient httpClient = HttpClients.createDefault();
				if("POST".equals(method)){
					//创建List集合
					List<NameValuePair> params = new ArrayList<NameValuePair>();
					//遍历Map集合
					for(Entry<String,String> e:param.entrySet()){
						String name=e.getKey();
						String value=e.getValue();
						NameValuePair nvp = new BasicNameValuePair(name, value);
						params.add(nvp);
					}
					//将url封装为对应的请求方式
					HttpPost httpPost = new HttpPost(url);
					httpPost.setHeader("Cookie", "sso_token="+cookieValue);
					//对发送到服务器的参数进行编码
					StringEntity entity= new UrlEncodedFormEntity(params);
					//将参数设置到httpPost中
					httpPost.setEntity(entity);
					response = httpClient.execute(httpPost);
				}else{
					//url?a=b&c=d
				}
				//获得服务端响应的数据
				Long size=response.getEntity().getContentLength();
				InputStream is = response.getEntity().getContent();
				System.out.println("size="+size);
				byte[] b = new byte[1024*2];
				int len=0; // 实际读取长度
				Object obj=null;
				while((len=is.read(b))!=-1){
					System.out.println("----------clear----------"+new String(b,0,len));
				}
				is.close();
				return obj;
			}catch(Exception ex){
				ex.printStackTrace();
			}
			return null;
		}
}
