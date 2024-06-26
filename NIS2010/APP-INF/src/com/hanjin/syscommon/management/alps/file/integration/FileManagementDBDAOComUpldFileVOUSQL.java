/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ${FILE_NAME}.java
*@FileTitle : File Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.06
*@LastModifier : 김정훈
*@LastVersion : 1.0
* 2009.05.06 김정훈
* 1.0 Creation
=========================================================*/
package com.hanjin.syscommon.management.alps.file.integration;

import java.util.HashMap;

import org.apache.log4j.Logger;

import com.hanjin.framework.support.db.ISQLTemplate;

/**
 *
 * @author Jeong-Hoon, Kim
 * @see 
 * @since J2EE 1.4
 */

public class FileManagementDBDAOComUpldFileVOUSQL implements ISQLTemplate{

	private StringBuffer query = new StringBuffer();
	
	Logger log =Logger.getLogger(this.getClass());
	
	/** Parameters definition in params/param elements */
	private HashMap<String,String[]> params = null;
	
	/**
	  * <pre>
	  * 
	  * </pre>
	  */
	public FileManagementDBDAOComUpldFileVOUSQL(){
		setQuery();
		
		params = new HashMap<String,String[]>();
	}
	
	public String getSQL(){
		return query.toString();
	}
	
	public HashMap<String,String[]> getParams() {
		return params;
	}
	
	/**
	 * Query 생성
	 */
	public void setQuery(){
		
		query.append("/*").append("\n"); 
		query.append("Path : com.hanjin.syscommon.nis2010.management.file.filemanagement.integration").append("\n"); 
		query.append("FileName : FileManagementDBDAOComUpldFileVOUSQL").append("\n"); 
		query.append("*/").append("\n"); 
	}
}