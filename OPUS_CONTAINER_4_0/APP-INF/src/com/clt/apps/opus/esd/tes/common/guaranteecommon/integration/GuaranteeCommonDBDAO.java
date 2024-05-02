/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : GuaranteeCommonDBDAO.java
 *@FileTitle : GuaranteeCommon
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.10.22
 *@LastModifier : yOng hO lEE
 *@LastVersion : 1.0
 * 2009.10.22 yOng hO lEE
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.common.guaranteecommon.integration;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.tes.common.guaranteecommon.basic.GuaranteeCommonBCImpl;
import com.clt.apps.opus.esd.tes.common.guaranteecommon.vo.SearchRefNoListVO;
import com.clt.apps.opus.esd.tes.guaranteemanage.guaranteemanage.vo.GuaranteeCommonVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.TesGnteCntrListVO;
import com.clt.syscommon.common.table.TesGnteHdrVO;
import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAOValidateCostOFCRSQL;
import com.clt.apps.opus.esd.tes.common.tescommon.integration.TESCommonDBDAOValidateYardCodeRSQL;

/**
 * GuaranteeCommonDBDAO <br>
 * GuaranteeCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author yOng hO lEE
 * @see GuaranteeCommonBCImpl 참조
 * @since J2EE 1.6
 */
public class GuaranteeCommonDBDAO extends DBDAOSupport {

