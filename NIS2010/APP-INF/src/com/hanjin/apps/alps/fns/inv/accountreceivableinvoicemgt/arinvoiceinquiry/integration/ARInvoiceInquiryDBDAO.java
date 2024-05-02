/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ARInvoiceInquiryDBDAO.java
 *@FileTitle : Invoice Inquiry by I/F No - General
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.04
 *@LastModifier : 김세일
 *@LastVersion : 1.0
 * 2009.05.04 김세일
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.12.28 최도순 [CHM-201007700] ALPS AR INV ''Transaction Data Comparison Report'' 기능 개발 요청(신규)
 * 2011.04.18 최도순 [CHM-201109030-01] Intra - Europe Business 관련 VAT 기능 개발
 * 2013.09.23 임옥영 [] Customer Inquiry by B/L No 개발
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration.ARInvoiceExRateMgtDBDAOSearchCustomerMonExRateVORSQL;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration.ARInvoiceExRateMgtDBDAOSearchExRateVOCSQL;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration.ARInvoiceExRateMgtDBDAOSearchExRateVODSQL;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.integration.ARInvoiceExRateMgtDBDAOSearchExRateVOUSQL;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.CustDailyExRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.integration.ARInvoiceCorrectionDBDAOSearchDirectBillingInvoiceVORSQL;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceChargeCorrectionVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCorrectionVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.BillInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.DirectBillingInvoiceVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.basic.ARInvoiceInquiryBCImpl;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceByBLNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeByBLNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeSumVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceContainerVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceHistoryByBLNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceInputByBLNoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceInquiryInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceIssueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceListByIFDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceNoGoodInPutVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceNoGoodNotIssueListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.BKGForTaxByDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.BKGForTaxByVesselVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CustomerListByBLVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.DXBInvoiceListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ErpErrorInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ErpErrorVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.FaxEmailSentDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.FaxEmailSentResultVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.GCFSAFChargeListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.GSTChargeListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceDetailListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueListInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueTVAListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceSumVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceSummaryListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceTermAnalysisInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceTermAnalysisVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotIssuedAgingInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotIssuedAgingVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotIssuedListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotissuedInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NYCInvoiceIssueDateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.PCFRevExpnAmountVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.PCFStatusInfoInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.PCFStatusInfoVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ReportForReverseChargeVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.SpainInvoiceEDIListCountVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.SpainInvoiceEDIListVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TransDataComparisonReportInputVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TransDataComparisonReportVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceAKLBAVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.hanjin.apps.alps.fns.inv.invcommon.invcommon.vo.AROfficeListVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.rowset.DBRowSet;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.db.ISQLTemplate;
import com.hanjin.framework.support.db.RowSetUtil;
import com.hanjin.framework.support.db.SQLExecuter;
import com.hanjin.framework.support.layer.integration.DBDAOSupport;

/**
 * ALPS ARInvoiceInquiryDBDAO <br>
 * - ALPS-AccountReceivableInvoiceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author saeil kim
 * @see ARInvoiceInquiryBCImpl 참조
 * @since J2EE 1.4
 */
