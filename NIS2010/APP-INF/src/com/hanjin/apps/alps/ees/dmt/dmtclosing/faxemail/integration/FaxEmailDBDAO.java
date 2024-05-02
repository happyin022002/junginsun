/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FaxEmailDBDAO.java
*@FileTitle : DEM/DET FaxEmail
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.23
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.09.23 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.faxemail.basic.FaxEmailBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * NIS2010 FaxEmailDBDAO <br>
 * - NIS2010-DMTClosing system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see FaxEmailBCImpl 참조
 * @since J2EE 1.6
 */

public class FaxEmailDBDAO extends DBDAOSupport {
	/**
	 * [Approval, Counter Offer, Reject 된 After Booking 요청자의] Email 정보를 [조회] 합니다.<br>
	 * 
	 * @param String darNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchAfterBookingUserEmailByDARNo(String darNo) throws DAOException {
		DBRowSet 				dbRowset 		= null;
		StringBuffer 			sbEmailList 	= new StringBuffer();
		//query parameter
		Map<String, Object> 	param 			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 		= new HashMap<String, Object>();

		try {
				param.put(		"aft_expt_dar_no", 	darNo	);
				velParam.put(	"aft_expt_dar_no", 	darNo	);

//			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
//					FaxEmailDBDAOSearchAfterBookingUserEmailByDARNoRSQL(), param, velParam);
				
			// 승인 권한자 Email 주소 조회
			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
					FaxEmailDBDAOSearchAfterBookingAproUserEmailByDARNoRSQL(), param, velParam);

			while (dbRowset.next()) {
				sbEmailList.append(dbRowset.getString(1)).append(";");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
		if (sbEmailList.length() > 1) {
			return sbEmailList.substring(0, sbEmailList.length() - 1);
		}
		return "";
	}
	
	/**
	 * [Approval, Counter Offer, Reject 된 Before Booking 요청자의] Email 정보를 [조회] 합니다.<br>
	 * 
	 * @param String darNo
	 * @param String mapgSeq
	 * @param String verNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchBeforeBookingUserEmailByDARNo(String darNo, String mapgSeq, String verNo) throws DAOException {
		DBRowSet 				dbRowset 		= null;
		StringBuffer 			sbEmailList 	= new StringBuffer();
		//query parameter
		Map<String, Object> 	param 			= new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> 	velParam 		= new HashMap<String, Object>();

		try {
				param.put(		"rfa_expt_dar_no", 		darNo	);
				param.put(		"rfa_expt_mapg_seq", 	mapgSeq	);
				param.put(		"rfa_expt_ver_seq", 	verNo	);
				
				velParam.put(	"rfa_expt_dar_no", 		darNo	);
				velParam.put(	"rfa_expt_mapg_seq", 	mapgSeq	);
				velParam.put(	"rfa_expt_ver_seq", 	verNo	);

			dbRowset = new SQLExecuter("DMT_HJSBAT").executeQuery((ISQLTemplate)new 
					FaxEmailDBDAOSearchBeforeBookingUserEmailByDARNoRSQL(), param, velParam);

			while (dbRowset.next()) {
				sbEmailList.append(dbRowset.getString(1)).append(";");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		if (sbEmailList.length() > 1) {
			return sbEmailList.substring(0, sbEmailList.length() - 1);
		}
		return "";
	}	
}
