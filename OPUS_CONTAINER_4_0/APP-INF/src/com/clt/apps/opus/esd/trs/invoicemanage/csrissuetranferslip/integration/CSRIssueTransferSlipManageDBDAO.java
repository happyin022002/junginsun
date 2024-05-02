/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : CSRIssueTransferSlipManageDBDAO.java
 *@FileTitle : Transportation invoice CSR Creation - Detail
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.12
 *----------------------------------------------------------
 * History
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

import com.clt.apps.opus.esd.trs.common.util.CommonUtil;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBCImpl;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0031Event;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0032Event;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0034Event;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0035Event;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0047Event;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0048Event;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0960Event;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.vo.twoParamVO;
import com.clt.bizcommon.approval.util.ApprovalUtil;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.CheckUtils;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.db.ISQLTemplate;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.db.SQLExecuter;
import com.clt.framework.support.layer.integration.DBDAOSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.AP_INV_IF;
import com.clt.syscommon.common.table.ApInvDtrbVO;
import com.clt.syscommon.common.table.ComAproCsrDtlVO;
import com.clt.syscommon.common.table.ComAproRqstHdrVO;
import com.clt.syscommon.common.table.ComAproRqstRoutVO;
import com.clt.syscommon.common.table.LeaRevVvdCngVO;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;

/**
 * ENIS-ESD에 대한 DB 처리를 담당<br>
 * - ENIS-ESD Business Logic을 처리하기 위한 JDBC 작업수행.<br>
 * 
 * @author 김 진
 * @see CSRIssueTransferSlipManageBCImpl 참조
 * @since J2EE 1.6
 */
public class CSRIssueTransferSlipManageDBDAO extends DBDAOSupport {
	private static final long serialVersionUID = 2331525526943249005L;

	/**
	 * CSR 생성 대상 리스트 조회<br>
	 * 
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCSRSummary(EsdTrs0031Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("CRE_OFC_CD", event.getCostOfcCd());
		param.put("INV_CFM_DT", event.getInvCfmDt());
		param.put("INV_VNDR_SEQ", event.getVndrSeq());

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOSearchCSRSummaryRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * CSR 생성 대상 리스트 상세조회.<br>
	 * 
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchCSRSummaryDetail(EsdTrs0032Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("COST_OFC_CD", event.getCostOfcCd());
		param.put("INV_OFC_CD", event.getInvOfcCd());
		param.put("INV_CFM_DT", event.getInvCfmDt());
		param.put("INV_VNDR_SEQ", event.getVndrSeq());
		param.put("INV_CURR_CD", event.getCurrCd());
		param.put("CONTI_CD", event.getContiCd());

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOSearchCSRSummaryDetailRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * PreView Head CSR 내역을 조회
	 * 
	 * @param sNewCsrNo
	 * @param sPreviewIndicator
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchPreviewHDR(String sNewCsrNo, String sPreviewIndicator) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("NEW_CSR_NO", sNewCsrNo);
		param.put("PREVIEW_INDICATOR", sPreviewIndicator);

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOSearchPreviewHdrRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * PreView Detail List
	 * 
	 * @param sCsrNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchPreviewDTRBList(String sCsrNo) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("CSR_NO", sCsrNo);

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOSearchPreviewDTRBListRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * CSR AP I/F
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchCSRAPiflist(EsdTrs0047Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		if (event.getFmEffDt().equals("") || event.getFmEffDt() == null)
			param.put("FM_EFF_DT", "20070101");
		else
			param.put("FM_EFF_DT", event.getFmEffDt().replaceAll("-", ""));

		if (event.getToEffDt().equals("") || event.getToEffDt() == null)
			param.put("TO_EFF_DT", "20991231");
		else
			param.put("TO_EFF_DT", event.getToEffDt().replaceAll("-", ""));

		param.put("CSR_NO", CommonUtil.seperationParameter(event.getMultCsrNo(), ","));
		param.put("CRE_OFC_CD", event.getCostOfcCd());
		param.put("DT_STATUS", event.getDtStatus());
		param.put("IF_STATUS", event.getIfStatus());

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOSearchCSRAPiflistRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * InvoiceInquiryList
	 * 
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInvoiceInquiry(EsdTrs0048Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("CSR_NO", event.getCsrNo());

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOSearchInvoiceInquiryRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * InvoiceInquiryList
	 * 
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInvoiceInquiry(EsdTrs0960Event event) throws DAOException {

		log.debug("\n\n:::::::::::::::::::::::::::::: [searchInvoiceInquiry] ::::::::::::::::::::::::::::::::\n\n");

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("CSR_NO", event.getCsrNo());

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOSearchInvoiceInquiryRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * InvoiceInquiryList
	 * 
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInvoiceInquiryList(EsdTrs0048Event event) throws DAOException {

		// searchInvoiceInquiryList(EsdTrs0960Event event) �묒뾽�섎㈃��遺꾨━ 20090817 kys
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("CSR_NO", event.getCsrNo());

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOSearchInvoiceInquiryListRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * InvoiceInquiryList
	 * 
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchInvoiceInquiryList(EsdTrs0960Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("CSR_NO", event.getCsrNo());

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOSearchInvoiceInquiryListRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * CSR ASA_NO LIST 조회.<br>
	 * 
	 * @param event
	 * @return DBRowSet
	 * @throws DAOException
	 */
	public DBRowSet searchASANOList(EsdTrs0032Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("OFC_CD", event.getCostOfcCd());

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOSearchASANOListRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;

	}