	/**
	 * [Guarantee Non TPB 여부]을 [Check] 합니다.<br>
	 * 
	 * @param TesGnteCntrListVO tesGnteCntrListVO
	 * @return List<TPBInterfaceVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TesGnteCntrListVO> checkNonTPB(TesGnteCntrListVO tesGnteCntrListVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TesGnteCntrListVO> list = null;

		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (tesGnteCntrListVO != null) {
				Map<String, String> mapVO = tesGnteCntrListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GuaranteeCommonDBDAOCheckNonTPBRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TesGnteCntrListVO.class);
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
	 * [Reference No(Guarantee No. Or Irregular No.)]을 [Select] 합니다.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return List<SearchRefNoListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchRefNoListVO> searchRefNoList(GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchRefNoListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (guaranteeCommonVO != null) {
				Map<String, String> mapVO = guaranteeCommonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GuaranteeCommonDBDAOSearchRefNoListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchRefNoListVO.class);
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
	 * [Guarantee Container Bkg No & Bl No & VVD Info]을 [Select] 합니다.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchUSGuaranteeCntrInfo(GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if (!"".equals(guaranteeCommonVO.getCntrNoTmp())) {
				param.put("cntr_no", guaranteeCommonVO.getCntrNoTmp());
				velParam.put("cntr_no", guaranteeCommonVO.getCntrNoTmp());
			}

			if (!"".equals(guaranteeCommonVO.getBkgNoTmp())) {
				param.put("bkg_no", guaranteeCommonVO.getBkgNoTmp());
				velParam.put("bkg_no", guaranteeCommonVO.getBkgNoTmp());
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GuaranteeCommonDBDAOSearchUSGuaranteeCntrInfoRSQL(), param, velParam);
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
	 * [Guarantee Container Bkg No & Bl No & VVD Info]을 [Select] 합니다.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet searchCntrBkgNo(GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if (!"".equals(guaranteeCommonVO.getCntrNoTmp())) {
				param.put("cntr_no", guaranteeCommonVO.getCntrNoTmp());
				velParam.put("cntr_no", guaranteeCommonVO.getCntrNoTmp());
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GuaranteeCommonDBDAOSearchCntrBkgNoRSQL(), param, velParam);
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
	 * validate Customer Code
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return DBRowSet
	 * @exception DAOException
	 */
	public DBRowSet validateCustomerCode(GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		log.debug("\n[GuaranteeCommonDBDAO][validateCustomerCode] \n");

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			if (!"".equals(guaranteeCommonVO.getGnteCustCd()) && guaranteeCommonVO.getGnteCustCd().length() == 8) {
				param.put("cust_cnt_cd", guaranteeCommonVO.getGnteCustCd().substring(0, 2));
				velParam.put("cust_cnt_cd", guaranteeCommonVO.getGnteCustCd().substring(0, 2));

				param.put("cust_seq", guaranteeCommonVO.getGnteCustCd().substring(2, 8));
				velParam.put("cust_seq", guaranteeCommonVO.getGnteCustCd().substring(2, 8));
			} else {
				param.put("cust_cnt_cd", guaranteeCommonVO.getGnteCustCd());
				velParam.put("cust_cnt_cd", guaranteeCommonVO.getGnteCustCd());

				param.put("cust_seq", "");
				velParam.put("cust_seq", "");
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GuaranteeCommonDBDAOValidateCustomerCodeRSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return dbRowset;
	}

	/**
	 * validateCustomerCode2
	 * 
	 * @param guaranteeCommonVO
	 * @return
	 * @throws DAOException
	 */
	public String validateCustomerCode2(GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		log.debug("\n[GuaranteeCommonDBDAO][validateCustomerCode2] \n");

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String custNm = "";

		try {

			if (!"".equals(guaranteeCommonVO.getGnteCustCd()) && guaranteeCommonVO.getGnteCustCd().length() == 8) {
				param.put("cust_cnt_cd", guaranteeCommonVO.getGnteCustCd().substring(0, 2));
				velParam.put("cust_cnt_cd", guaranteeCommonVO.getGnteCustCd().substring(0, 2));

				param.put("cust_seq", guaranteeCommonVO.getGnteCustCd().substring(2, 8));
				velParam.put("cust_seq", guaranteeCommonVO.getGnteCustCd().substring(2, 8));
			} else {
				param.put("cust_cnt_cd", guaranteeCommonVO.getGnteCustCd());
				velParam.put("cust_cnt_cd", guaranteeCommonVO.getGnteCustCd());

				param.put("cust_seq", "");
				velParam.put("cust_seq", "");
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GuaranteeCommonDBDAOValidateCustomerCodeRSQL(), param, velParam);

			if (dbRowset != null && dbRowset.next()) {
				custNm = dbRowset.getString("CUST_LGL_ENG_NM");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return custNm;
	}

	/**
	 * Container No. Duplication Check.<br>
	 * 
	 * @param GuaranteeCommonVO guaranteeCommonVO
	 * @return boolean
	 * @exception DAOException
	 */
	public boolean checkDupCntr(GuaranteeCommonVO guaranteeCommonVO) throws DAOException {
		log.debug("\n[GuaranteeCommonDBDAO][checkDupCntr] \n");

		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		boolean isSuccess = false;

		try {

			if (guaranteeCommonVO != null) {
				Map<String, String> mapVO = guaranteeCommonVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new GuaranteeCommonDBDAOCheckDupCntrRSQL(), param, velParam);

			while (dbRowset.next()) {
				if (dbRowset.getInt("CNT") < 1) {
					isSuccess = true;
				} else {
					isSuccess = false;
					throw new DAOException(new ErrorHandler("TES00071", new String[] { guaranteeCommonVO.getCntrNo() }).getMessage());
					// throw new DAOException("\n [Container No. Dup] Container No. : " + guaranteeCommonVO.getCntrNo() + " exists already.");
				}
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}
		return isSuccess;
	}

	/**
	 * validateYardCode
	 * 
	 * @param tesGnteHdrVO
	 * @return String
	 * @throws DAOException
	 */
	public String validateYardCode(TesGnteHdrVO tesGnteHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		String sYdNm = "";

		try {
			if (!"".equals(tesGnteHdrVO.getYdCd())) {
				param.put("yd_cd", tesGnteHdrVO.getYdCd());
				velParam.put("yd_cd", tesGnteHdrVO.getYdCd());
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOValidateYardCodeRSQL(), param, velParam);

			if (dbRowset != null && dbRowset.next()) {
				sYdNm = dbRowset.getString("YD_NM");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return sYdNm;
	}

	/**
	 * validateYardCode
	 * 
	 * @param tesGnteHdrVO
	 * @return String
	 * @throws DAOException
	 */
	public String validateOfficeCode(TesGnteHdrVO tesGnteHdrVO) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnVal = null;
		Map<String, Object> param = new HashMap<String, Object>(); // query parameter
		Map<String, Object> velParam = new HashMap<String, Object>(); // velocity parameter

		try {
			if (!"".equals(tesGnteHdrVO.getDeptNo())) {
				param.put("cost_ofc_cd", tesGnteHdrVO.getDeptNo());
				velParam.put("cost_ofc_cd", tesGnteHdrVO.getDeptNo());
			}
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new TESCommonDBDAOValidateCostOFCRSQL(), param, velParam);

			if (dbRowset != null && dbRowset.next()) {
				rtnVal = dbRowset.getString("IS_EXISTING_OFC_CD");
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (DAOException de) {
			log.error(de.getMessage(), de);
			throw de;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(e.getMessage());
		}

		return rtnVal;
	}

}