/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : BookingCorrectionSC.java
 *@FileTitle : BDR_Correction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esm.bkg.bookingcorrection;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBC;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.basic.ProductCatalogCreateBCImpl;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBC;
import com.clt.apps.opus.esd.sce.bkgcopmanage.basic.BkgCopManageBCImpl;
import com.clt.apps.opus.esd.sce.bkgcopmanage.vo.UpdBkgForBkgCodVO;
import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.basic.TerminalAgreementManageBC;
import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.basic.TerminalAgreementManageBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryTableVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.OblIssVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdMainInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdParameterVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.PrdQtyInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.basic.SpecialCargoReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.basic.BDRCorrectionBC;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.basic.BDRCorrectionBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.event.EsmBkg0567Event;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.event.EsmBkg0708Event;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaDetailVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaInfoByBkgVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.bdrcorrection.vo.CaRsnRmkVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBC;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.basic.CODCorrectionBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.event.EsmBkg0156Event;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.event.EsmBkg0157Event;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.event.EsmBkg0981Event;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.BkgCodInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodAuthVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodCntrVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodHistoryVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodMailSendVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodOldNewRhndPortVvdVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodRehandlingInfoVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodRsoVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodStsVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OblRdemVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.blrating.blrating.basic.BlRatingBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationBLBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.basic.BLDocumentationCMBCImpl;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.basic.RevenueDebitNoteBC;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.basic.RevenueDebitNoteBCImpl;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.CstmBkgRevDrNoteVO;
import com.clt.apps.opus.esm.bkg.revenueaudit.revenuedebitnote.vo.RevDrNoteVO;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBC;
import com.clt.apps.opus.esm.coa.stdunitcost.costassign.basic.CostAssignBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.basic.BookingARCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.bookingarcreation.vo.ARBkgInterfaceCreationVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.basic.ChangeOfDestinationMgtBC;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.basic.ChangeOfDestinationMgtBCImpl;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.BkgCodCostListVO;
import com.clt.apps.opus.vop.opf.changeofdestinationmgt.changeofdestinationmgt.vo.ChangeOfDestinationMgtConditionVO;
import com.clt.apps.opus.esm.bkg.bookingcorrection.codcorrection.vo.CodEtcVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.BkgCodCostVO;
import com.clt.syscommon.common.table.BkgCodVO;
import com.clt.syscommon.common.table.BkgCodVvdVO;
import com.clt.syscommon.common.table.BkgCorrectionVO;
import com.clt.syscommon.common.table.CoaBkgComIfVO;
import com.clt.syscommon.common.table.OpfCodRjctCdVO;
import com.clt.syscommon.common.table.ScgRgnShpOprCdVO;

