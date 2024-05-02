/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ChassisMgsetOnOffhireDAO.java
 *@FileTitle : Chassis Specification Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.04.28
 *@LastModifier : 박의수
 *@LastVersion : 1.0
 * 2009.04.28 박의수
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBCImpl;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqPoolInfoINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqPoolInfoMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqSpecINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqSpecMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqTpSzINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEqTpSzMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEquipmentINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSEquipmentMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSFoundAutoMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSFoundLostINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSFoundLostMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSLostResultINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSLostResultMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterInfoINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterInfoMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSMasterMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOffHireINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOffHireMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnHireINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnHireMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnOffhireSummaryINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSOnOffhireSummaryMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSSpecINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSSpecMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSStatusInfoINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.CHSStatusInfoMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.ErpFaInterfaceINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.ErpFaInterfaceMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.FaErpListVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSAtdtHistoryMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqSpecINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqSpecMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqTpSzINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEqTpSzMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEquipmentINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSEquipmentMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSFoundLostINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSFoundLostMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSLostResultINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSLostResultMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOffHireINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOffHireMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnHireINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnHireMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnOffhireSummaryINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSOnOffhireSummaryMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSSpecINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSSpecMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSStatusInfoINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.vo.MGSStatusInfoMGTVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * OPUS ChassisMgsetOnOffhireDAO <br>
 * - OPUS-ChassisMgsetMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author Eui-su Park
 * @see ChassisMgsetOnOffhireBCImpl 참조
 * @since J2EE 1.4
 */
public class ChassisMgsetOnOffhireDBDAO extends DBDAOSupport {

