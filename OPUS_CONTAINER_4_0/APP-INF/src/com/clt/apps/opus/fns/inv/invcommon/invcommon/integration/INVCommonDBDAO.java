/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : INVCommonDAO.java
*@FileTitle : INVCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.24
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.04.24 김세일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.fns.inv.invcommon.invcommon.integration;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceByBLNoVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.basic.INVCommonUtil;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ARCurrCdVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ARCustomerVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ChinaDailyExrateInputVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.CodeInputVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.CustExrateInputVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.ExrateDivisionVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.VVDCustomerVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.VVDExrateInputVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.syscommon.common.table.MdmChargeVO;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
import com.clt.syscommon.common.table.MdmCurrencyVO;
import com.clt.syscommon.common.table.PriRatUtVO;
 

/**
 * INVCommonDAO <br>
 * - INVCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author saeil kim
 * @see INVCommonUtil 참조
 * @since J2EE 1.4
 */
public class INVCommonDBDAO extends DBDAOSupport {

	
	 
	/**
	 * INVCommonDAO의 ScopeList에 해당되는 값을 불러온다.<br>
	 * 
	 * @return List<String>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<String> searchServiceScopeList() throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();
		String svcScpCd = "";

		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDAOSearchServiceScopeListRSQL(),  param, velParam);
			while (dbRowset.next()) {
				svcScpCd = dbRowset.getString("svc_scp_cd");
				
				list.add(svcScpCd);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * INVCommonDAO의 arOfcCd에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String ofcCd
	 * @param String pageType
	 * @return List<String>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public List<String> searchAROfficeList(String ofcCd, String pageType) throws DAOException {
		DBRowSet dbRowset = null;
		
		List list = new ArrayList();
		
		String arHdQtrOfcCd = "";
		String arOfcCd = "";
		String arAgnStlCd = "";
		String arOfcCdLogin = "";
		String arCurrCd = "";
		String arCtrlOfcCd = "";
		String locCd = "";
		String svrId = "";	 
		String xchRtRvsFlg = "";	 
		String dpPrcsKnt = "";
		String repCustCntCd = "";	 
		String repCustSeq = "";
		//String tmpOfcCd = "";
		String xchRtTpCd = "";
		String otsSmryCd = "";
		String invDupFlg = "";
		String invMltBlIssFlg = "";
		String invVatChgCd = "";
		String invVatChgRt = "";
		String cpyInvKnt = "";
		String xchRtN3rdTpCd = "";
		String altnCurrDivCd = "";

		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDAOsearchAROfficeListRSQL(),  param, velParam);
			while (dbRowset.next()) { 
				arHdQtrOfcCd = dbRowset.getString("ar_hd_qtr_ofc_cd");
				arOfcCd = dbRowset.getString("ar_ofc_cd");
				arAgnStlCd = dbRowset.getString("ar_agn_stl_cd");
				arOfcCdLogin = dbRowset.getString("ar_ofc_cd_login");
				arCurrCd = dbRowset.getString("ar_curr_cd");
				arCtrlOfcCd = dbRowset.getString("ar_ctrl_ofc_cd");
				locCd = dbRowset.getString("loc_cd");
				svrId = dbRowset.getString("svr_id");
				xchRtRvsFlg = dbRowset.getString("xch_rt_rvs_flg");
				dpPrcsKnt = dbRowset.getString("dp_prcs_knt");
				repCustCntCd = dbRowset.getString("rep_cust_cnt_cd");
				repCustSeq = dbRowset.getString("rep_cust_seq");
				xchRtTpCd = dbRowset.getString("xch_rt_tp_cd");
				otsSmryCd = dbRowset.getString("ots_smry_cd");
				invDupFlg = dbRowset.getString("inv_dup_flg");
				invMltBlIssFlg =dbRowset.getString("inv_mlt_bl_iss_flg");
				invVatChgCd = dbRowset.getString("inv_vat_chg_cd");
				invVatChgRt =dbRowset.getString("inv_vat_chg_rt");
				cpyInvKnt =dbRowset.getString("cpy_inv_knt");
				xchRtN3rdTpCd = dbRowset.getString("xch_rt_n3rd_tp_cd");
				altnCurrDivCd = dbRowset.getString("altn_curr_div_cd");
								
				//다른지역도 헤드쿼터및 OFFICE 를 다 볼수있도록 수정.
//				if (!arOfcCdLogin.equals(arHdQtrOfcCd) && arOfcCdLogin.equals(arOfcCd)
//						&& !svrId.equals("KOR") && !svrId.equals("USA") && !svrId.equals("JPN")) { 
//					tmpOfcCd = arOfcCd;		
//				}
			}
			
			dbRowset.beforeFirst();
			
			while (dbRowset.next()) { 
				arHdQtrOfcCd = dbRowset.getString("ar_hd_qtr_ofc_cd");
				arOfcCd = dbRowset.getString("ar_ofc_cd");
				arAgnStlCd = dbRowset.getString("ar_agn_stl_cd");
				arOfcCdLogin = dbRowset.getString("ar_ofc_cd_login");
				arCurrCd = dbRowset.getString("ar_curr_cd");
				arCtrlOfcCd = dbRowset.getString("ar_ctrl_ofc_cd");
				locCd = dbRowset.getString("loc_cd");
				svrId = dbRowset.getString("svr_id");
				xchRtRvsFlg = dbRowset.getString("xch_rt_rvs_flg");
				dpPrcsKnt = dbRowset.getString("dp_prcs_knt");
				repCustCntCd = dbRowset.getString("rep_cust_cnt_cd");
				repCustSeq = dbRowset.getString("rep_cust_seq");
				xchRtTpCd = dbRowset.getString("xch_rt_tp_cd");
				otsSmryCd = dbRowset.getString("ots_smry_cd");
				invDupFlg = dbRowset.getString("inv_dup_flg");
				invMltBlIssFlg =dbRowset.getString("inv_mlt_bl_iss_flg");
				invVatChgCd = dbRowset.getString("inv_vat_chg_cd");
				invVatChgRt =dbRowset.getString("inv_vat_chg_rt");
				cpyInvKnt =dbRowset.getString("cpy_inv_knt");
				xchRtN3rdTpCd = dbRowset.getString("xch_rt_n3rd_tp_cd");
				altnCurrDivCd = dbRowset.getString("altn_curr_div_cd");
				
//				if (pageType.equals("I")) {
					list.add(arHdQtrOfcCd+"^"+arOfcCd+"^"+arAgnStlCd+"^"+arOfcCdLogin+"^"+arCurrCd+"^"+arCtrlOfcCd+"^"+locCd+"^"+svrId+"^"+xchRtRvsFlg+"^"+dpPrcsKnt+"^"+repCustCntCd+"^"+repCustSeq+"^"+xchRtTpCd+"^"+otsSmryCd+"^"+invDupFlg+"^"+invMltBlIssFlg+"^"+invVatChgCd+"^"+invVatChgRt+"^"+cpyInvKnt+"^"+xchRtN3rdTpCd+"^"+altnCurrDivCd);
//				}
//				else {
//					if (!tmpOfcCd.equals("")) {
//						if (tmpOfcCd.equals(arOfcCd)) {
//							list.add(arHdQtrOfcCd+"^"+arOfcCd+"^"+arAgnStlCd+"^"+arOfcCdLogin+"^"+arCurrCd+"^"+arCtrlOfcCd+"^"+locCd+"^"+svrId+"^"+xchRtRvsFlg+"^"+dpPrcsKnt+"^"+repCustCntCd+"^"+repCustSeq+"^"+xchRtTpCd+"^"+otsSmryCd+"^"+invDupFlg+"^"+invMltBlIssFlg+"^"+invVatChgCd+"^"+invVatChgRt+"^"+cpyInvKnt+"^"+xchRtN3rdTpCd+"^"+altnCurrDivCd);
//						}
//					} else {
//						list.add(arHdQtrOfcCd+"^"+arOfcCd+"^"+arAgnStlCd+"^"+arOfcCdLogin+"^"+arCurrCd+"^"+arCtrlOfcCd+"^"+locCd+"^"+svrId+"^"+xchRtRvsFlg+"^"+dpPrcsKnt+"^"+repCustCntCd+"^"+repCustSeq+"^"+xchRtTpCd+"^"+otsSmryCd+"^"+invDupFlg+"^"+invMltBlIssFlg+"^"+invVatChgCd+"^"+invVatChgRt+"^"+cpyInvKnt+"^"+xchRtN3rdTpCd+"^"+altnCurrDivCd);
//					}
//				}	
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}

	/**
	 * INVCommonDAO의 AR Customer 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String cntryCd
	 * @param String custCd
	 * @param String custRgstNo
	 * @return ARCustomerVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	 public ARCustomerVO searchARCustomer(String cntryCd , String custCd, String custRgstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARCustomerVO> list = null;
		ARCustomerVO arCustomerVO = new ARCustomerVO();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cust_cnt_cd", cntryCd);
			mapVO.put("cust_seq", String.valueOf(custCd));
			mapVO.put("cust_rgst_no", custRgstNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDAOSearchARCustomerListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ARCustomerVO .class);
			if(list != null && list.size() > 0){
				arCustomerVO = (ARCustomerVO)list.get(0);
			} else{
				arCustomerVO = null;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arCustomerVO;
	 }   
	 
	 /**
	 * INVCommonDAO의 currency List에 해당되는 값을 불러온다.<br>
	 * 
	 * @return List<MdmCurrencyVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmCurrencyVO> searchCurrencyCodeList() throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOSearchCurrencyCodeListRSQL(),  null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCurrencyVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}			 
	 	 
	/**
	 * INVCommonDAO의 경리환율 해당되는 값을 불러온다.<br>
	 * 
	 * @param String fromCurrCd
	 * @param String toCurrCd
	 * @param String effDt
	 * @return String
	 * @exception DAOException
	 */
	public String searchAccountRate(String fromCurrCd,String toCurrCd,String effDt) throws DAOException {
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String usdLoclXchRt = "";
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("from_curr_cd", fromCurrCd);
			mapVO.put("to_curr_cd", toCurrCd);
			mapVO.put("eff_dt", effDt);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOSearchAccountRateRSQL(), param, velParam);	
	    	if(dbRowset.next()) {
	    		usdLoclXchRt = dbRowset.getString("usd_locl_xch_rt");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return usdLoclXchRt;
	}			 
		 	 