public class ARInvoiceInquiryDBDAO extends DBDAOSupport {
	/**
	 * Date type에 따라 Good date(BL_INV_CFM_DT), I/F Date(BL_INV_IF_DT) 기간 및 조회조건에 해당하는 AR Invoice 정보를 조회한다.<br>
	 * 
	 * @param ARInvoiceInquiryInPutVO invByGoodVO
	 * @return List< ARInvoiceListByIFDateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceListByIFDateVO> searchARInvoiceListByGoodDate(ARInvoiceInquiryInPutVO invByGoodVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceListByIFDateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invByGoodVO != null) {
							
				String revSrcCd = invByGoodVO.getRevSrcCd();
				
				StringTokenizer st = new StringTokenizer(revSrcCd, ",");
				String uRevSrcCd = "";
				String strRevSrcCd = "";
				while (st.hasMoreTokens()) {
					uRevSrcCd = st.nextToken();
					if (uRevSrcCd.equals("")) {
						strRevSrcCd = "";
					}else{
						strRevSrcCd = strRevSrcCd+"'," + "'"+uRevSrcCd;
					}
				
				}
				if(!strRevSrcCd.equals("")){
					strRevSrcCd = strRevSrcCd + "";
				}
				
				
				Map<String, String> mapVO = invByGoodVO.getColumnValues();
				
				mapVO.put("rev_src_cd", strRevSrcCd);				
				
				String vvd = "";
				String vslCd = "";
				String skdVoyNo = "";
				String skdDirCd = "";
				vvd = invByGoodVO.getVvd();
				if (!"".equals(vvd)) {
					vslCd = vvd.substring(0, 4);
					skdVoyNo = vvd.substring(4, 8);
					skdDirCd = vvd.substring(8, 9);
				}
				mapVO.put("vsl_cd", vslCd);
				mapVO.put("skd_voy_no", skdVoyNo);
				mapVO.put("skd_dir_cd", skdDirCd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOARInvoiceListByGoodDateVORSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceListByIFDateVO.class);
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
	 * Office별 엑셀데이터용 Invoice 데이터 조회.<br>
	 * No Good된 데이터 Or Not Issue 데이터를 조회조건에 해당하는 AR Invoice 정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param ARInvoiceNoGoodInPutVO noGoodNoIssueVO
	 * @return List< ARInvoiceNoGoodNotIssueListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceNoGoodNotIssueListVO> searchNoGoodNotIssueList(ARInvoiceNoGoodInPutVO noGoodNoIssueVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceNoGoodNotIssueListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (noGoodNoIssueVO != null) {
				// Map<String, String> mapVO = new HashMap<String, String>();
				Map<String, String> mapVO = noGoodNoIssueVO.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOARInvoiceNoGoodNotIssueListVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceNoGoodNotIssueListVO.class);
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
	 * AR Invoice issue 테이블에서 office code, Invoice no에 조회하여 AR Invoice main 테이블에서 조회하여 가져온다.<br>
	 * 
	 * @author JungJin Park
	 * @param String invNo
	 * @param String ofc
	 * @return ARInvoiceByBLNoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ARInvoiceByBLNoVO searchInvoiceMainByInvoiceNo(String invNo, String ofc) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceByBLNoVO> list = null;
		ARInvoiceByBLNoVO aRInvoiceByBLNoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invNo != null && ofc != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("inv_no", invNo);
				mapVO.put("ofc", ofc);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOARInvoiceByINVNoVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceByBLNoVO.class);

			if (list != null && list.size() > 0) {
				aRInvoiceByBLNoVO = (ARInvoiceByBLNoVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return aRInvoiceByBLNoVO;
	}

	/**
	 * AR Invoice issue 테이블에서 office code, Invoice no에 조회하여 AR Invoice charge 테이블에서 조회하여 Currency별로 Summary 하여 가져온다.<br>
	 * 
	 * @author JungJin Park
	 * @param String invNo
	 * @param String ofc
	 * @return List< ARInvoiceChargeSumVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceChargeSumVO> searchInvoiceChargeSumByInvoiceNo(String invNo, String ofc) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceChargeSumVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invNo != null && ofc != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("inv_no", invNo);
				mapVO.put("ofc", ofc);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOARInvoiceChargeSumVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceChargeSumVO.class);
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
	 * AR Invoice issue 테이블에서 office code, Invoice no에 조회하여 AR Invoice charge 테이블에서 조회하여 Charge별로 Summary 하여 가져온다.<br>
	 * 
	 * @author JungJin Park
	 * @param String invNo
	 * @param String ofc
	 * @return List< ARInvoiceChargeByBLNoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceChargeByBLNoVO> searchInvoiceChargeByInvoiceNo(String invNo, String ofc) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceChargeByBLNoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invNo != null && ofc != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("inv_no", invNo);
				mapVO.put("ofc", ofc);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOARInvoiceChargeByINVNoVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceChargeByBLNoVO.class);
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
	 * Issue date 기간 및 기타 조회조건에 해당하는 Issue 한 AR Invoice 정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param InvoiceIssueDateVO issueDateVo
	 * @return List< ARInvoiceIssueDateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceIssueDateVO> searchInvoiceListByIssueDate(InvoiceIssueDateVO issueDateVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceIssueDateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (issueDateVo != null) {
				Map<String, String> mapVO = issueDateVo.getColumnValues();

				String vvd = "";
				String vslCd = "";
				String skdVoyNo = "";
				String skdDirCd = "";
				vvd = issueDateVo.getVvd();
				if (!"".equals(vvd)) {
					vslCd = vvd.substring(0, 4);
					skdVoyNo = vvd.substring(4, 8);
					skdDirCd = vvd.substring(8, 9);
				}
				mapVO.put("vsl_cd", vslCd);
				mapVO.put("skd_voy_no", skdVoyNo);
				mapVO.put("skd_dir_cd", skdDirCd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOInvoiceIssueDateVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceIssueDateVO.class);
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
	 * Issue date 기간 및 기타 조회조건에 해당하는 Issue 한 AR Invoice LocalSum을 구한다<br>
	 * 
	 * @author JungJin Park
	 * @param InvoiceIssueDateVO issueDateVo
	 * @return String
	 * @exception DAOException
	 */
	public String searchInvoiceListByIssueDateSum(InvoiceIssueDateVO issueDateVo) throws DAOException {
		DBRowSet dbRowset = null;
		String ttlLoclAmt = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		
		try {
			if (issueDateVo != null) {
				Map<String, String> mapVO = issueDateVo.getColumnValues();

				String vvd = "";
				String vslCd = "";
				String skdVoyNo = "";
				String skdDirCd = "";
				vvd = issueDateVo.getVvd();
				if (!"".equals(vvd)) {
					vslCd = vvd.substring(0, 4);
					skdVoyNo = vvd.substring(4, 8);
					skdDirCd = vvd.substring(8, 9);
				}
				mapVO.put("vsl_cd", vslCd);
				mapVO.put("skd_voy_no", skdVoyNo);
				mapVO.put("skd_dir_cd", skdDirCd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOInvoiceIssueDateSumVORSQL(), param, velParam);
			if(dbRowset.next()) {
				ttlLoclAmt = dbRowset.getString("ttl_locl_amt");
	    	}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return ttlLoclAmt;
	}
	
	/**
	 * 조회조건 issue date기간에 해당하는 정보를 AR Invoice issue 테이블에서 office code 및 기타정보로 TVA CHARGE가 포함된 데이터를 조회하여 엑셀파일로 다운로드 할수있도록 데이터를 생성한다.<br>
	 * 
	 * @author JungJin Park
	 * @param InvoiceIssueListInputVO invTvaVo
	 * @return List< InvoiceIssueTVAListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceIssueTVAListVO> searchInvoiceTvaListByDate(InvoiceIssueListInputVO invTvaVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceIssueTVAListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invTvaVo != null) {
				// Map<String, String> mapVO = new HashMap<String, String>();
				Map<String, String> mapVO = invTvaVo.getColumnValues();

				String vvd = "";
				String vslCd = "";
				String skdVoyNo = "";
				String skdDirCd = "";
				vvd = invTvaVo.getVvd();
				if (!"".equals(vvd)) {
					vslCd = vvd.substring(0, 4);
					skdVoyNo = vvd.substring(4, 8);
					skdDirCd = vvd.substring(8, 9);
				}
				mapVO.put("vsl_cd", vslCd);
				mapVO.put("skd_voy_no", skdVoyNo);
				mapVO.put("skd_dir_cd", skdDirCd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOInvoiceIssueTVAListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvoiceIssueTVAListVO.class);
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
	 * BKG VVD와 조회조건 PORT(POL) 로 운항스케쥴(VSL_PORT_SKD)의 VPS_ETD_DT와 비교하여 해당 하는 데이터에 대하여 Booking정보에서 O/B에 해당하는(PPD) 컨테이너정보 및 Rating금액를 조회한다. <br>
	 * 
	 * @param String frDate
	 * @param String toDate
	 * @param String port
	 * @return List<BKGForTaxByDateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGForTaxByDateVO> searchVIEBookingListByDate(String frDate, String toDate, String port) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGForTaxByDateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("frDate", frDate);
			mapVO.put("toDate", toDate);
			mapVO.put("port", port);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOsearchVIEBookingListByDateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGForTaxByDateVO.class);
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
	 * AR Invoice main에서 office code, Bl No, BKG NO에 조회한 내용중 Max I/F No를 AR Invoice main 테이블에서 조회하여 가져온다.
	 * 
	 * @author JungJin Park
	 * @param ARInvoiceInputByBLNoVO invInput
	 * @return String
	 * @exception DAOException
	 */
	public String searchARInvoiceMaxIfNo(ARInvoiceInputByBLNoVO invInput) throws DAOException {
		DBRowSet dbRowset = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			// B/L No와 BKG No가 동시에 입력됐을 경우 B/L No을 우선으로 조회한다.
			String blSrcNo = invInput.getBlSrcNo();
			if (!"".equals(blSrcNo)) {
				invInput.setBkgNo("");
			}

			Map<String, String> mapVO = invInput.getColumnValues();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOARInvoiceMaxIfNoRSQL(), param, velParam);

			if (dbRowset != null && dbRowset.next()) {
				return dbRowset.getString("AR_IF_NO");
			} else {
				throw new DAOException(new ErrorHandler("COM10001", new String[] {}).getUserMessage());
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
	 * office code, Bl No, BKG NO로 AR Invoice main 테이블에서 구한 Max Interface No로 의 상세 및 History 정보 와 해당 BL의 Customer 신용정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String maxIfNo
	 * @return ARInvoiceByBLNoVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ARInvoiceByBLNoVO searchARInvoiceMainByBlNo(String maxIfNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceByBLNoVO> list = null;
		ARInvoiceByBLNoVO aRInvoiceByBLNoVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (maxIfNo != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("max_if_no", maxIfNo);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOARInvoiceByBLNoVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceByBLNoVO.class);

			if (list != null && list.size() > 0) {
				aRInvoiceByBLNoVO = (ARInvoiceByBLNoVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return aRInvoiceByBLNoVO;
	}

	/**
	 * 1. AR Invoice main에서 office code, Bl No, BKG NO에 조회한 내용중 Max I/F No에 해당하는 charge의 Ex rate 를 구하고<br>
	 * 금액부분은 office code, Bl No, BKG NO에 해당하는 데이터 전체를 SUM하여 가져온다.<br>
	 * 2. I/F NO이외의 다른 조건이 NULL인 경우는 I/F NO에 해당하는 데이터만 SUM하도록한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String IfNo
	 * @return List< ARInvoiceChargeSumVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceChargeSumVO> searchARInvoiceChargeSum(String IfNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceChargeSumVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (IfNo != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("max_if_no", IfNo);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchARInvoiceChargeSumRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceChargeSumVO.class);
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
	 * AR Invoice main에서 office code, Bl No, BKG NO에 해당하는 interface 내용 전체를 AR Invoice main 및 charge 테이블에서 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param ARInvoiceInputByBLNoVO invInput
	 * @return List< ARInvoiceHistoryByBLNoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceHistoryByBLNoVO> searchARInvoiceHistoryListByBLNo(ARInvoiceInputByBLNoVO invInput) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceHistoryByBLNoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invInput != null) {
				// B/L No와 BKG No가 동시에 입력됐을 경우 B/L No을 우선으로 조회한다.
				String blSrcNo = invInput.getBlSrcNo();
				if (!"".equals(blSrcNo)) {
					invInput.setBkgNo(null);
				}

				Map<String, String> mapVO = invInput.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOARInvoiceHistoryListByBLNoVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceHistoryByBLNoVO.class);
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
	 * office code, Bl No, BKG NO로 AR Invoice main 테이블에서 구한 Max Interface No로 의 상세 및 History 정보 와 해당 BL의 Customer 신용정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param ARInvoiceInputByBLNoVO invInput
	 * @return List< ARInvoiceChargeByBLNoVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceChargeByBLNoVO> searchARInvoiceChargeByBlNo(ARInvoiceInputByBLNoVO invInput) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceChargeByBLNoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invInput != null) {
				// B/L No와 BKG No가 동시에 입력됐을 경우 B/L No을 우선으로 조회한다.
				String blSrcNo = invInput.getBlSrcNo();
				if (!"".equals(blSrcNo)) {
					invInput.setBkgNo(null);
				}

				Map<String, String> mapVO = invInput.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOARInvoiceChargeByBLNoVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceChargeByBLNoVO.class);
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
	 * Max I/F No에 해당하는 AR Invoice container 정보를 테이블에서 조회한다.<br>
	 * INV_AR_CNTR에서 AR_IF_NO로 조회<br>
	 * 
	 * @author JungJin Park
	 * @param String maxIfNo
	 * @return List< ARInvoiceContainerVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceContainerVO> searchContainerNoList(String maxIfNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceContainerVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (maxIfNo != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("max_if_no", maxIfNo);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchContainerNoListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceContainerVO.class);
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
	 * Thailand Office(BKKSC)의 BKG 데이터를 VVD 조건으로 Prepaid, Collect 로 구분하여 데이터를 가져온다. <br>
	 * 
	 * @param String vvd
	 * @return List<BKGForTaxByVesselVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<BKGForTaxByVesselVO> searchThaiBookingListByVVD(String vvd) throws DAOException {
		DBRowSet dbRowset = null;
		List<BKGForTaxByVesselVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("vvd", vvd);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOsearchThaiBookingListByVVDRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGForTaxByVesselVO.class);
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
	 * India Office(BOMSC, BOMBA)의 BKG 데이터를 VVD or S/A date, Bound, Port 조건으로 Prepaid, Collect 로 구분하여 BKG Rate 및 Cntr 데이터를 가져온다. <br>
	 * 
	 * @param ARInvoiceInquiryInPutVO indBkgVO
	 * @return List<BKGForTaxByVesselVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
//	public List<BKGForTaxByVesselVO> searchIndiaBookingListByVVD(String vvd, String bnd, String port) throws DAOException {
	public List<BKGForTaxByVesselVO> searchIndiaBookingListByVVD(ARInvoiceInquiryInPutVO indBkgVO) throws DAOException {
	
		DBRowSet dbRowset = null;
		List<BKGForTaxByVesselVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {  
			if (indBkgVO != null) {
				
				Map<String, String> mapVO = indBkgVO.getColumnValues();
		    	param.putAll(mapVO);
			    velParam.putAll(mapVO);
			}  

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOsearchIndiaBookingListByVVDRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, BKGForTaxByVesselVO.class);
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
	 * Max I/F No로 AR Invoice main 테이블의 상세 및 해당 BL의 Customer 신용정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String ifNo
	 * @param String ofc
	 * @return ARInvoiceCorrectionVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public ARInvoiceCorrectionVO searchARInvoiceMain(String ifNo, String ofc) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceCorrectionVO> list = null;
		ARInvoiceCorrectionVO invoiceCorrectionVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ifNo != null) {
//				String ifNoOldYn = "N";
//				if (ifNo.length() == 10) {
//					ifNoOldYn = "Y";
//				}
				String viewIfNo = ""; 
				if (ifNo.length() == 10) {
					if (ifNo.substring(3, 4).equals("M")) {
						if (ifNo.substring(4, 5).equals("0")) {
							viewIfNo = ifNo.substring(0, 4)+"1"+ifNo.substring(4, 10);
						}
						else {
							viewIfNo = ifNo.substring(0, 4)+"0"+ifNo.substring(4, 10);
						}
					}
					else {
						viewIfNo = ifNo.substring(0, 3)+"0"+ifNo.substring(3, 10);
					}
				}
				else {
					viewIfNo = ifNo;
				}
				
					
				Map<String, String> mapVO = new HashMap<String, String>();
				
				
				mapVO.put("ar_if_no", viewIfNo);
				mapVO.put("ofc_cd", ofc);
//				mapVO.put("if_no_old_yn", ifNoOldYn);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchARInvoiceMainRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceCorrectionVO.class);

			if (list != null && list.size() > 0) {
				invoiceCorrectionVO = (ARInvoiceCorrectionVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return invoiceCorrectionVO;
	}

	/**
	 * AR Invoice main에서 office code, Bl No, BKG NO에 해당하는 charge를 AR Invoice Charge 테이블에서 전체 I/F된 내용을 SUM하여 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String ifNo
	 * @return List< ARInvoiceChargeCorrectionVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceChargeCorrectionVO> searchARInvoiceCharge(String ifNo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceChargeCorrectionVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ifNo != null) {
				Map<String, String> mapVO = new HashMap<String, String>();

				mapVO.put("ar_if_no", ifNo);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchARInvoiceChargeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceChargeCorrectionVO.class);
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
	 * Issue후 Email발송 및 Fax 전송한 내역을 조회조건에 따라 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param FaxEmailSentDateVO sendDateVo
	 * @return List<FaxEmailSentResultVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<FaxEmailSentResultVO> searchFaxEmailSentResultListBySendDate(FaxEmailSentDateVO sendDateVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<FaxEmailSentResultVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (sendDateVo != null) {
				
				String dateType = sendDateVo.getDateType();
				String fromDt = sendDateVo.getFromDt();
				String toDt   = sendDateVo.getToDt();
				String ofcCd = sendDateVo.getOfcCd();
				String userOfcCd = sendDateVo.getUserOfcCd();
				if(ofcCd.equals("")){
					ofcCd = userOfcCd;
				}
		
				if(dateType.equals("S")){
					List list01 = searchGlobalDate(fromDt,toDt,ofcCd);
					fromDt = list01.get(0).toString();
					toDt = list01.get(1).toString();
					
					sendDateVo.setFromDt(fromDt);
					sendDateVo.setToDt(toDt);

				} 
				
				String ioBndCd = sendDateVo.getIoBndCd();
				if (ioBndCd.equals("A")) {
					sendDateVo.setIoBndCd("");
				}

				Map<String, String> mapVO = sendDateVo.getColumnValues();

				String vvd = "";
				String vslCd = "";
				String skdVoyNo = "";
				String skdDirCd = "";

				vvd = sendDateVo.getVvd();
				if (!"".equals(vvd)) { 
					vslCd = vvd.substring(0, 4);
					skdVoyNo = vvd.substring(4, 8);
					skdDirCd = vvd.substring(8, 9);
				}
				mapVO.put("vsl_cd", vslCd);
				mapVO.put("skd_voy_no", skdVoyNo);
				mapVO.put("skd_dir_cd", skdDirCd);
				
				//Sent By 세팅
				log.info("sendDateVo.getSentBy()===>>>"+sendDateVo.getSentBy());
				if(!sendDateVo.getSvrId().equals("KOR")){
					String sentBy = sendDateVo.getSentBy();
					StringTokenizer st = new StringTokenizer(sentBy, ",");
					String uSentBy = "";
					String strSentBy = "";
					while (st.hasMoreTokens()) {
						uSentBy = st.nextToken();
						if (uSentBy.equals("")) {
							strSentBy = "";
						}else{
							strSentBy = strSentBy+"'," + "'"+uSentBy;
						}					
					}
					if(!strSentBy.equals("")){
						strSentBy = strSentBy + "";
					}
					mapVO.put("sent_by", strSentBy);
				}
				
				param.putAll(mapVO);
				velParam.putAll(mapVO); 
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOFaxEmailSentResultVORSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, FaxEmailSentResultVO.class);
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
	 * Spakin VLCSC Officed의 local SYSTEM용 엑셀데이터를 만들기 위한 데이터 조회.<br>
	 * issue date 기준으로 조회하며 .정해진 item 정보를 조회해 온다.<br>
	 * 
	 * @author JungJin Park
	 * @param String ofcCd
	 * @param String issDate
	 * @return List<SpainInvoiceEDIListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<SpainInvoiceEDIListVO> searchSpainInvoiceEDIList(String ofcCd, String issDate) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpainInvoiceEDIListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ofcCd != null && issDate != null) {
				Map<String, String> mapVO = new HashMap<String, String>();

				mapVO.put("ar_ofc_cd", ofcCd);
				mapVO.put("iss_dt", issDate.replaceAll("-", ""));

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchSpainInvoiceEDIListRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SpainInvoiceEDIListVO.class);
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
	 * Office code,issue date/ Good date로 issue date와 S/A date간의 Trem별 현황데이터를 조회해 온다.<br>
	 * 
	 * @author JungJin Park
	 * @param InvoiceTermAnalysisInputVO invTermAnlsVo
	 * @return List< InvoiceTermAnalysisVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceTermAnalysisVO> searchInvoiceIssueTermByDate(InvoiceTermAnalysisInputVO invTermAnlsVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceTermAnalysisVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invTermAnlsVo != null) {
				Map<String, String> mapVO = invTermAnlsVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchInvoiceIssueTermByDateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvoiceTermAnalysisVO.class);
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
	 * Invoice Detail Inquiry by Date & Charge 데이터를 조회해 온다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @param ARInvoiceInquiryInPutVO invDtlVO
	 * @return List< InvoiceDetailListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceDetailListVO> searchDetailInvoiceListByDate(ARInvoiceInquiryInPutVO invDtlVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceDetailListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invDtlVO != null) {
				Map<String, String> mapVO = invDtlVO.getColumnValues();
				
				String revSrcCd = invDtlVO.getRevSrcCd();
				
				StringTokenizer st = new StringTokenizer(revSrcCd, ",");
				String uRevSrcCd = "";
				String strRevSrcCd = "";
				while (st.hasMoreTokens()) {
					uRevSrcCd = st.nextToken();
					if (uRevSrcCd.equals("")) {
						strRevSrcCd = "";
					}else{
						strRevSrcCd = strRevSrcCd+"'," + "'"+uRevSrcCd;
					}
					/*
					if (!strRevSrcCd.equals("")) {
						dbDao.addMiscBlckChg(ofc, strChgCd, userId);
					}*/
				}
				if(!strRevSrcCd.equals("")){
					strRevSrcCd = strRevSrcCd + "";
				}
				mapVO.put("rev_src_cd", strRevSrcCd);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOInvoiceDetailListVORSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvoiceDetailListVO.class);
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
	 * Customer의 Invoice 미발행내용을 현재일로부터 조회기간 사이에 해당하는 due date데이터를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param NotissuedInputVO notIssVo
	 * @return List<NotIssuedListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<NotIssuedListVO> searchNotIssueListByCustomer(NotissuedInputVO notIssVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<NotIssuedListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (notIssVo != null) {
				Map<String, String> mapVO = notIssVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchNotIssueListByCustomerRSQL(), param, velParam);

			list = (List) RowSetUtil.rowSetToVOs(dbRowset, NotIssuedListVO.class);
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
	 * Customer의 I/B, O/B 별로 Invoice 미발행건수 및 Due date까지 남은 일수를 현재일로부터 날짜수 조건에 따라 집계한다.<br>
	 * 
	 * @author JungJin Park
	 * @param NotIssuedAgingInputVO notIssAgingVo
	 * @return List<NotIssuedAgingVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<NotIssuedAgingVO> searchNotIssueAgingByCustomer(NotIssuedAgingInputVO notIssAgingVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<NotIssuedAgingVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (notIssAgingVo != null) {
				Map<String, String> mapVO = notIssAgingVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchNotIssueAgingByCustomerRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, NotIssuedAgingVO.class);
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
	 * 조회조건에 따라 Good Date or Issue date에 해당하는 AR Invoice Summary정보를 조회한다.<br>
	 * 
	 * @author JungJin Park
	 * @param ARInvoiceInquiryInPutVO invSumVo
	 * @return List<InvoiceSummaryListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceSummaryListVO> searchSummaryInvoiceListByDate(ARInvoiceInquiryInPutVO invSumVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceSummaryListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invSumVo != null) {
				StringBuffer sb = new StringBuffer();
				if(!invSumVo.getRevSrcCd().equals("") || invSumVo.getRevSrcCd() !=null) {
					String arrRevSrcCd[] = invSumVo.getRevSrcCd().split(",");
					
					if(arrRevSrcCd.length > 0) {
						if(!arrRevSrcCd[0].equals("A")) {
							sb.append(" AND A.REV_SRC_CD IN (");
							
							for (int i=0; i<arrRevSrcCd.length; i++) {
								if(i == 0) {
									sb.append("'"+arrRevSrcCd[i]+"'");
								} else {
									sb.append(",'"+arrRevSrcCd[i]+"'");
								}
							}
							sb.append(")");
						}
					}
				}
				
				
				log.debug("");
				
				invSumVo.setRevSrcCd(sb.toString());
				
				Map<String, String> mapVO = invSumVo.getColumnValues();

				String vvd = "";
				String vslCd = "";
				String skdVoyNo = "";
				String skdDirCd = "";

				vvd = invSumVo.getVvd();
				if (!"".equals(vvd)) {
					vslCd = vvd.substring(0, 4);
					skdVoyNo = vvd.substring(4, 8);
					skdDirCd = vvd.substring(8, 9);
				}
				mapVO.put("vsl_cd", vslCd);
				mapVO.put("skd_voy_no", skdVoyNo);
				mapVO.put("skd_dir_cd", skdDirCd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchSummaryInvoiceListByDateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvoiceSummaryListVO.class);
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
	 * Issue date 기간 및 기타 조회조건에 해당하는 Issue 한 AR Invoice 정보를 조회한다.(POP-UP용. Re-Issue 화면에서 사용). <br>
	 * 
	 * @param InvoiceIssueDateVO issueDateVo
	 * @return List<ARInvoiceIssueDateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceIssueDateVO> searchPopInvoiceListByIssueDate(InvoiceIssueDateVO issueDateVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceIssueDateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (issueDateVo != null) {
				Map<String, String> mapVO = issueDateVo.getColumnValues();

				String vvd = "";
				String vslCd = "";
				String skdVoyNo = "";
				String skdDirCd = "";
				vvd = issueDateVo.getVvd();
				if (!"".equals(vvd)) {
					vslCd = vvd.substring(0, 4);
					skdVoyNo = vvd.substring(4, 8);
					skdDirCd = vvd.substring(8, 9);
				}
				mapVO.put("vsl_cd", vslCd);
				mapVO.put("skd_voy_no", skdVoyNo);
				mapVO.put("skd_dir_cd", skdDirCd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOInvoiceIssueDateVOPopRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceIssueDateVO.class);
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
	 * Invoice Inquiry by Date & VVD 화면 하단용 Summary.<br>
	 * INV_AR_MN, INV_AR_CHG에서 조회조건에 해당하는 BL count, Grand USD Total, Grand LCL Total을 구함.<br>
	 * 
	 * @author JungJin Park
	 * @param ARInvoiceInquiryInPutVO invByGoodVO
	 * @return InvoiceSumVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public InvoiceSumVO searchARInvoiceSumByGoodDate(ARInvoiceInquiryInPutVO invByGoodVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceSumVO> list = null;
		InvoiceSumVO invoiceSumVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invByGoodVO != null) {
				Map<String, String> mapVO = invByGoodVO.getColumnValues();
				
				String revSrcCd = invByGoodVO.getRevSrcCd();
				
				StringTokenizer st = new StringTokenizer(revSrcCd, ",");
				String uRevSrcCd = "";
				String strRevSrcCd = "";
				while (st.hasMoreTokens()) {
					uRevSrcCd = st.nextToken();
					if (uRevSrcCd.equals("")) {
						strRevSrcCd = "";
					}else{
						strRevSrcCd = strRevSrcCd+"'," + "'"+uRevSrcCd;
					}
					/*
					if (!strRevSrcCd.equals("")) {
						dbDao.addMiscBlckChg(ofc, strChgCd, userId);
					}*/
				}
				if(!strRevSrcCd.equals("")){
					strRevSrcCd = strRevSrcCd + "";
				}
				
				mapVO.put("rev_src_cd", strRevSrcCd);	

				String vvd = "";
				String vslCd = "";
				String skdVoyNo = "";
				String skdDirCd = "";
				vvd = invByGoodVO.getVvd();
				if (!"".equals(vvd)) {
					vslCd = vvd.substring(0, 4);
					skdVoyNo = vvd.substring(4, 8);
					skdDirCd = vvd.substring(8, 9);
				}
				mapVO.put("vsl_cd", vslCd);
				mapVO.put("skd_voy_no", skdVoyNo);
				mapVO.put("skd_dir_cd", skdDirCd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchARInvoiceSumByGoodDateRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvoiceSumVO.class);

			if (list != null && list.size() > 0) {
				invoiceSumVO = (InvoiceSumVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return invoiceSumVO;
	}

	/**
	 * MDM_ORGANIGATION에서 RHQ(AR_HD_QTR_OFC_CD)에 해당하는 Office code의 list를 구해온다.<br>
	 * 
	 * @author JungJin Park
	 * @return List<String>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchARRHQOfficeList() throws DAOException {
		DBRowSet dbRowset = null;

		List list = new ArrayList();
		String arOfcCd = "";

		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchARRHQOfficeListRSQL(), param, velParam);

			while (dbRowset.next()) {
				arOfcCd = dbRowset.getString("ar_ofc_cd");

				list.add(arOfcCd);
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
	 * RHQ를 조건으로 BOMSC Office 아닌 타 Office 의 채권 데이터중 Option에 따라서 I/F date or S/A date를 비교하여 "GST"CHarge 가 있는 대상을 조회하여 USD, INR Currnecy로 환산하여 보여줌.<br>
	 * USD, INR Currnecy환산금액은 채권데이터의 GL_EFF_DT기준 경리환율로 계산한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String dateOption
	 * @param String fromDate
	 * @param String toDate
	 * @param String rhq
	 * @return List< GSTChargeListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<GSTChargeListVO> searchGSTListByDate(String dateOption, String fromDate, String toDate, String rhq) throws DAOException {
		DBRowSet dbRowset = null;
		List<GSTChargeListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (dateOption != null && fromDate != null && toDate != null && rhq != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("date_option", dateOption);
				mapVO.put("from_date", fromDate);
				mapVO.put("to_date", toDate);
				mapVO.put("ar_hd_qtr_ofc_cd", rhq);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchGSTListByDateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GSTChargeListVO.class);
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
	 * Issue date 기간 및 기타 조회조건에 해당하는 Issue 한 AR Invoice 정보를 조회한다.(POP-UP용. Re-Issue 화면에서 사용). <br>
	 * 
	 * @param InvoiceIssueDateVO issueDateVo
	 * @return List<ARInvoiceListByIFDateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceListByIFDateVO> searchPopSGNBBInvoiceListByIssueDate(InvoiceIssueDateVO issueDateVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceListByIFDateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (issueDateVo != null) {
				Map<String, String> mapVO = issueDateVo.getColumnValues();
				
				String invtype = issueDateVo.getInvType();
				StringTokenizer st = new StringTokenizer(invtype, ",");
				String invTypeValue = "";
				String invType1 = "";
				String invType2 = "";
				String invType3 = "";
				String invType4 = "";
				String invType5 = "";
				String invType6 = "";
				String invType7 = "";
				String invType8 = "";
				
				while (st.hasMoreTokens()) {
					invTypeValue = st.nextToken();
					if(invTypeValue.equals("F")) {
						invType1 = invTypeValue;
					}else if(invTypeValue.equals("T")) {
						invType2 = invTypeValue;
					}else if(invTypeValue.equals("H")) {
						invType3 = invTypeValue;
					}else if(invTypeValue.equals("D")) {
						invType4 = invTypeValue;
					}else if(invTypeValue.equals("R")) {
						invType5 = invTypeValue;
					}else if(invTypeValue.equals("M")) {
						invType6 = invTypeValue;
					}else if(invTypeValue.equals("S")) {
						invType7 = invTypeValue;
					}else if(invTypeValue.equals("C")) {
						invType8 = invTypeValue;
					}
					
				}
				
				mapVO.put("inv_type1", invType1);
				mapVO.put("inv_type2", invType2);
				mapVO.put("inv_type3", invType3);
				mapVO.put("inv_type4", invType4);
				mapVO.put("inv_type5", invType5);
				mapVO.put("inv_type6", invType6);
				mapVO.put("inv_type7", invType7);
				mapVO.put("inv_type8", invType8);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchPopSGNBBInvoiceListByIssueDateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceListByIFDateVO.class);
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
	 * 1. AR Invoice main에서 office code, Bl No, BKG NO에 조회한 내용중 Max I/F No에 해당하는 charge의 Ex rate 를 구하고<br>
	 * 금액부분은 office code, Bl No, BKG NO에 해당하는 데이터 전체를 SUM하여 가져온다.<br>
	 * 2. I/F NO이외의 다른 조건이 NULL인 경우는 I/F NO에 해당하는 데이터만 SUM하도록한다.<br>
	 * 
	 * @author JungJin Park
	 * @param ARInvoiceInputByBLNoVO invInput
	 * @return List<ARInvoiceChargeSumVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceChargeSumVO> searchARInvoiceChargeSumByBLNo(ARInvoiceInputByBLNoVO invInput) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceChargeSumVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invInput != null) {
				String blSrcNo = invInput.getBlSrcNo();
				if (!"".equals(blSrcNo)) {
					invInput.setBkgNo(null);
				}

				Map<String, String> mapVO = invInput.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOARInvoiceChargeSumByBLNoVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceChargeSumVO.class);
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
	 * Sales Office의 A/R OFFICE CODE의 정보(INV_AR_STUP_OFC- INV_DUP_FLG)를 조회한다.<br>
	 * UI_INV_0009의 PopUp화면으로 오픈시 사용됨.<br>
	 * 
	 * @author JungJin Park
	 * @param String saleOfc
	 * @return AROfficeListVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public AROfficeListVO searchAROffice(String saleOfc) throws DAOException {
		DBRowSet dbRowset = null;
		List<AROfficeListVO> list = null;
		AROfficeListVO arOfficeListVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (saleOfc != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("ofc_cd", saleOfc);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchAROfficeRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, AROfficeListVO.class);

			if (list != null && list.size() > 0) {
				arOfficeListVO = (AROfficeListVO) list.get(0);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return arOfficeListVO;
	}

	/**
	 * INVCommonDAO의 arOfcCd에 해당되는 값을 불러온다.<br>
	 * 
	 * @param String blNo
	 * @param String bkgNo
	 * @param String ofc
	 * @return List<String>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchARInvoiceOfcListByBLNo(String blNo, String bkgNo, String ofc) throws DAOException {
		DBRowSet dbRowset = null;

		List list = new ArrayList();

		String arOfcCd = "";
		String invDupFlg = "";

		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_src_no", blNo);
			mapVO.put("bkg_no", bkgNo);
			mapVO.put("ofc_cd", ofc);

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchARInvoiceOfcListByBLNoRSQL(), param, velParam);
			while (dbRowset.next()) {
				arOfcCd = dbRowset.getString("ar_ofc_cd");
				invDupFlg = dbRowset.getString("inv_dup_flg");

				list.add(arOfcCd + "," + invDupFlg);
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
	 * 조회조건 issue date기간에 해당하는 정보를 AR Invoice issue 테이블에서 office code 및 기타정보로 TVA CHARGE가 포함된 데이터를 조회하여 엑셀파일로 다운로드 할수있도록 데이터를 생성한다.<br>
	 * 
	 * @author JungJin Park
	 * @param InvoiceIssueListInputVO invTvaVo
	 * @return List< InvoiceIssueTVAListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceIssueTVAListVO> searchInvoiceSGNBBVatListByDate(InvoiceIssueListInputVO invTvaVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceIssueTVAListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invTvaVo != null) {
				Map<String, String> mapVO = invTvaVo.getColumnValues();

				String vvd = "";
				String vslCd = "";
				String skdVoyNo = "";
				String skdDirCd = "";
				vvd = invTvaVo.getVvd();
				if (!"".equals(vvd)) {
					vslCd = vvd.substring(0, 4);
					skdVoyNo = vvd.substring(4, 8);
					skdDirCd = vvd.substring(8, 9);
				}
				mapVO.put("vsl_cd", vslCd);
				mapVO.put("skd_voy_no", skdVoyNo);
				mapVO.put("skd_dir_cd", skdDirCd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchInvoiceSGNBBVatListByDateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvoiceIssueTVAListVO.class);
		} catch (SQLException se) {
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 조회조건 issue date기간에 해당하는 정보를 AR Invoice issue 테이블에서 office code 및 기타정보로 TVA CHARGE가 포함된 데이터를 조회하여 엑셀파일로 다운로드 할수있도록 데이터를 생성한다.<br>
	 * 
	 * @author JungJin Park
	 * @param InvoiceIssueListInputVO invTvaVo
	 * @return List< InvoiceIssueTVAListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceIssueTVAListVO> searchInvoiceSYDBBGstListByDate(InvoiceIssueListInputVO invTvaVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<InvoiceIssueTVAListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (invTvaVo != null) {
				Map<String, String> mapVO = invTvaVo.getColumnValues();

				String vvd = "";
				String vslCd = "";
				String skdVoyNo = "";
				String skdDirCd = "";
				vvd = invTvaVo.getVvd();
				if (!"".equals(vvd)) {
					vslCd = vvd.substring(0, 4);
					skdVoyNo = vvd.substring(4, 8);
					skdDirCd = vvd.substring(8, 9);
				}
				mapVO.put("vsl_cd", vslCd);
				mapVO.put("skd_voy_no", skdVoyNo);
				mapVO.put("skd_dir_cd", skdDirCd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchInvoiceSYDBBGstListByDateRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, InvoiceIssueTVAListVO.class);
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
	 * FNS_INV_0110<br>
	 * Issue 대상 (DXBSC)INV B/L Select<br>
	 * 
	 * @author Choi Woo-Seok
	 * @param GeneralInvoiceVO genInvVo
	 * @return List<DXBInvoiceListVO>
	 * @exception DAOException,Exception
	 */
	@SuppressWarnings("unchecked")
	public List<DXBInvoiceListVO> searchDXBInvoiceList(GeneralInvoiceVO genInvVo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<DXBInvoiceListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(genInvVo != null){
				Map<String, String> mapVO = genInvVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceInquiryDBDAODXBInvoiceListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, DXBInvoiceListVO .class);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * INV_AR_LOCL_CHG 있는 ar_ofc_cd를 조회한다.<br>
	 * 
	 * @author Dong Hoon Han
	 * @return List<String>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchLoclChgOfc() throws DAOException {
		DBRowSet dbRowset = null;

		List list = new ArrayList();
		String loclChgOfc = "";

		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchLoclChgOfcRSQL(), param, velParam);

			while (dbRowset.next()) {
				loclChgOfc = dbRowset.getString("ar_ofc_cd");

				list.add(loclChgOfc);
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
	 * Spakin VLCSC Officed의 local SYSTEM용 엑셀데이터를 만들기 위한 데이터 조회.<br>
	 * issue date 기준으로 조회하며 .정해진 item 정보를 조회해 온다.<br>
	 * 
	 * @param String ofcCd
	 * @param String issDate
	 * @return SpainInvoiceEDIListCountVO
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public SpainInvoiceEDIListCountVO searchSpainInvoiceEDIListCount(String ofcCd, String issDate) throws DAOException {
		DBRowSet dbRowset = null;
		List<SpainInvoiceEDIListCountVO> list = null;
		SpainInvoiceEDIListCountVO spainInvoiceEDIListCountVO = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (ofcCd != null && issDate != null) {
				Map<String, String> mapVO = new HashMap<String, String>();

				mapVO.put("ar_ofc_cd", ofcCd);
				mapVO.put("iss_dt", issDate.replaceAll("-", ""));

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchSpainInvoiceEDIListCountRSQL(), param, velParam, true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, SpainInvoiceEDIListCountVO.class);

			if (list != null && list.size() > 0) {
				spainInvoiceEDIListCountVO = (SpainInvoiceEDIListCountVO) list.get(0);
			}
			
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return spainInvoiceEDIListCountVO;
	}
	/**
	 * ERP I/F Error 내역을 조회한다.<br>
	 * @author KIM HYUN HWA
	 * @param  ErpErrorInputVO erpErrorInputVO
	 * @return List<ErpErrorVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ErpErrorVO> searchErpErrorList(ErpErrorInputVO erpErrorInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<ErpErrorVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (erpErrorInputVO != null) {
							
				String revSrcCd = erpErrorInputVO.getRevSrcCd();
				
				StringTokenizer st = new StringTokenizer(revSrcCd, ",");
				String uRevSrcCd = "";
				String strRevSrcCd = "";
				while (st.hasMoreTokens()) {
					uRevSrcCd = st.nextToken();
					if (uRevSrcCd.equals("")) {
						strRevSrcCd = "";
					}else{
						strRevSrcCd = strRevSrcCd+"'," + "'"+uRevSrcCd;
					}
				
				}
				if(!strRevSrcCd.equals("")){
					strRevSrcCd = strRevSrcCd + "";
				}
				
				Map<String, String> mapVO = erpErrorInputVO.getColumnValues();
		
				mapVO.put("rev_src_cd", strRevSrcCd);				
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOARInvoiceErpErrorListVORSQL(), param, velParam,true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ErpErrorVO.class);
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
	 * 세션정보Ofc소속의 RHQ를 조회한다.<br>
	 * UI_INV_0115.<br>
	 * 
	 * @author KIM HYUN HWA
	 * @param String useOfc
	 * @return String 
	 * @exception DAOException
	 */
	public String searchARRhqByUserId(String useOfc) throws DAOException {
		DBRowSet dbRowset = null;
		String rhq = "";
		Map<String, Object> param = new HashMap<String, Object>();

		try{
			param.put("useOfc", useOfc);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceInquiryDBDAOSearchARRhqByUserIdRSQL(), param, null);
			
			while (dbRowset.next()) {
				rhq = dbRowset.getString("ar_hd_qtr_ofc_cd");
			}

		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(),se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(),ex);
		}
		return rhq;
	}
	
	
	/**
	 * RHQ소속의 A/R OFFICE 조회한다.<br>
	 * UI_INV_0115.<br>
	 * 
	 * @author KIM HYUN HWA
	 * @param String rhq
	 * @param String usrOfc
	 * @return List<String> 
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchAROfficeListByRhq(String rhq, String usrOfc) throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();
		String arOfcCd = "";
//		String ofcCd = usrOfc;
		
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

//			 if (usrOfc.equals(rhq)){
//				 usrOfc ="RHQ";
				 
//			 } else {
//				 ofcCd = usrOfc;
//			 }
			 mapVO.put("usrOfc", usrOfc);
			 mapVO.put("rhq", rhq);

			 
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchAROfficeByRhqRSQL(), param, velParam);
			while (dbRowset.next()) {
				arOfcCd = dbRowset.getString("ar_ofc_cd");

				list.add(arOfcCd);
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
	 *  AR Invoice에서 ERP로 I/F한  Transaction을 조회한다.
	 * @param  TransDataComparisonReportInputVO transDataComparisonReportInputVO
	 * @return List<TransDataComparisonReportVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<TransDataComparisonReportVO> searchTransactionDataComparisonReportList( TransDataComparisonReportInputVO transDataComparisonReportInputVO) throws DAOException {
		DBRowSet dbRowset = null;
		List<TransDataComparisonReportVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (transDataComparisonReportInputVO != null) {
							
				String revSrcCd = transDataComparisonReportInputVO.getRevSrcCd();
				
				StringTokenizer st = new StringTokenizer(revSrcCd, ",");
				String uRevSrcCd = "";
				String strRevSrcCd = "";
				while (st.hasMoreTokens()) {
					uRevSrcCd = st.nextToken();
					if (uRevSrcCd.equals("")) {
						strRevSrcCd = "";
					}else{
						strRevSrcCd = strRevSrcCd+"'," + "'"+uRevSrcCd;
					}
				
				}
				if(!strRevSrcCd.equals("")){
					strRevSrcCd = strRevSrcCd + "";
				}
				
				Map<String, String> mapVO = transDataComparisonReportInputVO.getColumnValues();
		
				mapVO.put("rev_src_cd", strRevSrcCd);				
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchTransactionDataComparisonReportRSQL(), param, velParam,true);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, TransDataComparisonReportVO.class);
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
	 * AR에서 발생된 "Reverse Charge" Data 산출기능<br>
	 * 
	 * @param String arOfcCd
	 * @param String fmDt
	 * @param String toDt
	 * @return List<ReportForReverseChargeVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ReportForReverseChargeVO> searchReportForReverseChargeList(String arOfcCd, String fmDt, String toDt) throws DAOException {
		DBRowSet dbRowset = null;
		List<ReportForReverseChargeVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("ar_ofc_cd", arOfcCd);
			mapVO.put("fm_dt", fmDt);
			mapVO.put("to_dt", toDt);

			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOReportForReverseChargeListRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ReportForReverseChargeVO.class);
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
	 * Split된 Invoice 발행 정보를 Bl No 별로 조회한다.<br>
	 * 
	 * @param blNo
	 * @param ofc
	 * @return
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<ARInvoiceChargeByBLNoVO> searchOtherSplitInvoicesForBL(String blNo, String ofc) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceChargeByBLNoVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("bl_no", blNo);
			mapVO.put("ofc", ofc);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOsearchOtherSplitInvoicesForBLRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceChargeByBLNoVO.class);
			
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
	 * Issue date 기간 및 기타 조회조건에 해당하는 Issue 한 AR Invoice 정보를 조회한다.(POP-UP용. Re-Issue 화면에서 사용). - SAOSC<br>
	 * 
	 * @param InvoiceIssueDateVO issueDateVo
	 * @return List<ARInvoiceIssueDateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<ARInvoiceIssueDateVO> searchPopSplitInvoiceListByIssueDate(InvoiceIssueDateVO issueDateVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<ARInvoiceIssueDateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (issueDateVo != null) {
				Map<String, String> mapVO = issueDateVo.getColumnValues();

				String vvd = "";
				String vslCd = "";
				String skdVoyNo = "";
				String skdDirCd = "";
				vvd = issueDateVo.getVvd();
				if (!"".equals(vvd)) {
					vslCd = vvd.substring(0, 4);
					skdVoyNo = vvd.substring(4, 8);
					skdDirCd = vvd.substring(8, 9);
				}
				mapVO.put("vsl_cd", vslCd);
				mapVO.put("skd_voy_no", skdVoyNo);
				mapVO.put("skd_dir_cd", skdDirCd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSplitInvoiceIssueDateVOPopRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, ARInvoiceIssueDateVO.class);
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
	 * 사용자가 EXCEL로 업로드한 Bl No의 Customer정보를 조회한다.<br>
	 * 
	 * @param blNos
	 * @return List<CustomerListByBLVO>
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public List<CustomerListByBLVO> searchCustomerListByBL(String blNos) throws DAOException {
		DBRowSet dbRowset = null;
		List<CustomerListByBLVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		List<String> headerList = null;
	
		try {
			
			int j = 0;
			headerList = new ArrayList<String>();
			StringTokenizer st = new StringTokenizer(blNos, ",");
			while( st.hasMoreTokens() ) {
				headerList.add(j++, st.nextToken());
			}
			
			velParam.put("keyList", headerList);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchCustomerListByBLRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, CustomerListByBLVO.class);
			
		} catch(SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex) {
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
		
	}
	
	/**
	 * FNS_INV_0138 AKLBA Invoice Detail 정보 조회 이벤트 처리<br>
	 * 
	 * @param BillInputVO billInputVO 
	 * @return List<InvoiceAKLBAVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<InvoiceAKLBAVO> searchInvoiceDetailForAKLBA(BillInputVO billInputVO) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<InvoiceAKLBAVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(billInputVO != null){
				Map<String, String> mapVO = billInputVO .getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceInquiryDBDAOSearchInvoiceDetailForAKLBARSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, InvoiceAKLBAVO .class);
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
	 * NYC Issue date 기간 및 기타 조회조건에 해당하는 Issue 한 AR Invoice 정보를 조회한다.<br>
	 * 
	 * @author Dosoon Choi
	 * @param InvoiceIssueDateVO issueDateVo
	 * @return List< NYCInvoiceIssueDateVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<NYCInvoiceIssueDateVO> searchNYCInvoiceListByIssueDate(InvoiceIssueDateVO issueDateVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<NYCInvoiceIssueDateVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (issueDateVo != null) {
				Map<String, String> mapVO = issueDateVo.getColumnValues();

				String vvd = "";
				String vslCd = "";
				String skdVoyNo = "";
				String skdDirCd = "";
				vvd = issueDateVo.getVvd();
				if (!"".equals(vvd)) {
					vslCd = vvd.substring(0, 4);
					skdVoyNo = vvd.substring(4, 8);
					skdDirCd = vvd.substring(8, 9);
				}
				mapVO.put("vsl_cd", vslCd);
				mapVO.put("skd_voy_no", skdVoyNo);
				mapVO.put("skd_dir_cd", skdDirCd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAONYCInvoiceIssueDateVORSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, NYCInvoiceIssueDateVO.class);
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
	 * GlobalDate 정보를 조회한다.<br>
	 * 
	 * @author Seungil Baek
	 * @param String fromDt 
	 * @param String toDt
	 * @param String ofcCd
	 * @return List<String>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchGlobalDate(String fromDt, String toDt, String ofcCd) throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();
		String from_dt = "";
		String to_dt = "";
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			
			Map<String, String> mapVO = new HashMap<String, String>();
			mapVO.put("from_dt", fromDt);
			mapVO.put("to_dt", toDt);
			mapVO.put("ofc_cd", ofcCd);
		
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOsearchGlobalDateRSQL(), param, velParam);
			while (dbRowset.next()) {
				from_dt = dbRowset.getString("FROM_DT");
				to_dt =   dbRowset.getString("TO_DT");
				list.add(from_dt);
				list.add(to_dt);

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
	 * RHQ를 조건으로 BOMSC Office 아닌 타 Office 의 채권 데이터중 Option에 따라서 I/F date or S/A date를 비교하여 "GST"CHarge 가 있는 대상을 조회하여 USD, INR Currnecy로 환산하여 보여줌.<br>
	 * USD, INR Currnecy환산금액은 채권데이터의 GL_EFF_DT기준 경리환율로 계산한다.<br>
	 * 
	 * @author JungJin Park
	 * @param String dateOption
	 * @param String fromDate
	 * @param String toDate
	 * @param String rhq
	 * @param String scNo
	 * @param String chgCd
	 * @return List< GCFSAFChargeListVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<GCFSAFChargeListVO> searchGCFSAFListByData(String dateOption, String fromDate, String toDate, String rhq, String chgCd, String scNo ) throws DAOException {
		DBRowSet dbRowset = null;
		List<GCFSAFChargeListVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (dateOption != null && fromDate != null && toDate != null && rhq != null && scNo != null && chgCd != null) {
				
				String strRhq = "'" + rhq.replaceAll(",", "','") + "'";
				String strChgCd = "'" + chgCd.replaceAll(",", "','") + "'";

				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("date_option", dateOption);
				mapVO.put("from_date", fromDate);
				mapVO.put("to_date", toDate);
				mapVO.put("ar_hd_qtr_ofc_cd", strRhq.toString());
				mapVO.put("sc_no", scNo);
				
				if(strChgCd.length() == 5){
					mapVO.put("chg_cd", strChgCd.toString());
				}else{
					mapVO.put("chg_cd", "'GCF','SAF','SAC'");
				} 
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchGCFSAFListByDataRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, GCFSAFChargeListVO.class);
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
	 * MDM_ORGANIGATION에서 RHQ(AR_HD_QTR_OFC_CD)에 해당하는 Office code의 list를 구해온다.<br>
	 * 
	 * @author JungJin Park
	 * @return List<String>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<String> searchGCFSAFRHQOfficeList() throws DAOException {
		DBRowSet dbRowset = null;

		List list = new ArrayList();
		String arOfcCd = "";

		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			Map<String, String> mapVO = new HashMap<String, String>();

			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOsearchGCFSAFRHQOfficeListRSQL(), param, velParam);

			while (dbRowset.next()) {
				arOfcCd = dbRowset.getString("ar_ofc_cd");

				list.add(arOfcCd);
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
	 * PCF Revenue, Expense 요율을 조회한다.<br>
	 * 
	 * @author SungYong Park
	 * @param String portCd
	 * @param String reDivrCd
	 * @return List<PCFRevExpnAmountVO>
	 * @exception DAOException
	 */
	@SuppressWarnings("unchecked")
	public List<PCFRevExpnAmountVO> searchPCFRevExpnAmount(String portCd, String reDivrCd) throws DAOException {
		DBRowSet dbRowset = null;
		List<PCFRevExpnAmountVO> list = null;
		// query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		// velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try {
			if (portCd != null && reDivrCd != null) {
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("port_cd", portCd);
				mapVO.put("re_divr_cd", reDivrCd);

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOSearchPCFRevExpnAmountRSQL(), param, velParam);
			list = (List) RowSetUtil.rowSetToVOs(dbRowset, PCFRevExpnAmountVO.class);
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
	 * INV_PCF_REV_EXPN_AMT 테이블에 insert<br>
	 * 
	 * @param List<PCFRevExpnAmountVO> pcfRevExpnAmountVOs
	 * @exception DAOException
	 */
	public void addPCFRevExpnAmount(List<PCFRevExpnAmountVO> pcfRevExpnAmountVOs) throws DAOException, Exception {
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        PCFRevExpnAmountVO pcfRevExpnAmountVO = null;
        
        int result = 0; 
        
		try {
			
			for(int i = 0; i < pcfRevExpnAmountVOs.size(); i++) {
	        	
				pcfRevExpnAmountVO = pcfRevExpnAmountVOs.get(i);
				
	        	if(pcfRevExpnAmountVO != null) {
		            Map<String, String> mapVO = pcfRevExpnAmountVO.getColumnValues();
		            
		            param.putAll(mapVO);
		            velParam.putAll(mapVO);
	        	}
	            
	            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new ARInvoiceInquiryDBDAOAddPCFRevExpnAmountCSQL(), param, velParam);
	            
	            if(result == Statement.EXECUTE_FAILED) {
	            	throw new DAOException("Fail to insert SQL");
	            }
        	} // end for(i)   
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * INV_PCF_REV_EXPN_AMT 테이블에 update<br>
	 * 
	 * @param List<PCFRevExpnAmountVO> pcfRevExpnAmountVOs
	 * @exception DAOException
	 */
	public void modifyPCFRevExpnAmount(List<PCFRevExpnAmountVO> pcfRevExpnAmountVOs) throws DAOException, Exception {
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        PCFRevExpnAmountVO pcfRevExpnAmountVO = null;
        
        int result = 0; 
        
		try {
			
			for(int i = 0; i < pcfRevExpnAmountVOs.size(); i++) {
	        	
				pcfRevExpnAmountVO = pcfRevExpnAmountVOs.get(i);
				
	        	if(pcfRevExpnAmountVO != null) {
		            Map<String, String> mapVO = pcfRevExpnAmountVO.getColumnValues();
		            
		            param.putAll(mapVO);
		            velParam.putAll(mapVO);
	        	}
	            
	            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new ARInvoiceInquiryDBDAOModifyPCFRevExpnAmountUSQL(), param, velParam);
	            
	            if(result == Statement.EXECUTE_FAILED) {
	            	throw new DAOException("Fail to update SQL");
	            }
        	} // end for(i)   
			
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * INV_PCF_REV_EXPN_AMT 테이블에 delete<br>
	 * 
	 * @param List<PCFRevExpnAmountVO> pcfRevExpnAmountVOs
	 * @exception DAOException
	 */
	public void removePCFRevExpnAmount(List<PCFRevExpnAmountVO> pcfRevExpnAmountVOs) throws DAOException, Exception {
		//query parameter
        Map<String, Object> param = new HashMap<String, Object>();
        //velocity parameter
        Map<String, Object> velParam = new HashMap<String, Object>();
        
        PCFRevExpnAmountVO pcfRevExpnAmountVO = null;
        
        int result = 0; 
        
		try {
			
			for(int i = 0; i < pcfRevExpnAmountVOs.size(); i++) {
	        	
				pcfRevExpnAmountVO = pcfRevExpnAmountVOs.get(i);
				
	        	if(pcfRevExpnAmountVO != null) {
		            Map<String, String> mapVO = pcfRevExpnAmountVO.getColumnValues();
		            
		            param.putAll(mapVO);
		            velParam.putAll(mapVO);
	        	}
	            
	            result = new SQLExecuter("").executeUpdate((ISQLTemplate)new ARInvoiceInquiryDBDAORemovePCFRevExpnAmountDSQL(), param, velParam);
	            
	            if(result == Statement.EXECUTE_FAILED) {
	            	throw new DAOException("Fail to delete SQL");
	            }
        	} // end for(i)   

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
	}

	/**
	 * PCF status 정보를 조회한다.<br>
	 * 
	 * @author Sungyong Park
	 * @param PCFStatusInfoInputVO pcfStatusInfoInputVo
	 * @return List<PCFStatusInfoVO>
	 * @exception DAOException,Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PCFStatusInfoVO> searchPCFStatusInfo(PCFStatusInfoInputVO pcfStatusInfoInputVo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		List<PCFStatusInfoVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(pcfStatusInfoInputVo != null){
				Map<String, String> mapVO = pcfStatusInfoInputVo.getColumnValues();

				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceInquiryDBDAOSearchPCFStatusInfoRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, PCFStatusInfoVO .class);
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
}