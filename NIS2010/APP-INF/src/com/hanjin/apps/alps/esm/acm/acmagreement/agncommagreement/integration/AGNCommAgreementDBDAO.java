/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : AGNCommAgreementDBDAO.java
*@FileTitle : AGNCommAgreementDBDAO
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.20
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.20 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.basic.AGNCommAgreementBCImpl;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.AgentMinimumCommissionVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.AgentRateDetailSubVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.AgentRateDetailVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.AgentRateMasterVO;
import com.hanjin.apps.alps.esm.acm.acmagreement.agncommagreement.vo.CodeDescVO;
import com.hanjin.apps.alps.esm.acm.acmapproval.agncommapproval.vo.AGNCommApprovalMasterVO;
import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration.AGNCommRequestDBDAOGetSpclAgmtCntRSQL;
import com.hanjin.bizcommon.csr.csrapproval.vo.ComCsrRequestAgmtVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/** 
 * ALPS AGNCommAgreementDBDAO <br>
 * - ALPS-ACMAgreement system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Sang-Soo
 * @see AGNCommAgreementBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class AGNCommAgreementDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0001-01 / ESM_ACM_0001-03 / ESM_ACM_0101]
	 * [Master]탭 / [Summary]탭 - Master 목록을 조회<br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @return List<AgentRateMasterVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgentRateMasterVO> searchAgentRateMaster(AgentRateMasterVO agentRateMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgentRateMasterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agentRateMasterVO != null) {
				Map<String, String> mapVO= agentRateMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommAgreementDBDAOSearchAgentRateMasterListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgentRateMasterVO.class);
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
	 * [ESM_ACM_0001-01]
	 * ACM_AGN_AGMT_MST 테이블에서 AGN_FM_DT, AGN_TO_DT로 중복 체크<br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @return List<AgentRateMasterVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgentRateMasterVO> getDupDataFromAcmAgmAgmtMstInfo(AgentRateMasterVO agentRateMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgentRateMasterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agentRateMasterVO != null) {
				Map<String, String> mapVO= agentRateMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommAgreementDBDAOGetDupDataFromAcmAgnAgmtMstInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgentRateMasterVO.class);
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
	 * [ESM_ACM_0001-01]
	 * [Master]탭 목록을 일괄적으로 생성<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgentRateMaster(List<AgentRateMasterVO> agentRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgentRateMasterListCSQL(), agentRateMasterVOlist, null);
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
	 * [ESM_ACM_0001-01]
	 * [Master]탭 목록을 일괄적으로 수정<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOlist
	 * @throws DAOException
	 */
	public void modifyAgentRateMaster(List<AgentRateMasterVO> agentRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (agentRateMasterVOlist.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOModifyAgentRateMasterListUSQL(), agentRateMasterVOlist, null);
				for (int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
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
	 * [ESM_ACM_0001-02 / ESM_ACM_0001-03]
	 * [Detail]탭 - Compensation Master / [Summary]탭 - Detail 목록을 조회<br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @return List<AgentRateDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgentRateDetailVO> searchAgentRateDetail(AgentRateMasterVO agentRateMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgentRateDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agentRateMasterVO != null) {
				Map<String, String> mapVO= agentRateMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommAgreementDBDAOSearchAgentRateDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgentRateDetailVO.class);
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Compensation Master의 한 Row 에 해당하는 Minimum Commission 목록을 조회<br>
	 *
	 * @param AgentMinimumCommissionVO agentMinimumCommissionVO
	 * @return List<AgentMinimumCommissionVO>
	 * @exception EventException
	 */
	 public List<AgentMinimumCommissionVO> searchAgentRateMinComm(AgentMinimumCommissionVO agentMinimumCommissionVO)  throws DAOException {
		DBRowSet dbRowset = null;
		List<AgentMinimumCommissionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agentMinimumCommissionVO != null) {
				Map<String, String> mapVO= agentMinimumCommissionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommAgreementDBDAOSearchAgentRateMinCommListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgentMinimumCommissionVO.class);
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Compensation Master 목록을 일괄적으로 생성하기 전 AGN_AGMT_SEQ 조회<br>
	 *
	 * @param AgentRateDetailVO agentRateDetailVO
	 * @return List<AgentRateDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgentRateDetailVO> getAgnAgmtSeqInfo(AgentRateDetailVO agentRateDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgentRateDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agentRateDetailVO != null) {
				Map<String, String> mapVO= agentRateDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommAgreementDBDAOGetAgnAgmtSeqInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgentRateDetailVO.class);
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Compensation Master 목록을 일괄적으로 생성<br>
	 *
	 * @param List<AgentRateDetailVO> agentRateDetailVOList
	 * @throws DAOException
	 */
	public void addAgentRateDetail(List<AgentRateDetailVO> agentRateDetailVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateDetailVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgentRateDetailListCSQL(), agentRateDetailVOList, null);
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Compensation Master 목록을 일괄적으로 수정<br>
	 *
	 * @param List<AgentRateDetailVO> agentRateDetailVOList
	 * @throws DAOException
	 */
	public void modifyAgentRateDetail(List<AgentRateDetailVO> agentRateDetailVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (agentRateDetailVOList.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOModifyAgentRateDetailListUSQL(), agentRateDetailVOList, null);
				for (int i=0; i<updCnt.length; i++) {
					if (updCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Compensation Master 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<AgentRateDetailVO> agentRateDetailVOList
	 * @throws DAOException
	 */
	public void removeAgentRateDetail(List<AgentRateDetailVO> agentRateDetailVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (agentRateDetailVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAORemoveAgentRateDetailListDSQL(), agentRateDetailVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Compensation Rate의 Container TP/SZ 목록을 일괄적으로 생성<br>
	 *
	 * @param List<AgentRateDetailSubVO> agentRateDetailSubVOList
	 * @throws DAOException
	 */
	public void addAgentRateDetailCntr(List<AgentRateDetailSubVO> agentRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateDetailSubVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgentRateDetailCntrListCSQL(), agentRateDetailSubVOList, null);
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Compensation Rate의 Container TP/SZ 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<AgentRateDetailSubVO> agentRateDetailSubVOList
	 * @throws DAOException
	 */
	public void removeAgentRateDetailCntr(List<AgentRateDetailSubVO> agentRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (agentRateDetailSubVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAORemoveAgentRateDetailCntrListDSQL(), agentRateDetailSubVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Compensation Rate의 Route 목록을 일괄적으로 생성<br>
	 *
	 * @param List<AgentRateDetailSubVO> agentRateDetailSubVOList
	 * @throws DAOException
	 */
	public void addAgentRateDetailRout(List<AgentRateDetailSubVO> agentRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateDetailSubVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgentRateDetailRoutListCSQL(), agentRateDetailSubVOList, null);
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Compensation Rate의 Route 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<AgentRateDetailSubVO> agentRateDetailSubVOList
	 * @throws DAOException
	 */
	public void removeAgentRateDetailRout(List<AgentRateDetailSubVO> agentRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (agentRateDetailSubVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAORemoveAgentRateDetailRoutListDSQL(), agentRateDetailSubVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Compensation Rate의 Charge 목록을 일괄적으로 생성<br>
	 *
	 * @param List<AgentRateDetailSubVO> agentRateDetailSubVOList
	 * @throws DAOException
	 */
	public void addAgentRateDetailChg(List<AgentRateDetailSubVO> agentRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateDetailSubVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgentRateDetailChgListCSQL(), agentRateDetailSubVOList, null);
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Compensation Rate의 Charge 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<AgentRateDetailSubVO> agentRateDetailSubVOList
	 * @throws DAOException
	 */
	public void removeAgentRateDetailChg(List<AgentRateDetailSubVO> agentRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (agentRateDetailSubVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAORemoveAgentRateDetailChgListDSQL(), agentRateDetailSubVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [ESM_ACM_0001-01 / ESM_ACM_0101]
	 * New Agreement No. 조회<br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @return List<AgentRateMasterVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgentRateMasterVO> getNewAgreementNo(AgentRateMasterVO agentRateMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgentRateMasterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agentRateMasterVO != null) {
				Map<String, String> mapVO= agentRateMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommAgreementDBDAOGetNewAgreementNoInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgentRateMasterVO.class);
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
	 * [ESM_ACM_0101]
	 * 사용자가 입력한 Agreement No.의 유효성 검증<br>
	 *
	 * @param AgentRateMasterVO agentRateMasterVO
	 * @return List<AgentRateMasterVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgentRateMasterVO> getAgreementNoInfo(AgentRateMasterVO agentRateMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgentRateMasterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agentRateMasterVO != null) {
				Map<String, String> mapVO= agentRateMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommAgreementDBDAOGetAgreementNoInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgentRateMasterVO.class);
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
	 * [ESM_ACM_0101]
	 * New Ageement No.로 저장되어 있을 수 있는 Master목록을 일괄적으로 삭제<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOList
	 * @throws DAOException
	 */
	public void removeAgmtCopyMaster(List<AgentRateMasterVO> agentRateMasterVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (agentRateMasterVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAORemoveAgmtCopyMasterListDSQL(), agentRateMasterVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [ESM_ACM_0101]
	 * New Ageement No.로 저장되어 있을 수 있는 Detail목록을 일괄적으로 삭제<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOList
	 * @throws DAOException
	 */
	public void removeAgmtCopyDetail(List<AgentRateMasterVO> agentRateMasterVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (agentRateMasterVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAORemoveAgmtCopyDetailListDSQL(), agentRateMasterVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [ESM_ACM_0101]
	 * New Ageement No.로 저장되어 있을 수 있는 TP/SZ목록을 일괄적으로 삭제<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOList
	 * @throws DAOException
	 */
	public void removeAgmtCopyDetailCntr(List<AgentRateMasterVO> agentRateMasterVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (agentRateMasterVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAORemoveAgmtCopyDetailCntrListDSQL(), agentRateMasterVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [ESM_ACM_0101]
	 * New Ageement No.로 저장되어 있을 수 있는 Route목록을 일괄적으로 삭제<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOList
	 * @throws DAOException
	 */
	public void removeAgmtCopyDetailRout(List<AgentRateMasterVO> agentRateMasterVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (agentRateMasterVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAORemoveAgmtCopyDetailRoutListDSQL(), agentRateMasterVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [ESM_ACM_0101]
	 * New Ageement No.로 저장되어 있을 수 있는 Charge 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOList
	 * @throws DAOException
	 */
	public void removeAgmtCopyDetailChg(List<AgentRateMasterVO> agentRateMasterVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (agentRateMasterVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAORemoveAgmtCopyDetailChgListDSQL(), agentRateMasterVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [ESM_ACM_0101]
	 * 선택된 Agreement No.의 Master목록을 일괄적으로 New Ageement No.로 생성<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgmtCopyMaster(List<AgentRateMasterVO> agentRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgmtCopyMasterListCSQL(), agentRateMasterVOlist, null);
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
	 * [ESM_ACM_0101]
	 * 선택된 Agreement No.의 Detail목록을 일괄적으로 New Ageement No.로 생성<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgmtCopyDetail(List<AgentRateMasterVO> agentRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgmtCopyDetailListCSQL(), agentRateMasterVOlist, null);
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
	 * [ESM_ACM_0101]
	 * 선택된 Agreement No.의 TP/SZ목록을 일괄적으로 New Ageement No.로 생성<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgmtCopyDetailCntr(List<AgentRateMasterVO> agentRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgmtCopyDetailCntrListCSQL(), agentRateMasterVOlist, null);
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
	 * [ESM_ACM_0101]
	 * 선택된 Agreement No.의 Route목록을 일괄적으로 New Ageement No.로 생성<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgmtCopyDetailRout(List<AgentRateMasterVO> agentRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgmtCopyDetailRoutListCSQL(), agentRateMasterVOlist, null);
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
	 * [ESM_ACM_0101]
	 * 선택된 Agreement No.의 Charge 목록을 일괄적으로 New Ageement No.로 생성<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgmtCopyDetailChg(List<AgentRateMasterVO> agentRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgmtCopyDetailChgListCSQL(), agentRateMasterVOlist, null);
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 목록을 일괄적으로 생성 후 [히스토리 테이블에 등록]<br>
	 *
	 * @param List<AgentRateDetailVO> agentRateDetailVOlist
	 * @throws DAOException
	 */
	public void addAgentRateDetailHis(List<AgentRateDetailVO> agentRateDetailVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateDetailVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgentRateDetailHistoryListCSQL(), agentRateDetailVOlist, null);
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
	 * [ESM_ACM_0001-01]
	 * [Master]탭 목록을 일괄적으로 생성 후 [히스토리 테이블에 등록]<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgentRateMasterHis(List<AgentRateMasterVO> agentRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgentRateMasterHistoryListCSQL(), agentRateMasterVOlist, null);
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
	 * [ESM_ACM_0004]
	 * AGN_INFO_SEQ MAX 값 구하기<br>
	 *
	 * @exception DAOException
	 */
	public String getAgnAgmtHisSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String agnAgmtHisSeq = "";

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommAgreementDBDAOGetAgentRateMasterHistorySeqRSQL(), null, null);
			if(dbRowset.next()) {
				agnAgmtHisSeq = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return agnAgmtHisSeq;
	}
	
	////////////////////////////////////////////////
	/**
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Compensation Rate의 Container TP/SZ 목록을 일괄적으로 생성 후 [히스토리 테이블에 등록]<br>
	 *
	 * @param List<AgentRateDetailSubVO> agentRateDetailSubVOList
	 * @throws DAOException
	 */
	public void addAgentRateDetailCntrHis(List<AgentRateDetailSubVO> agentRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateDetailSubVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgentRateDetailCntrHisListCSQL(), agentRateDetailSubVOList, null);
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Compensation Rate의 Route 목록을 일괄적으로 생성 후 [히스토리 테이블에 등록]<br>
	 *
	 * @param List<AgentRateDetailSubVO> agentRateDetailSubVOList
	 * @throws DAOException
	 */
	public void addAgentRateDetailRoutHis(List<AgentRateDetailSubVO> agentRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateDetailSubVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgentRateDetailRoutHisListCSQL(), agentRateDetailSubVOList, null);
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Compensation Rate의 Charge 목록을 일괄적으로 생성 후 [히스토리 테이블에 등록]<br>
	 *
	 * @param List<AgentRateDetailSubVO> agentRateDetailSubVOList
	 * @throws DAOException
	 */
	public void addAgentRateDetailChgHis(List<AgentRateDetailSubVO> agentRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateDetailSubVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgentRateDetailChgHisListCSQL(), agentRateDetailSubVOList, null);
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
	
	
	//////////////////////////////////////
	/**
	 * [ESM_ACM_0101]
	 * 선택된 Agreement No.의 Master목록을 일괄적으로 New Ageement No.로 생성 후 [히스토리 테이블에 등록]<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgmtCopyMasterHis(List<AgentRateMasterVO> agentRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgmtCopyMasterHisListCSQL(), agentRateMasterVOlist, null);
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
	 * [ESM_ACM_0101]
	 * 선택된 Agreement No.의 Detail목록을 일괄적으로 New Ageement No.로 생성 후 [히스토리 테이블에 등록]<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgmtCopyDetailHis(List<AgentRateMasterVO> agentRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgmtCopyDetailHisListCSQL(), agentRateMasterVOlist, null);
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
	 * [ESM_ACM_0101]
	 * 선택된 Agreement No.의 TP/SZ목록을 일괄적으로 New Ageement No.로 생성 후 [히스토리 테이블에 등록]<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgmtCopyDetailCntrHis(List<AgentRateMasterVO> agentRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgmtCopyDetailCntrHisListCSQL(), agentRateMasterVOlist, null);
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
	 * [ESM_ACM_0101]
	 * 선택된 Agreement No.의 Route목록을 일괄적으로 New Ageement No.로 생성 후 [히스토리 테이블에 등록]<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgmtCopyDetailRoutHis(List<AgentRateMasterVO> agentRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgmtCopyDetailRoutHisListCSQL(), agentRateMasterVOlist, null);
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
	 * [ESM_ACM_0101]
	 * 선택된 Agreement No.의 Charge 목록을 일괄적으로 New Ageement No.로 생성 후 [히스토리 테이블에 등록]<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgmtCopyDetailChgHis(List<AgentRateMasterVO> agentRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgmtCopyDetailChgHisListCSQL(), agentRateMasterVOlist, null);
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
	 * [ESM_ACM_0001] Agent Commission Agreement Creation<br>
	 *
	 * @param String agmtNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchAcmAgnAgmtNoData(String agmtNo) throws DAOException {
		DBRowSet dbRowset = null;
		String newAgmtNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (agmtNo != null) {
				param.put("agmt_no", agmtNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommAgreementDBDAOSearchAcmAgmtNoDataRSQL(), param, null);
			if(dbRowset.next()) {
				newAgmtNo = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return newAgmtNo;
	}

	/**
	 * [ESM_ACM_0001] Agent Commission Agreement Creation<br>
	 *
	 * @param String agmtNo
	 * @return String
	 * @throws DAOException
	 */
	public String searchAcmFfAgmtNoData(String agmtNo) throws DAOException {
		DBRowSet dbRowset = null;
		String newAgmtNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (agmtNo != null) {
				param.put("agmt_no", agmtNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommAgreementDBDAOSearchAcmFfAgmtNoDataRSQL(), param, null);
			if(dbRowset.next()) {
				newAgmtNo = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return newAgmtNo;
	}
	
	/**
	 * [ESM_ACM_0009]
	 * GW에 EAI전송하기위한 ACM 계약서 정보 가져오기@@<br>
	 * @param AGNCommApprovalMasterVO
	 * @return AgentRateMasterVO
	 * @exception DAOException
	 */
	public List<AgentRateMasterVO> getAgmtDocInfo(AGNCommApprovalMasterVO agnCommApprovalMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgentRateMasterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agnCommApprovalMasterVO != null) {
				Map<String, String> mapVO= agnCommApprovalMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommAgreementDBDAOSerachAgmtDocRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgentRateDetailVO.class);
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
	 * CSR I/F 화면서 호출<br>
	 * @param String csrNo
     * @return List<ComCsrRequestAgmtVO>
     * @throws DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ComCsrRequestAgmtVO> printComCsrAgmtInfo2(String csrNo) throws DAOException {
    	DBRowSet dbRowset = null;
        List<ComCsrRequestAgmtVO> list = null;
       
        try{
        	// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
            
        	//  Cargo Claim No
        	param.put("csr_no", csrNo);
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommAgreementDBDAOSearchAgmtAttach2RSQL(), param, velParam);          
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ComCsrRequestAgmtVO.class);
            
        }catch(SQLException se){
            log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(), se);
        }catch(Exception ex){
            log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
        return list;
    }
    
    /**
	 * Charge Code 목록을 조회<br>
	 *
	 * @param CodeDescVO codeDescVO
	 * @return List<CodeDescVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CodeDescVO> searchChargeCode(CodeDescVO codeDescVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CodeDescVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (codeDescVO != null) {
				Map<String, String> mapVO= codeDescVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommAgreementDBDAOSearchChargeCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CodeDescVO.class);
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Charge Commission의 Charge 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<AgentRateDetailSubVO> agentRateDetailSubVOList
	 * @throws DAOException
	 */
	public void removeAgentRateCommChg(List<AgentRateDetailSubVO> agentRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (agentRateDetailSubVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAORemoveAgentRateCommChgListDSQL(), agentRateDetailSubVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Minimum Commission의 Charge 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<AgentRateDetailSubVO> agentRateDetailSubVOList
	 * @throws DAOException
	 */
	public void removeAgentRateMinComm(List<AgentRateDetailSubVO> agentRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (agentRateDetailSubVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAORemoveAgentRateMinCommListDSQL(), agentRateDetailSubVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Charge Commission의 Charge 목록을 일괄적으로 생성<br>
	 *
	 * @param List<AgentRateDetailSubVO> agentRateDetailSubVOList
	 * @throws DAOException
	 */
	public void addAgentRateCommChg(List<AgentRateDetailSubVO> agentRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateDetailSubVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgentRateCommChgListCSQL(), agentRateDetailSubVOList, null);
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Charge Commission의 Charge 목록을 일괄적으로 생성 후 [히스토리 테이블에 등록]<br>
	 *
	 * @param List<AgentRateDetailSubVO> agentRateDetailSubVOList
	 * @throws DAOException
	 */
	public void addAgentRateCommChgHis(List<AgentRateDetailSubVO> agentRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateDetailSubVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgentRateCommChgHisListCSQL(), agentRateDetailSubVOList, null);
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Minimum Commission의 Charge 목록을 일괄적으로 생성<br>
	 *
	 * @param List<AgentMinimumCommissionVO> agentRateDetailSubVOList
	 * @throws DAOException
	 */
	public void addAgentRateMinComm(List<AgentMinimumCommissionVO> agentRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateDetailSubVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgentRateMinCommListCSQL(), agentRateDetailSubVOList, null);
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
	 * [ESM_ACM_0001-02]
	 * [Detail]탭 - Minimum Commission의 Charge 목록을 일괄적으로 생성 후 [히스토리 테이블에 등록]<br>
	 *
	 * @param List<AgentMinimumCommissionVO> agentRateDetailSubVOList
	 * @throws DAOException
	 */
	public void addAgentRateMinCommHis(List<AgentMinimumCommissionVO> agentRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateDetailSubVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgentRateMinCommHisListCSQL(), agentRateDetailSubVOList, null);
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
	 * [ESM_ACM_0101]
	 * New Ageement No.로 저장되어 있을 수 있는 Charge Commission 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOList
	 * @throws DAOException
	 */
	public void removeAgmtCopyChgComm(List<AgentRateMasterVO> agentRateMasterVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (agentRateMasterVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAORemoveAgmtCopyChgCommListDSQL(), agentRateMasterVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [ESM_ACM_0101]
	 * 선택된 Agreement No.의 Charge Commission 목록을 일괄적으로 New Ageement No.로 생성<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgmtCopyChgComm(List<AgentRateMasterVO> agentRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgmtCopyChgCommListCSQL(), agentRateMasterVOlist, null);
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
	 * [ESM_ACM_0101]
	 * 선택된 Agreement No.의 Charge Commission history 목록을 일괄적으로 New Ageement No.로 생성<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgmtCopyChgCommHis(List<AgentRateMasterVO> agentRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgmtCopyChgCommHisListCSQL(), agentRateMasterVOlist, null);
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
	 * [ESM_ACM_0101]
	 * New Ageement No.로 저장되어 있을 수 있는 Minimum Commission 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOList
	 * @throws DAOException
	 */
	public void removeAgmtCopyMinComm(List<AgentRateMasterVO> agentRateMasterVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (agentRateMasterVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAORemoveAgmtCopyMinCommListDSQL(), agentRateMasterVOList, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
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
	 * [ESM_ACM_0101]
	 * 선택된 Agreement No.의 Minimum Commission 목록을 일괄적으로 New Ageement No.로 생성<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgmtCopyMinComm(List<AgentRateMasterVO> agentRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgmtCopyMinCommListCSQL(), agentRateMasterVOlist, null);
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
	 * [ESM_ACM_0101]
	 * 선택된 Agreement No.의 Minimum Commission history 목록을 일괄적으로 New Ageement No.로 생성<br>
	 *
	 * @param List<AgentRateMasterVO> agentRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgmtCopyMinCommHis(List<AgentRateMasterVO> agentRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agentRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AGNCommAgreementDBDAOAddAgmtCopyMinCommHisListCSQL(), agentRateMasterVOlist, null);
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
	 * Search Surcharge Count<br>
	 *
	 * @param String chgCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchSurchargeCnt(String chgCd) throws DAOException {
		DBRowSet dbRowset = null;
		String flag = "N";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("chg_cd", chgCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AGNCommAgreementDBDAOSearchSurchargeCntRSQL(), param, null);
			if(dbRowset.next()) {
				flag = ("0").equals(dbRowset.getString("CNT"))?"N":"Y";
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return flag;
	}

}