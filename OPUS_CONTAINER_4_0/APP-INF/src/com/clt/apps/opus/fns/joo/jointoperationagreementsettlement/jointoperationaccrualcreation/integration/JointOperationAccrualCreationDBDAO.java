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
=========================================================*/
package com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.basic.JointOperationAccrualCreationBCImpl;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.ActRsltRVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstdCarVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstdVvdVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmActRsltVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.EstmConditionVO;
import com.clt.apps.opus.fns.joo.jointoperationagreementsettlement.jointoperationaccrualcreation.vo.SettlementConditionVO;
import com.clt.apps.opus.fns.joo.joocommonutil.BizComJooUtil;
import com.clt.apps.opus.fns.joo.joocommonutil.JooConstants;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.JooEstmClzVO;

/**
 * OPUS JointOperationAccrualCrationDBDAO <br>
 * - OPUS-JointOperationAgreementSettlement system Business Logic을 처리하기 위한 JDBC
 * 작업수행.<br>
 * 
 * @author HAM DAE SUNG
 * @see JointOperationAccrualCreationBCImpl 참조
 * @since J2EE 1.6
 */
public class JointOperationAccrualCreationDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 0030 Closing 여부를 조회한다. <br>
	 * @param String estmClzYr
	 * @return String
	 * @exception EventException
	 */
	public String searchExistAccrualClosing(String estmClzYr) throws DAOException {
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOExistAccrualClosingRSQL(),param, velParam);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<JooEstmClzVO> searchAccrualClosing(JooEstmClzVO jooEstmClzVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOJooEstmClzVORSQL(),param, velParam);
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
				int result = sqlExe.executeUpdate((ISQLTemplate) new JointOperationAccrualCreationDBDAOJooEstmClzVOCSQL(),param, null);

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
	public void modifyAccrualClosing(List<JooEstmClzVO> jooEstmClzVOs ) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (jooEstmClzVOs .size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new JointOperationAccrualCreationDBDAOJooEstmClzVOUSQL(),jooEstmClzVOs , null);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ActRsltRVO> searchAccrualListByAccount(ActRsltRVO actRsltRVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOJooEstmActRsltVORSQL(),param, velParam);

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ActRsltRVO> searchAccrualListByMAS(ActRsltRVO actRsltRVO) throws DAOException {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOEstmActRsltMasRSQL(),param, velParam);

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
				updCnt = sqlExe.executeBatch((ISQLTemplate) new JointOperationAccrualCreationDBDAOJooEstmActRsltUSQL(),estmActRsltVOs, null);
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
	public void removeJointOperationAccrual(SettlementConditionVO settlementConditionVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = settlementConditionVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			//2015.07.10 Modify : Item : ALL을 제외한 S/H, OPR, 그외 Item.
			List<String> allItemList = new ArrayList<String>();
			allItemList = BizComJooUtil.getSeperationParameterList(settlementConditionVO.getJoStlItmCd(), ",");
			if (null != allItemList && allItemList.size() > 0){
				velParam.put("jo_stl_itm_cds", allItemList); //S/H,OPR  를 제외한 Item 목록.
			}else{
				velParam.put("jo_stl_itm_cds", ""); //S/H,OPR  를 제외한 Item 목록.
			}
			
			int result = new SQLExecuter("").executeUpdate((ISQLTemplate) new JointOperationAccrualCreationDBDAORemJooEstmActRsltDSQL(),param, velParam);
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
	 * [추정실적산출 테이블(JOO_ESTM_ACT_RSLT) ]을 [삭제] 합니다.<br>
	 * UID : FNS_JOO_0029 <br>
	 * 
	 * @param  List<EstmActRsltVO> estmActRsltVOs
	 * @throws DAOException
	 * @throws Exception
	 * @author jang kang cheol
	 */
	public void removeJointOperationAccrualList(List<EstmActRsltVO> estmActRsltVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (estmActRsltVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new JointOperationAccrualCreationDBDAORemJooEstmActRsltListDSQL(),estmActRsltVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Delete No" + i + " SQL");
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
			int result = sqlExe.executeUpdate((ISQLTemplate) new JointOperationAccrualCreationDBDAOGlEstmIfErpDSQL(),param, velParam);
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
			int result = sqlExe.executeUpdate((ISQLTemplate) new JointOperationAccrualCreationDBDAOGlEstmIfErpCSQL(),param, velParam);
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
	 * [추정실적산출 테이블(JOO_ESTM_ACT_RSLT) ]을 [GL_ESTM_IF_ERP] ALL Insert 합니다.<br>
	 * UID : FNS_JOO_0029 <br>
	 * 
	 * @param SettlementConditionVO settlementConditionVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJOOAllAccurals(SettlementConditionVO settlementConditionVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = settlementConditionVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new JointOperationAccrualCreationDBDAOGlEstmIfErpAllCSQL(),param, velParam);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EstdCarVO> searchEstdCarCheckList(String yearMm) throws DAOException, Exception {
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOEstdCarRSQL(),param, velParam);
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
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EstdVvdVO> searchEstdVvdCheckList(EstdVvdVO estdVvdVO) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<EstdVvdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			if(null != estdVvdVO){
				Map<String, String> mapVO =  estdVvdVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				if( estdVvdVO.getYrmonType().equals("curr")){
				     dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOEstdVvdRSQL(), param, velParam);
				}else{
					//else if( estdVvdVO.getYrmonType().equals("prev")){
					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOSearchEstdVvdPrevRSQL(), param, velParam);
				}
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, EstdVvdVO.class);
			}
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
	 * @return List<EstmActRsltVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EstmActRsltVO> calJointOperationAccrual(SettlementConditionVO settlementConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmActRsltVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			//String jo_stl_itm_flg = "N"; //jo_stl_itm_cd가 S/H 만 있을대.. 
			
			if (settlementConditionVO != null) {
				Map<String, String> mapVO = settlementConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//2015.07.10 Modify : Item : ALL을 제외한 S/H, OPR, 그외 Item.
				List<String> allItemList = new ArrayList<String>();
				allItemList = BizComJooUtil.getSeperationParameterList(settlementConditionVO.getJoStlItmCd(), ",");
				if (null != allItemList && allItemList.size() > 0){
					//jo_stl_itm_flg = "Y";
					//추가적인 조건.
					//velParam.put("jo_stl_itm_flg", "Y"); //S/H,OPR 를 제외한 Item 존재 여부.
					velParam.put("jo_stl_itm_cds", allItemList); //S/H,OPR  를 제외한 Item 목록.
				}else{
					//추가적인 조건.
					//velParam.put("jo_stl_itm_flg", "N"); //S/H,OPR 를 제외한 Item 존재 여부.
					velParam.put("jo_stl_itm_cds", ""); //S/H,OPR  를 제외한 Item 목록.
				}
				
				/*
				//S/H 존재 여부 체크.
				if(allItemList.contains((String)JooConstants.KEY_JO_STL_ITM_CD_SH)){
					param.put("jo_stl_itm_cd_of_sh", JooConstants.KEY_JO_STL_ITM_CD_SH);
					velParam.put("jo_stl_itm_cd_of_sh", JooConstants.KEY_JO_STL_ITM_CD_SH);
				}
				//OPR 존재 여부 체크.
				if(allItemList.contains((String)JooConstants.KEY_JO_STL_ITM_CD_OPR)){
					param.put("jo_stl_itm_cd_of_opr", JooConstants.KEY_JO_STL_ITM_CD_OPR);
					velParam.put("jo_stl_itm_cd_of_opr", JooConstants.KEY_JO_STL_ITM_CD_OPR);
				}
				
				//Data : ALL,S/H,R/F 식으로 ALL 일경우 해당 vndrSeq를 다 넘기므로 체크 해서 직접 넣어준다.
				// ALL, S/H, OPR 값을 제외하고 그외 jo_stl_itm_cd를 List 로 리턴한다.
				List<String> othItemList = new ArrayList<String>();
				othItemList = BizComJooUtil.getSeperationParameterList(settlementConditionVO.getJoStlItmCd(), ",", new String[]{JooConstants.KEY_JO_STL_ITM_CD_SH, JooConstants.KEY_JO_STL_ITM_CD_OPR});
				
				if (null != othItemList && othItemList.size() > 0){
					//jo_stl_itm_flg = "Y";
					//추가적인 조건.
					velParam.put("jo_stl_itm_flg", "Y"); //S/H,OPR 를 제외한 Item 존재 여부.
					velParam.put("jo_stl_itm_cds", othItemList); //S/H,OPR  를 제외한 Item 목록.
				}else{
					//추가적인 조건.
					velParam.put("jo_stl_itm_flg", "N"); //S/H,OPR 를 제외한 Item 존재 여부.
					velParam.put("jo_stl_itm_cds", ""); //S/H,OPR  를 제외한 Item 목록.
				}	*/											
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
	 * Estimate Performance Inquiry
	 * 추정 결과를 조회합니다.
	 * @param EstmConditionVO estmConditionVO
	 * @return List<EstmActRsltVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOSearchEstmPerformanceRSQL(),param, velParam);

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
	 * Estimate Performance Inquiry By VVD
	 * 추정 결과를 조회합니다.
	 * @param EstmConditionVO estmConditionVO
	 * @return List<EstmActRsltVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EstmActRsltVO> searchEstmPerformanceByVvdList(EstmConditionVO estmConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmActRsltVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			List<String> itemList = new ArrayList<String>();
			
			//Data : ALL,S/H,R/F 식으로 ALL 일경우 해당 vndrSeq를 다 넘기므로 체크 해서 직접 넣어준다.
			// ALL값을 제외하고 그외 jo_stl_itm_cd를 List 로 리턴한다.
			itemList = BizComJooUtil.getSeperationParameterList(estmConditionVO.getJoStlItmCd(), ",");
			
			if (estmConditionVO != null) {
				Map<String, String> mapVO = estmConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//Create BackandJob 으로 돌릴경우 전체 Item을 리턴하도록 한다.
				//if(!JooConstants.KEY_CRE_FLG_BACKEND.equals(estmConditionVO.getCreFlg())){
					if(itemList != null && itemList.size() > 0){
						velParam.put("jo_stl_itm_cds", itemList); //S/H 를 제외한 Item 목록.
					}else{
						velParam.put("jo_stl_itm_cds", "");
					}
				//}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOSearchEstmPerformanceByVvdRSQL(),param, velParam);

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
	 * Estimate Performance Inquiry By Month
	 * 추정 결과를 조회합니다.
	 * @param EstmConditionVO estmConditionVO
	 * @return List<EstmActRsltVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EstmActRsltVO> searchEstmPerformanceByMonthList(EstmConditionVO estmConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmActRsltVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			List<String> itemList = new ArrayList<String>();
			
			//Data : ALL,S/H,R/F 식으로 ALL 일경우 해당 vndrSeq를 다 넘기므로 체크 해서 직접 넣어준다.
			// ALL값을 제외하고 그외 jo_stl_itm_cd를 List 로 리턴한다.
			itemList = BizComJooUtil.getSeperationParameterList(estmConditionVO.getJoStlItmCd(), ",");
			
			if (estmConditionVO != null) {
				Map<String, String> mapVO = estmConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//Create BackandJob 으로 돌릴경우 전체 Item을 리턴하도록 한다.
				//if(!JooConstants.KEY_CRE_FLG_BACKEND.equals(estmConditionVO.getCreFlg())){
					if(itemList != null && itemList.size() > 0){
						velParam.put("jo_stl_itm_cds", itemList); //S/H 를 제외한 Item 목록.
					}else{
						velParam.put("jo_stl_itm_cds", "");
					}
				//}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOSearchEstmPerformanceByMonthRSQL(),param, velParam);

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
	public void addJointOperationAccrualList(List<EstmActRsltVO> estmActRsltVOs) throws DAOException, Exception {
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
	 * [추정실적산출 테이블(JOO_ESTM_ACT_RSLT) ]을 [저장] 합니다.<br>
	 * 
	 * @param estmActRsltVO EstmActRsltVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addJointOperationAccrual(EstmActRsltVO estmActRsltVO) throws DAOException, Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = estmActRsltVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new JointOperationAccrualCreationDBDAOAddJooEstmActRsltCSQL(),param, velParam);
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
	 * Estimation의 Total값을 Return한다.
	 * @param SettlementConditionVO settlementConditionVO
	 * @return EstmActRsltVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EstmActRsltVO searchJointOperationAccrualTotal(SettlementConditionVO settlementConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmActRsltVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			List<String> itemList = new ArrayList<String>();
			
			//Data : ALL,S/H,R/F 식으로 ALL 일경우 해당 vndrSeq를 다 넘기므로 체크 해서 직접 넣어준다.
			// ALL값을 제외하고 그외 jo_stl_itm_cd를 List 로 리턴한다.
			itemList = BizComJooUtil.getSeperationParameterList(settlementConditionVO.getJoStlItmCd(), ",");
			
			if (settlementConditionVO != null) {
				Map<String, String> mapVO = settlementConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//Create BackandJob 으로 돌릴경우 전체 Item을 리턴하도록 한다.
				//if(!JooConstants.KEY_CRE_FLG_BACKEND.equals(settlementConditionVO.getCreFlg())){
					if(itemList != null && itemList.size() > 0){
						velParam.put("jo_stl_itm_cds", itemList); //S/H 를 제외한 Item 목록.
					}else{
						velParam.put("jo_stl_itm_cds", "");
					}
				//}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOEstmActRsltTotalRSQL(), param, velParam);
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
	 * 
	 * <pre>
	 *   Estimate Performance Creation By VVD
	 *      UID : FNS_JOO_0029
	 * </pre>
	 * 
	 * @param SettlementConditionVO settlementConditionVO
	 * @return List<EstmActRsltVO>
	 * @throws DAOException
	 * @author jang kang cheol
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EstmActRsltVO> searchJointOperationAccrualByVvdList(SettlementConditionVO settlementConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmActRsltVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			List<String> itemList = new ArrayList<String>();
			
			//Data : ALL,S/H,R/F 식으로 ALL 일경우 해당 vndrSeq를 다 넘기므로 체크 해서 직접 넣어준다.
			// ALL값을 제외하고 그외 jo_stl_itm_cd를 List 로 리턴한다.
			itemList = BizComJooUtil.getSeperationParameterList(settlementConditionVO.getJoStlItmCd(), ",");
						
			if (settlementConditionVO != null) {
				Map<String, String> mapVO = settlementConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//Create BackandJob 으로 돌릴경우 전체 Item을 리턴하도록 한다.
				//if(!JooConstants.KEY_CRE_FLG_BACKEND.equals(settlementConditionVO.getCreFlg())){
					if(itemList != null && itemList.size() > 0){
						velParam.put("jo_stl_itm_cds", itemList); //S/H 를 제외한 Item 목록.
					}else{
						velParam.put("jo_stl_itm_cds", "");
					}
				//}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOEstmActRsltVOByVvdRSQL(), param, velParam);
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
	 *   Estimate Performance Creation By Month
	 *      UID : FNS_JOO_0029
	 * </pre>
	 * 
	 * @param SettlementConditionVO settlementConditionVO
	 * @return List<EstmActRsltVO>
	 * @throws DAOException
	 * @author jang kang cheol
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<EstmActRsltVO> searchJointOperationAccrualByMonthList(SettlementConditionVO settlementConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmActRsltVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			List<String> itemList = new ArrayList<String>();
			
			//Data : ALL,S/H,R/F 식으로 ALL 일경우 해당 vndrSeq를 다 넘기므로 체크 해서 직접 넣어준다.
			// ALL값을 제외하고 그외 jo_stl_itm_cd를 List 로 리턴한다.
			itemList = BizComJooUtil.getSeperationParameterList(settlementConditionVO.getJoStlItmCd(), ",");
			
			if (settlementConditionVO != null) {
				Map<String, String> mapVO = settlementConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//Create BackandJob 으로 돌릴경우 전체 Item을 리턴하도록 한다.
				//if(!JooConstants.KEY_CRE_FLG_BACKEND.equals(settlementConditionVO.getCreFlg())){
					if(itemList != null && itemList.size() > 0){
						velParam.put("jo_stl_itm_cds", itemList); //S/H 를 제외한 Item 목록.
					}else{
						velParam.put("jo_stl_itm_cds", "");
					}
				//}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOEstmActRsltVOByMonthRSQL(), param, velParam);
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
	 * Estimation의 Total By Vvd값을 Return한다.
	 * @param SettlementConditionVO settlementConditionVO
	 * @return EstmActRsltVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EstmActRsltVO searchJointOperationAccrualTotalByVvd(SettlementConditionVO settlementConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmActRsltVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			List<String> itemList = new ArrayList<String>();
			
			//Data : ALL,S/H,R/F 식으로 ALL 일경우 해당 vndrSeq를 다 넘기므로 체크 해서 직접 넣어준다.
			// ALL값을 제외하고 그외 jo_stl_itm_cd를 List 로 리턴한다.
			itemList = BizComJooUtil.getSeperationParameterList(settlementConditionVO.getJoStlItmCd(), ",");
			
			if (settlementConditionVO != null) {
				Map<String, String> mapVO = settlementConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//Create BackandJob 으로 돌릴경우 전체 Item을 리턴하도록 한다.
				//if(!JooConstants.KEY_CRE_FLG_BACKEND.equals(settlementConditionVO.getCreFlg())){
					if(itemList != null && itemList.size() > 0){
						velParam.put("jo_stl_itm_cds", itemList); //S/H 를 제외한 Item 목록.
					}else{
						velParam.put("jo_stl_itm_cds", "");
					}
				//}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOEstmActRsltTotalByVvdRSQL(), param, velParam);
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
	 * Estimation의 Total By Month값을 Return한다.
	 * @param SettlementConditionVO settlementConditionVO
	 * @return EstmActRsltVO
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EstmActRsltVO searchJointOperationAccrualTotalByMonth(SettlementConditionVO settlementConditionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<EstmActRsltVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			List<String> itemList = new ArrayList<String>();
			
			//Data : ALL,S/H,R/F 식으로 ALL 일경우 해당 vndrSeq를 다 넘기므로 체크 해서 직접 넣어준다.
			// ALL값을 제외하고 그외 jo_stl_itm_cd를 List 로 리턴한다.
			itemList = BizComJooUtil.getSeperationParameterList(settlementConditionVO.getJoStlItmCd(), ",");
			
			if (settlementConditionVO != null) {
				Map<String, String> mapVO = settlementConditionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				//Create BackandJob 으로 돌릴경우 전체 Item을 리턴하도록 한다.
				//if(!JooConstants.KEY_CRE_FLG_BACKEND.equals(settlementConditionVO.getCreFlg())){
					if(itemList != null && itemList.size() > 0){
						velParam.put("jo_stl_itm_cds", itemList); //S/H 를 제외한 Item 목록.
					}else{
						velParam.put("jo_stl_itm_cds", "");
					}
				//}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOEstmActRsltTotalByMonthRSQL(), param, velParam);
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
	 * 0029 ESTM_ACT_SEQ Max 조회한다. <br>
	 * @param EstmActRsltVO estmActRsltVO
	 * @return String
	 * @exception EventException
	 */
	public String searchMaxEstmActSeq(EstmActRsltVO estmActRsltVO) throws DAOException {
		DBRowSet dbRowset = null;
		String maxEstmActSeq = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO =  estmActRsltVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new JointOperationAccrualCreationDBDAOSearchMaxEstmActSeqRSQL(),param, velParam);
			while (dbRowset.next()) {
				maxEstmActSeq = dbRowset.getString("MAX_ESTM_ACT_SEQ");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return maxEstmActSeq;
	}	
}