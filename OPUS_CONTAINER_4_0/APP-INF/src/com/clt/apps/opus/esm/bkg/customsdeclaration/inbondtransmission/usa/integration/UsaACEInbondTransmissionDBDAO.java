/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : UsaACEInbondTransmissionDAO.java
 *@FileTitle : Generate Arrival Manifest by Container
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.01.27
 *@LastModifier : 민정호
 *@LastVersion : 1.0
 * 2009.04.22 민정호
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.basic.UsaInbondTransmissionBCImpl;
import com.clt.apps.opus.esm.bkg.customsdeclaration.inbondtransmission.usa.vo.UsaArrHeaderCondVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS UsaInbondTransmissionDAO <br>
 * - ALPS-InbondTransmission system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Kim Dowan
 * @see UsaInbondTransmissionBCImpl 참조
 * @since J2EE 1.4
 */
public class UsaACEInbondTransmissionDBDAO extends DBDAOSupport {
	/**
	 * Arrival header 를 조회한다.
	 * 
	 * @param UsaArrHeaderCondVO usaArrHeaderCondVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchArrHeader(UsaArrHeaderCondVO usaArrHeaderCondVO) throws DAOException {
		String retVal = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (usaArrHeaderCondVO != null) {
				Map<String, String> mapVO = usaArrHeaderCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaACEInbondTransmissionDBDAOsearchArrHeaderRSQL(), param, velParam);
			if (dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}	
	
	/**
	 * BL Arrival H01 정보를 조회한다.<br>
	 * 
	 * @param String blNo
	 * @param String arrDt
	 * @param String locCd
	 * @param String flag1
	 * @param String arrTime
	 * @return String
	 * @exception DAOException
	 */
	public String searchH01ForBl(String blNo, String arrDt, String locCd, String flag1, String arrTime) throws DAOException {
		String retVal = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("arr_dt", arrDt);
			velParam.put("arr_dt", arrDt);
			param.put("loc_cd", locCd);
			velParam.put("loc_cd", locCd);
			param.put("flag1", flag1);
			velParam.put("flag1", flag1);
			param.put("arr_time", arrTime);
			velParam.put("arr_time", arrTime);
			

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaACEInbondTransmissionDBDAOsearchH01RSQL(), param, velParam);

			if (dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}	

	/**
	 * Container Arrival H01 정보를 조회한다.<br>
	 * 
	 * @param blNo
	 * @param arrDt
	 * @param locCd
	 * @param cntrNo
	 * @param flag2
	 * @param arrTime
	 * @param ibd_trsp_no
	 * @return
	 * @throws DAOException
	 */
	public String searchH01ForCntr(String blNo, String arrDt, String locCd, String cntrNo, String flag2, String arrTime, String ibd_trsp_no) throws DAOException {
		String retVal = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("bl_no", blNo);
			velParam.put("bl_no", blNo);
			param.put("arr_dt", arrDt);
			velParam.put("arr_dt", arrDt);
			param.put("loc_cd", locCd);
			velParam.put("loc_cd", locCd);
			param.put("cntr_no", cntrNo);
			velParam.put("cntr_no", cntrNo);
			param.put("flag2", flag2);
			velParam.put("flag2", flag2);
			param.put("arr_time", arrTime);
			velParam.put("arr_time", arrTime);
			param.put("ibd_trsp_no", ibd_trsp_no);
			velParam.put("ibd_trsp_no", ibd_trsp_no);				

			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new UsaACEInbondTransmissionDBDAOsearchH01ForCntrRSQL(), param, velParam);

			if (dbRowset.getRowCount() > 0) {
				if (dbRowset.next()) {
					retVal = dbRowset.getString(1);
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}	
}