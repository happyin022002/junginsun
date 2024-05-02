/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : JointOperationAccrualCrationDBDAO.java
 *@FileTitle : 怨듬룞�댄빆異붿젙 �곗텧
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.04
 *@LastModifier : �⑤���
 *@LastVersion : 1.0
 * 2009.06.04 �⑤���
 * 1.0 Creation
* -------------------------------------------------------
* 2012.04.02 조병연[CHM-201217059-01]
* Title : [ALPS JOO] Estimate VVD Code Check - Current Estimate Cost 0 조회 기능 추가
* 내용 :
* Estimate Cost가 0인 경우의 조회 조건이 추가, 해당 쿼리를 생성. 
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.integration.CarrierSettlementProcessDBDAOchkSummaryCrrRmkRSQL;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.McsStatusVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration.JointOperationAccrualCreationDBDAO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.basic.JointOperationAccrualCreationBCImpl;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.ActRsltRVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstdCarVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstdVvdVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmActRsltVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmConditionVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusRsltVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusVO;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.SettlementConditionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.JooEstmClzVO;

import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusIIRsltVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmPerformanceChangeStatusIIVO;


/**
 * ALPS JointOperationAccrualCrationDBDAO <br>
 * - ALPS-JointOperationAgreementSettlement system Business Logic을 처리하기 위한 JDBC
 * 작업수행.<br>
 * 
 * @author HAM DAE SUNG
 * @see JointOperationAccrualCreationBCImpl 참조
 * @since J2EE 1.6
 */
public class JointOperationAccrualCreationDBDAO extends DBDAOSupport {

