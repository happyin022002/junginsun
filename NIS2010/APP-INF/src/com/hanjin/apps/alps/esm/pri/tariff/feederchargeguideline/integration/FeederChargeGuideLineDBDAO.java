/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : FeederChargeGuideLineDBDAO.java
 *@FileTitle : Feeder Charge Guideline
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.5.08
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 2012.5.08 이은섭
 * 1.0 Creation
 * 2013.07.31 [CHM-201326002] 전윤주 DG Service flag가 'Y' 인 경우에만 버튼 색을 파란색으로 표시 
 *                           DG Service flag check 메서드 추가
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.basic.FeederChargeGuideLineBCImpl;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.ComboFdrRhqCdListVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRDGSurchargeVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.FDRProgVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.SearchFDRAmendmentHistoryDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.SearchFDRAmendmentHistoryMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.SearchTariffInquiryVO;
import com.hanjin.apps.alps.esm.pri.tariff.feederchargeguideline.vo.TariffInquiryListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriTrfFdrRtVO;

/**
 * NIS2010 FeederChargeGuideLineDBDAO <br>
 * - Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Eun-Sup Lee
 * @see FeederChargeGuideLineBCImpl 참조
 * @since J2EE 1.4
 */

public class FeederChargeGuideLineDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L;

	/**
	 *  ESM_PRI_7003_01, ESM_PRI_7003_02 : Feeder/IHC Tariff Inquiry
	 * 
	 * @param searchTariffInquiryVO
	 * @return List<TariffInquiryListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<TariffInquiryListVO> searchTariffInquiryList(SearchTariffInquiryVO searchTariffInquiryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TariffInquiryListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (searchTariffInquiryVO != null) {
 			Map<String, String> mapVO = searchTariffInquiryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			velParam.put("list_pnt_loc_cd", searchTariffInquiryVO.getPntLocCds());
		}
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FeederChargeGuideLineDBDAOSearchTariffInquiryListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TariffInquiryListVO.class);
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
	 *  ESM_PRI_7003_01, ESM_PRI_7003_02 : Feeder/IHC Tariff Inquiry  - 버튼 색 표시를 위한 조회
	 * 
	 * @param tariffInquiryListVO
	 * @return List<TariffInquiryListVO>
	 * @throws DAOException
	 */

	@SuppressWarnings("unchecked")
	public List<TariffInquiryListVO> searchTariffInquiryAddOnDgFlag(TariffInquiryListVO tariffInquiryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TariffInquiryListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (tariffInquiryListVO != null) {
 			Map<String, String> mapVO = tariffInquiryListVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);			
		}
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FeederChargeGuideLineDBDAOSearchTariffInquiryAddOnDgFlagRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TariffInquiryListVO.class);
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
	 * ESM_PRI_7011 : Retrieve form <br>
	 * Retrieve form data <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @return List<FDRMainVO>
	 * @exception DAOException
	 */
	public List<FDRMainVO> searchFDRMain(FDRMainVO fDRMainVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FDRMainVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FeederChargeGuideLineDBDAOSearchFDRMainRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, FDRMainVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * ESM_PRI_7011 : Retrieve sheet <br>
	 * Retrieve sheet data <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @return List<FDRDetailVO>
	 * @exception DAOException
	 */
	public List<FDRDetailVO> searchFDRDetail(FDRMainVO fDRMainVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FDRDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FeederChargeGuideLineDBDAOSearchFDRDetailRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, FDRDetailVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * ESM_PRI_7011 : Save <br>
	 * update effective data PRI_TRF_FDR_MN table
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @exception DAOException
	 */
	public void modifyFDRMain(FDRMainVO fDRMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new FeederChargeGuideLineDBDAOModifyFDRMainUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Save <br>
	 * update effective data PRI_TRF_FDR_DUR table
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @exception DAOException
	 */
	public void modifyFDRTariffDuration(FDRMainVO fDRMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new FeederChargeGuideLineDBDAOModifyFDRTariffDurationUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Save <br>
	 * update PRI_TRF_FDR_RT Guideline(USD)
	 * 
	 * @param List<FDRDetailVO> updateSheetVoList
	 * @exception DAOException
	 */
	public void modifyFDRDetail(List<FDRDetailVO> updateSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (updateSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new FeederChargeGuideLineDBDAOModifyFDRDetailUSQL(), updateSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Save <br>
	 * Delete Dry Tariff
	 * 
	 * @param List<FDRDetailVO> deleteSheetVoList
	 * @exception DAOException
	 */
	public void removeFDRDetail(List<FDRDetailVO> deleteSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (deleteSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new FeederChargeGuideLineDBDAORemoveFDRDetailDSQL(), deleteSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Confirm <br>
	 * Confirm <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @exception DAOException
	 */
	public void modifyFDRMainConfirmCur(FDRMainVO fDRMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new FeederChargeGuideLineDBDAOModifyFDRMainConfirmCurUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Confirm <br>
	 * Confirm : add progress <br>
	 * 
	 * @param FDRProgVO fDRProgVO
	 * @exception DAOException
	 */
	public void addFDRMainProgress(FDRProgVO fDRProgVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = fDRProgVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new FeederChargeGuideLineDBDAOAddFDRMainProgressCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED)
				throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Confirm <br>
	 * update EXP_DT PRI_TRF_FDR_MN table
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @exception DAOException
	 */
	public void modifyFDRMainConfirmBef(FDRMainVO fDRMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new FeederChargeGuideLineDBDAOModifyFDRMainConfirmBefUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Confirm <br>
	 * update EXP_DT data PRI_TRF_RDR_DUR table
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @exception DAOException
	 */
	public void modifyFDRTariffDurationConfirm(FDRMainVO fDRMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new FeederChargeGuideLineDBDAOModifyFDRTariffDurationConfirmUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Confirm <br>
	 * update EXP_DT data PRI_TRF_FDR_MN table
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @exception DAOException
	 */
	public void modifyFDRMainConfirmBefTrf(FDRMainVO fDRMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new FeederChargeGuideLineDBDAOModifyFDRMainConfirmBefTrfUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Cancel <br>
	 * Cancel : PRI_TRF_FDR_MN <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @exception DAOException
	 */
	public void removeFDRMain(FDRMainVO fDRMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new FeederChargeGuideLineDBDAORemoveFDRMainDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Cancel <br>
	 * Cancel : PRI_TRF_FDR_DUR <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @exception DAOException
	 */
	public void removeFDRTariffDuration(FDRMainVO fDRMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new FeederChargeGuideLineDBDAORemoveFDRTariffDurationDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Cancel <br>
	 * Cancel : PRI_TRF_FDR_PROG <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @exception DAOException
	 */
	public void removeFDRProgress(FDRMainVO fDRMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new FeederChargeGuideLineDBDAORemoveFDRProgressDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Cancel <br>
	 * Cancel : PRI_TRF_FDR_HDR <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @exception DAOException
	 */
	public void removeFDRHeader(FDRMainVO fDRMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new FeederChargeGuideLineDBDAORemoveFDRHeaderDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Cancel <br>
	 * Cancel : PRI_TRF_FDR_HDR <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @exception DAOException
	 */
	public void removeFDRCostVerMapg(FDRMainVO fDRMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new FeederChargeGuideLineDBDAORemoveFDRCostVerMapgDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Cancel <br>
	 * Cancel : PRI_TRF_FDR_RT <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @exception DAOException
	 */
	public void removeFDRDetailAll(FDRMainVO fDRMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new FeederChargeGuideLineDBDAORemoveFDRDetailAllDSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Cancel <br>
	 * Cancel : PRI_TRF_FDR_MN modify EXP_DT and setting CFM_DT, CFM_USR_ID, CFM_OFC_CD = null <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @exception DAOException
	 */
	public void modifyFDRMainCancel(FDRMainVO fDRMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new FeederChargeGuideLineDBDAOModifyFDRMainCancelUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Amend <br>
	 * Amend : PRI_TRF_FDR_MN <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @exception DAOException
	 */
	public void addFDRMainAmend(FDRMainVO fDRMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new FeederChargeGuideLineDBDAOAddFDRMainAmendCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Amend <br>
	 * Amend : PRI_TRF_FDR_RT <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @exception DAOException
	 */
	public void addFDRDetailAmend(FDRMainVO fDRMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new FeederChargeGuideLineDBDAOAddFDRDetailAmendCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Amend <br>
	 * Amend : PRI_TRF_FDR_DUR <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @exception DAOException
	 */
	public void addFDRTariffDurationAmend(FDRMainVO fDRMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new FeederChargeGuideLineDBDAOAddFDRTariffDurationAmendCSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7011 : Confirm <br>
	 * Retrieve pre version eff_dt <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @return List<FDRMainVO>
	 * @exception DAOException
	 */
	public List<FDRMainVO> checkPreFDR(FDRMainVO fDRMainVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FDRMainVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FeederChargeGuideLineDBDAOCheckPreFDRRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, FDRMainVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * ESM_PRI_7011 : Amend <br>
	 * Retrieve MAX COST_TRF_NO <br>
	 * 
	 * @param FDRMainVO fDRMainVO
	 * @return List<FDRMainVO>
	 * @exception DAOException
	 */
	public List<FDRMainVO> checkMaxCostTrfNoFDR(FDRMainVO fDRMainVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<FDRMainVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (fDRMainVO != null) {
				Map<String, String> mapVO = fDRMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FeederChargeGuideLineDBDAOCheckMaxCostTrfNoFDRRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, FDRMainVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

	/**
	 * ESM_PRI_7013 : PRI_TRF_FDR_RT ==> INSERT / UPDATE
	 * 
	 * @param fdrDetailVO
	 * @param pntLocCds
	 * @param bsePortLocCds
	 * @param rcvDeTermCds
	 * @throws DAOException
	 */
	public void uploadAddonCreation(PriTrfFdrRtVO priTrfFdrRtVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (priTrfFdrRtVO != null) {
				Map<String, String> mapVO = priTrfFdrRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new FeederChargeGuideLineDBDAOUploadAddonCreationUSQL(), param, velParam);
			if (result == Statement.EXECUTE_FAILED) {
				throw new DAOException("Fail to update SQL");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7013 : EUR Add-on Guideline Creation / Amend – Load Excel <br>
	 * CHECK 버튼
	 * 
	 * @param String locCd
	 * @param String svcScpCd
	 * @param String orgDestTpCd
	 * @return boolean
	 * @throws DAOException
	 */
	public boolean checkLocList(String locCd, String svcScpCd, String orgDestTpCd) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			param.put("loc_cd", locCd);
			velParam.put("loc_cd", locCd);
			param.put("svc_scp_cd", svcScpCd);
			velParam.put("svc_scp_cd", svcScpCd);
			param.put("org_dest_tp_cd", orgDestTpCd);
			velParam.put("org_dest_tp_cd", orgDestTpCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FeederChargeGuideLineDBDAOCheckLocListRSQL(), param, velParam);
			return dbRowset.next();
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7013 : EUR Add-on Guideline Creation / Amend – Load Excel <br>
	 * 저장전 Feeder Status 조회
	 * 
	 * @param fdrDetailVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchFeederStatus(FDRDetailVO fdrDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rsltVal = "";
		try {
			Map<String, String> map = fdrDetailVO.getColumnValues();
			param.putAll(map);
			velParam.putAll(map);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FeederChargeGuideLineDBDAOSearchFeederStatusRSQL(), param, velParam);
			if (dbRowset.next()) {
				rsltVal = dbRowset.getString(1);
			}
			return rsltVal;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7013 : EUR Add-on Guideline Creation / Amend – Load Excel <br>
	 * 서비스 코드에 따른 RHQ_CD 조회
	 * 
	 * @param fdrDetailVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ComboFdrRhqCdListVO> comboFdrRhqCdList(FDRDetailVO fdrDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<ComboFdrRhqCdListVO> list = null;
		try {
			Map<String, String> map = fdrDetailVO.getColumnValues();
			param.putAll(map);
			velParam.putAll(map);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FeederChargeGuideLineDBDAOComboFdrRhqCdListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ComboFdrRhqCdListVO.class);
			return list;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * ESM_PRI_7013 : Feeder List 조회
	 * 
	 * @param fdrDetailVO
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<PriTrfFdrRtVO> searchFDRList(FDRDetailVO fdrDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<PriTrfFdrRtVO> list = null;
		try {
			Map<String, String> map = fdrDetailVO.getColumnValues();
			param.putAll(map);
			velParam.putAll(map);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FeederChargeGuideLineDBDAOSearchFDRListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriTrfFdrRtVO.class);
			return list;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * location 코드 존재 여부 체크
	 * 
	 * @param fdrDetailVO
	 * @return Int
	 * @throws DAOException
	 */
	public int checkLocCode(String locCd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int rsltVal = 0;
		try {
			Map<String, String> map = new HashMap<String, String>();
			map.put("loc_cd", locCd);
			param.putAll(map);
			velParam.putAll(map);
			DBRowSet dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FeederChargeGuideLineDBDAOCheckLocCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				rsltVal = dbRowset.getInt(1);
			}
			return rsltVal;
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	
	/**
	 * ESM_PRI_7026 : FDR Tariff Amendment History Main <br>
	 * Retrieve FDR Tariff Amendment History Main <br>
	 * 
	 * @param SearchFDRAmendmentHistoryMainVO searchFDRAmendmentHistoryMainVO
	 * @return List<SearchFDRAmendmentHistoryMainVO>
	 * @exception DAOException
	 */
	public List<SearchFDRAmendmentHistoryMainVO> searchFDRAmendmentHistoryMain(SearchFDRAmendmentHistoryMainVO searchFDRAmendmentHistoryMainVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchFDRAmendmentHistoryMainVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchFDRAmendmentHistoryMainVO != null) {
				Map<String, String> mapVO = searchFDRAmendmentHistoryMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FeederChargeGuideLineDBDAOSearchFDRAmendmentHistoryMainRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchFDRAmendmentHistoryMainVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * ESM_PRI_7026 : Add-on Tariff Amendment History Detail <br>
	 * Retrieve Add-on Tariff Amendment History detail <br>
	 * 
	 * @param SearchFDRAmendmentHistoryDetailVO searchFDRAmendmentHistoryDetailVO
	 * @return List<SearchFDRAmendmentHistoryDetailVO>
	 * @exception DAOException
	 */
	public List<SearchFDRAmendmentHistoryDetailVO> searchFDRAmendmentHistoryDetail(SearchFDRAmendmentHistoryDetailVO searchFDRAmendmentHistoryDetailVO)  throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchFDRAmendmentHistoryDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchFDRAmendmentHistoryDetailVO != null) {
				Map<String, String> mapVO = searchFDRAmendmentHistoryDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FeederChargeGuideLineDBDAOSearchFDRAmendmentHistoryDetailRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchFDRAmendmentHistoryDetailVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * ESM_PRI_7028 : Add-On Tariff Amendment DG Cargo Inquiry <br>
	 * Retrieve Add-On Tariff Amendment DG Cargo Inquiry <br>
	 * 
	 * @param FDRDGSurchargeVO fDRDGSurchargeVO
	 * @return List<FDRDGSurchargeVO>
	 * @exception DAOException
	 */
	public List<FDRDGSurchargeVO> searchFDRDGSurcharge(FDRDGSurchargeVO fDRDGSurchargeVO)  throws DAOException {
		DBRowSet dbRowset = null;
		List<FDRDGSurchargeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (fDRDGSurchargeVO != null) {
				Map<String, String> mapVO = fDRDGSurchargeVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new FeederChargeGuideLineDBDAOSearchFDRDGSurchargeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, FDRDGSurchargeVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * ESM_PRI_7011 : Save <br>
	 * add PRI_TRF_FDR_RT Guideline(USD)
	 * 
	 * @param List<FDRDetailVO> insertSheetVoList
	 * @exception DAOException
	 */
	public void addFDRDetail(List<FDRDetailVO> insertSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new FeederChargeGuideLineDBDAOInsertFDRGuidelineDetailCSQL(), insertSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

}
