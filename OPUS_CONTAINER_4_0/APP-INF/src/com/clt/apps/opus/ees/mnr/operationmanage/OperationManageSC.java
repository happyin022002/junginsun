/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : OperationManageSC.java
 *@FileTitle : Operation Manage
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier :
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.basic.ExpenseMgtBC;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.basic.ExpenseMgtBCImpl;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.PayableINVInquiryINVO;
import com.clt.apps.opus.ees.mnr.accountmanage.expensemgt.vo.PayableInvoiceGRPVO;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.basic.TariffMgtBC;
import com.clt.apps.opus.ees.mnr.agreementmanage.tariffmgt.basic.TariffMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.basic.HangerInventoryMgtBC;
import com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.basic.HangerInventoryMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.hangerinventorymgt.vo.HangerInventoryListGRPVO;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.basic.PartnerMgtBC;
import com.clt.apps.opus.ees.mnr.generalmanage.partnermgt.basic.PartnerMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.basic.StatusHistoryMgtBC;
import com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.basic.StatusHistoryMgtBCImpl;
import com.clt.apps.opus.ees.mnr.generalmanage.statushistorymgt.vo.StatusHistoryGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.basic.GeneralCodeCheckMgtBC;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.basic.GeneralCodeCheckMgtBCImpl;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.GeneralCodeCheckMgtGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.basic.GeneralCodeSearchMgtBC;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.basic.GeneralCodeSearchMgtBCImpl;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.BkgTrdCodeVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeGRPVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CostCodeINVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomCostCodeVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodesearchmgt.vo.CustomMnrEqStsVVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBC;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.basic.InterfaceMgtBCImpl;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrOrdTmpDtlVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrOrdTmpHdrVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.CustomMnrRprRqstTmpHdrVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.DocResultVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.IFMnrFlagVO;
import com.clt.apps.opus.ees.mnr.mnrcommon.interfacemgt.vo.InterfaceGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.basic.DisposalMgtBC;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.basic.DisposalMgtBCImpl;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnr0156Event;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnr0157Event;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnr0159Event;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnr0160Event;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnr0163Event;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnr0164Event;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnr0200Event;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnr0220Event;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnr0221Event;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnr0235Event;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnrS301Event;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnrS304Event;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.event.EesMnrS308Event;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.CustomMyBiddingHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalInquiryGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalPriceFileListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.DisposalSoldGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.MyBiddingGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.MyBiddingINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.disposalmgt.vo.SoldEQFileListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBC;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.basic.EQFlagMgtBCImpl;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0109Event;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0111Event;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0122Event;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0125Event;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0139Event;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0151Event;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event.EesMnr0158Event;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.event.EesMnrS122Event;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqRngStsVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrEqStsVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.CustomMnrFlgHisVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.DisposalCandidateFlagGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.VerifyEQFlagFileListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.basic.ExtraDisposalMgtBC;
import com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.basic.ExtraDisposalMgtBCImpl;
import com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.event.EesMnr0093Event;
import com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.event.EesMnr0094Event;
import com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.vo.CustomMnrXtraDispVO;
import com.clt.apps.opus.ees.mnr.operationmanage.extradisposalmgt.vo.ExtraDisposalMgtGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.basic.RepairMgtBC;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.basic.RepairMgtBCImpl;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0019Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0022Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0023Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0027Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0028Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0030Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0032Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0036Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0052Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0054Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0055Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0058Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0191Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0192Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0194Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0211Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0219Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0226Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0227Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0228Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0240Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0243Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0247Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnr0248Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnrS019Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnrS027Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnrS028Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnrS032Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event.EesMnrS232Event;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomDocHeaderVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomESTWOMainINFOVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.DocGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EDIInvoiceParkingLotDTLDataVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EDIInvoiceParkingLotGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EDIInvoiceParkingLotHDRDataVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EQWorkOrderHistoryListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.ESTWOMainGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.GeneralWOGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.GeneralWOINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.RepairCollectionGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.RepairResultGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.RepairResultINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.RepairResultListVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.SparePartWOGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.VerifyEQTypeSizeFlagFileListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.VerifyRPRCreateFileListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.WONoInquiryListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.basic.TotalLossMgtBC;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.basic.TotalLossMgtBCImpl;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.event.EesMnr0095Event;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.event.EesMnr0096Event;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.event.EesMnr0098Event;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.event.EesMnr0105Event;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.event.EesMnr0195Event;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.event.EesMnr0234Event;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.CustomMnrTtlLssRqstDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.TotalLossGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.TotalLossInfoGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.totallossmgt.vo.TotalLossLessorReportVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * COM-OperationManage Business Logic ServiceCommand - COM-OperationManage business transaction dispose
 *
 * @author
 * @see GeneralCodeCheckMgtBC
 * @since J2EE 1.4
 */
 
