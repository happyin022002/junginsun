/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : FFCmpnAgreementDBDAO.java
*@FileTitle : FF Compensation Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.02 김영오
* 1.0 Creation
* ------------------------------------------------------
* HISTORY
* 2012.12.05 김봉균 [CHM-201221834-01] Audit 기능 Multi Save 기능 추가
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.ffcmpnagreement.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.basic.AGNCommAgreementBCImpl;
import com.hanjin.apps.alps.esm.acm.acmagreement.ffcmpnagreement.vo.FFAgreementVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS AGNCommAgreementDBDAO <br>
 * - ALPS-ACMAgreement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Young-Oh
 * @see AGNCommAgreementBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class FFCmpnAgreementDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0023]
	 * FF Compensation Agreement Creation 목록을 조회<br>
	 *
	 * @param FFAgreementVO ffagreementVO
	 * @return List<FFAgreementVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FFAgreementVO> searchFFAgreement(FFAgreementVO ffagreementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FFAgreementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (ffagreementVO != null) {
				Map<String, String> mapVO= ffagreementVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new FFCmpnAgreementDBDAOFFAgreementRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FFAgreementVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	 
	/**
	 * [ESM_ACM_0023]
	 * FF Compensation Agreement Creation 목록을 저장<br>
	 *
	 * @param FFAgreementVO ffagreementVO
	 * @throws DAOException
	 */
	public void addFFAgreement(FFAgreementVO ffagreementVO) throws DAOException {
		int insCnt = 0;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(ffagreementVO != null ){
				Map<String, String> mapVO = ffagreementVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			insCnt = sqlExe.executeUpdate((ISQLTemplate) new FFCmpnAgreementDBDAOAddFFAgreementCSQL(),param, velParam);
			if (insCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0023]
	 * FF Compensation Agreement Creation 목록을 수정<br>
	 *
	 * @param List<FFAgreementVO> ffagreementVOs
	 * @throws DAOException
	 */
	public void modifyFFAgreement(List<FFAgreementVO> ffagreementVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (ffagreementVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new FFCmpnAgreementDBDAOModifyFFAgreementUSQL(), ffagreementVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0023]
	 * FF Compensation Agreement Creation 목록을 삭제<br>
	 * DELT_FLG 만 "Y"로 업데이트
	 * @param List<FFAgreementVO> ffagreementVOs
	 * @throws DAOException
	 */
	public void deleteFFAgreement(List<FFAgreementVO> ffagreementVOs)  throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (ffagreementVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new FFCmpnAgreementDBDAODeleteFFAgreementUSQL(), ffagreementVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


}