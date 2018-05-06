/**
 * Project Name:ego-common
 * File Name:BinaryObjectUtils.java
 * Package Name:com.jyd.utils
 * Date:2017年8月15日下午8:37:37
 * Copyright (c) 2017
 *
 */
package com.jyd.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * 类名: BinaryObjectUtils
 * 备注:
 * 时间: 2017年8月15日 下午8:37:37
 * 作者:sylar
 * @version 
 * @since JDK 1.8
 */
public class BinaryObjectUtils {
	/**
	 * 
	 * 方法名:objToByteArray
	 * 备注:对象序列化
	 * 作者:sylar
	 * 时间:2017年8月15日下午8:58:01
	 * @param obj
	 * @return
	 * @since JDK 1.8
	 */
	public static byte[] objToByteArray(Object obj){
		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(baos);
			oos.writeObject(obj);
			return baos.toByteArray();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	/**
	 * 
	 * 方法名:byteArrayToObj
	 * 备注:对象反序列化
	 * 作者:sylar
	 * 时间:2017年8月15日下午9:00:56
	 * @param buf
	 * @return
	 * @since JDK 1.8
	 */
	public static Object byteArrayToObj(byte[] buf){
		try {
			ByteArrayInputStream bais = new ByteArrayInputStream(buf);
			ObjectInputStream ois = new ObjectInputStream(bais);
			return ois.readObject();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
