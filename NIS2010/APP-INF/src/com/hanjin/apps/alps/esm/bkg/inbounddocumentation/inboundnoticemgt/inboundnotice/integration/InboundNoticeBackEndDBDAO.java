/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InboundNoticeBackEndDBDAO.java
*@FileTitle : Inbound Customer Code Validation Background Job
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.04.28 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS InboundNoticeBackEndDBDAO <br>
 * - ALPS-InboundNoticeMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Park Mangeon
 * @see InboundNoticeMgt 참조
 * @since J2EE 1.4
 */
public class InboundNoticeBackEndDBDAO extends DBDAOSupport {
	
	/**
	 * UI-BKG-1054 Customer code Validation<br>
	 * Booking Customer가 Match된 정보에 대하여 Arrival Notice Detail정보를 생성한다.<br>
	 * @param ArrNtcSearchVO arrNtcSearch 검색조회 조건
	 * @exception DAOException
	 * @author Park Mangeon
	 */
	public void modifyArrNtcDetail(ArrNtcSearchVO arrNtcSearch) throws DAOException {
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			Map<String, String> mapVO = arrNtcSearch.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			//sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new InboundNoticeBackEndDBDAOmodifyArrNtcDetailUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to merge SQL");
				
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * UI-BKG-1054 Customer code Validation<br>
	 * Booking Customer가 Match된 정보에 대하여 Arrival Notice Master정보를 생성한다.<br>
	 * @param ArrNtcSearchVO arrNtcSearch 검색조회 조건
	 * @exception DAOException
	 * @author Park Mangeon
	 */
	public void modifyArrNtc(ArrNtcSearchVO arrNtcSearch) throws DAOException {
		try {
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			int result = 0;
			Map<String, String> mapVO = arrNtcSearch.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new InboundNoticeBackEndDBDAOmodifyArrNtcUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to merge SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * UI-BKG-1054 Customer Code Validation<br>
	 * Validation시간을 일정하게 설정하기 위하여 Validation에 의해 Data가 Update되는 시간을 조회한다.<br>
	 *  @return String  작업 시작 일시분초
	 *  @exception DAOException
	 *  @author Park Mangeon
	 */
	public String searchJobStartDate() throws DAOException {
		String systemDate  = null;
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new InboundNoticeBackEndDBDAOsearchJobStartDateRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0) {
				dbRowset.next();
				systemDate = dbRowset.getString("SYSTEM_DATE");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return systemDate;
	}

	
}
