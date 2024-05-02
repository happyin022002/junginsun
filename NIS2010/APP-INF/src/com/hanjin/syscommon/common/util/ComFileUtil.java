package com.hanjin.syscommon.common.util;

import java.util.ArrayList;
import java.util.List;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.syscommon.common.fileupload.basic.FileUploadBC;
import com.hanjin.syscommon.common.fileupload.basic.FileUploadBCImpl;

public class ComFileUtil {

	/**
	 * 
	 * @param key
	 * @return
	 * @throws EventException
	 */
	public static String copyUploadFile(String key) throws EventException {
		String newkeys;
		FileUploadBC command = new FileUploadBCImpl();
		try {
			newkeys = command.copyUploadFile(key);
		} catch (Exception e) {
			throw new EventException("[Exception]" + e);
		}
		return newkeys;
	}
	
	/**
	 * 
	 * @param keys
	 * @return
	 * @throws EventException
	 */
	public List<String> copyUploadFile(List<String> keys) throws EventException {
		List<String> newkeys = new ArrayList<String>();
		FileUploadBC command = new FileUploadBCImpl();
		try {
			newkeys = command.copyUploadFile(newkeys);
		} catch (Exception e) {
			throw new EventException("[Exception]" + e);
		}
		return newkeys;
	}
	
	/**
	 * 파일이 존재하는지 체크
	 * @param key
	 * @return
	 * @throws EventException 
	 */
	public boolean fileDeleteCheck(String key) throws EventException{
		FileUploadBC command = new FileUploadBCImpl();
		try {
			if(command.fileDeleteCheck(key)) return true;
		} catch (Exception e) {
			throw new EventException("[Exception]" + e);
		}
		return false;
	}
}
