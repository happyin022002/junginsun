/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExcelDownloadBC.java
*@FileTitle : ExcelDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 김정훈
*@LastVersion : 1.0
* 2009.09.22 김정훈
* 1.0 Creation
=========================================================*/
package com.clt.sample.file.exceldownload.basic;

import java.util.List;

import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.table.ComUpldFileVO;

/**
 * 
 * ExcelDownloadBC.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2SE 1.6
 * 2016. 1. 11.
 */
public interface ExcelDownloadBC {

	/**
	 * 
	 * ComUpldFile
	 * @author Jeong-Hoon, KIM
	 * @param comUpldFile
	 * @return
	 * @throws EventException List<ComUpldFileVO>
	 */
	public List<ComUpldFileVO> comUpldFile(ComUpldFileVO comUpldFile) throws EventException;
}