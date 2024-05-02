/*========================================================
*Copyright(c) 2009 CyberLogitec
*ProcessChain    : NPI
*@FileName       : FileUploadBC.java
*@FileTitle      : NIS2010
*Open Issues     :
*Change history  :
*@LastModifyDate : Apr 22, 2009
*@LastModifier   : Jeong-Hoon, KIM
*@LastVersion    : 1.0
=========================================================*/
package com.hanjin.syscommon.common.fileupload.basic;

import java.util.List;

import com.hanjin.framework.core.layer.event.EventException;

/**
 * It's FileUploadBC.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2EE 1.5
 * Apr 22, 2009
 */
public interface FileUploadBC {

	/**
	 * This method 
	 * @author Jeong-Hoon, KIM
	 * @param moduleId
	 * @param string 
	 */
	void moveUploadFile(List<String> object, String target) throws EventException ;

	/**
	 * 
	 * @param key
	 * @return
	 * @throws EventException
	 */
	public String copyUploadFile(String key) throws EventException;
	
	/**
	 * 
	 * @param keys
	 * @return
	 * @throws EventException
	 */
	public List<String> copyUploadFile(List<String> keys) throws EventException;
	
	/**
	 * 파일 존재 유무
	 * @param key
	 * @return
	 * @throws EventException
	 */
	public boolean fileDeleteCheck(String key)throws EventException;
}
