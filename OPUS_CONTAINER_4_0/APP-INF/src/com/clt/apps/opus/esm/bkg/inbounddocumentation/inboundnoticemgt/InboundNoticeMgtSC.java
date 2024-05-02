/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InboundNoticeMgtSC.java
*@FileTitle : Arrival Notice Form Setting tab#1
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.vo.HistoryLineVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgComboVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.MdmCustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBC;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.basic.GeneralBookingReceiptBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.ArrivalNoticeBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.HoldNoticeBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.HoldNoticeBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.PickUpNoticeBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.basic.PickUpNoticeBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0001Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0052Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0240Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0242Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0243Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0375Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0381Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0411Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0414Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0510Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0511Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0672Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0760Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0764Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0941Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0946Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0948Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0956Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0992Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg0993Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1002Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1020Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1021Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1034Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1044Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg105499Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1054Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1058Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1063Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1064Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1066Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1067Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1068Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event.EsmBkg1099Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustCodeErrListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustRefVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustUploadListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcGrpSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcGrpSendVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcInfoListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcMrdVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcWdVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.BkgNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ConfirmHldNtcSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdEvaluationVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdValidationVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.HoldNoticeFormVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IbCustCntcHisVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.IbCustCntcVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MrnRtnYdVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.NoticeVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoMnlUpldVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoRptVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNoVerifyVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcFormVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcManualListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSentHisListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PkupNtcSentHisSchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.PreHldNtcSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.RsltCdListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.TpbInfoVO;
import com.clt.apps.opus.esm.bkg.servicesio.InboundDocumentationProxy;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.component.util.code.CodeUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.db.RowSetUtil;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.framework.table.ComBakEndJbVO;
import com.clt.syscommon.common.table.BkgArrNtcCntrVO;
import com.clt.syscommon.common.table.BkgArrNtcDtlVO;
import com.clt.syscommon.common.table.BkgArrNtcWdDtlVO;
import com.clt.syscommon.common.table.BkgArrNtcWdVO;
import com.clt.syscommon.common.table.BkgCustTmpltVO;
import com.clt.syscommon.common.table.BkgHldNtcUsrVO;
import com.clt.syscommon.common.table.BkgHldWdVO;
import com.clt.syscommon.common.table.BkgIbCmdtCntcVO;
import com.clt.syscommon.common.table.BkgIbCustCntcStupVO;
import com.clt.syscommon.common.table.BkgIbCustCntcVO;
import com.clt.syscommon.common.table.BkgMdmCrCustVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;
import com.clt.syscommon.common.table.BkgPkupCntrRtnYdVO;
import com.clt.syscommon.common.table.BkgPkupNtcPkupNoHisVO;
import com.clt.syscommon.common.table.BkgTroActCustVO;


/**
 * InboundBLMgt Business Logic ServiceCommand - Handling business transaction for InboundBLMgt
 * 
 * @author
 * @see InboundNoticeDBDAO
 * @since J2EE 1.4
 */

public class InboundNoticeMgtSC extends ServiceCommandSupport {
    // Login User Information
    protected SignOnUserAccount account = null;

    /**
     * InboundBLMgt system preceding process for biz scenario<br>
     * Inbound Creating related object by calling work scenario<br>
     */
    public void doStart() {
        try {
            account = getSignOnUserAccount();
        } catch (Exception e) {
            log.error(e.getLocalizedMessage());
        }
    }

    /**
     * InboundBLMgt system Handling for the end of working scenario<br>
     * Inbound Clearing object by the end of work scenario<br>
     */
    public void doEnd() {
        log.debug("InboundNoticeMgtSC end");
        
    }

