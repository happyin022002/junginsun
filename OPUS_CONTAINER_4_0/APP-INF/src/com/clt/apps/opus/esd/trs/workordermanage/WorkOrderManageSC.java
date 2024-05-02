/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : WorkOrderManageSC.java
 *@FileTitle : Transportation Report & Code / USA 404 EDI Status Inquiry
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBC;
import com.clt.apps.opus.esd.sce.replanmanage.replanmanage.basic.ReplanManageBCImpl;
import com.clt.apps.opus.esd.trs.common.trscommon.basic.TrsCommonBC;
import com.clt.apps.opus.esd.trs.common.trscommon.basic.TrsCommonBCImpl;
import com.clt.apps.opus.esd.trs.common.trscommon.vo.TrsCommonComboVO;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.basic.SingleTransportationSOManageBC;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.basic.SingleTransportationSOManageBCImpl;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.event.EsdTrs0002Event;
import com.clt.apps.opus.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.basic.EmptyReleaseRedeliveryOrderMgtBC;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.basic.EmptyReleaseRedeliveryOrderMgtBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.event.EsdTrs0429Event;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.event.EsdTrs0451Event;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo.CimCStockVO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo.RDFaxMailEAIVO;
import com.clt.apps.opus.esd.trs.workordermanage.emptyreleaseredeliveryordermgt.vo.SearchRelredMasterForEdiVO;
import com.clt.apps.opus.esd.trs.workordermanage.predispatchsenthistory.basic.PreDispatchSentHistoryBC;
import com.clt.apps.opus.esd.trs.workordermanage.predispatchsenthistory.basic.PreDispatchSentHistoryBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.predispatchsenthistory.event.EsdTrs0021Event;
import com.clt.apps.opus.esd.trs.workordermanage.predispatchstatus.basic.PreDispatchStatusBC;
import com.clt.apps.opus.esd.trs.workordermanage.predispatchstatus.basic.PreDispatchStatusBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.predispatchstatus.event.EsdTrs0020Event;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.basic.USA404EDIStatusInquiryBC;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.basic.USA404EDIStatusInquiryBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.basic.USA404TrsStccBC;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.basic.USA404TrsStccBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0026Event;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0027Event;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0028Event;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event.EsdTrs0802Event;
import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.vo.TrsStccVO;
import com.clt.apps.opus.esd.trs.workordermanage.vendorcm.basic.VendorCmBC;
import com.clt.apps.opus.esd.trs.workordermanage.vendorcm.basic.VendorCmBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.basic.WorkOrderCCManageBC;
import com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.basic.WorkOrderCCManageBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderccmanage.event.EsdTrs0072Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderinquiry.basic.WorkOrderInquiryBC;
import com.clt.apps.opus.esd.trs.workordermanage.workorderinquiry.basic.WorkOrderInquiryBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderinquiry.event.EsdTrs0025Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBC;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.basic.WorkOrderIssueBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event.EsdTrs0023Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event.EsdTrs0921Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.event.EsdTrs0977Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderissue.vo.WoIssueListVO;
import com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.basic.WorkOrderManagementBC;
import com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.basic.WorkOrderManagementBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.event.EsdTrs0029Event;
import com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.event.EsdTrs0983Event;
import com.clt.apps.opus.esd.trs.workordermanage.workordermanagement.vo.WorkOrderBFIManagementVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.basic.WorkOrderPreviewBC;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.basic.WorkOrderPreviewBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.event.EsdTrs0024Event;
import com.clt.apps.opus.esd.trs.workordermanage.workorderpreview.vo.WorkOrderPreviewVO;
import com.clt.apps.opus.esd.trs.workordermanage.workorderremark.basic.WorkOrderRemarkBC;
import com.clt.apps.opus.esd.trs.workordermanage.workorderremark.basic.WorkOrderRemarkBCImpl;
import com.clt.apps.opus.esd.trs.workordermanage.workorderremark.event.EsdTrs0078Event;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.clt.framework.component.common.AbstractValueObject;
import com.clt.framework.component.javamail.MailerAppException;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.utility.CheckUtilities;
import com.clt.syscommon.common.table.CoaBkgComIfVO;
import com.clt.syscommon.common.table.MdmCntrTpSzVO;
import com.clt.syscommon.common.table.TrsTrspEdiRailOrdVO;

/**
 * ESD-WorkOrderManage Business Logic ServiceCommand<br>
 * @author
 * @see ESD_TRS_072EventResponse,WorkOrderCCManageDBDAO
 * @since J2EE 1.4
 */
public class WorkOrderManageSC extends ServiceCommandSupport {
	private SignOnUserAccount account = null;

	/**
	 * Preceding process of WorkOrderManage task scenario<br>
	 * Generating the implicit object when WorkOrderCCManage task is called.<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("Error in preceding process of WorkOrderManageSC " + e.toString(), e);
		}
	}

	/**
	 * End process of WorkOrderManage task scenario<br>
	 * Releasing the related implicit object when WorkOrderCCManage task is end<br>
	 */
	public void doEnd() {
		log.debug("end of WorkOrderManageSC");
	}

	/**
	 * Performing the task scenario corresponding each event.<br>
	 * Branch processing of every event occurring at ESD-WorkOrderManage task<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsdTrs0072Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWorkOrderCCManageList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchWorkOrderCCFaxList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchWorkOrderCCEmailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiWorkOrderCCManageList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0078Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchWorkOrderRemarkList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeWorkOrderRemark(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multiWorkOrderRemark(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchComboList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWorkOrderIssueList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchWorkOrderIssueBySoNo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSpSelectList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchLocalCurr2UsdCurr(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchBillingCaseCode();
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchTpbBasicAmt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchWoIssuedSoList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchWOStsCDCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = setFrustrate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = modifyTrspSubStsCd(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = updateCYContainerNo(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSODeleteCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchWorkOrderPreviewGroup(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchWorkOrderPreviewIssuedGroup(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchEdiInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = resendEDIAsia(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = resendEDIEur(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchWorkOrderPreviewEdiCondChk(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchEdiResendCondChk(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchWorkOrderInquiryPreview(e);
			} else if (e.getFormCommand().isCommand(FormCommand.ADD)) {
				try {
					eventResponse = addWorkOrderPreview(e);
				} catch (DAOException de) {
					log.error("err " + de.toString(), de);
					throw new EventException(de.getMessage());
				} catch (MailerAppException me) {
					log.error("err " + me.toString(), me);
					throw new EventException(me.getMessage());
				}
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				try {
					eventResponse = addWorkOrderPreviewIssued(e);
				} catch (DAOException de) {
					log.error("err " + de.toString(), de);
					this.rollback();
					throw new EventException(de.getMessage());
				} catch (MailerAppException me) {
					log.error("err " + me.toString(), me);
					throw new EventException(me.getMessage());
				}
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // issued multiple W/O
				eventResponse = reissueMultipleWorkOrder(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { // not issued multiple W/O
				eventResponse = issueMultipleWorkOrder(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0025Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWorkOrderInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchWorkOrderInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchWorkOrderList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0028Event")) { // US RAIL EDI page.
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // Search Use
				eventResponse = searchUSA404EDIStatusInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchFaxNoVndrEmlByVndrSeq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // Confirm Message Send
				eventResponse = search02USA404EDIStatusInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // EDI Send Cop
				eventResponse = multiUSA404EDIStatusInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // CONFIM MESSAGE Send
				eventResponse = multi01USA404EDIStatusInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // Cancellation EDI send
				eventResponse = multi02USA404EDIStatusInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { // FRUSTRATE
				eventResponse = multi03USA404EDIStatusInquiry(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) { // 404EDI RESEND (Rail Billing Correction : UI204)
				eventResponse = multiUS404EDIResend(e);
			} else {
				eventResponse = null;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0020Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPreDispatchStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = search01PreDispatchStatus(e);
			} else {
				eventResponse = null;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0021Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPreDispatchSentHistory(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = search01PreDispatchSentHistory(e);
			} else {
				eventResponse = null;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0921Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMoreCandidates(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMdmOrganization(e);
			} else {
				eventResponse = null;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0802Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTrsStcc(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageTrsStcc(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0029Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWorkOrderBFIManagement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // retrieve
				eventResponse = searchWorkOrderBFIUiManagement(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) { // downexcel for invoice
				eventResponse = searchWorkOrderBFIDownForInvoice(e);
				// LOOK : email testing, DON'T BUILD IT
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // send email
				eventResponse = sendBFIManagementByEmail(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0977Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTrsSvcOrdBkgChmHis(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = updateTrsSvcOrdBkgChmHis(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0024Event")) {
			if (e.getFormCommand().isCommand(FormCommand.ADD) || e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = new GeneralEventResponse();
			} else {
				eventResponse = null;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0451Event")) {
			eventResponse = searchRDContent(e);
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0429Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIssueList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = getYardFaxEmailInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = settleIssuedOrder(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = sendReleaseRedeliveryFaxEmail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = checkEdiYardSetup(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0972Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchJoEdiRcvMsgList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = multipleAccept(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = multipleReject(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0973Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchJoEdiHistory(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0026Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUSRailMoreCandidates(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = multiUSRailMoreCandidates(e);
			} else {
				eventResponse = null;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0027Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUSRailBasicRates(e);
			} else {
				eventResponse = null;
			}
		} else if (e.getEventName().equalsIgnoreCase("EsdTrs0983Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTrsSubStsHis(e);
			}
		}
		return eventResponse;
	}

	/**
	 * Combo Search
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchComboList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TrsCommonBC command = new TrsCommonBCImpl();
		List<MdmCntrTpSzVO> list = null;
		try {
			list = command.searchMdmCntrTpSz(e);
			eventResponse.setRsVoList(searchComCodeCombo("CD00748"));
			eventResponse.setRsVoList(searchComCodeCombo("CD01507"));
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}

	/**
	 * com_intg_cd_dtl Table 조회<br>
	 * @param String comCode
	 * @return List<TrsCommonComboVO>
	 * @exception EventException
	 */
	private List<TrsCommonComboVO> searchComCodeCombo(String comCode) throws EventException {
		TrsCommonBC command = new TrsCommonBCImpl();
		List<TrsCommonComboVO> list = null;
		try {
			list = command.searchCombo(comCode);
			for (int j = 0; j < list.size(); j++) {
				list.get(j).setDesc(list.get(j).getVal() + " " + list.get(j).getName());
			}
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(ex.getMessage());
		}

		return list;
	}

