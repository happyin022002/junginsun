/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CSRIssueTransferSlipManageBCImpl.java
 *@FileTitle : BTransportation invoice CSR Creation - Detail
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.basic;

import java.sql.SQLException;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.basic.TPBInterfaceBCImpl;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0031Event;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0032Event;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0034Event;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0047Event;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0048Event;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0960Event;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.integration.CSRIssueTransferSlipManageDBDAO;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.basic.BasicCommandSupport;
import com.clt.framework.utility.CheckUtilities;
import com.clt.apps.opus.esd.tpb.common.tpbinterface.vo.TPBInterfaceVO;

/**
 * ESD-TRS Business Logic Basic Command implementation<br>
 * - ESD-TRS business logic handling.<br>
 * 
 * @author kimjin
 * @see ESD_TRS_024EventResponse,CSRIssueTransferSlipManageBC each DAO class reference
 * @since J2EE 1.6
 * @History 2009-02-10 : CSR duplicate check issued additional logic
 */
public class CSRIssueTransferSlipManageBCImpl extends BasicCommandSupport implements CSRIssueTransferSlipManageBC {
	private transient CSRIssueTransferSlipManageDBDAO dbDao = null;

	/**
	 * CSRIssueTransferSlipManageBCImpl object creation<br>
	 * CSRIssueTransferSlipManageDBDAO creation<br>
	 */
	public CSRIssueTransferSlipManageBCImpl() {
		dbDao = new CSRIssueTransferSlipManageDBDAO();
	}

	/**
	 * retrieve event handling<br>
	 * CSRIssueTransferSlipManage screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_031Event
	 * @return EventResponse ESD_TRS_031EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummary(Event e) throws EventException {
		EsdTrs0031Event event = (EsdTrs0031Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchCSRSummary(event);
			eventResponse.setRsVo(rowSet);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event handling<br>
	 * CSRIssueTransferSlipManage screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_032Event
	 * @return EventResponse ESD_TRS_032EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRSummaryDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0032Event event = (EsdTrs0032Event) e;
		DBRowSet rowSet = null;
		DBRowSet asaSet = null;
		DBRowSet ap_ofc_cd = null;

		try {
			rowSet = dbDao.searchCSRSummaryDetail(event);
			asaSet = dbDao.searchASANOList(event);
			ap_ofc_cd = dbDao.searchApOfcCD(event);

			eventResponse.setRsVo(rowSet);
			if (asaSet.next()) {
				eventResponse.setETCData("asaNoString", asaSet.getString("asanostring"));
				eventResponse.setETCData("csrNo", "");
			}
			if (ap_ofc_cd.next()) {
				eventResponse.setETCData("apOfcCd", ap_ofc_cd.getString("AP_OFC_CD"));
			}
		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event handling<br>
	 * CSRIssueTransferSlipManage screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_032Event
	 * @return EventResponse ESD_TRS_032EventResponse
	 * @exception EventException
	 */
	public EventResponse correctCsrAmt(Event e) throws EventException {
		EsdTrs0032Event event = (EsdTrs0032Event) e;
		try {
			log.info("\n TRS START ... correctCsrAmt:" + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date())) + "\n");

			dbDao.correctSvcOrdMstCsrScgCorrAmt(event);
			/** SURCHARGE AMOUNT CORRECTION */
			dbDao.correctSvcOrdMstCsrBzcCorrAmt(event);
			/** BASIC AMOUNT CORRECTION */
			dbDao.correctRfndInvCsrCorrAmt(event);
			/** REFUND AMOUNT CORRECTION */

