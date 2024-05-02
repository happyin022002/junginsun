/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GeneralCodeSearchMgtDBDAO.java
 *@FileTitle : ghost
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.12
 *@LastModifier : 박명신
 *@LastVersion : 1.0
 * 2009.05.12 박명신
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.basic.GeneralCodeSearchMgtBCImpl;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.AGMTRtGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.AGMTRtINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.AGMTRtListVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.BkgTrdCodeVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.ComboInitDataINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CommonInitDataINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomCostCodeVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomCurrXchRtVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMdmVendorVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrEqStsVVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrGeneralCodeVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomUnitPriceVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomerInfoVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.DefaultUnitOfMeasureVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.EQGeneralInfoINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.OfficeInfoListVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.ServiceProviderInfoListINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.VesselInfoVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
	
/**
 * COM GeneralCodeSearchMgtDBDAO <br>
 * - COM-MNRCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author park myoung sin
 * @see GeneralCodeSearchMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class GeneralCodeSearchMgtDBDAO extends DBDAOSupport {
	
	private static final long serialVersionUID = 1L;

	/**
	 * [EES_MNR_0011] 스탠다드 타리프의 EQ TYPE별 디폴트 Unit Of Measure를 구합니다. <br>
	 * 
	 * @param DefaultUnitOfMeasureVO inDefaultUnitOfMeasureVO
	 * @return DefaultUnitOfMeasureVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public DefaultUnitOfMeasureVO searchDEFUnitOfMeasureData(DefaultUnitOfMeasureVO inDefaultUnitOfMeasureVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<DefaultUnitOfMeasureVO> defaultUnitOfMeasureVOS = null;
		DefaultUnitOfMeasureVO defaultUnitOfMeasureVO = new DefaultUnitOfMeasureVO();

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = inDefaultUnitOfMeasureVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchDEFUnitOfMeasureDataRSQL(), param, velParam);
			defaultUnitOfMeasureVOS = (List) RowSetUtil.rowSetToVOs(dbRowset, DefaultUnitOfMeasureVO.class);

			if (defaultUnitOfMeasureVOS.size() > 0) {
				defaultUnitOfMeasureVO = defaultUnitOfMeasureVOS.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return defaultUnitOfMeasureVO;
	}

	/**
	 * [EES_MNR_0189]M&R Service Provider Inquiry_Pop Up의 정보를 조회 합니다. <br>
	 * M&R Service Provider Inquiry_Pop Up에서 데이터를 조회한다.
	 * 
	 * @param ServiceProviderInfoListINVO serviceProviderInfoListINVO
	 * @return List<CustomMdmVendorVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMdmVendorVO> searchServiceProviderInfoListData(ServiceProviderInfoListINVO serviceProviderInfoListINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMdmVendorVO> customMdmVendorVOS = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (serviceProviderInfoListINVO != null) {
				Map<String, String> mapVO = serviceProviderInfoListINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchServiceProviderInfoListDataRSQL(), param, velParam);
			customMdmVendorVOS = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMdmVendorVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return customMdmVendorVOS;
	}

	/**
	 * [EES_MNR_0023]Repair Estimate Creation의 정보를 조회 합니다. <br>
	 * Cost Code을 조회한다.<br>
	 * 
	 * @param CostCodeINVO costCodeINVO
	 * @return List<CustomCostCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomCostCodeVO> searchCostCodeData(CostCodeINVO costCodeINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomCostCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		Map<String, String> mapVO = costCodeINVO.getColumnValues();

		param.putAll(mapVO);
		velParam.putAll(mapVO);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchCostCodeDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomCostCodeVO.class);
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
	 * [MNR_COMMON] Agreement office 를 조회합니다.<br>
	 * 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchOfcComboCodeListData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, String> mapVO = comboInitDataINVO.getColumnValues();
		param.putAll(mapVO);
		velParam.putAll(mapVO);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchOfcComboCodeListDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [EES_MNR_0223]MNR PFMC by VNDR/Manufacturer의 정보를 조회 합니다. <br>
	 * DV Factor의 TP/SZ 데이타에 해당되는 값을 불러온다.<br>
	 * 
	 * @param CommonInitDataINVO commonInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchTypeSizeListData(CommonInitDataINVO commonInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (commonInitDataINVO != null) {
				if (commonInitDataINVO.getKndCd() != null
						&& commonInitDataINVO.getKndCd().trim().length() > 0) {
					param.put("knd_cd", commonInitDataINVO.getKndCd());
					velParam.put("knd_cd", commonInitDataINVO.getKndCd());
					
					param.put("order_by_col_nm", commonInitDataINVO.getOrderByColNm());
					velParam.put("order_by_col_nm", commonInitDataINVO.getOrderByColNm());
					
					velParam.put("type_size_search_ind", commonInitDataINVO.getTypeSizeSearchInd());
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchTypeSizeListDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [EES_MNR_0223]MNR PFMC by VNDR/Manufacturer의 정보를 조회 합니다. <br>
	 * GeneralCodeSearchMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param CommonInitDataINVO commonInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchComGeneralCodeListData(CommonInitDataINVO commonInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchCOMGeneralCodeListDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [EES_MNR_0226]Total Loss Request의 정보를 조회 합니다. <br>
	 * EQ 상세 정보를 조회한다.<br>
	 * 
	 * @param EQGeneralInfoINVO eQGeneralInfoINVO
	 * @return List<CustomMnrEqStsVVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrEqStsVVO> searchEQGeneralInfoData(EQGeneralInfoINVO eQGeneralInfoINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrEqStsVVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (eQGeneralInfoINVO != null) {
				if (eQGeneralInfoINVO.getEqType() != null
						&& eQGeneralInfoINVO.getEqType().trim().length() > 0) {
					List<String> eqNos = new ArrayList();
					String[] arrayEqNo = eQGeneralInfoINVO.getEqNo().split(",");
					for (int i = 0; i < arrayEqNo.length; i++) {
						eqNos.add(arrayEqNo[i]);
					}
						
					param.put("eq_type", eQGeneralInfoINVO.getEqType());
					param.put("eq_no", eqNos);
					param.put("cntr_no", arrayEqNo[0]);
					param.put("total_loss_date", eQGeneralInfoINVO.getTotalLossDate());

					velParam.put("eq_type", eQGeneralInfoINVO.getEqType());
					velParam.put("eq_no", eqNos);
					velParam.put("total_loss_date", eQGeneralInfoINVO.getTotalLossDate());
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchEQGeneralInfoDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrEqStsVVO.class);
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
	 * [EES_MNR_0226]Simple W/O Inquiry Pop Up의 정보를 조회 합니다. <br>
	 * Agreement Rate 조회용 메소드
	 * 
	 * @param AGMTRtGRPVO agmtRtGRPVO
	 * @return List<AGMTRtListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AGMTRtListVO> searchAgmtRateListData(AGMTRtGRPVO agmtRtGRPVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<AGMTRtListVO> rtn = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		AGMTRtINVO agmtRtINVO = agmtRtGRPVO.getAGMTRtINVO();
		try {
			if (agmtRtINVO != null) {
				Map<String, String> mapVO = agmtRtINVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
				param.put("type", agmtRtINVO.getType());
				velParam.put("type", agmtRtINVO.getType());
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchMnrAgmtRtRSQL(), param, velParam);
			rtn = (List) RowSetUtil.rowSetToVOs(dbRowset, AGMTRtListVO.class);

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
	 * [EES_MNR_0226]W/O Creation의 정보를 조회 합니다. <br>
	 * GeneralCodeSearchMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ComboInitDataINVO comboInitDataINVO 
	 * @param SignOnUserAccount account  
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchMnrGenCdData(ComboInitDataINVO comboInitDataINVO,SignOnUserAccount account) throws DAOException {
		DBRowSet dbRowset = null;    
		List<CustomMnrGeneralCodeVO> list = null;     
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("searchcon", comboInitDataINVO.getSearchcon());
			velParam.put("searchcon", comboInitDataINVO.getSearchcon());
			
			//EQ_KIND_CD  
			if(comboInitDataINVO.getSearchcon().equalsIgnoreCase("CUSTOM9")){
				param.put("searchkey", account.getOfc_cd().toString());    
				velParam.put("searchkey", account.getOfc_cd().toString());    
			} else {	
				if(comboInitDataINVO.getSearchkey().endsWith("_AGMT")){
					velParam.put("searchagmt", "A");
					param.put("searchagmt", "A");
					param.put("searchkey", comboInitDataINVO.getSearchkey().replaceAll("_AGMT", ""));
					velParam.put("searchkey", comboInitDataINVO.getSearchkey().replaceAll("_AGMT", ""));
				}else{
					param.put("searchkey", comboInitDataINVO.getSearchkey());
					velParam.put("searchkey", comboInitDataINVO.getSearchkey());
				}
			}		
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchMnrGenCdDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [EES_MNR_0226]W/O Creation의 정보를 조회 합니다. <br>
	 * GeneralCodeSearchMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchMdmCurrencyData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("searchkey", comboInitDataINVO.getSearchkey());
			param.put("searchcon", comboInitDataINVO.getSearchcon());

			velParam.put("searchcon", comboInitDataINVO.getSearchcon());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchMdmCurrencyDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [EES_MNR_0226]W/O Creation의 정보를 조회 합니다. <br>
	 * GeneralCodeSearchMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchMdmVendorData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("searchkey", comboInitDataINVO.getSearchkey());
			param.put("searchcon", comboInitDataINVO.getSearchcon());

			velParam.put("searchcon", comboInitDataINVO.getSearchcon());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchMdmVendorDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [EES_MNR_0226]W/O Creation의 정보를 조회 합니다. <br>
	 * GeneralCodeSearchMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchEqTpSzData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("searchkey", comboInitDataINVO.getSearchkey());
			param.put("searchcon", comboInitDataINVO.getSearchcon());

			velParam.put("searchcon", comboInitDataINVO.getSearchcon());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchEqTpSzDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [EES_MNR_0226]W/O Creation의 정보를 조회 합니다. <br>
	 * GeneralCodeSearchMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchComUserData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("searchkey", comboInitDataINVO.getSearchkey());
			param.put("searchcon", comboInitDataINVO.getSearchcon());

			velParam.put("searchcon", comboInitDataINVO.getSearchcon());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchComUserDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [MNRCOMMON] EQ_COMPO_CD를 조회해옴. <br>
	 * GeneralCodeSearchMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>	
	 * 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchMnrEqCmpoCdData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("searchkey", comboInitDataINVO.getSearchkey());
			param.put("searchcon", comboInitDataINVO.getSearchcon());

			velParam.put("searchcon", comboInitDataINVO.getSearchcon());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchMnrEqCmpoCdDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [MNRCOMMON] FLag가 체크된 EQ_COMPO_CD를 조회해옴. <br> 
	 * GeneralCodeSearchMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 *				 	
	 * @param ComboInitDataINVO comboInitDataINVO	
	 * @return List<CustomMnrGeneralCodeVO>			
	 * @exception DAOException						
	 */	
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchMnrEqCmpoCdByEqTypeData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			param.put("searchkey", comboInitDataINVO.getSearchkey());
			param.put("searchcon", comboInitDataINVO.getSearchcon());
			
			velParam.put("searchcon", comboInitDataINVO.getSearchcon());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchMnrEqCmpoCdByEqTypeDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [EES_MNR_0226]W/O Creation의 정보를 조회 합니다. <br>
	 * GeneralCodeSearchMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchMnrEqCmpoUpCdData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("searchkey", comboInitDataINVO.getSearchkey());
			param.put("searchcon", comboInitDataINVO.getSearchcon());

			velParam.put("searchcon", comboInitDataINVO.getSearchcon());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchMnrEqCmpoUpCdDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [EES_MNR_0226]W/O Creation의 정보를 조회 합니다. <br>
	 * GeneralCodeSearchMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchMnrCedexOthCdData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("searchkey", comboInitDataINVO.getSearchkey());
			param.put("searchcon", comboInitDataINVO.getSearchcon());

			velParam.put("searchcon", comboInitDataINVO.getSearchcon());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchMnrCedexOthCdDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [EES_MNR_0226]W/O Creation의 정보를 조회 합니다. <br>
	 * GeneralCodeSearchMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchMnrEqLocCdData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("searchkey", comboInitDataINVO.getSearchkey());
			param.put("searchcon", comboInitDataINVO.getSearchcon());

			velParam.put("searchcon", comboInitDataINVO.getSearchcon());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchMnrEqLocCdDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [EES_MNR_0226]W/O Creation의 정보를 조회 합니다. <br>
	 * GeneralCodeSearchMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchMnrFldQltyAudRsltData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("searchkey", comboInitDataINVO.getSearchkey());
			param.put("searchcon", comboInitDataINVO.getSearchcon());

			velParam.put("searchcon", comboInitDataINVO.getSearchcon());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchMnrFldQltyAudRsltDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [EES_MNR_0226]W/O Creation의 정보를 조회 합니다. <br>
	 * GeneralCodeSearchMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchMnrAgmtHdrData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			String serKeyTemp = comboInitDataINVO.getSearchkey();
			
			//문자열은 제외하고 다시 AGMT NO다시 조합		
			if(serKeyTemp.length() > 3){
				String serPrifix = serKeyTemp.substring(0, 3);
				String serSeq = serKeyTemp.substring(3);
				
				StringBuilder tempSerSeq = new StringBuilder("");
				char chars[] = serSeq.toCharArray();
				for(int k = 0; k < chars.length;k ++){
					if(!(chars[k] < '0' || chars[k] > '9')) { 
						Character ch = new Character(chars[k]);
						tempSerSeq.append(ch.toString());	
					} 		
				}
				serKeyTemp = serPrifix + tempSerSeq.toString();
			}
			
			param.put("searchkey", serKeyTemp);
			param.put("searchcon", comboInitDataINVO.getSearchcon());

			velParam.put("searchcon", comboInitDataINVO.getSearchcon());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchMnrAgmtHdrDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [EES_MNR_0226]W/O Creation의 정보를 조회 합니다. <br>
	 * GeneralCodeSearchMgtDBDAO의 Division 정보에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchMnrDivisionCodeData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			String searchkey = comboInitDataINVO.getSearchkey();
			String[] searchkeys = searchkey.split(",");

			if (searchkeys.length > 1) {
				param.put("fm_rlt_cd", searchkeys[0]);
				param.put("cost_grp_cd", searchkeys[1]);
			} else {
				param.put("fm_rlt_cd", searchkey);
			}

			param.put("searchcon", comboInitDataINVO.getSearchcon());
			velParam.put("searchcon", comboInitDataINVO.getSearchcon());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchMnrDivisonCodeDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [EES_MNR_0226]W/O Creation의 정보를 조회 합니다. <br>
	 * GeneralCodeSearchMgtDBDAO의 Division 정보에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchMnrRepairCodeData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
							
		try {	
			param.put("searchkey", comboInitDataINVO.getSearchkey());
			param.put("searchcon", comboInitDataINVO.getSearchcon());
											
			velParam.put("searchcon", comboInitDataINVO.getSearchcon());	
						
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchMnrRepairCodeDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [EES_MNR_0226]W/O Creation의 정보를 조회 합니다. <br>
	 * GeneralCodeSearchMgtDBDAO의 COMMON INTG CODE 정보에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchComIntgCodeData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("searchkey", comboInitDataINVO.getSearchkey());
			param.put("searchcon", comboInitDataINVO.getSearchcon());

			velParam.put("searchcon", comboInitDataINVO.getSearchcon());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchComIntgCodeDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [MNR_COMMON] RHQ OFC CODE 정보를 조회합니다. <br>
	 *					 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchRhqOfcCdData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try {	
			param.put("searchkey", comboInitDataINVO.getSearchkey());
			param.put("searchcon", comboInitDataINVO.getSearchcon());
			
			velParam.put("searchcon", comboInitDataINVO.getSearchcon());
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchRhqOfcCdDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [MNR_COMMON] RHQ OFC CODE 정보를 조회합니다. <br>
	 *					 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchOfcCdFromRhqData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;	
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try {	
			param.put("searchkey", comboInitDataINVO.getSearchkey());
			param.put("searchcon", comboInitDataINVO.getSearchcon());
				
			velParam.put("searchcon", comboInitDataINVO.getSearchcon());
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchOfcCdFromRhqDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [MNR_COMMON] Repair Invoice OFC CODE 정보를 조회합니다. <br>
	 *					 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchRprInvOfcCdData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try {
			param.put("searchkey", comboInitDataINVO.getSearchkey());
			param.put("searchcon", comboInitDataINVO.getSearchcon());
			
			velParam.put("searchcon", comboInitDataINVO.getSearchcon());
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchRprInvOfcCdDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [MNR_COMMON] RHQ Office Change 정보를 조회합니다. <br>
	 *					 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchRhqOfcChgCdData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
			
		try {
			param.put("searchkey", comboInitDataINVO.getSearchkey());
			param.put("searchcon", comboInitDataINVO.getSearchcon());
			
			velParam.put("searchcon", comboInitDataINVO.getSearchcon());
				
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchRhqOfcChgCdDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [MNR_COMMON] RHQ Office 로 conuntry 정보를 조회합니다. <br>
	 *					 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchCountryByRhqOfcCdData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {  			
			param.put("searchkey", comboInitDataINVO.getSearchkey());
			param.put("searchcon", comboInitDataINVO.getSearchcon());
			
			velParam.put("searchcon", comboInitDataINVO.getSearchcon());
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchCountryByRhqOfcCdDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [MNR_COMMON] conuntry 로 OFC 정보를 조회합니다. <br>
	 *					 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchOfcCdByCountryData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter	
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		
		try {
			
			String country = "";
			String rhq = "";
			if(comboInitDataINVO.getSearchcon().length() > 0 && comboInitDataINVO.getSearchcon().indexOf(",") != -1){
				String[] arrSearchcon = comboInitDataINVO.getSearchcon().split(",");
				country = arrSearchcon[0];
				rhq = arrSearchcon[1];		
			}
				
			param.put("country", country);
			param.put("rhq", rhq);
				
			velParam.put("country", country);
			velParam.put("rhq", rhq);							
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchOfcCdByCountryDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [EES_MNR_0194]Vessel Reefer Spare Part Purchase W/O Creation의 정보를 조회 합니다. <br>
	 * GeneralCodeSearchMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param VesselInfoVO vesselInfoVO
	 * @return List<VesselInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<VesselInfoVO> searchVesselInfoData(VesselInfoVO vesselInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<VesselInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, String> mapVO = vesselInfoVO.getColumnValues();
		param.putAll(mapVO);
		velParam.putAll(mapVO);
		if (vesselInfoVO.getVslCd().length() >= 9) {
			param.put("vsl_cd", vesselInfoVO.getVslCd().substring(0, 4));
			velParam.put("vsl_cd", vesselInfoVO.getVslCd().substring(0, 4));
			param.put("skd_voy_no", vesselInfoVO.getVslCd().substring(4, 8));
			velParam.put("skd_voy_no", vesselInfoVO.getVslCd().substring(4, 8));
			param.put("skd_dir_cd", vesselInfoVO.getVslCd().substring(8, 9));
			velParam.put("skd_dir_cd", vesselInfoVO.getVslCd().substring(8, 9));
		}

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchVesselInfoDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, VesselInfoVO.class);
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
	 * [EES_MNR_0155]Disposal Buyer Management의 정보를 조회 합니다. <br>
	 * GeneralCodeSearchMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param CustomerInfoVO customerInfoVO
	 * @return List<CustomerInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerInfoVO> searchCustomerInfoData(CustomerInfoVO customerInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerInfoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, String> mapVO = customerInfoVO.getColumnValues();
		param.putAll(mapVO);
		velParam.putAll(mapVO);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchCustomerInfoDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomerInfoVO.class);
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
	 * [EES_MNR_0157]Disposal Request의 정보를 조회 합니다. <br>
	 * Unit Price 를 조회합니다.
	 * 
	 * @param CustomUnitPriceVO customUnitPriceVO
	 * @return CustomUnitPriceVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CustomUnitPriceVO searchUnitPriceData(CustomUnitPriceVO CustomUnitPriceVO) throws DAOException {
		DBRowSet dbRowset = null;
		CustomUnitPriceVO customUnitPriceVO = new CustomUnitPriceVO();
		List<CustomUnitPriceVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, String> mapVO = CustomUnitPriceVO.getColumnValues();
		param.putAll(mapVO);
		velParam.putAll(mapVO);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchUnitPriceDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomUnitPriceVO.class);

			if (list.size() > 0) {
				customUnitPriceVO = (CustomUnitPriceVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return customUnitPriceVO;
	}

	/**
	 * [EES_MNR_0223]MNR PFMC by VNDR/Manufacturer의 정보를 조회 합니다. <br>
	 * Disposal Planning by Headoffice[EES_MNR_0152] 에서 Disposal 에 해당하는 TypeSize
	 * 를 조회한다.<br>
	 * 
	 * @param CommonInitDataINVO commonInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchTypeSizeListForDSPData(CommonInitDataINVO commonInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (commonInitDataINVO != null) {
				if (commonInitDataINVO.getKndCd() != null
						&& commonInitDataINVO.getKndCd().trim().length() > 0) {
					param.put("knd_cd", commonInitDataINVO.getKndCd());
					velParam.put("knd_cd", commonInitDataINVO.getKndCd());
					param.put("order_by_col_nm", commonInitDataINVO.getOrderByColNm());
					velParam.put("order_by_col_nm", commonInitDataINVO.getOrderByColNm());
				}
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchTypeSizeListForDSPDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [EES_MNR_0041]Currency별 소수점자리 정보를 조회 합니다. <br>
	 * 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchMdmCurrencyPrcsKntData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("searchkey", comboInitDataINVO.getSearchkey());
			param.put("searchcon", comboInitDataINVO.getSearchcon());

			velParam.put("searchcon", comboInitDataINVO.getSearchcon());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchMdmCurrencyPrcsKntDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [EES_MNR_0041]파트너 정보를 조회 합니다. <br>
	 * 
	 * @param ComboInitDataINVO comboInitDataINVO
	 * @return List<CustomMnrGeneralCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomMnrGeneralCodeVO> searchPrntVndrSeqData(ComboInitDataINVO comboInitDataINVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomMnrGeneralCodeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("searchkey", comboInitDataINVO.getSearchkey());
			param.put("searchcon", comboInitDataINVO.getSearchcon());

			velParam.put("searchcon", comboInitDataINVO.getSearchcon());

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchPrntVndrSeqDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrGeneralCodeVO.class);
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
	 * [EES_MNR_QEXE] TEMP <br>
	 * 
	 * @param String tabName
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchTabColInfoData(String tabName) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("tab_name", tabName);
			velParam.put("tab_name", tabName);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchTabColInfoDataRSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}

	/**
	 * [EES_MNR_QEXE] TEMP<br>
	 * 
	 * @param String sql
	 * @return int
	 * @exception DAOException
	 */
	public int modifyMnrQexeData(String sql) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		int result = 0;

		try {
			Map<String, String> mapVO = new ComboInitDataINVO().getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			SQLExecuter sqlExe = new SQLExecuter("");
			result = sqlExe.executeUpdate((ISQLTemplate) new GeneralCodeSearchMgtDBDAOmodifyMnrQexeDataUSQL(sql), param, velParam);

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
	 * [EES_MNR_QEXE] TEMP <br>
	 * 
	 * @param String sql
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchMnrQexeData(String sql) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchMnrQexeDataRSQL(sql), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return dbRowset;
	}
	
	/**
	 * [EES_MNR_0041]Conversion할 Curr rate를 조회 합니다. <br>
	 * Curr Rate을 조회합니다.
	 * 
	 * @param CustomCurrXchRtVO customCurrXchRtVO
	 * @return CustomCurrXchRtVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CustomCurrXchRtVO searchCurrXchRtInfoData(CustomCurrXchRtVO customCurrXchRtVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomCurrXchRtVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		Map<String, String> mapVO = customCurrXchRtVO.getColumnValues();
		param.putAll(mapVO);
		velParam.putAll(mapVO);

		try {
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchCurrXchRtInfoDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomCurrXchRtVO.class);

			if (list.size() > 0) {
				customCurrXchRtVO = (CustomCurrXchRtVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return customCurrXchRtVO;
	}	
	
	/**
     * [EES_MNR_0019] Searching rfUnitMaker <br>
     * 
     * @param String eqNo
     * @return CustomMnrEqStsVVO
     * @throws DAOException
     */
    public CustomMnrEqStsVVO searchRfUnitMakerData(String eqNo) throws DAOException {
          DBRowSet dbRowset = null;
          List<CustomMnrEqStsVVO> list = null;    
          CustomMnrEqStsVVO customMnrEqStsVVO = null;
          // query parameter
          Map<String, Object> param = new HashMap<String, Object>();
          // velocity parameter
          Map<String, Object> velParam = new HashMap<String, Object>();

          Map<String, String> mapVO = new HashMap<String, String>();
          mapVO.put("eq_no", eqNo);
          
          param.putAll(mapVO);
          velParam.putAll(mapVO);

          try {
                 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchRfUnitMakerDataRSQL(), param, velParam);
                 
                 list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomMnrEqStsVVO.class);
                 
                 if (list.size() > 0) {
                        customMnrEqStsVVO = (CustomMnrEqStsVVO) list.get(0);
                 }                   
                 
          } catch (SQLException se) {
                 log.error(se.getMessage(), se);
                 throw new DAOException(new ErrorHandler(se).getMessage());
          } catch (Exception ex) {
                 log.error(ex.getMessage(), ex);
                 throw new DAOException(new ErrorHandler(ex).getMessage());
          }
          return customMnrEqStsVVO;
    }
    
    /**
	 * [EES_MNR_0052]Bkg No 와 Trade Code 를 가져온다<br>
	 * 
	 * @param BkgTrdCodeVO bkgTrdCodeVO
	 * @return List<BkgTrdCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BkgTrdCodeVO> searchBkgTrdCodeData(BkgTrdCodeVO bkgTrdCodeVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<BkgTrdCodeVO> bkgTrdCodeVOs = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (bkgTrdCodeVO != null) {
				Map<String, String> mapVO = bkgTrdCodeVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchBkgTrdCodeDataRSQL(), param, velParam);
			bkgTrdCodeVOs = (List) RowSetUtil.rowSetToVOs(dbRowset, BkgTrdCodeVO.class);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return bkgTrdCodeVOs;
	}
	
	/**
	 * Cost Shipment Pattern 을 조회한다<br>
	 *
	 * @param BkgTrdCodeVO bkgTrdCodeVO
	 * @return String
	 * @exception DAOException
	 */
	 public String checkCostShpSrchPattData(BkgTrdCodeVO bkgTrdCodeVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 String retVal = "";
		 
		 //query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 //velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 	
		try{
			Map<String, String> mapVO = bkgTrdCodeVO.getColumnValues();
	     	    
			param.putAll(mapVO);     
			velParam.putAll(mapVO);  
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeSearchMgtDBDAOsearchCostShpSrchPattDataRSQL(), param, velParam);
			 
			if(dbRowset.next()){
				retVal = dbRowset.getString("COST_SHP_SRCH_PATT_NM");
			}
			 
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}
	 
	/**
	 * OFC_CD 에 해당하는 LCC_CD 를 조회한다<br>
	 *
	 * @param CustomerInfoVO customerInfoVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchOfcLccCdata(CustomerInfoVO customerInfoVO) throws DAOException {
		DBRowSet dbRowset = null;
		String retVal = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = customerInfoVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchOfcLccCdDataRSQL(), param, velParam);

			if (dbRowset.next()) {
				retVal = dbRowset.getString("LCC_CD");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}

	/**
	 * OFC_CD 에 해당하는 RHQ_OFC_CD 를 조회한다<br>
	 *
	 * @param OfficeInfoListVO officeInfoListVO
	 * @return String
	 * @exception DAOException
	 */
	public String searchRhqOfcFmOfcCdData(OfficeInfoListVO officeInfoListVO) throws DAOException {
		DBRowSet dbRowset = null;
		String retVal = "";

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = officeInfoListVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchRhqOfcFmOfcCdDataRSQL(), param, velParam);

			if (dbRowset.next()) {
				retVal = dbRowset.getString("AR_HD_QTR_OFC_CD");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return retVal;
	}
	
	/**
	 * [EES_MNR_0018]Agreement Group 정보를 가져온다 
	 * 
	 * @param  String eqType
	 * @return List<CustomCostCodeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CustomCostCodeVO> searchAgmtGrpData(String eqType) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomCostCodeVO> result = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("eq_type", eqType);
			velParam.put("eq_type", eqType);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GeneralCodeSearchMgtDBDAOsearchMnrAgmtGrpListDataRSQL(), param, velParam);
			result = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomCostCodeVO.class);

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
	  * Cost Code 별 Yard Code 를 조회합니다.<br>
	  * @param AGMTRtGRPVO agmtRtGRPVO
	  * @return List<AGMTRtListVO>
	  * @exception DAOException
	  */
	 @SuppressWarnings("unchecked")
	 public List<AGMTRtListVO> searchCostYardCodeData(AGMTRtGRPVO agmtRtGRPVO) throws DAOException {
		 DBRowSet dbRowset = null;
		 List<AGMTRtListVO> rtn = null;

		 // query parameter
		 Map<String, Object> param = new HashMap<String, Object>();
		 // velocity parameter
		 Map<String, Object> velParam = new HashMap<String, Object>();
		 AGMTRtINVO agmtRtINVO = agmtRtGRPVO.getAGMTRtINVO();
		 try{
			 Map<String, String> mapVO = agmtRtINVO.getColumnValues();
			 param.putAll(mapVO);
			 velParam.putAll(mapVO);

			 dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new GeneralCodeSearchMgtDBDAOsearchCostYardCodeDataRSQL(), param, velParam);
			 rtn = (List)RowSetUtil.rowSetToVOs(dbRowset, AGMTRtListVO .class);

		 }catch(SQLException se){
			 log.error(se.getMessage(),se);
			 throw new DAOException(new ErrorHandler(se).getMessage());
		 }catch(Exception ex){
			 log.error(ex.getMessage(),ex);
			 throw new DAOException(new ErrorHandler(ex).getMessage());
		 }
		 return rtn;
	 }
}