	/**
	 * [ESD_TRS_0029] W/O BFI Management 를 조회합니다. <br>
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return List<WorkOrderBFIManagementVO>
	 * @exception DAOException
	 */
	private EventResponse searchWorkOrderBFIManagement(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0029Event event = (EsdTrs0029Event) e;
		WorkOrderManagementBC command = new WorkOrderManagementBCImpl();

		WorkOrderBFIManagementVO workOrderBFIManagementVO = event.getWorkOrderBFIManagementVO();
		try {
			List<WorkOrderBFIManagementVO> workOrderBFIManagementVOs = command.searchWorkOrderManagementBFIListBasic(workOrderBFIManagementVO);

			eventResponse.setRsVoList(workOrderBFIManagementVOs);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * [ESD_TRS_0029] W/O BFI Management 를 조회합니다. <br>
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return List<WorkOrderBFIManagementVO>
	 * @exception DAOException
	 */
	private EventResponse searchWorkOrderBFIUiManagement(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0029Event event = (EsdTrs0029Event) e;
		WorkOrderManagementBC command = new WorkOrderManagementBCImpl();

		WorkOrderBFIManagementVO workOrderBFIManagementVO = event.getWorkOrderBFIManagementVO();
		try {
			List<WorkOrderBFIManagementVO> workOrderBFIManagementVOs = command.searchWorkOrderManagementBFIUiListBasic(workOrderBFIManagementVO);

			eventResponse.setRsVoList(workOrderBFIManagementVOs);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of WorkOrderPreview page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderInquiryList(Event e) throws EventException {
		EsdTrs0025Event event = (EsdTrs0025Event) e;
		EventResponse eventResponse = null;
		try {
			WorkOrderInquiryBC command = new WorkOrderInquiryBCImpl();
			eventResponse = command.searchWorkOrderInquiryList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of WorkOrderPreview page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderList(Event e) throws EventException {
		EsdTrs0025Event event = (EsdTrs0025Event) e;
		EventResponse eventResponse = null;
		try {
			WorkOrderInquiryBC command = new WorkOrderInquiryBCImpl();
			eventResponse = command.searchWorkOrderList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of WorkOrderPreview page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderInquiry(Event e) throws EventException {
		EsdTrs0025Event event = (EsdTrs0025Event) e;
		EventResponse eventResponse = null;
		try {
			WorkOrderInquiryBC command = new WorkOrderInquiryBCImpl();
			eventResponse = command.searchWorkOrderInquiry(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of WorkOrderPreview page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse resendEDIEur(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			this.begin();
			WorkOrderPreviewBC command = new WorkOrderPreviewBCImpl();
			command.resendEDIEur(event);
			this.commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			this.rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of WorkOrderPreview page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse resendEDIAsia(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			this.begin();
			WorkOrderPreviewBC command = new WorkOrderPreviewBCImpl();
			command.resendEDIAsia(event);
			this.commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			this.rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of WorkOrderPreview page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse addWorkOrderPreview(Event e) throws EventException, DAOException, MailerAppException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;

		String woFaxUseFlg = null;
		String woEmlUseFlg = null;
		Boolean isFax = false;
		HashMap<String, Object> flatFileHashMap = null;
		List<String> bkgNoList = new ArrayList<String>();
		List woArrMail = new ArrayList();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WorkOrderPreviewVO wrkOrdPrvVO = event.getWorkOrderPreviewVO();
		WorkOrderPreviewBC command = new WorkOrderPreviewBCImpl();
		try {
			if (command.checkSoChanged(event, false)) {
				throw new DAOException(new ErrorHandler("TRS00061").getMessage());
			}

			this.begin();
			woFaxUseFlg = wrkOrdPrvVO.getWoFaxUseFlg();
			woEmlUseFlg = wrkOrdPrvVO.getWoEmlUseFlg();
			if (woFaxUseFlg == null || !woFaxUseFlg.equals("FAX")) {
				wrkOrdPrvVO.setWoN1stFaxNo("");
				wrkOrdPrvVO.setWoN2ndFaxNo("");
				wrkOrdPrvVO.setWoN3rdFaxNo("");
			}

			if (woEmlUseFlg == null || !woEmlUseFlg.equals("EML")) {
				wrkOrdPrvVO.setWoN1stEml("");
				wrkOrdPrvVO.setWoN2ndEml("");
				wrkOrdPrvVO.setWoN3rdEml("");
			}

			event.setWorkOrderPreviewVO(wrkOrdPrvVO);
			bkgNoList = command.getBkgNoIfVndrChanged(event);
			flatFileHashMap = command.addWorkOrderPreview(event, account);
			String workOrderNo = command.searchWorkOrderNo(event);
			for (int i = 0; i < bkgNoList.size(); i++) {
				if (null != bkgNoList.get(i) && !"".equals(bkgNoList.get(i))) {
					modifyCoaCommonInterface((String) bkgNoList.get(i), event.getFormCreUsrId());
				}
			}
			if (woEmlUseFlg != null && woEmlUseFlg.equals("EML")) {
				DBRowSet wonoRowSet = null;
				wonoRowSet = command.searchWoNo(event);
				woArrMail = command.emailSend(event, wonoRowSet);
			}
			if (woFaxUseFlg != null && woFaxUseFlg.equals("FAX")) {
				command.sendEaiFax(event, account.getUsr_id(), workOrderNo);
			}

			wrkOrdPrvVO = event.getWorkOrderPreviewVO();

			String faxNo01 = wrkOrdPrvVO.getFaxNo01() == null ? "" : wrkOrdPrvVO.getFaxNo01();
			String faxNo02 = wrkOrdPrvVO.getFaxNo02() == null ? "" : wrkOrdPrvVO.getFaxNo02();
			String faxNo03 = wrkOrdPrvVO.getFaxNo03() == null ? "" : wrkOrdPrvVO.getFaxNo03();
			if (!faxNo01.equals("") || !faxNo02.equals("") || !faxNo03.equals("")) {
				isFax = true;
			}

			if ((isFax) || (null != woArrMail && woArrMail.size() > 0)) {
				command.addFaxAndEmailNo(event);
			}
			// Separate the EDI sending part from the transaction due to the frequent timeout exception.
			if (flatFileHashMap != null) {
				ArrayList joEdiFF = (ArrayList) flatFileHashMap.get("JOEDI");
				if (joEdiFF != null) {
					String[] ffArray = null;
					for (int ediCnt = 0; ediCnt < joEdiFF.size(); ediCnt++) {
						ffArray = (String[]) joEdiFF.get(ediCnt);
						if (ffArray != null) {
							command.sendFlatMessage(ffArray[1]);
						}
					}
				}
				sendEdiFaxEmlForReleaseAndRedelivery(command, event, flatFileHashMap, account);
			}
			this.commit();
		} catch (Exception de) {
			this.rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of WorkOrderPreview page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse addWorkOrderPreviewIssued(Event e) throws EventException, DAOException, MailerAppException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;

		String woFaxUseFlg = null;
		String woEmlUseFlg = null;
		Boolean isFax = false;
		String userId = null;
		String usrOfcCd = null;
		HashMap<String, Object> flatFileHashMap = null;
		List woArrMail = new ArrayList();

		WorkOrderPreviewVO wrkOrdPrvVO = null;
		SingleTransportationVO[] singleTransportationVOs = null;

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		WorkOrderPreviewBC command = new WorkOrderPreviewBCImpl();
		try {
			if (command.checkSoChanged(event, true)) {
				throw new DAOException(new ErrorHandler("TRS00061").getMessage());
			}

			this.begin();
			wrkOrdPrvVO = event.getWorkOrderPreviewVO();
			userId = event.getSignOnUserAccount().getUsr_id();
			usrOfcCd = event.getSignOnUserAccount().getOfc_cd();
			woFaxUseFlg = wrkOrdPrvVO.getWoFaxUseFlg();
			woEmlUseFlg = wrkOrdPrvVO.getWoEmlUseFlg();
			if (woFaxUseFlg == null || !woFaxUseFlg.equals("FAX")) {
				wrkOrdPrvVO.setWoN1stFaxNo("");
				wrkOrdPrvVO.setWoN2ndFaxNo("");
				wrkOrdPrvVO.setWoN3rdFaxNo("");
			}
			if (woEmlUseFlg == null || !woEmlUseFlg.equals("EML")) {
				wrkOrdPrvVO.setWoN1stEml("");
				wrkOrdPrvVO.setWoN2ndEml("");
				wrkOrdPrvVO.setWoN3rdEml("");
			}
			flatFileHashMap = command.addWorkOrderPreviewIssued(event, account);
			if (woEmlUseFlg != null && woEmlUseFlg.equals("EML")) {
				DBRowSet wonoRowSet = null;
				wonoRowSet = command.searchWoNo(event);
				woArrMail = command.emailSend(event, wonoRowSet);
			}

			singleTransportationVOs = command.searchDeleteSoList(event);
			if (singleTransportationVOs != null && singleTransportationVOs.length > 0) {
				EsdTrs0002Event event0002 = new EsdTrs0002Event();
				event0002.setSingleTransportationVOs(singleTransportationVOs);
				event0002.setForm_cre_usr_id(userId);
				event0002.setForm_usr_ofc_cd(usrOfcCd);

				SingleTransportationSOManageBC command0002 = new SingleTransportationSOManageBCImpl();
				eventResponse = command0002.removeSingleTransportationSOManage(event0002);
			}
			if (woFaxUseFlg != null && woFaxUseFlg.equals("FAX")) {
				String workOrderNo = command.searchWorkOrderNo(event);
				command.sendEaiFax(event, account.getUsr_id(), workOrderNo);
			}

			wrkOrdPrvVO = event.getWorkOrderPreviewVO();
			String faxNo01 = wrkOrdPrvVO.getFaxNo01() == null ? "" : wrkOrdPrvVO.getFaxNo01();
			String faxNo02 = wrkOrdPrvVO.getFaxNo02() == null ? "" : wrkOrdPrvVO.getFaxNo02();
			String faxNo03 = wrkOrdPrvVO.getFaxNo03() == null ? "" : wrkOrdPrvVO.getFaxNo03();
			if (!faxNo01.equals("") || !faxNo02.equals("") || !faxNo03.equals("")) {
				isFax = true;
			}

			if ((isFax) || (null != woArrMail && woArrMail.size() > 0)) {
				command.addFaxAndEmailNo(event);
			}
			if (flatFileHashMap != null) {
				ArrayList joEdiFF = (ArrayList) flatFileHashMap.get("JOEDI");
				String[] ffArray = null;
				for (int ediCnt = 0; joEdiFF != null && ediCnt < joEdiFF.size(); ediCnt++) {
					ffArray = (String[]) joEdiFF.get(ediCnt);
					if (ffArray != null) {
						command.sendFlatMessage(ffArray[1]);
					}
				}
				sendEdiFaxEmlForReleaseAndRedelivery(command, event, flatFileHashMap, account);
			}

			// COA I/F
			DBRowSet bkgRowSet = null;
			bkgRowSet = command.searchBkgCancelList(event);
			while (bkgRowSet.next()) {
				CostAssignBC coaCommand = new CostAssignBCImpl();
				CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
				coaBkgComIfVo.setBkgNo(bkgRowSet.getString("bkg_no"));
				coaBkgComIfVo.setCostSrcSysCd("TRS");// SUB SYSTEM CODE : TRS, TES, SCE, BKG etc
				coaBkgComIfVo.setIfRmk("W/O Cancel. RQST By BKG");
				coaBkgComIfVo.setCreUsrId(userId);
				coaBkgComIfVo.setUpdUsrId(userId);

				int result_cnt = coaCommand.modifyCoaCommonInterface(coaBkgComIfVo);
				if (result_cnt < 0)
					throw new EventException((new ErrorHandler("TRS00099", new String[] { "COA I/F Error" })).getMessage());
			}
			this.commit();
		} catch (Exception de) {
			this.rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Release & Redelivery => EDI
	 * @param command
	 * @param event
	 * @param flatFileHashMap
	 * @param account
	 */
	@SuppressWarnings("rawtypes")
	private void sendEdiFaxEmlForReleaseAndRedelivery(WorkOrderPreviewBC command, EsdTrs0024Event event, HashMap<String, Object> flatFileHashMap, SignOnUserAccount account) {
		try {
			EmptyReleaseRedeliveryOrderMgtBC emptyCommand = new EmptyReleaseRedeliveryOrderMgtBCImpl();
			ArrayList relRedArray = (ArrayList) flatFileHashMap.get("RELRED");
			List<SearchRelredMasterForEdiVO> cimCStockVOs = new ArrayList<SearchRelredMasterForEdiVO>();
			SearchRelredMasterForEdiVO cimCStockVO = null;
			if (relRedArray != null) {
				List<AbstractValueObject> list = new ArrayList<AbstractValueObject>();
				int listCnt = 0;
				String[] s = new String[2];
				for (int k = 0; k < relRedArray.size(); k++) {
					WorkOrderPreviewVO previewVO = (WorkOrderPreviewVO) relRedArray.get(k);
					list.addAll(emptyCommand.searchRelRedMasterData(previewVO, "RLS"));
					list.addAll(emptyCommand.searchRelRedMasterData(previewVO, "RDV"));
					listCnt = list.size();
					for (int o = 0; o < listCnt; o++) {
						cimCStockVO = (SearchRelredMasterForEdiVO) list.get(o);
						if (cimCStockVO != null && !CheckUtilities.isInBlank(cimCStockVO.getModeCd())) {
							s = emptyCommand.makeFlatFileReleaseReDelivery(event, previewVO, cimCStockVO, account);
							if (s[0] == null || s[0].trim().length() == 0) {
								continue;
							}
							command.sendFlatMessage(s[0]);
							cimCStockVO.setCreUsrId(account.getUsr_id());
							cimCStockVO.setUserId(account.getUsr_id());
							cimCStockVOs.add(cimCStockVO);
							cimCStockVO = null;
						}
					}
					list = new ArrayList<AbstractValueObject>();
				}
			}
		} catch (EventException e) {
			log.error("err " + e.toString(), e);
		} catch (Exception e) {
			log.error("err " + e.toString(), e);
		}
	}

	/**
	 * Inquiry event process of EdiInquiryList page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEdiInquiryList(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		EventResponse eventResponse = null;
		try {
			WorkOrderPreviewBC command = new WorkOrderPreviewBCImpl();
			eventResponse = command.searchEdiInquiryList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of EdiInquiryList page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderPreviewEdiCondChk(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		EventResponse eventResponse = null;
		try {
			WorkOrderPreviewBC command = new WorkOrderPreviewBCImpl();
			eventResponse = command.searchWorkOrderPreviewEdiCondChk(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of EdiInquiryList page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEdiResendCondChk(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		EventResponse eventResponse = null;
		try {
			WorkOrderPreviewBC command = new WorkOrderPreviewBCImpl();
			eventResponse = command.searchEdiResendCondChk(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of WorkOrderPreview page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderPreviewIssuedGroup(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		EventResponse eventResponse = null;
		try {
			this.begin();
			WorkOrderPreviewBC command = new WorkOrderPreviewBCImpl();
			command.searchWorkOrderPreviewIssuedGroup(event);
			this.commit();
			this.begin();
			eventResponse = command.searchWorkOrderPreviewIssueStatus(event);
			this.commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			this.rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of WorkOrderPreview page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderPreviewGroup(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		EventResponse eventResponse = null;
		try {
			WorkOrderPreviewBC command = new WorkOrderPreviewBCImpl();
			this.begin();
			command.searchWorkOrderPreviewGroup(event);
			this.commit();
			this.begin();
			eventResponse = command.searchWorkOrderPreviewIssueStatus(event);
			this.commit();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			this.rollback();
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of WorkOrderPreview page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderInquiryPreview(Event e) throws EventException {
		EventResponse eventResponse = null;
		try {
			WorkOrderPreviewBC command = new WorkOrderPreviewBCImpl();
			eventResponse = command.searchWorkOrderInquiryPreview(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of WorkOrderCCManage page<br>
	 * @return response EventResponse
	 * @exception EventException 2014.12.11 Modified by Hyungwook Choi
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchWorkOrderIssueList(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		int i = 1;

		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = command.searchWorkOrderIssueList(event);
			List<WoIssueListVO> woModel = new ArrayList<WoIssueListVO>();
			woModel = (List) eventResponse.getRsVoList();

			if (woModel.size() > 0) {
				ArrayList scgArr = command.searchSurchargeList(woModel);
				int colCount = 0;
				if (scgArr.size() > 0) {
					DBRowSet scgRs = (DBRowSet) scgArr.get(0);
					StringBuilder scgXml = new StringBuilder();
					StringBuffer colOrder = new StringBuffer();
					colCount = scgRs.getMetaData().getColumnCount();
					for (int k = 1; k < scgRs.getMetaData().getColumnCount() + 1; k++) {
						colOrder.append("surcharge_" + scgRs.getMetaData().getColumnName(k).toLowerCase());
						if (k != scgRs.getMetaData().getColumnCount())
							colOrder.append("|");
					}

					scgXml.append("<SHEET>");
					scgXml.append("<DATA COLORDER='").append(colOrder).append("'>");
					for (int k = 0; k < scgArr.size(); k++) {
						scgRs = (DBRowSet) scgArr.get(k);
						while (scgRs != null && scgRs.next()) {
							i = 1;
							scgXml.append("<TR>");
							String colVal = "";
							for (int j = 0; j < colCount; j++) {
								if (i > scgRs.getMetaData().getColumnCount()) {
									colVal = "";
								} else {
									colVal = JSPUtil.getNull(scgRs.getString(i++));
								}
								scgXml.append("<TD>").append(colVal).append("</TD>");
							}
							scgXml.append("</TR>");
						}
					}
					scgXml.append("</DATA></SHEET>");
					eventResponse.setETCData("scgXml", scgXml.toString());
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
	 * Inquiry event process of WorkOrderCCManage page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchWorkOrderIssueBySoNo(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		int i = 1;

		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = command.searchWorkOrderIssueBySoNo(event);
			List<WoIssueListVO> woModel = new ArrayList<WoIssueListVO>();
			woModel = (List) eventResponse.getRsVoList();

			if (woModel.size() > 0) {
				ArrayList scgArr = command.searchSurchargeList(woModel);
				if (scgArr.size() > 0) {
					DBRowSet scgRs = (DBRowSet) scgArr.get(0);
					@SuppressWarnings("unused")
					String[] colValue = null;
					StringBuilder scgXml = new StringBuilder();
					StringBuffer colOrder = new StringBuffer();

					if (scgRs != null) {
						colValue = new String[scgRs.getMetaData().getColumnCount()];
						for (int k = 1; k < scgRs.getMetaData().getColumnCount() + 1; k++) {
							colOrder.append("surcharge_" + scgRs.getMetaData().getColumnName(k));
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
	 * Inquiry event process of WorkOrderCCManage page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private EventResponse searchSpSelectList(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		int i = 1;
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = command.searchSpSelectList(event);
			List<WoIssueListVO> woModel = new ArrayList<WoIssueListVO>();
			woModel = (List) eventResponse.getRsVoList();

			if (woModel.size() > 0) {
				ArrayList scgArr = command.searchSurchargeList(woModel);
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
	 * Inquiry event process of WorkOrderCCManage page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocalCurr2UsdCurr(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = command.searchLocalCurr2UsdCurr(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Process of FRUSTRATING<br>
	 * Inquiry event process of WorkOrderCCManage page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse setFrustrate(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
		try {
			eventResponse = (EventResponse) command.setFrustrate(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * modifyTrspSubStsCd <br>
	 * modify <br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyTrspSubStsCd(Event e) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			begin();
			command.modifyTrspSubStsCd(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inserting process of WorkOrderCCManage event<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiWorkOrderRemark(Event e) throws EventException {
		EsdTrs0078Event event = (EsdTrs0078Event) e;
		try {
			begin();
			WorkOrderRemarkBC command = new WorkOrderRemarkBCImpl();
			command.multiWorkOrderRemark(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchWorkOrderRemarkList(e);
	}

	/**
	 * Inserting process of WorkOrderCCManage event<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeWorkOrderRemark(Event e) throws EventException {
		EsdTrs0078Event event = (EsdTrs0078Event) e;
		try {
			begin();
			WorkOrderRemarkBC command = new WorkOrderRemarkBCImpl();
			command.removeWorkOrderRemark(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return this.searchWorkOrderRemarkList(e);
	}

	/**
	 * Inquiry event process of WorkOrderCCManage page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderRemarkList(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0078Event event = (EsdTrs0078Event) e;
		try {
			WorkOrderRemarkBC command = new WorkOrderRemarkBCImpl();
			eventResponse = command.searchWorkOrderRemarkList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of WorkOrderCCManage page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderCCManageList(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0072Event event = (EsdTrs0072Event) e;
		try {
			WorkOrderCCManageBC command = new WorkOrderCCManageBCImpl();
			eventResponse = command.searchWorkOrderCCManageList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		return eventResponse;
	}

	/**
	 * Inquiring the list of WorkOrderCCManage event<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderCCFaxList(Event e) throws EventException {
		EsdTrs0072Event event = (EsdTrs0072Event) e;
		EventResponse eventResponse = null;
		try {
			WorkOrderCCManageBC command = new WorkOrderCCManageBCImpl();
			eventResponse = command.searchWorkOrderCCFaxList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring the list of WorkOrderCCManage event<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWorkOrderCCEmailList(Event e) throws EventException {
		EsdTrs0072Event event = (EsdTrs0072Event) e;
		EventResponse eventResponse = null;
		try {
			WorkOrderCCManageBC command = new WorkOrderCCManageBCImpl();
			eventResponse = command.searchWorkOrderCCEmailList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Multi-process of WorkOrderCCManage event<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiWorkOrderCCManageList(Event e) throws EventException {
		EsdTrs0072Event event = (EsdTrs0072Event) e;
		EventResponse eventResponse = null;
		try {
			begin();
			WorkOrderCCManageBC command = new WorkOrderCCManageBCImpl();
			command.multiWorkOrderCCManageList(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}

		if ("FAX".equals(event.getFaxEmailIndicator())) {
			eventResponse = this.searchWorkOrderCCFaxList(e);
		} else {
			eventResponse = this.searchWorkOrderCCEmailList(e);
		}
		return eventResponse;
	}

	/**
	 * Inquiring the list of USA404EDIStatusInquiry event<br>
	 * 404EDI Inquiry
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSA404EDIStatusInquiry(Event e) throws EventException {
		EventResponse eventResponse = null;
		USA404EDIStatusInquiryBC command = new USA404EDIStatusInquiryBCImpl();
		try {
			EsdTrs0028Event event = (EsdTrs0028Event) e;
			eventResponse = command.searchUSA404EDIStatusInquiry(event);
		} catch (Exception de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry the list of USA404EDIStatusInquiry event<br>
	 * Confimr Message Send Popup
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search02USA404EDIStatusInquiry(Event e) throws EventException {
		EsdTrs0028Event event = (EsdTrs0028Event) e;
		EventResponse eventResponse = null;
		try {
			USA404EDIStatusInquiryBC command = new USA404EDIStatusInquiryBCImpl();
			eventResponse = command.search02USA404EDIStatusInquiry(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry the list of USA404EDIStatusInquiry event<br>
	 * Confimr Message Send Popup
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFaxNoVndrEmlByVndrSeq(Event e) throws EventException {
		EsdTrs0028Event event = (EsdTrs0028Event) e;
		EventResponse eventResponse = null;
		try {
			USA404EDIStatusInquiryBC command = new USA404EDIStatusInquiryBCImpl();
			eventResponse = command.searchFaxNoVndrEmlByVndrSeq(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Multi-process of USA404EDIStatusInquiry event<br>
	 * 404EDI CONFIM MESSAGE Send
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multi01USA404EDIStatusInquiry(Event e) throws EventException {
		EsdTrs0028Event event = (EsdTrs0028Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			USA404EDIStatusInquiryBC command = new USA404EDIStatusInquiryBCImpl();
			command.multi01USA404EDIStatusInquiry(event);
			command.faxEdiSend(event);
			command.emailEdiSend(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Multi-process of USA404EDIStatusInquiry event<br>
	 * 404EDI Send
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiUSA404EDIStatusInquiry(Event e) throws EventException {
		EsdTrs0028Event event = (EsdTrs0028Event) e;
		boolean isSendFlag = false;

		EventResponse eventResponse = null;
		EventResponse eventResponseSub = null;
		EventResponse eventResponseKleinSchmit = null;

		GeneralEventResponse eventResponseReturn = new GeneralEventResponse();
		USA404EDIStatusInquiryBC command = new USA404EDIStatusInquiryBCImpl();
		ReplanManageBC replanManageBC = new ReplanManageBCImpl();

		try {
			begin();
			eventResponse = command.multiUSA404EDIStatusInquiry(event);
			TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
			for (int i = 0; i < model.length; i++) {
				if (model[i].getCgoTpCd().equals("F") && !("Y".equals(model[i].getUplnSoFlg())) && !("Y".equals(model[i].getTrspFrstFlg()))) {
					model[i].setTrspSoStsCd("I");
					replanManageBC.modifySoList(model[i]);
				}
			}
			eventResponseSub = command.search03USA404EDIStatusSend(eventResponse.getRsVoList());
			eventResponseKleinSchmit = command.searchFlatFileKleinSchmitRailBill(eventResponse.getRsVoList(), "N");
			if (eventResponseSub != null && eventResponseSub.getRs().getRowCount() > 0) {
				command.search03SubUSA404EDIStatusSend(eventResponseSub.getRs());
				isSendFlag = true;
			}
			if (eventResponseKleinSchmit != null && eventResponseKleinSchmit.getRs().getRowCount() > 0) {
				command.ediSendKleinSchmitRailBill(eventResponseKleinSchmit.getRs());
				isSendFlag = true;
			}
			if (!isSendFlag) {
				throw new Exception(new ErrorHandler("TRS00015").getMessage());
			}
			commit();
		} catch (Exception de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponseReturn;
	}

	/**
	 * Multi-process of USA404EDIStatusInquiry event<br>
	 * 404EDI Cancellation EDI Send
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multi02USA404EDIStatusInquiry(Event e) throws EventException {
		EsdTrs0028Event event = (EsdTrs0028Event) e;
		EventResponse eventResponse = null;
		EventResponse eventResponseSub = null;
		EventResponse eventResponseKleinSchmit = null;

		GeneralEventResponse eventResponseReturn = new GeneralEventResponse();
		USA404EDIStatusInquiryBC command = new USA404EDIStatusInquiryBCImpl();
		ReplanManageBC replanManageBC = new ReplanManageBCImpl();
		try {
			begin();
			String userId = event.getSignOnUserAccount().getUsr_id();
			eventResponse = command.multi02USA404EDIStatusInquiry(event);
			TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
			for (int i = 0; i < model.length; i++) {
				if (model[i].getCgoTpCd().equals("F")) {
					if (model[i].getWoRjctRsn().equals("RBB")) { // Request By BKG
						// COA I/F
						CostAssignBC coaCommand = new CostAssignBCImpl();
						CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
						coaBkgComIfVo.setBkgNo(model[i].getBkgNo());
						coaBkgComIfVo.setCostSrcSysCd("TRS");// SUB SYSTEM CODE : TRS, TES, SCE, BKG etc
						coaBkgComIfVo.setIfRmk("US RAIL 404 EDI CANCEL");
						coaBkgComIfVo.setCreUsrId(userId);
						coaBkgComIfVo.setUpdUsrId(userId);

						int result_cnt = coaCommand.modifyCoaCommonInterface(coaBkgComIfVo);
						if (result_cnt < 0) {
							throw new EventException((new ErrorHandler("SAQ00099", new String[] { "COA I/F Error" })).getMessage());
						}
						model[i].setTrspSoStsCd("D");
					} else {
						model[i].setTrspSoStsCd("C");
					}

					if (!("Y".equals(model[i].getUplnSoFlg())) && !("Y".equals(model[i].getTrspFrstFlg()))) {
						// COP TRS S/O Status Update
						replanManageBC.modifySoList(model[i]);
					}
				}
			}

			eventResponseSub = command.search04USA404EDIStatusSend(eventResponse.getRsVoList()); // EDI 404 Search
			eventResponseKleinSchmit = command.searchFlatFileKleinSchmitRailBill(eventResponse.getRsVoList(), "C");
			command.multi02USA404EDIStatusInquiryRBB(event);

			boolean isSendFlag = false;
			if (eventResponseSub != null && eventResponseSub.getRs().getRowCount() > 0) {
				command.search04SubUSA404EDIStatusSend(eventResponseSub.getRs()); // EDI 404
				isSendFlag = true;
			}
			if (eventResponseKleinSchmit != null && eventResponseKleinSchmit.getRs().getRowCount() > 0) {
				command.ediSendKleinSchmitRailBill(eventResponseKleinSchmit.getRs());
				isSendFlag = true;
			}
			if (!isSendFlag) {
				throw new EventException(new ErrorHandler("TRS00015").getMessage());
			}
			commit();

			// MULTI02
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponseReturn;
	}

	/**
	 * Multi-process of USA404EDIStatusInquiry event<br>
	 * FRUSTRATE
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multi03USA404EDIStatusInquiry(Event e) throws EventException {
		EsdTrs0028Event event = (EsdTrs0028Event) e;
		GeneralEventResponse eventResponseReturn = new GeneralEventResponse();
		USA404EDIStatusInquiryBC command = new USA404EDIStatusInquiryBCImpl();
		ReplanManageBC replanManageBC = new ReplanManageBCImpl();
		try {
			begin();
			event.setUserId(account.getUsr_id());
			command.multi03USA404EDIStatusInquiry(event);
			TrsTrspEdiRailOrdVO[] model = event.getTrsTrspEdiRailOrdVOS();
			for (int i = 0; i < model.length; i++) {
				if (model[i].getCgoTpCd().equals("F")) {
					model[i].setTrspSoStsCd("F");
					replanManageBC.modifySoList(model[i]); // COP TRS S/O Status Update
				}
			}
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponseReturn;
	}

	/**
	 * Multi-process of multiUS404EDIResend(US Rail Correction) event<br>
	 * EDI RESEND (404EDI)
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse multiUS404EDIResend(Event e) throws EventException {
		EsdTrs0028Event event = (EsdTrs0028Event) e;
		EventResponse eventResponse = null;
		EventResponse eventResponseSub = null;
		EventResponse eventResponseKleinSchmit = null;
		GeneralEventResponse eventResponseReturn = new GeneralEventResponse();
		USA404EDIStatusInquiryBC command = null;
		try {
			command = new USA404EDIStatusInquiryBCImpl();
			begin();
			eventResponse = command.modifyUS404EDIResendRailBilOrd(event);
			eventResponseSub = command.searchUS404EDIResendList(eventResponse.getRsVoList()); // EDI 404 Search
			eventResponseKleinSchmit = command.searchFlatFileKleinSchmitRailBill(eventResponse.getRsVoList(), "N");

			boolean isSendFlag = false;
			if (eventResponseSub != null && eventResponseSub.getRs().getRowCount() > 0) {
				command.resendUS404EDIResend(eventResponseSub.getRs());
			}
			if (eventResponseKleinSchmit != null && eventResponseKleinSchmit.getRs().getRowCount() > 0) {
				command.ediSendKleinSchmitRailBill(eventResponseKleinSchmit.getRs());
				isSendFlag = true;
			}
			if (!isSendFlag) {
				throw new EventException(new ErrorHandler("TRS00015").getMessage());
			}
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			this.addUSA404EDIResendRollback(event);
			throw new EventException(de.getMessage());
		}
		return eventResponseReturn;
	}

	/**
	 * Multi-process of USA404EDIStatusInquiry event<br>
	 * 404EDI Send
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse addUSA404EDIResendRollback(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			USA404EDIStatusInquiryBC command = new USA404EDIStatusInquiryBCImpl();
			command.addUSA404EDIResendRollback(e);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring the list of PreDispatchStatus event<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreDispatchStatus(Event e) throws EventException {
		EsdTrs0020Event event = (EsdTrs0020Event) e;
		EventResponse eventResponse = null;
		try {
			PreDispatchStatusBC command = new PreDispatchStatusBCImpl();
			eventResponse = command.searchPreDispatchStatus(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring the list of PreDispatchStatus event<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search01PreDispatchStatus(Event e) throws EventException {
		EsdTrs0020Event event = (EsdTrs0020Event) e;
		EventResponse eventResponse = null;
		try {
			PreDispatchStatusBC command = new PreDispatchStatusBCImpl();
			eventResponse = command.search01PreDispatchStatus(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring the list of PreDispatchSentHistory event<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPreDispatchSentHistory(Event e) throws EventException {
		EsdTrs0021Event event = (EsdTrs0021Event) e;
		EventResponse eventResponse = null;
		try {
			PreDispatchSentHistoryBC command = new PreDispatchSentHistoryBCImpl();
			eventResponse = command.searchPreDispatchSentHistory(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring the list of PreDispatchSentHistory event<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse search01PreDispatchSentHistory(Event e) throws EventException {
		EsdTrs0021Event event = (EsdTrs0021Event) e;
		EventResponse eventResponse = null;

		try {
			PreDispatchSentHistoryBC command = new PreDispatchSentHistoryBCImpl();
			eventResponse = command.search01PreDispatchSentHistory(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring the list of More Candidates event<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMoreCandidates(Event e) throws EventException {
		EsdTrs0921Event event = (EsdTrs0921Event) e;
		EventResponse eventResponse = null;
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = command.searchMoreCandidates(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Save USRail More Candidates event<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse multiUSRailMoreCandidates(Event e) throws EventException {
		EsdTrs0026Event event = (EsdTrs0026Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		USA404EDIStatusInquiryBC command = new USA404EDIStatusInquiryBCImpl();

		try {
			begin();
			command.multiUSRailMoreCandidates(event);
			commit();
		} catch (EventException de) {
			rollback();
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring the list of USRail More Candidates event<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSRailMoreCandidates(Event e) throws EventException {
		EsdTrs0026Event event = (EsdTrs0026Event) e;
		EventResponse eventResponse = null;
		try {
			USA404EDIStatusInquiryBC command = new USA404EDIStatusInquiryBCImpl();
			eventResponse = command.searchUSRailMoreCandidates(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring the list of USRail Basic Rates event<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUSRailBasicRates(Event e) throws EventException {
		EsdTrs0027Event event = (EsdTrs0027Event) e;
		EventResponse eventResponse = null;
		try {
			USA404EDIStatusInquiryBC command = new USA404EDIStatusInquiryBCImpl();
			eventResponse = command.searchUSRailBasicRates(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiring the event of WorkOrder Preview event<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse searchSODeleteCheck(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		EventResponse eventResponse = null;
		try {
			WorkOrderPreviewBC command = new WorkOrderPreviewBCImpl();
			eventResponse = command.searchSODeleteCheck(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Loading the list of 3RD PARTY BASIC INTERFACE BILLING CASE. <br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBillingCaseCode() throws EventException {
		GeneralEventResponse eventResponse = null;
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = (GeneralEventResponse) command.searchBillingCaseCode();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Loading the list of 3RD PARTY BASIC INTERFACE BILLING CASE.<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTpbBasicAmt(Event e) throws EventException {
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		GeneralEventResponse eventResponse = null;
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = (GeneralEventResponse) command.searchTpbBasicAmt(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of WorkOrderCCManage page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */

	private EventResponse searchWoIssuedSoList(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = command.searchWoIssuedSoList(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of WorkOrderCCManage page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */

	private EventResponse searchWOStsCDCheck(Event e) throws EventException {
		EventResponse eventResponse = null;
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = command.searchWOStsCDCheck(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * Inquiry event process of S/P Select page<br>
	 * @param e
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMdmOrganization(Event e) throws EventException {
		EsdTrs0921Event event = (EsdTrs0921Event) e;
		EventResponse eventResponse = null;
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = command.searchMdmOrganization(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

	/**
	 * COA Interface process of WorkOrderPreview page<br>
	 * @param bkgNo
	 * @param usrId
	 * @throws EventException
	 */
	public void modifyCoaCommonInterface(String bkgNo, String usrId) throws EventException {
		try {
			CostAssignBC coaCommand = new CostAssignBCImpl();
			CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
			coaBkgComIfVo.setBkgNo(bkgNo);
			coaBkgComIfVo.setCostSrcSysCd("TRS");// TRS, TES, SCE and BKG etc. SUB SYSTEM CODE
			coaBkgComIfVo.setIfRmk("S/O Modify");
			coaBkgComIfVo.setCreUsrId(usrId);
			coaBkgComIfVo.setUpdUsrId(usrId);

			int resultCnt = coaCommand.modifyCoaCommonInterface(coaBkgComIfVo);
			if (resultCnt < 0)
				throw new EventException((new ErrorHandler("SAQ00099", new String[] { "COA I/F Error" })).getMessage());

		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
	}

	/**
	 * retrieve Trs cmdetail
	 * @param e Event
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchTrsSvcOrdBkgChmHis(Event e) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0977Event event = (EsdTrs0977Event) e;
		try {
			WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
			eventResponse = command.searchTrsSvcOrdBkgChmHis(event);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * manage Trs Stcc
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse updateTrsSvcOrdBkgChmHis(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0977Event event = (EsdTrs0977Event) e;
		WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
		try {
			command.updateTrsSvcOrdBkgChmHis(event);
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * retrieve Trs Stcc
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchTrsStcc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0802Event event = (EsdTrs0802Event) e;
		USA404TrsStccBC command = new USA404TrsStccBCImpl();
		try {
			List<TrsStccVO> list = command.searchTrsStcc(event);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * manage Trs Stcc
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse manageTrsStcc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0802Event event = (EsdTrs0802Event) e;
		USA404TrsStccBC command = new USA404TrsStccBCImpl();

		try {
			begin();
			command.manageTrsStcc(event.getTrsStccVOs(), account);
			commit();
		} catch (EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESD_TRS_0429 : send<br>
	 * EDI Yard Setup이 되어있는지 확인합니다.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkEdiYardSetup(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0429Event event = (EsdTrs0429Event) e;
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		SearchRelredMasterForEdiVO cimCStockVO = new SearchRelredMasterForEdiVO();
		try {
			cimCStockVO.setEmptyCy(event.getCimCStockVO().getEmptyCy());
			cimCStockVO.setTrspCostDtlModCd(event.getCimCStockVO().getTrspCostDtlModCd());
			String ediYardSetup = command.checkEdiYardSetup(cimCStockVO);
			eventResponse.setETCData("edi_yard_setup", ediYardSetup);
			eventResponse.setETCData("yard_cd", event.getCimCStockVO().getEmptyCy());
		} catch (EventException ex) {
			log.error("\n\n[SC - searchRDContents] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("\n\n[SC - searchRDContents] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESD_TRS_0429 : btn_retrieve retrieving CimCStock IssueList
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIssueList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0429Event event = (EsdTrs0429Event) e;
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		try {
			eventResponse.setRsVoList(command.searchIssueList(event.getCimCStockVO()));
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESD_TRS_0429 : btn_settled settling CimCStock IssuedOrder
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse settleIssuedOrder(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0429Event event = (EsdTrs0429Event) e;
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		try {
			begin();
			command.settleIssuedOrder(event.getCimCStockVOS(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESD_TRS_0429 : Validation getting FAX No and Email for Yard Code
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse getYardFaxEmailInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0429Event event = (EsdTrs0429Event) e;
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		try {
			String[] returnValues = command.getYardFaxEmailInfo(event.getCimCStockVO().getEmptyCy());
			eventResponse.setETCData("ydCd", returnValues[0]);
			eventResponse.setETCData("faxNo", returnValues[1]);
			eventResponse.setETCData("ydEml", returnValues[2]);
		} catch (EventException ex) {
			log.error("\n\n[SC - getYardFaxEmailInfo] EventException :  " + ex.getMessage(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("\n\n[SC - getYardFaxEmailInfo] Exception :  " + ex.getMessage(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESD_TRS_0451 : onload retrieving RD contents
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRDContent(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0451Event event = (EsdTrs0451Event) e;
		RDFaxMailEAIVO rdFaxMailEAIVO = event.getRDFaxMailEAIVO();
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		try {
			event.getCimCStockVOS()[0].setUserId(rdFaxMailEAIVO.getSenderUsrId());
			event.getCimCStockVOS()[0].setUserOfc(rdFaxMailEAIVO.getSenderUsrOfc());
			event.getCimCStockVOS()[0].setUserCnt(rdFaxMailEAIVO.getSenderUsrCnt());
			event.getCimCStockVOS()[0].setEmail(rdFaxMailEAIVO.getReceiverEml());
			event.getCimCStockVOS()[0].setFaxNo(rdFaxMailEAIVO.getReceiverFax());
			eventResponse.setETCData("RD", command.searchRDContent(event.getCimCStockVOS()));
		} catch (Exception ex) {
			log.error("\n\n[SC - searchRDContents] Exception :  " + ex.getMessage(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * ESD_TRS_0973
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchJoEdiHistory(Event e) throws EventException {
		VendorCmBC command = new VendorCmBCImpl();
		try {
			return command.searchJoEdiHistory(e);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESD_TRS_0972
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchJoEdiRcvMsgList(Event e) throws EventException {
		VendorCmBC command = new VendorCmBCImpl();
		try {
			return command.searchJoEdiRcvMsgList(e);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESD_TRS_0972
	 * @param e
	 * @return
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse multipleAccept(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VendorCmBC command = new VendorCmBCImpl();
		WorkOrderPreviewBC orderPreviewBC = new WorkOrderPreviewBCImpl();
		try {
			ArrayList ffList = command.multipleAccept(e);
			String[] ffArray;
			for (int i = 0; i < ffList.size(); i++) {
				ffArray = (String[]) ffList.get(i);
				if (ffArray != null) {
					orderPreviewBC.sendFlatMessage(ffArray[1]);
				}
				ffArray = null;
			}
			return eventResponse;
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * ESD_TRS_0972
	 * @param e
	 * @return
	 * @throws EventException
	 */
	@SuppressWarnings("rawtypes")
	private EventResponse multipleReject(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		VendorCmBC command = new VendorCmBCImpl();
		WorkOrderPreviewBC orderPreviewBC = new WorkOrderPreviewBCImpl();
		try {
			ArrayList ffList = command.multipleReject(e);
			String[] ffArray;
			for (int i = 0; i < ffList.size(); i++) {
				ffArray = (String[]) ffList.get(i);
				if (ffArray != null) {
					orderPreviewBC.sendFlatMessage(ffArray[1]);
				}
				ffArray = null;
			}
			return eventResponse;
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse sendReleaseRedeliveryFaxEmail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0429Event event = (EsdTrs0429Event) e;
		EmptyReleaseRedeliveryOrderMgtBC command = new EmptyReleaseRedeliveryOrderMgtBCImpl();
		List<CimCStockVO> manageList = new ArrayList<CimCStockVO>();
		String[] returnValues = null;
		String sendFaxMailKey = null;
		String mailTitle = null;
		String xFileNm = null;
		SearchRelredMasterForEdiVO cimCStockVO = new SearchRelredMasterForEdiVO();
		boolean relredEdiSent = false; // RELRED EDI Resend여부 확인을 위한 변수

		try {
			String userLoc = command.getUserLocCd(event.getRDFaxMailEAIVO().getSenderUsrId());
			String issueType = null;
			for (int i = 0; i < event.getCimCStockVOS().length; i++) {
				begin();
				event.getCimCStockVOS()[i].setType(event.getCimCStockVOS()[0].getType());
				event.getCimCStockVOS()[i].setIssueFlag(event.getCimCStockVOS()[0].getIssueFlag());
				event.getCimCStockVOS()[i].setIssueType(event.getCimCStockVOS()[0].getIssueType());
				event.getCimCStockVOS()[i].setUserId(event.getRDFaxMailEAIVO().getSenderUsrId());
				event.getCimCStockVOS()[i].setUserOfc(event.getRDFaxMailEAIVO().getSenderUsrOfc());
				event.getCimCStockVOS()[i].setUserLoc(userLoc);
				manageList = new ArrayList<CimCStockVO>();
				if ("RLS".equals(event.getCimCStockVOS()[0].getType())) {
					manageList.add(event.getCimCStockVOS()[i]);
				} else {
					if ("RDV".equals(event.getCimCStockVOS()[0].getType()) && "M".equals(event.getCimCStockVOS()[i].getTypeCd()) && "I".equals(event.getCimCStockVOS()[0].getIssueFlag())) {
						returnValues = command.getSoOfcNextVal(event.getRDFaxMailEAIVO().getSenderUsrOfc());
						event.getCimCStockVOS()[i].setSoOfcCtyCd(returnValues[0]);
						event.getCimCStockVOS()[i].setSoSeq(returnValues[1]);
					}
					manageList.add(event.getCimCStockVOS()[i]);
				}
				if (manageList == null || manageList.size() < 1) {
					throw new EventException(new ErrorHandler("There is no issue data.").getMessage());

				} else {
					issueType = event.getCimCStockVOS()[0].getIssueType();
					if ("F".equals(issueType) || "E".equals(issueType)) {
						if (i == 0) {
							if ("R".equals(event.getCimCStockVOS()[0].getTypeCd())) { // Empty Release/Redelivery Order(MTY)
								if ("RLS".equals(event.getCimCStockVOS()[0].getType())) { // Release
									mailTitle = "EMPTY RELEASE ORDER";
									xFileNm = "EMPTYRELEASEORDER";
								} else { // Redelivery
									mailTitle = "EMPTY REDELIVERY ORDER";
									xFileNm = "MTYDELIVERYORDER";
								}
							} else {
								if ("RLS".equals(event.getCimCStockVOS()[0].getType())) { // Release
									if ("DR".equals(event.getCimCStockVOS()[0].getTrspCostDtlModCd())) { // Empty Release Order(FULL)
										mailTitle = "EMPTY RELEASE ORDER";
										xFileNm = "EMPTYRELEASEORDER";
									} else { // Full Release Order
										mailTitle = "FULL RELEASE ORDER";
										xFileNm = "FULLRELEASEORDER";
									}
								} else { // Redelivery
									if ("DR".equals(event.getCimCStockVOS()[0].getTrspCostDtlModCd())) { // Empty Redelivery Order(FULL)
										mailTitle = "EMPTY REDELIVERY ORDER";
										xFileNm = "MTYDELIVERYORDER";
									} else { // Full Restitution Order
										mailTitle = "FULL RESTITUTION ORDER";
										xFileNm = "FULLRESTITUTIONORDER";
									}
								}
							}
							String rdBkgNo = manageList.get(manageList.size() - 1).getBkgNo(); // BKG No.
							String rdRefId = manageList.get(manageList.size() - 1).getRefId(); // MTY Reference No.
							event.getRDFaxMailEAIVO().setXfileNm(xFileNm);
							if (!CheckUtilities.isInBlank(rdBkgNo)) { // BKG No 가 없을 경우 MTY Reference No 를 사용
								event.getRDFaxMailEAIVO().setTitle(mailTitle + " for Shipment reference " + rdBkgNo);
							} else {
								event.getRDFaxMailEAIVO().setTitle(mailTitle + " for Shipment reference " + rdRefId);
							}
							event.getRDFaxMailEAIVO().setReceiverNm(command.getYardFaxEmailInfo(event.getCimCStockVOS()[0].getEmptyCy())[3]);
							sendFaxMailKey = command.rdFaxMailSend(event.getCimCStockVOS()[0].getIssueType(), event.getRDFaxMailEAIVO());
						}
						if (sendFaxMailKey != null && !"".equals(sendFaxMailKey)) {
							for (int h = 0; h < manageList.size(); h++) {
								if ("F".equals(issueType)) {
									manageList.get(h).setFaxSndNo(sendFaxMailKey);
								} else {
									manageList.get(h).setEmlSndNo(sendFaxMailKey);
								}
							}
						}
					} else if ("D".equals(event.getCimCStockVOS()[i].getIssueType()) && !relredEdiSent) {
						/* D일 때 RELRED EDI 송신 */
						List<AbstractValueObject> list = new ArrayList<AbstractValueObject>();
						if ("RLS".equals(event.getCimCStockVOS()[i].getType())) { // MTRELORD
							list.addAll(command.searchRelRedMasterData(event.getCimCStockVOS()[i], "RLS"));
						} else if ("RDV".equals(event.getCimCStockVOS()[i].getType())) { // MTRESORD
							list.addAll(command.searchRelRedMasterData(event.getCimCStockVOS()[i], "RDV"));
						}

						if (list.size() > 0) {
							cimCStockVO = (SearchRelredMasterForEdiVO) list.get(0);
							command.resendEdi(cimCStockVO, event.getCimCStockVOS()); // RELRED EDI Resend
							relredEdiSent = true; // Mark RELRED EDI as Resent
						}
					}

					command.sendReleaseRedeliveryFaxEmail(manageList);
				}
				commit();
			}

		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * Process of FRUSTRATING<br>
	 * Inquiry event process of WorkOrderCCManage page<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse updateCYContainerNo(Event e) throws EventException {
		EsdTrs0023Event event = (EsdTrs0023Event) e;
		WorkOrderIssueBC command = new WorkOrderIssueBCImpl();
		WorkOrderManagementBC workOrderManagementBC = new WorkOrderManagementBCImpl();
		try {
			List<WoIssueListVO> vos = command.updateCYContainerNo(event);
			if (!vos.isEmpty()) {
				String loginUsrId = e.getSignOnUserAccount().getUsr_id();
				for (WoIssueListVO vo : vos) {
					workOrderManagementBC.modifyWorkOrderExecuteDateByTrs(vo.getTrspSoOfcCtyCd(), vo.getTrspSoSeq(), vo.getTrspWoOfcCtyCd(), vo.getTrspWoSeq(), null, vo.getBkgNo(), loginUsrId);
				}
			}
			return new GeneralEventResponse();
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
	}

	/**
	 * retrieve Trs cmdetail
	 * @param e Event
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchTrsSubStsHis(Event e) throws EventException {
		EventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0983Event event = (EsdTrs0983Event) e;
		try {
			WorkOrderManagementBC command = new WorkOrderManagementBCImpl();
			eventResponse = command.searchTrsSubStsHis(event);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * [ESD_TRS_0029] download포맷의 W/O BFI Management 를 조회합니다. <br>
	 * @param WorkOrderBFIManagementVO workOrderBFIManagementVO
	 * @return List<WorkOrderBFIManagementVO>
	 * @exception DAOException
	 */
	private EventResponse searchWorkOrderBFIDownForInvoice(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0029Event event = (EsdTrs0029Event) e;
		WorkOrderManagementBC command = new WorkOrderManagementBCImpl();
		WorkOrderBFIManagementVO workOrderBFIManagementVO = event.getWorkOrderBFIManagementVO();
		try {
			eventResponse.setRsVoList(command.searchWorkOrderBFIDownForInvoice(workOrderBFIManagementVO));
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * [ESD_TRS_0029] W/O BFI Management 를 조회 후 cvs 변환/첨부하여 S/P에게 email로 발송합니다. <br>
	 * @param EsdTrs0029Event event
	 * @return EventResponse
	 * @exception DAOException
	 */
	private EventResponse sendBFIManagementByEmail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsdTrs0029Event event = (EsdTrs0029Event) e;
		WorkOrderManagementBC command = new WorkOrderManagementBCImpl();

		WorkOrderBFIManagementVO workOrderBFIManagementVO = event.getWorkOrderBFIManagementVO();

		if (workOrderBFIManagementVO != null) {
			log.debug("\n======================================================================");
			log.debug("\n VO : " + workOrderBFIManagementVO.getVndrSeq());
			// check vendor's email address exists or not
			try {
				int cnt = command.checkVndrPrmrCntcPntEmailAddr(workOrderBFIManagementVO);
				if (cnt > 0) {
					throw new EventException(new ErrorHandler("There is a vendor without e-mail setup in MDA. Please modify and proceed.").getMessage());
				}
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage());
			}

			// retrieve vendor sequence number for removing duplicated data
			String[] vndrSeqs = null;
			try {
				vndrSeqs = command.searchVendorList(workOrderBFIManagementVO);
			} catch (DAOException ex) {
				throw new EventException(new ErrorHandler(ex).getMessage());
			}
			// Set<String> vndrSeqs = new HashSet<String>(Arrays.asList(workOrderBFIManagementVO.getVndrSeq().split(",")));
			log.debug("\n Array : " + vndrSeqs.toString());
			log.debug("\n======================================================================");

			// send email by vendor
			if (vndrSeqs != null) {
				for (String vndrSeq : vndrSeqs) {
					workOrderBFIManagementVO.setVndrSeq(vndrSeq);

					try {
						begin();
						command.sendBFIManagementByEmail(workOrderBFIManagementVO);
						// List<WorkOrderBFIManagementVO> workOrderBFIManagementVOs = command.sendBFIManagementByEmail(workOrderBFIManagementVO);
						// eventResponse.setRsVoList(workOrderBFIManagementVOs);
						commit();
					} catch (EventException ex) {
						rollback();
						log.error("err " + ex.toString(), ex);
						throw new EventException(new ErrorHandler(ex).getMessage());
					} catch (Exception ex) {
						rollback();
						log.error("err " + ex.toString(), ex);
						throw new EventException(new ErrorHandler(ex).getMessage());
					}
				}
			}

		} else {
			throw new EventException("Requested information is invalid.");
		}
		return eventResponse;
	}

	/**
	 * Issue multiple work order<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse issueMultipleWorkOrder(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			WorkOrderPreviewVO[] vo = event.getWorkOrderPreviewVOs();
			int cnt = vo.length;
			for (int i = 0; i < cnt; i++) {
				event.setWorkOrderPreviewVO(vo[i]);
				addWorkOrderPreview(event);
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * Re-issue multiple work order<br>
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse reissueMultipleWorkOrder(Event e) throws EventException {
		EsdTrs0024Event event = (EsdTrs0024Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			WorkOrderPreviewVO[] vo = event.getWorkOrderPreviewVOs();
			int cnt = vo.length;
			for (int i = 0; i < cnt; i++) {
				event.setWorkOrderPreviewVO(vo[i]);
				addWorkOrderPreviewIssued(event);
			}
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}
}
