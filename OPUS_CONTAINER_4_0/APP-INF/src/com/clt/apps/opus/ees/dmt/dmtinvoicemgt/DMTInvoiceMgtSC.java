/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : DMTInvoiceMgtSC.java
*@FileTitle : Invoice Creation & Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009.08.05 김태균
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.EDIVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBC;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.basic.CommonFinderBCImpl;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.ARCurrencyVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CommonCodeVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CoverageVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.CurrencyVO;
import com.clt.apps.opus.ees.dmt.dmtcommon.commonfinder.vo.TariffNameVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChrgDtlVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.VVDNEtaVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.basic.DemandNoteSendBC;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.basic.DemandNoteSendBCImpl;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.event.EesDmt3007Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.event.EesDmt3013Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.event.EesDmt3108Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.event.EesDmt3109Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteByBookingVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteGroupListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNoteListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewEtcVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewMstVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.demandnotesend.vo.DemandNotePreviewParmVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBC;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4001Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4002Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4003Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4004Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4006Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4007Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4008Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4009Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4011Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4013Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4016Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4101Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4103Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4104Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4105Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt4106Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt5001Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt5002Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt5003Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt5101Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.event.EesDmt7006Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration.InvoiceIssueCollectionMgtDBDAO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ARInterfaceStatusVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ChargeBookingInvoiceVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ConfirmChargeListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtCommonReturnDataVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtFaxEmlSndHisVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvDtlVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvMnVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtInvRtVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtPayrCntcPntVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.DmtPayrInfoVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.EDIContainerVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.FAXEmailByPayerVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceGroupMgtVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceGroupParamVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARByDetailVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceInterfaceARBySummaryVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMasterPreviewVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueMgtVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.IssuedInvoiceListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssueVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceIssuedListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualInvoiceSummaryVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualKeyByBookingVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ManualKeyByChargeVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetial2VO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetial3VO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryByDetialVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.OtsInquiryBySummaryVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.PayerInformationVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SearchIndiaGstRateVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.SheetOptionMasterSetVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.VVDCheckDataVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.usdemurrageaudit.basic.USDemurrageAuditBC;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.usdemurrageaudit.basic.USDemurrageAuditBCImpl;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.usdemurrageaudit.event.EesDmt4005Event;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.usdemurrageaudit.vo.ChargeForAuditVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.basic.GeneralARInvoiceCreationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.vo.ARInterfaceCreationVO;
import com.clt.framework.component.backend.support.BackEndJobResult;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * InvoiceMgt Business Logic ServiceCommand - InvoiceMgt handling business transaction.
 * 
 * @author Kim Tae Kyun
 * @see InvoiceIssueCollectionMgtDBDAO
 * @since J2EE 1.6
 */

public class DMTInvoiceMgtSC extends ServiceCommandSupport {
    // Login User Information
    private SignOnUserAccount account = null;

