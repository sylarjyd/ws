package com.jyd.util;

import java.io.InputStream;

import org.apache.commons.net.ftp.FTP;
import org.apache.commons.net.ftp.FTPClient;

public class FtpUtils {

	/***
	 * 完成文件的ftp上传
	 * is：需要上传的文件对应的输入流对象
	 * path：上传到ftp服务器需要保存的目录
	 * **/
	public static String uploadFile(String host,int port 
			,String user,String pwd,String path,String newName
			,InputStream is){
		
		try{
			//创建FTPCLIENT对象
			FTPClient ftpClient = new FTPClient();
			//连接ftp服务器
			ftpClient.connect(host, port);
			//登陆ftp服务器
			ftpClient.login(user, pwd);
			
			System.out.println("------------ftp服务器连接成功-------------");
			//指定ftp的工作目录,上传的文件的保存目录
			ftpClient.changeWorkingDirectory(path);
			//指定文件上传类型(二进制类型)
			//ftp.type(FTP.BINARY_FILE_TYPE);
			ftpClient.setFileType(FTP.BINARY_FILE_TYPE);
			//实现文件上传
			ftpClient.storeFile(newName,is);
			is.close();
			//退出
			ftpClient.logout();
			ftpClient.disconnect();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return "http://www.ftpuser.com"+"/"+newName;
	}
}
