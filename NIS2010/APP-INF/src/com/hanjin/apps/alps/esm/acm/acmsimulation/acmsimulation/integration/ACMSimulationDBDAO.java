/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : ACMSimulationDBDAO.java
 * @FileTitle : ACMSimulationDBDAO
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2012.04.09
 * @LastModifier : 김상수
 * @LastVersion : 1.0
 * 2012.04.09 김상수 1.0 Creation.
 * ---------------------------------------------
 * History
 * 2012.12.21 김봉균 [CHM-201221923] ACM/ Simulation 계산 로직 고도화
 * 2014.06.03 박다은 [CHM-201430120] Agent Comm. Mass simulation 에 기능 추가
 * 2015.05.18 김상현 [CHM-201534767]대리점비 공제로직 변경으로 인한 ACM 시스템 적용 (Own feederage 단가 테이블 로직 구성 하여 공제에 활용)
 */
package com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.acm.acmrequest.agncommrequest.integration.AGNCommRequestDBDAOGetMasCoaFlgRSQL;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.basic.ACMSimulationBCImpl;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.AGNCommMassSimVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.AGNCommSimulationVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.AgmtInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.AgnReqCalCondVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.AgnReqRevInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.BkgCreDtInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.BkgNumberInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.BkgQtyInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.ChgAmtInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.ChgAmtRtInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.ChgInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.OfficeCodeInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.SaDtInfoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.SearchAgreementVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.SimAgnRateDetailSubVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.SimAgnRateDetailVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.SimAgnRateMasterVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.SimulationNoVO;
import com.hanjin.apps.alps.esm.acm.acmsimulation.acmsimulation.vo.VslSvcLaneInfoVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ACMSimulationDBDAO <br>
 * - ALPS-ACMSimulation system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Sang-Soo
 * @see ACMSimulationBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class ACMSimulationDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0106]
	 * Agreement Search화면의 Actual Agreement 목록을 조회<br>
	 *
	 * @param SearchAgreementVO searchAgreementVO
	 * @return List<SearchAgreementVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchAgreementVO> searchActualAgreement(SearchAgreementVO searchAgreementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAgreementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchAgreementVO != null) {
				Map<String, String> mapVO= searchAgreementVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOSearchActualAgreementListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAgreementVO.class);
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
	 * [ESM_ACM_0106]
	 * Agreement Search화면의 Simulation Agreement 목록을 조회<br>
	 *
	 * @param SearchAgreementVO searchAgreementVO
	 * @return List<SearchAgreementVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SearchAgreementVO> searchSimulationAgreement(SearchAgreementVO searchAgreementVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAgreementVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (searchAgreementVO != null) {
				Map<String, String> mapVO= searchAgreementVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOSearchSimulationAgreementListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SearchAgreementVO.class);
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
	 * [ESM_ACM_0010]
	 * Agent Commission Simulation 목록을 조회<br>
	 *
	 * @param AGNCommSimulationVO agnCommSimulationVO
	 * @return List<AGNCommSimulationVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AGNCommSimulationVO> searchAGNCommSimulation(AGNCommSimulationVO agnCommSimulationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommSimulationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agnCommSimulationVO != null) {
				Map<String, String> mapVO= agnCommSimulationVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOSearchAGNCommSimulationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommSimulationVO.class);
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
	  * [ESM_ACM_0010]
	  * Agent Commission Simulation 목록을 조회<br>
	  * searchAGNCommSimulationResult
	  * @param AGNCommSimulationVO agnCommSimulationVO
	  * @return List<AGNCommSimulationVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<AGNCommSimulationVO> searchAGNCommSimulationResult(AGNCommSimulationVO agnCommSimulationVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<AGNCommSimulationVO> list = null;
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 
		 try{
			 if (agnCommSimulationVO != null) {
				 Map<String, String> mapVO= agnCommSimulationVO.getColumnValues();
				 
				 param.putAll(mapVO);
				 velParam.putAll(mapVO);
			 }
			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOSearchAGNCommSimulationResultRSQL(), param, velParam);
			 list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommSimulationVO.class);
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
	 * [ESM_ACM_0011-01 / ESM_ACM_0011-03 / ESM_ACM_0115]
	 * [Master]탭 / [Summary]탭 - Master 목록을 조회<br>
	 *
	 * @param SimAgnRateMasterVO simAgnRateMasterVO
	 * @return List<SimAgnRateMasterVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SimAgnRateMasterVO> searchSimAgnRateMaster(SimAgnRateMasterVO simAgnRateMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SimAgnRateMasterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (simAgnRateMasterVO != null) {
				Map<String, String> mapVO= simAgnRateMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOSearchSimAgnRateMasterListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SimAgnRateMasterVO.class);
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
	 * [ESM_ACM_0011-01]
	 * ACM_AGN_AGMT_MST 테이블에서 AGN_FM_DT, AGN_TO_DT로 중복 체크<br>
	 *
	 * @param SimAgnRateMasterVO simAgnRateMasterVO
	 * @return List<SimAgnRateMasterVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SimAgnRateMasterVO> getDupDataFromAcmAgmAgmtMstInfo(SimAgnRateMasterVO simAgnRateMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SimAgnRateMasterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (simAgnRateMasterVO != null) {
				Map<String, String> mapVO= simAgnRateMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetDupDataFromAcmSimAgmtMstInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SimAgnRateMasterVO.class);
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
	 * [ESM_ACM_0011-01]
	 * [Master]탭 목록을 일괄적으로 생성<br>
	 *
	 * @param List<SimAgnRateMasterVO> simAgnRateMasterVOlist
	 * @throws DAOException
	 */
	public void addSimAgnRateMaster(List<SimAgnRateMasterVO> simAgnRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (simAgnRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAOAddSimAgnRateMasterListCSQL(), simAgnRateMasterVOlist, null);
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
	 * [ESM_ACM_0011-01]
	 * [Master]탭 목록을 일괄적으로 수정<br>
	 *
	 * @param List<SimAgnRateMasterVO> simAgnRateMasterVOlist
	 * @throws DAOException
	 */
	public void modifySimAgnRateMaster(List<SimAgnRateMasterVO> simAgnRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (simAgnRateMasterVOlist.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAOModifySimAgnRateMasterListUSQL(), simAgnRateMasterVOlist, null);
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
	 * [ESM_ACM_0011-02 / ESM_ACM_0011-03]
	 * [Detail]탭 - Compensation Master / [Summary]탭 - Detail 목록을 조회<br>
	 *
	 * @param SimAgnRateMasterVO simAgnRateMasterVO
	 * @return List<SimAgnRateDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SimAgnRateDetailVO> searchSimAgnRateDetail(SimAgnRateMasterVO simAgnRateMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SimAgnRateDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (simAgnRateMasterVO != null) {
				Map<String, String> mapVO= simAgnRateMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOSearchSimAgnRateDetailListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SimAgnRateDetailVO.class);
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
	 * @param SimAgnRateDetailVO simAgnRateDetailVO
	 * @return List<AgentRateDetailVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SimAgnRateDetailVO> getAgnAgmtSeqInfo(SimAgnRateDetailVO simAgnRateDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SimAgnRateDetailVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (simAgnRateDetailVO != null) {
				Map<String, String> mapVO= simAgnRateDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetAgnAgmtSeqInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SimAgnRateDetailVO.class);
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
	 * [ESM_ACM_0011-02]
	 * [Detail]탭 - Compensation Master 목록을 일괄적으로 생성<br>
	 *
	 * @param List<SimAgnRateDetailVO> simAgnRateDetailVOList
	 * @throws DAOException
	 */
	public void addSimAgnRateDetail(List<SimAgnRateDetailVO> simAgnRateDetailVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (simAgnRateDetailVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAOAddSimAgnRateDetailListCSQL(), simAgnRateDetailVOList, null);
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
	 * [ESM_ACM_0011-02]
	 * [Detail]탭 - Compensation Master 목록을 일괄적으로 수정<br>
	 *
	 * @param List<SimAgnRateDetailVO> simAgnRateDetailVOList
	 * @throws DAOException
	 */
	public void modifySimAgnRateDetail(List<SimAgnRateDetailVO> simAgnRateDetailVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (simAgnRateDetailVOList.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAOModifySimAgnRateDetailListUSQL(), simAgnRateDetailVOList, null);
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
	 * [ESM_ACM_0011-02]
	 * [Detail]탭 - Compensation Master 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<SimAgnRateDetailVO> simAgnRateDetailVOList
	 * @throws DAOException
	 */
	public void removeSimAgnRateDetail(List<SimAgnRateDetailVO> simAgnRateDetailVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (simAgnRateDetailVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAORemoveSimAgnRateDetailListDSQL(), simAgnRateDetailVOList, null);
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
	 * [ESM_ACM_0011-02]
	 * [Detail]탭 - Compensation Rate의 Container TP/SZ 목록을 일괄적으로 생성<br>
	 *
	 * @param List<SimAgnRateDetailSubVO> simAgnRateDetailSubVOList
	 * @throws DAOException
	 */
	public void addSimAgnRateDetailCntr(List<SimAgnRateDetailSubVO> simAgnRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (simAgnRateDetailSubVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAOAddSimAgnRateDetailCntrListCSQL(), simAgnRateDetailSubVOList, null);
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
	 * [ESM_ACM_0011-02]
	 * [Detail]탭 - Compensation Rate의 Container TP/SZ 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<SimAgnRateDetailSubVO> simAgnRateDetailSubVOList
	 * @throws DAOException
	 */
	public void removeSimAgnRateDetailCntr(List<SimAgnRateDetailSubVO> simAgnRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (simAgnRateDetailSubVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAORemoveSimAgnRateDetailCntrListDSQL(), simAgnRateDetailSubVOList, null);
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
	 * [ESM_ACM_0011-02]
	 * [Detail]탭 - Compensation Rate의 Route 목록을 일괄적으로 생성<br>
	 *
	 * @param List<SimAgnRateDetailSubVO> simAgnRateDetailSubVOList
	 * @throws DAOException
	 */
	public void addSimAgnRateDetailRout(List<SimAgnRateDetailSubVO> simAgnRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (simAgnRateDetailSubVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAOAddSimAgnRateDetailRoutListCSQL(), simAgnRateDetailSubVOList, null);
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
	 * [ESM_ACM_0011-02]
	 * [Detail]탭 - Compensation Rate의 Route 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<SimAgnRateDetailSubVO> simAgnRateDetailSubVOList
	 * @throws DAOException
	 */
	public void removeSimAgnRateDetailRout(List<SimAgnRateDetailSubVO> simAgnRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (simAgnRateDetailSubVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAORemoveSimAgnRateDetailRoutListDSQL(), simAgnRateDetailSubVOList, null);
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
	 * [ESM_ACM_0011-02]
	 * [Detail]탭 - Compensation Rate의 Charge 목록을 일괄적으로 생성<br>
	 *
	 * @param List<SimAgnRateDetailSubVO> simAgnRateDetailSubVOList
	 * @throws DAOException
	 */
	public void addSimAgnRateDetailChg(List<SimAgnRateDetailSubVO> simAgnRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (simAgnRateDetailSubVOList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAOAddSimAgnRateDetailChgListCSQL(), simAgnRateDetailSubVOList, null);
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
	 * [ESM_ACM_0011-02]
	 * [Detail]탭 - Compensation Rate의 Charge 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<SimAgnRateDetailSubVO> simAgnRateDetailSubVOList
	 * @throws DAOException
	 */
	public void removeSimAgnRateDetailChg(List<SimAgnRateDetailSubVO> simAgnRateDetailSubVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (simAgnRateDetailSubVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAORemoveSimAgnRateDetailChgListDSQL(), simAgnRateDetailSubVOList, null);
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
	 * [ESM_ACM_0011-01 / ESM_ACM_0115]
	 * New Agreement No. 조회<br>
	 *
	 * @param SimAgnRateMasterVO simAgnRateMasterVO
	 * @return List<SimAgnRateMasterVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SimAgnRateMasterVO> getNewAgreementNo(SimAgnRateMasterVO simAgnRateMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SimAgnRateMasterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (simAgnRateMasterVO != null) {
				Map<String, String> mapVO= simAgnRateMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetNewAgreementNoInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SimAgnRateMasterVO.class);
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
	 * [ESM_ACM_0115]
	 * 사용자가 입력한 Agreement No.의 유효성 검증<br>
	 *
	 * @param SimAgnRateMasterVO simAgnRateMasterVO
	 * @return List<SimAgnRateMasterVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SimAgnRateMasterVO> getAgreementNoInfo(SimAgnRateMasterVO simAgnRateMasterVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SimAgnRateMasterVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (simAgnRateMasterVO != null) {
				Map<String, String> mapVO= simAgnRateMasterVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetAgreementNoInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SimAgnRateMasterVO.class);
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
	 * [ESM_ACM_0115]
	 * New Ageement No.로 저장되어 있을 수 있는 Master목록을 일괄적으로 삭제<br>
	 *
	 * @param List<SimAgnRateMasterVO> simAgnRateMasterVOList
	 * @throws DAOException
	 */
	public void removeAgmtCopyMaster(List<SimAgnRateMasterVO> simAgnRateMasterVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (simAgnRateMasterVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAORemoveAgmtCopyMasterListDSQL(), simAgnRateMasterVOList, null);
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
	 * [ESM_ACM_0115]
	 * New Ageement No.로 저장되어 있을 수 있는 Detail목록을 일괄적으로 삭제<br>
	 *
	 * @param List<SimAgnRateMasterVO> simAgnRateMasterVOList
	 * @throws DAOException
	 */
	public void removeAgmtCopyDetail(List<SimAgnRateMasterVO> simAgnRateMasterVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (simAgnRateMasterVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAORemoveAgmtCopyDetailListDSQL(), simAgnRateMasterVOList, null);
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
	 * [ESM_ACM_0115]
	 * New Ageement No.로 저장되어 있을 수 있는 TP/SZ목록을 일괄적으로 삭제<br>
	 *
	 * @param List<SimAgnRateMasterVO> simAgnRateMasterVOList
	 * @throws DAOException
	 */
	public void removeAgmtCopyDetailCntr(List<SimAgnRateMasterVO> simAgnRateMasterVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (simAgnRateMasterVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAORemoveAgmtCopyDetailCntrListDSQL(), simAgnRateMasterVOList, null);
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
	 * [ESM_ACM_0115]
	 * New Ageement No.로 저장되어 있을 수 있는 Route목록을 일괄적으로 삭제<br>
	 *
	 * @param List<SimAgnRateMasterVO> simAgnRateMasterVOList
	 * @throws DAOException
	 */
	public void removeAgmtCopyDetailRout(List<SimAgnRateMasterVO> simAgnRateMasterVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (simAgnRateMasterVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAORemoveAgmtCopyDetailRoutListDSQL(), simAgnRateMasterVOList, null);
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
	 * [ESM_ACM_0115]
	 * New Ageement No.로 저장되어 있을 수 있는 Charge 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<SimAgnRateMasterVO> simAgnRateMasterVOList
	 * @throws DAOException
	 */
	public void removeAgmtCopyDetailChg(List<SimAgnRateMasterVO> simAgnRateMasterVOList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (simAgnRateMasterVOList.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAORemoveAgmtCopyDetailChgListDSQL(), simAgnRateMasterVOList, null);
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
	 * [ESM_ACM_0115]
	 * 선택된 Agreement No.의 Master목록을 일괄적으로 New Ageement No.로 생성<br>
	 *
	 * @param List<SimAgnRateMasterVO> simAgnRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgmtCopyMaster(List<SimAgnRateMasterVO> simAgnRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (simAgnRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAOAddAgmtCopyMasterListCSQL(), simAgnRateMasterVOlist, null);
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
	 * [ESM_ACM_0115]
	 * 선택된 Agreement No.의 Detail목록을 일괄적으로 New Ageement No.로 생성<br>
	 *
	 * @param List<SimAgnRateMasterVO> simAgnRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgmtCopyDetail(List<SimAgnRateMasterVO> simAgnRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (simAgnRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAOAddAgmtCopyDetailListCSQL(), simAgnRateMasterVOlist, null);
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
	 * [ESM_ACM_0115]
	 * 선택된 Agreement No.의 TP/SZ목록을 일괄적으로 New Ageement No.로 생성<br>
	 *
	 * @param List<SimAgnRateMasterVO> simAgnRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgmtCopyDetailCntr(List<SimAgnRateMasterVO> simAgnRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (simAgnRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAOAddAgmtCopyDetailCntrListCSQL(), simAgnRateMasterVOlist, null);
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
	 * [ESM_ACM_0115]
	 * 선택된 Agreement No.의 Route목록을 일괄적으로 New Ageement No.로 생성<br>
	 *
	 * @param List<SimAgnRateMasterVO> simAgnRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgmtCopyDetailRout(List<SimAgnRateMasterVO> simAgnRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (simAgnRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAOAddAgmtCopyDetailRoutListCSQL(), simAgnRateMasterVOlist, null);
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
	 * [ESM_ACM_0115]
	 * 선택된 Agreement No.의 Charge 목록을 일괄적으로 New Ageement No.로 생성<br>
	 *
	 * @param List<SimAgnRateMasterVO> simAgnRateMasterVOlist
	 * @throws DAOException
	 */
	public void addAgmtCopyDetailChg(List<SimAgnRateMasterVO> simAgnRateMasterVOlist) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (simAgnRateMasterVOlist.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSimulationDBDAOAaddAgmtCopyDetailChgListCSQL(), simAgnRateMasterVOlist, null);
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
	 * [ESM_ACM_0033]
	 * Target Booking 목록을 조회<br>
	 *
	 * @param AGNCommMassSimVO agnCommMassSimVO
	 * @return List<AGNCommMassSimVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AGNCommMassSimVO> searchAGNCommMassSimList(AGNCommMassSimVO agnCommMassSimVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGNCommMassSimVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agnCommMassSimVO != null) {
				Map<String, String> mapVO= agnCommMassSimVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOSearchAGNCommMassSimListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AGNCommMassSimVO.class);
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
	 * [ESM_ACM_0033] Start Simulation<br>
	 * 대상 Booking 을 Batch 에 입력한다<br>
	 *
	 * @param AGNCommMassSimVO agnCommMassSimVO
	 * @exception DAOException
	 */
	public void manageAGNCommMassSimList(AGNCommMassSimVO agnCommMassSimVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (agnCommMassSimVO != null) {
				Map<String, String> mapVO = agnCommMassSimVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
				int result = sqlExe.executeUpdate((ISQLTemplate)new  ACMSimulationDBDAOManageAGNCommMassSimListCSQL(), param, velParam);
				if(result == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0033]
	 * 조회 결과를 Excel 파일 다운로드한다.<br>
	 *
	 * @param AGNCommMassSimVO agnCommMassSimVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchAGNCommMassSimExcel(AGNCommMassSimVO agnCommMassSimVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agnCommMassSimVO != null) {
				Map<String, String> mapVO= agnCommMassSimVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOSearchAGNCommMassSimExcelListRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * [ESM_ACM_0110] Simulation No. Search<br>
	 * Simulation No. Search 목록을 조회<br>
	 *
	 * @param SimulationNoVO simulationNoVO
	 * @return List<SimulationNoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SimulationNoVO> searchSimulationNoList(SimulationNoVO simulationNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SimulationNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (simulationNoVO != null) {
				Map<String, String> mapVO= simulationNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOSearchSimulationNoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SimulationNoVO.class);
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
	 * [ESM_ACM_0110]Simulation No 의 Simulation Office 조회<br>
	 * Simulation Office 조회
	 *
	 * @param SimulationNoVO simulationNoVO
	 * @return List<SimulationNoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<SimulationNoVO> getSimulationOfficeList(SimulationNoVO simulationNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SimulationNoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (simulationNoVO != null) {
				Map<String, String> mapVO= simulationNoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOSimulationOfficeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SimulationNoVO.class);
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
	 * [ESM_ACM_0033] Simulation Result - Simulation Number<br>
	 * imulation Result - Simulation Number Excel 파일 다운로드한다.<br>
	 *
	 * @param AGNCommMassSimVO agnCommMassSimVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchAGNCommMassSimSimulationNumberExcel(AGNCommMassSimVO agnCommMassSimVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agnCommMassSimVO != null) {
				Map<String, String> mapVO= agnCommMassSimVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOSearchAGNCommMassSimSimulationNumberExcelListRSQL(), param, velParam);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * Simulation No. Max 값 조회. NO 체계 : 'S' + YYMMDD + 4자리 Sequence
	 * @return String
	 * @throws DAOException
	 */
	public String getNewSimulationNo() throws DAOException {
		DBRowSet dbRowset = null;
		String simNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetNewSimulationNoInfoRSQL(), param, null);
			if(dbRowset.next()) {
				simNo = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return simNo;
	}
	
	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * Simulation No. Max 값 조회. NO 체계 : 'S' + YYMMDD + 4자리 Sequence max 값
	 * @return String
	 * @throws DAOException
	 */
	public String getMaxSimulationNo() throws DAOException {
		DBRowSet dbRowset = null;
		String simNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetMaxSimulationNoInfoRSQL(), param, null);
			if(dbRowset.next()) {
				simNo = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return simNo;
	}
	
	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * Simulation 정보를 저장한다.
	 * @param SimulationNoVO simulationNoVO
	 * @throws DAOException
	 */
	public void addAcmSimInfo(SimulationNoVO simulationNoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (simulationNoVO != null) {
				Map<String, String> mapVO= simulationNoVO.getColumnValues();

				param.putAll(mapVO);
			}
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new ACMSimulationDBDAOAddAcmSimInfoCSQL(), param, null);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to add");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * Master BKG No 를 조회한다.
	 * @param String bkgNo
	 * @return BkgNumberInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgNumberInfoVO getBkgNumber(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgNumberInfoVO> list = null;
		BkgNumberInfoVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetBkgNumberInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgNumberInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * Simulation 을 위한 기본적인 Information 저장
	 * @param AgnReqCalCondVO agnCondVO
	 * @throws DAOException
	 */
	public void modifyAcmSimBkgInfo(AgnReqCalCondVO agnCondVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agnCondVO != null) {
				Map<String, String> mapVO= agnCondVO.getColumnValues();

				param.putAll(mapVO);
			}

			int updCnt = sqlExe.executeUpdate((ISQLTemplate) new ACMSimulationDBDAOModifyAcmSimBkgInfoUSQL(), param, null);
			if (updCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to update");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * BDR 을 확인한다
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String getBkgBdrFlg(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String bkgBdrFlg = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetBkgBdrFlgInfoRSQL(), param, null);
			if(dbRowset.next()) {
				bkgBdrFlg = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bkgBdrFlg;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * BKG QTY 를 조회한다
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgQtyInfoVO getBkgQty(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgQtyInfoVO> list = null;
		BkgQtyInfoVO rtnVO = new BkgQtyInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetBkgQtyInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgQtyInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * BKG 생성 날짜를 확인한다. 
	 * @param String bkgNo
	 * @return BkgCreDtInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public BkgCreDtInfoVO getBkgCreDt(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgCreDtInfoVO> list = null;
		BkgCreDtInfoVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetBkgCreDtInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BkgCreDtInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * 부킹의 revenue month 를 조회
	 * @param String bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String getRevMon(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String revMon = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetRevMonInfoRSQL(), param, null);
			if (dbRowset.next()) {
				revMon = dbRowset.getString("REV_MON");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return revMon;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * Rate apply date를 조회
	 * @param String mstBkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String getRtAplyDt(String mstBkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String rtAplyDt = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (mstBkgNo != null) {
				param.put("bkg_no", mstBkgNo);
				velParam.put("bkg_no", mstBkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetRtAplyDtInfoRSQL(), param, velParam);
			if (dbRowset.next()) {
				rtAplyDt = dbRowset.getString("RT_APLY_DT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtAplyDt;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * Sail arrival date를 조회
	 * @param String bkgNo
	 * @return SaDtInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public SaDtInfoVO getSaDt(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<SaDtInfoVO> list = null;
		SaDtInfoVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetSaDtInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SaDtInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * BKG Rating 정보를 조회한다.
	 * @param String bkgNo
	 * @param String rtAplyDt
	 * @return ChgAmtInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public ChgAmtInfoVO getChgAmt(String bkgNo, String rtAplyDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChgAmtInfoVO> list = null;
		ChgAmtInfoVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);
			param.put("rt_aply_dt", rtAplyDt);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetChgAmtInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChgAmtInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * 부킹의 office code 조회
	 * @param String bkgNo
	 * @return OfficeCodeInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public OfficeCodeInfoVO getOfficeCode(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<OfficeCodeInfoVO> list = null;
		OfficeCodeInfoVO rtnVO = new OfficeCodeInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetOfficeCodeInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfficeCodeInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation
	 * 기본적인 Simulation 정보를 삭제한다
	 * @param String bkgNo
	 * @param String simNo
	 * @throws DAOException
	 */
	public void removeAcmSimBkgInfo(String bkgNo, String simNo) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("sim_no", simNo);
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new ACMSimulationDBDAORemoveAcmSimBkgInfoDSQL(), param, null);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0010] Start Simulation
	 * Simulation Commission 정보를 삭제한다(지급프로세스 시작된 커미션 제외)
	 * @param String bkgNo
	 * @param String simNo
	 * @throws DAOException
	 */
	public void removeAcmSimCommDtl(String bkgNo, String simNo) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("sim_no", simNo);
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new ACMSimulationDBDAORemoveAcmSimCommDtlDSQL(), param, null);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0010] Start Simulation
	 * Simulation Commission 정보를 삭제한다(지급프로세스 시작된 커미션 제외)
	 * @param String bkgNo
	 * @param String simNo
	 * @throws DAOException
	 */
	public void removeAcmSimComm(String bkgNo, String simNo) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("sim_no", simNo);
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new ACMSimulationDBDAORemoveAcmSimCommDSQL(), param, null);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0010] Start Simulation
	 * Simulation Commission 정보를 삭제한다(지급프로세스 시작된 커미션 제외)
	 * @param String bkgNo
	 * @param String simNo
	 * @throws DAOException
	 */
	public void removeAcmSimCommChg(String bkgNo, String simNo) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("sim_no", simNo);
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new ACMSimulationDBDAORemoveAcmSimCommChgDSQL(), param, null);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0010] Start Simulation
	 * Simulation Commission 정보를 삭제한다(지급프로세스 시작된 커미션 제외)
	 * @param String bkgNo
	 * @param String simNo
	 * @throws DAOException
	 */
	public void removeAcmSimCommRev(String bkgNo, String simNo) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("sim_no", simNo);
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new ACMSimulationDBDAORemoveAcmSimCommRevDSQL(), param, null);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0010] Start Simulation
	 * Simulation Commission 정보를 삭제한다(지급프로세스 시작된 커미션 제외)
	 * @param String bkgNo
	 * @param String simNo
	 * @throws DAOException
	 */
	public void removeAcmSimCommTrsp(String bkgNo, String simNo) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("sim_no", simNo);
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new ACMSimulationDBDAORemoveAcmSimCommTrspDSQL(), param, null);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_ACM_0010] Start Simulation
	 * Simulation 기본 정보를 저장한다.
	 * @param OfficeCodeInfoVO officeCodeInfoVO
	 * @throws DAOException
	 */
	public void addAcmSimBkgInfo(OfficeCodeInfoVO officeCodeInfoVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (officeCodeInfoVO != null) {
				Map<String, String> mapVO= officeCodeInfoVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new ACMSimulationDBDAOAddAcmSimBkgInfoCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * BKG 에 해당하는 Agreement list 조회 한다. 
	 * @param AgnReqCalCondVO agnReqCalCondVO
	 * @return List<AgmtInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<AgmtInfoVO> getAgmtInfo(AgnReqCalCondVO agnReqCalCondVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgmtInfoVO> list = new ArrayList<AgmtInfoVO>();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agnReqCalCondVO != null) {
				Map<String, String> mapVO= agnReqCalCondVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetAgmtInfoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgmtInfoVO.class);
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
	 * [ESM_ACM_0010] Start Simulation<br>
	 * Max 대리점비 calculation sequence 조회
	 * @param AgmtInfoVO agmtVO
	 * @return int
	 * @throws DAOException
	 */
	public String getMaxAcSeq(AgmtInfoVO agmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		String maxAcSeq = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetMaxAcSeqInfoRSQL(), param, null);
			if (dbRowset.next()) {
				maxAcSeq = dbRowset.getString("MAX_AC_SEQ");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return maxAcSeq;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * Office 정보 조회
	 * @param String ofcCd
	 * @return OfficeCodeInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public OfficeCodeInfoVO getOfcInfo(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<OfficeCodeInfoVO> list = null;
		OfficeCodeInfoVO rtnVO = new OfficeCodeInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (ofcCd != null) {
				param.put("ofc_cd", ofcCd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetOfcInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, OfficeCodeInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * Booking 의 POR, POL, POD, DEL 에 해당하는 FINC_CTRL_OFC_CD 와 AR_OFC_CD 를 구함
	 * @param AgmtInfoVO agmtVO
	 * @return int
	 * @throws DAOException
	 */
	public String getPayXchRt(AgmtInfoVO agmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		String payXchRt = "0";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetPayXchRtInfoRSQL(), param, velParam);
			if (dbRowset.next()) {
				payXchRt = dbRowset.getString("PAY_XCH_RT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return payXchRt;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * BKG Rating 정보를 조회한다.
	 * @param String bkgNo
	 * @param String saDt
	 * @return AgnReqRevInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public AgnReqRevInfoVO getBlRev(String bkgNo, String saDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgnReqRevInfoVO> list = null;
		AgnReqRevInfoVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
				param.put("sa_dt", saDt);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetBlRevInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgnReqRevInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * OFT 외에 추가 Revenue 가 될 Charge 코드의 금액을 구한다
	 * @param AgmtInfoVO agmtVO
	 * @return AgnReqRevInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public AgnReqRevInfoVO getStrcRev(AgmtInfoVO agmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgnReqRevInfoVO> list = null;
		AgnReqRevInfoVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetStrcRevInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgnReqRevInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * CAF Charge 금액을 조회한다.
	 * @param AgmtInfoVO agmtVO
	 * @return AgnReqRevInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public AgnReqRevInfoVO getCafRev(AgmtInfoVO agmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgnReqRevInfoVO> list = null;
		AgnReqRevInfoVO rtnVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetCafRevInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgnReqRevInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0010]
	 * Simulation Commission 정보를 삭제한다(지급프로세스 시작된 커미션 제외)
	 * @param String bkgNo
	 * @param String simNo
	 * @throws DAOException
	 */
	public void removeAcmSimCommChgRef(String bkgNo, String simNo) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("bkg_no", bkgNo);
			param.put("sim_no", simNo);
			int delCnt = sqlExe.executeUpdate((ISQLTemplate) new ACMSimulationDBDAORemoveAcmSimCommChgRefDSQL(), param, null);
			if (delCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0010] Start Simulation
	 * Simulation 시 Charge Reference 정보를 저장한다.
	 * @param AgmtInfoVO agmtVO
	 * @throws DAOException
	 */
	public void addAcmSimCommChgRef(AgmtInfoVO agmtVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new ACMSimulationDBDAOAddAcmSimCommChgRefCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Auto rating를 이용한 Surcharge 항목 조회.
	 * @param agmtVO
	 * @throws DAOException
	 */
	public void addAcmSimCommChgRefFromAutoRt(AgmtInfoVO agmtVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter

		SQLExecuter sqlExe = new SQLExecuter("");
		try {
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();
				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new ACMSimulationDBDAOAddAcmSimCommChgRefFromAutoRtCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0010] Start Simulation
	 * Simulation 시 Charge 금액 정보를 저장한다.
	 * @param AgmtInfoVO agmtVO
	 * @throws DAOException
	 */
	public void addAcmSimCommChg(AgmtInfoVO agmtVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new ACMSimulationDBDAOAddAcmSimCommChgCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Simulation 시 Charge 금액 정보를 저장한다.
	 * @param agmtVO
	 * @throws DAOException
	 */
	public void addAcmSimCommChgFromAutoRt(AgmtInfoVO agmtVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		SQLExecuter sqlExe = new SQLExecuter("");

		try {
			if (agmtVO != null) {
				Map<String, String> mapVO = agmtVO.getColumnValues();
				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new ACMSimulationDBDAOAddAcmSimCommChgFromAutoRtCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * BKG TRS 비용을 deduction 하기 위해 Charge TAC rating 정보를 확인한다
	 * @param String bkgNo
	 * @return ChgInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public ChgInfoVO getChgInfo1(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChgInfoVO> list = null;
		ChgInfoVO rtnVO = new ChgInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetChgInfo1RSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChgInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}


	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * BKG TRS 비용을 deduction 하기 위해 Charge OIH,DIH,OAR,DAR rating 정보를 확인한다
	 * @param String bkgNo
	 * @return ChgInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public ChgInfoVO getChgInfo2(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChgInfoVO> list = null;
		ChgInfoVO rtnVO = new ChgInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetChgInfo2RSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChgInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * Feeder 운송이 포함 됐는지 조회
	 * @param String bkgNo
	 * @return VslSvcLaneInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public VslSvcLaneInfoVO getVslSvcLaneInfo(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<VslSvcLaneInfoVO> list = null;
		VslSvcLaneInfoVO rtnVO = new VslSvcLaneInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bkg_no", bkgNo);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetVslSvcLaneInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, VslSvcLaneInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation
	 * Simulation 시 TRS 비용 정보를 저장한다.
	 * @param AgmtInfoVO agmtVO
	 * @throws DAOException
	 */
	public void addAcmSimCommTrsp(AgmtInfoVO agmtVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new ACMSimulationDBDAOAddAcmSimCommTrspCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Simulation 시 TRS 비용 정보를 저장한다.
	 * @param agmtVO
	 * @throws DAOException
	 */
	public void addAcmSimCommTrspFromCoa(AgmtInfoVO agmtVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		SQLExecuter sqlExe = new SQLExecuter("");

		try {
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();
				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new ACMSimulationDBDAOAddAcmSimCommTrspFromCoaCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to insert");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Own Feedrage를 적용할 것인지 결정하기 위해 기존 Feederage 비용 조회.
	 * @param agmtVO
	 * @return int
	 * @throws DAOException
	 */
	public int getSimFdrgDdctOrgFlg(AgmtInfoVO agmtVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		int rowCount = 0;

		try {
			if (agmtVO != null) {
				param.putAll(agmtVO.getColumnValues());
				dbRowset = sqlExe.executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetSimFdrgDdctOrgFlgRSQL(), param, null);
				if (dbRowset.next()) {
					rowCount = dbRowset.getInt("CNT");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

		return rowCount;
	}

	/**
	 * Own Feedreage 공제 금액 조회 후 저장
	 * @param agmtVO
	 * @throws DAOException
	 */
	public void addAcmSimOtrFdrgDdctCSQL(AgmtInfoVO agmtVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter.
		try {
			if (agmtVO != null) {
				param.putAll(agmtVO.getColumnValues());
				int intCnt = sqlExe.executeUpdate((ISQLTemplate)new ACMSimulationDBDAOAddAcmSimOtrFdrgDdctCSQL(), param, null);
				if (intCnt == Statement.EXECUTE_FAILED) {
					throw new DAOException("Fail to insert");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * BKG의 총 Deduction 금액을 조회 한다. 
	 * @param AgmtInfoVO agmtVO
	 * @return ChgAmtRtInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public ChgAmtRtInfoVO getChgAmtRtInfo(AgmtInfoVO agmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChgAmtRtInfoVO> list = null;
		ChgAmtRtInfoVO rtnVO = new ChgAmtRtInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetChgAmtRtInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChgAmtRtInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation
	 * Simulation 생성되는 commission 중 Rate 계약 기반의 정보를 저장한다.
	 * @param AgmtInfoVO agmtVO
	 * @throws DAOException
	 */
	public void addAcmSimCommRt(AgmtInfoVO agmtVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new ACMSimulationDBDAOAddAcmSimCommRtCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * 생성되는 commission 중 Fixed Amount 계약 기반의 금액을 조회한다
	 * @param AgmtInfoVO agmtVO
	 * @return String
	 * @throws DAOException
	 */
	public String getFxRealAmt(AgmtInfoVO agmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		String fxRealAmt = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetFxRealAmtInfoRSQL(), param, null);
			if(dbRowset.next()) {
				fxRealAmt = dbRowset.getString("FX_REAL_AMT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return fxRealAmt;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation<br>
	 * 생성된 Commission 에 환율 적용
	 * @param AgmtInfoVO agmtVO
	 * @return AgmtInfoVO
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public AgmtInfoVO getLoclXchRtComm(AgmtInfoVO agmtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgmtInfoVO> list = null;
		AgmtInfoVO rtnVO = new AgmtInfoVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetLoclXchRtCommInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, AgmtInfoVO.class);
			if(list != null && list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}

	/**
	 * [ESM_ACM_0010] Start Simulation
	 * Simulation 생성되는 commission 중 Fixed Amount 계약 기반의 정보를 저장한다.	
	 * @param AgmtInfoVO agmtVO
	 * @throws DAOException
	 */
	public void addAcmSimCommFx(AgmtInfoVO agmtVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (agmtVO != null) {
				Map<String, String> mapVO= agmtVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new ACMSimulationDBDAOAddAcmSimCommFxCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0010] Start Simulation
	 * Simulation 시 CNTR 별 Detail 정보를 저장한다.
	 * @param AgnReqCalCondVO condVO
	 * @throws DAOException
	 */
	public void addAcmSimCommDtl(AgnReqCalCondVO condVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			if (condVO != null) {
				Map<String, String> mapVO= condVO.getColumnValues();

				param.putAll(mapVO);
			}
			int intCnt = sqlExe.executeUpdate((ISQLTemplate) new ACMSimulationDBDAOAddAcmSimCommDtlCSQL(), param, null);
			if (intCnt == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0010]<br>
	 * OFT 의 Term 과 ACM 계약의 Pay Term이 맞는지 조회한다
	 * @param String bkgNo
	 * @param String oftPayTermCd
	 * @return String
	 * @throws DAOException
	 */
	public String searchBkgChgOftTermMatCnt(String bkgNo, String oftPayTermCd) throws DAOException {
		DBRowSet dbRowSet = null;
		String count = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("bkg_no", bkgNo);
			param.put("oft_pay_term_cd", oftPayTermCd);
			dbRowSet = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOSearchBkgChgOftTermMatCntRSQL(), param, null);
			if(dbRowSet.next()){
				count = dbRowSet.getString("BKG_CHG_RT_COUNT");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return count;
	}
	
	/**
	 * [ESM_ACM_0033] Add Batch<br>
	 * 대상 Actual Agreement 를 Batch 에 입력한다<br>
	 *
	 * @param agnCommMassSimVO
	 * @throws DAOException
	 */
	public void manageAGNCommAddBatchList(AGNCommMassSimVO agnCommMassSimVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (agnCommMassSimVO != null) {
				Map<String, String> mapVO = agnCommMassSimVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ACMSimulationDBDAOManageAGNCommAddBatchListCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [ESM_ACM_0033] Add Batch<br>
	 * 대상 Simulation Agreement 를 Batch 에 입력한다<br>
	 * 
	 * @param agnCommMassSimVO
	 * @throws DAOException
	 */
	public void manageSimCommAddBatchList(AGNCommMassSimVO agnCommMassSimVO) throws DAOException {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (agnCommMassSimVO != null) {
				Map<String, String> mapVO = agnCommMassSimVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ACMSimulationDBDAOManageSimCommAddBatchListCSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * COA, MAS 접근 구분 값 출력
	 * @param bkgNo
	 * @return String
	 * @throws DAOException
	 */
	public String getMasCoaFlg(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String masCoaFlg = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (bkgNo != null) {
				param.put("bkg_no", bkgNo);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSimulationDBDAOGetMasCoaFlgRSQL(), param, null);
			if(dbRowset.next()) {
				masCoaFlg = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return masCoaFlg;
	}
}