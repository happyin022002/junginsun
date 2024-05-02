/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : InvoiceManageSC.java
 *@FileTitle : surcharge Add/Amend/Delete page
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.invoicemanage;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBC;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.basic.CSRIssueTransferSlipManageBCImpl;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0031Event;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0032Event;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0034Event;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0047Event;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0048Event;
import com.clt.apps.opus.esd.trs.invoicemanage.csrissuetranferslip.event.EsdTrs0960Event;
import com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.basic.InvoiceAuditBC;
import com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.basic.InvoiceAuditBCImpl;
import com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0033Event;
import com.clt.apps.opus.esd.trs.invoicemanage.invoiceaudit.event.EsdTrs0040Event;
import com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.basic.InvoiceInquiryCorrectionBC;
import com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.basic.InvoiceInquiryCorrectionBCImpl;
import com.clt.apps.opus.esd.trs.invoicemanage.invoiceinquirycorrection.event.EsdTrs0030Event;
import com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.basic.PoolChassisBC;
import com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.basic.PoolChassisBCImpl;
import com.clt.apps.opus.esd.trs.invoicemanage.poolchassis.event.EsdTrs0041Event;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.basic.RailInvoiceauditBC;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.basic.RailInvoiceauditBCImpl;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0038Event;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceaudit.event.EsdTrs0923Event;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceinquirycorrection.basic.RailInvoiceInquiryCorrectionBC;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceinquirycorrection.basic.RailInvoiceInquiryCorrectionBCImpl;
import com.clt.apps.opus.esd.trs.invoicemanage.railinvoiceinquirycorrection.event.EsdTrs0046Event;
import com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.basic.SurchargeInputInquiryBC;
import com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.basic.SurchargeInputInquiryBCImpl;
import com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.event.EsdTrs0918Event;
import com.clt.apps.opus.esd.trs.invoicemanage.surchargeinputinquiry.vo.SurchargeVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBC;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.basic.WorkOrderManagementBC;
import com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.basic.WorkOrderManagementBCImpl;
import com.clt.bizcommon.approval.basic.ApprovalBC;
import com.clt.bizcommon.approval.basic.ApprovalBCImpl;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.TrsTrspRailInvDtlVO;
import com.clt.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * ESD-InvoiceManage Business Logic ServiceCommand<br>
 * 
 * @author
 * @see ESD_TRS_918EventResponse,SurchargeInputInquiryDBDAO
 * @since J2EE 1.4
 */
public class InvoiceManageSC extends ServiceCommandSupport {
	/**
	 * Preceding process of InvoiceManage task scenario<br>
	 * Generating the implicit object when ChassisGensetSOManage task is called.<br>
	 */
	public void doStart() {
		log.debug("start of InvoiceManageSC");
	}

	/**
	 * End process of InvoiceManage task scenario<br>
	 * Releasing the related implicit object when SurchargeInputInquiry task is end<br>
	 */
	public void doEnd() {
		log.debug("end of InvoiceManageSC");
	}

