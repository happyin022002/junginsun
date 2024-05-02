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
=========================================================*/
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceChargeCorrectionVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoicecorrection.vo.ARInvoiceCorrectionVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.basic.ARInvoiceInquiryBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceByBLNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeByBLNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceChargeSumVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceContainerVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceHistoryByBLNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceInputByBLNoVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceInquiryInPutVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceIssueDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ARInvoiceListByIFDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRIDListInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRTInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRTInvoiceVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRTListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CPRTMainVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.CprtItemVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.DXBInvoiceListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ErpErrorInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.ErpErrorVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.FaxEmailSentDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.FaxEmailSentResultVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvCprtTmpltChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceIssueDateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.InvoiceSumVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotIssuedListVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.NotissuedInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.RptTmpltNmVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TemplateItemVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TemplateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TransDataComparisonReportInputVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.arinvoiceinquiry.vo.TransDataComparisonReportVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemgt.invoiceissue.vo.GeneralInvoiceVO;
import com.clt.apps.opus.fns.inv.invcommon.invcommon.vo.AROfficeListVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;

/**
 * ARInvoiceInquiryDBDAO <br>
 * - AccountReceivableInvoiceMgt system Business Logic을 처리하기 위한 JDBC 작업수행.<br>
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
	 * FNS_INV_0110<br>
	 * Issue 대상 (DXBBB)INV B/L Select<br>
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
	 * USER가 사용가능한 권한으로 등록된 Template name을 INV_CPRT_TMPLT테이블에서 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param String userId
	 * @param String ofc
	 * @return List<TemplateVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<TemplateVO> searchTemplateList(String userId, String ofc) throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();			
			mapVO.put("usr_id", userId);
			mapVO.put("ar_ofc_cd", ofc);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceInquiryDBDAOSearchTemplateListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TemplateVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 해당 Template으로 저장되어 있는 선택 item목록을 INV_CPRT_TMPLT테이블에서 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param String tmplate
 	 * @param CPRTInputVO cprInputVo
	 * @return List<TemplateItemVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<TemplateItemVO> searchTemplateItemList(String tmplate,  CPRTInputVO cprInputVo) throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();
		
		log.debug("DBDAO==================scNo===================================");
    	log.debug(cprInputVo.getScNo());
    	log.debug(cprInputVo.getArOfcCd());
		log.debug("DBDAO==================scNo END===================================");

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();			
			mapVO.put("rpt_tmplt_nm", tmplate);
			mapVO.put("ar_ofc_cd", cprInputVo.getArOfcCd());
			mapVO.put("sc_no", cprInputVo.getScNo());
			mapVO.put("rfa_no",  cprInputVo.getRfaNo());
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceInquiryDBDAOSearchTemplateItemListRSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, TemplateItemVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * CPR 에서 bl preview 조회시 bkg_no가 없을 경우, 조회한다. <br>
	 * 
	 * @author Dong Hoon Han
	 * @param String blNo
	 * @return String
	 * @exception DAOException
	 */
	public String searchBlNo(String blNo) throws DAOException,Exception {
		DBRowSet dbRowset = null;
		String bkgNo = "";
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();

			mapVO.put("bl_no", blNo);
			
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceInquiryDBDAOSearchBlNoRSQL(), param, velParam);
            if(dbRowset.next()) {						
            	bkgNo = dbRowset.getString("bkg_no");
	    	}
		} catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return bkgNo;
	}	
	
	/**
	 * CPRT 대상 데이터를 BL No 조건으로 BKG 테이블에서 조회함. <br>
	 * @author KIM HYUN HWA
	 * @param CPRTInputVO cprInputVo
	 * @param String rptItmId
	 * @return List<CPRTInvoiceVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CPRTInvoiceVO> searchCPRTByBL(CPRTInputVO cprInputVo, String rptItmId) throws DAOException {
		DBRowSet dbRowset = null;
		List list = new ArrayList();
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
				Map<String, String> mapVO = new HashMap<String, String>();
				mapVO.put("rpt_tmplt_nm", cprInputVo.getRptTmpltNm());
				mapVO.put("frt_term_cd", cprInputVo.getFrtTermCd()); 
				mapVO.put("bl_nos", cprInputVo.getBlNos()); 
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			
			List<String> cols  = new ArrayList();   
			
			StringTokenizer st = new StringTokenizer(rptItmId, "|");
			String strRptItmId = "";
			while (st.hasMoreTokens()) {
				strRptItmId = st.nextToken();
				if (!strRptItmId.equals("")) {
					cols.add(strRptItmId);
				}
			}
			param.put("allcols", cols);   
			velParam.put("allcols", cols);   

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceInquiryDBDAOCPRTInvoiceByMultiBLRSQL(), param, velParam, true);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CPRTInvoiceVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * CPRT 대상 데이터를 BKG 테이블에서 조회함. <br>
	 * @author Dong Hoon Han
	 * @param CPRTInputVO cprInputVo
	 * @param String rptItmId
	 * @return List<CPRTInvoiceVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CPRTInvoiceVO> searchCPRTInvoice(CPRTInputVO cprInputVo, String rptItmId) throws DAOException {
		DBRowSet dbRowset = null;
		//List list = new ArrayList();
		List<CPRTInvoiceVO> list = null;
	
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			//Customer Multi Entry
			String custCd = cprInputVo.getCustCd();
			
			StringTokenizer st2 = new StringTokenizer(custCd, ",");
			String uCustCd = "";
			String strCustCd = "";
			while (st2.hasMoreTokens()) {
				uCustCd = st2.nextToken();
				if (uCustCd.equals("")) {
					strCustCd = "";
				}else{
					strCustCd = strCustCd+"'," + "'"+uCustCd.substring(0, 2) + Integer.parseInt(uCustCd.substring(2));
				}
			
			}
			if(!strCustCd.equals("")){
				strCustCd = strCustCd + "";
			}
			
			Map<String, String> mapVO = cprInputVo.getColumnValues();
			mapVO.put("cust_cd", strCustCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);
			
			List<String> cols  = new ArrayList();   
			
			StringTokenizer st = new StringTokenizer(rptItmId, "|");
			String strRptItmId = "";
			while (st.hasMoreTokens()) {
				strRptItmId = st.nextToken();
				if (!strRptItmId.equals("")) {
					cols.add(strRptItmId);
				}
			}
			param.put("allcols", cols);   
			velParam.put("allcols", cols);   
		    dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceInquiryDBDAOCPRTInvoiceVORSQL(), param, velParam, true);

			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CPRTInvoiceVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * 신규 Report ID 생성시 이전 Max Report ID를 조회하여 다음 번호를 Return한다. <br>
	 * @author Dong Hoon Han
	 * @param String custNm
	 * @param String arOfcCd
	 * @return String
	 * @exception DAOException
	 */	
	public String searchMaxReporID(String custNm, String arOfcCd) throws DAOException {
		DBRowSet dbRowset = null;
		String reportId = "";

		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			Map<String, String> mapVO = new HashMap<String, String>();			
			mapVO.put("custNm", custNm);
			mapVO.put("ar_ofc_cd", arOfcCd);
			param.putAll(mapVO);
			velParam.putAll(mapVO);

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceInquiryDBDAOsearchMaxReporIDRSQL(), param, velParam);
			if(dbRowset.next()) {						
				reportId = dbRowset.getString("cust_rpt_id");
	    	}
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return reportId;
	}
	
	/**
	 * Report ID 생성시 INV_CPRT_HIS에 정해진 주요 item  Insert.<br>
	 * Customer Name이 5자리+YYMM+’-’+SEQ3자리호 Report ID 생성.<br>
	 * @author Dong Hoon Han
	 * @param String newID
	 * @param CPRTInputVO cprInputVo
	 * @exception DAOException
	 */		
	public void addCPRTHistory(String newID, CPRTInputVO cprInputVo) throws DAOException,Exception {
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();
		try {
			SQLExecuter sqlExe = new SQLExecuter("");
			
			if(cprInputVo != null){
				
				//Customer Multi Entry
				String custCd = cprInputVo.getCustCd();
				
				StringTokenizer st2 = new StringTokenizer(custCd, ",");
				String uCustCd = "";
				String strCustCd = "";
				while (st2.hasMoreTokens()) {
					uCustCd = st2.nextToken();
					if (uCustCd.equals("")) {
						strCustCd = "";
					}else{
						strCustCd = strCustCd+"'," + "'"+uCustCd.substring(0, 2) + Integer.parseInt(uCustCd.substring(2));
					}
				
				}
				if(!strCustCd.equals("")){
					strCustCd = strCustCd + "";
				}
				
				Map<String, String> mapVO = cprInputVo.getColumnValues();
				mapVO.put("cust_rpt_id", newID);
				mapVO.put("ar_ofc_cd", cprInputVo.getArOfcCd());
				mapVO.put("usr_id", cprInputVo.getCreUsrId());
				mapVO.put("cust_cd", strCustCd);
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
			}
			
			int result = sqlExe.executeUpdate((ISQLTemplate)new ARInvoiceInquiryDBDAOCPRTMain2VOCSQL(), param, velParam, true);
			//log.info("result==========>>>"+result);
			if(result == 0){
				throw new DAOException("Fail to insert SQL");
			}	
			//sqlExe.executeUpdate((ISQLTemplate)new InvoiceIssueDBDAOCPRTMainVOCSQL(), param, velParam);
		} catch (SQLException se) {
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOCprtItemVORSQL(), param, velParam);
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
	public List<RptTmpltNmVO> searchCPRTemplateList(String userId, String ofc) throws DAOException, Exception {
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOCprtItemVO2RSQL(), param, velParam);
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOTemplateItemVORSQL(), param, velParam);
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOsearchTemplateChgListRSQL(), param, velParam);
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

			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate) new ARInvoiceInquiryDBDAOsearchTemplateNameRSQL(), param, velParam);
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
				delCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceInquiryDBDAOTemplateVODSQL(), tmplateVOs, null);
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
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceInquiryDBDAOTemplateVOCSQL(), tmplateVOs, null);
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
				updCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceInquiryDBDAOTemplateVOUSQL(), tmplateVOs, null);
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

			sqlExe.executeUpdate((ISQLTemplate) new ARInvoiceInquiryDBDAOremoveTemlapteChgDSQL(), param, velParam);

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
				insCnt = sqlExe.executeBatch((ISQLTemplate) new ARInvoiceInquiryDBDAOaddTemplateChgCSQL(), invCprtTmpltChgVOs, null);
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

			sqlExe.executeUpdate((ISQLTemplate) new ARInvoiceInquiryDBDAOremoveTemplateDSQL(), param, velParam);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}
	
	/**
	 * 한개 이상의 Report ID로  INV_CPRT_HIS에서 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param CPRTListVO cprIdVo
	 * @return List<CPRTMainVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CPRTMainVO> searchCPRTHistoryList(CPRTListVO cprIdVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CPRTMainVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			log.info("########## cprIdVos : "+cprIdVo);
			if(cprIdVo != null){
				String custRptId = "";
				//for(int i=0; i<cprIdVos.length; i++) {
					custRptId = cprIdVo.getCustRptId();
				//}
				
				Map<String, String> mapVO = new HashMap<String, String>();
				
				mapVO.put("cust_rpt_id", custRptId);
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceInquiryDBDAOCPRTMainVORSQL(), param, velParam, true);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CPRTMainVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	/**
	 * Creation date, Create user ID, Office로  Report ID를  INV_CPRT_HIS에서 조회한다.<br>
	 * @author Dong Hoon Han
	 * @param CPRIDListInputVO cprsearchVo
	 * @return List<CPRTListVO>
	 * @exception DAOException
	 */	
	@SuppressWarnings("unchecked")
	public List<CPRTListVO> searchCPRTIDList(CPRIDListInputVO cprsearchVo) throws DAOException {
		DBRowSet dbRowset = null;
		List<CPRTListVO> list = null;
		//query parameter
		Map<String, Object> param = new HashMap<String, Object>();
		//velocity parameter
		Map<String, Object> velParam = new HashMap<String, Object>();

		try{
			if(cprsearchVo != null){
	
				Map<String, String> mapVO = cprsearchVo.getColumnValues();
				
				param.putAll(mapVO);
				velParam.putAll(mapVO);
				
			}
			dbRowset = new SQLExecuter("").executeQuery((ISQLTemplate)new ARInvoiceInquiryDBDAOCPRTListVORSQL(), param, velParam);
			list = (List)RowSetUtil.rowSetToVOs(dbRowset, CPRTListVO .class);
		}catch(SQLException se){
			log.error(se.getMessage(),se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw new DAOException(new ErrorHandler(ex).getMessage(), ex);
		}
		return list;
	}
	
	
}