    /**
     * Handling working scenario of each event<br>
     *
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    public EventResponse perform(Event e) throws EventException {
        // RDTO(Data Transfer Object including Parameters)
        EventResponse eventResponse = null;
        

        if (e.getEventName().equalsIgnoreCase("EsmBkg0375Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//search
                eventResponse = searchArrNtcForm(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//Pod cd
                eventResponse = searchArrNtcFormPodList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {//Agent
                eventResponse = searchArrNtcFormAgentList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = setupArrNtcForm(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.REMOVE01)) {
                eventResponse = removeArrNtcForm(e);
            } 
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0001Event")) {  // Notice Sent History
        	if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
        		eventResponse = searchBkgNtcHis(e);
        	}
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0411Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchPkupNtcForm(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = searchPkupNtcFormDelList(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = setupPkupNtcForm (e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = removePkupNtcForm (e);
            }
            else {
            	eventResponse = getComIntgCodes(new String[]{"CD02133"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C", "X"}});
            }

        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0760Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHldNtcConfirmForm(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = setupHldNtcConfirmForm(e);
			}
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg1066Event")) {
            if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = modifyPkupNtcSendList (e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchPkupNtcSendList(e);
            }
            // Send Fax
            else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = sendPkupNtcByFax(e);
            }
            // Send Email
            else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {
                eventResponse = sendPkupNtcByEmail(e);
            }
            // Stop Send
            else if (e.getFormCommand().isCommand(FormCommand.MULTI11)) {
                eventResponse = stopPkupNtcSend(e);
            }
            // Resume Send
            else if (e.getFormCommand().isCommand(FormCommand.MULTI12)) {
                eventResponse = resumePkupNtcSend(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.MULTI20)) {
                eventResponse = verifyPkupNtcList(e);
            }
            else {
            	eventResponse = getComIntgCodesWithEvent(new String[]{"CD02133"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C", "X"}},eventResponse);
            	eventResponse = getComIntgCodesWithEvent(new String[]{"CD02539"}, new String[]{"type_code"}, new String[]{"type_value"}, new String[]{"|"}, new String[][]{{"TO", "WO"}}, eventResponse);
            	eventResponse = getComIntgCodesWithEvent(new String[]{"CD02599"}, new String[]{"event_code"}, new String[]{"event_value"}, new String[]{"|"}, new String[][]{{"TO", "WO"}}, eventResponse);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0511Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchHldNtcFormPodList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchHldNtcPreForm(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = setupHldNtcPreForm(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeHldNtcForm(e);
			}

        } else if (e.getEventName().equalsIgnoreCase("EsmBkg1058Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPkupMtRtnCy(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = setupPkupMtRtnCy(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkPkupMtRtnCy(e);
			}
        
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0992Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkPkupNtcFormExist(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = copyPkupNtcForm(e);
			}
			
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0993Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchPkupNtcListByManual(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = setupPkupNtcListByManual(e);
            }

        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0948Event")) {
    		/* retrieve */
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchHldNtcUsr(e);
            } 
    		/* save */
            else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = setupHldNtcUsr(e);
            }
    		/* checking Location Code validation */
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = validateLoc(e);
            } 
    		/* Hold Code retrieve */
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) 
            {
                eventResponse = searchHldNtcCode(e);
            }
            else{
            	eventResponse = getComIntgCodesWithEvent(new String[]{"CD02597"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C", "X"}}, eventResponse);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0240Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//Customer Main (MDM)
                eventResponse = searchIntgCustCntcInfo(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {//Detail IB
                eventResponse = this.searchIntgCustCntcInfoByIB(e);
            }else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {//Save
                eventResponse = this.manageIntgCustCntcInfoByIB(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {//Detail OB
                eventResponse = this.searchIntgCustCntcInfoByOB(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {//Detail Invoice
                eventResponse = this.searchIntgCustCntcInfoByInvoice(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {//Detail TRO
                eventResponse = this.searchIntgCustCntcInfoByTRO(e);
            }
            //common code + naming table
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH19)) {
				eventResponse = this.searchComCodeDescList(e);
			}
			else {
            	eventResponse = getComIntgCodesWithEvent(new String[]{"CD02129"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C", "X"}}, eventResponse);
            	eventResponse = getComIntgCodesWithEvent(new String[]{"CD00690"}, new String[]{"status_code"}, new String[]{"status_value"}, new String[]{"|"}, new String[][]{{"C", "X"}},eventResponse);
			}

        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0242Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//(Consignee)
                eventResponse = searchArrNtcCustInfo(e);
            }
            
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0510Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // Pre-Hold Notice
				eventResponse = searchHldNtcSendListByPre(e);
			}		
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // Confirmation Notice
				eventResponse = searchHldNtcSendListByConfirm(e);
			}		
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) { // Confirmation Notice
				eventResponse = checkHldNtcFormExistByNtcType(e);
			}		
			else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) { // Pre-Hold Fax
				eventResponse = sendPreHldNtcByFax(e);
			}		
			else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) { // Pre-Hold Email
				eventResponse = sendPreHldNtcByEmail(e);
			}		
			else if (e.getFormCommand().isCommand(FormCommand.MULTI11)) { // Confirm-Hold Fax
				eventResponse = sendConfirmHldNtcByFax(e);
			}		
			else if (e.getFormCommand().isCommand(FormCommand.MULTI12)) { // Confirm-Hold Email
				eventResponse = sendConfirmHldNtcByEmail(e);
			}		
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND40)) { // for test
				eventResponse = createCstmsHld(e);
			}		
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0672Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {// [672-1] Retrieve Arrival Data
                eventResponse = searchArrNtcInfoList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {//(Consignee)[672-2]
            	eventResponse = this.searchArrNtcCustList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {//(Upload_Match)[672-3]                
            	eventResponse = this.searchArrNtcCustListForUpload (e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {// [672-1] Update Arrival Data Modify
                eventResponse = this.setupArrNtcInfoList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {// [672-2] Customer
                eventResponse = this.modifyArrNtcCustList (e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI04)) {// [672-3] Upload_Match
                eventResponse = this.createArrNtcCustListbyUpload (e);
            }else{
            	eventResponse = getComIntgCodes(new String[]{"CD02123"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C", "X"}});
            }
        }else if  (e.getEventName().equalsIgnoreCase("EsmBkg0941Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchArrNtcCustCodeErrReport(e);
            } else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
                eventResponse = confirmArrNtcCustCodeErrReport(e);
            } else {
            	eventResponse = getComIntgCodes(new String[]{"CD01655", "CD00880"}, new String[]{"code", "cust_code"}, new String[]{"value", "cust_value"}, new String[]{"|", "|"}, new String[][]{{"C", "X"}, {"A", "B", "E", "F", "S"}});
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg1034Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchPkupNtcFormByManual(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = setupPkupNtcFormByManual(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0243Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = this.searchArrNtcFormDtl (e);
            }else{
            	eventResponse = getComIntgCodes(new String[]{"CD02123"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C", "X"}});
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg0052Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = this.searchArrNtcMrnRtnYd(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
                eventResponse = this.setupArrNtcMrnRtnYd(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0764Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // main search
                eventResponse = searchIntgCustCntcInfoHistory (e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { // customer's name about customer code
                eventResponse = searchMdmCust(e);
            } else {
            	eventResponse = getComIntgCodes(new String[]{"CD02129"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C", "X"}});
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg1002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = checkHldNtcFormExist(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = copyHldNtcPreForm(e);
			}

        }else if (e.getEventName().equalsIgnoreCase("EsmBkg1021Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchArrNtcBankAcct (e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = setupArrNtcBankAcct(e);
            }else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
                eventResponse = removeArrNtcBankAcct(e);
            }
        }else if (e.getEventName().equalsIgnoreCase("EsmBkg1020Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchArrNtcGrpForm(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = setupArrNtcGrpForm(e);
            }else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
                eventResponse = setupArrNtcGrpForm(e);
            }    
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg1044Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchCustCmdtCntcInfo(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageCustCmdtCntcInfo(e);
            }    
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg1054Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {//Code Validation
                eventResponse = manageArrNtcCodeValidation(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {// CodeValidation Result (UnMatch List)
                eventResponse = searchArrNtcUnMatchCustList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {// CodeValidation Result (Match List)
                eventResponse = searchArrNtcMatchCustList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {// CodeValidation Validation Unmatch List
                eventResponse = manageArrNtcUnMatchCust(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) {// CodeValidation Reject Validation
                eventResponse = cancelArrNtcCustCdVal(e);
            }else {
            	eventResponse = getComIntgCodes(new String[]{"CD01655"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C", "X"}});
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0414Event")) { // Pick-Up Notice Sent History
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {// Search
                eventResponse = searchPkupNtcSentHistory (e);
            } else {
            	eventResponse = getComIntgCodes(new String[]{"CD02133"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C", "X"}});
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg105499Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Code Validation
                eventResponse = searchManualValInfo(e);
	        }else {
	        	eventResponse = getComIntgCodes(new String[]{"CD01655"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C"}});
	        }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0381Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {                
                eventResponse = this.searchArrNtcSendList(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//Fax transmission                
            	eventResponse = this.sendArrNtcByFax(e);
            }else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {//Email transmission                
            	eventResponse = this.startBackEndJobArrivalNoticeSendEmail(e); //sendArrNtcByEmail
            }else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {    // (공통) Get status of Back End Job (TRANSMIT)
				String backEndJobKey = e.getAttribute("backEndJob_Key").toString();
				eventResponse = getBackEndJobStatus(backEndJobKey);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {    // Result return (TRANSMIT)
				String backEndJobKey = e.getAttribute("backEndJob_Key").toString();
				eventResponse = resultBackEndJobSendArrivalNoticeEmail(backEndJobKey);
			}else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {//Email transmission per B/L                
            	eventResponse = this.sendArrNtcByEmail(e);
            }else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)){//RD Type information
            	eventResponse = this.searchArrNtcMrdId(e);
            }else {
            	eventResponse = getComIntgCodesWithEvent(new String[]{"CD20066"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C"}}, eventResponse);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0956Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = this.searchArrNtcHldRmk(e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//modify
            	eventResponse = this.setupArrNtcHldRmk(e);
            }
        } else if (e.getEventName().equalsIgnoreCase("EsmBkg0946Event")) {
        	
            if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
                eventResponse = this.searchArrNtcGrpSendList(e);
            //sending a Fax
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {//               
            	eventResponse = this.sendArrNtcByGrpFax (e);
            //Mailing
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {//               
            	eventResponse = this.sendArrNtcByGrpEmail(e);
            //data for Proxy Test
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI11)) {//               
            	
            	//receive each vvd
            	new InboundDocumentationProxy().receiveOtsInfoTest();           	
            	
            }
        } 
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1063Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPkupNoMnlUpldList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchPkupNoMnlUpldList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = managePkupNoMnlUpldList(e);
			}
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
                eventResponse = executePickupSetting(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
                eventResponse = monitorPickupSetting(e);
            }
            else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
                eventResponse = isRunningBatch(e);
            }
			
		}
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1064Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = searchParsedPkupNoRpt(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = searchPkupNoVerifyRpt(e);
			}
		}
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1067Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchPkupNoHisList(e);
			}
		}
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1068Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = setupTpbInfo(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchTpbInfo(e);
			}
		}
        else if (e.getEventName().equalsIgnoreCase("EsmBkg1099Event")) {
            if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
                eventResponse = searchIntgCustCntcUpdtStupInfoByOfc (e);
            }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
                eventResponse = manageIntgCustCntcUpdtStupInfoByOfc(e);
            }
        }

        
        return eventResponse;
    }

    /**
     * VARIABLE UI - Code Selection<br>
     * @param String[] intgCdIds
     * @param String[] intgCdValCtntNames
     * @param String[] intgCdValDpDescNames
     * @param String[] concatStrs
     * @param String[][] excludeCodeList
     * @exception EventException
     * @return EventResponse
     * @author
     */
    private EventResponse getComIntgCodes(String[] intgCdIds, String[] intgCdValCtntNames, String[] intgCdValDpDescNames, String[] concatStrs, String[][] excludeCodeList ) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try {
	    	CodeUtil codeUtil = com.clt.framework.component.util.code.CodeUtil.getInstance();
	    	
//	    	if (!(intgCdIds == null || intgCdIds.length == 0
//	    			|| intgCdValCtntNames == null || intgCdValCtntNames.length == 0
//	    			|| intgCdValDpDescNames == null || intgCdValDpDescNames.length == 0)
//	    		&& (intgCdIds.length == intgCdValCtntNames.length
//	    				&& intgCdIds.length == intgCdValDpDescNames.length) 
//	    	   ) {
	    	if (!(intgCdIds.length == 0	|| intgCdValCtntNames.length == 0 || intgCdValDpDescNames.length == 0)
	    		&& (intgCdIds.length == intgCdValCtntNames.length
	    				&& intgCdIds.length == intgCdValDpDescNames.length) 
	    	   ) {
	    		Collection<CodeInfo> codeRslt = null;
	    		StringBuffer sbCode = new StringBuffer();
		    	StringBuffer sbValue = new StringBuffer();
		    	CodeInfo[] codeInfoVOs = null;
		    	boolean isExclude = false;
		    	String[] excludeCodes = null;
		    	
		    	for (int idx = 0; idx < intgCdIds.length; idx++) {
		    		codeRslt = (Collection<CodeInfo>)codeUtil.getCodeSelect(intgCdIds[idx], 0);

		    		codeInfoVOs = new CodeInfo[codeRslt.size()];
			    	codeRslt.toArray(codeInfoVOs);

			    	if (excludeCodeList != null) {
			    		excludeCodes = excludeCodeList[idx];
			    	}
			    	
			    	for (int i = 0; i< codeInfoVOs.length; i ++) {

			    		if (excludeCodes != null && excludeCodes.length >0) {
			    			for (int j = 0; j < excludeCodes.length; j ++) {
			    				if (codeInfoVOs[i].getCode().equals(excludeCodes[j]) ) {
			    					isExclude = true;
			    					break;
			    				}
			    			}
			    		}
			    		if (!isExclude) {
			        		sbCode.append(codeInfoVOs[i].getCode());
			        		sbValue.append(codeInfoVOs[i].getName());
			        		if (i < codeInfoVOs.length -1) {
			        			sbCode.append(concatStrs[idx]);
			        			sbValue.append(concatStrs[idx]);
			        		}
			    		}
			    		
			    		isExclude = false;
			    	}
			    	log.debug("===============================================");
			    	log.debug("======== sbCode.toString()          ===========");
			    	log.debug("===============================================");
			    	log.debug(sbCode.toString());
			    	
			    	log.debug("===============================================");
			    	log.debug("======== sbValue.toString()         ===========");
			    	log.debug("===============================================");
			    	log.debug(sbValue.toString());

			    	eventResponse.setETCData(intgCdValCtntNames[idx], sbCode.toString());
			    	eventResponse.setETCData(intgCdValDpDescNames[idx], sbValue.toString());
		    		
			    	sbCode.delete(0, sbCode.length() );
			    	sbValue.delete(0, sbValue.length());
		    	}
	    			
		    	
	    	}
	    	
	    	
    	} catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
    	return eventResponse;
    	
    }

    /**
     * VARIABLE UI - Code Selection<br>
     * @param String[] intgCdIds
     * @param String[] intgCdValCtntNames
     * @param String[] intgCdValDpDescName
     * @param String[] concatStrs
     * @param String[][] excludeCodeList
     * @exception EventException
     * @return EventResponse
     * @author
     */
    private EventResponse getComIntgCodesWithEvent(String[] intgCdIds, String[] intgCdValCtntNames, String[] intgCdValDpDescNames, String[] concatStrs, String[][] excludeCodeList , EventResponse eventResponse) throws EventException {

    	try {
	    	CodeUtil codeUtil = com.clt.framework.component.util.code.CodeUtil.getInstance();
	    	if ( eventResponse == null) {
	    		 eventResponse = new GeneralEventResponse();
	    	}
	    	
//	    	if (!(intgCdIds == null || intgCdIds.length == 0
//	    			|| intgCdValCtntNames == null || intgCdValCtntNames.length == 0
//	    			|| intgCdValDpDescNames == null || intgCdValDpDescNames.length == 0)
//	    		&& (intgCdIds.length == intgCdValCtntNames.length
//	    				&& intgCdIds.length == intgCdValDpDescNames.length) 
//	    	   ) {
	    	if (!(intgCdIds.length == 0	|| intgCdValCtntNames.length == 0 || intgCdValDpDescNames.length == 0)
	    		&& (intgCdIds.length == intgCdValCtntNames.length
	    				&& intgCdIds.length == intgCdValDpDescNames.length) 
	    	   ) {
	    		Collection<CodeInfo> codeRslt = null;
	    		StringBuffer sbCode = new StringBuffer();
		    	StringBuffer sbValue = new StringBuffer();
		    	CodeInfo[] codeInfoVOs = null;
		    	boolean isExclude = false;
		    	String[] excludeCodes = null;
		    	
		    	for (int idx = 0; idx < intgCdIds.length; idx++) {
		    		codeRslt = (Collection<CodeInfo>)codeUtil.getCodeSelect(intgCdIds[idx], 0);

		    		codeInfoVOs = new CodeInfo[codeRslt.size()];
			    	codeRslt.toArray(codeInfoVOs);

			    	if (excludeCodeList != null) {
			    		excludeCodes = excludeCodeList[idx];
			    	}
			    	
			    	for (int i = 0; i< codeInfoVOs.length; i ++) {

			    		if (excludeCodes != null && excludeCodes.length >0) {
			    			for (int j = 0; j < excludeCodes.length; j ++) {
			    				if (codeInfoVOs[i].getCode().equals(excludeCodes[j]) ) {
			    					isExclude = true;
			    					break;
			    				}
			    			}
			    		}
			    		if (!isExclude) {
			        		sbCode.append(codeInfoVOs[i].getCode());
			        		sbValue.append(codeInfoVOs[i].getName());
			        		if (i < codeInfoVOs.length -1) {
			        			sbCode.append(concatStrs[idx]);
			        			sbValue.append(concatStrs[idx]);
			        		}
			    		}
			    		
			    		isExclude = false;
			    	}
			    	log.debug("===============================================");
			    	log.debug("======== sbCode.toString()          ===========");
			    	log.debug("===============================================");
			    	log.debug(sbCode.toString());
			    	
			    	log.debug("===============================================");
			    	log.debug("======== sbValue.toString()         ===========");
			    	log.debug("===============================================");
			    	log.debug(sbValue.toString());

			    	eventResponse.setETCData(intgCdValCtntNames[idx], sbCode.toString());
			    	eventResponse.setETCData(intgCdValDpDescNames[idx], sbValue.toString());
		    		
			    	sbCode.delete(0, sbCode.length() );
			    	sbValue.delete(0, sbValue.length());
		    	}
	    			
		    	
	    	}
	    	
	    	
    	} catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
    	return eventResponse;
    	
    }



    /**
     * ESM_BKG_0375 : retrieve event process<br>
     * Arrival Notice Form retrieve<br>
     * 
     * @author
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchArrNtcForm(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try {
	        // PDTO(Data Transfer Object including Parameters)
	        EsmBkg0375Event event = (EsmBkg0375Event)e;
	        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
	
	        BkgArrNtcWdVO aryBkgArrNtcWdVO = event.getArrNtcWdVO().getBkgArrNtcWdVO();
	
	        String ofcCd = aryBkgArrNtcWdVO.getOfcCd();
	        String podCd = aryBkgArrNtcWdVO.getPodCd();
	        String chnAgnCd = aryBkgArrNtcWdVO.getChnAgnCd();
	
	        ArrNtcWdVO arrNtcWdVO= command.searchArrNtcForm(ofcCd, podCd, chnAgnCd);
	
	        if (arrNtcWdVO.getBkgArrNtcWdVO() != null) { 
		        // insert etc_data to bkg_arr_ntc_wd
	        	BkgArrNtcWdVO bkgArrNtcWdVO = arrNtcWdVO.getBkgArrNtcWdVO();
	        	eventResponse.setETCData("an_seq"         , bkgArrNtcWdVO.getAnSeq());
	        	eventResponse.setETCData("arr_prv_fom_cd" , bkgArrNtcWdVO.getArrPrvFomCd());
	        	eventResponse.setETCData("locl_lang_flg"  , bkgArrNtcWdVO.getLoclLangFlg());
	        	eventResponse.setETCData("eclz_bl_cpy_flg", bkgArrNtcWdVO.getEclzBlCpyFlg());
		        
		        // bkg_arr_ntc_wd_dtl is converted into an xml.
		        List<BkgArrNtcWdDtlVO> arrNtcWdDtlList = new ArrayList<BkgArrNtcWdDtlVO>();
		        for (int i = 0; i < arrNtcWdVO.getBkgArrNtcWdDtlVOs().length; i ++) {
		        	arrNtcWdDtlList.add(arrNtcWdVO.getBkgArrNtcWdDtlVOs()[i]);
		        }
		        eventResponse.setRsVoList(arrNtcWdDtlList);
	        }
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }
    /**
	 * ESM_BKG_0375 : in case of changing Office<br>
	 * POD list registered with Arrival Notice Form retrieve<br>
	 * @author  
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchArrNtcFormPodList(Event e) throws EventException{
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try {
	        EsmBkg0375Event event = (EsmBkg0375Event)e;
	        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
	
	        List<BkgArrNtcWdVO> list = (List<BkgArrNtcWdVO>)command.searchArrNtcFormPodList(
	                event.getArrNtcWdVO().getBkgArrNtcWdVO().getOfcCd()
	                );
	
//	        String podCd = "";
//	        String anSeq = "";
	        
	        StringBuffer podCd = new StringBuffer();
	        StringBuffer anSeq = new StringBuffer();	        
	        
	        for(int i=0;i<list.size();i++){
//	            podCd = podCd + list.get(i).getPodCd() + "|";
//	            anSeq = anSeq + list.get(i).getAnSeq() + "|";
	        	
	        	podCd.append(list.get(i).getPodCd()).append("|");
	            anSeq.append(list.get(i).getAnSeq()).append("|");	        	
	        }
	
	        eventResponse.setETCData("code", podCd.toString());
	        eventResponse.setETCData("value", anSeq.toString());
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }
    /**
	 * ESM_BKG_0375 : in case of changing POD<br>
	 * Agent list registered with Arrival Notice Form retrieve<br>
	 * @author  
     * @param Event e 
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchArrNtcFormAgentList(Event e) throws EventException{
        // PDTO(Data Transfer Object including Parameters)
        log.debug("-------------------------------");
        log.debug("searchArrNtcFormAgentList method start");
        log.debug("-------------------------------");
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try {
	        EsmBkg0375Event event = (EsmBkg0375Event)e;
	        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
	
	        ArrNtcWdVO anfs = event.getArrNtcWdVO();
	        log.debug("-------------------------------");
	        log.debug("anfs " + anfs);
	        log.debug("-------------------------------");
	
	        List<BkgArrNtcWdVO> list = (List<BkgArrNtcWdVO>)command.searchArrNtcFormAgentList(
	                anfs.getBkgArrNtcWdVO().getOfcCd()
	                ,anfs.getBkgArrNtcWdVO().getPodCd()
	                );
	
//	        String chnAgnCd = "";
//	        String anSeq = "";
	        
	        StringBuffer chnAgnCd = new StringBuffer();
	        StringBuffer anSeq = new StringBuffer();
	        
	        for(int i=0;i<list.size();i++){
//	            chnAgnCd = chnAgnCd + list.get(i).getChnAgnCd() + "|";
//	            anSeq = anSeq + list.get(i).getAnSeq() + "|";
	        	
	        	chnAgnCd.append(list.get(i).getChnAgnCd()).append("|");
	            anSeq.append(list.get(i).getAnSeq()).append("|");
	        	
	            //eventResponse.setETCData(list.get(i).getColumnValues());
	        }
	
	        eventResponse.setETCData("code", chnAgnCd.toString());
	        eventResponse.setETCData("value", anSeq.toString());
	
	        log.debug("-------------------------------");
	        log.debug("searchArrNtcFormAgentList method end");
	        log.debug("-------------------------------");
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * ESM_BKG_0375 : Save Arrival Notice Form<br>
     * modifying Arrival Notice Form Data<br>
     * modifying master and detail at the same time<br>
     * @author
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse setupArrNtcForm(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0375Event event = (EsmBkg0375Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
        try{
            begin();
            ArrNtcWdVO arrNtcWdVO = event.getArrNtcWdVO();
            command.setupArrNtcForm(arrNtcWdVO.getBkgArrNtcWdVO(),arrNtcWdVO.getBkgArrNtcWdDtlVOs(),account);
            eventResponse.setETCData("opr_name", "I");
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0375 : Delete Arrival Notice Form<br>
     * delete Arrival Notice Form<br>
     * @author
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse removeArrNtcForm(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0375Event event = (EsmBkg0375Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
        try{
            begin();

            ArrNtcWdVO arrNtcWdVO = event.getArrNtcWdVO();
            command.removeArrNtcForm(arrNtcWdVO.getBkgArrNtcWdVO().getOfcCd()
            		                ,arrNtcWdVO.getBkgArrNtcWdVO().getPodCd()
            		                ,arrNtcWdVO.getBkgArrNtcWdVO().getChnAgnCd());
            eventResponse.setETCData("opr_name", "D");
            eventResponse.setUserMessage(new ErrorHandler("BKG00593").getUserMessage());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
    }

	/**
	 * ESM_BKG_0948 : Search<br>
	 * Hold Code information registered with each specific countries retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchHldNtcCode(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0948Event event = (EsmBkg0948Event)e;
        HoldNoticeBC command = new HoldNoticeBCImpl();

        try {
            List<BkgComboVO> list = command.searchHldNtcCode(event.getCntCd());
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }


    /**
	 * ESM_BKG_0948 : Search<br>
	 * checking Location Code validation<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */    
    private EventResponse validateLoc(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0948Event event = (EsmBkg0948Event)e;
        BookingUtil comboUtil = new BookingUtil();

        String locCd = event.getLocCd();

        try {
            boolean bResult = comboUtil.validateLoc(locCd);

            if (bResult == true) eventResponse.setETCData("loc_validate", "true");
            else eventResponse.setETCData("loc_validate", "false");

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }

        return eventResponse;
    }


	/**
	 * ESM_BKG_0948 : search event<br>
	 * retrieve set information by staff that wants to get automatically Mail or/and Alert<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */    
    private EventResponse searchHldNtcUsr(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0948Event event = (EsmBkg0948Event)e;
        HoldNoticeBC command = new HoldNoticeBCImpl();

        try {
            // retrieve condition
            String locCd     = event.getLocCd();
            String userId    = event.getUserId();

            List<BkgHldNtcUsrVO> list = command.searchHldNtcUsr(locCd, userId);
            eventResponse.setRsVoList(list);
            
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }

        return eventResponse;
    }

	/**
	 * ESM_BKG_0948 : setup<br>
	 * Hold Notice( Mail or/and Alert ) Setting information add/modify/remove by staff<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse setupHldNtcUsr(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0948Event event = (EsmBkg0948Event)e;
        HoldNoticeBC command = new HoldNoticeBCImpl();

        try{
            begin();
            command.setupHldNtcUsr(event.getBkgHldNtcUsrVOS(),account);
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110", new String[]{"Setup"}).getMessage(), ex);
        }

		return eventResponse;
    }

    /**
     * ESM_BKG_1054 : Save Notice of discharge and arrival - Customer Code Validation<br>
     * perform Backend job for Customer code Validation<br>
     * @author
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageArrNtcCodeValidation(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            begin();
            EsmBkg1054Event event = (EsmBkg1054Event)e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
            ArrNtcSearchVO anSearch = event.getArrNtcSearchVO();
	        anSearch.setValUsrId(account.getUsr_id()); // move depending on model change
	        anSearch.setValOfcCd(account.getOfc_cd()); // move depending on model change
            String key = command.manageArrNtcCodeValidation(anSearch); 
            eventResponse.setETCData("background_job_key", key);
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_BKG_0240-1 : retrieve event handling<br>
     * Integrated Customer Data Management Open event handling<br>
     * Master retrieve
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     * by 
     */
    private EventResponse searchIntgCustCntcInfo(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0240Event event = (EsmBkg0240Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
       
        try{
        	IbCustCntcVO bkgIbCustCntcVO = command.searchIntgCustCntcInfo(event.getIntgCustSearchVO());
	        eventResponse.setRsVoList(bkgIbCustCntcVO.getMdmCustomerVO());
	        eventResponse.setRsVoList(bkgIbCustCntcVO.getDetailBkgIbCustCntcVO());
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }


        return eventResponse;
    }
    
    /**
     * retrieve event handling<br>
     * Integrated Customer Data Management Open event handling<br>
     * I/B Tab retrieve
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchIntgCustCntcInfoByIB(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0240Event event = (EsmBkg0240Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	String custCntCdIb = event.getIntgCustSearchVO().getCustCntCdIb();
        	String custSeqIb = event.getIntgCustSearchVO().getCustSeqIb();
        	String ofcCd = "";
        	//retrieve at IB Tab after directly entering OFC_CD
        	if(event.getIntgCustSearchVO().getOfcCdIb() != null 
        			&& !event.getIntgCustSearchVO().getOfcCdIb().equals("")){
        		ofcCd = event.getIntgCustSearchVO().getOfcCdIb();
        	}else{
        		ofcCd = event.getIntgCustSearchVO().getLoginOfcCd();
        	}
        	
        	eventResponse.setRsVoList(
                (List<IbCustCntcVO>)command.searchIntgCustCntcInfoByIB(custCntCdIb ,custSeqIb ,ofcCd));
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        

        return eventResponse;
    }
    
    /**
     * ESM_BKG_0240: save I/B Customer Info<br>
     * 
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse manageIntgCustCntcInfoByIB(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0240Event event = (EsmBkg0240Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

        try{
            begin();
            BkgIbCustCntcVO[] bkgIbCustCntcVOs = event.getBkgIbCustCntcVOs();
            String ofcCd = "";
            for(int i=0;i<bkgIbCustCntcVOs.length;i++){
            	//retrieve at IB Tab after directly entering OFC_CD
            	if(event.getIntgCustSearchVO().getOfcCdIb() != null 
            			&& !event.getIntgCustSearchVO().getOfcCdIb().equals("")){
            		ofcCd = event.getIntgCustSearchVO().getOfcCdIb();
            	}else{
            		ofcCd =	event.getIntgCustSearchVO().getLoginOfcCd();
            	}
            	log.debug("------------------- ofcCd " + ofcCd);
            	log.debug("------------------- event.getIntgCustSearchVO() " + event.getIntgCustSearchVO().getColumnValues());
                bkgIbCustCntcVOs[i].setCustCntCd(event.getIntgCustSearchVO().getCustCntCdIb());
                bkgIbCustCntcVOs[i].setCustSeq(event.getIntgCustSearchVO().getCustSeqIb());
                bkgIbCustCntcVOs[i].setOfcCd(ofcCd);
                log.debug("------------------- bkgIbCustCntcVOs[i] " + bkgIbCustCntcVOs[i].getColumnValues());
            }
            command.manageIntgCustCntcInfoByIB(bkgIbCustCntcVOs,event.getSignOnUserAccount());
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_0240-02 : Integrated Customer Data Management(OB) Open event process<br>
     * retrieve event process<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchIntgCustCntcInfoByOB(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0240Event event = (EsmBkg0240Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	eventResponse.setRsVoList(
                (List<BkgCustTmpltVO>)command.searchIntgCustCntcInfoByOB(
                        event.getIntgCustSearchVO().getCustCntCdIb()
                        ,event.getIntgCustSearchVO().getCustSeqIb()
                        ));
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * ESM_BKG_0240-03 : retrieve event process<br>
     * Integrated Customer Data Management(Invoice) Open event process<br> 
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchIntgCustCntcInfoByInvoice(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0240Event event = (EsmBkg0240Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	eventResponse.setRsVoList(
                (List<BkgMdmCrCustVO>)command.searchIntgCustCntcInfoByInvoice(
                        event.getIntgCustSearchVO().getCustCntCdIb()
                        ,event.getIntgCustSearchVO().getCustSeqIb()
                        ));
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * retrieve event process<br>
     * Integrated Customer Data Management(TRO) Open event process<br>
     * [240-4]
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchIntgCustCntcInfoByTRO(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0240Event event = (EsmBkg0240Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	eventResponse.setRsVoList(
                (List<BkgTroActCustVO>)command.searchIntgCustCntcInfoByTRO(
                        event.getIntgCustSearchVO().getCustCntCdIb()
                        ,event.getIntgCustSearchVO().getCustSeqIb()
                        ));
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * ESM_BKG_0242-01 : retrieve event process<br>
     * AN Setting Screen_Customer Information(Consignee)<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchArrNtcCustInfo (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0242Event event = (EsmBkg0242Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        String bkgNo = event.getArrNtcCustRefVO().getBkgNo();
        String custTpCd = event.getArrNtcCustRefVO().getBkgCustTpCd();
        try{
        	eventResponse.setRsVoList(
                (List<ArrNtcCustRefVO>)command.searchArrNtcCustInfo(bkgNo,custTpCd));
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }
 
    /**
     * ESM_BKG_0672-01 : retrieve event process<br>
     * A/N Setting Screen_Arrival Data information retrieve (Paging)(1)<br>
     * 
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchArrNtcInfoList  (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0672Event event = (EsmBkg0672Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

         GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	List<ArrNtcInfoListVO> saveVO = (List<ArrNtcInfoListVO>)command.searchArrNtcInfoList(event.getArrNtcSearchVO(),account);
        	eventResponse.setRsVoList(saveVO);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }

        return eventResponse;
    }
    /**
     * ESM_BKG_1054 : Retrieve Customer Code Validation<br>
     * retrieve information corresponding to unmatch after Customer Code Validation<br>
     * 
     * @author
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
	@SuppressWarnings("unchecked")
	private EventResponse searchArrNtcUnMatchCustList (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            EsmBkg1054Event event = (EsmBkg1054Event)e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            ArrNtcSearchVO arrNtcSearchVO = event.getArrNtcSearchVO();
            List<CustCdValidationVO> unmatchList = null;

            if(arrNtcSearchVO.getMtchChkFlg() == null || arrNtcSearchVO.getMtchChkFlg().equals("")) {
                // checking Backend job Progress
                BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(arrNtcSearchVO.getBackgroundJobKey());

                DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
                List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);

                ComBakEndJbVO jobVo = null;
                if (dbRowSetlist.size() == 0) {
                    jobVo = new ComBakEndJbVO();
                    jobVo.setJbStsFlg("0");
                } else {
                    jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);
                }

                eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
                if (jobVo.getJbStsFlg().equals("3")) {
                    // retrieve if Backend job is end
                    unmatchList = command.searchArrNtcUnMatchCustList(arrNtcSearchVO, account);
                    eventResponse.setRsVoList(unmatchList);
                }
            } else if(arrNtcSearchVO.getMtchChkFlg().equals("N")) {
                // handling for unmatch case
                unmatchList = command.searchArrNtcUnMatchCustList(arrNtcSearchVO, account);
                eventResponse.setRsVoList(unmatchList);
            }
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }


    /**
     * ESM_BKG_1054 : Search Customer Code Validation<br> 
     * retrieve information corresponding to match after Customer Code Validation<br>
     * @author
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchArrNtcMatchCustList (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            EsmBkg1054Event event = (EsmBkg1054Event)e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            ArrNtcSearchVO arrNtcSch = event.getArrNtcSearchVO();
            arrNtcSch.setOfcCd(account.getOfc_cd());  // move depending on model change
            List<CustCdValidationVO> list = command.searchArrNtcMatchCustList(arrNtcSch);

            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * ESM_BKG_1054-99 : Search Customer Code Validation<br> 
     * retrieve information corresponding to match after Customer Code Validation<br>
     * @author
     * @param Event e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchManualValInfo (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
            EsmBkg105499Event event = (EsmBkg105499Event)e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            ArrNtcSearchVO arrNtcSearchVO = event.getArrNtcSearchVO();

            List<CustCdValidationVO> list = command.searchManualValInfo(arrNtcSearchVO, account);
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }
    

	/**
	 * ESM_BKG_0411 : Search<br>
	 * retrieve setting information about PickUp Notice Form<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
     
    private EventResponse searchPkupNtcForm(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0411Event event = (EsmBkg0411Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try {

            String ntcSndTpCd = event.getNtcSndTpCd();
            String ofcCd = event.getOfcCd();
            String delCd = event.getDelCd();
            String eqOfcCntCd = "";

            PkupNtcFormVO pickUpNoticeFormVO = command.searchPkupNtcForm(ntcSndTpCd, ofcCd, delCd);

            eventResponse.setRsVo(pickUpNoticeFormVO.getBkgPkupNtcStupVO());
            eventResponse.setRsVo(pickUpNoticeFormVO.getBkgPkupWdVO(0));
            eventResponse.setRsVoList(pickUpNoticeFormVO.getBkgPkupNtcHrVO(0));
            eventResponse.setRsVo(pickUpNoticeFormVO.getBkgPkupWdVO(1));
            eventResponse.setRsVoList(pickUpNoticeFormVO.getBkgPkupNtcHrVO(1));
            
            eqOfcCntCd =command.searchPkupNtcEqOfcCntCd(ofcCd);
            //Canada의 경우 ESM_BKG_0411 화면의 select 콤보 박스 이름 수정
            eventResponse.setETCData("eqOfcCntCd", eqOfcCntCd);

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }

        return eventResponse;
    }

	/**
	 * ESM_BKG_0411 : Search<br>
	 * retrieve Del list of each Office about PickUp Notice Form<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    
    private EventResponse searchPkupNtcFormDelList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0411Event event = (EsmBkg0411Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try{

            String ntcSndTpCd = event.getNtcSndTpCd();
            String ofcCd = event.getOfcCd();

            List<BkgComboVO> list = command.searchPkupNtcFormDelList(ntcSndTpCd, ofcCd);

            eventResponse.setRsVoList(list);

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }

	/**
	 * ESM_BKG_0411 : Setup<br>
	 * PickUp Notice Form information modify and save<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse setupPkupNtcForm (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0411Event event = (EsmBkg0411Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try{
            begin();
            command.setupPkupNtcForm (event.getBkgPkupNtcStupVO(),
                                      event.getBkgPkupWdVOs(),
                                      event.getBkgPkupNtcHrVOs(),
                                      account);
            commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[]{"Setup"}).getMessage(), ex);
		}

		return eventResponse;
    }

    
    
	/**
	 * ESM_BKG_0411 : Delete<br>
	 * delete PickUp Notice Form information<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse removePkupNtcForm (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0411Event event = (EsmBkg0411Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try{
            begin();
            command.removePkupNtcForm (event.getPkupNtcSeq());
            commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[]{"Delete"}).getMessage(), ex);
		}

		return eventResponse;
    }
    
    /**
     * ESM_BKG_1054 : Save Customer Code Validation<br>
     * update Unmatch information after Customer Code Validation<br>
     * Arrival Notice master 및 Detail을 생성한다.<br>
     * @author
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse manageArrNtcUnMatchCust (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	begin();
            EsmBkg1054Event event = (EsmBkg1054Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
            GeneralBookingReceiptBC generalBookingReceiptCommand = new GeneralBookingReceiptBCImpl();

            CustCdEvaluationVO[] custCdEval = event.getCustCdEvaluationVO();

            generalBookingReceiptCommand.modifyCustCdValInfo(custCdEval, account); 
            command.manageArrNtcUnMatchCust(custCdEval, account);
            
            BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
            HistoryLineVO historyLineVO = new HistoryLineVO();
            historyLineVO.setCaFlg( "N" );
            historyLineVO.setUiId( "ESM_BKG_1054");
            String strOldVal = null; 
            String strNewVal = null;
            for (int i = 0; i < custCdEval.length; i ++) {
            	if (custCdEval[i].getBkgNo() != null && !custCdEval[i].getBkgNo().equals("")) { 
	            	strOldVal = custCdEval[i].getMdmCustCd()==null?"":custCdEval[i].getMdmCustCd();
	            	strNewVal = custCdEval[i].getCorCustCd()==null?"":custCdEval[i].getCorCustCd();
	            	if (!strOldVal.equals(strNewVal)) { 
		            	historyLineVO.setBkgNo( custCdEval[i].getBkgNo() );
			            historyLineVO.setCrntCtnt( strNewVal );
			            historyLineVO.setPreCtnt( strOldVal );
			            if (custCdEval[i].getBkgCustTpCd().equals("C")) {
			            	historyLineVO.setHisCateNm( "CNEE CD");
			            } else if (custCdEval[i].getBkgCustTpCd().equals("N")) {
			            	historyLineVO.setHisCateNm( "NTFY CD");
			            }
			            historyBC.createBkgHistoryLine(historyLineVO, account);
	            	}
            	}
            }

            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
    }

    /**
     * ESM_BKG_1054 : Save Customer Code Validation<br>
     * Matched information after Customer Code Validation changes Unmatch
     * Arrival Notice master and Detail delete<br>
     * update Match information<br>
     * @author
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse cancelArrNtcCustCdVal (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	begin();
            EsmBkg1054Event event = (EsmBkg1054Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
            GeneralBookingReceiptBC generalBookingReceiptCommand = new GeneralBookingReceiptBCImpl();

            CustCdEvaluationVO[] custCdEvals = event.getCustCdEvaluationVO();

            command.cancelArrNtcCustCdVal(custCdEvals);
            generalBookingReceiptCommand.removeCustCdValInfo(custCdEvals[0].getBkgNo(),custCdEvals[0].getBkgCustTpCd() , account); // 책임테이블 때문에 분리

            BookingHistoryMgtBC historyBC = new BookingHistoryMgtBCImpl();
            HistoryLineVO historyLineVO = new HistoryLineVO();
            historyLineVO.setCaFlg( "N" );
            historyLineVO.setUiId( "ESM_BKG_1054");
            String strOldVal = null; // Variable declaration for reliable test
            String strNewVal = null;
        	strOldVal = custCdEvals[0].getMdmCustCd()==null?"":custCdEvals[0].getMdmCustCd();
        	strNewVal = custCdEvals[0].getOrgCustCd()==null?"":custCdEvals[0].getOrgCustCd();
        	if (!strOldVal.equals(strNewVal)) { 
            	historyLineVO.setBkgNo( custCdEvals[0].getBkgNo() );
	            historyLineVO.setCrntCtnt( strNewVal );
	            historyLineVO.setPreCtnt( strOldVal);
	            if (custCdEvals[0].getBkgCustTpCd().equals("C")) {
	            	historyLineVO.setHisCateNm( "CNEE CD");
	            } else if (custCdEvals[0].getBkgCustTpCd().equals("N")) {
	            	historyLineVO.setHisCateNm( "NTFY CD");
	            }
	            historyBC.createBkgHistoryLine(historyLineVO, account);
        	}
            
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
    }
    
    
	/**
	 * ESM_BKG_0992 : checking duplicate
	 * <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse checkPkupNtcFormExist(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0992Event event = (EsmBkg0992Event)e;
    	PickUpNoticeBC command = new PickUpNoticeBCImpl();
    	
    	try {
    		boolean bResult = command.checkPkupNtcFormExist(event.getOfcCd(), event.getDelCd());
            if (bResult == true) eventResponse.setETCData("valid", "true");
            else eventResponse.setETCData("valid", "false");

    	} catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
    	
    	return eventResponse;
    }
    
	/**
	 * ESM_BKG_0992 : Copy<br>
	 * pre-entered P/N Notice Form Setup information copy<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse copyPkupNtcForm(Event e) throws EventException {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg0992Event event = (EsmBkg0992Event)e;
    	PickUpNoticeBC command = new PickUpNoticeBCImpl();
    	
        try{
            begin();
            command.copyPkupNtcForm(event.getPkupNtcFormCopy());
            commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[]{"Copy"}).getMessage(), ex);
		}
    	
    	return eventResponse;
    }

	/**
	 * ESM_BKG_0993 : Search<br>
	 * retrieve specific information of each container after upload to send the target
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchPkupNtcListByManual(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0993Event event = (EsmBkg0993Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try{
            List<PkupNtcManualListVO> list = command.searchPkupNtcListByManual(event.getBlNo());
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }		
        return eventResponse;
    }

	/**
	 * ESM_BKG_0993 : Setup<br>
	 * setup P/N target data of each container using completed Manually Upload<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse setupPkupNtcListByManual(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0993Event event = (EsmBkg0993Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();
        try{
            begin();
            command.setupPkupNtcListByManual(event.getPkupNtcManualListVOs(),account);
            commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[]{"Setup"}).getMessage(), ex);
		}
        return eventResponse;
    }

    /**
     * ESM_BKG_0941 : Search Customer code Error Report<br>
     * Customer Code Error Report retrieve<br>
     * @author
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse searchArrNtcCustCodeErrReport (Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            EsmBkg0941Event event = (EsmBkg0941Event)e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
            List<ArrNtcCustCodeErrListVO> custCodeErrLists = command.searchArrNtcCustCodeErrReport(event.getArrNtcCustCodeErrSearchVO());
            eventResponse.setRsVoList(custCodeErrLists);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
	 * ESM_BKG_0941 : Customer Code Error Report Confirm<br>
	 * Revaluate Code Validation result<br>
     * @author
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse confirmArrNtcCustCodeErrReport (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            EsmBkg0941Event event = (EsmBkg0941Event)e;
            GeneralBookingReceiptBC command = new GeneralBookingReceiptBCImpl();
            command.confirmCustCdErrReport(event.getArrNtcCustCodeErrListVOs());
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }

    
	/**
	 * ESM_BKG_1034 : search<br>
	 * retrieve Setting information about Manual PickUp Notice Form
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse searchPkupNtcFormByManual(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1034Event event = (EsmBkg1034Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try{
            String ofcCd = event.getOfcCd();
            String eqOfcCntCd = "";
            PkupNtcFormVO pickUpNoticeFormVO = command.searchPkupNtcFormByManual(ofcCd);

            eventResponse.setRsVo(pickUpNoticeFormVO.getBkgPkupNtcStupVO());
            eventResponse.setRsVo(pickUpNoticeFormVO.getBkgPkupWdVO(0));
            eventResponse.setRsVo(pickUpNoticeFormVO.getBkgPkupWdVO(1));
            eventResponse.setRsVo(pickUpNoticeFormVO.getBkgPkupWdVO(2));
            
            if (pickUpNoticeFormVO.getBkgPkupNtcStupVO() == null) {
            	eventResponse.setUserMessage(new ErrorHandler("BKG04016", new String[] {ofcCd}).getUserMessage());
            }
            
            eqOfcCntCd =command.searchPkupNtcEqOfcCntCd(ofcCd);
          //Canada의 경우 ESM_BKG_0411 화면의 select 콤보 박스 이름 수정
            eventResponse.setETCData("eqOfcCntCd", eqOfcCntCd);

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }		
        return eventResponse;
    }


	/**
	 * ESM_BKG_1034 : setup<br>
	 * PickUp Notice Form information modify or save
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
    private EventResponse setupPkupNtcFormByManual(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1034Event event = (EsmBkg1034Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try{
            begin();
            command.setupPkupNtcFormByManual (event.getBkgPkupNtcStupVO(),
                                              event.getBkgPkupWdVOs(),
                                              account);
            commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[]{"Setup"}).getMessage(), ex);
		}

        return eventResponse;
    }

	/**
	 * ESM_BKG_1066 : event<br>
	 * changing information about each consignee that will take PickUp Notice
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */    
    private EventResponse modifyPkupNtcSendList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg1066Event event = (EsmBkg1066Event) e;
    	PickUpNoticeBC command = new PickUpNoticeBCImpl();
    	
        try{
            begin();
            command.modifyPkupNtcSendList(event.getPkupNtcSendListVOs(), account);
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}

        return eventResponse;
    }
    
    
    
	/**
	 * ESM_BKG_1066 : event<br>
	 * save user confirmation of pick-up notice list
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */    
    private EventResponse verifyPkupNtcList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	EsmBkg1066Event event = (EsmBkg1066Event) e;
    	PickUpNoticeBC command = new PickUpNoticeBCImpl();
    	
        try{
            begin();
            command.verifyPkupNtcSendList(event.getPkupNtcSendListVOs(), account);
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}

        return eventResponse;
    }
    

	/**
	 * ESM_BKG_1066 : Search<br>
	 * retrieve failed or missing information and send PickUp Notice to the target 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */    
    private EventResponse searchPkupNtcSendList(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1066Event event = (EsmBkg1066Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();

        try{
            PkupNtcSearchVO search = event.getPkupNtcSearchVO();

            List<PkupNtcSendListVO> list = command.searchPkupNtcSendList(search);
            eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }	
        
        return eventResponse;
    }


	/**
	 * ESM_BKG_1066 : Fax<br>
	 * sending a P/N by Fax as Container units
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */    
    private EventResponse sendPkupNtcByFax(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1066Event event = (EsmBkg1066Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();

        try{

        	String uiId = "ESM_BKG_1066";
        	
            begin();
            /* 1. Send Notice */
            List<BkgNtcHisVO> bkgNtcHisVOs = command.sendPkupNtcByFax(event.getPkupNtcSendListVOs(), account);
            /* 2. Register Notice History */
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("BKG40053").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00242").getMessage(), ex);
		}

        return eventResponse;
    }


	/**
	 * ESM_BKG_1066 : Email<br>
	 * sending a P/N by e-mail as Container units  <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */    
    private GeneralEventResponse sendPkupNtcByEmail(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1066Event event = (EsmBkg1066Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();

        try {
        	String uiId = "ESM_BKG_1066";
        	
            begin();
            /* 1. Send Notice */
            List<BkgNtcHisVO> bkgNtcHisVOs = 
            	command.sendPkupNtcByEmail(event.getPkupNtcSendListVOs(), account);
            /* 2. Register Notice History */
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("BKG40054").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("BKG00243").getMessage(), ex);
		}

        return eventResponse;
    }
    
    
	/**
	 * ESM_BKG_1066 : Stop<br>
	 * stopping preordination sending Pick-up Notice Email/Fax auto sending <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */    
    private GeneralEventResponse stopPkupNtcSend(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1066Event event = (EsmBkg1066Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();
		
        try {
        	        	
            begin();
            command.stopPkupNtcSend(event.getPkupNtcSendListVOs(), account);
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

        return eventResponse;
    }    
    
    
	/**
	 * ESM_BKG_1066 : Resume<br>
	 * clear preordination sending Pick-up Notice Email/Fax auto sending. <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */    
    private GeneralEventResponse resumePkupNtcSend(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1066Event event = (EsmBkg1066Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();
		
        try {
        	        	
            begin();
            command.resumePkupNtcSend(event.getPkupNtcSendListVOs(), account);
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

        return eventResponse;
    } 
    
    
    /**
     * ESM_BKG_0764 : Retrieve Customer Data Management Update History<br>
	 * retrieve Inbound customer information modifying status
     *  @author
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse searchIntgCustCntcInfoHistory(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try {
	        EsmBkg0764Event event = (EsmBkg0764Event)e;
	        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
	
	        // retrieve condition
	        IbCustCntcHisVO ibCustCntcHis = event.getIbCustCntcHisVO();
	
	        List<IbCustCntcHisVO> list = command.searchIntgCustCntcInfoHistory(ibCustCntcHis);
	        eventResponse.setRsVoList(list);
    	} catch(EventException ex) {
    		throw ex;
    	} catch(Exception ex) {
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
   		}
        return eventResponse;
    }
    
    /**
     * ESM_BKG_0764 : Search Customer Data Management Update History<br>
	 * retrieve customer name about Inbound customer information<br>
     *  @author
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse searchMdmCust(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try {
	        EsmBkg0764Event event = (EsmBkg0764Event)e;
	        BookingUtil command = new BookingUtil();
	
	        // retrieve condition
	        IbCustCntcHisVO search = event.getIbCustCntcHisVO();
	
	        MdmCustVO mdmCustVO = command.searchMdmCust(search.getCustCntCd(), search.getCustSeq(), "N");
	        
	        eventResponse.setETCData("cust_nm", mdmCustVO.getName());
    	} catch(EventException ex) {
    		throw ex;
    	} catch(Exception ex) {
    		log.error("err " + ex.toString(), ex);
    		throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
   		}
        return eventResponse;
    }
    

    /**
     * ESM_BKG_0001 : Search Notice Sent History<br>
     * extract Inbound Arrival Notice information using Bkg Notice History
     * @author
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse searchBkgNtcHis(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            EsmBkg0001Event event = (EsmBkg0001Event )e;
            
            // retrieve condition
            BkgNtcSearchVO bkgNtcSearch = event.getBkgNtcSearchVO();
	        
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
	        List<NoticeVO> list = command.searchBkgNtcHis(bkgNtcSearch);
	        eventResponse.setRsVoList(list);
	        
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
        return eventResponse;
    	
    }

    /**
     * ESM_BKG_0414 : Search Pick-Up Notice Sent History<br>
     * Pick-up Notice Sent History retrieve <br>
     * @author
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
     */
    private EventResponse searchPkupNtcSentHistory(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
            EsmBkg0414Event event = (EsmBkg0414Event )e;
            
            // retrieve condition
            PkupNtcSentHisSchVO pkupNtcSentHisSch = event.getPkupNtcSentHisSchVO();
	        
            PickUpNoticeBC command = new PickUpNoticeBCImpl();
	        List<PkupNtcSentHisListVO> list = command.searchPkupNtcSentHistory(pkupNtcSentHisSch);
	        eventResponse.setRsVoList(list);
	        
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
        return eventResponse;
    	
    }
    
    /**
     * [1021] Bank In Account No Setup for A/N<br>
     * Search<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author 
     */
    private EventResponse searchArrNtcBankAcct(Event e) throws EventException 
    {
        // TODO Auto-generated method stub
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try 
        {
            EsmBkg1021Event event = (EsmBkg1021Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            BkgArrNtcWdVO arrNtcBankAcctVO = event.getBkgArrNtcWdVO();
            BkgArrNtcWdVO resultSearch = command.searchArrNtcBankAcct(arrNtcBankAcctVO.getOfcCd());
            eventResponse.setRsVo(resultSearch);
            
            if(resultSearch != null)
            {
            	eventResponse.setETCData("status", "ok");
            }
            else
            {
            	eventResponse.setETCData("status", "no_data");
            }

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }
    
    
    /**
     * [1021] Bank In Account No Setup for A/N<br>
     * Update<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author 
     */
    private EventResponse setupArrNtcBankAcct(Event e) throws EventException 
    {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try 
        {
        	EsmBkg1021Event event = (EsmBkg1021Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            BkgArrNtcWdVO arrNtcBankAcctVO = event.getBkgArrNtcWdVO();
            begin();
            command.setupArrNtcBankAcct(arrNtcBankAcctVO, account);
            commit();
            eventResponse.setETCData("status", "ok");
        } catch(EventException ex) {
            rollback();
            throw ex;
        }catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
        }
        return eventResponse;
    }
    
    
    /**
     * [1021] Bank In Account No Setup for A/N<br>
     * Delete<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author 
     */
    private EventResponse removeArrNtcBankAcct(Event e) throws EventException 
    {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        try 
        {
        	EsmBkg1021Event event = (EsmBkg1021Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            BkgArrNtcWdVO arrNtcBankAcctVO = event.getBkgArrNtcWdVO();
            begin();
            command.removeArrNtcBankAcct(arrNtcBankAcctVO.getOfcCd());
            commit();
            eventResponse.setETCData("status", "ok");
        } catch(EventException ex) {
            rollback();
            throw ex;
        }catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * [1020] Group A/N Remark Template<br>
     * Group Arrival Notice Remark Template Search<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author 
     */
    private EventResponse searchArrNtcGrpForm(Event e) throws EventException
    {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        try 
        {
        	EsmBkg1020Event event = (EsmBkg1020Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            BkgArrNtcWdVO bkgArrNtcWdVO = event.getArrNtcWdVO();
            List<BkgArrNtcWdVO> list = command.searchArrNtcGrpForm(bkgArrNtcWdVO.getOfcCd());            
            
            eventResponse.setRsVoList(list);
                        
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }
    
    
    /**
     * [1020] Group A/N Remark Template<br>
     * Group Arrival Notice Remark Template Setup
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author 
     */
    private EventResponse setupArrNtcGrpForm(Event e) throws EventException
    {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try
    	{
    		EsmBkg1020Event event = (EsmBkg1020Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
            BkgArrNtcWdVO[] bkgArrNtcWdVOs = event.getArrNtcWdVOs();

    		begin();
    		command.setupArrNtcGrpForm(bkgArrNtcWdVOs, account);
    		commit();
    		eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
    	} catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
        
    }
    

    /**
     * [1044] Add Concerned Party Pop-up
     * search
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author 
     */
    private EventResponse searchCustCmdtCntcInfo(Event e)throws EventException
    {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
        try 
        {
        	EsmBkg1044Event event = (EsmBkg1044Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            BkgIbCmdtCntcVO bkgIbCmdtCntcVO = event.getBkgIbCmdtCntcVO();
            List<BkgIbCmdtCntcVO> resultSearch = command.searchCustCmdtCntcInfo(account.getOfc_cd()
            		                                                                  , bkgIbCmdtCntcVO.getCustCntCd()
            		                                                                  , bkgIbCmdtCntcVO.getCustSeq()
            		                                                                  , bkgIbCmdtCntcVO.getCustCntcTpCd());
            
          
            eventResponse.setRsVoList(resultSearch);
            	
            
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }
    
    
    /**
     * [1044] Add Concerned Party Pop-up
	 * Insert, Update, Delete
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author 
     */
    private EventResponse manageCustCmdtCntcInfo(Event e) throws EventException
    {
    	GeneralEventResponse eventResponse = new GeneralEventResponse();
    	try
    	{
    		EsmBkg1044Event event = (EsmBkg1044Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
            
            BkgIbCmdtCntcVO[] bkgIbCmdtCntcVOs = event.getBkgIbCmdtCntcVOs();
           	begin();
           
           	command.manageCustCmdtCntcInfo(bkgIbCmdtCntcVOs, account);
           	
           	
           	commit();
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
    	} catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
        }
        return eventResponse;
    }
    

	/**
	 * ESM_BKG_1058 : Retrieve<br>
	 * Retrieve Empty Return CY code of each Office by Port(POD), Rail Destination Location, DEL
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPkupMtRtnCy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1058Event event = (EsmBkg1058Event)e;
		PickUpNoticeBC command = new PickUpNoticeBCImpl();

		try{
			List<BkgPkupCntrRtnYdVO> list = command.searchPkupMtRtnCy(event.getPkupCntrRtnYdVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1058 : Save<br>
	 * insert, modify and remove Empty Return CY code of each Office by Port(POD), Rail Destination Location, DEL
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse setupPkupMtRtnCy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1058Event event = (EsmBkg1058Event)e;
		PickUpNoticeBC command = new PickUpNoticeBCImpl();
		try{
			begin();
			command.setupPkupMtRtnCy(event.getBkgPkupCntrRtnYdVOS(),account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00167").getMessage());
		}
		return eventResponse;
	}    
    
	/**
	 * ESM_BKG_1058 : Validation<br>
	 * checking validation in case of insert and modify EMPTY CONTAINER Return Yard, Location code for sending a PICKUP NOTICE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPkupMtRtnCy(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1058Event event = (EsmBkg1058Event)e;
		PickUpNoticeBC command = new PickUpNoticeBCImpl();

		try{
			String chkTp = event.getChkTp();
			String locCd = event.getLocCd();
			
			command.checkPkupMtRtnCy(chkTp, locCd);
			
		} catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}
	
	
	/**
	 * ESM_BKG_0511 : POD Search<br>
	 * retrieve POD list information at pre-registered Hold Notice Form screen
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHldNtcFormPodList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0511Event event = (EsmBkg0511Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try{
			String ofcCd   = event.getOfcCd();
			String ntcTpCd = event.getNtcTpCd();
			
			List<BkgHldWdVO> list = command.searchHldNtcFormPodList(ofcCd, ntcTpCd);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0511 : Search<br>
	 * retrieve Hold Notice transmission and Form Setup information according to content
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHldNtcPreForm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0511Event event = (EsmBkg0511Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try{
			String ofcCd = event.getOfcCd();
			String podCd = event.getPodCd();
			
			HoldNoticeFormVO vo = command.searchHldNtcPreForm(ofcCd, podCd);
			
            eventResponse.setRsVo(vo.getBkgHldWd());
            eventResponse.setRsVoList(vo.getBkgHldWdDtls());

		} catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0511 : Save<br>
	 * save or modify form information of each Hold Code of Hold Notice ( Pre-Hold & Confirm-Hold)
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse setupHldNtcPreForm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0511Event event = (EsmBkg0511Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();
		try{
			begin();
			command.setupHldNtcPreForm(event.getBkgHldWdVO(), event.getBkgHldWdDtlVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[]{"Save"}).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_BKG_0511 : Delete<br>
	 * remove H/N Form Master information
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeHldNtcForm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0511Event event = (EsmBkg0511Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();
		try{
			
			begin();
			
			String ofcCd   = event.getOfcCd();
			String podCd   = event.getPodCd();
			String ntcTpCd = event.getNtcTpCd();
			
			command.removeHldNtcForm(ofcCd, podCd, ntcTpCd);

			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG04011").getMessage());
		}
		return eventResponse;
	}	
	
	/**
	 * ESM_BKG_1002 : checking duplicate<br>
	 * checking Pre-entered Pre-Hold Notice Setup information
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkHldNtcFormExist(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1002Event event = (EsmBkg1002Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try {
            boolean bResult = command.checkHldNtcFormExist(event.getOfcCd(),
										                   event.getPodCd(),
										                   event.getNtcTpCd());

            if (bResult == true) eventResponse.setETCData("exist", "yes");
            else eventResponse.setETCData("exist", "no");
			
		} catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}
	

	/**
	 * ESM_BKG_1002 : Copy<br>
	 * Copy Pre-entered Pre-Hold Notice Setup information
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse copyHldNtcPreForm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1002Event event = (EsmBkg1002Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try{
			begin();						
			command.copyHldNtcPreForm(event.getOfcCd(),
					                  event.getPodCd(),
					                  event.getFmOfcCd(),
					                  event.getFmPodCd(),
					                  event.getNtcTpCd(),
					                  account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[]{"Copy"}).getMessage(), ex);
		}
		return eventResponse;
	}

	
	/**
	 * ESM_BKG_0510 : Retrieve<br>
	 * sent Pre-Hold Notice history information retrieve from Hold information of the Customs EDI information (only US)
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHldNtcSendListByPre(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0510Event event = (EsmBkg0510Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try{
			List<PreHldNtcSendListVO> list = command.searchHldNtcSendListByPre(event.getHldNtcSearchVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * ESM_BKG_0510_01 : Retrieve<br>
	 * Clear(Confirm) Event occurred information retrieve about Hold of Customs EDI information (only US)
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHldNtcSendListByConfirm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0510Event event = (EsmBkg0510Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try{
			List<ConfirmHldNtcSendListVO> list = command.searchHldNtcSendListByConfirm(event.getHldNtcSearchVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}

	/**
	 * ESM_BKG_0510 : Fax<br>
s	 * sending Hold Notice from Hold (Pre or Confirm) information by fax 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendPreHldNtcByFax(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0510Event event = (EsmBkg0510Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();

        try{

        	String uiId = "ESM_BKG_0510";
        	
            begin();
            /* 1. Send Notice */
            List<BkgNtcHisVO> bkgNtcHisVOs = command.sendPreHldNtcByFax(event.getPreHldNtcSendListVOs(), account);
            /* 2. Register Notice History */
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("BKG40053").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00242").getMessage(), ex);
		}

        return eventResponse;
	}
	

	/**
	 * ESM_BKG_0510 : Email<br>
	 * sending Hold Notice from Hold (Pre or Confirm) information by e-mail
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendPreHldNtcByEmail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0510Event event = (EsmBkg0510Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();

        try{

        	String uiId = "ESM_BKG_0510";
        	
            begin();
            /* 1. Send Notice */
            List<BkgNtcHisVO> bkgNtcHisVOs = 
            	command.sendPreHldNtcByEmail(event.getPreHldNtcSendListVOs(), 
                                             account);
            /* 2. Register Notice History */
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("BKG40054").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00243").getMessage(), ex);
		}

        return eventResponse;        
	}

	
	
	/**
	 * ESM_BKG_0510 : Preview<br>
	 * Checking Pre-entered Hold Notice Setup information
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkHldNtcFormExistByNtcType(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0510Event event = (EsmBkg0510Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try {
            boolean bResult = 
            	command.checkHldNtcFormExistByNtcType(event.getOfcCd(), event.getPodCd(), event.getHldNtcTpCd());

            if (bResult == true) eventResponse.setETCData("exist", "yes");
            else eventResponse.setETCData("exist", "no");
			
		} catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * 	For test!!!
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCstmsHld(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0510Event event = (EsmBkg0510Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();

        try{

        	String uiId = "ESM_BKG_0510-01";

        	begin();
        	command.sendAmsNtcToObStaff(event.getCstmsHldVO());
        	
            /* 1. Send Notice */
            List<BkgNtcHisVO> bkgNtcHisVOs = command.createCstmsHld(event.getCstmsHldVO());
            /* 2. Register Notice History */
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, uiId);

            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
		}

        return eventResponse;        
	}
	
	/**
	 * ESM_BKG_0510 : Fax<br>
	 * sending Hold Notice from Hold (Pre or Confirm) information by fax 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendConfirmHldNtcByFax(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0510Event event = (EsmBkg0510Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();

        try{

        	String uiId = "ESM_BKG_0510-01";
        	
            begin();
            /* 1. Send Notice */
            List<BkgNtcHisVO> bkgNtcHisVOs = command.sendConfirmHldNtcByFax(event.getConfirmHldNtcSendListVOs(), account);
            /* 2. Register Notice History */
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("BKG40053").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00242").getMessage(), ex);
		}

        return eventResponse;
	}
	

	/**
	 * ESM_BKG_0510 : Email<br>
	 * sending Hold Notice from Hold (Pre or Confirm) information by e-mail
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse sendConfirmHldNtcByEmail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0510Event event = (EsmBkg0510Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();
		BookingHistoryMgtBC bkgHisCmd = new BookingHistoryMgtBCImpl();

        try{

        	String uiId = "ESM_BKG_0510-01";
        	
            begin();
            /* 1. Send Notice */
            List<BkgNtcHisVO> bkgNtcHisVOs = 
            	command.sendConfirmHldNtcByEmail(event.getConfirmHldNtcSendListVOs(), 
            			                         account);
            /* 2. Register Notice History */
			bkgHisCmd.createBkgNtcHis(bkgNtcHisVOs, uiId);
            eventResponse.setUserMessage(new ErrorHandler("BKG40054").getUserMessage());
            commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("BKG00243").getMessage(), ex);
		}

        return eventResponse;        
	}

	/**
	 * ESM_BKG_0760 : Retrieve<br>
	 * retrieve Confirm Hold Notice transmission and Form Setup information according to content
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchHldNtcConfirmForm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0760Event event = (EsmBkg0760Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try{
			String ofcCd = event.getOfcCd();
			String podCd = event.getPodCd();
			
			HoldNoticeFormVO vo = command.searchHldNtcConfirmForm(ofcCd, podCd);
			
            eventResponse.setRsVo(vo.getBkgHldWd());
            eventResponse.setRsVoList(vo.getBkgHldWdDtls());
            
		} catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}
	/**
	 * ESM_BKG_0760 : Save<br>
	 * save or modify or remove form information of each Hold Code of Hold Notice (Pre-Hold & Confirm-Hold)
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse setupHldNtcConfirmForm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0760Event event = (EsmBkg0760Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();
				
		try{
			begin();
			command.setupHldNtcConfirmForm(event.getBkgHldWdVO(), event.getBkgHldWdDtlVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00167").getMessage());
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1063 : Retrieve<br>
	 * retrieve manual to upload Pick-up No
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPkupNoMnlUpldList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1063Event event = (EsmBkg1063Event)e;
		PickUpNoticeBC command = new PickUpNoticeBCImpl();

		try{
			List<PkupNoMnlUpldVO> list = command.searchPkupNoMnlUpldList(event.getPkupNoMnlUpldSearchVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }	
		return eventResponse;
	}	
	
	/**
	 * ESM_BKG_1063 : Save<br>
	 * save manual pre-entered Pick-up No and additional Information
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse managePkupNoMnlUpldList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1063Event event = (EsmBkg1063Event)e;
		PickUpNoticeBC command = new PickUpNoticeBCImpl();
				
		try{
			
			begin();
			command.managePkupNoMnlUpldList(event.getPkupNoMnlUpldVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}
	
	
	
	/**
	 * ESM_BKG_1063 : Batch<br>
	 *  <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */    
    private GeneralEventResponse executePickupSetting(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        PickUpNoticeBC command = new PickUpNoticeBCImpl();
		
        try {
        	        	
            begin();
            String jobId = command.executeBatch("ESM_BKG_B012", "");
            eventResponse.setETCData("JOB_ID", jobId);
            commit();

		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

        return eventResponse;
    }


	/**
	 * ESM_BKG_1063 : Batch Monitor <br>
	 *  <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */    
    private GeneralEventResponse monitorPickupSetting(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1063Event event = (EsmBkg1063Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();
		
        try {
        	        	
            String jobStatus = command.getBatchStatus(event.getJobId(), "ESM_BKG_B012");
            eventResponse.setETCData("BATCH_STATUS", jobStatus);

		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

        return eventResponse;
    }

    
	/**
	 * ESM_BKG_1063 : Batch Running Status <br>
	 *  <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */    
    private GeneralEventResponse isRunningBatch(Event e) throws EventException{
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg1063Event event = (EsmBkg1063Event)e;
        PickUpNoticeBC command = new PickUpNoticeBCImpl();
		
        try {
        	        	
            boolean status = command.isRunningBatch(event.getBatchCd());
            
            if (status == true) {
                eventResponse.setETCData("BATCH_STATUS", "true");
            } else {
                eventResponse.setETCData("BATCH_STATUS", "false");
            }

		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}

        return eventResponse;
    }

    
	/**
	 * ESM_BKG_1064 : File Import<br>
	 * extract pick up No upload related information by analyzing Received e-mail Report from the railroad company
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchParsedPkupNoRpt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1064Event event = (EsmBkg1064Event)e;
		PickUpNoticeBC command = new PickUpNoticeBCImpl();

		try{
			List<PkupNoRptVO> list = command.searchParsedPkupNoRpt(event.getPkupNoRptEmlUpldVO());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1064 : Verify<br>
	 * verify pick up No upload Received e-mail Report from the railroad company
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPkupNoVerifyRpt(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1064Event event = (EsmBkg1064Event)e;
		PickUpNoticeBC command = new PickUpNoticeBCImpl();

		try{
			PkupNoVerifyVO pkupNtcVerifyVO = command.searchPkupNoVerifyRpt(event.getPkupNoRptVOs());
			
			List<PkupNoRptVO> list = pkupNtcVerifyVO.getPkupNoRptVOs();
			List<PkupNoMnlUpldVO> upList = pkupNtcVerifyVO.getPkupNoMnlUpldVOs();
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(upList);

		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_1067 : Open<br>
	 * to manual upload Pick-up No retrieve
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchPkupNoHisList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1067Event event = (EsmBkg1067Event)e;
		PickUpNoticeBC command = new PickUpNoticeBCImpl();

		try{
			List<BkgPkupNtcPkupNoHisVO> list = command.searchPkupNoHisList(event.getBkgNo(),
					                                                       event.getCntrNo(),
					                                                       event.getOfcCd());
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			throw ex;
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}	
		return eventResponse;
	}
	
	
	/**
	 * ESM_BKG_1068 : Retrieve<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchTpbInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1068Event event = (EsmBkg1068Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();

		try{
			List<TpbInfoVO> list = command.searchTpbInfo(event.getBkgNo(),
					                                     event.getNtcSeq());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}	
	
	/**
	 * ESM_BKG_1063 : Save<br>
	 * <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse setupTpbInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1068Event event = (EsmBkg1068Event)e;
		HoldNoticeBC command = new HoldNoticeBCImpl();
				
		try{
			begin();
			command.setupTpbInfo(event.getTpbInfoVOs(), account);
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00110", new String[]{"Save"}).getMessage(), ex);
		}
		return eventResponse;
	}	
	

	/**[672-02]
	 * Customer Info retrieve
	 * @param e
	 * @return EventResponse
	 * @exception EventException 
	 */
	private EventResponse searchArrNtcCustList(Event e) throws EventException {
		EsmBkg0672Event event = (EsmBkg0672Event)e;		
		ArrivalNoticeBC command = new ArrivalNoticeBCImpl();		
        // retrieve condition
        ArrNtcSearchVO search = event.getArrNtcSearchVO();
        search.setOfcCd(account.getOfc_cd());

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
	        List<ArrNtcCustListVO> list = command.searchArrNtcCustList(search,getSignOnUserAccount());
	        
	        eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }

        return eventResponse;
	}

		

	/**
	 * [0381] search RD ID information to be used
	 * @param e
	 * @return EventResponse
	 */
	private EventResponse searchArrNtcMrdId(Event e) throws EventException{
		log.debug("0381 search SC start");
		GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0381Event event = (EsmBkg0381Event) e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
        try{
	        ArrNtcMrdSearchVO arrNtcMrdSearch = event.getArrNtcMrdSearch();
	        arrNtcMrdSearch.setUsrId(account.getUsr_id());
	        arrNtcMrdSearch.setOfcCd(account.getOfc_cd());
	        ArrNtcMrdVO list = command.searchArrNtcMrdId(arrNtcMrdSearch);
	        
	        String mrdId = "";
	        String loclLangFlg = "";
	        String comParam  ="";
	        String arrPrvFomCd  ="";
	        
	        log.debug("------------- list "+list);
	        
	        if(list != null && list.getMrdId() != null && !list.getMrdId().equals("")){
	        	mrdId = list.getMrdId();
	        	loclLangFlg = list.getLoclLangFlg();
	        	comParam = list.getComParam();
	        	arrPrvFomCd = list.getArrPrvFomCd();
	        }
	        
	        eventResponse.setETCData("MRD_ID", mrdId);
	        eventResponse.setETCData("LOCL_LANG_FLG", loclLangFlg);
	        eventResponse.setETCData("COM_PARAM", comParam);//공통 파라미터
	        eventResponse.setETCData("ARR_PRV_FOM_CD", arrPrvFomCd);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
	}


	/**
     * [0052]<br>
     * MRN & Return yard information retrieve
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse searchArrNtcMrnRtnYd(Event e) throws EventException {
		log.debug("0052 search SC start");
        EsmBkg0052Event event = (EsmBkg0052Event) e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

        String vvd = event.getMrnRtnYdVO().getVvd();
        String podCd = event.getMrnRtnYdVO().getPodCd();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	List<MrnRtnYdVO> list = command.searchArrNtcMrnRtnYd(vvd, podCd);

        
        	eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;

    }
    /**
     * [0052]
     * save MRN & Return yard information 
     * @param e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse setupArrNtcMrnRtnYd(Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	begin();
            EsmBkg0052Event event = (EsmBkg0052Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            MrnRtnYdVO[] mrnRtnYdVOS = event.getMrnRtnYdVOs();
            String vvd = event.getMrnRtnYdVO().getVvd();
            for(int i=0;i<mrnRtnYdVOS.length;i++){
            	MrnRtnYdVO vo = mrnRtnYdVOS[i];
            	vo.setVvd(vvd);
            	mrnRtnYdVOS[i] = vo;
            }
            command.setupArrNtcMrnRtnYd(mrnRtnYdVOS,e.getSignOnUserAccount());
            
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * [672-1] Update Arrival Data modify
     * @param e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse setupArrNtcInfoList(Event e) throws EventException {
    	// PDTO(Data Transfer Object including Parameters)
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmBkg0672Event event = (EsmBkg0672Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
        try{
        	long startTime = System.currentTimeMillis();
            begin();
            ArrNtcInfoListVO[] arrNtcInfos = event.getArrNtcInfos();
            
            command.setupArrNtcInfoList(arrNtcInfos, account);

            commit();
            long endTime = System.currentTimeMillis();
			
			log.debug("--------- 실행시간 " + ((endTime-startTime)/1000));
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
    }
    
    /**
     * [672-2] Customer Info modify
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse modifyArrNtcCustList(Event e) throws EventException {
        // TODO Auto-generated method stub
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	begin();
            EsmBkg0672Event event = (EsmBkg0672Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            ArrNtcCustListVO[] arrNtcCustListVOS = event.getArrNtcCustListVOS();

            command.modifyArrNtcCustList(arrNtcCustListVOS, e.getSignOnUserAccount());
            
            GeneralBookingReceiptBC cmd1 = new GeneralBookingReceiptBCImpl();
            cmd1.modifyArrNtcCustChgFlg(arrNtcCustListVOS);

            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00110").getMessage(), ex);
        }
        return eventResponse;
    }
    /**
     * [672-3] Upload Match information retrieve
     * @param e
     * @return EventResponse
     */
    private EventResponse searchArrNtcCustListForUpload(Event e)
			throws EventException {
    	List<ArrNtcCustUploadListVO> list = null;
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmBkg0672Event event = (EsmBkg0672Event) e;
		ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
		try{
			list = command.searchArrNtcCustListForUpload(event.getArrNtcSearchVO());
		} catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		
        eventResponse.setRsVoList(list);
		return eventResponse;
	}

    /**
     * [672-3] Upload_Match information modify
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse createArrNtcCustListbyUpload(Event e) throws EventException {
        // TODO Auto-generated method stub
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	begin();
            EsmBkg0672Event event = (EsmBkg0672Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
            
            ArrNtcCustUploadListVO[] vos = event.getArrNtcCustUploadListVOS();
           
    		
    		for(int i=0;i<vos.length;i++){
    			ArrNtcCustUploadListVO  arrNtcCustUploadListVO = vos[i];
    			BkgArrNtcDtlVO nVo = new BkgArrNtcDtlVO();
    			nVo.setBkgNo(arrNtcCustUploadListVO.getBkgNo());
    			nVo.setBkgCustTpCd(arrNtcCustUploadListVO.getBkgCustTpCd());
    			
    			//1.cust_cntc_tp_cd = C2
    			nVo.setCustCntcTpCd("C2");
    			nVo.setFaxNo(arrNtcCustUploadListVO.getFaxNo1());
    			nVo.setNtcEml(arrNtcCustUploadListVO.getNtcEml1());
    			//nVos[i] = nVo;
    			command.createArrNtcCustListbyUpload(nVo, account);
    			
    			//2.cust_cntc_tp_cd = B1
    			nVo.setCustCntcTpCd("B1");
    			nVo.setFaxNo(arrNtcCustUploadListVO.getFaxNo2());
    			nVo.setNtcEml(arrNtcCustUploadListVO.getNtcEml2());
    			//nVos[i] = nVo;
    			command.createArrNtcCustListbyUpload(nVo, account);
    			
    			
    			//3.cust_cntc_tp_cd = B2
    			nVo.setCustCntcTpCd("B2");
    			nVo.setFaxNo(arrNtcCustUploadListVO.getFaxNo3());
    			nVo.setNtcEml(arrNtcCustUploadListVO.getNtcEml3());
    			//nVos[i] = nVo;
    			command.createArrNtcCustListbyUpload(nVo, account);
    		
    		}
            
            
            eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());

            
            commit();
        } catch(EventException ex) {
            rollback();
            throw ex;
        } catch(Exception ex) {
            rollback();
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00167").getMessage(), ex);
        }
        return eventResponse;
    }
    
	   
	
    /**[243] AN Setup Screen_Arrival Info. <br>
     * Grouped each VVD/POD entered Phrases and information retrieve
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchArrNtcFormDtl(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
        EsmBkg0243Event event = (EsmBkg0243Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();


        String ofcCd = event.getOfcCd();
        String podCd = event.getPodCd();
        String anFomCd = event.getAnFomCd();
        String agent = event.getAgent();
        
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	List<BkgArrNtcWdDtlVO> arrNtcWdDtlVOS = command.searchArrNtcFormDtl(ofcCd,podCd,anFomCd,agent);
        	eventResponse.setRsVoList(arrNtcWdDtlVOS);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }

        
        



        return eventResponse;
    }
	   
    /**
     * pre-setting A/N send information and pre-send history retrieve at A/N Setting screen
     * @param e
     * @return EventResponse
     * @exception EventException
     */
    private EventResponse searchArrNtcSendList(Event e) throws EventException {
        // PDTO(Data Transfer Object including Parameters)
	   	EsmBkg0381Event event = (EsmBkg0381Event)e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        
        try{
       
	        List<ArrNtcSendListVO> listVOS = command.searchArrNtcSendList(event.getSearchVO(),account);
	        
	        
	        eventResponse.setRsVoList(listVOS);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }


        return eventResponse;
    }
   /**
    * [0381] sending a Fax
    * @param e
    * @return EventResponse
    * @exception EventException
    */
   private EventResponse sendArrNtcByFax(Event e) throws EventException{
	   GeneralEventResponse eventResponse = new GeneralEventResponse();
	   EsmBkg0381Event event = (EsmBkg0381Event)e;
	   ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
	   BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();
	   ArrNtcSendListVO[] listVOS = event.getListVOS();
	   
	   try {
		   String uiId = "ESM_BKG_0381";
		   
		   begin();
		   List<BkgNtcHisVO> hisVOS = command.sendArrNtcByFax(listVOS, account);
		   
//		   GeneralBookingReceiptBC cmd1 = new GeneralBookingReceiptBCImpl();
//		   
//		   ArrNtcCustListVO[] arrNtcCustListVOS = new ArrNtcCustListVO[listVOS.length];
//		   for(int i=0;i<listVOS.length;i++){
//			   arrNtcCustListVOS[i] = new ArrNtcCustListVO();
//			   arrNtcCustListVOS[i].setBkgNo(listVOS[i].getBkgNo());
//			   arrNtcCustListVOS[i].setChgDpFlg(listVOS[i].getChgDpFlg());
//			   arrNtcCustListVOS[i].setBkgCustTpCd(listVOS[i].getBkgCustTpCd());
//		   }
//		   cmd1.modifyArrNtcCustChgFlg(arrNtcCustListVOS);
		   
		   hisBC.createBkgNtcHis(hisVOS, uiId);
		   eventResponse.setUserMessage(new ErrorHandler("BKG40053").getUserMessage());
		   commit();
	   }catch(Exception ex) {
           log.error("err " + ex.toString(), ex);
        	rollback();
        	String[] msg = new String[]{"Arrival Notice"};
        	throw new EventException(new ErrorHandler("BKG40035",msg).getMessage());
        }
        return eventResponse;
   }
	   
   /**
    * [0381] sending an Email
    * @param e
    * @return EventResponse
    * @exception EventException
    */
   
   private EventResponse sendArrNtcByEmail (Event e) throws EventException{
	   GeneralEventResponse eventResponse = new GeneralEventResponse();
	   EsmBkg0381Event event = (EsmBkg0381Event)e;
	   ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
	   BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();
	   
	   try {
		   begin();
		   List<BkgNtcHisVO> hisVOS = command.sendArrNtcByEmail(event.getListVO(), account);
		   hisBC.createBkgNtcHis(hisVOS, "ESM_BKG_0381");			 
		   eventResponse.setUserMessage(new ErrorHandler("BKG40054").getUserMessage());
		   commit();
		   
	   }catch(EventException ex) {
           throw ex;
       }catch(Exception ex) {
        	rollback();  
        	String[] msg = new String[]{"Arrival Notice"};
        	throw new EventException(new ErrorHandler("BKG40036",msg).getMessage());
        }
        return eventResponse;
   }
   
   /**
     * [0956]Arrival Notice Hold Remark retrieve event process<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
   private EventResponse searchArrNtcHldRmk (Event e) throws EventException {
		log.debug("0956 retrieve SC start");
        EsmBkg0956Event event = (EsmBkg0956Event) e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();

        String bkgNo = event.getSearchVO().getBkgNo();
        try{
	        List<BkgArrNtcCntrVO> list = command.searchArrNtcHldRmk(bkgNo);

	        
	        eventResponse.setRsVoList(list);
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;

    }
    /**
     * [0956]Arrival Notice Hold Remark save
     * @param e
     * @return EventResponse
     * @exception EventException
     */
	private EventResponse setupArrNtcHldRmk (Event e) throws EventException {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	begin();
            EsmBkg0956Event event = (EsmBkg0956Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            BkgArrNtcCntrVO[] vos = event.getListVOS();
            
            command.setupArrNtcHldRmk (vos,e.getSignOnUserAccount());
            commit();

        } catch(EventException ex){
            rollback();
            throw new EventException(new ErrorHandler("BKG00110").getMessage());
        } catch (Exception ex) {
			// TODO Auto-generated catch block
			rollback();
            throw new EventException(new ErrorHandler("BKG00110").getMessage());
		} 
        return eventResponse;
    }
	   /**
     * [0946]Group A/N Merge Pop-up retrieve event process<br>
     *
     * @param e Event
     * @return response EventResponse
     * @exception EventException
     */
	private EventResponse searchArrNtcGrpSendList(Event e) throws EventException {
		log.debug("0946 retrieve SC start");
        EsmBkg0946Event event = (EsmBkg0946Event) e;
        ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try{
        	List<ArrNtcGrpSendListVO> list = command.searchArrNtcGrpSendList(event.getSearchVO());
        	eventResponse.setRsVoList(list);
        	
        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;

    }
	
	/**
	 * [0946]sending Group A/N Merge Pop-up Email
	 * @param e
	 * @return EventResponse
	 * @exception EventException 
	 */

	private EventResponse sendArrNtcByGrpEmail(Event e) throws EventException {
    	// TODO Auto-generated method stub
		log.debug("----0946 Email retrieve SC start");
		BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();
  
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	begin();
        	String uiId = "ESM_BKG_0946";

        	EsmBkg0946Event event = (EsmBkg0946Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
            Vector<String> vEmail = event.getEmail();
            ArrNtcGrpSendVO grpSendVO = event.getGrpSendVO();

            List<BkgNtcHisVO> hisVOS = command.sendArrNtcByGrpEml(grpSendVO,event.getListVOS(), account,vEmail);
            hisBC.createBkgNtcHis(hisVOS, uiId);
            
            eventResponse.setUserMessage(new ErrorHandler("BKG40054").getUserMessage());
            log.debug("--------------- e-mail transmission success commit()");
            commit();

        } catch(EventException ex){
            rollback();            
         	throw ex;
         	
        } catch(Exception ex){
        	rollback();
            String[] msg = new String[]{"Group Arrival Notice"};
         	throw new EventException(new ErrorHandler("BKG40036",msg).getMessage());	
        }
        return eventResponse;
        
	}

	/**
	 * [0946]sending Group A/N Merge Pop-up Fax
	 * @param e
	 * @return EventResponse
	 * @exception EventException 
	 */
    private EventResponse sendArrNtcByGrpFax(Event e) throws EventException {
		// TODO Auto-generated method stub
		log.debug("---------------0946 fax sending SC start");
		BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();
  
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try {
        	begin();
        	String uiId = "ESM_BKG_0946";

        	EsmBkg0946Event event = (EsmBkg0946Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
            
            ArrNtcGrpSendVO grpSendVO = event.getGrpSendVO();

            List<BkgNtcHisVO> hisVOS = command.sendArrNtcByGrpFax(grpSendVO, event.getListVOS(), account,event.getFaxNo());
            hisBC.createBkgNtcHis(hisVOS, uiId);
            eventResponse.setUserMessage(new ErrorHandler("BKG40053").getUserMessage());
            commit();

        } catch(EventException ex){
            rollback();            
         	throw ex;
         	
        }catch(Exception ex){
            rollback();
            String[] msg = new String[]{"Group Arrival Notice"};
        	throw new EventException(new ErrorHandler("BKG40035",msg).getMessage());
        	
        } 
        
       
        
        return eventResponse;
	}
	/**
	 * common code(code,naming) retrieve event process<br>
	 * specific list retrieve event process about PRICommon event
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchComCodeDescList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmBkg0240Event event = (EsmBkg0240Event)e;
		CodeUtil cdUtil = CodeUtil.getInstance();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			ArrayList<CodeInfo> cdList =(ArrayList<CodeInfo>)cdUtil.getCodeSelect(event.getRsltcdlistvo().getCd(),0);
			List<RsltCdListVO> list = new ArrayList<RsltCdListVO>();

			for (int i = 0; i < cdList.size(); i++) {
				RsltCdListVO rsltcdlistvo = new RsltCdListVO() ;
				rsltcdlistvo.setCd(cdList.get(i).getCode());
				
				if (event.getRsltcdlistvo().getCd().toString().equalsIgnoreCase("CD01701") ){
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (event.getRsltcdlistvo().getCd().toString().equalsIgnoreCase("CD01714")) {
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (event.getRsltcdlistvo().getCd().toString().equalsIgnoreCase("CD02128")) {
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (event.getRsltcdlistvo().getCd().toString().equalsIgnoreCase("CD02141")) {
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());
				}else if (event.getRsltcdlistvo().getCd().toString().equalsIgnoreCase("CD02085")) {
					rsltcdlistvo.setNm(cdList.get(i).getCode()+"\t"+ cdList.get(i).getName());	
				}else {
					rsltcdlistvo.setNm(cdList.get(i).getName());
				}
				
				list.add(rsltcdlistvo);
			}

			
			eventResponse.setRsVoList(list);
		
		} catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
		return eventResponse;
	}
	
	/**
	 * [1099]Integrated Customer Data Update Setup retrieve
	 * @param e
	 * @return EventResponse
	 * @exception EventException 
	 */
	private EventResponse searchIntgCustCntcUpdtStupInfoByOfc(Event e) throws EventException 
    {
        // TODO Auto-generated method stub
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try 
        {
            EsmBkg1099Event event = (EsmBkg1099Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            BkgIbCustCntcStupVO bkgIbCustCntcStupVO = event.getBkgIbCustCntcStupVO();
            BkgIbCustCntcStupVO resultSearch = command.searchIntgCustCntcUpdtStupInfoByOfc(bkgIbCustCntcStupVO.getOfcCd());
            eventResponse.setRsVo(resultSearch);
            
            if(resultSearch != null)
            {
            	eventResponse.setETCData("status", "ok");
            }
            else
            {
            	eventResponse.setETCData("status", "no_data");
            }

        } catch(EventException ex) {
            throw ex;
        } catch(Exception ex) {
            log.error("err " + ex.toString(), ex);
            throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
        }
        return eventResponse;
    }
    
    
    /**
     * ESM_BKG_1099:   Integrated Customer Data Update Setup save<br>
     * 
     * @param e
     * @return EventResponse
     * @exception EventException
     * */
    private EventResponse manageIntgCustCntcUpdtStupInfoByOfc(Event e) throws EventException 
    {
        GeneralEventResponse eventResponse = new GeneralEventResponse();
        try 
        {
        	EsmBkg1099Event event = (EsmBkg1099Event )e;
            ArrivalNoticeBC command = new ArrivalNoticeBCImpl();

            BkgIbCustCntcStupVO bkgIbCustCntcStupVo = event.getBkgIbCustCntcStupVO();
            begin();

            command.manageIntgCustCntcUpdtStupInfoByOfc(bkgIbCustCntcStupVo, account);
            commit();
            
			// setting success message
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
        } catch(EventException ex) {
        	
            rollback();
            throw new EventException(new ErrorHandler("BKG00820").getMessage(), ex);
        }catch(Exception ex){
            rollback();
            throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
        }
        return eventResponse;
    }
    
	/**
	 * Back End Job 공통<br>
	 *  - Back End Job Status 조회
	 * (동일 Package에 Back End Job이 여러개일때 공통으로 사용)
	 *
	 * @param String backEndJobKey
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getBackEndJobStatus(String backEndJobKey) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
		try {
			String jbStsFlg = command.getBackEndJobStatus(backEndJobKey);
			eventResponse.setETCData("jb_sts_flg", jbStsFlg);
		} catch(EventException ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(ex.getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
    * [0381] sending an Email
	 *
	 * @param String backEndJobKey
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse resultBackEndJobSendArrivalNoticeEmail(String backEndJobKey) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
		 BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();
		try {
			begin();
			List<BkgNtcHisVO> hisVOS  = command.resultBackEndJobSendArrivalNoticeEmail(backEndJobKey);
			   hisBC.createBkgNtcHis(hisVOS, "ESM_BKG_0381");			 
			   eventResponse.setUserMessage(new ErrorHandler("BKG40054").getUserMessage());
			commit();
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * [ESM_BKG_0381] A/N email - Back End Job 시작<br>
	 * Arrival Notice BackEnd - A/N email 전송
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse startBackEndJobArrivalNoticeSendEmail(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		ArrivalNoticeBC command = new ArrivalNoticeBCImpl();
		EsmBkg0381Event event = (EsmBkg0381Event) e;
		try {
			begin();
			String backEndJobKey = command.startBackEndJobArrivalNoticeSendEmail(event.getListVOS(), account);
			commit();
			eventResponse.setETCData("backEndJob_Key", backEndJobKey);
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
         	
	
}