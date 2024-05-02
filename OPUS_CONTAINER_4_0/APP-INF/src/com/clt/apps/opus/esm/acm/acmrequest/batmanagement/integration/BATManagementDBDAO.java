/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : BATManagementDBDAO.java
*@FileTitle : Batch Management
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.25
*@LastModifier : 김봉균
*@LastVersion : 1.0
* 2012.05.25 김봉균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmrequest.batmanagement.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.acm.acmrequest.batmanagement.basic.BATManagementBCImpl;
import com.clt.apps.opus.esm.acm.acmrequest.batmanagement.vo.BATManagementVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS BATManagementDBDAO <br>
 * - OPUS-BATManagement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM BONG-GYOON
 * @see BATManagementBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class BATManagementDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0032]
	 * Mass Calculation Batch List 조회<br>
	 *
	 * @param BATManagementVO batManagementVO
	 * @return List<BATManagementVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BATManagementVO> searchBatchManagement(BATManagementVO batManagementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BATManagementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (batManagementVO != null) {
				Map<String, String> mapVO= batManagementVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BATManagementDBDAOSearchBatchManagementListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BATManagementVO.class);
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
	 * [ESM_ACM_0032]
	 * Simulation Batch List 조회<br>
	 *
	 * @param BATManagementVO batManagementVO
	 * @return List<BATManagementVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<BATManagementVO> searchSimBatchManagement(BATManagementVO batManagementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BATManagementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (batManagementVO != null) {
				Map<String, String> mapVO= batManagementVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new BATManagementDBDAOSearchSimBatchManagementListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BATManagementVO.class);
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
	 * [ESM_ACM_0032] Cancel Batch(Mass Calculation Batch)<br>
	 * 현재 진행되고 있지 않은 Batch Cancel<br>
	 *
	 * @param List<BATManagementVO> batManagementVOList
	 * @throws DAOException
	 */
	public void deleteBatchManagement(List<BATManagementVO> batManagementVOList) throws DAOException {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (batManagementVOList.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new BATManagementDBDAODeleteBatchManagementListUSQL(), batManagementVOList, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No"+ i + " SQL");
				}
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}