			log.info("\n TRS FINISH ... correctCsrAmt:" + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date())) + "\n");

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return null;
	}

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param e ESD_TRS_032Event
	 * @return EventResponse ESD_TRS_032EventResponse
	 * @exception EventException
	 */
	public String generateNewCsrNo(Event e) throws EventException {
		EsdTrs0032Event event = (EsdTrs0032Event) e;
		String sCsrNo = null;
		try {
			log.info("\n TRS START ... generateNewCsrNo:" + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date())) + "\n");
			sCsrNo = dbDao.createCsrNo(event);
			log.info("\n TRS FINISH ... generateNewCsrNo:" + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date())) + "\n");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return sCsrNo;
	}

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param e ESD_TRS_032Event
	 * @return EventResponse ESD_TRS_032EventResponse
	 * @exception EventException
	 */
	public EventResponse createApInvHdrDtrb(Event e) throws EventException {
		EsdTrs0032Event event = (EsdTrs0032Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			dbDao.createApInvHDR(event);
			dbDao.createApInvDtrb(event);
			if (event.getCntCd().equals("JP")) {
				dbDao.createApInvKRDtrb(event);
			}
			if (!CheckUtilities.isInBlank(event.getAsaNo())) {
				dbDao.createApInvDTRBASANo(event);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		eventResponse.setETCData("csrNo", event.getCsr_no());
		return eventResponse;
	}

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param sCsrNo
	 * @exception EventException
	 */
	public void updateApInvDtrbLineNo(String sCsrNo) throws EventException {
		try {
			dbDao.modifyApInvDTRBLineNo(sCsrNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param e ESD_TRS_032Event
	 * @exception EventException
	 */
	public void updateCntrFincVVD(Event e) throws EventException {
		EsdTrs0032Event event = (EsdTrs0032Event) e;
		try {
			log.info("\n TRS START ... updateCntrFincVVD:" + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date())) + "\n");
			dbDao.updateCntrFincVVD(event);
			log.info("\n TRS FINISH ... updateCntrFincVVD:" + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date())) + "\n");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param sCsrNo
	 * @param sPreviewIndicator
	 * @return EventResponse ESD_TRS_032EventResponse
	 * @exception EventException
	 */
	public EventResponse selectApInvHdrDtrbList(String sCsrNo, String sPreviewIndicator) throws EventException {

		DBRowSet hdrSet = null;
		DBRowSet dtrbSet = null;

		try {
			log.info("\n TRS START ... selectApInvHdrDtrbList:" + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date())) + "\n");
			hdrSet = dbDao.searchPreviewHDR(sCsrNo, sPreviewIndicator);
			dtrbSet = dbDao.searchPreviewDTRBList(sCsrNo);
			log.info("\n TRS FINISH ... selectApInvHdrDtrbList:" + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date())) + "\n");
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			if (hdrSet.next()) {
				eventResponse.setETCData("pre_csr_no", hdrSet.getString("pre_csr_no"));
				eventResponse.setETCData("pre_office", hdrSet.getString("pre_office"));
				eventResponse.setETCData("pre_prpd_dy", hdrSet.getString("pre_prpd_dy"));
				eventResponse.setETCData("pre_pay_to", hdrSet.getString("pre_pay_to"));
				eventResponse.setETCData("pre_csr_type", hdrSet.getString("pre_csr_type"));
				eventResponse.setETCData("pre_desc", hdrSet.getString("pre_desc"));
				eventResponse.setETCData("pre_pay_group", hdrSet.getString("pre_pay_group"));
				eventResponse.setETCData("pre_evi_tp", hdrSet.getString("pre_evi_tp"));
				eventResponse.setETCData("pre_due_date", hdrSet.getString("pre_due_date"));
				eventResponse.setETCData("pre_asa_no", hdrSet.getString("pre_asa_no"));
				eventResponse.setETCData("pre_inv_dt", hdrSet.getString("pre_inv_dt"));
				eventResponse.setETCData("pre_curr_cd", hdrSet.getString("pre_curr_cd"));
				eventResponse.setETCData("pre_amt", hdrSet.getString("pre_amt"));
				eventResponse.setETCData("chk_mail", hdrSet.getString("chk_mail"));
				eventResponse.setETCData("chk_mail1", hdrSet.getString("chk_mail1"));
				eventResponse.setETCData("chk_mail2", hdrSet.getString("chk_mail2"));
				eventResponse.setETCData("chk_mail3", hdrSet.getString("chk_mail3"));
				eventResponse.setETCData("chk_mail4", hdrSet.getString("chk_mail4"));
				eventResponse.setETCData("chk_mail5", hdrSet.getString("chk_mail5"));
				eventResponse.setETCData("chk_mail6", hdrSet.getString("chk_mail6"));
				eventResponse.setETCData("chk_mail7", hdrSet.getString("chk_mail7"));
			}

			eventResponse.setRsVo(dtrbSet);
			return eventResponse;

		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param sCsrNo
	 * @exception EventException
	 */
	public void deleteInvHdrDtrbList(String sCsrNo) throws EventException {
		try {
			log.info("\n TRS START ... deletePreviewInvHdrDtrbList:" + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date())) + "\n");
			dbDao.deleteApInvHDRDTRB(sCsrNo);
			/** DELETING AFTER PREVIEW ROWSET GENERATION */
			log.info("\n TRS FINISH ... deletePreviewInvHdrDtrbList:" + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date())) + "\n");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event handling<br>
	 * CSRIssueTransferSlipManage screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_034Event
	 * @return EventResponse ESD_TRS_034EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTAXInfo(Event e) throws EventException {
		EsdTrs0034Event event = (EsdTrs0034Event) e;
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchTAXDetail(event.getVndrSeq(), event.getWoVndrSeq());
			FormCommand formcommand = e.getFormCommand();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			if (rowSet.next()) {
				if (formcommand.isCommand(FormCommand.SEARCHLIST)) {
					eventResponse.setETCData("vndr_nm", rowSet.getString("vndr_nm"));
					eventResponse.setETCData("bzct_nm", rowSet.getString("bzct_nm"));
					eventResponse.setETCData("bztp_nm", rowSet.getString("bztp_nm"));
					eventResponse.setETCData("vndr_addr", rowSet.getString("vndr_addr"));
					eventResponse.setETCData("ceo_nm", rowSet.getString("ceo_nm"));
					eventResponse.setETCData("rgst_no", rowSet.getString("rgst_no"));
					eventResponse.setETCData("wkplc_nmstring", rowSet.getString("evi_code"));
				}
			}
			return eventResponse;
		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * retrieve event handling<br>
	 * CSRIssueTransferSlipManage screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_024Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchApEviNo(Event e) throws EventException {
		EsdTrs0034Event event = (EsdTrs0034Event) e;
		try {
			String tax_no3 = dbDao.searchApEviNo(event);
			FormCommand formcommand = e.getFormCommand();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("tax_no3", tax_no3);
			if (formcommand.isCommand(FormCommand.MULTI01)) {
				eventResponse.setETCData("gsFlg", "MULTI01");
			} else if (formcommand.isCommand(FormCommand.MULTI02)) {
				eventResponse.setETCData("gsFlg", "MULTI02");
			}
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event handling<br>
	 * CSRIssueTransferSlipManage screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_034Event
	 * @return EventResponse ESD_TRS_024EventResponse
	 * @exception EventException
	 */
	public EventResponse searchTAXCode(Event e) throws EventException {
		EsdTrs0034Event event = (EsdTrs0034Event) e;
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchTAXCode(event);
			FormCommand formcommand = e.getFormCommand();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if (rowSet.next()) {
				eventResponse.setETCData("tax_code", rowSet.getString("ap_tax_nm"));
				if (formcommand.isCommand(FormCommand.MULTI01)) {
					eventResponse.setETCData("gsFlg", "MULTI01");
				} else if (formcommand.isCommand(FormCommand.MULTI02)) {
					eventResponse.setETCData("gsFlg", "MULTI02");
				}
			}
			return eventResponse;
		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param sCsrNo
	 * @return EventResponse ESD_TRS_032EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCsrPreVeiw(String sCsrNo) throws EventException {
		DBRowSet hdrSet = null;
		DBRowSet dtrbSet = null;
		try {
			hdrSet = dbDao.searchPreviewHDR(sCsrNo, "");
			dtrbSet = dbDao.searchPreviewDTRBList(sCsrNo);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if (hdrSet.next()) {
				eventResponse.setETCData("pre_csr_no", hdrSet.getString("pre_csr_no"));
				eventResponse.setETCData("pre_office", hdrSet.getString("pre_office"));
				eventResponse.setETCData("pre_prpd_dy", hdrSet.getString("pre_prpd_dy"));
				eventResponse.setETCData("pre_pay_to", hdrSet.getString("pre_pay_to"));
				eventResponse.setETCData("pre_csr_type", hdrSet.getString("pre_csr_type"));
				eventResponse.setETCData("pre_desc", hdrSet.getString("pre_desc"));
				eventResponse.setETCData("pre_pay_group", hdrSet.getString("pre_pay_group"));
				eventResponse.setETCData("pre_evi_tp", hdrSet.getString("pre_evi_tp"));
				eventResponse.setETCData("pre_due_date", hdrSet.getString("pre_due_date"));
				eventResponse.setETCData("pre_asa_no", hdrSet.getString("pre_asa_no"));
				eventResponse.setETCData("pre_inv_dt", hdrSet.getString("pre_inv_dt"));
				eventResponse.setETCData("pre_curr_cd", hdrSet.getString("pre_curr_cd"));
				eventResponse.setETCData("pre_amt", hdrSet.getString("pre_amt"));
				eventResponse.setETCData("pre_pay_curr_cd", hdrSet.getString("pre_pay_curr_cd"));
				eventResponse.setETCData("pre_pay_amt", hdrSet.getString("pre_pay_amt"));
				eventResponse.setETCData("pre_evi_tp_count", hdrSet.getString("pre_evi_tp_count"));
				eventResponse.setETCData("pre_appro_by", hdrSet.getString("pre_appro_by"));
				eventResponse.setETCData("chk_mail", hdrSet.getString("chk_mail"));
				eventResponse.setETCData("chk_mail1", hdrSet.getString("chk_mail1"));
				eventResponse.setETCData("chk_mail2", hdrSet.getString("chk_mail2"));
				eventResponse.setETCData("chk_mail3", hdrSet.getString("chk_mail3"));
				eventResponse.setETCData("chk_mail4", hdrSet.getString("chk_mail4"));
				eventResponse.setETCData("chk_mail5", hdrSet.getString("chk_mail5"));
				eventResponse.setETCData("chk_mail6", hdrSet.getString("chk_mail6"));
				eventResponse.setETCData("chk_mail7", hdrSet.getString("chk_mail7"));
			}
			eventResponse.setRsVo(dtrbSet);
			return eventResponse;
		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param e ESD_TRS_0048Event
	 * @return EventResponse ESD_TRS_0048EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCsrCancel(Event e) throws EventException {
		EsdTrs0048Event event = (EsdTrs0048Event) e;
		DBRowSet rowSet_top = null;
		DBRowSet rowSet = null;
		try {
			rowSet_top = dbDao.searchInvoiceInquiry(event);
			rowSet = dbDao.searchInvoiceInquiryList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			if (rowSet_top.next()) {
				eventResponse.setETCData("csr_no", rowSet_top.getString("csr_no"));
				eventResponse.setETCData("vndr_no", rowSet_top.getString("vndr_no"));
				eventResponse.setETCData("vndr_nm", rowSet_top.getString("vndr_nm"));
				eventResponse.setETCData("inv_cnt", rowSet_top.getString("inv_cnt"));
				eventResponse.setETCData("csr_curr_cd", rowSet_top.getString("csr_curr_cd"));
				eventResponse.setETCData("csr_amt", rowSet_top.getString("csr_amt"));
				eventResponse.setETCData("max_iss_dt", rowSet_top.getString("max_iss_dt"));
				eventResponse.setETCData("max_rcv_dt", rowSet_top.getString("max_rcv_dt"));
				eventResponse.setETCData("asa_no", rowSet_top.getString("asa_no"));
				eventResponse.setETCData("vndr_term_nm", rowSet_top.getString("vndr_term_nm"));
				eventResponse.setETCData("cost_ofc", rowSet_top.getString("cost_ofc"));
				eventResponse.setETCData("payment_due_dt", rowSet_top.getString("pre_due_date"));
			}
			return eventResponse;

		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * Service Management > Trans S/O > CSR > CSR I/F Status Inquiry : get main list
	 * 
	 * @param e ESD_TRS_047Event
	 * @return EventResponse ESD_TRS_047EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCSRAPiflist(Event e) throws EventException {
		EsdTrs0047Event event = (EsdTrs0047Event) e;
		DBRowSet rowSet = null;
		try {
			rowSet = dbDao.searchCSRAPiflist(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);

			return eventResponse;

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve event handling<br>
	 * CSRIssueTransferSlipManage screen views for event handling<br>
	 * 
	 * @param e ESD_TRS_0960Event
	 * @return EventResponse ESD_TRS_0960EventResponse
	 * @exception EventException
	 */
	public EventResponse searchInvoiceListInquiry(Event e) throws EventException {
		EsdTrs0960Event event = (EsdTrs0960Event) e;
		DBRowSet rowSet_top = null;
		DBRowSet rowSet = null;

		try {
			rowSet_top = dbDao.searchInvoiceInquiry(event);
			rowSet = dbDao.searchInvoiceInquiryList(event);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(rowSet);
			if (rowSet_top.next()) {
				eventResponse.setETCData("csr_no", rowSet_top.getString("csr_no"));
				eventResponse.setETCData("vndr_no", rowSet_top.getString("vndr_no"));
				eventResponse.setETCData("vndr_nm", rowSet_top.getString("vndr_nm"));
				eventResponse.setETCData("inv_cnt", rowSet_top.getString("inv_cnt"));
				eventResponse.setETCData("csr_curr_cd", rowSet_top.getString("csr_curr_cd"));
				eventResponse.setETCData("csr_amt", rowSet_top.getString("csr_amt"));
				eventResponse.setETCData("max_iss_dt", rowSet_top.getString("max_iss_dt"));
				eventResponse.setETCData("max_rcv_dt", rowSet_top.getString("max_rcv_dt"));
				eventResponse.setETCData("asa_no", rowSet_top.getString("asa_no"));
				eventResponse.setETCData("vndr_term_nm", rowSet_top.getString("vndr_term_nm"));
				eventResponse.setETCData("cost_ofc", rowSet_top.getString("cost_ofc"));
				eventResponse.setETCData("payment_due_dt", rowSet_top.getString("pre_due_date"));
			}
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (SQLException se) {
			log.error("err " + se.toString(), se);
			throw new EventException(se.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param sCsrNo
	 * @exception EventException
	 */
	public void checkApInvDtrbValidation(String sCsrNo) throws EventException {
		try {
			/** Checking Coincidence Between Total Amount and Sum of Line Amount */
			dbDao.checkSumLineAmountTotalAmount(sCsrNo);

			/** R.VVD CHECK */
			dbDao.checkRevenueVVDfromDTRB(sCsrNo);

			/** GL DT CHECK */
			dbDao.checkApInvHdrGLDT(sCsrNo);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * <br>
	 * CSRIssueTransferSlipManage<br>
	 * 
	 * @param e ESD_TRS_032Event
	 * @exception EventException
	 */
	public void createApInvIF(Event e) throws EventException {
		EsdTrs0032Event event = (EsdTrs0032Event) e;
		try {
			dbDao.approvalRequest(event);
			dbDao.checkCsrNoDup(event);
			dbDao.updateCSRSOHDRsts(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Payment -> TRS TEMP
	 * 
	 * @param flag String
	 * @param sCsrNo
	 * @exception EventException
	 */
	public void trsUpdateCSRSTSFlag(String flag, String sCsrNo) throws EventException {
		try {
			/** APPROVAL CONFIRM */
			if (flag.equals("C")) {
				/** TRS_TRSP_INV_WRK [TRS_TRSP_RAIN_INV_WRK].TRSP_INV_AUD_STS_CD = 'IF'(INTERFACED) UPDATE */
				dbDao.updateCSRSTSFlag(sCsrNo, "IF");
				/** APPROVAL REJECT */
			} else if (flag.equals("R")) {
				/** TRS_TRSP_INV_WRK [TRS_TRSP_RAIN_INV_WRK].TRSP_INV_AUD_STS_CD = 'DA'(DISAPPROVED) UPDATE */
				dbDao.updateCSRSTSFlag(sCsrNo, "DA");
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * AGT -- > TRS - > LED (Succeed)
	 * 
	 * @param sCsrNo
	 * @exception EventException
	 */
	public void approvalSuccess(String sCsrNo) throws EventException {
		final String tpbIfError = "TPB";
		TPBInterfaceVO[] models = null;

		/** GL_DT UPDATE TRANSACTION */
		try {
			log.info("\n DONE - approvalSuccess.updateGLDT = CSR_NO:" + JSPUtil.getNull(sCsrNo) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date())) + "\n");
			dbDao.updateGLDT(sCsrNo, "U");

		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			log.error("\n DONE - approvalSuccess.updateApInvHdrIFErrRsn(GL_DT_UPDATE_ERROR) = CSR_NO:" + JSPUtil.getNull(sCsrNo) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date())) + "\n");
			throw new EventException(de.getMessage());
		}

		/** LEA I/F TRANSACTION */

		/** TPB UPDATE TRANSACTION */
		try {
			TPBInterfaceBCImpl tbpIF = new TPBInterfaceBCImpl();
			models = dbDao.searchTrs3PtyIF(sCsrNo);

			if (models != null)
				tbpIF.createTRSTPB(models);

			log.info("\n DONE - approvalSuccess.createTRSTPB = CSR_NO:" + JSPUtil.getNull(sCsrNo) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date())) + "\n");
		} catch (DAOException de1) {
			log.error("err " + de1.toString(), de1);
			try {
				dbDao.updateApInvHdrIFErrRsn(sCsrNo, tpbIfError);
				log.error("\n DONE - approvalSuccess.updateApInvHdrIFErrRsn(TPB_IF_ERROR) = CSR_NO:" + JSPUtil.getNull(sCsrNo) + " - " + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date())) + "\n");
			} catch (DAOException de2) {
				log.error("err " + de2.toString(), de2);
				throw new EventException(de2.getMessage());
			}
			throw new EventException(de1.getMessage());
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * AGT -- > TRS - > LED (Reject)
	 * 
	 * @param sCsrNo
	 * @exception EventException
	 */
	public void approvalReject(String sCsrNo) throws EventException {
		try {
			if (!"12".equals(sCsrNo.substring(0, 2)))
				dbDao.createInterfaceChgRevenueVVDCSRToLEA(sCsrNo, "CANCEL");
			/** '13' CSR : Revenue VVD Change AP_INV_HDR.RCV_ERR_FLG = 'E' */
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * AP Interface - > TRS
	 * 
	 * @param obj
	 * @exception EventException
	 */
	public void modifyTrsInvHdr(Object obj) throws EventException {
		try {
			dbDao.modifyTrsInvHdr(obj);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
	}

	/**
	 * CSR cancel
	 * 
	 * @param e ESD_TRS_047Event
	 * @return EventResponse ESD_TRS_047EventResponse
	 * @exception EventException
	 */
	public EventResponse cancelCSRAPifError(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0047Event event = (EsdTrs0047Event) e;
		try {
			dbDao.cancelCSRAPifError(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * CSR cancel
	 * 
	 * @param e ESD_TRS_048Event
	 * @return EventResponse ESD_TRS_048EventResponse
	 * @exception EventException
	 */
	public EventResponse cancelCSRAPif(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0048Event event = (EsdTrs0048Event) e;
		try {
			dbDao.cancelCSRAPif(event);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * retrieve event handling<br>
	 * CSRIssueTransferSlipManage ASA code related<br>
	 * 
	 * @param e ESD_TRS_031Event
	 * @return EventResponse ESD_TRS_031EventResponse
	 * @exception EventException
	 */
	public EventResponse checkASANO(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0031Event event = (EsdTrs0031Event) e;
		try {
			eventResponse.setETCData("asaFlag", dbDao.checkASANO(event));
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception ex) {
			log.error(ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * <br>
	 * CSRIssueTransferSlipManage涌∽옙占�R.VVD Change<br>
	 * 
	 * @param e ESD_TRS_0047Event
	 * @return EventResponse ESD_TRS_0047EventResponse
	 * @exception EventException
	 */
	public DBRowSet[] generateApInvDTRB(Event e) throws EventException {
		DBRowSet[] oApDtrbRowSetArr = null;
		EsdTrs0032Event event = (EsdTrs0032Event) e;
		try {
			log.info("\n generateApInvDTRB <<<GENERATING START>>>:" + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date())) + "\n");

			/** STEP 00. generating AP_INV_DTRB ArrayList */
			oApDtrbRowSetArr = dbDao.generateApInvDTRB(event);

			log.info("\n generateApInvDTRB <<<GENERATING FINISH>>>:" + ((new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ssSSS")).format(new java.util.Date())) + "\n");
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return oApDtrbRowSetArr;
	}

	/**
	 * Office Change City changed the country code lookup N200905040013 2009-05-11: Office Change of the concept applied modules
	 * 
	 * @param sOfficeCd
	 * @return String
	 * @exception EventException
	 */
	public String searchOfficeChangedCntCd(String sOfficeCd) throws EventException {
		String cnt_cd = "";
		try {
			cnt_cd = dbDao.searchOfficeChangedCntCd(sOfficeCd);
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		}
		return cnt_cd;
	}

	/**
	 * Hold Invoice No is checked for.
	 * 
	 * 
	 * @param Event e
	 * @return EventResponse ESD_TRS_0032EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCheckHoldInvoice(Event e) throws EventException {
		EsdTrs0032Event event = (EsdTrs0032Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setETCData("holdInvNo", dbDao.searchCheckHoldInvoice(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Search the AP Office of invoice office
	 * 
	 * 
	 * @param Event e
	 * @return EventResponse ESD_TRS_0032EventResponse
	 * @exception EventException
	 */
	public EventResponse searchCheckAPoffice(Event e) throws EventException {
		EsdTrs0032Event event = (EsdTrs0032Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			eventResponse.setETCData("apOfcCd", dbDao.searchCheckAPoffice(event));
			return eventResponse;
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * Payment(AP) -> TRS [PD / RJ / IF] TEMP
	 * 
	 * @param sCsrNo
	 * @param sTrspInvAudStsCd
	 * @param sDate
	 * @param sInvPayMzdCd
	 * @throws EventException
	 */
	public void trsUpdateCSRInvAudSts(String sCsrNo, String sTrspInvAudStsCd, String sDate, String sInvPayMzdCd) throws EventException {
		try {
			/** INVOICE STATUS : PAID(PD) */
			if ("PD".equals(sTrspInvAudStsCd)) {
				dbDao.updateCSRPaid(sCsrNo, sDate, sInvPayMzdCd, null);
				/** INVOICE STATUS : REJECTED(RJ) */
			} else if ("RJ".equals(sTrspInvAudStsCd)) {
				dbDao.updateCSRRejection(sCsrNo, sDate, sInvPayMzdCd, null);
				/** INVOICE STATUS : INTERFACE(IF) */
			} else if ("IF".equals(sTrspInvAudStsCd)) {
				dbDao.updateCSRInterface(sCsrNo, sInvPayMzdCd, null);
			}
		} catch (DAOException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * ESD finishing business scenarios<br>
	 * At the end of business-related internal objects CSRIssueTransferSlipManage release scenarios<br>
	 */
	public void doEnd() {
		dbDao = null;
	}
}