/**
 * ALPS-SpecialCargoBookingConduct Business Logic Basic Command
 * implementation<br>
 * - ALPS-SpecialCargoBookingConduct에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author 
 * @see UI_BKG_0207EventResponse,SpecialCargoRiderBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class BookingCorrectionSC extends ServiceCommandSupport {

	// Login User Information
    private SignOnUserAccount account = null;

    /**
     * BookingCorrection system preceding process for biz scenario<br>
     * BDR_Correction related objects creation<br>
     */
    public void doStart() {
        log.debug("BookingCorrectionSC START");
        try {
            // comment --> Checking LogIn
            account = getSignOnUserAccount();
            
        } catch(Exception e) {
            log.error(e.getLocalizedMessage());
        }
    }

    /**
     * BookingCorrection system biz scenario closing<br>
     * BDR_Correction clearing related objects<br>
     */
    public void doEnd() {
        log.debug("BookingCorrectionSC END");
    }

    /**
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;

        if(e.getEventName().equalsIgnoreCase("EsmBkg0157Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCodStsList(e);
            }
        }
        else if(e.getEventName().equalsIgnoreCase("EsmBkg0156Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCod(e);
            }else if(e.getFormCommand().isCommand(FormCommand.ADD)) {
                eventResponse = createCodRqst(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MODIFY)) {
                eventResponse = modifyCodRqst(e);
            }else if(e.getFormCommand().isCommand(FormCommand.REMOVE)) {
                eventResponse = removeCodRqst(e);
            }else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {	//Sequence 
                eventResponse = searchCodRqstSeq(e);
            }else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) { //Request Click
                eventResponse = requestCodApproval(e);
            }else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)) { //Cancel Click
                eventResponse = cancelCod(e);
            }else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)){ //Code Combo
        		eventResponse = searchCodCodeList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)){ //Calculation Click
        		eventResponse = searchRehandlingCost(e);
            }else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)){ //complete cod c/a
        		eventResponse = completeCodCa(e);
            }else if (e.getFormCommand().isCommand(FormCommand.COMMAND07)){ //Confirm Click
        		eventResponse = confirmCod (e); 
            }else if (e.getFormCommand().isCommand(FormCommand.COMMAND08)){ //PC Click
            	eventResponse =searchCodRoute (e);
            }else if (e.getFormCommand().isCommand(FormCommand.COMMAND09)){ //search Rehandling Port
            	eventResponse =searchRehandlingPort (e);
            }else if (e.getFormCommand().isCommand(FormCommand.COMMAND10)){ //start cod c/a
            	eventResponse = startCodCa (e);
            }else if (e.getFormCommand().isCommand(FormCommand.COMMAND11)){ //manual request
            	eventResponse = modifyCodMnlApprove (e);
            }else if (e.getFormCommand().isCommand(FormCommand.COMMAND12)){ //manual approve
            	eventResponse = modifyCodMnlApprove (e);
            }else if (e.getFormCommand().isCommand(FormCommand.COMMAND13)){ //manual cancel
            	eventResponse = modifyCodMnlApprove (e);
            }else if (e.getFormCommand().isCommand(FormCommand.COMMAND14)){ //search COD Email send List
            	eventResponse = searchCODEmailsendList (e);
            }else if (e.getFormCommand().isCommand(FormCommand.COMMAND15)){ // Send Email
            	eventResponse = sendCODEmail(e);
            }else if (e.getFormCommand().isCommand(FormCommand.COMMAND16)){ // Check Recipient 
            	eventResponse = searchRecipient(e);
            }
        }
        else if(e.getEventName().equalsIgnoreCase("EsmBkg0981Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCodHistory(e);
            } 
        }
        else if(e.getEventName().equalsIgnoreCase("EsmBkg0758Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCaKind(e);
            } 
        } 
        else if(e.getEventName().equalsIgnoreCase("EsmBkg0769Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCaKind(e);
            } 
        } 
        else if(e.getEventName().equalsIgnoreCase("EsmBkg0768Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCaReason(e);
            } 
        }
        else if(e.getEventName().equalsIgnoreCase("EsmBkg0708Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCaRsnRmk(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
            	eventResponse = startCA(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
            	eventResponse = modifyCaRsnRmk(e); 
            }
        } 
        else if(e.getEventName().equalsIgnoreCase("EsmBkg0567Event")) {
        	if(e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCaInfoByBkg(e);
        	} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)){
            	eventResponse = searchCaDetail(e);
            }
        } 
        
        return eventResponse;
    }
    
    /**
     * ESM_BKG_0157:btn_retrieve<br>
     * Searching the status history of COD<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCodStsList(Event e) throws EventException {
    	try{
	    	EsmBkg0157Event event = (EsmBkg0157Event)e;
	    	CODCorrectionBC command = new CODCorrectionBCImpl();
			List<CodStsVO> list = command.searchCodStsList(event.getCodStsInputVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}
			return eventResponse;
    	} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
	}
    
    /**
     * ESM_BKG_0156:loadPage<br>
     * Searching cod_rqst_seq in BKG_COD<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCodRqstSeq(Event e) throws EventException {
    	try{
	    	EsmBkg0156Event event = (EsmBkg0156Event)e;
	    	CODCorrectionBC command = new CODCorrectionBCImpl();
	    	List<BkgComboVO> list = command.searchCodRqstSeq(event.getBkgBlNoVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
			eventResponse.setRsVoList(list);
			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}
			return eventResponse;
    	} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
    
    /**
     * ESM_BKG_0156:btn_retrieve<br>
     * Searching the booking Info and status for creating the COD request Info<br>
     *
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCod(Event e) throws EventException {
    	try{
	    	EsmBkg0156Event      event         = (EsmBkg0156Event)e;
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			
	    	CODCorrectionBC command = new CODCorrectionBCImpl();
			
	    	CodVO codVO = command.searchCodRqst(event.getCodRqstSeq(),event.getBkgBlNoVO());

			eventResponse.setETCData("bkg_no", 			(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getBkgNo():"");
			eventResponse.setETCData("bl_no", 			(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getBlNo():"");
			eventResponse.setETCData("pctl_no",			(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getPctlNo():"");
			eventResponse.setETCData("bkgStsCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getBkgStsCd():"");
			eventResponse.setETCData("cod_rqst_seq", 	(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getSeq():"");
			eventResponse.setETCData("max_seq",		 	(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getMaxSeq():"");
			eventResponse.setETCData("cod_auth_flg", 	(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getArrpoval():"");
			eventResponse.setETCData("rgn_cd", 			(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getApprovalRso():"");
			eventResponse.setETCData("cod_rqst_rsn_cd", (codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getCodReason():"");
			eventResponse.setETCData("codRemark", 		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getCodRemark():"");
			eventResponse.setETCData("cod_rhnd_port_cd",(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getRehandlingPort():"");
			eventResponse.setETCData("codStsCd", 		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getCodStatus():"");
			eventResponse.setETCData("cod_rjct_cd", 	(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getRejectReasonCode():"");
			eventResponse.setETCData("codRjctRsnRmk",	(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getRejectReasonRemark():"");
			eventResponse.setETCData("cod_mnl_flg",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getCodMnlFlg():"");
			eventResponse.setETCData("bdr_flag",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getBdrFlg():"");
			eventResponse.setETCData("confirmFlg",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getCannotConfirmFlg():"");
			 
			eventResponse.setETCData("oldPorCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getOldPorCd():"");
			eventResponse.setETCData("oldPorNodCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getOldPorNodCd():"");
			eventResponse.setETCData("oldPolCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getOldPolCd():"");
			eventResponse.setETCData("oldPolNodCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getOldPolNodCd():"");
			eventResponse.setETCData("oldPodCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getOldPodCd():"");
			eventResponse.setETCData("oldPodNodCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getOldPodNodCd():"");
			eventResponse.setETCData("oldDelCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getOldDelCd():"");
			eventResponse.setETCData("oldDelNodCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getOldDelNodCd():"");
			eventResponse.setETCData("oldDeTermCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getOldDeTermCd():"");
			eventResponse.setETCData("oldPreCd" ,		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getOldPreCd():"");
			eventResponse.setETCData("oldPreNodCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getOldPreNodCd():"");
			eventResponse.setETCData("oldPstCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getOldPstCd():"");
			eventResponse.setETCData("oldPstNodCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getOldPstNodCd():"");
			eventResponse.setETCData("oldTvvd",			(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getOldTvvd():"");
			
			eventResponse.setETCData("newPorCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewPorCd():"");
			eventResponse.setETCData("newPorNodCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewPorNodCd():"");
			eventResponse.setETCData("newPolCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewPolCd():"");
			eventResponse.setETCData("newPolNodCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewPolNodCd():"");
			eventResponse.setETCData("newPodCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewPodCd():"");
			eventResponse.setETCData("newPodNodCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewPodNodCd():"");
			eventResponse.setETCData("newDelCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewDelCd():"");
			eventResponse.setETCData("newDelNodCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewDelNodCd():"");
			eventResponse.setETCData("newDeTermCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewDeTermCd():"");
			eventResponse.setETCData("newPreCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewPreCd():"");
			eventResponse.setETCData("newPreNodCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewPreNodCd():"");
			eventResponse.setETCData("newPstCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewPstCd():"");
			eventResponse.setETCData("newPstNodCd",		(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewPstNodCd():"");
			eventResponse.setETCData("newTvvd",			(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewTvvd():"");
			eventResponse.setETCData("cod_cnt",			(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getCodCnt():"");
						
			eventResponse.setRsVoList(codVO.getCodCntrVO());
			eventResponse.setRsVoList(codVO.getBkgCodCostVO());
			eventResponse.setRsVoList(codVO.getBkgCodCostSumVO());
			eventResponse.setRsVoList(codVO.getCodLastHistoryVO());
			eventResponse.setRsVoList(codVO.getBkgOldCodVvdVO());
			eventResponse.setRsVoList(codVO.getBkgNewCodVvdVO());
			return eventResponse;
    	} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}    
    
    /**
     * ESM_BKG_0981:loadPage<br>
     * Searching the changed COD history by request<br>
     * 
     * @author C.Y.H 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCodHistory(Event e) throws EventException {
    	try{
	    	EsmBkg0981Event event = (EsmBkg0981Event)e;
	    	CODCorrectionBC command = new CODCorrectionBCImpl();
			List<CodHistoryVO> list = command.searchCodHistory(event.getBkgBlNoVO(),event.getCodRqstSeq());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(list);
			if (list.isEmpty()) {
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());
			}
			return eventResponse;
    	} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
    
    /**
     * ESM_BKG_0156:btn_save<br>
     * Creating the requested COD Info<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse createCodRqst(Event e)throws EventException{    	
    	try {
    		EsmBkg0156Event event = (EsmBkg0156Event)e;
        	CODCorrectionBC command = new CODCorrectionBCImpl();
        	GeneralEventResponse eventResponse = new GeneralEventResponse();
            begin();
            command.createCodRqst(event.getCodVO(),account);
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();
            return eventResponse;
    	} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}    	
    }
    
    /**
     * ESM_BKG_0156:btn_save<br>
     * Modifying the requested COD Info<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse modifyCodRqst(Event e)throws EventException{    	
    	try {
    		EsmBkg0156Event event = (EsmBkg0156Event)e;
        	CODCorrectionBC command = new CODCorrectionBCImpl();
        	GeneralEventResponse eventResponse = new GeneralEventResponse();
            begin();
            command.modifyCodRqst(event.getCodVO(),event.getBkgBlNoVO(),event.getCodRqstSeq(), account);
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();
            return eventResponse;
    	} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}    	
    }
    
    /**
     * ESM_BKG_0156:btn_del<br>
     * Deleting the requested COD Info<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse removeCodRqst(Event e)throws EventException{
    	try {
    		EsmBkg0156Event event = (EsmBkg0156Event)e;
        	CODCorrectionBC command = new CODCorrectionBCImpl();
        	GeneralEventResponse eventResponse = new GeneralEventResponse();
            begin();
            command.removeCodRqst(event.getCodVO(),event.getBkgBlNoVO(),event.getCodRqstSeq(),account);
            eventResponse.setUserMessage(new ErrorHandler("BKG00593").getUserMessage());
            commit();
            return eventResponse;
    	} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}    	
    }
    
    /**
     * ESM_BKG_0156:btn_request<br>
     * Requesting the approval of saved COD Info as OPF<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse requestCodApproval(Event e)throws EventException{    	
    	try {
    		EsmBkg0156Event event   = (EsmBkg0156Event)e;
        	CODCorrectionBC command = new CODCorrectionBCImpl();
        	BookingUtil     util    = new BookingUtil();
        	GeneralEventResponse eventResponse = new GeneralEventResponse();
            begin();

            BkgBlNoVO bkgBlNoVO    = event.getBkgBlNoVO();
			String codRqstSeq 	   = event.getCodRqstSeq();
			String pctlNoMapSeqStr = bkgBlNoVO.getPctlNo();
			
			if(pctlNoMapSeqStr.length()>20){
				String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
				
				bkgBlNoVO.setPctlNo(pctlNoMapSeq[0]);	
				bkgBlNoVO.setMapSeq(pctlNoMapSeq[1]);
			}
			
            command.modifyCodStatus (bkgBlNoVO, codRqstSeq, "R", event.getCodRqstRsnCd(),account);
            
            // Send e-mail (to joint operation shipping company)
            command.sendXterCodRqst(codRqstSeq, bkgBlNoVO, account);			
			eventResponse.setETCData(command.searchCodRqstEmlCtnt(codRqstSeq, bkgBlNoVO, account).getColumnValues());           
            eventResponse.setUserMessage(new ErrorHandler("BKG08102").getUserMessage());
            commit();
            return eventResponse;
    	} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
    /**
     * ESM_BKG_0156:btn_cancel<br>
     * Canceling the requested COD status<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse cancelCod(Event e)throws EventException{
    	try {
    		EsmBkg0156Event event = (EsmBkg0156Event)e;
        	CODCorrectionBC command = new CODCorrectionBCImpl();
        	GeneralEventResponse eventResponse = new GeneralEventResponse();
            begin();
            command.modifyCodStatus(event.getBkgBlNoVO(),event.getCodRqstSeq(), "C", event.getCodRqstRsnCd(),account);
            // Send e-mail (to joint operation shipping company)
            command.sendXterCodRqst(event.getCodRqstSeq(), event.getBkgBlNoVO(), account);			
			eventResponse.setETCData(command.searchCodRqstEmlCtnt(event.getCodRqstSeq(), event.getBkgBlNoVO(), account).getColumnValues());
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();
            eventResponse.setETCData("codStsCd", "C");
            return eventResponse;
    	} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}    	
    }
    
    /**
     * ESM_BKG_0156:setCodReason_Combo<br>
     * Searching the Combobox for COD code<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCodCodeList(Event e)throws EventException{		
		try{
			BookingUtil comboUtil = new BookingUtil();
			ChangeOfDestinationMgtBC changeOfDestinationMgtBC = new ChangeOfDestinationMgtBCImpl();
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			ChangeOfDestinationMgtConditionVO changeOfDestinationMgtConditionVO = new ChangeOfDestinationMgtConditionVO();

			 List<BkgComboVO> codReasonlistList  = comboUtil.searchCombo("CD02153");
			 List<ScgRgnShpOprCdVO> rsoComboList = changeOfDestinationMgtBC.searchRsoCombo(changeOfDestinationMgtConditionVO);
			 List<OpfCodRjctCdVO> cODRejectCodeList = changeOfDestinationMgtBC.searchCODRejectCodeList(changeOfDestinationMgtConditionVO);
			 List<BkgComboVO> deTermCdList = comboUtil.searchCombo("CD00765");			 
			 
//	         List<BkgComboVO> statuslist_list  = comboUtil.searchCombo("CD02124");
	         eventResponse.setRsVoList(codReasonlistList);
	         eventResponse.setRsVoList(rsoComboList);
	         eventResponse.setRsVoList(cODRejectCodeList);
	         eventResponse.setRsVoList(deTermCdList);
//	         eventResponse.setRsVoList(statuslist_list);
	         return eventResponse;
		} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}		
	}
    
    /**
     * ESM_BKG_0156:btn_calculation<br>
     * Searching and Request the rehandling Cost to OPF<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    @SuppressWarnings("unchecked")
	private EventResponse searchRehandlingCost(Event e)throws EventException{
    	try{
        	EsmBkg0156Event event = (EsmBkg0156Event)e;
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		
        	ChangeOfDestinationMgtBC          codBC          = new ChangeOfDestinationMgtBCImpl();
			TerminalAgreementManageBC 		  tesBC 		 = new TerminalAgreementManageBCImpl();
	    	ChangeOfDestinationMgtConditionVO codConditionVO = new ChangeOfDestinationMgtConditionVO();
	    	CodRehandlingInfoVO 			  codRhndVO		 = new CodRehandlingInfoVO();
	    	List<BkgCodCostVO> 				  codCostVO 	 = new ArrayList<BkgCodCostVO>();
	    	
	    	//COD Info
	    	BkgCodVO 		bkgCodVO 	 = event.getCodVO().getBkgCodVO().get(0);
	    	BkgCodVvdVO [] 	newCodVvdVOs = event.getCodVO().getBkgNewCodVvdVOs();
	    	BkgCodVvdVO [] 	oldCodVvdVOs = event.getCodVO().getBkgOldCodVvdVOs();	
	    	List<CodCntrVO> codCntrVOs   = event.getCodVO().getCodCntrVO();	
	    	
	    	//7 digit rehandling yard code
	    	String rhndYdCd = bkgCodVO.getCodRhndPortYdCd();
	    	
	    	codConditionVO.setBkgNo        (event.getBkgBlNoVO().getBkgNo());
	    	codConditionVO.setCodRqstSeq   (event.getCodRqstSeq());
	    	codConditionVO.setCod          ("R");
	    	codConditionVO.setCodRhndPortCd(rhndYdCd.substring(0, 5));
	    	 
	    	// parameters for OPF
	    	String rhndVvd = "X";
	    	CodOldNewRhndPortVvdVO oldNewRhndPortVvdVO = new CodOldNewRhndPortVvdVO(); 
	    	oldNewRhndPortVvdVO.setCodRhndPortYdCd(rhndYdCd);
	    	
	    	//rehandling vvd
	    	for(int i=0;i<newCodVvdVOs.length;i++){
	    		if(newCodVvdVOs[i].getPodYdCd().equals(rhndYdCd)){
	    			rhndVvd = newCodVvdVOs[i].getVslCd()+newCodVvdVOs[i].getSkdVoyNo()+newCodVvdVOs[i].getSkdDirCd();
	    			break;
	    		}
	    	}
	    	if("X".equals(rhndVvd)){
		    	for(int i=0;i<oldCodVvdVOs.length;i++){
		    		if(oldCodVvdVOs[i].getPodYdCd().equals(rhndYdCd)){
		    			rhndVvd = oldCodVvdVOs[i].getVslCd()+oldCodVvdVOs[i].getSkdVoyNo()+oldCodVvdVOs[i].getSkdDirCd();
		    			break;
		    		}
		    	}
	    	}
	    	codConditionVO.setVvd(rhndVvd);
	    	oldNewRhndPortVvdVO.setVvd(rhndVvd);
	    	
	    	//newPodYdCd
	    	for(int i=0;i<newCodVvdVOs.length;i++){
	    		if(rhndVvd.equals(newCodVvdVOs[i].getVslCd()+newCodVvdVOs[i].getSkdVoyNo()+newCodVvdVOs[i].getSkdDirCd())){
	    			codConditionVO.setNewPod(newCodVvdVOs[i].getPodYdCd()); 
	    			oldNewRhndPortVvdVO.setNewPodYdCd(newCodVvdVOs[i].getPodYdCd());
	    			break;
	    		}
	    	}
	    	//oldPodYdCd
	    	for(int i=0;i<oldCodVvdVOs.length;i++){
	    		if(rhndVvd.equals(oldCodVvdVOs[i].getVslCd()+oldCodVvdVOs[i].getSkdVoyNo()+oldCodVvdVOs[i].getSkdDirCd())){
	    			codConditionVO.setOldPod(oldCodVvdVOs[i].getPodYdCd()); 
	    			oldNewRhndPortVvdVO.setOldPodYdCd(oldCodVvdVOs[i].getPodYdCd());
	    			break;
	    		}
	    	}
	    	//rhndCntrList 
	    	List<CodCntrVO> opfCntrVOs   = new ArrayList<CodCntrVO>();
	    	List<String>    rhndCntrList = new ArrayList<String>();
	    	for(int i=0;i<codCntrVOs.size();i++){
	    		if("Y".equals(codCntrVOs.get(i).getChk())){
	    			log.debug("cntr:"+codCntrVOs.get(i).getCntrNo());
	    			rhndCntrList.add(codCntrVOs.get(i).getCntrNo());
	    			CodCntrVO codCntrVO = new CodCntrVO();
	    			codCntrVO.setCntrNo(codCntrVOs.get(i).getCntrNo());
	    			opfCntrVOs.add(codCntrVO);
	    		}
	    	}

	    	codRhndVO.setCodOldNewRhndPortVvdVO(oldNewRhndPortVvdVO);
	    	codRhndVO.setCodCntrVOs(opfCntrVOs);
	    	List<ChangeOfDestinationMgtConditionVO> codConditionVOs = codBC.searchBayPlanCheck(codConditionVO);
	    	if (codConditionVOs.size()>0
	    		&& Integer.parseInt(codConditionVOs.get(0).getCnt())>0){
	    		
	    		List<BkgCodCostListVO> bkgCodCostList=codBC.searchRehandlingQTY(codConditionVO, codRhndVO);
				if(bkgCodCostList.size() < 1){
					throw new EventException((String)new ErrorHandler("OPF00006").getMessage());
				}else{
			    	boolean bbBlan = false;

			    	for(int i=0; i<bkgCodCostList.size(); i++){
						if("BB".equals(((BkgCodCostListVO)bkgCodCostList.get(i)).getCgoCateCd())){
							bbBlan = true;
						}else{
							bbBlan = false;
						}
					}
					
					if(bbBlan){
						throw new EventException((String)new ErrorHandler("OPF00005").getMessage());
					}else{
						List rtnCostList = tesBC.searchRehandlingCost(bkgCodCostList);
						if(rtnCostList.size() < 1){
							throw new EventException((String)new ErrorHandler("OPF00004").getMessage());
						}else{					
							for(int i=0; i<rtnCostList.size(); i++){
								codCostVO.addAll(i, (List<BkgCodCostVO>)rtnCostList.get(i));
							}
						}
					}
				}
				for(int i=0; i<codCostVO.size(); i++){
					codCostVO.get(i).setCostCdRqstSeq((i+1)+"");
				}
	    		eventResponse.setRsVoList(codCostVO);
	    	}else{
	    		throw new EventException((String)new ErrorHandler("BKG02035").getMessage());
	    	}
	    	
	    	return eventResponse;
    	} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}		
    }
    
    /**
     * ESM_BKG_0156:btn_bkg_main<br>
     * Starting the C/A for COD<br>
     *  
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse startCodCa(Event e) throws EventException{    	
    	try {
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
        	EsmBkg0156Event event = (EsmBkg0156Event)e;
        	
        	GeneralBookingReceiptBC receiptBC = new GeneralBookingReceiptBCImpl();
        	BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
    		BLDocumentationCMBC blCmBC = new BLDocumentationCMBCImpl();
    		BlRatingBC ratingBC = new BlRatingBCImpl();
    		
        	BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO(); 
        	bkgBlNoVO.setCaFlg("Y");        	
        	HistoryTableVO historyTableVO = historyBC.searchOldBkgForHistory("ESM_BKG_0156", bkgBlNoVO);
    		receiptBC.modifyTempHistForCOD(bkgBlNoVO, event.getCodRqstSeq(),account);
    		
			blCmBC.modifyBlActWgt(bkgBlNoVO, "X",  "X", account);

			ratingBC.modifyRateCntCd(bkgBlNoVO.getBkgNo(), account, bkgBlNoVO.getCaFlg());
        	historyBC.manageBookingHistory("ESM_BKG_0156", historyTableVO, account);    		
    		
			eventResponse.setETCData("SuccessYn","Y");
			
	    	return eventResponse;
    	} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}    	
    }    
    
    /**
     * ESM_BKG_0156:btn_confirm<br>
     * Updating the route Info into Booking Info after COD approved<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse confirmCod(Event e)throws EventException{    	
    	try {
        	EsmBkg0156Event event = (EsmBkg0156Event)e;
        	GeneralBookingReceiptBC receiptBC  = new GeneralBookingReceiptBCImpl();
        	CODCorrectionBC         codBC      = new CODCorrectionBCImpl();
        	BlRatingBC              blRatingBC = new BlRatingBCImpl();
        	BookingHistoryMgtBC     historyBC  = new BookingHistoryMgtBCImpl();
        	BookingUtil             util       = new BookingUtil();
        	
        	BDRCorrectionBC         bdrBC      = new BDRCorrectionBCImpl();
    		BLDocumentationBLBC     blDocBlBC  = new BLDocumentationBLBCImpl();
    		BLDocumentationCMBC     blCmBC     = new BLDocumentationCMBCImpl();
    		SpecialCargoReceiptBC   spclCgoBC  = new SpecialCargoReceiptBCImpl();
    		BLIssuanceBC            blIssBC    = new BLIssuanceBCImpl();
			CargoReleaseOrderBC     cgoRelBC   = new CargoReleaseOrderBCImpl();
    		
        	BkgCopManageBC          copBC      = new BkgCopManageBCImpl();
			CostAssignBC            coaBc      = new CostAssignBCImpl();
			BookingARCreationBC     invBc      = new BookingARCreationBCImpl();
			RevenueDebitNoteBC      rdnBC      = new RevenueDebitNoteBCImpl();
			
    		GeneralEventResponse eventResponse = new GeneralEventResponse();
    		
            begin();
            
            BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();
            bkgBlNoVO.setBdrFlg(event.getBdrFlag());
            bkgBlNoVO.setCaFlg("N");
            
            // Insert the 1st C/A
            if("Y".equals(event.getBdrFlag())){
            	String strReturn  = "N";    		
    			String copyTypeCd = "HIST000";
    			
    			//01. 
    			strReturn = bdrBC.add1stCaHist(bkgBlNoVO, account);
    						
    			if ("N".equals(strReturn)) {
    				//02. 
    				bkgBlNoVO.setCaNo("0000000001"); 
    				receiptBC.createBookingCA(bkgBlNoVO, copyTypeCd);     				
    				//03. 
    				blDocBlBC.createBlCA     (bkgBlNoVO, copyTypeCd);     				
    				//04. 
    				spclCgoBC.createSpclCA   (bkgBlNoVO, copyTypeCd);     				
    				//05. 
    				blRatingBC.createRateCA  (bkgBlNoVO, copyTypeCd);     				
    				//06. 
    				blIssBC.createIssCA      (bkgBlNoVO, copyTypeCd); 
    			}
    		}

			String pctlNoMapSeqStr = bkgBlNoVO.getPctlNo();
			
			if(pctlNoMapSeqStr.length()>20){
				String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
				
				bkgBlNoVO.setPctlNo(pctlNoMapSeq[0]);	
				bkgBlNoVO.setMapSeq(pctlNoMapSeq[1]);
			} 

			log.error("COD confirm bkg_no:"+bkgBlNoVO.getBkgNo()+",pctl_no:"+bkgBlNoVO.getPctlNo()+",map_seq:"+bkgBlNoVO.getMapSeq());
						
			HistoryTableVO historyTableVO =historyBC.searchOldBkgForHistory("ESM_BKG_0156", bkgBlNoVO);
			
			//POD,DEL 국가 변경시 COP 호출
			CodEtcVO codEtcVO = codBC.searchCopForBkgCodParam(bkgBlNoVO);
			
			receiptBC.modifyBookingFromCod(bkgBlNoVO, bkgBlNoVO, event.getCodRqstSeq(), account);
			
			blCmBC.modifyBlActWgt(bkgBlNoVO, "X",  "X", account);

			blRatingBC.modifyRateCntCd(bkgBlNoVO.getBkgNo(), account, "N");
			
			//07-1. 
            if("Y".equals(event.getBdrFlag())){
            	BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();
            	bkgCorrectionVO.setBkgNo(bkgBlNoVO.getBkgNo());
            	bkgCorrectionVO.setCaRsnCd(event.getCaRsnCd());
            	bkgCorrectionVO.setBkgCorrRmk(event.getCaRemark());
            	
				bdrBC.addAutoCaTemp(bkgBlNoVO, "COD_CONFIRM", bkgCorrectionVO, account);
				
				String tempHistCd = "H";
				String copyTypeCd = "HIST";

				//01. createTempHist
				BkgBlNoVO corrBkgBlNoVO = bdrBC.createTempHist(bkgBlNoVO, tempHistCd, bkgCorrectionVO, account);

				//02. createBookingCA
				receiptBC.createBookingCA(corrBkgBlNoVO, copyTypeCd);				
				//03. createBlCA 
				blDocBlBC.createBlCA     (corrBkgBlNoVO, copyTypeCd);				
				//04. createSpclCA
				spclCgoBC.createSpclCA   (corrBkgBlNoVO, copyTypeCd);				
				//05. createRateCA
				blRatingBC.createRateCA  (corrBkgBlNoVO, copyTypeCd);				
				//06. createIssCA
				blIssBC.createIssCA      (corrBkgBlNoVO, copyTypeCd);
				
				bdrBC.removeCATemp(bkgBlNoVO);
								
				OblIssVO oblIssVO = util.searchOblIssue(corrBkgBlNoVO); 
				
				RevDrNoteVO revDrNoteVO 		  = new RevDrNoteVO(); 
				CstmBkgRevDrNoteVO bkgRevDrNoteVO = new CstmBkgRevDrNoteVO();
				bkgRevDrNoteVO.setBkgNo      (corrBkgBlNoVO.getBkgNo());  
				bkgRevDrNoteVO.setBkgCorrNo  (corrBkgBlNoVO.getCaNo()); 
				bkgRevDrNoteVO.setRdnNo      (oblIssVO.getRdnNo()); 
				bkgRevDrNoteVO.setRvisSeq    (oblIssVO.getRvisSeq()); 
				bkgRevDrNoteVO.setReceiverRmk("");
				revDrNoteVO.setBkgRevDrNoteVO(bkgRevDrNoteVO);
				
				rdnBC.acceptRDNbyReceiptOffice(revDrNoteVO, account);  
				
				OblRdemVO oblRdem = new OblRdemVO();
				oblRdem.setBlNo      (oblIssVO.getBlNo());  
				oblRdem.setCgorTeamCd("C");
				oblRdem.setCgoEvntNm ("B/L Correct");
				oblRdem.setEvntDt    (new SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
				oblRdem.setEvntOfcCd (account.getOfc_cd());
				oblRdem.setEvntUsrId (account.getUsr_id());
				oblRdem.setOblRdemFlg(oblIssVO.getOblRlseFlg()); 
				try{
					cgoRelBC.setupFocByObl(oblRdem);
				} catch(Exception crEx){
					log.error("err " + crEx.toString(), crEx);
				}	
				historyTableVO.getBkgBlNoVO().setCaNo(corrBkgBlNoVO.getCaNo());
			}
			
			historyBC.manageBookingHistory("ESM_BKG_0156", historyTableVO,account);
			
			// Calling SCE
			copBC.updateBkg(bkgBlNoVO.getBkgNo(), bkgBlNoVO.getMapSeq());
			

			//POD,DEL 국가 변경시 COP 호출
			if(codEtcVO!=null){
				UpdBkgForBkgCodVO updBkgForBkgCodVO = new UpdBkgForBkgCodVO();
				updBkgForBkgCodVO.setBkgNo(codEtcVO.getBkgNo());
				updBkgForBkgCodVO.setOldPodYdCd(codEtcVO.getOldPodNodCd());
				updBkgForBkgCodVO.setOldDelYdCd(codEtcVO.getOldDelNodCd());
				updBkgForBkgCodVO.setNewPodYdCd(codEtcVO.getNewPodNodCd());
				updBkgForBkgCodVO.setNewDelYdCd(codEtcVO.getNewDelNodCd());
				copBC.updateBkgForBkgCod(updBkgForBkgCodVO);
			}
			
						
			codBC.confirmCod(event.getCodRqstSeq(), event.getBkgBlNoVO(), account);
			// Send e-mail (to joint operation shipping company)
			codBC.sendXterCodRqst(event.getCodRqstSeq(), bkgBlNoVO, account);			
			eventResponse.setETCData(codBC.searchCodRqstEmlCtnt(event.getCodRqstSeq(), bkgBlNoVO, account).getColumnValues());
			
			//costAssignBC.modifyCoaCommonInterface();
			log.debug("TO COA bkg no : " + event.getBkgBlNoVO().getBkgNo());
			CoaBkgComIfVO coaBkgComIfVo = new CoaBkgComIfVO();
			coaBkgComIfVo.setBkgNo(event.getBkgBlNoVO().getBkgNo());
			coaBkgComIfVo.setCostSrcSysCd("BKG");
			coaBkgComIfVo.setIfRmk("VVD ASSIGN");
			coaBkgComIfVo.setCreUsrId(account.getUsr_id());
			coaBkgComIfVo.setUpdUsrId(account.getUsr_id());
			coaBc.modifyCoaCommonInterface(coaBkgComIfVo);
			
			//IBookingARCreationBC::interfaceBKGARInvoiceToINV ( bkgIfVo )
			log.debug("TO INV bkg no : " + event.getBkgBlNoVO().getBkgNo());
			ARBkgInterfaceCreationVO bkgIfVo = new ARBkgInterfaceCreationVO();	
			bkgIfVo.setBkgNo(event.getBkgBlNoVO().getBkgNo());
			bkgIfVo.setBkgCorrNo(bkgBlNoVO.getCaNo());
			bkgIfVo.setUserId(account.getUsr_id());
			bkgIfVo.setManDivInd("B");			
			invBc.interfaceBKGARInvoiceToINV(bkgIfVo);

			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
	    	commit();
	    	return eventResponse;
    	} catch(EventException se) {
			log.error("err " + se.toString(), se);
			rollback();
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}    	
    }
    
    /**
     * ESM_BKG_0156:btn_pc<br>
     * Searching the route for requested COD data via PRD<br>
     * 
     * @param  Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchCodRoute(Event e)throws EventException{
    	try{    		
	    	EsmBkg0156Event 	 event 		   = (EsmBkg0156Event)e;
	    	GeneralEventResponse eventResponse = new GeneralEventResponse();
	    	
	    	BookingUtil 			util  = new BookingUtil();
	    	ProductCatalogCreateBC  prdBC = new ProductCatalogCreateBCImpl();
	    	
	    	PrdParameterVO prdParameterVO = new PrdParameterVO();
	    	PrdMainInfoVO  prdMainInfoVO  = new PrdMainInfoVO();
	    	
	    	begin();
	    	
	    	BkgCodVO bkgCodVO = event.getCodVO().getBkgCodVO().get(0);
	    	BkgCodVvdVO[] bkgNewCodVvdVOs = event.getCodVO().getBkgNewCodVvdVOs();
			prdParameterVO.setBkgBlNoVO(event.getBkgBlNoVO());
	    	prdMainInfoVO.setFCmd("3");
			prdMainInfoVO.setPcMode("R");
			prdMainInfoVO.setBkgNo(event.getBkgBlNoVO().getBkgNo());
			prdParameterVO.setPrdMainInfoVO(prdMainInfoVO);
			
	    	PrdParameterVO rtnPrdParameter = util.searchPrdParmForFullRoute(prdParameterVO);
	    	
	    	rtnPrdParameter.getPrdMainInfoVO().setPod  (bkgCodVO.getNewPodYdCd().substring(0,5));
	    	rtnPrdParameter.getPrdMainInfoVO().setPodN((bkgCodVO.getNewPodYdCd().length()==7)?bkgCodVO.getNewPodYdCd():"");
			rtnPrdParameter.getPrdMainInfoVO().setDel  (bkgCodVO.getNewDelYdCd().substring(0,5));
			rtnPrdParameter.getPrdMainInfoVO().setDelN((bkgCodVO.getNewDelYdCd().length()==7)?bkgCodVO.getNewDelYdCd():"");
			rtnPrdParameter.getPrdMainInfoVO().setTVvd (bkgCodVO.getNewVslCd()
										               +bkgCodVO.getNewSkdVoyNo()
										               +bkgCodVO.getNewSkdDirCd());
			rtnPrdParameter.getPrdMainInfoVO().setDelT (bkgCodVO.getNewDeTermCd());
			if (bkgNewCodVvdVOs.length>0){
				rtnPrdParameter.getPrdMainInfoVO().setPod1  (bkgNewCodVvdVOs[0].getPodYdCd().substring(0,5));
				rtnPrdParameter.getPrdMainInfoVO().setPod1N((bkgNewCodVvdVOs[0].getPodYdCd().length()==7)?bkgNewCodVvdVOs[0].getPodYdCd():"");
				rtnPrdParameter.getPrdMainInfoVO().setPod1C (bkgNewCodVvdVOs[0].getPodClptIndSeq());
				rtnPrdParameter.getPrdMainInfoVO().setPol1  (bkgNewCodVvdVOs[0].getPolYdCd().substring(0,5));
				rtnPrdParameter.getPrdMainInfoVO().setPol1N((bkgNewCodVvdVOs[0].getPolYdCd().length()==7)?bkgNewCodVvdVOs[0].getPolYdCd():"");
				rtnPrdParameter.getPrdMainInfoVO().setPol1C (bkgNewCodVvdVOs[0].getPolClptIndSeq());
				rtnPrdParameter.getPrdMainInfoVO().setVvd1  (bkgNewCodVvdVOs[0].getVslCd()
														    +bkgNewCodVvdVOs[0].getSkdVoyNo()
														    +bkgNewCodVvdVOs[0].getSkdDirCd());
				rtnPrdParameter.getPrdMainInfoVO().setLane1(util.searchSvcLaneByVvd(rtnPrdParameter.getPrdMainInfoVO().getVvd1()));
			}else{
				rtnPrdParameter.setPrdMainInfoVO(util.resetNthRoute(rtnPrdParameter.getPrdMainInfoVO(), 1));
			}
			if (bkgNewCodVvdVOs.length>1){
				rtnPrdParameter.getPrdMainInfoVO().setPod2  (bkgNewCodVvdVOs[1].getPodYdCd().substring(0,5));
				rtnPrdParameter.getPrdMainInfoVO().setPod2N((bkgNewCodVvdVOs[1].getPodYdCd().length()==7)?bkgNewCodVvdVOs[1].getPodYdCd():"");
				rtnPrdParameter.getPrdMainInfoVO().setPod2C (bkgNewCodVvdVOs[1].getPodClptIndSeq());
				rtnPrdParameter.getPrdMainInfoVO().setPol2  (bkgNewCodVvdVOs[1].getPolYdCd().substring(0,5));
				rtnPrdParameter.getPrdMainInfoVO().setPol2N((bkgNewCodVvdVOs[1].getPolYdCd().length()==7)?bkgNewCodVvdVOs[1].getPolYdCd():"");
				rtnPrdParameter.getPrdMainInfoVO().setPol2C (bkgNewCodVvdVOs[1].getPolClptIndSeq());
				rtnPrdParameter.getPrdMainInfoVO().setVvd2  (bkgNewCodVvdVOs[1].getVslCd()
														    +bkgNewCodVvdVOs[1].getSkdVoyNo()
														    +bkgNewCodVvdVOs[1].getSkdDirCd());
				rtnPrdParameter.getPrdMainInfoVO().setLane2(util.searchSvcLaneByVvd(rtnPrdParameter.getPrdMainInfoVO().getVvd2()));
			}else{
				rtnPrdParameter.setPrdMainInfoVO(util.resetNthRoute(rtnPrdParameter.getPrdMainInfoVO(), 2));
			}
			if (bkgNewCodVvdVOs.length>2){
				rtnPrdParameter.getPrdMainInfoVO().setPod3  (bkgNewCodVvdVOs[2].getPodYdCd().substring(0,5));
				rtnPrdParameter.getPrdMainInfoVO().setPod3N((bkgNewCodVvdVOs[2].getPodYdCd().length()==7)?bkgNewCodVvdVOs[2].getPodYdCd():"");
				rtnPrdParameter.getPrdMainInfoVO().setPod3C (bkgNewCodVvdVOs[2].getPodClptIndSeq());
				rtnPrdParameter.getPrdMainInfoVO().setPol3  (bkgNewCodVvdVOs[2].getPolYdCd().substring(0,5));
				rtnPrdParameter.getPrdMainInfoVO().setPol3N((bkgNewCodVvdVOs[2].getPolYdCd().length()==7)?bkgNewCodVvdVOs[2].getPolYdCd():"");
				rtnPrdParameter.getPrdMainInfoVO().setPol3C (bkgNewCodVvdVOs[2].getPolClptIndSeq());
				rtnPrdParameter.getPrdMainInfoVO().setVvd3  (bkgNewCodVvdVOs[2].getVslCd()
														    +bkgNewCodVvdVOs[2].getSkdVoyNo()
														    +bkgNewCodVvdVOs[2].getSkdDirCd());
				rtnPrdParameter.getPrdMainInfoVO().setLane3(util.searchSvcLaneByVvd(rtnPrdParameter.getPrdMainInfoVO().getVvd3()));
			}else{
				rtnPrdParameter.setPrdMainInfoVO(util.resetNthRoute(rtnPrdParameter.getPrdMainInfoVO(), 3));
			}
			if (bkgNewCodVvdVOs.length>3){
				rtnPrdParameter.getPrdMainInfoVO().setPod4  (bkgNewCodVvdVOs[3].getPodYdCd().substring(0,5));
				rtnPrdParameter.getPrdMainInfoVO().setPod4N((bkgNewCodVvdVOs[3].getPodYdCd().length()==7)?bkgNewCodVvdVOs[3].getPodYdCd():"");
				rtnPrdParameter.getPrdMainInfoVO().setPod4C (bkgNewCodVvdVOs[3].getPodClptIndSeq());
				rtnPrdParameter.getPrdMainInfoVO().setPol4  (bkgNewCodVvdVOs[3].getPolYdCd().substring(0,5));
				rtnPrdParameter.getPrdMainInfoVO().setPol4N((bkgNewCodVvdVOs[3].getPolYdCd().length()==7)?bkgNewCodVvdVOs[3].getPolYdCd():"");
				rtnPrdParameter.getPrdMainInfoVO().setPol4C (bkgNewCodVvdVOs[3].getPolClptIndSeq());
				rtnPrdParameter.getPrdMainInfoVO().setVvd4  (bkgNewCodVvdVOs[3].getVslCd()
														    +bkgNewCodVvdVOs[3].getSkdVoyNo()
														    +bkgNewCodVvdVOs[3].getSkdDirCd());
				rtnPrdParameter.getPrdMainInfoVO().setLane4(util.searchSvcLaneByVvd(rtnPrdParameter.getPrdMainInfoVO().getVvd4()));
			}else{
				rtnPrdParameter.setPrdMainInfoVO(util.resetNthRoute(rtnPrdParameter.getPrdMainInfoVO(), 4));
			}
			rtnPrdParameter.getPrdMainInfoVO().setOrgTrnsMode("");
			rtnPrdParameter.getPrdMainInfoVO().setDestTrnsMode("");
			// PrdQuantityVO Set
			List<PrdQtyInfoVO> prdQtyInfo 	= new ArrayList<PrdQtyInfoVO>();
			if (event.getCodVO().getCodCntrVO()!=null){ 
				String tpsz[] = new String [event.getCodVO().getCodCntrVO().size()];
				int    qty[]  = new int    [event.getCodVO().getCodCntrVO().size()];
				
				for(int idx=0; idx<event.getCodVO().getCodCntrVO().size(); idx++){
					for(int j=0;j<tpsz.length;j++){
						if(tpsz[j]==null){
							tpsz[j] = event.getCodVO().getCodCntrVO().get(idx).getCntrTpszCd();
							qty[j]++;
							break;
						} else if(tpsz[j].equals(event.getCodVO().getCodCntrVO().get(idx).getCntrTpszCd())){
							qty[j]++;
							break;							
						}
					}
				}
				for(int idx=0; idx<tpsz.length;idx++){
					if(tpsz[idx]==null) continue;
					PrdQtyInfoVO prdQtyInfoVO = new PrdQtyInfoVO();
					prdQtyInfoVO.setCTpsz(tpsz[idx]);
					prdQtyInfoVO.setCQty (qty [idx]+"");
					log.debug("\ntpsz:["+prdQtyInfoVO.getCTpsz()+"]\nqty:["+prdQtyInfoVO.getCQty());
					prdQtyInfo.add(prdQtyInfoVO);					
				}
			}
			
			rtnPrdParameter.getPrdMainInfoVO().setTVvd(""); //2016/11/15 Stop to set Trunk VVD
			
	    	String pctlNo="";
	    	util.prdParameterLog(rtnPrdParameter.getPrdMainInfoVO());
	    	
	    	try{
	    		pctlNo=prdBC.createPrdCtlgRout(rtnPrdParameter, account);
	    		commit();
	    	} catch (Exception prdEx){
				eventResponse.setETCData("IsPctlNoPop", "Y");
				eventResponse.setETCData("pctl_no", "");
				eventResponse.setETCData("map_seq", "");
				
				eventResponse.setETCData(rtnPrdParameter.getPrdMainInfoVO().getColumnValues());	
				eventResponse.setRsVoList(null);	
				eventResponse.setRsVoList(null);	
				eventResponse.setRsVoList(rtnPrdParameter.getPrdQtyInfo());	
				
				log.error(prdEx);
				rollback();
				return eventResponse;
	    	}
	    	
	    	if(pctlNo!=null && pctlNo.length()>0 && !"FAIL".equals(pctlNo.trim())){
	    		event.getBkgBlNoVO().setPctlNo(pctlNo);
	    		eventResponse = (GeneralEventResponse)searchRehandlingPort(event);
	    	} else {
				eventResponse.setETCData("IsPctlNoPop", "Y");
				eventResponse.setETCData("pctl_no", "");
				eventResponse.setETCData("map_seq", "");
				
				eventResponse.setETCData(rtnPrdParameter.getPrdMainInfoVO().getColumnValues());	
				eventResponse.setRsVoList(null);	
				eventResponse.setRsVoList(null);	
				eventResponse.setRsVoList(rtnPrdParameter.getPrdQtyInfo());	
				
				log.debug("Pctl Pop Up Call");
				rollback();
				return eventResponse;	    		
	    	}
			
	    	return eventResponse;
    	} catch(EventException se) {
			log.error("err " + se.toString(), se);
			throw se;
		} catch(Exception ex) { 
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    }
    
	/**
	 * Starting the C/A, Creating the History temp data(ESM_BKG_0708)<br>
	 * 
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse startCA(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0708Event event = (EsmBkg0708Event)e;
		BDRCorrectionBC         bDRCorrectionBC         = new BDRCorrectionBCImpl();
		BLDocumentationBLBC     bLDocumentationBLBC     = new BLDocumentationBLBCImpl();
		GeneralBookingReceiptBC generalBookingReceiptBC = new GeneralBookingReceiptBCImpl();
		SpecialCargoReceiptBC   specialCargoReceiptBC   = new SpecialCargoReceiptBCImpl();
		BlRatingBC              blRatingBC              = new BlRatingBCImpl();
		BLIssuanceBC            bLIssuanceBC            = new BLIssuanceBCImpl();
		 
		try {
			begin();
			
			String tempHistCd = "T";
			String copyTypeCd = "TEMP";

			//01. createTempHist
			BkgCorrectionVO bkgCorrectionVO = new BkgCorrectionVO();
			bkgCorrectionVO.setCaRsnCd   (event.getCaRsnCD());
			bkgCorrectionVO.setBkgCorrRmk(event.getBkgCorrRmk());
			bkgCorrectionVO.setRdnNo     (event.getRdnNo());
			bkgCorrectionVO.setRvisSeq   (event.getRvisSeq());
			bkgCorrectionVO.setRdnAcptFlg(event.getRdnAcptFlg());
			BkgBlNoVO schBkgBlNoVO = bDRCorrectionBC.createTempHist(event.getBkgBlNoVO(), tempHistCd, bkgCorrectionVO, account);

			//02. modifyCaStart
			bLDocumentationBLBC.modifyCaStart      (schBkgBlNoVO, account);
			
			//03. createBookingCA 
			generalBookingReceiptBC.createBookingCA(schBkgBlNoVO, copyTypeCd);
			
			//04. createBlCA 
			bLDocumentationBLBC.createBlCA         (schBkgBlNoVO, copyTypeCd);
			
			//05. createSpclCA
			specialCargoReceiptBC.createSpclCA     (schBkgBlNoVO, copyTypeCd);
			
			//06. createRateCA
			blRatingBC.createRateCA                (schBkgBlNoVO, copyTypeCd);
			
			//07. createIssCA 
			bLIssuanceBC.createIssCA               (schBkgBlNoVO, copyTypeCd); 
			
			commit();			
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());  //BKG00166 : 저장성공
			
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}				
		return eventResponse;
	}
	
	/**
	 * Completing the COD data after the C/A ended<br>
	 * 
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse completeCodCa(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0156Event event = (EsmBkg0156Event)e;
		try{
			CODCorrectionBC codBC = new CODCorrectionBCImpl();
			codBC.confirmCod(event.getCodRqstSeq(), event.getBkgBlNoVO(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			// Send e-mail (to joint operation shipping company)
			codBC.sendXterCodRqst(event.getCodRqstSeq(), event.getBkgBlNoVO(), account);		
			eventResponse.setETCData(codBC.searchCodRqstEmlCtnt(event.getCodRqstSeq(), event.getBkgBlNoVO(), account).getColumnValues());			
			eventResponse.setETCData("SuccessYn","Y");		
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}	
		return eventResponse;		
	}
	
	/**
	 * (ESM_BKG_0758/ESM_BKG_0769) Searching the CA Kind Code<br>
	 * 
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCaKind(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		BookingUtil command = new BookingUtil();
		
		try{
			List<BkgComboVO> list = command.searchCombo("CD02272");
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}	
		return eventResponse;
	}
	
	/**
	 * (ESM_BKG_0708) Searching the CA Reason Code<br>
	 * 
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCaRsnRmk(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)		
		EsmBkg0708Event 		event = (EsmBkg0708Event)e;
		GeneralEventResponse 	eventResponse	= new GeneralEventResponse();
		BookingUtil   		 	utilBC          = new BookingUtil();
		BDRCorrectionBC 		bDRCorrectionBC = new BDRCorrectionBCImpl();
		
		try {
			//01. 
			CaRsnRmkVO caRsnRmkVO = bDRCorrectionBC.searchCaRsnRmk(event.getBkgBlNoVO(), account); 
			
			Map<String,String> etcData = new HashMap<String,String>();
			HashMap<String,String> hashVO = caRsnRmkVO.getColumnValues();
	        for (Iterator<String> iter = hashVO.keySet().iterator(); iter.hasNext(); ){
	            String key = iter.next();
	            String val = hashVO.get(key);
	            etcData.put(key, JSPUtil.getNullNoTrim(val));
	        }
			eventResponse.setETCData(etcData); 
			
			//02. 
			List<BkgComboVO> listold = utilBC.searchCombo("CD01632");
			List<BkgComboVO> list = new ArrayList<BkgComboVO>();
			for(int i=0;i<listold.size();i++){
				if (!"O".equals(listold.get(i).getVal())&&!"E".equals(listold.get(i).getVal())&&!"F".equals(listold.get(i).getVal())){
					list.add(listold.get(i));
				}
			}
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}

		return eventResponse;
	}
	
	/**
	 * (ESM_BKG_0768) Searching the CA Reason Code<br>
	 * 
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCaReason(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		BookingUtil command = new BookingUtil();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try{
			List<BkgComboVO> list = command.searchCombo("CD01632");
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}	

		return eventResponse;
	}
	
	/**
	 * Modifying the CA Resaon/Remark Info(ESM_BKG_0079)
	 * 
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCaRsnRmk(Event e) throws EventException{
		EsmBkg0708Event event = (EsmBkg0708Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		BDRCorrectionBC bDRCorrectionBC = new BDRCorrectionBCImpl();
		
		try{
			begin(); 
			bDRCorrectionBC.modifyCaReason(event.getCaRsnCD(), event.getBkgCorrRmk(), event.getBkgBlNoVO(), event.getRdnAcptFlg(), account);
			commit();
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());  
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}	
		
		return eventResponse;
	}

	/**
	 * (ESM_BKG_0567) Searching the changed CA list and the basic Info<br>
	 * 
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCaInfoByBkg(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)		
		EsmBkg0567Event event = (EsmBkg0567Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BDRCorrectionBC bDRCorrectionBC = new BDRCorrectionBCImpl();
		
		try {
			CaInfoByBkgVO caInfoByBkgVO = bDRCorrectionBC.searchCaInfoByBkg(event.getBkgBlNoVO()); 
					
	        //01. etcData
			if (caInfoByBkgVO == null || caInfoByBkgVO.getCaBkgInfoVO() == null || 
			    "".equals(JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getBkgNo()))) {
				// No data found.
				eventResponse.setUserMessage(new ErrorHandler("BKG00095").getUserMessage());	
				eventResponse.setETCData("DataYn", "N");
			} else {		
				eventResponse.setETCData("bkg_no",           JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getBkgNo()));
				eventResponse.setETCData("bl_no",            JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getBlNo()));
				eventResponse.setETCData("ca_no",            JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getCaNo()));
				eventResponse.setETCData("cust_cnt_cd",      JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getCustCntCd()));
				eventResponse.setETCData("cust_nm",          JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getCustNm()));
				eventResponse.setETCData("cust_seq",         JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getCustSeq()));
				eventResponse.setETCData("sailed_vvd",       JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getSailedVvd()));
				eventResponse.setETCData("t_vvd",            JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getTVvd()));
				eventResponse.setETCData("por_cd",           JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getPorCd()));
				eventResponse.setETCData("pol_cd",           JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getPolCd()));
				eventResponse.setETCData("del_cd",           JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getDelCd()));
				eventResponse.setETCData("pod_cd",           JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getPodCd()));
				eventResponse.setETCData("por_nod_cd",       JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getPorNodCd()));
				eventResponse.setETCData("pol_nod_cd",       JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getPolNodCd()));
				eventResponse.setETCData("del_nod_cd",       JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getDelNodCd()));
				eventResponse.setETCData("pod_nod_cd",       JSPUtil.getNullNoTrim(caInfoByBkgVO.getCaBkgInfoVO().getPodNodCd()));
				
				//02. list
				eventResponse.setRsVoList(caInfoByBkgVO.getCaListByBkgVOs());
				eventResponse.setETCData("DataYn", "Y");
			}
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}	

		return eventResponse;
	}
	
	/**
	 * (ESM_BKG_0567) Searching the detail Info of the changed CA<br>
	 * 
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCaDetail(Event e) throws EventException {
		EsmBkg0567Event event = (EsmBkg0567Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		BDRCorrectionBC bDRCorrectionBC = new BDRCorrectionBCImpl();
		
		try {
			CaDetailVO caDetailVO = bDRCorrectionBC.searchCaDetail(event.getBkgBlNoVO()); 
	
			eventResponse.setRsVoList(caDetailVO.getCaGeneralVOs());
			eventResponse.setRsVoList(caDetailVO.getCaChargeVOs());
			eventResponse.setRsVoList(caDetailVO.getCaCustVOs());
		}catch(EventException ex){
			throw ex;
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}	
		return eventResponse;
	}
	
	/**
	 * (ESM_BKG_0156) Searching the rehandling Port<br>
	 * 
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unused")
	private EventResponse searchRehandlingPort(Event e) throws EventException {
		EsmBkg0156Event event = (EsmBkg0156Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CODCorrectionBC codBC = new CODCorrectionBCImpl();
		BookingUtil     util  = new BookingUtil();

		try{
			BkgBlNoVO bkgBlNoVO = event.getBkgBlNoVO();
			CodAuthVO codAuthVO = event.getCodAuthVO();
			String    codStsCd  = event.getCodStsCd();
			
			String pctlNoMapSeqStr = bkgBlNoVO.getPctlNo();
			log.error("COD Confirm : pctlNoMapSeqStr = " + bkgBlNoVO.getPctlNo());
			if(pctlNoMapSeqStr.length()>20){
				String [] pctlNoMapSeq = util.splitByToken(pctlNoMapSeqStr, "|");
				
				bkgBlNoVO.setPctlNo(pctlNoMapSeq[0]);
				bkgBlNoVO.setMapSeq(pctlNoMapSeq[1]);
			}	
		
			CodVO codVO = codBC.searchRehandlingPort(bkgBlNoVO, codAuthVO, account); 

			CodRsoVO codRsoVO = codVO.getCodRsoVO();
			String rhndPort = codVO.getBkgCodVO().get(0).getCodRhndPortYdCd();
			String rhndVvd  = codRsoVO.getNewVslCd()+codRsoVO.getNewSkdVoyNo()+codRsoVO.getNewSkdDirCd();
			String codMnlFlg = event.getCodVO().getBkgCodVO().get(0).getCodMnlFlg();
			
			if(codStsCd==null || codStsCd.length()<1 || " ".equals(codStsCd)){

				if(codRsoVO.getOldPolYdCd().substring(0, 5).equals(codRsoVO.getNewPolYdCd().substring(0, 5))
						&& codRsoVO.getOldPodYdCd().substring(0, 5).equals(codRsoVO.getNewPodYdCd().substring(0, 5))){
					String diversionVvd = "";
					for(int i=0;i<codVO.getBkgNewCodVvdVO().size();i++){
						if(rhndPort.equals(codVO.getBkgNewCodVvdVO().get(i).getPolYdCd().substring(0, 5))){
							diversionVvd = codVO.getBkgNewCodVvdVO().get(i).getVslCd() 
										 + codVO.getBkgNewCodVvdVO().get(i).getSkdVoyNo()
										 + codVO.getBkgNewCodVvdVO().get(i).getSkdDirCd();
						}				
					}
					eventResponse.setUserMessage(new ErrorHandler("BKG00982",new String[]{}).getUserMessage());
					codMnlFlg = "Y";
				}
				
				log.debug("pol_port_act_arr_dt:["+codRsoVO.getPolActDepDt()+"]");
				if(codRsoVO.getPolActDepDt()==null || codRsoVO.getPolActDepDt().length()<8){

					String rhndPol = "";
					for(int i=0;i<codVO.getBkgOldCodVvdVO().size();i++){
						if(rhndVvd.equals(codVO.getBkgOldCodVvdVO().get(i).getVslCd() 
										+ codVO.getBkgOldCodVvdVO().get(i).getSkdVoyNo()
										+ codVO.getBkgOldCodVvdVO().get(i).getSkdDirCd())){
							rhndPol = codVO.getBkgOldCodVvdVO().get(i).getPolYdCd();
						}				
					}
					eventResponse.setUserMessage(new ErrorHandler("BKG02040",new String[]{rhndVvd, rhndPol}).getUserMessage());		
					codMnlFlg = "Y";
				}
				log.debug("rhnd_port_act_arr_dt:["+codRsoVO.getRhndPortActArrDt()+"] ," + 
						  "rhnd_port_act_dep_dt:["+codRsoVO.getRhndPortActDepDt()+"]");

				if(codRsoVO.getRhndPortActArrDt()!=null && codRsoVO.getRhndPortActArrDt().length()==8){
					if(codRsoVO.getRhndPortActDepDt()!=null && codRsoVO.getRhndPortActDepDt().length()==8){
						throw new EventException(new ErrorHandler("BKG02045",new String[]{rhndVvd, rhndPort}).getMessage());
					} else {
						eventResponse.setUserMessage(new ErrorHandler("BKG02041",new String[]{rhndVvd, rhndPort}).getUserMessage());	
						codMnlFlg = "Y";						
					}
				}
				
				log.debug("vslSvcTpCd:"+codRsoVO.getVslSvcTpCd());
				if("O".equals(codRsoVO.getVslSvcTpCd())){
					eventResponse.setUserMessage(new ErrorHandler("BKG02039",new String[]{rhndVvd}).getUserMessage());		
					codMnlFlg = "Y";
				}
			}
			eventResponse.setETCData("newPodCd",   (codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewPodCd():"");
			eventResponse.setETCData("newPodNodCd",(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewPodNodCd():"");
			eventResponse.setETCData("newDelCd",   (codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewDelCd():"");
			eventResponse.setETCData("newDelNodCd",(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewDelNodCd():"");
			eventResponse.setETCData("newPreCd",   (codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewPreCd():"");
			eventResponse.setETCData("newPreNodCd",(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewPreNodCd():"");
			eventResponse.setETCData("newPstCd",   (codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewPstCd():"");
			eventResponse.setETCData("newPstNodCd",(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewPstNodCd():"");
			eventResponse.setETCData("newTvvd",    (codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewTvvd():""); 
			eventResponse.setETCData("newDeTermCd",(codVO.getCodEtcVO().size()>0)? codVO.getCodEtcVO().get(0).getNewDeTermCd():"");
			
			eventResponse.setETCData("SuccessYn","Y");
			eventResponse.setETCData("cod_rhnd_port_cd", rhndPort);
			eventResponse.setETCData("cod_mnl_flg", codMnlFlg);
			
			eventResponse.setETCData("rgn_cd", codVO.getCodRsoVO().getRso());
			eventResponse.setETCData("pctl_no", bkgBlNoVO.getPctlNo());
			eventResponse.setETCData("map_seq", bkgBlNoVO.getMapSeq());
			
			List<CodCntrVO> codCntrVOs = codVO.getCodCntrVO();
			for(int i=0;i<codCntrVOs.size();i++){
				eventResponse.setETCData(codCntrVOs.get(i).getCntrNo(), codCntrVOs.get(i).getCntrStwgNo());
			}
			eventResponse.setRsVoList(codVO.getBkgOldCodVvdVO());
			eventResponse.setRsVoList(codVO.getBkgNewCodVvdVO());
			

		}catch(EventException ex){
			throw ex;  			
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  
		}
		return eventResponse;
	}
	
	/**
	 * (ESM_BKG_0156) Modifying the approval manually if NOT under OPF<br>
	 * 
	 * @param     e Event
	 * @return    eventResponse EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCodMnlApprove(Event e) throws EventException {
		EsmBkg0156Event event = (EsmBkg0156Event)e;
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			CODCorrectionBC codBC = new CODCorrectionBCImpl();
			BkgBlNoVO 	bkgBlNoVO   = event.getBkgBlNoVO();
			CodAuthVO 	codAuthVO   = event.getCodAuthVO();
			String 		codRqstSeq  = event.getCodRqstSeq();
			String 		codStsCd    = event.getCodStsCd();
		
			log.debug("sts:"+codStsCd+",mnl flag:"+event.getCodVO().getBkgCodVO().get(0).getCodMnlFlg());

			if("Y".equals(event.getCodVO().getBkgCodVO().get(0).getCodMnlFlg())){
				if("Y".equals(codStsCd)){			//approve
					codAuthVO.setAuthflag("Y");
					codAuthVO.setCodstscd("Y");
					codBC.approveCod(codAuthVO, null, "", account);
				} else if (codStsCd.equals("R")){//request
					codBC.modifyCodStatus(bkgBlNoVO, codRqstSeq, "M", "", account);
					codBC.sendXterCodRqst(codRqstSeq, bkgBlNoVO, account);
				} else if (codStsCd.equals("C")){
		            codBC.modifyCodStatus(bkgBlNoVO, codRqstSeq, "C", "", account);
					codBC.sendXterCodRqst(codRqstSeq, bkgBlNoVO, account);				
				}
				eventResponse.setETCData(codBC.searchCodRqstEmlCtnt(codRqstSeq, bkgBlNoVO, account).getColumnValues());
			}
		}catch(EventException ex){
			throw ex;  			
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  
		}
		return eventResponse;
	}
  
	/**
	 * ESM_BKG_0156 : COD Application<br>
	 * Retrieve EMAIL by RSO, LANE <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCODEmailsendList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0156Event event = (EsmBkg0156Event)e;
		CODCorrectionBC command = new CODCorrectionBCImpl();

		try{
			List<BkgCodInfoVO> list1 = command.searchCODNewOldPODCd(event.getBkgCODMgtConditionVO());
			eventResponse.setRsVoList(list1);
			List<BkgCodInfoVO> list2 = command.searchCODEmailsendList(event.getBkgCODMgtConditionVO());
			if(list2 != null && list2.size() > 0){
				eventResponse.setETCData("picEml", ((BkgCodInfoVO)list2.get(0)).getPicEml());
			}
			Map<String, String> etcData = new HashMap<String, String>();
			
			etcData.put("carrierCd", ((BkgCodInfoVO)list1.get(0)).getCarrierCd());
			etcData.put("vslEngNm", ((BkgCodInfoVO)list1.get(0)).getVslEngNm());
			etcData.put("obCssmVoyNm", ((BkgCodInfoVO)list1.get(0)).getObCssmVoyNo());
			etcData.put("oldPolFullNm", ((BkgCodInfoVO)list1.get(0)).getOldPolFullNm());
			etcData.put("oldPodFullNm", ((BkgCodInfoVO)list1.get(0)).getOldPodFullNm());
			etcData.put("newPodFullNm", ((BkgCodInfoVO)list1.get(0)).getNewPodFullNm());
			etcData.put("emlDt", ((BkgCodInfoVO)list1.get(0)).getEmlDt());
			
			eventResponse.setETCData(etcData);
			

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}		
		return eventResponse;
	}
	/**
	 * ESM_BKG_0156 : COD Application<br>
	 * Send Email <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendCODEmail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0156Event event = (EsmBkg0156Event)e;
		CodMailSendVO codMailSendVO = null;
		CODCorrectionBC command = null;
//		CodVO codVO = null;
		
		try{
			begin();
			command = new CODCorrectionBCImpl();
			codMailSendVO = event.getCodMailSendVO();
			if ("CD".equalsIgnoreCase(codMailSendVO.getEdtNtcKndCd())){
				command.sendCODEmail(codMailSendVO, account);
			}
			commit();
			eventResponse.setETCData("SuccessYn", "Y");
			return eventResponse;
		}catch(EventException ex){
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);  			
		}	
	}	
	/**
	 * ESM_BKG_0156 : COD Application<br>
	 * Search Recipient <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchRecipient(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0156Event event = (EsmBkg0156Event)e;
		CODCorrectionBC command = new CODCorrectionBCImpl();

		try{
			List<BkgCodInfoVO> list = command.searchCODEmailsendList(event.getBkgCODMgtConditionVO());
			if(list != null && list.size() > 0){
				eventResponse.setETCData("picEml", ((BkgCodInfoVO)list.get(0)).getPicEml());
			}

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12203", new String[]{"COD Approval Detail at RSO Office"}).getMessage(), ex);
		}		
		return eventResponse;
	}	
}