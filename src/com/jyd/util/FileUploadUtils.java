/**
 * Project Name:ego-common
 * File Name:FileUploadUtils.java
 * Package Name:com.jyd.utils
 * Date:2017年8月12日下午8:05:09
 * Copyright (c) 2017
 *
 */
package com.jyd.util;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.springframework.web.multipart.MultipartFile;

/**
 * 类名: FileUploadUtils
 * 备注:
 * 时间: 2017年8月12日 下午8:05:09
 * 作者:sylar
 * @version 
 * @since JDK 1.8
 */
public class FileUploadUtils {
	public static String UploadImg(MultipartFile mf) {
		String savePath="/home/ftpuser";
		String newName=mf.getOriginalFilename();
		System.out.println(newName);
		newName = DateUtils.getFormatDate2()+newName.substring(newName.lastIndexOf("."));
		//创建InputStream对象
		InputStream is = null;
		try {
			is = new ByteArrayInputStream(mf.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		String url=null;
		//将图片上传到ftp服务器
		FtpUtils.uploadFile("192.168.124.30",21,
				"ftpuser","ftpuser", savePath, newName, is);
		url="http://www.ftpuser.com/"+newName;
		//封装上传的图片路径
		return url;
	}
}
