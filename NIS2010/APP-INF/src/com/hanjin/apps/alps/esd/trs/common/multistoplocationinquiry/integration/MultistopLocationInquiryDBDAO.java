/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : MultistopLocationInquiryDBDAO.java
*@FileTitle : Multi-stop Location Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-10
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-11-10 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.multistoplocationinquiry.integration;

import java.util.Map;
import java.sql.SQLException;
import java.util.HashMap;
import com.hanjin.apps.alps.esd.trs.common.multistoplocationinquiry.basic.MultistopLocationInquiryBCImpl;
import com.hanjin.apps.alps.esd.trs.common.multistoplocationinquiry.event.EsdTrs0933Event;
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
 * @see MultistopLocationInquiryBCImpl 참조
 * @since J2EE 1.4
 */
public class MultistopLocationInquiryDBDAO extends DBDAOSupport {

	/**
	 * MultistopLocationInquiry의 모든 목록을 가져온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchMultistopLocationInquiryList(EsdTrs0933Event event) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		String bkgnumber = event.getBkgNumber();
		String blnumber = event.getBlNumber();
		String cntrnumber = event.getCntrNumber();
		String troSeq = event.getTroSeq();
		String tpsznumber = event.getTpSzNumber();

		param.put("bkg_no", bkgnumber);
		param.put("bl_no", blnumber);
		param.put("cntr_no", cntrnumber);
		param.put("tro_seq", troSeq);
		param.put("cntr_tpsz_no", tpsznumber);

		try {
			
			dRs = new SQLExecuter().executeQuery(new MultistopLocationInquiryDBDAOsearchMultistopLocationInquiryListRSQL(), param,param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		} 
		return dRs;
	   }
}