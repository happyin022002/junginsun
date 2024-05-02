/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : BreakBulkCargoDetailInquiryDBDAO.java
*@FileTitle : BKG CGO SPE Detail Popup - BB
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-27
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-27 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.breakbulkcargodetailinquiry.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.common.breakbulkcargodetailinquiry.basic.BreakBulkCargoDetailInquiryBCImpl;
import com.hanjin.apps.alps.esd.trs.common.breakbulkcargodetailinquiry.event.EsdTrs0937Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author juhyun
 * @see BreakBulkCargoDetailInquiryBCImpl 참조
 * @since J2EE 1.4
 */
public class BreakBulkCargoDetailInquiryDBDAO extends DBDAOSupport {


	/**
	 * BreakBulkCargoDetailInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchBreakBulkCargoDetailInquiry(EsdTrs0937Event event) throws DAOException {
		DBRowSet dRs = null;
		try{
			String sBkg_no = event.getBkgNo();
			
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("sBkg_no",sBkg_no);

	        SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
	        BreakBulkCargoDetailInquiryDBDAOSearchBreakBulkCargoDetailInquiryRSQL template = new BreakBulkCargoDetailInquiryDBDAOSearchBreakBulkCargoDetailInquiryRSQL();
	        
	        dRs = sqlExe.executeQuery(template, param, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		} 
		return dRs;
	}
}