	/**
	 * 0030 Closing 여부를 조회한다. <br>
	 * @param String estmClzYr
	 * @return String
	 * @exception EventException
	 */
	public String searchExistAccrualClosing(String estmClzYr)
			throws DAOException {
		DBRowSet dbRowset = null;
		String closingCnt = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("estm_clz_yr", estmClzYr);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationAccrualCreationDBDAOExistAccrualClosingRSQL(),
							param, velParam);
			while (dbRowset.next()) {
				closingCnt = dbRowset.getString("CNT");

			}
			// list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueAcctVO
			// .class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return closingCnt;
	}
 
	/**
	 * Estimate Closing의 데이타 모델에 해당되는 값을 불러온다.
	 * @param JooEstmClzVO jooEstmClzVO
	 * @return List<JooEstmClzVO>
	 * @throws DAOException
	 */
	public List<JooEstmClzVO> searchAccrualClosing(JooEstmClzVO jooEstmClzVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<JooEstmClzVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (jooEstmClzVO != null) {
				Map<String, String> mapVO = jooEstmClzVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationAccrualCreationDBDAOJooEstmClzVORSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, JooEstmClzVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
 
	/**
	 * Estimate Closing의 데이타 모델에 해당되는 다건의 데이터를 일괄적으로 생성한다.
	 * @param JooEstmClzVO jooEstmClzVO 
	 * @throws DAOException
	 */
	public void addAccrualClosing(JooEstmClzVO jooEstmClzVO ) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			if (jooEstmClzVO  != null) {
				// query parameter
				Map<String, String> param = jooEstmClzVO .getColumnValues();
				int result = sqlExe
						.executeUpdate(
								(ISQLTemplate) new JointOperationAccrualCreationDBDAOJooEstmClzVOCSQL(),
								param, null);

				if (result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");

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
	 * Estimate Closing의 데이타 모델에 해당되는 다건의 데이터를 일괄적으로 갱신한다.
	 * @param List<JooEstmClzVO> jooEstmClzVOs
	 * @throws DAOException
	 */
	public void modifyAccrualClosing(List<JooEstmClzVO> jooEstmClzVOs )
			throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (jooEstmClzVOs .size() > 0) {
				updCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new JointOperationAccrualCreationDBDAOJooEstmClzVOUSQL(),
								jooEstmClzVOs , null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
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
     * Estimate Report - Account을 조회합니다.<br>
     *
     * @param  ActRsltRVO actRsltRVO
     * @throws DAOException
     * @return List<ActRsltRVO>
     * @author jang kang cheol
     */
	public List<ActRsltRVO> searchAccrualListByAccount(
			ActRsltRVO actRsltRVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActRsltRVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (actRsltRVO != null) {
				Map<String, String> mapVO = actRsltRVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationAccrualCreationDBDAOJooEstmActRsltVORSQL(),
							param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ActRsltRVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 0033 조회
	 * @param  ActRsltRVO actRsltRVO
	 * @return List<ActRsltRVO> 
	 * @throws DAOException
	 */
	public List<ActRsltRVO> searchAccrualListByMAS(ActRsltRVO actRsltRVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<ActRsltRVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (actRsltRVO != null) {
				Map<String, String> mapVO = actRsltRVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationAccrualCreationDBDAOEstmActRsltMasRSQL(),
							param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ActRsltRVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 
	 * <pre>
	 *   Estimate Performance Creation
	 *      UID : FNS_JOO_0029
	 * </pre>
	 * 
	 * @param SettlementConditionVO settlementConditionVO
	 * @return List<EstmActRsltVO>
	 * @throws DAOException
	 * @author jang kang cheol
	 */
	@SuppressWarnings("unchecked")
	public List<EstmActRsltVO> searchJointOperationAccrualList(SettlementConditionVO settlementConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmActRsltVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (settlementConditionVO != null) {
				Map<String, String> mapVO = settlementConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOEstmActRsltVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmActRsltVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
 
	
	/**
	 * 
	 * <pre>
	 *   Estimate Performance (ERP)
	 *      UID : FNS_JOO_0029
	 * </pre>
	 * 
	 * @param SettlementConditionVO settlementConditionVO
	 * @return List<EstmActRsltVO>
	 * @throws DAOException
	 * @author jang kang cheol
	 */
	@SuppressWarnings("unchecked")
	public List<EstmActRsltVO> searchJointOperationAccrualERP(SettlementConditionVO settlementConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmActRsltVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (settlementConditionVO != null) {
				Map<String, String> mapVO = settlementConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOSearchJointOperationAccrualERPRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmActRsltVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}	
	
	
	
	/**
	 * 
	 * <pre>
	 *   I/F Send 대상건을 조회합니다.
	 *      UID : FNS_JOO_0029
	 * </pre>
	 * 
	 * @param SettlementConditionVO settlementConditionVO
	 * @return List<EstmActRsltVO>
	 * @throws DAOException
	 * @author jang kang cheol
	 */
	@SuppressWarnings("unchecked")
	public List<EstmActRsltVO> searchEstmCntList(SettlementConditionVO settlementConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmActRsltVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (settlementConditionVO != null) {
				Map<String, String> mapVO = settlementConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOSearchEstmCntListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmActRsltVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	/**
	 * 추정결과를 수정합니다.
	 * @param List<EstmActRsltVO> estmActRsltVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyJointOperationAccruals(List<EstmActRsltVO> estmActRsltVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (estmActRsltVOs.size() > 0) {
				updCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new JointOperationAccrualCreationDBDAOJooEstmActRsltUSQL(),
								estmActRsltVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No" + i + " SQL");
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
	 * 
	 * [추정실적산출 테이블(JOO_ESTM_ACT_RSLT) ]을 [삭제] 합니다.<br>
	 * UID : FNS_JOO_0029 <br>
	 * 
	 * @param  SettlementConditionVO settlementConditionVO
	 * @throws DAOException
	 * @throws Exception
	 * @author jang kang cheol
	 */
	public void removeJointOperationAccrual(SettlementConditionVO settlementConditionVO)
			throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = settlementConditionVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			if("999912".equals(settlementConditionVO.getExeYrmon())){
				param.put("jo_crr_cd", "");
				param.put("rlane_cd", "");
				param.put("re_divr_cd", "");			
			}			
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe
					.executeUpdate(
							(ISQLTemplate) new JointOperationAccrualCreationDBDAORemJooEstmActRsltDSQL(),
							param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	
	/**
	 * 
	 * [추정실적산출 테이블(JOO_ESTM_ACT_RSLT) ]을 [수정] 합니다.<br>
	 * UID : FNS_JOO_0029 <br>
	 * 
	 * @param  SettlementConditionVO settlementConditionVO
	 * @throws DAOException
	 * @throws Exception
	 * @author jang kang cheol
	 */
	public void modifyJointOperationAccrual(SettlementConditionVO settlementConditionVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = settlementConditionVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			//joo_stl_itm ?낅젰
			int result = sqlExe.executeUpdate((ISQLTemplate)new JointOperationAccrualCreationDBDAOModifyJooEstmActRsltUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
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
	 * 
	 * [추정실적산출 테이블(JOO_ESTM_ACT_RSLT) ]을 [I/F 삭제] 합니다.<br>
	 * UID : FNS_JOO_0029 <br>
	 * 
	 * @param String lsYearMn
	 * @throws DAOException
	 * @throws Exception
	 * @author jang kang cheol
	 */
	public void removeJOOAccural(String lsYearMn) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("exe_yrmon" , lsYearMn);
			mapVO.put("sys_src_id", "JOO");

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe
					.executeUpdate(
							(ISQLTemplate) new JointOperationAccrualCreationDBDAOGlEstmIfErpDSQL(),
							param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [추정실적산출 테이블(JOO_ESTM_ACT_RSLT) ]을 [I/F 생성] 합니다.<br>
	 * UID : FNS_JOO_0029 <br>
	 * 
	 * @param EstmActRsltVO estmActRsltVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJOOAccurals(EstmActRsltVO estmActRsltVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = estmActRsltVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe
					.executeUpdate(
							(ISQLTemplate) new JointOperationAccrualCreationDBDAOGlEstmIfErpCSQL(),
							param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [Estimate Code Check - Carrier]을 [조회Retrieve]합니다.<br>
	 * @param String yearMm
	 * @return List<EstdCarVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<EstdCarVO> searchEstdCarCheckList(String yearMm)
			throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<EstdCarVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("acct_yrmon", yearMm);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationAccrualCreationDBDAOEstdCarRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstdCarVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * [Estimate Code Check - VVD]을 [조회Retrieve]합니다.<br>
	 * @param EstdVvdVO estdVvdVO
	 * @return List<EstdVvdVO> 
	 * @throws DAOException
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<EstdVvdVO> searchEstdVvdCheckList(EstdVvdVO estdVvdVO)
			throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<EstdVvdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO =  estdVvdVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			if( estdVvdVO.getYrmonType().equals("curr")){
			     dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new JointOperationAccrualCreationDBDAOEstdVvdRSQL(), param, velParam);
			}else if( estdVvdVO.getYrmonType().equals("curr_estm")){
			     dbRowset = new SQLExecuter("").executeQuery(
                   (ISQLTemplate) new JointOperationAccrualCreationDBDAOSearchEstdVvdEstmRSQL(), param, velParam);
			}else if( estdVvdVO.getYrmonType().equals("prev")){
			     dbRowset = new SQLExecuter("").executeQuery(
                   (ISQLTemplate) new JointOperationAccrualCreationDBDAOSearchEstdVvdPrevRSQL(), param, velParam);
			}
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstdVvdVO.class);
            
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Estimation Creation 대상 조회
	 * @param SettlementConditionVO settlementConditionVO
	 * @return List<EstmActRsltVO>
	 * @throws DAOException
	 */
	public List<EstmActRsltVO> calJointOperationAccrual(SettlementConditionVO settlementConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmActRsltVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (settlementConditionVO != null) {
				Map<String, String> mapVO = settlementConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOEstmActRsltCreRSQL(),param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmActRsltVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * Estimation Creation
	 * @param SettlementConditionVO settlementConditionVO
	 * @throws DAOException
	 */	
	public void createJointOperationAccrual(SettlementConditionVO settlementConditionVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = settlementConditionVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new JointOperationAccrualCreationDBDAOEstmActRsltCreCSQL(),param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	
	
	/**
	 * Estimate Performance Inquiry
	 * 추정 결과를 조회합니다.
	 * @param EstmConditionVO estmConditionVO
	 * @return List<EstmActRsltVO>
	 * @throws DAOException
	 */
	public List<EstmActRsltVO> searchEstmPerformanceList(EstmConditionVO estmConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmActRsltVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (estmConditionVO != null) {
				Map<String, String> mapVO = estmConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationAccrualCreationDBDAOSearchEstmPerformanceRSQL(),
							param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmActRsltVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	/**
	 * 
	 * [추정실적산출 테이블(JOO_ESTM_ACT_RSLT) ]을 [저장] 합니다.<br>
	 * 
	 * @param  List<EstmActRsltVO> estmActRsltVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJointOperationAccrualS(List<EstmActRsltVO> estmActRsltVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(estmActRsltVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new JointOperationAccrualCreationDBDAOAddJooEstmActRsltCSQL(), estmActRsltVOs,null);
				for(int i = 0; i < insCnt.length; i++){
					if(insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
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
	 * Estimation의 Total값을 Return한다.
	 * @param SettlementConditionVO settlementConditionVO
	 * @return EstmActRsltVO
	 * @throws DAOException
	 */
	public EstmActRsltVO searchJointOperationAccrualTotal(SettlementConditionVO settlementConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmActRsltVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (settlementConditionVO != null) {
				Map<String, String> mapVO = settlementConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if (settlementConditionVO != null) {
				if("1".equals(settlementConditionVO.getSearchGubun())){			// 1:Retrieve, 2:Target Retrieve 3:I/F Retrieve
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOEstmActRsltTotalRSQL(), param, velParam);				
				}else if("2".equals(settlementConditionVO.getSearchGubun())){		
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOTargetEstmActRsltTotalRSQL(), param, velParam);				
				}
			}
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmActRsltVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.get(0);
	}
	
	/**
	 * Estimation의 Total(ERP)값을 Return한다.
	 * @param SettlementConditionVO settlementConditionVO
	 * @return EstmActRsltVO
	 * @throws DAOException
	 */
	public EstmActRsltVO searchJointOperationAccrualERPTotal(SettlementConditionVO settlementConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmActRsltVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (settlementConditionVO != null) {
				Map<String, String> mapVO = settlementConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOSearchJointOperationAccrualERPTotalRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmActRsltVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list.get(0);
	}	
	
	/**
	 * Estimate Performance Change Status I
	 * 추정 결과를 조회합니다.
	 * @param EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO
	 * @return List<EstmPerformanceChangeStatusRsltVO>
	 * @throws DAOException
	 */
	public List<EstmPerformanceChangeStatusRsltVO> searchEstmPerformanceChangeStatusList(EstmPerformanceChangeStatusVO estmPerformanceChangeStatusVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmPerformanceChangeStatusRsltVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (estmPerformanceChangeStatusVO != null) {
				Map<String, String> mapVO = estmPerformanceChangeStatusVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			if("1".equals(estmPerformanceChangeStatusVO.getEstmOption())){
				//조회조건 Adjusted Estimate 선택
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusAdjRSQL(),param, velParam);				
			}else{
				//조회조건 Initial Estimate 선택				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusRSQL(),param, velParam);				
			}


			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmPerformanceChangeStatusRsltVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	
	/**
	 * 추정결과를 체크합니다.
	 * @param EstmPerformanceChangeStatusRsltVO estmPerformanceChangeStatusRsltVOs
	 * @return List<EstmPerformanceChangeStatusRsltVO>
	 * @throws DAOException
	 * @throws Exception
	 */
	public List<EstmPerformanceChangeStatusRsltVO> chkEstmPerformanceChangeStatus(EstmPerformanceChangeStatusRsltVO estmPerformanceChangeStatusRsltVOs) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<EstmPerformanceChangeStatusRsltVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(estmPerformanceChangeStatusRsltVOs != null){
				Map<String, String> mapVO = estmPerformanceChangeStatusRsltVOs.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusChkSQL(), param, velParam);
			
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, EstmPerformanceChangeStatusRsltVO .class);
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

	
	/**
	 * 추정결과를 저장합니다.
	 * @param List<EstmPerformanceChangeStatusRsltVO> estmPerformanceChangeStatusRsltVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addEstmPerformanceChangeStatus(List<EstmPerformanceChangeStatusRsltVO> estmPerformanceChangeStatusRsltVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int creCnt[] = null;

			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			if (estmPerformanceChangeStatusRsltVOs.size() > 0) {
				
				Map<String, String> mapVO = estmPerformanceChangeStatusRsltVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);
			
				creCnt = sqlExe.executeBatch((ISQLTemplate) new JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusCSQL(), estmPerformanceChangeStatusRsltVOs, velParam);
				
				for (int i = 0; i < creCnt.length; i++) {
					if (creCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No" + i + " SQL");
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
	 * 추정결과를 수정합니다.
	 * @param List<EstmPerformanceChangeStatusRsltVO> estmPerformanceChangeStatusRsltVOs
	 * @throws DAOException
	 * @throws Exception
	 */
	public void modifyEstmPerformanceChangeStatus(List<EstmPerformanceChangeStatusRsltVO> estmPerformanceChangeStatusRsltVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;

			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			if (estmPerformanceChangeStatusRsltVOs.size() > 0) {
				
				Map<String, String> mapVO = estmPerformanceChangeStatusRsltVOs.get(0).getColumnValues();
				velParam.putAll(mapVO);

				updCnt = sqlExe.executeBatch((ISQLTemplate) new JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusUSQL(), estmPerformanceChangeStatusRsltVOs, velParam);
				
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No" + i + " SQL");
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
	 * Estimate Performance Change Status II
	 * 추정 결과를 조회합니다.
	 * @param EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO
	 * @return List<EstmPerformanceChangeStatusIIRsltVO>
	 * @throws DAOException
	 */
	public List<EstmPerformanceChangeStatusIIRsltVO> searchEstmPerformanceChangeStatusIIList(EstmPerformanceChangeStatusIIVO estmPerformanceChangeStatusIIVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmPerformanceChangeStatusIIRsltVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (estmPerformanceChangeStatusIIVO != null) {
				Map<String, String> mapVO = estmPerformanceChangeStatusIIVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new JointOperationAccrualCreationDBDAOSearchEstmPerformanceChangeStatusIIRSQL(),
							param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstmPerformanceChangeStatusIIRsltVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	
	
}