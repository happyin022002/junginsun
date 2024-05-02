/*=========================================================
 *Copyright(c) 2012 CyberLogitec
 *@FileName : IHCGuideLineDBDAO.java
 *@FileTitle : IHC Guideline DBDAO
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.5.08
 *@LastModifier : 이은섭
 *@LastVersion : 1.0
 * 2012.5.08 이은섭
 * 1.0 Creation
 * 2013.07.26 전윤주 [CHM-201325898] Dry 일 경우 신규 Tariff 입력 시 40' AMT를 기준으로 Loc.Group을 할당해주는 로직 추가
 * 2013.08.01 전윤주 [CHM-201326002] DG Overweight Service flag가 'Y' 인 경우에만 버튼 색을 파란색으로 표시 
=========================================================*/

package com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.basic.IHCGuideLineBCImpl;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCGuidelineDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCGuidelineMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.IHCTariffInquiryListVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.PriTrfIHCRtVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchIHCAmendmentHistoryDetailVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchIHCAmendmentHistoryMainVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchIhcTariffInquiryVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchUsInlandServiceModeTotalVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SearchUsTariffInquiryListVO;
import com.hanjin.apps.alps.esm.pri.tariff.ihcguideline.vo.SpecialCargoPopupListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.PriTrfIhcProgVO;

/**
 * NIS2010 IHCGuideLineDBDAO <br>
 * - Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author Eun-Sup Lee
 * @see IHCGuideLineBCImpl 참조
 * @since J2EE 1.4
 */
public class IHCGuideLineDBDAO extends DBDAOSupport {

	private static final long serialVersionUID = 1L; 

