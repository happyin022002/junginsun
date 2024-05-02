/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : OperationNPerformMasterDataMgtDBDAO.java
 *@FileTitle : Stevedore Damage Part Code (Creation)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.12
 *@LastModifier : 우지석
 *@LastVersion : 1.0
 * 2009.05.12 우지석
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.basic.OperationNPerformMasterDataMgtBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.MdmLocationVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;
import com.clt.syscommon.common.table.OpfCodDvsFeeVO;
import com.clt.syscommon.common.table.OpfCodRjctCdVO;
import com.clt.syscommon.common.table.OpfRstwgRsnCdVO;
import com.clt.syscommon.common.table.OpfStvDmgCdVO;
import com.clt.syscommon.common.table.OpfTmlProdRptRsnCdVO;

/**
 * OPUS OperationNPerformMasterDataMgtDBDAO <br>
 * - OPUS-OperationNPerformMasterDataMgt system Business Logic을 처리하기 위한 JDBC
 * 작업수행.<br>
 * 
 * @author Ji Seok Woo
 * @see OperationNPerformMasterDataMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class OperationNPerformMasterDataMgtDBDAO extends DBDAOSupport {

	/**
	 * Steve Damage Part Code List를 조회 합니다. <br>
	 * 
	 * @param OpfStvDmgCdVO opfStvDmgCdVO
	 * @return List<OpfStvDmgCdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpfStvDmgCdVO> searchStevedoreDamagePartCodeList(OpfStvDmgCdVO opfStvDmgCdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfStvDmgCdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (opfStvDmgCdVO != null) {
				Map<String, String> mapVO = opfStvDmgCdVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery( (ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfStvDmgCdVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OpfStvDmgCdVO.class);
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
	 * Steve Damage Reason Code List를 조회 합니다. <br>
	 * 
	 * @param OpfStvDmgCdVO opfStvDmgCdVO
	 * @return List<OpfStvDmgCdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpfStvDmgCdVO> searchStevedoreDamageReasonCodeList(OpfStvDmgCdVO opfStvDmgCdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfStvDmgCdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (opfStvDmgCdVO != null) {
				Map<String, String> mapVO = opfStvDmgCdVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			dbRowset = new SQLExecuter("").executeQuery( (ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfStvDmgRsnCdRSQL(),	param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OpfStvDmgCdVO.class);
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
	 * Exclude TPR Reason Code List를 조회 합니다. <br>
	 * 
	 * @param OpfTmlProdRptRsnCdVO opfTmlProdRptRsnCdVO
	 * @return List<OpfTmlProdRptRsnCdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpfTmlProdRptRsnCdVO> searchExcludeTPRReasonCodeList(OpfTmlProdRptRsnCdVO opfTmlProdRptRsnCdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfTmlProdRptRsnCdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (opfTmlProdRptRsnCdVO != null) {
				Map<String, String> mapVO = opfTmlProdRptRsnCdVO
						.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfTmlProdRptRsnCdVORSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					OpfTmlProdRptRsnCdVO.class);
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
	 * Stevedore Damage Part Code List를 저장합니다. <br>
	 * 
	 * @param List<OpfStvDmgCdVO> opfStvDmgCdVOs
	 * @throws DAOException
	 */
	public void addmanageStevedoreDamagePartCodeS(List<OpfStvDmgCdVO> opfStvDmgCdVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (opfStvDmgCdVOs.size() > 0) {
				insCnt = sqlExe.executeBatch( (ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfStvDmgCdVOCSQL(), opfStvDmgCdVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
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
	 * Stevedore Damage Reason Code List를 저장합니다. <br>
	 * 
	 * @param List<OpfStvDmgCdVO> opfStvDmgCdVOs
	 * @throws DAOException
	 */
	public void addmanageStevedoreDamageReasonCodeS(List<OpfStvDmgCdVO> opfStvDmgCdVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (opfStvDmgCdVOs.size() > 0) {
				insCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfStvDmgRsnCdCSQL(),
								opfStvDmgCdVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
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
	 * Exclude TPR Reason Code List를 저장합니다. <br>
	 * 
	 * @param List<OpfTmlProdRptRsnCdVO> opfTmlProdRptRsnCdVOs
	 * @throws DAOException
	 */
	public void addmanageExcludeTPRReasonCodeS(List<OpfTmlProdRptRsnCdVO> opfTmlProdRptRsnCdVOs) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (opfTmlProdRptRsnCdVOs.size() > 0) {
				insCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfTmlProdRptRsnCdVOCSQL(),
								opfTmlProdRptRsnCdVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
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
	 * Stevedore Damage Part Code List를 수정합니다. <br>
	 * 
	 * @param List<OpfStvDmgCdVO> opfStvDmgCdVOs
	 * @throws DAOException
	 */
	public void modifymanageStevedoreDamagePartCodeS(List<OpfStvDmgCdVO> opfStvDmgCdVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (opfStvDmgCdVOs.size() > 0) {
				updCnt = sqlExe.executeBatch( (ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfStvDmgCdVOUSQL(), opfStvDmgCdVOs, null);
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
	 * Stevedore Damage Reason Code List를 수정합니다. <br>
	 * 
	 * @param List<OpfStvDmgCdVO> opfStvDmgCdVOs
	 * @throws DAOException
	 */
	public void modifymanageStevedoreDamageReasonCodeS(List<OpfStvDmgCdVO> opfStvDmgCdVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (opfStvDmgCdVOs.size() > 0) {
				updCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfStvDmgRsnCdUSQL(),
								opfStvDmgCdVOs, null);
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
	 * Exclude TPR Reason Code List를 수정합니다. <br>
	 * 
	 * @param List<OpfTmlProdRptRsnCdVO> opfTmlProdRptRsnCdVOs
	 * @throws DAOException
	 */
	public void modifymanageExcludeTPRReasonCodeS(List<OpfTmlProdRptRsnCdVO> opfTmlProdRptRsnCdVOs) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (opfTmlProdRptRsnCdVOs.size() > 0) {
				updCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfTmlProdRptRsnCdVOUSQL(),
								opfTmlProdRptRsnCdVOs, null);
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
	 * Stevedore Damage Part Code List를 삭제합니다. <br>
	 * 
	 * @param List<OpfStvDmgCdVO> opfStvDmgCdVOs
	 * @throws DAOException
	 */
	public void removemanageStevedoreDamagePartCodeS(List<OpfStvDmgCdVO> opfStvDmgCdVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (opfStvDmgCdVOs.size() > 0) {
				delCnt = sqlExe.executeBatch( (ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfStvDmgCdVODSQL(), opfStvDmgCdVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
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
	 * Stevedore Damage Reason Code List를 삭제합니다. <br>
	 * 
	 * @param List<OpfStvDmgCdVO> opfStvDmgCdVOs
	 * @throws DAOException
	 */
	public void removemanageStevedoreDamageReasonCodeS(List<OpfStvDmgCdVO> opfStvDmgCdVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (opfStvDmgCdVOs.size() > 0) {
				delCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfStvDmgRsnCdDSQL(),
								opfStvDmgCdVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
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
	 * Exclude TPR Reason Code List를 삭제합니다. <br>
	 * 
	 * @param List<OpfTmlProdRptRsnCdVO> opfTmlProdRptRsnCdVOs
	 * @throws DAOException
	 */
	public void removemanageExcludeTPRReasonCodeS(List<OpfTmlProdRptRsnCdVO> opfTmlProdRptRsnCdVOs) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (opfTmlProdRptRsnCdVOs.size() > 0) {
				delCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfTmlProdRptRsnCdVODSQL(),
								opfTmlProdRptRsnCdVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
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

	// VOP_OPF_0075 Start========================================================================//
	/**
	 * Restow Reason Code을 조회 합니다. <br>
	 * 
	 * @param OpfRstwgRsnCdVO opfRstwgRsnCdVO
	 * @return List<OpfRstwgRsnCdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpfRstwgRsnCdVO> searchRestowReasonCodeList(OpfRstwgRsnCdVO opfRstwgRsnCdVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<OpfRstwgRsnCdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (opfRstwgRsnCdVO != null) {
				Map<String, String> mapVO = opfRstwgRsnCdVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfRstwgRsnCdVORSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset,
					OpfRstwgRsnCdVO.class);
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
	 * Restow Reason Code의 중복되는 정보가 있는지 여부를 조회 합니다. <br>
	 * 
	 * @param OpfRstwgRsnCdVO opfRstwgRsnCdVO
	 * @return List<OpfRstwgRsnCdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpfRstwgRsnCdVO> searchRestowReasonCode(OpfRstwgRsnCdVO opfRstwgRsnCdVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<OpfRstwgRsnCdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (opfRstwgRsnCdVO != null) {
				Map<String, String> mapVO = opfRstwgRsnCdVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("delt_flg", "Y");
			}
			dbRowset = new SQLExecuter("").executeQuery(
							(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAORstwgRsnCdRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, OpfRstwgRsnCdVO.class);
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
	 * Restow Reason Code를 생성 합니다. <br>
	 * 
	 * @param OpfRstwgRsnCdVO opfRstwgRsnCdVO
	 * @throws DAOException
	 */
	public void addRestowReasonCode(OpfRstwgRsnCdVO opfRstwgRsnCdVO) throws DAOException,
			Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = opfRstwgRsnCdVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe
					.executeUpdate(
							(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfRstwgRsnCdVOCSQL(),
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
	 * Restow Reason Code를 갱신 합니다. <br>
	 * 
	 * @param OpfRstwgRsnCdVO opfRstwgRsnCdVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyRestowReasonCode(OpfRstwgRsnCdVO opfRstwgRsnCdVO) throws DAOException,
			Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = opfRstwgRsnCdVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe
					.executeUpdate(
							(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfRstwgRsnCdVOUSQL(),
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
		return result;
	}

	/**
	 * Restow Reason Code를 삭제 합니다. <br>
	 * 
	 * @param OpfRstwgRsnCdVO opfRstwgRsnCdVO
	 * @return int
	 * @throws DAOException
	 */
	public int removeRestowReasonCode(OpfRstwgRsnCdVO opfRstwgRsnCdVO) throws DAOException,
			Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = opfRstwgRsnCdVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe
					.executeUpdate(
							(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfRstwgRsnCdVODSQL(),
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
		return result;
	}

	/**
	 * Restow Reason Code를 생성 합니다. <br>
	 * 
	 * @param List<OpfRstwgRsnCdVO> opfRstwgRsnCdVOs
	 * @throws DAOException
	 */
	public void addRestowReasonCode(List<OpfRstwgRsnCdVO> opfRstwgRsnCdVOs)	throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (opfRstwgRsnCdVOs.size() > 0) {
				insCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfRstwgRsnCdVOCSQL(),
								opfRstwgRsnCdVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
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
	 * Restow Reason Code를 갱신 합니다. <br>
	 * 
	 * @param List<OpfRstwgRsnCdVO> opfRstwgRsnCdVOs
	 * @throws DAOException
	 */
	public void modifyRestowReasonCode(List<OpfRstwgRsnCdVO> opfRstwgRsnCdVOs)	throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			
			if (opfRstwgRsnCdVOs.size() > 0) {
				updCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfRstwgRsnCdVOUSQL(),
								opfRstwgRsnCdVOs, null);
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
	 * Restow Reason Code를 삭제 합니다. <br>
	 * 
	 * @param List<OpfRstwgRsnCdVO> opfRstwgRsnCdVOs
	 * @throws DAOException
	 */
	public void removeRestowReasonCode(List<OpfRstwgRsnCdVO> opfRstwgRsnCdVOs)	throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (opfRstwgRsnCdVOs.size() > 0) {
				delCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfRstwgRsnCdVODSQL(),
								opfRstwgRsnCdVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
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

	// VOP_OPF_0075 End ==========================================================================//

	// VOP_OPF_0034 Start ========================================================================//
	/**
	 * COD Reject Reason Code을 조회 합니다. <br>
	 * 
	 * @param OpfCodRjctCdVO opfCodRjctCdVO
	 * @return List<OpfCodRjctCdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpfCodRjctCdVO> searchCODRejectReasonCodeList(OpfCodRjctCdVO opfCodRjctCdVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<OpfCodRjctCdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (opfCodRjctCdVO != null) {
				Map<String, String> mapVO = opfCodRjctCdVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfCodRjctCdVORSQL(),
							param, velParam);
			list = (List) RowSetUtil
					.rowSetToVOs(dbRowset, OpfCodRjctCdVO.class);
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
	 * COD Reject Reason Code의 중복되는 정보가 있는지 여부를 조회 합니다. <br>
	 * 
	 * @param OpfCodRjctCdVO opfCodRjctCdVO
	 * @return List<OpfCodRjctCdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpfCodRjctCdVO> searchCODRejectReasonCode(OpfCodRjctCdVO opfCodRjctCdVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<OpfCodRjctCdVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (opfCodRjctCdVO != null) {
				Map<String, String> mapVO = opfCodRjctCdVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfCodRjctCdRSQL(),
							param, velParam);
			list = (List) RowSetUtil
					.rowSetToVOs(dbRowset, OpfCodRjctCdVO.class);
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
	 * COD Reject Reason Code을 생성 합니다. <br>
	 * 
	 * @param OpfCodRjctCdVO opfCodRjctCdVO
	 * @throws DAOException
	 */
	public void addCODRejectReasonCode(OpfCodRjctCdVO opfCodRjctCdVO) throws DAOException,	Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = opfCodRjctCdVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe
					.executeUpdate(
							(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfCodRjctCdVOCSQL(),
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
	 * COD Reject Reason Code을 갱신 합니다. <br>
	 * 
	 * @param OpfCodRjctCdVO opfCodRjctCdVO
	 * @return int
	 * @throws DAOException
	 */
	public int modifyCODRejectReasonCode(OpfCodRjctCdVO opfCodRjctCdVO)	throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = opfCodRjctCdVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe
					.executeUpdate(
							(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfCodRjctCdVOUSQL(),
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
		return result;
	}

	/**
	 * COD Reject Reason Code을 삭제 합니다. <br>
	 * 
	 * @param OpfCodRjctCdVO opfCodRjctCdVO
	 * @return int
	 * @throws DAOException
	 */
	public int removeCODRejectReasonCode(OpfCodRjctCdVO opfCodRjctCdVO)	throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {
			Map<String, String> mapVO = opfCodRjctCdVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe
					.executeUpdate(
							(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfCodRjctCdVODSQL(),
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
		return result;
	}

	/**
	 * 다건의 COD Reject Reason Code을 생성 합니다. <br>
	 * 
	 * @param List<OpfCodRjctCdVO> opfCodRjctCdVOs 
	 * @throws DAOException
	 */
	public void addCODRejectReasonCode(List<OpfCodRjctCdVO> opfCodRjctCdVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (opfCodRjctCdVOs.size() > 0) {
				insCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfCodRjctCdVOCSQL(),
								opfCodRjctCdVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
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
	 * 다건의 COD Reject Reason Code을 갱신 합니다. <br>
	 * 
	 * @param List<OpfCodRjctCdVO> opfCodRjctCdVOs
	 * @throws DAOException
	 */
	public void modifyCODRejectReasonCode(List<OpfCodRjctCdVO> opfCodRjctCdVOs)	throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (opfCodRjctCdVOs.size() > 0) {
				updCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfCodRjctCdVOUSQL(),
								opfCodRjctCdVOs, null);
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
	 * 다건의 COD Reject Reason Code을 삭제 합니다. <br>
	 * 
	 * @param List<OpfCodRjctCdVO> opfCodRjctCdVOs
	 * @throws DAOException
	 */
	public void removeCODRejectReasonCode(List<OpfCodRjctCdVO> opfCodRjctCdVOs)	throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (opfCodRjctCdVOs.size() > 0) {
				delCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfCodRjctCdVODSQL(),
								opfCodRjctCdVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
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

	// VOP_OPF_0034 End ==========================================================================//

	// VOP_OPF_0068 Start
	// ========================================================================//
	/**
	 * TPR Target Port Creation 을 조회 합니다. <br>
	 * 
	 * @param MdmLocationVO mdmLocationVO
	 * @return List<MdmLocationVO>
	 * @throws DAOException
	 */
	public List<MdmLocationVO> searchAllPortList(MdmLocationVO mdmLocationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmLocationVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mdmLocationVO != null) {
				Map<String, String> mapVO = mdmLocationVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOMdmLocationVORSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmLocationVO.class);
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
	 * TPR Target Port Creation 을 조회 합니다. <br>
	 * 
	 * @param MdmLocationVO mdmLocationVO
	 * @return List<MdmLocationVO>
	 * @throws DAOException
	 */
	public List<MdmLocationVO> searchTPRTargetPortList(MdmLocationVO mdmLocationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmLocationVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if (mdmLocationVO != null) {
				Map<String, String> mapVO = mdmLocationVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOTargetPortRSQL(),
							param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmLocationVO.class);
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
	 *  TPR Target Port를 수정 합니다. <br>
	 * 
	 * @param List<MdmLocationVO> mdmLocationVOs
	 * @throws DAOException
	 */
	public void modifyTPRTargetPort(List<MdmLocationVO> mdmLocationVOs)	throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (mdmLocationVOs.size() > 0) {
				insCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOMdmLocationVOCSQL(),
								mdmLocationVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
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
	 * RHQ List 목록을 가져온다.<br>
	 * @param MdmLocationVO mdmLocationVO
	 * @return List<mdmLocationVO>
	 * @throws DAOException
	 */
	public List<MdmLocationVO> searchRHQOfficeList(MdmLocationVO mdmLocationVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmLocationVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			velParam.put("methodname", "searchRHQOfficeList");
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OperationNPerformMasterDataMgtDBDAOOpfRHQOfficeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmLocationVO.class);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return list;
		
	}

	// VOP_OPF_0068 End
	// ==========================================================================//
	
	// VOP_OPF_0067 Start ========================================================================//
	/**
	 * TPR Target Lane Creation 을 조회 합니다. <br>
	 * 
	 * @param MdmVslSvcLaneVO mdmVslSvcLaneVO
	 * @return List<MdmVslSvcLaneVO>
	 * @throws DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmVslSvcLaneVO> searchTPRTargetLaneList(MdmVslSvcLaneVO mdmVslSvcLaneVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmVslSvcLaneVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmVslSvcLaneVO != null){
				Map<String, String> mapVO = mdmVslSvcLaneVO .getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new OperationNPerformMasterDataMgtDBDAOMdmVslSvcLaneVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmVslSvcLaneVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
	 
	/**
	 *  TPR Target Lane를 수정 합니다. <br>
	 * 
	 * @param List<MdmVslSvcLaneVO> mdmVslSvcLaneVOs
	 * @throws DAOException
	 */
	public void modifymanageTPRTargetLaneListS(List<MdmVslSvcLaneVO> mdmVslSvcLaneVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mdmVslSvcLaneVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new OperationNPerformMasterDataMgtDBDAOMdmVslSvcLaneVOUSQL(), mdmVslSvcLaneVOs,null);
				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
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
	// VOP_OPF_0067 End ==========================================================================//
	
	
	// VOP_OPF_9003 Start ========================================================================//
	/**
	 * COD Diversion Fee Cdoe을 조회 합니다. <br>
	 * 
	 * @param OpfCodDvsFeeVO opfCodDvsFeeVO
	 * @return List<OpfCodRjctCdVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpfCodDvsFeeVO> searchCODDiversionCodeList(OpfCodDvsFeeVO opfCodDvsFeeVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<OpfCodDvsFeeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (opfCodDvsFeeVO != null) {
				Map<String, String> mapVO = opfCodDvsFeeVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfCodDvsFeeVORSQL(),
							param, velParam);
			list = (List) RowSetUtil
					.rowSetToVOs(dbRowset, OpfCodDvsFeeVO.class);
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
	 * MDM_CONTINENT TABLE의 Conti Cd 의존재 여부를 조회 합니다. <br>
	 * 
	 * @param OpfCodDvsFeeVO opfCodDvsFeeVO
	 * @return List<OpfCodDvsFeeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public String searchContiCdUseYn(OpfCodDvsFeeVO opfCodDvsFeeVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		String result = "0";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (opfCodDvsFeeVO != null) {
				Map<String, String> mapVO = opfCodDvsFeeVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOSearchContiCdUseYnRSQL(),
							param, velParam);
			
			if(dbRowset.next()) {
				result = dbRowset.getString(1);
			}
			
//			list = (List) RowSetUtil
//					.rowSetToVOs(dbRowset, OpfCodDvsFeeVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}
	
	/**
	 * COD Diversion Fee Cdoe duplicate information is searched. <br>
	 * 
	 * @param OpfCodDvsFeeVO opfCodDvsFeeVO
	 * @return List<OpfCodDvsFeeVO>
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<OpfCodDvsFeeVO> searchCODDiversionCode(OpfCodDvsFeeVO opfCodDvsFeeVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<OpfCodDvsFeeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (opfCodDvsFeeVO != null) {
				Map<String, String> mapVO = opfCodDvsFeeVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("")
					.executeQuery(
							(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOCODDiversionCodeRSQL(),
							param, velParam);
			list = (List) RowSetUtil
					.rowSetToVOs(dbRowset, OpfCodDvsFeeVO.class);
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
	 * COD Diversion Fee Cdoe create <br>
	 * 
	 * @param List<OpfCodDvsFeeVO> opfCodDvsFeeVOs
	 * @throws DAOException
	 */
	public void addCODDiversionCode(List<OpfCodDvsFeeVO> opfCodDvsFeeVOs) throws DAOException,
			Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (opfCodDvsFeeVOs.size() > 0) {
				insCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfCodDvsFeeVOCSQL(),
								opfCodDvsFeeVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
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
	 * COD Diversion Fee Cdoe update <br>
	 * 
	 * @param List<OpfCodDvsFeeVO> opfCodDvsFeeVOs
	 * @throws DAOException
	 */
	
	public void modifyCODDiversionCode(List<OpfCodDvsFeeVO> opfCodDvsFeeVOs)	throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (opfCodDvsFeeVOs.size() > 0) {
				insCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfCodDvsFeeVOUSQL(),
								opfCodDvsFeeVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
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
	 * COD Diversion Fee Cdoe delete <br>
	 * 
	 * @param List<OpfCodDvsFeeVO> opfCodDvsFeeVOs
	 * @throws DAOException
	 */
	
	public void removeCODDiversionCode(List<OpfCodDvsFeeVO> opfCodDvsFeeVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (opfCodDvsFeeVOs.size() > 0) {
				delCnt = sqlExe.executeBatch( (ISQLTemplate) new OperationNPerformMasterDataMgtDBDAOOpfCodDvsFeeVODSQL(), opfCodDvsFeeVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
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
	

	// VOP_OPF_9003 End ==========================================================================//
}
