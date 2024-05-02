/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AgncommagmthistoryDBDAO.java
*@FileTitle : Agent Commission Agreement History (master)
*Open Issues :
*Change history :
*@LastModifyDate : 2012.05.15
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2012.05.15 김영오
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.vo.AgncommagmtDetailHistoryVO;
import com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.vo.AgncommagmtMasterHistoryVO;
import com.clt.apps.opus.esm.acm.acmhistory.agncommagmthistory.vo.AgncommagmthistoryVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS AgncommagmthistoryDBDAO <br>
 * - OPUS-ACMAgreement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Young-Oh
 * @see AgncommagmthistoryBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class AgncommagmthistoryDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0017]
	 * Agent Commission Agreement History (master) - Agreement List 목록을 조회<br>
	 *
	 * @param AgncommagmthistoryVO agncommagmthistoryVO
	 * @return List<Agncommagmthistory>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgncommagmthistoryVO> searchAgncommagmthistory(AgncommagmthistoryVO agncommagmthistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgncommagmthistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agncommagmthistoryVO != null) {
				Map<String, String> mapVO = agncommagmthistoryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgncommagmthistoryDBDAOSearchAgncommagmthistoryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgncommagmthistoryVO.class);
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
	 * [ESM_ACM_0017]
	 * Agent Commission Agreement History (master) - Master History 목록을 조회<br>
	 *
	 * @param AgncommagmtMasterHistoryVO agncommagmtMasterHistoryVO
	 * @return List<Agncommagmthistory>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgncommagmtMasterHistoryVO> searchAgncommagmtMasterHistory(AgncommagmtMasterHistoryVO agncommagmtMasterHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgncommagmtMasterHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agncommagmtMasterHistoryVO != null) {
				Map<String, String> mapVO = agncommagmtMasterHistoryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgncommagmthistoryDBDAOSearchAgncommagmtMasterHistoryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgncommagmtMasterHistoryVO.class);
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
	 * [ESM_ACM_0017]
	 * Agent Commission Agreement History (master) - Detail(Compensation) History 목록을 조회<br>
	 *
	 * @param AgncommagmtDetailHistoryVO agncommagmtDetailHistoryVO
	 * @return List<Agncommagmthistory>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgncommagmtDetailHistoryVO> searchAgncommagmtDetailHistory(AgncommagmtDetailHistoryVO agncommagmtDetailHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgncommagmtDetailHistoryVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agncommagmtDetailHistoryVO != null) {
				Map<String, String> mapVO = agncommagmtDetailHistoryVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AgncommagmthistoryDBDAOSearchAgncommagmtDetailHistoryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgncommagmtDetailHistoryVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

}