    /**
     * InvoiceMgt system preceding process for biz scenario<br>
     * related objects creation<br>
     */
    public void doStart() {
        log.debug("DMTInvoiceMgtSC 시작");
        try {
            account = getSignOnUserAccount();
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
    }

    /**
     * InvoiceMgt system biz scenario closing<br>
     * clearing related objects<br>
     */
    public void doEnd() {
        log.debug("DMTInvoiceMgtSC 종료");
    }

    /**
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;

        if (e.getEventName().equalsIgnoreCase("EesDmt4001Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchChargeInvoiceList(e);
            }else{
		    	eventResponse = searchCurrentDateByOffice();
	        }
        }else if(e.getEventName().equalsIgnoreCase("EesDmt4002Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchChargeInvoice(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchIssuedInvoice(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchExchangeRate(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = issueInvoice(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = modifyInvoice(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
                eventResponse = createInvoiceData(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
                eventResponse = searchFAXEmailByPayer(e);
            }
            
        }
        else if(e.getEventName().equalsIgnoreCase("EesDmt4003Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchInvoiceIssueMasterPreview(e);
            }
        }
        else if(e.getEventName().equalsIgnoreCase("EesDmt4004Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchManualInvoiceByBooking(e);
            } 
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchManualKeyByBooking(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = checkContainerNo(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = checkCallingPort(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchExchangeRate(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
                eventResponse = checkVVD(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH07)) {
                eventResponse = searchChargeCurrency(e);
            }             
            else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
            	eventResponse = issueInvoiceByManual(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
            	eventResponse = modifyInvoiceByManual(e);
            }       
            else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
            	eventResponse = createInvoiceData(e);
            }
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchInvoiceInitControls(e);
			}            
        }        
        else if(e.getEventName().equalsIgnoreCase("EesDmt4009Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchOTSInquiryBySummaryList(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EesDmt4005Event")) {
            if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = searchChargeForAudit(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EesDmt5001Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchARInterfaceStatusByDMT(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchARInterfaceStatusByBKG(e);
            } 
        } else if (e.getEventName().equalsIgnoreCase("EesDmt5002Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchInvoiceInterfaceARBySummary(e);
            }   
        } else if (e.getEventName().equalsIgnoreCase("EesDmt5003Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchInvoiceInterfaceARByDetail(e);
            }else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
                eventResponse = createInvoiceData(e);
            }   
        } else if(e.getEventName().equalsIgnoreCase("EesDmt4011Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchOTSInquiryByDetailList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchOTSInquiryByDetailListRemark(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = updateOTSInquiryByDetailListRemark(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchOTSInquiryByDetailListRemark2(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = searchOTSInquiryByDetailList2(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = searchOTSInquiryByDetailList3(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EesDmt3013Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchDemandChargeList(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EesDmt3109Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchDemandNoteByBooking(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EesDmt3108Event")) {
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//office별 Tax Rate
                eventResponse = searchDemandEnvironmentByOffice(e);
            } else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
            	eventResponse = searchDemandNoteByGroup(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EesDmt4105Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchInvoiceRemark(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchOTSRemark(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = modifyInvoiceRemark(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = modifyOTSRemark(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EesDmt4101Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchSheetSet(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = saveSheetSet(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = removeSheetSet(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EesDmt4103Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchSheetOption(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageSheetOption(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EesDmt4006Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchManualInvoiceBySummaryList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchManuaLInvoiceReasonList();
            } 
        } else if(e.getEventName().equalsIgnoreCase("EesDmt4007Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchManualInvoiceByDetailList(e);
            }
	    } else if(e.getEventName().equalsIgnoreCase("EesDmt4008Event")) {
	    	
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchIssuedInvoiceList(e);
	        }else{
		    	//처음 로딩
		    	eventResponse = searchCurrentDateByOffice();
	        }
	    }else if(e.getEventName().equalsIgnoreCase("EesDmt4106Event")) {
	        if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
	            eventResponse = searchCancelReason(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = cancelInvoice(e);
	        }
	    } else if(e.getEventName().equalsIgnoreCase("EesDmt5101Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchHoldReasonCdList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchHoldReason(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = modifyInvoiceByHold(e);
            }
        } else if ( e.getEventName().equalsIgnoreCase("EesDmt7006Event") ) {
            if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
                eventResponse = searchFaxEmailHistory(e);
            }
        } else if ( e.getEventName().equalsIgnoreCase("EesDmt4104Event")) {
        	if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
                eventResponse = searchPayerInformation(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01) ) {
                eventResponse = searchPayerName(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST02) ) {
                eventResponse = searchPayerAddress(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST03) ) {
                eventResponse = searchPayerContactPointName(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST04) ) {
                eventResponse = searchPayerPhoneNo(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST05) ) {
                eventResponse = searchPayerFaxNo(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST06) ) {
                eventResponse = searchPayerEmail(e);
        	}else if (e.getFormCommand().isCommand(FormCommand.MULTI) ) {
                eventResponse = managePayerInformation(e);
            }
        } else if ( e.getEventName().equalsIgnoreCase("EesDmt4013Event")) {
        	if ( e.getFormCommand().isCommand(FormCommand.SEARCH) ) {
                eventResponse = searchEnvironmentByOffice(e);
        	}else if ( e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
        		eventResponse = searchBookingContainerCount(e);
        	}else if ( e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
        		eventResponse = searchChargeByBooking(e);
            }else if ( e.getFormCommand().isCommand(FormCommand.MULTI) ) {		//Save
            	eventResponse = issueInvoiceByGroup(e);
            }else if ( e.getFormCommand().isCommand(FormCommand.COMMAND01) ) {	//A/R-I/F
            	eventResponse = createInvoiceData(e);
            }else if ( e.getFormCommand().isCommand(FormCommand.COMMAND02) ) {	//BackEndJob
            	eventResponse = doBackEndJob(e);
            }else if ( e.getFormCommand().isCommand(FormCommand.COMMAND03) ) {	//BackEndJob
            	eventResponse = checkBackEndJob(e);
            }
        	
        } else if (e.getEventName().equalsIgnoreCase("EesDmt3007Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchDemandNoteIssuePreview(e);
            }
        } else if(e.getEventName().equalsIgnoreCase("EesDmt4016Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
            	eventResponse = searchChargeInvoiceBySZPBB(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchIssuedInvoiceBySZPBB(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
                eventResponse = searchExchangeRate(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = issueInvoiceBySZPBB(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = modifyInvoice(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
                eventResponse = createInvoiceData(e);
            }
        } 
        
        return eventResponse;
    }
    /**
     * EES_DMT_4001 : Retrieve<br>
     * Retrieving Invoice Create & Issue.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchChargeInvoiceList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4001Event event = (EesDmt4001Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

        try{
            List<ConfirmChargeListVO> list = command.searchChargeInvoiceList(event.getIssuedInvoiceParamVO(), account);
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
     * EES_DMT_4002 : Retrieve<br>
     * Retrieving Invoice Create & Issue.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchChargeInvoice(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4002Event event = (EesDmt4002Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        ChargeCalculationBC commandChrge 	= new ChargeCalculationBCImpl();
        
        try{
        	VVDCheckDataVO vVDCheckDataVO = command.searchVVDCheckData(event.getIssuedInvoiceParamVO());
        	
        	if(!vVDCheckDataVO.getBkgNo().equals("")) {
	        	//2.modifyBookingContainerVVD
	        	commandChrge.modifyBookingContainerVVD(vVDCheckDataVO);
        	}
            InvoiceIssueMgtVO invoiceIssueMgtVO = command.searchChargeInvoice(event.getIssuedInvoiceParamVO(), account);
            
            List<InvoiceIssueVO> list = invoiceIssueMgtVO.getInvoiceIssueVOs();
            ChargeBookingInvoiceVO chargeBookingInvoiceVO = invoiceIssueMgtVO.getChargeBookingInvoiceVO();
            //=========================================
            //2015.10.27 #7995 comment start
            //2017.01.12 #23259 India Invoice
            //4. 인도인 경우 GST 관련 Tax rate를 조회. (2012.05.22 Kim hyunhwa)
            if(event.getIssuedInvoiceParamVO().getUsrCntCd().equals("IN")){
               String iss_dt ="" ;
               SearchIndiaGstRateVO indiaGstRateVO = command.searchIndiaGstRate(iss_dt);
               chargeBookingInvoiceVO.setIdaExpnTaxRt(indiaGstRateVO.getIdaExpnTaxRt());
               chargeBookingInvoiceVO.setIdaEduTaxRt(indiaGstRateVO.getIdaEduTaxRt());
               chargeBookingInvoiceVO.setIdaHighEduTaxRt(indiaGstRateVO.getIdaHighEduTaxRt());
            }
            //2015.10.27 #7995 comment e n d
            //=========================================
            eventResponse.setRsVoList(list);
            eventResponse.setETCData(chargeBookingInvoiceVO.getColumnValues());
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
    * EES_DMT_4009 : [Search]<br>
    * Retrieving Outstanding Inquiry by Customer N Issue.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSInquiryBySummaryList (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4009Event event = (EesDmt4009Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try {
	        List<OtsInquiryBySummaryVO> list = command.searchOTSInquiryBySummaryList ( event.getOtsInquiryParmVO() );
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        
        return eventResponse;
    }
    
   /**
    * EES_DMT_4005 : [Retrieve]<br>
    * Retrieving 3rd Party DEM/DET Collection Audit.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchChargeForAudit(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4005Event event = (EesDmt4005Event)e;
        USDemurrageAuditBC command = new USDemurrageAuditBCImpl();

        try{
            List<ChargeForAuditVO> list = command.searchChargeForAudit(event.getChargeForAuditParmVOS());
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
    * EES_DMT_5001_1 : [Retrieve]<br>
    * Retrieving TAB1:A/R Interface Status Inquiry By DMT.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchARInterfaceStatusByDMT(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt5001Event event = (EesDmt5001Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

        try{
            List<ARInterfaceStatusVO> list = command.searchARInterfaceStatusByDMT(event.getARInterfaceParmVO());
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
    * EES_DMT_5001_2 : [Retrieve]<br>
    * Retrieving TAB2:A/R Interface Status Inquiry By BKG.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchARInterfaceStatusByBKG(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt5001Event event = (EesDmt5001Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

        try{
            List<ARInterfaceStatusVO> list = command.searchARInterfaceStatusByBKG(event.getARInterfaceParmVO());
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
    * EES_DMT_5002 : [Retrieve]<br>
    * Retrieving Invoice Interface to A/R.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchInvoiceInterfaceARBySummary(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt5002Event event = (EesDmt5002Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

        try{
            List<InvoiceInterfaceARBySummaryVO> list = command.searchInvoiceInterfaceARBySummary(event.getInvoiceInterfaceARParmVO());
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
    * EES_DMT_5003 : [Retrieve]<br>
    * Retrieving Invoice Interface to A/R - Detail.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchInvoiceInterfaceARByDetail(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt5003Event event = (EesDmt5003Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

        try{
            List<InvoiceInterfaceARByDetailVO> list = command.searchInvoiceInterfaceARByDetail(event.getInvoiceInterfaceARParmVO(), account);
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
    * EES_DMT_4011 : [Search]<br>
    * Retrieving Outstanding Inquiry by Customer N Issue - Detail(s).<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSInquiryByDetailList (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4011Event event = (EesDmt4011Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
	        List<OtsInquiryByDetialVO> list = command.searchOTSInquiryByDetailList ( event.getOtsInquiryParmVO() );
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
    * EES_DMT_4011 : [Search]<br>
    * Retrieving Outstanding Inquiry by Customer N Issue - Detail(s).<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSInquiryByDetailList2 (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4011Event event = (EesDmt4011Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
	        List<OtsInquiryByDetial2VO> list = command.searchOTSInquiryByDetailList2 ( event.getOtsInquiryParmVO() );
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * EES_DMT_4002 : [SAVE]<br>
     * Saving Invoice Create & Issue<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse issueInvoice(Event e) throws EventException {

        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
        ChargeCalculationBC commandChrge 		= new ChargeCalculationBCImpl();
        GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueMgtVO invoiceIssueMgtVO 	= new InvoiceIssueMgtVO();
        ChargeBookingInvoiceVO chargeBookingInvoiceVO = new ChargeBookingInvoiceVO();
        List<InvoiceIssueVO> list		= null;
        
        boolean chg_loc_div_cd_flag = false;
        List<InvoiceIssueVO> invoiceIssueList 	= null;
        VVDCheckDataVO vVDCheckDataVO 			= new VVDCheckDataVO();
        VVDNEtaVO vVDNEtaVO 					= new VVDNEtaVO();
        
        
        DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
        Map<String,String> etcData = new HashMap<String,String>();

        //EesDmt4002Event event = (EesDmt4002Event)e;
        invoiceIssueMgtVO.setChargeBookingInvoiceVO(((EesDmt4002Event)e).getChargeBookingInvoiceVO());
        invoiceIssueMgtVO.setInvoiceIssueVOs(((EesDmt4002Event)e).getInvoiceIssueVOs());
        
        //
        chargeBookingInvoiceVO = invoiceIssueMgtVO.getChargeBookingInvoiceVO();
        list = invoiceIssueMgtVO.getInvoiceIssueVOs();
        
        try{
            
            begin();
            ///////////////////////////////////////////////////////////////////////////////////////////////
        	invoiceIssueList = invoiceIssueMgtVO.getInvoiceIssueVOs();
            for(int i = 0 ; i < invoiceIssueList.size() ; i++) {
                InvoiceIssueVO invoiceIssueParam = (InvoiceIssueVO)invoiceIssueList.get(i);
                log.debug("=====IB_FLAG=========> "+invoiceIssueParam.getIbflag());
                
                if(!invoiceIssueParam.getIbflag().equals("U")){
                	continue;
                }
                
                log.debug("=====DMDT_CHG_LOC_DIV_CD=========> "+invoiceIssueParam.getDmdtChgLocDivCd());
                
                if(invoiceIssueParam.getDmdtChgLocDivCd().equals("TSP") && invoiceIssueParam.getOfcTrnsFlg().equals("N")){
                	chg_loc_div_cd_flag = true;
                	break;
                }else if(invoiceIssueParam.getDmdtChgLocDivCd().equals("SZP")){
                	chg_loc_div_cd_flag = true;
                	break;
                }
                
            }
            if(!chg_loc_div_cd_flag) {
            	vVDCheckDataVO.setBkgNo(invoiceIssueMgtVO.getChargeBookingInvoiceVO().getBkgNo());
            	vVDCheckDataVO.setPodCd(invoiceIssueMgtVO.getChargeBookingInvoiceVO().getPodCd());
            	vVDCheckDataVO.setPolCd(invoiceIssueMgtVO.getChargeBookingInvoiceVO().getPolCd());
            	vVDCheckDataVO.setIoBnd(invoiceIssueMgtVO.getChargeBookingInvoiceVO().getDmdtTrfCd().substring(2,3));
            	
            	if(!vVDCheckDataVO.getBkgNo().equals("")
                		&& !vVDCheckDataVO.getPodCd().equals("")
                		&& !vVDCheckDataVO.getPolCd().equals("")
                		&& !vVDCheckDataVO.getIoBnd().equals("")
                		) 
                {

	                // searchVVDNEta
	            	vVDNEtaVO = command.searchIssueInvoiceVVD(vVDCheckDataVO);
	                
	            	
	                if(vVDNEtaVO != null) 
	                {
	                	if(vVDNEtaVO.getVslCd() != null && vVDNEtaVO.getVslCd().length() > 0
	                			&& vVDNEtaVO.getSkdVoyNo() != null && vVDNEtaVO.getSkdVoyNo().length() > 0
	                			&& vVDNEtaVO.getSkdDirCd() != null && vVDNEtaVO.getSkdDirCd().length() > 0 )
	                	{
	                	
		                    //DMT_CHG_BKG_CNTR update
		                    commandChrge.modifyBookingContainerVVD(vVDCheckDataVO);	
		                    
		                    log.debug("=========== vsl_cd ==>"+vVDNEtaVO.getVslCd());
		                    log.debug("=========== skd_voy_no ==>"+vVDNEtaVO.getSkdVoyNo());
		                    log.debug("=========== skd_dir_cd ==>"+vVDNEtaVO.getSkdDirCd());
		
		                	chargeBookingInvoiceVO.setVslCd(vVDNEtaVO.getVslCd());
		                	chargeBookingInvoiceVO.setSkdVoyNo(vVDNEtaVO.getSkdVoyNo());
		                	chargeBookingInvoiceVO.setSkdDirCd(vVDNEtaVO.getSkdDirCd());
		                	chargeBookingInvoiceVO.setVvdCd(vVDNEtaVO.getVslCd()+vVDNEtaVO.getSkdVoyNo()+vVDNEtaVO.getSkdDirCd());
		
		                    log.debug("=========== chargeBookingInvoiceVO.vsl_cd ==>"+chargeBookingInvoiceVO.getVslCd());
		                    log.debug("=========== chargeBookingInvoiceVO.skd_voy_no ==>"+chargeBookingInvoiceVO.getSkdVoyNo());
		                    log.debug("=========== chargeBookingInvoiceVO.skd_dir_cd ==>"+chargeBookingInvoiceVO.getSkdDirCd());
		                	
		                    invoiceIssueMgtVO.setChargeBookingInvoiceVO(chargeBookingInvoiceVO);	//invoice Setting
	                	}
	                }
                }
            }
            
            /////////////////////////////////////////////////////////////////////////////////////////////////
            
            dmtInvMnVO = command.issueInvoice(invoiceIssueMgtVO, account);
            
            log.debug("\n invoice_no == > "+dmtInvMnVO.getDmdtInvNo());
            
            chargeBookingInvoiceVO.setDmdtInvNo(dmtInvMnVO.getDmdtInvNo());
            
            invoiceIssueMgtVO.setChargeBookingInvoiceVO(chargeBookingInvoiceVO);
            invoiceIssueMgtVO.setInvoiceIssueList(list);
            
            if(dmtInvMnVO.getErrCode().equals("DMT03064")){//성공
                commandChrge.changeChargeStatusForInvoice(invoiceIssueMgtVO, account);
                
                etcData.put("INVOICE_NO", dmtInvMnVO.getDmdtInvNo());
                etcData.put("CRE_OFC_CD", dmtInvMnVO.getCreOfcCd());
                etcData.put("SUCCESS_YN", "Y");
                eventResponse.setETCData(etcData);
            	eventResponse.setUserMessage(new ErrorHandler(dmtInvMnVO.getErrCode()).getUserMessage());
                commit();

            }else{
            	if(dmtInvMnVO.getErrCode().equals("DMT01068")){//It's already invoiced. You can't [Value] it !
            		String message = new ErrorHandler("DMT01068").getUserMessage();
            		message = JSPUtil.replace(message, "[Value]", "Save");
            		
            		log.error("\n SC ERROR [DMT01068] == > "+message);
	            	eventResponse.setUserMessage(message);
            	}else if(dmtInvMnVO.getErrCode().equals("DMT02002")){ 
            		String message = new ErrorHandler("DMT02002").getUserMessage();
            		message = JSPUtil.replace(message, "XXX", "INV Cur.");
            		log.error("\n SC ERROR [DMT02002] == > "+message);
	            	eventResponse.setUserMessage(message);
            	}else{
            		log.error("\n SC ERROR ["+dmtInvMnVO.getErrCode()+"] == > "+new ErrorHandler(dmtInvMnVO.getErrCode()).getUserMessage());
	            	eventResponse.setUserMessage(new ErrorHandler(dmtInvMnVO.getErrCode()).getUserMessage());
            	}

                etcData.put("SUCCESS_YN", "N");
                eventResponse.setETCData(etcData);
                eventResponse.setRsVoList(list);
            	rollback();
            }
        } catch(EventException ex) {
    		log.error("\n SC EventException ERROR == > "+ex.getMessage());
            etcData.put("SUCCESS_YN", "N");
            eventResponse.setETCData(etcData);
            eventResponse.setRsVoList(list);
            rollback();
            throw new EventException(ex.getMessage(), ex);
        } catch(Exception ex){
    		log.error("\n SC Exception ERROR == > "+ex.getMessage());
            etcData.put("SUCCESS_YN", "N");
            eventResponse.setETCData(etcData);
            eventResponse.setRsVoList(list);
            rollback();
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse;           
    }
    
    
    /**
    * EES_DMT_4011 : [Search]<br>
    * Retrieving Outstanding Inquiry by Customer N Issue - Detail(s).<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSInquiryByDetailListRemark (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4011Event event = (EesDmt4011Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        Map<String,String> etcData 			= new HashMap<String,String>();
        try {
	        String rtnRemark = command.searchOTSInquiryByDetailListRemark ( event.getOtsInquiryParmVO() );
	        etcData.put("rtnRemark",rtnRemark);
	        eventResponse.setETCData(etcData);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
    * EES_DMT_4011 : [Search]<br>
    * Retrieving Outstanding Inquiry by Customer N Issue - Detail(s).<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSInquiryByDetailListRemark2 (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4011Event event = (EesDmt4011Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        Map<String,String> etcData 			= new HashMap<String,String>();
        try {
	        String rtnRemark = command.searchOTSInquiryByDetailListRemark2 ( event.getOtsInquiryParmVO() );
	        etcData.put("rtnRemark",rtnRemark);
	        eventResponse.setETCData(etcData);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }    
    
    /**
    * EES_DMT_4011 : [UPDATE]<br>
    * Updating Outstanding Inquiry by Customer N Issue - Detail(s) REMARK.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse updateOTSInquiryByDetailListRemark(Event e) throws EventException {
    
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4011Event event = (EesDmt4011Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        try{
            begin();            
            String rtnRemark = command.updateOTSInquiryByDetailListRemark ( event.getOtsInquiryParmVO() , account);
            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            eventResponse.setETCData("rtnRemark" , rtnRemark);
            commit(); 
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
    
    /**
     * EES_DMT_4002 : Retrieve<br>
     * Retrieving Invoice Create & Issue<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchIssuedInvoice(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4002Event event = (EesDmt4002Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

        try{
            InvoiceIssueMgtVO invoiceIssueMgtVO = command.searchIssuedInvoice(event.getIssuedInvoiceParamVO());
            
            List<InvoiceIssueVO> list = invoiceIssueMgtVO.getInvoiceIssueVOs();
            ChargeBookingInvoiceVO chargeBookingInvoiceVO = invoiceIssueMgtVO.getChargeBookingInvoiceVO();
            
            eventResponse.setRsVoList(list);
            eventResponse.setETCData(chargeBookingInvoiceVO.getColumnValues());
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
     * EES_DMT_4002 : Save<br>
     * Saving Invoice Create & Issue<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse modifyInvoice(Event e) throws EventException {
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
        ChargeCalculationBC commandChrge 		= new ChargeCalculationBCImpl();
        GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueMgtVO invoiceIssueMgtVO 	=  new InvoiceIssueMgtVO();
        
        DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
        Map<String,String> etcData          	= new HashMap<String,String>();

        
        try{
            //EesDmt4002Event event = (EesDmt4002Event)e;
        	
        	if(e instanceof EesDmt4002Event) {
	            invoiceIssueMgtVO.setChargeBookingInvoiceVO(((EesDmt4002Event)e).getChargeBookingInvoiceVO());
	            invoiceIssueMgtVO.setInvoiceIssueVOs(((EesDmt4002Event)e).getInvoiceIssueVOs());
        	} else if(e instanceof EesDmt4016Event) {
        		invoiceIssueMgtVO.setChargeBookingInvoiceVO(((EesDmt4016Event)e).getChargeBookingInvoiceVO());
 	            invoiceIssueMgtVO.setInvoiceIssueVOs(((EesDmt4016Event)e).getInvoiceIssueVOs());
        	}
        	
            begin();
            dmtInvMnVO = command.modifyInvoice(invoiceIssueMgtVO, account);
            
            if(dmtInvMnVO.getErrCode().equals("0")) {	//성공
            	if(e instanceof EesDmt4002Event) {
                    commandChrge.changeTruckerForInvoice(invoiceIssueMgtVO, account);
            	}
            	
            	
                etcData.put("SUCCESS_YN", "Y");
                eventResponse.setETCData(etcData);
                eventResponse.setUserMessage(new ErrorHandler("DMT03065").getUserMessage());
                commit(); 
            }else{
            	etcData.put("SUCCESS_YN", "N");
            	eventResponse.setETCData(etcData);
            	eventResponse.setUserMessage(new ErrorHandler(dmtInvMnVO.getErrCode()).getUserMessage());
            	rollback();
            }
        } catch(EventException ex) {
            rollback();
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        }catch(Exception ex){
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }   
        return eventResponse;           
    }    
    
    /**
     * EES_DMT_4002 : inv_cur onchange Event<br>
     * Retrieving Exchange Rate.<br>
     * 
     * @param ExchangeRateParmVO exchangeRateParmVO
     * @return double
     * @exception EventException
     */
    private EventResponse searchExchangeRate(Event e) throws EventException {
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        Map<String,String> etcData          = new HashMap<String,String>();
        
        try{
        	double dResult = 0.0d;
        	
            if(e instanceof EesDmt4002Event) {
				dResult = command.searchExchangeRate(((EesDmt4002Event)e).getChargeBookingInvoiceVO());
			} 
            else if(e instanceof EesDmt4004Event) {
				dResult = command.searchExchangeRate(((EesDmt4004Event)e).getChargeBookingInvoiceVO());
			}
            else if(e instanceof EesDmt4016Event) {
				dResult = command.searchExchangeRate(((EesDmt4016Event)e).getChargeBookingInvoiceVO());
			}
            
            etcData.put("EX_RATE", JSPUtil.toDecimalFormat(dResult, "#.######"));
            eventResponse.setETCData(etcData);
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } catch(Exception ex){
        	eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse;           
    }
    
    /**
     * EES_DMT_3013 : [btn_retrieve Event]<br>
     * Retrieving Demand Note Issue.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDemandChargeList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        DemandNoteSendBC command = new DemandNoteSendBCImpl();
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        
        try{
            EesDmt3013Event event = (EesDmt3013Event)e;
            List<DemandNoteListVO> list = command.searchDemandChargeList(event.getDemandNoteListParmVO(), account);
            
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } catch(Exception ex){
            eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse;           
    }
    
    /**
     * EES_DMT_3109 : [Open Event]<br>
     * Retrieving Demand Note Issue by Booking.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDemandNoteByBooking(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        DemandNoteSendBC command = new DemandNoteSendBCImpl();
        InvoiceIssueCollectionMgtBC Issuecommand = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        CommonFinderBC 			commonCommand 			= new CommonFinderBCImpl();
        try{
            EesDmt3109Event event = (EesDmt3109Event)e;
            //Search Group VO from request
            DemandNoteByBookingVO demandNoteByBookingVO = command.searchDemandNoteByBooking(event.getDemandNoteParmVO(), account);
            
            //Extract muli-list data from group vo
            List<InvoiceIssueVO> list = demandNoteByBookingVO.getInvoiceIssueVOs();
            //Extract single data from group vo
            ChargeBookingInvoiceVO chargeBookingInvoiceVO = demandNoteByBookingVO.getChargeBookingInvoiceVO();
            log.debug("india-----------------:"+event.getDemandNoteParmVO().getUsrCntCd());
			String usrCntCd = commonCommand.searchUserCntCode(account.getOfc_cd());
			
			eventResponse.setETCData("USR_CNT_CD", usrCntCd);
            //=========================================
            //2015.10.27 #7995 comment start
            //2017.01.12 #23259 India Invoice
            // 인도인 경우 GST 관련 Tax rate를 조회. (2012.07.06 Kim hyun hwa)
//            if(event.getDemandNoteParmVO().getUsrCntCd().equals("IN")){
            if(usrCntCd.equals("IN")){
               String iss_dt ="" ;
               SearchIndiaGstRateVO indiaGstRateVO = Issuecommand.searchIndiaGstRate(iss_dt);
               chargeBookingInvoiceVO.setIdaExpnTaxRt(indiaGstRateVO.getIdaExpnTaxRt());
               chargeBookingInvoiceVO.setIdaEduTaxRt(indiaGstRateVO.getIdaEduTaxRt());
               chargeBookingInvoiceVO.setIdaHighEduTaxRt(indiaGstRateVO.getIdaHighEduTaxRt());
               chargeBookingInvoiceVO.setTaxRgstNo(indiaGstRateVO.getTaxRgstNo());
               chargeBookingInvoiceVO.setPmntAcctNo(indiaGstRateVO.getPmntAcctNo());
               chargeBookingInvoiceVO.setSvcCateRmk(indiaGstRateVO.getSvcCateRmk());
               
               log.debug("india-------------setIdaExpnTaxRt:"+chargeBookingInvoiceVO.getIdaExpnTaxRt());
               log.debug("india-------------setIdaEduTaxRt:"+chargeBookingInvoiceVO.getIdaEduTaxRt());
               log.debug("india-------------setIdaHighEduTaxRt:"+chargeBookingInvoiceVO.getIdaHighEduTaxRt());              	
            }
            //2015.10.27 #7995 comment e n d
            //=========================================	
   

            eventResponse.setRsVoList(list);
            eventResponse.setETCData(chargeBookingInvoiceVO.getColumnValues());

        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } catch(Exception ex){
        	eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse;           
    }
    
    /**
     * EES_DMT_3108 : [Open Event]<br>
     * Retrieving Demand Note Issue by Group.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDemandNoteByGroup(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        DemandNoteSendBC command = new DemandNoteSendBCImpl();
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        
        try{
            EesDmt3108Event event = (EesDmt3108Event)e;
            //Search Group VO from request
            List<DemandNoteGroupListVO> list = command.searchDemandNoteByGroup(event.getDemandNoteParmVO());
            
            eventResponse.setRsVoList(list);

        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } catch(Exception ex){
            eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse;           
    }
    
    /**
     * EES_DMT_3108 : [doInit Event]<br>
     * Retrieving Tax Rto. by Office.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchDemandEnvironmentByOffice(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        EesDmt3108Event event 				= (EesDmt3108Event)e;
        Map<String,String> etcData 			= new HashMap<String,String>();
    	InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        
        try {        
        	String tax_rto = command.searchEnvironmentByOffice( event.getSheetOptionVO() );
        	etcData.put("TAX_RTO",tax_rto);
        	eventResponse.setETCData(etcData);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;

    }
    
    /**
     * EES_DMT_4013 : [SELECT]<br>
     * Retrieving Tax Rto by Office.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchEnvironmentByOffice(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
    	GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        EesDmt4013Event event 				= (EesDmt4013Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        Map<String,String> etcData 			= new HashMap<String,String>();
        try {
        	String tax_rto = command.searchEnvironmentByOffice( event.getSheetOptionVO() );
        	etcData.put("TAX_RTO",tax_rto);
        	eventResponse.setETCData(etcData);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;

    }
    
    /**
    * EES_DMT_4105 : [Search]<br>
    * Retrieving Remark(s) 대상]을 [조회]합니다.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchInvoiceRemark (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4105Event event 				= (EesDmt4105Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        Map<String,String> etcData 			= new HashMap<String,String>();
        try {
	        String rtnRemark = command.searchInvoiceRemark ( event.getOtsInquiryParmVO() );
	        etcData.put("rtnRemark",rtnRemark);
	        eventResponse.setETCData(etcData);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }    
    
    /**
    * EES_DMT_4105 : [Search]<br>
    * Retrieving Remark(s).<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSRemark (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4105Event event 				= (EesDmt4105Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        Map<String,String> etcData 			= new HashMap<String,String>();
        try {
	        String rtnRemark = command.searchOTSRemark ( event.getOtsInquiryParmVO() );
	        etcData.put("rtnRemark",rtnRemark);
	        eventResponse.setETCData(etcData);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        
        return eventResponse;
    }
    
    /**
    * EES_DMT_4105 : [UPDATE]<br>
    * Updating Remark(s).<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse modifyInvoiceRemark(Event e) throws EventException {
    
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4105Event event = (EesDmt4105Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        try{
            begin();            
            String rtnRemark = command.modifyInvoiceRemark ( event.getOtsInquiryParmVO() , account);
            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            eventResponse.setETCData("rtnRemark" , rtnRemark);
            commit(); 
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
    
    /**
    * EES_DMT_4105 : [UPDATE]<br>
    * Updating Remark(s).<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse modifyOTSRemark(Event e) throws EventException {
    
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4105Event event = (EesDmt4105Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        try{
            begin();            
            String rtnRemark = command.modifyOTSRemark ( event.getOtsInquiryParmVO() , account);
            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            eventResponse.setETCData("rtnRemark" , rtnRemark);
            commit(); 
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }    
    
    /**
    * EES_DMT_4103 : [Search]<br>
    * Retrieving Sheet Option.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchSheetOption(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4103Event event = (EesDmt4103Event)e;

        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        
        SheetOptionMasterSetVO sheetOptionMasterSetVO = new SheetOptionMasterSetVO();
        sheetOptionMasterSetVO = command.searchSheetOption( event.getSheetOptionSearchOptionVO() , sheetOptionMasterSetVO );

        String shOptInfo = sheetOptionMasterSetVO.getShOptInfo();
        Map<String,String> etcData = new HashMap<String,String>();
        etcData.put("shOptInfo",shOptInfo);
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        eventResponse.setETCData ( etcData                                                  );
        eventResponse.setRsVoList( sheetOptionMasterSetVO.getSheetOptionTermTitleListUpVO() );
        eventResponse.setRsVoList( sheetOptionMasterSetVO.getSheetOptionTermTitleListDwVO() );

        return eventResponse;
    }
    
    /**
    * EES_DMT_4103 : [Delete/Insert]<br>
    * Saving Sheet Option.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse manageSheetOption(Event e) throws EventException {
    
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4103Event event = (EesDmt4103Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        try{
            begin();            
            String audVerSeq = command.manageSheetOption( event.getSheetOptionSearchOptionVO() , event.getSheetOptionTermTitleListUpVOs() , account);
            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            eventResponse.setETCData("aud_ver_seq" , audVerSeq);
            commit(); 
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
    
    /**
    * EES_DMT_4101 : [Search]<br>
    * Retrieving Sheet Setting Screen.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchSheetSet (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4101Event event = (EesDmt4101Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        String rtnRemark = command.searchSheetSet ( event.getSheetSetSearchOptionVO() );
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        Map<String,String> etcData = new HashMap<String,String>();
        etcData.put("rtnRemark",rtnRemark);
        eventResponse.setETCData(etcData);
        return eventResponse;
    }
    
    /**
    * EES_DMT_4101 : [DELETE/INSERT]<br>
    * Delete and Insert Sheet Setting Screen.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse saveSheetSet(Event e) throws EventException {
    
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4101Event event = (EesDmt4101Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        try{
            begin();            
            String rtnRemark = command.saveSheetSet ( event.getSheetSetSearchOptionVO() , account);
            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            eventResponse.setETCData("rtnRemark" , rtnRemark);
            commit(); 
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;
    }
    
    /**
    * EES_DMT_4101 : [DELETE]<br>
    * Deleting Sheet Setting Screen.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse removeSheetSet(Event e) throws EventException {
    
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4101Event event = (EesDmt4101Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        try{
            begin();            
            String rtnRemark = command.removeSheetSet ( event.getSheetSetSearchOptionVO() , account);
            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            eventResponse.setETCData("rtnRemark" , rtnRemark);
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
    * EES_DMT_4101 : [Search]<br>
    * Retrieving Sheet Setting Screen.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchManualInvoiceBySummaryList (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4006Event event 				= (EesDmt4006Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        try{
	        List<ManualInvoiceSummaryVO> list = command.searchManualInvoiceBySummaryList ( event.getManualInvoiceIssueParmVO() );
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }        
        return eventResponse;
    }
    
    /**
     * Saving Invoice Group.<br>
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse issueInvoiceByGroup(Event e) throws EventException {
    	GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        EesDmt4013Event event 				= (EesDmt4013Event)e;
        Map<String,String> etcData 			= new HashMap<String,String>();
        
        try{
        	InvoiceGroupParamVO invoiceGroupParamVO = event.getInvoiceGroupParamVO();
        	
        	String key = invoiceGroupParamVO.getBackendjobKey();
        	InvoiceGroupMgtVO invoiceGroupMgtVO = (InvoiceGroupMgtVO)BackEndJobResult.loadFromFile(key);
        	
        	if(!invoiceGroupMgtVO.getInvoiceGroupParamVO().getErrCode().equals("")){
            		eventResponse.setUserMessage(new ErrorHandler(invoiceGroupMgtVO.getInvoiceGroupParamVO().getErrCode()).getUserMessage());
        	}else{
        		eventResponse.setRsVoList(invoiceGroupMgtVO.getConfirmChargeListVOs());
        		etcData.put("inv_qty", invoiceGroupMgtVO.getInvoiceGroupParamVO().getInvQty());
        		eventResponse.setETCData(etcData);
        	}
        } catch(Exception ex) {
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;    	

    }

    /**
    * EES_DMT_4007 : [SEARCH]<br>
    * Retrieving Manual Invoice Report by Office - Detail(s).<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchManualInvoiceByDetailList (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4007Event event 				= (EesDmt4007Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        try{
	        List<ManualInvoiceIssuedListVO> list = command.searchManualInvoiceByDetailList ( event.getManualInvoiceIssueParmVO() );
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
    * EES_DMT_4011 : [Search]<br>
    * Retrieving Outstanding Inquiry by Customer N Issue - Detail(s).<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchOTSInquiryByDetailList3 (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt4011Event event 				= (EesDmt4011Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 	= new GeneralEventResponse();
        try {
	        List<OtsInquiryByDetial3VO> list = command.searchOTSInquiryByDetailList3 ( event.getOtsInquiryParmVO() );
	        eventResponse.setRsVoList(list);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
    * EES_DMT_4006 : [SEARCH]<br>
    * Retrieving Manual Invoice Report by Office.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchManuaLInvoiceReasonList () throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        Map<String,String> etcData = new HashMap<String,String>();
        try {
	        String reasoncd = command.searchManualInvoiceReasonList();
	        etcData.put("reasoncd",reasoncd);
	        eventResponse.setETCData(etcData);
        }catch(EventException ex){
        	throw ex;
        }catch(Exception ex){
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * EES_DMT_4008 : Retrieve<br>
     * Retrieving Issued Invoice Inquiry.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchIssuedInvoiceList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4008Event event = (EesDmt4008Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

        try{
        	List<IssuedInvoiceListVO> list = command.searchIssuedInvoiceList(event.getIssuedInvoiceParamVO());
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
     * EES_DMT_4004 : Retrieve<br>
     * Retrieving Invoice Create & Issue.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchManualInvoiceByBooking(Event e) throws EventException {
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4004Event event = (EesDmt4004Event)e;

        try{
            ChargeBookingInvoiceVO invoiceVO = event.getChargeBookingInvoiceVO();
            InvoiceIssueMgtVO invoiceIssueMgtVO = command.searchManualInvoiceByBooking(invoiceVO.getDmdtInvNo());
            
            DmtInvMnVO 			dmtInvMnVO 		= null;
            List<DmtInvMnVO> 	dmtInvMnVOS 	= invoiceIssueMgtVO.getDmtInvMnVOS();
            List<DmtInvDtlVO> 	dmtInvDtlVOS 	= invoiceIssueMgtVO.getDmtInvDtlVOS();
            List<DmtInvRtVO> 	dmtInvRtVOS 	= invoiceIssueMgtVO.getDmtInvRtVOS();
            
            if (dmtInvMnVOS != null && dmtInvMnVOS.size() > 0) {
            	
            	dmtInvMnVO = dmtInvMnVOS.get(0);
            	
            	eventResponse.setETCData("ISSUE_DT", 			dmtInvMnVO.getIssueDt() 		!= null ? dmtInvMnVO.getIssueDt() 			: "");
            	eventResponse.setETCData("ISSUE_OFC", 			dmtInvMnVO.getIssueOfcCd() 		!= null ? dmtInvMnVO.getIssueOfcCd() 		: "");
            	eventResponse.setETCData("ISSUE_NM", 			dmtInvMnVO.getIssueUsrNm() 		!= null ? dmtInvMnVO.getIssueUsrNm() 		: "");
            	eventResponse.setETCData("DMDT_INV_STS_CD", 	dmtInvMnVO.getDmdtInvStsCd() 	!= null ? dmtInvMnVO.getDmdtInvStsCd() 		: "");
            	eventResponse.setETCData("DMDT_INV_STS_DESC", 	dmtInvMnVO.getDmdtInvStsDesc() 	!= null ? dmtInvMnVO.getDmdtInvStsDesc() 	: "");
            	eventResponse.setETCData("ARIF", 				dmtInvMnVO.getDmdtArIfCd() 		!= null ? dmtInvMnVO.getDmdtArIfCd() 		: "");
            	eventResponse.setETCData("ARIF_DT", 			dmtInvMnVO.getArIfDt() 			!= null ? dmtInvMnVO.getArIfDt() 			: "");
            	eventResponse.setETCData("ARIF_OFC", 			dmtInvMnVO.getArIfOfcCd() 		!= null ? dmtInvMnVO.getArIfOfcCd() 		: "");
            	eventResponse.setETCData("ARIF_NM", 			dmtInvMnVO.getArIfUsrNm() 		!= null ? dmtInvMnVO.getArIfUsrNm() 		: "");
            	eventResponse.setETCData("ARIF_ID", 			dmtInvMnVO.getArIfUsrId() 		!= null ? dmtInvMnVO.getArIfUsrId() 		: "");
            	eventResponse.setETCData("CR_INV_NO", 			dmtInvMnVO.getCrInvNo() 		!= null ? dmtInvMnVO.getCrInvNo() 			: "");
            	eventResponse.setETCData("CR_AR_IF_CD", 		dmtInvMnVO.getCrArIfCd() 		!= null ? dmtInvMnVO.getCrArIfCd() 			: "");

            	eventResponse.setETCData("BKG_NO", 				dmtInvMnVO.getBkgNo() 			!= null ? dmtInvMnVO.getBkgNo() 			: "");
            	eventResponse.setETCData("BL_NO", 				dmtInvMnVO.getBlNo() 			!= null ? dmtInvMnVO.getBlNo() 				: "");
            	eventResponse.setETCData("DMDT_TRF_CD", 		dmtInvMnVO.getDmdtTrfCd() 		!= null ? dmtInvMnVO.getDmdtTrfCd() 		: "");
            	eventResponse.setETCData("INC_CNTR_DTL", 		dmtInvMnVO.getMnlInvSndFlg() 	!= null ? dmtInvMnVO.getMnlInvSndFlg() 		: "");
            	eventResponse.setETCData("VVD_CD", 				dmtInvMnVO.getVvdCd() 			!= null ? dmtInvMnVO.getVvdCd() 			: "");
            	eventResponse.setETCData("POR_CD", 				dmtInvMnVO.getPorCd() 			!= null ? dmtInvMnVO.getPorCd() 			: "");
            	eventResponse.setETCData("POL_CD", 				dmtInvMnVO.getPolCd() 			!= null ? dmtInvMnVO.getPolCd() 			: "");
            	eventResponse.setETCData("POD_CD", 				dmtInvMnVO.getPodCd() 			!= null ? dmtInvMnVO.getPodCd() 			: "");
            	eventResponse.setETCData("DEL_CD", 				dmtInvMnVO.getDelCd() 			!= null ? dmtInvMnVO.getDelCd() 			: "");
            	eventResponse.setETCData("RCV_TERM_CD", 		dmtInvMnVO.getRcvTermCd() 		!= null ? dmtInvMnVO.getRcvTermCd() 		: "");
            	eventResponse.setETCData("DE_TERM_CD", 			dmtInvMnVO.getDeTermCd() 		!= null ? dmtInvMnVO.getDeTermCd() 			: "");
            	eventResponse.setETCData("BKG_CUST_CD", 		dmtInvMnVO.getBkgCustCd() 		!= null ? dmtInvMnVO.getBkgCustCd() 		: "");
            	eventResponse.setETCData("BKG_CUST_NM", 		dmtInvMnVO.getBkgCustNm() 		!= null ? dmtInvMnVO.getBkgCustNm() 		: "");
            	eventResponse.setETCData("ACT_CUST_CD", 		dmtInvMnVO.getActCustCd() 		!= null ? dmtInvMnVO.getActCustCd() 		: "");
            	eventResponse.setETCData("ACT_CUST_NM", 		dmtInvMnVO.getActCustNm() 		!= null ? dmtInvMnVO.getActCustNm() 		: "");
            	eventResponse.setETCData("ACT_PAYR_CUST_CD", 	dmtInvMnVO.getActPayrCustCd() 	!= null ? dmtInvMnVO.getActPayrCustCd() 	: "");
            	eventResponse.setETCData("ACT_PAYR_CUST_NM", 	dmtInvMnVO.getActPayrCustNm() 	!= null ? dmtInvMnVO.getActPayrCustNm() 	: "");         	
            	eventResponse.setETCData("DUE_DT_FLG", 			dmtInvMnVO.getIssDtPrnFlg() 	!= null ? dmtInvMnVO.getIssDtPrnFlg() 		: "");  
            	eventResponse.setETCData("CRDT_TERM", 			dmtInvMnVO.getCrTermDys() 		!= null ? dmtInvMnVO.getCrTermDys() 		: "");
            	
            	//Attention
            	eventResponse.setETCData("DMDT_PAYR_CNTC_PNT_NM", dmtInvMnVO.getDmdtPayrCntcPntNm()	!= null ? dmtInvMnVO.getDmdtPayrCntcPntNm() : "");
            	eventResponse.setETCData("CUST_CNTC_PNT_SEQ", 		dmtInvMnVO.getCustCntcPntSeq()	!= null ? dmtInvMnVO.getCustCntcPntSeq() 	: "");
            	
            	//Trucker
            	eventResponse.setETCData("VNDR_SEQ", 			dmtInvMnVO.getVndrSeq() 		!= null ? dmtInvMnVO.getVndrSeq() 			: "");
            	eventResponse.setETCData("VNDR_NM", 			dmtInvMnVO.getVndrNm() 			!= null ? dmtInvMnVO.getVndrNm() 			: "");
            	//Due Date, Credit Term
            	eventResponse.setETCData("DUE_DATE", 			dmtInvMnVO.getDueDt() 			!= null ? dmtInvMnVO.getDueDt() 			: "");
            	eventResponse.setETCData("CR_TERM_DYS", 		dmtInvMnVO.getCrTermDys() 		!= null ? dmtInvMnVO.getCrTermDys() 		: "");
            	//Notice
            	eventResponse.setETCData("NOTICE", 				dmtInvMnVO.getNtcKntCd() 		!= null ? dmtInvMnVO.getNtcKntCd() 			: "");
            	//Cust. Ref.
            	eventResponse.setETCData("INV_REF_NO", 			dmtInvMnVO.getInvRefNo() 		!= null ? dmtInvMnVO.getInvRefNo() 			: "");
            	//Invoice Remark(s)
            	eventResponse.setETCData("INV_RMK1", 			dmtInvMnVO.getInvRmk1() 		!= null ? dmtInvMnVO.getInvRmk1() 			: "");
            	eventResponse.setETCData("INV_RMK2", 			dmtInvMnVO.getInvRmk2() 		!= null ? dmtInvMnVO.getInvRmk2() 			: "");
            	//Charge Currency
            	eventResponse.setETCData("CHG_CURR_CD", 		dmtInvMnVO.getChgCurrCd() 		!= null ? dmtInvMnVO.getChgCurrCd() 		: "");
            	//Total AMT
            	eventResponse.setETCData("BIL_AMT", 			dmtInvMnVO.getBilAmt() 			!= null ? dmtInvMnVO.getBilAmt() 			: "");
            	//Invoice Currency
            	eventResponse.setETCData("INV_CURR_CD", 		dmtInvMnVO.getInvCurrCd() 		!= null ? dmtInvMnVO.getInvCurrCd() 		: "");
            	//Ex. Rate
            	eventResponse.setETCData("INV_XCH_RT", 			dmtInvMnVO.getInvXchRt() 		!= null ? dmtInvMnVO.getInvXchRt() 			: "");
            	//Billing AMT
            	eventResponse.setETCData("INV_CHG_AMT", 		dmtInvMnVO.getInvChgAmt() 		!= null ? dmtInvMnVO.getInvChgAmt() 		: "");
            	//Tax Rate
            	eventResponse.setETCData("TAX_RTO",  			dmtInvMnVO.getTaxRto() 			!= null ? dmtInvMnVO.getTaxRto() 			: "");
            	//Sheet Option Tax Rate
            	eventResponse.setETCData("DFLT_TAX_RTO",		dmtInvMnVO.getDfltTaxRto()		!= null ? dmtInvMnVO.getDfltTaxRto() 		: "");
            	//Tax AMT 
            	eventResponse.setETCData("TAX_AMT",  			dmtInvMnVO.getTaxAmt() 			!= null ? dmtInvMnVO.getTaxAmt() 			: "");
            	//Payable AMT
            	eventResponse.setETCData("INV_AMT", 			dmtInvMnVO.getInvAmt() 			!= null ? dmtInvMnVO.getInvAmt() 			: "");
            	//Manual Invoice Reason
            	eventResponse.setETCData("DMDT_MNL_INV_RSN_CD", dmtInvMnVO.getDmdtMnlInvRsnCd() != null ? dmtInvMnVO.getDmdtMnlInvRsnCd() 	: "");
            	//Manual Invoice Remark(s)
            	eventResponse.setETCData("MNL_INV_RMK", 		dmtInvMnVO.getMnlInvRmk() 		!= null ? dmtInvMnVO.getMnlInvRmk() 		: "");
            	
            	//C.REMARK, H.REMARK
            	eventResponse.setETCData("DMDT_CXL_RSN_CD", 	dmtInvMnVO.getDmdtCxlRsnCd() 	!= null ? dmtInvMnVO.getDmdtCxlRsnCd() 		: "");
            	eventResponse.setETCData("DMDT_CXL_RSN_NM", 	dmtInvMnVO.getDmdtCxlRsnNm() 	!= null ? dmtInvMnVO.getDmdtCxlRsnNm() 		: "");
            	eventResponse.setETCData("CXL_RMK", 			dmtInvMnVO.getCxlRmk() 			!= null ? dmtInvMnVO.getCxlRmk() 			: "");
            	eventResponse.setETCData("INV_HLD_RSN_CD", 		dmtInvMnVO.getInvHldRsnCd() 	!= null ? dmtInvMnVO.getInvHldRsnCd() 		: "");
            	eventResponse.setETCData("INV_HLD_RSN_NM", 		dmtInvMnVO.getInvHldRsnNm() 	!= null ? dmtInvMnVO.getInvHldRsnNm() 		: "");
            	eventResponse.setETCData("INV_HLD_RMK", 		dmtInvMnVO.getInvHldRmk() 		!= null ? dmtInvMnVO.getInvHldRmk() 		: "");
            	eventResponse.setETCData("UPD_DT", 				dmtInvMnVO.getUpdDt() 			!= null ? dmtInvMnVO.getUpdDt() 			: "");
            	eventResponse.setETCData("UPD_OFC_CD", 			dmtInvMnVO.getUpdOfcCd() 		!= null ? dmtInvMnVO.getUpdOfcCd() 			: "");
            	eventResponse.setETCData("UPD_USR_ID", 			dmtInvMnVO.getUpdUsrId() 		!= null ? dmtInvMnVO.getUpdUsrId() 			: "");
            	eventResponse.setETCData("UPD_USR_NM", 			dmtInvMnVO.getUpdUsrNm() 		!= null ? dmtInvMnVO.getUpdUsrNm() 			: "");
            	
            	eventResponse.setETCData("BIL_TO_LOC_DIV_CD", 	dmtInvMnVO.getBilToLocDivCd() 	!= null ? dmtInvMnVO.getBilToLocDivCd() 	: "");
            	
            	eventResponse.setETCData("CRE_CNT_CD", 			dmtInvMnVO.getCreCntCd() 		!= null ? dmtInvMnVO.getCreCntCd() 			: "");
            	
            	eventResponse.setETCData("SUTH_CHN_ISS_FLG", 	dmtInvMnVO.getSuthChnIssFlg()	!= null ? dmtInvMnVO.getSuthChnIssFlg() 	: "");
            }
            
            eventResponse.setRsVoList(dmtInvDtlVOS);
            eventResponse.setRsVoList(dmtInvRtVOS);
         
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } catch(Exception ex){
        	eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;           
    }
    /**
     * EES_DMT_4004 : Retrieve<br>
     * Retrieving Invoice Create & Issue.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchManualKeyByBooking(Event e) throws EventException {
    	GeneralEventResponse 			eventResponse 			= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC 	command 				= new InvoiceIssueCollectionMgtBCImpl();
        EesDmt4004Event 				event					= (EesDmt4004Event)e;

        ManualKeyByBookingVO 			manualKeyByBookingVO 	= null;
        List<ManualKeyByChargeVO> 		manualKeyByChargeVOS 	= null;
        List<ManualKeyByBookingVO> 		manualKeyByBookingVOS 	= null;
        
        try {
        	ChargeBookingInvoiceVO 	invoiceVO = event.getChargeBookingInvoiceVO();
        	
            InvoiceIssueMgtVO 		invoiceIssueMgtVO =
            	command.searchManualKeyByBooking(invoiceVO.getBkgNo()
            									, account.getOfc_cd()
            									, invoiceVO.getDmdtTrfCd()
            									, invoiceVO.getMnlInvSndFlg());
            
            manualKeyByBookingVOS = invoiceIssueMgtVO.getManualKeyByBookingVOS();
            if (manualKeyByBookingVOS != null && manualKeyByBookingVOS.size() > 0) {
	       		manualKeyByBookingVO = manualKeyByBookingVOS.get(0);
	       		
            	eventResponse.setETCData("VVD_CD", 			 manualKeyByBookingVO.getVvdCd() 		 != null ? manualKeyByBookingVO.getVvdCd() 			: "");
            	eventResponse.setETCData("POR_CD", 			 manualKeyByBookingVO.getPorCd() 		 != null ? manualKeyByBookingVO.getPorCd() 			: "");
            	eventResponse.setETCData("POL_CD", 			 manualKeyByBookingVO.getPolCd() 		 != null ? manualKeyByBookingVO.getPolCd() 			: "");
            	eventResponse.setETCData("POD_CD", 			 manualKeyByBookingVO.getPodCd() 		 != null ? manualKeyByBookingVO.getPodCd() 			: "");
            	eventResponse.setETCData("DEL_CD", 			 manualKeyByBookingVO.getDelCd() 		 != null ? manualKeyByBookingVO.getDelCd() 			: "");
            	eventResponse.setETCData("RCV_TERM_CD", 	 manualKeyByBookingVO.getRcvTermCd() 	 != null ? manualKeyByBookingVO.getRcvTermCd() 		: "");
            	eventResponse.setETCData("DE_TERM_CD", 		 manualKeyByBookingVO.getDeTermCd() 	 != null ? manualKeyByBookingVO.getDeTermCd() 		: "");
            	eventResponse.setETCData("BKG_CUST_CD", 	 manualKeyByBookingVO.getBkgCustCd() 	 != null ? manualKeyByBookingVO.getBkgCustCd() 		: "");
            	eventResponse.setETCData("BKG_CUST_NM", 	 manualKeyByBookingVO.getBkgCustNm() 	 != null ? manualKeyByBookingVO.getBkgCustNm() 		: "");
            	eventResponse.setETCData("ACT_CUST_CD", 	 manualKeyByBookingVO.getActCustCd() 	 != null ? manualKeyByBookingVO.getActCustCd() 		: "");
            	eventResponse.setETCData("ACT_CUST_NM", 	 manualKeyByBookingVO.getActCustNm() 	 != null ? manualKeyByBookingVO.getActCustNm() 		: "");
            	eventResponse.setETCData("ACT_PAYR_CUST_CD", manualKeyByBookingVO.getActPayrCustCd() != null ? manualKeyByBookingVO.getActPayrCustCd() 	: "");
            	eventResponse.setETCData("ACT_PAYR_CUST_NM", manualKeyByBookingVO.getActPayrCustNm() != null ? manualKeyByBookingVO.getActPayrCustNm() 	: ""); 
            	eventResponse.setETCData("VNDR_SEQ", 		 manualKeyByBookingVO.getVndrSeq() 		 != null ? manualKeyByBookingVO.getVndrSeq() 		: "");
            	eventResponse.setETCData("VNDR_NM", 		 manualKeyByBookingVO.getVndrNm() 		 != null ? manualKeyByBookingVO.getVndrNm() 		: "");
            	//Due Date, Credit Term
            	eventResponse.setETCData("DUE_DATE", 		 manualKeyByBookingVO.getDueDt() 		 != null ? manualKeyByBookingVO.getDueDt() 			: "");
            	eventResponse.setETCData("CR_TERM_DYS", 	 manualKeyByBookingVO.getCrTermDys() 	 != null ? manualKeyByBookingVO.getCrTermDys() 		: "");
            	//Tax Rate
            	eventResponse.setETCData("TAX_RTO", 		 manualKeyByBookingVO.getDfltTaxRto() 	 != null ? manualKeyByBookingVO.getDfltTaxRto() 	: "");
            	//S/C No.
            	eventResponse.setETCData("SC_NO", 			 manualKeyByBookingVO.getScNo() 	 	 != null ? manualKeyByBookingVO.getScNo() 			: "");
            	//RFA No.
            	eventResponse.setETCData("RFA_NO", 			 manualKeyByBookingVO.getRfaNo() 	 	 != null ? manualKeyByBookingVO.getRfaNo() 			: "");
            	
	       		manualKeyByChargeVOS = invoiceIssueMgtVO.getManualKeyByChargeVOS();
	       		eventResponse.setRsVoList(manualKeyByChargeVOS);
            }
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } catch(Exception ex){
            eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;           
    } 
    /**
     * EES_DMT_4004 : Retrieve<br>
     * Retrieving Charge Container No.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkContainerNo(Event e) throws EventException {
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4004Event event = (EesDmt4004Event)e;

        try {
            ChargeBookingInvoiceVO invoiceVO = event.getChargeBookingInvoiceVO();
            String cntrTpszCd = command.checkContainerNo(invoiceVO.getCntrNo());
            
            if (cntrTpszCd != null && cntrTpszCd.length() > 0) {
            	eventResponse.setETCData("VALIDATE", "Y");
            	eventResponse.setETCData("TPSZ_CD", cntrTpszCd);
            }
            else {
            	eventResponse.setETCData("VALIDATE", "N");
            	eventResponse.setETCData("TPSZ_CD", "");            	
            }
            
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } catch(Exception ex){
        	eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;           
    }
    /**
     * EES_DMT_4004 : Retrieve<br>
     * Retrieving Calling Port of VVD CD.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkCallingPort(Event e) throws EventException {
    	GeneralEventResponse 		eventResponse 	= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command 		= new InvoiceIssueCollectionMgtBCImpl();
        EesDmt4004Event 			event 			= (EesDmt4004Event)e;

        try {
            boolean isCallingPort = command.checkCallingPort(event.getChargeBookingInvoiceVO());
           	eventResponse.setETCData("IS_CALLPORT", isCallingPort ? "Y" : "N");
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } catch(Exception ex){
        	eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;           
    }
    /**
     * EES_DMT_4004 : Retrieve<br>
     * Retrieving VVD CD exist..<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse checkVVD(Event e) throws EventException {
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4004Event event = (EesDmt4004Event)e;

        try {
            boolean isVVD = command.checkVVD(event.getChargeBookingInvoiceVO());
            
        	eventResponse.setETCData("IS_VVD", isVVD ? "Y" : "N");
            
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } catch(Exception ex){
        	eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse;           
    } 
    /**
     * EES_DMT_4004 : Save<br>
     * Updating Manual Invoice Creation & Issue.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse modifyInvoiceByManual(Event e) throws EventException {
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4004Event event = (EesDmt4004Event)e;

		try {
			ManualInvoiceIssueVO manualInvoiceIssueVO = new ManualInvoiceIssueVO();
			
			manualInvoiceIssueVO.setDmtInvMnVO(event.getDmtInvMnVO());
			manualInvoiceIssueVO.setDmtInvDtlVOS(event.getDmtInvDtlVOS());
			manualInvoiceIssueVO.setDmtInvRtVOS(event.getDmtInvRtVOS());
			
			begin();
			command.modifyInvoiceByManual(manualInvoiceIssueVO, account);
			commit();
			
			eventResponse.setETCData("SUCCESS_YN", "Y");
			eventResponse.setUserMessage(new ErrorHandler("DMT03065").getUserMessage());
			
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
     * EES_DMT_4004 : Save<br>
     * Saving Manual Invoice Creation & Issue.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse issueInvoiceByManual(Event e) throws EventException {
    	GeneralEventResponse 			eventResponse 	= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC 	command 		= new InvoiceIssueCollectionMgtBCImpl();
        EesDmt4004Event 				event 			= (EesDmt4004Event)e;

        try {
			ManualInvoiceIssueVO manualInvoiceIssueVO = new ManualInvoiceIssueVO();
			
			manualInvoiceIssueVO.setDmtInvMnVO(		event.getDmtInvMnVO()		);
			manualInvoiceIssueVO.setDmtInvDtlVOS(	event.getDmtInvDtlVOS()		);
			manualInvoiceIssueVO.setDmtInvRtVOS(	event.getDmtInvRtVOS()		);
			
			begin();
			String invoiceNo = command.issueInvoiceByManual(manualInvoiceIssueVO, account);
			commit();
			
        	eventResponse.setETCData("SUCCESS_YN", "Y");
        	eventResponse.setETCData("INV_NO", invoiceNo);
        	eventResponse.setUserMessage(new ErrorHandler("DMT03064").getUserMessage());

        } catch(EventException ex) {
        	rollback();
        	eventResponse.setETCData("SUCCESS_YN", "N");
        	if (true) {
        		eventResponse.setUserMessage(ex.getMessage());
        	}
        	else {
        		throw ex;
        	}
        } catch(Exception ex){
        	rollback();
        	eventResponse.setETCData("SUCCESS_YN", "N");
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse;           
    }    
    /**
     * Retrieving Invoice Cancel
     * @param e
     * @return
     * @throws EventException
     */
    private EventResponse searchCancelReason(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
//        EesDmt4106Event event = (EesDmt4106Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

        try{
        	List<DmtCommonReturnDataVO> list = command.searchCancelReason();
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
    * EES_DMT_5101 : SEARCH<br>
    * Retrieving Hold Reason Entry.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchHoldReasonCdList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        try{
            List<DmtCommonReturnDataVO> list = command.searchHoldReasonCdList();
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
    * EES_DMT_5101 : SEARCH<br>
    * Retrieving Hold Reason Entry.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchHoldReason (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EesDmt5101Event event = (EesDmt5101Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        String invoiceNo = (String)event.getAttribute("invoiceNo");
        log.debug("####### SC searchHoldReason invoiceNo [" + invoiceNo + "]");
        String holdReason = command.searchHoldReason ( invoiceNo );
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        Map<String,String> etcData = new HashMap<String,String>();
        etcData.put("holdReason",holdReason);
        eventResponse.setETCData(etcData);
        return eventResponse;
    }
    
    /**
    * EES_DMT_5101 : [UPDATE]<br>
    * Updating Hold Reason Entry.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse modifyInvoiceByHold (Event e) throws EventException {
    
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt5101Event event = (EesDmt5101Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        String invoiceNo = (String)event.getAttribute("invoiceNo");
        String holdReasn = (String)event.getAttribute("holdReasn");
        String holdRemrk = (String)event.getAttribute("holdRemrk");
        try{
            begin();            
            String holdReason = command.modifyInvoiceByHold ( invoiceNo , holdReasn , holdRemrk , account );
            eventResponse.setUserMessage(new ErrorHandler("MST00003").getUserMessage());
            eventResponse.setETCData("holdReason" , holdReason);
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
    * EES_DMT_7006 : [ SEARCH ]<br>
    * Retrieving Fax/E-mail Sending History.<br>
    * 
    * @param Event e
    * @return EventResponse
    * @exception EventException
    */
    private EventResponse searchFaxEmailHistory (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt7006Event event = (EesDmt7006Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();

        try{
            List<DmtFaxEmlSndHisVO> list = command.searchFaxEmailHistory(event.getDmtFaxEmlSndHisParmVO());
            eventResponse.setRsVoList(list);
        }catch(EventException ex){
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler(ex).getMessage());
        }catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}   
        return eventResponse;
        
    }
    /**
     * Canceling Invoice.<br>
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse cancelInvoice(Event e) throws EventException {
        GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
        List<ChargeArgumentVO> chargeArgumentVOList = new ArrayList<ChargeArgumentVO>();
		ChargeArgumentVO chargeArgumentVO 		= new ChargeArgumentVO();
		String err_code 	= "";
		String err_msg 		= "";
		String create_note	= "";	//ar-if 할 invoice_no
        ChargeCalculationBC commandChrge 		= new ChargeCalculationBCImpl();
        Map<String,String> etcData = new HashMap<String,String>();
        
    	GeneralARInvoiceCreationBC commandAR	= new GeneralARInvoiceCreationBCImpl("DEFAULTXA");		//2011.01.07 XA DataSource생성
    	
        List<ARInterfaceCreationVO> genIfVOs	= new ArrayList<ARInterfaceCreationVO>();	//ar-if
		List<ARInterfaceCreationVO> rGenIfVOs	= new ArrayList<ARInterfaceCreationVO>();	//ar-if
		ARInterfaceCreationVO arInterfaceCreationVO = new ARInterfaceCreationVO();			//ar-if
		
		String ar_if_no 	= "";
		String cre_ofc_cd	= "";
        
		try{

            begin();            
            chargeArgumentVOList = command.cancelInvoice(((EesDmt4106Event)e).getCancelInvoiceParamVO(), account);
            cre_ofc_cd = ((EesDmt4106Event)e).getCancelInvoiceParamVO().getCreOfcCd();
            
        	chargeArgumentVO = (ChargeArgumentVO)chargeArgumentVOList.get(0);
        	err_code 	= chargeArgumentVO.getErrCode();
        	err_msg		= chargeArgumentVO.getErrMsg();
        	create_note = chargeArgumentVO.getCrInvNo();
        	
log.debug("\n create_note===>"+create_note);        	
        	
        	if(err_code.equals("DMT03024") || err_code.equals("DMT03063")){
            	rollback();
                eventResponse.setUserMessage(err_msg);
                etcData.put("SUCCESS_YN","N");
                eventResponse.setETCData(etcData);   
                log.error("[cancelInvoice ERROR]"+err_msg);
                return eventResponse;
            }else{

            	String invoice_no = ((EesDmt4106Event)e).getCancelInvoiceParamVO().getDmdtInvNo();
            	String sub_invoice = invoice_no.substring(2, 3);
            	
            	log.debug(">>>>>>>>>>>>>>>>>>>>>[sub_invoice]"+sub_invoice);
            	
            	if(!sub_invoice.equals("M")) {
	            	commandChrge.changeChargeStatusForInvoiceByCancel(chargeArgumentVOList, account);
            	}else{
                	log.debug(">>>>>>>>>>>>>>>>>>>>>Manual Invoice");
            		String suth_chn_iss_flg = command.checkSZPBBInvoice(invoice_no);
                	log.debug(">>>>>>>>>>>>>>>>>>>>>[suth_chn_iss_flg]"+suth_chn_iss_flg);
            		
            		if(suth_chn_iss_flg.equals("Y")) {
    	            	commandChrge.changeChargeStatusForInvoiceByCancel(chargeArgumentVOList, account);
            		}
            	}
            	
            	if(err_code.equals("DMT03062")){
            		//check logic
            		
            		//********************************************************************************
            		arInterfaceCreationVO = command.searchARInterfaceInvoice(account, create_note, "Y", cre_ofc_cd);
            		
    	            genIfVOs.add(arInterfaceCreationVO);
    	            
    	            // AR INTERFACE CALL
    	            //begin();
    	            rGenIfVOs = commandAR.interfaceGeneralARInvoiceToIF(genIfVOs);
    	            //commit();
    	     
    	            //begin();
    	           	ar_if_no = commandAR.interfaceGeneralARInvoiceToINV(rGenIfVOs);
    	            //commit();
    	            // AR INTERFACE END
	
	
	log.debug("\n ar_if_no===>"+ar_if_no);        	
	    	            
    	            if(ar_if_no == null || ar_if_no.equals("")) {
    	            	etcData.put("SUCCESS_YN", "N");
    	                eventResponse.setETCData(etcData);   
    	            	log.error("\n AR_IF_NO NULL===============");
    	            	eventResponse.setUserMessage("Cancelled! A/R I/F failed! Credit Note: "+create_note);//메시지 처리
    	                log.error("Cancelled! A/R I/F failed! Credit Note: "+create_note);
    	            	rollback();
    	            }else{
    	            	String ar_if_no_arr[] =	ar_if_no.split("::");
    	            	//성공
    	            	if(ar_if_no_arr[0].equals("S")){
    	            		// DMT TABLE UPDATE
    			            //begin();
    			        	command.modifyARInterface(account, ar_if_no_arr[1], create_note, cre_ofc_cd);
    			            //commit();
    			            
    	    	            eventResponse.setUserMessage(err_msg);
    	                	etcData.put("SUCCESS_YN","Y");
    	                	eventResponse.setETCData(etcData);
    	                	
        	            	commit();
    	            	}else{
    		            	etcData.put("SUCCESS_YN", "N");
    		            	eventResponse.setETCData(etcData);   
    		            	log.error("\n AR_IF_ERROR MSG===============>"+ar_if_no_arr[1]);
    		            	
        	            	eventResponse.setUserMessage("Cancelled! A/R I/F failed! Credit Note: "+create_note);//메시지 처리
        	            	rollback();
    	            	}
    	            }
            		//***********************************************************************************
            	}else if(err_code.equals("DMT03061")){
            		eventResponse.setUserMessage(err_msg);
                	etcData.put("SUCCESS_YN","Y");
                	eventResponse.setETCData(etcData);
                	commit();
            	}else{
            		etcData.put("SUCCESS_YN","Y");
                	eventResponse.setETCData(etcData);
                	commit();
            	}
            }
        }catch(EventException ex){
            rollback();
            log.error("\n EventException : "+ex.toString());
            throw ex;
        }catch(Exception ex){
        	rollback();
        	log.error("\n Exception : "+ex.toString());
			throw new EventException(ex.getMessage(), ex);
		}       
        return eventResponse;
    	
    }    
    /**
     * Retrieving Payer Info.
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchPayerInformation(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
		try{
			PayerInformationVO payrInfomationVO = command.searchPayerInformation(((EesDmt4104Event)e).getPayerInfoParamVO());
			List<DmtPayrCntcPntVO> list = payrInfomationVO.getDmtPayrCntcPntVOs();
			DmtPayrInfoVO dmtPayrInfoVO = payrInfomationVO.getDmtPayrInfoVO();
			
            eventResponse.setRsVoList(list);
            eventResponse.setETCData(dmtPayrInfoVO.getColumnValues());
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;

    }    
    
    /**
     * Retrieving Demand Note Issue Preview.
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchDemandNoteIssuePreview(Event e) throws EventException {
    	 DemandNoteSendBC command = new DemandNoteSendBCImpl();
         GeneralEventResponse eventResponse  = new GeneralEventResponse();
		try{
			EesDmt3007Event event = (EesDmt3007Event)e;
			DemandNotePreviewParmVO paramVO = event.getDemandNotePreviewParmVO();
			if(paramVO.getCallToRdTp().equals("group")){
				paramVO.setSessionUsrId(account.getUsr_id());
				paramVO.setSessionOfcCd(account.getOfc_cd());
				
				DemandNotePreviewMstVO demandNotePreviewMstVO = command.searchDemandNoteIssueMstPreview(paramVO);
	            eventResponse.setETCData(demandNotePreviewMstVO.getColumnValues());
			} else {
				paramVO.setSessionUsrId(account.getUsr_id());
				paramVO.setSessionOfcCd(account.getOfc_cd());
				
				DemandNotePreviewMstVO demandNotePreviewMstVO = command.searchDemandNoteIssueMstPreview(paramVO);
				DemandNotePreviewEtcVO demandNotePreviewEtcVO = command.searchDemandNoteIssueEtcPreview(paramVO);
				           
	            eventResponse.setETCData(demandNotePreviewMstVO.getColumnValues());
	            eventResponse.setETCData(demandNotePreviewEtcVO.getColumnValues());
			}
			
            
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
        return eventResponse;

    }     
    
    
    /**
     * Retrieving Payer Name Info.<br>
     * 
     * @param e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchPayerName(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
		try{
			List<DmtPayrInfoVO> list = command.searchPayerName(((EesDmt4104Event)e).getPayerInfoParamVO());//PayerInfoParamVO
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("=").append(" ").append("|");

				for (int i = 0 ; i < list.size(); i++) {
					//DMT,MDM,BKG = GENERAL,CREDIT, ... = NAME 
					codes.append(list.get(i).getJobTp()).append("=").append(list.get(i).getGubun()).append("=").append(list.get(i).getDmdtPayrNm());
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			log.debug("\n payer_name list--->"+codes.toString());
			eventResponse.setETCData("PAYER_NAME", codes.toString());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
		return eventResponse;
    }
	/**
	 * Retrieving Payer Address Info.<br>
	 * 
     * @param e
     * @return EventResponse
     * @throws EventException
	 */
    private EventResponse searchPayerAddress(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
		try{
			List<DmtPayrInfoVO> list = command.searchPayerAddress(((EesDmt4104Event)e).getPayerInfoParamVO());//PayerInfoParamVO
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("=").append(" ").append("|").append(" ");

				for (int i = 0 ; i < list.size(); i++) {
					//DMT,MDM,BKG = GENERAL,CREDIT, ... = ADDR 
					codes.append(list.get(i).getJobTp()).append("=").append(list.get(i).getGubun()).append("=").append(list.get(i).getDmdtPayrAddr()).append("=").append(" ");
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			
			log.debug("\n payer_addr list--->"+codes.toString());
			eventResponse.setETCData("PAYER_ADDR", codes.toString());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
		return eventResponse;
    }
	/**
	 * Retrieving Payer Contact Point Info.<br>
	 * 
     * @param e
     * @return EventResponse
     * @throws EventException
	 */
    private EventResponse searchPayerContactPointName(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
		try{
			List<DmtPayrInfoVO> list = command.searchPayerContactPointName(((EesDmt4104Event)e).getPayerInfoParamVO());//PayerInfoParamVO
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("=").append(" ").append("|");

				for (int i = 0 ; i < list.size(); i++) {
					//DMT,MDM,BKG = GENERAL,CREDIT, ... = ContractPointName 
					codes.append(list.get(i).getJobTp()).append("=").append(list.get(i).getGubun()).append("=").append(list.get(i).getDmdtPayrCntcPntNm());
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData("PAYER_CNTC_PNT_NM", codes.toString());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
		return eventResponse;
    }
	/**
	 * Retrieving Payer Phone No Info.<br>
	 * 
     * @param e
     * @return EventResponse
     * @throws EventException
	 */
    private EventResponse searchPayerPhoneNo(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
		try{
			List<DmtPayrInfoVO> list = command.searchPayerPhoneNo(((EesDmt4104Event)e).getPayerInfoParamVO());//PayerInfoParamVO
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("=").append(" ").append("|");

				for (int i = 0 ; i < list.size(); i++) {
					//DMT,MDM,BKG = GENERAL,CREDIT, ... = PhoneNo 
					codes.append(list.get(i).getJobTp()).append("=").append(list.get(i).getGubun()).append("=").append(list.get(i).getDmdtPayrPhnNo());
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData("PAYER_PHN_NO", codes.toString());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
		return eventResponse;
    }
	/**
	 * Retrieving Payer Fax No.<br>
	 * 
     * @param e
     * @return EventResponse
     * @throws EventException
	 */
    private EventResponse searchPayerFaxNo(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
		try{
			List<DmtPayrInfoVO> list = command.searchPayerFaxNo(((EesDmt4104Event)e).getPayerInfoParamVO());//PayerInfoParamVO
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("=").append(" ").append("|");

				for (int i = 0 ; i < list.size(); i++) {
					//DMT,MDM,BKG = GENERAL,CREDIT, ... = FAX NO 
					codes.append(list.get(i).getJobTp()).append("=").append(list.get(i).getGubun()).append("=").append(list.get(i).getDmdtPayrFaxNo());
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData("PAYER_FAX_NO", codes.toString());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
		return eventResponse;
    }
	/**
	 * Retrieving Payer Email.<br>
	 * 
     * @param e
     * @return EventResponse
     * @throws EventException
	 */
    private EventResponse searchPayerEmail(Event e) throws EventException {
    	GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
		try{
			List<DmtPayrInfoVO> list = command.searchPayerEmail(((EesDmt4104Event)e).getPayerInfoParamVO());//PayerInfoParamVO
			
			StringBuffer codes = new StringBuffer();
			if (list != null && list.size() > 0) {
				codes.append(" ").append("=").append(" ").append("=").append(" ").append("|");

				for (int i = 0 ; i < list.size(); i++) {
					//DMT,MDM,BKG = GENERAL,CREDIT, ... = Email 
					codes.append(list.get(i).getJobTp()).append("=").append(list.get(i).getGubun()).append("=").append(list.get(i).getDmdtPayrN1stEml());
					if (i < list.size() - 1) codes.append("|");
				}
			}		
			eventResponse.setETCData("PAYER_EMAIL", codes.toString());
        }catch(EventException ex){
            throw ex;
        }catch(Exception ex){
            throw new EventException(ex.getMessage(), ex);
        }       
		return eventResponse;
    }
    
    /**
     * Retrieving Payer Info.<BR>
     * @param e
     * @return
     * @throws EventException
     */
    private EventResponse managePayerInformation(Event e) throws EventException {
        InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        PayerInformationVO payerInformationVO 	= new PayerInformationVO();
        Map<String,String> etcData 				= new HashMap<String,String>();
        
        try{
            //EesDmt4002Event event = (EesDmt4002Event)e;
        	payerInformationVO.setDmtPayrInfoVO(((EesDmt4104Event)e).getDmtPayrInfoVO());
        	payerInformationVO.setDmtPayrCntcPntVOs(((EesDmt4104Event)e).getDmtPayrCntcPntVOs());
        	
            begin();
            command.managePayerInformation(payerInformationVO, account);
            etcData.put("SUCCESS_YN", "Y");
            eventResponse.setETCData(etcData);
            commit();

        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
        	rollback();
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse;           
    	
    }
    
    
    /**
     * EES_DMT_4016-1 : Manual Billing<br>
     * Retrieving calculated Charge Info by Finished Booking,  Tariff Type, "SZPBB".<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchChargeInvoiceBySZPBB(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4016Event event = (EesDmt4016Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        ChargeCalculationBC commandChrge 	= new ChargeCalculationBCImpl();
        
        try{
        	//1.searchVVDCheckData
        	VVDCheckDataVO vVDCheckDataVO = command.searchVVDCheckData(event.getIssuedInvoiceParamVO());
        	if(!vVDCheckDataVO.getBkgNo().equals("")) {
	        	//2.modifyBookingContainerVVD
	        	commandChrge.modifyBookingContainerVVD(vVDCheckDataVO);
        	}
        	
        	InvoiceIssueMgtVO invoiceIssueMgtVO = command.searchChargeInvoiceBySZPBB(event.getIssuedInvoiceParamVO(), account);
            
            List<InvoiceIssueVO> invIssueVOList = invoiceIssueMgtVO.getInvoiceIssueVOs();
            List<ChrgDtlVO> chrgDtlVOList = invoiceIssueMgtVO.getChrgDtlVOs();
            ChargeBookingInvoiceVO chargeBookingInvoiceVO = invoiceIssueMgtVO.getChargeBookingInvoiceVO();
            
            eventResponse.setRsVoList(invIssueVOList);	// Charge
            eventResponse.setRsVoList(chrgDtlVOList);	// Rate Detail
            
            Map<String, String> etcData = chargeBookingInvoiceVO.getColumnValues();
			Set<String> keys = etcData.keySet();
			Iterator<String> it = keys.iterator();
			
			while(it.hasNext()) {
				String key = (String)it.next();
				if(etcData.get(key) == null)
					etcData.put(key, "");
			}
			
            eventResponse.setETCData(etcData);
            
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
     * EES_DMT_4016 : Retrieve<br>
     * Retrieving Invoice Create & Issue<br>
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchIssuedInvoiceBySZPBB(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EesDmt4016Event event = (EesDmt4016Event)e;
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        
        try{
            InvoiceIssueMgtVO invoiceIssueMgtVO = command.searchIssuedInvoiceBySZPBB(event.getIssuedInvoiceParamVO());
            
            List<InvoiceIssueVO> invIssueVOList = invoiceIssueMgtVO.getInvoiceIssueVOs();
            List<ChrgDtlVO> chrgDtlVOList = invoiceIssueMgtVO.getChrgDtlVOs();
            ChargeBookingInvoiceVO chargeBookingInvoiceVO = invoiceIssueMgtVO.getChargeBookingInvoiceVO();
            
            eventResponse.setRsVoList(invIssueVOList);	// Charge
            eventResponse.setRsVoList(chrgDtlVOList);	// Rate Detail
            eventResponse.setETCData(chargeBookingInvoiceVO.getColumnValues());
            
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
     * EES_DMT_4016 : SAVE<br>
     * Invoice Issue Confirmed Charge
     * 
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse issueInvoiceBySZPBB(Event e) throws EventException {

    	log.debug("SC start....................");
    	InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
        ChargeCalculationBC commandChrge 		= new ChargeCalculationBCImpl();
        GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        InvoiceIssueMgtVO invoiceIssueMgtVO 	= new InvoiceIssueMgtVO();
        DmtInvMnVO dmtInvMnVO = new DmtInvMnVO();
        Map<String,String> etcData = new HashMap<String,String>();
        try{
            EesDmt4016Event event = (EesDmt4016Event)e;
            invoiceIssueMgtVO.setChargeBookingInvoiceVO(event.getChargeBookingInvoiceVO());
            invoiceIssueMgtVO.setInvoiceIssueVOs(event.getInvoiceIssueVOs());
            invoiceIssueMgtVO.setChrgDtlVOs(event.getChrgDtlVOs());
            
            begin();
            dmtInvMnVO = command.issueInvoiceBySZPBB(invoiceIssueMgtVO, account);
            
            invoiceIssueMgtVO.getChargeBookingInvoiceVO().setDmdtInvNo(dmtInvMnVO.getDmdtInvNo());
            
            if(dmtInvMnVO.getErrCode().equals("DMT03064")){//성공
                commandChrge.changeChargeStatusForInvoice(invoiceIssueMgtVO, account);
                
                etcData.put("INVOICE_NO", dmtInvMnVO.getDmdtInvNo());
                etcData.put("SUCCESS_YN", "Y");
                eventResponse.setETCData(etcData);
            	eventResponse.setUserMessage(new ErrorHandler(dmtInvMnVO.getErrCode()).getUserMessage());
                commit();
                
            } else {
                etcData.put("SUCCESS_YN", "N");
                eventResponse.setETCData(etcData);
            	eventResponse.setUserMessage(new ErrorHandler(dmtInvMnVO.getErrCode()).getUserMessage());
            	rollback();
            }
            
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex){
        	rollback();
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse;           
    }
   
    
    /**
	 * [EES_DMT_4002] : [ARIF] <br>
	 * Creating ARInterface<br>
	 * @param Event e
	 * @return EventResponse response 
	 * @throws EventException
     */
    @SuppressWarnings("unchecked")
	private EventResponse createInvoiceData(Event e) throws EventException {
    	InvoiceIssueCollectionMgtBC command 	= new InvoiceIssueCollectionMgtBCImpl();
    	GeneralARInvoiceCreationBC commandAR	= new GeneralARInvoiceCreationBCImpl("DEFAULTXA");//2011.01.07 XA DataSource생성
    	//ChargeCalculationBC commandCharge		= new ChargeCalculationBCImpl();
    	
        GeneralEventResponse eventResponse 		= new GeneralEventResponse();
        
        List<ARInterfaceCreationVO> genIfVOs	= new ArrayList<ARInterfaceCreationVO>();	
		List<ARInterfaceCreationVO> rGenIfVOs	= new ArrayList<ARInterfaceCreationVO>();	
		ARInterfaceCreationVO arInterfaceCreationVO = new ARInterfaceCreationVO();
		
		
		Map<String,String> etcData = new HashMap<String,String>();
		String ar_if_no 	= "";
		String invoice_no  	= "";
		String cre_ofc_cd	= "";
		
		String[] invoice_nos 	= null;
		ConfirmChargeListVO[] confirmChargeListVOs = null;
		InvoiceInterfaceARByDetailVO[] invoiceInterfaceARByDetailVOs = null;
		List<ConfirmChargeListVO> list = new ArrayList<ConfirmChargeListVO>();
		
		boolean isEqualDataCheck = false;
		HashMap hm = new HashMap();
		int iCnt = 0;
		int total_cnt = 0;
		int success_cnt = 0;
		int fail_cnt = 0;
		String msg = "";
		String ar_err_msg = "";
		StringBuffer sb_ar_err_msg = new StringBuffer();
		
		ChargeBookingInvoiceVO chargeBookingInvoiceVO = new ChargeBookingInvoiceVO();
		
		log.debug("\n ===========start===>");

        try{
        	if(e instanceof EesDmt4002Event) {			//4002	단건
        		invoice_no = ((EesDmt4002Event)e).getIssuedInvoiceParamVO().getSInvoiceNo();
        		cre_ofc_cd = ((EesDmt4002Event)e).getIssuedInvoiceParamVO().getSOfcCd();		
        		invoice_nos = new String[1];
        		invoice_nos[0] = invoice_no;	
        	}else if(e instanceof EesDmt4016Event) {	//4016
        		invoice_no = ((EesDmt4016Event)e).getChargeBookingInvoiceVO().getDmdtInvNo();
        		cre_ofc_cd = ((EesDmt4016Event)e).getChargeBookingInvoiceVO().getCreOfcCd();	
        		invoice_nos = new String[1];
        		invoice_nos[0] = invoice_no;	
        	}else if(e instanceof EesDmt4004Event) {	//4004
        		invoice_no = ((EesDmt4004Event)e).getDmtInvMnVO().getDmdtInvNo();
        		cre_ofc_cd = ((EesDmt4004Event)e).getDmtInvMnVO().getCreOfcCd();				
        		invoice_nos = new String[1];
        		invoice_nos[0] = invoice_no;	
        	}else if(e instanceof EesDmt4013Event) {	//4013	
        		confirmChargeListVOs = ((EesDmt4013Event)e).getConfirmChargeListVOs();
        		cre_ofc_cd = ((EesDmt4013Event)e).getInvoiceGroupParamVO().getUsrOfc();
        		//array to list
        		for(int i = 0 ; i < confirmChargeListVOs.length ; i++) {
        			list.add(confirmChargeListVOs[i]);
        		}
        		
//        		log.debug("\n ===========confirmChargeListVOs.size===>"+confirmChargeListVOs.length);
        		for(int i = 0; i < confirmChargeListVOs.length ; i++) {
        			String temp_no = confirmChargeListVOs[i].getDmdtInvNo();
        			
        			if(temp_no == null || temp_no.equals("")){
        				continue;
        			}
        			
        			if(confirmChargeListVOs[i].getCheckBox().equals("1")) {
	            		isEqualDataCheck = false;
	
	        			for( int j = i+1; j < confirmChargeListVOs.length ; j++) {
	        				if(temp_no.equals(confirmChargeListVOs[j].getDmdtInvNo())){
	        					isEqualDataCheck = true;
	        					break;
	        				}
	        			}
	        			if(!isEqualDataCheck){
	        				hm.put("INVOICE_NO_"+iCnt, temp_no);
	        				iCnt++;
	        			}
        			}
        		}

        		invoice_nos = new String[hm.size()];
        		for(int i = 0 ; i < hm.size() ; i++) {
        			invoice_nos[i] = (String)hm.get("INVOICE_NO_"+i);
        		}
        	}else if(e instanceof EesDmt5003Event) {	//5003
        		invoiceInterfaceARByDetailVOs =  ((EesDmt5003Event)e).getInvoiceInterfaceARByDetailVOS();
        		cre_ofc_cd = ((EesDmt5003Event)e).getInvoiceInterfaceARParmVO().getOfcCd();
        		
        		invoice_nos = new String[invoiceInterfaceARByDetailVOs.length];
        		
        		for(int i = 0 ; i < invoiceInterfaceARByDetailVOs.length ; i++) {
        			invoice_nos[i] = invoiceInterfaceARByDetailVOs[i].getDmdtInvNo();
        		}
        	}
        	
        	List<String> invoiceNoList = new ArrayList<String>();
        	int ar_if_cnt = 0;
        	
        	if(invoice_nos != null) {
        		invoiceNoList = command.searchARIFCount(invoice_nos, cre_ofc_cd, "1");
        	}
        	
        	for(int i = 0; i < invoiceNoList.size(); i++) {
        		if(!invoiceNoList.get(i).equals("")) {
        			ar_if_cnt++;
        		}
        	}
        	
    		if(ar_if_cnt > 0) {
    			etcData.put("SUCCESS_YN", "N");
                log.error("ERROR || It's already interfaced to A/R. Please check again ! (AR-IF COUNT =>" + ar_if_cnt +")");
                eventResponse.setETCData(etcData);
    			eventResponse.setUserMessage(new ErrorHandler("DMT01024").getUserMessage());
    			
    			if(e instanceof EesDmt4013Event){

    				for(int i = 0; i < list.size(); i++){
	            		ConfirmChargeListVO tempVO = (ConfirmChargeListVO)list.get(i);
	            		for(int j = 0; j < invoiceNoList.size(); j++) {
	                		if(!invoiceNoList.get(j).equals("")) {	
	                			if((tempVO.getCheckBox().equals("1")) 
	                					&& (invoiceNoList.get(j).equals(tempVO.getDmdtInvNo()))) {
	                				tempVO.setDmdtArIfCd("Y");
	                				break;
	                			}
	                		}
	                	}
	            		
	            		list.set(i, tempVO);
	            	}    				
	            	if(list != null) eventResponse.setRsVoList(list);
	            }
                return eventResponse;  
    		}
    		
        	invoiceNoList = command.searchARIFCount(invoice_nos, cre_ofc_cd, "2");
        	int cur_blank_cnt = 0;
        	for(int i = 0; i < invoiceNoList.size(); i++) {
        		if(!invoiceNoList.get(i).equals("Y")) {
        			cur_blank_cnt++;
        		}
        	}
        	if(cur_blank_cnt > 0){
        		etcData.put("SUCCESS_YN", "N");
        		eventResponse.setETCData(etcData);
        		String message = new ErrorHandler("DMT02002").getUserMessage();
        		message = JSPUtil.replace(message, "XXX", "INV Cur.");
            	eventResponse.setUserMessage(message);
            	
    			if(e instanceof EesDmt4013Event){
    				
    				for(int i = 0; i < list.size(); i++){
	            		ConfirmChargeListVO tempVO = (ConfirmChargeListVO)list.get(i);
	            		for(int j = 0; j < invoiceNoList.size(); j++) {
	                		if(!invoiceNoList.get(j).equals("")) {	
	                			if((tempVO.getCheckBox().equals("1")) 
	                					&& (invoiceNoList.get(j).equals(tempVO.getDmdtInvNo()))) {
	                				tempVO.setDmdtArIfCd("Y");
	                				break;
	                			}
	                		}
	                	}
	            		
	            		list.set(i, tempVO);
	            	}    				
	            	eventResponse.setRsVoList(list);
	            }
                return eventResponse;
        	}
    		
    		
    		String create_note_yn = "N";
    		
        	
        	//String					ydCd	= null;
			//EDIVO 					eDIVO 	= null;
			List<EDIVO> 			eDIVOs	= null;
			List<EDIContainerVO>	eDIContainerVOs = null;
        	
        	if(e instanceof EesDmt4002Event || e instanceof EesDmt4016Event || e instanceof EesDmt4004Event) {

        		String inv_sts_cd = command.searchInvoiceStatus(invoice_no, cre_ofc_cd);
        		
        		if(inv_sts_cd.equals("C"))
        			create_note_yn = "Y";
        		else
        			create_note_yn = "N";
        		
        		if(create_note_yn.equals("N")){
        			chargeBookingInvoiceVO = command.checkAftInvAdjAmtByInvoiceNo(invoice_no, cre_ofc_cd, account);
        			if(chargeBookingInvoiceVO.getArIfOfcCd().length() > 0 && chargeBookingInvoiceVO.getAftInvAdjAmt().length() > 0 ) {
	        			if(chargeBookingInvoiceVO.getArIfOfcCd().equals("LEHBB") && !chargeBookingInvoiceVO.getAftInvAdjAmt().equals("0")){
	        				etcData.put("SUCCESS_YN", "N");
	        				log.error("\n LEHBB===============>AFT_INV_ADJ_AMT["+chargeBookingInvoiceVO.getAftInvAdjAmt()+"]");
	        				eventResponse.setUserMessage(new ErrorHandler("DMT03070").getUserMessage());
			                eventResponse.setETCData(etcData);
			    			return eventResponse;  
	        			}
        			}
        		}

        		arInterfaceCreationVO = command.searchARInterfaceInvoice(account, invoice_no, create_note_yn, cre_ofc_cd);
	            
	            if(arInterfaceCreationVO.getInvArIfChgVOs() == null) {
	            	log.debug(arInterfaceCreationVO.getInvArIfMnVO().getArIfNo());	//ERROR MESSAGE
	            	etcData.put("SUCCESS_YN", "N");
	            	log.error("\n AR INTERFACE VO NULL ===============");
	            	eventResponse.setUserMessage(arInterfaceCreationVO.getInvArIfMnVO().getArIfNo());
	            }else{
	            	genIfVOs.add(arInterfaceCreationVO);
	            	log.debug("\n invoice_no===============>"+invoice_no);
	            
		            // AR INTERFACE CALL
		            begin();
		            rGenIfVOs = commandAR.interfaceGeneralARInvoiceToIF(genIfVOs);
		     
		            ar_if_no = commandAR.interfaceGeneralARInvoiceToINV(rGenIfVOs);
		            // AR INTERFACE END
		            log.debug("\n ar_if_no===============>"+ar_if_no);
	            
		            if(ar_if_no == null || ar_if_no.equals("")) {
		            	etcData.put("SUCCESS_YN", "N");
		            	log.error("\n AR_IF_NO NULL===============");
		            	msg = new ErrorHandler("DMT03066").getUserMessage();
		            	eventResponse.setUserMessage(JSPUtil.replace(msg, "XXXXXXXXX", invoice_no));
		            	log.error("\n "+JSPUtil.replace(msg, "XXXXXXXXX", invoice_no));
		                rollback();
		            }else{
		            	String ar_if_no_arr[] =	ar_if_no.split("::");

		            	if(ar_if_no_arr[0].equals("S")){
		            		// DMT TABLE UPDATE
				            //begin();
				        	command.modifyARInterface(account, ar_if_no_arr[1], invoice_no, cre_ofc_cd);		
				            //commit();
				            etcData.put("SUCCESS_YN", "Y");
				            msg = new ErrorHandler("DMT03027").getUserMessage();
				            eventResponse.setUserMessage(JSPUtil.replace(msg, "XXR123456", invoice_no));
		            	}else{
			            	etcData.put("SUCCESS_YN", "N");
			            	log.error("\n AR_IF_ERROR MSG===============>"+ar_if_no_arr[1]);
			            	msg = new ErrorHandler("DMT03066").getUserMessage();
			            	ar_err_msg = ar_if_no_arr[1];
			            	msg = msg + "["+ar_err_msg+"]";
			            	eventResponse.setUserMessage(JSPUtil.replace(msg, "XXXXXXXXX", invoice_no));
		            	}
		            	commit();
		            }
	            }
        	}else if(e instanceof EesDmt4013Event || e instanceof EesDmt5003Event) {
        		total_cnt = invoice_nos.length;
        		StringBuffer sb_err_inv = new StringBuffer(); 
        		
        		for(int i = 0; i < invoice_nos.length ; i++) {
        			invoice_no = invoice_nos[i];
        			
            		String inv_sts_cd = command.searchInvoiceStatus(invoice_no, cre_ofc_cd);
            		
            		if(inv_sts_cd.equals("C"))
            			create_note_yn = "Y";
            		else
            			create_note_yn = "N";
            		
            		if(create_note_yn.equals("N")){
            			chargeBookingInvoiceVO = command.checkAftInvAdjAmtByInvoiceNo(invoice_no, cre_ofc_cd, account);
            			if(chargeBookingInvoiceVO.getArIfOfcCd().length() > 0 && chargeBookingInvoiceVO.getAftInvAdjAmt().length() > 0 ) {
    	        			if(chargeBookingInvoiceVO.getArIfOfcCd().equals("LEHBB") && !chargeBookingInvoiceVO.getAftInvAdjAmt().equals("0")){
    	        				log.error("\n LEHBB===============>AFT_INV_ADJ_AMT["+chargeBookingInvoiceVO.getAftInvAdjAmt()+"]");
    	    	            	fail_cnt++;
    			            	sb_err_inv.append(invoice_no).append(",");
    			            	continue;
    	        			}
            			}
            		}
            		//=======================================================================================
            		
        			ar_if_no   = "";
        			log.debug("\n========[size]=>"+invoice_nos.length+":[row]=>"+i+":[invoice_no]"+invoice_no);    
					genIfVOs	= new ArrayList<ARInterfaceCreationVO>();

        			arInterfaceCreationVO = command.searchARInterfaceInvoice(account, invoice_no, create_note_yn, cre_ofc_cd);
        			
        			if(arInterfaceCreationVO.getInvArIfChgVOs() == null) {
    	            	log.debug(arInterfaceCreationVO.getInvArIfMnVO().getArIfNo());
    	            	fail_cnt++;
		            	sb_err_inv.append(invoice_no).append(",");
    	            }else{
        			
	    	            genIfVOs.add(arInterfaceCreationVO);
	    	            
	    	            // AR INTERFACE CALL
	    	            begin();
	    	            rGenIfVOs = commandAR.interfaceGeneralARInvoiceToIF(genIfVOs);
	    	     
	    	            ar_if_no = commandAR.interfaceGeneralARInvoiceToINV(rGenIfVOs);
	    	            // AR INTERFACE END
	    	            
	    	            if(ar_if_no == null || ar_if_no.equals("")) {
	    	            	log.debug("\n AR_IF_NO NULL===============");
	    	            	fail_cnt++;
			            	sb_err_inv.append(invoice_no).append(",");
			            	rollback();
	    	            }else{
	    	            	String ar_if_no_arr[] =	ar_if_no.split("::");
	    	            	if(ar_if_no_arr[0].equals("S")){
		    	            	success_cnt++;
		        	            // DMT TABLE UPDATE
		        	        	command.modifyARInterface(account, ar_if_no_arr[1], invoice_no, cre_ofc_cd);
		        	            
		        	            String io_bnd_cd = arInterfaceCreationVO.getInvArIfMnVO().getIoBndCd();
		        	            
				            	if(io_bnd_cd.equals("I")) {
						            log.debug("\n =========> AR-IF SUCESS!! EDI SEND data search start !!");
									eDIContainerVOs = command.searchEDIContainerInfoByInvoice(invoice_no, cre_ofc_cd);	//EDI로 전송할 데이터를 조회한다.
									
//									if (eDIContainerVOs != null && eDIContainerVOs.size() > 0 ) {
//										eDIVOs = new ArrayList<EDIVO>(); 
//										for ( int j = 0 ; j < eDIContainerVOs.size() ; j++ ) {
//											ydCd = eDIContainerVOs.get(j).getFmMvmtYdCd();
//											
//											if (ydCd == null || ydCd.length() != 7) continue;
//														
//											String locCd = ydCd.substring(0, 5);
//											if ("KOR".equals(eDIContainerVOs.get(j).getSvrId())
//													&& ("KRPUS".equals(locCd) ||
//    													"KRKAN".equals(locCd) ||
//														"KRINC".equals(locCd) ||
//														"KRPYT".equals(locCd) ||
//														"KRUSN".equals(locCd) ||
//														"KRPTK".equals(locCd) )) {
//
//												eDIVO = new EDIVO();
//												eDIVO.setBkgNo(			eDIContainerVOs.get(j).getBkgNo()		);
//												eDIVO.setSysAreaGrpId(	eDIContainerVOs.get(j).getSvrId()		);
//												eDIVO.setCntrNo(		eDIContainerVOs.get(j).getCntrNo()		);
//												eDIVO.setCntrCycNo(		eDIContainerVOs.get(j).getCntrCycNo()	);
//												eDIVO.setAcount(		account									);
//												eDIVOs.add(eDIVO);
//											}
//										}
//									}
//									
									if (eDIVOs != null && eDIVOs.size() > 0) {
										log.debug("\n =========> EDI common module start !!");
										//20150430 Park Young Jin 주석 처리 강환수석님 요청
										//commandCharge.sendToEDI(eDIVOs);
									}
									/////////////////////////////////////////////////////////////////////////////////////////////////////////
				            	}
		        	            
	    	            	}else{
	        	            	fail_cnt++;
	        	            	sb_ar_err_msg.append(ar_if_no_arr[1]).append("|");
	    		            	log.debug("\n AR_IF_ERROR MSG===============>["+invoice_no+"]"+ar_if_no_arr[1]);
	    		            	sb_err_inv.append(invoice_no).append(",");
	    	            	}
		    	            commit();
	    	            }
	        		}
        		}
        		
	            etcData.put("SUCCESS_YN", "Y");
	            
	            msg = new ErrorHandler("DMT03067").getUserMessage();
	            msg = JSPUtil.replace(msg, "$1", ""+total_cnt);
	            msg = JSPUtil.replace(msg, "$2", ""+success_cnt);
	            msg = JSPUtil.replace(msg, "$3", ""+fail_cnt);
	            msg = JSPUtil.replace(msg, "XXX123456", ""+sb_err_inv.toString());
	            if(fail_cnt > 0) {
	            	msg = msg+"["+sb_ar_err_msg.toString()+"]";
	            }
            	eventResponse.setUserMessage(msg);
	            
	            if(e instanceof EesDmt4013Event){
	            	for(int i = 0; i < list.size(); i++){
	            		ConfirmChargeListVO tempVO = (ConfirmChargeListVO)list.get(i);
	            		if((tempVO.getCheckBox().equals("1")) && (fail_cnt == 0)) {
            				tempVO.setDmdtArIfCd("Y");
	            		}
	            		list.set(i, tempVO);
	            	}
	            	eventResponse.setRsVoList(list);
	            }
        	}
        	eventResponse.setETCData(etcData);
            
        } catch(EventException ex) {
            etcData.put("SUCCESS_YN", "N");
            log.error("EventException " + ex.toString(), ex);
            eventResponse.setETCData(etcData);
            rollback();
            throw new EventException(new ErrorHandler(ex).getMessage());
        } catch(Exception ex){
            etcData.put("SUCCESS_YN", "N");
            log.error("Exception " + ex.toString(), ex);
            eventResponse.setETCData(etcData);
            rollback();
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse;
    } 
    
    /**
     * EES_DMT_4013 : cntr count retrieving<br>
     * Retrieving cntr count by Bkg.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchBookingContainerCount(Event e) throws EventException {
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        Map<String,String> etcData          = new HashMap<String,String>();
        
        try{
        	int dResult = 0;
        	
        	dResult = command.searchBookingContainerCount(((EesDmt4013Event)e).getIssuedInvoiceParamVO());
			
            etcData.put("CNTR_CNT", String.valueOf(dResult));
            eventResponse.setETCData(etcData);
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex){
            eventResponse.setUserMessage(ex.getMessage());
            log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse;           
    }
    
    
    /**
     * EES_DMT_4013 : cntr count retrieving<br>
     * Retrieving container by Bkg.<br>
     * 
     * @param Event e
     * @return EventResponse
     * @throws EventException
     */
    private EventResponse searchChargeByBooking(Event e) throws EventException {
        InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        ChargeCalculationBC commandChrge 	= new ChargeCalculationBCImpl();
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        List<ConfirmChargeListVO> list 		= null;
        List<VVDCheckDataVO>	  vVDCheckList = null;

        
        try{
        	//1.searchVVDCheckData
        	vVDCheckList = command.searchVVDCheckDataList(((EesDmt4013Event)e).getIssuedInvoiceParamVO(), account);
        	
        	for( int i = 0 ; i < vVDCheckList.size() ; i++) {
        		VVDCheckDataVO vVDCheckDataVO = (VVDCheckDataVO)vVDCheckList.get(i);
	        	//2.modifyBookingContainerVVD
	        	commandChrge.modifyBookingContainerVVD(vVDCheckDataVO);
        	}
        	
        	list = command.searchChargeInvoiceList(((EesDmt4013Event)e).getIssuedInvoiceParamVO(), account);
        	
        	eventResponse.setRsVoList(list);
			
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex){
            eventResponse.setUserMessage(ex.getMessage());
            log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse; 
    }
    
    /**
     * Retrieving fax, email Info by Payer
     * @param Event e
     * @return EventResponse
     * @throws EventExcpetion
     */
    private EventResponse searchFAXEmailByPayer(Event e) throws EventException {
    	InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        Map<String,String> etcData          = new HashMap<String,String>();
        FAXEmailByPayerVO fAXEmailByPayerVO = new FAXEmailByPayerVO();
        
        
        try{
        	fAXEmailByPayerVO = command.searchFAXEmailByPayer(((EesDmt4002Event)e).getFAXEmailByPayerVO());
			
            etcData.put("EMAIL_NO", fAXEmailByPayerVO.getEmailNos());
            etcData.put("FAX_NO", fAXEmailByPayerVO.getFaxNos());
            eventResponse.setETCData(etcData);
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex){
            eventResponse.setUserMessage(ex.getMessage());
            log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse; 
    }
    
    /**
     * Retrieving manual invoice MASTER data of INVOICE RD.<br>
     * @param Event e
     * @return EventResponse
     * @throws EventExcpetion
     */
    private EventResponse searchInvoiceIssueMasterPreview(Event e) throws EventException {
    	InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
        GeneralEventResponse eventResponse  = new GeneralEventResponse();
        InvoiceIssueMasterPreviewVO invoiceIssueMasterPreviewVO = new InvoiceIssueMasterPreviewVO();
        
        try{
        	invoiceIssueMasterPreviewVO = command.searchInvoiceIssueMasterPreview(((EesDmt4003Event)e).getInvoiceIssueRDParamVO());
			
        	eventResponse.setETCData(invoiceIssueMasterPreviewVO.getColumnValues());
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            log.error("err " + ex.toString(), ex);
            throw ex;
        } catch(Exception ex){
            eventResponse.setUserMessage(ex.getMessage());
            log.error("err " + ex.toString(), ex);
        	throw new EventException(ex.getMessage(), ex);
        } 
        return eventResponse; 
    }
    
	/**
	 * EES_DMT_4008, EES_DMT_4001 : Open<br>
	 * Retrieving current date by OFC_CD. <br>
	 * 
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCurrentDateByOffice() throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		CommonFinderBC command = new CommonFinderBCImpl();
		
		String curr_day = command.searchCurrentDateByOffice(account.getOfc_cd());
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		eventResponse.setETCData("OFC_CURR_DAY", curr_day);
		return eventResponse;
	}
	
	/**
	 * EES_DMT_4013 : Group Invoice Save.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse doBackEndJob(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
		
		try{
			InvoiceGroupParamVO invoiceGroupParamVO = null;
			ConfirmChargeListVO[] confirmChargeListVOs = null;
			String backEndJobKey = null;
			
			invoiceGroupParamVO = ((EesDmt4013Event)e).getInvoiceGroupParamVO();
			confirmChargeListVOs = ((EesDmt4013Event)e).getConfirmChargeListVOs();
				
			backEndJobKey = command.doBackEndJob(invoiceGroupParamVO, confirmChargeListVOs, account);
			eventResponse.setETCData("BackEndJobKey", backEndJobKey);
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		} 
		return eventResponse;
	}
	/**
	 * EES_DMT_4013 : btn_save<br>
	 * Retrieving Long Tx status<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 * @exception EventException
	 */
	private EventResponse checkBackEndJob(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		InvoiceIssueCollectionMgtBC command = new InvoiceIssueCollectionMgtBCImpl();
		
		try{
			InvoiceGroupParamVO invoiceGroupParamVO = null;
			
			invoiceGroupParamVO = ((EesDmt4013Event)e).getInvoiceGroupParamVO();
			
			String[] result = command.checkBackEndJob(invoiceGroupParamVO.getBackendjobKey());
			eventResponse.setETCData("jb_sts_flg",		result[0]);
			eventResponse.setETCData("jb_usr_err_msg",	result[1]);
			
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
	 * EES_DMT_4004 : Open <br>
	 * Retrieving Info to initiate control when page is loading. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 */
	private EventResponse searchInvoiceInitControls(Event e) throws EventException {
		GeneralEventResponse 	eventResponse 		= new GeneralEventResponse();
		CommonFinderBC 			command 			= new CommonFinderBCImpl();
		InvoiceIssueCollectionMgtBC Issuecommand = new InvoiceIssueCollectionMgtBCImpl();
		EesDmt4004Event			event				= (EesDmt4004Event) e;
		
		try{
		
			List<TariffNameVO> 		tariffList 			= command.searchTariffTypeList();
			StringBuffer 			sbTariff 			= new StringBuffer();
			
			if (tariffList != null && tariffList.size() > 0) {
				for (int i = 0 ; i < tariffList.size() ; i++) {
					sbTariff.append(tariffList.get(i).getDmdtTrfCd()).append("=").append(tariffList.get(i).getDmdtTrfNm());
					if (i < tariffList.size() - 1) sbTariff.append("|");
				}
			}
			eventResponse.setETCData("TARIFF", sbTariff.toString());
			
			CommonCodeVO			commonCodeVO		= new CommonCodeVO();
			commonCodeVO.setIntgCdId("CD01975");
			
			List<CommonCodeVO> 		mnlInvRsnList 		= command.searchCommonCode(commonCodeVO);
			StringBuffer 			sbMnlInvRsn			= new StringBuffer();
			
			if (mnlInvRsnList != null && mnlInvRsnList.size() > 0) {
				for (int i = 0 ; i < mnlInvRsnList.size() ; i++) {
					sbMnlInvRsn.append(mnlInvRsnList.get(i).getIntgCdValCtnt()).append("=").append(mnlInvRsnList.get(i).getIntgCdValDpDesc());
					if (i < mnlInvRsnList.size() - 1) sbMnlInvRsn.append("|");
				}
			}
			eventResponse.setETCData("INV_RSN", sbMnlInvRsn.toString());
			//===============================================================================================================
			
			String 					curr_day 			= command.searchCurrentDateByOffice(account.getOfc_cd());
			eventResponse.setETCData("OFC_CURR_DAY", curr_day);
			//===============================================================================================================
			
			commonCodeVO.setIntgCdId("CD00764");
			
			List<CommonCodeVO> 		rcvTermList 		= command.searchCommonCode(commonCodeVO);
			StringBuffer 			sbRcvTerm 			= new StringBuffer();
			
			if (rcvTermList != null && rcvTermList.size() > 0) {
				for (int i = 0 ; i < rcvTermList.size() ; i++) {
					sbRcvTerm.append(rcvTermList.get(i).getIntgCdValCtnt()).append("=").append(rcvTermList.get(i).getIntgCdValDpDesc());
					if (i < rcvTermList.size() - 1) sbRcvTerm.append("|");
				}
			}
			eventResponse.setETCData("RCV_TERM", sbRcvTerm.toString());
			//==================================================================================================================
			
			commonCodeVO.setIntgCdId("CD00765");
			
			List<CommonCodeVO> 		deTermList 			= command.searchCommonCode(commonCodeVO);
			StringBuffer 			sbDeTerm 			= new StringBuffer();
			
			if (deTermList != null && deTermList.size() > 0) {
				for (int i = 0 ; i < deTermList.size() ; i++) {
					sbDeTerm.append(deTermList.get(i).getIntgCdValCtnt()).append("=").append(deTermList.get(i).getIntgCdValDpDesc());
					if (i < deTermList.size() - 1) sbDeTerm.append("|");
				}
			}
			eventResponse.setETCData("DE_TERM", sbDeTerm.toString());
			//====================================================================================================================		
	
			String usrCntCd = command.searchUserCntCode(account.getOfc_cd());
	
			eventResponse.setETCData("USR_CNT_CD", usrCntCd);
			//====================================================================================================================
			
			List<ARCurrencyVO> 		invCurrList 		= command.searchARCurrencyList(event.getChargeBookingInvoiceVO().getOfcCd(),"");//4002 EUR 추가로 변경
			StringBuffer 			sbInvCurr			= new StringBuffer();
			
			if (invCurrList != null && invCurrList.size() > 0) {
				for (int i = 0 ; i < invCurrList.size() ; i++) {
					sbInvCurr.append(invCurrList.get(i).getArCurrCd()).append("=").append(invCurrList.get(i).getArCurrCd());
					if (i < invCurrList.size() - 1) sbInvCurr.append("|");
				}
			}
			eventResponse.setETCData("AR_CURRENCY", sbInvCurr.toString());
			//====================================================================================================================

			//=========================================
			//2015.10.27 #7995 comment start
			//2017.01.12 #23259 India Invoice
		    //인도인 경우 GST 관련 Tax rate를 조회. (2012.05.24)
			if(usrCntCd.equals("IN")){
				String iss_dt ="" ;
				SearchIndiaGstRateVO indiaGstRateVO = Issuecommand.searchIndiaGstRate(iss_dt);
				eventResponse.setETCData("IDA_EXPN_TAX_RT", indiaGstRateVO.getIdaExpnTaxRt());
				eventResponse.setETCData("IDA_EDU_TAX_RT", indiaGstRateVO.getIdaEduTaxRt());
				eventResponse.setETCData("IDA_HIGH_EDU_TAX_RT", indiaGstRateVO.getIdaHighEduTaxRt());
			}
			else
			{
				eventResponse.setETCData("IDA_EXPN_TAX_RT"		, "");
				eventResponse.setETCData("IDA_EDU_TAX_RT"		, "");
				eventResponse.setETCData("IDA_HIGH_EDU_TAX_RT"	, "");
			}
			//2015.10.27 #7995 comment e n d
			//=========================================	
			//====================================================================================================================		
	
			String repCustSeq = command.searchRepCustSeq(account.getOfc_cd());
	
			eventResponse.setETCData("REP_CUST_SEQ", repCustSeq);
			//====================================================================================================================
			
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	} 	

	/**
	 * EES_DMT_4004 : Retrieve <br>
	 * Retrieving Charge Currency by BKG No., Tariff. <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @throws EventException 
	 */
	private EventResponse searchChargeCurrency(Event e) throws EventException {
		GeneralEventResponse 		eventResponse 		= new GeneralEventResponse();
		InvoiceIssueCollectionMgtBC invCommand 			= new InvoiceIssueCollectionMgtBCImpl();
		CommonFinderBC 				comCommand 			= new CommonFinderBCImpl();
		EesDmt4004Event				event				= (EesDmt4004Event) e;
		ChargeBookingInvoiceVO		chargeVO			= event.getChargeBookingInvoiceVO();

		try {
       		String 		rateCurrency 	= invCommand.searchRateCurrency(chargeVO.getBkgNo(), chargeVO.getDmdtTrfCd());
       		//============================================================================================================================
       		
       		CoverageVO coverageVO	= new CoverageVO();
   			coverageVO.setCntCd(		chargeVO.getCntCd()			);
   			
   			if (rateCurrency != null &&  !"".equals(rateCurrency)) {
   				coverageVO.setUseRtCurr(	chargeVO.getUseRtCurr()		);
       			coverageVO.setRtCurrCd(		rateCurrency				);
   			}
       		
       		List<CurrencyVO> 	currencyList 	= comCommand.searchCurrencyList(coverageVO);
       		
    		StringBuffer sbCurrency = new StringBuffer();
    		if (currencyList != null && currencyList.size() > 0) {
    			for (int i = 0 ; i < currencyList.size() ; i++) {
    				sbCurrency.append(currencyList.get(i).getCurrCd()).append("=").append(currencyList.get(i).getCurrNm());
    				if (i < currencyList.size() - 1) sbCurrency.append("|");
    			}
    		}
    		eventResponse.setETCData("CHG_CURR_CD", sbCurrency.toString());
    		//============================================================================================================================
    		
        } catch(EventException ex) {
            eventResponse.setUserMessage(ex.getMessage());
            throw ex;
        } catch(Exception ex){
        	eventResponse.setUserMessage(ex.getMessage());
        	throw new EventException(ex.getMessage(), ex);
        }
        return eventResponse; 
	}
}