	/**
	 * CSR Ap Office Cd 조회.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchApOfcCD(EsdTrs0032Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("OFC_CD", event.getCostOfcCd());

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOSearchApOfcCDRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * �멸툑怨꾩궛���곸꽭�뺣낫瑜�조회
	 * 
	 * @param vndr_seq
	 * @param wo_vndr_seq
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchTAXDetail(String vndr_seq, String wo_vndr_seq) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("VNDR_SEQ", wo_vndr_seq);

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOSearchTAXDetailRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * �멸툑怨꾩궛��肄붾뱶紐⑸줉��조회
	 * 
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchEviCodeList() throws DAOException {
		DBRowSet dRs = null;

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOSearchEviCodeListRSQL(), null, null);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * TAX CODE 조회
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchTAXCode(EsdTrs0034Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("TAX_TYPE", event.getTaxType());
		param.put("TAX_NAID_FLG", event.getTaxNaidFlg());
		param.put("FA_FLG", event.getFaFlg());
		param.put("TAX_NSL_FLG", event.getTaxNslFlg());

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOSearchTAXCodeRSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * AP_EVID_NO �깅줉
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public String searchApEviNo(EsdTrs0034Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		String taxNo01 = event.getTaxNo1();
		String taxNo02 = event.getTaxNo2();
		String taxNoTotal = taxNo01 + taxNo02;
		String sTaxNo = "";
		String sTaxSerNo = "";

		param.put("TAX_NO_01", taxNo01);
		param.put("TAX_NO_02", taxNo02);
		param.put("TAX_NO_TOTAL", taxNoTotal);
		param.put("CRE_OFC_CD", event.getCreOfcCd());
		param.put("CRE_USR_ID", event.getCreUsrId());

		try {
			if ("07".equals(taxNo01.substring(4, 6)))
				dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOMakeApEvidNo07RSQL(), param, param); // 07源뚯�
			else
				dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOMakeApEvidNo08RSQL(), param, param); // 08�댄썑

			if (dRs.next())
				sTaxSerNo = dRs.getString("TAX_SER_NO");
			else
				sTaxSerNo = "";

			sTaxNo = taxNoTotal + sTaxSerNo;

			param.put("TAX_NO", sTaxNo);

			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOCreateApEvidNoCSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return sTaxSerNo;
	}

	/**
	 * CSR 寃곗옱��I/F瑜��꾪빐 eai���섏졇二쇰뒗 DATA 조회
	 * 
	 * @param sNewCsrNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchApInvInfForEAIInterface(String sNewCsrNo) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("CSR_NO", sNewCsrNo);

		try {

			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOSearchApInvIfForEAIInterfaceRSQL(), param, param);

			// 怨듯넻��감��寃쎌슦 CSR 寃곗옱��GL_DT瑜��ъ슜�섏뿬 洹몄� 媛숈� 媛믪쑝濡�UPDATE
			// new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate)new CSRIssueTransferSlipManageDBDAOUpdateApInvIfForEAIInterfaceUSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * SearchTrs3PtyIF
	 * 
	 * @param csr_no
	 * @return
	 * @throws DAOException
	 */
	public TPBInterfaceVO[] searchTrs3PtyIF(String csr_no) throws DAOException {
		DBRowSet dRs = null;
		TPBInterfaceVO[] models1 = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("CSR_NO", csr_no);

		try {

			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOUpdateTrs3PtyIFUSQL(), param, param);

			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOSearchTrs3PtyIFRSQL(), param, param);

			if (dRs != null) {

				models1 = new TPBInterfaceVO[dRs.getRowCount()];
				int i = 0;

				while (dRs.next()) {
					models1[i] = new TPBInterfaceVO();
					String ofc = dRs.getString("trsp_if_ofc_cd");
					String seq = dRs.getString("trsp_if_seq");

					models1[i].setTrspIfOfcCd(ofc);
					models1[i].setTrspIfSeq(seq);
					i++;
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
		return models1;
	}

	/**
	 * AP Actual Interface
	 * 
	 * @param sNewCsrNo
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet searchChgRevenueApInvInfForEAIInterface(String sNewCsrNo) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("CSR_NO", sNewCsrNo);

		try {

			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOSearchChgRevenueApInvIfForEAIInterfaceRSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return dRs;
	}

	/**
	 * CSR 踰덊샇瑜�梨꾨쾲.<br>
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public String createCsrNo(EsdTrs0032Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String csr_no = "";

		log.debug(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
		log.debug("::::::::::::: [[ multiCSRNo ]] ::::::::::::::::::::::::");
		log.debug("csr_no_sub 	= [" + event.getCsrType() + "]");
		log.debug("sCost_ofc_cd = [" + event.getCostOfcCd() + "]");
		log.debug(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");

		param.put("CSR_TYPE", event.getCsrType());
		param.put("COST_OFC_CD", event.getCostOfcCd());

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOCreateCsrNoRSQL(), param, param);

			if (dRs.next())
				csr_no = dRs.getString("NEW_CSR_NO");

			log.debug(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			log.debug("csr_no = [" + csr_no + "]");
			log.debug(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");

			param.put("CSR_NO", csr_no);

			/** Not Preview + Create Only Inserting AP_CSR_NO */
			if (!"PREVIEW".equals(event.getPreviewIndicator()) && event.getPreviewIndicator() != null)
				new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOInsertAPCsrNoCSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return csr_no;
	}

	/**
	 * �덈줈��CSR踰덊샇瑜�梨꾨쾲 �섍퀬 CSR踰덊샇瑜���옣.<br>
	 * 
	 * @param sUserOfcCd
	 * @return
	 * @throws DAOException
	 */
	public String generateCSRNoForChgRevenueVVD(String sUserOfcCd) throws DAOException {

		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();

		String sNewCsrNo = "";

		param.put("USR_OFC_CD", sUserOfcCd);

		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOGenerateCSRNoForChgRevenueVVDRSQL(), param, param);

			if (dRs.next())
				sNewCsrNo = dRs.getString("NEW_CSR_NO");

			log.debug(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");
			log.debug(":::::: Changed R.VVD sNewCsrNo = [" + sNewCsrNo + "] ::::::");
			log.debug(":::::::::::::::::::::::::::::::::::::::::::::::::::::::");

			param.put("CSR_NO", sNewCsrNo);

			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOInsertCSRNoForChgRevenueVVDCSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return sNewCsrNo;
	}