public class OperationManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * OperationManage system - begin business processing<br>
	 * EES_MNR_0139 create object<br>
	 */
	public void doStart() {
		log.debug("Begin OperationManageSC");
		try {
			//Assign login information
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * OperationManage system - end business processing<br>
	 * EES_MNR_0139 release object<br>
	 */
	public void doEnd() {
		log.debug("End OperationManageSC");
	}

	/**
	 * do processing case of event<br>
	 * COM-OperationManage system - do processing case of business all event<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// Event handling part of SC
		if (e.getEventName().equalsIgnoreCase("EesMnr0139Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = verifyEQFlagFileListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0122Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEQFlagListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEQFlagHistoryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEQFlagListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = searchCntrOpStatusService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0125Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEQFlagHistoryListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEstimateSMRListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = verifyEstimateCalcService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = manageEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = requestEstimateService(e);
			}  else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = searchESTNextVerNoListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0191Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEQWorkOrderHistoryListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0194Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWOInfoListBySparePartService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0055Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWOInfoListBySparePartService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0211Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchWONoInquiryListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0058Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExtraWOService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageExtraWOService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getBzcAmtService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeWOService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0227Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExtraWOService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getBzcAmtService(e);
			}
		} else	if (e.getEventName().equalsIgnoreCase("EesMnr0219Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = verifyWOFileListService(e);
			}
		} else	if (e.getEventName().equalsIgnoreCase("EesMnr0220Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = verifyDisposalPriceFileListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0052Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSimpleWOService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageSimpleWOService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getBzcAmtService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeWOService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0226Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchSimpleWOService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getBzcAmtService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0054Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRFSpareWOService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRFSpareWOService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getBzcAmtService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeWOService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0228Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRFSpareWOService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getBzcAmtService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairResultListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRepairResultService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = getBzcAmtService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0109Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEQFlagListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageHangerRackBarService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0151Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalCandidateListFlagService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDisposalCandidateFlagService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0158Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalCandidatePopupListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0111Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEQFlagHistoryListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0036Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDocSendService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDocSendService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0192Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEstimateByEQService(e);
			}
		//Estimate Auditing
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0023Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEstimateSMRListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = verifyEstimateCalcService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = counterOfferEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = rejectEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = approvalEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = manageEstimateAuditItLaterService(e);
			}
		//Estimate EDI Auditing
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0240Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEstimateSMRListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = verifyEstimateCalcService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = counterOfferEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = rejectEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = approvalEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = manageEstimateAuditItLaterService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0030Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchESTWorkOrderListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchESTWorkOrderDetailListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createESTWOCreationService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0022Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchESTGroupAuditListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = manageESTGroupAuditListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = manageESTGroupAuditListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0027Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairInquiryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = manageEstimateCancelService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = manageRepairDeleteService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairInquiryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = manageEstimateCancelService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = manageRepairDeleteService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0093Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExtraDisposalByEQService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkExtraDisposalByEQService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageExtraDisposalByEQService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0094Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchExtraDisposalListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0156Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchDSPPartnerService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = manageDisposalService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDisposalService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeDisposalService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0157Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = manageDisposalService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDisposalService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeDisposalService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0195Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTotalLossInfoByOFCListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0095Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTotalLossService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageTotalLossService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.REMOVE)){
				eventResponse = removeTotalLossGRPService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0098Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTotalLossListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTotalLossWithCLTService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageTotalLossService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.REMOVE)){
				eventResponse = removeTotalLossService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0234Event")) {
		    	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTotalLossWithCLTService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0160Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalSoldListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDisposalSoldDetailService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDispRlseNoService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDisposalSoldService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0164Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0163Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalInquiryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDisposalDetailInquiryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchDisposalCollectionInquiryListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0105Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTotalLossLessorReportListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0221Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = verifySoldEQFileListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0096Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchTotalLossListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTotalLossService(e);
			} else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = manageTotalLossService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0200Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDisposalService(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EesMnr0235Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageDisposalDocSendService(e);
			}
		//EDI & Excel Estimate Upload
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0243Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEstimateUploadService(e);
			}
		}
		//**************** SPP FUNCTION START ******************//
		else if (e.getEventName().equalsIgnoreCase("EesMnrS122Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEQFlagListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEQFlagListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnrS027Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairInquiryListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = manageRepairDeleteService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnrS019Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEstimateSMRListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = verifyEstimateCalcService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = manageEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = requestEstimateService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = searchESTNextVerNoListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnrS032Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairResultListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRepairResultService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnrS232Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = verifyRPRCreateFileListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnrS028Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRepairInquiryListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnrS308Event")) {
			if (e.getFormCommand().isCommand(FormCommand.INIT)) {
				eventResponse = searchPartnerListService(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDisposalInquiryListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnrS304Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMyBiddingHdrListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMyBiddingDtlListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMyBiddingDtlListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeMyBiddingDtlListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchMyBiddingLoaclTimeListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchMyBiddingStatusListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnrS301Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchMyBiddingHdrListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchMyBiddingDtlListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageMyBiddingDtlListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
				eventResponse = removeMyBiddingDtlListService(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchMyBiddingStatusListService(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EesMnr0247Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEDIInvoiceParkingLotHDRData(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchEDIInvoiceParkingLotDTLData(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageEDIInvoiceParkingLotHDRData(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageEDIInvoiceParkingLotConfirmData(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEDIInvoiceParkingLotHDRData(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EesMnr0248Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = verifySOLInvoiceFileImportData(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageSOLInvoiceFileImportData(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = searchComBackEndJobStatusService(e);
			}
		}

	
		//**************** SPP FUNCTION START ******************//		
		
		return eventResponse;
	}

	/**
	 * EES_MNR_0157 : Save <br>
	 * [EES_MNR_0157]add, modify, delete "Disposal Request" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDisposalService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DisposalMgtBC  command = new DisposalMgtBCImpl();
		EQFlagMgtBC    command3 = new EQFlagMgtBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DisposalGRPVO disposalGRPVO = null;

		if(e.getEventName().equalsIgnoreCase("EesMnr0156Event")){
			EesMnr0156Event event = (EesMnr0156Event)e;
			disposalGRPVO = event.getDisposalGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0157Event")){
			EesMnr0157Event event = (EesMnr0157Event)e;
			disposalGRPVO = event.getDisposalGRPVO();
		}

		try {
			if(disposalGRPVO != null){
				CustomMnrDispHdrVO customMnrDispHdrVO = disposalGRPVO.getCustomMnrDispHdrVO();
				customMnrDispHdrVO.setMnrPrnrEml(account.getUsr_eml());
				if(e.getEventName().equalsIgnoreCase("EesMnr0157Event") && customMnrDispHdrVO.getDispStsCd().equals("HC")){
					java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
					String today = formatter.format(new java.util.Date());
					customMnrDispHdrVO.setAproDt(today);
					customMnrDispHdrVO.setAproUsrId(account.getUsr_id());
				}
				disposalGRPVO.setCustomMnrDispHdrVO(customMnrDispHdrVO);
	
				begin();
	
				command3.manageEqStsMkrNmMdlNmBasic(disposalGRPVO, account);
				disposalGRPVO = command.manageDisposalBasic(disposalGRPVO,account);
	
				
				disposalGRPVO = command.searchDisposalListBasic(disposalGRPVO,account);
	
				//Case of DispStsCd == "HC"
				if(customMnrDispHdrVO.getDispStsCd().equals("HC")){
					command.addContractDisposalBuyerDTLBasic(disposalGRPVO);
					//Calculating data sum
					command.addDisposalCofirmSumBasic(disposalGRPVO);
				}
				commit();
	
				eventResponse.setETCData("disp_no",disposalGRPVO.getCustomMnrDispHdrVO().getDispNo());
				eventResponse.setRsVoList(disposalGRPVO.getCustomMnrDispHdrVOS());
			}
			return eventResponse;
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0098 : Delete <br>
	 * [EES_MNR_0098] Delete Total Loss Collection & Inquiry data <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeTotalLossService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		TotalLossMgtBC command = new TotalLossMgtBCImpl();
		//HISTORY
		StatusHistoryMgtBC command5 = new StatusHistoryMgtBCImpl();
		StatusHistoryGRPVO statusHistoryGRPVO = new StatusHistoryGRPVO();

		EesMnr0098Event event = (EesMnr0098Event)e;
		TotalLossGRPVO totalLossGRPVO = event.getTotalLossGRPVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		PayableInvoiceGRPVO payableInvoiceGRPVO = new PayableInvoiceGRPVO();
		try {
			begin();
			int delCnt=0;
			int notDsCnt=0;
			int notDvCnt=0;
			CustomMnrTtlLssRqstDtlVO[]  arrayCustomMnrTtlLssRqstDtlVOs  = totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs();
			for ( int i = 0; i < arrayCustomMnrTtlLssRqstDtlVOs.length; i++ ) {
				//Increase count case of deleted DTL
				if(arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D"))delCnt++;
				//Increase count case of except "DV"
				if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV"))notDvCnt++;
				//Increase count case of except "DS"
				if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DS"))notDsCnt++;
			}
			InterfaceMgtBC command1 = new InterfaceMgtBCImpl();
			ExpenseMgtBC command2 = new ExpenseMgtBCImpl();
			for ( int i = 0; i < arrayCustomMnrTtlLssRqstDtlVOs.length; i++ ) {
				if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV")){
					/** Begin rollback CSR Temp Table *************************************************************/
					if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getInvRgstNo().equalsIgnoreCase("")
						&& arrayCustomMnrTtlLssRqstDtlVOs[i].getInvRgstNo().length()>=13 )
					{
						//AP_PAY_INV update DELT_FLG = 'Y'
						command1.removeCSRIFBasic(arrayCustomMnrTtlLssRqstDtlVOs[i].getInvRgstNo(), account);
						//MNR_PAY_INV_WRK delete where pay_inv_seq
						if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getPayInvSeq().equalsIgnoreCase(""))
						{
							PayableINVInquiryINVO payableINVInquiryINVO = new PayableINVInquiryINVO();
							payableINVInquiryINVO.setPayInvSeq(arrayCustomMnrTtlLssRqstDtlVOs[i].getPayInvSeq());
							payableInvoiceGRPVO.setPayableINVInquiryINVO(payableINVInquiryINVO);
							command2.removePayableInvoiceBasic(payableInvoiceGRPVO,account);
						}
					}
					/** End rollback CSR Temp Table ***************************************************************/
				}
			}
			//*************** FLAG for RollBack ************************* //
			EQFlagMgtBC command3 = new EQFlagMgtBCImpl();
			EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
			CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[arrayCustomMnrTtlLssRqstDtlVOs.length - notDvCnt];
			CustomMnrEqStsVO[] arrCustomMnrEqStsVOS2 = new CustomMnrEqStsVO[arrayCustomMnrTtlLssRqstDtlVOs.length - notDsCnt];
			CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[arrayCustomMnrTtlLssRqstDtlVOs.length -  notDvCnt];
			int flgCnt = 0; //DV, DV Expense tab flag count
			int flgCnt2 = 0;//DS,Dispsal tab flag count
			for ( int i = 0; i < arrayCustomMnrTtlLssRqstDtlVOs.length; i++ ) {

				if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV")
					|| arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DS"))
				{
					//STS VO
					CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
					customMnrEqStsVO.setEqNo(arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo());
					customMnrEqStsVO.setEqKndCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqKndCd());
					customMnrEqStsVO.setEqTpszCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqTpszCd());
					java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
					String today = formatter.format(new java.util.Date());
					customMnrEqStsVO.setMnrStsRmk("From Total Loss Management");
					if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV"))
					{
						//STS VO
						customMnrEqStsVO.setMnrDmgFlgDt(today);
						customMnrEqStsVO.setMnrDmgFlgYdCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssYdCd());
						customMnrEqStsVO.setMnrDmgFlg("0");
						arrCustomMnrEqStsVOS[flgCnt] = customMnrEqStsVO;

						//FLG_HIS_VO
						CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
						customMnrFlgHisVO.setEqNo(arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo());
						customMnrFlgHisVO.setEqKndCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqKndCd());
						customMnrFlgHisVO.setEqTpszCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqTpszCd());
						customMnrFlgHisVO.setMnrFlgYdCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssYdCd());
						customMnrFlgHisVO.setMnrFlgInpTpCd("T");
						customMnrFlgHisVO.setMnrFlgTpCd("TLL");
						customMnrFlgHisVO.setMnrFlgInpDt(today);
						customMnrFlgHisVO.setMnrFlgRmk("From Total Loss Management");
						customMnrFlgHisVO.setMnrStsFlg("N");
						arrCustomMnrFlgHisVOS[flgCnt] = customMnrFlgHisVO;
						flgCnt++;
					}
					else if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DS"))
					{
						//STS VO
						customMnrEqStsVO.setMnrDispSelFlgDt(today);
						customMnrEqStsVO.setMnrDispSelFlgYdCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssYdCd());
						customMnrEqStsVO.setMnrDispSelFlg("0");
						arrCustomMnrEqStsVOS2[flgCnt2] = customMnrEqStsVO;
						flgCnt2++;
					}
				}
			}
			EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
			eQFlagListINVO.setMnrFlgTpCd("TLL");
			eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
			eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
			eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
			command3.manageEQFlagListBasic(eQFlagListGRPVO,account);	//Damaged flag data ROLLBACK
			//*************** FLAG END   ************************* //

			/***************** MST - for outer interface call **********************/
			InterfaceMgtBC command4 = new InterfaceMgtBCImpl();
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
			// Total Loss Damage flag dispose
			for(int i = 0;i < arrCustomMnrEqStsVOS.length; i++){
				IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
				iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
				iFMnrFlagVO.setFlagUserId(account.getUsr_id());
				iFMnrFlagVO.setFlagType("TLL");
				iFMnrFlagVO.setRetireFlag("N");
				iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[i].getEqKndCd());
				iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDispFlgYdCd());
				iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[i].getEqNo());
				//Damage Flag
				if(arrCustomMnrEqStsVOS[i].getMnrDmgFlg().equals("1")){
					iFMnrFlagVO.setStsFlag("Y");
				} else {
					iFMnrFlagVO.setStsFlag("N");
				}
				iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[i].getMnrDmgFlgDt());
				iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDmgFlgYdCd());
				iFMnrFlagVOS.add(iFMnrFlagVO);
			}
			// Disposal Candidate Selection flag dispose
			for(int i = 0;i < arrCustomMnrEqStsVOS2.length; i++){
				IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
				iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
				iFMnrFlagVO.setFlagUserId(account.getUsr_id());
				iFMnrFlagVO.setFlagType("DSP");
				iFMnrFlagVO.setRetireFlag("N");
				iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS2[i].getEqKndCd());
				iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS2[i].getEqNo());
				//Disposal Flag
				if(arrCustomMnrEqStsVOS2[i].getMnrDispSelFlg().equals("1")){
					iFMnrFlagVO.setStsFlag("Y");
				} else {
					iFMnrFlagVO.setStsFlag("N");
				}
				iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS2[i].getMnrDispSelFlgDt());
				iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS2[i].getMnrDispSelFlgYdCd());
				iFMnrFlagVOS.add(iFMnrFlagVO);
			}
			interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);

			/***************** MST - for outer interface call *********************/
			command4.manageIFFlagBasic(interfaceGRPVO,account);         //MST/CGM ROLLBACK call

			//Delete TOTAL LOSS 
			totalLossGRPVO = command.removeTotalLossBasic(totalLossGRPVO,account);

			//Delete Total Loss History
			if(!totalLossGRPVO.getCustomMnrTtlLssRqstHdrVO().getMnrStsRefNo().equalsIgnoreCase("")) {
				statusHistoryGRPVO.setMnrStsRefNo(totalLossGRPVO.getCustomMnrTtlLssRqstHdrVO().getMnrStsRefNo());
				command5.removeStatusHistorysAllBasic(statusHistoryGRPVO, account);
			}
			commit();

			//Retrieve TOTAL LOSS
			totalLossGRPVO = command.searchTotalLossListBasic(totalLossGRPVO,account);
			eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0095 : Delete <br>
	 * [EES_MNR_0095] Delete Total Loss Request data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeTotalLossGRPService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		TotalLossMgtBC command = new TotalLossMgtBCImpl();
		StatusHistoryMgtBC command1 = new StatusHistoryMgtBCImpl();

		EesMnr0095Event event = (EesMnr0095Event)e;
		TotalLossGRPVO totalLossGRPVO = event.getTotalLossGRPVO();
		StatusHistoryGRPVO statusHistoryGRPVO = new StatusHistoryGRPVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			totalLossGRPVO = command.removeTotalLossGRPBasic(totalLossGRPVO,account);
			//Delete HISTORY
			statusHistoryGRPVO.setMnrStsRefNo(totalLossGRPVO.getCustomMnrTtlLssRqstHdrVO().getMnrStsRefNo());
			command1.removeStatusHistorysAllBasic(statusHistoryGRPVO, account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0159 : Delete <br>
	 * [EES_MNR_0159] Delete Disposal Request data<br>
	 *
	 * @param DisposalGRPVO disposalGRPVO
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeDisposalService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DisposalMgtBC command = new DisposalMgtBCImpl();

		DisposalGRPVO disposalGRPVO = null;
		if(e.getEventName().equalsIgnoreCase("EesMnr0156Event")){
			EesMnr0156Event event = (EesMnr0156Event)e;
			disposalGRPVO = event.getDisposalGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0157Event")){
			EesMnr0157Event event = (EesMnr0157Event)e;
			disposalGRPVO = event.getDisposalGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0159Event")){
			EesMnr0159Event event = (EesMnr0159Event)e;
			disposalGRPVO = event.getDisposalGRPVO();
		}

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			if(disposalGRPVO != null){
				begin();
				disposalGRPVO = command.removeDisposalBasic(disposalGRPVO,account);
				commit();
				disposalGRPVO = command.searchDisposalListBasic(disposalGRPVO,account);
				eventResponse.setRsVoList(disposalGRPVO.getCustomMnrDispHdrVOS());
			}
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	* EES_MNR_0164 : Retrieve <br>
	* [EES_MNR_0164] Retrieve Disposal Request data<br>
	*
	* @param DisposalGRPVO disposalGRPVO
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchDisposalListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			DisposalGRPVO disposalGRPVO = null;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if(e.getEventName().equalsIgnoreCase("EesMnr0156Event")){
				EesMnr0156Event event = (EesMnr0156Event)e;
				disposalGRPVO = event.getDisposalGRPVO();
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0157Event")){
				EesMnr0157Event event = (EesMnr0157Event)e;
				disposalGRPVO = event.getDisposalGRPVO();
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0159Event")){
				EesMnr0159Event event = (EesMnr0159Event)e;
				disposalGRPVO = event.getDisposalGRPVO();
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0164Event")){
				EesMnr0164Event event = (EesMnr0164Event)e;
				disposalGRPVO = event.getDisposalGRPVO();
			}
			if(disposalGRPVO != null){
				disposalGRPVO = command.searchDisposalListBasic(disposalGRPVO,account);
				eventResponse.setRsVoList(disposalGRPVO.getCustomMnrDispHdrVOS());
			}
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	* EES_MNR_0200 : doActionIBSheet <br>
	* [EES_MNR_0200] Retrieve Disposal Request data<br>
	*
	* @param String eventName
	* @param DisposalGRPVO disposalGRPVO
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchDisposalService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			DisposalGRPVO disposalGRPVO = null;
			if(e.getEventName().equalsIgnoreCase("EesMnr0156Event")){
				EesMnr0156Event event = (EesMnr0156Event)e;
				disposalGRPVO = event.getDisposalGRPVO();
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0157Event")){
				EesMnr0157Event event = (EesMnr0157Event)e;
				disposalGRPVO = event.getDisposalGRPVO();
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0159Event")){
				EesMnr0159Event event = (EesMnr0159Event)e;
				disposalGRPVO = event.getDisposalGRPVO();
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0200Event")){
				EesMnr0200Event event = (EesMnr0200Event)e;
				disposalGRPVO = event.getDisposalGRPVO();
				disposalGRPVO.getCustomMnrDispHdrVO().setInqFlg("Y");
			}
			
			if(disposalGRPVO != null){
				disposalGRPVO = command.searchDisposalBasic(disposalGRPVO);
	
				eventResponse.setRsVoList(disposalGRPVO.getCustomMnrDispBuyerPartVOS());
				eventResponse.setRsVoList(disposalGRPVO.getEqCustomMnrDispDtlVOS());
				eventResponse.setRsVoList(disposalGRPVO.getQtyCustomMnrDispDtlVOS());
				if(e.getEventName().equalsIgnoreCase("EesMnr0159Event") || e.getEventName().equalsIgnoreCase("EesMnr0200Event")){
					disposalGRPVO = command.searchDSPBuyerDTLPartBasic(disposalGRPVO);
					eventResponse.setRsVoList(disposalGRPVO.getCustomMnrDispBuyrDtlPartVOS());
				}
			}
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	* EES_MNR_0156 : Request <br>
	* [EES_MNR_0156] Retrieve Disposal Request data<br>
	*
	* @param Event e
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchDSPPartnerService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			PartnerMgtBC command = new PartnerMgtBCImpl();
			EesMnr0156Event event = (EesMnr0156Event)e;
			DisposalGRPVO disposalGRPVO = event.getDisposalGRPVO();
			disposalGRPVO = command.searchDSPPartnerBasic(disposalGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(disposalGRPVO.getCustomMnrDispBuyerPartVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

   /**
	* EES_MNR_0028 : Retrieve <br>
	* [EES_MNR_0028] Retrieve Repair Cancellation and Deletion data<br>
	*
	* @param Event e
	* @param RepairCollectionGRPVO repairCollectionGRPVO
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchRepairInquiryListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			RepairMgtBC command = new RepairMgtBCImpl();

			RepairCollectionGRPVO repairCollectionGRPVO = null;
			if(e.getEventName().equalsIgnoreCase("EesMnr0027Event")){
				EesMnr0027Event event = (EesMnr0027Event)e;
				repairCollectionGRPVO = event.getRepairCollectionGRPVO();
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0028Event")){
				EesMnr0028Event event = (EesMnr0028Event)e;
				repairCollectionGRPVO = event.getRepairCollectionGRPVO();
			} else if(e.getEventName().equalsIgnoreCase("EesMnrS027Event")){
				EesMnrS027Event event = (EesMnrS027Event)e;
				repairCollectionGRPVO = event.getRepairCollectionGRPVO();
				repairCollectionGRPVO.setCurrSystem("SPP");
			} else if(e.getEventName().equalsIgnoreCase("EesMnrS028Event")){
				EesMnrS028Event event = (EesMnrS028Event)e;
				repairCollectionGRPVO = event.getRepairCollectionGRPVO();
				repairCollectionGRPVO.setCurrSystem("SPP");
			}
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if(repairCollectionGRPVO != null){
				repairCollectionGRPVO = command.searchRepairInquiryListBasic(repairCollectionGRPVO,account);
				eventResponse.setRsVoList(repairCollectionGRPVO.getCustomRepairCollectionVOS());
			}
			
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0192 : doActionIBSheet <br>
	 * [EES_MNR_0192] Retrieve Estimate Detail_Pop-up data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEstimateByEQService(Event e) throws EventException {
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0192Event event = (EesMnr0192Event)e;
			RepairMgtBC command = new RepairMgtBCImpl();
			EstimateGRPVO estimateGRPVO = event.getEstimateGRPVO();
			if(estimateGRPVO.getEstimateINVO().getEstTemp().equalsIgnoreCase("Y")){
				estimateGRPVO = command.searchEDIEstimateBasic(estimateGRPVO);
			} else {
				estimateGRPVO = command.searchEstimateBasic(estimateGRPVO,account);
			}
			eventResponse.setETCData(estimateGRPVO.getCustomMnrRprRqstHdrVO().getColumnValues());
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstDtlVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0023 : Calculation <br>
	 * [EES_MNR_0023] Checking Repair Estimate Creation data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyEstimateCalcService(Event e) throws EventException {
		EstimateGRPVO estimateGRPVO = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//0019
		if(e.getEventName().equalsIgnoreCase("EesMnr0019Event")){
			EesMnr0019Event event = (EesMnr0019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
		//0023
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0023Event")){
			EesMnr0023Event event = (EesMnr0023Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
		//0240
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0240Event")){
			EesMnr0240Event event = (EesMnr0240Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
		//SPP 0019
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS019Event")){
			EesMnrS019Event event = (EesMnrS019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setCurrSystem("SPP");
		}

		GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();

		/* Begin of additional setting
		   : INP_MSG35 = AGMT_OFC_CTY_CD
		   : INP_MSG36 = AGMT_SEQ
		   : INP_MSG37 = 'NNN'
		   : INP_MSG4  = 'SS'
		*/
		if(estimateGRPVO != null){
			CustomMnrDatVrfyVO[] customMnrDatVrfyVOS = null;
			customMnrDatVrfyVOS = estimateGRPVO.getCustomMnrDatVrfyVOS();
			GeneralCodeSearchMgtBC command1 = new GeneralCodeSearchMgtBCImpl();
	
			for(int i = 0;i < customMnrDatVrfyVOS.length; i++){
				customMnrDatVrfyVOS[i].setInpMsg35(estimateGRPVO.getCustomMnrRprRqstHdrVO().getAgmtOfcCtyCd());
				customMnrDatVrfyVOS[i].setInpMsg36(estimateGRPVO.getCustomMnrRprRqstHdrVO().getAgmtSeq());
				customMnrDatVrfyVOS[i].setInpMsg37("NNN");
				customMnrDatVrfyVOS[i].setInpMsg4("SS");
	
				//Assign COST_CD data after checking not exist data
				if(customMnrDatVrfyVOS[i].getInpMsg19().equals("") || customMnrDatVrfyVOS[i].getInpMsg19() ==  null){
	
					if(estimateGRPVO.getCustomMnrRprRqstHdrVO().getEqKndCd().equals("U")){
						if(estimateGRPVO.getCustomMnrRprRqstHdrVO().getEqTpszCd().startsWith("D")){
							customMnrDatVrfyVOS[i].setInpMsg19("MRDRRC");
						} else if(estimateGRPVO.getCustomMnrRprRqstHdrVO().getEqTpszCd().startsWith("R")){
							CostCodeINVO costCodeINVO = new CostCodeINVO();
							//Component Code
							costCodeINVO.setCmpoCd(customMnrDatVrfyVOS[i].getInpMsg2());
							//TpSz
							costCodeINVO.setTpSz(estimateGRPVO.getCustomMnrRprRqstHdrVO().getEqTpszCd());
							CostCodeGRPVO costCodeGRPVO = new CostCodeGRPVO();
							costCodeGRPVO.setCostCodeINVO(costCodeINVO);
							costCodeGRPVO = command1.searchCostCodeBasic(costCodeGRPVO);
							List<CustomCostCodeVO> customCostCodeVOS = costCodeGRPVO.getCustomCostCodeVOS();
							if(customCostCodeVOS.size() > 0){
								customMnrDatVrfyVOS[i].setInpMsg19(customCostCodeVOS.get(0).getCostCd());
							} else {
								//DEFAULT
								customMnrDatVrfyVOS[i].setInpMsg19("MRRURC");
							}
						} else {
							customMnrDatVrfyVOS[i].setInpMsg19("MRDSRC");
						}
					} else if(estimateGRPVO.getCustomMnrRprRqstHdrVO().getEqKndCd().equals("G")){
						customMnrDatVrfyVOS[i].setInpMsg19("MRGSRC");
					} else {
						customMnrDatVrfyVOS[i].setInpMsg19("MRZSRC");
					}
				}
				//Re-assign "NR" at the COST_DTL_CD after checking empty data
				if(customMnrDatVrfyVOS[i].getInpMsg20().equals("") || customMnrDatVrfyVOS[i].getInpMsg20() ==  null){
					customMnrDatVrfyVOS[i].setInpMsg20("NR");
				}
			}
			/* End of setting additional */
	
			generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyVOS(customMnrDatVrfyVOS);
			GeneralCodeCheckMgtBC command  = new GeneralCodeCheckMgtBCImpl();
			RepairMgtBC 	  	  command2 = new RepairMgtBCImpl();
	
			try {
				begin();
				//Getting sequence after insert into table MNR_DAT_VRFY
				String seqValue = command.createMnrTempBasic(generalCodeCheckMgtGRPVO,account);
				//Sequence
				EstimateINVO estimateINVO = new EstimateINVO();
				estimateINVO.setTmpSeq(seqValue);
				//AGMT
				estimateINVO.setAgmtOfcCtyCd(estimateGRPVO.getCustomMnrRprRqstHdrVO().getAgmtOfcCtyCd());
				estimateINVO.setAgmtSeq(estimateGRPVO.getCustomMnrRprRqstHdrVO().getAgmtSeq());
				estimateINVO.setAgmtVerNo(estimateGRPVO.getCustomMnrRprRqstHdrVO().getAgmtVerNo());
				//TRF
				estimateINVO.setTrfNo(estimateGRPVO.getCustomMnrRprRqstHdrVO().getTrfNo());
				estimateGRPVO.setEstimateINVO(estimateINVO);
	
				//updating by business logic
				estimateGRPVO = command.verifyEstimateCalcBasic(estimateGRPVO);
				commit();
	
				eventResponse =	command2.searchLatestEstimateBasic(estimateGRPVO);
				eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstDtlVOS());
	
			}catch(EventException ex){
				rollback();
				throw ex;
			}catch(Exception ex){
				rollback();
				throw new EventException(ex.getMessage(), ex);
			}
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0023 : doActionIBSheet <br>
	 * [EES_MNR_0023] Retrieve "Repair Estimate Creation" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEstimateService(Event e) throws EventException {
		try {
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			// PDTO(Data Transfer Object including Parameters)
			RepairMgtBC command = new RepairMgtBCImpl();
			EstimateGRPVO estimateGRPVO = null;
			//0019
			if(e.getEventName().equalsIgnoreCase("EesMnr0019Event")){
				EesMnr0019Event event = (EesMnr0019Event)e;
				estimateGRPVO = event.getEstimateGRPVO();
			//0023
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0023Event")){
				EesMnr0023Event event = (EesMnr0023Event)e;
				estimateGRPVO = event.getEstimateGRPVO();
			//0240
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0240Event")){
				EesMnr0240Event event = (EesMnr0240Event)e;
				estimateGRPVO = event.getEstimateGRPVO();
			//SPP 0019
			} else if(e.getEventName().equalsIgnoreCase("EesMnrS019Event")){
				EesMnrS019Event event = (EesMnrS019Event)e;
				estimateGRPVO = event.getEstimateGRPVO();
				estimateGRPVO.setCurrSystem("SPP");
			}
			if(estimateGRPVO != null){
				estimateGRPVO = command.searchEstimateBasic(estimateGRPVO,account);
				eventResponse.setETCData(estimateGRPVO.getCustomMnrRprRqstHdrVO().getColumnValues());
				eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstDtlVOS());
			}
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0019 : Delete <br>
	 * [EES_MNR_0019] Delete "Repair Estimate Creation" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeEstimateService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		RepairMgtBC command = new RepairMgtBCImpl();
		EstimateGRPVO estimateGRPVO = new EstimateGRPVO();

		//0019
		if(e.getEventName().equalsIgnoreCase("EesMnr0019Event")){
			EesMnr0019Event event = (EesMnr0019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
		//SPP 0019
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS019Event")){
			EesMnrS019Event event = (EesMnrS019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setCurrSystem("SPP");
		}

		try {
			begin();
			estimateGRPVO = command.removeEstimateBasic(estimateGRPVO);
			commit();

			EstimateINVO estimateINVO = new EstimateINVO();
			estimateINVO.setRqstType("rqst_cre");
			estimateINVO.setCostOfcCd(account.getOfc_cd());
			//SPP 조회용
			if(estimateGRPVO.getCurrSystem().equals("SPP")){
				estimateINVO.setVndrSeq(account.getOfc_eng_nm());
			}

			estimateGRPVO.setEstimateINVO(estimateINVO);

			estimateGRPVO = command.searchEstimateSMRListBasic(estimateGRPVO,account);
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0019 : Save <br>
	 * [EES_MNR_0019] Add, modify, delete "Repair Estimate Creation" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEstimateService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EstimateGRPVO estimateGRPVO = new EstimateGRPVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RepairMgtBC command = new RepairMgtBCImpl();
		
		//0019
		if(e.getEventName().equalsIgnoreCase("EesMnr0019Event")){
			EesMnr0019Event event = (EesMnr0019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
		//SPP 0019
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS019Event")){
			EesMnrS019Event event = (EesMnrS019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setCurrSystem("SPP");
		}


		try {
			begin();
			estimateGRPVO = command.manageEstimateBasic(estimateGRPVO,account);
			commit();

			//Retrieve saved data
			EstimateINVO estimateINVO = new EstimateINVO();
			estimateINVO.setRqstEqNo(estimateGRPVO.getCustomMnrRprRqstHdrVO().getRqstEqNo());
			estimateINVO.setRprRqstSeq(estimateGRPVO.getCustomMnrRprRqstHdrVO().getRprRqstSeq());
			estimateINVO.setRprRqstVerNo(estimateGRPVO.getCustomMnrRprRqstHdrVO().getRprRqstVerNo());
			estimateINVO.setRprRqstLstVerFlg("Y");
			
			//SPP 조회용
			if(estimateGRPVO.getCurrSystem().equals("SPP")){
				estimateINVO.setVndrSeq(account.getOfc_eng_nm());
			}

			//estimate
			estimateINVO.setRqstType("rqst_cre");
			estimateINVO.setCostOfcCd(account.getOfc_cd());
			estimateGRPVO.setEstimateINVO(estimateINVO);
			eventResponse.setETCData(estimateINVO.getColumnValues());

			estimateGRPVO = command.searchEstimateSMRListBasic(estimateGRPVO,account);
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0023 : Audit it Later <br>
	 * [EES_MNR_0023] Add, modify, delete "Repair Estimate Auditing" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEstimateAuditItLaterService(Event e) throws EventException {
		EstimateGRPVO estimateGRPVO = new EstimateGRPVO();
		//0023
		if(e.getEventName().equalsIgnoreCase("EesMnr0023Event")){
			EesMnr0023Event event = (EesMnr0023Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setIsEDI("N");
		//0240
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0240Event")){
			EesMnr0240Event event = (EesMnr0240Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setIsEDI("Y");
		}

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairMgtBC command = new RepairMgtBCImpl();

		try {
			begin();
			estimateGRPVO = command.manageEstimateAuditItLaterBasic(estimateGRPVO,account);
			commit();

			EstimateINVO estimateINVO = new EstimateINVO();
			estimateINVO.setRqstEqNo(estimateGRPVO.getCustomMnrRprRqstHdrVO().getRqstEqNo());
			estimateINVO.setRprRqstSeq(estimateGRPVO.getCustomMnrRprRqstHdrVO().getRprRqstSeq());
			estimateINVO.setRprRqstVerNo(estimateGRPVO.getCustomMnrRprRqstHdrVO().getRprRqstVerNo());
			estimateINVO.setRprRqstLstVerFlg("Y");

			//Repair Estimate Auditing
			estimateINVO.setRqstType("rqst_aud");
			estimateINVO.setAproOfcCd(account.getOfc_cd());
			estimateGRPVO.setEstimateINVO(estimateINVO);
			eventResponse.setETCData(estimateINVO.getColumnValues());
			estimateGRPVO = command.searchEstimateSMRListBasic(estimateGRPVO,account);
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0019 : Request <br>
	 * [EES_MNR_0019] Modify "Repair Estimate Creation" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse requestEstimateService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EstimateGRPVO estimateGRPVO = new EstimateGRPVO();
		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		//0019
		if(e.getEventName().equalsIgnoreCase("EesMnr0019Event")){
			EesMnr0019Event event = (EesMnr0019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
		//SPP 0019
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS019Event")){
			EesMnrS019Event event = (EesMnrS019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setCurrSystem("SPP");
		}

		RepairMgtBC	command = new RepairMgtBCImpl();
		EQFlagMgtBC command2 = new EQFlagMgtBCImpl();

		CustomMnrRprRqstHdrVO[] customMnrRprRqstHdrVOS = estimateGRPVO.getArrCustomMnrRprRqstHdrVOS();

		try {
			begin();
			for(int i = 0;i < customMnrRprRqstHdrVOS.length;i++){
				CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = null;
				customMnrRprRqstHdrVO = customMnrRprRqstHdrVOS[i];

				/*************** Checking "DmgFlag" data ****************/
				boolean isNeedFlagging = false;
				CustomMnrEqStsVVO customMnrEqStsVVO = command2.searchEqInfoBasic(customMnrRprRqstHdrVO.getRqstEqNo());
				String currDmgFlg = customMnrEqStsVVO.getDmgFlag();
				String reqDmgFlg = "N";

				if(customMnrRprRqstHdrVO.getRprWrkTpCd().equalsIgnoreCase("W")){
					reqDmgFlg = "Y";
				}

				if(!currDmgFlg.equalsIgnoreCase(reqDmgFlg)){
					isNeedFlagging = true;
				}
				/*************** Checking "DmgFlag" data ****************/

				//************** Dmg Flag ****************//
				if(isNeedFlagging){
					/***********************FLAG *********************************/
					//STS VO
					CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
					customMnrEqStsVO.setEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
					customMnrEqStsVO.setEqKndCd(customMnrRprRqstHdrVO.getEqKndCd());
					customMnrEqStsVO.setEqTpszCd(customMnrRprRqstHdrVO.getEqTpszCd());
					java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
					String today = formatter.format(new java.util.Date());
					customMnrEqStsVO.setMnrDmgFlgDt(today);
					customMnrEqStsVO.setMnrDmgFlgYdCd(customMnrRprRqstHdrVO.getRprYdCd());
					customMnrEqStsVO.setMnrStsRmk("From Estimate Request");
					//FLG_HIS_VO
					CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
					customMnrFlgHisVO.setEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
					customMnrFlgHisVO.setEqTpszCd(customMnrRprRqstHdrVO.getEqTpszCd());
					customMnrFlgHisVO.setMnrFlgTpCd("DMG");
					customMnrFlgHisVO.setMnrFlgInpTpCd("R");
					customMnrFlgHisVO.setEqKndCd(customMnrRprRqstHdrVO.getEqKndCd());
					customMnrFlgHisVO.setMnrFlgYdCd(customMnrRprRqstHdrVO.getRprYdCd());
					customMnrFlgHisVO.setMnrFlgInpDt(today);
					customMnrFlgHisVO.setMnrFlgRmk("From Estimate Request");

					if(customMnrRprRqstHdrVO.getRprWrkTpCd().equalsIgnoreCase("W")){
						customMnrEqStsVO.setMnrDmgFlg("1");
						customMnrFlgHisVO.setMnrStsFlg("1");
					} else {
						customMnrEqStsVO.setMnrDmgFlg("0");
						customMnrFlgHisVO.setMnrStsFlg("0");
					}

					CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[1];
					CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[1];

					arrCustomMnrEqStsVOS[0] = customMnrEqStsVO;
					arrCustomMnrFlgHisVOS[0] = customMnrFlgHisVO;

					EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
					eQFlagListINVO.setMnrFlgTpCd("DMG");
					eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
					eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
					eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
					/********************** FLAG END **********************************/

					/***************** MST for outer interface call **********************/
					InterfaceMgtBC command3 = new InterfaceMgtBCImpl();
					InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
					List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
					for(int j = 0;j < arrCustomMnrEqStsVOS.length; j++){
						IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
						iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
						iFMnrFlagVO.setFlagUserId(account.getUsr_id());
						iFMnrFlagVO.setFlagType("DMG");
						iFMnrFlagVO.setRetireFlag("N");
						iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[j].getEqKndCd());
						iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[j].getEqNo());
						//Damage Flag
						if(arrCustomMnrEqStsVOS[j].getMnrDmgFlg().equals("1")){
							iFMnrFlagVO.setStsFlag("Y");
						} else {
							iFMnrFlagVO.setStsFlag("N");
						}
						iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[j].getMnrDmgFlgDt());
						iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[j].getMnrDmgFlgYdCd());
						iFMnrFlagVOS.add(iFMnrFlagVO);
					}
					interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
					/***************** MST for outer interface call **********************/
					
					command2.manageEQFlagListBasic(eQFlagListGRPVO,account);
					command3.manageIFFlagBasic(interfaceGRPVO,account);
				}
			}

			estimateGRPVO = command.requestEstimateBasic(estimateGRPVO,account);
			commit();

			//Retrieve saved data
			EstimateINVO estimateINVO = new EstimateINVO();
			
			//Estimate
			estimateINVO.setRqstType("rqst_cre");
			estimateINVO.setCostOfcCd(account.getOfc_cd());
			estimateGRPVO.setEstimateINVO(estimateINVO);

			//SPP 조회용
			if(estimateGRPVO.getCurrSystem().equals("SPP")){
				estimateINVO.setVndrSeq(account.getOfc_eng_nm());
			}
			eventResponse.setETCData(estimateINVO.getColumnValues());

			estimateGRPVO = command.searchEstimateSMRListBasic(estimateGRPVO,account);
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0023 : Counter offer <br>
	 * [EES_MNR_0023] Modify "Repair Estimate Auditing" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse counterOfferEstimateService(Event e) throws EventException {
		EstimateGRPVO estimateGRPVO = new EstimateGRPVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		//0023
		if(e.getEventName().equalsIgnoreCase("EesMnr0023Event")){
			EesMnr0023Event event = (EesMnr0023Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setIsEDI("N");
		//0240
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0240Event")){
			EesMnr0240Event event = (EesMnr0240Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setIsEDI("Y");
		}
		RepairMgtBC	command = new RepairMgtBCImpl();

		try {
			begin();
			estimateGRPVO = command.counterOfferEstimateBasic(estimateGRPVO,account);
			commit();

			//Retrieve saved data
			EstimateINVO estimateINVO = new EstimateINVO();
			//Estimate
			estimateINVO.setRqstType("rqst_aud");
			estimateINVO.setAproOfcCd(account.getOfc_cd());
			estimateGRPVO.setEstimateINVO(estimateINVO);
			eventResponse.setETCData(estimateINVO.getColumnValues());

			estimateGRPVO = command.searchEstimateSMRListBasic(estimateGRPVO,account);
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0023 : Reject <br>
	 * [EES_MNR_0023] Modify "Repair Estimate Auditing" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse rejectEstimateService(Event e) throws EventException {
		EstimateGRPVO estimateGRPVO = new EstimateGRPVO();
		//0023
		if(e.getEventName().equalsIgnoreCase("EesMnr0023Event")){
			EesMnr0023Event event = (EesMnr0023Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setIsEDI("N");
		//0240
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0240Event")){
			EesMnr0240Event event = (EesMnr0240Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setIsEDI("Y");
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RepairMgtBC	command = new RepairMgtBCImpl();

		try {
			begin();
			estimateGRPVO = command.rejectEstimateBasic(estimateGRPVO,account);
			commit();

			//Retrieve saved data
			EstimateINVO estimateINVO = new EstimateINVO();
			//Estimate
			estimateINVO.setRqstType("rqst_aud");
			estimateINVO.setAproOfcCd(account.getOfc_cd());
			estimateGRPVO.setEstimateINVO(estimateINVO);
			eventResponse.setETCData(estimateINVO.getColumnValues());

			estimateGRPVO = command.searchEstimateSMRListBasic(estimateGRPVO,account);
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0023 : Approval <br>
	 * [EES_MNR_0023] Modify "Repair Estimate Auditing"<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse approvalEstimateService(Event e) throws EventException {
		EstimateGRPVO estimateGRPVO = new EstimateGRPVO();
		//0023
		if(e.getEventName().equalsIgnoreCase("EesMnr0023Event")){
			EesMnr0023Event event = (EesMnr0023Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setIsEDI("N");
		//0240
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0240Event")){
			EesMnr0240Event event = (EesMnr0240Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setIsEDI("Y");
		}

		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
		InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RepairMgtBC	command = new RepairMgtBCImpl();
		EQFlagMgtBC command2 = new EQFlagMgtBCImpl();
		InterfaceMgtBC command3 = new InterfaceMgtBCImpl();
		CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = estimateGRPVO.getCustomMnrRprRqstHdrVO();

		/*************** Checking "DmgFlag" ****************/
		boolean isNeedFlagging = false;
		CustomMnrEqStsVVO customMnrEqStsVVO = command2.searchEqInfoBasic(customMnrRprRqstHdrVO.getRqstEqNo());
		String currDmgFlg = customMnrEqStsVVO.getDmgFlag();
		String reqDmgFlg = "N";
		if(customMnrRprRqstHdrVO.getRprWrkTpCd().equalsIgnoreCase("W")){
			reqDmgFlg = "Y";
		}
		if(!currDmgFlg.equalsIgnoreCase(reqDmgFlg)){
			isNeedFlagging = true;
		}
		/*************** Checking "DmgFlag" ****************/

		try {
			begin();
			if(isNeedFlagging){
				/***********************FLAG *********************************/
				//STS VO
				CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
				customMnrEqStsVO.setEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
				customMnrEqStsVO.setEqKndCd(customMnrRprRqstHdrVO.getEqKndCd());
				customMnrEqStsVO.setEqTpszCd(customMnrRprRqstHdrVO.getEqTpszCd());
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
				String today = formatter.format(new java.util.Date());
				customMnrEqStsVO.setMnrDmgFlgDt(today);
				customMnrEqStsVO.setMnrDmgFlgYdCd(customMnrRprRqstHdrVO.getRprYdCd());
				customMnrEqStsVO.setMnrStsRmk("From Estimate Approval");
				//FLG_HIS_VO
				CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
				customMnrFlgHisVO.setEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
				customMnrFlgHisVO.setEqTpszCd(customMnrRprRqstHdrVO.getEqTpszCd());
				customMnrFlgHisVO.setMnrFlgTpCd("DMG");
				customMnrFlgHisVO.setMnrFlgInpTpCd("R");
				customMnrFlgHisVO.setEqKndCd(customMnrRprRqstHdrVO.getEqKndCd());
				customMnrFlgHisVO.setMnrFlgYdCd(customMnrRprRqstHdrVO.getRprYdCd());
				customMnrFlgHisVO.setMnrFlgInpDt(today);
				customMnrFlgHisVO.setMnrFlgRmk("From Estimate Approval");

				if(customMnrRprRqstHdrVO.getRprWrkTpCd().equalsIgnoreCase("W")){
					customMnrEqStsVO.setMnrDmgFlg("1");
					customMnrFlgHisVO.setMnrStsFlg("1");
				} else {
					customMnrEqStsVO.setMnrDmgFlg("0");
					customMnrFlgHisVO.setMnrStsFlg("0");
				}

				CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[1];
				CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[1];

				arrCustomMnrEqStsVOS[0] = customMnrEqStsVO;
				arrCustomMnrFlgHisVOS[0] = customMnrFlgHisVO;

				EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
				eQFlagListINVO.setMnrFlgTpCd("DMG");
				eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
				eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
				eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
				/********************** FLAG END **********************************/

				/***************** MST for outer interface call **********************/
				List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
				for(int i = 0;i < arrCustomMnrEqStsVOS.length; i++){
					IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
					iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
					iFMnrFlagVO.setFlagUserId(account.getUsr_id());
					iFMnrFlagVO.setFlagType("DMG");
					iFMnrFlagVO.setRetireFlag("N");
					iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[i].getEqKndCd());
					iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[i].getEqNo());
					//Damage Flag
					if(arrCustomMnrEqStsVOS[i].getMnrDmgFlg().equals("1")){
						iFMnrFlagVO.setStsFlag("Y");
					} else {
						iFMnrFlagVO.setStsFlag("N");
					}
					iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[i].getMnrDmgFlgDt());
					iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDmgFlgYdCd());
					iFMnrFlagVOS.add(iFMnrFlagVO);
				}
				interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
				/***************** MST for outer interface call **********************/
				
				command2.manageEQFlagListBasic(eQFlagListGRPVO,account);
				command3.manageIFFlagBasic(interfaceGRPVO,account);
			}
			estimateGRPVO = command.approvalEstimateBasic(estimateGRPVO,account);

			//changing data at approvalEstimateBasic
			customMnrRprRqstHdrVO = estimateGRPVO.getCustomMnrRprRqstHdrVO();

			/************** TPB Start ********************/
			if(customMnrRprRqstHdrVO.getN3ptyFlg().equalsIgnoreCase("Y") && customMnrRprRqstHdrVO.getRprStsCd().equalsIgnoreCase("HA")){
				interfaceGRPVO.setTpbRqstEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
				command3.createTPBIFBasic(interfaceGRPVO, account);
			}
			/************* TPB End ***********************/
			commit();

			//Retrieve saved data
			EstimateINVO estimateINVO = new EstimateINVO();
			//Estimate
			estimateINVO.setRqstType("rqst_aud");
			estimateINVO.setAproOfcCd(account.getOfc_cd());
			estimateGRPVO.setEstimateINVO(estimateINVO);
			eventResponse.setETCData(estimateINVO.getColumnValues());

			estimateGRPVO = command.searchEstimateSMRListBasic(estimateGRPVO,account);
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());
		} catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0139 : Verify <br>
	 * [EES_MNR_0139] Checking "Damage Flagging/Unflagging Pop-up" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyEQFlagFileListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0139Event event = (EesMnr0139Event)e;
		GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
		generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyVOS(event.getCustomMnrDatVrfyVOS());
		GeneralCodeCheckMgtBC command  = new GeneralCodeCheckMgtBCImpl();

		VerifyEQFlagFileListGRPVO eQFlagMgtGRPVO = new VerifyEQFlagFileListGRPVO();
		eQFlagMgtGRPVO.setEQFlagMgtINVO(event.getEQFlagMgtINVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			//Getting sequence after insert into table MNR_DAT_VRFY
			String seqValue = command.createMnrTempBasic(generalCodeCheckMgtGRPVO,account);
			//Setting sequence
			eQFlagMgtGRPVO.getEQFlagMgtINVO().setTmpSeq(seqValue);
			//Update by business logic
			eQFlagMgtGRPVO = command.verifyEQFlagFileListBasic(eQFlagMgtGRPVO);
			commit();

			eventResponse.setRsVoList(eQFlagMgtGRPVO.getCustomMnrDatVrfyVOS());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0219 : Verify <br>
	 * [EES_MNR_0219] Checking "M&R Simple WO File Import Pop_Up" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyWOFileListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0219Event event = (EesMnr0219Event)e;
		GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
		generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyVOS(event.getCustomMnrDatVrfyVOS());
		GeneralCodeCheckMgtBC command  = new GeneralCodeCheckMgtBCImpl();

		VerifyEQTypeSizeFlagFileListGRPVO eQTypeSizeFlagMgtGRPVO = new VerifyEQTypeSizeFlagFileListGRPVO();
		eQTypeSizeFlagMgtGRPVO.setEQFlagMgtINVO(event.getEQFlagMgtINVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			//Getting sequence after insert into table MNR_DAT_VRFY
			String seqValue = command.createMnrTempBasic(generalCodeCheckMgtGRPVO,account);
			//Setting sequence
			eQTypeSizeFlagMgtGRPVO.getEQFlagMgtINVO().setTmpSeq(seqValue);
			//Update by business logic
			eQTypeSizeFlagMgtGRPVO = command.verifyWOFileListBasic(eQTypeSizeFlagMgtGRPVO);
			commit();

			eventResponse.setRsVoList(eQTypeSizeFlagMgtGRPVO.getCustomMnrDatVrfyVOS());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0220 : Verify <br>
	 * [EES_MNR_0220] Checking "Disposal Price File Import_Pop-up" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyDisposalPriceFileListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0220Event event = (EesMnr0220Event)e;
		GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
		generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyVOS(event.getCustomMnrDatVrfyVOS());
		GeneralCodeCheckMgtBC command  = new GeneralCodeCheckMgtBCImpl();

		DisposalPriceFileListGRPVO disposalPriceFileListGRPVO = new DisposalPriceFileListGRPVO();
		disposalPriceFileListGRPVO.setEQFlagMgtINVO(event.getEQFlagMgtINVO());
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();
			//Getting sequence after insert into table MNR_DAT_VRFY
			String seqValue = command.createMnrTempBasic(generalCodeCheckMgtGRPVO,account);
			//Setting sequence
			disposalPriceFileListGRPVO.getEQFlagMgtINVO().setTmpSeq(seqValue);
			//Update by business logic
			disposalPriceFileListGRPVO = command.verifyDisposalPriceFileListBasic(disposalPriceFileListGRPVO);
			commit();

			eventResponse.setRsVoList(disposalPriceFileListGRPVO.getCustomMnrDatVrfyVOS());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0122 : Retrieve <br>
	 * [EES_MNR_0122] Retrieve "Hanger Bar Attatch/Detach Qty by CNTR" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQFlagListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EQFlagMgtBC command = new EQFlagMgtBCImpl();
			EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
			String validFlg = "";
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			if(e.getEventName().equalsIgnoreCase("EesMnr0109Event")){
				EesMnr0109Event event = (EesMnr0109Event)e;
				event.getEQFlagListINVO().setOfcCd(account.getOfc_cd());
				eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());

			} else if(e.getEventName().equalsIgnoreCase("EesMnr0122Event")){
				EesMnr0122Event event = (EesMnr0122Event)e;
				eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());
				if("".equals(eQFlagListGRPVO.getEQFlagListINVO().getEqList())&&"".equals(eQFlagListGRPVO.getEQFlagListINVO().getMnrDmgFlgYdCd())){
					validFlg = "N";
				} 
			} else {
				EesMnrS122Event event = (EesMnrS122Event)e;
				eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());
				if("".equals(eQFlagListGRPVO.getEQFlagListINVO().getEqList())){
					validFlg = "N";
				} 
			}
			
			if(!"N".equals(validFlg)){
				if((e.getEventName().equalsIgnoreCase("EesMnr0109Event")||e.getEventName().equalsIgnoreCase("EesMnr0122Event"))&&eQFlagListGRPVO.getEQFlagListINVO().getIPage() == 1){
					String rtvTotal = command.searchHangerFlagStatusCountBasic(eQFlagListGRPVO);
					eventResponse.setETCData("rtv_total", rtvTotal);
				}
				eQFlagListGRPVO = command.searchEQFlagListBasic(eQFlagListGRPVO);
			}

//			eQFlagListGRPVO = command.searchEQFlagListBasic(eQFlagListGRPVO);
			
			eventResponse.setRsVoList(eQFlagListGRPVO.getCustomMnrEqStsVOS());
			eventResponse.setETCData("validFlg", validFlg);
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0151 : Retrieve <br>
	 * [EES_MNR_0151] Retrieve "Disposal Candidate Selection" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalCandidateListFlagService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EQFlagMgtBC command = new EQFlagMgtBCImpl();
			DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO = new DisposalCandidateFlagGRPVO();

			if(e.getEventName().equalsIgnoreCase("EesMnr0151Event")){
				EesMnr0151Event event = (EesMnr0151Event)e;
				disposalCandidateFlagGRPVO.setDisposalCandidateFlagINVO(event.getDisposalCandidateFlagINVO());
			}

			disposalCandidateFlagGRPVO = command.searchDisposalCandidateFlagListBasic(disposalCandidateFlagGRPVO,account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(disposalCandidateFlagGRPVO.getCustomMnrEqRngStsVOS());
			eventResponse.setRsVoList(disposalCandidateFlagGRPVO.getCustomMnrEqStsVOS());
			return eventResponse;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0158 : Retrieve <br>
	 * [EES_MNR_0158] Retrieve "Disposal Candidate Inquiry_Pop-up" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalCandidatePopupListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EQFlagMgtBC command = new EQFlagMgtBCImpl();
			DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO = new DisposalCandidateFlagGRPVO();

			EesMnr0158Event event = (EesMnr0158Event)e;
			disposalCandidateFlagGRPVO.setDisposalCandidateFlagINVO(event.getDisposalCandidateFlagINVO());

			disposalCandidateFlagGRPVO = command.searchDisposalCandidatePopupListBasic(disposalCandidateFlagGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(disposalCandidateFlagGRPVO.getCustomMnrEqStsVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0125 : Retrieve <br>
	 * [EES_MNR_0125] Retrieve "Hanger Bar CNTR History" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQFlagHistoryListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EQFlagMgtBC command = new EQFlagMgtBCImpl();
			EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();

			if(e.getEventName().equalsIgnoreCase("EesMnr0111Event")){
				EesMnr0111Event event = (EesMnr0111Event)e;
				eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());
				eQFlagListGRPVO.getEQFlagListINVO().setMnrFlgTpCd("HGR");
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0122Event")){
				EesMnr0122Event event = (EesMnr0122Event)e;
				eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());
				eQFlagListGRPVO.getEQFlagListINVO().setMnrFlgTpCd("DMG");
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0125Event")){
				EesMnr0125Event event = (EesMnr0125Event)e;
				eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());
				eQFlagListGRPVO.getEQFlagListINVO().setMnrFlgTpCd("DMG");
			}

			eQFlagListGRPVO = command.searchEQFlagHistoryListBasic(eQFlagListGRPVO,account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(eQFlagListGRPVO.getCustomMnrFlgHisVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0023 : Retrieve <br>
	 * [EES_MNR_0023] Retrieve "Repair Estimate Creation" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEstimateSMRListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			RepairMgtBC command = new RepairMgtBCImpl();
			EstimateGRPVO estimateGRPVO = new EstimateGRPVO();
			
			//0019
			if(e.getEventName().equalsIgnoreCase("EesMnr0019Event")){
				EesMnr0019Event event = (EesMnr0019Event)e;
				estimateGRPVO = event.getEstimateGRPVO();
			//0023
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0023Event")){
				EesMnr0023Event event = (EesMnr0023Event)e;
				estimateGRPVO = event.getEstimateGRPVO();
				estimateGRPVO.setIsEDI("N");
			//0240 (EDI Auditing)
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0240Event")){
				EesMnr0240Event event = (EesMnr0240Event)e;
				estimateGRPVO = event.getEstimateGRPVO();
				estimateGRPVO.setIsEDI("Y");
			//SPP 19
			} else if(e.getEventName().equalsIgnoreCase("EesMnrS019Event")){
				EesMnrS019Event event = (EesMnrS019Event)e;
				estimateGRPVO = event.getEstimateGRPVO();
				estimateGRPVO.setCurrSystem("SPP");
			}
			
			estimateGRPVO = command.searchEstimateSMRListBasic(estimateGRPVO,account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0022 : Retrieve <br>
	 * [EES_MNR_0022] Retrieve "Repair Group Auditing" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchESTGroupAuditListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			RepairMgtBC command = new RepairMgtBCImpl();
			EesMnr0022Event event = (EesMnr0022Event)e;
			EstimateGRPVO estimateGRPVO = event.getEstimateGRPVO();

			estimateGRPVO = command.searchESTGroupAuditListBasic(estimateGRPVO,account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0022 : Reject,Approval <br>
	 * [EES_MNR_0022] Add, modify, delete "Repair Group Auditing" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageESTGroupAuditListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RepairMgtBC command = new RepairMgtBCImpl();

		EesMnr0022Event event = (EesMnr0022Event)e;
		EstimateGRPVO estimateGRPVO = event.getEstimateGRPVO();

		try{
			begin();
			command.manageESTGroupAuditListBasic(estimateGRPVO,account);

			//************* TPB Start ********************//
			InterfaceMgtBC command1 = new InterfaceMgtBCImpl();
			CustomMnrRprRqstHdrVO[] customMnrRprRqstHdrVOS = estimateGRPVO.getArrCustomMnrRprRqstHdrVOS();
			//case of "Approval"
			if(estimateGRPVO.getGroupAuditAction().equals("Approval")){
				InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
				for(int i = 0;i < customMnrRprRqstHdrVOS.length;i ++){
					CustomMnrRprRqstHdrVO customMnrRprRqstHdrVO = customMnrRprRqstHdrVOS[i];
					if(customMnrRprRqstHdrVO.getN3ptyFlg().equalsIgnoreCase("Y")){
						interfaceGRPVO.setTpbRqstEqNo(customMnrRprRqstHdrVO.getRqstEqNo());
						command1.createTPBIFBasic(interfaceGRPVO, account);
					}
				}
			}
			//************* TPB End *********************//
			commit();

			estimateGRPVO = command.searchESTGroupAuditListBasic(estimateGRPVO,account);
			eventResponse.setRsVoList(estimateGRPVO.getCustomMnrRprRqstHdrVOS());

		} catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0027 : Cancel <br>
	 * [EES_MNR_0027] Modify "Repair Cancellation and Deletion" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	 private EventResponse manageEstimateCancelService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairMgtBC command = new RepairMgtBCImpl();

		RepairCollectionGRPVO repairCollectionGRPVO = new RepairCollectionGRPVO();
		if(e.getEventName().equalsIgnoreCase("EesMnr0027Event")){
			EesMnr0027Event event = (EesMnr0027Event)e;
			repairCollectionGRPVO = event.getRepairCollectionGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0028Event")){
			EesMnr0028Event event = (EesMnr0028Event)e;
			repairCollectionGRPVO = event.getRepairCollectionGRPVO();
		}

		try{
			begin();
			command.manageEstimateCancelBasic(repairCollectionGRPVO,account);
			commit();

			repairCollectionGRPVO = command.searchRepairInquiryListBasic(repairCollectionGRPVO,account);
			eventResponse.setRsVoList(repairCollectionGRPVO.getCustomRepairCollectionVOS());

		} catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_MNR_0027 : Delete <br>
	 * [EES_MNR_0027] Delete "Repair Cancellation and Deletion" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	 private EventResponse manageRepairDeleteService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairMgtBC command = new RepairMgtBCImpl();

		RepairCollectionGRPVO repairCollectionGRPVO = new RepairCollectionGRPVO();
		if(e.getEventName().equalsIgnoreCase("EesMnr0027Event")){
			EesMnr0027Event event = (EesMnr0027Event)e;
			repairCollectionGRPVO = event.getRepairCollectionGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0028Event")){
			EesMnr0028Event event = (EesMnr0028Event)e;
			repairCollectionGRPVO = event.getRepairCollectionGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS027Event")){
			EesMnrS027Event event = (EesMnrS027Event)e;
			repairCollectionGRPVO = event.getRepairCollectionGRPVO();
		}

		try{
			begin();
			command.manageRepairDeleteBasic(repairCollectionGRPVO,account);
			commit();

			repairCollectionGRPVO = command.searchRepairInquiryListBasic(repairCollectionGRPVO,account);
			eventResponse.setRsVoList(repairCollectionGRPVO.getCustomRepairCollectionVOS());

		} catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_MNR_0122 : Save <br>
	 * [EES_MNR_0122] Save "Hanger Bar Attatch/Detach Qty by CNTR" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEQFlagListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EQFlagMgtBC command = new EQFlagMgtBCImpl();
		InterfaceMgtBC command2 = new InterfaceMgtBCImpl();
		HangerInventoryMgtBC command3 = new HangerInventoryMgtBCImpl();

		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
		HangerInventoryListGRPVO hangerInventoryListGRPVO = new HangerInventoryListGRPVO();

		try{

			if(e.getEventName().equalsIgnoreCase("EesMnr0109Event")){
				EesMnr0109Event event = (EesMnr0109Event)e;
				eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());

				CustomMnrEqStsVO[] customMnrEqStsVO1 = event.getHangerInventoryListGRPVO().getArrCustomMnrEqStsVOS();
				for(int i = 0;i < customMnrEqStsVO1.length; i++){
					event.getHangerInventoryListGRPVO().getArrCustomMnrEqStsVOS()[i].setMnrStsRmk("");
				}
				CustomMnrEqStsVO[] customMnrEqStsVO2 = event.getCustomMnrEqStsVOs();
				for(int i = 0;i < customMnrEqStsVO2.length; i++){
					event.getCustomMnrEqStsVOs()[i].setMnrStsRmk("");
				}

				eQFlagListGRPVO.setArrCustomMnrEqStsVOS(event.getCustomMnrEqStsVOs());
				eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(event.getCustomMnrFlgHisVOs());
				hangerInventoryListGRPVO.setArrCustomMnrEqStsVOS(event.getHangerInventoryListGRPVO().getArrCustomMnrEqStsVOS());
				
			} else if(e.getEventName().equalsIgnoreCase("EesMnr0122Event")){
				EesMnr0122Event event = (EesMnr0122Event)e;
				eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());
				eQFlagListGRPVO.setArrCustomMnrEqStsVOS(event.getCustomMnrEqStsVOs());
				eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(event.getCustomMnrFlgHisVOs());
			} else {
				EesMnrS122Event event = (EesMnrS122Event)e;
				eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());
				eQFlagListGRPVO.setArrCustomMnrEqStsVOS(event.getCustomMnrEqStsVOs());
				eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(event.getCustomMnrFlgHisVOs());
			}


			/***************** MST outer interface call **********************/
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();

			CustomMnrEqStsVO[] customMnrEqStsVOS = eQFlagListGRPVO.getArrCustomMnrEqStsVOS();
			for(int i = 0;i < customMnrEqStsVOS.length; i++){
				IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
				iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
				iFMnrFlagVO.setFlagUserId(account.getUsr_id());
				iFMnrFlagVO.setFlagType(eQFlagListGRPVO.getEQFlagListINVO().getMnrFlgTpCd());
				iFMnrFlagVO.setRetireFlag("N");
				if(e.getEventName().equalsIgnoreCase("EesMnr0109Event")) {
					iFMnrFlagVO.setEqKindCd(eQFlagListGRPVO.getEQFlagListINVO().getEqKndCd());
				}else{
					iFMnrFlagVO.setEqKindCd(customMnrEqStsVOS[i].getEqKndCd());
				}
				iFMnrFlagVO.setEqNo(customMnrEqStsVOS[i].getEqNo());

				//Damage Flag
				if(eQFlagListGRPVO.getEQFlagListINVO().getMnrFlgTpCd().equals("DMG")){
					//Checking flag
					if(customMnrEqStsVOS[i].getMnrDmgFlg().equals("1")){
						iFMnrFlagVO.setStsFlag("Y");
					} else {
						iFMnrFlagVO.setStsFlag("N");
					}

					iFMnrFlagVO.setFlagDt(customMnrEqStsVOS[i].getMnrDmgFlgDt());
					iFMnrFlagVO.setFlagYdCd(customMnrEqStsVOS[i].getMnrDmgFlgYdCd());
					iFMnrFlagVO.setRmk(customMnrEqStsVOS[i].getMnrStsRmk());
				//Hanger Flag
				} else {
					//Checking flag
					if(customMnrEqStsVOS[i].getMnrHngrFlg().equals("1")){
						iFMnrFlagVO.setStsFlag("Y");
					} else {
						iFMnrFlagVO.setStsFlag("N");
					}

					iFMnrFlagVO.setFlagDt(customMnrEqStsVOS[i].getMnrHngrFlgDt().replace("-", ""));
					iFMnrFlagVO.setFlagYdCd(customMnrEqStsVOS[i].getMnrHngrFlgYdCd());
					iFMnrFlagVO.setHrType(customMnrEqStsVOS[i].getMnrHngrRckCd());
					iFMnrFlagVO.setHbType(customMnrEqStsVOS[i].getMnrHngrBarTpCd());
					iFMnrFlagVO.setHbCount(customMnrEqStsVOS[i].getHngrBarAtchKnt());
				}
				iFMnrFlagVOS.add(iFMnrFlagVO);
			}
			interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
			/***************** MST outer interface call **********************/

			begin();
			command.manageEQFlagListBasic(eQFlagListGRPVO,account);
			if(eQFlagListGRPVO.getEQFlagListINVO().getMnrFlgTpCd().equals("HGR")){
				command3.manageHangerInventoryEqStsBasic(hangerInventoryListGRPVO,account);
			}
			command2.manageIFFlagBasic(interfaceGRPVO,account);
			
			if(eQFlagListGRPVO.getEQFlagListINVO().getMnrFlgTpCd().equals("DMG") && "U".equals(eQFlagListGRPVO.getEQFlagListINVO().getEqKndCd())){
				String [] rtn = command2.manageCtmIfFlagBasic(interfaceGRPVO, account);
				if("".equals(rtn[0])&&"".equals(rtn[1])){
					eventResponse.setETCData("error1", "");
					eventResponse.setETCData("error2", "");
					commit();
				}else{
					eventResponse.setETCData("error1", rtn[0]);
					eventResponse.setETCData("error2", rtn[1]);
					rollback();
				}
			}else{
				commit();
			}
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_MNR_0109 : Save <br>
	 * [EES_MNR_0109] Save "Hanger Rack & Bar Installation/Removal" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	 private EventResponse manageHangerRackBarService(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
		 	HangerInventoryListGRPVO hangerInventoryListGRPVO = new HangerInventoryListGRPVO();
			EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			EQFlagMgtBC command1 = new EQFlagMgtBCImpl();
			InterfaceMgtBC command2 = new InterfaceMgtBCImpl();
			HangerInventoryMgtBC command3 = new HangerInventoryMgtBCImpl();
			
			CustomMnrEqStsVO[] customMnrEqStsVOS = null;
			EQFlagListINVO eQFlagListINVO = null;
			CustomMnrFlgHisVO[] customMnrFlgHisVOS = null;
			
			EesMnr0109Event event = (EesMnr0109Event)e;
			hangerInventoryListGRPVO = event.getHangerInventoryListGRPVO();
			customMnrEqStsVOS 		 = hangerInventoryListGRPVO.getArrCustomMnrEqStsVOS();
			eQFlagListINVO 			 = hangerInventoryListGRPVO.getEQFlagListINVO();
			if (customMnrEqStsVOS != null) {
				customMnrFlgHisVOS = new CustomMnrFlgHisVO[customMnrEqStsVOS.length];
			}
				
			try {
				begin();
				List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
				if(customMnrEqStsVOS != null) {		
					for(int i = 0;i < customMnrEqStsVOS.length; i++){
						if(!"Y".equals(eQFlagListINVO.getExcelLoadFlg())||"".equals(customMnrEqStsVOS[i].getMnrHngrFlgDt())){
							java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
							String today = formatter.format(new java.util.Date());
							customMnrEqStsVOS[i].setMnrHngrFlgDt(today);
						}
						String hngrFlag = "";
						if(customMnrEqStsVOS[i].getMnrHngrFlg().equals("1")){		
							hngrFlag = command1.checkHngrFlaggingBasic(customMnrEqStsVOS[i]);
							if("Y".equals(hngrFlag)){
								throw new EventException(new ErrorHandler("MNR00001",new String[]{"Equipment No: "+ customMnrEqStsVOS[i].getEqNo() + " already has been hanger installed."}).getMessage());
							}else{
								customMnrEqStsVOS[i].setMnrHngrFlg("Y");
							}
						} else {		
							customMnrEqStsVOS[i].setMnrHngrFlg("N");			
						}	
						customMnrEqStsVOS[i].setMnrDmgFlg("N");
						
						IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
						iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
						iFMnrFlagVO.setFlagUserId(account.getUsr_id());
						iFMnrFlagVO.setFlagType("HGR");
						iFMnrFlagVO.setRetireFlag("N");
						iFMnrFlagVO.setEqKindCd(customMnrEqStsVOS[i].getEqKndCd());
						iFMnrFlagVO.setEqNo(customMnrEqStsVOS[i].getEqNo());
						iFMnrFlagVO.setFlagDt(customMnrEqStsVOS[i].getMnrHngrFlgDt());
						iFMnrFlagVO.setFlagYdCd(customMnrEqStsVOS[i].getMnrHngrFlgYdCd());
						
						int attachCnt = 0;
						//Case of Hanger Rack/Bar Installation
						if(customMnrEqStsVOS[i].getMnrHngrFlg().equals("Y")){			
							iFMnrFlagVO.setHrType(customMnrEqStsVOS[i].getMnrHngrRckCd());
							iFMnrFlagVO.setHbType(customMnrEqStsVOS[i].getMnrHngrBarTpCd());
								
							attachCnt = Integer.parseInt(customMnrEqStsVOS[i].getHngrBarAtchKnt());
						} else { 	//Case of Hanger Rack/Bar Removal
							if(customMnrEqStsVOS[i].getMnrHngrRckCd().equals("O")){
								iFMnrFlagVO.setHrType("O");		 
								iFMnrFlagVO.setHbType("S"); 	
							} else {	 	 
								iFMnrFlagVO.setHrType("");	   		
								iFMnrFlagVO.setHbType("");  
							}			
						}		
						
						customMnrEqStsVOS[i].setHngrBarAmdQty(customMnrEqStsVOS[i].getHngrBarAtchKnt());
						customMnrEqStsVOS[i].setHngrBarAtchKnt(String.valueOf(attachCnt));
						
						iFMnrFlagVO.setHbCount(String.valueOf(attachCnt));			
						iFMnrFlagVO.setStsFlag(customMnrEqStsVOS[i].getMnrHngrFlg());
						iFMnrFlagVOS.add(iFMnrFlagVO);	
						
						CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
						customMnrFlgHisVO.setMnrStsFlg(customMnrEqStsVOS[i].getMnrHngrFlg());
						customMnrFlgHisVO.setMnrFlgTpCd("HGR");		
						customMnrFlgHisVO.setMnrFlgInpTpCd("M");	
						customMnrFlgHisVO.setEqNo(customMnrEqStsVOS[i].getEqNo());
						customMnrFlgHisVO.setEqTpszCd(customMnrEqStsVOS[i].getEqTpszCd());
						customMnrFlgHisVO.setMnrFlgYdCd(customMnrEqStsVOS[i].getMnrHngrFlgYdCd());
						customMnrFlgHisVO.setMnrHngrBarTpCd(customMnrEqStsVOS[i].getMnrHngrBarTpCd());
						customMnrFlgHisVO.setMnrHngrRckCd(customMnrEqStsVOS[i].getMnrHngrRckCd());
						customMnrFlgHisVO.setHngrBarAmdQty(customMnrEqStsVOS[i].getHngrBarAtchKnt());
						customMnrFlgHisVO.setHngrBarTtlQty(String.valueOf(attachCnt));
						String actType = "Install";
						
						//Removal
						if(customMnrEqStsVOS[i].getMnrHngrFlg().equals("N")){	
							customMnrFlgHisVO.setActInvtQty(customMnrEqStsVOS[i].getActInvtQty());
							customMnrFlgHisVO.setMnrHngrDmgQty(customMnrEqStsVOS[i].getMnrHngrDmgQty());
							customMnrFlgHisVO.setMnrLostHngrQty(customMnrEqStsVOS[i].getMnrLostHngrQty());
							customMnrFlgHisVO.setMnrDispHngrQty(customMnrEqStsVOS[i].getMnrDispHngrQty());
							actType = "Removal";
						}
						
						customMnrFlgHisVO.setMnrFlgRmk(actType + " by Manual " + customMnrEqStsVOS[i].getHngrBarAmdQty() + " Qty [" + account.getOfc_cd() + "] [" + account.getUsr_id()+ "]");  
						customMnrFlgHisVO.setMnrOrdOfcCtyCd(customMnrEqStsVOS[i].getMnrOrdOfcCtyCd());
						customMnrFlgHisVO.setMnrOrdSeq(customMnrEqStsVOS[i].getMnrOrdSeq());
						customMnrFlgHisVO.setMnrHngrTrfCd(customMnrEqStsVOS[i].getMnrHngrTrfCd());
						customMnrFlgHisVO.setMnrHngrTrfOtrDesc(customMnrEqStsVOS[i].getMnrHngrTrfOtrDesc());
							
						customMnrFlgHisVOS[i] = customMnrFlgHisVO;
						String rmk = command1.searchEQStsRmkBasic(customMnrFlgHisVO);
						if(rmk != null){
							if(rmk.equals(customMnrEqStsVOS[i].getMnrStsRmk())){
								customMnrEqStsVOS[i].setMnrStsRmk(customMnrFlgHisVO.getMnrFlgRmk());
							}
						}else{
							customMnrEqStsVOS[i].setMnrStsRmk(customMnrFlgHisVO.getMnrFlgRmk());
						}
//						if(customMnrEqStsVOS[i].getMnrStsRmk().equals("") || customMnrEqStsVOS[i].getMnrStsRmk() == null){
//							customMnrEqStsVOS[i].setMnrStsRmk(customMnrFlgHisVO.getMnrFlgRmk());
//						}
					}
					eQFlagListGRPVO.setArrCustomMnrEqStsVOS(customMnrEqStsVOS);
				}	
				eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
				eQFlagListGRPVO.getEQFlagListINVO().setMnrFlgTpCd("HGR");
				if(customMnrFlgHisVOS != null){
					eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(customMnrFlgHisVOS);
				}
				interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
				
				if(customMnrEqStsVOS != null) {	
					//Manual Inventory BC 다시 구현
					command3.manageHangerRackBarManualInventoryBasic(hangerInventoryListGRPVO,account);
					command1.manageEQFlagListBasic(eQFlagListGRPVO,account);
					command2.manageIFFlagBasic(interfaceGRPVO,account);
					
				}      
				commit();
			}catch(EventException ex){
				rollback();
				throw ex;
			}catch(Exception ex){
				rollback();
				throw new EventException(ex.getMessage(), ex);
			}
			return eventResponse;
		}


	/**
	 * EES_MNR_0151 : Save <br>
	 * [EES_MNR_0151] Save "Disposal Candidate Selection" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	 private EventResponse manageDisposalCandidateFlagService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EQFlagMgtBC command = new EQFlagMgtBCImpl();
		InterfaceMgtBC command3 = new InterfaceMgtBCImpl();
		DisposalCandidateFlagGRPVO disposalCandidateFlagGRPVO = new DisposalCandidateFlagGRPVO();

		try{
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			if(e.getEventName().equalsIgnoreCase("EesMnr0151Event"))
			{
				EesMnr0151Event event = (EesMnr0151Event)e;
				disposalCandidateFlagGRPVO.setDisposalCandidateFlagINVO(event.getDisposalCandidateFlagINVO());
				disposalCandidateFlagGRPVO.setArrCustomMnrEqStsVOS(event.getCustomMnrEqStsVOs());
				disposalCandidateFlagGRPVO.setArrCustomMnrEqRngStsVOS(event.getCustomMnrEqRngStsVOs());

				CustomMnrEqRngStsVO[] customMnrEqRngStsVOS = disposalCandidateFlagGRPVO.getarrCustomMnrEqRngStsVOS();
				CustomMnrEqStsVO[] customMnrEqStsVOS = disposalCandidateFlagGRPVO.getArrCustomMnrEqStsVOS();

				String selectCd = disposalCandidateFlagGRPVO.getDisposalCandidateFlagINVO().getSelectCd();
				
				/***************** MST for outer interface call **********************/
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
				String today = formatter.format(new java.util.Date());
				List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();

				//Selection Type = EQ Range
				if(selectCd.equalsIgnoreCase("R"))
				{
					for ( int i=0; i < customMnrEqRngStsVOS.length; i++ ) {
						IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
						iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
						iFMnrFlagVO.setFlagUserId(account.getUsr_id());
						iFMnrFlagVO.setFlagType("DSP");
						iFMnrFlagVO.setRetireFlag("N");
						if(customMnrEqRngStsVOS[i].getMnrDispSelFlg().equals("1")){
							iFMnrFlagVO.setStsFlag("Y");
						} else {
							iFMnrFlagVO.setStsFlag("N");
						}
						disposalCandidateFlagGRPVO.setEqFrNo(customMnrEqRngStsVOS[i].getFmSerNo());
						disposalCandidateFlagGRPVO.setEqToNo(customMnrEqRngStsVOS[i].getToSerNo());
						disposalCandidateFlagGRPVO.setEqPfx(customMnrEqRngStsVOS[i].getLotEqPfxCd());
						disposalCandidateFlagGRPVO.setIFMnrFlagVO(iFMnrFlagVO);

						//Retrieve "Eq_no" between range
						disposalCandidateFlagGRPVO = command.searchRangeToEQNoBasic(disposalCandidateFlagGRPVO);
						List<IFMnrFlagVO> searchIFMnrFlagVOS  = disposalCandidateFlagGRPVO.getIFMnrFlagVOS();

						for ( int j = 0; j < searchIFMnrFlagVOS.size(); j++ ) {
							iFMnrFlagVOS.add(searchIFMnrFlagVOS.get(j));
						}
					}
					disposalCandidateFlagGRPVO.setArrCustomMnrEqRngStsVOS(customMnrEqRngStsVOS);
				//Selection Type = EQ No
				} else if(selectCd.equalsIgnoreCase("N")){
					for(int i = 0;i < customMnrEqStsVOS.length; i++){
						IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
						iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
						iFMnrFlagVO.setFlagUserId(account.getUsr_id());
						iFMnrFlagVO.setFlagType("DSP");
						iFMnrFlagVO.setRetireFlag("N");
						iFMnrFlagVO.setEqKindCd(customMnrEqStsVOS[i].getEqKndCd());
						iFMnrFlagVO.setEqNo(customMnrEqStsVOS[i].getEqNo());
						if(customMnrEqStsVOS[i].getMnrDispSelFlg().equals("1")){
							iFMnrFlagVO.setStsFlag("Y");
						} else {
							iFMnrFlagVO.setStsFlag("N");
						}
						customMnrEqStsVOS[i].setMnrDispSelFlgDt(today);
						iFMnrFlagVO.setFlagDt(customMnrEqStsVOS[i].getMnrDispSelFlgDt());
						iFMnrFlagVO.setFlagYdCd(customMnrEqStsVOS[i].getMnrDispSelFlgYdCd());
						iFMnrFlagVOS.add(iFMnrFlagVO);
					}
					disposalCandidateFlagGRPVO.setArrCustomMnrEqStsVOS(customMnrEqStsVOS);
				}
				interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
				/***************** MST for outer interface call **********************/
			}

			begin();
			command.manageDisposalCandidateFlagBasic(disposalCandidateFlagGRPVO,account);
			command3.manageIFFlagBasic(interfaceGRPVO,account);    //MST outer interface call
			commit();
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0191 : Retrieve <br>
	 * [EES_MNR_0191] Retrieve "Repair History_Pop-up" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEQWorkOrderHistoryListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0191Event event = (EesMnr0191Event)e;
			RepairMgtBC command = new RepairMgtBCImpl();
			EQWorkOrderHistoryListGRPVO eQWorkOrderHistoryListGRPVO = new EQWorkOrderHistoryListGRPVO();
			eQWorkOrderHistoryListGRPVO.setEQWorkOrderHistoryListINVO(event.getEQWorkOrderHistoryListINVO());

			eQWorkOrderHistoryListGRPVO = command.searchEQWorkOrderHistoryListBasic(eQWorkOrderHistoryListGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(eQWorkOrderHistoryListGRPVO.getCustomEQWorkOrderHistoryListVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0194 : Retrieve <br>
	 * [EES_MNR_0194] Retrieve "Reefer Spare Part Summary List" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWOInfoListBySparePartService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			SparePartWOGRPVO sparePartWOGRPVO = new SparePartWOGRPVO();
			RepairMgtBC command = new RepairMgtBCImpl();
			if(e.getEventName().equalsIgnoreCase("EesMnr0194Event"))
			{
				EesMnr0194Event event = (EesMnr0194Event)e;

				sparePartWOGRPVO.setSparePartWOINVO(event.getSparePartWOINVO());

				sparePartWOGRPVO = command.searchWOInfoListBySparePartBasic(sparePartWOGRPVO);
			}
			else if(e.getEventName().equalsIgnoreCase("EesMnr0055Event"))
			{
				EesMnr0055Event event = (EesMnr0055Event)e;
				sparePartWOGRPVO.setSparePartWOINVO(event.getSparePartWOINVO());

				sparePartWOGRPVO = command.searchWOInfoListBySparePartBasic(sparePartWOGRPVO);
			}

			eventResponse.setRsVoList(sparePartWOGRPVO.getMnrOrderInfoBySparePartVOS());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0211 : Retrieve <br>
	 * [EES_MNR_0211] Retrieve "Tire Purchase W/O" data for use pop-up<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchWONoInquiryListService (Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0211Event event = (EesMnr0211Event)e;
		RepairMgtBC command = new RepairMgtBCImpl();

		try{
			WONoInquiryListGRPVO wONoInquiryListGRPVO = command.searchWONoInquiryListBasic(event.getWONoInquiryListGRPVO());
			eventResponse.setRsVoList(wONoInquiryListGRPVO.getArrWONoInquiryVOS());

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;


	}

	/**
	 * EES_MNR_0226 : sheet1_cost_dtl_cd_OnChange <br>
	 * [EES_MNR_0226] Retrieve "Simple W/O Inquiry Pop-up" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse getBzcAmtService (Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralWOGRPVO generalWOGRPVO=new GeneralWOGRPVO();
		RepairMgtBC command = new RepairMgtBCImpl();

		try{
			if(e.getEventName().equalsIgnoreCase("EesMnr0058Event"))
			{
				EesMnr0058Event event = (EesMnr0058Event)e;
				generalWOGRPVO = command.getBzcAmtBasic(event.getGeneralWOGRPVO());
			}
			else if(e.getEventName().equalsIgnoreCase("EesMnr0052Event"))
			{
				EesMnr0052Event event = (EesMnr0052Event)e;
				generalWOGRPVO = command.getBzcAmtBasic(event.getGeneralWOGRPVO());
			}

			eventResponse.setRsVoList(generalWOGRPVO.getCustomBzcAmtVOLST());

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * EES_MNR_0058 : doIBSEARCH <br>
     * [EES_MNR_0058] Retrieve "M&R Extra Expense W/O Creation" data<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchExtraWOService (Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();
		RepairMgtBC command = new RepairMgtBCImpl();

		try{
			if(e.getEventName().equalsIgnoreCase("EesMnr0058Event"))
			{
				EesMnr0058Event event = (EesMnr0058Event)e;
				generalWOGRPVO = command.searchExtraWOBasic(event.getGeneralWOGRPVO());
			}
			else if(e.getEventName().equalsIgnoreCase("EesMnr0052Event"))
			{
				EesMnr0052Event event = (EesMnr0052Event)e;
				generalWOGRPVO = command.searchExtraWOBasic(event.getGeneralWOGRPVO());
			}
			else if(e.getEventName().equalsIgnoreCase("EesMnr0227Event"))
			{
				EesMnr0227Event event = (EesMnr0227Event)e;
				generalWOGRPVO = command.searchExtraWOBasic(event.getGeneralWOGRPVO());
			}

			eventResponse.setRsVoList(generalWOGRPVO.getCustomMnrOrdDtlVOLst());
			eventResponse.setRsVoList(generalWOGRPVO.getCustomMnrOrdHdrVOLst());
			eventResponse.setRsVoList(generalWOGRPVO.getCustomMnrOrdHdrVOLst());

		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;


	}

	/**
	 * EES_MNR_0058 : doIBSAVE <br>
	 * [EES_MNR_0058] Save "M&R Extra Expense W/O Creation" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageExtraWOService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
			
		GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();
		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
		HangerInventoryListGRPVO hangerInventoryListGRPVO = new HangerInventoryListGRPVO();

		if(e.getEventName().equalsIgnoreCase("EesMnr0058Event"))
		{
			EesMnr0058Event event = (EesMnr0058Event)e;
			generalWOGRPVO = event.getGeneralWOGRPVO();
			eQFlagListGRPVO.setEQFlagListINVO(event.getGeneralWOGRPVO().getEQFlagListINVO());
		}

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		RepairMgtBC command = new RepairMgtBCImpl();
		EQFlagMgtBC command2 = new EQFlagMgtBCImpl();
		InterfaceMgtBC command3 = new InterfaceMgtBCImpl();
		HangerInventoryMgtBC command4 = new HangerInventoryMgtBCImpl();

		try {
			begin();
			generalWOGRPVO = command.manageExtraWOBasic(generalWOGRPVO, account);

			if(e.getEventName().equalsIgnoreCase("EesMnr0058Event"))
			{
				CustomMnrOrdDtlVO[] customMnrOrdDtlVOS = generalWOGRPVO.getArrCustomMnrOrdDtlVOS();
				CustomMnrEqStsVO[] customMnrEqStsVOS = new CustomMnrEqStsVO[customMnrOrdDtlVOS.length];
				CustomMnrFlgHisVO[] customMnrFlgHisVOS = new CustomMnrFlgHisVO[customMnrOrdDtlVOS.length];

				InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
				List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();

				if(customMnrOrdDtlVOS != null){
					//Container - Flagging data case of "Hanger"
					String costCd = customMnrOrdDtlVOS[0].getCostCd();
					//case of Hanger Rack/Bar Installation, Removal
					if(costCd.equals("MRDRHA") || costCd.equals("MRDRHD")) {
						for ( int i = 0; i < customMnrOrdDtlVOS.length; i++ ) {
							CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
							customMnrEqStsVO.setEqNo(customMnrOrdDtlVOS[i].getEqNo());
							customMnrEqStsVO.setCostDtlCd(customMnrOrdDtlVOS[i].getCostDtlCd());
								
							//Case of Hanger Rack/Bar Installation
							int attachCnt = 0;	//The actual number of attached
							if(costCd.equals("MRDRHA")){	
								customMnrEqStsVO.setMnrHngrFlg("Y");
								attachCnt = Integer.parseInt(customMnrOrdDtlVOS[i].getRprQty());
								customMnrEqStsVO.setMnrHngrRckCd(customMnrOrdDtlVOS[i].getMnrHngrRckCd());
								customMnrEqStsVO.setMnrHngrBarTpCd(customMnrOrdDtlVOS[i].getMnrHngrBarTpCd());
							} else { //Case of Hanger Rack/Bar Removal
								attachCnt = 0;
								customMnrEqStsVO.setMnrHngrFlg("N"); 	
								if(customMnrOrdDtlVOS[i].getMnrHngrRckCd().equals("O")){
									customMnrEqStsVO.setMnrHngrRckCd("O");
									customMnrEqStsVO.setMnrHngrBarTpCd("S");
								} else {	
									customMnrEqStsVO.setMnrHngrRckCd(customMnrOrdDtlVOS[i].getMnrHngrRckCd());
									customMnrEqStsVO.setMnrHngrBarTpCd(customMnrOrdDtlVOS[i].getMnrHngrBarTpCd());
								}			
								customMnrEqStsVO.setActInvtQty(customMnrOrdDtlVOS[i].getActInvtQty());
								customMnrEqStsVO.setMnrHngrDmgQty(customMnrOrdDtlVOS[i].getMnrHngrDmgQty());
								customMnrEqStsVO.setMnrLostHngrQty(customMnrOrdDtlVOS[i].getMnrLostHngrQty());
								customMnrEqStsVO.setMnrDispHngrQty(customMnrOrdDtlVOS[i].getMnrDispHngrQty());
							}		
							
							
							customMnrEqStsVO.setHngrBarAtchKnt(String.valueOf(attachCnt));
							customMnrEqStsVO.setRecentHngrBarAtchKnt(customMnrOrdDtlVOS[i].getRprQty());
							customMnrEqStsVO.setMnrDmgFlg("N");		
							customMnrEqStsVO.setMnrStsRmk("By Work Order");		
							customMnrEqStsVO.setMnrHngrFlgYdCd(customMnrOrdDtlVOS[i].getMnrHngrFlgYdCd());
							customMnrEqStsVO.setMnrHngrFlgDt(customMnrOrdDtlVOS[i].getMnrHngrFlgDt());	
							customMnrEqStsVO.setEqTpszCd(customMnrOrdDtlVOS[i].getEqTpszCd());	
							customMnrEqStsVO.setMnrHngrTrfCd(customMnrOrdDtlVOS[i].getMnrHngrTrfCd());	
							customMnrEqStsVO.setMnrHngrTrfOtrDesc(customMnrOrdDtlVOS[i].getMnrHngrTrfOtrDesc());
							customMnrEqStsVOS[i] = customMnrEqStsVO;	
							
							IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
							iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
							iFMnrFlagVO.setFlagUserId(account.getUsr_id());
							iFMnrFlagVO.setFlagType("HGR");
							iFMnrFlagVO.setRetireFlag("N");
							iFMnrFlagVO.setEqKindCd(customMnrOrdDtlVOS[i].getEqKndCd());
							iFMnrFlagVO.setEqNo(customMnrOrdDtlVOS[i].getEqNo());
							iFMnrFlagVO.setFlagDt(customMnrOrdDtlVOS[i].getMnrHngrFlgDt());
							iFMnrFlagVO.setFlagYdCd(customMnrOrdDtlVOS[i].getMnrHngrFlgYdCd());
							
							//Case of Hanger Rack/Bar Installation
							if(costCd.equals("MRDRHA")){			
								iFMnrFlagVO.setHrType(customMnrOrdDtlVOS[i].getMnrHngrRckCd());
								iFMnrFlagVO.setHbType(customMnrOrdDtlVOS[i].getMnrHngrBarTpCd());
							} else { //Case of Hanger Rack/Bar Removal
								if(customMnrEqStsVO.getMnrHngrRckCd().equals("O")){
									iFMnrFlagVO.setHrType("O");		 
									iFMnrFlagVO.setHbType("S"); 	
								} else {	 	 
									iFMnrFlagVO.setHrType("");	   		
									iFMnrFlagVO.setHbType("");  
								}						
							}			
								
							iFMnrFlagVO.setHbCount(String.valueOf(attachCnt));			
							iFMnrFlagVO.setStsFlag(customMnrEqStsVO.getMnrHngrFlg());
							iFMnrFlagVOS.add(iFMnrFlagVO);	
							
							CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
							customMnrFlgHisVO.setMnrStsFlg(customMnrEqStsVO.getMnrHngrFlg());
							customMnrFlgHisVO.setMnrFlgTpCd("HGR");		
							customMnrFlgHisVO.setMnrFlgInpTpCd("W");	
							customMnrFlgHisVO.setEqNo(customMnrOrdDtlVOS[i].getEqNo());
							customMnrFlgHisVO.setEqTpszCd(customMnrOrdDtlVOS[i].getEqTpszCd());
							customMnrFlgHisVO.setMnrFlgYdCd(customMnrOrdDtlVOS[i].getMnrHngrFlgYdCd());
							customMnrFlgHisVO.setMnrHngrBarTpCd(customMnrOrdDtlVOS[i].getMnrHngrBarTpCd());
							customMnrFlgHisVO.setMnrHngrRckCd(customMnrOrdDtlVOS[i].getMnrHngrRckCd());
							customMnrFlgHisVO.setHngrBarAmdQty(customMnrOrdDtlVOS[i].getRprQty()); 
							customMnrFlgHisVO.setHngrBarTtlQty(String.valueOf(attachCnt));		
							if(costCd.equals("MRDRHD")){	
								customMnrFlgHisVO.setActInvtQty(customMnrOrdDtlVOS[i].getActInvtQty());
								customMnrFlgHisVO.setMnrHngrDmgQty(customMnrOrdDtlVOS[i].getMnrHngrDmgQty());
								customMnrFlgHisVO.setMnrLostHngrQty(customMnrOrdDtlVOS[i].getMnrLostHngrQty());
								customMnrFlgHisVO.setMnrDispHngrQty(customMnrOrdDtlVOS[i].getMnrDispHngrQty());
							}	
							customMnrFlgHisVO.setMnrOrdOfcCtyCd(customMnrOrdDtlVOS[i].getMnrOrdOfcCtyCd());
							customMnrFlgHisVO.setMnrOrdSeq(customMnrOrdDtlVOS[i].getMnrOrdSeq());
							customMnrFlgHisVO.setMnrHngrTrfCd(customMnrOrdDtlVOS[i].getMnrHngrTrfCd());
							customMnrFlgHisVO.setMnrHngrTrfOtrDesc(customMnrOrdDtlVOS[i].getMnrHngrTrfOtrDesc());
								
							customMnrFlgHisVOS[i] = customMnrFlgHisVO;
						}	
						
						eQFlagListGRPVO.getEQFlagListINVO().setMnrFlgTpCd("HGR");
						eQFlagListGRPVO.setArrCustomMnrEqStsVOS(customMnrEqStsVOS);
						eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(customMnrFlgHisVOS);
						hangerInventoryListGRPVO.setArrCustomMnrEqStsVOS(customMnrEqStsVOS);
						interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
							
						command4.manageHangerInventoryEqStsBasic(hangerInventoryListGRPVO,account);
						command2.manageEQFlagListBasic(eQFlagListGRPVO,account);
						command3.manageIFFlagBasic(interfaceGRPVO,account);
					//Case of COST TYPE is "Other"
					} else if(costCd.equals("MRDROT")) {
						List<CustomMnrEqStsVO> listCustomMnrEqStsVO = new ArrayList<CustomMnrEqStsVO>(); 
						
						for ( int i = 0; i < customMnrOrdDtlVOS.length; i++ ) {
							CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
							//Case of Hanger Bar(Square,Round) Purchasing
							if(customMnrOrdDtlVOS[i].getCostDtlCd().equals("M1") || customMnrOrdDtlVOS[i].getCostDtlCd().equals("MD")){
								customMnrEqStsVO.setCostDtlCd(customMnrOrdDtlVOS[i].getCostDtlCd());
								customMnrEqStsVO.setEqNo(customMnrOrdDtlVOS[i].getEqNo());
								customMnrEqStsVO.setHngrBarAtchKnt(customMnrOrdDtlVOS[i].getRprQty());
								customMnrEqStsVO.setRecentHngrBarAtchKnt(customMnrOrdDtlVOS[i].getRprQty());
								customMnrEqStsVO.setMnrHngrFlg("N");
								customMnrEqStsVO.setMnrDmgFlg("N");
								customMnrEqStsVO.setMnrStsRmk("By Work Order");
								customMnrEqStsVO.setMnrHngrFlgYdCd(customMnrOrdDtlVOS[i].getMnrHngrFlgYdCd());
								customMnrEqStsVO.setMnrHngrFlgDt(customMnrOrdDtlVOS[i].getMnrHngrFlgDt());
								customMnrEqStsVO.setEqTpszCd(customMnrOrdDtlVOS[i].getEqTpszCd());
								customMnrEqStsVO.setMnrHngrDtlOffrDesc(customMnrOrdDtlVOS[i].getMnrHngrDtlOffrDesc());
									
								if(customMnrOrdDtlVOS[i].getCostDtlCd().equals("M1")){
									customMnrEqStsVO.setMnrHngrBarTpCd("S");
								}else{
									customMnrEqStsVO.setMnrHngrBarTpCd("D");
								}
								listCustomMnrEqStsVO.add(customMnrEqStsVO);
							} 
						}	
								
						if(listCustomMnrEqStsVO.size() > 0){	
							CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[listCustomMnrEqStsVO.size()];
							for (int i = 0; i < listCustomMnrEqStsVO.size(); i++) {
								arrCustomMnrEqStsVOS[i] = listCustomMnrEqStsVO.get(i);	
							}	
							
							hangerInventoryListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
							command4.manageHangerInventoryEqStsBasic(hangerInventoryListGRPVO,account);
						}
					}
				}
			}


			commit();

			GeneralWOINVO extraWOINVO = new GeneralWOINVO();

			String strMnrOrdSeq=generalWOGRPVO.getGeneralWOINVO().getAgmtOfcCtyCd().substring(0,3)+ generalWOGRPVO.getGeneralWOINVO().getMnrOrdSeq();
			extraWOINVO.setMnrOrdSeq(strMnrOrdSeq);
	    	generalWOGRPVO.setGeneralWOINVO(extraWOINVO);
			eventResponse.setETCData(extraWOINVO.getColumnValues());

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;

	}

	/**
	 * EES_MNR_0058 : Delete <br>
	 * [EES_MNR_0058] Delete "Vessel Reefer Spare Part Purchase W/O Creation" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeWOService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();
		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
		HangerInventoryListGRPVO hangerInventoryListGRPVO = new HangerInventoryListGRPVO();

		if(e.getEventName().equalsIgnoreCase("EesMnr0058Event"))
		{
			EesMnr0058Event event = (EesMnr0058Event)e;
			generalWOGRPVO = event.getGeneralWOGRPVO();
		}
		else if(e.getEventName().equalsIgnoreCase("EesMnr0052Event"))
		{
			EesMnr0052Event event = (EesMnr0052Event)e;
			generalWOGRPVO = event.getGeneralWOGRPVO();
		}
		else if(e.getEventName().equalsIgnoreCase("EesMnr0054Event"))
		{
			EesMnr0054Event event = (EesMnr0054Event)e;
			generalWOGRPVO = event.getGeneralWOGRPVO();
		}

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairMgtBC	command = new RepairMgtBCImpl();
		EQFlagMgtBC command2 = new EQFlagMgtBCImpl();
		InterfaceMgtBC command3 = new InterfaceMgtBCImpl();
		HangerInventoryMgtBC command4 = new HangerInventoryMgtBCImpl();
		
		try {	
			begin();
					
			if(e.getEventName().equalsIgnoreCase("EesMnr0058Event")){
				CustomMnrOrdHdrVO customMnrOrdHdrVO = generalWOGRPVO.getCustomMnrOrdHdrVO();
				String mnrOrdOfcCtyCd = "";
				String mnrOrdSeq = "";
				String woNo = customMnrOrdHdrVO.getMnrOrdSeq();
				if(woNo != null && !woNo.equals("")){
					mnrOrdOfcCtyCd = woNo.substring(0,3);
					mnrOrdSeq = woNo.substring(3);
				} 
				
				CustomMnrOrdDtlVO[] customMnrOrdDtlVOS = generalWOGRPVO.getArrCustomMnrOrdDtlVOS();
				
				List<CustomMnrEqStsVO> customMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>();
				List<CustomMnrEqStsVO> tmpCustomMnrEqStsVOS = new ArrayList<CustomMnrEqStsVO>();
				List<CustomMnrFlgHisVO> customMnrFlgHisVOS = new ArrayList<CustomMnrFlgHisVO>();
				
				InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
				List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
				
				if(customMnrOrdDtlVOS != null){		
					//Flagging Case of Container is Hanger
					String costCd = customMnrOrdDtlVOS[0].getCostCd();
					//Case of Hanger Rack/Bar Installation or Removal
					if(costCd.equals("MRDRHA") || costCd.equals("MRDRHD")) {
						for ( int i = 0; i < customMnrOrdDtlVOS.length; i++ ) {
							//Retrieve latest data for Checking modified data
							EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
							eQFlagListINVO.setEqList(customMnrOrdDtlVOS[i].getEqNo());		
							eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
							
							//Retrieve latest data
							eQFlagListGRPVO = command2.searchHangerEQFlagListBasic(eQFlagListGRPVO);
							CustomMnrEqStsVO tmpCustomMnrEqStsVO = eQFlagListGRPVO.getCustomMnrEqStsVO();
							if(tmpCustomMnrEqStsVO != null){
								boolean workFlag = false;
								String remarkStr = "";	
								CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO(); 
								customMnrEqStsVO.setCostDtlCd(customMnrOrdDtlVOS[i].getCostDtlCd());
								
 								//delete WO sign 
 								tmpCustomMnrEqStsVO.setCostDtlCd("RMH");
 								
								//Case of Hanger Rack/Bar Installation
								if(costCd.equals("MRDRHA")){	
									customMnrEqStsVO.setMnrHngrFlg("N");
 
									if(tmpCustomMnrEqStsVO.getMnrHngrFlg().equals("Y")){
										workFlag = true;	
										
										customMnrEqStsVO.setHngrBarAtchKnt("0");	
										customMnrEqStsVO.setActInvtQty(tmpCustomMnrEqStsVO.getHngrBarAtchKnt());
										customMnrEqStsVO.setMnrHngrDmgQty("0");		
										customMnrEqStsVO.setMnrLostHngrQty("0");	
										customMnrEqStsVO.setMnrDispHngrQty("0");	
										customMnrEqStsVO.setRecentHngrBarAtchKnt(tmpCustomMnrEqStsVO.getHngrBarAtchKnt());
									}				
									remarkStr = "INSTALL"; 	
								//Case of Hanger Rack/Bar Removal
								} else {		
									customMnrEqStsVO.setMnrHngrFlg("Y");
									if(tmpCustomMnrEqStsVO.getMnrHngrFlg().equals("N")){
										workFlag = true;	
											
										int soundQty = Integer.parseInt(tmpCustomMnrEqStsVO.getActInvtQty());
										int dmgQty = Integer.parseInt(tmpCustomMnrEqStsVO.getMnrHngrDmgQty());
										int lostQty = Integer.parseInt(tmpCustomMnrEqStsVO.getMnrLostHngrQty());
										int dispQty = Integer.parseInt(tmpCustomMnrEqStsVO.getMnrDispHngrQty());
										
										int reCoveryCnt = soundQty + dmgQty + lostQty + dispQty;
										customMnrEqStsVO.setHngrBarAtchKnt(String.valueOf(reCoveryCnt));
										customMnrEqStsVO.setActInvtQty("0");
										customMnrEqStsVO.setMnrHngrDmgQty("0");		
										customMnrEqStsVO.setMnrLostHngrQty("0");	
										customMnrEqStsVO.setMnrDispHngrQty("0");	
										customMnrEqStsVO.setRecentHngrBarAtchKnt(String.valueOf(reCoveryCnt));
									}				
									remarkStr = "REMOVE";
								}																				
								customMnrEqStsVO.setEqNo(tmpCustomMnrEqStsVO.getEqNo());
								customMnrEqStsVO.setEqTpszCd(tmpCustomMnrEqStsVO.getEqTpszCd());
								customMnrEqStsVO.setEqKndCd(tmpCustomMnrEqStsVO.getEqKndCd());
								customMnrEqStsVO.setMnrHngrRckCd(tmpCustomMnrEqStsVO.getMnrHngrRckCd());
								customMnrEqStsVO.setMnrHngrBarTpCd(tmpCustomMnrEqStsVO.getMnrHngrBarTpCd());
								customMnrEqStsVO.setMnrDmgFlg("N");  
								customMnrEqStsVO.setMnrHngrFlgYdCd(tmpCustomMnrEqStsVO.getMnrHngrFlgYdCd());
								customMnrEqStsVO.setMnrHngrFlgDt(tmpCustomMnrEqStsVO.getMnrHngrFlgDt());
								customMnrEqStsVO.setMnrHngrTrfCd(tmpCustomMnrEqStsVO.getMnrHngrTrfCd());	
								customMnrEqStsVO.setMnrHngrTrfOtrDesc(tmpCustomMnrEqStsVO.getMnrHngrTrfOtrDesc());
								java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
								String today = formatter.format(new java.util.Date());
								customMnrEqStsVO.setMnrHngrFlgDt(today); 	
													
								customMnrEqStsVO.setMnrStsRmk("By Work Order [" + remarkStr + "][" + mnrOrdOfcCtyCd + mnrOrdSeq + "] DELETE ");
								tmpCustomMnrEqStsVO.setMnrStsRmk("By Work Order [" + remarkStr + "][" + mnrOrdOfcCtyCd + mnrOrdSeq + "] DELETE ");
								
								IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();	
								iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());	
								iFMnrFlagVO.setFlagUserId(account.getUsr_id());	
								iFMnrFlagVO.setFlagType("HGR");	
								iFMnrFlagVO.setRetireFlag("N");		
								iFMnrFlagVO.setEqKindCd(customMnrEqStsVO.getEqKndCd());
								iFMnrFlagVO.setEqNo(customMnrEqStsVO.getEqNo());		
								iFMnrFlagVO.setFlagDt(customMnrEqStsVO.getMnrHngrFlgDt());
								iFMnrFlagVO.setFlagYdCd(customMnrEqStsVO.getMnrHngrFlgYdCd());
								iFMnrFlagVO.setHrType(customMnrEqStsVO.getMnrHngrRckCd());	
								iFMnrFlagVO.setHbType(customMnrEqStsVO.getMnrHngrBarTpCd());	
								if(customMnrEqStsVO.getMnrHngrFlg().equals("N")){			
									if(customMnrEqStsVO.getMnrHngrRckCd().equals("O")){
										iFMnrFlagVO.setHrType("O");			 
										iFMnrFlagVO.setHbType("S"); 	
									} else {	 	 
										iFMnrFlagVO.setHrType("");	   		
										iFMnrFlagVO.setHbType("");  
									}					
								}			
								iFMnrFlagVO.setHbCount(customMnrEqStsVO.getHngrBarAtchKnt());
								iFMnrFlagVO.setStsFlag(customMnrEqStsVO.getMnrHngrFlg());
								
								CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
								customMnrFlgHisVO.setMnrStsFlg(customMnrEqStsVO.getMnrHngrFlg());
								customMnrFlgHisVO.setMnrFlgTpCd("HGR");	
								customMnrFlgHisVO.setMnrFlgInpTpCd("W");	
								customMnrFlgHisVO.setEqNo(customMnrEqStsVO.getEqNo());
								customMnrFlgHisVO.setEqTpszCd(customMnrEqStsVO.getEqTpszCd());
								customMnrFlgHisVO.setMnrFlgYdCd(customMnrEqStsVO.getMnrHngrFlgYdCd());
								customMnrFlgHisVO.setMnrHngrRckCd(customMnrEqStsVO.getMnrHngrRckCd());
								customMnrFlgHisVO.setMnrHngrBarTpCd(customMnrEqStsVO.getMnrHngrBarTpCd());
								customMnrFlgHisVO.setHngrBarAmdQty(customMnrEqStsVO.getRecentHngrBarAtchKnt());       
								customMnrFlgHisVO.setHngrBarTtlQty(customMnrEqStsVO.getHngrBarAtchKnt()); 	 	
								customMnrFlgHisVO.setActInvtQty(customMnrEqStsVO.getActInvtQty());
								customMnrFlgHisVO.setMnrHngrDmgQty(customMnrEqStsVO.getMnrHngrDmgQty());
								customMnrFlgHisVO.setMnrLostHngrQty(customMnrEqStsVO.getMnrLostHngrQty());
								customMnrFlgHisVO.setMnrDispHngrQty(customMnrEqStsVO.getMnrDispHngrQty());
								customMnrFlgHisVO.setMnrOrdOfcCtyCd(mnrOrdOfcCtyCd);
								customMnrFlgHisVO.setMnrOrdSeq(mnrOrdSeq);
								customMnrFlgHisVO.setMnrHngrTrfCd(customMnrEqStsVO.getMnrHngrTrfCd());
								customMnrFlgHisVO.setMnrHngrTrfOtrDesc(customMnrEqStsVO.getMnrHngrTrfOtrDesc());
								if(workFlag){	
									customMnrEqStsVOS.add(customMnrEqStsVO);	
									tmpCustomMnrEqStsVOS.add(tmpCustomMnrEqStsVO);		
									customMnrFlgHisVOS.add(customMnrFlgHisVO);	
									iFMnrFlagVOS.add(iFMnrFlagVO); 
								}		
							}		
						}	
						//List data convert to array
						CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = null;
						CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = null;
						CustomMnrEqStsVO[] arrTmpCustomMnrEqStsVOS = null;
						
						arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[customMnrEqStsVOS.size()];
						if ( customMnrEqStsVOS.size() > 0 ) {
							for ( int x = 0; x < customMnrEqStsVOS.size(); x++ ) {
								arrCustomMnrEqStsVOS[x] = customMnrEqStsVOS.get(x);
							}
						}	
						arrTmpCustomMnrEqStsVOS = new CustomMnrEqStsVO[tmpCustomMnrEqStsVOS.size()];
						if ( tmpCustomMnrEqStsVOS.size() > 0 ) {
							for ( int x = 0; x < tmpCustomMnrEqStsVOS.size(); x++ ) {
								arrTmpCustomMnrEqStsVOS[x] = tmpCustomMnrEqStsVOS.get(x);
							}
						}	
						arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[customMnrFlgHisVOS.size()];
						if ( customMnrFlgHisVOS.size() > 0 ) {
							for ( int x = 0; x < customMnrEqStsVOS.size(); x++ ) {
								arrCustomMnrFlgHisVOS[x] = customMnrFlgHisVOS.get(x); 
							}	
						}			
						eQFlagListGRPVO.getEQFlagListINVO().setMnrFlgTpCd("HGR");	
						eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);	
							
						eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
						hangerInventoryListGRPVO.setArrCustomMnrEqStsVOS(arrTmpCustomMnrEqStsVOS);
						interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);			
						
						command4.manageHangerInventoryEqStsBasic(hangerInventoryListGRPVO,account);
						command2.manageEQFlagListBasic(eQFlagListGRPVO,account);	
						command3.manageIFFlagBasic(interfaceGRPVO,account);	
					//Case of Other	
					} else if(costCd.equals("MRDROT")) {
//						CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[customMnrOrdDtlVOS.length];
						List<CustomMnrEqStsVO> eqStsList = new ArrayList<CustomMnrEqStsVO>();
						for ( int i = 0; i < customMnrOrdDtlVOS.length; i++ ) {
							CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
							//Case of "Hanger Bar(Square, Round) Purchasing"
							if(customMnrOrdDtlVOS[i].getCostDtlCd().equals("M1") || customMnrOrdDtlVOS[i].getCostDtlCd().equals("MD")){
								customMnrEqStsVO.setCostDtlCd(customMnrOrdDtlVOS[i].getCostDtlCd());	
								customMnrEqStsVO.setEqNo(customMnrOrdDtlVOS[i].getEqNo());
								customMnrEqStsVO.setHngrBarAtchKnt(customMnrOrdDtlVOS[i].getRprQty());
								customMnrEqStsVO.setRecentHngrBarAtchKnt(customMnrOrdDtlVOS[i].getRprQty());
								customMnrEqStsVO.setMnrHngrFlg("N");	
								customMnrEqStsVO.setMnrDmgFlg("N");		
								customMnrEqStsVO.setMnrStsRmk("By Work Order [PURCHASING][" + mnrOrdOfcCtyCd + mnrOrdSeq + "] DELETE ");
								customMnrEqStsVO.setMnrHngrFlgYdCd(customMnrOrdDtlVOS[i].getMnrHngrFlgYdCd());
								customMnrEqStsVO.setMnrHngrFlgDt(customMnrOrdDtlVOS[i].getMnrHngrFlgDt());
								customMnrEqStsVO.setEqTpszCd(customMnrOrdDtlVOS[i].getEqTpszCd());
								customMnrEqStsVO.setMnrHngrDtlOffrDesc(customMnrOrdDtlVOS[i].getMnrHngrDtlOffrDesc());
								
								if(customMnrOrdDtlVOS[i].getCostDtlCd().equals("M1")){
									customMnrEqStsVO.setMnrHngrBarTpCd("S");
								} else {	
									customMnrEqStsVO.setMnrHngrBarTpCd("D");
								}
//								arrCustomMnrEqStsVOS[i] = customMnrEqStsVO;
								eqStsList.add(customMnrEqStsVO);
							} 		
						}			
						
						if(eqStsList != null && eqStsList.size() > 0){	
							hangerInventoryListGRPVO.setArrCustomMnrEqStsVOS((CustomMnrEqStsVO[])eqStsList.toArray(new CustomMnrEqStsVO[eqStsList.size()]));
							command4.manageHangerInventoryEqStsBasic(hangerInventoryListGRPVO,account);
						}	
					}	
				}	
			}	
			
			generalWOGRPVO = command.removeWOBasic(generalWOGRPVO, account);
			commit();

			GeneralWOINVO generalWOINVO = new GeneralWOINVO();

			String strMnrOrdSeq=generalWOGRPVO.getGeneralWOINVO().getAgmtOfcCtyCd().substring(0,3)+ generalWOGRPVO.getGeneralWOINVO().getMnrOrdSeq();
			generalWOINVO.setMnrOrdSeq(strMnrOrdSeq);
	    	generalWOGRPVO.setGeneralWOINVO(generalWOINVO);
			eventResponse.setETCData(generalWOINVO.getColumnValues());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * EES_MNR_0226 : Retrieve <br>
	 * [EES_MNR_0226] Retrieve "Simple W/O Inquiry Pop-up" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSimpleWOService (Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();
		RepairMgtBC command = new RepairMgtBCImpl();

		try{

	        if(e.getEventName().equalsIgnoreCase("EesMnr0052Event"))
			{
				EesMnr0052Event event = (EesMnr0052Event)e;
				generalWOGRPVO = command.searchExtraWOBasic(event.getGeneralWOGRPVO());
			}
			else if(e.getEventName().equalsIgnoreCase("EesMnr0226Event"))
			{
				EesMnr0226Event event = (EesMnr0226Event)e;
				generalWOGRPVO = command.searchExtraWOBasic(event.getGeneralWOGRPVO());
			}

			eventResponse.setRsVoList(generalWOGRPVO.getCustomMnrOrdDtlVOLst());
			eventResponse.setRsVoList(generalWOGRPVO.getCustomMnrOrdHdrVOLst());

			eventResponse.setRsVoList(generalWOGRPVO.getCustomMnrOrdHdrVOLst());

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0054 : Retrieve <br>
	 * [EES_MNR_0054] Retrieve "Vessel Reefer Spare Part Purchase W/O Creation" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRFSpareWOService(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();
		RepairMgtBC command = new RepairMgtBCImpl();

		try{

	        if(e.getEventName().equalsIgnoreCase("EesMnr0054Event"))
			{
	        	EesMnr0054Event event = (EesMnr0054Event)e;
				generalWOGRPVO = command.searchExtraWOBasic(event.getGeneralWOGRPVO());
			}
			else if(e.getEventName().equalsIgnoreCase("EesMnr0228Event"))
			{
				EesMnr0228Event event = (EesMnr0228Event)e;
				generalWOGRPVO = command.searchExtraWOBasic(event.getGeneralWOGRPVO());
			}

			eventResponse.setRsVoList(generalWOGRPVO.getCustomMnrOrdDtlVOLst());

			eventResponse.setRsVoList(generalWOGRPVO.getCustomMnrOrdHdrVOLst());

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * EES_MNR_0052 : W/O Creation <br>
	 * [EES_MNR_0052] Add "Simple W/O Creation" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSimpleWOService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)

		GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();

		EesMnr0052Event event = (EesMnr0052Event)e;
		generalWOGRPVO = event.getGeneralWOGRPVO();

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairMgtBC	command = new RepairMgtBCImpl();

		try {
			begin();
			generalWOGRPVO = command.manageExtraWOBasic(generalWOGRPVO, account);
			commit();
			
			GeneralWOINVO generalWOINVO = new GeneralWOINVO();

			String strMnrOrdSeq=generalWOGRPVO.getGeneralWOINVO().getAgmtOfcCtyCd().substring(0,3)+ generalWOGRPVO.getGeneralWOINVO().getMnrOrdSeq();
			generalWOINVO.setMnrOrdSeq(strMnrOrdSeq);
	    	generalWOGRPVO.setGeneralWOINVO(generalWOINVO);
			eventResponse.setETCData(generalWOINVO.getColumnValues());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0054 : W/O Creation <br>
	 * [EES_MNR_0054] Add "Vessel Reefer Spare Part Purchase W/O Creation" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRFSpareWOService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();
		EesMnr0054Event event = (EesMnr0054Event)e;
		generalWOGRPVO = event.getGeneralWOGRPVO();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairMgtBC	command = new RepairMgtBCImpl();

		try {
			begin();
			generalWOGRPVO = command.manageRFSpareWOBasic(generalWOGRPVO, account);
			commit();

			GeneralWOINVO generalWOINVO = new GeneralWOINVO();

			String strMnrOrdSeq=generalWOGRPVO.getGeneralWOINVO().getAgmtOfcCtyCd().substring(0,3)+ generalWOGRPVO.getGeneralWOINVO().getMnrOrdSeq();
			generalWOINVO.setMnrOrdSeq(strMnrOrdSeq);
	    	generalWOGRPVO.setGeneralWOINVO(generalWOINVO);
			eventResponse.setETCData(generalWOINVO.getColumnValues());

			return eventResponse;
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0032 : Retrieve <br>
	 * [EES_MNR_0032] Retrieve "Repair Result creatioln by W/O" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRepairResultListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairMgtBC command = new RepairMgtBCImpl();
		RepairResultGRPVO repairResultGRPVO = new RepairResultGRPVO();
		if(e.getEventName().equalsIgnoreCase("EesMnr0032Event")){
			EesMnr0032Event event = (EesMnr0032Event)e;
			repairResultGRPVO = event.getRepairResultGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS032Event")){
			EesMnrS032Event event = (EesMnrS032Event)e;
			repairResultGRPVO = event.getRepairResultGRPVO();
		}
		try{
			repairResultGRPVO = command.searchRepairResultListBasic(repairResultGRPVO);
			eventResponse.setRsVoList(repairResultGRPVO.getRepairResultListVOLst());

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * EES_MNR_0032 : Save <br>
	 * [EES_MNR_0032] Save "Repair Result creatioln by W/O" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRepairResultService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RepairResultGRPVO repairResultGRPVO = new RepairResultGRPVO();
		if(e.getEventName().equalsIgnoreCase("EesMnr0032Event")){
			EesMnr0032Event event = (EesMnr0032Event)e;
			repairResultGRPVO = event.getRepairResultGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS032Event")){
			EesMnrS032Event event = (EesMnrS032Event)e;
			repairResultGRPVO = event.getRepairResultGRPVO();
		}

		RepairMgtBC	command = new RepairMgtBCImpl();
		InterfaceMgtBC command3 = new InterfaceMgtBCImpl();

		EQFlagMgtBC command2 = new EQFlagMgtBCImpl();
		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();

		RepairResultListVO[] repairResultListVOS = repairResultGRPVO.getArrRepairResultListVOS();

		int flgCnt = 0;
		//Counting data for unflagging
		for ( int i = 0; i < repairResultListVOS.length; i++ )
		{
			if(repairResultListVOS[i].getIbflag().equals("U")){
				String dmgFlg       = repairResultListVOS[i].getMnrDmgFlg();
				String rprRsltDt       = repairResultListVOS[i].getRprRsltDt().trim();
				if(dmgFlg.equals("Y") && rprRsltDt.length()>=8)
				{
					flgCnt++;
				}
			}
		}
		//Assigning data for unflagging
		CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[flgCnt];
		CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[flgCnt];
		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
		String today = formatter.format(new java.util.Date());
		flgCnt=0;
		for ( int i = 0; i < repairResultListVOS.length; i++ )
		{
			if(repairResultListVOS[i].getIbflag().equals("U")){
				String dmgFlg       = repairResultListVOS[i].getMnrDmgFlg();
				String rprRsltDt       = repairResultListVOS[i].getRprRsltDt().trim();
				if(dmgFlg.equals("Y") && rprRsltDt.length()>=8)
				{
					//STS VO
					CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
					customMnrEqStsVO.setEqNo(repairResultListVOS[i].getEqNo());
					customMnrEqStsVO.setEqKndCd(repairResultListVOS[i].getEqKndCd());
					customMnrEqStsVO.setEqTpszCd(repairResultListVOS[i].getEqTpszCd());

					customMnrEqStsVO.setMnrDmgFlgDt(today);
					customMnrEqStsVO.setMnrDmgFlgYdCd(repairResultListVOS[i].getYdCd());
					customMnrEqStsVO.setMnrStsRmk("From Repair Result Creation");
					customMnrEqStsVO.setMnrDmgFlg("0");
					arrCustomMnrEqStsVOS[flgCnt] = customMnrEqStsVO;

					//FLG_HIS_VO
					CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
					customMnrFlgHisVO.setEqNo(repairResultListVOS[i].getEqNo());
					customMnrFlgHisVO.setEqTpszCd(repairResultListVOS[i].getEqTpszCd());
					customMnrFlgHisVO.setMnrFlgTpCd("DMG");
					customMnrFlgHisVO.setMnrFlgInpTpCd("S");
					customMnrFlgHisVO.setEqKndCd(repairResultListVOS[i].getEqKndCd());
					customMnrFlgHisVO.setMnrFlgYdCd(repairResultListVOS[i].getYdCd());
					customMnrFlgHisVO.setMnrFlgInpDt(today);
					customMnrFlgHisVO.setMnrFlgRmk("From Repair Result Creation");
					customMnrFlgHisVO.setMnrStsFlg("0");
					arrCustomMnrFlgHisVOS[flgCnt] = customMnrFlgHisVO;

					flgCnt++;
				}
			}
		}

		EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
		eQFlagListINVO.setMnrFlgTpCd("DMG");
		eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
		eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
		eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
		//*************** FLAG END   ************************* //

		/***************** MST for outer interface call **********************/
		InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
		List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();

		CustomMnrEqStsVO[] customMnrEqStsVOS = eQFlagListGRPVO.getArrCustomMnrEqStsVOS();
		for(int i = 0;i < customMnrEqStsVOS.length; i++){
			IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
			iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
			iFMnrFlagVO.setFlagUserId(account.getUsr_id());
			iFMnrFlagVO.setFlagType(eQFlagListGRPVO.getEQFlagListINVO().getMnrFlgTpCd());
			iFMnrFlagVO.setRetireFlag("N");
			iFMnrFlagVO.setEqKindCd(customMnrEqStsVOS[i].getEqKndCd());
			iFMnrFlagVO.setEqNo(customMnrEqStsVOS[i].getEqNo());

			//Damage Flag
			if(eQFlagListGRPVO.getEQFlagListINVO().getMnrFlgTpCd().equals("DMG")){
				//Flagging status
				if(customMnrEqStsVOS[i].getMnrDmgFlg().equals("0"))
					iFMnrFlagVO.setStsFlag("N");
				else
					iFMnrFlagVO.setStsFlag("Y");
				iFMnrFlagVO.setFlagDt(customMnrEqStsVOS[i].getMnrDmgFlgDt());
				iFMnrFlagVO.setFlagYdCd(customMnrEqStsVOS[i].getMnrDmgFlgYdCd());
		     }
			iFMnrFlagVOS.add(iFMnrFlagVO);
		}
		interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
		/***************** MST for outer interface call **********************/

		try {
			begin();
			//In case of existing "Damage unflagging"
			if(flgCnt > 0) {
				command2.manageEQFlagListBasic(eQFlagListGRPVO,account);	//Logic of Damage flagging
				command3.manageIFFlagBasic(interfaceGRPVO,account);			//MST outer interface call
			}

			repairResultGRPVO = command.manageRepairResultBasic(repairResultGRPVO, account);
			commit();

			RepairResultINVO repairResultINVO = new RepairResultINVO();

			repairResultGRPVO.setRepairResultINVO(repairResultINVO);
			eventResponse.setETCData(repairResultINVO.getColumnValues());

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * EES_MNR_0036 : Open <br>
	 * [EES_MNR_0036] Retrieve "M&R Document Transmission" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDocSendService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0036Event event = (EesMnr0036Event)e;
		RepairMgtBC command = new RepairMgtBCImpl();
		DocGRPVO docGRPVO = new DocGRPVO();

		try{
			docGRPVO = command.searchDocSendBasic(event.getDocGRPVO());

			eventResponse.setRsVoList(docGRPVO.getCustomDocHeaderVOs());

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0036 : W/O Send <br>
	 * [EES_MNR_0036] Modify "M&R Document Transmission" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDocSendService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0036Event event = (EesMnr0036Event)e;
		RepairMgtBC command = new RepairMgtBCImpl();
		InterfaceMgtBC command2 = new InterfaceMgtBCImpl();

		try{
			DocGRPVO docGRPVO = event.getDocGRPVO();
			CustomDocHeaderVO[] arrCustomDocHeaderVO = docGRPVO.getArrcustomDocHeaderVOs();
			String ifTrcSeq = "";

			begin();

			for ( int i = 0; i < arrCustomDocHeaderVO.length; i++ ) {

				CustomMnrOrdHdrVO customMnrOrdHdrVO = new CustomMnrOrdHdrVO();
				ifTrcSeq = "";

				if(arrCustomDocHeaderVO[i].getSel().equals("1")){

					if(arrCustomDocHeaderVO[i].getTrsmModCd().equals("E")||arrCustomDocHeaderVO[i].getTrsmModCd().equals("F")||arrCustomDocHeaderVO[i].getTrsmModCd().equals("M")){

						DocResultVO docResultVO = new DocResultVO();

						if(arrCustomDocHeaderVO[i].getWoTypeCode().equals("SPL")){
							docResultVO.setTmplMrd("EES_MNR_0183.mrd");
						}else if(arrCustomDocHeaderVO[i].getWoTypeCode().equals("EXT")){
							docResultVO.setTmplMrd("EES_MNR_0187.mrd");
						}else if(arrCustomDocHeaderVO[i].getWoTypeCode().equals("RFS")){
							docResultVO.setTmplMrd("EES_MNR_0231.mrd");
						}else{
							docResultVO.setTmplMrd("EES_MNR_0182.mrd");
						}

						docResultVO.setRdSubSysCd("MNR");
						docResultVO.setBatFlg("N");
						if(arrCustomDocHeaderVO[i].getTrsmModCd().equals("F")){
							if(arrCustomDocHeaderVO[i].getWoTypeCode().equals("EST")){
								docResultVO.setDocTitNm("Repair Approval(WO#: "+arrCustomDocHeaderVO[i].getMnrOrdSeq()+")");
							}else{
								docResultVO.setDocTitNm("MNR WO Notice(WO#: "+arrCustomDocHeaderVO[i].getMnrOrdSeq()+")");
							}
						}
						else{
							docResultVO.setDocTitNm(arrCustomDocHeaderVO[i].getDocSubject());
						}
						docResultVO.setEmlCtnt(arrCustomDocHeaderVO[i].getMemo());
						docResultVO.setTemplateArgs("/rv mnr_ord_ofc_cty_cd["+ arrCustomDocHeaderVO[i].getMnrOrdSeq().substring(0,3) +"] mnr_ord_seq[" + arrCustomDocHeaderVO[i].getMnrOrdSeq().substring(3) + "] user_nm[" + account.getUsr_nm() + "] memo[" + arrCustomDocHeaderVO[i].getMemo() + "] subject[" + arrCustomDocHeaderVO[i].getDocSubject() + "]");
						if(arrCustomDocHeaderVO[i].getTrsmModCd().equals("F")){
							docResultVO.setSndrNm(account.getUsr_nm());
						}else{
							docResultVO.setSndrNm("");
						}
						docResultVO.setFaxOffice(account.getOfc_cd());
						docResultVO.setReceiverRmail(arrCustomDocHeaderVO[i].getMnrPrnrEml());
						docResultVO.setSndrEml("shipment.info@notifications.nykline.com");
						docResultVO.setCreUsrId(account.getUsr_id());
						docResultVO.setEdiId(arrCustomDocHeaderVO[i].getEdiId());
						docResultVO.setMnrOrdOfcCtyCd(arrCustomDocHeaderVO[i].getMnrOrdSeq().substring(0,3));
						docResultVO.setMnrOrdSeq(arrCustomDocHeaderVO[i].getMnrOrdSeq().substring(3));

						String arrFaxNo[] = arrCustomDocHeaderVO[i].getFaxNo().split(",");
						StringBuffer faxNo = new StringBuffer();
						for(int j = 0; j < arrFaxNo.length;j++){
							if(j>0){
								faxNo.append(",").append(" ;").append(arrFaxNo[j]);
							}else{
								faxNo.append(" ;").append(arrFaxNo[j]);
							}
						}
						//FAX Format
						docResultVO.setFaxRcvInfo(arrCustomDocHeaderVO[i].getVndrLglEngNm()+faxNo.toString());
						docResultVO.setTemplateFile("");
						docResultVO.setTrsmModCd(arrCustomDocHeaderVO[i].getTrsmModCd());

						ifTrcSeq = command2.docSendBasic(docResultVO, account);
					}

					customMnrOrdHdrVO.setTrsmModCd(arrCustomDocHeaderVO[i].getTrsmModCd());
					customMnrOrdHdrVO.setOrdIssOfcCd(account.getOfc_cd());
					customMnrOrdHdrVO.setIfTrcSeq(ifTrcSeq);
					customMnrOrdHdrVO.setMnrOrdSeq(arrCustomDocHeaderVO[i].getMnrOrdSeq().substring(3));
					customMnrOrdHdrVO.setCreUsrId(account.getUsr_id());
					customMnrOrdHdrVO.setUpdUsrId(account.getUsr_id());
					docGRPVO.setCustomMnrOrdHdrVO(customMnrOrdHdrVO);

					docGRPVO = command.manageDocSendBasic(docGRPVO,account);
				}

			}
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0030 : Retrieve <br>
	 * [EES_MNR_0030] Retrieve "W/O Creation" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchESTWorkOrderListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0030Event event = (EesMnr0030Event)e;
			RepairMgtBC command = new RepairMgtBCImpl();
			ESTWOMainGRPVO eSTWOMainGRPVO = new ESTWOMainGRPVO();

			eSTWOMainGRPVO = command.searchESTWorkOrderListBasic(event.getESTWOMainGRPVO(), account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(eSTWOMainGRPVO.getCustomESTWOMainSMRVO());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0030 : Retrieve <br>
	 * [EES_MNR_0030] Retrieve "W/O Creation" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchESTWorkOrderDetailListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0030Event event = (EesMnr0030Event)e;
			RepairMgtBC command = new RepairMgtBCImpl();
			GeneralCodeSearchMgtBC command1 = new GeneralCodeSearchMgtBCImpl();
			ESTWOMainGRPVO eSTWOMainGRPVO = new ESTWOMainGRPVO();

			eSTWOMainGRPVO = command.searchESTWorkOrderDetailListBasic(event.getESTWOMainGRPVO(),account);
			//Booking/Trade Code 검색 로직
			List<CustomESTWOMainINFOVO> list = eSTWOMainGRPVO.getCustomESTWOMainINFOVO();
			if("I".equals(event.getESTWOMainGRPVO().getESTWOMainINVO().getStatus())){
				for(int i = 0; i < list.size(); i++){
					BkgTrdCodeVO bkgTrdCodeVO = new BkgTrdCodeVO();
					bkgTrdCodeVO.setEqType(list.get(i).getEqKndCd());
					bkgTrdCodeVO.setCostCd(list.get(i).getCostCd());
					bkgTrdCodeVO.setCostDtlCd("NR");
					bkgTrdCodeVO.setEqNo(list.get(i).getRqstEqNo());
					bkgTrdCodeVO.setRprRsltDt(list.get(i).getEqDmgDt());
					
					List<BkgTrdCodeVO> bkgTrdCd = command1.searchBkgTrdCdBasic(bkgTrdCodeVO);
					if(bkgTrdCd != null && bkgTrdCd.size() > 0){
						list.get(i).setBkgNo(bkgTrdCd.get(0).getBkgNo());
						list.get(i).setTrdCd(bkgTrdCd.get(0).getTrdCd());
					}
				}
			}
			
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0030 : W/O Creation <br>
	 * [EES_MNR_0030] Add "W/O Creation" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createESTWOCreationService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0030Event event = (EesMnr0030Event)e;

		RepairMgtBC command = new RepairMgtBCImpl();
		ESTWOMainGRPVO eSTWOMainGRPVO = event.getESTWOMainGRPVO();

		EQFlagMgtBC command2 = new EQFlagMgtBCImpl();
		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();

		CustomESTWOMainINFOVO[] arrayCustomESTWOMainINFOVOs = eSTWOMainGRPVO.getArrayCustomESTWOMainINFOVOs();
		CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[arrayCustomESTWOMainINFOVOs.length];
		CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[arrayCustomESTWOMainINFOVOs.length];
		int flgCnt = 0;

		for ( int i = 0; i < arrayCustomESTWOMainINFOVOs.length; i++ ) {
			String dmgFlg       = arrayCustomESTWOMainINFOVOs[i].getMnrDmgFlg();
			String hiddenDmgFlg = arrayCustomESTWOMainINFOVOs[i].getHiddenMnrDmgFlg();
			if(!dmgFlg.equals(hiddenDmgFlg)) {
				//STS VO
				CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
				customMnrEqStsVO.setEqNo(arrayCustomESTWOMainINFOVOs[i].getRqstEqNo());
				customMnrEqStsVO.setEqKndCd(arrayCustomESTWOMainINFOVOs[i].getEqKndCd());
				customMnrEqStsVO.setEqTpszCd(arrayCustomESTWOMainINFOVOs[i].getEqTpszCd());
				java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
				String today = formatter.format(new java.util.Date());
				customMnrEqStsVO.setMnrDmgFlgDt(today);
				customMnrEqStsVO.setMnrDmgFlgYdCd(arrayCustomESTWOMainINFOVOs[i].getRprYdCd());
				customMnrEqStsVO.setMnrStsRmk("From Estimate W/O Creation");
				customMnrEqStsVO.setMnrDmgFlg(dmgFlg);
				arrCustomMnrEqStsVOS[flgCnt] = customMnrEqStsVO;

				//FLG_HIS_VO
				CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
				customMnrFlgHisVO.setEqNo(arrayCustomESTWOMainINFOVOs[i].getRqstEqNo());
				customMnrFlgHisVO.setEqTpszCd(arrayCustomESTWOMainINFOVOs[i].getEqTpszCd());
				customMnrFlgHisVO.setMnrFlgTpCd("DMG");
				customMnrFlgHisVO.setMnrFlgInpTpCd("W");
				customMnrFlgHisVO.setEqKndCd(arrayCustomESTWOMainINFOVOs[i].getEqKndCd());
				customMnrFlgHisVO.setMnrFlgYdCd(arrayCustomESTWOMainINFOVOs[i].getRprYdCd());
				customMnrFlgHisVO.setMnrFlgInpDt(today);
				customMnrFlgHisVO.setMnrFlgRmk("From Estimate W/O Creation");
				customMnrFlgHisVO.setMnrStsFlg(dmgFlg);
				arrCustomMnrFlgHisVOS[flgCnt] = customMnrFlgHisVO;

				flgCnt++;
			}
		}
		EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
		eQFlagListINVO.setMnrFlgTpCd("DMG");
		eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
		eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
		eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
		//*************** FLAG END   ************************* //

		/***************** MST for outer interface call **********************/
		InterfaceMgtBC command3 = new InterfaceMgtBCImpl();
		InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
		List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
		if(flgCnt > 0) {
			for(int i = 0;i < arrCustomMnrEqStsVOS.length; i++){

				IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
				iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
				iFMnrFlagVO.setFlagUserId(account.getUsr_id());
				iFMnrFlagVO.setFlagType("DMG");
				iFMnrFlagVO.setRetireFlag("N");
				iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[i].getEqKndCd());
				iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[i].getEqNo());
				//Damage Flag
				if(arrCustomMnrEqStsVOS[i].getMnrDmgFlg().equals("1")){
					iFMnrFlagVO.setStsFlag("Y");
				} else {
					iFMnrFlagVO.setStsFlag("N");
				}
				iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[i].getMnrDmgFlgDt());
				iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDmgFlgYdCd());
				iFMnrFlagVOS.add(iFMnrFlagVO);
			}
			interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
		}
		/***************** MST for outer interface call **********************/

		try {
			begin();
			//In case of existing "Damage flagging"
			if(flgCnt > 0) {
				command2.manageEQFlagListBasic(eQFlagListGRPVO,account);	//Logic of Damage Flagging
				command3.manageIFFlagBasic(interfaceGRPVO,account);
			}
			eSTWOMainGRPVO = command.createESTWOCreationBasic(eSTWOMainGRPVO, account);		//Logic of "W/O Creation"
			commit();
			eventResponse.setETCData("wo_nos", eSTWOMainGRPVO.getWoNos());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0093 : Retrieve <br>
	 * [EES_MNR_0093] Retrieve "Scraping/Donation Creation" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExtraDisposalByEQService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0093Event event = (EesMnr0093Event)e;
			ExtraDisposalMgtBC command = new ExtraDisposalMgtBCImpl();
			ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO = new ExtraDisposalMgtGRPVO();

			extraDisposalMgtGRPVO = command.searchExtraDisposalByEQBasic(event.getExtraDisposalMgtGRPVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(extraDisposalMgtGRPVO.getListCustomMnrXtraDispVO());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0093 : checkDuplication <br>
	 * [EES_MNR_0093] Checking "Scraping/Donation Creation" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkExtraDisposalByEQService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		try {
			EesMnr0093Event event = (EesMnr0093Event)e;
			ExtraDisposalMgtBC command = new ExtraDisposalMgtBCImpl();
			ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO = new ExtraDisposalMgtGRPVO();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			extraDisposalMgtGRPVO = command.checkExtraDisposalByEQBasic(event.getExtraDisposalMgtGRPVO());
			eventResponse.setETCData("cnt", extraDisposalMgtGRPVO.getCnt());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0093 : Save <br>
	 * [EES_MNR_0093] Save "Scraping/Donation Creation" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageExtraDisposalByEQService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0093Event event = (EesMnr0093Event)e;
		ExtraDisposalMgtBC command = new ExtraDisposalMgtBCImpl();

		ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO = event.getExtraDisposalMgtGRPVO();

		try{
			CustomMnrXtraDispVO[]  arrayCustomMnrXtraDispVOs  = extraDisposalMgtGRPVO.getArrayCustomMnrXtraDispVOs();

			EQFlagMgtBC command2 = new EQFlagMgtBCImpl();
			EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();

			CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[arrayCustomMnrXtraDispVOs.length];
			CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[arrayCustomMnrXtraDispVOs.length];
			int flgCnt = 0;
			String mnrFlgTpCd = "";

			for ( int i = 0; i < arrayCustomMnrXtraDispVOs.length; i++ ) {
				String xtraDispStsCd	= arrayCustomMnrXtraDispVOs[i].getXtraDispStsCd();
				if(xtraDispStsCd.equals("HA")||xtraDispStsCd.equals("HC")) {
					//STS VO
					CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
					customMnrEqStsVO.setEqNo(arrayCustomMnrXtraDispVOs[i].getEqNo());
					customMnrEqStsVO.setEqKndCd(arrayCustomMnrXtraDispVOs[i].getEqKndCd());
					customMnrEqStsVO.setEqTpszCd(arrayCustomMnrXtraDispVOs[i].getEqTpszCd());
					java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
					String today = formatter.format(new java.util.Date());
					customMnrEqStsVO.setMnrDmgFlgDt(today);
					customMnrEqStsVO.setMnrDmgFlgYdCd(arrayCustomMnrXtraDispVOs[i].getIssYdCd());
					customMnrEqStsVO.setMnrStsRmk("From Scrapping/Donation Creation");
					if(xtraDispStsCd.equals("HA")) { //Confirm
						customMnrEqStsVO.setMnrDmgFlg("1");
					} else if(xtraDispStsCd.equals("HC")) {  //Cancel
						customMnrEqStsVO.setMnrDmgFlg("0");
					}
					arrCustomMnrEqStsVOS[flgCnt] = customMnrEqStsVO;

					//FLG_HIS_VO
					CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
					customMnrFlgHisVO.setEqNo(arrayCustomMnrXtraDispVOs[i].getEqNo());
					customMnrFlgHisVO.setEqTpszCd(arrayCustomMnrXtraDispVOs[i].getEqTpszCd());
					String mnrXtraDispTpCd = arrayCustomMnrXtraDispVOs[i].getMnrXtraDispTpCd();

					if(mnrXtraDispTpCd.equals("SCR")) {
						mnrFlgTpCd = mnrXtraDispTpCd;
						customMnrFlgHisVO.setMnrFlgInpTpCd("C");
					} else if(mnrXtraDispTpCd.equals("DON")){
						mnrFlgTpCd = mnrXtraDispTpCd;
						customMnrFlgHisVO.setMnrFlgInpTpCd("N");
					} else {
						mnrFlgTpCd = mnrXtraDispTpCd;
						customMnrFlgHisVO.setMnrFlgInpTpCd("O");
					}
					customMnrFlgHisVO.setMnrFlgTpCd(mnrFlgTpCd);

					customMnrFlgHisVO.setEqKndCd(arrayCustomMnrXtraDispVOs[i].getEqKndCd());
					customMnrFlgHisVO.setMnrFlgYdCd(arrayCustomMnrXtraDispVOs[i].getIssYdCd());
					customMnrFlgHisVO.setMnrFlgInpDt(today);
					customMnrFlgHisVO.setMnrFlgRmk("From Scrapping/Donation Creation");
					if(xtraDispStsCd.equals("HA")) {  //Confirm
						customMnrFlgHisVO.setMnrStsFlg("Y");
					} else if(xtraDispStsCd.equals("HC")) {//Cancel
						customMnrFlgHisVO.setMnrStsFlg("N");
					}
					arrCustomMnrFlgHisVOS[flgCnt] = customMnrFlgHisVO;

					flgCnt++;
				}
			}
			EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
			eQFlagListINVO.setMnrFlgTpCd(mnrFlgTpCd);
			eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
			eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
			eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
			//*************** FLAG END   ************************* //

			/***************** MST for outer interface call **********************/
			InterfaceMgtBC command3 = new InterfaceMgtBCImpl();
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
			if(flgCnt > 0) {
				for(int i = 0;i < arrCustomMnrEqStsVOS.length; i++){
					IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
					iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
					iFMnrFlagVO.setFlagUserId(account.getUsr_id());
					iFMnrFlagVO.setFlagType(mnrFlgTpCd);
					iFMnrFlagVO.setRetireFlag("N");
					iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[i].getEqKndCd());
					iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[i].getEqNo());
					//Damage Flag
					if(arrCustomMnrEqStsVOS[i].getMnrDmgFlg().equals("1")){
						iFMnrFlagVO.setStsFlag("Y");
					} else {
						iFMnrFlagVO.setStsFlag("N");
					}
					iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[i].getMnrDmgFlgDt());
					iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDmgFlgYdCd());
					iFMnrFlagVOS.add(iFMnrFlagVO);
				}
				interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
			}
			/***************** MST for outer interface call **********************/

			begin();

			//In Case of "Confirm" or "Cancel"
			if(flgCnt > 0) {
				command2.manageEQFlagListBasic(eQFlagListGRPVO,account);	//Logic of "Damage Flagging"
				command3.manageIFFlagBasic(interfaceGRPVO,account);         //Logic of "MST/CGM"
			}

			command.manageExtraDisposalByEQBasic(event.getExtraDisposalMgtGRPVO(), account);
			
			//FA Send
			//2013.10.02 Kyoung Wan CHO add
//			InterfaceMgtBC command4	= new 	InterfaceMgtBCImpl();
//			FaErpListVO[] arrayfaErpListVOs = new FaErpListVO[arrayCustomMnrXtraDispVOs.length];
//			String ymdhms = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
//			String ymdhm = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
//
//			for ( int i=0; i< arrayCustomMnrXtraDispVOs.length; i++ ) {
//				if(arrayCustomMnrXtraDispVOs[i] == null)break;
//
//				if ( arrayCustomMnrXtraDispVOs[i].getXtraDispStsCd().equals("HA")){
//					FaErpListVO faErpListVO = new FaErpListVO();
//					faErpListVO.setLifid("FNS027-0001");
//					faErpListVO.setSeq(ymdhms + arrayCustomMnrXtraDispVOs[i].getEqNo());
//					faErpListVO.setTotalCount("1");
//					faErpListVO.setRnum("1");
//					//Tag Number search start////////////////////////////////
//					String faEqNo = "";
//					String eqNo		= arrayCustomMnrXtraDispVOs[i].getEqNo();
//					faEqNo	= command4.searchFAEqNoBasic(eqNo);
//					faErpListVO.setTagNumber(faEqNo);
//					//Tag Number search end//////////////////////////////////
//					faErpListVO.setBookTypeCode("OPUS GAAP BOOK");
//					faErpListVO.setDateRetired(arrayCustomMnrXtraDispVOs[i].getIssDt().replace("-", ""));
//					faErpListVO.setUnitsRetired("1");
//					faErpListVO.setProceedsOfSale("0");
//					String mnrXtraDispTpCd = arrayCustomMnrXtraDispVOs[i].getMnrXtraDispTpCd();
//					if(mnrXtraDispTpCd.equals("DON")) {
//						faErpListVO.setRetirementTypeCode("DONATION");
//					} else {
//						// Scrapping도 Donation으로 처리하라는 FA 요청 : 2010.03.20
//						faErpListVO.setRetirementTypeCode("DONATION");
//						//faErpListVO.setRetirementTypeCode("SCRAPPING");
//					}
//					faErpListVO.setInterfaceFlag("N");
//					faErpListVO.setCreationDate(ymdhm);
//					faErpListVO.setLastUpdateDate(ymdhm);
//					faErpListVO.setSoldTo("136514");
//					faErpListVO.setAttribute2("USD");
//
//					arrayfaErpListVOs[i] = faErpListVO;

					//전송
//					command4.faSendBasic(arrayfaErpListVOs, account, "SCR"); // Scrapping/Donation Creation 구분(SCR)
//				}
//			}
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0094 : Retrieve <br>
	 * [EES_MNR_0094] Retrieve "Scraping/Donation Inquiry" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchExtraDisposalListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0094Event event = (EesMnr0094Event)e;
			ExtraDisposalMgtBC command = new ExtraDisposalMgtBCImpl();
			ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO = new ExtraDisposalMgtGRPVO();

			extraDisposalMgtGRPVO = command.searchExtraDisposalListBasic(event.getExtraDisposalMgtGRPVO(),account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(extraDisposalMgtGRPVO.getListCustomMnrXtraDispVO());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0195 : Retrieve <br>
	 * [EES_MNR_0195] Retrieve "Total Loss No Inquiry_Pop-up" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTotalLossInfoByOFCListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnr0195Event event = (EesMnr0195Event)e;
			TotalLossMgtBC command = new TotalLossMgtBCImpl();
			TotalLossInfoGRPVO totalLossInfoGRPVO = new TotalLossInfoGRPVO();

			totalLossInfoGRPVO = command.searchTotalLossInfoByOFCListBasic(event.getTotalLossInfoGRPVO(),account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(totalLossInfoGRPVO.getListCustomMnrTtlLssRqstHdrVOs());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0098 : Retrieve <br>
	 * [EES_MNR_0098] Retrieve "Total Loss Management" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTotalLossListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TotalLossMgtBC command = new TotalLossMgtBCImpl();

		TotalLossGRPVO totalLossGRPVO = new TotalLossGRPVO();
		if(e.getEventName().equalsIgnoreCase("EesMnr0098Event")){
			EesMnr0098Event event = (EesMnr0098Event)e;
			totalLossGRPVO = event.getTotalLossGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0096Event")){
			EesMnr0096Event event = (EesMnr0096Event)e;
			totalLossGRPVO = event.getTotalLossGRPVO();
		}

		try{
			totalLossGRPVO = command.searchTotalLossListBasic(totalLossGRPVO,account);

			eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO());
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0096 : Retrieve <br>
	 * [EES_MNR_0096] Retrieve "Total Loss Request" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTotalLossService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TotalLossMgtBC command = new TotalLossMgtBCImpl();

		TotalLossGRPVO totalLossGRPVO = new TotalLossGRPVO();
		if(e.getEventName().equalsIgnoreCase("EesMnr0095Event")){
			EesMnr0095Event event = (EesMnr0095Event)e;
			totalLossGRPVO = event.getTotalLossGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0096Event")){
			EesMnr0096Event event = (EesMnr0096Event)e;
			totalLossGRPVO = event.getTotalLossGRPVO();
		}

		try{
			totalLossGRPVO = command.searchTotalLossBasic(totalLossGRPVO,account);

			//Retrieve header data
			eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO());

			//Retrieve detail data
			for (int i = 0; i < totalLossGRPVO.getListCustomMnrTtlLssRqstDtlVOs().size(); i++) {
				eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstDtlVOs().get(i));
			}

		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0098 : doActionIBSheet <br>
	 * [EES_MNR_0098] Retrieve "Total Loss Collection & Inquiry" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTotalLossWithCLTService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		TotalLossMgtBC command = new TotalLossMgtBCImpl();

		TotalLossGRPVO totalLossGRPVO = new TotalLossGRPVO();
		if(e.getEventName().equalsIgnoreCase("EesMnr0098Event")){
			EesMnr0098Event event = (EesMnr0098Event)e;
			totalLossGRPVO = event.getTotalLossGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0234Event")){
			EesMnr0234Event event = (EesMnr0234Event)e;
			totalLossGRPVO = event.getTotalLossGRPVO();
		}

		try{
			totalLossGRPVO = command.searchTotalLossBasic(totalLossGRPVO,account);
			totalLossGRPVO = command.searchTotalLossWithCLTBasic(totalLossGRPVO,account);

			//Retrieve header data
			eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO());

			//Retrieve detail data
			for (int i = 0; i < totalLossGRPVO.getListCustomMnrTtlLssRqstDtlVOs().size(); i++) {
				eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstDtlVOs().get(i));
			}

			//  Total Loss Collection
			eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssCltVOS());

		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0098 : Save <br>
	 * [EES_MNR_0098] Save "Total Loss Request" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageTotalLossService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		StatusHistoryMgtBC command2 = new StatusHistoryMgtBCImpl();
		StatusHistoryGRPVO statusHistoryGRPVO = new StatusHistoryGRPVO();

		TotalLossMgtBC command = new TotalLossMgtBCImpl();

		TotalLossGRPVO totalLossGRPVO = new TotalLossGRPVO();
		if(e.getEventName().equalsIgnoreCase("EesMnr0098Event")){
			EesMnr0098Event event = (EesMnr0098Event)e;
			totalLossGRPVO = event.getTotalLossGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0096Event")){
			EesMnr0096Event event = (EesMnr0096Event)e;
			totalLossGRPVO = event.getTotalLossGRPVO();
		} else if(e.getEventName().equalsIgnoreCase("EesMnr0095Event")){
			EesMnr0095Event event = (EesMnr0095Event)e;
			totalLossGRPVO = event.getTotalLossGRPVO();
		}

		try{
			begin();

			String ttlLssStsCd = totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getTtlLssStsCd();
			CustomMnrTtlLssRqstDtlVO[]  arrayCustomMnrTtlLssRqstDtlVOs  = totalLossGRPVO.getArrayCustomMnrTtlLssRqstDtlVOs();
			int payInvSeqCnt = 0;
			String[] arrayPayInvSeq = null;
			//////////////////////////////////////////////////////////////////////////////////////////////////
			//Begin Saving
			//////////////////////////////////////////////////////////////////////////////////////////////////
			//Saving "Total Loss History"
			String mnrStsRefNo = "";
			if(totalLossGRPVO.getArrayCustomMnrStsHisVO() != null) {
				statusHistoryGRPVO.setArrayCustomMnrStsHisVO(totalLossGRPVO.getArrayCustomMnrStsHisVO());
				statusHistoryGRPVO = command2.manageStatusHistorysBasic(statusHistoryGRPVO, account);
				mnrStsRefNo = statusHistoryGRPVO.getMnrStsRefNo();
			}

			//Saving "Total Loss Request"
			totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().setMnrStsRefNo(mnrStsRefNo);
			totalLossGRPVO = command.manageTotalLossBasic(totalLossGRPVO, account);
			//////////////////////////////////////////////////////////////////////////////////////////////////
			//End Saving
			//////////////////////////////////////////////////////////////////////////////////////////////////

			//Confirm
			if(ttlLssStsCd.equals("HA")) {
				EQFlagMgtBC command3 = new EQFlagMgtBCImpl();
				EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
				int delCnt=0;       // Deleted Count
				int dvCnt=0;		// DV DTL Count
				int dvDelCnt=0;	    // Deleted "DV DTL" Count

				for ( int i = 0; i < arrayCustomMnrTtlLssRqstDtlVOs.length; i++ ) {
					//Increase deleted data DTL count
					if(arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D"))delCnt++;

					if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV"))
					{
						if(!"OW".equals(arrayCustomMnrTtlLssRqstDtlVOs[i].getLstmCd())){
							command.modifyTotalLossRevVvdBasic(arrayCustomMnrTtlLssRqstDtlVOs[i], totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getTtlLssDt(), account);
						}
						dvCnt++; //Increase "DV DTL" 갯수 계산
						if(arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D"))dvDelCnt++;
					}
				}
				
				int flgCnt = 0;
				if(!e.getEventName().equalsIgnoreCase("EesMnr0098Event"))
				{
					CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[dvCnt];
					CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[dvCnt];
					for ( int i = 0; i < arrayCustomMnrTtlLssRqstDtlVOs.length; i++ ) {

						if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV"))
						{
							//STS VO
							CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
							customMnrEqStsVO.setEqNo(arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo());
							customMnrEqStsVO.setEqKndCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqKndCd());
							customMnrEqStsVO.setEqTpszCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqTpszCd());
							java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
							String today = formatter.format(new java.util.Date());
							customMnrEqStsVO.setMnrStsRmk("From Total Loss Management");
							String iBflag=arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().toUpperCase();
							if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV"))
							{
								//STS VO
								customMnrEqStsVO.setMnrDmgFlgDt(today);
								customMnrEqStsVO.setMnrDmgFlgYdCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssYdCd());
								customMnrEqStsVO.setMnrDmgFlg((iBflag.equals("D"))?"0":"1");
								arrCustomMnrEqStsVOS[flgCnt] = customMnrEqStsVO;

								//FLG_HIS_VO
								CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
								customMnrFlgHisVO.setEqNo(arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo());
								customMnrFlgHisVO.setEqKndCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqKndCd());
								customMnrFlgHisVO.setEqTpszCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqTpszCd());
								customMnrFlgHisVO.setMnrFlgYdCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssYdCd());
								customMnrFlgHisVO.setMnrFlgInpTpCd("T");
								customMnrFlgHisVO.setMnrFlgTpCd("TLL");
								customMnrFlgHisVO.setMnrFlgInpDt(today);
								customMnrFlgHisVO.setMnrFlgRmk("From Total Loss Management");
								customMnrFlgHisVO.setMnrStsFlg((iBflag.equals("D"))?"N":"Y");
								arrCustomMnrFlgHisVOS[flgCnt] = customMnrFlgHisVO;
								flgCnt++;
							}
						}
					}
					EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
					eQFlagListINVO.setMnrFlgTpCd("TLL");
					eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
					eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
					eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
					//*************** FLAG END   ************************* //

					/***************** MST for outer interface call **********************/
					InterfaceMgtBC command4 = new InterfaceMgtBCImpl();
					InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
					List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
					String ttlLssNtfyDt=totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getTtlLssIssDt();
					ttlLssNtfyDt=ttlLssNtfyDt.replaceAll("-","");

					for(int i = 0;i < arrCustomMnrEqStsVOS.length; i++){
						IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
						iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
						iFMnrFlagVO.setFlagUserId(account.getUsr_id());
						iFMnrFlagVO.setFlagType("TLL");
						iFMnrFlagVO.setRetireFlag("N");
						iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[i].getEqKndCd());
						iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDispFlgYdCd());
						iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[i].getEqNo());
						//Damage Flag
						if(arrCustomMnrEqStsVOS[i].getMnrDmgFlg().equals("1")){
							iFMnrFlagVO.setStsFlag("Y");
						} else {
							iFMnrFlagVO.setStsFlag("N");
						}
						//iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[i].getMnrDmgFlgDt());
						iFMnrFlagVO.setFlagDt(totalLossGRPVO.getTotalLossINVO().getTtlLssDt().replaceAll("-",""));
						iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDmgFlgYdCd());
						iFMnrFlagVO.setTtlLssNtfyDt(ttlLssNtfyDt);
						iFMnrFlagVOS.add(iFMnrFlagVO);
					}
					interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);

					/***************** MST for outer interface call **********************/
					command3.manageEQFlagListBasic(eQFlagListGRPVO,account);
					command4.manageIFFlagBasic(interfaceGRPVO,account);

					/** Begin add MNR_PAY_INV_WRK **********************************************/
					ExpenseMgtBC command5 = new ExpenseMgtBCImpl();
					PayableInvoiceGRPVO payableInvoiceGRPVO = new PayableInvoiceGRPVO();
					String ttlLssNo = totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getTtlLssNo();
					String ttlLssIssDt = totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getTtlLssIssDt();
					payableInvoiceGRPVO.setTtlLssNo(ttlLssNo);
					payableInvoiceGRPVO.setTtlLssIssDt(ttlLssIssDt);//Assign Issue Date
					String ttlLssDtlSeq ="0";
					for(int i=0; i<arrayCustomMnrTtlLssRqstDtlVOs.length; i++) {
						if(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssDtlSeq().equalsIgnoreCase(""))
						{
							ttlLssDtlSeq = String.valueOf(Integer.valueOf(ttlLssDtlSeq)+1);
						}else{
							ttlLssDtlSeq = arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssDtlSeq();
						}

						if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D")){
							String mnrInvTpCd = arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd();
							String lstmCd = arrayCustomMnrTtlLssRqstDtlVOs[i].getLstmCd();
							if(mnrInvTpCd.equals("DV")) {
								if(!"OW".equals(lstmCd)){
									payableInvoiceGRPVO.setTtlLssDtlSeq(ttlLssDtlSeq);
									arrayPayInvSeq = command5.manageTotalLossPayableInvoiceBasic(payableInvoiceGRPVO, account);
									arrayCustomMnrTtlLssRqstDtlVOs[i].setPayInvSeq(arrayPayInvSeq[0]);
									payInvSeqCnt++;
								}
							}
						}
					}

					arrayPayInvSeq=null;
					arrayPayInvSeq=new String[payInvSeqCnt];
					payInvSeqCnt=0;
					for(int i=0; i<arrayCustomMnrTtlLssRqstDtlVOs.length; i++) {
						if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D")){
							String mnrInvTpCd = arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd();
							String lstmCd = arrayCustomMnrTtlLssRqstDtlVOs[i].getLstmCd();
							if(mnrInvTpCd.equals("DV")) {
								if(!"OW".equals(lstmCd)){
									arrayPayInvSeq[payInvSeqCnt]=arrayCustomMnrTtlLssRqstDtlVOs[i].getPayInvSeq();
									payInvSeqCnt++;
								}
							}
						}
					}

					totalLossGRPVO.setArrayCustomMnrTtlLssRqstDtlVOs(arrayCustomMnrTtlLssRqstDtlVOs);
					totalLossGRPVO = command.modifyTotalLossDetailBasic(totalLossGRPVO, account);
					/** End add MNR_PAY_INV_WRK *************************************************/

					/** Begin insert into table CSR Temp *****************************************************************/
					InterfaceMgtBC command6 = new InterfaceMgtBCImpl();
					ExpenseMgtBC command7 = new ExpenseMgtBCImpl();
					if(payInvSeqCnt > 0) {
						String invRgstNo = "";
						for(int i=0; i<arrayPayInvSeq.length; i++) {
							invRgstNo = command6.createCSRIFBasic("TLL", arrayPayInvSeq[i], account);
							command7.modifyTotalLossPayableInvoiceBasic(arrayPayInvSeq[i], invRgstNo, account);
						}
					}

					/** end insert into temporary table CSR ********************************************************************/

					/** Begin roll-back temporary table NR_PAY_INV_WRK, CSR *****************************************************************/
					InterfaceMgtBC command8 = new InterfaceMgtBCImpl();
					ExpenseMgtBC command9 = new ExpenseMgtBCImpl();
					for ( int i = 0; i < arrayCustomMnrTtlLssRqstDtlVOs.length; i++ ) {
						if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV")){
							if(arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D"))
							{
								/** Begin roll-back temporary table CSR *******************************************************/
								if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getInvRgstNo().equalsIgnoreCase("")
									&& arrayCustomMnrTtlLssRqstDtlVOs[i].getInvRgstNo().length()>=13 )
								{
									//AP_PAY_INV  update DELT_FLG = 'Y'
									command8.removeCSRIFBasic(arrayCustomMnrTtlLssRqstDtlVOs[i].getInvRgstNo(), account);
									//MNR_PAY_INV_WRK delete where pay_inv_seq
									if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getPayInvSeq().equalsIgnoreCase(""))
									{
										PayableINVInquiryINVO payableINVInquiryINVO = new PayableINVInquiryINVO();
										payableINVInquiryINVO.setPayInvSeq(arrayCustomMnrTtlLssRqstDtlVOs[i].getPayInvSeq());
										payableInvoiceGRPVO.setPayableINVInquiryINVO(payableINVInquiryINVO);
										command9.removePayableInvoiceBasic(payableInvoiceGRPVO,account);
									}
								}
								/** End roll-back temporary table CSR **********************************************************/
							}
						}
					}
					/** End roll-back temporary table NR_PAY_INV_WRK, CSR *****************************************************************/
					
					//FA Sending
					//2013.10.02 Kyoung Wan CHO Add
//					InterfaceMgtBC command10	= new 	InterfaceMgtBCImpl();

//					List<FaErpListVO> fMnrFlagVOS = new ArrayList<FaErpListVO>();
//					String ymdhms = (new SimpleDateFormat("yyyyMMddHHmmss")).format(new Date());
//					String ymdhm  = (new SimpleDateFormat("yyyyMMdd")).format(new Date());
//					int faErpCnt = 0;
//					for ( int i=0; i< arrayCustomMnrTtlLssRqstDtlVOs.length; i++ ) {
//						if(arrayCustomMnrTtlLssRqstDtlVOs[i] == null)break;
//						if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV"))
//						{
//							if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D")){
//								FaErpListVO faErpListVO = new FaErpListVO();
//								faErpListVO.setLifid("FNS027-0001");
//								faErpListVO.setSeq(ymdhms + arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo());
//								faErpListVO.setRnum(String.valueOf(faErpCnt+1));
//								//Tag Number search start////////////////////////////////
//								String faEqNo = "";
//								String eqNo		= arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo();
//								faEqNo			= command10.searchFAEqNoBasic(eqNo);
//								faErpListVO.setTagNumber(faEqNo);
//								//Tag Number search end//////////////////////////////////
//								faErpListVO.setBookTypeCode("OPUS GAAP BOOK");
//								faErpListVO.setDateRetired(ttlLssIssDt.replace("-", ""));
//								faErpListVO.setUnitsRetired("1");
//								faErpListVO.setProceedsOfSale(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssBilAmt());
//								faErpListVO.setInvoiceNo(arrayCustomMnrTtlLssRqstDtlVOs[i].getInvNo());
//								//내부적으로는 TTL로 하기로 했으나 ERP로는 TTL로 넘겨야함
//								faErpListVO.setRetirementTypeCode("TTL");
//								faErpListVO.setInterfaceFlag("N");
//								faErpListVO.setCreationDate(ymdhm);
//								faErpListVO.setLastUpdateDate(ymdhm);
//								faErpListVO.setSoldTo("136514");
//								//추가 2010-07-08
//								faErpListVO.setLclAmt(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssBilAmt());
//							    faErpListVO.setLclCurr(arrayCustomMnrTtlLssRqstDtlVOs[i].getCurrCd());
//
//								fMnrFlagVOS.add(faErpListVO);
//								faErpCnt++;
//							}
//						}
//				    }
//
//					//List to Array
//					FaErpListVO[] arrayFaErpListVOs = new FaErpListVO[fMnrFlagVOS.size()];
//					for (int i = 0; i < fMnrFlagVOS.size(); i++) {
//						arrayFaErpListVOs[i] = fMnrFlagVOS.get(i);
//						arrayFaErpListVOs[i].setTotalCount(fMnrFlagVOS.size() + "");
//					}

					//Sending
//					command10.faSendBasic(arrayFaErpListVOs, account, "TTL"); // Total Loss Request(TTL)
				}else if(ttlLssStsCd.equals("HA") && e.getEventName().equalsIgnoreCase("EesMnr0098Event")) {
					CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[dvDelCnt];
					CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[dvDelCnt];
					for ( int i = 0; i < arrayCustomMnrTtlLssRqstDtlVOs.length; i++ ) {
						if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV")
							&& arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D"))
						{
							//STS VO
							CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
							customMnrEqStsVO.setEqNo(arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo());
							customMnrEqStsVO.setEqKndCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqKndCd());
							customMnrEqStsVO.setEqTpszCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqTpszCd());
							java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
							String today = formatter.format(new java.util.Date());
							customMnrEqStsVO.setMnrStsRmk("From Total Loss Management");
							if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV") )
							{
								//STS VO
								customMnrEqStsVO.setMnrDmgFlgDt(today);
								customMnrEqStsVO.setMnrDmgFlgYdCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssYdCd());
								customMnrEqStsVO.setMnrDmgFlg("0");
								arrCustomMnrEqStsVOS[flgCnt] = customMnrEqStsVO;

								//FLG_HIS_VO
								CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
								customMnrFlgHisVO.setEqNo(arrayCustomMnrTtlLssRqstDtlVOs[i].getRqstEqNo());
								customMnrFlgHisVO.setEqKndCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqKndCd());
								customMnrFlgHisVO.setEqTpszCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getEqTpszCd());
								customMnrFlgHisVO.setMnrFlgYdCd(arrayCustomMnrTtlLssRqstDtlVOs[i].getTtlLssYdCd());
								customMnrFlgHisVO.setMnrFlgInpTpCd("T");
								customMnrFlgHisVO.setMnrFlgTpCd("TLL");
								customMnrFlgHisVO.setMnrFlgInpDt(today);
								customMnrFlgHisVO.setMnrFlgRmk("From Total Loss Management");
								customMnrFlgHisVO.setMnrStsFlg("N");
								arrCustomMnrFlgHisVOS[flgCnt] = customMnrFlgHisVO;
								flgCnt++;
							}
						}
					}
					EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
					eQFlagListINVO.setMnrFlgTpCd("TLL");
					eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
					eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
					eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
					//*************** FLAG END   ************************* //

					/***************** MST for outer interface call **********************/
					InterfaceMgtBC command4 = new InterfaceMgtBCImpl();
					InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
					List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();

					for(int i = 0;i < arrCustomMnrEqStsVOS.length; i++){
						IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
						iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
						iFMnrFlagVO.setFlagUserId(account.getUsr_id());
						iFMnrFlagVO.setFlagType("TLL");
						iFMnrFlagVO.setRetireFlag("N");
						iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[i].getEqKndCd());
						iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDispFlgYdCd());
						iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[i].getEqNo());
						//Damage Flag
						iFMnrFlagVO.setStsFlag("N");
						iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[i].getMnrDmgFlgDt());
						iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[i].getMnrDmgFlgYdCd());
						iFMnrFlagVOS.add(iFMnrFlagVO);
					}
					interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
					/***************** MST for outer interface call *********************/
					
					command3.manageEQFlagListBasic(eQFlagListGRPVO,account);
					command4.manageIFFlagBasic(interfaceGRPVO,account);

					/** Add MNR_PAY_INV_WRK **********************************************/


					/** Begin roll-back temporary table NR_PAY_INV_WRK, CSR **************************************************************/
					PayableInvoiceGRPVO payableInvoiceGRPVO = new PayableInvoiceGRPVO();
					String ttlLssNo = totalLossGRPVO.getArrayCustomMnrTtlLssRqstHdrVO().getTtlLssNo();
					payableInvoiceGRPVO.setTtlLssNo(ttlLssNo);
					InterfaceMgtBC command8 = new InterfaceMgtBCImpl();
					ExpenseMgtBC command9 = new ExpenseMgtBCImpl();
					for ( int i = 0; i < arrayCustomMnrTtlLssRqstDtlVOs.length; i++ ) {
						if(arrayCustomMnrTtlLssRqstDtlVOs[i].getMnrInvTpCd().equalsIgnoreCase("DV")){
							if(arrayCustomMnrTtlLssRqstDtlVOs[i].getIbflag().equalsIgnoreCase("D"))
							{
								/** Begin roll-back temporary table CSR *****************************************************************/
								if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getInvRgstNo().equalsIgnoreCase("")
									&& arrayCustomMnrTtlLssRqstDtlVOs[i].getInvRgstNo().length()>=13 )
								{
									//AP_PAY_INV  update DELT_FLG = 'Y'
									command8.removeCSRIFBasic(arrayCustomMnrTtlLssRqstDtlVOs[i].getInvRgstNo(), account);
									//MNR_PAY_INV_WRK delete where pay_inv_seq
									if(!arrayCustomMnrTtlLssRqstDtlVOs[i].getPayInvSeq().equalsIgnoreCase(""))
									{
										PayableINVInquiryINVO payableINVInquiryINVO = new PayableINVInquiryINVO();
										payableINVInquiryINVO.setPayInvSeq(arrayCustomMnrTtlLssRqstDtlVOs[i].getPayInvSeq());
										payableInvoiceGRPVO.setPayableINVInquiryINVO(payableINVInquiryINVO);
										command9.removePayableInvoiceBasic(payableInvoiceGRPVO,account);
									}
								}
								/** End roll-back temporary table CSR *****************************************************************/
							}
						}
					}
					/** End roll-back temporary table NR_PAY_INV_WRK, CSR **************************************************************/
				}
			}
			commit();
			//Total Loss No return
			eventResponse.setETCData("totalLossNo", totalLossGRPVO.getTotalLossNo());
			String workType = totalLossGRPVO.getTotalLossINVO().getWorkType();
			if(!workType.equals("request")) {
				totalLossGRPVO = command.searchTotalLossListBasic(totalLossGRPVO,account);
			}
			eventResponse.setRsVoList(totalLossGRPVO.getListCustomMnrTtlLssRqstHdrVO());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0160 : Retrieve <br>
	 * [EES_MNR_0160] Retrieve "Disposal Sold Creation" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalSoldListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			EesMnr0160Event event = (EesMnr0160Event)e;
			DisposalSoldGRPVO disposalSoldGRPVO = new DisposalSoldGRPVO();

			disposalSoldGRPVO = command.searchDisposalSoldListBasic(event.getDisposalSoldGRPVO(), account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(disposalSoldGRPVO.getListCustomMnrDispHdrVO());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0160 : Retrieve <br>
	 * [EES_MNR_0160] Retrieve "Disposal Sold Creation" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalSoldDetailService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DisposalMgtBC command = new DisposalMgtBCImpl();
		EesMnr0160Event event = (EesMnr0160Event)e;
		DisposalSoldGRPVO disposalSoldGRPVO = new DisposalSoldGRPVO();
		try {
			begin();
			disposalSoldGRPVO = command.searchDisposalSoldDetailBasic(event.getDisposalSoldGRPVO(),account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		eventResponse.setRsVoList(disposalSoldGRPVO.getListCustomMnrDispDtlVO());

		return eventResponse;
	}

	/**
	 * EES_MNR_0163 : Retrieve <br>
	 * [EES_MNR_0163] Retrieve "Disposal Invoice Inquiry" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalInquiryListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			DisposalInquiryGRPVO disposalInquiryGRPVO = new DisposalInquiryGRPVO();

			if (e.getEventName().equalsIgnoreCase("EesMnr0163Event")) {
				EesMnr0163Event event = (EesMnr0163Event)e;
				disposalInquiryGRPVO = event.getDisposalInquiryGRPVO();
			}else if (e.getEventName().equalsIgnoreCase("EesMnrS308Event")) {
				EesMnrS308Event event = (EesMnrS308Event)e;
				disposalInquiryGRPVO = event.getDisposalInquiryGRPVO();
			}

			disposalInquiryGRPVO = command.searchDisposalInquiryListBasic(disposalInquiryGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(disposalInquiryGRPVO.getCustomMnrRcvInvWrkVOs());

			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0163 : Invoice Detail <br>
	 * [EES_MNR_0163] Retrieve "Disposal Invoice Detail" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalDetailInquiryListService(Event e) throws EventException {
		try {
		 	// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			DisposalInquiryGRPVO disposalInquiryGRPVO = null;

			EesMnr0163Event event = (EesMnr0163Event)e;
			disposalInquiryGRPVO = event.getDisposalInquiryGRPVO();

			disposalInquiryGRPVO = command.searchDisposalDetailInquiryListBasic(disposalInquiryGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(disposalInquiryGRPVO.getCustomDispInvDtIVOs());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0163 : Collection Info <br>
	 * [EES_MNR_0163] Retrieve "Disposal Invoice Collection" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDisposalCollectionInquiryListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			DisposalInquiryGRPVO disposalInquiryGRPVO = null;

			EesMnr0163Event event = (EesMnr0163Event)e;
			disposalInquiryGRPVO = event.getDisposalInquiryGRPVO();

			disposalInquiryGRPVO = command.searchDisposalCollectionInquiryListBasic(disposalInquiryGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(disposalInquiryGRPVO.getCustomBkgOtsDtlVOs());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_0160 : Save <br>
	 * [EES_MNR_0160] Save "Disposal Sold Creation" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDisposalSoldService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DisposalMgtBC command = new DisposalMgtBCImpl();
		EesMnr0160Event event = (EesMnr0160Event)e;

		EQFlagMgtBC command2 = new EQFlagMgtBCImpl();
		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();

		//Retrieve Flagging Row
		DisposalSoldGRPVO disposalSoldGRPVO = event.getDisposalSoldGRPVO();
		CustomMnrDispDtlVO[] arrayCustomMnrDispDtlVOs = disposalSoldGRPVO.getArrayCustomMnrDispDtlVO();
		int flgCnt = 0;
		for ( int i = 0; i < arrayCustomMnrDispDtlVOs.length; i++ ) {
			String dispSoldDtFlg = arrayCustomMnrDispDtlVOs[i].getDispSoldDtFlg();
			if(dispSoldDtFlg.equals("Y")||dispSoldDtFlg.equals("N")) {
				flgCnt++;
			} else if (dispSoldDtFlg.equals("U")) {
				flgCnt = flgCnt + 2;
			}
		}
		CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[flgCnt];
		CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[flgCnt];

		java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyyMMdd");
		String unFlagDay = formatter.format(new java.util.Date());

		try{
			flgCnt = 0;

			for ( int i = 0; i < arrayCustomMnrDispDtlVOs.length; i++ ) {
				String dispSoldDtFlg = arrayCustomMnrDispDtlVOs[i].getDispSoldDtFlg();

				if(dispSoldDtFlg.equals("Y")||dispSoldDtFlg.equals("N")) {
					//STS VO
					CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
					customMnrEqStsVO.setEqKndCd(arrayCustomMnrDispDtlVOs[i].getEqKndCd());
					if(dispSoldDtFlg.equals("Y")) {
						customMnrEqStsVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getEqNo());
						customMnrEqStsVO.setEqTpszCd(arrayCustomMnrDispDtlVOs[i].getEqTpszCd());
						customMnrEqStsVO.setMnrDmgFlgYdCd(arrayCustomMnrDispDtlVOs[i].getDispYdCd());
						customMnrEqStsVO.setMnrDmgFlg("1");
						customMnrEqStsVO.setMnrDmgFlgDt(arrayCustomMnrDispDtlVOs[i].getDispSoldDt().replaceAll("-", ""));
					} else {
						customMnrEqStsVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getOldEqNo());
						customMnrEqStsVO.setEqTpszCd(arrayCustomMnrDispDtlVOs[i].getOldEqTpszCd());
						customMnrEqStsVO.setMnrDmgFlgYdCd(arrayCustomMnrDispDtlVOs[i].getOldEqDispYdCd());
						customMnrEqStsVO.setMnrDmgFlg("0");
						if(!arrayCustomMnrDispDtlVOs[i].getOldSoldDt().equals("") && arrayCustomMnrDispDtlVOs[i].getOldSoldDt() != null){
							customMnrEqStsVO.setMnrDmgFlgDt(arrayCustomMnrDispDtlVOs[i].getOldSoldDt().replaceAll("-", ""));
						} else {
							customMnrEqStsVO.setMnrDmgFlgDt(unFlagDay);
						}
					}

					customMnrEqStsVO.setMnrStsRmk("From Disposal Sold Creation");
					arrCustomMnrEqStsVOS[flgCnt] = customMnrEqStsVO;

					//FLG_HIS_VO
					CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
					if(dispSoldDtFlg.equals("Y")) {
						customMnrFlgHisVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getEqNo());
						customMnrFlgHisVO.setEqTpszCd(arrayCustomMnrDispDtlVOs[i].getEqTpszCd());
						customMnrFlgHisVO.setMnrFlgYdCd(arrayCustomMnrDispDtlVOs[i].getDispYdCd());
						customMnrFlgHisVO.setMnrStsFlg("1");
						customMnrFlgHisVO.setMnrFlgInpDt(arrayCustomMnrDispDtlVOs[i].getDispSoldDt().replaceAll("-", ""));
					} else {
						customMnrFlgHisVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getOldEqNo());
						customMnrFlgHisVO.setEqTpszCd(arrayCustomMnrDispDtlVOs[i].getOldEqTpszCd());
						customMnrFlgHisVO.setMnrFlgYdCd(arrayCustomMnrDispDtlVOs[i].getOldEqDispYdCd());
						customMnrFlgHisVO.setMnrStsFlg("0");
						if(!arrayCustomMnrDispDtlVOs[i].getOldSoldDt().equals("") && arrayCustomMnrDispDtlVOs[i].getOldSoldDt() != null){
							customMnrFlgHisVO.setMnrFlgInpDt(arrayCustomMnrDispDtlVOs[i].getOldSoldDt().replaceAll("-", ""));
						} else {
							customMnrFlgHisVO.setMnrFlgInpDt(unFlagDay);
						}
					}
					customMnrFlgHisVO.setMnrFlgTpCd("SLD");
					customMnrFlgHisVO.setMnrFlgInpTpCd("M");
					customMnrFlgHisVO.setEqKndCd(arrayCustomMnrDispDtlVOs[i].getEqKndCd());
					customMnrFlgHisVO.setMnrFlgRmk("From Disposal Sold Creation");
					arrCustomMnrFlgHisVOS[flgCnt] = customMnrFlgHisVO;

					flgCnt++;

				} else if (dispSoldDtFlg.equals("U")) {
					for(int j=0; j<2; j++) {
						//STS VO
						CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
						if(j==0) {
							customMnrEqStsVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getOldEqNo());
							customMnrEqStsVO.setEqTpszCd(arrayCustomMnrDispDtlVOs[i].getOldEqTpszCd());
							customMnrEqStsVO.setMnrDmgFlgYdCd(arrayCustomMnrDispDtlVOs[i].getOldEqDispYdCd());
							customMnrEqStsVO.setMnrDmgFlg("0");
							if(!arrayCustomMnrDispDtlVOs[i].getOldSoldDt().equals("") && arrayCustomMnrDispDtlVOs[i].getOldSoldDt() != null){
								customMnrEqStsVO.setMnrDmgFlgDt(arrayCustomMnrDispDtlVOs[i].getOldSoldDt().replaceAll("-", ""));
							} else {
								customMnrEqStsVO.setMnrDmgFlgDt(unFlagDay);
							}
						} else {
							customMnrEqStsVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getEqNo());
							customMnrEqStsVO.setEqTpszCd(arrayCustomMnrDispDtlVOs[i].getEqTpszCd());
							customMnrEqStsVO.setMnrDmgFlgYdCd(arrayCustomMnrDispDtlVOs[i].getDispYdCd());
							customMnrEqStsVO.setMnrDmgFlg("1");
							customMnrEqStsVO.setMnrDmgFlgDt(arrayCustomMnrDispDtlVOs[i].getDispSoldDt().replaceAll("-", ""));
						}
						customMnrEqStsVO.setEqKndCd(arrayCustomMnrDispDtlVOs[i].getEqKndCd());
						customMnrEqStsVO.setMnrStsRmk("From Disposal Sold Creation");
						arrCustomMnrEqStsVOS[flgCnt] = customMnrEqStsVO;

						//FLG_HIS_VO
						CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
						if(j==0) {
							customMnrFlgHisVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getOldEqNo());
							customMnrFlgHisVO.setEqTpszCd(arrayCustomMnrDispDtlVOs[i].getOldEqTpszCd());
							customMnrFlgHisVO.setMnrFlgYdCd(arrayCustomMnrDispDtlVOs[i].getOldEqDispYdCd());
							customMnrFlgHisVO.setMnrStsFlg("0");
							if(!arrayCustomMnrDispDtlVOs[i].getOldSoldDt().equals("") && arrayCustomMnrDispDtlVOs[i].getOldSoldDt() != null){
								customMnrFlgHisVO.setMnrFlgInpDt(arrayCustomMnrDispDtlVOs[i].getOldSoldDt().replaceAll("-", ""));
							} else {
								customMnrFlgHisVO.setMnrFlgInpDt(unFlagDay);
							}
						} else {
							customMnrFlgHisVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getEqNo());
							customMnrFlgHisVO.setEqTpszCd(arrayCustomMnrDispDtlVOs[i].getEqTpszCd());
							customMnrFlgHisVO.setMnrFlgYdCd(arrayCustomMnrDispDtlVOs[i].getDispYdCd());
							customMnrFlgHisVO.setMnrStsFlg("1");
							customMnrFlgHisVO.setMnrFlgInpDt(arrayCustomMnrDispDtlVOs[i].getDispSoldDt().replaceAll("-", ""));
						}
						customMnrFlgHisVO.setMnrFlgTpCd("SLD");
						customMnrFlgHisVO.setMnrFlgInpTpCd("D");
						customMnrFlgHisVO.setEqKndCd(arrayCustomMnrDispDtlVOs[i].getEqKndCd());

						customMnrFlgHisVO.setMnrFlgRmk("From Disposal Sold Creation");
						arrCustomMnrFlgHisVOS[flgCnt] = customMnrFlgHisVO;

						flgCnt++;
					}
				}
			}
			EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
			eQFlagListINVO.setMnrFlgTpCd("SLD");
			eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
			eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
			eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
			//*************** FLAG END   ************************* //

			/***************** MST for outer interface call **********************/
			InterfaceMgtBC command3 = new InterfaceMgtBCImpl();
			InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
			List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
			if(flgCnt > 0) {
				for(int i = 0;i < arrayCustomMnrDispDtlVOs.length; i++){
					String dispSoldDtFlg = arrayCustomMnrDispDtlVOs[i].getDispSoldDtFlg();

					if(dispSoldDtFlg.equals("Y")||dispSoldDtFlg.equals("N")) {
						IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
						iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
						iFMnrFlagVO.setFlagUserId(account.getUsr_id());
						iFMnrFlagVO.setFlagType("SLD");
						iFMnrFlagVO.setRetireFlag("N");
						iFMnrFlagVO.setEqKindCd(arrayCustomMnrDispDtlVOs[i].getEqKndCd());
						if(dispSoldDtFlg.equals("Y")) {
							iFMnrFlagVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getEqNo());
							iFMnrFlagVO.setFlagYdCd(arrayCustomMnrDispDtlVOs[i].getDispYdCd());
							iFMnrFlagVO.setFlagDt(arrayCustomMnrDispDtlVOs[i].getDispSoldDt().replaceAll("-", ""));
						} else {
							iFMnrFlagVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getOldEqNo());
							iFMnrFlagVO.setFlagYdCd(arrayCustomMnrDispDtlVOs[i].getOldEqDispYdCd());
							if(!arrayCustomMnrDispDtlVOs[i].getOldSoldDt().equals("") && arrayCustomMnrDispDtlVOs[i].getOldSoldDt() != null){
								iFMnrFlagVO.setFlagDt(arrayCustomMnrDispDtlVOs[i].getOldSoldDt().replaceAll("-", ""));
							} else {
								iFMnrFlagVO.setFlagDt(unFlagDay);
							}
						}
						//Damage Flag
						iFMnrFlagVO.setStsFlag(arrayCustomMnrDispDtlVOs[i].getDispSoldDtFlg());
						iFMnrFlagVO.setCustCntCd(arrayCustomMnrDispDtlVOs[i].getMnrPrnrCntCd());
						iFMnrFlagVO.setCustSeq(arrayCustomMnrDispDtlVOs[i].getMnrPrnrSeq());

						iFMnrFlagVOS.add(iFMnrFlagVO);
					} else if(dispSoldDtFlg.equals("U")) {
						for(int j=0; j<2; j++) {
							IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
							iFMnrFlagVO.setFlagOfcCd(account.getOfc_cd());
							iFMnrFlagVO.setFlagUserId(account.getUsr_id());
							iFMnrFlagVO.setFlagType("SLD");
							iFMnrFlagVO.setRetireFlag("N");
							iFMnrFlagVO.setEqKindCd(arrayCustomMnrDispDtlVOs[i].getEqKndCd());
							if(j==0) {
								iFMnrFlagVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getOldEqNo());
								iFMnrFlagVO.setFlagYdCd(arrayCustomMnrDispDtlVOs[i].getOldEqDispYdCd());
								iFMnrFlagVO.setStsFlag("N"); //Damage Flag
								if(!arrayCustomMnrDispDtlVOs[i].getOldSoldDt().equals("") && arrayCustomMnrDispDtlVOs[i].getOldSoldDt() != null){
									iFMnrFlagVO.setFlagDt(arrayCustomMnrDispDtlVOs[i].getOldSoldDt().replaceAll("-", ""));
								} else {
									iFMnrFlagVO.setFlagDt(unFlagDay);
								}
							} else {
								iFMnrFlagVO.setEqNo(arrayCustomMnrDispDtlVOs[i].getEqNo());
								iFMnrFlagVO.setFlagYdCd(arrayCustomMnrDispDtlVOs[i].getDispYdCd());
								iFMnrFlagVO.setStsFlag("Y"); //Damage Flag
								iFMnrFlagVO.setFlagDt(arrayCustomMnrDispDtlVOs[i].getDispSoldDt().replaceAll("-", ""));
							}

							iFMnrFlagVO.setCustCntCd(arrayCustomMnrDispDtlVOs[i].getMnrPrnrCntCd());
							iFMnrFlagVO.setCustSeq(arrayCustomMnrDispDtlVOs[i].getMnrPrnrSeq());

							iFMnrFlagVOS.add(iFMnrFlagVO);
						}
					}
				}
				interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
			}
			/***************** MST for outer interface call **********************/

			begin();

			//In case of existing Damage Flagging
			if(flgCnt > 0) {
				command2.manageEQFlagListBasic(eQFlagListGRPVO,account);
				command3.manageIFFlagBasic(interfaceGRPVO,account);
			}

			command.manageDisposalSoldBasic(event.getDisposalSoldGRPVO(), account);
			commit();

			disposalSoldGRPVO = command.searchDisposalSoldListBasic(event.getDisposalSoldGRPVO(), account);
			eventResponse.setRsVoList(disposalSoldGRPVO.getListCustomMnrDispHdrVO());
			eventResponse.setETCData("mnr_prnr_cnt_cd",disposalSoldGRPVO.getDisposalSoldINVO().getSelectedMnrPrnrCntCd());
			eventResponse.setETCData("mnr_prnr_seq",disposalSoldGRPVO.getDisposalSoldINVO().getSelectedMnrPrnrSeq());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0105 : Retrieve <br>
	 * [EES_MNR_0105] Retrieve "Total Loss Payment to Lessor Report" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTotalLossLessorReportListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0105Event event = (EesMnr0105Event)e;
		TotalLossMgtBC command = new TotalLossMgtBCImpl();

		try{
			List<TotalLossLessorReportVO> list = command.searchTotalLossLessorReportListBasic(event.getTotalLossLessorReportINVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0221 : Verify <br>
	 * [EES_MNR_0221] Verify "Sold Creation File Import_Pop-up" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifySoldEQFileListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0221Event event = (EesMnr0221Event)e;

		GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
		generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyVOS(event.getSoldEQFileListGRPVO().getArrayCustomMnrDatVrfyVO());
		GeneralCodeCheckMgtBC command  = new GeneralCodeCheckMgtBCImpl();

		SoldEQFileListGRPVO soldEQFileListGRPVO = event.getSoldEQFileListGRPVO();

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try{
			begin();
			//Getting sequence after insert into temporary table
			String seqValue = command.createMnrTempBasic(generalCodeCheckMgtGRPVO,account);
			//Retrieve updated data after Updating for validation checking
			soldEQFileListGRPVO.getSoldEQFileListINVO().setTmpSeq(seqValue);  				//set tmp_seq
			soldEQFileListGRPVO = command.verifySoldEQFileListBasic(soldEQFileListGRPVO);	//update and search
			commit();

			eventResponse.setRsVoList(soldEQFileListGRPVO.getListCustomMnrDatVrfyVO());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0160 : Retrieve <br>
	 * [EES_MNR_0160] Retrieve "Release No" data<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDispRlseNoService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		DisposalMgtBC command = new DisposalMgtBCImpl();
		DisposalSoldGRPVO disposalSoldGRPVO = new DisposalSoldGRPVO();
		try{
			disposalSoldGRPVO = command.searchDispRlseNoBasic(account);
			eventResponse.setETCData("dispRlseNo",disposalSoldGRPVO.getDispRlseNo());
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0235 : Doc Send <br>
	 * [EES_MNR_0235] Sending "M&R Disposal Release Order Document Transmission" data for reporting<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDisposalDocSendService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// PDTO(Data Transfer Object including Parameters)
		EesMnr0235Event event = (EesMnr0235Event)e;
		InterfaceMgtBC command = new InterfaceMgtBCImpl();

		try{
			DocGRPVO docGRPVO = event.getDocGRPVO();
			CustomDocHeaderVO customDocHeaderVO = docGRPVO.getCustomDocHeaderVO();

			begin();

			DocResultVO docResultVO = new DocResultVO();

			docResultVO.setTmplMrd("EES_MNR_0184.mrd");
			docResultVO.setRdSubSysCd("MNR");
			docResultVO.setBatFlg("N");
			if(customDocHeaderVO.getTrsmModCd().equals("F")){
				docResultVO.setDocTitNm("Disposal(DSP#: "+customDocHeaderVO.getDispNo()+")");
			}else{
				docResultVO.setDocTitNm("Equipment Disposal Release Order");
			}
			
			docResultVO.setEmlCtnt("");
			String dispNo 		= customDocHeaderVO.getDispNo();
			String userNm 		= customDocHeaderVO.getUserNm();
			String mnrPrnrCntCd = customDocHeaderVO.getMnrPrnrCntCd();
			String mnrPrnrSeq	= customDocHeaderVO.getMnrPrnrSeq();
			docResultVO.setTemplateArgs("/rv disp_no["+ dispNo +"] user_nm[" + userNm + "] mnr_prnr_cnt_cd[" + mnrPrnrCntCd + "] mnr_prnr_seq[" + mnrPrnrSeq +"]");
			if(customDocHeaderVO.getTrsmModCd().equals("F")){
				docResultVO.setSndrNm(account.getUsr_nm());
			}else{
				docResultVO.setSndrNm("");
			}
			docResultVO.setFaxOffice(account.getOfc_cd());
			docResultVO.setReceiverRmail(customDocHeaderVO.getMnrPrnrEml());
			docResultVO.setSndrEml("shipment.info@notifications.nykline.com");
			docResultVO.setCreUsrId(account.getUsr_id());

			String arrFaxNo[] = customDocHeaderVO.getFaxNo().split(",");
			StringBuffer faxNo = new StringBuffer();
			for(int j = 0; j < arrFaxNo.length;j++){
				if(j>0){
					faxNo.append(",").append(" ;").append(arrFaxNo[j]);
				}else{
					faxNo.append(" ;").append(arrFaxNo[j]);
				}
			}

			docResultVO.setFaxRcvInfo(userNm+faxNo.toString());
			docResultVO.setTemplateFile("");
			docResultVO.setTrsmModCd(customDocHeaderVO.getTrsmModCd());

			command.docSendBasic(docResultVO, account);

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EES_MNR_0243 : Save <br>
	 * [EES_MNR_0243] Save "Estimate Upload" data for creating estimate<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEstimateUploadService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InterfaceMgtBC command = new InterfaceMgtBCImpl();
		RepairMgtBC command2 = new RepairMgtBCImpl();
		EQFlagMgtBC command3 = new EQFlagMgtBCImpl();

		EesMnr0243Event event = (EesMnr0243Event)e;
		EstimateUploadVO[] estimateUploadVOs = event.getEstimateUploadVOs();

		try{
			begin();
			//Insert into temporary table
			EstimateUploadGRPVO estimateUploadGRPVO = command.createEstimateUploadBasic(estimateUploadVOs, account , event.getReqUi());
			List<InterfaceGRPVO> interfaceGRPVOList = estimateUploadGRPVO.getInterfaceGRPVOList();
			InterfaceGRPVO interfaceGRPVO = null;
			EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();

			for(int i = 0; i < interfaceGRPVOList.size(); i++) {
				interfaceGRPVO = interfaceGRPVOList.get(i);
				//Checking temporary table data for insert into business table
				interfaceGRPVO = command.checkEDIEstimateBasic(interfaceGRPVO);
				//Re-assigning of validated value
				interfaceGRPVOList.set(i, interfaceGRPVO);

				CustomMnrRprRqstTmpHdrVO customMnrRprRqstTmpHdrVO = interfaceGRPVO.getCustomMnrRprRqstTmpHdrVO();
				//Assigning of account information
				SignOnUserAccount ediAccount = new SignOnUserAccount(customMnrRprRqstTmpHdrVO.getCreUsrId(),null,null,null,null,null,null,null, customMnrRprRqstTmpHdrVO.getCreUsrId(), customMnrRprRqstTmpHdrVO.getCreDt() , customMnrRprRqstTmpHdrVO.getCreUsrId(), customMnrRprRqstTmpHdrVO.getCreDt(), customMnrRprRqstTmpHdrVO.getCostOfcCd(), null, null, null, null, null, null, null, null, null);

				//Case of validated
				if(interfaceGRPVO.getValidOk()){
					//Insert into estimate table
					command2.ediEstimateCopyToEstimateBasic(interfaceGRPVO);

					/***********************FLAG *********************************/
					//STS VO
					CustomMnrEqStsVO customMnrEqStsVO = new CustomMnrEqStsVO();
					customMnrEqStsVO.setEqNo(customMnrRprRqstTmpHdrVO.getRqstEqNo());
					customMnrEqStsVO.setEqKndCd(customMnrRprRqstTmpHdrVO.getEqKndCd());
					customMnrEqStsVO.setEqTpszCd(customMnrRprRqstTmpHdrVO.getEqTpszCd());
					java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat("yyyy-MM-dd");
					String today = formatter.format(new java.util.Date());
					customMnrEqStsVO.setMnrDmgFlgDt(today);
					customMnrEqStsVO.setMnrDmgFlgYdCd(customMnrRprRqstTmpHdrVO.getRprYdCd());
					customMnrEqStsVO.setMnrStsRmk("From EDI REF_NO:" + customMnrRprRqstTmpHdrVO.getRqstRefNo());
					//FLG_HIS_VO
					CustomMnrFlgHisVO customMnrFlgHisVO = new CustomMnrFlgHisVO();
					customMnrFlgHisVO.setEqNo(customMnrRprRqstTmpHdrVO.getRqstEqNo());
					customMnrFlgHisVO.setEqTpszCd(customMnrRprRqstTmpHdrVO.getEqTpszCd());
					customMnrFlgHisVO.setMnrFlgTpCd("DMG");
					customMnrFlgHisVO.setMnrFlgInpTpCd("E");
					customMnrFlgHisVO.setEqKndCd(customMnrRprRqstTmpHdrVO.getEqKndCd());
					customMnrFlgHisVO.setMnrFlgYdCd(customMnrRprRqstTmpHdrVO.getRprYdCd());
					customMnrFlgHisVO.setMnrFlgInpDt(today);
					customMnrFlgHisVO.setMnrFlgRmk("From EDI REF_NO:" + customMnrRprRqstTmpHdrVO.getRqstRefNo());

					customMnrFlgHisVO.setMnrStsFlg("1");

					CustomMnrEqStsVO[] arrCustomMnrEqStsVOS = new CustomMnrEqStsVO[1];
					CustomMnrFlgHisVO[] arrCustomMnrFlgHisVOS = new CustomMnrFlgHisVO[1];

					arrCustomMnrEqStsVOS[0] = customMnrEqStsVO;
					arrCustomMnrFlgHisVOS[0] = customMnrFlgHisVO;

					EQFlagListINVO eQFlagListINVO = new EQFlagListINVO();
					eQFlagListINVO.setMnrFlgTpCd("DMG");
					eQFlagListGRPVO.setEQFlagListINVO(eQFlagListINVO);
					eQFlagListGRPVO.setArrCustomMnrEqStsVOS(arrCustomMnrEqStsVOS);
					eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(arrCustomMnrFlgHisVOS);
					command3.manageEQFlagListBasic(eQFlagListGRPVO,ediAccount);
					/********************** FLAG END **********************************/

					/***************** MST for outer interface call **********************/
					List<IFMnrFlagVO> iFMnrFlagVOS = new ArrayList<IFMnrFlagVO>();
					for(int j = 0;j < arrCustomMnrEqStsVOS.length; j++){
						IFMnrFlagVO iFMnrFlagVO = new IFMnrFlagVO();
						iFMnrFlagVO.setFlagOfcCd(ediAccount.getOfc_cd());
						iFMnrFlagVO.setFlagUserId(ediAccount.getUsr_id());
						iFMnrFlagVO.setFlagType("DMG");
						iFMnrFlagVO.setRetireFlag("N");
						iFMnrFlagVO.setEqKindCd(arrCustomMnrEqStsVOS[j].getEqKndCd());
						iFMnrFlagVO.setEqNo(arrCustomMnrEqStsVOS[j].getEqNo());
						iFMnrFlagVO.setStsFlag("Y");
						iFMnrFlagVO.setFlagDt(arrCustomMnrEqStsVOS[j].getMnrDmgFlgDt());
						iFMnrFlagVO.setFlagYdCd(arrCustomMnrEqStsVOS[j].getMnrDmgFlgYdCd());
						iFMnrFlagVOS.add(iFMnrFlagVO);
					}
					interfaceGRPVO.setIFMnrFlagVOS(iFMnrFlagVOS);
					command.manageIFFlagBasic(interfaceGRPVO,ediAccount);
					/***************** MST for outer interface call **********************/

				}
			}
			commit();

			List<EstimateUploadVO> estimateUploadVOList = command.searchEstimateUploadResultBasic(estimateUploadGRPVO);
			eventResponse.setRsVoList(estimateUploadVOList);
			eventResponse.setETCData("complex_pk", estimateUploadGRPVO.getEstimateUploadPkStr());
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}

		return eventResponse;
	}
	
	/**
	 * EES_MNR_0019  <br>
	 * [EES_MNR_0019] Estimate Creation 정보를 체크합니다<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchESTNextVerNoListService(Event e) throws EventException {
		RepairMgtBC command = new RepairMgtBCImpl();
		EstimateGRPVO estimateGRPVO = new EstimateGRPVO();
		
		if(e.getEventName().equalsIgnoreCase("EesMnr0019Event")){
			EesMnr0019Event event = (EesMnr0019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
		//SPP 0019
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS019Event")){
			EesMnrS019Event event = (EesMnrS019Event)e;
			estimateGRPVO = event.getEstimateGRPVO();
			estimateGRPVO.setCurrSystem("SPP");
		}
		
		try {
			estimateGRPVO = command.searchESTNextVerNoListBasic(estimateGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			List<CustomMnrRprRqstHdrVO> customMnrRprRqstHdrVOS = estimateGRPVO.getCustomMnrRprRqstHdrVOS();
			StringBuffer rqstEqNo = new StringBuffer();
			String chkEqNo = "";
			if(customMnrRprRqstHdrVOS != null){
				for(int i = 0; i < customMnrRprRqstHdrVOS.size();i++){
					if(i>0){
						rqstEqNo.append(",").append(customMnrRprRqstHdrVOS.get(i).getRqstEqNo());
					}else{
						rqstEqNo.append(customMnrRprRqstHdrVOS.get(i).getRqstEqNo());
					}
				}
				chkEqNo = rqstEqNo.toString();
			}		
			eventResponse.setETCData("RQST_EQ_NO", chkEqNo);
			
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}	
	
	/**
	 * EES_MNR_S232 : Verify<br>
	 * [EES_MNR_S232] Eq No의 존재를 검증 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyRPRCreateFileListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			EesMnrS232Event event = (EesMnrS232Event)e;
			GeneralCodeCheckMgtGRPVO generalCodeCheckMgtGRPVO = new GeneralCodeCheckMgtGRPVO();
			generalCodeCheckMgtGRPVO.setCustomMnrDatVrfyVOS(event.getCustomMnrDatVrfyVOS());
			GeneralCodeCheckMgtBC command  = new GeneralCodeCheckMgtBCImpl();

			VerifyRPRCreateFileListGRPVO rPRCreateMgtGRPVO = new VerifyRPRCreateFileListGRPVO();
			rPRCreateMgtGRPVO.setRPRCreateMgtINVO(event.getRPRCreateMgtINVO());

			//로직시작
			begin();
			//MNR_DAT_VRFY 테이블에 인서트하고 시퀸스 값을 가져온다.
			String seqValue = command.createMnrTempBasic(generalCodeCheckMgtGRPVO,account);
			//시퀸스 값을 세팅
			rPRCreateMgtGRPVO.getRPRCreateMgtINVO().setTmpSeq(seqValue);
			//비즈로직에 따른 업데이트 진행 //조회시작
			rPRCreateMgtGRPVO = command.verifyRPRCreateFileListBasic(rPRCreateMgtGRPVO);
			commit();
			//로직완료
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(rPRCreateMgtGRPVO.getCustomMnrDatVrfyVOS());
			return eventResponse;
		} catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
	}	
	
	/**
	 * EES_MNR_0163 : Load <br>
	 * [EES_MNR_0163] 파트너 정보를 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPartnerListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			DisposalInquiryGRPVO disposalInquiryGRPVO = null;

			EesMnrS308Event event = (EesMnrS308Event)e;
			disposalInquiryGRPVO = event.getDisposalInquiryGRPVO();

			disposalInquiryGRPVO = command.searchPartnerBasic(disposalInquiryGRPVO,account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			if(disposalInquiryGRPVO.getDisposalInquiryINVO() ==null){
				eventResponse.setETCData("cust_cd","");
				eventResponse.setETCData("cust_lgl_eng_nm","");
			} else {
				eventResponse.setETCData(disposalInquiryGRPVO.getDisposalInquiryINVO().getColumnValues());
			}
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}	
	
	
	/**
	 * EES_MNR_S304 : Retrieve <br>
	 * [EES_MNR_S304] My Bidding List의 헤더목록을 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMyBiddingHdrListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			MyBiddingGRPVO myBiddingGRPVO = new MyBiddingGRPVO();

			//My Bidding List
			if(e.getEventName().equalsIgnoreCase("EesMnrS304Event")){
				EesMnrS304Event event = (EesMnrS304Event)e;
				myBiddingGRPVO = event.getMyBiddingGRPVO();
				//myBiddingGRPVO.getMyBiddingINVO().setOfcCd(account.getOfc_cd());
			//Bidding List
			} else if(e.getEventName().equalsIgnoreCase("EesMnrS301Event")){
				EesMnrS301Event event = (EesMnrS301Event)e;
				myBiddingGRPVO = event.getMyBiddingGRPVO();
				myBiddingGRPVO.getMyBiddingINVO().setResult("ALL");
				myBiddingGRPVO.getMyBiddingINVO().setBiddingStatus("ALL");
				//myBiddingGRPVO.getMyBiddingINVO().setOfcCd(account.getOfc_cd());
			}

			myBiddingGRPVO = command.searchMyBiddingHdrListBasic(myBiddingGRPVO);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(myBiddingGRPVO.getListCustomMyBiddingHdrVO());

			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_S304 : Submit <br>
	 * [EES_MNR_S304] My Bidding List의 선택된 Bidding No의 Bidding Status을 조회 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMyBiddingStatusListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			MyBiddingINVO myBiddingINVO = new MyBiddingINVO();

			//My Bidding List
			if(e.getEventName().equalsIgnoreCase("EesMnrS304Event")){
				EesMnrS304Event event = (EesMnrS304Event)e;
				myBiddingINVO = event.getMyBiddingINVO();

			//Bidding List
			} else if(e.getEventName().equalsIgnoreCase("EesMnrS301Event")){
				EesMnrS301Event event = (EesMnrS301Event)e;
				myBiddingINVO = event.getMyBiddingINVO();
			}
			DisposalMgtBC command = new DisposalMgtBCImpl();

			List<CustomMyBiddingHdrVO> list = command.searchMyBiddingStatus(myBiddingINVO);
			if(list != null && list.size() > 0){
				eventResponse.setETCData("biddingStatus", list.get(0).getBiddingStatus());
			}

			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}


	/**
	* EES_MNR_S304 : doActionIBSheet <br>
	* [EES_MNR_S304] My Bidding List의 디테일목록을 조회 합니다. <br>
	*
	* @param String eventName
	* @param DisposalGRPVO disposalGRPVO
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchMyBiddingDtlListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			MyBiddingGRPVO myBiddingGRPVO = new MyBiddingGRPVO();

			//My Bidding List
			if(e.getEventName().equalsIgnoreCase("EesMnrS304Event")){
				EesMnrS304Event event = (EesMnrS304Event)e;
				myBiddingGRPVO = event.getMyBiddingGRPVO();
			//Bidding List
			} else if(e.getEventName().equalsIgnoreCase("EesMnrS301Event")){
				EesMnrS301Event event = (EesMnrS301Event)e;
				myBiddingGRPVO = event.getMyBiddingGRPVO();
			}

			myBiddingGRPVO = command.searchMyBiddingDtlListBasic(myBiddingGRPVO);

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(myBiddingGRPVO.getListEqCustomMyBiddingDtlVO());
			eventResponse.setRsVoList(myBiddingGRPVO.getListQtyCustomMyBiddingDtlVO());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_S304 : Save <br>
	 * [EES_MNR_S304]My Bidding List의 디테일목록을 추가/수정 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMyBiddingDtlListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DisposalMgtBC  command = new DisposalMgtBCImpl();

		MyBiddingGRPVO myBiddingGRPVO = new MyBiddingGRPVO();

		//My Bidding List
		if(e.getEventName().equalsIgnoreCase("EesMnrS304Event")){
			EesMnrS304Event event = (EesMnrS304Event)e;
			myBiddingGRPVO = event.getMyBiddingGRPVO();
		//Bidding List
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS301Event")){
			EesMnrS301Event event = (EesMnrS301Event)e;
			myBiddingGRPVO = event.getMyBiddingGRPVO();
			myBiddingGRPVO.getMyBiddingINVO().setResult("ALL");
			myBiddingGRPVO.getMyBiddingINVO().setBiddingStatus("ALL");
		}

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();

			//저장
			myBiddingGRPVO = command.manageMyBiddingDtlListBasic(myBiddingGRPVO, account);
			commit();

			//조회
			myBiddingGRPVO = command.searchMyBiddingHdrListBasic(myBiddingGRPVO);

			eventResponse.setRsVoList(myBiddingGRPVO.getListCustomMyBiddingHdrVO());
			eventResponse.setETCData("disp_no", myBiddingGRPVO.getDispNo());
			return eventResponse;
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
	}

	/**
	 * EES_MNR_S304 : Save <br>
	 * [EES_MNR_S304]My Bidding List의 디테일목록을 삭제 합니다. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeMyBiddingDtlListService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		DisposalMgtBC  command = new DisposalMgtBCImpl();

		MyBiddingGRPVO myBiddingGRPVO = new MyBiddingGRPVO();

		//My Bidding List
		if(e.getEventName().equalsIgnoreCase("EesMnrS304Event")){
			EesMnrS304Event event = (EesMnrS304Event)e;
			myBiddingGRPVO = event.getMyBiddingGRPVO();
		//Bidding List
		} else if(e.getEventName().equalsIgnoreCase("EesMnrS301Event")){
			EesMnrS301Event event = (EesMnrS301Event)e;
			myBiddingGRPVO = event.getMyBiddingGRPVO();
			myBiddingGRPVO.getMyBiddingINVO().setResult("ALL");
			myBiddingGRPVO.getMyBiddingINVO().setBiddingStatus("ALL");
		}

		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			begin();

			//삭제
			myBiddingGRPVO = command.removeMyBiddingDtlListBasic(myBiddingGRPVO, account);
			commit();

			//조회
			myBiddingGRPVO = command.searchMyBiddingHdrListBasic(myBiddingGRPVO);

			eventResponse.setRsVoList(myBiddingGRPVO.getListCustomMyBiddingHdrVO());
			eventResponse.setETCData("disp_no", myBiddingGRPVO.getDispNo());
			return eventResponse;
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
	}	
	
	/**
	* EES_MNR_S304 : doActionIBSheet <br>
	* [EES_MNR_S304] My Bidding List의  Local Time을 조회 합니다. <br>
	*
	* @param Event e
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchMyBiddingLoaclTimeListService(Event e) throws EventException {
		try {
			// PDTO(Data Transfer Object including Parameters)
			DisposalMgtBC command = new DisposalMgtBCImpl();
			MyBiddingGRPVO myBiddingGRPVO = new MyBiddingGRPVO();

			EesMnrS304Event event = (EesMnrS304Event)e;
			myBiddingGRPVO = event.getMyBiddingGRPVO();

			myBiddingGRPVO = command.searchMyBiddingLoaclTimeListBasic(myBiddingGRPVO,account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			eventResponse.setETCData(myBiddingGRPVO.getMyBiddingINVO().getColumnValues());
			return eventResponse;
		} catch(EventException ex){
			throw ex;
		} catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
	}
	
	/**
	 * EES_MNR_0247 : Retrieve Event<br>
	 * Retrieve EDI Invoice Parking Lot<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIInvoiceParkingLotHDRData(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0247Event event = (EesMnr0247Event) e;
		RepairMgtBC command = new RepairMgtBCImpl();
				
		try {
			EDIInvoiceParkingLotHDRDataVO eDIInvoiceParkingLotHDRDataVO = event.getEDIInvoiceParkingLotHDRDataVO();
			List<EDIInvoiceParkingLotHDRDataVO> list = command.searchEDIInvoiceParkingLotHDRData(eDIInvoiceParkingLotHDRDataVO);
			eventResponse.setRsVoList(list);
			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0247 : Retrieve Event<br>
	 * Retrieve EDI Invoice Parking Lot<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEDIInvoiceParkingLotDTLData(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0247Event event = (EesMnr0247Event) e;
		RepairMgtBC command = new RepairMgtBCImpl();
				
		try {
			EDIInvoiceParkingLotDTLDataVO eDIInvoiceParkingLotDTLDataVO = event.getEDIInvoiceParkingLotDTLDataVO();
			List<EDIInvoiceParkingLotDTLDataVO> list = command.searchEDIInvoiceParkingLotDTLData(eDIInvoiceParkingLotDTLDataVO);
			eventResponse.setRsVoList(list);
			
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0247 : Multi Event<br>
	 * Update /Remove EDI Invoice Parking Lot information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEDIInvoiceParkingLotHDRData(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0247Event event = (EesMnr0247Event) e;
		RepairMgtBC command = new RepairMgtBCImpl();
		EDIInvoiceParkingLotGRPVO eDIInvoiceParkingLotGRPVO = new EDIInvoiceParkingLotGRPVO();
		
		try {
			if("0".equals(command.searchBackEndJobCntBasic())){
				eDIInvoiceParkingLotGRPVO.setCustomMnrOrdTmpHdrVOs(event.getCustomMnrOrdTmpHdrVOS());
				eDIInvoiceParkingLotGRPVO.setCustomMnrOrdTmpDtlVOs(event.getCustomMnrOrdTmpDtlVOS());
				begin();
//				CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs = event.getCustomMnrOrdTmpHdrVOS();
//				command.manageEDIInvoiceParkingLotHDRData(customMnrOrdTmpHdrVOs, account);
				command.manageEDIInvoiceParkingLotData(eDIInvoiceParkingLotGRPVO, account);
				commit();
				eventResponse.setETCData("result", "");
			}else{
				eventResponse.setETCData("result", "X");
			}
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0247 : Multi Event<br>
	 * Update /Remove EDI Invoice Parking Lot information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEDIInvoiceParkingLotConfirmData(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0247Event event = (EesMnr0247Event) e;
		RepairMgtBC command = new RepairMgtBCImpl();
		EDIInvoiceParkingLotGRPVO eDIInvoiceParkingLotGRPVO = new EDIInvoiceParkingLotGRPVO();
		InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
		InterfaceMgtBC command1 = new InterfaceMgtBCImpl();
		
		try {
			if("0".equals(command.searchBackEndJobCntBasic())){
				eDIInvoiceParkingLotGRPVO.setCustomMnrOrdTmpHdrVOs(event.getCustomMnrOrdTmpHdrVOS());
				eDIInvoiceParkingLotGRPVO.setCustomMnrOrdTmpDtlVOs(event.getCustomMnrOrdTmpDtlVOS());
				interfaceGRPVO.setArrayCustomMnrOrdTmpHdrVOs(event.getCustomMnrOrdTmpHdrVOS());
				begin();
				command.manageEDIInvoiceParkingLotData(eDIInvoiceParkingLotGRPVO, account);
				commit();
				
				String status = command1.newPortEdiBackEndJobBasic(interfaceGRPVO, account);
	        	eventResponse.setETCData("BackEndJobKey", status);
	        	eventResponse.setETCData("result", "");
			}else{
				eventResponse.setETCData("result", "X");
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0248 : Multi Event<br>
	 * Verify SOL Invoice File import information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifySOLInvoiceFileImportData(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesMnr0248Event event = (EesMnr0248Event) e;
		InterfaceMgtBC command = new InterfaceMgtBCImpl();
		InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
		
        CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs = event.getCustomMnrOrdTmpHdrVOS();
        CustomMnrOrdTmpDtlVO[] customMnrOrdTmpDtlVOs = event.getCustomMnrOrdTmpDtlVOS();
        CustomMnrOrdTmpDtlVO[][] customMnrOrdTmpDtlVOS =  new CustomMnrOrdTmpDtlVO[customMnrOrdTmpHdrVOs.length][];

        for(int i=0; i < customMnrOrdTmpHdrVOs.length; i++){
        	String invNo = customMnrOrdTmpHdrVOs[i].getInvNo();
//        	int k = 0;
        	List<CustomMnrOrdTmpDtlVO> list = new ArrayList<CustomMnrOrdTmpDtlVO>();
        	for(int j=0; j < customMnrOrdTmpDtlVOs.length; j++){
        		if(invNo.equals(customMnrOrdTmpDtlVOs[j].getInvNo())){
        			list.add(customMnrOrdTmpDtlVOs[j]);
        		}
        	}
        	customMnrOrdTmpDtlVOS[i] = new CustomMnrOrdTmpDtlVO[list.size()];
        	for(int k=0; k < list.size(); k++){
        		customMnrOrdTmpDtlVOS[i][k] = list.get(k);
        	}
        }
        
        interfaceGRPVO.setArrayCustomMnrOrdTmpHdrVOs(customMnrOrdTmpHdrVOs);
        interfaceGRPVO.setArrayCustomMnrOrdTmpDtlVOs(customMnrOrdTmpDtlVOS);
        
        try {
        	interfaceGRPVO = command.verifySOLBasic(interfaceGRPVO, account);
        	eventResponse.setRsVoList(interfaceGRPVO.getCustomMnrOrdTmpHdrVOs());
        	eventResponse.setRsVoList(interfaceGRPVO.getCustomMnrOrdTmpDtlVOs());
        	
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * EES_MNR_0248 : Multi Event<br>
	 * manage SOL Invoice File import information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageSOLInvoiceFileImportData(Event e) throws EventException{
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
				GeneralEventResponse eventResponse = new GeneralEventResponse();
				EesMnr0248Event event = (EesMnr0248Event) e;
				InterfaceMgtBC command = new InterfaceMgtBCImpl();
				InterfaceGRPVO interfaceGRPVO = new InterfaceGRPVO();
				
		        CustomMnrOrdTmpHdrVO[] customMnrOrdTmpHdrVOs = event.getCustomMnrOrdTmpHdrVOS();
		        CustomMnrOrdTmpDtlVO[] customMnrOrdTmpDtlVOs = event.getCustomMnrOrdTmpDtlVOS();
		        CustomMnrOrdTmpDtlVO[][] customMnrOrdTmpDtlVOS =  new CustomMnrOrdTmpDtlVO[customMnrOrdTmpHdrVOs.length][];

		        for(int i=0; i < customMnrOrdTmpHdrVOs.length; i++){
		        	String invNo = customMnrOrdTmpHdrVOs[i].getInvNo();
//		        	int k = 0;
		        	List<CustomMnrOrdTmpDtlVO> list = new ArrayList<CustomMnrOrdTmpDtlVO>();
		        	for(int j=0; j < customMnrOrdTmpDtlVOs.length; j++){
		        		if(invNo.equals(customMnrOrdTmpDtlVOs[j].getInvNo())){
		        			list.add(customMnrOrdTmpDtlVOs[j]);
		        		}
		        	}
		        	customMnrOrdTmpDtlVOS[i] = new CustomMnrOrdTmpDtlVO[list.size()];
		        	for(int k=0; k < list.size(); k++){
		        		customMnrOrdTmpDtlVOS[i][k] = list.get(k);
		        	}
		        }
		        
		        interfaceGRPVO.setArrayCustomMnrOrdTmpHdrVOs(customMnrOrdTmpHdrVOs);
		        interfaceGRPVO.setArrayCustomMnrOrdTmpDtlVOs(customMnrOrdTmpDtlVOS);
		        
		        try {
//		        	begin();
//		        	interfaceGRPVO = command.manageSOLInvoiceDataBasic(interfaceGRPVO, account);
		        	String status = command.backEndManageSOLInvoiceBasic(interfaceGRPVO, account);
		        	eventResponse.setETCData("BackEndJobKey", status);
//		        	commit();
//		        	eventResponse.setRsVoList(interfaceGRPVO.getCustomMnrOrdTmpHdrVOs());
//		        	eventResponse.setRsVoList(interfaceGRPVO.getCustomMnrOrdTmpDtlVOs());
		        
				} catch (EventException ex) {
					rollback();
					throw new EventException(ex.getMessage(), ex);
				} catch(Exception ex){
					rollback();
					throw new EventException(ex.getMessage(), ex);
				}
				return eventResponse;
	}
	
	/**
	 * EES_MNR_0154 : BackEndJob<br>
	 * retrieving status result of BackEndJob.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchComBackEndJobStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			TariffMgtBC command = new TariffMgtBCImpl();
			String key = (String)e.getAttribute("KEY");

			String status = command.searchComBackEndJobStatusBasic(key);
			eventResponse.setETCData("jb_sts_flg", status);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * EES_MNR_0122 : Checking OP Status<br>
	 * Checking OP Status<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCntrOpStatusService(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EQFlagMgtBC command = new EQFlagMgtBCImpl();
		EQFlagListGRPVO eQFlagListGRPVO = new EQFlagListGRPVO();
		if(e.getEventName().equalsIgnoreCase("EesMnr0122Event")){
			EesMnr0122Event event = (EesMnr0122Event)e;
			eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());
			eQFlagListGRPVO.setArrCustomMnrEqStsVOS(event.getCustomMnrEqStsVOs());
			eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(event.getCustomMnrFlgHisVOs());
		} else {
			EesMnrS122Event event = (EesMnrS122Event)e;
			eQFlagListGRPVO.setEQFlagListINVO(event.getEQFlagListINVO());
			eQFlagListGRPVO.setArrCustomMnrEqStsVOS(event.getCustomMnrEqStsVOs());
			eQFlagListGRPVO.setArrCustomMnrFlgHisVOS(event.getCustomMnrFlgHisVOs());
		}
				
		try {
			String opCntrs = command.searchCntrOpStatusBasic(eQFlagListGRPVO);
			eventResponse.setETCData("op_cntrs", opCntrs);
		} catch (EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		} catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage());
		}
		return eventResponse;
	}
}