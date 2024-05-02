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
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.basic.ARInvoiceCustomerMgtBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.AROfcVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.PopCustomerListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.PriCustomerListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SearchCustomerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.CreditCustomerVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ARInvoiceCustomerMgtDBDAO <br>
 * - AccountReceivableInvoiceMasterDataMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author saeil kim
 * @see ARInvoiceCustomerMgtBCImpl 참조
 * @since J2EE 1.4
 */
public class ARInvoiceCustomerMgtDBDAO extends DBDAOSupport {

	
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
	 * @return CreditCustomerVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public CreditCustomerVO searchCreditCustomer(String country, String cust, String regNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CreditCustomerVO> list = null;
		CreditCustomerVO creditCustomerVO = null;
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
			if (list != null && list.size() > 0) {
				creditCustomerVO = (CreditCustomerVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
		return creditCustomerVO;
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

}
