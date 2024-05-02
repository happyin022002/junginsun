/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ARInvoiceCustomerMgtDBDAO.java
 *@FileTitle : Customer Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.05.04 김세일
 * 1.0 Creation
 *  --------------------------------------------------------
 * History
 * 2011.09.28 권   민 [CHM-201113617] [INV]SVAT Reg. No for CMBSC SVAT Reg. NO 입력/저장 기능 개발
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.basic.ARInvoiceCustomerMgtBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.ARInvoiceBadCustomerHistoryVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.AROfcVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.AgentByVesselPortVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CprtItemVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CreditCustomerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CustRepEmlInfoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CustomerListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CustomerSecurityVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.InvArScrVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.InvCprtCdConvVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.InvSubAgnCustCdVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.PopCustomerListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.PriCustomerListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.RptTmpltNmVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SearchAgentListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SearchCustomerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SearchSVATNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SecurityInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.TemplateItemVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.TemplateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.ActPayerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.AutoInvCustomerVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;
import com.hanjin.syscommon.common.table.InvArSpndVatRgstNoVO;
import com.hanjin.syscommon.common.table.InvCprtTmpltChgVO;

/**
 * ALPS ARInvoiceCustomerMgtDBDAO <br>
 * - ALPS-AccountReceivableInvoiceMasterDataMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author saeil kim
 * @see ARInvoiceCustomerMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class ARInvoiceCustomerMgtDBDAO extends DBDAOSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
 
	/**
	 * ARInvoiceCustomerMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param SearchCustomerVO searchCustomerVO
	 * @return List<SearchCustomerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchCustomerVO> searchCustomerList(SearchCustomerVO searchCustomerVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchCustomerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchCustomerVO != null) {				
				Map<String, String> mapVO = searchCustomerVO.getColumnValues();
				
				StringTokenizer st = new StringTokenizer(searchCustomerVO.getCustNm(), " ");
				String custNm = searchCustomerVO.getCustNm();
				String custNm1 = "";
				String custNm2 = "";
				String custNm3 = "";
				String chkNm = searchCustomerVO.getChkNm();
				int i = 1;
				while (st.hasMoreTokens()) {				
					if(i==1){
						custNm1 = st.nextToken();
					}else if(i==2){
						custNm2 = st.nextToken();
					}else if(i==3){
						custNm3 = st.nextToken();
					}
					i++;
				}	
				mapVO.put("cust_nm", custNm);
				mapVO.put("cust_nm1", custNm1);
				mapVO.put("cust_nm2", custNm2);
				mapVO.put("cust_nm3", custNm3);
				mapVO.put("chk_nm", chkNm);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchCustomerVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchCustomerVO.class);
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
	 * 전체 데이타 건수를 조회한다.<br>
	 * 
	 * @param SearchCustomerVO searchCustomerVO
	 * @return int
	 * @exception DAOException
	 */
	public int searchCustomerListCnt(SearchCustomerVO searchCustomerVO) throws DAOException {
		int cnt = 0;
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			if (searchCustomerVO != null) {
				Map<String, String> mapVO = searchCustomerVO.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchCustomerCntRSQL(), param, velParam);
			if (dbRowset.next()) {
				cnt = dbRowset.getInt("CNT");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

		return cnt;
	}

	/**
	 * CUSTOMER 테이블에 Customer code or 사업자등록번호(주민등록번호)로 정보를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String country
	 * @param String cust
	 * @param String regNo
	 * @return List<CreditCustomerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CreditCustomerVO> searchCreditCustomer(String country, String cust, String regNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CreditCustomerVO> list = null;
//		CreditCustomerVO creditCustomerVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("frm_cust_cnt_cd", country);
			mapVO.put("frm_cust_rgst_no", regNo);
			mapVO.put("frm_cust_seq", cust);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOCreditCustomerVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CreditCustomerVO.class);
//			if (list != null && list.size() > 0) {
//				creditCustomerVO = (CreditCustomerVO) list.get(0);
//			}
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
	 * MDM_CUST_REP 테이블 에서 조회조건에 해당하는E-MAIL정보를 가져온다.<br>
	 * 
	 * @author Seungil Baek
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<CustRepEmlInfoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustRepEmlInfoVO> searchMdmCustRepEmlInfo(String custCntCd, String custSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustRepEmlInfoVO> list = null;
//		CustRepEmlInfoVO custRepEmlInfoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cust_cnt_cd", custCntCd);
			mapVO.put("cust_seq", custSeq);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchMdmCustRepEmlInfoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustRepEmlInfoVO.class);
//			if (list != null && list.size() > 0) {
//				custRepEmlInfoVO = (CustRepEmlInfoVO) list.get(0);
//			}
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
	 * 
	 * MDM_CR_CUST 테이블에서 관리 Office별 Credit Customer 정로를 조회한다.<br>
	 * CreditCustomer 일때,
	 * 
	 * @author Dong Hoon Han
	 * @param String usrOfcCd
	 * @param String ofcCd
	 * @param String custRlseCtrlFlg
	 * @return List<CustomerListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerListVO> searchCreditCustomerListByOffice(String usrOfcCd, String ofcCd, String custRlseCtrlFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cust_rlse_ctrl_flg", custRlseCtrlFlg);
			mapVO.put("ofc", ofcCd);
			mapVO.put("userofc", usrOfcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOCustomerListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomerListVO.class);
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
	 * MDM_CUSTOMER , MDM_CR_CUST 테이블에서 관리 Office별 Sales Customer 정보를 조회한다.<br>
	 * SalesCustomer 일때
	 * 
	 * @author Dong Hoon Han
	 * @param String usrOfcCd
	 * @param String ofcCd
	 * @param String custRlseCtrlFlg
	 * @return List<CustomerListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerListVO> searchSalesCustomerListByOffice(String usrOfcCd, String ofcCd, String custRlseCtrlFlg) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cust_rlse_ctrl_flg", custRlseCtrlFlg);
			mapVO.put("ofc", ofcCd);
			mapVO.put("userofc", usrOfcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOCustomerList2VORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomerListVO.class);
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
	 * 소속 AR_HD_QTR_OFC_CD 산하의 모든 office code를 가져온다.<br>
	 * SalesCustomer 일때
	 * 
	 * @author Dong Hoon Han
	 * @param String ofc
	 * @return List<String>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchSalesOfcList(String ofc) throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();
		String strOfcCd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("userofc", ofc);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOSalesOfcVORSQL(), param, velParam);
			while (dbRowset.next()) {
				strOfcCd = dbRowset.getString("ofc_cd");

				list.add(strOfcCd);
			}
			// list = (List)RowSetUtil.rowSetToVOs(dbRowset, SalesOfcVO .class);

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
	 * MDM_CUSTOMER 테이블에 Cntry code, Customer Name, Zipcode로 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String cntry
	 * @param String custNm
	 * @param String zipNo
	 * @param String chkNm
	 * @param String custRgstNo
	 * @return List<PopCustomerListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PopCustomerListVO> searchPopCustomerList(String cntry, String custNm, String zipNo, String chkNm, String custRgstNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PopCustomerListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {			
			StringTokenizer st = new StringTokenizer(custNm, " ");
			String custNm1 = "";
			String custNm2 = "";
			String custNm3 = "";
			int i = 1;
			while (st.hasMoreTokens()) {				
				if(i==1){
					custNm1 = st.nextToken();
				}else if(i==2){
					custNm2 = st.nextToken();
				}else if(i==3){
					custNm3 = st.nextToken();
				}
				i++;
			}	
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cust_cnt_cd", cntry);
			mapVO.put("cust_lgl_eng_nm", custNm);
			mapVO.put("cust_lgl_eng_nm1", custNm1);
			mapVO.put("cust_lgl_eng_nm2", custNm2);
			mapVO.put("cust_lgl_eng_nm3", custNm3);
			mapVO.put("zip_cd", zipNo);
			mapVO.put("chk_nm", chkNm);
			mapVO.put("cust_rgst_no", custRgstNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOPopCustomerListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PopCustomerListVO.class);
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
	 * RFA NO로 PRI의 PRI_RP_HDR에서 .PROP_NO를 구하고 PRI_RP_MN. PRI_RP_AFIL에서 PROP_No에 관련 Customer를 조회한다.<br>
	 * 
	 * @param String rfaNo
	 * @return List<PriCustomerListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriCustomerListVO> searchRFACustomerList(String rfaNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriCustomerListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rfa_no", rfaNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchRFACustomerListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriCustomerListVO.class);
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
	 * S/C NO로 PRI의 PRI_SP_HDR에서 .PROP_No를 구하고 PRI_SP_CTRT_PTY, PRI_SP_MN. PRI_SP_AFIL에서 PROP_No에 관련 Customer를 조회한다<br>
	 * 
	 * @param String scNo
	 * @return List<PriCustomerListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PriCustomerListVO> searchSCCustomerList(String scNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<PriCustomerListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("sc_no", scNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchSCCustomerListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PriCustomerListVO.class);
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
	 * FNS_INV_0081<br>
	 * INV_VSL_AGN_CUST_CD에서 office조건으로 등록된 Vessl 별 Agent정보를 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String arOfc
	 * @param String ofc
	 * @return List<AgentByVesselPortVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AgentByVesselPortVO> searchAgentByVesselList(String arOfc, String ofc) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgentByVesselPortVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ar_ofc_cd", arOfc);
			param.put("ofc_cd", ofc);
			velParam.put("ar_ofc_cd", arOfc);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchAgentByVesselListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AgentByVesselPortVO.class);
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
	 * FNS_INV_0081<br>
	 * INV_FDR_POD_AGN_CUST_CD에서 office조건으로 등록된 Port, Lane 별로 등록된 Agent정보를 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String arOfc
	 * @param String ofc
	 * @return List<AgentByVesselPortVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AgentByVesselPortVO> searchAgentByPortList(String arOfc, String ofc) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgentByVesselPortVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			param.put("ar_ofc_cd", arOfc);
			param.put("ofc_cd", ofc);
			velParam.put("ar_ofc_cd", arOfc);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchAgentByPortListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AgentByVesselPortVO.class);
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
	 * MDM_ORGANIZATION에서 USER ID AR office(AR_OFC_CD) 및 ARControl(AR_CTRL_OFC_CD)를 구해온다.<br>
	 * 
	 * @param String arOfc
	 * @return List<AROfcVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AROfcVO> searchAROfc(String arOfc) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROfcVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		log.info("arofc:" + arOfc);
		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ofc_cd", arOfc);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOAROfcVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AROfcVO.class);
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
	 * FNS_INV_0081<br>
	 * 1.BKG_CHN_AGN 테이블에서 USER ID AR office에 해당하는 북중국 Inbound Collection Agent code별<br>
	 * 소속 office, vender, customer정보를 list로 가지고 온다.<br>
	 * 2.USER ID AR office가 RHQ 인 경우는 산하 AR Ofice에 해당하는 Agent code를 모두 가져온다.<br>
	 * 3.AR Office code 가 'BB"로 된 office 는 제외하고 가져온다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String arOfc
	 * @return List<SearchAgentListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchAgentListVO> searchAgentList(String arOfc) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAgentListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("ofc_cd", arOfc);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchAgentListVORSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchAgentListVO.class);
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
	 * FNS_INV_0081<br>
	 * 1.BKG_CHN_AGN 테이블에서 USER ID AR office에 해당하는 북중국 Inbound Collection Agent code별<br>
	 * 소속 office, vender, customer정보를 list로 가지고 온다.<br>
	 * 2.USER ID AR office가 RHQ 인 경우는 산하 AR Ofice에 해당하는 Agent code를 모두 가져온다.<br>
	 * 3.AR Office code 가 'BB"로 된 office 는 제외하고 가져온다.<br>
	 * arControl='C' or arOfc='XMNSC' 인 경우<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String arOfc
	 * @return List<SearchAgentListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchAgentListVO> searchAgentCList(String arOfc) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchAgentListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("ofc_cd", arOfc);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchAgentCListRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchAgentListVO.class);
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
	 * INV_VSL_AGN_CUST_CD 테이블에 Vessl 로 등록된 Agent정보를 조회한다.<br>
	 * 
	 * @param String vsl
	 * @return List<AgentByVesselPortVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AgentByVesselPortVO> searchAgentByVessel(String vsl) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgentByVesselPortVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("vsl_cd", vsl);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOAgentByVesselVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AgentByVesselPortVO.class);
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
	 * FNS_INV_0081<br>
	 * INV_VSL_AGN_CUST_CD 테이블에 Vessl 별 Agent정보를 등록한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param List<AgentByVesselPortVO> agtVslVOs
	 * @exception DAOException
	 */
	public void addAgentByVessel(List<AgentByVesselPortVO> agtVslVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agtVslVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOAgentByVesselVOCSQL(), agtVslVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * FNS_INV_0081<br>
	 * INV_VSL_AGN_CUST_CD 테이블에 Vessl 별 Agent정보를 수정한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param List<AgentByVesselPortVO> agtVslVOs
	 * @exception DAOException
	 */
	public void modifyAgentByVessel(List<AgentByVesselPortVO> agtVslVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (agtVslVOs.size()> 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOAgentByVesselVOUSQL(), agtVslVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
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
	 * FNS_INV_0081<br>
	 * INV_VSL_AGN_CUST_CD 테이블에 Vessl 별 Agent정보를 삭제한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param List<AgentByVesselPortVO> agtVslVOs
	 * @exception DAOException
	 */
	public void removeAgentByVessel(List<AgentByVesselPortVO> agtVslVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (agtVslVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOAgentByVesselVODSQL(), agtVslVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}

			log.info("delCnt:" + delCnt);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * INV_FDR_POD_AGN_CUST_CD 테이블에서 POD(Port) ,Lane로 등록된 Agent 내용을 조회한다.<br>
	 * 
	 * @param String pod
	 * @param String lane
	 * @return List<AgentByVesselPortVO>
	 * @exception DAOException
	 */
	/*
	@SuppressWarnings("unchecked")
	
	public List<AgentByVesselPortVO> searchAgentByPort(String pod, String lane) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgentByVesselPortVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("fdr_pod_cd", pod);
			mapVO.put("lane_cd", lane);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOAgentByPortVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AgentByVesselPortVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	*/

	/**
	 * FNS_INV_0081<br>
	 * 
	 * INV_FDR_POD_AGN_CUST_CD 테이블에 POD(Port) ,Lane 별 Agent정보를 등록한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param List<AgentByVesselPortVO> agtPodVOs
	 * @exception DAOException
	 */
	public void addAgentByPort(List<AgentByVesselPortVO> agtPodVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (agtPodVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOAgentByPortVOCSQL(), agtPodVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * FNS_INV_0081<br>
	 * INV_FDR_POD_AGN_CUST_CD 테이블에 POD(Port) ,Lane 별 Agent정보를 수정등록한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param List<AgentByVesselPortVO> agtPodVOs
	 * @exception DAOException
	 */
	public void modifyAgentByPort(List<AgentByVesselPortVO> agtPodVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (agtPodVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOAgentByPortVOUSQL(), agtPodVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
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
	 * FNS_INV_0081<br>
	 * INV_FDR_POD_AGN_CUST_CD 테이블에 POD(Port) ,Lane 별 Agent정보를 삭제한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param List<AgentByVesselPortVO> agtPodVOs
	 * @exception DAOException
	 */
	public void removeAgentByPort(List<AgentByVesselPortVO> agtPodVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (agtPodVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOAgentByPortVODSQL(), agtPodVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
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
	 * INV_CPRT_CD_CONV에서 S/C NO나 RFA NO (화면에서 입력하지 않은 Number는 임의로 'X'로 넘겨 준다. )와 code 유형을 조건으로 데이터를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String scNo
	 * @param String rfaNO
	 * @param String codeTy
	 * @return List<InvCprtCdConvVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvCprtCdConvVO> searchCodeConversionList(String scNo, String rfaNO, String codeTy) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<InvCprtCdConvVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("sc_no", scNo);
			mapVO.put("rfa_no", rfaNO);
			mapVO.put("cprt_conv_tp_cd", codeTy);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOInvCprtCdConvVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvCprtCdConvVO.class);
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
	 * S/C NO로 PRI의 PRI_SP_HDR에서 .PROP_No를 구하고 PRI_SP_CTRT_PTY에서 PROP_No에대한 Customer를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String scNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchSCCustomerName(String scNo) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		String searchScNo = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("sc_no", scNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchSCCustomerNameRSQL(), param, velParam);
			if (dbRowset.next()) {
				searchScNo = dbRowset.getString("cust_lgl_eng_nm");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchScNo;
	}

	/**
	 * RFA NO로 PRI의 PRI_RP_HDR에서 .PROP_No를 구하고 PRI_RP_MN에서 Customer를 구하여 이름을 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String rfaNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchRFACustomerName(String rfaNo) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		String searchRfaNo = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("rfa_no", rfaNo);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchRFACustomerNameRSQL(), param, velParam);
			if (dbRowset.next()) {
				searchRfaNo = dbRowset.getString("cust_lgl_eng_nm");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchRfaNo;
	}

	/**
	 * MDM_LOCATION의 LOC_CD와 Code 비교 하기위해 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String cd
	 * @return String
	 * @exception DAOException
	 */
	public String searchLocation(String cd) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		String searchCd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cd", cd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchLocationRSQL(), param, velParam);
			if (dbRowset.next()) {
				searchCd = dbRowset.getString("cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchCd;
	}

	/**
	 * MDM_CHARGE 의 CHG_CD와 Code 비교하기위해 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String cd
	 * @return String
	 * @exception DAOException
	 */
	public String searchChgCode(String cd) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		String searchCd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cd", cd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchChgCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				searchCd = dbRowset.getString("cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchCd;
	}

	/**
	 * MDM_CNTR_TP_SZ의 CNTR_TPSZ_CD와 Code 비교하기위해 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String cd
	 * @return String
	 * @exception EDAOException
	 */
	public String searchCNTRCode(String cd) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		String searchCd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cd", cd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchCNTRCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				searchCd = dbRowset.getString("cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchCd;
	}

	/**
	 * MDM_COMMODITY 의 CMDT_CD와 Code 비교하기위해 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String cd
	 * @return String
	 * @exception DAOException
	 */
	public String searchCmdtCode(String cd) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		String searchCd = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cd", cd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchCmdtCodeRSQL(), param, velParam);
			if (dbRowset.next()) {
				searchCd = dbRowset.getString("cd");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return searchCd;
	}

	/**
	 * INV_CPRT_CD_CONV 에 S/C NO나 RFA NO별로( (화면에서 입력하지 않은 Number는 임의로 'X'로 넘겨 준다. ) Conversion code유형에 따라 생성한다..<br>
	 * 
	 * @author Dong Hoon Han
	 * @param List<InvCprtCdConvVO> invCprtCdConvVOs
	 * @exception DAOException
	 */
	public void addCodeConversion(List<InvCprtCdConvVO> invCprtCdConvVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invCprtCdConvVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOInvCprtCdConvVoCSQL(), invCprtCdConvVOs, null);
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
	 * INV_CPRT_CD_CONV의 데이터를 update 한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param List<InvCprtCdConvVO> invCprtCdConvVOs
	 * @exception DAOException
	 */
	public void modifyCodeConversion(List<InvCprtCdConvVO> invCprtCdConvVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (invCprtCdConvVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOInvCprtCdConvVOUSQL(), invCprtCdConvVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to update No" + i + " SQL");
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
	 * INV_CPRT_CD_CONV의 데이터를 삭제한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param List<InvCprtCdConvVO> invCprtCdConvVOs
	 * @exception DAOException
	 */
	public void removeCodeConversion(List<InvCprtCdConvVO> invCprtCdConvVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (invCprtCdConvVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOInvCprtCdConVODSQL(), invCprtCdConvVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
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
	 * INV_AR_SCR 테이블에서 Customer조건으로 등록된 담보정보를 조회한다.<br>
	 * 
	 * @param String custCntCd
	 * @param String custSeq
	 * @return List<CustomerSecurityVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerSecurityVO> searchSecurityList(String custCntCd, String custSeq) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<CustomerSecurityVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("cust_cnt_cd", custCntCd);
			mapVO.put("cust_seq", custSeq);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOSearchSecurityListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomerSecurityVO.class);
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
	 * INV_AR_SCR 테이블에서 Customer 담보정보를 insert.<br>
	 * 
	 * @author Choi Do Soon
	 * @param invArScrVO
	 * @exception DAOException
	 */
	public void addCustomerSecurity(InvArScrVO invArScrVO) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = invArScrVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			sqlExe.executeUpdate((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOAddCustomerSecurityCSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}

	}

	/**
	 * INV_AR_SCR 테이블에서 Customer 담보정보를 update<br>
	 * 
	 * @param List<InvArScrVO> invArScrVOs
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] modifyCustomerSecurity(List<InvArScrVO> invArScrVOs) throws DAOException, Exception {
		int updCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (invArScrVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOModifyCustomerSecurityUSQL(), invArScrVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
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
		return updCnt;
	}

	/**
	 * INV_AR_SCR 테이블에서 Customer 담보정보를 delete<br>
	 * 
	 * @param List<InvArScrVO> invArScrVOs
	 * @return int[]
	 * @exception DAOException
	 */
	public int[] removeCustomerSecurity(List<InvArScrVO> invArScrVOs) throws DAOException, Exception {
		int delCnt[] = null;
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			if (invArScrVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCustomerMgtDBDAORemoveCustomerSecurityDSQL(), invArScrVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
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
		return delCnt;
	}

	/**
	 * Template에 선택할수 있는 item 전체 목록을 INV_CPRT_ITM테이블에서 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @return List<CprtItemVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CprtItemVO> searchItemList() throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<CprtItemVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOCprtItemVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CprtItemVO.class);
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
	 * USER가 사용가능한 권한으로 등록된 Template name을 INV_CPRT_TMPLT테이블에서 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String userId
	 * @param String ofc
	 * @return List<RptTmpltNmVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<RptTmpltNmVO> searchTemplateList(String userId, String ofc) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<RptTmpltNmVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("usr_id", userId);
			mapVO.put("ar_ofc_cd", ofc);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOCprtItemVO2RSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, RptTmpltNmVO.class);
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
	 * 입력한 Template으로 저장되어 있는 선택 item목록을 INV_CPRT_TMPLT테이블에서 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String tmplate
	 * @param String arOfcCd
	 * @return List<TemplateItemVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<TemplateItemVO> searchSelectedItemList(String tmplate ,String arOfcCd) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<TemplateItemVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("rpt_tmplt_nm", tmplate);
			mapVO.put("ar_ofc_cd", arOfcCd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOTemplateItemVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TemplateItemVO.class);
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
	 * 입력한 Template으로 저장되어 있는 S/C, RFA NO별 Charge code를 INV_CPRT_TMPLT_CHG 테이블에서 조회한다.<br>
	 * 
	 * @author KIM HYUN HWA
	 * @param String tmplate
	 * @param String arOfcCd
	 * @return List<InvCprtTmpltChgVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvCprtTmpltChgVO> searchSelectedChildItemList(String tmplate, String arOfcCd) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<InvCprtTmpltChgVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("rpt_tmplt_nm", tmplate);
			mapVO.put("ar_ofc_cd", arOfcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchTemplateChgListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvCprtTmpltChgVO.class);
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
	 * USER가 신규 입력한 Template name이 같은 이름으로 저장된 내용이 있는지 INV_CPRT_TMPLT테이블에서 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String tmplate
	 * @return String
	 * @exception DAOException
	 */
    public String searchTemplateName(String tmplate) throws DAOException, Exception {	
		DBRowSet dbRowset = null;
		String tmpleName = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {

			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("rpt_tmplt_nm", tmplate);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchTemplateNameRSQL(), param, velParam);
			if (dbRowset.next()) {
				tmpleName = dbRowset.getString("rpt_tmplt_nm");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return tmpleName;
	}

	/**
	 * 신규 Template에 선택한 item 들을 INV_CPRT_TMPLT테이블에 저장한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param List<TemplateVO> tmplateVOs
	 * @exception DAOException
	 */

	public void addTemplateItem(List<TemplateVO> tmplateVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (tmplateVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOTemplateVOCSQL(), tmplateVOs, null);
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
	 * Template에 선택한 item 의 변경된 내용을 INV_CPRT_TMPLT테이블에 저장한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param List<TemplateVO> tmplateVOs
	 * @exception DAOException
	 */
	public void modifyTemplateItem(List<TemplateVO> tmplateVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (tmplateVOs.size() > 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOTemplateVOUSQL(), tmplateVOs, null);
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
	 * Template에 선택해제된 item 을 INV_CPRT_TMPLT테이블에서 삭제 한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param List<TemplateVO> tmplateVOs
	 * @exception DAOException
	 */
	public void removeTemplateItem(List<TemplateVO> tmplateVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (tmplateVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOTemplateVODSQL(), tmplateVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
				}
			}

			log.info("delCnt:" + delCnt);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * 등록된 Template을 INV_CPRT_TMPLT테이블에서 삭제한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param String tmplate
	 * @param String ofcCd
	 * @exception DAOException
	 */
	public void removeTemplate(String tmplate, String ofcCd) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("rpt_tmplt_nm", tmplate);
			mapVO.put("ar_ofc_cd", ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			sqlExe.executeUpdate((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOremoveTemplateDSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 신규 Template에 선택한 Charge code 들을 INV_CPRT_TMPLT테이블에 저장한다.<br>
	 * 
	 * @author KIM HYUN HWA
	 * @param List<InvCprtTmpltChgVO> invCprtTmpltChgVOs
	 * @exception DAOException
	 */
	
	public void addInvCprTmpltChg(List<InvCprtTmpltChgVO> invCprtTmpltChgVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invCprtTmpltChgVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOaddTemplateChgCSQL(), invCprtTmpltChgVOs, null);
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
	 * Template에 속한 Charge code를 INV_CPRT_TMPLT테이블에서 삭제 한다.<br>
	 * 
	 * @author  KIM HYUN HWA
	 * @param String tmplate
	 * @param String ofcCd
	 * @exception DAOException
	 */
	public void removeInvCprTmpltChg(String tmplate, String ofcCd) throws DAOException, Exception {
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("rpt_tmplt_nm", tmplate);
			mapVO.put("ar_ofc_cd", ofcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			sqlExe.executeUpdate((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOremoveTemlapteChgDSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}


	/**
	 * INV_AR_SCR 테이블에서 Kind of Security, O/BTerm, I/B Term, Office, <br>
	 * DateOption(DueDate, As of Date), FromDate, ToDate 조건으로 Customer별 등록된 담보정보를 조회한다.<br>
	 * 
	 * @param SecurityInputVO securityInputVO
	 * @return List<CustomerSecurityVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<CustomerSecurityVO> searchCustomerSecurityList(SecurityInputVO securityInputVO) throws DAOException, Exception {
		DBRowSet dbRowset = null;
		List<CustomerSecurityVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = securityInputVO.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOSearchCustomerSecurityListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomerSecurityVO.class);
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
	 * FNS_INV_0082<br>
	 * INV_SUB_POD_AGN_CUST_CD 테이블에서 AR OFFICE로 등록된 Agent 내용을 조회한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param String arOfc
	 * @return List<AgentByVesselPortVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AgentByVesselPortVO> searchSubAgentList(String arOfc) throws DAOException {
		DBRowSet dbRowset = null;
		List<AgentByVesselPortVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("ar_ofc_cd", arOfc);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOSubAgentListRSQL(), param, null);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AgentByVesselPortVO.class);
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
	 * FNS_INV_0082<br>
	 * INV_SUB_AGN_CUST_CD 테이블에  Office 별 Agent정보를 등록한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param List<InvSubAgnCustCdVO> invSubAgnCustCdVOs
	 * @exception DAOException
	 */
	public void addSubAgent(List<InvSubAgnCustCdVO> invSubAgnCustCdVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int insCnt[] = null;
			if (invSubAgnCustCdVOs.size() > 0) {
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOSubAgentCSQL(), invSubAgnCustCdVOs, null);
				for (int i = 0; i < insCnt.length; i++) {
					if (insCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to insert No" + i + " SQL");
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
	 * FNS_INV_0082<br>
	 * INV_SUB_AGN_CUST_CD 테이블에  Office 별 Agent정보를 수정한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param List<InvSubAgnCustCdVO> invSubAgnCustCdVOs
	 * @exception DAOException
	 */
	public void modifySubAgent(List<InvSubAgnCustCdVO> invSubAgnCustCdVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int updCnt[] = null;
			if (invSubAgnCustCdVOs.size()> 0) {
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOSubAgentUSQL(), invSubAgnCustCdVOs, null);
				for (int i = 0; i < updCnt.length; i++) {
					if (updCnt[i] == Statement.EXECUTE_FAILED)
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
	 * FNS_INV_0082<br>
	 * INV_SUB_AGN_CUST_CD 테이블에  Office 별 Agent정보를 삭제한다.<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param List<InvSubAgnCustCdVO> invSubAgnCustCdVOs
	 * @exception DAOException
	 */
	public void removeSubAgent(List<InvSubAgnCustCdVO> invSubAgnCustCdVOs) throws DAOException, Exception {
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			int delCnt[] = null;
			if (invSubAgnCustCdVOs.size() > 0) {
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOSubAgentDSQL(), invSubAgnCustCdVOs, null);
				for (int i = 0; i < delCnt.length; i++) {
					if (delCnt[i] == Statement.EXECUTE_FAILED)
						throw new DAOException("Fail to delete No" + i + " SQL");
				}
			}

			log.info("delCnt:" + delCnt);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * ARInvoiceCustomerMgtDBDAO의 데이타 모델에 해당되는 값을 불러온다.<br>
	 * 
	 * @param	SearchSVATNoVO searchSVATNoVO
	 * @return	List<SearchSVATNoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SearchSVATNoVO> searchSVATNo(SearchSVATNoVO searchSVATNoVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<SearchSVATNoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (searchSVATNoVO != null) {				
				Map<String, String> mapVO = searchSVATNoVO.getColumnValues();
				
				String custCntCd	= searchSVATNoVO.getCustCntCd();
				String custSeq		= searchSVATNoVO.getCustSeq();
				String svatRgstNo	= searchSVATNoVO.getSpndVatRgstNo();
				String gubun        = searchSVATNoVO.getGubun();

				mapVO.put("custCntCd", custCntCd);
				mapVO.put("custSeq", custSeq);
				mapVO.put("svatRgstNo", svatRgstNo);
				mapVO.put("gubun", gubun);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchSVATNoRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SearchSVATNoVO.class);
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
	 * INV_AR_SPND_VAT_RGST_NO 테이블에 insert or update 한다.<br>
	 * 
	 * @author		권 민
	 * @param		InvArSpndVatRgstNoVO invArSpndVatRgstNoVO
	 * @exception	DAOException
	 */
	public void modifySVATNo(InvArSpndVatRgstNoVO invArSpndVatRgstNoVO) throws DAOException, Exception {
		try {
			// query parameter
			Map<String, Object> param = new HashMap<String, Object>();
			// velocity parameter
			Map<String, Object> velParam = new HashMap<String, Object>();
			
			int result = 0;
			
			if (invArSpndVatRgstNoVO != null) {
				
				Map<String, String> mapVO = invArSpndVatRgstNoVO.getColumnValues();
				
				String custCntCd	= invArSpndVatRgstNoVO.getCustCntCd();
				String custSeq		= invArSpndVatRgstNoVO.getCustSeq();
				String svatRgstNo	= invArSpndVatRgstNoVO.getSpndVatRgstNo();
				String creUsrId		= invArSpndVatRgstNoVO.getCreUsrId();
				String updUsrId		= invArSpndVatRgstNoVO.getUpdUsrId();
				
				mapVO.put("svatRgstNo", svatRgstNo);
				mapVO.put("creUsrId", creUsrId);
				mapVO.put("updUsrId", updUsrId);
				mapVO.put("custCntCd", custCntCd);
				mapVO.put("custSeq", custSeq);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
				result = new SQLExecuter("").executeUpdate((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOmodifySVATNoUSQL(),param, velParam);
				
				if(result == Statement.EXECUTE_FAILED)
					throw new DAOException("Fail to excute SQL");
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
	 * 악성화주 리스트 조회<br>
	 * 
	 * @param ARInvoiceBadCustomerHistoryVO aRInvoiceBadCustomerHistoryVO
	 * @return List<ARInvoiceBadCustomerHistoryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceBadCustomerHistoryVO> searchBadCustomerList(ARInvoiceBadCustomerHistoryVO aRInvoiceBadCustomerHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceBadCustomerHistoryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			if (aRInvoiceBadCustomerHistoryVO != null) {
				Map<String, String> mapVO = aRInvoiceBadCustomerHistoryVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);			
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOBadCustHistoryRSQL(), param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceBadCustomerHistoryVO.class);
			}
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
	 * 악성화주 히스토리 리스트 조회<br>
	 * 
	 * @param ARInvoiceBadCustomerHistoryVO aRInvoiceBadCustomerHistoryVO
	 * @return List<ARInvoiceBadCustomerHistoryVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceBadCustomerHistoryVO> searchBadCustomerHistoryList(ARInvoiceBadCustomerHistoryVO aRInvoiceBadCustomerHistoryVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceBadCustomerHistoryVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			
			if (aRInvoiceBadCustomerHistoryVO != null) {
				Map<String, String> mapVO = aRInvoiceBadCustomerHistoryVO.getColumnValues();
				param.putAll(mapVO);
				velParam.putAll(mapVO);			
				
				dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOBadCustHistoryDtlRSQL(), param, velParam);
				list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceBadCustomerHistoryVO.class);
			}
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
	 * INV_BAD_CUST_HIS_PROC 호출함.
	 * @param String cust_cnt_cd
	 * @param String cust_seq
	 * @param String in_kind
	 * @throws DAOException
	 */
	@SuppressWarnings("unchecked")
	public void manageInvBadCustHist(String cust_cnt_cd, String cust_seq, String in_kind ) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
	    Map<String, Object> rtnMap = new HashMap<String, Object>();
		try {
			
	       Map<String, String> mapVO = new HashMap<String, String>();
		
			mapVO.put("in_cust_cnt_cd", cust_cnt_cd);
			mapVO.put("in_cust_seq", cust_seq);
			mapVO.put("in_kind" ,in_kind);
			mapVO.put("o_result", "");
			mapVO.put("o_err_msg", "");
			
			param.putAll(mapVO);
			
			rtnMap = new SQLExecuter("DEFAULT").executeSP( (ISQLTemplate) new ARInvoiceCustomerMgtDBDAOManageInvBadCustHistCSQL(), param, null);			
			
			String result = rtnMap.get("o_result")==null?"":(String)rtnMap.get("o_result");
			String errMsg = rtnMap.get("o_err_msg")==null?"":(String)rtnMap.get("o_err_msg");
			log.debug("---------------------------------------------------------");
			log.debug("manageInvBadCustHist o_result:" + result);
			log.debug("---------------------------------------------------------");	
			log.debug("---------------------------------------------------------");
			log.debug("manageInvBadCustHist o_err_msg:" + errMsg);
			log.debug("---------------------------------------------------------");	

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		
	}
	
	/**
	 * MDM Actual Payer 리스트 조회<br>
	 * 
	 * @param String arOfcCd
	 * @param String userOfcCd
	 * @param String actCustCntCd
	 * @param String actCustSeq
	 * @return List<ActPayerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ActPayerVO> searchActualPayerList(String arOfcCd, String userOfcCd,String actCustCntCd, String actCustSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<ActPayerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("user_ofc_cd", userOfcCd);
			mapVO.put("act_cust_cnt_cd", actCustCntCd);
			mapVO.put("act_cust_seq", actCustSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchActualPayerListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ActPayerVO.class);
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
	 * MDM Auto Invoice 대상화주 리스트 조회<br>
	 * 
	 * @param String arOfcCd
	 * @param String ioBndCd
	 * @param String userOfcCd
	 * @param String actCustCntCd
	 * @param String actCustSeq
	 * @return List<AutoInvCustomerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<AutoInvCustomerVO> searchAutoInvCustomerList(String arOfcCd, String ioBndCd, String userOfcCd, String actCustCntCd, String actCustSeq) throws DAOException {
		DBRowSet dbRowset = null;
		List<AutoInvCustomerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("io_bnd_cd", ioBndCd);
			mapVO.put("user_ofc_cd", userOfcCd);
			mapVO.put("act_cust_cnt_cd", actCustCntCd);
			mapVO.put("act_cust_seq", actCustSeq);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceCustomerMgtDBDAOsearchAutoInvCustomerListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AutoInvCustomerVO.class);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}

}
