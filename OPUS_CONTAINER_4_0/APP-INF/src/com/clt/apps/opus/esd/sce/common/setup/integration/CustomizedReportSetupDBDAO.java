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
package com.clt.apps.opus.esd.sce.common.setup.integration;
   
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

import com.clt.apps.opus.esd.sce.common.setup.basic.CustomizedReportSetupBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * user별 customized Rpt Setup 정보를 C/R/U/D.<br>
 * 
 * @author HanSung Shin.
 * @see CustomizedReportSetupBCImpl 참조
 * @since J2EE 1.4
 */
public class CustomizedReportSetupDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * user별 Rpt Setup 정보를 조회한다.<br>
	 * 
	 * @param String usrId
	 * @param String usrOfcCd
	 * @param String pgmNo
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCustmRptForm(String usrId, String usrOfcCd, String pgmNo) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("user_id", usrId);
			param.put("user_ofc_cd", usrOfcCd);
			param.put("pgm_no", pgmNo);
			
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
	 * user별 Rpt Setup 정보를 등록 한다.
	 * 
	 * @param String usrId
	 * @param String usrOfcCd
	 * @param String pgmNo
	 * @param String rptInfoCtnt
	 * @throws DAOException
	 */
	public void insertCustmRptForm(String usrId, String usrOfcCd, String pgmNo, String rptInfoCtnt) throws DAOException {
		int insCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("user_id", usrId);
			param.put("user_ofc_cd", usrOfcCd);
			param.put("pgm_no", pgmNo);
			param.put("save_list", rptInfoCtnt);
			
			insCnt = new SQLExecuter("").executeUpdate(new CustomizedReportSetupDBDAOInsertCustmRptFormCSQL(), param, null);
			if(insCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * user별 Rpt Setup 정보를 수정 한다.
	 * 
	 * @param String usrId
	 * @param String usrOfcCd
	 * @param String pgmNo
	 * @param String rptInfoCtnt
	 * @throws DAOException
	 */
	public void updateCustmRptForm(String usrId, String usrOfcCd, String pgmNo, String rptInfoCtnt) throws DAOException {
		int insCnt = 0;
		Map<String, Object> param = new HashMap<String, Object>();
		
		try {
			param.put("user_id", usrId);
			param.put("user_ofc_cd", usrOfcCd);
			param.put("pgm_no", pgmNo);
			param.put("save_list", rptInfoCtnt);
			
			insCnt = new SQLExecuter("").executeUpdate(new CustomizedReportSetupDBDAOUpdateCustmRptFormUSQL(), param, null);
			if(insCnt== Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update SQL");
		} catch (SQLException se) {
			//se.printStackTrace();
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}