/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : DangerCargoDetailInquiryDBDAO.java
*@FileTitle : BKG CGO SPE Detail Popup - DG
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : juhyun
*@LastVersion : 1.0
* 2006-10-30 juhyun
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.common.dangercargodetailinquiry.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.trs.common.dangercargodetailinquiry.basic.DangerCargoDetailInquiryBCImpl;
import com.clt.apps.opus.esd.trs.common.dangercargodetailinquiry.event.EsdTrs0938Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * ESD-TRS에 대한 DB 처리를 담당<br>
 * - ESD-TRS Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author juhyun
 * @see DangerCargoDetailInquiryBCImpl 참조
 * @since J2EE 1.4
 */
public class DangerCargoDetailInquiryDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * DangerCargoDetailInquiry의 모든 목록을 가져온다.<br>
	 * 
	 * @param event EsdTrs0938Event
	 * @return DBRowSet DB 처리 결과
	 * @throws DAOException
	 */
	public DBRowSet searchDangerCargoDetailInquiry(EsdTrs0938Event event) throws DAOException {
		// 데이터 전송을 위해 DB ResultSet을 구현한 객체
		DBRowSet dRs = null;
		try{
			
			String bkg_no = event.getBkgNo();
			String tro_seq = event.getTroSeq();
			String cntr_no = event.getCntrNo();			
			String sExsep = event.getUiContiCd();

			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			param.put("bkg_no",bkg_no);
			param.put("tro_seq",tro_seq);
			param.put("cntr_no",cntr_no);
			param.put("sExsep", sExsep);			

	        SQLExecuter sqlExe = new SQLExecuter("DEFAULT");	        
	        DangerCargoDetailInquiryDBDAOSearchDangerCargoRSQL template = new DangerCargoDetailInquiryDBDAOSearchDangerCargoRSQL();	        
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