	/**
	 * ESM_PRI_7004 :: IHC Tariff Inquiry
	 * 
	 * @param searchIhcTariffInquiryVO
	 * @return List<IHCTariffInquiryListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<IHCTariffInquiryListVO> searchIhcTariffInquiryList(SearchIhcTariffInquiryVO searchIhcTariffInquiryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IHCTariffInquiryListVO> list = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		if (searchIhcTariffInquiryVO != null) {
			Map<String, String> mapVO = searchIhcTariffInquiryVO.getColumnValues();
			param.putAll(mapVO);
			velParam.putAll(mapVO);
		}
		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOSearchIhcTariffInquiryListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, IHCTariffInquiryListVO.class);
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
	 * ESM_PRI_7024 :: IHC Tariff Creation & Amendment – Special Pop up
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @return List<SpecialCargoPopupListVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<SpecialCargoPopupListVO> searchSpecialCargoPopupList(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpecialCargoPopupListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOSearchSpecialCargoPopupListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SpecialCargoPopupListVO.class);
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
	 * ESM_PRI_7001 : Retrieve form <br>
	 * Retrieve form data <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @return List<IHCGuidelineMainVO>
	 * @exception DAOException
	 */
	public List<IHCGuidelineMainVO> searchIHCGuidelineMain(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IHCGuidelineMainVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOSearchIHCGuidelineMainRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, IHCGuidelineMainVO.class);
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
	 * ESM_PRI_7001_01, ESM_PRI_7001_02 : Retrieve sheet <br>
	 * Retrieve sheet data <br>
	 * 
	 * @param IHCGuidelineDetailVO iHCGuidelineDetailVO
	 * @return List<IHCGuidelineDetailVO>
	 * @exception EventException
	 */
	public List<IHCGuidelineDetailVO> searchIHCGuidelineDetail(IHCGuidelineDetailVO iHCGuidelineDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IHCGuidelineDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (iHCGuidelineDetailVO != null) {
				Map<String, String> mapVO = iHCGuidelineDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOSearchIHCGuidelineDetailRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, IHCGuidelineDetailVO.class);
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
	 * ESM_PRI_7001 : Save <br>
	 * update effective data PRI_TRF_IHC_MN table
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void modifyIHCGuidelineMain(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOModifyIHCGuidelineMainUSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Save <br>
	 * update effective data PRI_TRF_IHC_DUR table
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void modifyIHCTariffDuration(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOModifyIHCTariffDurationUSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Save <br>
	 * update PRI_TRF_IHC_RT Guideline(USD)
	 * 
	 * @param List<IHCGuidelineDetailVO> insertSheetVoList
	 * @exception DAOException
	 */
	public void addIHCGuidelineDetail(List<IHCGuidelineDetailVO> insertSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new IHCGuideLineDBDAOInsertIHCGuidelineDetailCSQL(), insertSheetVoList, null);
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
	 * ESM_PRI_7001 : IHC 테이블에 업데이트
	 * @param IHCDetailVO iHCDetailVO
	 * @throws DAOException
	 */
	public void addIHCGuidelineDetailLocGroup(IHCDetailVO iHCDetailVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCDetailVO != null) {
				Map<String, String> mapVO = iHCDetailVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOInsertIHCGuidelineDetailLocGroupCSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Save <br>
	 * update PRI_TRF_IHC_RT Guideline(USD)
	 * 
	 * @param List<IHCGuidelineDetailVO> updateSheetVoList
	 * @exception DAOException
	 */
	public void modifyIHCGuidelineDetail(List<IHCGuidelineDetailVO> updateSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (updateSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new IHCGuideLineDBDAOModifyIHCGuidelineDetailUSQL(), updateSheetVoList, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
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
	 * ESM_PRI_7001 : Save <br>
	 * Delete Dry Tariff
	 * 
	 * @param List<IHCGuidelineDetailVO> deleteSheetVoList
	 * @exception DAOException
	 */
	public void removeIHCGuidelineDetail(List<IHCGuidelineDetailVO> deleteSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (deleteSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new IHCGuideLineDBDAORemoveIHCGuidelineDetailDSQL(), deleteSheetVoList, null);
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
	 * ESM_PRI_7001 : Confirm <br>
	 * Confirm <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void modifyIHCGuidelineConfirmCur(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOModifyIHCGuidelineConfirmUSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Confirm <br>
	 * Confirm : add progress <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void addIHCGuidelineProgress(PriTrfIhcProgVO priTrfIhcProgVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			Map<String, String> mapVO = priTrfIhcProgVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			int result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOAddIHCGuidelineProgressCSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Confirm <br>
	 * update PRI_TRF_IHC_RT
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void modifyIHCGuidelineDetailDiff(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOModifyIHCGuidelineDetailDiffUSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Confirm <br>
	 * update PRI_TRF_IHC_RT
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void modifyIHCGuidelineDetailConfirm(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOModifyIHCGuidelineDetailConfirmUSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Confirm <br>
	 * update PRI_TRF_IHC_RT (tariff tuning)
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void modifyIHCGuidelineDetailConfirmTuning(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOModifyIHCGuidelineDetailConfirmTuningUSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Confirm <br>
	 * update PRI_TRF_IHC_RT (exchange currency)
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void modifyIHCGuidelineDetailConfirmExchangeRate(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOModifyIHCGuidelineDetailConfirmExchangeRateUSQL(), param, velParam);
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
	 * ESM_PRI_7002 : Confirm <br>
	 * update EXP_DT PRI_TRF_IHC_MN table
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void modifyIHCGuidelineConfirmBef(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOModifyIHCGuidelineMainAmendUSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Confirm <br>
	 * update EXP_DT data PRI_TRF_IHC_DUR table
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void modifyIHCTariffDurationConfirm(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOModifyIHCTariffDurationConfirmUSQL(), param, velParam);
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
	 * ESM_PRI_7002 : Confirm <br>
	 * update EXP_DT data PRI_TRF_IHC_MN table
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void modifyIHCGuidelineConfirmBefTrf(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOmodifyIHCGuidelineConfirmBefTrfUSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Cancel <br>
	 * Cancel : PRI_TRF_IHC_MN <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void removeIHCGuidelineMain(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAORemoveIHCGuidelineMainDSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Cancel <br>
	 * Cancel : PRI_TRF_IHC_DUR <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void removeIHCTariffDuration(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAORemoveIHCTariffDurationDSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Cancel <br>
	 * Cancel : PRI_TRF_IHC_PROG <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void removeIHCGuidelineProgress(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAORemoveIHCGuidelineProgressDSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Cancel <br>
	 * Cancel : PRI_TRF_IHC_HDR <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void removeIHCGuidelineHeader(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAORemoveIHCGuidelineHeaderDSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Cancel <br>
	 * Cancel : PRI_TRF_IHC_RT <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void removeIHCGuidelineDetailAll(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAORemoveIHCGuidelineDetailAllDSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Cancel <br>
	 * Cancel : PRI_TRF_IHC_SPCL_CGO_RT <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void removeIHCSpecialCargoRate(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAORemoveIHCSpecialCargoRateDSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Cancel <br>
	 * Cancel : PRI_TRF_IHC_MN modify EXP_DT and setting CFM_DT, CFM_USR_ID, CFM_OFC_CD = null <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void modifyIHCGuidelineCancel(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOModifyIHCGuidelineCancelUSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Amend <br>
	 * Amend : PRI_TRF_IHC_MN <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void addIHCGuidelineMainAmend(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOAddIHCGuidelineMainAmendCSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Amend <br>
	 * Amend : PRI_TRF_IHC_RT <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void addIHCGuidelineDetailAmend(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOAddIHCGuidelineDetailAmendCSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Amend <br>
	 * Amend : PRI_TRF_IHC_DUR <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void addIHCTariffDurationAmend(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOAddIHCTariffDurationAmendCSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Confirm <br>
	 * Retrieve pre version eff_dt <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @return List<IHCGuidelineMainVO>
	 * @exception DAOException
	 */
	public List<IHCGuidelineMainVO> checkPreIHCGuideline(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IHCGuidelineMainVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOCheckPreIHCGuidelineRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, IHCGuidelineMainVO.class);
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
	 * ESM_PRI_7001 : Amend <br>
	 * Retrieve MAX COST_TRF_NO <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @return List<IHCGuidelineMainVO>
	 * @exception DAOException
	 */
	public List<IHCGuidelineMainVO> checkMaxCostTrfNo(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IHCGuidelineMainVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOCheckMaxCostTrfNoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, IHCGuidelineMainVO.class);
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
	 * ESM_PRI_7025 : IHC Tariff No. Combo <br>
	 * Retrieve IHC Tariff No. Combo <br>
	 * 
	 * @param SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO
	 * @return List<RsltCdListVO>
	 * @exception DAOException
	 */
	public List<RsltCdListVO> searchIHCAmendmentHistoryMainCombo(SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<RsltCdListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchIHCAmendmentHistoryMainVO != null) {
				Map<String, String> mapVO = searchIHCAmendmentHistoryMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOSearchIHCAmendmentHistoryMainComboRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RsltCdListVO.class);
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
	 * ESM_PRI_7025 : IHC Tariff Amendment History Main <br>
	 * Retrieve IHC Tariff Amendment History Main <br>
	 * 
	 * @param SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO
	 * @return List<SearchIHCAmendmentHistoryMainVO>
	 * @exception DAOException
	 */
	public List<SearchIHCAmendmentHistoryMainVO> searchIHCAmendmentHistoryMain(SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchIHCAmendmentHistoryMainVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchIHCAmendmentHistoryMainVO != null) {
				Map<String, String> mapVO = searchIHCAmendmentHistoryMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOSearchIHCAmendmentHistoryMainRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchIHCAmendmentHistoryMainVO.class);
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
	 * ESM_PRI_7025 : IHC Tariff Amendment History Main <br>
	 * DG, Overweight 팝업 버튼 색 변경을 위한 조회 <br>
	 * 
	 * @param IHCTariffInquiryListVO iHCTariffInquiryListVO
	 * @return List<IHCTariffInquiryListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<IHCTariffInquiryListVO> searchIHCDgOverWeightFlag(IHCTariffInquiryListVO iHCTariffInquiryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		 List<IHCTariffInquiryListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (iHCTariffInquiryListVO != null) {
				Map<String, String> mapVO = iHCTariffInquiryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOSearchIHCDgOverWeightFlagRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, IHCTariffInquiryListVO.class);
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
	 * ESM_PRI_7025 : Retrieve Max seq. <br>
	 * Retrieve IHC Tariff Amendment History Max seq. <br>
	 * 
	 * @param SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO
	 * @return List<SearchIHCAmendmentHistoryMainVO>
	 * @exception DAOException
	 */
	public List<SearchIHCAmendmentHistoryMainVO> searchIHCAmendmentHistoryMainMaxSeq(SearchIHCAmendmentHistoryMainVO searchIHCAmendmentHistoryMainVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchIHCAmendmentHistoryMainVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchIHCAmendmentHistoryMainVO != null) {
				Map<String, String> mapVO = searchIHCAmendmentHistoryMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOSearchIHCAmendmentHistoryMainMaxSeqRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchIHCAmendmentHistoryMainVO.class);
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
	 * ESM_PRI_7025 : IHC Tariff Amendment History Detail <br>
	 * Retrieve IHC Tariff Amendment History detail <br>
	 * 
	 * @param SearchIHCAmendmentHistoryDetailVO searchIHCAmendmentHistoryDetailVO
	 * @return List<SearchIHCAmendmentHistoryDetailVO>
	 * @exception DAOException
	 */
	public List<SearchIHCAmendmentHistoryDetailVO> searchIHCAmendmentHistoryDetail(SearchIHCAmendmentHistoryDetailVO searchIHCAmendmentHistoryDetailVO)
			throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchIHCAmendmentHistoryDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchIHCAmendmentHistoryDetailVO != null) {
				Map<String, String> mapVO = searchIHCAmendmentHistoryDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOSearchIHCAmendmentHistoryDetailRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchIHCAmendmentHistoryDetailVO.class);
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
	 * ESM_PRI_7031_01, ESM_PRI_7031_02 : Save <br>
	 * update PRI_TRF_IHC_RT Guideline(USD) for US
	 * 
	 * @param List<IHCGuidelineDetailVO> updateSheetVoList
	 * @exception DAOException
	 */
	public void modifyUsIHCGuidelineDetail(List<IHCGuidelineDetailVO> updateSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (updateSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new IHCGuideLineDBDAOModifyUsIHCGuidelineDetailUSQL(), updateSheetVoList, null);
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
	 * ESM_PRI_7001_01, ESM_PRI_7001_02 : Retrieve sheet <br>
	 * Retrieve sheet data <br>
	 * 
	 * @param SearchUsInlandServiceModeTotalVO searchUsInlandServiceModeTotalVO
	 * @return List<IHCGuidelineDetailVO>
	 * @exception EventException
	 */
	public List<SearchUsInlandServiceModeTotalVO> searchUsInlandServiceModeTotal(SearchUsInlandServiceModeTotalVO searchUsInlandServiceModeTotalVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchUsInlandServiceModeTotalVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchUsInlandServiceModeTotalVO != null) {
				Map<String, String> mapVO = searchUsInlandServiceModeTotalVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOSearchUsInlandServiceModeTotalRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchUsInlandServiceModeTotalVO.class);
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
	 * ESM_PRI_7031 : Save <br>
	 * update PRI_TRF_IHC_RT Guideline(USD) for US
	 * 
	 * @param List<IHCGuidelineDetailVO> insertSheetVoList
	 * @exception DAOException
	 */
	public void addUsIHCGuidelineDetail(List<IHCGuidelineDetailVO> insertSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (insertSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new IHCGuideLineDBDAOInsertUsIHCGuidelineDetailCSQL(), insertSheetVoList, null);
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
	 * ESM_PRI_7033 : Route Retrieve  <br>
	 * Route Retrieve <br>
	 * 
	 * @param IHCGuidelineDetailVO iHCGuidelineDetailVO
	 * @return List<IHCGuidelineDetailVO>
	 * @exception EventException
	 */
	public List<IHCGuidelineDetailVO> searchUsRailIHCGuidelineDetail(IHCGuidelineDetailVO iHCGuidelineDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IHCGuidelineDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (iHCGuidelineDetailVO != null) {
				Map<String, String> mapVO = iHCGuidelineDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOSearchUsRailIHCGuidelineDetailRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, IHCGuidelineDetailVO.class);
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
	 * ESM_PRI_7033 : Apply to Tariff <br>
	 * Update Rate data<br>
	 * 
	 * @param List<IHCGuidelineDetailVO> updateSheetVoList
	 * @exception DAOException
	 */
	public void modifyUsRailIHCGuidelineDetail(List<IHCGuidelineDetailVO> updateSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (updateSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new IHCGuideLineDBDAOModifyUsRailIHCGuidelineDetailUSQL(), updateSheetVoList, null);
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
	 * ESM_PRI_7033 : Check  <br>
	 * Check Point - Base port pair <br>
	 * 
	 * @param IHCGuidelineDetailVO iHCGuidelineDetailVO
	 * @return List<IHCGuidelineDetailVO>
	 * @exception EventException
	 */
	public List<IHCGuidelineDetailVO> checkUsRailIHCGuidelineDetail(IHCGuidelineDetailVO iHCGuidelineDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IHCGuidelineDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (iHCGuidelineDetailVO != null) {
				Map<String, String> mapVO = iHCGuidelineDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOCheckUsRailIHCGuidelineDetailRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, IHCGuidelineDetailVO.class);
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
	 * ESM_PRI_7034 : Retrieve <br>
	 * Retrieve Inland add-on inquiry in local currency (TRO) <br>
	 * 
	 * @param SearchUsTariffInquiryListVO searchUsTariffInquiryListVO
	 * @return List<SearchUsTariffInquiryListVO>
	 * @exception DAOException
	 */
	public List<SearchUsTariffInquiryListVO> searchUsTariffInquiryList(SearchUsTariffInquiryListVO searchUsTariffInquiryListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchUsTariffInquiryListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchUsTariffInquiryListVO != null) {
				Map<String, String> mapVO = searchUsTariffInquiryListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOSearchUsTariffInquiryListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchUsTariffInquiryListVO.class);
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
	 * ESM_PRI_7031 : Confirm <br>
	 * validation check 1 - total value is 0 <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @return List<SearchUsInlandServiceModeTotalVO>
	 * @exception DAOException
	 */
	public List<SearchUsInlandServiceModeTotalVO> checkUsIHCTariffTotal(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchUsInlandServiceModeTotalVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOCheckUsIHCTariffTotalRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchUsInlandServiceModeTotalVO.class);
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
	 * ESM_PRI_7031 : Confirm <br>
	 * validation check 2 - rate tariff tuning or not <br>
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @return List<SearchUsInlandServiceModeTotalVO>
	 * @exception EventException
	 */
	public List<SearchUsInlandServiceModeTotalVO> checkUsIHCTariffTuning(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchUsInlandServiceModeTotalVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOCheckUsIHCTariffTuningRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchUsInlandServiceModeTotalVO.class);
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
	 * ESM_PRI_7001_02 : Save  <br>
	 * Check Add RF IHC GuidelineDetail <br>
	 * 
	 * @param IHCGuidelineDetailVO iHCGuidelineDetailVO
	 * @return List<IHCGuidelineDetailVO>
	 * @exception EventException
	 */
	public List<IHCGuidelineDetailVO> checkAddRFIHCGuidelineDetail(IHCGuidelineDetailVO iHCGuidelineDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<IHCGuidelineDetailVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (iHCGuidelineDetailVO != null) {
				Map<String, String> mapVO = iHCGuidelineDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}		
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOCheckAddRFIHCGuidelineDetailRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, IHCGuidelineDetailVO.class);
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
	 * ESM_PRI_7035 : Delete from Tariff <br>
	 * Delete US Route - ( amdt_seq != 0 )<br>
	 * 
	 * @param List<IHCGuidelineDetailVO> updateSheetVoList
	 * @return void
	 * @exception DAOException
	 */
	public void modifyUSRoute(List<IHCGuidelineDetailVO> updateSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (updateSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new IHCGuideLineDBDAOModifyUSRouteUSQL(), updateSheetVoList, null);
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
	 * ESM_PRI_7035 : Delete from Tariff <br>
	 * Delete US Route - ( amdt_seq = 0 ) <br>
	 * 
	 * @param List<IHCGuidelineDetailVO> deleteSheetVoList
	 * @return void
	 * @exception DAOException
	 */
	public void removeUSRoute(List<IHCGuidelineDetailVO> deleteSheetVoList) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (deleteSheetVoList.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new IHCGuideLineDBDAORemoveUSRouteDSQL(), deleteSheetVoList, null);
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
	 * ESM_PRI_7014 : 엑셀 업로드 시 업데이트 되지 않은 route를 삭제한다.
	 * @param IHCDetailVO ihcDetailVO
	 * @throws DAOException
	 */
	public void removeIHCDetailAll(IHCDetailVO ihcDetailVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (ihcDetailVO != null) {
				Map<String, String> mapVO = ihcDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAORemoveIHCDetailAllDSQL(), param, velParam);
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
	 * ESM_PRI_7014 : 기존 IHC의 IHC_RT_RMK 를 update 한다.
	 * @param IHCDetailVO ihcDetailVO
	 * @throws DAOException
	 */
	public void modifyIHCDetailAll(IHCDetailVO ihcDetailVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (ihcDetailVO != null) {
				Map<String, String> mapVO = ihcDetailVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOModifyIHCDetailAllUSQL(), param, velParam);
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
	 * ESM_PRI_7014 : IHC 테이블에 업데이트
	 * @param PriTrfIHCRtVO priTrfIHCRtVO
	 * @throws DAOException
	 */
	public void uploadIHCCreation(PriTrfIHCRtVO priTrfIHCRtVO) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (priTrfIHCRtVO != null) {
				Map<String, String> mapVO = priTrfIHCRtVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			result = new SQLExecuter("").executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOUploadIHCCreationUSQL(), param, velParam);
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
	
	/*** 
	 * ESM_PRI_7014 : IHC의 Status를 확인한다. 
	 * @param IHCDetailVO ihcDetailVO
	 * @return String
	 * @throws DAOException
	 */
	public String searchIHCStatus(IHCDetailVO ihcDetailVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		String rsltVal = "";
		try {
			Map<String, String> map = ihcDetailVO.getColumnValues();
			param.putAll(map);
			velParam.putAll(map);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOSearchIHCStatusRSQL(), param, velParam);
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
	 *  ESM_PRI_7014 : loc_cd 중복체크 
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
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new IHCGuideLineDBDAOCheckLocListRSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Confirm <br>
	 * update PRI_TRF_IHC_RT ( Guideline Local Diff )
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void modifyIHCGuidelineDetailLocalDiff(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOModifyIHCGuidelineDetailLocalDiffUSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Confirm <br>
	 * update PRI_TRF_IHC_RT ( Local DG, OVG )
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void modifyIHCGuidelineDetailLocalConfirm(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOModifyIHCGuidelineDetailLocalConfirmUSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Confirm <br>
	 * update PRI_TRF_IHC_RT ( Local tariff DG, OVG tuning)
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void modifyIHCGuidelineDetailLocalConfirmTuning(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOModifyIHCGuidelineDetailLocalConfirmTuningUSQL(), param, velParam);
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
	 * ESM_PRI_7001 : Confirm <br>
	 * update PRI_TRF_IHC_RT (exchange USD)
	 * 
	 * @param IHCGuidelineMainVO iHCGuidelineMainVO
	 * @exception DAOException
	 */
	public void modifyIHCGuidelineDetailConfirmUSDExchangeRate(IHCGuidelineMainVO iHCGuidelineMainVO) throws DAOException {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;
		try {
			if (iHCGuidelineMainVO != null) {
				Map<String, String> mapVO = iHCGuidelineMainVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new IHCGuideLineDBDAOModifyIHCGuidelineDetailConfirmUSDExchangeRateUSQL(), param, velParam);
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
}
