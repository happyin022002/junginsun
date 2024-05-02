/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AccountPayableCommonDBDAO.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 *
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.APBankAccountByOfficeCondVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.APBankAccountByOfficeVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.ApCSRNoListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.ApOfficeListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.ApPayBatchNameListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.ApSupplierRegisterListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.BankAccountInfoListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.BankAccountListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.BankAccountSupplierListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.BankBranchVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.BankNameListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.CardBrandListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.CenterListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.CreditCardListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.CreditCardMasterListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.FinanceOfficeListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.InterCompanyListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.InvoiceTypeListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PaymentMethodListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PopPayGroupListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PopPayInvoiceInfomationListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.RegionListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SourceListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SupplierBankAccountListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.TermsListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.UnsettledAccountListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.SapCommonVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.MdmCurrencyVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PopSupplierListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.PopAccountListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.CompanyListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.VVDListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.LocationListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.WorkPlacesListVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.TaxCodeVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.APVendorInfoVO;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.vo.InternalBankAcctVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * AccountPayableCommonDBDAO <br>
 * - AccountPayableCommon system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 
 * @see    AccountPayableCommonBCImpl 참조
 * @since J2EE 1.6
 */
@SuppressWarnings("serial")
public class AccountPayableCommonDBDAO extends DBDAOSupport {
	
	
	/**
	 * COMMON : searchOfcCdByUserId<br>
	 *
	 * @param String usr_id
	 * @param String ofc_cd
	 * @return String[]
	 * @exception DAOException
	 */
	public String[] searchOfcCdByUserId(String usr_id, String ofc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		String[] rtnValue = new String[3];
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("usr_id", usr_id);         	
        	velParam.put("usr_id", usr_id);
        	
        	param.put("ofc_cd", ofc_cd);         	
        	velParam.put("ofc_cd", ofc_cd);
        	
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchOfcCdByUserIdRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue[0] = dbRowset.getString("AP_OFC_CD");
				rtnValue[1] = dbRowset.getString("AR_CURR_CD");
				rtnValue[2] = dbRowset.getString("LOC_CD");
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
	 * COMMON : searchLocalTime <br>
	 *
	 * @param String usr_id
	 * @param String ofc_cd
	 * @return String
	 * @exception DAOException
	 */
	public String searchLocalTime(String usr_id, String ofc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			param.put("usr_id", usr_id);         	
        	velParam.put("usr_id", usr_id);
        	param.put("ofc_cd", ofc_cd);         	
        	velParam.put("ofc_cd", ofc_cd);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchLocalTimeRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("LCL_TIME");
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
	 * [STM_SAP_0010]
	 * searchExchangeRateCheck <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return List<SapCommonVO> 
	 * @exception DAOException
	*/	 
	public List<SapCommonVO> searchExchangeRateCheck(SapCommonVO sapCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		 List<SapCommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (sapCommonVO != null) {
				Map<String, String> mapVO = sapCommonVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchExchangeRateCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SapCommonVO.class);             
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
	 * searchGLDatePeriodCheck <br>
	 * 
	 * @param String gl_dt
	 * @param String ofc_cd
	 * @return String
	 * @exception DAOException
	*/
	 
	public String searchGLDatePeriodCheck(String gl_dt, String ofc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (gl_dt != null && ofc_cd != null ) {
				param.put("gl_dt", gl_dt);
				param.put("ofc_cd", ofc_cd);
				velParam.put("gl_dt", gl_dt);
				velParam.put("ofc_cd", ofc_cd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchGLDatePeriodCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("CHK_PRD");
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
	 * searchAPLineServiceLaneCheck <br>
	 * 
	 * @param String vvd
	 * @return String
	 * @exception DAOException
	*/	 
	public String searchAPLineServiceLaneCheck(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (vvd != null ) {
				param.put("vvd", vvd);
				velParam.put("vvd", vvd);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchAPInvLineServiceLaneInfoRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("SERVICE_LANE");
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
	 * searchGLDateAPPeriodCheck <br>
	 * 
	 * @param String gl_dt
	 * @return String
	 * @exception DAOException
	*/
	 
	public String searchGLDateAPPeriodCheck(String gl_dt) throws DAOException {
		DBRowSet dbRowset = null;
		String rtnValue = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (gl_dt != null  ) {
				param.put("gl_dt", gl_dt);
				velParam.put("gl_dt", gl_dt);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchGLDateAPPeriodCheckRSQL(), param, velParam);
			if(dbRowset.next()) {
				rtnValue = dbRowset.getString("CHK_PRD");
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
	 * COMMON : searchFunctionalCurrencyCode <br>
	 *
	 * @return List<SapCommonVO>
	 * @exception DAOException
	 */
	public List<SapCommonVO> searchFunctionalCurrencyCode() throws DAOException {
		DBRowSet dbRowset = null;
		List<SapCommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchFunctionalCurrencyCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SapCommonVO.class);         
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
	 * COMMON : searchCurrencyCode <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return List<MdmCurrencyVO> 
	 * @exception DAOException
	*/
	 
	public List<MdmCurrencyVO> searchCurrencyCode(SapCommonVO sapCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		 List<MdmCurrencyVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (sapCommonVO != null) {
				Map<String, String> mapVO = sapCommonVO.getColumnValues();
				param.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchCurrencyCodeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, MdmCurrencyVO.class);             
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
	 * [STM_SAP_0023]
	 * LocationListVO <br>
	 * 
	 * @param LocationListVO locationVO
	 * @return List<LocationListVO> 
	 * @exception DAOException
	*/	 
	public List<LocationListVO> searchPopLocationList(LocationListVO locationVO) throws DAOException {
		DBRowSet dbRowset = null;
		 List<LocationListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (locationVO != null) {
				Map<String, String> mapVO = locationVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopLocationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, LocationListVO.class);   

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
	 * [STM_SAP_0010] [STM_SAP_0240]
	 * searchTaxCodeList <br>
	 * 
	 * @param TaxCodeVO taxCodeVO
	 * @return List<TaxCodeVO> 
	 * @exception DAOException
	*/	 
	public List<TaxCodeVO> searchTaxCodeList(TaxCodeVO taxCodeVO) throws DAOException {
		DBRowSet dbRowset = null;
		 List<TaxCodeVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (taxCodeVO != null) {
				Map<String, String> mapVO = taxCodeVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchTaxCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TaxCodeVO.class);             
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
	 * [STM_SAP_0010]
	 * searchOffValiInfo 단건조회 <br>
	 * 
	 * @param String ofc_cd
	 * @param String securityFlag
	 * @param String usrId
	 * @param String login_ofc_cd
	 * @return SapCommonVO
	 * @exception DAOException
	*/	 
	public SapCommonVO searchOffValiInfo(String ofc_cd, String securityFlag, String usrId, String login_ofc_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SapCommonVO> list = null;
		SapCommonVO rtnVO  = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (ofc_cd != null) {
				param.put("ofc_cd", ofc_cd);	
				param.put("security_flag", securityFlag);
				param.put("login_ofc_cd", login_ofc_cd);
				param.put("usr_id", usrId);
				
				velParam.put("ofc_cd", ofc_cd);	
				velParam.put("security_flag", securityFlag);
				velParam.put("login_ofc_cd", login_ofc_cd);
				velParam.put("usr_id", usrId);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchOffValiInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SapCommonVO.class);     
			if(list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}	
	
	/**
	 * [STM_SAP_0021]
	 * searchInvoiceActivityPlaceCheck 단건조회 <br>
	 * 
	 * @param String activity_place
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	 
	public SapCommonVO searchInvoiceActivityPlaceCheck(String activity_place) throws DAOException {
		DBRowSet dbRowset = null;
		List<SapCommonVO> list = null;
		SapCommonVO rtnVO  = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (activity_place != null) {
				param.put("activity_place", activity_place);	
				velParam.put("activity_place", activity_place);	
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchInvoiceActivityPlaceCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SapCommonVO.class);     
			if(list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}	
	
	/**
	 * [STM_SAP_0021]
	 * searchInvoiceServiceLaneCheck 단건조회 <br>
	 * 
	 * @param String service_lane_cd
	 * @return SapCommonVO
	 * @exception DAOException
	*/	 
	public SapCommonVO searchInvoiceServiceLaneCheck(String service_lane_cd) throws DAOException {
		DBRowSet dbRowset = null;
		List<SapCommonVO> list = null;
		SapCommonVO rtnVO  = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (service_lane_cd != null) {
				param.put("service_lane_cd", service_lane_cd);	
				velParam.put("service_lane_cd", service_lane_cd);	
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchInvoiceServiceLaneCheckRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SapCommonVO.class);     
			if(list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}	
	
	/**
	 * [STM_SAP_0010]
	 * searchSupplierInfo 단건조회 <br>
	 * 
	 * @param String vndr_seq
	 * @param String vndr_lgl_eng_nm
	 * @param String delt_flg
	 * @return SapCommonVO
	 * @exception DAOException
	*/
	 
	public SapCommonVO searchSupplierInfo(String vndr_seq, String vndr_lgl_eng_nm, String delt_flg) throws DAOException {
		DBRowSet dbRowset = null;
		List<SapCommonVO> list = null;
		SapCommonVO rtnVO  = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (vndr_seq != null) {
				param.put("vndr_seq", vndr_seq);	
				velParam.put("vndr_seq", vndr_seq);	
				
				param.put("vndr_lgl_eng_nm", vndr_lgl_eng_nm);	
				velParam.put("vndr_lgl_eng_nm", vndr_lgl_eng_nm);	
				
				param.put("delt_flg", delt_flg);	
				velParam.put("delt_flg", delt_flg);	

			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchSupplierInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SapCommonVO.class);     
			if(list.size() > 0) {
				rtnVO = list.get(0);
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return rtnVO;
	}		
	
    /**
     * 조건을 기준으로 등록되어 있는 은행계좌 정보에서 해당하는 계좌 내역을 조회 처리<br>
     * 
     * @param String bank_acct_nm
     * @param String bank_acct_no
     * @param String ofc_cd
     * @return List<BankAccountInfoListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<BankAccountInfoListVO> searchBankAccountCheck(String bank_acct_nm, String bank_acct_no, String ofc_cd) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<BankAccountInfoListVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
			param.put("bank_acct_nm", bank_acct_nm);
			velParam.put("bank_acct_nm", bank_acct_nm);
			
			param.put("bank_acct_no", bank_acct_no);
			velParam.put("bank_acct_no", bank_acct_no);
			
			param.put("ofc_cd", ofc_cd);
			velParam.put("ofc_cd", ofc_cd);
			
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchBankAccountCheckRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, BankAccountInfoListVO.class);             
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
     * [STM_SAP_0350] searchAPVendorInfoList <br>
     * 
     * @param String vndr_no
     * @param String vndr_nm
     * @return List<APVendorInfoVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<APVendorInfoVO> searchAPVendorInfoList(String vndr_no, String vndr_nm) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<APVendorInfoVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
			param.put("vndr_no", vndr_no);
			velParam.put("vndr_no", vndr_no);
			
			param.put("vndr_nm", vndr_nm);
			velParam.put("vndr_nm", vndr_nm);
			
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchAPVendorInfoListRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, APVendorInfoVO.class);             
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
	 * [STM_SAP_0350] addAPVendorInfo <br>
	 * 
	 * @param List<APVendorInfoVO> aPVendorInfoVOs
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void addAPVendorInfo(List<APVendorInfoVO> aPVendorInfoVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (aPVendorInfoVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableCommonDBDAOAddAPVendorInfoCSQL(), aPVendorInfoVOs, null);
				for (int i=0; i<insCnt.length; i++) {
					if (insCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	   
    
	/**
	 * [STM_SAP_0350] modifyAPVendorInfo <br>
	 * 
	 * @param List<APVendorInfoVO> aPVendorInfoVOs
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void modifyAPVendorInfo(List<APVendorInfoVO> aPVendorInfoVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int modCnt[] = null;
			if (aPVendorInfoVOs.size() > 0) {
				modCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableCommonDBDAOModifyAPVendorInfoUSQL(), aPVendorInfoVOs, null);
				for (int i=0; i<modCnt.length; i++) {
					if (modCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	
	 
	/**
	 * [STM_SAP_0350] removeAPVendorInfo <br>
	 * 
	 * @param List<APVendorInfoVO> aPVendorInfoVOs
	 * @exception DAOException
	 */
	 @SuppressWarnings("unchecked")
	public void removeAPVendorInfo(List<APVendorInfoVO> aPVendorInfoVOs) throws DAOException {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (aPVendorInfoVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate)new AccountPayableCommonDBDAORemoveAPVendorInfoDSQL(), aPVendorInfoVOs, null);
				for (int i=0; i<delCnt.length; i++) {
					if (delCnt[i]== Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No"+ i + " SQL");
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}	 
    
	/**
	 * [STM_SAP_0100]
	 * Bank Account Inquiry <br>
	 * 
	 * @param  APBankAccountByOfficeCondVO apBankAccountByOfficeCondVO
	 * @return List<APBankAccountByOfficeVO>
	 * @exception DAOException
	*/
	@SuppressWarnings("unchecked") 
	public List<APBankAccountByOfficeVO> searchBankAccountByOffice(APBankAccountByOfficeCondVO apBankAccountByOfficeCondVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<APBankAccountByOfficeVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (apBankAccountByOfficeCondVO != null) {
				Map<String, String> mapVO = apBankAccountByOfficeCondVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchBankAccountByOfficeRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, APBankAccountByOfficeVO.class);  
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
     * [STM_SAP_0032]
	 * Supplier Bank Account Popup<br>
	 * 
	 * @param String vendorCode
	 * @param String invoiceCurrency
	 * @param String bankAcctTpNm
	 * @param String callFlag
	 * @param String vendorName
	 * @return List<SupplierBankAccountListVO>
	 * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SupplierBankAccountListVO> searchPopSupplierBankAccountList(String vendorCode, String invoiceCurrency, String bankAcctTpNm, String callFlag, String vendorName) throws DAOException { 
        
    	DBRowSet dbRowset = null;
        List<SupplierBankAccountListVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
        	
             param.put("vndr_seq", vendorCode);
             velParam.put("vndr_seq", vendorCode);
             param.put("curr_cd", invoiceCurrency);
             velParam.put("curr_cd", invoiceCurrency);
             param.put("bank_acct_tp_nm", bankAcctTpNm);
             velParam.put("bank_acct_tp_nm", bankAcctTpNm);
             param.put("call_flag", callFlag);
             velParam.put("call_flag", callFlag);
             param.put("vndr_lgl_eng_nm", vendorName);
             velParam.put("vndr_lgl_eng_nm", vendorName);
   
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopSupplierBankAccountListRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, SupplierBankAccountListVO.class);             
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
	 * [STM_SAP_0310]
	 * Create Credit Card - Retrieve<br>
	 * 
	 * @param String crdSeq
	 * @param String crdNo
	 * @return List<CreditCardMasterListVO>
	 * @exception DAOException
	*/
    @SuppressWarnings("unchecked")
    public List<CreditCardMasterListVO> searchCreditCardMasterList(String crdSeq, String crdNo) throws DAOException { 
     
    	DBRowSet dbRowset = null;
    	List<CreditCardMasterListVO> list = null;
     
    	//query parameter
    	Map<String, Object> param = new HashMap<String, Object>();
    	//velocity parameter
    	Map<String, Object> velParam = new HashMap<String, Object>();

    	try {	
    		
    		param.put("crd_seq", crdSeq);
    		velParam.put("crd_seq", crdSeq);
    		param.put("crd_no", crdNo);
    		velParam.put("crd_no", crdNo);

    		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchCreditCardMasterListRSQL(), param, velParam);
    		list = (List)RowSetUtil.rowSetToVOs(dbRowset, CreditCardMasterListVO.class);             
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
   	 * [STM_SAP_0310]
   	 * Create Credit Card - Sequence Nextval<br>
   	 * 
   	 * @return String 
   	 * @exception DAOException
   	*/
   	@SuppressWarnings("unchecked")
   	public String searchCreditCardMaxSeq() throws DAOException {
   	
   		DBRowSet dbRowset = null;
   		String rtnValue = null;
   		
   	    // query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        // velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
       	
   		
   		try {
   			
           	// velocity parameter 설정 
            velParam.putAll(param);
               
   			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountPayableCommonDBDAOSearchCreditCardMaxSeqRSQL(),param, velParam);
   			if (dbRowset.next()) {
   				rtnValue= dbRowset.getString("crd_seq");
            }
   			return rtnValue;
   			
   		} catch(SQLException se){
   			log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex){
           	log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
   	} 	
     
    /**
   	 * [STM_SAP_0310]
   	 * Create Credit Card - check card no for duplicating<br>
   	 * 
   	 * @param  String crdNo
   	 * @return int 
   	 * @exception DAOException
   	*/
    @SuppressWarnings("unchecked")
    public int searchCreditCardDuplicateCheck(String crdNo) throws DAOException {
    
    	DBRowSet dbRowset = null;
     	int crdNoCnt = 0;
     		
     	//query parameter
     	Map<String, Object> param = new HashMap<String, Object>();
     	//velocity parameter
     	Map<String, Object> velParam = new HashMap<String, Object>();

     	try{
     		param.put("crd_no", crdNo);
     		velParam.put("crd_no", crdNo);	 
     		
     		dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchCreditCardDuplicateCheckRSQL(), param, velParam);
     	    	
     		if(dbRowset.next()){
     			crdNoCnt = dbRowset.getInt("cnt");
     		}
     			
     	}catch(SQLException se){
     		log.error(se.getMessage(),se);
     	    throw new DAOException(new ErrorHandler(se).getMessage());
     	}catch(Exception ex){
     	   	log.error(ex.getMessage(),ex);
     	   	throw new DAOException(new ErrorHandler(ex).getMessage());
     	}
     	
     	return crdNoCnt;
    } 
       
    /**
   	 * [STM_SAP_0310]
   	 * Create Credit Card - Save(Insert)<br>
   	 * 
   	 * @param  CreditCardMasterListVO creditCardMasterListVO
   	 * @exception DAOException
   	*/
    public void addCreditCardEntryInfo(CreditCardMasterListVO creditCardMasterListVO) throws DAOException {
    	
   		//query parameter
   		Map<String, Object> param = new HashMap<String, Object>();
   		//velocity parameter
   		Map<String, Object> velParam = new HashMap<String, Object>();
   		
   		int result = 0;

   		try{
   			if (creditCardMasterListVO != null) {
   				
   				Map<String, String> mapVO= creditCardMasterListVO.getColumnValues();

   				param.putAll(mapVO);
   				velParam.putAll(mapVO);
   			}
   			
   			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new AccountPayableCommonDBDAOAddCreditCardEntryInfoCSQL(), param, velParam);
   			
   			if(result == Statement.EXECUTE_FAILED)
   				throw new DAOException("Fail to insert SQL");
   		}catch (SQLException se) {
   			log.error(se.getMessage(), se);
   			throw new DAOException(new ErrorHandler(se).getMessage());
   		}catch(Exception ex) {
   			log.error(ex.getMessage(), ex);
   			throw new DAOException(new ErrorHandler(ex).getMessage());
   		}
   	}
   	
   	/**
   	 * [STM_SAP_0310]
   	 * Create Credit Card - Save(Update)<br>
   	 * 
   	 * @param  CreditCardMasterListVO creditCardMasterListVO
   	 * @exception DAOException
   	*/
   	@SuppressWarnings("unchecked")
   	public void modifyCreditCardEntryInfo(CreditCardMasterListVO creditCardMasterListVO) throws DAOException {
   		//query parameter
   		Map<String, Object> param = new HashMap<String, Object>();
   		//velocity parameter
   		Map<String, Object> velParam = new HashMap<String, Object>();
   		
   		int result = 0;

   		try{
   			if (creditCardMasterListVO != null) {
   				
   				Map<String, String> mapVO= creditCardMasterListVO.getColumnValues();

   				param.putAll(mapVO);
   				velParam.putAll(mapVO);
   			}
   			
   			result = new SQLExecuter("").executeUpdate((ISQLTemplate)new AccountPayableCommonDBDAOModifyCreditCardEntryInfoUSQL(), param, velParam);
   			if(result == Statement.EXECUTE_FAILED)
   				 throw new DAOException("Fail to update SQL");
   			
   		} catch (SQLException se) {
   			log.error(se.getMessage(), se);
   			throw new DAOException(new ErrorHandler(se).getMessage());
   		} catch(Exception ex) {
   			log.error(ex.getMessage(), ex);
   			throw new DAOException(new ErrorHandler(ex).getMessage());
   		}
   	}
    
	/**
    * [STM_SAP_0500]
	 * Finance Office Code Popup<br>
	 * 
	 * @param String ofcTp
	 * @param String ofcCd
	 * @return List<FinanceOfficeListVO>
	 * @exception DAOException
    */
   @SuppressWarnings("unchecked")
   public List<FinanceOfficeListVO> searchPopFinanceOfficeList(String ofcTp, String ofcCd) throws DAOException { 
       
   	DBRowSet dbRowset = null;
       List<FinanceOfficeListVO> list = null;
       
       //query parameter
       Map<String, Object> param = new HashMap<String, Object>();
       
       //velocity parameter
       Map<String, Object> velParam = new HashMap<String, Object>();

       try {	
       	
            param.put("ofc_type", ofcTp);
            velParam.put("ofc_type", ofcTp);
            param.put("ofc_code", ofcCd);
            velParam.put("ofc_code", ofcCd);
  
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopFinanceOfficeListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, FinanceOfficeListVO.class);             
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
    * [STM_SAP_0510]
	 * Internal Bank Account Popup<br>
	 * 
	 * @param String ofc_cd
	 * @param String ofc_type
	 * @param String inactive_type
	 * @param String bank_acct_no
	 * @return List<InternalBankAcctVO>
	 * @exception DAOException
    */
   @SuppressWarnings("unchecked")
   public List<InternalBankAcctVO> searchPopInternalBankAcctList(String ofc_cd, String ofc_type, String inactive_type, String bank_acct_no) throws DAOException { 
       
   	DBRowSet dbRowset = null;
       List<InternalBankAcctVO> list = null;
       
       Map<String, Object> mapVO 		= new HashMap<String, Object>();
   	   Map<String, Object> param 		= new HashMap<String, Object>();
   	   //velocity parameter
   	   Map<String, Object> velParam 	= new HashMap<String, Object>();
   	
       try {	
            
            mapVO.put("ofc_cd", 		ofc_cd);
    		mapVO.put("ofc_type", 		ofc_type);
    		mapVO.put("inactive_type", 	inactive_type);
    		mapVO.put("bank_acct_no",   bank_acct_no);
    		
    		param.putAll(mapVO);
    		velParam.putAll(mapVO);
    		
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopInternalBankAcctListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, InternalBankAcctVO.class);             
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
     * Card Brand Popup 내역 조회<br>
     * 
     * @param String lu_cd     
     * @return List<CardBrandListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<CardBrandListVO> searchPopCardBrandList(String lu_cd) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<CardBrandListVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
        	
        	param.put("lu_cd", lu_cd);
         	
         	velParam.put("lu_cd", lu_cd);
             
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOsearchPopCardBrandListRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, CardBrandListVO.class);             
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
	 * [STM_SAP_0003]
     * CSR NO LIST 조회<br>
     * 
     * @param ApCSRNoListVO apCSRNoListVO
     * @return List<ApCSRNoListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ApCSRNoListVO> searchPopCSRNoList(ApCSRNoListVO apCSRNoListVO) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ApCSRNoListVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
			if (apCSRNoListVO != null) {
				Map<String, String> mapVO = apCSRNoListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
	         dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOsearchPopCSRNoListRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApCSRNoListVO.class);             
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
     * Unsettled Summary 에 존재하는 월별 미결 내역 조회<br>
     * 
     * @param String VendorName 
     * @return List<PopSupplierListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PopSupplierListVO> searchPopSupplierList(String VendorName) throws DAOException { 
        DBRowSet dbRowset = null;
        
        List<PopSupplierListVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
        	
             param.put("vndr_lgl_eng_nm", VendorName);            
             
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopSupplierListRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, PopSupplierListVO.class);             
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
     * 조건을 기준으로 Lookup에 등록된 Source 정보 조회<br>
     * 
     * @param String luDesc    
     * @return List<SourceListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<SourceListVO> searchPopSourceList(String luDesc) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<SourceListVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
        	if(!luDesc.equals("")) {
    			param.put("lu_cd", luDesc);
    			velParam.put("lu_cd", luDesc);
    		}
            
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopSourceListRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, SourceListVO.class);             
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
     * 조건을 기준으로 Lookup에 등록된 SupplierRegister 정보 조회<br>
     * 
     * @param String registerNo     
     * @return List<ApSupplierRegisterListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ApSupplierRegisterListVO> searchPopSupplierRegisterList(String registerNo) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ApSupplierRegisterListVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
        	if(!registerNo.equals("")) {
    			param.put("rgst_no", registerNo);
    			velParam.put("rgst_no", registerNo);
    		}
            
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopSupplierRegisterListRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApSupplierRegisterListVO.class);             
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
    * [STM_SAP_0009]
	* INVOICE TYPE LIST 조회<br>
	* 
	* @param InvoiceTypeListVO invoiceTypeListVO
	* @return List<InvoiceTypeListVO>
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<InvoiceTypeListVO> searchPopInvoiceTypeList(InvoiceTypeListVO invoiceTypeListVO) throws DAOException {
	  DBRowSet dbRowset = null;
	  
	  List<InvoiceTypeListVO> list = null;
	  
	  //query parameter
	  Map<String, Object> param = new HashMap<String, Object>();
	  
	  //velocity parameter
	  Map<String, Object> velParam = new HashMap<String, Object>();
	
	  try {	
				if (invoiceTypeListVO != null) {
					Map<String, String> mapVO = invoiceTypeListVO.getColumnValues();
	
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
		         dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOsearchPopInvoiceTypeListRSQL(), param, velParam);
	       list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceTypeListVO.class);             
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
	* [STM_SAP_0033]
	* TERMS LIST 조회<br>
	* 
	* @param TermsListVO termsListVO
	* @return List<TermsListVO>
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<TermsListVO> searchPopTermsList(TermsListVO termsListVO) throws DAOException {
	DBRowSet dbRowset = null;
	
	List<TermsListVO> list = null;
	
	//query parameter
	Map<String, Object> param = new HashMap<String, Object>();
	
	//velocity parameter
	Map<String, Object> velParam = new HashMap<String, Object>();
	
	try {	
			if (termsListVO != null) {
				Map<String, String> mapVO = termsListVO.getColumnValues();
	
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
	       dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOsearchPopTermsListRSQL(), param, velParam);
	    list = (List)RowSetUtil.rowSetToVOs(dbRowset, TermsListVO.class);             
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
	* [STM_SAP_0440]
	* CENTER LIST 조회<br>
	* 
	* @param CenterListVO centerListVO
	* @return List<CenterListVO>
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<CenterListVO> searchPopCenterList(CenterListVO centerListVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<CenterListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {	
				if (centerListVO != null) {
					Map<String, String> mapVO = centerListVO.getColumnValues();
		
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
		       dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOsearchPopCenterListRSQL(), param, velParam);
		    list = (List)RowSetUtil.rowSetToVOs(dbRowset, CenterListVO.class);             
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
	* [STM_SAP_0460]
	* Inter Company LIST 조회<br>
	* 
	* @param InterCompanyListVO interCompanyListVO
	* @return List<InterCompanyListVO>
	* @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public List<InterCompanyListVO> searchPopInterCompanyList(InterCompanyListVO interCompanyListVO) throws DAOException {
		DBRowSet dbRowset = null;
		
		List<InterCompanyListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {	
				if (interCompanyListVO != null) {
					Map<String, String> mapVO = interCompanyListVO.getColumnValues();
		
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
		       dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOsearchPopInterCompanyListRSQL(), param, velParam);
		    list = (List)RowSetUtil.rowSetToVOs(dbRowset, InterCompanyListVO.class);             
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
     * AP Office Code Popup <br>
     * 
     * @param String ofcCd
     * @param String securityFlag
     * @param String usrId
     * @param String login_ofc_cd  
     * @return List<ApOfficeListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ApOfficeListVO> searchPopAPOfficeList(String ofcCd, String securityFlag, String usrId, String login_ofc_cd) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ApOfficeListVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
        	
          	param.put("ofc_cd", ofcCd);     
          	param.put("security_flag", securityFlag);
          	param.put("login_ofc_cd", login_ofc_cd);
          	param.put("usr_id", usrId);
         	
         	velParam.put("ofc_cd", ofcCd);  
         	velParam.put("security_flag", securityFlag);
         	velParam.put("login_ofc_cd", login_ofc_cd);
         	velParam.put("usr_id", usrId);
         	 
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopAPOfficeListRSQL(), param, velParam); 
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApOfficeListVO.class);             
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
     * AR Office Code Popup <br>
     * 
     * @param String ofcCd
     * @param String securityFlag
     * @param String usrId  
     * @return List<ApOfficeListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ApOfficeListVO> searchPopAROfficeList(String ofcCd, String securityFlag, String usrId) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ApOfficeListVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
        	
          	param.put("ofc_cd", ofcCd);     
          	param.put("security_flag", securityFlag);
          	param.put("usr_id", usrId);
         	
         	velParam.put("ofc_cd", ofcCd);  
         	velParam.put("security_flag", securityFlag);
         	velParam.put("usr_id", usrId);
         	 
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopAROfficeListRSQL(), param, velParam); 
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApOfficeListVO.class);             
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
     * Payment Method Popup <br>
     * 
     * @param String luCd      
     * @return List<PaymentMethodListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PaymentMethodListVO> searchPopPaymentMethodList(String luCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<PaymentMethodListVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
        	
          	 param.put("lu_cd", luCd);    
         	
         	 velParam.put("lu_cd", luCd);  
         	 
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopPaymentMethodListRSQL(), param, velParam);                                                                     
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, PaymentMethodListVO.class);             
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
     * Bank Name Popup <br>
     * 
     * @param String bankNm   
     * @return List<BankNameListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<BankNameListVO> searchPopBankNameList(String bankNm) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<BankNameListVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
        	
          	 param.put("bank_nm", bankNm);     
         	
         	 velParam.put("bank_nm", bankNm);  
         	 
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopBankNameListRSQL(), param, velParam); 
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, BankNameListVO.class);             
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
     * Unsettled Account Popup <br>
     * 
     * @param String luCd    
     * @return List<UnsettledAccountListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<UnsettledAccountListVO> searchPopUnsettledAccountList(String luCd) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<UnsettledAccountListVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
        	
          	 param.put("lu_cd", luCd);     
         	
         	 velParam.put("lu_cd", luCd);  
         	 
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopUnsettledAccountListRSQL(), param, velParam); 
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, UnsettledAccountListVO.class);   
             
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
     * Credit Card Search Popup <br>
     * 
     * @param CreditCardListVO creditCardlistVO
     * @return List<CreditCardListVO>
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
	public List<CreditCardListVO> searchCreditCardList(CreditCardListVO creditCardlistVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<CreditCardListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (creditCardlistVO != null) {
				Map<String, String> mapVO= creditCardlistVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchCreditCardListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CreditCardListVO.class);
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
     * Pay Group Popup - Retrieve <br>	
     * 	
     * @param String luCd
     * @param String attr_ctnt1 	
     * @return List<PopPayGroupListVO>	
     * @exception DAOException	
     */    	
    @SuppressWarnings("unchecked")	
    public List<PopPayGroupListVO> searchPopPayGroupList(String luCd, String attr_ctnt1) throws DAOException {	
        DBRowSet dbRowset = null;	
        	
        List<PopPayGroupListVO> list = null;	
        	
        //query parameter	
        Map<String, Object> param = new HashMap<String, Object>();	
        	
        //velocity parameter	
        Map<String, Object> velParam = new HashMap<String, Object>();	
	
        try {	
        	
             param.put("lu_cd", luCd);	
         	
         	 velParam.put("lu_cd", luCd);
             	
         	 param.put("attr_ctnt1", attr_ctnt1);	
         	
         	 velParam.put("attr_ctnt1", attr_ctnt1);
         	 
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopPayGroupListRSQL(), param, velParam);	
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, PopPayGroupListVO.class);             	
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
     * WorkPlaces Popup - Retrieve <br>	
     * 	
     * @param String luCd  	 	
     * @return List<WorkPlacesListVO>	
     * @exception DAOException	
     */    	
    @SuppressWarnings("unchecked")	
    public List<WorkPlacesListVO> searchPopWorkPlacesList(String luCd) throws DAOException {	
        DBRowSet dbRowset = null;	
        	
        List<WorkPlacesListVO> list = null;	
        	
        //query parameter	
        Map<String, Object> param = new HashMap<String, Object>();	
        	
        //velocity parameter	
        Map<String, Object> velParam = new HashMap<String, Object>();	
	
        try {	
        	
             param.put("lu_cd", luCd);	
         	
         	 velParam.put("lu_cd", luCd);
             
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopWorkPlacesListRSQL(), param, velParam);	
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, WorkPlacesListVO.class);             	
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
     * Region Popup - Retrieve <br>	
     * 	
     * @param String luCd  	 	
     * @return List<RegionListVO>	
     * @exception DAOException	
     */    	
    @SuppressWarnings("unchecked")	
    public List<RegionListVO> searchPopRegionList(String luCd) throws DAOException {	
        DBRowSet dbRowset = null;	
        	
        List<RegionListVO> list = null;	
        	
        //query parameter	
        Map<String, Object> param = new HashMap<String, Object>();	
        	
        //velocity parameter	
        Map<String, Object> velParam = new HashMap<String, Object>();	
	
        try {	
        	
             param.put("lu_cd", luCd);	
         	
         	 velParam.put("lu_cd", luCd);
             
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopRegionListRSQL(), param, velParam);	
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, RegionListVO.class);             	
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
     * 조건을 기준으로 등록되어 있는 Payment Batch Name 정보 조회, 일괄 지불한 내역 파악<br>
     * 
     * @param String payBatNm
     * @param String payFromDate
     * @param String payToDate   
     * @return List<ApPayBatchNameListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<ApPayBatchNameListVO> searchPopPayBatchNameList(String payBatNm, String payFromDate, String payToDate) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<ApPayBatchNameListVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
			param.put("pay_bat_nm", payBatNm);
			velParam.put("pay_bat_nm", payBatNm);
			param.put("sdate", payFromDate);
			velParam.put("sdate", payFromDate);
			param.put("edate", payToDate);
			velParam.put("edate", payToDate);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopPayBatchNameListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, ApPayBatchNameListVO.class);             
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
     * Supplier Code Popup<br>
     * 
     * @param String vendorName
     * @param String vendorCode
     * @param String enableFlag     
     * @return List<PopSupplierListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<PopSupplierListVO> searchPopSupplierList(String vendorName,	String vendorCode, String enableFlag) throws DAOException { 
        DBRowSet dbRowset = null;
        
        List<PopSupplierListVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
        	
             param.put("vndr_lgl_eng_nm", vendorName);
             velParam.put("vndr_lgl_eng_nm", vendorName);
             param.put("vndr_seq", vendorCode);
             velParam.put("vndr_seq", vendorCode);
             param.put("delt_flg", enableFlag);
             velParam.put("delt_flg", enableFlag);
             
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopSupplierListRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, PopSupplierListVO.class);             
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
     * Company Popup<br>
     * 
     * @param String companyCode
     * @return List<CompanyListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<CompanyListVO> searchPopCompanyList(String companyCode) throws DAOException { 
        DBRowSet dbRowset = null;
        
        List<CompanyListVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
        	
             param.put("lu_cd", companyCode);
             velParam.put("lu_cd", companyCode);

             
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopCompanyListRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, CompanyListVO.class);             
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
     * Account Popup<br>
     * 
     * @param String accountCode
     * @param String accountType
     * @param String unsettledFlag
     * @param String lineType
     * @param String acctNm  
     * @return List<PopAccountListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")           
    public List<PopAccountListVO> searchPopAccountList(String accountCode, String accountType, String unsettledFlag, String lineType, String acctNm) throws DAOException { 
        DBRowSet dbRowset = null;
        
        List<PopAccountListVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	

             param.put("acct_cd", accountCode);
             param.put("acctg_mng_tp_cd", accountType);
             param.put("pnd_tgt_flg", unsettledFlag);
             param.put("line_type", lineType);
             param.put("acct_eng_nm", acctNm);

             velParam.put("acct_cd", accountCode);
             velParam.put("acctg_mng_tp_cd", accountType);
             velParam.put("pnd_tgt_flg", unsettledFlag);
             velParam.put("line_type", lineType);
             velParam.put("acct_eng_nm", acctNm);
   
             dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopAccountListRSQL(), param, velParam);
             list = (List)RowSetUtil.rowSetToVOs(dbRowset, PopAccountListVO.class);             
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
     * 조건을 기준으로 재무 항차에 등록된 VVD 정보 조회<br>
     * 
     * @param String vvd_cd  
     * @param String vvd_type  
     * @param String acct_cd  
     * @return List<VVDListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<VVDListVO> searchPopVVDList(String vvd_cd, String vvd_type, String acct_cd) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<VVDListVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
			param.put("vvd_cd", vvd_cd);
			velParam.put("vvd_cd", vvd_cd);
			param.put("vvd_type", vvd_type);
			velParam.put("vvd_type", vvd_type);
			param.put("acct_cd", acct_cd);
			velParam.put("acct_cd", acct_cd);
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopVVDListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, VVDListVO.class);             
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
     * 조건을 기준으로 등록되어 있는 은행계좌 정보에서 해당하는 계좌 내역을 조회 처리<br>
     * 
     * @param String bank_acct_nm
     * @param String bank_acct_no
     * @param String ofc_cd
     * @param String bank_acct_tp_nm
     * @param String acct_tp_cd
     * @return List<BankAccountInfoListVO>
     * @exception DAOException
     */
    @SuppressWarnings("unchecked")
    public List<BankAccountInfoListVO> searchPopBankAccountInfoList(String bank_acct_nm, String bank_acct_no, String ofc_cd, String bank_acct_tp_nm, String acct_tp_cd) throws DAOException {
        DBRowSet dbRowset = null;
        
        List<BankAccountInfoListVO> list = null;
        
        //query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();

        try {	
			param.put("bank_acct_nm", bank_acct_nm);
			velParam.put("bank_acct_nm", bank_acct_nm);
			
			param.put("bank_acct_no", bank_acct_no);
			velParam.put("bank_acct_no", bank_acct_no);
			
			param.put("ofc_cd", ofc_cd);
			velParam.put("ofc_cd", ofc_cd);
			
			param.put("bank_acct_tp_nm", bank_acct_tp_nm);
			velParam.put("bank_acct_tp_nm", bank_acct_tp_nm);
			
			param.put("acct_tp_cd", acct_tp_cd);
			velParam.put("acct_tp_cd", acct_tp_cd);
			
            dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopBankAccountInfoListRSQL(), param, velParam);
            list = (List)RowSetUtil.rowSetToVOs(dbRowset, BankAccountInfoListVO.class);             
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
     * bank branch detail info 조회<br>
     * 
     * @param BankBranchVO bankBranchVO  
     * @return List<BankBranchVO>
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
	public List<BankBranchVO> searchBankBranchList(BankBranchVO bankBranchVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BankBranchVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bankBranchVO != null) {
				Map<String, String> mapVO= bankBranchVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchBankBranchListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BankBranchVO.class);
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
     * bank branch 등록<br>
     * 
     * @param BankBranchVO vo     
     * @exception DAOException
     */
	public void addBankBranchEntry(BankBranchVO vo) throws DAOException{
		try{
			int successFlag = 0;
			Map<String, String> mapVO = vo.getColumnValues();

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new AccountPayableCommonDBDAOAddBankBranchEntryCSQL(), mapVO, mapVO);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}	   
		    
    /**
     * bank branch 수정<br>
     * 
     * @param BankBranchVO vo     
     * @exception DAOException
     */
	public void modifyBankBranchEntry(BankBranchVO vo) throws DAOException{
		try{
			int successFlag = 0;
			Map<String, String> mapVO = vo.getColumnValues();

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new AccountPayableCommonDBDAOModifyBankBranchEntryUSQL(), mapVO, mapVO);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00065")).getMessage() );
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}	
	

    /**
     * bank branch code list 조회<br>
     * 
     * @param BankBranchVO bankBranchVO 
     * @return List<BankBranchVO>
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
	public List<BankBranchVO> searchBankBranchCodeList(BankBranchVO bankBranchVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BankBranchVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bankBranchVO != null) {
				Map<String, String> mapVO= bankBranchVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchBankBranchCodeListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BankBranchVO.class);
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
	 * Bank Branch Seq 채번<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	public String searchBankBrancMaxSeq() throws DAOException {
		DBRowSet dbRowset = null;
		try {
			
			// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountPayableCommonDBDAOSearchBankBrancMaxSeqRSQL(),param, velParam);
			if (dbRowset.next()) {
            	return dbRowset.getString("bank_brnc_seq");
            }
			return null;
		} catch(SQLException se){
			log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex){
        	log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
	} 	
	

    /**
     * Pay Invoice Information List 조회<br>
     * 
     * @param PopPayInvoiceInfomationListVO popPayInvoiceInfomationListVO     
     * @return List<PopPayInvoiceInfomationListVO>
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
	public List<PopPayInvoiceInfomationListVO> searchPopPayInvoiceInfomationList(PopPayInvoiceInfomationListVO popPayInvoiceInfomationListVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<PopPayInvoiceInfomationListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (popPayInvoiceInfomationListVO != null) {
				Map<String, String> mapVO= popPayInvoiceInfomationListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchPopPayInvoiceInfomationListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PopPayInvoiceInfomationListVO.class);
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
	 * Bank Account Seq 채번<br>
	 * 
	 * @return String
	 * @exception DAOException
	 */
	public String searchNextBankAccount() throws DAOException {
		DBRowSet dbRowset = null;
		try {
			
			// query parameter
            Map<String, Object> param = new HashMap<String, Object>();
            // velocity parameter
            Map<String, Object> velParam = new HashMap<String, Object>();
        	
        	// velocity parameter 설정 
            velParam.putAll(param);
            
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new AccountPayableCommonDBDAOSearchNextBankAccountRSQL(),param, velParam);
			if (dbRowset.next()) {
            	return dbRowset.getString("bank_acct_seq");
            }
			return null;
		} catch(SQLException se){
			log.error(se.getMessage(),se);
            throw new DAOException(new ErrorHandler(se).getMessage(),se);
        } catch(Exception ex){
        	log.error(ex.getMessage(),ex);
            throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
        }
	} 	
				
	
    /**
     * bank account 등록<br>
     * 
     * @param BankAccountListVO vo     
     * @exception DAOException
     */
	public void addBankAccountEntry(BankAccountListVO vo) throws DAOException{
		try{
			int successFlag = 0;
			Map<String, String> mapVO = vo.getColumnValues();

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new AccountPayableCommonDBDAOAddBankAccountEntryCSQL(), mapVO, mapVO);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}			
	
    /**
     * bank account 수정<br>
     * 
     * @param BankAccountListVO vo     
     * @exception DAOException
     */
	public void modifyBankAccountEntry(BankAccountListVO vo) throws DAOException{
		try{
			int successFlag = 0;
			Map<String, String> mapVO = vo.getColumnValues();

			successFlag = new SQLExecuter("").executeUpdate((ISQLTemplate) new AccountPayableCommonDBDAOModifyBankAccountEntryUSQL(), mapVO, mapVO);
			if(successFlag == Statement.EXECUTE_FAILED){
				throw new DAOException( (new ErrorHandler("PRD00064")).getMessage() );
			} // end if
		}catch(SQLException se){
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}

	}			


    /**
     * bank account detail info 조회<br>
     * 
     * @param BankAccountListVO bankAccountListVO     
     * @return List<BankAccountListVO>
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
	public List<BankAccountListVO> searchBankAccountList(BankAccountListVO bankAccountListVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BankAccountListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bankAccountListVO != null) {
				Map<String, String> mapVO= bankAccountListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchBankAccountListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BankAccountListVO.class);
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
     * bank account Leger 조회<br>
     * 
     * @param BankAccountListVO bankAccountListVO     
     * @return List<BankAccountListVO>
     * @exception DAOException
     */
	@SuppressWarnings("unchecked")
	public List<BankAccountListVO> searchBankAccountLegerList(BankAccountListVO bankAccountListVO) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BankAccountListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if (bankAccountListVO != null) {
				Map<String, String> mapVO= bankAccountListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchBankAccountLegerListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BankAccountListVO.class);
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
	 * COMMON : searchCOAInfo (SEARCH08) <br>
	 * 
	 * @param SapCommonVO sapCommonVO
	 * @return List<SapCommonVO> 
	 * @exception DAOException
	*/
	@SuppressWarnings("unchecked") 
	public List<SapCommonVO> searchCOAInfo(SapCommonVO sapCommonVO) throws DAOException {
		DBRowSet dbRowset = null;
		 List<SapCommonVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{

			if (sapCommonVO != null) {
				Map<String, String> mapVO = sapCommonVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchCOAInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, SapCommonVO.class);             
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
	 * [STM_SAP_0110]
	 * Bank Account Creation ( Supplier Bank ) - retrieve <br> 
	 * 
	 * @param String bankAcctSeq
	 * @return List<BankAccountSupplierListVO>
	 * @exception DAOException
  */
	@SuppressWarnings("unchecked")
  public List<BankAccountSupplierListVO> searchBankAccountSupplierList(String bankAcctSeq) throws DAOException {
		
		DBRowSet dbRowset = null;
		List<BankAccountSupplierListVO> list = null;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			 param.put("bank_acct_seq",    bankAcctSeq);
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchBankAccountSupplierListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, BankAccountSupplierListVO.class);
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
	 * [STM_SAP_0110]
	 * Bank Account Creation ( Supplier Bank ) - save check <br> 
	 * 
	 * @param String bankAcctSeq
	 * @return int
	 * @exception DAOException
   */
	@SuppressWarnings("unchecked")
   public int searchBankAccountSupplierBankCheck(String bankAcctSeq) throws DAOException {
		
		DBRowSet dbRowset = null;
		int insCnt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			 param.put("bank_acct_seq",    bankAcctSeq);
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchBankAccountSupplierBankCheckRSQL(), param, velParam);
			if(dbRowset.next()){
				insCnt = dbRowset.getInt("cnt");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
		
	}
	
	/**
	 * [STM_SAP_0110]
	 * Bank Account Creation ( Supplier Bank ) - save check (searchBankAccountSupplierBankDupCheck)<br> 
	 * 
	 * @param String bankAcctNo
	 * @param String vndr_seq
	 * @return int
	 * @exception DAOException
   */
	@SuppressWarnings("unchecked")
   public int searchBankAccountSupplierBankDupCheck(String bankAcctNo, String vndr_seq) throws DAOException {
		
		DBRowSet dbRowset = null;
		int insCnt = 0;
		
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			 param.put("bank_acct_no",          bankAcctNo);
			 param.put("bank_acct_vndr_seq",    vndr_seq);
			 
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchBankAccountSupplierDupCheckRSQL(), param, velParam);
			if(dbRowset.next()){
				insCnt = dbRowset.getInt("cnt");
			}
		} catch(SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return insCnt;
		
	}			
	
	/**
	 * [STM_SAP_0110]
	 * Bank Account Creation ( Supplier Bank ) - save<br> 
	 * 
	 * @param BankAccountSupplierListVO bankAccountSupplierListVO
	 * @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public void addBankAccountSupplier(BankAccountSupplierListVO bankAccountSupplierListVO) throws DAOException {
		SQLExecuter sqlExe = new SQLExecuter("");
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		int result = 0;

		try{
			if (bankAccountSupplierListVO != null) {
				Map<String, String> mapVO= bankAccountSupplierListVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
		
		result = sqlExe.executeUpdate((ISQLTemplate)new AccountPayableCommonDBDAOAddBankAccountSupplierCSQL(), param, velParam);
		if(result == Statement.EXECUTE_FAILED)
			 throw new DAOException("Fail to insert SQL");
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * [STM_SAP_0110]
	 * Bank Account Creation ( Supplier Bank ) - save<br> 
	 * 
	 * @param BankAccountSupplierListVO bankAccountSupplierListVO
	 * @exception DAOException
	*/
	@SuppressWarnings("unchecked")
	public void modifyBankAccountSupplier(BankAccountSupplierListVO bankAccountSupplierListVO) throws DAOException {
			SQLExecuter sqlExe = new SQLExecuter("");
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;

			try{
				if (bankAccountSupplierListVO != null) {
					Map<String, String> mapVO= bankAccountSupplierListVO.getColumnValues();

					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
			
			result = sqlExe.executeUpdate((ISQLTemplate)new AccountPayableCommonDBDAOModifyBankAccountSupplierUSQL(), param, velParam);
			if(result == Statement.EXECUTE_FAILED)
				 throw new DAOException("Fail to update SQL");
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch(Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	   /**
		 * SAKURA I/F for PAYMENT  
		 * searchBankAccountSequenceInfo <br> 
		 * 
		 * @return String
		 * @exception DAOException
	   */ 
		public String searchBankAccountSequenceInfo() throws DAOException {
			DBRowSet dbRowset = null;
			String rtnValue = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchBankAccountSequenceInfoRSQL(), param, velParam);
				if(dbRowset.next()) {
					rtnValue = dbRowset.getString("bank_account_id");
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
		 * [STM_SAP_0090] BANK_ACCT_NO DUP CHECK <br>
		 *
		 * @param String bank_acct_no
		 * @param String bank_acct_tp_nm
		 * @return String
		 * @exception DAOException
		 */
		public String searchBankAcctNoDupCheck(String bank_acct_no, String bank_acct_tp_nm) throws DAOException {
			DBRowSet dbRowset = null;
			String rtnValue = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				param.put("bank_acct_no", bank_acct_no);         	
	        	velParam.put("bank_acct_no", bank_acct_no);
	        	param.put("bank_acct_tp_nm", bank_acct_tp_nm);         	
	        	velParam.put("bank_acct_tp_nm", bank_acct_tp_nm);
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchBankAcctNoDupCheckRSQL(), param, velParam);
				if(dbRowset.next()) {
					rtnValue = dbRowset.getString("DUP_CHK");
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
		 * searchGLDateAPPeriodCheckByInvNo <br>
		 * 
		 * @param String inv_no
		 * @return String
		 * @exception DAOException
		*/	 
		public String searchGLDateAPPeriodCheckByInvNo(String inv_no) throws DAOException {
			DBRowSet dbRowset = null;
			String rtnValue = null;
			//query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			//velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();

			try{
				if (inv_no != null  ) {
					Map<String, String> mapVO = new HashMap<String, String>();
					mapVO.put("inv_no", inv_no);
				
					param.putAll(mapVO);
					velParam.putAll(mapVO);
				}
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new AccountPayableCommonDBDAOSearchGLDateAPPeriodCheckByInvNoRSQL(), param, velParam);
				if(dbRowset.next()) {
					rtnValue = dbRowset.getString("CHK_PRD");
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
	
}