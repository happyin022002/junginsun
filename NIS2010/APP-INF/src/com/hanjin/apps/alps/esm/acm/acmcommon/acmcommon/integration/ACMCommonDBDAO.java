/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ACMCommonDBDAO.java
*@FileTitle : ACM_Common
*Open Issues :
*Change history :
*@LastModifyDate : 2012.03.07
*@LastModifier : 김상수
*@LastVersion : 1.0
* 2012.03.07 김상수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.basic.ACMCommonBCImpl;
import com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.vo.CommonVO;
import com.hanjin.apps.alps.esm.acm.acmcommon.acmcommon.vo.LocationSelectionVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;


/**
 * ALPS ACMCommonDBDAO <br>
 * - ALPS-ACMCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 *
 * @author KIM, Sang-Soo
 * @see ACMCommonBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class ACMCommonDBDAO extends DBDAOSupport {

	/**
	 * 공통 : A/R Office 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getAROfficeFromBkgChnAgnList(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetAROfficeFromBkgChnAgnListRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : China Anegt info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getBkgChnAgnInfo(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetBkgChnAgnInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : MDM Office info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getMdmOrganizationInfo(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetMdmOrganizationInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : Vendor info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getMdmVendorInfo(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetMdmVendorInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : MDM LOCATION info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getMdmLocationInfo(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetMdmLocationInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : MDM VESSEL SERVICE LANE info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getMdmVslSvcLaneInfo(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetMdmVslSvcLaneInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : MDM ORGANIZATION에서 RHQ 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getRhqLevelFromMdmOrganizationInfo(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetRhqLevelFromMdmOrganizationInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : 사용자의 Office Code에 따른 A/R Office 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getAROfficeByUserOfficeList(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetAROfficeByUserOfficeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : 사용자의 Office Code에 따른 AGN 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getAgnByAROfficeList(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetAgnByAROfficeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : MDM CHARGE info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getMdmChageInfo(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetMdmChageInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : MDM_SVC_SCP info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CommonVO> getMdmServiceScopeInfo(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetMdmServiceScopeInfoRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : ACM_COMM_TP_CD_MAPG info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CommonVO> getAcmCommTpCdMapg(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetAcmCommTpCdMapgInfoRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : ACM_OFC_INFO에서 AGN 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getAgnFromAcmOfcInfoList(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetAgnFromAcmOfcInfoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : ACM_OFC_INFO에서 RHQ 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getRhqFromAcmOfcInfoList(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetRhqFromAcmOfcInfoListRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : MDM CURRENCY info 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getMdmCurrencyInfo(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetMdmCurrencyInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : 로그인한 사용자의 ofc_cd로 Sales Office 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getSalesOfficeFromMdmOrganizationList(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetSalesOfficeFromMdmOrganizationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : [ESM_ACM_0029]Special Compensation Audit 의 Office Code 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getAROfficeAgmtCmpnInfoList(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetAROfficeAgmtCmpnInfoListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : MDM_CUSTOMER에서 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getMdmCustomerInfo(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetMdmCustomerInfoRSQL(), param, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : High RHQ Level에 따른 A/R Office 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getAROfficeByRhqLevelHighList(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetAROfficeByRhqLevelHighListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : Low RHQ Level에 따른 A/R Office 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getAROfficeByRhqLevelLowList(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetAROfficeByRhqLevelLowListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : MDM_REP_CMDT 혹은 MDM_COMMODITY에서 단건을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return CommonVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public CommonVO getMdmCommodityInfo(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO rsltVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetMdmCommodityInfoRSQL(), param, velParam);
			List<CommonVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
			if(list.size() > 0) {
				rsltVo = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsltVo;
	}

	/**
	 * 공통 : [ESM_ACM_0023]FF Compensation Agreement Creation 저장 전 "Charge(Only for BS)"항목 체크<br>
	 * (MDM_CHARGE의 ERR_CNT 가 0인지 아닌지 조회)
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getFfChgCtntChkList(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetFfChgCtntChkListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : 입력된 코드가 MDM_CNTR_TP 에 존재하는지 체크<br>
	 *
	 * @param CommonVO commonVO
	 * @return CommonVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CommonVO getMdmCntrTpChkList(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		CommonVO rsltVo = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetMdmCntrTpChkListRSQL(), param, velParam);
			List<CommonVO> list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
			if(list.size() > 0) {
				rsltVo = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rsltVo;
	}

	/**
	 * 공통 : 입력된 office code 가 상계 정산 대리점(operational)인지 체크.(리턴값 => operational : Y, else : N)<br>
	 *
	 * @param CommonVO commonVO
	 * @return String
	 * @exception DAOException
	 */
	public String getOffSetFlag(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetOffSetFlagInfoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("CODE");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnValue;
	}

	/**
	 * [ESM_ACM_0113]
	 * Location Selection 목록을 조회(1. Conti)<br>
	 *
	 * @param LocationSelectionVO locationSelectionVO
	 * @return List<LocationSelectionVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<LocationSelectionVO> searchLocSelectConti(LocationSelectionVO locationSelectionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<LocationSelectionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (locationSelectionVO != null) {
				Map<String, String> mapVO= locationSelectionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOSearchLocSelectContiListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LocationSelectionVO.class);
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
	 * [ESM_ACM_0113]
	 * Location Selection 목록을 조회(2. Sub Conti)<br>
	 *
	 * @param LocationSelectionVO locationSelectionVO
	 * @return List<LocationSelectionVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<LocationSelectionVO> searchLocSelectSubConti(LocationSelectionVO locationSelectionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<LocationSelectionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (locationSelectionVO != null) {
				Map<String, String> mapVO= locationSelectionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOSearchLocSelectSubContiListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LocationSelectionVO.class);
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
	 * [ESM_ACM_0113]
	 * Location Selection 목록을 조회(3. Country)<br>
	 *
	 * @param LocationSelectionVO locationSelectionVO
	 * @return List<LocationSelectionVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<LocationSelectionVO> searchLocSelectCountry(LocationSelectionVO locationSelectionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<LocationSelectionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (locationSelectionVO != null) {
				Map<String, String> mapVO= locationSelectionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOSearchLocSelectCountryListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LocationSelectionVO.class);
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
	 * [ESM_ACM_0113]
	 * Location Selection 목록을 조회(4. Location)<br>
	 *
	 * @param LocationSelectionVO locationSelectionVO
	 * @return List<LocationSelectionVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<LocationSelectionVO> searchLocSelectLocation(LocationSelectionVO locationSelectionVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<LocationSelectionVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (locationSelectionVO != null) {
				Map<String, String> mapVO= locationSelectionVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOSearchLocSelectLocationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LocationSelectionVO.class);
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
	 * 공통 : RHQ에 따른 Agent Code 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getAgnByRhqList(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetAgnByRhqListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : MDM_TRADE 테이블의 TRD_CD 목록을 조회<br>
	 *
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getMdmTradeList() throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetMdmTradeListRSQL(), null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
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
	 * 공통 : COA_LANE_RGST 테이블의 RLANE_CD 목록을 조회<br>
	 *
	 * @param CommonVO commonVO
	 * @return List<CommonVO>
	 * @exception EventException
	 */
	 @SuppressWarnings("unchecked")
	public List<CommonVO> getCoaLaneRgstList(CommonVO commonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<CommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (commonVO != null) {
				Map<String, String> mapVO = commonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ACMCommonDBDAOGetCoaLaneRgstListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CommonVO.class);
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return list;
	}

}