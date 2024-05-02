/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : RFAProposalSC.java
 *@FileTitle : S/C Location Group Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0 
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBC;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.basic.PRICommonBCImpl;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.ComOrganizationVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.PriParaCdDtlVO;
import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.basic.AuthorizationAssignmentBC;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.basic.AuthorizationAssignmentBCImpl;
import com.clt.apps.opus.esm.pri.primasterdata.authorizationassignment.vo.OrganizationVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.basic.RFAAffiliateProposalBC;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.basic.RFAAffiliateProposalBCImpl;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.event.EsmPri200306Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.event.EsmPri201906Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.event.EsmPri204107Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.vo.PriRpAfilInqVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltAfilListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltPriRpAfilHdrVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaaffiliateproposal.vo.RsltPriRpAfilVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.basic.RFADurationProposalBC;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.basic.RFADurationProposalBCImpl;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.event.EsmPri2010Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.event.EsmPri204101Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpDurVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpScpDurCntVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.CstPriRpScpDurVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.CstScpDurVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.GrpDurVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.RsltPriRpDurHisVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfadurationproposal.vo.RsltPriRpDurVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.basic.RFAGRICalculationProposalBC;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.basic.RFAGRICalculationProposalBCImpl;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.event.EsmPri2033Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.event.EsmPri2087Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcGrpListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagricalculationproposal.vo.RsltGriCalcListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.basic.RFAGroupCommodityProposalBC;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.basic.RFAGroupCommodityProposalBCImpl;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.event.EsmPri200303Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.event.EsmPri201903Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.event.EsmPri204103Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.RsltGrpCmdtDtlListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagroupcommodityproposal.vo.RsltGrpCmdtListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.basic.RFAGroupLocationProposalBC;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.basic.RFAGroupLocationProposalBCImpl;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.event.EsmPri200302Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.event.EsmPri201902Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.event.EsmPri204104Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.integration.RFAGroupLocationProposalDBDAO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.vo.RsltGrpLocDtlListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfagrouplocationproposal.vo.RsltGrpLocListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.basic.RFANoteConversionProposalBC;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.basic.RFANoteConversionProposalBCImpl;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteconversionproposal.vo.RsltNoteConvVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.basic.RFANoteProposalBC;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.basic.RFANoteProposalBCImpl;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.event.EsmPri200301Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.event.EsmPri201901Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.event.EsmPri204108Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteCtntListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfanoteproposal.vo.RsltNoteListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposaldemdet.basic.RFAProposalDEMDETBC;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposaldemdet.basic.RFAProposalDEMDETBCImpl;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposaldemdet.event.EsmPri204109Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposaldemdet.event.EsmPri2058Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposaldemdet.vo.RsltDmdtExptHisListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposaldemdet.vo.RsltDmdtExptListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBC;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBCImpl;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2003Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2007Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2019Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2040Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2041Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2044Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2049Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.event.EsmPri2080Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.CstPriRpAmendVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.CstRequestCheckVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.DmtScExptVerVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RequestCheckForCalculationVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RpScpGlineCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltAmdtHisMnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriRpAmdHstMnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPriRpInqVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropAmdtSmryVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropCustInfoVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropInqListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropScpAmdtSmryVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltReturnVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaAproRqstRefVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaMainStsVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltRfaPropCopyVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltStatusVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.SchSaleLeadRfaVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.basic.RFARateProposalBC;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.basic.RFARateProposalBCImpl;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri200307Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri201907Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2022Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2023Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2024Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2025Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2034Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2036Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri204105Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2047Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2060Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2065Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2075Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.event.EsmPri2082Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltAllRtListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltPriRpScpRtCgoSpecVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCheckDuplicateVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCmdtListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtCmdtRoutListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalExcelVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListVerticalExcelVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtRoutHdrListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.basic.RFATransportationAdditionalChargeProposalBC;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.basic.RFATransportationAdditionalChargeProposalBCImpl;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri200304Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri201904Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri204106Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.event.EsmPri2050Event;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.ChkFontStyleVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltArbChgListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.vo.RsltPriRpScpTrspAddChgVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.CstPriSpScpDelCntVO;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.ComUpldFileVO;
import com.clt.syscommon.common.table.ComUserVO;
import com.clt.syscommon.common.table.PriRpAmdtSmryVO;
import com.clt.syscommon.common.table.PriRpAproRqstRefVO;
import com.clt.syscommon.common.table.PriRpDmdtVO;
import com.clt.syscommon.common.table.PriRpHdrVO;
import com.clt.syscommon.common.table.PriRpMnVO;
import com.clt.syscommon.common.table.PriRpScpAmdtSmryVO;
import com.clt.syscommon.common.table.PriRpScpDurVO;
import com.clt.syscommon.common.table.PriRpScpMnVO;
import com.clt.syscommon.common.table.PriSpCtrtPtyVO;

/**
 * handling business transaction about SCProposal Business Logic ServiceCommand - SCProposal
 * 
 * @author Byeon Young Joo
 * @see RFAGroupLocationProposalDBDAO
 * @since J2EE 1.4
 */

