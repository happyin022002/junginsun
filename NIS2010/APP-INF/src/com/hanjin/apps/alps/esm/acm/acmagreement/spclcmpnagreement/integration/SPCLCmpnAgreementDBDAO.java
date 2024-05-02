/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : SPCLCmpnAgreementDBDAO.java
*@FileTitle : Compensation Agreement Rate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.02
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.02 김영오
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.spclcmpnagreement.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.basic.AGNCommAgreementBCImpl;
import com.hanjin.apps.alps.esm.acm.acmagreement.spclcmpnagreement.vo.SCompAgreementVO;
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
public class SPCLCmpnAgreementDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0025]
	 * Special Compensation Agreement Creation 목록을 조회<br>
	 *
	 * @param SCompAgreementVO scompAgreementVO
	 * @return List<SCompAgreementVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SCompAgreementVO> searchSCompAgreement(SCompAgreementVO scompAgreementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SCompAgreementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (scompAgreementVO != null) {
				Map<String, String> mapVO= scompAgreementVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new SPCLCmpnAgreementDBDAOSCompAgreementRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SCompAgreementVO.class);
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
	 * [ESM_ACM_0025]
	 * Special Compensation Agreement Creation 목록을 저장<br>
	 *
	 * @param List<SCompAgreementVO> insertVoList
	 * @throws DAOException
	 */
	public void addSCompAgreement(List<SCompAgreementVO> insertVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SPCLCmpnAgreementDBDAOAddSPCLCmpnAgreementCSQL(), insertVoList, null);
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
	 * [ESM_ACM_0025]
	 * Special Compensation Agreement Creation 목록을 수정<br>
	 *
	 * @param List<SCompAgreementVO> scompAgreementVOs
	 * @throws DAOException
	 */
	public void modifySCompAgreement(List<SCompAgreementVO> scompAgreementVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (scompAgreementVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SPCLCmpnAgreementDBDAOModifySPCLCmpnAgreementUSQL(), scompAgreementVOs, null);
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
	 * [ESM_ACM_0025]
	 * Special Compensation Agreement Creation 목록을 삭제<br>
	 * DELT_FLG 만 "Y"로 업데이트
	 * @param List<SCompAgreementVO> scompAgreementVOs
	 * @throws DAOException
	 */
	public void deleteSCompAgreement(List<SCompAgreementVO> scompAgreementVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (scompAgreementVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new SPCLCmpnAgreementDBDAODeleteSPCLCmpnAgreementUSQL(), scompAgreementVOs, null);
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