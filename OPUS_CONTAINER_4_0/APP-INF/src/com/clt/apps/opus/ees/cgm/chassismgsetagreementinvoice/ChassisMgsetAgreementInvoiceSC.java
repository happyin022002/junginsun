/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChassisMgsetAgreementInvoiceSC.java
*@FileTitle : Agreement Matching
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.basic.CgmCodeMgtBC;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.basic.CgmCodeMgtBCImpl;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboMGTVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationINVO;
import com.clt.apps.opus.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.basic.ChassisMgsetAgreementBC;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.basic.ChassisMgsetAgreementBCImpl;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1020Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1021Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1022Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1026Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1117Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm1118Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm2021Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm2022Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm2023Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm2026Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm2028Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event.EesCgm2103Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementGroupVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementListMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermChangeResultMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusGroupVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementGroupVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementListMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermChangeResultMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusGroupVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSTermStatusMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.basic.ChassisMgsetInvoiceBC;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.basic.ChassisMgsetInvoiceBCImpl;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1028Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1029Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1030Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1031Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1034Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1035Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1107Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1123Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1124Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1125Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm1126Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2032Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2035Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2036Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2085Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2086Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2098Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event.EesCgm2206Event;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.integration.ChassisMgsetInvoiceDBDAO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSChargeCreationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSCoPoolChargeMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableAmountMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSConfirmPayableGRPVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSEstimateExpenseMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceImportAuditMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceInquiryMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSLessorAgmtMatchingMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSNuPoolChargeMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPayableInvoiceCreationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSPayableInvoiceCreationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSChargeCreationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSConfirmPayableAmountINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSConfirmPayableAmountMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSEstimateExpenseMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceImportAuditMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSInvoiceInquiryMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSLessorAgmtMatchingMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSPayableInvoiceCreationINVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.MGSPayableInvoiceCreationMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.PoolEstmExpenseMGTVO;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBC;
import com.clt.apps.opus.ees.cgm.chassismgsetmgt.chassismgsetonoffhire.basic.ChassisMgsetOnOffhireBCImpl;
import com.clt.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBC;
import com.clt.bizcommon.csr.csrcommon.csrexternalfinder.basic.CSRExternalFinderBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;


/**
 * opus-ChassisMgsetAgreementInvoice Business Logic ServiceCommand - handling business transaction about opus-ChassisMgsetAgreementInvoice 
 *
 * @author 
 * @see ChassisMgsetInvoiceDBDAO
 * @since J2EE 1.4
 */

public class ChassisMgsetAgreementInvoiceSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * ChassisMgsetAgreementInvoice system preceding process for biz scenario<br>
	 * ees_cgm_1028 related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * ChassisMgsetAgreementInvoice system biz scenario closing<br>
	 * ees_cgm_1028 clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("ChassisMgsetAgreementInvoiceSC End");
	}

	/**
	 * opus-ChassisMgsetAgreementInvoice system <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		try
		{
			// RDTO(Data Transfer Object including Parameters)
			EventResponse eventResponse = null;

			// part of using in case that SC handles many events
			if (e.getEventName().equalsIgnoreCase("EesCgm1020Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSAgreementAllService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
					eventResponse = modifyCHSAgreementService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)){
					eventResponse = removeCHSAgreementService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1020DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1021Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSAgreementListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1021DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1022Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSAgreementDtlPopupService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1026Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSTermChangeEqListService(e);
				} else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchCHSEqMainService(e);
				} else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageCHSTermChangeService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
					eventResponse = backEndCHSTermChangeListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
					eventResponse = searchComBackEndJobStatusService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1028Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSLessorAgmtMatchingService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageCHSLessorAgmtMatchingService (e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = checkCHSAgmtService (e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1029Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSChargeCreationListService(e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchCHSChargeCreationResultService (e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = createCHSChargeService (e);
				}
				else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
					eventResponse = removeCHSChargeService (e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1030Event")) {
				if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = verifyCHSInvoiceDraftService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = auditCHSInvoiceDraftService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
					eventResponse = verifyCHSInvoiceDraftInsertService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
					eventResponse = verifyCHSInvoiceDraftSearchService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1031Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSInvoiceAuditResultService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = manageCHSInvoiceAuditResultService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = confirmCHSPayableAmountService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
					eventResponse = cancelCHSPayableAmountService(e);
				}

			} else if (e.getEventName().equalsIgnoreCase("EesCgm1034Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSInvoiceListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchCHSInvoiceDetailService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = createCHSInvoiceService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = cancelCHSInvoiceService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1034DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1035Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSInvoiceInqListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchCHSInvoiceInqDtlService (e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2036Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSInvoiceInqListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchMGSInvoiceInqDtlService (e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1117Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSAgreementSelectionListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1117DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1118Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSTermChangeResultSmryService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1118DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1123Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSCoPoolChargeDtlService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageCHSCoPoolChargeService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchCHSCoPoolChargeListService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = searchCHSCoPoolChargeInitService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
					eventResponse = removeCHSCoPoolChargeService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1123DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1124Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchCHSNuPoolChargeDtlService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageCHSNuPoolChargeService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchCHSNuPoolChargeListService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
					eventResponse = searchCHSNuPoolChargeInitService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
					eventResponse = removeCHSNuPoolChargeService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm1124DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2021Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSAgreementAllService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
					eventResponse = modifyMGSAgreementService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)){
					eventResponse = removeMGSAgreementService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2021DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2022Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSAgreementSelectionListService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2022DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2023Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSAgreementListService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2023DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2026Event")) {
				if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSTermChangeEqListService(e);
				}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchMGSEqMainService(e);
				}else if(e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageMGSTermChangeService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2028Event")) {
				if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSTermChangeResultSmryService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2028DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2032Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSChargeCreationListService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchMGSChargeCreationResultService (e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = createMGSChargeService (e);
				}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
					eventResponse = removeMGSChargeService (e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2035Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSInvoiceListService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = searchMGSInvoiceDetailService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = createMGSInvoiceService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = cancelMGSInvoiceService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
					eventResponse = searchEesCgm2035DefaultService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2085Event")) {
				if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = verifyMGSInvoiceDraftService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = auditMGSInvoiceDraftService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
					eventResponse = verifyMGSInvoiceDraftInsertService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
					eventResponse = verifyMGSInvoiceDraftSearchService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2086Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSLessorAgmtMatchingService(e);
				}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = manageMGSLessorAgmtMatchingService (e);
				}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
					eventResponse = checkMGSAgmtService (e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2098Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSInvoiceAuditResultService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
					eventResponse = manageMGSInvoiceAuditResultService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
					eventResponse = confirmMGSPayableAmountService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
					eventResponse = cancelMGSPayableAmountService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2103Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchMGSAgreementDtlPopupService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1125Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchPoolEstimateAmtService(e);
				} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
					eventResponse = modifyPoolEstimateAmtService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1126Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
					eventResponse = searchPoolEstimateReportService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm1107Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {			// search
					eventResponse = searchCHSEstimateExpenseService(e);
				} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH01)) // calculate
				{
					eventResponse = searchCHSEstimateExpenseCalcService(e);
				} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH02)) // summary
				{
					eventResponse = searchCHSEstimateExpenseSummaryService(e);
				} else if ( e.getFormCommand().isCommand(FormCommand.MULTI)) 	// delete/insert
				{
					eventResponse = manageCHSEstimateExpenseCalcService(e);
				}
			} else if (e.getEventName().equalsIgnoreCase("EesCgm2206Event")) {
				if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {			// search
					eventResponse = searchMGSEstimateExpenseService(e);
				} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH01)) // calculate
				{
					eventResponse = searchMGSEstimateExpenseCalcService(e);
				} else if ( e.getFormCommand().isCommand(FormCommand.SEARCH02)) // summary
				{
					eventResponse = searchMGSEstimateExpenseSummaryService(e);
				} else if ( e.getFormCommand().isCommand(FormCommand.MULTI)) 	// delete/insert
				{
					eventResponse = manageMGSEstimateExpenseCalcService(e);
				}
			}

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1028] : [Retrieve]<br>
	 * Retrieve agreement data matched to Lessor.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSLessorAgmtMatchingService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1028Event event = (EesCgm1028Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSLessorAgmtMatchingMGTVO> list = command.searchCHSLessorAgmtMatchingBasic(event.getChsLessorAgmtMatchingINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1104] : [Save]<br>
	 * Save agreement data matched to Lessor.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSLessorAgmtMatchingService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1028Event event = (EesCgm1028Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.manageCHSLessorAgmtMatchingBasic (event.getChsLessorAgmtMatchingINVOS(),account);
//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1028] : [Check]<br>
	 * After insert Agreement No., Checking whether data exists or not when Focus Out.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkCHSAgmtService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1028Event event = (EesCgm1028Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();

		int agmtCnt = 0;
		String vndrSeq = null;
		String vndrLglEngNm = null;

		try {
			CHSLessorAgmtMatchingMGTVO lessorAgmtMatchingMGTVO = command.checkCHSAgmtBasic(event.getChsLessorAgmtMatchingINVO());

			if(lessorAgmtMatchingMGTVO == null){
				agmtCnt = 0;
				vndrSeq = "";
				vndrLglEngNm = "";
			} else {
				agmtCnt = 1;
				vndrSeq = lessorAgmtMatchingMGTVO.getVndrSeq();
				vndrLglEngNm = lessorAgmtMatchingMGTVO.getVndrLglEngNm();
			}

			eventResponse.setETCData("AgmtCnt", String.valueOf(agmtCnt));
			eventResponse.setETCData("vndrSeq", String.valueOf(vndrSeq));
			eventResponse.setETCData("vndrLglEngNm", String.valueOf(vndrLglEngNm));

		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * [EES_CGM_2086] : [Retrieve]<br>
	 * Retrieve agreement data matched to Lessor.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSLessorAgmtMatchingService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2086Event event = (EesCgm2086Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSLessorAgmtMatchingMGTVO> list = command.searchMGSLessorAgmtMatchingBasic(event.getMgsLessorAgmtMatchingINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2086] : [Save]<br>
	 * Save agreement data matched to Lessor.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMGSLessorAgmtMatchingService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2086Event event = (EesCgm2086Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.manageMGSLessorAgmtMatchingBasic (event.getMgsLessorAgmtMatchingINVOS(),account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2086] : [Check]<br>
	 * After insert Agreement No., Checking whether data exists or not when Focus Out.<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkMGSAgmtService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2086Event event = (EesCgm2086Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();

		int agmtCnt = 0;
		String vndrSeq = null;
		String vndrLglEngNm = null;

		try {
			MGSLessorAgmtMatchingMGTVO lessorAgmtMatchingMGTVO = command.checkMGSAgmtBasic(event.getMgsLessorAgmtMatchingINVO());

			if(lessorAgmtMatchingMGTVO == null){
				agmtCnt = 0;
				vndrSeq = "";
				vndrLglEngNm = "";
			} else {
				agmtCnt = 1;
				vndrSeq = lessorAgmtMatchingMGTVO.getVndrSeq();
				vndrLglEngNm = lessorAgmtMatchingMGTVO.getVndrLglEngNm();
			}

			eventResponse.setETCData("AgmtCnt", String.valueOf(agmtCnt));
			eventResponse.setETCData("vndrSeq", String.valueOf(vndrSeq));
			eventResponse.setETCData("vndrLglEngNm", String.valueOf(vndrLglEngNm));

		} catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * [EES_CGM_1123] : [Retrieve]<br>
	 * Retrieve saved Co-op Pool Charge list.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSCoPoolChargeListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1123Event event = (EesCgm1123Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSCoPoolChargeMGTVO> list = command.searchCHSCoPoolChargeListBasic(event.getChsCoPoolChargeINVO());

			StringBuffer comboList = new StringBuffer("");
			for(int i=0; i<list.size(); i++){
				CHSCoPoolChargeMGTVO chsCoPoolChargeMGTVO = (CHSCoPoolChargeMGTVO)list.get(i);

				comboList.append(chsCoPoolChargeMGTVO.getInvNo() + "|" + chsCoPoolChargeMGTVO.getChssMgstInvStsCd());

				if(i < list.size()-1) comboList.append("@");
			}

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("comboList", comboList.toString());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1123] : [Retrieve]<br>
	 * Retrieve Co-op Pool Charge initial list.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSCoPoolChargeInitService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1123Event event = (EesCgm1123Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSCoPoolChargeMGTVO> list = command.searchCHSCoPoolChargeInitBasic(event.getChsCoPoolChargeINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1123] : [Retrieve]<br>
	 * Retrieve saved Co-op Pool Charge detail list.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSCoPoolChargeDtlService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1123Event event = (EesCgm1123Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();

			List<CHSCoPoolChargeMGTVO> list = command.searchCHSCoPoolChargeDtlBasic(event.getChsCoPoolChargeINVO());

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(list);

			// Put value to etcData for mapping to inside of form.
			CHSCoPoolChargeMGTVO chsCoPoolChargeMGTVO = new CHSCoPoolChargeMGTVO();
			if(list.size() > 0){
				chsCoPoolChargeMGTVO = (CHSCoPoolChargeMGTVO)list.get(0);
			}

			eventResponse.setETCData(chsCoPoolChargeMGTVO.getColumnValues());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

	}


	/**
	 * [EES_CGM_1123] : [Save]<br>
	 * Manage inserted Co-op Pool Charge.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSCoPoolChargeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm1123Event event = (EesCgm1123Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();

		try{
			begin();

			// 1. Checking Invoice No of CGM_PAY_INV whether exists or not on 'LS' or 'NP' for Exception process. 
			// 2. Checking Invoice No at different Cost Month on 'CP' whether exists or not for Exception process.
			command.checkCHSInvoiceNoBasic(event.getChsCoPoolChargeINVO().getInvNo(),
						event.getChsCoPoolChargeINVO().getChssMgstInvKndCd(), event.getChsCoPoolChargeINVO().getCostYrmon());

			// Putting in action save process in case of not existing Invoice No in 'LS' or 'NP'
			CHSCoPoolChargeMGTVO data = command.searchCHSCoPoolChargeMainBasic(event.getChsCoPoolChargeINVO());

			if(data == null){
				command.createCHSCoPoolChargeBasic(event.getChsCoPoolChargeINVOS(), event.getChsCoPoolChargeINVO(), account);
			} else {
				command.modifyCHSCoPoolChargeBasic(event.getChsCoPoolChargeINVOS(), event.getChsCoPoolChargeINVO(), account);
			}

			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1123] : [Delete]<br>
	 * Deleting saved Co-op Pool Charge data.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCHSCoPoolChargeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm1123Event event = (EesCgm1123Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();

		try{
			begin();
			command.removeCHSCoPoolChargeBasic(event.getChsCoPoolChargeINVO(), account);
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1021] : [Retrieve]<br>
	 * Retrieve currently stored agreement list of chassis equipment lease.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSAgreementListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1021Event event = (EesCgm1021Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			List<CHSAgreementListMGTVO> list = command.searchCHSAgreementListBasic(event.getChsAgreementListINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2023] : [Retrieve]<br>
	 * Retrieve currently stored agreement list of M.G.Set equipment lease.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSAgreementListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2023Event event = (EesCgm2023Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			List<MGSAgreementListMGTVO> list = command.searchMGSAgreementListBasic(event.getMgsAgreementListINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1117] : [Retrieve]<br>
	 * Retrieve basic information of Chassis equipment lease agreement.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSAgreementSelectionListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1117Event event = (EesCgm1117Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			List<CHSAgreementListMGTVO> list = command.searchCHSAgreementSelectionListBasic(event.getChsAgreementListINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}

	}

	/**
	 * [EES_CGM_2022] : [Retrieve]<br>
	 * Retrieve basic information of M.G.Set equipment lease agreement.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSAgreementSelectionListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2022Event event = (EesCgm2022Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			List<MGSAgreementListMGTVO> list = command.searchMGSAgreementSelectionListBasic(event.getMgsAgreementListINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1020] : [Retrieve]<br>
	 * Retrieve basic information, rate, remark and etc data of agreement.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSAgreementAllService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1020Event event = (EesCgm1020Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// Response
			CHSAgreementGroupVO list = command.searchCHSAgreementAllBasic(event.getChsAgreementINVO());

			eventResponse.setETCData((Map<String,String>)list.getEtcData());
			eventResponse.setRsVoList((List<CHSAgreementMGTVO>)list.getChsagreementmgtvo());
			eventResponse.setRsVoList((List<CHSAgreementMGTVO>)list.getChsagreementmgtvo2());
			eventResponse.setRsVoList((List<CHSAgreementMGTVO>)list.getChsagreementmgtvo3());
			eventResponse.setRsVoList((List<CHSAgreementMGTVO>)list.getChsagreementmgtvo4());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1022] : [Retrieve]<br>
	 * Retrieve basic information, rate, remark and etc data of agreement in Pop-up type.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSAgreementDtlPopupService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1022Event event = (EesCgm1022Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// Response
			CHSAgreementGroupVO list = command.searchCHSAgreementAllBasic(event.getChsAgreementINVO());

			eventResponse.setETCData((Map<String,String>)list.getEtcData());
			eventResponse.setRsVoList((List<CHSAgreementMGTVO>)list.getChsagreementmgtvo());
			eventResponse.setRsVoList((List<CHSAgreementMGTVO>)list.getChsagreementmgtvo2());
			eventResponse.setRsVoList((List<CHSAgreementMGTVO>)list.getChsagreementmgtvo3());
			eventResponse.setRsVoList((List<CHSAgreementMGTVO>)list.getChsagreementmgtvo4());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1020] : [Save] <br>
	 * Create initial agreement.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCHSAgreementService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1020Event event = (EesCgm1020Event)e;
		ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
		try{
			List<CHSAgreementINVO[]> voList = new ArrayList<CHSAgreementINVO[]>();
			voList.add(event.getChsAgreementINVOS1());
			voList.add(event.getChsAgreementINVOS2());
			voList.add(event.getChsAgreementINVOS3());
			voList.add(event.getChsAgreementINVOS4());
			voList.add(event.getChsAgreementINVOS5());

			begin();
			CHSAgreementMGTVO chsAgreementMGTVO = command.modifyCHSAgreementBasic (voList, event.getChsAgreementINVO() ,account);

			// Setting ETC DATA
			eventResponse.setETCData((Map<String,String>)chsAgreementMGTVO.getColumnValues());

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1020] : [Delete] <br>
	 * Deleting Agreement that selected.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCHSAgreementService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1020Event event = (EesCgm1020Event)e;
		ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
		try{
			begin();
			command.removeCHSAgreementBasic (event.getChsAgreementINVO() ,account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2021] : [Retrieve]<br>
	 * Retrieve basic information, rate, remark and etc data of agreement.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSAgreementAllService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2021Event event = (EesCgm2021Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// Response
			MGSAgreementGroupVO list = command.searchMGSAgreementAllBasic(event.getMgsAgreementINVO());
/*
			eventResponse.setETCData((Map<String,String>)list.getEtcData());
			eventResponse.setRsVoList((List<MGSAgreementMGTVO>)list.getMgsagreementmgtvo());
*/			
			

			eventResponse.setETCData((Map<String,String>)list.getEtcData());
			eventResponse.setRsVoList((List<MGSAgreementMGTVO>)list.getMgsagreementmgtvervo());
			eventResponse.setRsVoList((List<MGSAgreementMGTVO>)list.getMgsagreementmgtvo());
			eventResponse.setRsVoList((List<MGSAgreementMGTVO>)list.getMgsagreementmgtvo2());
			eventResponse.setRsVoList((List<MGSAgreementMGTVO>)list.getMgsagreementmgtvo3());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2103] : [Retrieve]<br>
	 * Retrieve basic information, rate, remark and etc data of agreement in Pop-up type.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSAgreementDtlPopupService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2103Event event = (EesCgm2103Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			MGSAgreementGroupVO list = command.searchMGSAgreementAllBasic(event.getMgsAgreementINVO());

//			eventResponse.setETCData((Map<String,String>)list.getEtcData());
//			eventResponse.setRsVoList((List<MGSAgreementMGTVO>)list.getMgsagreementmgtvo());
			
			eventResponse.setETCData((Map<String,String>)list.getEtcData());
			eventResponse.setRsVoList((List<MGSAgreementMGTVO>)list.getMgsagreementmgtvervo());
			eventResponse.setRsVoList((List<MGSAgreementMGTVO>)list.getMgsagreementmgtvo());
			eventResponse.setRsVoList((List<MGSAgreementMGTVO>)list.getMgsagreementmgtvo2());
			eventResponse.setRsVoList((List<MGSAgreementMGTVO>)list.getMgsagreementmgtvo3());
			

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2021] : [Save] <br>
	 * Create initial agreement.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyMGSAgreementService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2021Event event = (EesCgm2021Event)e;
		ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
		try{
			List<MGSAgreementINVO[]> voList = new ArrayList<MGSAgreementINVO[]>();
			voList.add(event.getMgsAgreementINVOS1());
			voList.add(event.getMgsAgreementINVOS2());
			voList.add(event.getMgsAgreementINVOS3());

			begin();
			MGSAgreementMGTVO mgsAgreementMGTVO = command.modifyMGSAgreementBasic (voList,event.getMgsAgreementINVO() ,account);
			// ETC DATA setting
			eventResponse.setETCData((Map<String,String>)mgsAgreementMGTVO.getColumnValues());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2021] : [Delete] <br>
	 * Deleting Agreement that selected.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeMGSAgreementService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2021Event event = (EesCgm2021Event)e;
		ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
		try{
			begin();
			command.removeMGSAgreementBasic (event.getMgsAgreementINVO() ,account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1026] : [Retrieve]<br>
	 * Retrieve equipment list that will term change of selected agreement.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSTermChangeEqListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1026Event event = (EesCgm1026Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			List<CHSTermStatusMGTVO> list = command.searchCHSTermChangeEqListBasic(event.getChsTermStatusINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1026] : [Retrieve]<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSEqMainService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1026Event event = (EesCgm1026Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// Response
			CHSTermStatusGroupVO list = command.searchCHSEqMainBasic(event.getChsTermStatusINVO());

			eventResponse.setRsVoList((List<CHSTermStatusMGTVO>)list.getChstermstatusmgtvos());
			eventResponse.setETCData((Map<String,String>)list.getChstermstatusmgtvo().getColumnValues());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1026] : [Save]<br>
	 * Term Change Action selected agreement.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSTermChangeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1026Event event = (EesCgm1026Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
		try
		{
			begin();
			command.manageCHSTermChangeBasic (event.getChsTermStatusINVOS(), event.getChsTermStatusINVO() ,account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2026] : [Retrieve]<br>
	 * Retrieve equipment list that will term change of selected agreement.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSTermChangeEqListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2026Event event = (EesCgm2026Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			List<MGSTermStatusMGTVO> list = command.searchMGSTermChangeEqListBasic(event.getMgsTermStatusINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2026] : [Retrieve]<br>
	 * Retrieve M.G.Set equipment master information.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSEqMainService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2026Event event = (EesCgm2026Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			// Response
			MGSTermStatusGroupVO list = command.searchMGSEqMainBasic(event.getMgsTermStatusINVO());

			eventResponse.setRsVoList((List<MGSTermStatusMGTVO>)list.getMgstermstatusmgtvos());
			eventResponse.setETCData((Map<String,String>)list.getMgstermstatusmgtvo().getColumnValues());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2026] : [Save]<br>
	 * Term Change Action selected agreement.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMGSTermChangeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2026Event event = (EesCgm2026Event)e;
		ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
		try{
			begin();
			command.manageMGSTermChangeBasic (event.getMgsTermStatusINVOS(), event.getMgsTermStatusINVO() ,account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1118] : [Retrieve]<br>
	 * Display sum of Term Change amount by Chassis Type/Size<br>
	 * match retrieve condition that office, lessor, old agreenent, new agreement.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSTermChangeResultSmryService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1118Event event = (EesCgm1118Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			List<CHSTermChangeResultMGTVO> list = command.searchCHSTermChangeResultSmryBasic(event.getChsTermChangeResultINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2028] : [Retrieve]<br>
	 * Display sum of Term Change amount by Chassis Type/Size<br>
	 * match retrieve condition that office, lessor, old agreenent, new agreement.<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSTermChangeResultSmryService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2028Event event = (EesCgm2028Event)e;
			ChassisMgsetAgreementBC command = new ChassisMgsetAgreementBCImpl();
			List<MGSTermChangeResultMGTVO> list = command.searchMGSTermChangeResultSmryBasic(event.getMgsTermChangeResultINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1029] : [Retrieve]<br>
	 * Retrieve Charge creation list in this month.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSChargeCreationListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1029Event event = (EesCgm1029Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSChargeCreationMGTVO> list = command.searchCHSChargeCreationListBasic(event.getChsChargeCreationINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1029] : [Retrieve]<br>
	 * Retrieve result value of Charge Creation.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSChargeCreationResultService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1029Event event = (EesCgm1029Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSChargeCreationMGTVO> list = command.searchCHSChargeCreationResultBasic(event.getChsChargeCreationINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1029] : [Charge Creation]<br>
	 * Create that month Charge of selected agreement that month.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createCHSChargeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1029Event event = (EesCgm1029Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();

			command.createCHSChargeBasic(event.getChsChargeCreationINVOS(), event.getChsChargeCreationINVO(), account);
			List<CHSChargeCreationMGTVO> chargeList = command.searchCHSChargeCreationListBasic(event.getChsChargeCreationINVO());
			List<CHSChargeCreationMGTVO> resultList = command.searchCHSChargeCreationResultBasic(event.getChsChargeCreationINVO());

			eventResponse.setRsVoList(chargeList);
			eventResponse.setRsVoList(resultList);

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1029] : [Delete]<br>
	 * Delete selected Charge.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCHSChargeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1029Event event = (EesCgm1029Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.removeCHSChargeBasic(event.getChsChargeCreationINVOS(), event.getChsChargeCreationINVO(), account);
			List<CHSChargeCreationMGTVO> list = command.searchCHSChargeCreationListBasic(event.getChsChargeCreationINVO());
			eventResponse.setRsVoList(list);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2032] : [Retrieve]<br>
	 * Retrieve Charge creation list in this month.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSChargeCreationListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2032Event event = (EesCgm2032Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSChargeCreationMGTVO> list = command.searchMGSChargeCreationListBasic(event.getMgsChargeCreationINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2032] : [Retrieve]<br>
	 * Retrieve result value of Charge Creation.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSChargeCreationResultService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2032Event event = (EesCgm2032Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSChargeCreationMGTVO> list = command.searchMGSChargeCreationResultBasic(event.getMgsChargeCreationINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2032] : [Charge Creation]<br>
	 * Create that month Charge of selected agreement that month.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createMGSChargeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2032Event event = (EesCgm2032Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();

			command.createMGSChargeBasic(event.getMgsChargeCreationINVOS(), event.getMgsChargeCreationINVO(), account);
			List<MGSChargeCreationMGTVO> chargeList = command.searchMGSChargeCreationListBasic(event.getMgsChargeCreationINVO());
			List<MGSChargeCreationMGTVO> resultList = command.searchMGSChargeCreationResultBasic(event.getMgsChargeCreationINVO());

			eventResponse.setRsVoList(chargeList);
			eventResponse.setRsVoList(resultList);

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2032] : [Delete]<br>
	 * Delete selected Charge.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeMGSChargeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2032Event event = (EesCgm2032Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.removeMGSChargeBasic(event.getMgsChargeCreationINVOS(), event.getMgsChargeCreationINVO(), account);
			List<MGSChargeCreationMGTVO> list = command.searchMGSChargeCreationListBasic(event.getMgsChargeCreationINVO());
			eventResponse.setRsVoList(list);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1125] : [Retrieve] <br>
	 * Retrieve saved Pool Estimate Amount. Retrieve<br>
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPoolEstimateAmtService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1125Event event = (EesCgm1125Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<PoolEstmExpenseMGTVO> list = command.searchPoolEstimateAmtBasic(event.getPoolEstmExpenseINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1125] : [Save] <br>
	 * Retrieve saved Pool Estimate Amount. Save <br>
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyPoolEstimateAmtService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1125Event event = (EesCgm1125Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			PoolEstmExpenseMGTVO[]  tmp = event.getPoolEstmExpenseMGTVOs();

			log.debug("===PoolEstmExpenseMGTVO======================================="+tmp);

			command.modifyPoolEstimateAmtBasic(event.getPoolEstmExpenseMGTVOs(),account);
//			eventResponse.setUserMessage(new ErrorHandler("CGM00002").getUserMessage());
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1126] : [Retrieve] <br>
	 * 
	 * Retrieve Estimate amount by Year, Month, Pool List of Pool type. Retrieve <br>
	 *
	 * @param e
	 * @throws EventException
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPoolEstimateReportService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1126Event event = (EesCgm1126Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<PoolEstmExpenseMGTVO> list = command.searchPoolEstimateReportBasic(event.getPoolEstmExpenseINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1030] : [Verify]<br>
	 * Action Verify by EQ unit Invoice draft data that loaded on page.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyCHSInvoiceDraftService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCgm1030Event event = (EesCgm1030Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			List<CHSInvoiceImportAuditMGTVO> list = command.verifyCHSInvoiceDraftBasic(event.getChsInvoiceImportAuditINVOS(), event.getChsInvoiceImportAuditINVO(),account);
			eventResponse.setRsVoList(list);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1030] : [Verify]<br>
	 * Action Verify Insert by EQ unit Invoice draft data that loaded on page.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyCHSInvoiceDraftInsertService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCgm1030Event event = (EesCgm1030Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.verifyCHSInvoiceDraftInsertBasic(event.getChsInvoiceImportAuditINVOS(), event.getChsInvoiceImportAuditINVO(),account);
			commit();
			eventResponse.setETCData("ins_result", "SUCCESS");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1030] : [Verify]<br>
	 * Action Verify Search by EQ unit Invoice draft data that loaded on page.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyCHSInvoiceDraftSearchService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCgm1030Event event = (EesCgm1030Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<CHSInvoiceImportAuditMGTVO> list = command.verifyCHSInvoiceDraftSearchBasic(event.getChsInvoiceImportAuditINVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2085] : [Verify]<br>
	 * Action Verify Insert by EQ unit Invoice draft data that loaded on page.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyMGSInvoiceDraftInsertService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCgm2085Event event = (EesCgm2085Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			command.verifyMGSInvoiceDraftInsertBasic(event.getMgsInvoiceImportAuditINVOS(), event.getMgsInvoiceImportAuditINVO(),account);
			commit();
			eventResponse.setETCData("ins_result", "SUCCESS");
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2085] : [Verify]<br>
	 * 화Action Verify Search by EQ unit Invoice draft data that loaded on page.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyMGSInvoiceDraftSearchService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCgm2085Event event = (EesCgm2085Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<MGSInvoiceImportAuditMGTVO> list = command.verifyMGSInvoiceDraftSearchBasic(event.getMgsInvoiceImportAuditINVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1030] : [Save]<br>
	 * Audit and Save invoice draft that loaded on Invoice import page.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse auditCHSInvoiceDraftService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1030Event event = (EesCgm1030Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.auditCHSInvoiceDraftBasic(event.getChsInvoiceImportAuditINVOS(), event.getChsInvoiceImportAuditINVO(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2085] : [Verify]<br>
	 * Action Verify by EQ unit Invoice draft data that loaded on page..(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse verifyMGSInvoiceDraftService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EesCgm2085Event event = (EesCgm2085Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();
			List<MGSInvoiceImportAuditMGTVO> list = command.verifyMGSInvoiceDraftBasic(event.getMgsInvoiceImportAuditINVOS(), event.getMgsInvoiceImportAuditINVO(),account);
			eventResponse.setRsVoList(list);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}


		return eventResponse;
	}

	/**
	 * [EES_CGM_2085] : [Save]<br>
	 * Audit and Save invoice draft that loaded on Invoice import page.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse auditMGSInvoiceDraftService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2085Event event = (EesCgm2085Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.auditMGSInvoiceDraftBasic(event.getMgsInvoiceImportAuditINVOS(), event.getMgsInvoiceImportAuditINVO(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1031] : [Retrieve]<br>
	 * Retrieve Agreement Audit result that selected at Lease payable amount confirm page open.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSInvoiceAuditResultService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1031Event event = (EesCgm1031Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CHSConfirmPayableGRPVO resultVO = command.searchCHSInvoiceAuditResultBasic(event.getChsConfirmPayableAmountINVO());
			List<List<CHSConfirmPayableAmountMGTVO>> list = resultVO.getcHSConfirmPayableAmountMGTVOs();

			for(int i=0; i<list.size(); i++){
				eventResponse.setRsVoList((List<CHSConfirmPayableAmountMGTVO>)list.get(i));
			}
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1031] : [Save]<br>
	 * Save Invoice Audit result status by Eq.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSInvoiceAuditResultService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1031Event event = (EesCgm1031Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();

			List<CHSConfirmPayableAmountINVO[]> voList = new ArrayList<CHSConfirmPayableAmountINVO[]>();

			voList.add(event.getChsConfirmPayableAmountINVOS1());
			voList.add(event.getChsConfirmPayableAmountINVOS2());
			voList.add(event.getChsConfirmPayableAmountINVOS3());

			List<CHSConfirmPayableAmountMGTVO> list = command.manageCHSInvoiceAuditResultBasic(voList,event.getChsConfirmPayableAmountINVO(), account);

			// Retrieve list in case of Invoice Only
			if(event.getChsConfirmPayableAmountINVOS3() != null){
				eventResponse.setRsVoList(list);
			}

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1031] : [Payable Amount Confirm]<br>
	 * Confirm handling cost by payable amount of page.(Chassis) <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmCHSPayableAmountService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1031Event event = (EesCgm1031Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.confirmCHSPayableAmountBasic(event.getChsConfirmPayableAmountINVOS(), event.getChsConfirmPayableAmountINVO(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1031] : [Payable Amount Confirm]<br>
	 * Cancel handling cost by payable amount of page..(Chassis) <br>
	 *
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelCHSPayableAmountService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm1031Event event = (EesCgm1031Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.cancelCHSPayableAmountBasic(event.getChsConfirmPayableAmountINVO(), account);

			CHSConfirmPayableGRPVO resultVO = command.searchCHSInvoiceAuditResultBasic(event.getChsConfirmPayableAmountINVO());
			List<List<CHSConfirmPayableAmountMGTVO>> list = resultVO.getcHSConfirmPayableAmountMGTVOs();

			for(int i=0; i<list.size(); i++){
				eventResponse.setRsVoList((List<CHSConfirmPayableAmountMGTVO>)list.get(i));
			}
			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2098] : [Retrieve]<br>
	 * Retrieve Agreement Audit result that selected at Lease payable amount confirm page open.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSInvoiceAuditResultService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2098Event event = (EesCgm2098Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CHSConfirmPayableGRPVO resultVO = command.searchMGSInvoiceAuditResultBasic(event.getMgsConfirmPayableAmountINVO());
			List<List<MGSConfirmPayableAmountMGTVO>> list = resultVO.getmGSConfirmPayableAmountMGTVOs();

			for(int i=0; i<list.size(); i++){
				eventResponse.setRsVoList((List<MGSConfirmPayableAmountMGTVO>)list.get(i));
			}
			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2098] : [Save]<br>
	 * Save Invoice Audit result status by Eq.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMGSInvoiceAuditResultService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2098Event event = (EesCgm2098Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();

			List<MGSConfirmPayableAmountINVO[]> voList = new ArrayList<MGSConfirmPayableAmountINVO[]>();

			voList.add(event.getMgsConfirmPayableAmountINVOS1());
			voList.add(event.getMgsConfirmPayableAmountINVOS2());
			voList.add(event.getMgsConfirmPayableAmountINVOS3());

			List<MGSConfirmPayableAmountMGTVO> list = command.manageMGSInvoiceAuditResultBasic(voList,event.getMgsConfirmPayableAmountINVO(), account);

			// Retrieve list in case Invoice Only
			if(event.getMgsConfirmPayableAmountINVOS3() != null){
				eventResponse.setRsVoList(list);
			}

			commit();
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2098] : [Payable Amount Confirm]<br>
	 * Confirm handling cost by payable amount of page.(M.G.Set) <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse confirmMGSPayableAmountService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2098Event event = (EesCgm2098Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.confirmMGSPayableAmountBasic(event.getMgsConfirmPayableAmountINVOS(), event.getMgsConfirmPayableAmountINVO(), account);
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2098] : [Payable Amount Confirm]<br>
	 * Cancel handling cost by payable amount of page.(M.G.Set) <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelMGSPayableAmountService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EesCgm2098Event event = (EesCgm2098Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		try{
			begin();
			command.cancelMGSPayableAmountBasic(event.getMgsConfirmPayableAmountINVO(), account);
			CHSConfirmPayableGRPVO resultVO = command.searchMGSInvoiceAuditResultBasic(event.getMgsConfirmPayableAmountINVO());

			List<List<MGSConfirmPayableAmountMGTVO>> list = resultVO.getmGSConfirmPayableAmountMGTVOs();

			for(int i=0; i<list.size(); i++){
				eventResponse.setRsVoList((List<MGSConfirmPayableAmountMGTVO>)list.get(i));
			}
			commit();
		}catch(EventException ex){
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1124] : [Retrieve]<br>
	 * Retrieve Neutral Pool Charge list<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSNuPoolChargeListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1124Event event = (EesCgm1124Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSNuPoolChargeMGTVO> list = command.searchCHSNuPoolChargeListBasic(event.getChsNuPoolChargeINVO());

			StringBuffer comboList = new StringBuffer("");
			for(int i=0; i<list.size(); i++){
				CHSNuPoolChargeMGTVO chsNuPoolChargeMGTVO = (CHSNuPoolChargeMGTVO)list.get(i);

				comboList.append(chsNuPoolChargeMGTVO.getInvNo() + "|" + chsNuPoolChargeMGTVO.getChssMgstInvStsCd());

				if(i < list.size()-1) comboList.append("@");
			}

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setETCData("comboList", comboList.toString());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1124] : [Retrieve]<br>
	 * Retrieve initial item of Neutral Pool Charge.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSNuPoolChargeInitService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1124Event event = (EesCgm1124Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSNuPoolChargeMGTVO> list = command.searchCHSNuPoolChargeInitBasic(event.getChsNuPoolChargeINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1124] : [Retrieve]<br>
	 * Retrieve details of Neutral Pool Charge.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSNuPoolChargeDtlService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1124Event event = (EesCgm1124Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();

			List<CHSNuPoolChargeMGTVO> list = command.searchCHSNuPoolChargeDtlBasic(event.getChsNuPoolChargeINVO());

			CHSNuPoolChargeMGTVO chsNuPoolChargeMGTVO = new CHSNuPoolChargeMGTVO();
			if(list.size() > 0){

				chsNuPoolChargeMGTVO = (CHSNuPoolChargeMGTVO)list.get(0);
			}

			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			// Put value to etcData for mapping to inside of form.
			eventResponse.setETCData(chsNuPoolChargeMGTVO.getColumnValues());

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}


	/**
	 * [EES_CGM_1124] : [Save]<br>
	 * Manage inserted Neutral Pool Charge.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSNuPoolChargeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm1124Event event = (EesCgm1124Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();

		try{
			begin();

			// 1. Checking Invoice No of CGM_PAY_INV whether exists or not on 'LS' or 'CP' for Exception process. 
			// 2. Checking Invoice No at different Cost Month on 'NP' whether exists or not for Exception process.

			command.checkCHSInvoiceNoBasic(event.getChsNuPoolChargeINVO().getInvNo(),
						event.getChsNuPoolChargeINVO().getChssMgstInvKndCd(), event.getChsNuPoolChargeINVO().getCostYrmon());

			// Putting in action save process in case of not existing Invoice No in 'LS' or 'NP'
			CHSNuPoolChargeMGTVO data = command.searchCHSNuPoolChargeMainBasic(event.getChsNuPoolChargeINVO());

			if(data == null){
				command.createCHSNuPoolChargeBasic(event.getChsNuPoolChargeINVOS(), event.getChsNuPoolChargeINVO(), account);
			} else {
				command.modifyCHSNuPoolChargeBasic(event.getChsNuPoolChargeINVOS(), event.getChsNuPoolChargeINVO(), account);
			}

			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1124] : [Delete]<br>
	 * Delete saved Neutral Pool Charge data.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeCHSNuPoolChargeService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm1124Event event = (EesCgm1124Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();

		try{
			begin();
			command.removeCHSNuPoolChargeBasic(event.getChsNuPoolChargeINVO(), account);
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1034] : [Retrieve]<br>
	 * Retrieve Invoice List.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSInvoiceListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1034Event event = (EesCgm1034Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSPayableInvoiceCreationMGTVO> list = command.searchCHSInvoiceListBasic(event.getChsPayableInvoiceCreationINVO(), account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1034] : [Grid(dclick)]<br>
	 * Retrieve details of selected invoice.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSInvoiceDetailService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1034Event event = (EesCgm1034Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSPayableInvoiceCreationMGTVO> list = command.searchCHSInvoiceDetailBasic(event.getChsPayableInvoiceCreationINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1034] : [Invoice Confirm]<br>
	 * Creation invoice from contents of page (Issue date, effective date, receive date, revenue VVD, etc) (Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createCHSInvoiceService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm1034Event event = (EesCgm1034Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl();

		try{
			begin();

			// CSR handling
			CHSPayableInvoiceCreationINVO[] chsPayableInvoiceCreationINVOS = event.getChsPayableInvoiceCreationINVOS();

			for(int i=0; i<chsPayableInvoiceCreationINVOS.length; i++){

				CHSPayableInvoiceCreationINVO chsPayableInvoiceCreationINVO = event.getChsPayableInvoiceCreationINVO();

				// setting parameter value
				if(!chsPayableInvoiceCreationINVOS[i].getInvTaxCltTpCd().equals("")){
					chsPayableInvoiceCreationINVO.setInvTaxCltTpCd(chsPayableInvoiceCreationINVOS[i].getInvTaxCltTpCd());
				} else {
					chsPayableInvoiceCreationINVO.setInvTaxCltTpCd("0");
				}

				if(!chsPayableInvoiceCreationINVOS[i].getInvTaxRt().equals("")){
					chsPayableInvoiceCreationINVO.setInvTaxRt(chsPayableInvoiceCreationINVOS[i].getInvTaxRt());
				} else {
					chsPayableInvoiceCreationINVO.setInvTaxRt("0");
				}

				if(!chsPayableInvoiceCreationINVOS[i].getChgSmryAmt().equals("")){
					chsPayableInvoiceCreationINVO.setChgSmryAmt(chsPayableInvoiceCreationINVOS[i].getChgSmryAmt());
				} else {
					chsPayableInvoiceCreationINVO.setChgSmryAmt("0");
				}

				chsPayableInvoiceCreationINVO.setPayInvSeq(chsPayableInvoiceCreationINVOS[i].getPayInvSeq());
				chsPayableInvoiceCreationINVO.setChssMgstInvKndCd(chsPayableInvoiceCreationINVOS[i].getChssMgstInvKndCd());

				// setting AP_INV_MAIN
				ApPayInvVO apPayInvVO = command.searchCHSInvoiceCreateMainBasic(chsPayableInvoiceCreationINVO, account);

				// setting AP_INV_DTL
				ApPayInvDtlVO[] apPayInvDtlVOs = command.searchCHSInvoiceCreateDetailBasic(chsPayableInvoiceCreationINVO, account);

				// action CSR method
				String  invRgstNo = command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);

				// setting INV_RGST_NO value from CSR
				chsPayableInvoiceCreationINVOS[i].setInvRgstNo(invRgstNo);

			}

			// inside module
			command.createCHSInvoiceBasic(chsPayableInvoiceCreationINVOS, event.getChsPayableInvoiceCreationINVO(), account);
			List<CHSPayableInvoiceCreationMGTVO> list = command.searchCHSInvoiceListBasic(event.getChsPayableInvoiceCreationINVO(), account);


			eventResponse.setRsVoList(list);
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1034] : [Cancel]<br>
	 * Cancel handling Confirmed Invoice to Charge Creation status.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelCHSInvoiceService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm1034Event event = (EesCgm1034Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl();

		try{
			begin();

			// CSR handling
			CHSPayableInvoiceCreationINVO[] chsPayableInvoiceCreationINVOS = event.getChsPayableInvoiceCreationINVOS();

			for(int i=0; i<chsPayableInvoiceCreationINVOS.length; i++){

				ApPayInvVO apPayInvVO = new ApPayInvVO();
				ApPayInvDtlVO[] apPayInvDtlVOs = new ApPayInvDtlVO[0];

				apPayInvVO.setUpdUsrId(account.getUsr_id());
				apPayInvVO.setInvOfcCd(account.getOfc_cd());
				apPayInvVO.setDeltFlg("Y");
				apPayInvVO.setInvRgstNo(chsPayableInvoiceCreationINVOS[i].getInvRgstNo());

				// action CSR method
				command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);

			}

			// inside module
			command.cancelCHSInvoiceBasic(event.getChsPayableInvoiceCreationINVOS(), event.getChsPayableInvoiceCreationINVO(), account);
			List<CHSPayableInvoiceCreationMGTVO> list = command.searchCHSInvoiceListBasic(event.getChsPayableInvoiceCreationINVO(), account);
			eventResponse.setRsVoList(list);
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2035] : [Retrieve]<br>
	 * Retrieve Invoice List.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSInvoiceListService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2035Event event = (EesCgm2035Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSPayableInvoiceCreationMGTVO> list = command.searchMGSInvoiceListBasic(event.getMgsPayableInvoiceCreationINVO(), account);
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2035] : [Retrieve]<br>
	 * Retrieve details of selected invoice.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSInvoiceDetailService(Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2035Event event = (EesCgm2035Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSPayableInvoiceCreationMGTVO> list = command.searchMGSInvoiceDetailBasic(event.getMgsPayableInvoiceCreationINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2035] : [Invoice Confirm]<br>
	 * Creation invoice from contents of page (Issue date, effective date, receive date, revenue VVD, etc)(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createMGSInvoiceService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm2035Event event = (EesCgm2035Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl();

		try{
			begin();

			// CSR handling
			MGSPayableInvoiceCreationINVO[] mgsPayableInvoiceCreationINVOS = event.getMgsPayableInvoiceCreationINVOS();

			for(int i=0; i<mgsPayableInvoiceCreationINVOS.length; i++){

				MGSPayableInvoiceCreationINVO mgsPayableInvoiceCreationINVO = event.getMgsPayableInvoiceCreationINVO();

				// setting parameter value
				if(!mgsPayableInvoiceCreationINVOS[i].getInvTaxCltTpCd().equals("")){
					mgsPayableInvoiceCreationINVO.setInvTaxCltTpCd(mgsPayableInvoiceCreationINVOS[i].getInvTaxCltTpCd());
				} else {
					mgsPayableInvoiceCreationINVO.setInvTaxCltTpCd("0");
				}

				if(!mgsPayableInvoiceCreationINVOS[i].getInvTaxRt().equals("")){
					mgsPayableInvoiceCreationINVO.setInvTaxRt(mgsPayableInvoiceCreationINVOS[i].getInvTaxRt());
				} else {
					mgsPayableInvoiceCreationINVO.setInvTaxRt("0");
				}

				if(!mgsPayableInvoiceCreationINVOS[i].getChgSmryAmt().equals("")){
					mgsPayableInvoiceCreationINVO.setChgSmryAmt(mgsPayableInvoiceCreationINVOS[i].getChgSmryAmt());
				} else {
					mgsPayableInvoiceCreationINVO.setChgSmryAmt("0");
				}

				mgsPayableInvoiceCreationINVO.setPayInvSeq(mgsPayableInvoiceCreationINVOS[i].getPayInvSeq());
				mgsPayableInvoiceCreationINVO.setChssMgstInvKndCd(mgsPayableInvoiceCreationINVOS[i].getChssMgstInvKndCd());

				// setting AP_INV_MAIN
				ApPayInvVO apPayInvVO = command.searchMGSInvoiceCreateMainBasic(mgsPayableInvoiceCreationINVO, account);

				// setting AP_INV_DTL
				ApPayInvDtlVO[] apPayInvDtlVOs = command.searchMGSInvoiceCreateDetailBasic(mgsPayableInvoiceCreationINVO, account);

				// action CSR method
				String  invRgstNo = command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);

				// setting INV_RGST_NO value from CSR
				mgsPayableInvoiceCreationINVOS[i].setInvRgstNo(invRgstNo);

			}

			// inside module
			command.createMGSInvoiceBasic(event.getMgsPayableInvoiceCreationINVOS(), event.getMgsPayableInvoiceCreationINVO(), account);
			List<MGSPayableInvoiceCreationMGTVO> list = command.searchMGSInvoiceListBasic(event.getMgsPayableInvoiceCreationINVO(), account);

			eventResponse.setRsVoList(list);
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2035] : [Cancel]<br>
	 * Cancel handling Confirmed Invoice to Charge Creation status..(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelMGSInvoiceService (Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm2035Event event = (EesCgm2035Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
		CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl();

		try{
			begin();

			// CSR handling
			MGSPayableInvoiceCreationINVO[] mgsPayableInvoiceCreationINVOS = event.getMgsPayableInvoiceCreationINVOS();

			for(int i=0; i<mgsPayableInvoiceCreationINVOS.length; i++){

				ApPayInvVO apPayInvVO = new ApPayInvVO();
				ApPayInvDtlVO[] apPayInvDtlVOs = new ApPayInvDtlVO[0];

				apPayInvVO.setUpdUsrId(account.getUsr_id());
				apPayInvVO.setInvOfcCd(account.getOfc_cd());
				apPayInvVO.setDeltFlg("Y");
				apPayInvVO.setInvRgstNo(mgsPayableInvoiceCreationINVOS[i].getInvRgstNo());

				// action CSR method
				command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);

			}

			command.cancelMGSInvoiceBasic(event.getMgsPayableInvoiceCreationINVOS(), event.getMgsPayableInvoiceCreationINVO(), account);
			List<MGSPayableInvoiceCreationMGTVO> list = command.searchMGSInvoiceListBasic(event.getMgsPayableInvoiceCreationINVO(), account);
			eventResponse.setRsVoList(list);
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1107] : [Retrieve]<br>
	 * retrieve chassis Estimated settlement by month. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSEstimateExpenseService (Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1107Event event = (EesCgm1107Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSEstimateExpenseMGTVO> list = command.searchCHSEstimateExpenseBasic(event.getCHSEstimateExpenseINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1107] : [Retrieve]<br>
	 * Calculation chassis Estimated settlement by month. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSEstimateExpenseCalcService (Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1107Event event = (EesCgm1107Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSEstimateExpenseMGTVO> list = command.searchCHSEstimateExpenseCalcBasic(event.getCHSEstimateExpenseINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1107] : [Retrieve]<br>
	 * retrieve chassis Estimated settlement summary by month. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSEstimateExpenseSummaryService (Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1107Event event = (EesCgm1107Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSEstimateExpenseMGTVO> list = command.searchCHSEstimateExpenseSummaryBasic(event.getCHSEstimateExpenseINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1107] : [manage]<br>
	 * Manage chassis Estimated settlement by month. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCHSEstimateExpenseCalcService (Event e) throws EventException {
		log.debug("☆★☆1107--------------------------->>");
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm1107Event event = (EesCgm1107Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();

		try{
			begin();
			command.manageCHSEstimateExpenseCalcBasic(event.getCHSEstimateExpenseINVO(),event.getCHSEstimateExpenseINVOs(), account);
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_2206] : [Retrieve]<br>
	 * retrieve M.G.Set Estimated settlement by month. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSEstimateExpenseService (Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2206Event event = (EesCgm2206Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSEstimateExpenseMGTVO> list = command.searchMGSEstimateExpenseBasic(event.getMGSEstimateExpenseINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2206] : [Retrieve]<br>
	 * Calculation M.G.Set Estimated settlement by month. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSEstimateExpenseCalcService (Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2206Event event = (EesCgm2206Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSEstimateExpenseMGTVO> list = command.searchMGSEstimateExpenseCalcBasic(event.getMGSEstimateExpenseINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2206] : [Retrieve]<br>
	 * retrieve M.G.Set Estimated settlement summary by month. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSEstimateExpenseSummaryService (Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2206Event event = (EesCgm2206Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSEstimateExpenseMGTVO> list = command.searchMGSEstimateExpenseSummaryBasic(event.getMGSEstimateExpenseINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2206] : [manage]<br>
	 * Manage M.G.Set Estimated settlement by month. <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageMGSEstimateExpenseCalcService (Event e) throws EventException {
		log.debug("☆★☆2206--------------------------->>");
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EesCgm2206Event event = (EesCgm2206Event)e;
		ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();

		try{
			begin();
			command.manageMGSEstimateExpenseCalcBasic(event.getMGSEstimateExpenseINVO(),event.getMGSEstimateExpenseINVOs(), account);
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [EES_CGM_1035] : [Retrieve]<br>
	 * Retrieve invoice summary of chassis.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSInvoiceInqListService (Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1035Event event = (EesCgm1035Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSInvoiceInquiryMGTVO> list = command.searchCHSInvoiceInqListBasic (event.getCHSInvoiceInquiryINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1035] : [Grid(dclick)]<br>
	 * Retrieve invoice detail data of chassis.(Chassis)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCHSInvoiceInqDtlService (Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm1035Event event = (EesCgm1035Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<CHSInvoiceInquiryMGTVO> list = command.searchCHSInvoiceInqDtlBasic (event.getCHSInvoiceInquiryINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2036] : [Retrieve]<br>
	 * Retrieve invoice summary of M.G.Set.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSInvoiceInqListService (Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2036Event event = (EesCgm2036Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSInvoiceInquiryMGTVO> list = command.searchMGSInvoiceInqListBasic (event.getMGSInvoiceInquiryINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2036] : [Grid(dclick)]<br>
	 * Retrieve invoice detail data of M.G.Set.(M.G.Set)<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchMGSInvoiceInqDtlService (Event e) throws EventException {
		try
		{
			// PDTO(Data Transfer Object including Parameters)
			EesCgm2036Event event = (EesCgm2036Event)e;
			ChassisMgsetInvoiceBC command = new ChassisMgsetInvoiceBCImpl();
			List<MGSInvoiceInquiryMGTVO> list = command.searchMGSInvoiceInqDtlBasic (event.getMGSInvoiceInquiryINVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1021] : [Default] <br>
	 * Default Searvice.. Retrieve <br>
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1021DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2023] : [Default] <br>
	 * Default Searvice.. Retrieve <br>
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2023DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	/**
	 * [EES_CGM_1117] : [Default] <br>
	 * Default Searvice.. Retrieve <br>
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1117DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}
	/**
	 * [EES_CGM_2022] : [Default] <br>
	 * Default Searvice.. Retrieve <br>
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2022DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1020] : [Default] <br>
	 * Default Searvice.. Retrieve <br>
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1020DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			MdmOrganizationINVO mdmOrganizationINVO = new MdmOrganizationINVO();

			mdmOrganizationINVO.setOfcCd(account.getOfc_cd());
			MdmOrganizationMGTVO mdmOrganizationMGTVO  = command.searchOrganizationBasic(mdmOrganizationINVO);
			// setting ETC DATA
			log.debug("mdmOrganizationMGTVO.getArCurrCd()============"+mdmOrganizationMGTVO.getArCurrCd());


			eventResponse.setETCData("ar_curr_cd",mdmOrganizationMGTVO.getArCurrCd());

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			cParam1 = new ComboINVO();
			List<ComboMGTVO> list2 = command.searchPoolListBasic(cParam1);
			eventResponse.setRsVoList(list2);

			cParam1 = new ComboINVO();
			List<ComboMGTVO> list3 = command.searchStateCodeListBasic(cParam1);
			eventResponse.setRsVoList(list3);



			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2021] : [Default] <br>
	 * Default Searvice.. Retrieve <br>
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2021DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();
			
			MdmOrganizationINVO mdmOrganizationINVO = new MdmOrganizationINVO();

			mdmOrganizationINVO.setOfcCd(account.getOfc_cd());
			MdmOrganizationMGTVO mdmOrganizationMGTVO  = command.searchOrganizationBasic(mdmOrganizationINVO);
			// setting ETC DATA
			log.debug("mdmOrganizationMGTVO.getArCurrCd()============"+mdmOrganizationMGTVO.getArCurrCd());


			eventResponse.setETCData("ar_curr_cd",mdmOrganizationMGTVO.getArCurrCd());
			
			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1118] : [Default] <br>
	 * Default Searvice.. Retrieve <br>
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1118DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);


			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2028] : [Default] <br>
	 * Default Searvice.. Retrieve <br>
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2028DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD01948");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1123] : [Default] <br>
	 * Default Searvice.. Retrieve <br>
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1123DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();

			cParam1.setAgmtLstmCd("CP");
			cParam1.setChssPoolCd("");
			List<ComboMGTVO> list1 = command.searchAgreementByPoolBasic(cParam1);

			eventResponse.setRsVoList(list1);

			cParam1 = new ComboINVO();
			List<ComboMGTVO> list2 = command.searchPoolListBasic(cParam1);
			eventResponse.setRsVoList(list2);



			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1124] : [Default] <br>
	 * Default Searvice.. Retrieve <br>
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1124DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// agmt_lstm_cd
			ComboINVO cParam1 = new ComboINVO();

			cParam1.setAgmtLstmCd("NP");
			cParam1.setChssPoolCd("");
			List<ComboMGTVO> list1 = command.searchAgreementByPoolBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	// chungpa 20091230 Default Service Start
	/**
	 * [EES_CGM_1034] : [Default] <br>
	 * Default Searvice.. Retrieve <br>
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm1034DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// Option
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD02355");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_2035] : [Default] <br>
	 * Default Searvice.. Retrieve <br>
	 *
	 * @param e
	 * @throws EventException
	 * @return eventResponse EventResponse
	 */
	private EventResponse searchEesCgm2035DefaultService(Event e) throws EventException {
		try
		{
			GeneralEventResponse eventResponse = new GeneralEventResponse();

			CgmCodeMgtBC command = new CgmCodeMgtBCImpl();

			// Option
			ComboINVO cParam1 = new ComboINVO();
			cParam1.setIntgCdId("CD02355");
			List<ComboMGTVO> list1 = command.searchCommonCodeListBasic(cParam1);
			eventResponse.setRsVoList(list1);

			return eventResponse;
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("CGM20032").getMessage(), ex);
		}
	}

	/**
	 * [EES_CGM_1026] : [Save] - BackEndJob<br>
	 * Action selected agreement Term Change as BackEndJob.(Chassis)<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse backEndCHSTermChangeListService(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			EesCgm1026Event event = (EesCgm1026Event)e;
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			String status = command.backEndCHSTermChangeListBasic(event.getChsTermStatusINVOS(), event.getChsTermStatusINVO() ,account);
			eventResponse.setETCData("BackEndJobKey", status);
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
	 * EES_CGM_1026 : BackEndJob<br>
	 * Retrieve status value of BackEndJob action result.<br>
	 *
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse searchComBackEndJobStatusService(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ChassisMgsetOnOffhireBC command = new ChassisMgsetOnOffhireBCImpl();
			String key = (String)e.getAttribute("KEY");

			List<String> list = command.searchComBackEndJobStatusBasic(key);
			
			eventResponse.setETCData("jb_sts_flg", list.get(0));
			eventResponse.setETCData("jb_usr_err_msg", list.get(1));
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	//Default Service End
}