/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : AwkWardCargoDetailInquiryDBDAO.java
*@FileTitle : BKG CGO SPE Detail Popup - AK
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-30 juhyun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.common.awkwardcargodetailinquiry.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esd.trs.common.awkwardcargodetailinquiry.basic.AwkWardCargoDetailInquiryBCImpl;
import com.hanjin.apps.alps.esd.trs.common.awkwardcargodetailinquiry.event.EsdTrs0936Event;
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
 * @see AwkWardCargoDetailInquiryBCImpl 참조
 * @since J2EE 1.4
 */
public class AwkWardCargoDetailInquiryDBDAO extends DBDAOSupport {

	/**
	 * AwkWardCargoDetailInquiry의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchAwkWardCargoDetailInquiry(EsdTrs0936Event event) throws DAOException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체		
		DBRowSet dRs = null;		
		try{
			String bkg_no = event.getBkgNo();
			String cntr_no = event.getCntrNo();
			String tro_seq = event.getTroSeq();
			String sExsep= event.getUiContiCd();
			
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no",bkg_no);
			param.put("tro_seq",tro_seq);
			param.put("cntr_no",cntr_no);
			param.put("sExsep", sExsep);	

	        SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
	        AwkWardCargoDetailInquiryDBDAOSearchAwkWardCargoDetailInquiryRSQL template = new AwkWardCargoDetailInquiryDBDAOSearchAwkWardCargoDetailInquiryRSQL();	        
	        dRs = sqlExe.executeQuery(template, param, param);
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