public class RFAProposalSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * preceding process for biz scenario<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * biz scenario closing<br>
	 * clearing related objects<br>
	 */
	public void doEnd() {
		log.debug("RFAProposalSC Closing");
	}

	/**
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsmPri2003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchProposalMain(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchProposalCustomerInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchProposalAmendmentSummary(e);

			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchProposalScopeAmendmentSummary(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchProposalAcceptCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchProposalCountOfferCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
				eventResponse = searchRequestTermsCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH08)) {
				eventResponse = searchProposalScopeStatusCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH09)) {
				eventResponse = searchProposalDeleteCheck(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchCheckDmdtList(e);			
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchCheckDurationList(e);				
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
//				eventResponse = searchProposalMainSaleLeadFirstList(e);			
//			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
//				eventResponse = searchProposalMainSaleLeadList(e);		
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchApprovalCancelCheck(e);	
            /*} else if (e.getFormCommand().isCommand(FormCommand.SEARCH17)) {
                eventResponse = searchProposalMainPRSCMData(e); */ 
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH16)) {
				//2014.11.04 (Temporary)
				eventResponse = checkRFAno(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH18)) {
                eventResponse = searchProposalMainStatus(e);           
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
                eventResponse = searchProposalRequestCancelCheck(e);                                 
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageProposal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = counterofferProposal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = approveProposal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = cancelProposal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = manageProposalAmendmentSummary(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				eventResponse = manageProposalScopeAmendmentSummary(e);
			} else {
				eventResponse = initMainComboData(e);
			}
		}
		// ============================ESM_PRI_2003_01_Start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri200301Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSpecialNoteList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSpecialNoteContentList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchNoteMaxDpSeq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchNoteContentMaxDpSeq(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageNote(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = acceptAllNote(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = cancelAllNote(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = acceptNote(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = cancelNote(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchNoteConversionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchNoteConversionListCopy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI12)) {
				eventResponse = manageNoteConversionCopy(e);
			} else {
				eventResponse = searchCommonSpecialNoteList(e);
			} 
		}
		// ============================ESM_PRI_2003_02_Start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri200302Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupLocationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationDetailList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGroupLocationRateApplyList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGroupLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = acceptAllGroupLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = cancelAllGroupLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = acceptGroupLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = cancelGroupLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				eventResponse = copyGuidelineGroupLocation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI07)) {
				eventResponse = checkOriDestGroupLocationInUse(e);
			} else {
				eventResponse = searchCommonGroupLocationList(e);
			}
		}
		// ============================ESM_PRI_2003_03_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri200303Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupCommodityList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupCommodityDeatilList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchGroupCommodityRateApplyList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGroupCommodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = acceptAllGroupCommodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = cancelAllGroupCommodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = acceptGroupCommodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = cancelGroupCommodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				eventResponse = copyGuidelineGroupCommodity(e);
			} else {
				eventResponse = initAmendSourceStatusCodeList(e);
			}
		}
		// ============================ESM_PRI_2003_04_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri200304Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchArbitraryChargeList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = checkGuidelineCopyArbitraryChargeExist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = checkArbitraryFontStyle(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageArbitraryCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // guideline copy
				eventResponse = copyGuidelineArbitraryCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {
				eventResponse = acceptArbitraryCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {
				eventResponse = cancelArbitraryCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI05)) {
				eventResponse = acceptAllArbitraryCharge(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI06)) {
				eventResponse = cancelAllArbitraryCharge(e);
			} else {
				eventResponse = initArbitraryComboData(e);
			}
		}
		// ============================ESM_PRI_2050_Start=======================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2050Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = uploadArbitraryChargeProposal(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = searchCodeCheckResult(e);
			} else {
				eventResponse = searchCommonUploadArbitraryChargeProposal(e);
			}

		} else if (e.getEventName().equalsIgnoreCase("EsmPri200307Event")) {
			// ================== ESM_PRI_2003_07 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCommodityList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateRouteList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH10)) {
				eventResponse = searchRateListVerticalExcel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH11)) {
				eventResponse = searchRateListHorizontalExcel(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH12)) {
				eventResponse = checkGlineCopyGroupCodeExist(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH15)) {
				eventResponse = searchRateCmdtRoutStyle(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageRateCommodity(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
				eventResponse = manageRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY11)) {
				eventResponse = cancelAllRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY12)) {
				eventResponse = copyGuidelineRate(e);
            } else {
            	eventResponse = initRateComboData(e);
            }
			// ================== ESM_PRI_2003_07 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri204105Event")) {
			// ================== ESM_PRI_2041_05 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCommodityHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateRouteHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateHistoryList(e);
            } else {
            	eventResponse = initRateComboData(e);
            }
			// ================== ESM_PRI_2041_05 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri201907Event")) {
			// ================== ESM_PRI_2019_07 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCommodityInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchRateRouteInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchRateInquiryList(e);
            } else {
            	eventResponse = initRateComboData(e);
            }
			// ================== ESM_PRI_2019_07 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2023Event")) {
			// ================== ESM_PRI_2023 START ==================
			if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptRateCommodityDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelRateCommodityDetail(e);
			}
			// ================== ESM_PRI_2023 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2025Event")) {
			// ================== ESM_PRI_2025 START ==================
			if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptRateRoutePntVia(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelRateRoutePntVia(e);
			}
			// ================== ESM_PRI_2025 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2065Event")) {
			// ================== ESM_PRI_2065 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkRateExcelVertical(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = uploadRateExcelVertical(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = uploadRateExcelVerticalOnline(e);
            } else {
            	eventResponse = initRateExcelVertical(e);
            }
			// ================== ESM_PRI_2065 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2033Event")) {
			// ================== ESM_PRI_2033 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGRICalculationHeaderList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGRICalculationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageGRICalculation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = applyGRICalculation(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelGRICalculation(e);
			}
			// ================== ESM_PRI_2033 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2087Event")) {
			// ================== ESM_PRI_2087 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGRICalculationHeaderHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGRICalculationHistoryList(e);
			}
			// ================== ESM_PRI_2087 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2082Event")) {
			// ================== ESM_PRI_2082 START ==================
			if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptActualCustomer(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelActualCustomer(e);
			}
			// ================== ESM_PRI_2082 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2022Event")) {
			// ================== ESM_PRI_2022 START ==================
			if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptRateCnote(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelRateCnote(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchRateCnoteConversionListCopy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI12)) {
				eventResponse = manageRateCnoteConversionCopy(e);
			} else {
				eventResponse = searchCommonRateCnoteList(e);
			}
			
			// ================== ESM_PRI_2022 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2034Event")) {
			// ================== ESM_PRI_2034 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchRateCheckDuplicate(e);
			}
			// ================== ESM_PRI_2034 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2036Event")) {
			// ================== ESM_PRI_2036 START ==================
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAllRateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptAllRate(e);
			}
			// ================== ESM_PRI_2036 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2024Event")) {
			// ================== ESM_PRI_2024 START ==================
			if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptRateCommodityRnote(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelRateCommodityRnote(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchRateCommodityRnoteConversionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH14)) {
				eventResponse = searchRateCommodityRnoteConversionListCopy(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI12)) {
				eventResponse = manageRateCommodityRnoteConversionCopy(e);
			} else {
				eventResponse = searchCommonCommodityRnoteList(e);
			}
			
			// ================== ESM_PRI_2024 END ==================
		} else if (e.getEventName().equalsIgnoreCase("EsmPri2060Event")) {
			// ================== ESM_PRI_2060 START ==================
			if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {  			//upload excel with backendjob
				eventResponse = uploadRateExcelHorizontalBackEndJob(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	//It gets a status of backendjob to upload excel
				eventResponse = comBakEndJbVOs(e);                            	
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {	//Call BackEndJob to Check SheetData and Get BackEndJob Key
	            eventResponse = checkRateExcelHorizontalBackEndJob(e);        	
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {	//It gets a status of backendjob and Result to Check
				eventResponse = backEndJobChkHorizontalExcelResult(e);
			} else {
            	eventResponse = initRateExcelHorizontal(e);
            }
			// ================== ESM_PRI_2060 END ==================
			
		}

		// ============================ESM_PRI_2010_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchProposalDurationList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageProposalDuration(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptProposalDuration(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelProposalDuration(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchProposalScopeCheckList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchProposalDurationAmendCheckList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchProposalDurationScopeCount(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchProposalDurationAcceptCount(e);
			} else {
				eventResponse = initDurComboData(e);
			}
		}
		// =============================ESM_PRI_2010_end===================================


		// ============================ESM_PRI_2040_start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2040Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = amendProposal(e);
			}
		}
		
		// =============================ESM_PRI_2003_06_Start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri200306Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAffiliateList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = manageAffiliate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {
				eventResponse = acceptAffiliate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {
				eventResponse = cancelAffiliate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY03)) {
				eventResponse = acceptAllAffiliate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY04)) {
				eventResponse = cancelAllAffiliate(e);
			} else{
				eventResponse = initAffilComboData(e);
			}
			// =============================ESM_PRI_2003_06_end===================================
		}

		// ============================ESM_PRI_2041_03_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri204103Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupCommodityHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupCommodityDeatilHistoryList(e);
			} else {
				eventResponse = initAmendSourceStatusCodeList(e);
			}
		}
		
		// ============================ESM_PRI_2041_04_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri204104Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupLocationHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationDetailHistoryList(e);
			} else {
				eventResponse = searchCommonGroupLocationList(e);
			}
		}
		// ============================ESM_PRI_2041_08_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri204108Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSpecialNoteHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSpecialNoteContentHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchNoteConversionHistoryList(e);
			} else {
				eventResponse = searchCommonSpecialNoteHistoryList(e);
			}
		}
		// ============================ESM_PRI_2019_01_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri201901Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchSpecialNoteInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchSpecialNoteContentInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH13)) {
				eventResponse = searchNoteConversionInquiryList(e);
			} else {
				eventResponse = searchCommonSpecialNoteInquiryList(e);
			} 
		}
		// ============================ESM_PRI_2019_02_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri201902Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupLocationInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupLocationDetailInquiryList(e);
			} else {
				eventResponse = searchCommonGroupLocationList(e);
			}
		}
		// ============================ESM_PRI_2019_03_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri201903Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchGroupCommodityInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchGroupCommodityDeatilInquiryList(e);
			} else {
				eventResponse = initAmendSourceStatusCodeList(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmPri2058Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchDEMDETExceptionList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Save
				eventResponse = manageDEMDETException(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // Accept
				eventResponse = acceptDEMDETException(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) { // Accept Cancel
				eventResponse = cancelDEMDETException(e);
			} else {
				eventResponse = initDEMDETComboData(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmPri2047Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRateCargoSepcification(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageRateCargoSepcification(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("EsmPri2075Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchRateCargoSepcificationInquiry(e);
			}
		}
		
        // ============================esm_pri_2041_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri2041Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchAmendmentHistoryMain(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
            	eventResponse = searchAmendmentHistoryList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
            	eventResponse = searchHistoryAmendTermList(e);     
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
            	eventResponse = searchAmendmentHistorySummary(e);               	
            }else {
            	eventResponse = initAmendHistoryInquiry(e);
            }
            // =============================esm_pri_2041_end===================================            
        }    		
        // ============================ESM_PRI_0041_01_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri204101Event")) {
 	        if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
 	        	eventResponse = searchProposalDurationHistoryList(e);
 	        }
        }
         // =============================ESM_PRI_0041_01_end=================================== 
        // ============================ESM_PRI_2041_07_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri204107Event")) {
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	            eventResponse = searchAffiliateHistoryList(e);
	        }
        }
        // =============================ESM_PRI_2041_07_end===================================
        // ============================ESM_PRI_2041_09_Start====================================
        else if (e.getEventName().equalsIgnoreCase("EsmPri204109Event")) {
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
	            eventResponse = searchDEMDETExceptionHistoryList(e);
	        }
        }
        // =============================ESM_PRI_2041_09_end===================================		
		
		// ============================ESM_PRI_2041_06_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri204106Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchArbitraryChargeHistoryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = checkHistoryArbitraryFontStyle(e);
			} else {
				eventResponse = initArbitraryComboData(e);
			}
		}
		// ============================ESM_PRI_2041_06_End=======================================
		
		else if (e.getEventName().equalsIgnoreCase("EsmPri2044Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchProposalCopyList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = copyProposal(e);
            }
            // =============================ESM_PRI_0096_end===================================

        }

        else if (e.getEventName().equalsIgnoreCase("EsmPri2007Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchOrganizationList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageProposalRequestMessage(e);
            }
        }

        else if (e.getEventName().equalsIgnoreCase("EsmPri2049Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchProposalRequestList(e);
            }
        }

        else if (e.getEventName().equalsIgnoreCase("EsmPri2019Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchProposalMainInquiryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchProposalMainInquiry(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchProposalCustomerInfoInquiry(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                log.debug("searchProposalScopeAmendmentSummaryInquiry===================1");
                eventResponse = searchProposalScopeAmendmentSummaryInquiry(e);
            } else {
                eventResponse = initProposalInquiry(e);
            }
		}
		
		// ============================ESM_PRI_2019_04_Start====================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri201904Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchArbitraryChargeInquiryList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = checkArbitraryInquiryFontStyle(e);
			} else {
				eventResponse = initArbitraryComboData(e);
			}
		}
		// ============================ESM_PRI_2019_04_End====================================

        else if (e.getEventName().equalsIgnoreCase("EsmPri2080Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchGuidelineCopyCheck(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = copyScopeGuideline(e);
            } else {
                eventResponse = searchGuidelineCopySvcScpName(e);
            }
        }
		
		// =============================ESM_PRI_2019_06_Start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri201906Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAffiliateInquiryList(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchAffiliateHeader(e);
            }    
			// =============================ESM_PRI_2019_06_end===================================
		}
		
		// =============================ESM_PRI_2084_Start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2084Event")) {
            eventResponse = searchCommonRateNoteList(e);
			// =============================ESM_PRI_2019_06_end===================================
		}
		
		// =============================ESM_PRI_2085_Start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2085Event")) {
            eventResponse = searchCommonRateNoteList(e);
			// =============================ESM_PRI_2019_06_end===================================
		}
		
		// =============================ESM_PRI_2072_Start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2072Event")) {
            eventResponse = searchCommonRateNoteList(e);
			// =============================ESM_PRI_2019_06_end===================================
		}
		
		// =============================ESM_PRI_2073_Start===================================
		else if (e.getEventName().equalsIgnoreCase("EsmPri2073Event")) {
            eventResponse = searchCommonRateNoteList(e);
			// =============================ESM_PRI_2019_06_end===================================
		}
		
		return eventResponse;

	}
	
	/**
	 * ESM_PRI_2003_07 : OPEN<br>
	 * Retrieving Combo Data<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initRateComboData(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CodeUtil cdUtil = CodeUtil.getInstance();
			
			List<RsltCdListVO> ratUtCdList = command.searchPerCodeList(new RsltCdListVO());
			ArrayList<CodeInfo> prcCgoTpCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01701", 0);
			List<RsltCdListVO> currCdList = command.searchCurrencyCodeList(new RsltCdListVO());
			
			ArrayList<CodeInfo> termOrgCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02070", 0);
			ArrayList<CodeInfo> termDestCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02071", 0);
			ArrayList<CodeInfo> transModeCdList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01720", 0);
			
			eventResponse.setCustomData("ratUtCdList", ratUtCdList);
			eventResponse.setCustomData("prcCgoTpCdList", prcCgoTpCdList);
			eventResponse.setCustomData("currCdList", currCdList);
			eventResponse.setCustomData("termOrgCdList", termOrgCdList);
			eventResponse.setCustomData("termDestCdList", termDestCdList);
			eventResponse.setCustomData("transModeCdList", transModeCdList);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2003_07 : Open<br>
     * Retrieving Rate's Commodity Group<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchRateCommodityList (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri200307Event event = (EsmPri200307Event) e;
        RFARateProposalBC command = new RFARateProposalBCImpl();
        try {
            RsltRtCmdtListVO vo = command.searchRateCommodityList(event.getPriRpScpRtCmdtHdrVO());
            String maxBletDpSeq = command.getMaxOldBulletDispSeq(event.getPriRpScpRtCmdtHdrVO());

            eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCmdtDtlListVOS());
            eventResponse.setRsVoList(vo.getRsltActCustListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCnoteListVOS());
            eventResponse.setRsVoList(vo.getRsltCnoteNoteConvListVOS());

            eventResponse.setETCData("max_blet_dp_seq", maxBletDpSeq);
        } catch (EventException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
        }
        return eventResponse;
    }
	
    /**
     * ESM_PRI_2041_05 : Open<br>
     * REtrieving Rate History - Commodity Group
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchRateCommodityHistoryList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri204105Event event = (EsmPri204105Event) e;
        RFARateProposalBC command = new RFARateProposalBCImpl();
        RFAGRICalculationProposalBC cmdGRI = new RFAGRICalculationProposalBCImpl();
        
        try{
        	RsltRtCmdtListVO vo = command.searchRateCommodityHistoryList(event.getPriRpScpRtCmdtHdrVO());
            List<RsltGriCalcGrpListVO> voGRI = cmdGRI.searchGRICalculationHeaderList(event.getPriRpScpGriGrpVO());

            eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCmdtDtlListVOS());
            eventResponse.setRsVoList(vo.getRsltActCustListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCnoteListVOS());
            eventResponse.setRsVoList(vo.getRsltCnoteNoteConvListVOS());

            eventResponse.setETCData("gri_cnt", String.valueOf(voGRI.size()));
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
    /**
     * ESM_PRI_2019_07 : Open<br>
     * Retrieving Rate Inquiry - Commodity Group<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchRateCommodityInquiryList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri201907Event event = (EsmPri201907Event) e;
        RFARateProposalBC command = new RFARateProposalBCImpl();
        RFAGRICalculationProposalBC cmdGRI = new RFAGRICalculationProposalBCImpl();
        
        try{
        	RsltRtCmdtListVO vo = command.searchRateCommodityInquiryList(event.getPriRpScpRtCmdtHdrVO());
            List<RsltGriCalcGrpListVO> voGRI = cmdGRI.searchGRICalculationHeaderList(event.getPriRpScpGriGrpVO());

            eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCmdtDtlListVOS());
            eventResponse.setRsVoList(vo.getRsltActCustListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCnoteListVOS());
            eventResponse.setRsVoList(vo.getRsltCnoteNoteConvListVOS());

            eventResponse.setETCData("gri_cnt", String.valueOf(voGRI.size()));
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

    /**
     * ESM_PRI_2003_07 : Sheet1.Select<br>
     * REtrieving Rate's Route<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchRateRouteList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri200307Event event = (EsmPri200307Event) e;
        RFARateProposalBC command = new RFARateProposalBCImpl();
        try{
            List<RsltRtRoutHdrListVO> vos = command.searchRateRouteList(event.getPriRpScpRtCmdtRoutVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
    /**
     * ESM_PRI_2041_05 : Sheet1.Select<br>
     * Retrieving Rate History - Route List
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchRateRouteHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri204105Event event = (EsmPri204105Event) e;
        RFARateProposalBC command = new RFARateProposalBCImpl();
        try{
            List<RsltRtRoutHdrListVO> vos = command.searchRateRouteHistoryList(event.getPriRpScpRtCmdtRoutVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
    /**
     * ESM_PRI_2019_07 : Sheet1.Select<br>
     * Retrieving Rate Inquiry - Route  list<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchRateRouteInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri201907Event event = (EsmPri201907Event) e;
        RFARateProposalBC command = new RFARateProposalBCImpl();
        try{
            List<RsltRtRoutHdrListVO> vos = command.searchRateRouteInquiryList(event.getPriRpScpRtCmdtRoutVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

    /**
     * ESM_PRI_2003_07 : Sheet2.Select<br>
     * Retrieving Rate  information
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchRateList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri200307Event event = (EsmPri200307Event) e;
        RFARateProposalBC command = new RFARateProposalBCImpl();
        try{
            RsltRtListVO vo = command.searchRateList(event.getPriRpScpRtVO());
            eventResponse.setRsVoList(vo.getRsltRtDtlListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutOrgPntListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutOrgViaListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutDestViaListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutDestPntListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCmdtRnoteListVOS());
            eventResponse.setRsVoList(vo.getRsltRnoteNoteConvListVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
    /**
     * ESM_PRI_2041_05 : Sheet2.Select<br>
     * Retrieving Rate History - Rate  information<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchRateHistoryList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri204105Event event = (EsmPri204105Event) e;
        RFARateProposalBC command = new RFARateProposalBCImpl();
        try{
            RsltRtListVO vo = command.searchRateList(event.getPriRpScpRtVO());

            eventResponse.setRsVoList(vo.getRsltRtDtlListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutOrgPntListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutOrgViaListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutDestViaListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutDestPntListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCmdtRnoteListVOS());
            eventResponse.setRsVoList(vo.getRsltRnoteNoteConvListVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}
	
    /**
     * ESM_PRI_2019_07 : Sheet2.Select<br>
     * Rerieving Rate Inquiry - Rate  information<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchRateInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri201907Event event = (EsmPri201907Event) e;
        RFARateProposalBC command = new RFARateProposalBCImpl();
        try{
            RsltRtListVO vo = command.searchRateInquiryList(event.getPriRpScpRtVO());

            eventResponse.setRsVoList(vo.getRsltRtDtlListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutOrgPntListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutOrgViaListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutDestViaListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutDestPntListVOS());
            eventResponse.setRsVoList(vo.getRsltRtCmdtRnoteListVOS());
            eventResponse.setRsVoList(vo.getRsltRnoteNoteConvListVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

    /**
     * ESM_PRI_2003_07 : Down Excel<br>
     * Retrieving Excel Download(Vertical).<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchRateListVerticalExcel(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri200307Event event = (EsmPri200307Event) e;
        RFARateProposalBC command = new RFARateProposalBCImpl();
        try{
            List<RsltRtListVerticalExcelVO> vos = command.searchRateListVerticalExcel(event.getPriRpScpRtCmdtHdrVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

    /**
     * ESM_PRI_2003_07 : Down Excel<br>
     * Retrieving for Excel Download(Horizontal)<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchRateListHorizontalExcel(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri200307Event event = (EsmPri200307Event) e;
        RFARateProposalBC command = new RFARateProposalBCImpl();
        try{
            List<RsltRtListHorizontalExcelVO> vos = command.searchRateListHorizontalExcel(event.getPriRpScpRtCmdtHdrVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

    /**
     * ESM_PRI_2003_07 : OnSaveEnd<br>
     * Retrieving style information for screen after CUD transaction<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchRateCmdtRoutStyle(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri200307Event event = (EsmPri200307Event) e;
        RFARateProposalBC command = new RFARateProposalBCImpl();
        try{
            RsltRtCmdtRoutListVO vo = command.searchRateCmdtRoutStyle(event.getPriRpScpRtCmdtHdrVO(), event
                    .getPriRpScpRtCmdtRoutVO());

            eventResponse.setRsVoList(vo.getRsltRtCmdtHdrListVOS());
            eventResponse.setRsVoList(vo.getRsltRtRoutHdrListVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

    /**
     * ESM_PRI_2003_07 : Guideline Copy<br>
     * Checking weather Group Location, Group Commodity exists or not before Guideline Copy<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse checkGlineCopyGroupCodeExist(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri200307Event event = (EsmPri200307Event) e;
        RFARateProposalBC command = new RFARateProposalBCImpl();
        try{
            RsltCdListVO vo = command.checkGlineCopyGroupCodeExist(event.getRfaGlineCopyVO());
            List<RsltCdListVO> vos = new ArrayList<RsltCdListVO>();
            vos.add(vo);
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

    /**
     * ESM_PRI_2003_07 : Sheet1.Save<br>
     * Handling multi transaction of Commodity Group information<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse manageRateCommodity(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFANoteConversionProposalBC cmdNoteConv = new RFANoteConversionProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			cmdNoteConv.manageNoteConversionCascadeCommodity(event.getRfaRtPropCmdtVO(), account);
			command.manageRateCommodity(event.getRfaRtPropCmdtVO(), account);
			
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPropNo());
            smryVO.setAmdtSeq(event.getAmdtSeq());
            smryVO.setSvcScpCd(event.getSvcScpCd());
            smryVO.setPropScpTermTpCd("71"); 
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2003_07 : Sheet3.Save<br>
     * handling multi transaction of Route & Rate Data<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse manageRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFANoteConversionProposalBC cmdNoteConv = new RFANoteConversionProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			cmdNoteConv.manageNoteConversionCascadeRoute(event.getRfaRtPropRtVO(), account);
			command.manageRate(event.getRfaRtPropRtVO(), account);
			
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPropNo());
            smryVO.setAmdtSeq(event.getAmdtSeq());
            smryVO.setSvcScpCd(event.getSvcScpCd());
            smryVO.setPropScpTermTpCd("71"); 
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
            
            PriRpScpMnVO scpMnVO = new PriRpScpMnVO();
            scpMnVO.setPropNo(event.getPropNo());
            scpMnVO.setAmdtSeq(event.getAmdtSeq());
            scpMnVO.setSvcScpCd(event.getSvcScpCd());
//            cmdMain.updatePrsCalcFlgOnSaveRt(scpMnVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2003_07 : Accept<br>
     * Accepting Rate Data<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse acceptRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.acceptRate(event.getPriRpScpRtVOS(), account);
			
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriRpScpRtVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriRpScpRtVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriRpScpRtVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd("71"); 
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2003_07 : Accept Cancel<br>
     * Cancelling acception of Rate Data<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse cancelRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.cancelRate(event.getPriRpScpRtVOS(), account);
			
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriRpScpRtVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriRpScpRtVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriRpScpRtVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd("71"); 
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2034 : Open<br>
     * Retrieving duplicated Rate  list瑜�<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchRateCheckDuplicate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2034Event event = (EsmPri2034Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try{
			List<RsltRtCheckDuplicateVO> vos = command.searchRateCheckDuplicate(event.getPriRpScpRtCmdtHdrVO());
			eventResponse.setRsVoList(vos);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

    /**
     * ESM_PRI_2036 : Open<br>
     * retrieving Accept All scree list<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchAllRateList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2036Event event = (EsmPri2036Event) e;
        RFARateProposalBC command = new RFARateProposalBCImpl();
        try{
            List<RsltAllRtListVO> vos = command.searchAllRateList(event.getPriRpScpRtCmdtHdrVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

	/**
	 * ESM_PRI_2036 : Accept<br>
	 * Accepting all items in Rate<br>
	 * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
	 */
	private EventResponse acceptAllRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2036Event event = (EsmPri2036Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.acceptAllRate(event.getPriRpScpRtVO(), account);
			
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriRpScpRtVO().getPropNo());
            smryVO.setAmdtSeq(event.getPriRpScpRtVO().getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriRpScpRtVO().getSvcScpCd());
            smryVO.setPropScpTermTpCd("71"); 
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2003_07 : Accept Cancel<br>
     * Cancelling acception about all items in Rate<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse cancelAllRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.cancelAllRate(event.getPriRpScpRtVO(), account);
			
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriRpScpRtVO().getPropNo());
            smryVO.setAmdtSeq(event.getPriRpScpRtVO().getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriRpScpRtVO().getSvcScpCd());
            smryVO.setPropScpTermTpCd("71"); 
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2003_07 : Guideline Copy<br>
     * Copying Guideline Data<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse copyGuidelineRate(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200307Event event = (EsmPri200307Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.copyGuidelineRate(event.getRfaGlineCopyVO(), account);
			
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(event.getRfaGlineCopyVO().getPropNo());
            smryVO.setAmdtSeq(event.getRfaGlineCopyVO().getAmdtSeq());
            smryVO.setSvcScpCd(event.getRfaGlineCopyVO().getSvcScpCd());
            smryVO.setPropScpTermTpCd("71"); 
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

    /**
     * ESM_PRI_2023 : Accept<br>
     * Accept Commodity Data<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse acceptRateCommodityDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2023Event event = (EsmPri2023Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.acceptRateCommodityDetail(event.getPriRpScpRtCmdtVOS(), account);
			
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriRpScpRtCmdtVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriRpScpRtCmdtVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriRpScpRtCmdtVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd("71"); 
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2023 : Accept Cancel<br>
     * Cancel Commodity Data Accept <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse cancelRateCommodityDetail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2023Event event = (EsmPri2023Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.cancelRateCommodityDetail(event.getPriRpScpRtCmdtVOS(), account);
			
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriRpScpRtCmdtVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriRpScpRtCmdtVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriRpScpRtCmdtVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd("71"); 
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2025 : Accept<br>
     * Accept Route Point Data<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse acceptRateRoutePntVia(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2025Event event = (EsmPri2025Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			if (event.getPriRpScpRtRoutOrgPntVO() != null && event.getPriRpScpRtRoutOrgPntVO().length > 0) {
				command.acceptRateRoutePointDetail(event.getPriRpScpRtRoutOrgPntVO(), account);
				
	            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
	            smryVO.setPropNo(event.getPriRpScpRtRoutOrgPntVO()[0].getPropNo());
	            smryVO.setAmdtSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getAmdtSeq());
	            smryVO.setSvcScpCd(event.getPriRpScpRtRoutOrgPntVO()[0].getSvcScpCd());
	            smryVO.setPropScpTermTpCd("71"); 
	            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutOrgViaVO() != null && event.getPriRpScpRtRoutOrgViaVO().length > 0) {
				command.acceptRateRouteViaDetail(event.getPriRpScpRtRoutOrgViaVO(), account);
				
	            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
	            smryVO.setPropNo(event.getPriRpScpRtRoutOrgViaVO()[0].getPropNo());
	            smryVO.setAmdtSeq(event.getPriRpScpRtRoutOrgViaVO()[0].getAmdtSeq());
	            smryVO.setSvcScpCd(event.getPriRpScpRtRoutOrgViaVO()[0].getSvcScpCd());
	            smryVO.setPropScpTermTpCd("71"); 
	            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutDestViaVO() != null && event.getPriRpScpRtRoutDestViaVO().length > 0) {
				command.acceptRateRouteViaDetail(event.getPriRpScpRtRoutDestViaVO(), account);
				
	            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
	            smryVO.setPropNo(event.getPriRpScpRtRoutDestViaVO()[0].getPropNo());
	            smryVO.setAmdtSeq(event.getPriRpScpRtRoutDestViaVO()[0].getAmdtSeq());
	            smryVO.setSvcScpCd(event.getPriRpScpRtRoutDestViaVO()[0].getSvcScpCd());
	            smryVO.setPropScpTermTpCd("71"); 
	            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutDestPntVO() != null && event.getPriRpScpRtRoutDestPntVO().length > 0) {
				command.acceptRateRoutePointDetail(event.getPriRpScpRtRoutDestPntVO(), account);
				
	            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
	            smryVO.setPropNo(event.getPriRpScpRtRoutDestPntVO()[0].getPropNo());
	            smryVO.setAmdtSeq(event.getPriRpScpRtRoutDestPntVO()[0].getAmdtSeq());
	            smryVO.setSvcScpCd(event.getPriRpScpRtRoutDestPntVO()[0].getSvcScpCd());
	            smryVO.setPropScpTermTpCd("71"); 
	            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2025 : Accept Cancel<br>
     * Cancel accept of Route Point Data.<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse cancelRateRoutePntVia(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2025Event event = (EsmPri2025Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			if (event.getPriRpScpRtRoutOrgPntVO() != null && event.getPriRpScpRtRoutOrgPntVO().length > 0) {
				command.cancelRateRoutePointDetail(event.getPriRpScpRtRoutOrgPntVO(), account);
				
	            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
	            smryVO.setPropNo(event.getPriRpScpRtRoutOrgPntVO()[0].getPropNo());
	            smryVO.setAmdtSeq(event.getPriRpScpRtRoutOrgPntVO()[0].getAmdtSeq());
	            smryVO.setSvcScpCd(event.getPriRpScpRtRoutOrgPntVO()[0].getSvcScpCd());
	            smryVO.setPropScpTermTpCd("71"); 
	            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutOrgViaVO() != null && event.getPriRpScpRtRoutOrgViaVO().length > 0) {
				command.cancelRateRouteViaDetail(event.getPriRpScpRtRoutOrgViaVO(), account);
				
	            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
	            smryVO.setPropNo(event.getPriRpScpRtRoutOrgViaVO()[0].getPropNo());
	            smryVO.setAmdtSeq(event.getPriRpScpRtRoutOrgViaVO()[0].getAmdtSeq());
	            smryVO.setSvcScpCd(event.getPriRpScpRtRoutOrgViaVO()[0].getSvcScpCd());
	            smryVO.setPropScpTermTpCd("71"); 
	            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutDestViaVO() != null && event.getPriRpScpRtRoutDestViaVO().length > 0) {
				command.cancelRateRouteViaDetail(event.getPriRpScpRtRoutDestViaVO(), account);
				
	            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
	            smryVO.setPropNo(event.getPriRpScpRtRoutDestViaVO()[0].getPropNo());
	            smryVO.setAmdtSeq(event.getPriRpScpRtRoutDestViaVO()[0].getAmdtSeq());
	            smryVO.setSvcScpCd(event.getPriRpScpRtRoutDestViaVO()[0].getSvcScpCd());
	            smryVO.setPropScpTermTpCd("71"); 
	            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			if (event.getPriRpScpRtRoutDestPntVO() != null && event.getPriRpScpRtRoutDestPntVO().length > 0) {
				command.cancelRateRoutePointDetail(event.getPriRpScpRtRoutDestPntVO(), account);
				
	            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
	            smryVO.setPropNo(event.getPriRpScpRtRoutDestPntVO()[0].getPropNo());
	            smryVO.setAmdtSeq(event.getPriRpScpRtRoutDestPntVO()[0].getAmdtSeq());
	            smryVO.setSvcScpCd(event.getPriRpScpRtRoutDestPntVO()[0].getSvcScpCd());
	            smryVO.setPropScpTermTpCd("71"); 
	            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2065 : Check<br>
     * Checking wheather loaded excel data is correct or not<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse checkRateExcelVertical(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2065Event event = (EsmPri2065Event) e;
        RFARateProposalBC command = new RFARateProposalBCImpl();
        try{
            List<RsltCdListVO> vos = command.checkRateExcelVertical(event.getPriRpScpRtCmdtHdrVO(), event
                    .getRsltRtListVerticalExcelVOS());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

    /**
     * ESM_PRI_2065 : Check<br>
     * Saving loaded excel data in sheet<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse uploadRateExcelVertical(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2065Event event = (EsmPri2065Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();

		try {
			begin();
			String key = command.uploadRateExcelVertical(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListVerticalExcelVOS(), account);
			eventResponse.setETCData("JOB_KEY", key);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
     * ESM_PRI_2065 : Check<br>
     * Saving loaded excel data in sheet<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse uploadRateExcelVerticalOnline(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2065Event event = (EsmPri2065Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			
			command.uploadRateExcelVerticalOnline(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListVerticalExcelVOS(), account);
			
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriRpScpRtCmdtHdrVO().getPropNo());
            smryVO.setAmdtSeq(event.getPriRpScpRtCmdtHdrVO().getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriRpScpRtCmdtHdrVO().getSvcScpCd());
            smryVO.setPropScpTermTpCd("71"); 
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
            
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2065 : Open<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse initRateExcelVertical(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			comUpldFileVO.setFileUpldNm("RP_Rate_Templet_V.xls");
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("TEMPLATE_KEY", fileKey);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

//    /**
//     * ESM_PRI_2060 : Check<br>
//     * Checking wheather loaded excel data is correct or not<br>
//     *
//     * @param Event e
//     * @return EventResponse
//     * @exception EventException
//     */
//	private EventResponse checkRateExcelHorizontal(Event e) throws EventException {
//        // PDTO(Data Transfer Object including Parameters)
//        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        EsmPri2060Event event = (EsmPri2060Event) e;
//        RFARateProposalBC command = new RFARateProposalBCImpl();
//        try{
//            List<RsltCdListVO> vos = command.checkRateExcelHorizontal(event.getPriRpScpRtCmdtHdrVO(), event
//                    .getRsltRtListHorizontalExcelVOS());
//
//            eventResponse.setRsVoList(vos);
//        }catch(EventException ex){
//            throw ex;
//        }catch(Exception ex){
//            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
//        }
//        return eventResponse;
//	}

//    /**
//     * ESM_PRI_2060 : Save<br>
//     * Saving loaded excel data in sheet.<br>
//     *
//     * @param Event e
//     * @return EventResponse
//     * @exception EventException
//     */
//	private EventResponse uploadRateExcelHorizontal(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsmPri2060Event event = (EsmPri2060Event) e;
//		RFARateProposalBC command = new RFARateProposalBCImpl();
//
//		try {
//			begin();
//			String key = command.uploadRateExcelHorizontal(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelVOS(), account);
//			eventResponse.setETCData("JOB_KEY", key);
//			commit();
//		} catch (EventException ex) {
//			rollback();
//			throw ex;
//        } catch (Exception ex) {
//            rollback();
//            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
//		}
//		return eventResponse;
//	}
	
//    /**
//     * ESM_PRI_2060 : Save<br>
//     * Saving loaded excel data in sheet<br>
//     *
//     * @param Event e
//     * @return EventResponse
//     * @exception EventException
//     */
//	private EventResponse uploadRateExcelHorizontalOnline(Event e) throws EventException {
//		GeneralEventResponse eventResponse = new GeneralEventResponse();
//		EsmPri2060Event event = (EsmPri2060Event) e;
//		RFARateProposalBC command = new RFARateProposalBCImpl();
//		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();
//
//		try {
//			begin();
//			
//			command.uploadRateExcelHorizontalOnline(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelVOS(), account);
//			
//            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
//            smryVO.setPropNo(event.getPriRpScpRtCmdtHdrVO().getPropNo());
//            smryVO.setAmdtSeq(event.getPriRpScpRtCmdtHdrVO().getAmdtSeq());
//            smryVO.setSvcScpCd(event.getPriRpScpRtCmdtHdrVO().getSvcScpCd());
//            smryVO.setPropScpTermTpCd("71"); 
//            cmdMain.manageScopeAmendmentSummary(smryVO, account);
//            
//			commit();
//		} catch (EventException ex) {
//			rollback();
//			throw ex;
//        } catch (Exception ex) {
//            rollback();
//            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
//		}
//		return eventResponse;
//	}
	
	/**
	 * ESM_PRI_2060 : Open<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	private EventResponse initRateExcelHorizontal(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		RsltCdListVO vo = new RsltCdListVO();
        List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
		try {
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			comUpldFileVO.setFileUpldNm("RP_Rate_Templet_H.xls");
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO);
			eventResponse.setCustomData("TEMPLATE_KEY", fileKey);
			
			//CARGO TYPE
            vo.setCd("CD01701");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_PRC_CGO_TP_CD", list);
			
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("PRI00340", new String[] {}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2033 : Open<br>
     * Retrieving GRI Calculation Header list<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchGRICalculationHeaderList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2033Event event = (EsmPri2033Event) e;
        RFAGRICalculationProposalBC command = new RFAGRICalculationProposalBCImpl();
        try{
            List<RsltGriCalcGrpListVO> vos = command.searchGRICalculationHeaderList(event.getPriRpScpGriGrpVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

    /**
     * ESM_PRI_2087 : Open<br>
     * Retrieving GRI Calculation History - Header<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchGRICalculationHeaderHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2087Event event = (EsmPri2087Event) e;
        RFAGRICalculationProposalBC command = new RFAGRICalculationProposalBCImpl();
        try{
            List<RsltGriCalcGrpListVO> vos = command.searchGRICalculationHeaderList(event.getPriRpScpGriGrpVO());
            eventResponse.setRsVoList(vos);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

    /**
     * ESM_PRI_2033 : Sheet1.Select<br>
     * REtrieving GRI Calculation  list<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchGRICalculationList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2033Event event = (EsmPri2033Event) e;
        RFAGRICalculationProposalBC command = new RFAGRICalculationProposalBCImpl();
        try{
            RsltGriCalcListVO vo = command.searchGRICalculationList(event.getPriRpScpGriGrpVO());

            eventResponse.setRsVoList(vo.getRsltGriCalcRtListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcCmdtListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcActCustListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcOrgPntListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcOrgViaListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcDestViaListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcDestPntListVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

    /**
     * ESM_PRI_2087 : Open<br>
     * Retrieving GRI Calculation History - Rate & other information<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchGRICalculationHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2087Event event = (EsmPri2087Event) e;
        RFAGRICalculationProposalBC command = new RFAGRICalculationProposalBCImpl();
        try{
            RsltGriCalcListVO vo = command.searchGRICalculationList(event.getPriRpScpGriGrpVO());

            eventResponse.setRsVoList(vo.getRsltGriCalcRtListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcCmdtListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcActCustListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcOrgPntListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcOrgViaListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcDestViaListVOS());
            eventResponse.setRsVoList(vo.getRsltGriCalcDestPntListVOS());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
	}

    /**
     * ESM_PRI_2033 : Save<br>
     * handling GRI CUD transaction of Calculation Data<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse manageGRICalculation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2033Event event = (EsmPri2033Event) e;
		RFAGRICalculationProposalBC command = new RFAGRICalculationProposalBCImpl();

		try {
			begin();
			command.manageGRICalculation(event.getRfaGriCalcVO(), account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2033 : Apply<br>
     * Applying GRI Calculation Rate Data<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse applyGRICalculation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2033Event event = (EsmPri2033Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAGRICalculationProposalBC griCommand = new RFAGRICalculationProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.applyGRICalculation(event.getPriRpScpGriGrpVO(), account);
			griCommand.manageGRICalculation(event.getRfaGriCalcVO(), account);
			
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriRpScpGriGrpVO().getPropNo());
            smryVO.setAmdtSeq(event.getPriRpScpGriGrpVO().getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriRpScpGriGrpVO().getSvcScpCd());
            smryVO.setPropScpTermTpCd("71"); 
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2033 : Apply Cancel<br>
     * Calcelling applied GRI Calculation<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse cancelGRICalculation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2033Event event = (EsmPri2033Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAGRICalculationProposalBC griCommand = new RFAGRICalculationProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.cancelGRICalculation(event.getPriRpScpGriGrpVO(), account);
			griCommand.manageGRICalculation(event.getRfaGriCalcVO(), account);
			
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriRpScpGriGrpVO().getPropNo());
            smryVO.setAmdtSeq(event.getPriRpScpGriGrpVO().getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriRpScpGriGrpVO().getSvcScpCd());
            smryVO.setPropScpTermTpCd("71"); 
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2082 : Accept<br>
     * Accept Actual Customer Data<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse acceptActualCustomer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2082Event event = (EsmPri2082Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.acceptActualCustomer(event.getPriRpScpRtActCustVOS(), account);
			
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriRpScpRtActCustVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriRpScpRtActCustVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriRpScpRtActCustVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd("71"); 
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2082 : Accept Cancel<br>
     * Cancel Accepted Actual Customer Data<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse cancelActualCustomer(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2082Event event = (EsmPri2082Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.cancelActualCustomer(event.getPriRpScpRtActCustVOS(), account);
			
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriRpScpRtActCustVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriRpScpRtActCustVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriRpScpRtActCustVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd("71"); 
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2022 : Accept<br>
     * Accept Commodity Note Data .<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse acceptRateCnote(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2022Event event = (EsmPri2022Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.acceptRateCnote(event.getPriRpScpRtCnoteVOS(), account);
			
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriRpScpRtCnoteVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriRpScpRtCnoteVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriRpScpRtCnoteVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd("71"); 
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2022 : Accept Cancel<br>
     * Cancel accepted Commodity Note Data<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse cancelRateCnote(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2022Event event = (EsmPri2022Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.cancelRateCnote(event.getPriRpScpRtCnoteVOS(), account);
			
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriRpScpRtCnoteVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriRpScpRtCnoteVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriRpScpRtCnoteVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd("71"); 
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2024 : Accept<br>
     * Accept Route Note Data<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse acceptRateCommodityRnote(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2024Event event = (EsmPri2024Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.acceptRateCommodityRnote(event.getPriRpScpRtCmdtRnoteVOS(), account);
			
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriRpScpRtCmdtRnoteVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriRpScpRtCmdtRnoteVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriRpScpRtCmdtRnoteVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd("71"); 
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

    /**
     * ESM_PRI_2024 : Accept Cancel<br>
     * Cance accepted Route Note Data<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse cancelRateCommodityRnote(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2024Event event = (EsmPri2024Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();

		try {
			begin();
			command.cancelRateCommodityRnote(event.getPriRpScpRtCmdtRnoteVOS(), account);
			
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriRpScpRtCmdtRnoteVOS()[0].getPropNo());
            smryVO.setAmdtSeq(event.getPriRpScpRtCmdtRnoteVOS()[0].getAmdtSeq());
            smryVO.setSvcScpCd(event.getPriRpScpRtCmdtRnoteVOS()[0].getSvcScpCd());
            smryVO.setPropScpTermTpCd("71"); 
            cmdMain.manageScopeAmendmentSummary(smryVO, account);
			
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * ESM_PRI_2003 : Retrieve<br>
	 * retrieving data of Proposal Main<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalMain(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			RsltPropListVO vo = command.searchProposalMain(event.getPriRpHdrVO(), account);
			
			eventResponse.setRsVoList(vo.getRsltPropMnVOs());
			eventResponse.setRsVoList(vo.getRsltPropMnScpListVOs());

			if (vo.getRsltPropMnVOs() != null && vo.getRsltPropMnVOs().size() > 0){
				PRICommonBC command1 = new PRICommonBCImpl();
				RsltCdListVO cdVo = new RsltCdListVO();
				cdVo.setEtc1(vo.getRsltPropMnVOs().get(0).getRespbSlsOfcCd());
				cdVo.setEtc2(vo.getRsltPropMnVOs().get(0).getCtrtCustCntCd());
				cdVo.setEtc3(vo.getRsltPropMnVOs().get(0).getCtrtCustSeq());
				List<RsltCdListVO> list = command1.searchSalesRepListByCustOnly(cdVo);
				eventResponse.setRsVoList(list);
				cdVo.setEtc1(vo.getRsltPropMnVOs().get(0).getPropOfcCd());
				List<RsltCdListVO> list1 = command1.searchSalesRepByOfficeList(cdVo);
				eventResponse.setRsVoList(list1);
				
				SchSaleLeadRfaVO slsVo = new SchSaleLeadRfaVO();
				slsVo.setCustCntCd(vo.getRsltPropMnVOs().get(0).getCtrtCustCntCd());
				slsVo.setCustSeq(vo.getRsltPropMnVOs().get(0).getCtrtCustSeq());
				slsVo.setRespbSrepCd(vo.getRsltPropMnVOs().get(0).getRespbSrepCd());
				slsVo.setPropNo(vo.getRsltPropMnVOs().get(0).getPropNo());
				slsVo.setAmdtSeq(vo.getRsltPropMnVOs().get(0).getAmdtSeq());
				slsVo.setFirstSw("N");

			}
			
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003 : btn_ctrt_cust<br>
	 * Retrieving Customer  information<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalCustomerInfo(Event e) throws EventException {
		PriSpCtrtPtyVO paramVo = new PriSpCtrtPtyVO();
		if (e.getEventName().equalsIgnoreCase("EsmPri2003Event")) {
			EsmPri2003Event event = (EsmPri2003Event) e;
			paramVo = event.getPriSpCtrtPtyVO();
		}

		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<RsltPropCustInfoVO> list = command.searchProposalCustomerInfo(paramVo);
			
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003 : SAVE<br>
	 * Adding ,Modifying,Deleting RFA PROPOSAL,SCOPE<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageProposal(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		RFADurationProposalBC command2 = new RFADurationProposalBCImpl();
		RFAProposalDEMDETBC command4 = new RFAProposalDEMDETBCImpl();		
		RFANoteConversionProposalBC command6 = new RFANoteConversionProposalBCImpl();
//		RFARateProposalBC command7 = new RFARateProposalBCImpl();
		String propNo = "";
		try {
			begin();
//			String saleLeadOri =  event.getSaleLeadOri();
			
            PriRpMnVO[] mnVo = new PriRpMnVO[0];

            mnVo = event.getRfaPropMnVO().getPriRpMnVOs();
			
            //note conv
            PriRpScpMnVO[] scpVo = event.getRfaPropMnVO().getPriRpScpMnVOs();
            command6.manageNoteConversionEffectiveDate(scpVo, account);
            command6.manageNoteConversionExpireDate(scpVo, account);

            command2.manageProposalScopeDurationRemove(event.getRfaPropMnVO(), account);	
            //Surcharge
            command1.manageProposalRemove(event.getRfaPropMnVO(), account);
            
			propNo = command1.manageProposal(event.getRfaPropMnVO(), account);			
			command2.manageProposal(event.getRfaPropMnVO(), account);			
			command4.manageProposal(event.getRfaPropMnVO(), account);	
			
			
			//SUMMARY TABLE UPDATE
            if (mnVo[0].getIbflag().equals("I")){
            	PriRpAmdtSmryVO smryVo = new PriRpAmdtSmryVO();
            	smryVo.setPropNo(propNo);
            	smryVo.setAmdtSeq(mnVo[0].getAmdtSeq());
            	smryVo.setPropTermTpCd("01");
            	command1.manageProposalAmendmentSummary(smryVo, account);
            	smryVo.setPropTermTpCd("08");
            	command1.manageProposalAmendmentSummary(smryVo, account);
            }            
        	PriRpScpAmdtSmryVO scpSmryVO = new PriRpScpAmdtSmryVO();
        	scpSmryVO.setPropNo(mnVo[0].getPropNo());
        	scpSmryVO.setAmdtSeq(mnVo[0].getAmdtSeq());
        	for (int i=0; i < scpVo.length; i++){
        		if (scpVo[i].getIbflag().equals("I")){
            		scpSmryVO.setSvcScpCd(scpVo[i].getSvcScpCd());
            		scpSmryVO.setPropScpTermTpCd("11");
            		command1.manageProposalScopeAmendmentSummary(scpSmryVO, account);
        		}
        	}
			
			
            eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage()); 
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		eventResponse.setETCData("prop_no", propNo);
		return eventResponse;
	}

    /**
     * ESM_PRI_2003_01 : OPEN <br>
     * REtrieving code information when loading SPECIAL NOTE screen<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchCommonSpecialNoteList(Event e) throws EventException {
		//EsmPri200301Event event = (EsmPri200301Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;		
		
        try {        	
        	////////////////////COMMON - START/////////////////////
        	//SOURCE
            vo.setCd("CD02198");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("SRC_INFO_CD", list);

        	//STATUS
            vo.setCd("CD01719");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PRC_PROG_STS_CD", list);
        	
        	
            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);
            
            //CARGO TYPE
            vo.setCd("CD01701");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_PRC_CGO_TP_CD", list);
            
            //CAL.
            vo.setCd("CD01724");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_OP_CD", list);
                        
            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);
            
            //US SVC MODE
            vo.setCd("CD01708");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_HNGR_BAR_TP_CD", list);
            //////////////////////COMMON - END///////////////////////
        	
        	//PER TYPE
        	list = command.searchAllPerCodeList(vo);
        	eventResponse.setCustomData("BKG_RAT_UT_CD", list);
			        	
			//CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);
			
			//CANAL
            vo.setCd("CD02538");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_CNL_TZ_CD", list);
            
            //B/I - PRICING E-SERVICE CONVERSION TYPE CODE
            vo.setCd("CD02582");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ESVC_TP_CD", list);
            
            
/*
			vo.setEtc1("R"); // Agreement type: S->S/C,  R->RFA,  T->TRI
			vo.setEtc2("P"); // CONVERSION TYPE CODE
			list = command.searchNoteConvRuleMapgList(vo);
			eventResponse.setCustomData("RULE_CD", list);
						
            // Scope Charge Code List
			vo.setEtc1(event.getPriRfaNoteConvVO().getSvcScpCd());
            list = command.searchScopeChargeCodeList(vo); 
            eventResponse.setCustomData("CHARGE_CD", list);            
*/            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_PRI_2003_01 : RETRIEVE<br>
	 * Retrieving SPECIAL NOTE<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecialNoteList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<RsltNoteListVO> list = command.searchNoteList(event.getPriRpScpNoteListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : SHEET1.SELECTROW<br>
	 * Retriving content of SPECIAL NOTE<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecialNoteContentList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		
		try {
			List<RsltNoteCtntListVO> list = command.searchSpecialNoteContentList(event.getPriRpScpNoteCtntVO());            
			eventResponse.setRsVoList(list);	        
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2003_01 : SAVE<br>
	 * Retrieving MAX value of DP SEQ about SEQ-1 in content of special note<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoteContentMaxDpSeq(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		
		try {
            String maxDpSeq2 = command.searchNoteContentMaxDpSeq(event.getPriRpScpNoteCtntVO());            
	        eventResponse.setETCData("CONTENT_MAX_DP_SEQ", maxDpSeq2);
	        
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2003_01 : SAVE<br>
	 * Retrieving MAX value of DP SEQ about SEQ-1 in title of special note<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoteMaxDpSeq(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		
		try {
			String maxDpSeq1 = command.searchNoteMaxDpSeq(event.getPriRpScpNoteCtntVO());
	        eventResponse.setETCData("TITLE_MAX_DP_SEQ", maxDpSeq1);
	        
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : SAVE<br>
	 * saving SPECIAL NOTE<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageNote(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteProposalBC command1 = new RFANoteProposalBCImpl();
		RFANoteConversionProposalBC command2 = new RFANoteConversionProposalBCImpl();
		
		try {
			begin();

			command2.manageNoteConversion(event.getNotePropVO(), account);
			command1.manageNote(event.getNotePropVO(), account);

			//////////////////////////////////////////////////////
			//Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getNotePropVO().getPriRpScpNoteListVO().getPropNo());
			smryVO.setAmdtSeq(event.getNotePropVO().getPriRpScpNoteListVO().getAmdtSeq());
			smryVO.setPropScpTermTpCd("32"); 
			smryVO.setSvcScpCd(event.getNotePropVO().getPriRpScpNoteListVO().getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			///////////////////////////////////////////////////////

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : ACCEPT<br>
	 * Accept SPECIAL NOTE<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptNote(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		try {
			begin();
			command.acceptNote(event.getPriRpScpNoteCtntVOS(), account);

			//////////////////////////////////////////////////////
			//Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpNoteCtntVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpNoteCtntVOS()[0].getAmdtSeq());
			smryVO.setPropScpTermTpCd("32"); 
			smryVO.setSvcScpCd(event.getPriRpScpNoteCtntVOS()[0].getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			///////////////////////////////////////////////////////

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00108", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : CANCEL<br>
	 * Cancelling SPECIAL NOTE<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelNote(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		try {
			begin();
			command.cancelNote(event.getPriRpScpNoteCtntVOS(), account);

			//////////////////////////////////////////////////////
			//Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpNoteCtntVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpNoteCtntVOS()[0].getAmdtSeq());
			smryVO.setPropScpTermTpCd("32"); 
			smryVO.setSvcScpCd(event.getPriRpScpNoteCtntVOS()[0].getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			///////////////////////////////////////////////////////

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00109", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : ACCEPT ALL<br>
	 * Accept SPECIAL NOTE all<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptAllNote(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		try {
			begin();
			int result = command.acceptAllNote(event.getPriRpScpNoteCtntVO(), account);

			//////////////////////////////////////////////////////
			//Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpNoteCtntVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpNoteCtntVO().getAmdtSeq());
			smryVO.setPropScpTermTpCd("32"); 
			smryVO.setSvcScpCd(event.getPriRpScpNoteCtntVO().getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			///////////////////////////////////////////////////////

            if(result > 0) {
            	eventResponse.setUserMessage((String) new ErrorHandler("PRI00108",new String[]{}).getUserMessage());
            } else {
            	eventResponse.setUserMessage((String) new ErrorHandler("PRI00301",new String[]{}).getUserMessage());
            }
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : CANCEL<br>
	 * Cancelling SPECIAL NOTE all<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAllNote(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		try {
			begin();
			int result = command.cancelAllNote(event.getPriRpScpNoteCtntVO(), account);

			//////////////////////////////////////////////////////
			//Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpNoteCtntVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpNoteCtntVO().getAmdtSeq());
			smryVO.setPropScpTermTpCd("32"); 
			smryVO.setSvcScpCd(event.getPriRpScpNoteCtntVO().getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			///////////////////////////////////////////////////////

            if(result > 0) {
            	eventResponse.setUserMessage((String) new ErrorHandler("PRI00109",new String[]{}).getUserMessage());
            } else {
            	eventResponse.setUserMessage((String) new ErrorHandler("PRI00301",new String[]{}).getUserMessage());
            }
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : SHEET2.SELECTROW<br>
	 * REtrieving SPECIAL NOTE CONVERSION<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoteConversionList(Event e) throws EventException {
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteConversionProposalBC command = new RFANoteConversionProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<RsltNoteConvVO> list = command.searchNoteConversionList(event.getPriRfaNoteConvVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : COPY<br>
	 * Pasting SPECIAL NOTE CONVERSION<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoteConversionListCopy(Event e) throws EventException {
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteConversionProposalBC command = new RFANoteConversionProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<RsltNoteConvVO> list = command.searchNoteConversionListCopy(event.getPriRfaNoteConvVO(), account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_01 : COPY<br>
	 * SPECIAL NOTE CONVERSION<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageNoteConversionCopy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200301Event event = (EsmPri200301Event) e;
		RFANoteConversionProposalBC command = new RFANoteConversionProposalBCImpl();

		try {
			begin();
			command.manageNoteConversionCopy(event.getPriRfaNoteConvListVOs(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00110", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
     * ESM_PRI_2084,2085, 2072, 2073  : OPEN <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchCommonRateNoteList(Event e) throws EventException {
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;		
		
        try {        	
        	////////////////////COMMON - START/////////////////////
            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);
            
            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);
            
            //BAR TYPE
            vo.setCd("CD01708");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_HNGR_BAR_TP_CD", list);
            
            //CANAL
            vo.setCd("CD02538");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_CNL_TZ_CD", list);
            
            //B/I - PRICING E-SERVICE CONVERSION TYPE CODE
            vo.setCd("CD02582");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ESVC_TP_CD", list);
            
            //////////////////////COMMON - END///////////////////////
        	
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	

    /**
     * ESM_PRI_2022 : OPEN <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchCommonRateCnoteList(Event e) throws EventException {
		EsmPri2022Event event = (EsmPri2022Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        RFARateProposalBC command2 = new RFARateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;		
		
        try {        	
        	////////////////////COMMON - START/////////////////////
            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);
            
            //CARGO TYPE
            vo.setCd("CD01701");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_PRC_CGO_TP_CD", list);
            
            //CAL.
            vo.setCd("CD01724");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_OP_CD", list);
                        
            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);
            
            //BAR TYPE
            vo.setCd("CD01708");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_HNGR_BAR_TP_CD", list);
            //////////////////////COMMON - END///////////////////////
        	
        	//PER TYPE
        	list = command.searchAllPerCodeList(vo);
        	eventResponse.setCustomData("BKG_RAT_UT_CD", list);
			        	
			//CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);
			
			//CANAL
            vo.setCd("CD02538");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_CNL_TZ_CD", list);
            
            //B/I - PRICING E-SERVICE CONVERSION TYPE CODE
            vo.setCd("CD02582");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ESVC_TP_CD", list);

			//NOTE CONVERSION RULE CODE ( CONVERSION TYPE蹂�
 
			vo.setEtc1("R"); // Agreement type: S->S/C,  R->RFA,  T->TRI
			vo.setEtc2("C"); // CONVERSION TYPE CODE
			list = command.searchNoteConvRuleMapgList(vo);
			eventResponse.setCustomData("RULE_CD", list);
						
            // Scope Charge Code List
			vo.setEtc1(event.getPriRfaNoteConvVO().getSvcScpCd());
            list = command.searchScopeChargeCodeList(vo); 
            eventResponse.setCustomData("CHARGE_CD", list);   
            
            //�댁쟾 SEQ��EXP_DT
            PriRpScpMnVO priRpScpMnVO = new PriRpScpMnVO();
            ObjectCloner.build(event.getPriRfaNoteConvVO(), priRpScpMnVO);
            String bExpDt = command2.searchBeforeExpireDate(priRpScpMnVO);
            eventResponse.setCustomData("BEFORE_EXP_DT", bExpDt);
           
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

	/**
	 * ESM_PRI_2022 : COPY<br>
	 * Pasting RateCnote CONVERSION<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCnoteConversionListCopy(Event e) throws EventException {
		EsmPri2022Event event = (EsmPri2022Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
				
		try {
			List<RsltNoteConvVO> list = command.searchNoteConversionListCopy(event.getPriRfaNoteConvVO(), account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * ESM_PRI_2022 : COPY<br>
	 * RateCnote NOTE CONVERSION<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRateCnoteConversionCopy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2022Event event = (EsmPri2022Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();

		try {
			begin();
			command.manageNoteConversionCopy(event.getPriRfaNoteConvListVOs(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00110", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	   /**
     * ESM_PRI_2024 : OPEN <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchCommonCommodityRnoteList(Event e) throws EventException {
		EsmPri2024Event event = (EsmPri2024Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        RFARateProposalBC command2 = new RFARateProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;		
		
        try {        	
        	////////////////////COMMON - START/////////////////////
            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);
            
            //CARGO TYPE
            vo.setCd("CD01701");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_PRC_CGO_TP_CD", list);
            
            //CAL.
            vo.setCd("CD01724");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_OP_CD", list);
                        
            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);
            
            //BAR TYPE
            vo.setCd("CD01708");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_HNGR_BAR_TP_CD", list);
            //////////////////////COMMON - END///////////////////////
        	
        	//PER TYPE
        	list = command.searchAllPerCodeList(vo);
        	eventResponse.setCustomData("BKG_RAT_UT_CD", list);
			        	
			//CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);
			
			//CANAL
            vo.setCd("CD02538");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_CNL_TZ_CD", list);
            
            //B/I - PRICING E-SERVICE CONVERSION TYPE CODE
            vo.setCd("CD02582");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ESVC_TP_CD", list);

			//NOTE CONVERSION RULE CODE ( By CONVERSION TYPE)

			vo.setEtc1("R"); // Agreement type: S->S/C,  R->RFA,  T->TRI
			vo.setEtc2("R"); // CONVERSION TYPE CODE
			list = command.searchNoteConvRuleMapgList(vo);
			eventResponse.setCustomData("RULE_CD", list);
						
            // Scope Charge Code List
			vo.setEtc1(event.getPriRfaNoteConvVO().getSvcScpCd());
            list = command.searchScopeChargeCodeList(vo); 
            eventResponse.setCustomData("CHARGE_CD", list);  
            
            //�댁쟾 SEQ��EXP_DT
            PriRpScpMnVO priRpScpMnVO = new PriRpScpMnVO();
            ObjectCloner.build(event.getPriRfaNoteConvVO(), priRpScpMnVO);
            String bExpDt = command2.searchBeforeExpireDate(priRpScpMnVO);
            eventResponse.setCustomData("BEFORE_EXP_DT", bExpDt);
           
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_PRI_2024 : SHEET2.SELECTROW<br>
	 * Retrieving RateCommodityRnote CONVERSION<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityRnoteConversionList(Event e) throws EventException {
		EsmPri2024Event event = (EsmPri2024Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<RsltNoteConvVO> list = command.searchNoteConversionList(event.getPriRfaNoteConvVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		
		return eventResponse;
	}

	/**
	 * ESM_PRI_2024 : COPY<br>
	 * pasting RateCommodityRnote CONVERSION<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCommodityRnoteConversionListCopy(Event e) throws EventException {
		EsmPri2024Event event = (EsmPri2024Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<RsltNoteConvVO> list = command.searchNoteConversionListCopy(event.getPriRfaNoteConvVO(), account);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2024 : COPY<br>
	 * RateCommodityRnote NOTE CONVERSION<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRateCommodityRnoteConversionCopy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2024Event event = (EsmPri2024Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();

		try {
			begin();
			command.manageNoteConversionCopy(event.getPriRfaNoteConvListVOs(), account);
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00110", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
     * ESM_PRI_200302 : OPEN <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchCommonGroupLocationList(Event e) throws EventException {
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;		
		
        try {        	
        	////////////////////COMMON - START/////////////////////
        	//SOURCE
            vo.setCd("CD02198");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("SRC_INFO_CD", list);

        	//STATUS
            vo.setCd("CD01719");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PRC_PROG_STS_CD", list);
            
        	//ORI/DST
            vo.setCd("CD02166");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("ORG_DEST_TP_CD", list);
            //////////////////////COMMON - END///////////////////////
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

	/**
	 * ESM_PRI_2003_02 : RETRIEVE<br>
	 * Retrieving LOCATION GROUP.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationList(Event e) throws EventException {
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpLocListVO> list = command.searchGroupLocationList(event.getPriRpScpGrpLocVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_02 : SHEET1.SELECTROW<br>
	 * Retrieving LOCATION GROUP DETAIL<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationDetailList(Event e) throws EventException {
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpLocDtlListVO> list = command.searchGroupLocationDetailList(event.getPriRpScpGrpLocDtlVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_02 : DELETE1<br>
	 * Retrieving wheather RATE is used or not.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationRateApplyList(Event e) throws EventException {
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpLocListVO> list = command.searchGroupLocationRateApplyList(event.getPriRpScpGrpLocVOS());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_02 : ACCEPT ALL<br>
	 * All acceptting LOCATION GROUP DETAILbr>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptAllGroupLocation(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		String result = "";

		try {
			begin();
			result = command.acceptAllGroupLocation(event.getPriRpScpGrpLocDtlVO(), account);

			//////////////////////////////////////////////////////
			//Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGrpLocDtlVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGrpLocDtlVO().getAmdtSeq());
			smryVO.setPropScpTermTpCd("13"); 
			smryVO.setSvcScpCd(event.getPriRpScpGrpLocDtlVO().getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			///////////////////////////////////////////////////////

			if (result.equals("OK")) {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00108", new String[] {}).getUserMessage());
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00329", new String[] {}).getUserMessage());
			}
			eventResponse.setETCData("result", result);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_02 : CANCEL<br>
	 * all cancelling LOCATION GROUP DETAIL<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAllGroupLocation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		String result = "";

		try {
			begin();
			result = command.cancelAllGroupLocation(event.getPriRpScpGrpLocDtlVO(), account);

			//////////////////////////////////////////////////////
			//Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGrpLocDtlVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGrpLocDtlVO().getAmdtSeq());
			smryVO.setPropScpTermTpCd("13"); 
			smryVO.setSvcScpCd(event.getPriRpScpGrpLocDtlVO().getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			///////////////////////////////////////////////////////

			if (result.equals("OK")) {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00109", new String[] {}).getUserMessage());
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00330", new String[] {}).getUserMessage());
			}
			eventResponse.setETCData("result", result);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_02 : ACCEPT<br>
	 * accepting LOCATION GROUP DETAIL<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptGroupLocation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		try {
			begin();
			command.acceptGroupLocation(event.getPriRpScpGrpLocDtlVOS(), account);

			//////////////////////////////////////////////////////
			//Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGrpLocDtlVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGrpLocDtlVOS()[0].getAmdtSeq());
			smryVO.setPropScpTermTpCd("13"); 
			smryVO.setSvcScpCd(event.getPriRpScpGrpLocDtlVOS()[0].getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			///////////////////////////////////////////////////////

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00108", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_02 : CANCEL<br>
	 * Cancelling LOCATION GROUP DETAIL<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelGroupLocation(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		try {
			begin();
			command.cancelGroupLocation(event.getPriRpScpGrpLocDtlVOS(), account);

			//////////////////////////////////////////////////////
			//Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGrpLocDtlVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGrpLocDtlVOS()[0].getAmdtSeq());
			smryVO.setPropScpTermTpCd("13"); 
			smryVO.setSvcScpCd(event.getPriRpScpGrpLocDtlVOS()[0].getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			///////////////////////////////////////////////////////

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00109", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_02 : G/L COPY<br>
	 * Copying GUIDELINE��LOCATION GROUP<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse copyGuidelineGroupLocation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		try {
			begin();
			int result = command.copyGuidelineGroupLocation(event.getPriRpScpGrpLocDtlVO(), account);

            //////////////////////////////////////////////////////
            //Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
            smryVO.setPropNo(event.getPriRpScpGrpLocDtlVO().getPropNo());
            smryVO.setAmdtSeq(event.getPriRpScpGrpLocDtlVO().getAmdtSeq());
            smryVO.setPropScpTermTpCd("13"); 
            smryVO.setSvcScpCd(event.getPriRpScpGrpLocDtlVO().getSvcScpCd());
            command3.manageScopeAmendmentSummary(smryVO, account);
            ///////////////////////////////////////////////////////
            
			if (result > 0) {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI01017", new String[] {}).getUserMessage());
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI01016", new String[] {}).getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_02 : SAVE<br>
	 * Saving LOCATION GROUP<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGroupLocation(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		try {
			begin();
			//ORI/DST Validation checking
			String[] checkVal = command.checkGroupLocationCode(event.getRsltGrpLocDtlListVOs());
			
			if(checkVal[0] != null) {
				eventResponse.setETCData("ORI_DST_CHECK", checkVal[0]);
			} else {
				//SAVE
				command.manageGroupLocation(event.getGrpLocPropVO(), account);
				
	            //////////////////////////////////////////////////////
	            //Amendment Summary Update
				RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
	            PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
	            smryVO.setPropNo(event.getGrpLocPropVO().getPriRpScpGrpLocVO().getPropNo());
	            smryVO.setAmdtSeq(event.getGrpLocPropVO().getPriRpScpGrpLocVO().getAmdtSeq());
	            smryVO.setPropScpTermTpCd("13"); 
	            smryVO.setSvcScpCd(event.getGrpLocPropVO().getPriRpScpGrpLocVO().getSvcScpCd());
	            command3.manageScopeAmendmentSummary(smryVO, account);
	            ///////////////////////////////////////////////////////
	            
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2003_02 : SAVE<br>
	 * Checking LOCATION GROUP's ORI/DEST<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse checkOriDestGroupLocationInUse(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200302Event event = (EsmPri200302Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		try {;
			//ORI/DST Validation checking
			String[] checkVal = command.checkGroupLocationCode(event.getRsltGrpLocDtlListVOs());
			
			if(checkVal[0] != null) {
				eventResponse.setETCData("ORI_DST_CHECK", checkVal[0]);
			} else {
				eventResponse.setETCData("ORI_DST_CHECK", "");
			}
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
     * ESM_PRI_2003_03, 2019_03,2041_03 : OPEN<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse initAmendSourceStatusCodeList(Event e) throws EventException {
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();
		
        try {
        	////////////////////COMMON - START/////////////////////
        	//SOURCE
            vo.setCd("CD02198");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("SRC_INFO_CD", list);
            
        	//STATUS
            vo.setCd("CD01719");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PRC_PROG_STS_CD", list);
            //////////////////////COMMON - END///////////////////////
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
    

	/**
	 * ESM_PRI_2003_03 : RETRIEVE<br>
	 * Retrieving COMMODITY GROUP<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri200303Event event = (EsmPri200303Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpCmdtListVO> list = command.searchGroupCommodityList(event.getPriRpScpGrpCmdtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_03 : SHEET1.SELECTROW<br>
	 * retrieving COMMODITY GROUP��DETAIL<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityDeatilList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri200303Event event = (EsmPri200303Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpCmdtDtlListVO> list = command.searchGroupCommodityDetailList(event.getPriRpScpGrpCmdtDtlVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_03 : DELETE1<br>
	 * retrieving datas used in GRI COMMODITY GROUP & GRP COMMODITY GROUP<br>
	 * prohibiting deletion, if data exists in above 2 tables before deletion<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityRateApplyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri200303Event event = (EsmPri200303Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpCmdtListVO> list = command.searchGroupCommodityRateApplyList(event.getPriRpScpGrpCmdtVOS());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_03 : ACCEPT ALL<br>
	 * All acceptting COMMODITY GROUP<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptAllGroupCommodity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200303Event event = (EsmPri200303Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		String result = "";

		try {
			begin();
			result = command.acceptAllGroupCommodity(event.getPriRpScpGrpCmdtDtlVO(), account);

			//////////////////////////////////////////////////////
			//Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGrpCmdtDtlVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGrpCmdtDtlVO().getAmdtSeq());
			smryVO.setPropScpTermTpCd("14"); 
			smryVO.setSvcScpCd(event.getPriRpScpGrpCmdtDtlVO().getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			///////////////////////////////////////////////////////

			if (result.equals("OK")) {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00108", new String[] {}).getUserMessage());
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00329", new String[] {}).getUserMessage());
			}
			eventResponse.setETCData("result", result);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_03 : CANCEL<br>
	 * all cancelling COMMODITY GROUP<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAllGroupCommodity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200303Event event = (EsmPri200303Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		String result = "";

		try {
			begin();
			result = command.cancelAllGroupCommodity(event.getPriRpScpGrpCmdtDtlVO(), account);

			//////////////////////////////////////////////////////
			//Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGrpCmdtDtlVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGrpCmdtDtlVO().getAmdtSeq());
			smryVO.setPropScpTermTpCd("14"); 
			smryVO.setSvcScpCd(event.getPriRpScpGrpCmdtDtlVO().getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			///////////////////////////////////////////////////////

			if (result.equals("OK")) {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00109", new String[] {}).getUserMessage());
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI00330", new String[] {}).getUserMessage());
			}
			eventResponse.setETCData("result", result);
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_03 : ACCEPT<br>
	 * accepting COMMODITY GROUP<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptGroupCommodity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200303Event event = (EsmPri200303Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		try {
			begin();
			command.acceptGroupCommodity(event.getPriRpScpGrpCmdtDtlVOS(), account);

			//////////////////////////////////////////////////////
			//Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGrpCmdtDtlVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGrpCmdtDtlVOS()[0].getAmdtSeq());
			smryVO.setPropScpTermTpCd("14"); 
			smryVO.setSvcScpCd(event.getPriRpScpGrpCmdtDtlVOS()[0].getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			///////////////////////////////////////////////////////

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00108", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_03 : CANCEL<br>
	 * cancelling COMMODITY GROUP<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelGroupCommodity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200303Event event = (EsmPri200303Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		try {
			begin();
			command.cancelGroupCommodity(event.getPriRpScpGrpCmdtDtlVOS(), account);

			//////////////////////////////////////////////////////
			//Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGrpCmdtDtlVOS()[0].getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGrpCmdtDtlVOS()[0].getAmdtSeq());
			smryVO.setPropScpTermTpCd("14"); 
			smryVO.setSvcScpCd(event.getPriRpScpGrpCmdtDtlVOS()[0].getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			///////////////////////////////////////////////////////

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00109", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_03 : G/L COPY<br>
	 * Copying  COMMODITY GROUP of guide line<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse copyGuidelineGroupCommodity(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200303Event event = (EsmPri200303Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		try {
			begin();
			int result = command.copyGuidelineGroupCommodity(event.getPriRpScpGrpCmdtDtlVO(), account);

			//////////////////////////////////////////////////////
			//Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getPriRpScpGrpCmdtDtlVO().getPropNo());
			smryVO.setAmdtSeq(event.getPriRpScpGrpCmdtDtlVO().getAmdtSeq());
			smryVO.setPropScpTermTpCd("14"); 
			smryVO.setSvcScpCd(event.getPriRpScpGrpCmdtDtlVO().getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			///////////////////////////////////////////////////////

			
			if (result > 0) {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI01017", new String[] {}).getUserMessage());
			} else {
				eventResponse.setUserMessage((String) new ErrorHandler("PRI01016", new String[] {}).getUserMessage());
			}
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_03 : SAVE<br>
	 * Saving COMMODITY GROUP<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGroupCommodity(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200303Event event = (EsmPri200303Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		try {
			begin();
			command.manageGroupCommodity(event.getGrpCmdtPropVO(), account);

			//////////////////////////////////////////////////////
			//Amendment Summary Update
			RFAProposalMainBC command3 = new RFAProposalMainBCImpl();
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();
			smryVO.setPropNo(event.getGrpCmdtPropVO().getPriRpScpGrpCmdtVO().getPropNo());
			smryVO.setAmdtSeq(event.getGrpCmdtPropVO().getPriRpScpGrpCmdtVO().getAmdtSeq());
			smryVO.setPropScpTermTpCd("14"); 
			smryVO.setSvcScpCd(event.getGrpCmdtPropVO().getPriRpScpGrpCmdtVO().getSvcScpCd());
			command3.manageScopeAmendmentSummary(smryVO, account);
			///////////////////////////////////////////////////////

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	
	/**
     * ESM_PRI_2050 : OPEN <br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchCommonUploadArbitraryChargeProposal(Event e) throws EventException {
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2050Event event = (EsmPri2050Event) e;
        
        RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;		
		
        try {        	
        	////////////////////COMMON - START/////////////////////
        	//TRANS MODE
            vo.setCd("CD01720");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PRC_TRSP_MOD_CD", list);

        	//TERM CODE
            if(event.getRsltPriRpScpArbKeyVO().getOrgDestTpCd().equals("O")) {
            	 vo.setCd("CD02070");
            } else {
            	 vo.setCd("CD02071");
            }           
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RCV_DE_TERM_CD", list);
        	        	
            //CARGO TYPE
            vo.setCd("CD01701");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PRC_CGO_TP_CD", list);            
            //////////////////////COMMON - END///////////////////////
        	
        	//PER TYPE
        	list = command.searchAllPerCodeList(vo);
        	eventResponse.setCustomData("RAT_UT_CD", list);
			        	
			//CURRENCY
			list = command.searchAllCurrencyCodeList(vo);
			eventResponse.setCustomData("CURR_CD", list);
			
			//ACTUAL CUSTOMER
			vo.setPropNo(event.getRsltPriRpScpArbKeyVO().getPropNo());
			vo.setAmdtSeq(event.getRsltPriRpScpArbKeyVO().getAmdtSeq());
			vo.setSvcScpCd(event.getRsltPriRpScpArbKeyVO().getSvcScpCd());
			vo.setEtc1("");
			vo.setEtc2("");
			list = command.searchRFAActualCustomerList(vo);
			eventResponse.setCustomData("CUST_DEF_CD", list);

			//Excel Template File Key
			ComUpldFileVO comUpldFileVO = new ComUpldFileVO();
			if(event.getRsltPriRpScpArbKeyVO().getOrgDestTpCd().equals("D")) {
				comUpldFileVO.setFileUpldNm("RP_Arb_Templet_D.xls");
			} else {
				comUpldFileVO.setFileUpldNm("RP_Arb_Templet_O.xls");
			}
			String fileKey = command.searchExcelTemplateFileKey(comUpldFileVO); 
			eventResponse.setCustomData("templateKey", fileKey);

        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
	
	/**
	 * ESM_PRI_2050 : SAVE<br>
	 * Uploading excel file<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse uploadArbitraryChargeProposal(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2050Event event = (EsmPri2050Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();
		try {
			begin();
			command.uploadArbitraryChargeProposal(event.getPriRpScpTrspAddChgVOs(), account);
						
			//log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = new PriRpScpAmdtSmryVO();
            priRpScpAmdtSmryVO.setPropNo(event.getPriRpScpTrspAddChgVOs()[0].getPropNo());
            priRpScpAmdtSmryVO.setAmdtSeq(event.getPriRpScpTrspAddChgVOs()[0].getAmdtSeq());
            priRpScpAmdtSmryVO.setSvcScpCd(event.getPriRpScpTrspAddChgVOs()[0].getSvcScpCd());
            if("O".equals(event.getPriRpScpTrspAddChgVOs()[0].getOrgDestTpCd())) {
            	priRpScpAmdtSmryVO.setPropScpTermTpCd("51");
            } else if("D".equals(event.getPriRpScpTrspAddChgVOs()[0].getOrgDestTpCd())) {
            	priRpScpAmdtSmryVO.setPropScpTermTpCd("52");
            }

            command2.manageScopeAmendmentSummary(priRpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
			
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}

	/**
	 * ESM_PRI_2050 : CHECK<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCodeCheckResult(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2050Event event = (EsmPri2050Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltPriRpScpTrspAddChgVO> list = command.searchCodeCheckResult(event.getRsltPriRpScpTrspAddChgVOs());
			eventResponse.setRsVoList(list);
            
			List<RsltPriRpScpTrspAddChgVO> list2 = command.searchCurrentNoteSeqContent(event.getRsltPriRpScpTrspAddChgVOs());
			eventResponse.setRsVoList(list2);
            
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
     * ESM_PRI_2003: Counter Offer<br>
     * Modifying Main's status<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse counterofferProposal(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		String propStsCd = "";
        String userMsg = "";
		try {
			begin();
			PriRpMnVO[] mnVo = event.getRfaPropProgVO().getPriRpMnVOs();
			command.counterofferProposal(event.getRfaPropProgVO(), account);
			if (mnVo[0] != null)
				propStsCd = mnVo[0].getPropStsCd();

			// changing the status of Scope and manin to "returned" when C/Offer 
			if (mnVo[0] != null && propStsCd.equals("R")) {
//				manageReturnStatus(e);				
				int cnt = 0;
				
				List<RsltReturnVO> list = command.searchProposalReturnedList(mnVo[0]);
				if (list != null && list.size() > 0) {
					cnt++;
				}
				String propNo = mnVo[0].getPropNo();
				String amdtSeq = mnVo[0].getAmdtSeq();
				PriRpMnVO priMn = new PriRpMnVO();
				priMn.setPropNo(propNo);
				priMn.setAmdtSeq(amdtSeq);
				if (cnt > 0) {
					priMn.setPropStsCd("R");
				} else {
					priMn.setPropStsCd("Q");
				}
				command.modifyMainStatus(priMn, account);
				//Rate Calc Flag change
				PriRpScpMnVO scpMn = new PriRpScpMnVO();
				scpMn.setPropNo(propNo);
				scpMn.setAmdtSeq(amdtSeq);
				scpMn.setPrsRtCmpbCalcFlg("N");
				command.manageProposalRateCalcFlag(scpMn, account);				
				//PRS_RT_CMPB_CALC_FLG				
			}
			autoAcceptProposal(e);

            if (propStsCd.equals("Q")){
            	userMsg = "Request";
            }else if (propStsCd.equals("R")){
            	userMsg = "C/Offer";
            }
			
            eventResponse.setUserMessage((String) new ErrorHandler("PRI01045", new String[] {userMsg}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
     * ESM_PRI_2003: Request<br>
     * Accept automatically when Request<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private void autoAcceptProposal(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalDEMDETBC command1 = new RFAProposalDEMDETBCImpl();
		RFADurationProposalBC command2 = new RFADurationProposalBCImpl();
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		try {

			PriRpMnVO[] mnVo = event.getRfaPropProgVO().getPriRpMnVOs();
			PriRpScpMnVO[] mnScpVo = event.getRfaPropMnVO().getPriRpScpMnVOs();


			// request ���먮룞 Accept Proposal
			// duration,MQC,DEM/DT
			if (mnVo[0] != null && mnVo[0].getPropStsCd().equals("Q") && mnVo[0].getAmdtSeq().equals("0")) {
				// duration
				PriRpScpDurVO priRpDurVO = new PriRpScpDurVO();
				PriRpScpDurVO priRpScpDurVO = new PriRpScpDurVO();
				ObjectCloner.build(mnVo[0], priRpDurVO);
				priRpDurVO.setSvcScpCd("");
				priRpDurVO.setPrcProgStsCd("A");
				command2.acceptProposalDuration(priRpDurVO, account);


				if (mnScpVo != null) {
					for (int i = 0; i < mnScpVo.length; i++) {
						ObjectCloner.build(mnScpVo[i], priRpScpDurVO);
						priRpScpDurVO.setPrcProgStsCd("A");
						command2.acceptProposalDuration(priRpScpDurVO, account);
					}
				}

				//DEM/DT
				PriRpDmdtVO vo = new PriRpDmdtVO();				
				ObjectCloner.build(mnVo[0], vo);
				
				command1.acceptProposalDEMDETException(vo, account);

				// main
				PriRpAmdtSmryVO amdtVo = new PriRpAmdtSmryVO();
				amdtVo.setPropNo(mnVo[0].getPropNo());
				amdtVo.setAmdtSeq(mnVo[0].getAmdtSeq());
				// duration ,DEM/DT
				command.modifyProposalAutoAcceptAmendmentSummary(amdtVo, account);
				// Scop
				PriRpScpAmdtSmryVO amdtScpVo = new PriRpScpAmdtSmryVO();
				amdtScpVo.setPropNo(mnVo[0].getPropNo());
				amdtScpVo.setAmdtSeq(mnVo[0].getAmdtSeq());
				// duration 
				command.manageProposalScopeAutoAcceptAmendmentSummary(amdtScpVo, account);
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}

	}

	/**
     * ESM_PRI_2003:sheet2_OnSelectCell()<br>
     * Retrieving Terms Summary <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalAmendmentSummary(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<RsltPropAmdtSmryVO> list = command.searchProposalAmendmentSummary(event.getPriRpAmdtSmryVO());			
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

		return eventResponse;
	}

	/**
     * ESM_PRI_2003:sheet2_OnSelectCell<br>
     * Retrieving Scope Terms Summary<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalScopeAmendmentSummary(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<RsltPropScpAmdtSmryVO> list = command.searchProposalScopeAmendmentSummary(event.getPriRpScpAmdtSmryVO());		
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

		return eventResponse;
	}

	/**
     * ESM_PRI_2003:Approve<br>
     * Retrieving wheather terms is accepted or not<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalAcceptCheck(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<PriRpMnVO> list = command.searchProposalAcceptCheck(event.getPriRpMnVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

		return eventResponse;
	}


	/**
     * ESM_PRI_2003:Counter Offer<br>
     * Retrieving wheather all terms is accepted or returned or not<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalCountOfferCheck(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<RsltStatusVO> listCOffer = command.searchCountOfferStatus(event.getPriRpMnVO());
			int cnt = 0;
			if (listCOffer != null && listCOffer.size() > 0) {
				for (int i = 0; i < listCOffer.size(); i++) {
					RsltStatusVO vo = listCOffer.get(i);
					cnt += Integer.parseInt(vo.getCnt());
				}
			}
			RsltStatusVO rVo = new RsltStatusVO();
			rVo.setStatus("cnt");
			rVo.setCnt(String.valueOf(cnt));		
			eventResponse.setRsVo(rVo);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }


		return eventResponse;
	}	

	/**
     * ESM_PRI_2003:Request<br>
     * Retrieving terms without data<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRequestTermsCheck(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<CstRequestCheckVO> list = command.searchRequestTermsCheck(event.getPriRpMnVO());	
        	List<RequestCheckForCalculationVO> listCalc = null ; // command.searchRequestCheckCalculate(event.getPriRpScpMnVO()); 
        	//Handling exception because of not calculated information
        	if( listCalc != null && listCalc.size() > 0 ){
        		StringBuffer strMsg = new StringBuffer();
        		strMsg.append("\n[ ");
        		for(int i = 0 ; i < listCalc.size(); i++ ){
        			if( i != 0 ){
        				strMsg.append(", ");
        			}
       				strMsg.append(listCalc.get(i).getSvcScpCd());
 
        		}
        		strMsg.append(" ]");
        		//throw new EventException(new ErrorHandler("PRI03019",new String[]{strMsg.toString()}).getMessage());
        		CstRequestCheckVO vo = new CstRequestCheckVO();
        		vo.setTerms("CALC_CHK" );
        		vo.setCnt( strMsg.toString());
        		list.add(vo);
        	}
			
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

		return eventResponse;
	}		

	/**
     * ESM_PRI_2003: Calling from Terms<br>     *  
     *  Retrieving the status of scope for modifying the status of scope after modifyng Terms data<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalScopeStatusCheck(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<PriRpScpMnVO> list = command.searchProposalScopeStatusCheck(event.getPriRpScpMnVO());			
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
     * ESM_PRI_2003: delete<br>
     *  Retrieving wheather data in terms exists or not when deleting scope<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalDeleteCheck(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		// rate ori/dest loc group cmdt group standard note,special note L/agent goh //arb,ihc
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		CstPriSpScpDelCntVO vo = new CstPriSpScpDelCntVO();
		int cnt = 0;
		
		try{
			cnt = command.searchProposalScopeDeleteCheck(event.getPriRpScpMnVO());
			vo.setDelcnt(String.valueOf(cnt));
			eventResponse.setRsVo(vo);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}

	/**
     * ESM_PRI_2003: Approve<br>
     * Modifying the status of main to "approved"<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse approveProposal(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		String rfaNo = "";
		try {
			begin();
			rfaNo = command.approveProposal(event.getRfaPropProgVO(), account);			
            PriRpMnVO[] mnVo = new PriRpMnVO[0];
            mnVo = event.getRfaPropProgVO().getPriRpMnVOs();

            eventResponse.setUserMessage((String) new ErrorHandler("PRI01045", new String[] {"Approve"}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}

		eventResponse.setETCData("rfa_no", rfaNo);
		return eventResponse;
	}

    /**
     * ESM_PRI_2003: Cancel<br>
     * Rollbacking after cancelling the status value<br>.
     * Deleting all datas with Amd seq no in case cancelling Init status<br>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse cancelProposal(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2003Event event = (EsmPri2003Event) e;
        
        RFAProposalMainBC command = new RFAProposalMainBCImpl();
        RFADurationProposalBC command2 = new RFADurationProposalBCImpl();        
        RFANoteProposalBC command3 = new RFANoteProposalBCImpl();
        RFAGroupCommodityProposalBC command5 = new RFAGroupCommodityProposalBCImpl();
        RFARateProposalBC command7 = new RFARateProposalBCImpl();
        RFAGroupLocationProposalBC command8 = new RFAGroupLocationProposalBCImpl();
        RFATransportationAdditionalChargeProposalBC command10 = new RFATransportationAdditionalChargeProposalBCImpl();
        RFAAffiliateProposalBC command11 = new RFAAffiliateProposalBCImpl();
        RFAProposalDEMDETBC command15 = new RFAProposalDEMDETBCImpl();         
        RFAGRICalculationProposalBC command17 = new RFAGRICalculationProposalBCImpl();
        RFANoteConversionProposalBC command18 = new RFANoteConversionProposalBCImpl();
//        RFAQuotationMainBC command19 = new RFAQuotationMainBCImpl();

        try {
            begin();
            PriRpMnVO[] mnVo = event.getRfaPropProgVO().getPriRpMnVOs();
            PriRpScpMnVO[] mnScpVo = event.getRfaPropMnVO().getPriRpScpMnVOs();
            PriRpHdrVO hdrVo = event.getPriRpHdrVO();
            
            String stsCd = mnVo[0].getPropStsCd();
            log.debug("stsCd======================="+stsCd);
            log.debug("amdtseq======================="+mnVo[0].getAmdtSeq());
            if (!stsCd.equals("D")){
                command.cancelProposal(event.getRfaPropProgVO(), account); //Modifying main status
            }             
        
            if (stsCd.equals("I")){
                PriRpAproRqstRefVO priRpAproRqstRefVO = new PriRpAproRqstRefVO();
                if (mnVo[0] != null){
                    command11.manageProposalRequestCancel(mnVo[0], account);//affiliate
                    command2.manageProposalRequestCancel(mnVo[0], account);//duration 
                    command15.manageProposalRequestCancel(mnVo[0], account);//free time
                    
                    //updating pri_sp_amdt_smry acpt_flg to "N"
                    PriRpAmdtSmryVO vo = new PriRpAmdtSmryVO();
                    ObjectCloner.build(mnVo[0], vo);
                    command.manageProposalRequestCancelAmendmentSummary(vo, account);//Main Terms
                    
                    //Updating pri_sp_scp_amdt_smry acpt_flg瑜�N�쇰줈 update
                    PriRpScpAmdtSmryVO scpVo = new PriRpScpAmdtSmryVO();
                    ObjectCloner.build(mnVo[0], scpVo);
                    command.manageProposalScopeRequestCancelAmendmentSummary(scpVo, account);
                    //scope main's status change
                    PriRpScpMnVO scpMnVo = new PriRpScpMnVO();
                    ObjectCloner.build(mnVo[0], scpMnVo);
                    command.modifyAllScopeStatus(scpMnVo, account);

                    // Setting a value for Proposal Request  information's status changing
                    priRpAproRqstRefVO.setPropNo(mnVo[0].getPropNo());
                    priRpAproRqstRefVO.setAmdtSeq(mnVo[0].getAmdtSeq());
                    priRpAproRqstRefVO.setPrcAproRqstStsCd("C");
                }   

                command5.manageProposalRequestCancel(mnScpVo, account);//commodity
                command8.manageProposalRequestCancel(mnScpVo, account);//location 
                command3.manageProposalRequestCancel(mnScpVo, account);//note
                command7.manageProposalRequestCancel(mnScpVo, account);//rate
                command10.manageProposalRequestCancel(mnScpVo, account);//ihc,arb 
                command2.manageProposalRequestCancelScope(mnScpVo, account);//duration

                // Modifying Proposal Request  information's status to "Cancel"
                command.modifyProposalRequestStatus(priRpAproRqstRefVO, account);

                
            }else if(stsCd.equals("Q")){//Approve Cancel
            	
            	//MAIN,SCOPE MAIN EXP_DT Rollback
            	command.manageProposalApproveCancel(mnVo[0], account);//
            	
                log.debug("request approve cancel==================="+mnVo[0].getAmdtSeq());
                log.debug("request approve cancel==================="+mnScpVo[0].getAmdtSeq());
    			//Rate Calc Flag change
    			PriRpScpMnVO scpMn = new PriRpScpMnVO();
    			scpMn.setPropNo(mnVo[0].getPropNo());
    			scpMn.setAmdtSeq(mnVo[0].getAmdtSeq());
    			scpMn.setPrsRtCmpbCalcFlg("Y");
    			command.manageProposalRateCalcFlag(scpMn, account);
            	  
            }else if (stsCd.equals("D")){// Deleting all of Init Cancel Data
                
                // Quotation Main
//                PriRqMnVO priRqMnVO = new PriRqMnVO();
//                priRqMnVO.setPropNo(mnVo[0].getPropNo());
//                command19.modifyRFAQuotationMainPropNoDel(priRqMnVO, account);    // Quotation Main PropNo reset
                command2.removeProposal(mnVo[0], account);//duration main
                command11.manageProposal(mnVo[0], account); //affiliate
                command15.removeProposal(mnVo[0], account); //FREE TIME
                command18.manageProposal(mnVo[0], account);//conversion  
                command.removeProposalProgress(mnVo[0], account);//Progress
                command.removeProposalAmdtSmry(mnVo[0], account);//amdt smry
                command17.manageProposal(mnVo[0], account);//GRI

                if (mnScpVo != null){   
                    for (int i = 0; i < mnScpVo.length; i++){
                        command2.removeProposalScope(mnScpVo[i], account);//duration scope          
                        command3.manageProposal(mnScpVo[i], account);//s Note                   
                        command5.manageProposal(mnScpVo[i], account);//group Commodity                                 
                        command7.removeProposalMain(mnScpVo[i]);//rate                    
                        command8.removeProposal(mnScpVo[i],account);//group location        
                        command10.manageProposal(mnScpVo[i], account);//arb/ihc            
                        command.removeProposalScopeProgress(mnScpVo[i], account);//progress         
                        command.removeProposalScopeAmdtSmry(mnScpVo[i], account);//amdt_smry
                        command.removeProposalScopeMain(mnScpVo[i], account);
                    }
                }  
                command.removeProposalforContract(hdrVo, mnVo[0], account); //proposal main
            }
            eventResponse.setUserMessage((String) new ErrorHandler("PRI01047", new String[] {}).getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
        return eventResponse;
    }

	/**
     * ESM_PRI_2003:Calling from Terms<br>
     * Modifying Amendment summary if Terms Data is modified<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageProposalAmendmentSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		int result = 0;
		try {
			begin();
			command.manageProposalAmendmentSummary(event.getPriRpAmdtSmryVO(), account);
			PriRpMnVO vo = new PriRpMnVO();
			ObjectCloner.build(event.getPriRpAmdtSmryVO(), vo);
			result = command.changeAutoRequestMainStatus(vo, account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}

		eventResponse.setETCData("upd_cnt", String.valueOf(result));
		return eventResponse;
	}	

	/**
     * ESM_PRI_2003:Calling from Scope Terms<br>
     * Modifying AmendmentScopeSummary automatically if Scope Terms Data is modified.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageProposalScopeAmendmentSummary(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		int result = 0;
		try {
			begin();
			command.manageProposalScopeAmendmentSummary(event.getPriRpScpAmdtSmryVO(), account);			// 
			// Changed Scope main status to "Accept" after checking if all terms is accepted
			PriRpScpMnVO scpVo = new PriRpScpMnVO();
			ObjectCloner.build(event.getPriRpScpAmdtSmryVO(), scpVo);
			int cnt = command.searchProposalScopeAcceptCheck(scpVo);
			if (cnt == 0) {// scope status ALL accept
				PriRpScpMnVO[] priRpScpMnVO = new PriRpScpMnVO[1];
				priRpScpMnVO[0] = new PriRpScpMnVO();
				ObjectCloner.build(scpVo, priRpScpMnVO[0]);
				priRpScpMnVO[0].setPropScpStsCd("A");// changing to Accept
				priRpScpMnVO[0].setIbflag("U");
				command.modifyScopeStatus(priRpScpMnVO, account);
			} else {
				command.changeAutoScopeReturnStatus(scpVo, account);
			}
			PriRpMnVO vo = new PriRpMnVO();
			ObjectCloner.build(event.getPriRpScpAmdtSmryVO(), vo);
			result = command.changeAutoRequestMainStatus(vo, account);
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}

		eventResponse.setETCData("upd_cnt", String.valueOf(result));
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003 : OPEN<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initMainComboData(Event e) throws EventException {
		PRICommonBC command = new PRICommonBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RsltCdListVO> scopeList = command.searchServiceScopeCodeList(new RsltCdListVO());
			eventResponse.setCustomData("scopeList", scopeList);
			
			CodeUtil cdUtil = CodeUtil.getInstance(); 

			ArrayList<CodeInfo> lodUtList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD00897",0);
			eventResponse.setCustomData("lodUtList", lodUtList);				
			ArrayList<CodeInfo> scpStsList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01719",0);
			eventResponse.setCustomData("scpStsList", scpStsList);				
			ArrayList<CodeInfo> dmdtList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01704",0);
			eventResponse.setCustomData("dmdtList", dmdtList);	
			//2015.07.23 ADD - Contract Type (CD30038)
			ArrayList<CodeInfo> ctrtDurTpList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD30038",0);
            eventResponse.setCustomData("ctrtDurTpList", ctrtDurTpList);
			
			//2014.10.13 tariff start --------
			PriParaCdDtlVO sPriParaCdDtlVO1 = new PriParaCdDtlVO();
			sPriParaCdDtlVO1.setHrdCdgId("PRICD0001");
			List<PriParaCdDtlVO> tariffBasicCustCdList = command.searchPriParaCdDtl(sPriParaCdDtlVO1);
			eventResponse.setCustomData("tariffBasicCustCd", tariffBasicCustCdList);
			
			ComUserVO sComUserVO = new ComUserVO();
			sComUserVO.setUsrId(e.getSignOnUserAccount().getUsr_id());
			String strIsRole = command.checkPriUserRole(sComUserVO);
			eventResponse.setETCData("isRole", strIsRole);
			//2014.10.13 tariff end --------
			
		}catch(EventException ex){
			throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	} 	
	
 	

	// ===============================ESM_PRI_2010_start===========================================

	/**
     * ESM_PRI_2010:Retrieve<br>
	 * Retrieving Main,Scope Duration according to retrieving condition<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalDurationList(Event e) throws EventException {
		EsmPri2010Event event = (EsmPri2010Event) e;
		RFADurationProposalBC command = new RFADurationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			GrpDurVO grpDurVO = command.searchProposalDurationList(event.getCstAuthorityVO());
			List<RsltPriRpDurVO> list = grpDurVO.getRsltPriRpDurVOS();		
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}

	

	/**
	 * ESM_PRI_2010 : Save<br>
	 * adding/modifying/deleting Main,Scope Duration.<br>
	 * Modifying together if there is conversion with same expire data when duration is modified
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageProposalDuration(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2010Event event = (EsmPri2010Event) e;
		RFADurationProposalBC command = new RFADurationProposalBCImpl();
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		RFANoteConversionProposalBC command2 = new RFANoteConversionProposalBCImpl();
		String saveScp = "";
		try {
			begin();
			command.manageProposalDuration(event.getCstPriRpScpDurVOs(), account);
			
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
            priRpAmdtSmryVO.setPropNo(event.getCstPriRpScpDurVOs()[0].getPropNo());
            priRpAmdtSmryVO.setAmdtSeq(event.getCstPriRpScpDurVOs()[0].getAmdtSeq());
            priRpAmdtSmryVO.setPropTermTpCd("01"); 
        	command1.manageAmendmentSummary(priRpAmdtSmryVO, account);
        	log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
			
			
			CstPriRpScpDurVO[] cstVo = event.getCstPriRpScpDurVOs();
			saveScp = cstVo[0].getScpSave();
			// main update
			PriRpMnVO mnVo = new PriRpMnVO();
			mnVo.setPropNo(cstVo[0].getPropNo());
			mnVo.setAmdtSeq(cstVo[0].getAmdtSeq());
			mnVo.setExpDt(cstVo[0].getCtrtExpDt());

			if (cstVo[0].getSvcScpCd().equals("")) {
				//command1.manageProposalMainExpiry(mnVo, account);
				if (saveScp.equals("true")) {
					List<PriRpScpDurVO> list = command.searchProposalScope(cstVo[0]);
					if (list != null && list.size() > 0) {
	            		PriRpScpMnVO[] scpVo = new PriRpScpMnVO[list.size()];
						for (int i = 0; i < list.size(); i++) {
							PriRpScpAmdtSmryVO vo = new PriRpScpAmdtSmryVO();
							ObjectCloner.build(cstVo[0], vo);
							vo.setSvcScpCd(list.get(i).getSvcScpCd());
							vo.setPropScpTermTpCd("11");
							command1.manageProposalScopeAmendmentSummary(vo, account);

	                		scpVo[i] = new PriRpScpMnVO();
	                		scpVo[i].setPropNo(cstVo[0].getPropNo());
	                		scpVo[i].setAmdtSeq(cstVo[0].getAmdtSeq());
	                		scpVo[i].setSvcScpCd(list.get(i).getSvcScpCd());
	                		scpVo[i].setExpDt(mnVo.getExpDt());
	                		scpVo[i].setIbflag("U");
						}
	            		command2.manageNoteConversionExpireDate(scpVo, account);
					}
				}
				command1.manageProposalMainExpiry(mnVo, account);
			}else{
	            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
                PriRpScpAmdtSmryVO scpSmryVo = new PriRpScpAmdtSmryVO();
                scpSmryVo.setPropNo(event.getCstPriRpScpDurVOs()[0].getPropNo());                
                scpSmryVo.setAmdtSeq(event.getCstPriRpScpDurVOs()[0].getAmdtSeq());
                scpSmryVo.setSvcScpCd(event.getCstPriRpScpDurVOs()[0].getSvcScpCd());
                scpSmryVo.setPropScpTermTpCd("11");
                command1.manageProposalScopeAmendmentSummary(scpSmryVo, account);
	        	log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
			}
			
	        //note conv            
	        if (cstVo != null && cstVo.length > 0){
	        	PriRpScpMnVO[] scpVo = new PriRpScpMnVO[cstVo.length];
	        	for (int i = 0; i < cstVo.length;i++){
	        		scpVo[i] = new PriRpScpMnVO();
	        		scpVo[i].setPropNo(cstVo[i].getPropNo());
	        		scpVo[i].setAmdtSeq(cstVo[i].getAmdtSeq());
	        		scpVo[i].setSvcScpCd(cstVo[i].getSvcScpCd());
	        		scpVo[i].setExpDt(cstVo[i].getCtrtExpDt());
	        		scpVo[i].setIbflag("U");
	        	}
	            command2.manageNoteConversionExpireDate(scpVo, account);   	
	        }
			
			if (saveScp.equals("true")) {// scope main upate//
				command1.manageProposalScopeMainExpiry(mnVo, account);
			}
			if (saveScp.equals("expchange")) {// scope main upate//Scope change
				PriRpScpMnVO vo = new PriRpScpMnVO();
				ObjectCloner.build(cstVo[0], vo);
				vo.setExpDt(cstVo[0].getCtrtExpDt());
				command1.changeProposalScopeMainExpiry(vo, account);
			}

			eventResponse.setUserMessage((String) new ErrorHandler("PRI00101", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * ESM_PRI_2010 : Accept<br>
	 * Accept requeested data<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptProposalDuration(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2010Event event = (EsmPri2010Event) e;
		RFADurationProposalBC command = new RFADurationProposalBCImpl();
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		try {
			begin();
			
			String scpAccept = event.getCstScpDurVO().getScpAccept();
			CstScpDurVO cstVo = event.getCstScpDurVO();			
			PriRpScpDurVO scpVo = new PriRpScpDurVO();			
			ObjectCloner.build(cstVo, scpVo);			
			command.acceptProposalDuration(scpVo, account);
            if (event.getCstScpDurVO().getSvcScpCd().equals("")){
                log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
                PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
                priRpAmdtSmryVO.setPropNo(event.getCstScpDurVO().getPropNo());
                priRpAmdtSmryVO.setAmdtSeq(event.getCstScpDurVO().getAmdtSeq());
                priRpAmdtSmryVO.setPropTermTpCd("01"); 
            	command1.manageAmendmentSummary(priRpAmdtSmryVO, account);
            	log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            }else{
                log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
                PriRpScpAmdtSmryVO scpAmdtSmryVO = new PriRpScpAmdtSmryVO();
                scpAmdtSmryVO.setPropNo(event.getCstScpDurVO().getPropNo());
                scpAmdtSmryVO.setAmdtSeq(event.getCstScpDurVO().getAmdtSeq());
                scpAmdtSmryVO.setSvcScpCd(event.getCstScpDurVO().getSvcScpCd());
                scpAmdtSmryVO.setPropScpTermTpCd("11"); 
            	command1.manageScopeAmendmentSummary(scpAmdtSmryVO, account);
            	log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            }
			
			if (scpAccept.equals("Y")){

            	List<RsltCdListVO> listScope = command.searchProposalDurationAcceptList(scpVo);				
				command.acceptAutoProposalScopeDuration(scpVo, account);				
            	if (listScope != null && listScope.size() > 0){
        			PriRpScpAmdtSmryVO vo = new PriRpScpAmdtSmryVO();
        			vo.setPropNo(scpVo.getPropNo());
        			vo.setAmdtSeq(scpVo.getAmdtSeq());
        			vo.setPropScpTermTpCd("11");
            		for (int i = 0; i < listScope.size(); i++){            			
            			RsltCdListVO cdVo = listScope.get(i);
            			vo.setSvcScpCd(cdVo.getCd());
            			command1.manageScopeAmendmentSummary(vo, account);
            		}
            	}
				
			}
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00108", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2010 : Cancel<br>
	 * Cancelling Accepted Data<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelProposalDuration(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2010Event event = (EsmPri2010Event) e;
		RFADurationProposalBC command = new RFADurationProposalBCImpl();
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		try {
			begin();
			command.cancelProposalDuration(event.getPriRpScpDurVO(), account);
            if (event.getPriRpScpDurVO().getSvcScpCd().equals("")){
                log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
                PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
                priRpAmdtSmryVO.setPropNo(event.getPriRpScpDurVO().getPropNo());
                priRpAmdtSmryVO.setAmdtSeq(event.getPriRpScpDurVO().getAmdtSeq());
                priRpAmdtSmryVO.setPropTermTpCd("01"); 
            	command1.manageAmendmentSummary(priRpAmdtSmryVO, account);
            	log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            }else{
                log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
                PriRpScpAmdtSmryVO scpAmdtSmryVO = new PriRpScpAmdtSmryVO();
                scpAmdtSmryVO.setPropNo(event.getPriRpScpDurVO().getPropNo());
                scpAmdtSmryVO.setAmdtSeq(event.getPriRpScpDurVO().getAmdtSeq());
                scpAmdtSmryVO.setSvcScpCd(event.getPriRpScpDurVO().getSvcScpCd());
                scpAmdtSmryVO.setPropScpTermTpCd("11"); 
            	command1.manageScopeAmendmentSummary(scpAmdtSmryVO, account);
            	log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            }
			eventResponse.setUserMessage((String) new ErrorHandler("PRI00109", new String[] {}).getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("PRI00201").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2010 : Save<br>
	 * retrieving a period of Scope duration when saving main duration<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalScopeCheckList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri2010Event event = (EsmPri2010Event) e;
		RFADurationProposalBC command = new RFADurationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<CstPriRpDurVO> list = command.searchProposalScopeCheckList(event.getPriRpScpDurVO());			
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

		return eventResponse;
	}		

	/**
	 * ESM_PRI_2010 : Save<br>
	 * Retrieving wheather Amended data of scope duration exists or not when amending Main Duration<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalDurationAmendCheckList(Event e) throws EventException {
		EsmPri2010Event event = (EsmPri2010Event) e;
		RFADurationProposalBC command = new RFADurationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<PriRpScpDurVO> list = command.searchProposalDurationAmendCheckList(event.getPriRpScpDurVO());			
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

		return eventResponse;
	}

	/**
	 * ESM_PRI_2010 : Save<br>
	 * Retreiving wheater Main Duration <Scope Duration<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalDurationScopeCount(Event e) throws EventException {
		EsmPri2010Event event = (EsmPri2010Event) e;
		RFADurationProposalBC command = new RFADurationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<CstPriRpScpDurCntVO> list = command.searchProposalDurationScopeCount(event.getPriRpScpDurVO());			
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_04 : Search <br>
	 * Retrieving Arbitrary List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200304Event event = (EsmPri200304Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		
		try {
			List<RsltArbChgListVO> list = command.searchArbitraryChargeList(event.getPriRpScpTrspAddChgVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}	
		return eventResponse;
	}

	/**
	 * ESM_PRI_200304 : Guideline Copy <br>
	 * Modifiyng Arbitrary<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageArbitraryCharge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200304Event event = (EsmPri200304Event) e;
		RFATransportationAdditionalChargeProposalBC command1 = new RFATransportationAdditionalChargeProposalBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();
		
		try {
			begin();
			command1.manageArbitraryCharge(event.getPriRpScpTrspAddChgVOS(), account);
			
			//log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = new PriRpScpAmdtSmryVO();
            priRpScpAmdtSmryVO.setPropNo(event.getPriRpScpTrspAddChgVOS()[0].getPropNo());
            priRpScpAmdtSmryVO.setAmdtSeq(event.getPriRpScpTrspAddChgVOS()[0].getAmdtSeq());
            priRpScpAmdtSmryVO.setSvcScpCd(event.getPriRpScpTrspAddChgVOS()[0].getSvcScpCd());
            if("O".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
            	priRpScpAmdtSmryVO.setPropScpTermTpCd("51");
            } else if("D".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
            	priRpScpAmdtSmryVO.setPropScpTermTpCd("52");
            }

            command2.manageScopeAmendmentSummary(priRpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            
			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
     * ESM_PRI_200304 : Guideline Copy <br>
     * checking wheater Guideline to be copied exists and group location is valid when copying Arbitrary Guideline <br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse checkGuidelineCopyArbitraryChargeExist(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri200304Event event = (EsmPri200304Event) e;
        RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();

       	boolean existGline = true;
		boolean existGlineGrpLoc = true; 
				
		try{
			existGline = command.checkGuidelineArbitraryChargeExist(event.getCstPriRpScpTrspAddChgVO());
			existGlineGrpLoc = command.checkGuidelineArbitraryChargeGroupLocationExist(event.getCstPriRpScpTrspAddChgVO());
			 
			//No guideline to be copied
			if(existGline == false) {
				eventResponse.setUserMessage((String)new ErrorHandler("PRI01040", new String[]{}).getUserMessage());
				eventResponse.setETCData("FLAG","N");
			} 
			//Not registered guideline's group location 
			else if(existGlineGrpLoc == false) {
				eventResponse.setUserMessage((String)new ErrorHandler("PRI01095", new String[]{}).getUserMessage());
				eventResponse.setETCData("FLAG","N");
			} 
			//Excuting guideline copy
			else {
				eventResponse.setETCData("FLAG","Y");
			}
	        return eventResponse;
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
    }

	/**
     * ESM_PRI_200304 : Guideline Copy <br>
	 * Copying Arbitrary Cuideline<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse copyGuidelineArbitraryCharge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200304Event event = (EsmPri200304Event) e;
		RFATransportationAdditionalChargeProposalBC command1 = new RFATransportationAdditionalChargeProposalBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();
		
		try {
			begin();
			command1.copyGuidelineArbitraryCharge(event.getCstPriRpScpTrspAddChgVO(), account);
			
			//log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = new PriRpScpAmdtSmryVO();
            priRpScpAmdtSmryVO.setPropNo(event.getCstPriRpScpTrspAddChgVO().getPropNo());
            priRpScpAmdtSmryVO.setAmdtSeq(event.getCstPriRpScpTrspAddChgVO().getAmdtSeq());
            priRpScpAmdtSmryVO.setSvcScpCd(event.getCstPriRpScpTrspAddChgVO().getSvcScpCd());
            if("O".equals(event.getCstPriRpScpTrspAddChgVO().getOrgDestTpCd())) {
            	priRpScpAmdtSmryVO.setPropScpTermTpCd("51");
            } else if("D".equals(event.getCstPriRpScpTrspAddChgVO().getOrgDestTpCd())) {
            	priRpScpAmdtSmryVO.setPropScpTermTpCd("52");
            }

            command2.manageScopeAmendmentSummary(priRpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            
			//eventResponse.setUserMessage(new ErrorHandler("PRI01017").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_200304 : Accept <br>
	 * Accept Arbitrary accept<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptArbitraryCharge(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200304Event event = (EsmPri200304Event) e;
		RFATransportationAdditionalChargeProposalBC command1 = new RFATransportationAdditionalChargeProposalBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();
		
		try {
			begin();
			command1.acceptArbitraryCharge(event.getPriRpScpTrspAddChgVOS(), account);
			
			//log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = new PriRpScpAmdtSmryVO();
            priRpScpAmdtSmryVO.setPropNo(event.getPriRpScpTrspAddChgVOS()[0].getPropNo());
            priRpScpAmdtSmryVO.setAmdtSeq(event.getPriRpScpTrspAddChgVOS()[0].getAmdtSeq());
            priRpScpAmdtSmryVO.setSvcScpCd(event.getPriRpScpTrspAddChgVOS()[0].getSvcScpCd());
            if("O".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
            	priRpScpAmdtSmryVO.setPropScpTermTpCd("51");
            } else if("D".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
            	priRpScpAmdtSmryVO.setPropScpTermTpCd("52");
            }

            command2.manageScopeAmendmentSummary(priRpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            
			eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_200304 : Accept Cancel <br>
	 * Cancelling acceptted Arbitrary <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelArbitraryCharge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200304Event event = (EsmPri200304Event) e;
		RFATransportationAdditionalChargeProposalBC command1 = new RFATransportationAdditionalChargeProposalBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();
		
		try {
			begin();
			command1.cancelArbitraryCharge(event.getPriRpScpTrspAddChgVOS(), account);
			
			//log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
			PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = new PriRpScpAmdtSmryVO();
            priRpScpAmdtSmryVO.setPropNo(event.getPriRpScpTrspAddChgVOS()[0].getPropNo());
            priRpScpAmdtSmryVO.setAmdtSeq(event.getPriRpScpTrspAddChgVOS()[0].getAmdtSeq());
            priRpScpAmdtSmryVO.setSvcScpCd(event.getPriRpScpTrspAddChgVOS()[0].getSvcScpCd());
            if("O".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
            	priRpScpAmdtSmryVO.setPropScpTermTpCd("51");
            } else if("D".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
            	priRpScpAmdtSmryVO.setPropScpTermTpCd("52");
            }

            command2.manageScopeAmendmentSummary(priRpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            
			eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_04 : Accept All <br>
	 *  accepting  all arbitrary<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptAllArbitraryCharge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200304Event event = (EsmPri200304Event) e;
		RFATransportationAdditionalChargeProposalBC command1 = new RFATransportationAdditionalChargeProposalBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();
		
		try {
			begin();
			command1.acceptAllArbitraryCharge(event.getPriRpScpTrspAddChgVOS(), account);
			
			//log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = new PriRpScpAmdtSmryVO();
            priRpScpAmdtSmryVO.setPropNo(event.getPriRpScpTrspAddChgVOS()[0].getPropNo());
            priRpScpAmdtSmryVO.setAmdtSeq(event.getPriRpScpTrspAddChgVOS()[0].getAmdtSeq());
            priRpScpAmdtSmryVO.setSvcScpCd(event.getPriRpScpTrspAddChgVOS()[0].getSvcScpCd());
            if("O".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
            	priRpScpAmdtSmryVO.setPropScpTermTpCd("51");
            } else if("D".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
            	priRpScpAmdtSmryVO.setPropScpTermTpCd("52");
            }

            command2.manageScopeAmendmentSummary(priRpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            
			eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_04 : Accept Cancel <br>
	 * Cancelling accepted Arbitrary<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAllArbitraryCharge(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200304Event event = (EsmPri200304Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();
		
		try {
			begin();
			command.cancelAllArbitraryCharge(event.getPriRpScpTrspAddChgVOS(), account);
			
			//log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = new PriRpScpAmdtSmryVO();
            priRpScpAmdtSmryVO.setPropNo(event.getPriRpScpTrspAddChgVOS()[0].getPropNo());
            priRpScpAmdtSmryVO.setAmdtSeq(event.getPriRpScpTrspAddChgVOS()[0].getAmdtSeq());
            priRpScpAmdtSmryVO.setSvcScpCd(event.getPriRpScpTrspAddChgVOS()[0].getSvcScpCd());
            if("O".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
            	priRpScpAmdtSmryVO.setPropScpTermTpCd("51");
            } else if("D".equals(event.getPriRpScpTrspAddChgVOS()[0].getOrgDestTpCd())) {
            	priRpScpAmdtSmryVO.setPropScpTermTpCd("52");
            }

            command2.manageScopeAmendmentSummary(priRpScpAmdtSmryVO, account);
            //log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            
			eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2040 : Ok<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse amendProposal(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2040Event event = (EsmPri2040Event) e;
		RFAProposalMainBC command01 = new RFAProposalMainBCImpl();
		RFADurationProposalBC command02 = new RFADurationProposalBCImpl();
		RFAProposalDEMDETBC command04 = new RFAProposalDEMDETBCImpl();
		
		RFAGroupLocationProposalBC command05 = new RFAGroupLocationProposalBCImpl();
		RFAGroupCommodityProposalBC command06 = new RFAGroupCommodityProposalBCImpl();
		RFAAffiliateProposalBC command07 = new RFAAffiliateProposalBCImpl();
		RFANoteProposalBC command11 = new RFANoteProposalBCImpl();
		RFARateProposalBC command12 = new RFARateProposalBCImpl();
		RFATransportationAdditionalChargeProposalBC command14 = new RFATransportationAdditionalChargeProposalBCImpl();
		RFANoteConversionProposalBC command15 = new RFANoteConversionProposalBCImpl();
		
		PriRpMnVO vo = new PriRpMnVO();
		CstPriRpAmendVO amdVo = event.getCstPriRpAmendVO();
		ObjectCloner.build(amdVo, vo);
		if (!amdVo.getNewDurFlg().equals("Y")){ //inputting "Y" in case of new duration
			vo.setExpDt("");
		}
		
		try {
			begin();

			command01.amendProposal(vo, account);
			command02.amendProposal(vo, account);
			command04.amendProposal(vo, account);
			command05.amendProposal(vo, account);
			command06.amendProposal(vo, account);
			command07.amendProposal(vo, account);
			command11.amendProposal(vo, account);
			command12.amendProposal(vo, account);
			command14.amendProposal(vo, account);
			
			command15.amendProposal(vo, account);
			
			command01.manageProposalAmendmentSummaryDuration(vo, account);
			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_06 : Search <br>
	 * Retrieving Affiliate List <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAffiliateList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200306Event event = (EsmPri200306Event) e;
		RFAAffiliateProposalBC command = new RFAAffiliateProposalBCImpl();
		
		try {
			List<RsltPriRpAfilVO> list = command.searchAffiliateList(event.getPriRpAfilVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_06 : Save <br>
	 * Mdodifying Affiliate List. <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAffiliate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200306Event event = (EsmPri200306Event) e;
		RFAAffiliateProposalBC command = new RFAAffiliateProposalBCImpl();
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		try {
			begin();
			command.manageAffiliate(event.getPriRpAfilVOS(), account);
			
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
            priRpAmdtSmryVO.setPropNo(event.getPriRpAfilVOS()[0].getPropNo());
            priRpAmdtSmryVO.setAmdtSeq(event.getPriRpAfilVOS()[0].getAmdtSeq());
            priRpAmdtSmryVO.setPropTermTpCd("05");            
            command1.manageAmendmentSummary(priRpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
			
			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_06 : Accept <br>
	 * Accept Affiliate <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptAffiliate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200306Event event = (EsmPri200306Event) e;
		RFAAffiliateProposalBC command = new RFAAffiliateProposalBCImpl();
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		try {
			begin();
			command.acceptAffiliate(event.getPriRpAfilVOS(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
            priRpAmdtSmryVO.setPropNo(event.getPriRpAfilVOS()[0].getPropNo());
            priRpAmdtSmryVO.setAmdtSeq(event.getPriRpAfilVOS()[0].getAmdtSeq());
            priRpAmdtSmryVO.setPropTermTpCd("05");            
            command1.manageAmendmentSummary(priRpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
			
			eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_06 : Accept Cancel<br>
	 * Cancelling accept of Affiliate<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAffiliate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200306Event event = (EsmPri200306Event) e;
		RFAAffiliateProposalBC command = new RFAAffiliateProposalBCImpl();
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		try {
			begin();
			command.cancelAffiliate(event.getPriRpAfilVOS(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
            priRpAmdtSmryVO.setPropNo(event.getPriRpAfilVOS()[0].getPropNo());
            priRpAmdtSmryVO.setAmdtSeq(event.getPriRpAfilVOS()[0].getAmdtSeq());
            priRpAmdtSmryVO.setPropTermTpCd("05");            
            command1.manageAmendmentSummary(priRpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
			eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_06 : Accept All<br>
	 * Accept all of Affiliate<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptAllAffiliate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200306Event event = (EsmPri200306Event) e;
		RFAAffiliateProposalBC command = new RFAAffiliateProposalBCImpl();
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		try {
			begin();
			command.acceptAllAffiliate(event.getCstPriRpAfilVO(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
            priRpAmdtSmryVO.setPropNo(event.getCstPriRpAfilVO().getPropNo());
            priRpAmdtSmryVO.setAmdtSeq(event.getCstPriRpAfilVO().getAmdtSeq());
            priRpAmdtSmryVO.setPropTermTpCd("05");            
            command1.manageAmendmentSummary(priRpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
			eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2003_06 : Accept Cancel All<br>
	 * Cancelling all accepts of Affiliate<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelAllAffiliate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri200306Event event = (EsmPri200306Event) e;
		RFAAffiliateProposalBC command = new RFAAffiliateProposalBCImpl();
		RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
		try {
			begin();
			command.cancelAllAffiliate(event.getCstPriRpAfilVO(), account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
            priRpAmdtSmryVO.setPropNo(event.getCstPriRpAfilVO().getPropNo());
            priRpAmdtSmryVO.setAmdtSeq(event.getCstPriRpAfilVO().getAmdtSeq());
            priRpAmdtSmryVO.setPropTermTpCd("05");            
            command1.manageAmendmentSummary(priRpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
			eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2003_06 : OPEN<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initAffilComboData(Event e) throws EventException {	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			CodeUtil cdUtil = CodeUtil.getInstance(); 
			ArrayList<CodeInfo> srcInfoList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD02198",0);
			eventResponse.setCustomData("srcInfoList", srcInfoList);				
			ArrayList<CodeInfo> stsList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01719",0);
			eventResponse.setCustomData("stsList", stsList);				
		
		}catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	} 	

	/**
	 * ESM_PRI_2058 : Search <br>
	 * Retrieving DEMDET List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDEMDETExceptionList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2058Event event = (EsmPri2058Event) e;
		RFAProposalDEMDETBC command = new RFAProposalDEMDETBCImpl();

		try {
			List<RsltDmdtExptListVO> list = command.searchDEMDETExceptionList(event.getPriRpDmdtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}	
		return eventResponse;
	}

	/**
	 * ESM_PRI_2058 : Save <br>
	 * Modifying DEMDET <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDEMDETException(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2058Event event = (EsmPri2058Event) e;
		RFAProposalDEMDETBC command1 = new RFAProposalDEMDETBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();
		
		try {
			begin();
			command1.manageDEMDETException(event.getPriRpDmdtVOS(), account);
			
			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
            priRpAmdtSmryVO.setPropNo(event.getPriRpDmdtVOS()[0].getPropNo());
            priRpAmdtSmryVO.setAmdtSeq(event.getPriRpDmdtVOS()[0].getAmdtSeq());
            priRpAmdtSmryVO.setPropTermTpCd("08");
            command2.manageAmendmentSummary(priRpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            
			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2058 : Accept <br>
	 * Accept DEMDET . <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse acceptDEMDETException(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2058Event event = (EsmPri2058Event) e;
		RFAProposalDEMDETBC command1 = new RFAProposalDEMDETBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();
		
		try {
			begin();
			command1.acceptDEMDETException(event.getPriRpDmdtVOS(), account);
			
			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
            priRpAmdtSmryVO.setPropNo(event.getPriRpDmdtVOS()[0].getPropNo());
            priRpAmdtSmryVO.setAmdtSeq(event.getPriRpDmdtVOS()[0].getAmdtSeq());
            priRpAmdtSmryVO.setPropTermTpCd("08");
            command2.manageAmendmentSummary(priRpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
            
			eventResponse.setUserMessage(new ErrorHandler("PRI00108").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2058 : Accept Cancel <br>
	 * Cancel accept of DEMDET<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse cancelDEMDETException(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2058Event event = (EsmPri2058Event) e;
		RFAProposalDEMDETBC command1 = new RFAProposalDEMDETBCImpl();
		RFAProposalMainBC command2 = new RFAProposalMainBCImpl();
		
		try {
			begin();
			command1.cancelDEMDETException(event.getPriRpDmdtVOS(), account);
			log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< start");
            PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
            priRpAmdtSmryVO.setPropNo(event.getPriRpDmdtVOS()[0].getPropNo());
            priRpAmdtSmryVO.setAmdtSeq(event.getPriRpDmdtVOS()[0].getAmdtSeq());
            priRpAmdtSmryVO.setPropTermTpCd("08");
            command2.manageAmendmentSummary(priRpAmdtSmryVO, account);
            log.debug("<<<<<<<<<<<<<<<manageAmendmentSummary<<<<<<<<<<<<<<< end");
			eventResponse.setUserMessage(new ErrorHandler("PRI00109").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex){
			rollback();
		    throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
     * ESM_PRI_200304 : Search <br>
     * Retrieving ORIGIN& DESTINATION's FONT STYLE. <br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse checkArbitraryFontStyle(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri200304Event event = (EsmPri200304Event) e;
        RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
        try{
        	List<ChkFontStyleVO> list = command.checkFontStyle(event.getCstPriRpScpTrspAddChgVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
    	    throw ex;
    	}catch(Exception ex){
    	    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
    	}
        return eventResponse;
    }
    
	/**
     * ESM_PRI_2003 : Request <br>
	 * Retrieving dem/det when Request<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckDmdtList(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		try{
			List<DmtScExptVerVO> list = command.searchCheckDmdtList(event.getPriRpMnVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}    
	
	/**
     * ESM_PRI_2003 : Request <br>
	 * checking wheather duration is modified when Request <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCheckDurationList(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		try{
			List<RsltCdListVO> list = command.searchCheckDurationList(event.getPriRpMnVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}

		return eventResponse;
	}   	
	

	
	/**
	 * ESM_PRI_2047 : Search <br>
	 * Retrieving Rate Cargo Specification <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCargoSepcification(Event e) throws EventException {
		EsmPri2047Event event = (EsmPri2047Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try{
			List<RsltPriRpScpRtCgoSpecVO> list = command.searchRateCargoSepcification(event.getPriRpScpRtCgoSpecVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	} 
	
	/**
	 * ESM_PRI_2047 : Save <br>
	 * Modifying Rate Cargo Specification <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageRateCargoSepcification(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2047Event event = (EsmPri2047Event) e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try {
			begin();
			command.manageRateCargoSepcification(event.getPriRpScpRtCgoSpecVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("PRI00101").getUserMessage());
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2075 : Search <br>
	 * Retrieving Rate Cargo Specification <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRateCargoSepcificationInquiry(Event e) throws EventException {
		EsmPri2075Event event = (EsmPri2075Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try{
			List<RsltPriRpScpRtCgoSpecVO> list = command.searchRateCargoSepcification(event.getPriRpScpRtCgoSpecVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	} 

	/**
	 * ESM_PRI_2041_03 : RETRIEVE<br>
	 * Retrieving COMMODITY GROUP<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri204103Event event = (EsmPri204103Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpCmdtListVO> list = command.searchGroupCommodityHistoryList(event.getPriRpScpGrpCmdtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_03 : SHEET1.SELECTROW<br>
	 * Retrieving COMMODITY GROUP DETAIL<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityDeatilHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri204103Event event = (EsmPri204103Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpCmdtDtlListVO> list = command.searchGroupCommodityDetailHistoryList(event.getPriRpScpGrpCmdtDtlVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	   
	/**
	 * ESM_PRI_2019_03 : RETRIEVE<br>
	 * Retrieving COMMODITY GROUP<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri201903Event event = (EsmPri201903Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpCmdtListVO> list = command.searchGroupCommodityInquiryList(event.getPriRpScpGrpCmdtVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_03 : SHEET1.SELECTROW<br>
	 * Retrieving COMMODITY GROUP DETAIL.<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupCommodityDeatilInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri201903Event event = (EsmPri201903Event) e;
		RFAGroupCommodityProposalBC command = new RFAGroupCommodityProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpCmdtDtlListVO> list = command.searchGroupCommodityDetailInquiryList(event.getPriRpScpGrpCmdtDtlVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2041_04 : RETRIEVE<br>
	 * Retrieving LOCATION GROUP<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationHistoryList(Event e) throws EventException {
		EsmPri204104Event event = (EsmPri204104Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpLocListVO> list = command.searchGroupLocationHistoryList(event.getPriRpScpGrpLocVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_04 : SHEET1.SELECTROW<br>
	 * Retrieving LOCATION GROUP DETAIL<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationDetailHistoryList(Event e) throws EventException {
		EsmPri204104Event event = (EsmPri204104Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpLocDtlListVO> list = command.searchGroupLocationDetailHistoryList(event.getPriRpScpGrpLocDtlVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2019_02 : RETRIEVE<br>
	 * Retrieving LOCATION GROUP<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationInquiryList(Event e) throws EventException {
		EsmPri201902Event event = (EsmPri201902Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpLocListVO> list = command.searchGroupLocationInquiryList(event.getPriRpScpGrpLocVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_02 : SHEET1.SELECTROW<br>
	 * Retrieving LOCATION GROUP DETAIL<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGroupLocationDetailInquiryList(Event e) throws EventException {
		EsmPri201902Event event = (EsmPri201902Event) e;
		RFAGroupLocationProposalBC command = new RFAGroupLocationProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltGrpLocDtlListVO> list = command.searchGroupLocationDetailInquiryList(event.getPriRpScpGrpLocDtlVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	   /**
     * ESM_PRI_2041_08 : OPEN <br>
     * Retrieving combo information when loading SPECIAL NOTE INQUIRY screen<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchCommonSpecialNoteHistoryList(Event e) throws EventException {
		//EsmPri204108Event event = (EsmPri204108Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;		
		
        try {        	
        	////////////////////COMMON - START/////////////////////
        	//SOURCE
            vo.setCd("CD02198");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("SRC_INFO_CD", list);

        	//STATUS
            vo.setCd("CD01719");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PRC_PROG_STS_CD", list);
        	
        	
            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);
            
            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);
            
            //BAR TYPE
            vo.setCd("CD01708");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_HNGR_BAR_TP_CD", list);
            
            //CANAL
            vo.setCd("CD02538");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_CNL_TZ_CD", list);
            
            //B/I - PRICING E-SERVICE CONVERSION TYPE CODE
            vo.setCd("CD02582");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ESVC_TP_CD", list);
            
            //////////////////////COMMON - END///////////////////////
        	
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_PRI_2041_08 : RETRIEVE<br>
	 * Retrieving SPECIAL NOTE<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecialNoteHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri204108Event event = (EsmPri204108Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteListVO> list = command.searchNoteHistoryList(event.getPriRpScpNoteListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_08 : SHEET1.SELECTROW<br>
	 * Retrieving contents of SPECIAL NOTE<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecialNoteContentHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri204108Event event = (EsmPri204108Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteCtntListVO> list = command.searchSpecialNoteContentHistoryList(event.getPriRpScpNoteCtntVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2041_08 : SHEET2.SELECTROW<br>
	 * retrieving SPECIAL NOTE CONVERSION<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoteConversionHistoryList(Event e) throws EventException {
		EsmPri204108Event event = (EsmPri204108Event) e;
		RFANoteConversionProposalBC command = new RFANoteConversionProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteConvVO> list = command.searchNoteConversionList(event.getPriRfaNoteConvVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
    /**
     * ESM_PRI_2019_01 : OPEN <br>
     * Retrieving combo information when loading SPECIAL NOTE INQUIRY screen<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse searchCommonSpecialNoteInquiryList(Event e) throws EventException {
		//EsmPri201901Event event = (EsmPri201901Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        RsltCdListVO vo = new RsltCdListVO();
		List<RsltCdListVO> list = null;		
		
        try {        	
        	////////////////////COMMON - START/////////////////////
        	//SOURCE
            vo.setCd("CD02198");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("SRC_INFO_CD", list);

        	//STATUS
            vo.setCd("CD01719");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PRC_PROG_STS_CD", list);
        	
        	
            //APLICATION
            vo.setCd("CD01723");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("RT_APPL_TP_CD", list);
            
            //PAY TERM
            vo.setCd("CD01713");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("PAY_TERM_CD", list);
            
            //BAR TYPE
            vo.setCd("CD01708");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_HNGR_BAR_TP_CD", list);
          
            //CANAL
            vo.setCd("CD02538");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_CNL_TZ_CD", list);
            
            //B/I - PRICING E-SERVICE CONVERSION TYPE CODE
            vo.setCd("CD02582");
            list = command.searchComCodeDescList(vo);
            eventResponse.setCustomData("BKG_ESVC_TP_CD", list);
            
            
            //////////////////////COMMON - END///////////////////////
        	
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
	
	/**
	 * ESM_PRI_2019_01 : RETRIEVE<br>
	 * Retrieving SPECIAL NOTE<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecialNoteInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri201901Event event = (EsmPri201901Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteListVO> list = command.searchNoteInquiryList(event.getPriRpScpNoteListVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_01 : SHEET1.SELECTROW<br>
	 * Retrieving contents of SPECIAL NOTE<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchSpecialNoteContentInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmPri201901Event event = (EsmPri201901Event) e;
		RFANoteProposalBC command = new RFANoteProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteCtntListVO> list = command.searchSpecialNoteContentInquiryList(event.getPriRpScpNoteCtntVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_PRI_2019_01 : SHEET2.SELECTROW<br>
	 * SPECIAL NOTE CONVERSION��議고쉶�⑸땲��<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchNoteConversionInquiryList(Event e) throws EventException {
		EsmPri201901Event event = (EsmPri201901Event) e;
		RFANoteConversionProposalBC command = new RFANoteConversionProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			List<RsltNoteConvVO> list = command.searchNoteConversionList(event.getPriRfaNoteConvVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
		
    

	
	
    /**
     * ESM_PRI_2041 :  Inputting RFA No. <BR>
     * Retrieving Amendment History Main Data<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchAmendmentHistoryMain (Event e) throws EventException {
        EsmPri2041Event event = (EsmPri2041Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();        
        RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
        try{
            List<RsltPriRpAmdHstMnVO> list = command1.searchAmendmentHistoryMain(event.getPriRpHdrVO());
            
            if (list != null && list.size() !=0 && list.get(0) != null){	        
            	eventResponse.setETCData("prop_no", list.get(0).getPropNo());
    	        eventResponse.setETCData("amdt_seq", list.get(0).getAmdtSeq());
    	        eventResponse.setETCData("ctrt_pty_nm", list.get(0).getCtrtPtyNm()); 
    	        eventResponse.setETCData("ctrt_eff_dt", list.get(0).getCtrtEffDt());        
    	        eventResponse.setETCData("ctrt_exp_dt", list.get(0).getCtrtExpDt()); 
    	        
    	        PriRpMnVO vo = new PriRpMnVO();
    	        vo.setPropNo(list.get(0).getPropNo());
    	        List<RsltCdListVO> list1 = command1.searchHistoryScopeList(vo);
    	        eventResponse.setRsVoList(list1);
            }
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}

        
        
        return eventResponse;
    }	
    
    
    /**
     * ESM_PRI_2041 : Open<br>
     * Retrieving combo item of Amendment History Inquery screen<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse initAmendHistoryInquiry(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        List<RsltCdListVO> customData = null;
        try{
            customData = command.searchRfaTermTypeList (new RsltCdListVO());
            eventResponse.setCustomData("termType", customData);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}

        return eventResponse;
    }  	
    
    /**
     * ESM_PRI_2041 :  Retrieve  <BR>
     * Retrieving Amendment History Scope List Data<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchAmendmentHistoryList (Event e) throws EventException {
        EsmPri2041Event event = (EsmPri2041Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
        try{
            List<RsltAmdtHisMnVO> list = command1.searchAmendmentHistoryList(event.getCstShHistVO());
            eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}

        
        return eventResponse;
    }      
    
    /**
     * ESM_PRI_2041 :  sheet1_OnSelectCell <BR>
     * Retrieving Amended Terms Data<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchHistoryAmendTermList (Event e) throws EventException {
        EsmPri2041Event event = (EsmPri2041Event) e;
        GeneralEventResponse eventResponse = new GeneralEventResponse();        
        RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
        try{
            List<RsltPropScpAmdtSmryVO> list = command1.searchHistoryAmendTermList(event.getPriRpMnVO());
            eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
        
        return eventResponse;
    }      
    
    /**
     * ESM_PRI_2041 :  sheet Click  <BR>
     * Retrieving whether amended information in each terms exists or not<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchAmendmentHistorySummary(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	EsmPri2041Event event = (EsmPri2041Event) e;
        RFAProposalMainBC command = new RFAProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltPropScpAmdtSmryVO> list = command.searchAmendmentHistorySummary(event.getCstShHistVO());

            eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}

        return eventResponse;
    }    
	
    /**
     * ESM_PRI_2041_01 : SHEET1@FOCUS<br>
     * Retrieve Duration's Amend History<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalDurationHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri204101Event event = (EsmPri204101Event) e;
        RFADurationProposalBC command = new RFADurationProposalBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
            List<RsltPriRpDurHisVO> list= command.searchProposalDurationHistoryList(event.getPriRpScpDurVO());            
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }   
    
    /**
     * ESM_PRI_2041_07 : Retrieve<br>
     * Retrieving  Affiliate in RFA's Amendment History<br>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchAffiliateHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri204107Event event = (EsmPri204107Event) e;
        RFAAffiliateProposalBC command = new RFAAffiliateProposalBCImpl();
        
        try {
        	List<RsltAfilListVO> list = command.searchAffiliateHistoryList(event.getPriRpAfilVO());
        	eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }    
	
    /**
     * ESM_PRI_2041_09 : Retrieve<br>
     * Retrieving Amendment History - Dem/Det List<br>
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchDEMDETExceptionHistoryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri204109Event event = (EsmPri204109Event) e;
        RFAProposalDEMDETBC command = new RFAProposalDEMDETBCImpl();
        
        try {
	        List<RsltDmdtExptHisListVO> list = command.searchDEMDETExceptionHistoryList(event.getPriRpDmdtVO());
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }    
        return eventResponse;
    }    	
    
    /**
	 * ESM_PRI_2041_06 : Search <br>
	 * Retrieving Arbitrary Amend History  list <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeHistoryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri204106Event event = (EsmPri204106Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		
		try {
			List<RsltArbChgListVO> list = command.searchArbitraryChargeHistoryList(event.getPriRpScpTrspAddChgVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
     * ESM_PRI_204106 : Search <br>
     * retrieving Arbitrary Amend History's ORIGIN&DESTINATION's FONT STYLE<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse checkHistoryArbitraryFontStyle(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmPri204106Event event = (EsmPri204106Event) e;
        RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
        try{
	        List<ChkFontStyleVO> list = command.checkHistoryFontStyle(event.getCstPriRpScpTrspAddChgVO());
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
    	    throw ex;
    	}catch(Exception ex){
    	    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
    	}
        return eventResponse;
    }

    /**
     * ESM_PRI_2044 : Open<br>
     * Retrieving RFA Proposal<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalCopyList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri2044Event event = (EsmPri2044Event) e;
        RFAProposalMainBC command = new RFAProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltRfaPropCopyVO> list1 = command.searchProposalCopyAfilList(event.getRsltRfaPropCopyVO());
            List<RsltRfaPropCopyVO> list2 = command.searchProposalCopyList(event.getRsltRfaPropCopyVO());

            eventResponse.setRsVoList(list1);
            eventResponse.setRsVoList(list2);
        }catch(EventException ex){
    	    throw ex;
    	}catch(Exception ex){
    	    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
    	}

        return eventResponse;
    }

    /**
     * ESM_PRI_2044 : OK<br>
     * Copying RFA Proposal Main/Scope<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse copyProposal(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2044Event event = (EsmPri2044Event) e;
        RsltRfaPropCopyVO vo = event.getRsltRfaPropCopyVO();
        RsltRfaPropCopyVO[] spVos = event.getRsltRfaPropCopyVOs();

        if (spVos == null || spVos.length <= 0) {
            eventResponse.setUserMessage(new ErrorHandler("PRI00201").getUserMessage());
            return eventResponse;
        }
        RsltRfaPropCopyVO[] baVos = event.getRsltPropCpBlplAfilListVOs();

        RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
        RFADurationProposalBC command2 = new RFADurationProposalBCImpl();
        RFAAffiliateProposalBC command3 = new RFAAffiliateProposalBCImpl();
        RFATransportationAdditionalChargeProposalBC command4 = new RFATransportationAdditionalChargeProposalBCImpl();
        RFAGroupLocationProposalBC command5 = new RFAGroupLocationProposalBCImpl();
        RFAGroupCommodityProposalBC command6 = new RFAGroupCommodityProposalBCImpl();
        RFANoteProposalBC command7 = new RFANoteProposalBCImpl();
        RFARateProposalBC command8 = new RFARateProposalBCImpl();
        RFANoteConversionProposalBC command9 = new RFANoteConversionProposalBCImpl();
        RFAProposalDEMDETBC command10 = new RFAProposalDEMDETBCImpl();

        try {
            begin();
            String newPropNo = command1.searchMaxPropNo(account); // created prop_no
            if (JSPUtil.getNull(newPropNo).equals("")) {
                eventResponse.setUserMessage(new ErrorHandler("PRI00201").getUserMessage());
                commit();
                return eventResponse;
            }

            vo.setNewPropNo(newPropNo);

            // PRI_RP_MN/PRI_RP_HDR/PRI_RP_AMDT_SMRY/PRI_RP_PROG COPY
            command1.copyProposalMain(vo, account);

            // PRI_RP_DMDT
            command10.copyProposalDemDet(vo, account);
            
            // PRI_RP_DUR
            command2.copyProposalDuration(vo, account);

            if (baVos != null && baVos.length == 1 && baVos[0] != null && baVos[0].getPropNo() != null) {
                baVos[0].setNewPropNo(newPropNo);

                if (JSPUtil.getNullNoTrim(baVos[0].getAfilChk()).equals("1")) {
                    // PRI_RP_AFIL
                    command3.copyProposalAffiliate(baVos[0], account);
                }
            }
            
            // PRI_RP_AMDT_SMRY UPDATE
            PriRpAmdtSmryVO priRpAmdtSmryVO = new PriRpAmdtSmryVO();
            priRpAmdtSmryVO.setPropNo(newPropNo);
            priRpAmdtSmryVO.setAmdtSeq("0");
            command1.manageProposalAmendmentSummaryAll(priRpAmdtSmryVO, account);

            // Scope Copy
            if (spVos != null && spVos.length > 0) {
                for (int i = 0, n = spVos.length; i < n; i++) {
                    spVos[i].setNewPropNo(newPropNo);
                    if (JSPUtil.getNullNoTrim(spVos[i].getScpChk()).equals("1")) {
                        command1.copyProposalScopeMain(spVos[i], account);
                        command2.copyProposalScopeDuration(spVos[i], account);
                    } else {
                        continue;
                    }

                    if (JSPUtil.getNullNoTrim(spVos[i].getLocaChk()).equals("1")) {
                        // Group Location
                        command5.copyProposalScopeLocation(spVos[i], account);
                    }

                    if (JSPUtil.getNullNoTrim(spVos[i].getCmdtChk()).equals("1")) {
                        // Group Commodity
                        command6.copyProposalScopeCommodity(spVos[i], account);
                    }

                    if (JSPUtil.getNullNoTrim(spVos[i].getSpntChk()).equals("1")) {
                        // Special Note
                        command7.copyProposalScopeNote(spVos[i], account);
                        // Note Conversion
                        command9.copyProposalRfaNoteConversion(spVos[i], account);
                    }

                    if (JSPUtil.getNullNoTrim(spVos[i].getRateChk()).equals("1")) {
                        // Rate
                        command8.copyProposalScopeRate(spVos[i], account);
                        // Note Conversion
                        command9.copyProposalRoutNoteConversion(spVos[i], account);
                        command9.copyProposalCmdtNoteConversion(spVos[i], account);
                    }

                    if (JSPUtil.getNullNoTrim(spVos[i].getArorChk()).equals("1")) {
                        // Arbitrary Origin
                        spVos[i].setAddChgTpCd("A");
                        spVos[i].setOrgDestTpCd("O");
                        command4.copyProposalScopeTransport(spVos[i], account);
                    }

                    if (JSPUtil.getNullNoTrim(spVos[i].getArdeChk()).equals("1")) {
                        // Arbitrary Destination
                        spVos[i].setAddChgTpCd("A");
                        spVos[i].setOrgDestTpCd("D");
                        command4.copyProposalScopeTransport(spVos[i], account);
                    }
                }
                
                // PRI_RP_SCP_AMDT_SMRY UPDATE
                command1.copyProposalScopeAmdtSmry(spVos, account);
            }

            eventResponse.setUserMessage(new ErrorHandler("PRI00110").getUserMessage());
            eventResponse.setETCData("newPropNo", newPropNo);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_2007 : Open<br>
     * Retrieving organization map<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchOrganizationList(Event e) throws EventException {
        ComOrganizationVO paramVo = new ComOrganizationVO();
        EsmPri2007Event event = (EsmPri2007Event)e;
        paramVo = event.getComOrganizationVO();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        AuthorizationAssignmentBC authBC = new AuthorizationAssignmentBCImpl();
        try{
        	List<OrganizationVO> orgList = authBC.searchRFAOfficeTreeList (null);
            List<ComOrganizationVO> list = command.searchOrganizationList(paramVo,orgList);
            eventResponse.setRsVoList(list);
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }

    /**
     * ESM_PRI_2007 : Send<br>
     * saving Proposal Request  information<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse manageProposalRequestMessage(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2007Event event = (EsmPri2007Event)e;
        RFAProposalMainBC command = new RFAProposalMainBCImpl();
        try {
            begin();
            command.manageProposalRequestMessage(event.getPriRpAproRqstRefUsrVOs(), account);
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_PRI_2049 : Retrieve<br>
     * Retrieving proposal request which is requested and received for approving RFA<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalRequestList(Event e) throws EventException {
        RsltRfaAproRqstRefVO paramVo = new RsltRfaAproRqstRefVO();
        EsmPri2049Event event = (EsmPri2049Event)e;
        paramVo = event.getRsltRfaAproRqstRefVO();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RFAProposalMainBC command = new RFAProposalMainBCImpl();
        try{
            List<RsltRfaAproRqstRefVO> list = command.searchProposalRequestList(paramVo);
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
    	    throw ex;
    	}catch(Exception ex){
    	    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
    	}

        return eventResponse;
    }
    
    
    /**
     * ESM_PRI_2019 : Retrive <br>
     * Retrieving Proposal Main Inquiry List
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalMainInquiryList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri2019Event event = (EsmPri2019Event) e;
        RFAProposalMainBC command = new RFAProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltPriRpInqVO> list = command.searchProposalMainInquiryList(event.getCstShRInqVO());        

            eventResponse.setRsVoList(list);
        }catch(EventException ex){
    	    throw ex;
    	}catch(Exception ex){
    	    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
    	}

        return eventResponse;
    }    
    
    /**
     * ESM_PRI_2019 : sheet0_OnSelectCell<br>
     * Retrieving RFA Proposal Main Inquiry
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalMainInquiry(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri2019Event event = (EsmPri2019Event) e;
        RFAProposalMainBC command = new RFAProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            RsltPropInqListVO vo = command.searchProposalMainInquiry(event.getPriRpMnVO(), account);

            eventResponse.setRsVoList(vo.getRsltPropMnInqVOs());
            eventResponse.setRsVoList(vo.getRsltPropMnScpInqListVOs());
        }catch(EventException ex){
    	    throw ex;
    	}catch(Exception ex){
    	    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
    	}

        return eventResponse;
    }    
    
    /**
     * ESM_PRI_2019 : sheet2_OnSelectCell<br>
     * REtrieving RFA Proposal Inquiry Scope Terms's Amendment Summary <br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalScopeAmendmentSummaryInquiry(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri2019Event event = (EsmPri2019Event) e;
        RFAProposalMainBC command = new RFAProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            List<RsltPropScpAmdtSmryVO> list = command.searchProposalScopeAmendmentSummaryInquiry(event.getPriRpScpAmdtSmryVO());

            eventResponse.setRsVoList(list);
        }catch(EventException ex){
    	    throw ex;
    	}catch(Exception ex){
    	    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
    	}

        return eventResponse;
    }   
    
    /**
     * ESM_PRI_2019 : Open<br>
     * Retrieving Proposal& Amendment Inquery screen's Combo Item<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
	private EventResponse initProposalInquiry(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PRICommonBC command = new PRICommonBCImpl();
        try{
			List<RsltCdListVO> scopeList = command.searchServiceScopeCodeList(new RsltCdListVO());
			eventResponse.setCustomData("scopeList", scopeList);
			CodeUtil cdUtil = CodeUtil.getInstance(); 
			ArrayList<CodeInfo> stsList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD02394",0);
			eventResponse.setCustomData("stsList", stsList);	
			
			//2014.09.29
			ArrayList<CodeInfo> ctrtFlg = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD00912",0);
			eventResponse.setCustomData("ctrtFlg", ctrtFlg);
			
        }catch(EventException ex){
    	    throw ex;
    	}catch(Exception ex){
    	    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
    	}

        return eventResponse;
    }     

    /**
     * ESM_PRI_2019 : Customer<br>
     * Retrieving customer information by Customer Country Code & Customer Seq<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalCustomerInfoInquiry(Event e) throws EventException {
        PriSpCtrtPtyVO paramVo = new PriSpCtrtPtyVO();
        EsmPri2019Event event = (EsmPri2019Event) e;
        paramVo = event.getPriSpCtrtPtyVO();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        RFAProposalMainBC command = new RFAProposalMainBCImpl();
        try{
            List<RsltPropCustInfoVO> list = command.searchProposalCustomerInfoInquiry(paramVo);

            eventResponse.setRsVoList(list);
        }catch(EventException ex){
    	    throw ex;
    	}catch(Exception ex){
    	    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
    	}

        return eventResponse;
    }

	/**
     * ESM_PRI_2010 : when accepting Main Accept <br>
	 * Retrieving scope with same exp_dt of main when accepting Main duration<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchProposalDurationAcceptCount(Event e) throws EventException {
		EsmPri2010Event event = (EsmPri2010Event) e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		RFADurationProposalBC command = new RFADurationProposalBCImpl();
		try{
			List<RsltCdListVO> list = command.searchProposalDurationAcceptCount(event.getPriRpDurVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
    	    throw ex;
    	}catch(Exception ex){
    	    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
    	}

		return eventResponse;
	}    
	
	/**
	 * ESM_PRI_2010 : OPEN<br>
	 * 
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initDurComboData(Event e) throws EventException {	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			CodeUtil cdUtil = CodeUtil.getInstance(); 
			ArrayList<CodeInfo> srcInfoList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD02198",0);
			eventResponse.setCustomData("srcInfoList", srcInfoList);				
			ArrayList<CodeInfo> stsList = (ArrayList<CodeInfo>)cdUtil.getCodeSelect("CD01719",0);
			eventResponse.setCustomData("stsList", stsList);				
		
		}catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }		
		return eventResponse;
	} 		
	
	
	/**
     * ESM_PRI_2003 : Cancel(Approve) <br>
	 * Retrieving whether booking data exists or not when cancelling approval<br>
	 * Prohibition cancelling whether Data exists.
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchApprovalCancelCheck(Event e) throws EventException {
		EsmPri2003Event event = (EsmPri2003Event) e;
		RFAProposalMainBC command = new RFAProposalMainBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			List<RsltCdListVO> list = command.searchApprovalCancelCheck(event.getCstApprovalVO());
			eventResponse.setRsVoList(list);
        }catch(EventException ex){
    	    throw ex;
    	}catch(Exception ex){
    	    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
    	}
		return eventResponse;
	}    
	
	
	/**
     * ESM_PRI_2019_06 : Retrieve <br>
	 * Retrieving Affiliate Inquiry<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAffiliateInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201906Event event = (EsmPri201906Event) e;
		RFAAffiliateProposalBC command = new RFAAffiliateProposalBCImpl();

		try {
			List<PriRpAfilInqVO> list = command.searchAffiliateInquiryList(event.getPriRpAfilVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
     * ESM_PRI_2019_06 : loadPage() <br>
	 * retrieving basic information by proposal no when calling from dem/det <br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAffiliateHeader(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201906Event event = (EsmPri201906Event) e;
		RFAAffiliateProposalBC command = new RFAAffiliateProposalBCImpl();

		try {
			
			List<RsltPriRpAfilHdrVO> list = command.searchAffiliateHeader(event.getPriRpMnVO());
			
            if (list != null && list.size() !=0 && list.get(0) != null){	        
            	eventResponse.setETCData("rfa_no", list.get(0).getRfaNo());
    	        eventResponse.setETCData("amdt_seq", list.get(0).getAmdtSeq());
    	        eventResponse.setETCData("ctrt_eff_dt", list.get(0).getCtrtEffDt());        
    	        eventResponse.setETCData("ctrt_exp_dt", list.get(0).getCtrtExpDt()); 
            }			
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}	

	/**
	 * ESM_PRI_2019_04 : Search <br>
	 * Retrieving Arbitrary Inquiry List<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchArbitraryChargeInquiryList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri201904Event event = (EsmPri201904Event) e;
		RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
		
		try {
			List<RsltArbChgListVO> list = command.searchArbitraryChargeInquiryList(event.getPriRpScpTrspAddChgVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
		    throw ex;
		}catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
		return eventResponse;
	}
    
	/**
     * ESM_PRI_200304 : Search <br>
     * Retrieving RFA Proposal Creation - Arbitrary's ORIGIN& DESTINATION's FONT STYLE<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse checkArbitraryInquiryFontStyle(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmPri201904Event event = (EsmPri201904Event) e;
        RFATransportationAdditionalChargeProposalBC command = new RFATransportationAdditionalChargeProposalBCImpl();
        try{
        	List<ChkFontStyleVO> list = command.checkFontStyle(event.getCstPriRpScpTrspAddChgVO());
        	eventResponse.setRsVoList(list);
        }catch(EventException ex){
    	    throw ex;
    	}catch(Exception ex){
    	    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
    	}
        return eventResponse;
    }

    /**
     * ESM_PRI_2080 : Open <br>
     * Retrieving scope name on Guideline Copy screen<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchGuidelineCopySvcScpName(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri2080Event event = (EsmPri2080Event) e;
        PRICommonBC command = new PRICommonBCImpl();
        RpScpGlineCopyVO vo = event.getRpScpGlineCopyVO();
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            if (vo != null) {
                String svcScpNm = command.searchServiceScopeCodeDetailName(vo.getSvcScpCd());
                eventResponse.setCustomData("svcScpNm", svcScpNm);
            }
        }catch(EventException ex){
    	    throw ex;
    	}catch(Exception ex){
    	    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
    	}
        
        return eventResponse;
    }

    /**
     * ESM_PRI_2080 : Open <br>
     * retrieving information about Guideline Copy<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchGuidelineCopyCheck(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2080Event event = (EsmPri2080Event) e;
        RFAProposalMainBC command = new RFAProposalMainBCImpl();
        
        try {
	        List<RpScpGlineCopyVO> list = command.searchGuidelineCopyCheck(event.getRpScpGlineCopyVO());
	        eventResponse.setRsVoList(list);
        } catch(EventException ex){
		    throw ex;
		} catch(Exception ex){
		    throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}
        return eventResponse;
    }

    /**
     * ESM_PRI_2080 : OK <br>
     * Copying Guideline to Proposal<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse copyScopeGuideline(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmPri2080Event event = (EsmPri2080Event) e;
        RpScpGlineCopyVO[] vos = event.getRpScpGlineCopyVOS();

        if (vos == null || vos.length <= 0) {
            eventResponse.setUserMessage(new ErrorHandler("PRI00201").getUserMessage());
            return eventResponse;
        }
        RpScpGlineCopyVO vo = vos[0];

        RFAProposalMainBC command1 = new RFAProposalMainBCImpl();
        RFAGroupLocationProposalBC command2 = new RFAGroupLocationProposalBCImpl();
        RFAGroupCommodityProposalBC command3 = new RFAGroupCommodityProposalBCImpl();
        RFATransportationAdditionalChargeProposalBC command4 = new RFATransportationAdditionalChargeProposalBCImpl();
        RFARateProposalBC command6 = new RFARateProposalBCImpl();

        try {
            String glineSeq = command1.searchCopyGlineSeq(vo);
            if (JSPUtil.getNull(glineSeq).equals("")) {
                eventResponse.setUserMessage(new ErrorHandler("PRI00201").getUserMessage());
                return eventResponse;
            }
            begin();

            vo.setGlineSeq(glineSeq);
            if (JSPUtil.getNullNoTrim(vo.getLocChk()).equals("1")) {
                // PRI_RP_SCP_GRP_LOC/PRI_SP_SCP_GRP_LOC_DTL
                command2.copyScopeGuidelineGrpLoc(vo, account);
            }

            if (JSPUtil.getNullNoTrim(vo.getCmdtChk()).equals("1")) {
                command3.copyScopeGuidelineGrpCmdt(vo, account);
            }                
            
            vo.setOrgDestTpCd("O");
            if (JSPUtil.getNullNoTrim(vo.getArbOrgChk()).equals("1")) {
                command4.copyScopeGuidelineArbitrary(vo, account);
            }
            
            vo.setOrgDestTpCd("D");
            if (JSPUtil.getNullNoTrim(vo.getArbDesChk()).equals("1")) {
                command4.copyScopeGuidelineArbitrary(vo, account);
            }

            if (JSPUtil.getNullNoTrim(vo.getRateChk()).equals("1")) {
                command6.copyScopeGuidelineRate(vo, account);
            }

            // PRI_RP_SCP_AMDT_SMRY UPDATE
            command1.copyScopeGuidelineScopeAmdtSmry(vo, account);
            eventResponse.setUserMessage(new ErrorHandler("PRI00110",new String[]{}).getUserMessage());
            commit();
        } catch (EventException ex) {
            rollback();
            throw ex;
        } catch (Exception ex) {
            rollback();
            throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
        }
        return eventResponse;
    }
    
   
    
    /**
     * ESM_PRI_2003 : Calling from each Terms<br>
     * Retrieving main's status after Terms modified Summary<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalMainStatus(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmPri2003Event event = (EsmPri2003Event) e;
        RFAProposalMainBC command = new RFAProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
            List<RsltRfaMainStsVO> list = command.searchProposalMainStatus(event.getPriRpMnVO());        
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    }      
    
    /**
	 * ESM_PRI_2003_04 : Load Page <br>
	 * Initializing basic Code List<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initArbitraryComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		PRICommonBC command = new PRICommonBCImpl();
		
		CodeUtil cdUtil = CodeUtil.getInstance();
		
		List<RsltCdListVO> customData = null;
		List<CodeInfo> codeInfos = null;
		
		try {
			// Trans Mode
			codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01720", 0);
		    eventResponse.setCustomData("prcTrspModCd", codeInfos);
		    
		    // Rating Unit Code
		    customData = command.searchPerCodeList(new RsltCdListVO());
			eventResponse.setCustomData("ratUtCd", customData);
			
			// Currency Code
			customData = command.searchAllCurrencyCodeList(new RsltCdListVO());
			eventResponse.setCustomData("currCd", customData);
			
			// Cargo Type Code
			codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01701", 0);
		    eventResponse.setCustomData("prcCgoTpCd", codeInfos);
		    
		    // Source Info Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02198", 0);
		    eventResponse.setCustomData("srcInfoCd", codeInfos);
		    
		    // Proposal Status Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01719", 0);
		    eventResponse.setCustomData("prcProgStsCd", codeInfos);
		    
		    // Origin Term
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02070", 0);
            eventResponse.setCustomData("orgRcvDetermCd", codeInfos);
            
            // Destination Term
            codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02071", 0);
            eventResponse.setCustomData("destRcvDetermCd", codeInfos);
		    
		}catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2058 : Load Page <br>
	 * Initializing basic Code List <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse initDEMDETComboData(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CodeUtil cdUtil = CodeUtil.getInstance();
		List<CodeInfo> codeInfos = null;
		
		try {
		    // Demdet 
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01704", 0);
		    eventResponse.setCustomData("dmdtFtTpCd", codeInfos);
		    
		    // Source Info Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD02198", 0);
		    eventResponse.setCustomData("srcInfoCd", codeInfos);
		    
		    // Proposal Status Code
		    codeInfos = (List<CodeInfo>)cdUtil.getCodeSelect("CD01719", 0);
		    eventResponse.setCustomData("prcProgStsCd", codeInfos);
		}catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }
		return eventResponse;
	}
	
	
    /**
     * ESM_PRI_2003 : Cancel<br>
     * Retrieving whether accept, returned data exists or not when a user cancels request<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchProposalRequestCancelCheck(Event e) throws EventException {
        EsmPri2003Event event = (EsmPri2003Event) e;
        RFAProposalMainBC command = new RFAProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
            List<CstRequestCheckVO> list = command.searchProposalRequestCancelCheck(event.getPriRpMnVO());
            
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    } 	
    
    /**
     * ESM_PRI_2003 : <br>
     * check the RFA No. to exists<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     * @LastModifyDate : 2014.11.04
     */
    private EventResponse checkRFAno(Event e) throws EventException {
        EsmPri2003Event event = (EsmPri2003Event) e;
        RFAProposalMainBC command = new RFAProposalMainBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
            String isRFAno = command.checkRFAno(event.getPriRpHdrVO());
            
            eventResponse.setETCData("ISRFANO", isRFAno);
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
        }

        return eventResponse;
    } 
    
    /****************************************************************************************/
	/* ESM_PRI_2060 BackEndJob START */
	/****************************************************************************************/
    
    /**
	 * ESM_PRI_2060 <br>
	 * running backEndJob to check data and get BackEndJob's Key<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse checkRateExcelHorizontalBackEndJob(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2060Event event = (EsmPri2060Event)e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try{
			
			CodeUtil cdUtil = CodeUtil.getInstance();
			ArrayList<CodeInfo> termOrgCodeList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02070", 0);
			ArrayList<CodeInfo> termDestCodeList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02071", 0);
			ArrayList<CodeInfo> trspModCodeList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01720", 0);
			
			eventResponse.setETCData("BackEndJobKey", command.checkRateExcelHorizontalBackEndJob(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelVOS(), termOrgCodeList, termDestCodeList, trspModCodeList, account));

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/**
	 * BackEndJob : interval <br>
	 * BackEndJob���곹깭媛믪쓣 議고쉶�쒕떎.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse comBakEndJbVOs(Event e) throws EventException {
		String key = (String)e.getAttribute("KEY");
		String status = null;		
		RFARateProposalBC command = new RFARateProposalBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			status = command.comBakEndJbVOs(key);			
			eventResponse.setETCData("jb_sts_flg", status);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00340",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;		
	}
	
	/**
	 * ESM_PRI_2060 :
	 * CHECK Horizontal BACK-END RESULT<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse backEndJobChkHorizontalExcelResult(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		String sKey = (String)e.getAttribute("KEY");
		String strResult = "";
		
		try
		{
			BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(sKey);
			BackEndJobResult backEndJobResult = new BackEndJobResult();
			DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
			while(rowSet.next())
			{
				if ("2".equals(rowSet.getString("JB_STS_FLG")))
				{
					// BackEndJob 泥섎━以�
					strResult = "2";
				}
				else if ("3".equals(rowSet.getString("JB_STS_FLG")))
				{
					// �깃났硫붿떆吏�꽭��
					if ("EsmPri2060Event".equalsIgnoreCase(e.getEventName())) {
						List<RsltRtListHorizontalExcelVO> list = (List<RsltRtListHorizontalExcelVO>)backEndJobResult.loadFromFile(sKey);
						if ( list.size() == 0 )
						{
							eventResponse.setUserMessage(new ErrorHandler("COM12198").getUserMessage());
						} else {
							eventResponse.setRsVoList(list);
						}
					}
					strResult = "3";
				}
				else if ("4".equals(rowSet.getString("JB_STS_FLG")))
				{
					// �먮윭硫붿떆吏�꽭��
					String errMsg = rowSet.getString("jb_usr_err_msg");
					if(errMsg==null||"".equals(errMsg)){
						eventResponse.setUserMessage(new ErrorHandler("COM12240").getUserMessage());
					}else{
						eventResponse.setETCData("err_msg", rowSet.getString("jb_usr_err_msg"));
					}

					strResult = "4";
				}
			}
			eventResponse.setETCData("jb_sts_flg", strResult);
		} catch (Exception ex)
		{
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_PRI_2060 <br>
	 * running backEndJob to upload and get BackEndJob's Key<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse uploadRateExcelHorizontalBackEndJob(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmPri2060Event event = (EsmPri2060Event)e;
		RFARateProposalBC command = new RFARateProposalBCImpl();
		try{
			
			CodeUtil cdUtil = CodeUtil.getInstance();
			ArrayList<CodeInfo> termOrgCodeList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02070", 0);
			ArrayList<CodeInfo> termDestCodeList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD02071", 0);
			ArrayList<CodeInfo> trspModCodeList = (ArrayList<CodeInfo>) cdUtil.getCodeSelect("CD01720", 0);
			
			eventResponse.setETCData("BackEndJobKey", command.uploadRateExcelHorizontalBackEndJob(event.getPriRpScpRtCmdtHdrVO(), event.getRsltRtListHorizontalExcelVOS(), termOrgCodeList, termDestCodeList, trspModCodeList, account));

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("PRI00201",new String[]{}).getMessage(), ex);
		}		
		return eventResponse;
	}
	
	/****************************************************************************************/
	/* ESM_PRI_2060 BackEndJob END */
	/****************************************************************************************/
	
	
}