	/**
	 * INVCommonDAO의 currency List에 해당되는 값을 불러온다.<br>
	 * 
	 * @return List<MdmChargeVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmChargeVO> searchChargeCodeList() throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOSearchChargeCodeListRSQL(),  null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmChargeVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}			
	 
	/**
	 * INVCommonDAO의 currency List에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String ofcCd
	 * @return List<MdmChargeVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<MdmChargeVO> searchChargeCodeList(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try{
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOSearchOfcChargeCodeListRSQL(),  param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmChargeVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}			
		 
	/**
	 * INVCommonDAO의 Ex.Rage에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String invCntryCd
	 * @param String invCustCd
	 * @return ExrateDivisionVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")	 
	public ExrateDivisionVO searchCustomerExrateDivision(String invCntryCd, String invCustCd) throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();
		ExrateDivisionVO exrateDivisionVo = new ExrateDivisionVO();
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("inv_cntry_cd", invCntryCd);
			mapVO.put("inv_cust_cd", invCustCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOsearchCustomerExrateDivisionRSQL(),  param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, ExrateDivisionVO.class);
			if(list.size() > 0){
				exrateDivisionVo = (ExrateDivisionVO)list.get(0);
			} else{
				exrateDivisionVo = null;
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return exrateDivisionVo;
	}	
	 
	/**
	 * INVCommonDAO의 Ex.Rage에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchSetupOfficeForThirdExrateType(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String thirdExrateTtype = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOsearchSetupOfficeForThirdExrateTypeRSQL(),  param, velParam);
			while (dbRowset.next()) {
				 thirdExrateTtype = dbRowset.getString("third_exrate_type");
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return thirdExrateTtype;
	}	 
	
	/**
	 * INVCommonDAO의 Ex.Rage에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */ 
	public String searchSetupOfficeForExrateType(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String usdExrateTypeTemp = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOsearchSetupOfficeForExrateTypeRSQL(),  param, velParam);
			 while (dbRowset.next()) {
				 usdExrateTypeTemp = dbRowset.getString("usd_exrate_type");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return usdExrateTypeTemp;
	}	
	 
