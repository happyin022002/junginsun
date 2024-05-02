/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExcelDownloadUsingRowsetBC.java
*@FileTitle : ExcelDownloadUsingRowset
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.23
*@LastModifier : 김정훈
*@LastVersion : 1.0
* 2009.10.23 김정훈
* 1.0 Creation
=========================================================*/
package com.clt.sample.file.exceldownloadusingrowset.basic;

import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;

/**
 * 
 * ExcelDownloadUsingRowsetBC.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2SE 1.6
 * 2016. 1. 11.
 */
public interface ExcelDownloadUsingRowsetBC {

	/**
	 * 
	 * getRowSet
	 * @author Jeong-Hoon, KIM
	 * @return
	 * @throws EventException DBRowSet
	 */
	DBRowSet getRowSet() throws EventException ;

	String[] getTitle();

	String[] getColumns();
}