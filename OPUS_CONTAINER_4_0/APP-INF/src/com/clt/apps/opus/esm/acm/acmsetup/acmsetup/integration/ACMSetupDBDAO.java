/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMSetupDBDAO.java
*@FileTitle : Charge Deduction User Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.14
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.14 김상수
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.acm.acmsetup.acmsetup.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esm.acm.acmsetup.acmsetup.basic.ACMSetupBCImpl;
import com.clt.apps.opus.esm.acm.acmsetup.acmsetup.vo.ChargeDdtSetVO;
import com.clt.apps.opus.esm.acm.acmsetup.acmsetup.vo.CntrTpSzGrpVO;
import com.clt.apps.opus.esm.acm.acmsetup.acmsetup.vo.FinanceOfficeInfoVO;
import com.clt.apps.opus.esm.acm.acmsetup.acmsetup.vo.CntrTpSelectVO;
import com.clt.apps.opus.esm.acm.acmsetup.acmsetup.vo.RevenueStrcSetVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;


/**
 * OPUS ACMSetupDBDAO <br>
 * - OPUS-ACMSetup system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Sang-Soo
 * @see ACMSetupBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class ACMSetupDBDAO extends DBDAOSupport {

	/**
	 * [ESM_ACM_0003]
	 * User Set List 목록을 조회<br>
	 *
	 * @return List<ChargeDdtSetVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChargeDdtSetVO> searchChargeDdtSet() throws DAOException {
		DBRowSet dbRowset = null;
		List<ChargeDdtSetVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSetupDBDAOSearchChargeDdtSetListRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeDdtSetVO.class);
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
	 * [ESM_ACM_0003]
	 * Rep.Charge 목록을 조회<br>
	 *
	 * @return List<ChargeDdtSetVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChargeDdtSetVO> searchRepCharge() throws DAOException {
		DBRowSet dbRowset = null;
		List<ChargeDdtSetVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSetupDBDAOSearchRepChargeListRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeDdtSetVO.class);
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
	 * [ESM_ACM_0003]
	 * Charge Code 목록을 조회<br>
	 *
	 * @return List<ChargeDdtSetVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChargeDdtSetVO> searchChargeCode() throws DAOException {
		DBRowSet dbRowset = null;
		List<ChargeDdtSetVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSetupDBDAOSearchChargeCodeListRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeDdtSetVO.class);
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
	 * [ESM_ACM_0003]
	 * Charge Deduction Group Name 단건을 조회 (Validation)<br>
	 *
	 * @param ChargeDdtSetVO chargeDdtSetVO
	 * @return List<ChargeDdtSetVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<ChargeDdtSetVO> getChargeDdtNmInfo(ChargeDdtSetVO chargeDdtSetVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ChargeDdtSetVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (chargeDdtSetVO != null) {
				Map<String, String> mapVO = chargeDdtSetVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSetupDBDAOGetChargeDdtNmInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ChargeDdtSetVO.class);
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
	 * [ESM_ACM_0003]
	 * Charge Code 목록을 일괄적으로 생성<br>
	 *
	 * @param List<ChargeDdtSetVO> chargeDdtSetVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addChargeDdtSet(List<ChargeDdtSetVO> chargeDdtSetVO) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (chargeDdtSetVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSetupDBDAOAddChargeDdtSetListCSQL(), chargeDdtSetVO, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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

	/**
	 * [ESM_ACM_0003]
	 * Charge Code 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<ChargeDdtSetVO> chargeDdtSetVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeChargeDdtSet(List<ChargeDdtSetVO> chargeDdtSetVO) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (chargeDdtSetVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSetupDBDAORemoveChargeDdtSetListDSQL(), chargeDdtSetVO, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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

	/**
	 * [ESM_ACM_0002]
	 * User Set List 목록을 조회<br>
	 *
	 * @return List<CntrTpSzGrpVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CntrTpSzGrpVO> searchCntrTpSzGrp() throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrTpSzGrpVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSetupDBDAOSearchCntrTpSzGrpListRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrTpSzGrpVO.class);
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
	 * [ESM_ACM_0002]
	 * Container TP/SZ Code 목록을 조회<br>
	 *
	 * @return List<CntrTpSzGrpVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CntrTpSzGrpVO> searchCntrTpSzList() throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrTpSzGrpVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSetupDBDAOSearchCntrTpSzListRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrTpSzGrpVO.class);
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
	 * [ESM_ACM_0002]
	 * Container TP/SZ Group Name 단건을 조회 (Validation)<br>
	 *
	 * @param CntrTpSzGrpVO cntrTpSzGrpVO
	 * @return List<CntrTpSzGrpVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CntrTpSzGrpVO> getCntrTpSzGrpNmInfo(CntrTpSzGrpVO cntrTpSzGrpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrTpSzGrpVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (cntrTpSzGrpVO != null) {
				Map<String, String> mapVO = cntrTpSzGrpVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSetupDBDAOGetCntrTpSzGrpNmInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrTpSzGrpVO.class);
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
	 * [ESM_ACM_0002]
	 * Container TP/SZ Code 목록을 일괄적으로 생성<br>
	 *
	 * @param List<CntrTpSzGrpVO> cntrTpSzGrpVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addCntrTpSzGrp(List<CntrTpSzGrpVO> cntrTpSzGrpVO) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (cntrTpSzGrpVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSetupDBDAOAddCntrTpSzGrpListCSQL(), cntrTpSzGrpVO, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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

	/**
	 * [ESM_ACM_0002]
	 * Container TP/SZ Code 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<CntrTpSzGrpVO> cntrTpSzGrpVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeCntrTpSzGrp(List<CntrTpSzGrpVO> cntrTpSzGrpVO) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (cntrTpSzGrpVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSetupDBDAORemoveCntrTpSzGrpListDSQL(), cntrTpSzGrpVO, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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

	/**
	 * [ESM_ACM_0004]
	 * Finance Office Info 목록을 조회<br>
	 *
	 * @param FinanceOfficeInfoVO financeOfficeInfoVO
	 * @return List<FinanceOfficeInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FinanceOfficeInfoVO> searchFinanceOfficeInfo(FinanceOfficeInfoVO financeOfficeInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FinanceOfficeInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (financeOfficeInfoVO != null) {
				Map<String, String> mapVO = financeOfficeInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSetupDBDAOSearchFinanceOfficeInfoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FinanceOfficeInfoVO.class);
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
	 * [ESM_ACM_0004]
	 * BKG_CHN_AGN에서 Sub-Office의 존재유무 확인 (Validation)<br>
	 *
	 * @param FinanceOfficeInfoVO financeOfficeInfoVO
	 * @return List<FinanceOfficeInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FinanceOfficeInfoVO> getBkgChnAgnInfo(FinanceOfficeInfoVO financeOfficeInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FinanceOfficeInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (financeOfficeInfoVO != null) {
				Map<String, String> mapVO = financeOfficeInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSetupDBDAOGetBkgChnAgnInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FinanceOfficeInfoVO.class);
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
	 * [ESM_ACM_0004]
	 * MDM_ORGANIZATION에서 Sub-Office의 존재유무 확인 (Validation)<br>
	 *
	 * @param FinanceOfficeInfoVO financeOfficeInfoVO
	 * @return List<FinanceOfficeInfoVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<FinanceOfficeInfoVO> getMdmOrganizationInfo(FinanceOfficeInfoVO financeOfficeInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FinanceOfficeInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (financeOfficeInfoVO != null) {
				Map<String, String> mapVO = financeOfficeInfoVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSetupDBDAOGetMdmOrganizationInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, FinanceOfficeInfoVO.class);
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
	 * [ESM_ACM_0004]
	 * ACM_OFC_INFO_TMP 테이블에서 AGN_FM_DT_CD, AGN_TO_DT_CD, AGN_FM_DT, AGN_TO_DT로 중복 체크<br>
	 *
	 * @param String ofcTmpNo
	 * @return String
	 * @exception DAOException
	 */
	public String getDupDataFromAcmOfcInfo(String ofcTmpNo) throws DAOException {
		DBRowSet dbRowset = null;
		String errOfcGrpId = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("ofc_tmp_no", ofcTmpNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSetupDBDAOGetDupDataFromAcmOfcInfoRSQL(), param, velParam);
			if(dbRowset.next()){
				errOfcGrpId = dbRowset.getString("ERR_OFC_INFO");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return errOfcGrpId;
	}

	/**
	 * [ESM_ACM_0004]
	 * ACM_OFC_INFO_TMP_SEQ 구하기<br>
	 *
	 * @return String
	 * @exception DAOException
	 */
	public String getAcmOfcInfoTmpSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String ofcInfoTmpSeq = null;

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSetupDBDAOGetAcmOfcInfoTmpSeqInfoRSQL(), null, null);
			if (dbRowset.next()) {
				ofcInfoTmpSeq = dbRowset.getString("ACM_OFC_INFO_TMP_SEQ");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return ofcInfoTmpSeq;
	}

	/**
	 * [ESM_ACM_0004]
	 * Finance Office Info 목록을 일괄적으로 생성(ACM_OFC_INFO_TMP 테이블)<br>
	 *
	 * @param List<FinanceOfficeInfoVO> financeOfficeInfoVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addFinanceOfficeInfoTemp(List<FinanceOfficeInfoVO> financeOfficeInfoVO) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (financeOfficeInfoVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSetupDBDAOAddFinanceOfficeInfoTempListCSQL(), financeOfficeInfoVO, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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

	/**
	 * [ESM_ACM_0004]
	 * Finance Office Info 목록을 일괄적으로 생성(ACM_OFC_INFO_TMP 테이블)<br>
	 *
	 * @param String ofcTmpNo
	 * @exception DAOException
	 * @exception Exception
	 */
	public void removeFinanceOfficeInfoTemp(String ofcTmpNo) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ofc_tmp_no", ofcTmpNo);
			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ACMSetupDBDAORemoveFinanceOfficeInfoTempListDSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to delete SQL");
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * [ESM_ACM_0004]
	 * Finance Office Info 목록을 생성<br>
	 *
	 * @param FinanceOfficeInfoVO financeOfficeInfoVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addFinanceOfficeInfo(FinanceOfficeInfoVO financeOfficeInfoVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = financeOfficeInfoVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ACMSetupDBDAOAddFinanceOfficeInfoListCSQL(), param, velParam);
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
	 * [ESM_ACM_0004]
	 * Finance Office Info 목록을 수정<br>
	 *
	 * @param FinanceOfficeInfoVO financeOfficeInfoVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void modifyFinanceOfficeInfo(FinanceOfficeInfoVO financeOfficeInfoVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = financeOfficeInfoVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ACMSetupDBDAOModifyFinanceOfficeInfoListUSQL(), param, velParam);
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
	 * [ESM_ACM_0004]
	 * Finance Office Info History 목록을 생성<br>
	 *
	 * @param FinanceOfficeInfoVO financeOfficeInfoVO
	 * @exception DAOException
	 * @exception Exception
	 */
	public void addFinanceOfficeInfoHistory(FinanceOfficeInfoVO financeOfficeInfoVO) throws DAOException, Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = financeOfficeInfoVO .getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate)new ACMSetupDBDAOAddFinanceOfficeInfoHistoryListCSQL(), param, velParam);
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
	 * [ESM_ACM_0004]
	 * AGN_INFO_SEQ MAX 값 구하기<br>
	 *
	 * @exception DAOException
	 */
	public String getAgnInfoSeq() throws DAOException {
		DBRowSet dbRowset = null;
		String agnInfoSeq = "";

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSetupDBDAOGetAgnInfoSeqInfoRSQL(), null, null);
			if(dbRowset.next()) {
				agnInfoSeq = dbRowset.getString(1);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return agnInfoSeq;
	}

	/**
	 * [ESM_ACM_0026]
	 * Revenue 인식 Charge Code 목록을 조회<br>
	 *
	 * @param RevenueStrcSetVO revenueStrcSetVO
	 * @return List<FinanceOfficeInfoVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<RevenueStrcSetVO> searchRevenueStrcSet(RevenueStrcSetVO revenueStrcSetVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RevenueStrcSetVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (revenueStrcSetVO != null) {
				Map<String, String> mapVO = revenueStrcSetVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSetupDBDAOSearchRevenueStrcSetListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueStrcSetVO.class);
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
	 * [ESM_ACM_0026]
	 * Revenue Structure Setup화면 수정, 저장 시 기존 데이터 중복 체크 조회<br>
	 *
	 * @param RevenueStrcSetVO revenueStrcSetVO
	 * @return List<FinanceOfficeInfoVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<RevenueStrcSetVO> searchRevenueStrcSetChk(RevenueStrcSetVO revenueStrcSetVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RevenueStrcSetVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (revenueStrcSetVO != null) {
				Map<String, String> mapVO = revenueStrcSetVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSetupDBDAOsearchRevenueStrcSetChkRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, RevenueStrcSetVO.class);
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
	 * [ESM_ACM_0026]
	 * Revenue 인식 Charge Code 목록을 일괄적으로 생성<br>
	 *
	 * @param List<RevenueStrcSetVO> revenueStrcSetVO
	 * @throws DAOException
	 * @throws Exception
	 */
	public void addRevenueStrcSet(List<RevenueStrcSetVO> revenueStrcSetVO) throws DAOException, Exception {
		int insCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (revenueStrcSetVO.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSetupDBDAOAddRevenueStrcSetListCSQL(), revenueStrcSetVO, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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

	/**
	 * [ESM_ACM_0026]
	 * Revenue 인식 Charge Code 목록을 일괄적으로 수정<br>
	 *
	 * @param List<RevenueStrcSetVO> revenueStrcSetVO
	 * @exception EventException
	 */
	public void modifyRevenueStrcSet(List<RevenueStrcSetVO> revenueStrcSetVO) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (revenueStrcSetVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSetupDBDAOModifyRevenueStrcSetListUSQL(), revenueStrcSetVO, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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

	/**
	 * [ESM_ACM_0026]
	 * Revenue Structure Setting 목록을 일괄적으로 삭제<br>
	 *
	 * @param List<RevenueStrcSetVO> revenueStrcSetVO
	 * @exception EventException
	 */
	public void removeRevenueStrcSet(List<RevenueStrcSetVO> revenueStrcSetVO) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (revenueStrcSetVO.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new ACMSetupDBDAORemoveRevenueStrcSetListDSQL(), revenueStrcSetVO, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
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

	/**
	 * [ESM_ACM_0104]
	 * Container Type Selection 목록을 조회<br>
	 *
	 * @param CntrTpSelectVO mdmCntrTpVO
	 * @return List<CntrTpSelectVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<CntrTpSelectVO> searchCntrTpSelect(CntrTpSelectVO mdmCntrTpVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CntrTpSelectVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(mdmCntrTpVO != null){
				Map<String, String> mapVO = mdmCntrTpVO .getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMSetupDBDAOSearchCntrTpSelectListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CntrTpSelectVO .class);
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}
}