	/**
	 * INVCommonDAO의 Ex.Rage에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String cngIndivCd
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */	 
	public String searchBKGPortCd(String cngIndivCd, String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String portCd = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cng_indiv_cd", cngIndivCd);
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOsearchBKGPortCdRSQL(),  param, velParam);
			 while (dbRowset.next()) {
				 portCd = dbRowset.getString("port_cd");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return portCd;
	}	 
	 
	/**
	 * INVCommonDAO의 Ex.Rage에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String cngIndivCd
	 * @param String bkgNo
	 * @param String portCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchSailingArrivalDate(String cngIndivCd, String bkgNo, String portCd) throws DAOException {
		DBRowSet dbRowset = null;
		String exRateDate = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cng_indiv_cd", cngIndivCd);
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("port_cd", portCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOsearchSailingArrivalDateRSQL(),  param, velParam);
			 while (dbRowset.next()) {
				 exRateDate = dbRowset.getString("ex_rate_date");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return exRateDate;
	}	
	 
	/**
	 * INVCommonDAO의 Ex.Rage에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchBLOnDate(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		//List list = new ArrayList();
		String exRateDate = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOsearchBLOnDateRSQL(),  param, velParam);
			 while (dbRowset.next()) {
				 exRateDate = dbRowset.getString("ex_rate_date");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return exRateDate;
	}		
	
	/**
	 * INVCommonDAO의 Ex.Rage에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchCargoReceiveDate(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		//List list = new ArrayList();
		String exRateDate = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOsearchCargoReceiveDateRSQL(),  param, velParam);
			 while (dbRowset.next()) {
				 exRateDate = dbRowset.getString("ex_rate_date");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return exRateDate;
	}
	 
	/**
	 * INVCommonDAO의 Ex.Rage에 해당되는 값을 불러온다.<br>
	 * 
	 * @param CustExrateInputVO custExrateVo
	 * @return String
	 * @exception DAOException
	 */	  
	public String searchCustomerExrate(CustExrateInputVO custExrateVo) throws DAOException {
		DBRowSet dbRowset = null;
		String rExRate = "0";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(custExrateVo != null){
				Map<String, String> mapVO = custExrateVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOsearchCustomerExrateRSQL(),  param, velParam);
			while (dbRowset.next()) {
				rExRate = dbRowset.getString("ex_rate");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rExRate;
	}	 
	 
	/**
	 * INVCommonDAO의 Ex.Rage에 해당되는 값을 불러온다.<br>
	 * 
	 * @param VVDExrateInputVO vvdExrateVo
	 * @return String
	 * @exception DAOException
	 */
	 public String searchVVDExrate(VVDExrateInputVO vvdExrateVo) throws DAOException {
		DBRowSet dbRowset = null;
		String rExRate = "0";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vvdExrateVo != null){
				Map<String, String> mapVO = vvdExrateVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOsearchVVDExrateRSQL(),  param, velParam);
			while (dbRowset.next()) {
				rExRate = dbRowset.getString("ex_rate");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rExRate;
	}		 
	 
	/**
	 * INVCommonDAO의 Ex.Rage에 해당되는 값을 불러온다.<br>
	 * 
	 * @param VVDCustomerVO exRate
	 * @return String
	 * @exception DAOException
	 */
	public String searchAccountExrate(VVDCustomerVO exRate) throws DAOException {
		DBRowSet dbRowset = null;
		String rExRate = "0";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = exRate.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOsearchAccountExrateRSQL(),  param, velParam);
			 while (dbRowset.next()) {
				 rExRate = dbRowset.getString("ex_rate");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rExRate;
	}	
	 
	/**
	 * INVCommonDAO의 Ex.Rage에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchFixedExrate(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String rExRate = "0";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOsearchFixedExrateRSQL(),  param, velParam);
			 while (dbRowset.next()) {
				 rExRate = dbRowset.getString("ex_rate");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rExRate;
	}		 
	 
	/**
	 * INVCommonDAO의 Ex.Rage에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ChinaDailyExrateInputVO chinaDailyExrateVo
	 * @return String
	 * @exception DAOException
	 */
	public String searchChinaDailyExrate(ChinaDailyExrateInputVO chinaDailyExrateVo) throws DAOException {
		DBRowSet dbRowset = null;
		String rExRate = "0";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chinaDailyExrateVo != null){
				Map<String, String> mapVO = chinaDailyExrateVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOsearchChinaDailyExrateRSQL(),  param, velParam);
			while (dbRowset.next()) {
				rExRate = dbRowset.getString("ex_rate");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rExRate;
	}		 
	 
	/**
	 * INVCommonDAO의 S/A Date에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String vvd
	 * @param String port
	 * @param String bnd
	 * @return String
	 * @exception DAOException
	 */
	public String searchSADate(String vvd, String port, String bnd) throws DAOException {
		DBRowSet dbRowset = null;
		String saDate = "";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vvd", vvd);
			mapVO.put("port", port);
			mapVO.put("bnd", bnd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOsearchSADateRSQL(),  param, velParam);
			while (dbRowset.next()) {
				saDate = dbRowset.getString("sa_date");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return saDate;
	}		
	 
	/**
	 * (india) Freight and Charge List의 event에 대한 vsl_eng_nm 조회 이벤트 처리<br>
	 * @author Jung Hwi Taek
	 * @param String vvd
	 * @return String
	 * @exception DAOException
	 */
	 public String searchVesslName(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String vslEngNm = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vvd", vvd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOsearchVesslNameRSQL(), param, velParam);
			while(dbRowset.next()){
				vslEngNm = dbRowset.getString("vsl_eng_nm");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return vslEngNm;
	 }   
	 
	 /**
	 * Closing Status 테이블을 select <br>
	 * 해당 office 로  Closing Status 정보가 없을시 AR_HD_QTR_OFC_CD의 Closing Status 및 EffDt 를 적용한다.<br>
	 * 
	 * @param String ofcCd
	 * @param String sailingDt
	 * @return String
	 * @exception DAOException
	 */
	public String searchEffectiveDate ( String ofcCd , String sailingDt )throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String effDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();	 

		try{

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc", ofcCd);
			mapVO.put("sail_dt", sailingDt);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOSearchEffectiveDateVORSQL(), param, velParam);
			if(dbRowset.next()) {						
				effDt = dbRowset.getString("eff_dt");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return effDt;
	}
	
	/**
	 * BKG_VVD, VSK_VSL_PORT_SKD 테이블에서 select<br>
	 * 
	 * @param String bkgNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchSailingDate(String bkgNo) throws DAOException {
		DBRowSet dbRowset = null;
		String sailDt = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bkg_no", bkgNo);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOsearchSailingDateRSQL(), param, velParam);
			while(dbRowset.next()){
				sailDt = dbRowset.getString("vps_etd_dt");
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return sailDt;
	}	
	
	/**
	 * INV_AR_PRN_STUP 테이블에서 User 프린터명 select<br>
	 * 
	 * @param String ofcCd
	 * @param String userId
	 * @return String
	 * @exception DAOException
	 */
	public String searchARPrinterName(String ofcCd, String userId) throws DAOException {
		DBRowSet dbRowset = null;
		String invPrnDvcNm = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);
			mapVO.put("usr_id", userId);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOSearchARPrinterNameRSQL(), param, velParam);
			while(dbRowset.next()){
				invPrnDvcNm = dbRowset.getString("inv_prn_dvc_nm");
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return invPrnDvcNm;
	}	
	
	/**
	 * Lane을 조회한다.<br>
	 * 
	 * @param String lane
	 * @return String
	 * @exception DAOException
	 */
	public String searchSvcLaneCode(String lane) throws DAOException {
		DBRowSet dbRowset = null;
		String lanCd = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		try{
			param.put("lane", lane);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDAOSvcLaneCodeRSQL(), param, null);
			while(dbRowset.next()){
				lanCd = dbRowset.getString("lane");
            }
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return lanCd;
	}	
	
	/**
	 * INVCommonDAO의 per_tp_cd List에 해당되는 값을 불러온다.<br>
	 * 
	 * @return List<PriRatUtVO>
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public List<PriRatUtVO> searchPerTpCdList() throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();

		try{
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOsearchPerTpCdListRSQL(),  null, null);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PriRatUtVO.class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return list;
	}	
	
	/**
	 * Local Time의 Date를 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String ofcCd
	 * @return String
	 * @exception DAOException
	 */
	public String searchLocalTime(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String lclTime = "";
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("ofc_cd", ofcCd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOLocalTimeRSQL(), param, null);
			while (dbRowset.next()) {
				lclTime = dbRowset.getString("lcl_time");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return lclTime;
	}
	
	/**
	 * BL_NO로 BKG_NO를 BKG_BOOKING 에서 조회한다.<br>
	 * 
	 * @param String blSrcNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchBkgNoByBlNo(String blSrcNo) throws DAOException {
		DBRowSet dbRowset = null;
		String bkgNo = "";
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("bl_src_no", blSrcNo);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOsearchBkgNoByBlNoRSQL(), param, null);
			while (dbRowset.next()) {
				bkgNo = dbRowset.getString("bkg_no");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return bkgNo;
	}
	
	/**
	 * Container typesize의 desc를 가져온다..<br>
	 * 
	 * @param CodeInputVO inputVO
	 * @return MdmCntrTpSzVO
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public MdmCntrTpSzVO searchMdmCntrTpSz(CodeInputVO inputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<MdmCntrTpSzVO> list = null;
		MdmCntrTpSzVO returnVO = null;
		Map<String, Object> param = new HashMap<String, Object>();		
		try{
			if(inputVO != null){
				Map<String, String> mapVO = inputVO.getColumnValues();
				param.putAll(mapVO);				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOsearchMdmTpSzRSQL(),  param, null);
			
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmCntrTpSzVO.class);

			if (list != null && list.size() > 0) {
				returnVO = (MdmCntrTpSzVO) list.get(0);
			}
			
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return returnVO;
	}	

		/**
		 * Charge Code typesize의 desc를 가져온다..<br>
		 * 
		 * @param CodeInputVO inputVO
		 * @return MdmChargeVO
		 * @exception DAOException
		 */
		 @SuppressWarnings("unchecked")
		 
		public MdmChargeVO searchMdmCharge(CodeInputVO inputVO) throws DAOException {
			DBRowSet dbRowset = null;
			List<MdmChargeVO> list = null;
			MdmChargeVO returnVO = null;
			Map<String, Object> param = new HashMap<String, Object>();		
			try{
				if(inputVO != null){
					Map<String, String> mapVO = inputVO.getColumnValues();
					param.putAll(mapVO);				
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOsearchMdmChargeRSQL(),  param, null);
				
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, MdmChargeVO.class);

				if (list != null && list.size() > 0) {
					returnVO = (MdmChargeVO) list.get(0);
				}
				
			}catch(SQLException se){
				log.error(se.getMessage(),se);
				throw new DAOException(new ErrorHandler(se).getMessage(),se);
			}catch(Exception ex){
				log.error(ex.getMessage(),ex);
				throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
			}
			return returnVO;
		}	 
		 
	 	 
	/**
	 * INVCommonDAO의 가장 최근의 환율 데이터를 가져온다.<br>
	 * 
	 * @param String fromCurrCd
	 * @param String toCurrCd
	 * @param String arOfcCd
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchLatestRate(String fromCurrCd,String toCurrCd, String arOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		String[] rtnVal = {"",""};	

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("from_curr_cd", fromCurrCd);
			mapVO.put("to_curr_cd", toCurrCd);
			mapVO.put("ar_ofc_cd", arOfcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOSearchLatestRateRSQL(), param, velParam);	
	    	if(dbRowset.next()) {
	    		rtnVal[0] = dbRowset.getString("O_INV_XCH_RT");
	    		rtnVal[1] = dbRowset.getString("I_INV_XCH_RT");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnVal;
	}
	
	/**
	 * Search Office A/R Currency Code<br>
	 * 
	 * @param String ofcCd
	 * @return ARCurrCdVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ARCurrCdVO searchOfficeCurrency(String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARCurrCdVO> list = null;
		ARCurrCdVO arCurrCdVO = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", ofcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOSearchOfficeCurrencyRSQL(), param, velParam);	
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARCurrCdVO.class);

			if (list != null && list.size() > 0) {
				arCurrCdVO = (ARCurrCdVO) list.get(0);
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return arCurrCdVO;
	}	
	
	/**
	 * INVCommonDAO의 Ex.Rage에 해당되는 값을 불러온다.<br>
	 * 
	 * @param VVDExrateInputVO vvdExrateVo
	 * @return String
	 * @exception DAOException
	 */
	 public String searchVVDUSDExrate(VVDExrateInputVO vvdExrateVo) throws DAOException {
		DBRowSet dbRowset = null;
		String rExRate = "0";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(vvdExrateVo != null){
				Map<String, String> mapVO = vvdExrateVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOSearchVVDUSDExrateRSQL(),  param, velParam);
			while (dbRowset.next()) {
				rExRate = dbRowset.getString("ex_rate");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rExRate;
	}	
	 
	 /**
	 * INVCommonDAO의 Ex.Rage에 해당되는 값을 불러온다.<br>
	 * 
	 * @param CustExrateInputVO custExrateVo
	 * @return String
	 * @exception DAOException
	 */	  
	public String searchCustomerUSDExrate(CustExrateInputVO custExrateVo) throws DAOException {
		DBRowSet dbRowset = null;
		String rExRate = "0";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(custExrateVo != null){
				Map<String, String> mapVO = custExrateVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOSearchCustomerUSDExrateRSQL(),  param, velParam);
			while (dbRowset.next()) {
				rExRate = dbRowset.getString("ex_rate");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rExRate;
	}	
	
	/**
	 * INVCommonDAO의 Ex.Rage에 해당되는 값을 불러온다.<br>
	 * 
	 * @param ChinaDailyExrateInputVO chinaDailyExrateVo
	 * @return String
	 * @exception DAOException
	 */
	public String searchChinaDailyUSDExrate(ChinaDailyExrateInputVO chinaDailyExrateVo) throws DAOException {
		DBRowSet dbRowset = null;
		String rExRate = "0";
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(chinaDailyExrateVo != null){
				Map<String, String> mapVO = chinaDailyExrateVo.getColumnValues();
			
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}			
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOSearchChinaDailyUSDExrateRSQL(),  param, velParam);
			while (dbRowset.next()) {
				rExRate = dbRowset.getString("ex_rate");
			}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rExRate;
	}	
	
	 
	/**
	* VVD를 이용하여 VSL Eng Name을 가져온다.<br>
	* 
	* @param String vvd
	* @return String
	* @exception DAOException
	*/
	public String searchVslName(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
	
		String rtnVal = "";	
	
		try{
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vvd", vvd);
	
			param.putAll(mapVO);
			velParam.putAll(mapVO);
	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new INVCommonDBDAOSearchVslNameRSQL(), param, velParam);	
		   	if(dbRowset.next()) {
		   		rtnVal = dbRowset.getString("VSL_ENG_NM");	   		
		   	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rtnVal;
	}	
	
	
}