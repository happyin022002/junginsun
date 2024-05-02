/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : RailTransitReportDBDAO.java
*@FileTitle : RailTransitReportDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-16
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-16 Seong-mun Kang
* 1.0 최초 생성
* 
* 2009-02-19 iskim
* 	(1) N200902130040	[SCEM] RTR 조회 대상 보완 요청 
* 		delt_flg = 'Y' 인건은 조회 되지 않게 수정
* 2009-03-04 iskim
* 	(1) R200903040003	2월 소스품질 검토 결과 follow-up
=========================================================*/
package com.hanjin.apps.alps.esd.sce.common.setup.integration;
   
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.management.alps.role.event.ComSys007Event;


/**
 * user별 customized Rpt Setup 정보를 C/R/U/D.<br>
 * 
 * @author HanSung Shin.
 * @see CustomizedReportSetupBCImpl 참조
 * @since J2EE 1.4
 */
public class CustomizedReportSetupDBDAO extends DBDAOSupport {
	
	/**
	 * 기본 default report setup 정보를 조회한다 (master table: SCE_USA_INLND_OP_RPT_COL)
	 * 
	 * @param String usrId
	 * @param String usrOfcCd
	 * @param String pgmNo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchRptForm(String usrId, String usrOfcCd)
			throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			param.put("user_id", usrId);
			param.put("user_ofc_cd", usrOfcCd);
			 
			log.info("DBDAO, searchRPTForm, 66lines, test123");
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomizedReportSetupDBDAOSearchRptFormRSQL(),
					param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * user별로 등록되어 저장된 report 정보를 조회한다 (customized table: SCE_USA_INLND_OP_RPT_FOM)
	 * 
	 * @param String usrId
	 * @param String usrOfcCd
	 * @param String pgmNo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public DBRowSet searchCustmRptForm(String usrId, String usrOfcCd)
			throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("user_id", usrId);
			param.put("user_ofc_cd", usrOfcCd);
			
			dbRowset = new SQLExecuter("").executeQuery(
					(ISQLTemplate) new CustomizedReportSetupDBDAOSearchCustmRptFormRSQL(),
					param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * user가 customizing하여 선택한 항목에 대한 report setup 정보를 등록 한다.
	 * 
	 * @param String usrId
	 * @param String usrOfcCd
	 * @param String pgmNo
	 * @see ComSys007Event
	 * @throws DAOException
	 */
	public void insertCustmRptForm(String usrId, String usrOfcCd, String[] coldesc2, String[] chk2) throws DAOException {
		
		int a = coldesc2.length;
		int insCnt;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			
			for(int i=0; i<coldesc2.length; i++){
				param.put("user_id", usrId);
				param.put("user_ofc_cd", usrOfcCd);
				param.put("coldesc2", coldesc2[i]);

					insCnt = new SQLExecuter("").executeUpdate(new CustomizedReportSetupDBDAOInsertCustmRptFormCSQL(), param, null);
					if(insCnt== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
			}
		
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * customized report 저장시 리셋을 위해 기존 user별로 등록된 report setup 정보를 삭제 한다.
	 * 
	 * @param String usrId
	 * @param String usrOfcCd
	 * @param String pgmNo
	 * @see ComSys007Event
	 * @throws DAOException
	 */
	public void deleteCustmRptForm(String usrId, String usrOfcCd) throws DAOException {


		int insCnt;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
				param.put("user_id", usrId);
				param.put("user_ofc_cd", usrOfcCd);
				insCnt = new SQLExecuter("").executeUpdate(new CustomizedReportSetupDBDAODeleteCustmRptFormDSQL(), param, velParam);
				if(insCnt== Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to update SQL");
		
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}