	/**
	 * AP Header 테이블에 자료 입력.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void createApInvHDR(EsdTrs0032Event event) throws DAOException {
		log.debug("::::::::::::::::::::::::::: <<< createApInvHDR STRATING... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");

		Map<String, Object> param = new HashMap<String, Object>();
		String sCost_ofc_cd = event.getCostOfcCd();
		String sBranchIndicator = "N";
		String sPaymentType = event.getPaymentType();
		String[] arrChinaSpeOffice = { "SZPBB", "CANBS" };
		String sInvOfc_cd = event.getInvOfcCd();

		for (int j = 0; j < arrChinaSpeOffice.length; j++) {
			if (arrChinaSpeOffice[j].equals(sCost_ofc_cd)) {
				sBranchIndicator = "Y";
				break;
			}
		}

		// SHAAOG, HKGBB Office로 로그인 하였을 경우엔 paymenttype를 강제 셋팅한다.
		if ("Y".equals(sBranchIndicator)) {
			if (sInvOfc_cd.equals("SHAAOG")) {
				sPaymentType = "RHQ";
			} else if (sInvOfc_cd.equals("HKGBB")) {
				sPaymentType = "BRANCH";
			}
		}

		if ("Y".equals(sBranchIndicator) && (!"BRANCH".equals(sPaymentType) && !"RHQ".equals(sPaymentType)))
			throw new DAOException("Exception occured because of china payment method error!, No Branch and No RHQ!!");

		param.put("COST_OFC_CD", event.getCostOfcCd());

		try {
			param.put("CSR_NO", event.getCsr_no());
			if (event.getCsrTpCd().equals("C")) {
				param.put("CSR_TP_CD", "CREDIT");
			} else {
				param.put("CSR_TP_CD", "STANDARD");
			}

			param.put("INV_DT", event.getMaxIssDt().replaceAll("-", ""));
			param.put("INV_TERM_DT", event.getPaymentDueDtView().replaceAll("-", ""));
			param.put("AP_OFC_CD", event.getApOfcCd());
			param.put("VNDR_NO", event.getVndrSeq());
			param.put("CSR_AMT", event.getTotalAmt());
			param.put("CSR_CURR_CD", event.getCurrCd());
			param.put("ATTR_CATE_NM", "Invoices");
			param.put("ATTR_CTNT8", event.getMaxRcvDt() + "000000");
			if (!CheckUtils.isInBlank(event.getAsaNo())) {
				param.put("ATTR_CTNT2", event.getAsaNo());
			} else {
				param.put("ATTR_CTNT2", event.getEviCompNo());
			}
			param.put("ATTR_CTNT3", event.getEviInvDt().replaceAll("-", ""));
			param.put("ATTR_CTNT4", event.getEviTotalNetAmt());
			param.put("ATTR_CTNT5", event.getEviTaxNo2());
			param.put("ATTR_CTNT6", event.getEviTotalTaxAmt());
			param.put("ATTR_CTNT10", event.getUsrNm());
			param.put("GLO_ATTR_CTNT1", event.getEviCtnt1());
			param.put("GLO_ATTR_CTNT2", event.getEviCtnt2());
			param.put("GLO_ATTR_CTNT3", event.getEviCtnt3());
			param.put("GLO_ATTR_CTNT4", event.getEviCtnt4());
			param.put("GLO_ATTR_CTNT5", event.getEviCtnt5());
			param.put("GLO_ATTR_CTNT6", event.getEviCtnt6());
			param.put("GLO_ATTR_CTNT7", event.getEviCtnt7());
			param.put("GLO_ATTR_CTNT8", event.getEviCtnt8());
			param.put("GLO_ATTR_CTNT9", event.getEviCtnt9());
			param.put("GLO_ATTR_CTNT10", event.getEviCtnt10());
			param.put("GLO_ATTR_CTNT11", event.getEviCtnt11());
			param.put("GLO_ATTR_CTNT12", event.getEviCtnt12());
			param.put("GLO_ATTR_CTNT13", event.getEviTaxNo());
			param.put("SRC_CTNT", "SO_TRANS");

			/**
			 * 2008.03.12 남중국 Office(3s)에 대한 Payment Group Rule sBranchIndicator == "Y"인경우. 대상 Office : "SZPBB", "XMNBB", "CANBS" For Branch Payment 선택시 (==> "BRANCH") → 일반 분리정산 I/F Logic 을 따름 For RHQ Payment 선택시 (==> "RHQ") → Pay Group 에 *****_RHQ_PYMT 입력
			 */
			if ("Y".equals(sBranchIndicator) && "RHQ".equals(sPaymentType)) {
				/** PAY_GRP_LU_CD */
				param.put("PAY_GRP_LU_CD", event.getApOfcCd() + "_RHQ_PYMT"); // Only PHQ Payment
			} else {
				if (event.getCntCd().equals("0")) {
					param.put("PAY_GRP_LU_CD", event.getApOfcCd() + "_ZERO PAYMENT");
				} else {
					param.put("PAY_GRP_LU_CD", event.getApOfcCd() + "_O/EXP");
				}
			}
			param.put("USR_EML", event.getUsrEml());
			param.put("CRE_USR_ID", event.getCreUsrId());
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOCreateApInvHdrCSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		log.debug("::::::::::::::::::::::::::: <<< createApInvHDR END... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");
	}

	/**
	 * CSR 생성내역을 조회.<br>
	 * 
	 * @param e
	 * @return
	 * @throws DAOException
	 */
	public DBRowSet[] generateApInvDTRB(Event e) throws DAOException {
		log.debug("::::::::::::::::::::::::::: <<< generateApInvDTRB STARTING... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");

		DBRowSet dRs = null;
		DBRowSet[] dRsArr = null;
		int dRsCnt = 0;

		String[] sInv_no = null;
		String[] sInv_vndr_seq = null;

		int line_no = 1;

		Map<String, Object> param = new HashMap<String, Object>();
		if (e instanceof EsdTrs0032Event) {
			EsdTrs0032Event event = (EsdTrs0032Event) e;

			sInv_no = event.getInv_no();
			sInv_vndr_seq = event.getInv_vndr_seq();

			List<String> invNoArr = new ArrayList<String>();
			for (int x = 0; x < sInv_no.length; x++) {
				invNoArr.add(sInv_no[x]);
			}

			param.put("INV_NO", invNoArr);
			param.put("INV_VNDR_SEQ", event.getInv_vndr_seq());
			param.put("TRSP_INV_AUD_STS_CD", "CF");
			/** INVOICE CONFIRM */
			param.put("CSR_NO", event.getCsr_no());
			param.put("CRE_OFC_CD", event.getCostOfcCd());
			param.put("INV_CFM_DT", event.getInvCfmDt());
			param.put("INV_VNDR_SEQ", event.getVndrSeq());

			param.put("COST_OFC_CD", event.getCostOfcCd());
			param.put("CURR_CD", event.getCurrCd());
			param.put("CNT_CD", event.getCntCd());
			param.put("CRE_USR_ID", event.getCreUsrId());

		} else if (e instanceof EsdTrs0035Event) {
			EsdTrs0035Event event = (EsdTrs0035Event) e;

			sInv_no = event.getInv_no();
			sInv_vndr_seq = event.getInv_vndr_seq();

			List<String> invNoArr = new ArrayList<String>();
			for (int x = 0; x < sInv_no.length; x++) {
				invNoArr.add(sInv_no[x]);
			}

			param.put("INV_NO", invNoArr);
			param.put("INV_VNDR_SEQ", event.getInv_vndr_seq());
			param.put("TRSP_INV_AUD_STS_CD", "AR");
			/** APPROVAL REQUEST */
		}

		if (sInv_no != null) {
			dRsArr = new DBRowSet[sInv_no.length];
		}

		try {
			if (sInv_no != null) {
				for (int z = 0; z < sInv_no.length; z++) {
					param.put("LINE_NO", line_no);
					param.put("INV_TAX_CD", "");
					param.put("INV_NO", sInv_no[z]);
					param.put("INV_VNDR_SEQ", sInv_vndr_seq[z]);

					dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOGenerateApInvDtrbRSQL(), param, param);

					dRsArr[dRsCnt] = dRs;
					dRsCnt++;

					line_no++;
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		log.debug("::::::::::::::::::::::::::: <<< generateApInvDTRB END... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");

		return dRsArr;
	}

	/**
	 * INSERT - AP Detail Table .<br>
	 * 
	 * @param e
	 * @throws DAOException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void createApInvDtrb(Event e) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		EsdTrs0032Event event = (EsdTrs0032Event) e;
		DBRowSet[] oApDtrbRowSetArr = event.getApDtrbRowSetArr();
		try {
			int insCnt[] = null;
			if (oApDtrbRowSetArr != null) {
				for (int j = 0; j < oApDtrbRowSetArr.length; j++) {
					if (oApDtrbRowSetArr[j] != null) {
						Collection<ApInvDtrbVO> list = (Collection) RowSetUtil.rowSetToVOs(oApDtrbRowSetArr[j], ApInvDtrbVO.class);
						if (list.size() > 0) {
							insCnt = new SQLExecuter("DEFAULT").executeBatch((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOCreateApInvDtrbCSQL(), list, param, param);
						}
					}
				}
				if (insCnt != null) {
					for (int i = 0; i < insCnt.length; i++) {
						if (insCnt[i] == Statement.EXECUTE_FAILED)
							throw new DAOException("Fail to insert No" + i + " SQL");
					}
				}
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * CSR Header creation.<br>
	 * 
	 * @param model
	 * @param userAccount
	 * @throws DAOException
	 */
	public void createChgRevenueVVDForApInvHDR(LeaRevVvdCngVO model, SignOnUserAccount userAccount) throws DAOException {

		/**
		 * STEP 02. NEW AP_INV_HDR INSERT<br>
		 * =======================================================<br>
		 * 1. CSR_NO : '13S............' <br>
		 * 2. CSR_TP_CD : 'STANDARD' <br>
		 * 3. GL_DT : NEW_REV_YRMON(6) + 해당월마지막일(2) <br>
		 * 4. CSR_AMT : 0 <br>
		 * 5. PAY_AMT : NULL <br>
		 * 6. PAY_DT : NULL <br>
		 * 7. APRO_FLG : 'Y' <br>
		 * 8. ERR_CSR_NO : OLD CSR_NO <br>
		 * 9. IF_FLG : NULL <br>
		 * 10.IF_DT : NULL<br>
		 * 11.IF_ERR_RSN : NULL<br>
		 * 12.RCV_ERR_FLG : NULL<br>
		 * 13.RCV_ERR_RSN : NULL<br>
		 * 14.USR_EML : LEA USER EMAIL<br>
		 * 15.CRE_DT : SYSDATE <-- GLOBAL TIME APPLY (?)<br>
		 * 16.CRE_USR_ID : USER_ID<br>
		 * 17.AFT_ACT_FLG : NULL<br>
		 */
		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("NEW_CSR_NO", JSPUtil.getNull(model.getModiCsrNo()));
			param.put("OLD_CSR_NO", JSPUtil.getNull(model.getCsrNo()));
			param.put("CRE_OFC_CD", JSPUtil.getNull(userAccount.getOfc_cd()));
			param.put("CRE_USR_ID", JSPUtil.getNull(userAccount.getUsr_id()));
			param.put("BKG_NO", JSPUtil.getNull(model.getBkgNo()));
			param.put("USER_EMAIL", JSPUtil.getNull(userAccount.getUsr_eml()));
			param.put("NEW_SKD_VOY_NO", JSPUtil.getNull(model.getNewSkdVoyNo()));
			param.put("NEW_SKD_DIR_CD", JSPUtil.getNull(model.getNewSkdDirCd()));
			param.put("NEW_REV_DIR_CD", JSPUtil.getNull(model.getNewRevDirCd()));
			param.put("NEW_VSL_CD", JSPUtil.getNull(model.getModiCsrNo()));

			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOCreateChgRevenueVVDForApInvHDRCSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * AP Detail Data Input (KR)
	 * 
	 * @param e
	 * @throws DAOException
	 */
	public void createApInvKRDtrb(Event e) throws DAOException {
		log.debug("::::::::::::::::::::::::::: <<< createApInvKRDtrb STARTING... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");

		String[] sInv_no = null;

		Map<String, Object> param = new HashMap<String, Object>();

		if (e instanceof EsdTrs0032Event) {
			EsdTrs0032Event event = (EsdTrs0032Event) e;

			sInv_no = event.getInv_no();

			List<String> invNoArr = new ArrayList<String>();
			for (int x = 0; x < sInv_no.length; x++) {
				invNoArr.add(sInv_no[x]);
			}
			param.put("TRSP_INV_AUD_STS_CD", "CF");
			/** INVOICE CONFIRM */
			param.put("CSR_NO", event.getCsr_no());
			param.put("INV_NO", invNoArr);
			param.put("INV_VNDR_SEQ", event.getInv_vndr_seq()[0]);
			param.put("CNT_CD", event.getCntCd());
			param.put("CRE_USR_ID", event.getCreUsrId());
			param.put("INV_TAX_CD", event.getEviTaxCode());

		} else if (e instanceof EsdTrs0035Event) {
			EsdTrs0035Event event = (EsdTrs0035Event) e;

			sInv_no = event.getInv_no();

			List<String> invNoArr = new ArrayList<String>();
			for (int x = 0; x < sInv_no.length; x++) {
				invNoArr.add(sInv_no[x]);
			}

			param.put("INV_NO", invNoArr);
			param.put("INV_VNDR_SEQ", event.getInv_vndr_seq());
			param.put("TRSP_INV_AUD_STS_CD", "AR");
			/** APPROVAL REQUEST */
		}

		try {
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOCreateApInvKRDtrbCSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		log.debug("::::::::::::::::::::::::::: <<< createApInvKRDtrb END... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");
	}

	/**
	 * AP DTRB 테이블에 asa 자료 입력
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void createApInvDTRBASANo(EsdTrs0032Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("CSR_NO", event.getCsr_no());
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOSelectApInvDTRBASANoRSQL(), param, param);
			if (dRs.next()) {
				param.put("LINE_SEQ", dRs.getString("LINE_SEQ"));
				param.put("LINE_NO", dRs.getString("LINE_NO"));
				param.put("INV_NO", dRs.getString("INV_NO"));
				param.put("ISS_DT", dRs.getString("ISS_DT"));
				param.put("LOC_CD", dRs.getString("LOC_CD"));
				param.put("ATTR_CTNT12", dRs.getString("ATTR_CTNT12"));
				param.put("TOTAL_AMT", dRs.getString("TOTAL_AMT"));
				param.put("ACCT_CD", "954113");
				param.put("VNDR_SEQ", event.getVndrSeq());
				param.put("COST_OFC_CD", event.getCostOfcCd());
				param.put("CRE_USR_ID", event.getCreUsrId());
				param.put("ASA_NO", event.getAsaNo());

				new SQLExecuter("DEFAULT").executeUpdate(new CSRIssueTransferSlipManageDBDAOUpdateCsrAmtZeroForASAUSQL(), param, param);
				new SQLExecuter("DEFAULT").executeUpdate(new CSRIssueTransferSlipManageDBDAOCreateApInvDTRBASANoCSQL(), param, param);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * CSR HEADER status UPDATE(Include RAIL)
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void updateCSRSOHDRsts(EsdTrs0032Event event) throws DAOException {

		log.debug("::::::::::::::::::::::::::: <<< updateCSRSOHDRsts STARTING... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");
		Map<String, Object> param = new HashMap<String, Object>();

		String[] sInv_no = event.getInv_no();
		String[] sInv_vndr_seq = event.getInv_vndr_seq();

		param.put("CRE_USR_ID", event.getCreUsrId());
		param.put("COST_OFC_CD", event.getCostOfcCd());
		param.put("CSR_NO", event.getCsr_no());

		try {

			for (int z = 0; z < sInv_no.length; z++) {
				param.put("INV_NO", sInv_no[z]);
				param.put("INV_VNDR_SEQ", sInv_vndr_seq[z]);

				new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOUpdateCSRSOHDRstsRailUSQL(), param, param);
				new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOUpdateCSRSOHDRstsUSQL(), param, param);

			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		log.debug("::::::::::::::::::::::::::: <<< updateCSRSOHDRsts END... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");
	}

	/**
	 * updateCSRSTSFlag
	 * 
	 * @param csr_no
	 * @param sInvStatFlag
	 * 
	 * @throws DAOException
	 */
	public void updateCSRSTSFlag(String csr_no, String sInvStatFlag) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("CSR_NO", csr_no);
		param.put("TRSP_INV_AUD_STS_CD", sInvStatFlag);

		try {
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOUpdateCSRSTSFlagUSQL(), param, param);
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOUpdateCSRSTSFlagRailUSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * GL_DT UPDATE
	 * 
	 * @param sCsrNo
	 * @param sInvStatCd
	 * @throws DAOException
	 */
	public void updateGLDT(String sCsrNo, String sInvStatCd) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("CSR_NO", sCsrNo);
		param.put("INV_STAT_CD", sInvStatCd);

		try {
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOUpdateGLDTUSQL(), param, param);
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOUpdateGLDTRailUSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * UpdateCSRRejection
	 * 
	 * @param csr_no
	 * @param inv_rjct_dt
	 * @param invPayMzdCd
	 * @param invChkTrnsNo
	 * @throws DAOException
	 */
	public void updateCSRRejection(String csr_no, String inv_rjct_dt, String invPayMzdCd, String invChkTrnsNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("CSR_NO", csr_no);
		param.put("INV_RJCT_DT", CheckUtils.checkNullAndReturnStringBlank(inv_rjct_dt));
		param.put("INV_PAY_MZD_CD", CheckUtils.checkNullAndReturnStringBlank(invPayMzdCd));
		param.put("INV_CHK_TRNS_NO", CheckUtils.checkNullAndReturnStringBlank(invChkTrnsNo));

		try {
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOUpdateCSRRejectionUSQL(), param, param);
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOUpdateCSRRejectionRailUSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * [UPATE] TRSP_INV_AUD_STS_CD ==> PD
	 * 
	 * @param csr_no
	 * @param paidDate
	 * @param invPayMzdCd
	 * @param invChkTrnsNo
	 * @throws DAOException
	 */
	public void updateCSRPaid(String csr_no, String paidDate, String invPayMzdCd, String invChkTrnsNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("CSR_NO", csr_no);
		param.put("PAID_DATE", CheckUtils.checkNullAndReturnStringBlank(paidDate));
		param.put("INV_PAY_MZD_CD", CheckUtils.checkNullAndReturnStringBlank(invPayMzdCd));
		param.put("INV_CHK_TRNS_NO", CheckUtils.checkNullAndReturnStringBlank(invChkTrnsNo));

		try {
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOUpdateCSRPaidUSQL(), param, param);
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOUpdateCSRPaidRailUSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * [UPATE] TRSP_INV_AUD_STS_CD ==> IF
	 * 
	 * @param csr_no
	 * @param invPayMzdCd
	 * @param invChkTrnsNo
	 * @throws DAOException
	 */
	public void updateCSRInterface(String csr_no, String invPayMzdCd, String invChkTrnsNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("CSR_NO", csr_no);
		param.put("INV_PAY_MZD_CD", CheckUtils.checkNullAndReturnStringBlank(invPayMzdCd));
		param.put("INV_CHK_TRNS_NO", CheckUtils.checkNullAndReturnStringBlank(invChkTrnsNo));
		try {
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOUpdateCSRInterfaceUSQL(), param, param);
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOUpdateCSRInterfaceRailUSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * updateApInvHdrIFErrRsn
	 * 
	 * @param sCsrNo
	 * @param sErrReason
	 * @throws DAOException
	 */
	public void updateApInvHdrIFErrRsn(String sCsrNo, String sErrReason) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("CSR_NO", sCsrNo);
		param.put("ERR_REASON", sErrReason);

		try {
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOUpdateApInvHdrIFErrRsnUSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * UpdateLEA_REV_VVD_CNG
	 * 
	 * @param model LeaRevVvdCngVO
	 * 
	 * @throws DAOException
	 */
	public void updateLEA_REV_VVD_CNG(LeaRevVvdCngVO model) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("NEW_CSR_NO", model.getModiCsrNo());
		param.put("CSR_NO", JSPUtil.getNull(model.getCsrNo()));
		param.put("BKG_NO", JSPUtil.getNull(model.getBkgNo()));
		param.put("OLD_VSL_CD", JSPUtil.getNull(model.getOldVslCd()));
		param.put("OLD_SKD_VOY_NO", JSPUtil.getNull(model.getOldSkdVoyNo()));
		param.put("OLD_SKD_DIR_CD", JSPUtil.getNull(model.getOldSkdDirCd()));
		param.put("OLD_REV_DIR_CD", JSPUtil.getNull(model.getOldRevDirCd()));

		try {
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOUpdateLEA_REV_VVD_CNGUSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * correctSvcOrdMstCsrScgCorrAmt.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void correctSvcOrdMstCsrScgCorrAmt(EsdTrs0032Event event) throws DAOException {
		log.debug("::::::::::::::::::::::::::: <<< correctSvcOrdMstCsrScgCorrAmt STARTING... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");

		try {
			Map<String, Object> param = new HashMap<String, Object>();

			String[] sInvNo = event.getInv_no();
			String sInvVndrSeq = event.getVndrSeq();

			List<String> invNoArr = new ArrayList<String>();
			for (int i = 0; i < sInvNo.length; i++) {
				invNoArr.add(sInvNo[i]);
			}

			param.put("INV_VNDR_SEQ", sInvVndrSeq);
			param.put("INV_NO", invNoArr);
			new SQLExecuter("DEFAULT").executeUpdate(new CSRIssueTransferSlipManageDBDAOCorrectSvcOrdMstCsrScgCorrAmtUSQL(), param, param);

			log.debug("::::::::::::::::::::::::::: <<< correctSvcOrdMstCsrScgCorrAmt END... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * correctSvcOrdMstCsrBzcCorrAmt.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void correctSvcOrdMstCsrBzcCorrAmt(EsdTrs0032Event event) throws DAOException {
		log.debug("::::::::::::::::::::::::::: <<< correctSvcOrdMstCsrBzcCorrAmt STARTING... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");

		try {
			Map<String, Object> param = new HashMap<String, Object>();

			String[] sInvNo = event.getInv_no();
			String sInvVndrSeq = event.getVndrSeq();

			List<String> invNoArr = new ArrayList<String>();
			for (int i = 0; i < sInvNo.length; i++) {
				invNoArr.add(sInvNo[i]);
			}

			param.put("INV_VNDR_SEQ", sInvVndrSeq);
			param.put("INV_NO", invNoArr);

			new SQLExecuter("DEFAULT").executeUpdate(new CSRIssueTransferSlipManageDBDAOCorrectSvcOrdMstCsrBzcCorrAmtUSQL(), param, param);

			log.debug("::::::::::::::::::::::::::: <<< correctSvcOrdMstCsrBzcCorrAmt END... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * correctRfndInvCsrCorrAmt.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void correctRfndInvCsrCorrAmt(EsdTrs0032Event event) throws DAOException {
		log.debug("::::::::::::::::::::::::::: <<< correctRfndInvCsrCorrAmt STARTING... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");

		try {
			Map<String, Object> param = new HashMap<String, Object>();

			String[] sInvNo = event.getInv_no();
			String sInvVndrSeq = event.getVndrSeq();

			List<String> invNoArr = new ArrayList<String>();
			for (int i = 0; i < sInvNo.length; i++) {
				invNoArr.add(sInvNo[i]);
			}

			param.put("INV_VNDR_SEQ", sInvVndrSeq);
			param.put("INV_NO", invNoArr);

			new SQLExecuter("DEFAULT").executeUpdate(new CSRIssueTransferSlipManageDBDAOCorrectRfndInvCsrCorrAmtUSQL(), param, param);

			log.debug("::::::::::::::::::::::::::: <<< correctRfndInvCsrCorrAmt END... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * correctApInvDtrbCsrAmt.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void correctApInvDtrbCsrAmt(EsdTrs0032Event event) throws DAOException {
		log.debug("::::::::::::::::::::::::::: <<< correctApInvDtrbCsrAmt STARTING... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");

		try {
			Map<String, Object> param = new HashMap<String, Object>();

			param.put("CSR_NO", event.getCsr_no());
			param.put("INV_VNDR_SEQ", event.getInv_vndr_seq());

			int upCnt = new SQLExecuter("DEFAULT").executeUpdate(new CSRIssueTransferSlipManageDBDAOCorrectApInvDtrbCsrAmtUSQL(), param, param);

			log.debug("::::::::::::::::::::::::::: <<< correctApInvDtrbCsrAmt Updated Count is [" + upCnt + "]  >>> ::::::::::::::::::::::::::::");
			log.debug("::::::::::::::::::::::::::: <<< correctApInvDtrbCsrAmt END... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * Line정보를 Update.<br>
	 * 
	 * @param sCsrNo
	 * @throws DAOException
	 */
	public void modifyApInvDTRBLineNo(String sCsrNo) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		try {
			param.put("CSR_NO", sCsrNo);
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOModifyApInvDtrbLineNoUSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * CNTR VVD를 업데이트한다.<br>
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void updateCntrFincVVD(EsdTrs0032Event event) throws DAOException {
		log.debug("::::::::::::::::::::::::::: <<< updateCntrFincVVD STARTING... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");

		try {
			SQLExecuter sqlExe = new SQLExecuter("");

			Map<String, Object> param = new HashMap<String, Object>();

			String[] sInvNo = event.getInv_no();
			String sInvVndrSeq = event.getVndrSeq();

			List<String> invNoArr = new ArrayList<String>();
			for (int i = 0; i < sInvNo.length; i++) {
				invNoArr.add(sInvNo[i]);
			}

			param.put("INV_VNDR_SEQ", sInvVndrSeq);
			param.put("INV_NO", invNoArr);
			param.put("INV_DT", event.getMaxIssDt().replaceAll("-", ""));
			param.put("AP_OFC_CD", event.getApOfcCd());

			/**
			 * 
			 * FUNCTION GET_BKG_REV_VVD3_FNC ( pi_ap_ofc_cd IN VARCHAR2 pi_inv_dt IN VARCHAR2 pi_trsp_so_tp_cd IN VARCHAR2 pi_trsp_so_ofc_cty_cd IN VARCHAR2 pi_trsp_so_seq IN VARCHAR2 pi_eq_knd_cd IN VARCHAR2 pi_cgo_tp_cd IN VARCHAR2 pi_bkg_no IN VARCHAR2 pi_ref_bkg_no IN VARCHAR2 pi_vsl_cd IN
			 * VARCHAR2 pi_skd_voy_no IN VARCHAR2 pi_skd_dir_cd IN VARCHAR2 )
			 * 
			 */

			sqlExe.executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOUpdateCntrFincVVDUSQL(), param, param);
			sqlExe.executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOUpdateRailCntrFincVVDUSQL(), param, param);

			log.debug("::::::::::::::::::::::::::: <<< updateCntrFincVVD END... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ex) {
			log.error(ex.getMessage(), ex);
			throw new DAOException(new ErrorHandler(ex).getMessage());
		}
	}

	/**
	 * ModifyTrsInvHdr
	 * 
	 * @param obj
	 * @throws DAOException
	 */
	public void modifyTrsInvHdr(Object obj) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		AP_INV_IF model = (AP_INV_IF) obj;

		param.put("CSR_NO", model.getHdr_csr_no());
		param.put("PAY_DT", model.getHdr_pay_dt());
		param.put("INV_CHK_TRNS_NO", model.getHdr_ftu_use_ctnt1());
		param.put("INV_PAY_MZD_CD", model.getHdr_pay_mzd_lu_cd());

		try {
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOModifyTrsInvHdrUSQL(), param, param);
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOModifyTrsInvHdrRailUSQL(), param, param);
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * CSR Preview하기 위해 AP Insert했던 DATA를 지운다
	 * 
	 * @param sCsrNo
	 * @throws DAOException
	 */
	public void deleteApInvHDRDTRB(String sCsrNo) throws DAOException {
		log.debug("::::::::::::::::::::::::::: <<< deleteApInvHDRDTRB STARTING... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("CSR_NO", sCsrNo);

			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAODeleteApInvHDRDSQL(), param, param);
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAODeleteApInvDTRBDSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}

		log.debug("::::::::::::::::::::::::::: <<< deleteApInvHDRDTRB END... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");
	}

	/**
	 * Approval Request Account (gl date와 Approval 상태를 수정, vvd 수정(DTRB, TRUCK SO, RAIL SO)
	 * 
	 * @param csr_no
	 * @param title_name
	 * @throws DAOException
	 */
	public void approvalRequestAccount(String csr_no, String title_name) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		DBRowSet dRs = null;
		String gl_dt = "";

		try {
			param.put("CSR_NO", csr_no);
			param.put("ATTR_CTNT1", title_name);

			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOGetCurrentGlDtRSQL(), param, param);

			if (dRs.next())
				gl_dt = dRs.getString("GL_DT");

			param.put("GL_DT", gl_dt);

			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOApprovalRequestAccountUSQL(), param, param);
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOApprovalRequestAccountUpdateDtrbUSQL(), param, param);
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOApprovalRequestAccountVVDSOUSQL(), param, param);
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOApprovalRequestAccountRailVVDSOUSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * approvalRequest
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void approvalRequest(EsdTrs0032Event event) throws DAOException {
		String sCsr_no = event.getCsr_no();
		String sTotal_amt = event.getTotalAmt();
		String sCost_ofc_cd = event.getCostOfcCd();
		String sInv_ofc_cd = event.getInvOfcCd();
		String sUsr_nm = event.getUsrNm();
		String sCre_usr_id = event.getCreUsrId();
		String sOfc_nm = event.getOfcNm();
		String sVndr_seq = event.getVndrSeq();
		String sCurr_cd = event.getCurrCd();
		String sInv_cnt = event.getCntInv();
		String sPayment_due_dt = event.getPaymentDueDt();

		/****************************************
		 * 결재정보 넘기기 CSR CREATION > DETAIL 화면
		 */

		try {
			ApprovalUtil util = new ApprovalUtil();
			// COM_APRO_RQST_HDR
			ComAproRqstHdrVO header = new ComAproRqstHdrVO();

			header.setSubSysCd("TRS");
			header.setAproKndCd("CSR");
			header.setRqstOfcCd(sCost_ofc_cd);
			header.setRqstOfcNm(sOfc_nm);
			header.setRqstUsrJbTitNm("");
			header.setRqstUsrId(sCre_usr_id);
			header.setRqstUsrNm(sUsr_nm);
			header.setCreUsrId(sCre_usr_id);

			// COM_APRO_RQST_ROUT
			// ComAproRqstRoutVO[] route = util.convertApprovalRoute(sApro_step); //ApprovalUtil.java 가 아직 구 TABLE VO를 사용하고 있어서 주석처리 함 20090817 김진
			// OFC 단위 결재로 변경. APRO_STEP 세팅할 필요 없음 (OFC 만 세팅)
			// 2015.12.22 CHAN WOO PARK : Approval Office 변경 (Cost Office -> Invoice Office)
			ComAproRqstRoutVO route = new ComAproRqstRoutVO();
			route.setAproOfcCd(sInv_ofc_cd);
			route.setAproOfcNm(sOfc_nm);

			// COM_APRO_CSR_DTL
			ComAproCsrDtlVO csr = new ComAproCsrDtlVO();

			csr.setCsrNo(sCsr_no);
			csr.setCostOfcCd(sCost_ofc_cd);
			csr.setInvKnt(sInv_cnt);
			csr.setVndrSeq(sVndr_seq);
			csr.setPayDueDt(sPayment_due_dt.replaceAll("-", ""));
			csr.setCurrCd(sCurr_cd);
			csr.setAproTtlAmt(sTotal_amt);
			csr.setCreUsrId(sCre_usr_id);

			// ApprovalUtil.java 가 아직 구 TABLE VO를 사용하고 있어서 주석처리 함 20090817 김진
			util.saveCsrApro(header, route, csr);

		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage());
		}
	}

	/**
	 * createInterfaceChgRevenueVVDCSRToLEA
	 * 
	 * @param sOldCsrNo
	 * @param sSuccessFlag
	 * @throws DAOException
	 */
	public void createInterfaceChgRevenueVVDCSRToLEA(String sOldCsrNo, String sSuccessFlag) throws DAOException {
		log.debug("::::::::::::::::::::::::::: <<< createInterfaceChgRevenueVVDCSRToLEA STARTING... >>> :::::::::::::::::::::::::::::::::::::::::::::::::::");

		Map<String, Object> param = new HashMap<String, Object>();

		try {
			param.put("CSR_NO", sOldCsrNo);
			param.put("GL_DT", sSuccessFlag);

			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOCreateInterfaceChgRevenueVVDCSRToLEACSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * CSR cancel
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void cancelCSRAPifError(EsdTrs0047Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		param.put("CSR_NO", event.getCsrNo());
		param.put("USR_ID", event.getUsrId());
		param.put("COST_OFC_CD", event.getCostOfcCd());

		try {
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOCancelCSRAPifErrorInvUSQL(), param, param);
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOCancelCSRAPifErrorRailInvUSQL(), param, param);
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOCancelCSRAPifErrorHDRDSQL(), param, param);
			new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOCancelCSRAPifErrorIFDSQL(), param, param);

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * CSR cancel
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void cancelCSRAPif(EsdTrs0048Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();

		String flag[] = event.getFlag();
		String inv_no[] = event.getInv_no();
		String inv_vndr_seq[] = event.getInv_vndr_seq();

		param.put("USR_ID", event.getUsrId());
		param.put("COST_OFC_CD", event.getCostOfcCd());
		param.put("CSR_NO", event.getCsrNo());

		try {
			// SO_HDR UPDATE
			for (int k = 0; k < flag.length; k++) {
				if (flag[k].equals("0"))
					param.put("TRSP_INV_AUD_STS_CD", "CF");
				else
					param.put("TRSP_INV_AUD_STS_CD", "SV");

				param.put("INV_NO", inv_no[k]);
				param.put("INV_VNDR_SEQ", inv_vndr_seq[k]);

				new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOCancelCSRAPifInvUSQL(), param, param);
				new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOCancelCSRAPifRailInvUSQL(), param, param);
				new SQLExecuter("DEFAULT").executeUpdate((ISQLTemplate) new CSRIssueTransferSlipManageDBDAOCancelCSRAPifErrorSacIfDSQL(), param, param);
			}

		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * CSR이 존재하는지 체크.<br>
	 * 
	 * @param sCheckCsrNo
	 * @throws DAOException
	 */
	public void checkCsrNoForApHdrDtrb(String sCheckCsrNo) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		final String errorMsg = "CSR No. " + sCheckCsrNo + " is Not Exist or Invalid!";
		int csrNoKnt = 0;
		param.put("CSR_NO", sCheckCsrNo);
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOCheckCsrNoForApHdrDtrbRSQL(), param, param);
			if (dRs.next())
				csrNoKnt = dRs.getInt("CSR_KNT");
			if (csrNoKnt < 1)
				throw new EventException(new ErrorHandler("TRS00099", new String[] { errorMsg }).getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * ASANO를 체크한다..
	 * 
	 * @param event
	 * @return
	 * @throws DAOException
	 */
	public String checkASANO(EsdTrs0031Event event) throws DAOException {
		Map<String, Object> param = new HashMap<String, Object>();
		String so_if_cd = "";
		try {
			param.put("OFC_CD", event.getCostOfcCd());
			DBRowSet dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOCheckASANORSQL(), param, param);
			if (dRs.next()) {
				so_if_cd = dRs.getString(1);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return so_if_cd;
	}

	/**
	 * Checking Coincidence Between Total Amount and Sum of Line Amount <br>
	 * 
	 * @param sCsrNo
	 * @throws DAOException
	 */
	public void checkSumLineAmountTotalAmount(String sCsrNo) throws DAOException {
		DBRowSet dRs = null;
		String sChkRslt = "";
		Map<String, Object> param = new HashMap<String, Object>();
		String errorMsg = "Difference between CSR Amount and Sum of Line Amount !";
		param.put("CSR_NO", sCsrNo);
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOCheckSumLineAmountTotalAmountRSQL(), param, param);
			if (dRs.next())
				sChkRslt = dRs.getString(1);

			if (sChkRslt == null || !"Y".equals(sChkRslt)) {
				throw new EventException(new ErrorHandler("TRS00099", new String[] { errorMsg }).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * AP_INV_HDR GL_DATE 비교.<br>
	 * 
	 * @param sCheckCsrNo
	 * @throws DAOException
	 */
	public void checkApInvHdrGLDT(String sCheckCsrNo) throws DAOException {
		String errorMsg = "No Open GL(Front System) Period IN GL Date Period OR The Next Period!";
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("csr_no", sCheckCsrNo);
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOCheckApInvHdrGLDTRSQL(), param, param);
			if (!dRs.next()) {
				throw new EventException(new ErrorHandler("TRS00099", new String[] { errorMsg }).getMessage());
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage(), se);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			throw new DAOException(new ErrorHandler(e).getMessage(), e);
		}
	}

	/**
	 * VVD Check.<br>
	 * 
	 * @param csr_no
	 * @throws DAOException
	 */
	public void checkRevenueVVDfromDTRB(String csr_no) throws DAOException {
		DBRowSet dRs = null;
		String dtrb_coa_acct_cd = "";
		String dtrb_coa_vvd_cd = "";
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("csr_no", csr_no);
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOCheckRevenueVVDfromDTRB01RSQL(), param, param);
			if (dRs.next()) {
				dtrb_coa_acct_cd = dRs.getString("dtrb_coa_acct_cd");
				dtrb_coa_vvd_cd = dRs.getString("dtrb_coa_vvd_cd");
				param.put("DTRB_COA_ACCT_CD", dtrb_coa_acct_cd);
				param.put("DTRB_COA_VVD_CD", dtrb_coa_vvd_cd);
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * VVD Check.<br>
	 * 
	 * @param sNewCsrNo
	 * @throws DAOException
	 */
	public void checkChgRevenueVVDDTRB(String sNewCsrNo) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("csr_no", sNewCsrNo);
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOCheckChgRevenueVVDDTRBRSQL(), param, param);
			if (dRs.next()) {
				int ttlAmt = Integer.parseInt(dRs.getString("ttl_amt"));
				if (ttlAmt == 999) {
					throw new DAOException("BKG NO 및 CHANGE REVENUE VVD에 대한 정보는 있으나 SUM OF AMOUT EQUALS ZERO RULE에 어긋납니다.");
				}
			} else {
				throw new DAOException("BKG NO 및 CHANGE REVENUE VVD에 대한 정보는 있으나 SUM OF AMOUT EQUALS ZERO RULE에 어긋납니다.");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * CSR 발행여부를 체크한다. <br>
	 * 생성일 : 2009-02-10
	 * 
	 * @param event
	 * @throws DAOException
	 */
	public void checkCsrNoDup(EsdTrs0032Event event) throws DAOException {
		DBRowSet dRs = null;
		int sChkRslt = 0;
		String invNo[] = event.getInv_no();
		String invVndrSeq[] = event.getInv_vndr_seq();

		final String errorMsg = "CSR has been already created.!";
		Map<String, Object> param = new HashMap<String, Object>();
		List<twoParamVO> paramArr = new ArrayList<twoParamVO>();

		for (int i = 0; i < invNo.length; i++) {
			twoParamVO twoVO = new twoParamVO();
			twoVO.setField1(invNo[i]);
			twoVO.setField2(invVndrSeq[i]);
			paramArr.add(twoVO);
		}
		param.put("INV_NO", paramArr);
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOCheckCsrNoDupRSQL(), param, param);
			if (dRs.next())
				sChkRslt = dRs.getInt(1);

			if (sChkRslt > 0)
				throw new EventException(new ErrorHandler("TRS00099", new String[] { errorMsg }).getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
	}

	/**
	 * Office Change시 변경된 국가코드를 조회한다.<br>
	 * N200905040013 2009-05-11: Office Change 개념의 모듈적용
	 * 
	 * @param office_cd
	 * @return
	 * @throws DAOException
	 */
	public String searchOfficeChangedCntCd(String office_cd) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String cnt_cd = "";
		param.put("ofc_cd", office_cd);
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOSearchOfficeChangedCntCdRSQL(), param, param);
			if (dRs.next())
				cnt_cd = dRs.getString("CNT_CD");
			else
				throw new DAOException(new ErrorHandler("TPB00061").getMessage());
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return cnt_cd;
	}

	/**
	 * Hold Invoice No����븯��泥댄겕 �쒕떎.<br>
	 * 
	 * @param EsdTrs0032Event event
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckHoldInvoice(EsdTrs0032Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		Map<String, Object> velParam = new HashMap<String, Object>();
		ArrayList<String> invNoArrL = new ArrayList<String>();
		ArrayList<String> invVndrSeqArrL = new ArrayList<String>();
		StringTokenizer strInvNo = null;
		StringTokenizer strInvVndrSeq = null;
		String tmpInvNo = "";
		String tmpInvVndrSeq = "";
		String holdInvNo = "";

		String sInvNo = event.getInvNo();
		String sInvVndrSeq = event.getInvVndrSeq();
		int lenSInvNo = sInvNo.length();
		int lenSInvVndrSeq = sInvVndrSeq.length();

		if (!sInvNo.equals("")) {
			sInvNo = sInvNo.substring(0, lenSInvNo);
			strInvNo = new StringTokenizer(sInvNo, "|");
			tmpInvNo = strInvNo.nextToken();
			invNoArrL.add(tmpInvNo);

			while (strInvNo.hasMoreTokens()) {
				tmpInvNo = strInvNo.nextToken();
				invNoArrL.add(tmpInvNo);
			}
		}
		if (invNoArrL.size() > 0) {
			param.put("inv_no", invNoArrL);
			velParam.put("inv_no", invNoArrL);
		}

		if (!sInvVndrSeq.equals("")) {
			sInvVndrSeq = sInvVndrSeq.substring(0, lenSInvVndrSeq);
			strInvVndrSeq = new StringTokenizer(sInvVndrSeq, "|");
			tmpInvVndrSeq = strInvVndrSeq.nextToken();
			invVndrSeqArrL.add(tmpInvVndrSeq);
			while (strInvVndrSeq.hasMoreTokens()) {
				tmpInvVndrSeq = strInvVndrSeq.nextToken();
				invVndrSeqArrL.add(tmpInvVndrSeq);
			}
		}
		if (invVndrSeqArrL.size() > 0) {
			param.put("inv_vndr_seq", invVndrSeqArrL);
			velParam.put("inv_vndr_seq", invVndrSeqArrL);
		}
		try {
			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOCheckHoldInvoiceRSQL(), param, velParam);
			if (dRs.next()) {
				holdInvNo = dRs.getString("hold_inv_no");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return holdInvNo;
	}

	/**
	 * Search the AP Office of invoice office
	 * 
	 * @param EsdTrs0032Event event
	 * @return String
	 * @throws DAOException
	 */
	public String searchCheckAPoffice(EsdTrs0032Event event) throws DAOException {
		DBRowSet dRs = null;
		Map<String, Object> param = new HashMap<String, Object>();
		String apOfcCd = "";

		try {
			param.put("cost_ofc_cd", event.getCostOfcCd());

			dRs = new SQLExecuter("DEFAULT").executeQuery(new CSRIssueTransferSlipManageDBDAOCheckAPinvoiceRSQL(), param, param);
			if (dRs.next()) {
				apOfcCd = dRs.getString("AP_OFC_CD");
			}
		} catch (SQLException se) {
			log.error(se.getMessage(), se);
			throw new DAOException(new ErrorHandler(se).getMessage());
		} catch (Exception ee) {
			log.error(ee.getMessage(), ee);
			throw new DAOException(ee.getMessage());
		}
		return apOfcCd;
	}
}