/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ExcelDownloadBCImpl.java
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

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.table.ComUpldFileVO;
import com.clt.sample.file.exceldownload.integration.ExcelDownloadDBDAO;

/**
 * 
 * ExcelDownloadBCImpl.java
 * @author Jeong-Hoon, KIM
 * @see 
 * @since J2SE 1.6
 * 2016. 1. 13.
 */
public class ExcelDownloadBCImpl extends BasicCommandSupport implements ExcelDownloadBC{

	// Database Access Object
	private transient ExcelDownloadDBDAO dbDao = null;

	/**
	 * 
	 * It's Constructor
	 * @author Jeong-Hoon, KIM
	 */
	public ExcelDownloadBCImpl() {
		dbDao = new ExcelDownloadDBDAO();
	}
	
	/**
	 * 
	 * comUpldFile
	 * @author Jeong-Hoon, KIM
	 * @param comUpldFile
	 * @return
	 * @throws EventException List<ComUpldFileVO>
	 */
	public List<ComUpldFileVO> comUpldFile(ComUpldFileVO comUpldFile) throws EventException {
		try {
			return dbDao.comUpldFile(comUpldFile);
		} catch(DAOException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
}