	/**
	 * chassis 및 M.G.Set 장비의 Type Size List 를 조회한다. [EES_CGM_1001].<br>
	 *
	 * @param cHSEqTpSzINVO CHSEqTpSzINVO
	 * @return List<CHSEqTpSzMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CHSEqTpSzMGTVO> searchCHSEqTypeSizeListData(CHSEqTpSzINVO cHSEqTpSzINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSEqTpSzMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cHSEqTpSzINVO != null) {
				Map<String, String> mapVO = cHSEqTpSzINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchCHSEqTypeSizeListDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSEqTpSzMGTVO.class);
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
	 * chassis 및 M.G.Set 장비의 Type Size List 다건의 데이터를 일괄적으로 생성한다. [EES_CGM_1001].<br>
	 *
	 * @param cHSEqTpSzINVOs List<CHSEqTpSzINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void addCHSEqTypeSizeData(List<CHSEqTpSzINVO> cHSEqTpSzINVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSEqTpSzINVOs.size() > 0) {

				log.info("###############################################################");
				log.info("[DAO][addCHSEqTypeSizeData]: " + cHSEqTpSzINVOs.get(0).getCreUsrId());
				log.info("[DAO][addCHSEqTypeSizeData]: " + cHSEqTpSzINVOs.get(0).getUpdUsrId());

				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOaddCHSEqTypeSizeDataCSQL(), cHSEqTpSzINVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * chassis 및 M.G.Set 장비의 Type Size List 다건의 데이터를 일괄적으로 갱신한다. [EES_CGM_1001].<br>
	 *
	 * @param cHSEqTpSzINVOs List<CHSEqTpSzINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void modifyCHSEqTypeSizeData(List<CHSEqTpSzINVO> cHSEqTpSzINVOs)
			throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSEqTpSzINVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyCHSEqTypeSizeDataUSQL(), cHSEqTpSzINVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * chassis 및 M.G.Set 장비의 Type Size List 다건의 데이터를 일괄적으로 삭제한다. [EES_CGM_1001].<br>
	 *
	 * @param cHSEqTpSzINVOs List<CHSEqTpSzINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void removeCHSEqTypeSizeData(List<CHSEqTpSzINVO> cHSEqTpSzINVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (cHSEqTpSzINVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOremoveCHSEqTypeSizeDataDSQL(), cHSEqTpSzINVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * M.G.Set 장비의 Type Size List 를 조회한다. [EES_CGM_2083].<br>
	 *
	 * @param mGSEqTpSzINVO MGSEqTpSzINVO
	 * @return List<MGSEqTpSzMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MGSEqTpSzMGTVO> searchMGSEqTypeSizeListData(MGSEqTpSzINVO mGSEqTpSzINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSEqTpSzMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mGSEqTpSzINVO != null) {
				Map<String, String> mapVO = mGSEqTpSzINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchMGSEqTypeSizeDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSEqTpSzMGTVO.class);
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
	 * chassis 및 M.G.Set 장비의 Type Size를 가진 장비가 있는지(CGM_EQUIPMENT) 조회한다. [EES_CGM_1001].<br>
	 *
	 * @param cHSEqTpSzINVO CHSEqTpSzINVO
	 * @return List<CHSEqTpSzMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CHSEqTpSzMGTVO> searchCHSEqTypeSizeInEqChkData(CHSEqTpSzINVO cHSEqTpSzINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSEqTpSzMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cHSEqTpSzINVO != null) {
				Map<String, String> mapVO = cHSEqTpSzINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchCHSEqTypeSizeInEqChkDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSEqTpSzMGTVO.class);
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
	 * chassis 및 M.G.Set 장비의 Type Size를 가진 장비가 있는지(CGM_EQUIPMENT) 조회한다. [EES_CGM_2083].<br>
	 *
	 * @param mGSEqTpSzINVO MGSEqTpSzINVO
	 * @return List<MGSEqTpSzMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MGSEqTpSzMGTVO> searchMGSEqTypeSizeInEqChkData(MGSEqTpSzINVO mGSEqTpSzINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSEqTpSzMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mGSEqTpSzINVO != null) {
				Map<String, String> mapVO = mGSEqTpSzINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchMGSEqTypeSizeInEqChkDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSEqTpSzMGTVO.class);
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
	 * M.G.Set 장비의 Type Size 다건의 데이터를 일괄적으로 생성한다. [EES_CGM_2083].<br>
	 *
	 * @param mGSEqTpSzINVOs List<MGSEqTpSzINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void addMGSEqTypeSizeData(List<MGSEqTpSzINVO> mGSEqTpSzINVOs)throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSEqTpSzINVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOaddMGSEqTypeSizeDataCSQL(), mGSEqTpSzINVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * M.G.Set 장비의 Type Size 다건의 데이터를 일괄적으로 갱신한다. [EES_CGM_2083].<br>
	 *
	 * @param mGSEqTpSzINVOs List<MGSEqTpSzINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void modifyMGSEqTypeSizeData(List<MGSEqTpSzINVO> mGSEqTpSzINVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSEqTpSzINVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyMGSEqTypeSizeDataUSQL(), mGSEqTpSzINVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * M.G.Set 장비의 Type Size 다건의 데이터를 일괄적으로 삭제한다. [EES_CGM_2083].<br>
	 *
	 * @param mGSEqTpSzINVOs List<MGSEqTpSzINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void removeMGSEqTypeSizeData(List<MGSEqTpSzINVO> mGSEqTpSzINVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (mGSEqTpSzINVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOremoveMGSEqTypeSizeDataDSQL(), mGSEqTpSzINVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * chassis의 Eq spec 정보를 조회한다. [EES_CGM_1002].<br>
	 *
	 * @param cHSEqSpecINVO CHSEqSpecINVO
	 * @return List<CHSEqSpecMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CHSEqSpecMGTVO> searchCHSEqSpecData(CHSEqSpecINVO cHSEqSpecINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSEqSpecMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cHSEqSpecINVO != null) {
				Map<String, String> mapVO = cHSEqSpecINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchCHSEqSpecDataRSQL(), param, velParam);
			//log.debug("☆★☆ DBDAO _ dbRowset : " + dbRowset);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSEqSpecMGTVO.class);
			//log.debug("☆★☆ DBDAO _ list : " + list);
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
	 * 스펙(eq_spec_no)에 해당하는 장비(cgm_equipment)들을 불러온다. [EES_CGM_1002].<br>
	 *
	 * @param cHSEqSpecINVO CHSEqSpecINVO
	 * @return List<CHSEqSpecMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CHSEqSpecMGTVO> searchCHSEqInEqSpecData(CHSEqSpecINVO cHSEqSpecINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSEqSpecMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cHSEqSpecINVO != null) {
				Map<String, String> mapVO = cHSEqSpecINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchCHSEqInEqSpecDataRSQL(), param, velParam);
			//log.debug("☆★☆ DBDAO _ dbRowset : " + dbRowset);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSEqSpecMGTVO.class);
			//log.debug("☆★☆ DBDAO _ list : " + list);
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
	 * chassis의 Eq spec 다건의 데이터를 일괄적으로 생성한다. [EES_CGM_1002].<br>
	 *
	 * @param cHSEqSpecINVOs List<CHSEqSpecINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void addCHSEqSpecData(List<CHSEqSpecINVO> cHSEqSpecINVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSEqSpecINVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOaddCHSEqSpecDataCSQL(), cHSEqSpecINVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * chassis의 Eq spec 다건의 데이터를 일괄적으로 갱신한다. [EES_CGM_1002].<br>
	 *
	 * @param cHSEqSpecINVOs List<CHSEqSpecINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void modifyCHSEqSpecData(List<CHSEqSpecINVO> cHSEqSpecINVOs)
			throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSEqSpecINVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyCHSEqSpecDataUSQL(), cHSEqSpecINVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * chassis의 Eq spec 다건의 데이터를 일괄적으로 삭제한다. [EES_CGM_1002].<br>
	 *
	 * @param cHSEqSpecINVOs List<CHSEqSpecINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void removeCHSEqSpecData(List<CHSEqSpecINVO> cHSEqSpecINVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (cHSEqSpecINVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOremoveCHSEqSpecDataDSQL(), cHSEqSpecINVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * Chassis 및 M.G.Set 의 Master 정보를 가져온다..  [EES_CGM_1009] .<br>
	 *
	 * @param chsOffHireINVO CHSOffHireINVO
	 * @return List<CHSOffHireMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CHSOffHireMGTVO> searchCHSOffhireInfoData(CHSOffHireINVO chsOffHireINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSOffHireMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("searchCHSEqinfoData=================================="+chsOffHireINVO);
		try{
			if(chsOffHireINVO != null){
				Map<String, String> mapVO = chsOffHireINVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOsearchCHSOffhireInfoDataRSQL(), param, velParam);


				//log.debug("☆★☆ DBDAO _ dbRowset : " + dbRowset);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSOffHireMGTVO.class);
			}
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
	 * 장비번호별 상태코드 정보를  리턴한다.  [EES_CGM_1009] .<br>
	 *
	 * @param cHSOffHireMGTVO CHSOffHireMGTVO
	 * @return CHSOffHireMGTVO
	 * @exception SQLException
	 * @exception Exception
	 */
     public CHSOffHireMGTVO checkCHSVerifyOffhireStatusData(CHSOffHireMGTVO cHSOffHireMGTVO) throws DAOException {
		DBRowSet dbRowset = null;
		CHSOffHireMGTVO chsEquipmentMGTVO = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("checkCHSVerifyOffhireStatusData==================================");
		try{
			if(cHSOffHireMGTVO != null){
				Map<String, String> mapVO = cHSOffHireMGTVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOcheckCHSVerifyOffhireStatusDataRSQL(), param, velParam);
				if(dbRowset.next()){
					chsEquipmentMGTVO = new CHSOffHireMGTVO();
					chsEquipmentMGTVO.setVerify(dbRowset.getString("verify"));
				}

			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return chsEquipmentMGTVO;
	}

 	/**
 	 * Off-hire 정보를 Equiment 마스터 테이블에 업데이트 한다. [EES_CGM_1009] .<br>
 	 *
 	 * @param cHSOffHireMGTVOs List<CHSOffHireMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void modifyCHSOffhireEquipmentData(List<CHSOffHireMGTVO> cHSOffHireMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(cHSOffHireMGTVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOmodifyCHSOffhireEquipmentDataUSQL(), cHSOffHireMGTVOs,null);
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

 	/**
 	 * Off-hire 정보를 Equiment History 테이블에 Insert 한다. [EES_CGM_1009] .<br>
 	 *
 	 * @param cHSOffHireMGTVOs List<CHSOffHireMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void addCHSOffhireEquipmentHistoryData(List<CHSOffHireMGTVO> cHSOffHireMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(cHSOffHireMGTVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOaddCHSOffhireEquipmentHistoryDataCSQL(), cHSOffHireMGTVOs,null);
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

	/**
	 * Chassis 및 M.G.Set 의 Master 정보를 가져온다..  [EES_CGM_2011] .<br>
	 *
	 * @param mgsOffHireINVO MGSOffHireINVO
	 * @return List<MGSOffHireMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
     @SuppressWarnings("unchecked")
	public List<MGSOffHireMGTVO> searchMGSOffhireInfoData(MGSOffHireINVO mgsOffHireINVO) throws DAOException {
    	DBRowSet dbRowset = null;
    	List<MGSOffHireMGTVO> list = null;
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		//velocity parameter
 		Map<String, Object> velParam = new HashMap<String, Object>();
 		log.debug("searchCHSEqinfoData=================================="+mgsOffHireINVO);
 		try{
 			if(mgsOffHireINVO != null){
 				Map<String, String> mapVO = mgsOffHireINVO .getColumnValues();

 				param.putAll(mapVO);
 				velParam.putAll(mapVO);
 				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOsearchMGSOffhireInfoDataRSQL(), param, velParam);

 				list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSOffHireMGTVO.class);
 			}
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
 	 * 장비번호별 상태코드 정보를  리턴한다.  [EES_CGM_2011] .<br>
 	 *
 	 * @param mGSOffHireMGTVO MGSOffHireMGTVO
 	 * @return MGSOffHireMGTVO
 	 * @exception SQLException
	 * @exception Exception
 	 */
      public MGSOffHireMGTVO checkMGSVerifyOffhireStatusData(MGSOffHireMGTVO mGSOffHireMGTVO) throws DAOException {
 		DBRowSet dbRowset = null;
 		MGSOffHireMGTVO mgsEeqOffHireMGTVO = null;
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		//velocity parameter
 		Map<String, Object> velParam = new HashMap<String, Object>();
 		log.debug("checkCHSVerifyOffhireStatusData==================================");
 		try{
 			if(mGSOffHireMGTVO != null){
 				Map<String, String> mapVO = mGSOffHireMGTVO .getColumnValues();

 				param.putAll(mapVO);
 				velParam.putAll(mapVO);
 				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOcheckMGSVerifyOffhireStatusDataRSQL(), param, velParam);
 				if(dbRowset.next()){
 					mgsEeqOffHireMGTVO = new MGSOffHireMGTVO();
 					mgsEeqOffHireMGTVO.setVerify(dbRowset.getString("verify"));
 				}

 			}

 		}catch(SQLException se){
 			log.error(se.getMessage(),se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		}catch(Exception ex){
 			log.error(ex.getMessage(),ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 		return mgsEeqOffHireMGTVO;
 	}

   	/**
   	 * Off-hire 정보를 Equiment 마스터 테이블에 업데이트 한다. [EES_CGM_2011] .<br>
   	 *
   	 * @param mGSOffHireMGTVOs List<MGSOffHireMGTVO>
   	 * @exception SQLException
	 * @exception Exception
   	 */
  	public void modifyMGSOffhireEquipmentData(List<MGSOffHireMGTVO> mGSOffHireMGTVOs) throws DAOException,Exception {
  		try {
  			SQLExecuter sqlExe = new SQLExecuter("");
  			int updCnt[] = null;
  			if(mGSOffHireMGTVOs.size() > 0){
  				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOmodifyMGSOffhireEquipmentDataUSQL(), mGSOffHireMGTVOs,null);
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

 	/**
 	 * Off-hire 정보를 Equiment History 테이블에 Insert 한다. [EES_CGM_2011] .<br>
 	 *
 	 * @param mGSOffHireMGTVOs List<CHSOffHireMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void addMGSOffhireEquipmentHistoryData(List<MGSOffHireMGTVO> mGSOffHireMGTVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(mGSOffHireMGTVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOaddMGSOffhireEquipmentHistoryDataCSQL(), mGSOffHireMGTVOs,null);
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

	/**
	 * M.G.Set 장비의 Eq spec 정보를 조회한다. [EES_CGM_2001].<br>
	 *
	 * @param mGSEqSpecINVO MGSEqSpecINVO
	 * @return List<MGSEqSpecMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MGSEqSpecMGTVO> searchMGSEqSpecData(MGSEqSpecINVO mGSEqSpecINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSEqSpecMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mGSEqSpecINVO != null) {
				Map<String, String> mapVO = mGSEqSpecINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchMGSEqSpecDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSEqSpecMGTVO.class);
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
	 * M.G.Set 장비의 Eq spec 정보가 중복되는지 조회한다. [EES_CGM_2001].<br>
	 *
	 * @param mGSEqSpecINVO MGSEqSpecINVO
	 * @return List<MGSEqSpecMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MGSEqSpecMGTVO> searchMGSEqSpecDupData(MGSEqSpecINVO mGSEqSpecINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSEqSpecMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mGSEqSpecINVO != null) {
				Map<String, String> mapVO = mGSEqSpecINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchMGSEqSpecDupDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSEqSpecMGTVO.class);
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
	 * M.G.Set 장비의 Eq spec 다건의 데이터를 일괄적으로 생성한다. [EES_CGM_2001]. <br>
	 *
	 * @param mGSEqSpecINVOs List<MGSEqSpecINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void addMGSEqSpecData(List<MGSEqSpecINVO> mGSEqSpecINVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;

			if (mGSEqSpecINVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOaddMGSEqSpecDataCSQL(), mGSEqSpecINVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * M.G.Set 장비의 Eq spec 다건의 데이터를 일괄적으로 갱신한다. [EES_CGM_2001].<br>
	 *
	 * @param mGSEqSpecINVOs List<MGSEqSpecINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void modifyMGSEqSpecData(List<MGSEqSpecINVO> mGSEqSpecINVOs)
			throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSEqSpecINVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyMGSEqSpecDataUSQL(), mGSEqSpecINVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * M.G.Set 장비의 Eq spec 다건의 데이터를 일괄적으로 삭제한다. [EES_CGM_2001].<br>
	 *
	 * @param mGSEqSpecINVOs List<MGSEqSpecINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void removeMGSEqSpecData(List<MGSEqSpecINVO> mGSEqSpecINVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (mGSEqSpecINVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOremoveMGSEqSpecDataDSQL(), mGSEqSpecINVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 * Leased Chassis의 On-hire 또는 Off-hire 실적댓수 별 Summary 값을 조회한다. [EES_CGM_1010] .<br>
 	 *
 	 * @param chsOnOffhireSummaryINVO CHSOnOffhireSummaryINVO
 	 * @return List<CHSOnOffhireSummaryMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	@SuppressWarnings("unchecked")
	public List<CHSOnOffhireSummaryMGTVO> searchCHSOnOffhireData(CHSOnOffhireSummaryINVO chsOnOffhireSummaryINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSOnOffhireSummaryMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (chsOnOffhireSummaryINVO != null) {
				Map<String, String> mapVO = chsOnOffhireSummaryINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchCHSOnOffhireDataRSQL(), param, velParam);
			//log.debug("☆★☆ DBDAO _ dbRowset : " + dbRowset);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSOnOffhireSummaryMGTVO.class);
			//log.debug("☆★☆ DBDAO _ list : " + list);
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
 	 * Leased Chassis의 On-hire 또는 Off-hire 실적댓수 별 Detail 값을 조회한다. [EES_CGM_1010] .<br>
 	 *
 	 * @param cHSOnOffhireSummaryINVO CHSOnOffhireSummaryINVO
 	 * @return List<CHSOnOffhireSummaryMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	@SuppressWarnings("unchecked")
	public List<CHSOnOffhireSummaryMGTVO> searchCHSOnOffhireDetailData(CHSOnOffhireSummaryINVO cHSOnOffhireSummaryINVO) throws DAOException {
		log.debug("searchCHSEqOnOffhireDetailData ========================================================================");
		DBRowSet dbRowset = null;
		List<CHSOnOffhireSummaryMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        log.debug("searchCHSEqOnOffhireDetailData ========================================================================");
		try {
			if (cHSOnOffhireSummaryINVO != null) {
				Map<String, String> mapVO = cHSOnOffhireSummaryINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchCHSOnOffhireDetailDataRSQL(), param, velParam);
			//log.debug("☆★☆ DBDAO _ dbRowset : " + dbRowset);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSOnOffhireSummaryMGTVO.class);
			//log.debug("☆★☆ DBDAO _ list : " + list);
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
 	 *  Leased Chassis의 On-hire 또는 Off-hire 실적댓수 별 Summary 값을 조회한다. [EES_CGM_2012] .<br>
 	 *
 	 * @param mgsOnOffhireSummaryINVO MGSOnOffhireSummaryINVO
 	 * @return List<MGSOnOffhireSummaryMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	@SuppressWarnings("unchecked")
	public List<MGSOnOffhireSummaryMGTVO> searchMGSOnOffhireData(MGSOnOffhireSummaryINVO mgsOnOffhireSummaryINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSOnOffhireSummaryMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mgsOnOffhireSummaryINVO != null) {
				Map<String, String> mapVO = mgsOnOffhireSummaryINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchMGSOnOffhireDataRSQL(), param, velParam);
			//log.debug("☆★☆ DBDAO _ dbRowset : " + dbRowset);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSOnOffhireSummaryMGTVO.class);
			//log.debug("☆★☆ DBDAO _ list : " + list);
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
 	 * Leased Chassis의 On-hire 또는 Off-hire 실적댓수 별 Detail 값을 조회한다. [EES_CGM_2012] .<br>
 	 *
 	 * @param mgsOnOffhireSummaryINVO MGSOnOffhireSummaryINVO
 	 * @return List<MGSOnOffhireSummaryMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	@SuppressWarnings("unchecked")
	public List<MGSOnOffhireSummaryMGTVO> searchMGSOnOffhireDetailData(MGSOnOffhireSummaryINVO mgsOnOffhireSummaryINVO) throws DAOException {
		log.debug("searchCHSEqOnOffhireDetailData ========================================================================");
		DBRowSet dbRowset = null;
		List<MGSOnOffhireSummaryMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
        log.debug("searchCHSEqOnOffhireDetailData ========================================================================");
		try {
			if (mgsOnOffhireSummaryINVO != null) {
				Map<String, String> mapVO = mgsOnOffhireSummaryINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchMGSOnOffhireDetailDataRSQL(), param, velParam);
			//log.debug("☆★☆ DBDAO _ dbRowset : " + dbRowset);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSOnOffhireSummaryMGTVO.class);
			//log.debug("☆★☆ DBDAO _ list : " + list);
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
	 * Chassis 의 Registration 정보를 조회한다. [EES_CGM_1006].<br>
	 *
	 * @param cHSEquipmentINVO CHSEquipmentINVO
	 * @return List<CHSEquipmentMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CHSEquipmentMGTVO> searchCHSEquipmentData(CHSEquipmentINVO cHSEquipmentINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSEquipmentMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cHSEquipmentINVO != null) {
				Map<String, String> mapVO = cHSEquipmentINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchCHSEquipmentDataRSQL(), param, velParam);
			//log.debug("☆★☆ DBDAO _ dbRowset : " + dbRowset);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSEquipmentMGTVO.class);
			//log.debug("☆★☆ DBDAO _ list : " + list);
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
	 * 서버에 중복된 Alias No 존재 여부 조회. [EES_CGM_1006].<br>
	 *
	 * @param cHSEquipmentINVO CHSEquipmentINVO
	 * @return List<CHSEquipmentMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CHSEquipmentMGTVO> searchCHSAliasNoData(CHSEquipmentINVO cHSEquipmentINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSEquipmentMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cHSEquipmentINVO != null) {
				Map<String, String> mapVO = cHSEquipmentINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchCHSAliasNoDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSEquipmentMGTVO.class);
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
	 * Chassis 의 Registration 다건의 데이터를 일괄적으로 갱신한다. [EES_CGM_1006].<br>
	 *
	 * @param cHSEquipmentINVOs List<CHSEquipmentINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void modifyCHSEquipmentData(List<CHSEquipmentINVO> cHSEquipmentINVOs)
			throws DAOException, Exception {
		try {
			log.debug("*****************modifyCHSEquipmentDataDBDAO ");
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSEquipmentINVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyCHSEquipmentDataUSQL(), cHSEquipmentINVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * chassis Pool 을 조회. [EES_CGM_1007].<br>
	 *
	 * @param cHSEqPoolInfoINVO CHSEqPoolInfoINVO
	 * @return List<CHSEqPoolInfoMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CHSEqPoolInfoMGTVO> searchCHSEqiPoolListData(CHSEqPoolInfoINVO cHSEqPoolInfoINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSEqPoolInfoMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cHSEqPoolInfoINVO != null) {
				Map<String, String> mapVO = cHSEqPoolInfoINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchCHSEqPoolInfoDataRSQL(), param, velParam);
			//log.debug("☆★☆ DBDAO _ dbRowset : " + dbRowset);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSEqPoolInfoMGTVO.class);
			//log.debug("☆★☆ DBDAO _ list : " + list);
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
	 * chassis Pool 다건의 데이터를 일괄적으로 갱신한다. [EES_CGM_1007].<br>
	 *
	 * @param cHSEqPoolInfoINVOs List<CHSEqPoolInfoINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void modifyCHSEqPoolInfoData(List<CHSEqPoolInfoINVO> cHSEqPoolInfoINVOs)
			throws DAOException, Exception {
		try {
			log.debug("_________ DBDAO _________");
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSEqPoolInfoINVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyCHSEqPoolInfoDataUSQL(), cHSEqPoolInfoINVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 * Chassis 및 M.G.Set 의 Master 정보를 가져온다.. [EES_CGM_1017] .<br>
 	 *
 	 * @param chsEqFoundLostINVO CHSFoundLostINVO
 	 * @return List<CHSFoundLostMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	@SuppressWarnings("unchecked")
	public List<CHSFoundLostMGTVO> searchCHSinfoData(CHSFoundLostINVO chsEqFoundLostINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSFoundLostMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("searchCHSEqinfoData=================================="+chsEqFoundLostINVO);
		try{
			if(chsEqFoundLostINVO != null){
				Map<String, String> mapVO = chsEqFoundLostINVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOsearchCHSInfoDataRSQL(), param, velParam);

				list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSFoundLostMGTVO.class);

			}
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
 	 * Found 되었던 Chassis 및 M.G.Set 을 Lost 처리한다. [EES_CGM_1017] .<br>
 	 *
 	 * @param cHSFoundLostMGTVOs List<CHSFoundLostMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void modifyCHSLostData (List<CHSFoundLostMGTVO> cHSFoundLostMGTVOs)
			throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSFoundLostMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyCHSLostDataUSQL(), cHSFoundLostMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 * Chassis 의 History 테이블에 새로운 상태를 Insert 한다. [EES_CGM_1017] .<br>
 	 *
 	 * @param cHSFoundLostMGTVOs List<CHSFoundLostMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void addCHSLostHistoryData (List<CHSFoundLostMGTVO> cHSFoundLostMGTVOs)
			throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSFoundLostMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOaddCHSLostHistoryDataCSQL(), cHSFoundLostMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 * Lost되었던 Chassis 및 M.G.Set 을 Found 처리한다.. [EES_CGM_1017] .<br>
 	 *
 	 * @param cHSFoundLostMGTVOs List<CHSFoundLostMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void modifyCHSFoundData (List<CHSFoundLostMGTVO> cHSFoundLostMGTVOs)
			throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSFoundLostMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyCHSFoundDataUSQL(), cHSFoundLostMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 * Chassis 의 History 테이블에 새로운 상태를 Insert 한다... [EES_CGM_1017] .<br>
 	 *
 	 * @param cHSFoundLostMGTVOs List<CHSFoundLostMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void addCHSFoundHistoryData  (List<CHSFoundLostMGTVO> cHSFoundLostMGTVOs)
			throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSFoundLostMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOaddCHSFoundHistoryDataCSQL(), cHSFoundLostMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 * Chassis 및 M.G.Set 의 Master 정보를 가져온다.. [EES_CGM_2019] .<br>
 	 *
 	 * @param mgsEqFoundLostINVO MGSFoundLostINVO
 	 * @return List<MGSFoundLostMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	@SuppressWarnings("unchecked")
	public List<MGSFoundLostMGTVO> searchMGSinfoData(MGSFoundLostINVO mgsEqFoundLostINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSFoundLostMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("searchCHSEqinfoData=================================="+mgsEqFoundLostINVO);
		try{
			if(mgsEqFoundLostINVO != null){
				Map<String, String> mapVO = mgsEqFoundLostINVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				// 커리 수정 ================
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOsearchMGSInfoDataRSQL(), param, velParam);

				list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSFoundLostMGTVO.class);

			}
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
 	 * Found 되었던 Chassis 및 M.G.Set 을 Lost 처리한다. [EES_CGM_2019] .<br>
 	 *
 	 * @param mGSFoundLostMGTVOs List<MGSFoundLostMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void modifyMGSLostData (List<MGSFoundLostMGTVO> mGSFoundLostMGTVOs)
			throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSFoundLostMGTVOs.size() > 0) {
				// sql u
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyMGSLostDataUSQL(), mGSFoundLostMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 * Chassis 의 History 테이블에 새로운 상태를 Insert 한다. [EES_CGM_2019] .<br>
 	 *
 	 * @param mGSFoundLostMGTVOs List<CHSFoundLostMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void addMGSLostHistoryData (List<MGSFoundLostMGTVO> mGSFoundLostMGTVOs)
			throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSFoundLostMGTVOs.size() > 0) {
				// sql
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOaddMGSLostHistoryDataCSQL(), mGSFoundLostMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 * Lost되었던 Chassis 및 M.G.Set 을 Found 처리한다.. [EES_CGM_2019] .<br>
 	 *
 	 * @param mGSFoundLostMGTVOs List<MGSFoundLostMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void modifyMGSFoundData (List<MGSFoundLostMGTVO> mGSFoundLostMGTVOs)
			throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSFoundLostMGTVOs.size() > 0) {
				// sqk
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyMGSFoundDataUSQL(), mGSFoundLostMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 * Chassis 의 History 테이블에 새로운 상태를 Insert 한다... [EES_CGM_2019] .<br>
 	 *
 	 * @param mGSFoundLostMGTVOs List<CHSFoundLostMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void addMGSFoundHistoryData  (List<MGSFoundLostMGTVO> mGSFoundLostMGTVOs)
			throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSFoundLostMGTVOs.size() > 0) {
				// sql
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOaddMGSFoundHistoryDataCSQL(), mGSFoundLostMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * Chassis Eq Master 기본 정보를 조회. [EES_CGM_1003]. <br>
	 *
	 * @param cHSMasterInfoINVO CHSMasterInfoINVO
	 * @return List<CHSMasterInfoMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CHSMasterInfoMGTVO> searchCHSMasterInfoData(CHSMasterInfoINVO cHSMasterInfoINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSMasterInfoMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cHSMasterInfoINVO != null) {
				Map<String, String> mapVO = cHSMasterInfoINVO.getColumnValues();

				log.debug("DDDDDDDDDDDDDDDDDDDDDDDDD" + mapVO);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchCHSMasterInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSMasterInfoMGTVO.class);
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
 	 * 장비 Lost 내역 summary 를 조회한다. [EES_CGM_1019] .<br>
 	 *
 	 * @param chsLostResultINVO CHSLostResultINVO
 	 * @return List<CHSLostResultMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	@SuppressWarnings("unchecked")
	public List<CHSLostResultMGTVO> searchCHSLostResultData(CHSLostResultINVO chsLostResultINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSLostResultMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (chsLostResultINVO != null) {
				Map<String, String> mapVO = chsLostResultINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchCHSLostResultDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSLostResultMGTVO.class);
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
	 * M.G.Set Eq Master 기본 정보를 조회. [EES_CGM_2006].<br>
	 *
	 * @param mGSEquipmentINVO MGSEquipmentINVO
	 * @return List<MGSEquipmentMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MGSEquipmentMGTVO> searchMGSEquipmentData(MGSEquipmentINVO mGSEquipmentINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSEquipmentMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mGSEquipmentINVO != null) {
				Map<String, String> mapVO = mGSEquipmentINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchMGSEquipmentDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSEquipmentMGTVO.class);
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
	 * M.G.Set Eq Master At/Dt 정보를 조회. [EES_CGM_2006].<br>
	 *
	 * @param mGSEquipmentINVO MGSEquipmentINVO
	 * @return List<MGSAtdtHistoryMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MGSAtdtHistoryMGTVO> searchMGSAtdtHistoryData(MGSEquipmentINVO mGSEquipmentINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSAtdtHistoryMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mGSEquipmentINVO != null) {
				Map<String, String> mapVO = mGSEquipmentINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchMGSAtdtHistoryDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSAtdtHistoryMGTVO.class);
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
	 * CChassisMgsetOnOffhire의 MGSET에 ATTACH된 샤시를 조회. [EES_CGM_2006]. <br>
	 *
	 * @param mGSEquipmentINVO MGSEquipmentINVO
	 * @return List<MGSEquipmentMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MGSEquipmentMGTVO> searchMGSEquipmentAtChssData(MGSEquipmentINVO mGSEquipmentINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSEquipmentMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mGSEquipmentINVO != null) {
				Map<String, String> mapVO = mGSEquipmentINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchMGSEquipmentAtChssDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSEquipmentMGTVO.class);
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
	 * M.G.Set Eq Master 기본 정보 다건의 데이터를 일괄적으로 생성한다. [EES_CGM_2006].<br>
	 *
	 * @param mGSEquipmentINVOs List<MGSEquipmentINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void addMGSEquipmentData(List<MGSEquipmentINVO> mGSEquipmentINVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSEquipmentINVOs.size() > 0) {
/*
				log.info("###############################################################");
				log.info("[DAO][addMGSEquipmentData]: " + mGSEquipmentINVOs.get(0).getCreUsrId());
				log.info("[DAO][addMGSEquipmentData]: " + mGSEquipmentINVOs.get(0).getUpdUsrId());
*/
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOaddMGSEquipmentDataCSQL(), mGSEquipmentINVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
	 *  M.G.Set Eq Master 기본 정보 다건의 데이터를 일괄적으로 갱신한다. [EES_CGM_2006].<br>
	 *
	 * @param mGSEquipmentINVOs List<MGSEquipmentINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void modifyMGSEquipmentData(List<MGSEquipmentINVO> mGSEquipmentINVOs)
			throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSEquipmentINVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyMGSEquipmentDataUSQL(), mGSEquipmentINVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 * 장비 Lost 내역 summary 를 조회한다. [EES_CGM_2020] .<br>
 	 *
 	 * @param mGSLostResultINVO MGSLostResultINVO
 	 * @return List<MGSLostResultMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	@SuppressWarnings("unchecked")
	public List<MGSLostResultMGTVO> searchMGSLostResultData(MGSLostResultINVO mGSLostResultINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSLostResultMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mGSLostResultINVO != null) {
				Map<String, String> mapVO = mGSLostResultINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchMGSLostResultDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSLostResultMGTVO.class);
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
 	 * Equipment 별 장비 현황(status) History 를 조회한다. [EES_CGM_1016] .<br>
 	 *
 	 * @param chsStatusInfoINVO CHSStatusInfoINVO
 	 * @return List<CHSStatusInfoMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	@SuppressWarnings("unchecked")
	public List<CHSStatusInfoMGTVO> searchCHSStatusData(CHSStatusInfoINVO chsStatusInfoINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSStatusInfoMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("searchCHSEqinfoData=================================="+chsStatusInfoINVO);
		try{
			if(chsStatusInfoINVO != null){
				Map<String, String> mapVO = chsStatusInfoINVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchCHSStatusDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSStatusInfoMGTVO.class);
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
	 * Spec정보에 대한 Valiation Check를 수행. [EES_CGM_1005].<br>
	 *
	 * @param cHSSpecINVO CHSSpecINVO
	 * @return List<CHSSpecMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CHSSpecMGTVO> searchEqSpecChkData(CHSSpecINVO cHSSpecINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSSpecMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cHSSpecINVO != null) {
				Map<String, String> mapVO = cHSSpecINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchEqSpecChkDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSSpecMGTVO.class);
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
	 * chassis 및 M.G.Set 장비의 SerialNo FM-TO 중복 체크. [EES_CGM_1005].<br>
	 *
	 * @param cHSSpecINVO CHSSpecINVO
	 * @return List<CHSSpecMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CHSSpecMGTVO> searchEqSpecChkFmToData(CHSSpecINVO cHSSpecINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSSpecMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cHSSpecINVO != null) {
				Map<String, String> mapVO = cHSSpecINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchEqSpecChkFmToDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSSpecMGTVO.class);
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
	 * Eq spec 정보를 조회한다. [EES_CGM_1005].<br>
	 *
	 * @param cHSSpecINVO CHSSpecINVO
	 * @return List<CHSSpecMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CHSSpecMGTVO> searchCHSSpecData(CHSSpecINVO cHSSpecINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSSpecMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cHSSpecINVO != null) {
				Map<String, String> mapVO = cHSSpecINVO.getColumnValues();

				log.debug("CHSSpecINVO.getColumnValues() " + cHSSpecINVO.getAgmtIssOfcCd());
				log.debug("CHSSpecINVO.getColumnValues() " + cHSSpecINVO.getAgmtOfcCtyCd());

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchCHSOwnMasterDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSSpecMGTVO.class);
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
	 * Eq Own Master(LOT) 리스트를 조회. [EES_CGM_1005].<br>
	 *
	 * @param cHSSpecINVO CHSSpecINVO
	 * @return List<CHSSpecMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CHSSpecMGTVO> searchCHSOwnMasterListData(CHSSpecINVO cHSSpecINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSSpecMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cHSSpecINVO != null) {
				Map<String, String> mapVO = cHSSpecINVO.getColumnValues();

				log.info("[DAO][addCHSSpecData]: " + cHSSpecINVO.getAgmtIssOfcCd());
				log.info("[DAO][addCHSSpecData]: " + cHSSpecINVO.getAgmtOfcCtyCd());

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchCHSSpecDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSSpecMGTVO.class);
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
	 * Eq Own Master(LOT) 다건의 데이터를 일괄적으로 생성한다. [EES_CGM_1005].<br>
	 *
	 * @param cHSSpecINVOs List<CHSSpecINVO>
	 * @return boolean
	 * @exception SQLException
	 * @exception Exception
	 */
	public boolean addCHSOwnMasterData(List<CHSSpecINVO> cHSSpecINVOs) throws DAOException, Exception {
		boolean rtn = false;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSSpecINVOs.size() > 0) {

				log.info("########################################################");
				log.info("[DAO][addCHSSpecData]: " + cHSSpecINVOs.get(0).getAgmtOfcCtyCd());
				log.info("[DAO][addCHSSpecData]: " + cHSSpecINVOs.get(0).getAgmtIssOfcCd());

				// 마스타 테이블
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOaddCHSOwnMasterDataCSQL(), cHSSpecINVOs, null);

				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

	/**
	 * Own Master(Lot 정보) 생성시 해당 LOT 다건의 데이터를 일괄적으로 생성한다. [EES_CGM_1005].<br>
	 *
	 * @param cHSSpecINVOs List<CHSSpecINVO>
	 * @return boolean
	 * @exception SQLException
	 * @exception Exception
	 */
	public boolean addCHSOwnMasterLotData(List<CHSSpecINVO> cHSSpecINVOs) throws DAOException, Exception {
		boolean rtn = false;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSSpecINVOs.size() > 0) {

				//log.info("########################################################"+cHSSpecINVOs.size());
				log.info("[DAO][addCHSSpecData]: " + cHSSpecINVOs.get(0).getAgmtOfcCtyCd());
				log.info("[DAO][addCHSSpecData]: " + cHSSpecINVOs.get(0).getAgmtIssOfcCd());

				// 장비 디테일 테이블
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOaddCHSOwnMasterLotDataCSQL(), cHSSpecINVOs, null);

				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

	/**
	 * Own Master(Lot 정보) 생성시 해당 LOT 다건의 데이터를 일괄적으로 갱신한다. [EES_CGM_1005].<br>
	 *
	 * @param cHSSpecINVOs List<CHSSpecINVO>
	 * @return boolean
	 * @exception SQLException
	 * @exception Exception
	 */
	public boolean modifyCHSOwnMasterData(List<CHSSpecINVO> cHSSpecINVOs)
			throws DAOException, Exception {
		boolean rtn = false;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSSpecINVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyCHSOwnMasterDataUSQL(), cHSSpecINVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

	/**
	 * Own Master(Lot 정보) 생성시 해당 LOT 데이터를 갱신한다. [EES_CGM_1005].<br>
	 *
	 * @param cHSSpecINVOs List<CHSSpecINVO>
	 * @return boolean
	 * @exception SQLException
	 * @exception Exception
	 */
	public boolean modifyCHSOwnMasterLotData(List<CHSSpecINVO> cHSSpecINVOs)
			throws DAOException, Exception {
		boolean rtn = false;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSSpecINVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyCHSOwnMasterLotDataUSQL(), cHSSpecINVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

 	/**
 	 * Chassis Status 정보를 수정한다. [EES_CGM_1016] .<br>
 	 *
 	 * @param cHSStatusInfoMGTVOs List<CHSStatusInfoMGTVO>
 	 * @return boolean
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public boolean modifyCHSStatusData(List<CHSStatusInfoMGTVO> cHSStatusInfoMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSStatusInfoMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyCHSStatusDataUSQL(), cHSStatusInfoMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;	// 데이터가 존재함. (사용)
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

 	/**
 	 * Chassis Status 정보를 수정한다. [EES_CGM_1016] .<br>
 	 *
 	 * @param cHSStatusInfoMGTVOs List<CHSStatusInfoMGTVO>
 	 * @return boolean
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public boolean modifyCHSStatusHistoryData(List<CHSStatusInfoMGTVO> cHSStatusInfoMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSStatusInfoMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyCHSStatusHistoryDataUSQL(), cHSStatusInfoMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;	// 데이터가 존재함. (사용)
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

 	/**
 	 * Equipment 별 장비 현황(status) History 를 조회한다. [EES_CGM_2018] .<br>
 	 *
 	 * @param mgsStatusInfoINVO MGSStatusInfoINVO
 	 * @return List<MGSStatusInfoMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	@SuppressWarnings("unchecked")
	public List<MGSStatusInfoMGTVO> searchMGSStatusData(MGSStatusInfoINVO mgsStatusInfoINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSStatusInfoMGTVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("searchMGSStatusData=================================="+mgsStatusInfoINVO);
		try{
			if(mgsStatusInfoINVO != null){
				Map<String, String> mapVO = mgsStatusInfoINVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchMGSStatusDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSStatusInfoMGTVO.class);
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
 	 * Chassis Status 정보를 수정한다. [EES_CGM_2018] .<br>
 	 *
 	 * @param mGSStatusInfoMGTVOs List<MGSStatusInfoMGTVO>
 	 * @return boolean
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public boolean modifyMGSStatusData(List<MGSStatusInfoMGTVO> mGSStatusInfoMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSStatusInfoMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyMGSStatusDataUSQL(), mGSStatusInfoMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;	// 데이터가 존재함. (사용)
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

 	/**
 	 * Chassis Status History 정보를 수정한다. [EES_CGM_2018] .<br>
 	 *
 	 * @param mGSStatusInfoMGTVOs List<MGSStatusInfoMGTVO>
 	 * @return boolean
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public boolean modifyMGSStatusHistoryData(List<MGSStatusInfoMGTVO> mGSStatusInfoMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSStatusInfoMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyCHSStatusHistoryDataUSQL(), mGSStatusInfoMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;	// 데이터가 존재함. (사용)
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

 	/**
 	 * CGM_EQ_STS_HIS 테이블에서 History 정보 삭제  [EES_CGM_1016] .<br>
 	 *
 	 * @param cHSStatusInfoMGTVOs List<CHSStatusInfoMGTVO>
 	 * @return boolean
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public boolean removeCHSStatusHistoryData(List<CHSStatusInfoMGTVO> cHSStatusInfoMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (cHSStatusInfoMGTVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOremoveCHSStatusHistoryDataDSQL(), cHSStatusInfoMGTVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;	// 데이터가 존재함. (사용)
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

 	/**
 	 * CGM_EQUIPMENT 테이블 항목 Update  [EES_CGM_1016] .<br>
 	 *
 	 * @param cHSStatusInfoMGTVOs List<CHSStatusInfoMGTVO>
 	 * @return boolean
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public boolean removeCHSStatusMasterData(List<CHSStatusInfoMGTVO> cHSStatusInfoMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSStatusInfoMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOremoveCHSStatusMasterDataUSQL(), cHSStatusInfoMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;	// 데이터가 존재함. (사용)
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

 	/**
 	 * CGM_EQUIPMENT 테이블 항목 Update 처리 [EES_CGM_1016] .<br>
 	 *
 	 * @param cHSStatusInfoMGTVOs List<CHSStatusInfoMGTVO>
 	 * @return boolean
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public boolean removeCHSStatusMasterNotLsiData(List<CHSStatusInfoMGTVO> cHSStatusInfoMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSStatusInfoMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOremoveCHSStatusMasterNotLsiDataUSQL(), cHSStatusInfoMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;	// 데이터가 존재함. (사용)
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

 	/**
 	 * CGM_EQ_STS_HIS 테이블에서 History 정보 삭제  [EES_CGM_1016] .<br>
 	 *
 	 * @param cHSStatusInfoMGTVOs List<CHSStatusInfoMGTVO>
 	 * @return boolean
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public boolean removeCHSStatusMasterLsiData(List<CHSStatusInfoMGTVO> cHSStatusInfoMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSStatusInfoMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOremoveCHSStatusMasterLsiDataUSQL(), cHSStatusInfoMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;	// 데이터가 존재함. (사용)
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}



 	/**
 	 * C단 Term Change인 경우 - 삭제대상이 CGM_EQ_STS_HIS 테이블의 TERM_CNG_SEQ 가 있는경우 LSI, LSO 2개를 삭제처리한다.  [EES_CGM_1016] .<br>
 	 *
 	 * @param cHSStatusInfoMGTVOs List<CHSStatusInfoMGTVO>
 	 * @return boolean
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public boolean removeCHSStatusTermChangeHistoryData(List<CHSStatusInfoMGTVO> cHSStatusInfoMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (cHSStatusInfoMGTVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOremoveCHSStatusTermChangeHistoryDataDSQL(), cHSStatusInfoMGTVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;	// 데이터가 존재함. (사용)
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

 	/**
 	 * CGM_EQ_STS_HIS 테이블에서 History 정보 가져오기  [EES_CGM_1016] .<br>
 	 *
 	 * @param chsStatusInfoMGTVO CHSStatusInfoMGTVO
 	 * @return CHSStatusInfoMGTVO
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public CHSStatusInfoMGTVO searchCHSStatusHistoryData(CHSStatusInfoMGTVO chsStatusInfoMGTVO) throws DAOException {
		DBRowSet dbRowset = null;
		CHSStatusInfoMGTVO list = new CHSStatusInfoMGTVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("searchMGSStatusData=================================="+chsStatusInfoMGTVO);
		try{
			if(chsStatusInfoMGTVO != null){
				Map<String, String> mapVO = chsStatusInfoMGTVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOsearchCHSStatusHistoryDataRSQL(), param, velParam);

				if(dbRowset.next()){
					list = new CHSStatusInfoMGTVO();

					list.setTermCngSeq(dbRowset.getString("term_cng_seq"));
					list.setStsEvntDt(dbRowset.getString("sts_evnt_dt"));
				}
			}

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
 	 * CGM_EQ_STS_HIS 테이블에서 History 정보 가져오기  [EES_CGM_1016] .<br>
 	 *
 	 * @param chsStatusInfoMGTVO CHSStatusInfoMGTVO
 	 * @return CHSStatusInfoMGTVO
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public CHSStatusInfoMGTVO searchCHSStatusHistoryLsiData(CHSStatusInfoMGTVO chsStatusInfoMGTVO) throws DAOException {
		DBRowSet dbRowset = null;
		CHSStatusInfoMGTVO list = new CHSStatusInfoMGTVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("searchMGSStatusData=================================="+chsStatusInfoMGTVO);
		try{
			if(chsStatusInfoMGTVO != null){
				Map<String, String> mapVO = chsStatusInfoMGTVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOsearchCHSStatusHistoryLsiDataRSQL(), param, velParam);

				if(dbRowset.next()){
					list = new CHSStatusInfoMGTVO();

					list.setStsEvntYdCd(dbRowset.getString("sts_evnt_yd_cd"));
					list.setCrntLocCd(dbRowset.getString("sts_evnt_loc_cd"));
					list.setStsEvntOfcCd(dbRowset.getString("sts_evnt_ofc_cd"));
					list.setStsEvntDt(dbRowset.getString("sts_evnt_dt"));
					list.setAgmtOfcCtyCd(dbRowset.getString("agmt_ofc_cty_cd"));
					list.setAgmtSeq(dbRowset.getString("agmt_seq"));
					list.setAgmtVerNo(dbRowset.getString("agmt_ver_no"));
					list.setEqAsetStsCd(dbRowset.getString("eq_aset_sts_cd"));
				}
			}

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
 	 * CGM_EQ_STS_HIS 테이블에서 History 정보 가져오기  [EES_CGM_2018] .<br>
 	 *
 	 * @param mgsStatusInfoMGTVO MGSStatusInfoMGTVO
 	 * @return MGSStatusInfoMGTVO
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public MGSStatusInfoMGTVO searchMGSStatusHistoryData(MGSStatusInfoMGTVO mgsStatusInfoMGTVO) throws DAOException {
		DBRowSet dbRowset = null;
		MGSStatusInfoMGTVO list = new MGSStatusInfoMGTVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("searchMGSStatusData=================================="+mgsStatusInfoMGTVO);
		try{
			if(mgsStatusInfoMGTVO != null){
				Map<String, String> mapVO = mgsStatusInfoMGTVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOsearchMGSStatusHistoryDataRSQL(), param, velParam);

				if(dbRowset.next()){
					list = new MGSStatusInfoMGTVO();

					list.setTermCngSeq(dbRowset.getString("term_cng_seq"));
					list.setStsEvntDt(dbRowset.getString("sts_evnt_dt"));
				}
			}

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
 	 * CGM_EQ_STS_HIS 테이블에서 History 정보 삭제 [EES_CGM_2018] .<br>
 	 *
 	 * @param mGSStatusInfoMGTVOs List<MGSStatusInfoMGTVO>
 	 * @return boolean
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public boolean removeMGSStatusHistoryData(List<MGSStatusInfoMGTVO> mGSStatusInfoMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (mGSStatusInfoMGTVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOremoveMGSStatusHistoryDataDSQL(), mGSStatusInfoMGTVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;	// 데이터가 존재함. (사용)
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

 	/**
 	 * CGM_EQUIPMENT 테이블 항목 Update 처리 [EES_CGM_2018] .<br>
 	 *
 	 * @param mGSStatusInfoMGTVOs List<MGSStatusInfoMGTVO>
 	 * @return boolean
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public boolean removeMGSStatusMasterData(List<MGSStatusInfoMGTVO> mGSStatusInfoMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSStatusInfoMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOremoveMGSStatusMasterDataUSQL(), mGSStatusInfoMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;	// 데이터가 존재함. (사용)
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}



 	/**
 	 *  Term Change인 경우 - 삭제대상이 CGM_EQ_STS_HIS 테이블의 TERM_CNG_SEQ 가 있는경우 LSI, LSO 2개를 삭제처리한다. [EES_CGM_2018] .<br>
 	 *
 	 * @param mGSStatusInfoMGTVOs List<MGSStatusInfoMGTVO>
 	 * @return boolean
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public boolean removeMGSStatusTermChangeHistoryData(List<MGSStatusInfoMGTVO> mGSStatusInfoMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (mGSStatusInfoMGTVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOremoveMGSStatusTermChangeHistoryDataDSQL(), mGSStatusInfoMGTVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;	// 데이터가 존재함. (사용)
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

 	/**
 	 *  CGM_EQ_STS_HIS 테이블의 삭제대상 이전(Term Change인 경우 LSI,LSO 2개를 지운 이전) 상태 Agreement 정보를 가져와서  [EES_CGM_2018] .<br>
 	 *
 	 * @param mgsStatusInfoMGTVO MGSStatusInfoMGTVO
 	 * @return MGSStatusInfoMGTVO
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public MGSStatusInfoMGTVO searchMGSStatusHistoryLsiData(MGSStatusInfoMGTVO mgsStatusInfoMGTVO) throws DAOException {
		DBRowSet dbRowset = null;
		MGSStatusInfoMGTVO list = new MGSStatusInfoMGTVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		log.debug("searchMGSStatusData=================================="+mgsStatusInfoMGTVO);
		try{
			if(mgsStatusInfoMGTVO != null){
				Map<String, String> mapVO = mgsStatusInfoMGTVO .getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);

				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOsearchMGSStatusHistoryLsiDataRSQL(), param, velParam);

				if(dbRowset.next()){
					list = new MGSStatusInfoMGTVO();

					list.setStsEvntYdCd(dbRowset.getString("sts_evnt_yd_cd"));
					list.setCrntLocCd(dbRowset.getString("sts_evnt_loc_cd"));
					list.setStsEvntOfcCd(dbRowset.getString("sts_evnt_ofc_cd"));
					list.setStsEvntDt(dbRowset.getString("sts_evnt_dt"));
					list.setAgmtOfcCtyCd(dbRowset.getString("agmt_ofc_cty_cd"));
					list.setAgmtSeq(dbRowset.getString("agmt_seq"));
					list.setAgmtVerNo(dbRowset.getString("agmt_ver_no"));
					list.setEqAsetStsCd(dbRowset.getString("eq_aset_sts_cd"));
				}
			}

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
 	 *  삭제대상이 'LSI'인 경우 이전의 LSI가 있으면 이전 LSI의 정보를 가져와서 ONH_OFC_CD, ONH_DT, ONH_YD_CD Update 처리.  [EES_CGM_2018] .<br>
 	 *
 	 * @param mGSStatusInfoMGTVOs List<MGSStatusInfoMGTVO>
 	 * @return boolean
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public boolean removeMGSStatusMasterLsiData(List<MGSStatusInfoMGTVO> mGSStatusInfoMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSStatusInfoMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOremoveMGSStatusMasterLsiDataUSQL(), mGSStatusInfoMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;	// 데이터가 존재함. (사용)
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

 	/**
 	 *   CGM_EQUIPMENT 테이블 항목 Update 처리  [EES_CGM_2018] .<br>
 	 *
 	 * @param mGSStatusInfoMGTVOs List<MGSStatusInfoMGTVO>
 	 * @return boolean
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public boolean removeMGSStatusMasterNotLsiData(List<MGSStatusInfoMGTVO> mGSStatusInfoMGTVOs) throws DAOException, Exception {
		boolean rtn = false;

		//query parameter
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSStatusInfoMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOremoveMGSStatusMasterNotLsiDataUSQL(), mGSStatusInfoMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
				rtn = true;	// 데이터가 존재함. (사용)
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtn;
	}

	/**
	 * M.G.Set 장비의 Eq spec 중복 여부를 조회. [EES_CGM_2004].<br>
	 *
	 * @param mGSSpecINVO MGSSpecINVO
	 * @return List<MGSSpecMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MGSSpecMGTVO> searchMGSSpecChkData(MGSSpecINVO mGSSpecINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSSpecMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mGSSpecINVO != null) {
				Map<String, String> mapVO = mGSSpecINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchMGSChkDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSSpecMGTVO.class);
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
	 * M.G.Set 장비의 Eq Own Master(LOT) 리스트를 조회. [EES_CGM_2004].<br>
	 *
	 * @param mGSSpecINVO MGSSpecINVO
	 * @return List<MGSSpecMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MGSSpecMGTVO> searchMGSOwnMasterListData(MGSSpecINVO mGSSpecINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSSpecMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mGSSpecINVO != null) {
				Map<String, String> mapVO = mGSSpecINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchMGSOwnMasterDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSSpecMGTVO.class);
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
	 * M.G.Set 장비의 Eq Own Master(LOT) 조회. [EES_CGM_2004].<br>
	 *
	 * @param mGSSpecINVO MGSSpecINVO
	 * @return List<MGSSpecMGTVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	@SuppressWarnings("unchecked")
	public List<MGSSpecMGTVO> searchMGSSpecData(MGSSpecINVO mGSSpecINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSSpecMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mGSSpecINVO != null) {
				Map<String, String> mapVO = mGSSpecINVO.getColumnValues();

				log.info("[DAO][addMGSSpecData]: " + mGSSpecINVO.getAgmtIssOfcCd());
				log.info("[DAO][addMGSSpecData]: " + mGSSpecINVO.getAgmtOfcCtyCd());

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchMGSOwnMasterLotDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSSpecMGTVO.class);
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
	 * M.G.Set 장비의 Eq Own Master(LOT) 다건의 데이터를 일괄적으로 생성한다. [EES_CGM_2004].<br>
	 *
	 * @param mGSSpecINVOs List<MGSSpecINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void addMGSSpecOwnMasterData(List<MGSSpecINVO> mGSSpecINVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSSpecINVOs.size() > 0) {

				log.info("########################################################");
				log.info("[DAO][addMGSSpecData]: " + mGSSpecINVOs.get(0).getAgmtOfcCtyCd());
				log.info("[DAO][addMGSSpecData]: " + mGSSpecINVOs.get(0).getAgmtIssOfcCd());

				// 마스타 테이블
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOaddMGSOwnMasterDataCSQL(), mGSSpecINVOs, null);

				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * M.G.Set 장비의 Eq Own Master(LOT) 데이터를 생성한다. [EES_CGM_2004].<br>
	 *
	 * @param mGSSpecINVOs List<MGSSpecINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void addMGSSpecOwnMasterLotData(List<MGSSpecINVO> mGSSpecINVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSSpecINVOs.size() > 0) {

				//log.info("########################################################"+mGSSpecINVOs.size());
				log.info("[DAO][addMGSSpecData]: " + mGSSpecINVOs.get(0).getAgmtOfcCtyCd());
				log.info("[DAO][addMGSSpecData]: " + mGSSpecINVOs.get(0).getAgmtIssOfcCd());

				// 장비 디테일 테이블
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOaddMGSOwnMasterLotDataCSQL(), mGSSpecINVOs, null);

				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * M.G.Set 장비의 Eq Own Master(LOT) 다건의 데이터를 일괄적으로 갱신한다. [EES_CGM_2004].<br>
	 *
	 * @param mGSSpecINVOs List<MGSSpecINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void modifyMGSSpecOwnMasterData(List<MGSSpecINVO> mGSSpecINVOs)
			throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSSpecINVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyMGSMasterDataUSQL(), mGSSpecINVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * M.G.Set 장비의 Eq Own Master(LOT) 데이터를 갱신한다. [EES_CGM_2004].<br>
	 *
	 * @param mGSSpecINVOs List<MGSSpecINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void modifyMGSSpecOwnMasterLotData(List<MGSSpecINVO> mGSSpecINVOs)
			throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSSpecINVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyMGSMasterLotDataUSQL(), mGSSpecINVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 *  On-Hire 시킬 Chassis No가 유효한지 Eq Master 에서 기본정보 및 상태를 조회한다.  [EES_CGM_1008] .<br>
 	 *
 	 * @param cHSOnHireINVO CHSOnHireINVO
 	 * @return List<CHSOnHireMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	@SuppressWarnings("unchecked")
	public List<CHSOnHireMGTVO> searchCHSOnHireStatusChkData(CHSOnHireINVO cHSOnHireINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSOnHireMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cHSOnHireINVO != null) {
				Map<String, String> mapVO = cHSOnHireINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchCHSOnHireStatusChkDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSOnHireMGTVO.class);
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
 	 *  On-Hire 시 기존에 등록되어 있는 Chassis 의 chss_veh_id_no, chss_tit_no, chss_als_no 가 있는지 체크한다  [EES_CGM_1008] .<br>
 	 *
 	 * @param cHSOnHireINVO CHSOnHireINVO
 	 * @return List<CHSOnHireMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	@SuppressWarnings("unchecked")
	public List<CHSOnHireMGTVO> searchCHSOnHireDupChkData(CHSOnHireINVO cHSOnHireINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSOnHireMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			log.debug("####### searchCHSOnHireDupChkData #######");
			if (cHSOnHireINVO != null) {
				Map<String, String> mapVO = cHSOnHireINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchCHSOnHireDupChkDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSOnHireMGTVO.class);
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
 	 *  O(자가, 임대 장비 확인용  [EES_CGM_1008] .<br>
 	 *
 	 * @param cHSOnHireINVO CHSOnHireINVO
 	 * @return List<CHSOnHireMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	@SuppressWarnings("unchecked")
	public List<CHSOnHireMGTVO> searchCHSOwnLeaseChkData(CHSOnHireINVO cHSOnHireINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CHSOnHireMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			log.debug("####### searchCHSOwnLeaseChkData #######");
			if (cHSOnHireINVO != null) {
				Map<String, String> mapVO = cHSOnHireINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchCHSOwnLeaseChkDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSOnHireMGTVO.class);
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
 	 *  장비번호별 상태코드 정보를 저장하여 리턴한다. [EES_CGM_1008] .<br>
 	 *
 	 * @param cHSOnHireINVO CHSOnHireINVO
 	 * @return CHSOnHireMGTVO
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public CHSOnHireMGTVO checkVerifyOnhireCountData(CHSOnHireINVO cHSOnHireINVO) throws DAOException {
		DBRowSet dbRowset = null;
		CHSOnHireMGTVO cHSOnHireMGTVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (cHSOnHireINVO != null) {
				Map<String, String> mapVO = cHSOnHireINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOcheckCHSVerifyOnhireStatusDataRSQL(), param, velParam);
				if(dbRowset.next()){
					cHSOnHireMGTVO = new CHSOnHireMGTVO();
					cHSOnHireMGTVO.setVerify(dbRowset.getString("verify"));
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cHSOnHireMGTVO;
	}

	/**
 	 *  On-hire 정보를 Equiment History 테이블에 Insert 한다. [EES_CGM_1008] .<br>
 	 *
 	 * @param cHSOnHireMGTVOs List<CHSOnHireMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void addCHSOnhireHistoryData(List<CHSOnHireMGTVO> cHSOnHireMGTVOs) throws DAOException, Exception {
		try {
			log.debug("####### addCHSOnhireHistoryData           #######" +cHSOnHireMGTVOs.size());
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSOnHireMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOaddCHSOnhireHistoryDataCSQL(), cHSOnHireMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 *  장비 마스터 테이블 인서트. [EES_CGM_1008] .<br>
 	 *
 	 * @param cHSOnHireMGTVOs List<CHSOnHireMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void addCHSOnhireEquipmentOwnData(List<CHSOnHireMGTVO> cHSOnHireMGTVOs) throws DAOException, Exception {
		try {
			log.debug("####### modifyCHSOnHireDataDBDAO #######");
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSOnHireMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOaddCHSOnhireEquipmentOwnDataCSQL(), cHSOnHireMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 *  On-hire 정보를 Equiment 마스터 테이블에 업데이트 한다. [EES_CGM_1008] .<br>
 	 *
 	 * @param CHSOnHireMGTVOs List<CHSOnHireMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void modifyCHSOnhireEquipmentData(List<CHSOnHireMGTVO> CHSOnHireMGTVOs) throws DAOException, Exception {
		try {
			log.debug("####### modifyCHSOnHireDataDBDAO #######");
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (CHSOnHireMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyCHSOnhireEquipmentDataUSQL(), CHSOnHireMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 *  On-Hire 시킬 M.G.Set No가 유효한지 Eq Master 에서 기본정보 및 상태를 조회한다 [EES_CGM_2007] .<br>
 	 *
 	 * @param mGSOnHireINVO MGSOnHireINVO
 	 * @return List<MGSOnHireMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
     @SuppressWarnings("unchecked")
	public List<MGSOnHireMGTVO> searchMGSOnHireStatusChkData(MGSOnHireINVO mGSOnHireINVO) throws DAOException {
    	DBRowSet dbRowset = null;
    	List<MGSOnHireMGTVO> list = null;
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		//velocity parameter
 		Map<String, Object> velParam = new HashMap<String, Object>();
 		log.debug("####### searchMGSOnHireStatusChkData ####### " + mGSOnHireINVO);
 		try{
 			if(mGSOnHireINVO != null){
 				Map<String, String> mapVO = mGSOnHireINVO .getColumnValues();

 				param.putAll(mapVO);
 				velParam.putAll(mapVO);
 				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOsearchMGSOnHireStatusChkDataRSQL(), param, velParam);

 				list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSOnHireMGTVO.class);
 			}
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
  	 *  On-Hire 를 시킬 Model No. 를 바꾸면 해당하는 voltage, fuel capacity  조회한다 [EES_CGM_2007] .<br>
  	 *
  	 * @param mGSOnHireINVO MGSOnHireINVO
  	 * @return List<MGSOnHireMGTVO>
  	 * @exception SQLException
	 * @exception Exception
  	 */
      @SuppressWarnings("unchecked")
 	public List<MGSOnHireMGTVO> searchMGSOnHireEqSpecNoChkData(MGSOnHireINVO mGSOnHireINVO) throws DAOException {
    	DBRowSet dbRowset = null;
    	List<MGSOnHireMGTVO> list = null;
 		//query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		//velocity parameter
 		Map<String, Object> velParam = new HashMap<String, Object>();
 		log.debug("####### searchMGSOnHireEqSpecNoChkData ####### " + mGSOnHireINVO);
 		try{
 			if(mGSOnHireINVO != null){
 				Map<String, String> mapVO = mGSOnHireINVO .getColumnValues();

 				param.putAll(mapVO);
 				velParam.putAll(mapVO);
 				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOsearchMGSOnHireEqSpecNoChkDataRSQL(), param, velParam);

 				list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSOnHireMGTVO.class);
 			}
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
  	 * ERP FA I/F  의 event에 대한 특정 리스트 조회.  [EES_CGM_1146] .<br>
  	 *
  	 * @param erpFaInterfaceMGTVO ErpFaInterfaceMGTVO
  	 * @return List<ErpFaInterfaceMGTVO>
  	 * @exception SQLException
	 * @exception Exception
  	 */
 	@SuppressWarnings("unchecked")
 	public List<ErpFaInterfaceMGTVO> searchErpFaCandidateListData(ErpFaInterfaceMGTVO erpFaInterfaceMGTVO) throws DAOException {
 		DBRowSet dbRowset = null;
 		List<ErpFaInterfaceMGTVO> list = null;
 		// query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		// velocity parameter
 		Map<String, Object> velParam = new HashMap<String, Object>();

 		try {
 			log.debug("####### searchCHSOwnLeaseChkData #######");
// 			if (erpFaInterfaceMGTVO != null) {
 				Map<String, String> mapVO = erpFaInterfaceMGTVO.getColumnValues();

 				param.putAll(mapVO);
 				velParam.putAll(mapVO);
// 			}
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchErpFaCandidateListDataRSQL(), param, velParam);
 			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ErpFaInterfaceMGTVO.class);
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
  	 * ERP FA I/F  의 event에 대한 준비 데이터(FA_IF_GRP_SEQ_NO,EAI_IF_NO) 조회. [EES_CGM_1146][FNS026-0001][IF_CGM_002].<br>
  	 *
  	 * @param erpFaInterfaceINVO ErpFaInterfaceINVO
  	 * @return ErpFaInterfaceMGTVO
  	 * @exception SQLException
	 * @exception Exception
  	 */
 	@SuppressWarnings("unchecked")
 	public ErpFaInterfaceMGTVO searchErpFaCandidatePreData(ErpFaInterfaceINVO erpFaInterfaceINVO) throws DAOException {
 		DBRowSet dbRowset = null;
 		List<ErpFaInterfaceMGTVO> list = null;

 		// query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		// velocity parameter
 		Map<String, Object> velParam = new HashMap<String, Object>();

 		try {
 			log.debug("####### searchCHSOwnLeaseChkData #######");
// 			if (erpFaInterfaceMGTVO != null) {
 				Map<String, String> mapVO = erpFaInterfaceINVO.getColumnValues();

 				param.putAll(mapVO);
 				velParam.putAll(mapVO);
// 			}
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchErpFaCandidatePreDataRSQL(), param, velParam);
 			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ErpFaInterfaceMGTVO.class);

 			if(list.size() != 1)
 			{
 				throw new DAOException(new String("chungpa SearchErpFaCandidatePreData Exception(Size != 1) Occurred."));
 			}
 			return list.get(0);

 		} catch (SQLException se) {
 			log.error(se.getMessage(), se);
 			throw new DAOException(new ErrorHandler(se).getMessage());
 		} catch (Exception ex) {
 			log.error(ex.getMessage(), ex);
 			throw new DAOException(new ErrorHandler(ex).getMessage());
 		}
 	}

  	/**
  	 * ERP FA I/F  의 event에 대한 특정 리스트 다중 업데이트.  [EES_CGM_1146][FNS026-0001][IF_CGM_002] .<br>
  	 *
  	 * @param erpFaInterfaceINVOs List<ErpFaInterfaceINVO>
  	 * @return List<ErpFaInterfaceINVO>
  	 * @exception SQLException
	 * @exception Exception
  	 */
 	public List<ErpFaInterfaceINVO> modifyErpFaCandidateListData(List<ErpFaInterfaceINVO> erpFaInterfaceINVOs) throws DAOException {
		try {
			int updCnt = 0;
			if (erpFaInterfaceINVOs != null){
				if(erpFaInterfaceINVOs.size() > 0){
					for(int i = 0; i < erpFaInterfaceINVOs.size(); i++){
						updCnt = modifyErpFaCandidateListData(erpFaInterfaceINVOs.get(i));

						if(updCnt== Statement.EXECUTE_FAILED)
						{
							throw new DAOException("Fail to Update No"+ i + " SQL");
						}
					}
				}
			}
			return erpFaInterfaceINVOs;
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
 	}

  	/**
  	 * ERP FA I/F  의 event에 대한 특정 리스트 다중 업데이트 BATCH 버전.  [EES_CGM_1146][FNS026-0001][IF_CGM_002] .<br>
  	 *
  	 * @param erpFaInterfaceINVOs List<ErpFaInterfaceINVO>
  	 * @return List<ErpFaInterfaceINVO>
  	 * @exception SQLException
	 * @exception Exception
  	 */
 	public List<ErpFaInterfaceINVO> modifyErpFaCandidateListBatchData(List<ErpFaInterfaceINVO> erpFaInterfaceINVOs) throws DAOException {

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (erpFaInterfaceINVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyErpFaCandidateListDataUSQL(), erpFaInterfaceINVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}
			return erpFaInterfaceINVOs;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

 	}
  	/**
  	 * ERP FA I/F  의 EAI 연계를 위한 준비데이타를 조회한다.  [EES_CGM_1146][FNS026-0001][IF_CGM_002] .<br>
  	 *
  	 * @param erpFaInterfaceINVO ErpFaInterfaceINVO
  	 * @return List<FaCntrListVO>
  	 * @exception SQLException
	 * @exception Exception
  	 */
	@SuppressWarnings("unchecked")
	public List<FaErpListVO> searchErpToFaData(ErpFaInterfaceINVO erpFaInterfaceINVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<FaErpListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(erpFaInterfaceINVO != null){
				Map<String, String> mapVO = erpFaInterfaceINVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOsearchErpToFaDataRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FaErpListVO .class);

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
  	 * ERP FA I/F  의 event에 대한 특정 리스트 업데이트.  [EES_CGM_1146][FNS026-0001][IF_CGM_002] .<br>
  	 *
  	 * @param erpFaInterfaceINVO ErpFaInterfaceINVO
  	 * @return int
  	 * @exception SQLException
	 * @exception Exception
  	 */
	public int modifyErpFaCandidateListData(ErpFaInterfaceINVO erpFaInterfaceINVO) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		int result = 0;
		try {

			Map<String, String> mapVO = erpFaInterfaceINVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOmodifyErpFaCandidateListDataUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to Update SQL");
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return result;
	}

	/**
	 * ERP FA I/F  의 Fns0260001 Receive 데이터 업데이트.  [EES_CGM_1146][FNS026-R001][IF_CGM_003] .<br>
	 *
	 * @param faErpListVOs List<FaErpListVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void modifyErpReceiveFAData(List<FaErpListVO> faErpListVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if(faErpListVOs.size() > 0){
				updCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOmodifyErpFaReceiveDataUSQL(), faErpListVOs,null);

				for(int i = 0; i < updCnt.length; i++){
					if(updCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to Update No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
    }

	/**
 	 *  장비번호별 상태코드 정보를 저장하여 리턴한다. [EES_CGM_2007] .<br>
 	 *
 	 * @param mGSOnHireINVO MGSOnHireINVO
 	 * @return MGSOnHireMGTVO
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public MGSOnHireMGTVO checkMGSVerifyOnhireStatusData (MGSOnHireINVO mGSOnHireINVO) throws DAOException {
		DBRowSet dbRowset = null;
		MGSOnHireMGTVO mGSOnHireMGTVO = null;
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (mGSOnHireINVO != null) {
				Map<String, String> mapVO = mGSOnHireINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOcheckMGSVerifyOnhireStatusDataRSQL(), param, velParam);
				if(dbRowset.next()){
					mGSOnHireMGTVO = new MGSOnHireMGTVO();
					mGSOnHireMGTVO.setVerify(dbRowset.getString("verify"));
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return mGSOnHireMGTVO;
	}

	/**
 	 *  On-hire 정보를 Equiment History 테이블에 Insert 한다. [EES_CGM_2007] .<br>
 	 *
 	 * @param mGSOnHireMGTVOs List<MGSOnHireMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void addMGSOnhireHistoryData(List<MGSOnHireMGTVO> mGSOnHireMGTVOs) throws DAOException, Exception {
		try {
			log.debug("####### addCHSOnhireHistoryData           #######" +mGSOnHireMGTVOs.size());
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSOnHireMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOaddMGSOnhireHistoryDataCSQL(), mGSOnHireMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 *  On-hire 정보를 Equiment 마스터 테이블에 업데이트 한다. [EES_CGM_2007] .<br>
 	 *
 	 * @param mGSOnHireMGTVOs List<MGSOnHireMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void modifyMGSOnhireEquipmentData(List<MGSOnHireMGTVO> mGSOnHireMGTVOs) throws DAOException, Exception {
		try {
			log.debug("####### modifyCHSOnHireDataDBDAO #######");
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSOnHireMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyMGSOnhireEquipmentDataUSQL(), mGSOnHireMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 *  장비 마스터 테이블 인서트. [EES_CGM_2007] .<br>
 	 *
 	 * @param mGSOnHireMGTVOs List<MGSOnHireMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void addMGSOnhireEquipmentOwnData(List<MGSOnHireMGTVO> mGSOnHireMGTVOs) throws DAOException, Exception {
		try {
			log.debug("####### modifyCHSOnHireDataDBDAO #######");
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (mGSOnHireMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOaddMGSOnhireEquipmentOwnDataCSQL(), mGSOnHireMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 *  Leased 장비일 경우 장비존재 여부 체크. [EES_CGM_2007] .<br>
 	 *
 	 * @param mGSOnHireINVO MGSOnHireINVO
 	 * @return List<MGSOnHireMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	@SuppressWarnings("unchecked")
	public List<MGSOnHireMGTVO> searchMGSOwnLeaseChkData(MGSOnHireINVO mGSOnHireINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MGSOnHireMGTVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			log.debug("####### searchCHSOwnLeaseChkData #######");
			if (mGSOnHireINVO != null) {
				Map<String, String> mapVO = mGSOnHireINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchCHSOwnLeaseChkDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MGSOnHireMGTVO.class);
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
 	 *  Status가 'LST' 나 'TLL' 즉 손실된 장비에 해당하는 CHASSIS, 정보 조회  [EES_CGM_1018] .<br>
 	 *
 	 * @param cHSFoundAutoMGTVO CHSFoundAutoMGTVO
 	 * @return List<CHSFoundAutoMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
 	@SuppressWarnings("unchecked")
 	public List<CHSFoundAutoMGTVO> searchCHSFoundAutoData(CHSFoundAutoMGTVO cHSFoundAutoMGTVO) throws DAOException {
 		DBRowSet dbRowset = null;
 		List<CHSFoundAutoMGTVO> list = null;
 		// query parameter
 		Map<String, Object> param = new HashMap<String, Object>();
 		// velocity parameter
 		Map<String, Object> velParam = new HashMap<String, Object>();

 		try {
 			log.debug("####### searchCHSFoundAutoData #######");
// 			if (erpFaInterfaceMGTVO != null) {
 				Map<String, String> mapVO = cHSFoundAutoMGTVO.getColumnValues();

 				param.putAll(mapVO);
 				velParam.putAll(mapVO);
// 			}
 			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOsearchCHSFoundAutoDataRSQL(), param, velParam);
 			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CHSFoundAutoMGTVO.class);
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
 	 * Lost되었던 Chassis 및 M.G.Set 을 Found 처리한다. [EES_CGM_1018] .<br>
 	 *
 	 * @param cHSFoundAutoMGTVOs List<CHSFoundAutoMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void addCHSFoundAutoStatusHistoryData(List<CHSFoundAutoMGTVO> cHSFoundAutoMGTVOs) throws DAOException, Exception {
		try {
			log.debug("####### modifyCHSOnHireDataDBDAO #######");
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSFoundAutoMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOaddCHSFoundAutoStatusHistoryDataCSQL(), cHSFoundAutoMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 *  Lost되었던 Chassis 및 M.G.Set 을 Found 처리한다..  [EES_CGM_1018] .<br>
 	 *
 	 * @param cHSFoundAutoMGTVOs List<CHSFoundAutoMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void modifyCHSFoundAutoMasterData(List<CHSFoundAutoMGTVO> cHSFoundAutoMGTVOs) throws DAOException, Exception {
		try {
			log.debug("####### modifyCHSOnHireDataDBDAO #######");
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (cHSFoundAutoMGTVOs.size() > 0) {
				updCnt = sqlExe
						.executeBatch(
								(ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyCHSFoundAutoMasterDataUSQL(), cHSFoundAutoMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * 단건의 CGM_EQ_STS_HIST 데이터를 일괄적으로 생성한다. [EES_CGM_1026].<br>
	 *
	 * @param cHSTermStatusINVO CHSTermStatusINVO
	 * @exception SQLException
	 * @exception Exception
	 */
	public void addCHSTermChangeEqHistoryData(CHSTermStatusINVO cHSTermStatusINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(cHSTermStatusINVO != null){
				//query parameter
			    Map<String, String> param = cHSTermStatusINVO.getColumnValues();

			    int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOAddCHSTermChangeEqHistoryDataCSQL() , param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * 단건의 CGM_EQ_STS_HIST 데이터를 일괄적으로 수정한다. [EES_CGM_1026].<br>
	 *
	 * @param cHSTermStatusINVO CHSTermStatusINVO
	 * @exception SQLException
	 * @exception Exception
	 */
	public void modifyCHSTermChangeEqHistoryData(CHSTermStatusINVO cHSTermStatusINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(cHSTermStatusINVO != null){
				//query parameter
			    Map<String, String> param = cHSTermStatusINVO.getColumnValues();

			    int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOModifyCHSTermChangeEqHistoryDataUSQL() , param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * 다건의 CGM_EQUIPMENT 의 Agreement No 데이터를 일괄적으로 수정한다. [EES_CGM_1026].<br>
	 *
	 * @param cHSTermStatusINVOs List<CHSTermStatusINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void modifyCHSTermChangeEqMasterData(List<CHSTermStatusINVO> cHSTermStatusINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(cHSTermStatusINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOModifyCHSTermChangeEqMasterDataUSQL(), cHSTermStatusINVOs,null);
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
	 * CGM_EQ_STS_HIS. EQ_STS_SEQ 의 시퀀스를 생성한다. [EES_CGM_1026].<br>
	 *
 	 * @return String
 	 * @exception SQLException
	 * @exception Exception
	 */
	public String searchCHSEqHistorySeqData() throws DAOException,Exception {

		DBRowSet dbRowset = null;
		String seq = "0";

		try {
			// AgmtSeq Max 값을 구해온다.
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOSearchCHSEqHistorySeqDataRSQL(), null, null);

			if(dbRowset.next()){
				seq = dbRowset.getString("eq_sts_seq");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return seq;
	}

	/**
	 * 단건의 CGM_EQ_STS_HIST 데이터를 일괄적으로 생성한다. [EES_CGM_2026]. <br>
	 *
	 * @param mGSTermStatusINVO MGSTermStatusINVO
	 * @exception SQLException
	 * @exception Exception
	 */
	public void addMGSTermChangeEqHistoryData(MGSTermStatusINVO mGSTermStatusINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mGSTermStatusINVO != null){
				//query parameter
			    Map<String, String> param = mGSTermStatusINVO.getColumnValues();

			    int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOAddMGSTermChangeEqHistoryDataCSQL() , param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * 단건의 CGM_EQ_STS_HIST 데이터를 일괄적으로 수정한다. [EES_CGM_2026].<br>
	 *
	 * @param mGSTermStatusINVO MGSTermStatusINVO
	 * @exception SQLException
	 * @exception Exception
	 */
	public void modifyMGSTermChangeEqHistoryData(MGSTermStatusINVO mGSTermStatusINVO) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(mGSTermStatusINVO != null){
				//query parameter
			    Map<String, String> param = mGSTermStatusINVO.getColumnValues();

			    int result = sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOModifyMGSTermChangeEqHistoryDataUSQL() , param, null);
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to insert SQL");
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
	 * 다건의 CGM_EQUIPMENT 의 Agreement No 데이터를 일괄적으로 수정한다.[EES_CGM_2026].<br>
	 *
	 * @param mGSTermStatusINVOs List<MGSTermStatusINVO>
	 * @exception SQLException
	 * @exception Exception
	 */
	public void modifyMGSTermChangeEqMasterData(List<MGSTermStatusINVO> mGSTermStatusINVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if(mGSTermStatusINVOs.size() > 0){
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOModifyMGSTermChangeEqMasterDataUSQL(), mGSTermStatusINVOs,null);
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
	 * CGM_EQ_STS_HIS. EQ_STS_SEQ 의 시퀀스를 생성한다. [EES_CGM_2026].<br>
	 *
	 * @return String
	 * @exception SQLException
	 * @exception Exception
	 */
	public String searchMGSEqHistorySeqData() throws DAOException,Exception {

		DBRowSet dbRowset = null;
		String seq = "0";

		try {
			// AgmtSeq Max 값을 구해온다.
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOSearchMGSEqHistorySeqDataRSQL(), null, null);

			if(dbRowset.next()){
				seq = dbRowset.getString("eq_sts_seq");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return seq;
	}

	/**
	 *  Mnr 에서 받은 데이터대로 장비 Flaging 처리 . [MNR 호출].<br>
	 *
 	 * @param iFMnrFlagVOs List<IFMnrFlagVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void modifyMnrFlagData(List<IFMnrFlagVO> iFMnrFlagVOs) throws DAOException,Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if(iFMnrFlagVOs.size() > 0){
				log.debug("iFMnrFlags==="+iFMnrFlagVOs.get(0).getEqNo());
				sqlExe.executeBatch((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOModifyMnrFlagDataUSQL(), iFMnrFlagVOs,null);
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
	 *  MNR에서 해당 Chassis 나 M.G.Set 을 제각처리시 CGM Master 테이블에 제각처리(EQ_ASET_STS_CD = 'TLL') 정보를 Insert 한다 . [MNR 호출].<br>
	 *
 	 * @param cHSMasterMGTVO CHSMasterMGTVO
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void addMnrRetirementData(CHSMasterMGTVO cHSMasterMGTVO) throws DAOException,Exception {

		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		log.debug("removeCgmChssMvmtHisData==================================");
		try{
			if(cHSMasterMGTVO != null){
				Map<String, String> param = cHSMasterMGTVO .getColumnValues();

				sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOAddMnrRetirementDataCSQL(), param, null);
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
	 *  MNR에서 해당 Chassis 나 M.G.Set 을 제각처리시 CGM Status History 테이블에 제각처리  정보를 Insert 한다 . [MNR 호출].<br>
	 *
 	 * @param cHSMasterMGTVO CHSMasterMGTVO
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void modifyMnrRetirementData(CHSMasterMGTVO cHSMasterMGTVO) throws DAOException,Exception {

		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		log.debug("removeCgmChssMvmtHisData==================================");
		try{
			if(cHSMasterMGTVO != null){
				Map<String, String> param = cHSMasterMGTVO .getColumnValues();

				sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOModifyMnrRetirementDataUSQL(), param, null);
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
 	 *  Movement 에 의해 Eq Master 정보를 수정한다.개별 Chassis의 Master Data Update<br>
 	 *
 	 * @param cHSMasterMGTVO CHSMasterMGTVO
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void modifyCHSCgmEquipmentData(CHSMasterMGTVO cHSMasterMGTVO) throws DAOException, Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		log.debug("removeCgmChssMvmtHisData==================================");
		try{
			if(cHSMasterMGTVO != null){
				Map<String, String> param = cHSMasterMGTVO .getColumnValues();

				sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOModifyCHSCgmEquipmentUSQL(), param, null);
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Effective Date 를 체크한다.(Chassis) <br>
	 *
	 * @param chsTermStatusINVO CHSTermStatusINVO
	 * @return int
	 * @exception DAOException
	 */
	public CHSTermStatusINVO checkCHSTermChangeEffDateData(CHSTermStatusINVO chsTermStatusINVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		CHSTermStatusINVO chsTerm = new CHSTermStatusINVO();
		try{
				if(chsTermStatusINVO != null){
					Map<String, String> mapVO = chsTermStatusINVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOCheckCHSTermChangeEffDateDataRSQL(), param, velParam);

					if(dbRowset.next()){
						chsTerm.setVerify(dbRowset.getString("verify"));
						chsTerm.setAgmtEffDt(dbRowset.getString("agmt_eff_dt"));
						chsTerm.setAgmtExpDt(dbRowset.getString("agmt_exp_dt"));

					}
				}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return chsTerm;
	}

	/**
	 * Effective Date 를 체크한다.(Chassis) <br>
	 *
	 * @param chsTermStatusINVO CHSTermStatusINVO
	 * @return int
	 * @exception DAOException
	 */
	public int checkCHSTermChangeChgCreationData(CHSTermStatusINVO chsTermStatusINVO) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
				if(chsTermStatusINVO != null){
					Map<String, String> mapVO = chsTermStatusINVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOCheckCHSTermChangeChgCreationDataRSQL(), param, velParam);

					if(dbRowset.next()){
						cnt = dbRowset.getInt("cnt");
					}
				}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}

	/**
	 * Effective Date 를 체크한다.(M.G.Set) <br>
	 *
	 * @param mgsTermStatusINVO MGSTermStatusINVO
	 * @return int
	 * @exception DAOException
	 */
	public MGSTermStatusINVO checkMGSTermChangeEffDateData(MGSTermStatusINVO mgsTermStatusINVO) throws DAOException {
		DBRowSet dbRowset = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		MGSTermStatusINVO mgsTerm = new MGSTermStatusINVO();

		try{
				if(mgsTermStatusINVO != null){
					Map<String, String> mapVO = mgsTermStatusINVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOCheckMGSTermChangeEffDateDataRSQL(), param, velParam);

					if(dbRowset.next()){
						mgsTerm.setVerify(dbRowset.getString("verify"));
						mgsTerm.setAgmtEffDt(dbRowset.getString("agmt_eff_dt"));
						mgsTerm.setAgmtExpDt(dbRowset.getString("agmt_exp_dt"));

					}
				}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return mgsTerm;
	}

	/**
	 * Effective Date 를 체크한다.(M.G.Set) <br>
	 *
	 * @param mgsTermStatusINVO MGSTermStatusINVO
	 * @return int
	 * @exception DAOException
	 */
	public int checkMGSTermChangeChgCreationData(MGSTermStatusINVO mgsTermStatusINVO) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
				if(mgsTermStatusINVO != null){
					Map<String, String> mapVO = mgsTermStatusINVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOCheckMGSTermChangeChgCreationDataRSQL(), param, velParam);

					if(dbRowset.next()){
						cnt = dbRowset.getInt("cnt");
					}
				}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}

	/**
	 * Effective Date 를 체크한다.(Chassis) <br>
	 *
	 * @param chsTermStatusINVO CHSTermStatusINVO
	 * @return int
	 * @exception DAOException
	 */
	public int checkCHSTermChangeTypeSizeData(CHSTermStatusINVO chsTermStatusINVO) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
				if(chsTermStatusINVO != null){
					Map<String, String> mapVO = chsTermStatusINVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOCheckCHSTermChangeTypeSizeDataRSQL(), param, velParam);

					if(dbRowset.next()){
						cnt = dbRowset.getInt("cnt");
					}
				}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}

	/**
	 * Effective Date 를 체크한다.(M.G.Set) <br>
	 *
	 * @param mGSTermStatusINVO MGSTermStatusINVO
	 * @return int
	 * @exception DAOException
	 */
	public int checkMGSTermChangeTypeSizeData(MGSTermStatusINVO mGSTermStatusINVO) throws DAOException {
		DBRowSet dbRowset = null;
		int cnt = 0;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
				if(mGSTermStatusINVO != null){
					Map<String, String> mapVO = mGSTermStatusINVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);

					dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ChassisMgsetOnOffhireDBDAOCheckMGSTermChangeTypeSizeDataRSQL(), param, velParam);

					if(dbRowset.next()){
						cnt = dbRowset.getInt("cnt");
					}
				}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return cnt;
	}

	/**
 	 *  On-hire 정보를 Equiment 마스터 테이블에 업데이트 한다. [EES_CGM_1008] .<br>
 	 *
 	 * @param CHSOnHireMGTVOs List<CHSOnHireMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void modifyCGMEquipmentStatusData(List<CHSOnHireMGTVO> CHSOnHireMGTVOs) throws DAOException, Exception {
		try {
			log.debug("####### modifyCHSOnHireDataDBDAO #######");
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (CHSOnHireMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyCGMEquipmentStatusDataUSQL(), CHSOnHireMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 *  On-hire 정보를 Equiment 마스터 테이블에 업데이트 한다. [EES_CGM_2007] .<br>
 	 *
 	 * @param MGSOnHireMGTVOs List<MGSOnHireMGTVO>
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void modifyMGSEquipmentStatusData(List<MGSOnHireMGTVO> MGSOnHireMGTVOs) throws DAOException, Exception {
		try {
			log.debug("####### modifyCHSOnHireDataDBDAO #######");
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (MGSOnHireMGTVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyMGSEquipmentStatusDataUSQL(), MGSOnHireMGTVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED) throw new DAOException("Fail to insert No" + i + " SQL");
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
 	 *  Movement 에 의해 Eq Master 정보를 수정한다.개별 M.G.Set의 Master Data Update<br>
 	 *
 	 * @param cHSMasterMGTVO CHSMasterMGTVO
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void modifyCHSCgmEquipMgSetData(CHSMasterMGTVO cHSMasterMGTVO) throws DAOException, Exception {
		SQLExecuter sqlExe = new SQLExecuter("");

		try{
			if(cHSMasterMGTVO != null){
				Map<String, String> param = cHSMasterMGTVO .getColumnValues();
				sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOmodifyCHSCgmEquipMgSetUSQL(), param, null);
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
 	 *  Movement 에 의해 Eq Master 정보를 수정한다.개별 Mgset의 Master Data Update<br>
 	 *
 	 * @param cHSMasterMGTVO CHSMasterMGTVO
 	 * @exception SQLException
	 * @exception Exception
 	 */
	public void modifyMGSCgmEquipmentData(CHSMasterMGTVO cHSMasterMGTVO) throws DAOException, Exception {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		log.debug("removeCgmChssMvmtHisData==================================");
		try{
			if(cHSMasterMGTVO != null){
				Map<String, String> param = cHSMasterMGTVO .getColumnValues();

				sqlExe.executeUpdate((ISQLTemplate) new ChassisMgsetOnOffhireDBDAOModifyMGSCgmEquipmentUSQL(), param, null);
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
}