	/**
	 * Performing the task scenario corresponding each event.<br>
	 * Branch processing of every event occurring at ESD-TRS task<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		String sCsrNo = null;
		if (e.getEventName().equalsIgnoreCase("EsdTrs0918Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSurchargeInputInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSurchargeCodeNameList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchTPBIfFlag(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				eventResponse = addTempSurchargeList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchInvoiceAuditList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchPaymentSP(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchDupChkInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchInvoiceAuditListByInvoiceNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = verifyEqNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchInvOfcCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = rejectInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = searchMdmOrganization(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = calculateExchangeRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = saveInvoiceAudit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = confirmInvoiceAudit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = confirmInvoiceAuditForNoTranjection(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = verifyTruckInvoiceFileImport(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchTruckInvoiceFileImport(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				eventResponse = searchInvoiceImportDuplicateCheckByDate2(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
				eventResponse = searchN3ptyCurrCd(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0038Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchPaymentVndrList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRailinvoiceauditList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = modifyRailinvoiceaudit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH20)) {
				eventResponse = searchContainerInfo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0923Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = verifyRailInvoiceFileImportEqNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0929Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPaymentHistoryList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0925Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReAuditInfoList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceInquiryCorrectionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = confirmInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = confirmCancelInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = saveHold(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = modifyInvOfcCdForSPP(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = deleteInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchInvoiceConfrimAmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchInvoiceInquirySecondExcelForm(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0031Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRSummary(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkASANO(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0032Event")) {
			EsdTrs0032Event event = (EsdTrs0032Event) e;

			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRSummaryDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = approvalRequest(event);
				/** ++ approvalRequest, ++ updateCSRSOHDRsts */
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = approvalPreview(event);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchCheckHoldInvoice(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchCheckAPoffice(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0034Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchTAXInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				EsdTrs0032Event event = (EsdTrs0032Event) e;

				approvalRequest(event);
				/** ++ approvalRequest, ++ updateCSRSOHDRsts */
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = searchApEviNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = searchTAXCode(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0037Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRSummaryDetail(e);

			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				EsdTrs0032Event event = (EsdTrs0032Event) e;
				correctCsrAmt(event);
				/** CORRECTION INVOICE AMOUNT FOR CSR */
				sCsrNo = generateNewCsrNo(event);
				event.setCsr_no(sCsrNo);

				createApInvHdrDtrb(event);
				checkApInvDtrbValidation(sCsrNo);
				updateApInvDtrbLineNo(sCsrNo);
				createApInvIF(event);
				/** ++ approvalRequest, ++ updateCSRSOHDRsts */
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0036Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRSummaryDetail(e);

			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				EsdTrs0032Event event = (EsdTrs0032Event) e;
				correctCsrAmt(event);
				/** CORRECTION INVOICE AMOUNT FOR CSR */
				sCsrNo = generateNewCsrNo(event);
				event.setCsr_no(sCsrNo);

				createApInvHdrDtrb(event);
				checkApInvDtrbValidation(sCsrNo);
				updateApInvDtrbLineNo(sCsrNo);
				createApInvIF(event);
				/** ++ approvalRequest, ++ updateCSRSOHDRsts */
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0040Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPaymentVendor(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchInvoiceNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchVendor(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchRefundInvAndDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiInvoiceAuditRefund(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchRefundList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0046Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRailInvoiceInquiryCorrectionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchUsRailInvoiceInquirySecondExcelForm(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiRailInvoiceHold(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeRailInvoiceInquiryCorrection(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multiRailInvoiceConfirmCancel(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0047Event")) {

			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchCSRAPiflist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCsrPreVeiw(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI19)) {
				eventResponse = cancelCSRAPifError(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI20)) {
				eventResponse = cancelCSRApprovalRequest(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0048Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCsrCancel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = cancelCSRAPif(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0960Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchInvoiceListInquiry(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0041Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchInvoicePoolChassisList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = dupChkPoolChassisInvoiceNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				insertInvoicePoolChassis(e);
				eventResponse = searchInvoicePoolChassisList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				updateInvoicePoolChassis(e);
				eventResponse = searchInvoicePoolChassisList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				confirmInsertInvoicePoolChassis(e);
				eventResponse = searchInvoicePoolChassisList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				confirmUpdateInvoicePoolChassis(e);
				eventResponse = searchInvoicePoolChassisList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				confirmInvoicePoolChassis(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				confirmCancelInvoicePoolChassis(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				deleteInvoicePoolChassis(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = getPaymentSPList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = getPoolList(e);
			}
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceInquiryCorrection page<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			begin();
			InvoiceInquiryCorrectionBC command = new InvoiceInquiryCorrectionBCImpl();
			eventResponse = command.deleteInvoice(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceInquiryCorrection page<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;
		try {
			begin();
			InvoiceInquiryCorrectionBC command = new InvoiceInquiryCorrectionBCImpl();
			eventResponse = command.confirmInvoice(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceInquiryCorrection page<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmCancelInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			begin();
			InvoiceInquiryCorrectionBC command = new InvoiceInquiryCorrectionBCImpl();
			eventResponse = command.confirmCancelInvoice(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceInquiryCorrection page<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse saveHold(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			begin();
			InvoiceInquiryCorrectionBC command = new InvoiceInquiryCorrectionBCImpl();
			eventResponse = command.saveHold(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceInquiryCorrection page<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceConfrimAmt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;
		try {
			InvoiceInquiryCorrectionBC command = new InvoiceInquiryCorrectionBCImpl();
			eventResponse = command.searchInvoiceConfrimAmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceInquiryCorrection page<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceInquirySecondExcelForm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;
		try {
			InvoiceInquiryCorrectionBC command = new InvoiceInquiryCorrectionBCImpl();
			eventResponse = command.searchInvoiceInquirySecondExcelForm(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceInquiryCorrection page<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoiceInquiryCorrectionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			InvoiceInquiryCorrectionBC command = new InvoiceInquiryCorrectionBCImpl();
			eventResponse = command.searchInvoiceInquiryCorrectionList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry process of InvoiceAudit page<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse saveInvoiceAudit(Event e) throws EventException {
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		EventResponse eventResponse = new GeneralEventResponse();
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			WorkOrderManagementBC workOrderManagementBC = new WorkOrderManagementBCImpl();
			ArrayList woScgArr = command.searchWoSurcharge(event);
			SurchargeVO[] scgArr = new SurchargeVO[woScgArr.size()];
			if (woScgArr != null) {
				for (int i = 0; i < woScgArr.size(); i++) {
					if (i == 0) {
						scgArr = new SurchargeVO[woScgArr.size()];
					}
					scgArr[i] = (SurchargeVO) woScgArr.get(i);
				}
			}
			event.setSurchargeVOs(scgArr);
			begin();
			List<TrsTrspSvcOrdVO> trspSvcOrdVOs = command.saveInvoiceAudit(event);
			String usrId = event.getSignOnUserAccount().getUsr_id();
			for (TrsTrspSvcOrdVO vo : trspSvcOrdVOs) {
				// S/O
				workOrderManagementBC.modifyWorkOrderExecuteDateByTrs(vo.getTrspSoOfcCtyCd(), vo.getTrspSoSeq(), vo.getTrspWoOfcCtyCd(), vo.getTrspWoSeq(), vo.getEqNo(), vo.getBkgNo(), usrId);
			}
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceAudit page<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse confirmInvoiceAudit(Event e) throws EventException {
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		EventResponse eventResponse = null;
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			ArrayList woScgArr = command.searchWoSurcharge(event);

			SurchargeVO[] scgArr = new SurchargeVO[woScgArr.size()];
			if (woScgArr != null) {
				for (int i = 0; i < woScgArr.size(); i++) {
					if (i == 0)
						scgArr = new SurchargeVO[woScgArr.size()];
					scgArr[i] = (SurchargeVO) woScgArr.get(i);
				}
			}
			event.setSurchargeVOs(scgArr);
			begin();
			eventResponse = command.confirmInvoiceAudit(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			if (de.toString().indexOf("TimedOutException") > -1) {
				eventResponse = confirmInvoiceAuditForNoTranjection(e);
			} else {
				throw new EventException(de.getMessage());
			}
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceAudit page<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse confirmInvoiceAuditForNoTranjection(Event e) throws EventException {
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		EventResponse eventResponse = null;
		InvoiceAuditBC command = new InvoiceAuditBCImpl();
		try {

			begin();
			ArrayList woScgArr = command.searchWoSurcharge(event);
			SurchargeVO[] scgArr = new SurchargeVO[woScgArr.size()];
			if (woScgArr != null) {
				for (int i = 0; i < woScgArr.size(); i++) {
					if (i == 0)
						scgArr = new SurchargeVO[woScgArr.size()];
					scgArr[i] = (SurchargeVO) woScgArr.get(i);
				}
			}
			event.setSurchargeVOs(scgArr);
			commit();
			command.checkConfirmInvoice(event);
			TrsTrspSvcOrdVO[] soArr = event.getTrsTrspSvcOrdVOS();
			begin();
			eventResponse = command.confirmInvoiceAuditForMain(event);
			commit();
			for (int k = 0; soArr != null && k < soArr.length; k++) {
				begin();
				command.confirmInvoiceAuditForSvcOrd(event, k);
				commit();
			}
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();

			// This doesn't use transaction. If there's a problem during confirm process, save as 'INV SAVE' status.
			command.rollbackInvoiceAuditForMain(event);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceAudit page<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse searchInvoiceAuditList(Event e) throws EventException {
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		EventResponse eventResponse = new GeneralEventResponse();
		int i = 1;
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			WorkOrderIssueBC command023 = new WorkOrderIssueBCImpl();
			eventResponse = command.searchInvoiceAuditList(event);
			DBRowSet rs = eventResponse.getRs();
			DBRowSet cloneRs = (DBRowSet) rs.clone();
			if (cloneRs != null) {
				ArrayList scgArr = command023.searchSurchargeList(cloneRs);
				if (scgArr != null) {
					if (scgArr.size() > 0) {
						DBRowSet scgRs = (DBRowSet) scgArr.get(0);
						@SuppressWarnings("unused")
						String[] colValue = null;
						StringBuilder scgXml = new StringBuilder();
						StringBuffer colOrder = new StringBuffer();

						if (scgRs != null) {
							colValue = new String[scgRs.getMetaData().getColumnCount()];
							for (int k = 1; k < scgRs.getMetaData().getColumnCount() + 1; k++) {
								colOrder.append("surcharge_" + scgRs.getMetaData().getColumnName(k).toLowerCase());

								if (k != scgRs.getMetaData().getColumnCount())
									colOrder.append("|");
							}
						}

						scgXml.append("<SHEET>");
						scgXml.append("<DATA COLORDER='").append(colOrder).append("'>");

						for (int k = 0; k < scgArr.size(); k++) {
							scgRs = (DBRowSet) scgArr.get(k);
							while (scgRs != null && scgRs.next()) {
								i = 1;
								scgXml.append("<TR>");
								for (int j = 0; j < scgRs.getMetaData().getColumnCount(); j++) {
									scgXml.append("<TD>").append(JSPUtil.getNull(scgRs.getString(i++))).append("</TD>");
								}
								scgXml.append("</TR>");
							}
						}
						scgXml.append("</DATA></SHEET>");
						eventResponse.setETCData("scgXml", scgXml.toString());
					}
				}
			}
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception f) {
			log.error("err " + f.toString(), f);
			throw new EventException(f.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceAudit page<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse searchInvoiceAuditListByInvoiceNo(Event e) throws EventException {
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		EventResponse eventResponse = new GeneralEventResponse();
		int i = 1;
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			WorkOrderIssueBC command023 = new WorkOrderIssueBCImpl();
			eventResponse = command.searchInvoiceAuditListByInvoiceNo(event);
			DBRowSet rs = eventResponse.getRs();
			DBRowSet cloneRs = (DBRowSet) rs.clone();

			if (cloneRs != null) {
				ArrayList scgArr = command023.searchSurchargeList(cloneRs);
				if (scgArr != null) {
					if (scgArr.size() > 0) {
						DBRowSet scgRs = (DBRowSet) scgArr.get(0);
						@SuppressWarnings("unused")
						String[] colValue = null;
						StringBuilder scgXml = new StringBuilder();
						StringBuffer colOrder = new StringBuffer();

						if (scgRs != null) {
							colValue = new String[scgRs.getMetaData().getColumnCount()];
							for (int k = 1; k < scgRs.getMetaData().getColumnCount() + 1; k++) {
								colOrder.append("surcharge_" + (scgRs.getMetaData().getColumnName(k)).toLowerCase());

								if (k != scgRs.getMetaData().getColumnCount())
									colOrder.append("|");
							}
						}

						scgXml.append("<SHEET>");
						scgXml.append("<DATA COLORDER='").append(colOrder).append("'>");

						for (int k = 0; k < scgArr.size(); k++) {
							scgRs = (DBRowSet) scgArr.get(k);
							while (scgRs != null && scgRs.next()) {
								i = 1;
								scgXml.append("<TR>");
								for (int j = 0; j < scgRs.getMetaData().getColumnCount(); j++) {
									scgXml.append("<TD>").append(JSPUtil.getNull(scgRs.getString(i++))).append("</TD>");
								}
								scgXml.append("</TR>");
							}
						}
						scgXml.append("</DATA></SHEET>");
						eventResponse.setETCData("scgXml", scgXml.toString());
					}
				}
			}

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception f) {
			log.error("err " + f.toString(), f);
			throw new EventException(f.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceAudit page<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDupChkInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.searchDupChkInvoice(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceAudit page<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyEqNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.verifyEqNo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceAudit page<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyInvOfcCdForSPP(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0030Event event = (EsdTrs0030Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			InvoiceInquiryCorrectionBC command = new InvoiceInquiryCorrectionBCImpl();
			eventResponse = command.modifyInvOfcCdForSPP(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceAudit page<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvOfcCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.searchInvOfcCd(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceAudit page<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmOrganization(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.searchMdmOrganization(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceAudit page<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse calculateExchangeRate(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.calculateExchangeRate(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceAudit page<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse rejectInvoice(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			begin();
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.rejectInvoice(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceAudit page<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentSP(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.searchPaymentSP(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of SurchargeInputInquiry page<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException 2014.12.11 Modified by Hyungwook Choi
	 */
	private EventResponse searchSurchargeInputInquiryList(Event e) throws EventException {
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;
		EsdTrs0918Event event = (EsdTrs0918Event) e;

		try {
			SurchargeInputInquiryBC command = new SurchargeInputInquiryBCImpl();
			eventResponse = command.searchSurchargeInputInquiryList(event, event.getSingleVO());
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inserting data to Surcharge Temp Table<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse addTempSurchargeList(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0918Event event = (EsdTrs0918Event) e;
		try {
			SurchargeInputInquiryBC command = new SurchargeInputInquiryBCImpl();
			eventResponse = command.addTempSurchargeList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of SurchargeInputInquiry page<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSurchargeCodeNameList(Event e) throws EventException {
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;
		EsdTrs0918Event event = (EsdTrs0918Event) e;

		try {
			SurchargeInputInquiryBC command = new SurchargeInputInquiryBCImpl();
			eventResponse = command.searchSurchargeCodeNameList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of SurchargeInputInquiry page<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTPBIfFlag(Event e) throws EventException {
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;
		EsdTrs0918Event event = (EsdTrs0918Event) e;

		try {
			SurchargeInputInquiryBC command = new SurchargeInputInquiryBCImpl();
			eventResponse = command.searchTPBIfFlag(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process<br>
	 * Inquiring the list of invoiceaudit<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentVndrList(Event e) throws EventException {

		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			RailInvoiceauditBC command = new RailInvoiceauditBCImpl();
			eventResponse = command.searchPaymentVndrList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inputting data to W/O which doesn't have EQ NO<br>
	 * FILE Importing Sub-METHOD of INVOICE<br>
	 * 
	 * @param TrsTrspSvcOrdVO model, ArrayList emptyWoList
	 * @return TrsTrspSvcOrdVO
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private TrsTrspSvcOrdVO fillEqNo(TrsTrspSvcOrdVO model, ArrayList emptyWoList, ArrayList childVndrList) throws EventException {
		TrsTrspSvcOrdVO svcModel = null;
		String bkgBkgCntr = null;
		InvoiceAuditBCImpl command = new InvoiceAuditBCImpl();
		try {
			for (int i = 0; emptyWoList != null && i < emptyWoList.size(); i++) {
				svcModel = (TrsTrspSvcOrdVO) emptyWoList.get(i);

				if (svcModel != null && model.getTrspWoOfcCtyCd().equals(svcModel.getTrspWoOfcCtyCd()) && model.getTrspWoSeq().equals(svcModel.getTrspWoSeq())) {
					/** When it's CY/Door O/D, check whether there's a corresponding container with BKG_CNTR **/
					if (svcModel.getTrspSoTpCd().equals("Y") && svcModel.getTrspBndCd().equals("O") && svcModel.getTrspCostDtlModCd().equals("DR")) {
						bkgBkgCntr = command.searchInvoiceImportBkgBkgCntr2(svcModel, model);
						if (bkgBkgCntr == null) {
							model.setEdiRcvRsltMsg("BKG CNTR Mismatch");
							model.setDtnUseFlg("0");
						} else {
							model.setTrspSoOfcCtyCd(svcModel.getTrspSoOfcCtyCd());
							model.setTrspSoSeq(svcModel.getTrspSoSeq());
							model.setCntrSubFlg("Y");
							model = fillCommon(model, svcModel, childVndrList);
							model.setCreDt(svcModel.getCreDt());
							/** a column for checking date-duplication **/
							model.setFmNodCd(svcModel.getFmNodCd());
							/** a column for checking date-duplication **/
							emptyWoList.remove(i);
						}
						break;
					} else if (model.getEqTpszCd().equals(svcModel.getEqTpszCd())) {
						model.setTrspSoOfcCtyCd(svcModel.getTrspSoOfcCtyCd());
						model.setTrspSoSeq(svcModel.getTrspSoSeq());
						model.setCreDt(svcModel.getCreDt());
						model.setFmNodCd(svcModel.getFmNodCd());
						model = fillCommon(model, svcModel, childVndrList);
						model.setCreDt(svcModel.getCreDt());
						/** a column for checking date-duplication **/
						model.setFmNodCd(svcModel.getFmNodCd());
						/** a column for checking date-duplication **/
						emptyWoList.remove(i);
						break;
					}
				}
			}
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return model;
	}

	/**
	 * @param childVndrList
	 * @param srcVndrSeq
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	private boolean isVndrSeq(ArrayList childVndrList, String srcVndrSeq) {
		boolean returnFlag = false;
		String rsVndrSeq = null;
		for (int i = 0; childVndrList != null && i < childVndrList.size(); i++) {
			rsVndrSeq = (String) childVndrList.get(i);
			if (rsVndrSeq != null && rsVndrSeq.equals(srcVndrSeq)) {
				returnFlag = true;
				break;
			}
		}
		return returnFlag;
	}

	/**
	 * FILE Importing Sub-METHOD of INVOICE<br>
	 * 
	 * @param TrsTrspSvcOrdVO model, DBRowSet rsValue
	 * @return TrsTrspSvcOrdVO
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private TrsTrspSvcOrdVO fillCommon(TrsTrspSvcOrdVO model, TrsTrspSvcOrdVO svcModel, ArrayList childVndrList) throws EventException {
		try {
			if (svcModel != null) {
				if (svcModel.getCreOfcCd().equals("") || !svcModel.getCreOfcCd().equals(model.getCreOfcCd())) {
					model.setEdiRcvRsltMsg("Unauthorized office");
					model.setDtnUseFlg("0");
				} else if (!isVndrSeq(childVndrList, svcModel.getVndrSeq())) {
					model.setEdiRcvRsltMsg("W/O S/P Mismatch");
					model.setDtnUseFlg("0");
				} else if (!svcModel.getTrspSoStsCd().equals("I")) {
					model.setEdiRcvRsltMsg("W/O Status [" + svcModel.getTrspSoStsCd() + "]");
					model.setDtnUseFlg("0");
				} else if (!svcModel.getInvNo().equals("")) {
					model.setEdiRcvRsltMsg("Already Invoiced [" + svcModel.getInvNo() + "]");
					model.setDtnUseFlg("0");
				} else if (!model.getInvBzcAmt().equals("")) {
					if (validateNumberFormat(model.getInvBzcAmt(), svcModel.getInvBzcAmt())) {
						BigDecimal modelInvBzcAmt = new BigDecimal(model.getInvBzcAmt());
						BigDecimal rsInvBzcAmt = new BigDecimal(svcModel.getInvBzcAmt());
						if (modelInvBzcAmt.compareTo(rsInvBzcAmt) != 0) {
							model.setEdiRcvRsltMsg("Amount Diff " + "(" + modelInvBzcAmt.subtract(rsInvBzcAmt).toString() + ")");
							model.setDtnUseFlg("1");
						}
					} else {
						BigDecimal modelInvBzcAmt = new BigDecimal("0");
						BigDecimal rsInvBzcAmt = new BigDecimal(svcModel.getInvBzcAmt());
						if (modelInvBzcAmt.compareTo(rsInvBzcAmt) != 0) {
							model.setEdiRcvRsltMsg("Amount Diff " + "(-" + modelInvBzcAmt.subtract(rsInvBzcAmt).toString() + ")");
							model.setDtnUseFlg("1");
						}
					}
				}
			}
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return model;
	}

	/**
	 * Validating number format.
	 * 
	 * @param model
	 * @param svcModel
	 * @return
	 */
	private boolean validateNumberFormat(String str1, String str2) {
		boolean returnFlag = true;
		try {
			new BigDecimal(str1);
			new BigDecimal(str2);
		} catch (NumberFormatException nfe) {
			log.error("err " + nfe.toString(), nfe);
			returnFlag = false;
		}
		return returnFlag;
	}

	/**
	 * Validating number format.
	 * 
	 * @param model
	 * @param svcModel
	 * @return
	 */
	private boolean validateNumberFormat2(String str1) {
		boolean returnFlag = true;
		try {
			Integer.parseInt(str1);
		} catch (NumberFormatException nfe) {
			log.error("err " + nfe.toString(), nfe);
			returnFlag = false;
		}
		return returnFlag;
	}

	/**
	 * FILE Importing Sub-METHOD of INVOICE<br>
	 * 
	 * @param TrsTrspSvcOrdVO model, DBRowSet rsValue
	 * @return TrsTrspSvcOrdVO
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private TrsTrspSvcOrdVO fillCommon(TrsTrspSvcOrdVO model, DBRowSet rsValue, ArrayList childVndrList) throws EventException {
		DBRowSet rs = null;
		try {
			rs = rsValue;
			if (rs != null) {
				if (rs.getString("INV_OFC_CD") == null || !rs.getString("INV_OFC_CD").equals(model.getCreOfcCd())) {
					model.setEdiRcvRsltMsg("Unauthorized office");
					model.setDtnUseFlg("0");
				} else if (rs.getString("VNDR_SEQ") == null || !isVndrSeq(childVndrList, rs.getString("VNDR_SEQ"))) {
					model.setEdiRcvRsltMsg("W/O S/P Mismatch");
					model.setDtnUseFlg("0");
				} else if (!rs.getString("TRSP_SO_STS_CD").equals("I")) {
					model.setEdiRcvRsltMsg("W/O Status [" + rs.getString("TRSP_SO_STS_CD") + "]");
					model.setDtnUseFlg("0");
				} else if (!rs.getString("INV_NO").equals("")) {
					model.setEdiRcvRsltMsg("Already Invoiced [" + rs.getString("INV_NO") + "]");
					model.setDtnUseFlg("0");
				} else if (!model.getInvBzcAmt().equals("")) {
					if (validateNumberFormat(model.getInvBzcAmt(), rs.getString("WO_TOT_AMT"))) {
						BigDecimal modelInvBzcAmt = new BigDecimal(model.getInvBzcAmt());
						BigDecimal rsInvBzcAmt = new BigDecimal(rs.getString("WO_TOT_AMT"));
						if (modelInvBzcAmt.compareTo(rsInvBzcAmt) != 0) {
							model.setEdiRcvRsltMsg("Amount Diff " + "(" + modelInvBzcAmt.subtract(rsInvBzcAmt).toString() + ")");
							model.setDtnUseFlg("1");
						}
					} else {
						BigDecimal modelInvBzcAmt = new BigDecimal("0");
						BigDecimal rsInvBzcAmt = new BigDecimal(rs.getString("WO_TOT_AMT"));
						if (modelInvBzcAmt.compareTo(rsInvBzcAmt) != 0) {
							model.setEdiRcvRsltMsg("Amount Diff " + "(-" + modelInvBzcAmt.subtract(rsInvBzcAmt).toString() + ")");
							model.setDtnUseFlg("1");
						}
					}
				}

				if (model.getDtnUseFlg().equals("1")) {
					model.setCreDt(rs.getString("CRE_DT"));
					/** a column for checking date-duplication **/
					model.setFmNodCd(rs.getString("FM_NOD_CD"));
					/** a column for checking date-duplication **/
				}
			}
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return model;
	}

	/**
	 * SO, WO,EQNO Duplication verify<br>
	 * INVOICE FILE IMPORT SUB METHOD<br>
	 * 
	 * @param ArrayList srcList
	 * @return ArrayList tgtList
	 * @exception EventException
	 */
	// NOT USED PRIVATE METHOD
	// @SuppressWarnings({ "unchecked", "rawtypes" })
	// private ArrayList checkDupSoWoEqNo(ArrayList srcList) {
	// ArrayList tgtList = (ArrayList) srcList.clone();
	// String src_trsp_so_seq = null;
	// String src_trsp_wo_seq = null;
	// String src_eq_no = null;
	// String tgt_trsp_so_seq = null;
	// String tgt_trsp_wo_seq = null;
	// String tgt_eq_no = null;
	//
	// for (int i = 0; srcList != null && i < srcList.size(); i++) {
	// TrsTrspSvcOrdVO srcModel = (TrsTrspSvcOrdVO) srcList.get(i);
	// src_trsp_so_seq = srcModel.getTrspSoOfcCtyCd() + srcModel.getTrspSoSeq();
	// if (!src_trsp_so_seq.equals("") && srcModel.getDtnUseFlg().equals("1")) {
	// for (int k = i + 1; tgtList != null && k < tgtList.size(); k++) {
	// TrsTrspSvcOrdVO tgtModel = (TrsTrspSvcOrdVO) tgtList.get(k);
	// if (tgtModel != null) {
	// tgt_trsp_so_seq = tgtModel.getTrspSoOfcCtyCd() + tgtModel.getTrspSoSeq();
	// if (tgtModel.getDtnUseFlg().equals("1") && !tgt_trsp_so_seq.equals("") && tgt_trsp_so_seq.equals(src_trsp_so_seq)) {
	// tgtModel.setEdiRcvRsltMsg("Duplicated S/O No");
	// tgtModel.setDtnUseFlg("0");
	// srcList.set(k, tgtModel);
	// tgtList.set(k, null);
	// }
	// }
	// }
	// }
	// }
	//
	// for (int i = 0; srcList != null && i < srcList.size(); i++) {
	// TrsTrspSvcOrdVO srcModel = (TrsTrspSvcOrdVO) srcList.get(i);
	// src_trsp_wo_seq = srcModel.getTrspWoOfcCtyCd() + srcModel.getTrspWoSeq();
	// src_eq_no = srcModel.getEqNo();
	// if (!src_trsp_wo_seq.equals("") && !src_eq_no.equals("") && srcModel.getDtnUseFlg().equals("1")) {
	// for (int k = i + 1; tgtList != null && k < tgtList.size(); k++) {
	// TrsTrspSvcOrdVO tgtModel = (TrsTrspSvcOrdVO) tgtList.get(k);
	// if (tgtModel != null) {
	// tgt_trsp_wo_seq = tgtModel.getTrspWoOfcCtyCd() + tgtModel.getTrspWoSeq();
	// tgt_eq_no = tgtModel.getEqNo();
	// if (tgtModel.getDtnUseFlg().equals("1") && !tgt_trsp_wo_seq.equals("") && !tgt_eq_no.equals("") && tgt_trsp_wo_seq.equals(src_trsp_wo_seq) && tgt_eq_no.equals(src_eq_no)) {
	// tgtModel.setEdiRcvRsltMsg("Duplicated W/O No, CNTR No");
	// tgtModel.setDtnUseFlg("0");
	// srcList.set(k, tgtModel);
	// tgtList.set(k, null);
	// }
	// }
	// }
	// }
	// }
	//
	// return srcList;
	// }

	/**
	 * SO, WO,EQNO Duplication verify<br>
	 * INVOICE FILE IMPORT SUB METHOD<br>
	 * 
	 * @param ArrayList srcList
	 * @return ArrayList
	 * @exception EventException
	 */
	// NOT USED PRIVATE METHOD
	// @SuppressWarnings({ "unchecked", "rawtypes" })
	// private ArrayList checkDupOpenerSoWoEqNo(ArrayList srcList, ArrayList tgtList) {
	// String src_trsp_so_seq = null;
	// String src_trsp_wo_seq = null;
	// String src_eq_no = null;
	// String tgt_trsp_so_seq = null;
	// String tgt_trsp_wo_seq = null;
	// String tgt_eq_no = null;
	// /* srcList - popup List, tgtList - main window List */
	// for (int i = 0; srcList != null && i < srcList.size(); i++) {
	// TrsTrspSvcOrdVO srcModel = (TrsTrspSvcOrdVO) srcList.get(i);
	// src_trsp_so_seq = srcModel.getTrspSoOfcCtyCd() + srcModel.getTrspSoSeq();
	// if (!src_trsp_so_seq.equals("") && srcModel.getDtnUseFlg().equals("1")) {
	// for (int k = 0; tgtList != null && k < tgtList.size(); k++) {
	// TrsTrspSvcOrdVO tgtModel = (TrsTrspSvcOrdVO) tgtList.get(k);
	// if (tgtModel != null) {
	// tgt_trsp_so_seq = tgtModel.getTrspSoOfcCtyCd() + tgtModel.getTrspSoSeq();
	// if (!tgt_trsp_so_seq.equals("") && tgt_trsp_so_seq.equals(src_trsp_so_seq)) {
	// srcModel.setEdiRcvRsltMsg("Duplicated S/O No \\w Main Window");
	// srcModel.setDtnUseFlg("0");
	// srcList.set(i, srcModel);
	// tgtList.set(k, null);
	// }
	// }
	// }
	// }
	// }
	//
	// for (int i = 0; srcList != null && i < srcList.size(); i++) {
	// TrsTrspSvcOrdVO srcModel = (TrsTrspSvcOrdVO) srcList.get(i);
	// src_trsp_wo_seq = srcModel.getTrspWoOfcCtyCd() + srcModel.getTrspWoSeq();
	// src_eq_no = srcModel.getEqNo();
	// if (!src_trsp_wo_seq.equals("") && !src_eq_no.equals("") && srcModel.getDtnUseFlg().equals("1")) {
	// for (int k = 0; tgtList != null && k < tgtList.size(); k++) {
	// TrsTrspSvcOrdVO tgtModel = (TrsTrspSvcOrdVO) tgtList.get(k);
	// if (tgtModel != null) {
	// tgt_trsp_wo_seq = tgtModel.getTrspWoOfcCtyCd() + tgtModel.getTrspWoSeq();
	// tgt_eq_no = tgtModel.getEqNo();
	// if (!tgt_trsp_wo_seq.equals("") && !tgt_eq_no.equals("") && tgt_trsp_wo_seq.equals(src_trsp_wo_seq) && tgt_eq_no.equals(src_eq_no)) {
	// srcModel.setEdiRcvRsltMsg("Duplicated W/O No, CNTR No w/ Main Window");
	// srcModel.setDtnUseFlg("0");
	// srcList.set(i, srcModel);
	// tgtList.set(k, null);
	// }
	// }
	// }
	// }
	// }
	//
	// return srcList;
	// }

	/**
	 * Invoice file import verify<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse verifyTruckInvoiceFileImport(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0033Event event = (EsdTrs0033Event) e;

		String invCurrCd = event.getApply_currency();
		String creOfcCd = event.getFORM_USR_OFC_CD();
		String vndrSeq = event.getWo_vndr_cd();
		String paymentVndrSeq = event.getPayment_vndr_cd();

		/*
		 * EDI_RCV_RSLT_MSG : verify_result DTN_USE_FLG : ibcheck EDI_RCV_RSLT_CD : NIS
		 */
		try {
			TrsTrspSvcOrdVO[] soArr = event.getTrsTrspSvcOrdVOS();
			TrsTrspSvcOrdVO[] opSoArr = event.getOPENER_TrsTrspSvcOrdVOS();
			InvoiceAuditBCImpl command = new InvoiceAuditBCImpl();
			ArrayList<TrsTrspSvcOrdVO> srcList = new ArrayList<TrsTrspSvcOrdVO>();
			ArrayList<TrsTrspSvcOrdVO> openerList = new ArrayList<TrsTrspSvcOrdVO>();
			if (soArr != null) {
				for (int i = 0; i < soArr.length; i++) {
					srcList.add(soArr[i]);
				}
			}
			if (opSoArr != null) {
				for (int i = 0; i < opSoArr.length; i++) {
					openerList.add(opSoArr[i]);
				}
			}
			ArrayList soList = null;
			ArrayList woList = null;
			ArrayList emptyWoList = null;
			ArrayList childVndrList = null;
			DBRowSet rs = null;
			DBRowSet rsEqVerify = null;
			String eqNo = null;
			String eqTpSzCd = null;
			String eqTpSzCdInput = null;
			String bkgBkgCntr = null;
			String currCd = null;

			for (int i = 0; srcList != null && i < srcList.size(); i++) {
				TrsTrspSvcOrdVO model = (TrsTrspSvcOrdVO) srcList.get(i);
				model.setDtnUseFlg("1");
				model.setInvCurrCd(invCurrCd);
				model.setCreOfcCd(creOfcCd);
				model.setVndrSeq(vndrSeq);

				/** separating S/O sequence **/
				if (!"".equals(model.getPrntTrspSoOfcCtyCd())) {
					if (validateNumberFormat2(model.getPrntTrspSoOfcCtyCd().substring(3))) {
						model.setTrspSoOfcCtyCd(model.getPrntTrspSoOfcCtyCd().substring(0, 3).toUpperCase());
						model.setTrspSoSeq(model.getPrntTrspSoOfcCtyCd().substring(3));
					} else {
						model.setEdiRcvRsltMsg("Invalid S/O No");
						model.setDtnUseFlg("0");
					}
				}

				/** separating W/O sequence **/
				if (!"".equals(model.getPrntTrspSoSeq())) {
					if (validateNumberFormat2(model.getPrntTrspSoSeq().substring(3))) {
						model.setTrspWoOfcCtyCd(model.getPrntTrspSoSeq().substring(0, 3).toUpperCase());
						model.setTrspWoSeq(model.getPrntTrspSoSeq().substring(3));
					} else {
						model.setEdiRcvRsltMsg("Invalid W/O No");
						model.setDtnUseFlg("0");
					}
				}

				if (!"".equals(model.getEqNo())) {
					model.setEqNo(model.getEqNo().toUpperCase());
				}

				srcList.set(i, model);
				event.setTrsTrspSvcOrdVoList(srcList);
			}

			woList = command.searchInvoiceImportWO(event);
			emptyWoList = command.searchInvoiceImportEmptyWO(event);
			soList = command.searchInvoiceImportSO(event);
			childVndrList = command.searchPaymentChildVendor(paymentVndrSeq);
			/** W/O LIST Process **/
			for (int i = 0; srcList != null && i < srcList.size(); i++) {
				TrsTrspSvcOrdVO model = (TrsTrspSvcOrdVO) srcList.get(i);
				if ("".equals(model.getTrspSoSeq()) && !"".equals(model.getTrspWoSeq()) && "1".equals(model.getDtnUseFlg())) {
					if (woList.get(i) != null) {
						rs = (DBRowSet) ((DBRowSet) woList.get(i)).clone();
					} else {
						rs = null;
					}

					boolean isexists = false;
					if (!CheckUtilities.isInBlank(model.getRefInvNo())) {
						DBRowSet dbRowSet = command.verifyRefInvNo(model.getVndrSeq(), model.getRefInvNo());
						while (dbRowSet.next()) {
							model.setEdiRcvRsltMsg("The Reference No [" + dbRowSet.getString("ref_inv_no") + "] was used at Invoice No [" + dbRowSet.getString("inv_no") + "], S/P [" + dbRowSet.getString("inv_vndr_seq") + "]");
							model.setEdiRcvRsltCd("1");
							model.setDtnUseFlg("0");
							isexists = true;
							break;
						}
					}
					if (!isexists) {
						if (rs == null || !rs.next()) {
							/** Fill empty equip no. **/
							if ("1".equals(model.getDtnUseFlg())) {
								if (!"".equals(model.getEqNo())) {
									rsEqVerify = command.verifyEqNo(model.getEqNo());
									if (rsEqVerify == null || rsEqVerify.getRowCount() == 0) {
										model.setEdiRcvRsltMsg("EQ No Not Exist");
										model.setDtnUseFlg("0");
									} else {
										rsEqVerify.next();
										model.setEqTpszCd(rsEqVerify.getString("tp_cd"));
										model.setEqNo(rsEqVerify.getString("eq_no"));
										model = fillEqNo(model, emptyWoList, childVndrList);
										if ("".equals(model.getEqNo()) || "".equals(model.getTrspSoSeq())) {
											model.setEdiRcvRsltMsg("No corresponding EQ No - W/O No");
											model.setDtnUseFlg("0");
										} else {
											ArrayList dupList = command.searchInvoiceImportDuplicateCheckByDate(model);
											String dupStr = getDuplicateCheckByDateString(dupList);
											if (dupStr.length() > 0) {
												if (model.getEdiRcvRsltMsg().length() > 0) {
													dupStr = model.getEdiRcvRsltMsg() + " / " + dupStr;
												}
												model.setEdiRcvRsltMsg(dupStr);
											}
										}
									}
								} else {
									model.setEdiRcvRsltMsg("No corresponding EQ No - W/O No");
									model.setDtnUseFlg("0");
								}
							}
						} else {
							model.setDtnUseFlg("1");
							model.setTrspSoOfcCtyCd(rs.getString("trsp_so_ofc_cty_cd"));
							model.setTrspSoSeq(rs.getString("trsp_so_seq"));
							model.setEqTpszCd(rs.getString("eq_tpsz_cd"));
							model.setEqNo(rs.getString("eq_no"));
							model = fillCommon(model, rs, childVndrList);
							if (currCd == null || "".equals(currCd.trim())) {
								currCd = rs.getString("curr_cd");
							} else if (!currCd.equals(rs.getString("curr_cd")) && model.getDtnUseFlg().equals("1")) {
								model.setEdiRcvRsltMsg("Currency Mismatch [" + rs.getString("CURR_CD") + "]");
								model.setDtnUseFlg("0");
							}
						}
					}
					srcList.set(i, model);
				} else if (!"".equals(model.getTrspSoSeq()) && "1".equals(model.getDtnUseFlg())) {
					/** S/O LIST Process **/
					if (soList.get(i) != null) {
						rs = (DBRowSet) ((DBRowSet) soList.get(i)).clone();
					} else {
						rs = null;
					}

					boolean isexists = false;
					if (!CheckUtilities.isInBlank(model.getRefInvNo())) {
						DBRowSet dbRowSet = command.verifyRefInvNo(model.getVndrSeq(), model.getRefInvNo());
						while (dbRowSet.next()) {
							model.setEdiRcvRsltMsg("The Reference No [" + dbRowSet.getString("ref_inv_no") + "] was used at Invoice No [" + dbRowSet.getString("inv_no") + "], S/P [" + dbRowSet.getString("inv_vndr_seq") + "]");
							model.setEdiRcvRsltCd("1");
							model.setDtnUseFlg("0");
							isexists = true;
							break;
						}
					}
					if (!isexists) {
						if (rs == null || !rs.next()) {
							model.setEdiRcvRsltMsg("S/O No Not Exist");
							model.setDtnUseFlg("0");
							model.setEdiRcvRsltCd("1");
						} else {
							eqNo = rs.getString("eq_no");
							eqTpSzCd = rs.getString("eq_tpsz_cd");
							if (CheckUtilities.isInBlank(eqNo)) {
								if (!model.getEqNo().equals("")) {
									/** EQ NO Check **/
									rsEqVerify = command.verifyEqNo(model.getEqNo());
									if (rsEqVerify == null || rsEqVerify.getRowCount() == 0) {
										model.setEdiRcvRsltMsg("EQ No Not Exist");
										model.setEdiRcvRsltCd("1");
										model.setDtnUseFlg("0");
									} else {
										rsEqVerify.next();
										eqTpSzCdInput = rsEqVerify.getString("tp_cd");
										model.setEqNo(rsEqVerify.getString("eq_no"));
										if (!eqTpSzCdInput.equals(eqTpSzCd) && !("Y".equals(rs.getString("trsp_so_tp_cd")) && "O".equals(rs.getString("trsp_bnd_cd")) && "DR".equals(rs.getString("trsp_cost_dtl_mod_cd")))) {
											model.setEdiRcvRsltMsg("EQ TP/SZ Mismatch");
											model.setDtnUseFlg("0");
										} else if (eqTpSzCdInput.equals(eqTpSzCd) && !("Y".equals(rs.getString("trsp_so_tp_cd")) && "O".equals(rs.getString("trsp_bnd_cd")) && "DR".equals(rs.getString("trsp_cost_dtl_mod_cd")))) {
											model.setEqTpszCd(eqTpSzCd);
											model = fillCommon(model, rs, childVndrList);
											if (!model.getEqNo().equals("")) {
												ArrayList dupList = command.searchInvoiceImportDuplicateCheckByDate(model);
												String dupStr = getDuplicateCheckByDateString(dupList);
												if (dupStr.length() > 0) {
													if (model.getEdiRcvRsltMsg().length() > 0) {
														dupStr = model.getEdiRcvRsltMsg() + " / " + dupStr;
													}
													model.setEdiRcvRsltMsg(dupStr);
												}
											}
										} else if ("Y".equals(rs.getString("trsp_so_tp_cd")) && "O".equals(rs.getString("trsp_bnd_cd")) && "DR".equals(rs.getString("trsp_cost_dtl_mod_cd"))) {
											model.setEqTpszCd(eqTpSzCdInput);
											/** Bkg CNTR Check **/
											bkgBkgCntr = command.searchInvoiceImportBkgBkgCntr(rs, model);
											if (bkgBkgCntr == null) {
												model.setEdiRcvRsltMsg("BKG CNTR Mismatch");
												model.setDtnUseFlg("0");
											} else {
												model = fillCommon(model, rs, childVndrList);
											}

										}
									}
								}
							} else {
								model.setEqNo(eqNo);
								model.setEqTpszCd(eqTpSzCd);
								model = fillCommon(model, rs, childVndrList);
							}
							model.setTrspWoOfcCtyCd(rs.getString("trsp_wo_ofc_cty_cd"));
							model.setTrspWoSeq(rs.getString("trsp_wo_seq"));
							if (currCd == null || currCd.trim().equals("")) {
								currCd = rs.getString("curr_cd");
							} else if (!currCd.equals(rs.getString("curr_cd")) && model.getDtnUseFlg().equals("1")) {
								model.setEdiRcvRsltMsg("Currency Mismatch [" + rs.getString("curr_cd") + "]");
								model.setDtnUseFlg("0");
							}
						}
					}
					srcList.set(i, model);
				}
			}
			
			if(srcList!= null) {
				// Invoice File Import S/O Dup Check
				ArrayList<TrsTrspSvcOrdVO> srcListTmp = (ArrayList<TrsTrspSvcOrdVO>)srcList.clone();
				String listSoNo = null;
				String listTmpSoNo = null;
				for (int i = 0; i < srcList.size(); i++) {
					TrsTrspSvcOrdVO srcModel = (TrsTrspSvcOrdVO)srcList.get(i);
					listSoNo = srcModel.getTrspSoOfcCtyCd() + srcModel.getTrspSoSeq();
					if (!listSoNo.equals("") && srcModel.getDtnUseFlg().equals("1")) {
						for (int j = i + 1; j < srcListTmp.size(); j++) {
							TrsTrspSvcOrdVO tmpModel = (TrsTrspSvcOrdVO)srcListTmp.get(j);
							listTmpSoNo = tmpModel.getTrspSoOfcCtyCd() + tmpModel.getTrspSoSeq();
							if (tmpModel.getDtnUseFlg().equals("1") && !listTmpSoNo.equals("") && listTmpSoNo.equals(listSoNo)) {
								tmpModel.setEdiRcvRsltMsg("Duplicated S/O No");
								tmpModel.setDtnUseFlg("0");
								srcList.set(j, tmpModel);
								srcListTmp.set(j, null);
							}
						}
					}
				}
			}
			
			/** Checking duplication of S/O, W/O and EQ NO. **/
			// srcList = checkDupSoWoEqNo(srcList);
			/** Checking duplication(S/O, W/O and EQ NO) of the OPENER SHEET **/
			// srcList = checkDupOpenerSoWoEqNo(srcList, openerList);
			// resultHashMap.put("resultList", srcList);
			// eventResponse = new GeneralEventResponse(resultHashMap,"SUCCESS");
			eventResponse = new GeneralEventResponse();
			eventResponse.setRsVo(srcList);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Transforming the Duplicate list to String.<br>
	 * 
	 * @param ArrayList rsList
	 * @return String
	 * @exception
	 */
	@SuppressWarnings("rawtypes")
	private String getDuplicateCheckByDateString(ArrayList rsList) {

		StringBuffer returnStr = new StringBuffer();
		if (rsList != null && rsList.size() > 0) {
			for (int i = 0; i < rsList.size(); i++) {
				TrsTrspSvcOrdVO model = (TrsTrspSvcOrdVO) rsList.get(i);

				if (i > 0)
					returnStr.append(" / ");
				returnStr.append(model.getTrspSoOfcCtyCd());
				returnStr.append(model.getTrspSoSeq());
				returnStr.append(" , ");
				returnStr.append(model.getCreDt());
				returnStr.append(" , ");
				returnStr.append(model.getFmNodCd());
				returnStr.append("-");
				returnStr.append(model.getToNodCd());
				returnStr.append(" , ");
				returnStr.append(model.getTrspCostDtlModCd());
				returnStr.append(" , ");
				returnStr.append(model.getTrspCrrModCd());
			}
		}
		return returnStr.toString();
	}

	/**
	 * Inquiry event process of SurchargeInputInquiry page<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTruckInvoiceFileImport(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		try {
			InvoiceAuditBCImpl command = new InvoiceAuditBCImpl();
			eventResponse = command.searchTruckInvoiceFileImport(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of SurchargeInputInquiry page<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "rawtypes" })
	private EventResponse searchInvoiceImportDuplicateCheckByDate2(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		try {
			InvoiceAuditBCImpl command = new InvoiceAuditBCImpl();
			eventResponse = command.searchInvoiceImportDuplicateCheckByDate2(event);
			List rsVoLists = eventResponse.getRsVoList();
			if (rsVoLists != null && rsVoLists.size() > 0) {
				for (int k = 0; k < rsVoLists.size(); k++) {
					ArrayList arr = (ArrayList) rsVoLists.get(k);
					for (int i = 0; arr != null && i < arr.size(); i++) {
						TrsTrspSvcOrdVO model = (TrsTrspSvcOrdVO) arr.get(i);
						model.setRefSeq(event.getRef_seq());
					}
				}
			} else {
				eventResponse = new GeneralEventResponse();
				List<Object> rs = new ArrayList<Object>();
				List<TrsTrspSvcOrdVO> trspSvcOrdVOs = new ArrayList<TrsTrspSvcOrdVO>();
				TrsTrspSvcOrdVO trspSvcOrdVO = new TrsTrspSvcOrdVO();
				trspSvcOrdVO.setRefSeq(event.getRef_seq());
				trspSvcOrdVOs.add(trspSvcOrdVO);
				rs.add(trspSvcOrdVOs);
				eventResponse.setRsVoList(rs);
			}
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceAudit page<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchN3ptyCurrCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0033Event event = (EsdTrs0033Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.searchN3ptyCurrCd(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Load the size of result set <br>
	 * Inquiring the list of invoiceaudit event<br>
	 * 
	 * @param src DBRowSet
	 * @return int result set size
	 * @exception Exception
	 */
//	@SuppressWarnings({ "unchecked", "rawtypes" })
	// private ArrayList getDupEqNoList(ArrayList eqNoList, ArrayList resultList) throws Exception {
	// String curEqNo = null;
	// int findIdx = -1;
	// for (int i = 0; i < eqNoList.size(); i++) {
	// curEqNo = (String) eqNoList.get(i);
	// if (curEqNo != null) {
	// eqNoList.set(i, null);
	// while ((findIdx = eqNoList.indexOf(curEqNo)) != -1) {
	// eqNoList.set(findIdx, null);
	// resultList.set(findIdx, "Duplicated  CNTR");
	// }
	// }
	// }
	// return resultList;
	// }
	/**
	 * Load the size of result set <br>
	 * Inquiring the list of invoiceaudit event<br>
	 * 
	 * @param src DBRowSet
	 * @return int result set size
	 * @exception Exception
	 */
	private int getRsltSize(DBRowSet src) throws Exception {
		int size = 0;
		if (src == null)
			return 0;
		DBRowSet tgt = (DBRowSet) src.clone();
		while (tgt.next()) {
			size++;
		}
		return size;
	}

	/**
	 * Load the size of result set <br>
	 * Inquiring the list of invoiceaudit event<br>
	 * 
	 * @param src DBRowSet
	 * @return int result set size
	 * @exception Exception
	 */
	private String getString(DBRowSet src, String colName) throws Exception {
		if (src == null)
			return null;
		DBRowSet tgt = (DBRowSet) src.clone();
		String tabCd = null;
		if (tgt.next()) {
			tabCd = tgt.getString(colName);
		}
		return tabCd;
	}

	/**
	 * Load the size of result set <br>
	 * Inquiring the list of invoiceaudit event<br>
	 * 
	 * @param src DBRowSet
	 * @return int result set size
	 * @exception Exception
	 */
	private boolean checkCurrency(DBRowSet src, String cur) throws Exception {
		boolean equalsCur = false;
		if (src == null)
			return false;
		DBRowSet tgt = (DBRowSet) src.clone();
		String invCur = null;
		if (tgt.next()) {
			invCur = tgt.getString("CURR_CD");
			if ((invCur != null && invCur.equals(cur)) || CheckUtilities.isInBlank(invCur)) {
				equalsCur = true;
			}
		}
		return equalsCur;
	}

	/**
	 * Inquiry event process of Railinvoiceaudit page<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRailinvoiceauditList(Event e) throws EventException {
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			RailInvoiceauditBC command = new RailInvoiceauditBCImpl();
			eventResponse = command.searchRailinvoiceauditList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of Container History page<br>
	 * 
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPaymentHistoryList(Event e) throws EventException {
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			RailInvoiceauditBC command = new RailInvoiceauditBCImpl();
			eventResponse = command.searchPaymentHistoryList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Multi-event process of Railinvoiceaudit event<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public EventResponse modifyRailinvoiceaudit(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0038Event event = (EsdTrs0038Event) e;
		TrsTrspRailInvDtlVO[] model = event.getTrsTrspRailInvDtlVos();
		List ibflagArr = new ArrayList();
		for (int i = 0; i < model.length; i++) {
			ibflagArr.add(model[i].getIbflag());
		}
		String[] ibflag = (String[]) ibflagArr.toArray(new String[ibflagArr.size()]);
		try {
			RailInvoiceauditBC command = new RailInvoiceauditBCImpl();
			if (ibflag != null) {
				// command.searchReAuditVerify(event);
				begin();
				command.modifyRailinvoiceaudit(e);
				commit();
			}
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of Re-Audit History page<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReAuditInfoList(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			eventResponse = new RailInvoiceauditBCImpl().searchReAuditInfoList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of Re-Audit History page<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchContainerInfo(Event e) throws EventException {
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			RailInvoiceauditBC command = new RailInvoiceauditBCImpl();
			eventResponse = command.searchContainerInfo(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchCSRSummary<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCSRSummary(Event e) throws EventException {

		EsdTrs0031Event event = (EsdTrs0031Event) e;

		EventResponse eventResponse = null;

		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();

			eventResponse = command.searchCSRSummary(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * checkASANO<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse checkASANO(Event e) throws EventException {
		EsdTrs0031Event event = (EsdTrs0031Event) e;
		EventResponse eventResponse = null;
		try {
			eventResponse = new CSRIssueTransferSlipManageBCImpl().checkASANO(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchCSRSummaryDetail<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCSRSummaryDetail(Event e) throws EventException {
		EsdTrs0032Event event = (EsdTrs0032Event) e;
		EventResponse eventResponse = null;
		try {
			eventResponse = new CSRIssueTransferSlipManageBCImpl().searchCSRSummaryDetail(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * correctCsrAmt<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse correctCsrAmt(Event e) throws EventException {

		EsdTrs0032Event event = (EsdTrs0032Event) e;

		EventResponse eventResponse = null;

		try {
			begin();
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.correctCsrAmt(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err [correctCsrAmt] " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * generateNewCsrNo<BR>
	 * 
	 * @param e ESD_TRS_032Event
	 * @param sCsrType String
	 * @param sPreviewIndicator String
	 * @return sCsrNo String
	 * @throws EventException
	 */
	private String generateNewCsrNo(EsdTrs0032Event e) throws EventException {

		EsdTrs0032Event event = (EsdTrs0032Event) e;
		String sCsrNo = null;

		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			sCsrNo = command.generateNewCsrNo(event);
		} catch (EventException de) {
			log.error("err [generateNewCsrNo] " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return sCsrNo;
	}

	/**
	 * createApInvHdrDtrb<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse createApInvHdrDtrb(Event e) throws EventException {

		EsdTrs0032Event event = (EsdTrs0032Event) e;
		EventResponse eventResponse = null;

		try {
			begin();
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.createApInvHdrDtrb(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err [createApInvHdrDtrb] " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * createApInvIF<BR>
	 * 
	 * @param e Event
	 * @throws EventException
	 */
	private void createApInvIF(Event e) throws EventException {

		CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();

		EsdTrs0032Event event = (EsdTrs0032Event) e;

		try {
			begin();
			command.createApInvIF(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err [createApInvIF] " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * checkApInvDtrbValidation<BR>
	 * 
	 * @param sCsrNo String
	 * @throws EventException
	 */
	private void checkApInvDtrbValidation(String sCsrNo) throws EventException {

		try {
			begin();
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			command.checkApInvDtrbValidation(sCsrNo);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err [checkApInvDtrbValidation] " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * updateApInvDtrbLineNo<BR>
	 * 
	 * @param sCsrNo String
	 * @throws EventException
	 */
	private void updateApInvDtrbLineNo(String sCsrNo) throws EventException {

		CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();

		try {
			begin();
			command.updateApInvDtrbLineNo(sCsrNo);
			commit();
		} catch (EventException de) {
			rollback();

			try {
				begin();
				command.deleteInvHdrDtrbList(sCsrNo);
				commit();
			} catch (EventException de2) {
				rollback();
				log.error("err [inner deleteInvHdrDtrbList] " + de.toString(), de2);
				throw new EventException(de2.getMessage());
			}

			log.error("err [updatePreviewInvDtrbLineNo] " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * selectApInvHdrDtrbList<BR>
	 * 
	 * @param sCsrNo String
	 * @param sPreviewIndicator String
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse selectApInvHdrDtrbList(String sCsrNo, String sPreviewIndicator) throws EventException {

		EventResponse eventResponse = null;

		try {
			begin();
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.selectApInvHdrDtrbList(sCsrNo, sPreviewIndicator);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err [selectPreviewInvHdrDtrbList] " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchTAXInfo<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTAXInfo(Event e) throws EventException {

		EsdTrs0034Event event = (EsdTrs0034Event) e;

		EventResponse eventResponse = null;

		try {

			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.searchTAXInfo(event);

		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchApEviNo<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchApEviNo(Event e) throws EventException {

		EsdTrs0034Event event = (EsdTrs0034Event) e;

		EventResponse eventResponse = null;

		try {
			begin();
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.searchApEviNo(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchTAXCode<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchTAXCode(Event e) throws EventException {

		EsdTrs0034Event event = (EsdTrs0034Event) e;

		EventResponse eventResponse = null;

		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.searchTAXCode(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * multiInvoiceAuditRefund<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse multiInvoiceAuditRefund(Event e) throws EventException {
		EsdTrs0040Event evnet = (EsdTrs0040Event) e;
		EventResponse eventResponse = null;

		try {
			begin();
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.multiInvoiceAuditRefund(evnet);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchPaymentVendor<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchPaymentVendor(Event e) throws EventException {
		EsdTrs0040Event evnet = (EsdTrs0040Event) e;
		EventResponse eventResponse = null;

		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.searchPaymentVendor(evnet);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchInvoiceNo<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchInvoiceNo(Event e) throws EventException {
		EsdTrs0040Event evnet = (EsdTrs0040Event) e;
		EventResponse eventResponse = null;

		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.searchInvoiceNo(evnet);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchRefundList<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRefundList(Event e) throws EventException {
		EsdTrs0040Event evnet = (EsdTrs0040Event) e;
		EventResponse eventResponse = null;

		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.searchRefundList(evnet);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchRefundInvAndDetailList<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRefundInvAndDetailList(Event e) throws EventException {
		EsdTrs0040Event evnet = (EsdTrs0040Event) e;
		EventResponse eventResponse = null;

		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.searchRefundInvAndDetailList(evnet);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchRailInvoiceInquiryCorrectionList<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchRailInvoiceInquiryCorrectionList(Event e) throws EventException {
		EsdTrs0046Event evnet = (EsdTrs0046Event) e;
		EventResponse eventResponse = null;

		try {
			RailInvoiceInquiryCorrectionBC command = new RailInvoiceInquiryCorrectionBCImpl();
			eventResponse = command.searchRailInvoiceInquiryCorrectionList(evnet);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * multiRailInvoiceHold<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse multiRailInvoiceHold(Event e) throws EventException {
		EsdTrs0046Event evnet = (EsdTrs0046Event) e;
		EventResponse eventResponse = null;

		try {
			begin();
			RailInvoiceInquiryCorrectionBC command = new RailInvoiceInquiryCorrectionBCImpl();
			eventResponse = command.multiRailInvoiceHold(evnet);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * removeRailInvoiceInquiryCorrection<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse removeRailInvoiceInquiryCorrection(Event e) throws EventException {
		EsdTrs0046Event evnet = (EsdTrs0046Event) e;
		EventResponse eventResponse = null;

		try {
			begin();
			RailInvoiceInquiryCorrectionBC command = new RailInvoiceInquiryCorrectionBCImpl();
			eventResponse = command.removeRailInvoiceInquiryCorrection(evnet);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * multiRailInvoiceConfirmCancel<BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse multiRailInvoiceConfirmCancel(Event e) throws EventException {
		EsdTrs0046Event evnet = (EsdTrs0046Event) e;
		EventResponse eventResponse = null;

		try {
			begin();
			RailInvoiceInquiryCorrectionBC command = new RailInvoiceInquiryCorrectionBCImpl();
			eventResponse = command.multiRailInvoiceConfirmCancel(evnet);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchInvoiceListInquiry <BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchInvoiceListInquiry(Event e) throws EventException {
		EsdTrs0960Event evnet = (EsdTrs0960Event) e;
		EventResponse eventResponse = null;

		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.searchInvoiceListInquiry(evnet);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchCSRAPiflist <BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCSRAPiflist(Event e) throws EventException {

		log.debug("\n\n SC - searchCSRAPiflist() \n\n");

		EsdTrs0047Event event = (EsdTrs0047Event) e;

		EventResponse eventResponse = null;

		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCSRAPiflist(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * cancelCSRAPifError <BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse cancelCSRAPifError(Event e) throws EventException {

		log.debug("\n\n SC - cancelCSRAPif() \n\n");

		EsdTrs0047Event event = (EsdTrs0047Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			command.cancelCSRAPifError(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * cancelCSRApprovalRequest <BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse cancelCSRApprovalRequest(Event e) throws EventException {

		log.debug("\n\n SC - cancelCSRApprovalRequest() \n\n");

		EsdTrs0047Event event = (EsdTrs0047Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String csrNo = event.getCsrNo();
		try {
			begin();
			ApprovalBC apCommand = new ApprovalBCImpl();
			apCommand.cancelApproval(csrNo);
			new CSRIssueTransferSlipManageBCImpl().cancelCSRAPifError(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * cancelCSRAPif <BR>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @throws EventException
	 */
	private EventResponse cancelCSRAPif(Event e) throws EventException {
		log.debug("\n\n SC - cancelCSRAPif() \n\n");
		EsdTrs0048Event event = (EsdTrs0048Event) e;
		EventResponse eventResponse = null;
		try {
			begin();
			eventResponse = new CSRIssueTransferSlipManageBCImpl().cancelCSRAPif(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * modifyTrsInvHdr <br>
	 * 
	 * @param e Event
	 * @throws EventException
	 */
	public void modifyTrsInvHdr(Object e) throws EventException {

		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			command.modifyTrsInvHdr(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * searchCsrCancel<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCsrCancel(Event e) throws EventException {
		EsdTrs0048Event evnet = (EsdTrs0048Event) e;
		EventResponse eventResponse = null;

		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCsrCancel(evnet);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * searchCsrPreVeiw<br>>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCsrPreVeiw(Event e) throws EventException {

		EsdTrs0047Event event = (EsdTrs0047Event) e;
		// HashMap hashParam = event.getHashParam();
		String sCsrNo = event.getCsrNo();

		EventResponse eventResponse = null;

		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCsrPreVeiw(sCsrNo);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * approval Request<br>>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse approvalRequest(Event e) throws EventException {

		String sCsrNo = null;
		EsdTrs0032Event event = (EsdTrs0032Event) e;
		DBRowSet[] oApDtrbRowSetArr = null;
		EventResponse eventResponse = null;
		CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
		try {
			begin();
			command.correctCsrAmt(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		sCsrNo = command.generateNewCsrNo(event);
		event.setCsr_no(sCsrNo);
		try {
			begin();
			command.updateCntrFincVVD(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		oApDtrbRowSetArr = command.generateApInvDTRB(event);
		event.setApDtrbRowSetArr(oApDtrbRowSetArr);
		try {
			begin();
			eventResponse = command.createApInvHdrDtrb(event);
			command.updateApInvDtrbLineNo(sCsrNo);
			command.checkApInvDtrbValidation(sCsrNo);
			command.createApInvIF(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * approval preview<br>>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse approvalPreview(Event e) throws EventException {

		String sCsrNo = null;
		EsdTrs0032Event event = (EsdTrs0032Event) e;
		DBRowSet[] oApDtrbRowSetArr = null;
		EventResponse eventResponse = null;

		CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
		try {

			begin();
			command.correctCsrAmt(event);
			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		try {

			begin();
			command.updateCntrFincVVD(event);
			commit();

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		sCsrNo = command.generateNewCsrNo(event);
		event.setCsr_no(sCsrNo);

		oApDtrbRowSetArr = command.generateApInvDTRB(event);
		event.setApDtrbRowSetArr(oApDtrbRowSetArr);

		try {

			begin();
			command.createApInvHdrDtrb(event);
			command.updateApInvDtrbLineNo(sCsrNo);
			commit();

			eventResponse = selectApInvHdrDtrbList(sCsrNo, "PREVIEW");
			command.deleteInvHdrDtrbList(sCsrNo);

		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Inserting process when Invoice Pool Chassis data saved Temporarily<br>>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */

	private EventResponse insertInvoicePoolChassis(Event e) throws EventException {
		EsdTrs0041Event evnet = (EsdTrs0041Event) e;
		EventResponse eventResponse = null;

		try {
			begin();
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.insertInvoicePoolChassis(evnet);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Updating process when Invoice Pool Chassis data saved Temporarily<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse updateInvoicePoolChassis(Event e) throws EventException {
		EsdTrs0041Event evnet = (EsdTrs0041Event) e;
		EventResponse eventResponse = null;

		try {
			begin();
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.updateInvoicePoolChassis(evnet);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inserting process when Invoice Pool Chassis data saved Temporarily<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */

	private EventResponse confirmInsertInvoicePoolChassis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0041Event event = (EsdTrs0041Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			begin();
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.confirmInsertInvoicePoolChassis(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * confirm and save Invoice Pool chassis event <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmUpdateInvoicePoolChassis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0041Event event = (EsdTrs0041Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			begin();
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.confirmUpdateInvoicePoolChassis(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of PoolChassis page<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchInvoicePoolChassisList(Event e) throws EventException {
		EsdTrs0041Event evnet = (EsdTrs0041Event) e;
		EventResponse eventResponse = null;

		try {
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.searchInvoicePoolChassisList(evnet);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring Payment S/P of chassis Pool<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse getPaymentSPList(Event e) throws EventException {

		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.getPaymentSPList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Checking the duplication of Invoice No.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse dupChkPoolChassisInvoiceNo(Event e) throws EventException {
		EsdTrs0041Event evnet = (EsdTrs0041Event) e;
		EventResponse eventResponse = null;
		try {
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.dupChkPoolChassisInvoiceNo(evnet);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Confirming the Invoice No.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmInvoicePoolChassis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0041Event event = (EsdTrs0041Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			begin();
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.confirmInvoicePoolChassis(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Canceling the confirmation of the Invoice No.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmCancelInvoicePoolChassis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdTrs0041Event event = (EsdTrs0041Event) e;
		// An object having the result of user's inquiry (DB Result Set, Object, value etc.)
		EventResponse eventResponse = null;

		try {
			begin();
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.confirmCancelInvoicePoolChassis(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Deleting Invoice Pool Chassis<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse deleteInvoicePoolChassis(Event e) throws EventException {
		EsdTrs0041Event event = (EsdTrs0041Event) e;
		EventResponse eventResponse = null;

		try {
			begin();
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.deleteInvoicePoolChassis(event);
			commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of InvoiceAudit page<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVendor(Event e) throws EventException {
		EsdTrs0040Event event = (EsdTrs0040Event) e;
		EventResponse eventResponse = null;
		try {
			InvoiceAuditBC command = new InvoiceAuditBCImpl();
			eventResponse = command.searchVendor(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring the list of Chassis Pool.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse getPoolList(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			PoolChassisBC command = new PoolChassisBCImpl();
			eventResponse = command.getPoolList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Checking the Hold Invoice No.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckHoldInvoice(Event e) throws EventException {
		EsdTrs0032Event event = (EsdTrs0032Event) e;
		EventResponse eventResponse = null;
		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCheckHoldInvoice(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Checking the Hold Invoice No.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckAPoffice(Event e) throws EventException {
		EsdTrs0032Event event = (EsdTrs0032Event) e;
		EventResponse eventResponse = null;
		try {
			CSRIssueTransferSlipManageBC command = new CSRIssueTransferSlipManageBCImpl();
			eventResponse = command.searchCheckAPoffice(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * 조회 이벤트 처리<br>
	 * invoiceaudit의 event에 대한 특정 리스트 조회 이벤트 처리<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse verifyRailInvoiceFileImportEqNo(Event e) throws EventException {

		EsdTrs0923Event event = (EsdTrs0923Event) e;
		GeneralEventResponse eventResponseReturn = new GeneralEventResponse();

		String invNo = null;
		// String result = null;
		String tabType = null;

		ArrayList seqList = event.getSeqNoList();
		ArrayList eqNoList = event.getCntrNoList();
		ArrayList wbl_dtList = event.getWblDtList();
		ArrayList invBilAmtList = event.getInvBilAmtList();
		ArrayList wblNoList = event.getWblNoList();
		ArrayList invOrgNodNmList = event.getInvOrgNodNmList();
		ArrayList invDestNodNmList = event.getInvDestNodNmList();

		ArrayList resultList = event.getResultList();
		ArrayList hashList = new ArrayList();
		ArrayList rsltSetList = new ArrayList();
		ArrayList eqtpszList = new ArrayList();
		ArrayList railAudCdList = new ArrayList();
		HashMap resultHashMap = new HashMap();

		DBRowSet rowSet = null;
		TrsTrspRailInvDtlVO[] trsTrspRailInvDtlVOs = event.getTrsTrspRailInvDtlVos();
		try {
			RailInvoiceauditBC command = new RailInvoiceauditBCImpl();
			ArrayList eqNoListClon = command.verifyInvoiceFileImportEqNo(event);
			for (int i = 0; i < seqList.size(); i++) {
				hashList.add(null);
				rsltSetList.add(null);
				eqtpszList.add(null);
				railAudCdList.add(null);
			}

			// ArrayList eqNoListTemp = (ArrayList) eqNoList.clone();
			// resultList = getDupEqNoList(eqNoListTemp, resultList);

			/* eq_no가 존재하지 않는건 결과 표시 */
			String eqNo = "";
			for (int idx = 0; idx < eqNoListClon.size(); idx++) {
				rowSet = (DBRowSet) eqNoListClon.get(idx);
				if (rowSet != null && rowSet.next()) {
					eqtpszList.set(idx, rowSet.getString("cntr_tpsz_cd"));
					for (int x = 0; x < eqNoList.size(); x++) {
						eqNo = CheckUtilities.isNullOrNullStringReplacement((String) eqNoList.get(x), "");
						if (eqNo.length() >= 10 && rowSet.getString("cntr_no").startsWith(eqNo)) {
							eqNoList.set(x, rowSet.getString("cntr_no"));
						}
					}
				} else {
					resultList.set(idx, "Incorrect CNTR NO");
				}
			}

			event.setResultList(resultList);
			/* inv_no가 존재하는 건 결과표시 */
			ArrayList invNoList = command.verifyInvoiceFileImportInvNo(event);
			for (int idx = 0; idx < invNoList.size(); idx++) {
				rowSet = (DBRowSet) invNoList.get(idx);
				while (rowSet != null && rowSet.next()) {
					invNo = rowSet.getString("inv_no");
					resultList.set(idx, "Already Exists Invoice NO(" + invNo + ")");
				}
			}
			event.setResultList(resultList);
			DBRowSet vndrSetRowSet = null;
			int vndrSetSize = 0;
			HashMap tempMap = null;
			DBRowSet resultRow = null;
			String result = null;
			Set<String> uniqueData = new HashSet<String>();
			for (int k = 0; k < trsTrspRailInvDtlVOs.length; k++) {
				tempMap = new HashMap();
				resultRow = null;
				result = (String) resultList.get(k);
				if (result == null || CheckUtilities.isInBlank(result)) {
					TrsTrspRailInvDtlVO fileImptVo = trsTrspRailInvDtlVOs[k];
					fileImptVo.setCurrCd(event.getCurrency());
					fileImptVo.setInvVndrSeq(event.getRailRoadCode());

					StringBuilder uniqueKey = new StringBuilder();
					uniqueKey.append(fileImptVo.getCntrNo()).append("|");
					uniqueKey.append(fileImptVo.getInvOrgNodNm()).append("|");
					uniqueKey.append(fileImptVo.getInvDestNodNm());
					if (uniqueData.contains(uniqueKey.toString()) || uniqueData.contains(fileImptVo.getCntrNo() + "||")) {
						resultList.set(k, "This Data is duplicated.");
					} else {
						uniqueData.add(uniqueKey.toString());
						vndrSetRowSet = command.verifyInvoiceFileImportVndrSetList(fileImptVo);
						vndrSetSize = getRsltSize(vndrSetRowSet);
						if (vndrSetSize == 0) {
							resultList.set(k, "Invoice Only");
							tempMap.put("inv_only_check", "1");
							railAudCdList.set(k, "I");
						} else if (vndrSetSize == 1) {
							if (!checkCurrency(vndrSetRowSet, event.getCurrency())) {
								resultList.set(k, "Currency Differ");
							} else {
								tabType = getString(vndrSetRowSet, "trsp_rail_inv_aud_cd");
								if (tabType.equals("C")) {
									tempMap.put("coincidence_check", "1");
									railAudCdList.set(k, "C");
								} else if (tabType.equals("D")) {
									tempMap.put("descrepancy_check", "1");
									railAudCdList.set(k, "D");
								}
								resultList.set(k, "OK");
								resultRow = vndrSetRowSet;
							}
						} else if (vndrSetSize > 1) {
							if (!checkCurrency(vndrSetRowSet, event.getCurrency())) {
								resultList.set(k, "Currency Differ");
							} else {
								tabType = getString(vndrSetRowSet, "trsp_rail_inv_aud_cd");
								if (tabType.equals("C")) {
									tempMap.put("coincidence_check", "1");
									railAudCdList.set(k, "C");
								} else if (tabType.equals("D")) {
									tempMap.put("descrepancy_check", "1");
									railAudCdList.set(k, "D");
								}
								resultList.set(k, "Multiple SO");
								resultRow = vndrSetRowSet;
							}
						} else {
							String sdd = command.verifyInvoiceFileImportVndrSetListForMultiSo(fileImptVo);
							if (!CheckUtilities.isInBlank(sdd)) {
								resultList.set(k, "This data is already included in existing invoice. [" + sdd + "]");
							} else {
								resultList.set(k, "There is no corresponding data.");
							}
						}
					}
				}
				hashList.set(k, tempMap);
				if (resultRow == null) {
					resultRow = vndrSetRowSet;
				}
				rsltSetList.set(k, resultRow);
			}

			resultHashMap.put("hashList", hashList);
			resultHashMap.put("seqList", seqList);
			resultHashMap.put("eqNoList", eqNoList);
			resultHashMap.put("resultList", resultList);
			resultHashMap.put("rsltSetList", rsltSetList);
			resultHashMap.put("eqtpszList", eqtpszList);
			resultHashMap.put("railAudCdList", railAudCdList);
			resultHashMap.put("wbl_dtList", wbl_dtList);
			resultHashMap.put("invBilAmtList", invBilAmtList);
			resultHashMap.put("hashParam", event.getColumnValues());
			resultHashMap.put("wblNoList", wblNoList);
			resultHashMap.put("invOrgNodNmList", invOrgNodNmList);
			resultHashMap.put("invDestNodNmList", invDestNodNmList);

			/* 결과를 return */
			event.setHashParam(resultHashMap);
			eventResponseReturn.setRsVo(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponseReturn;
	}

	/**
	 * Inquiry event process of InvoiceInquiryCorrection page<br>
	 * 
	 * @param e
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsRailInvoiceInquirySecondExcelForm(Event e) throws EventException {
		EsdTrs0046Event event = (EsdTrs0046Event) e;
		EventResponse eventResponse = null;
		try {
			RailInvoiceInquiryCorrectionBC command = new RailInvoiceInquiryCorrectionBCImpl();
			eventResponse = command.searchUsRailInvoiceInquirySecondExcelForm(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
}