/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName       : CargoReleaseOrderMgtSC.java
*@FileTitle      :
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009.04.28
*@LastModifier   :
*@LastVersion    : 1.0
* 2009.04.28
* 1.0 Creation
* --------------------------------------------------------------------------------------
* History
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerGrpVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeByBookingCustomerParmVO;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.basic.StatusInquiryBC;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.basic.StatusInquiryBCImpl;
import com.clt.apps.opus.esd.tpb.statusinquiry.statusinquiry.vo.SearchTPBStatusByBkgNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBC;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookinghistorymgt.basic.BookingHistoryMgtBCImpl;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.basic.BookingUtil;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgHrdCdgCtntListCondVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBC;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.basic.CargoReleaseOrderBCImpl;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0128Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0130Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0131Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0132Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0133Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0134Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0135Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0136Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0137Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0271Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0272Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0273Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0326Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0680Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0682Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0694Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0711Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0737Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0909Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0923Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0936Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0937Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0938Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0939Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0954Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg0999Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg1000Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg1001Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg1018Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg1035Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg1052Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event.EsmBkg1167Event;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BkgOutstandingVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseBkbcBlVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CstmsClrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DmtChargeVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoBlInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCancelVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCheckListSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCheckListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoCntrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoHisVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoHoldVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoMstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoPrnRmkVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRcvrInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRcvrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRefVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoCntrRqstsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoRqstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoRqstsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoCntrRlseStsVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoMstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EuDoRcvrVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FrtCltLstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrdVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderEdiSendVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderHisSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderHisVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderMailVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoMstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseReportVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoRlseVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.IdaDoSaveVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoHisListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoHisSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoIssueVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoMstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorEdiTransVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoAttorneyDtlVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoAttorneyVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoCancelVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoMstVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.KorDoRlseVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OblRdemVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.OtsRcvInfoVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.ToTBilAmtVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseBkbcBlVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseHisVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseSearchVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBC;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.basic.BLIssuanceBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.CheckUtils;
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
import com.clt.syscommon.common.table.BkgBlIssVO;
import com.clt.syscommon.common.table.BkgCgoRlseVO;
import com.clt.syscommon.common.table.BkgDoFomVO;
import com.clt.syscommon.common.table.BkgDoRefVO;
import com.clt.syscommon.common.table.BkgDoVO;
import com.clt.syscommon.common.table.BkgEdoLogVO;
import com.clt.syscommon.common.table.BkgEuPinNoVO;
import com.clt.syscommon.common.table.BkgHrdCdgCtntVO;
import com.clt.syscommon.common.table.BkgNtcHisVO;

/**
 *  business transaction handling about cargoreleaseordermgt Business Logic ServiceCommand - cargoreleaseordermgt.
 *
 * @author
 * @see InboundNoticeDBDAO
 * @since J2EE 1.4
 */
public class CargoReleaseOrderMgtSC extends ServiceCommandSupport {

	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Pre-Operation of CargoReleaseOrderMgt business scenario<br>
	 */
	public void doStart() {
		try {
			// check log-in
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * End-Operation of CargoReleaseOrderMgt business scenario<br>
	 */
	public void doEnd() {
		log.debug("CargoReleaseOrderMgt 종료");
	}

	/**
	 * Action of business scenario that each event<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC is used to handle multiple events

		  if (e.getEventName().equalsIgnoreCase("EsmBkg1001Event")) {
			  if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				  eventResponse = searchKorDoCustList(e);
			  }
		  }else if (e.getEventName().equalsIgnoreCase("EsmBkg0711Event")) {
			  if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				  eventResponse = searchDoHistory(e);
			  }
		  }else if (e.getEventName().equalsIgnoreCase("EsmBkg1000Event")) {
			  if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				  eventResponse = searchKorDoCustList(e);
			  }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				  eventResponse = manageKorDoCust(e);
			  }
		  }else if (e.getEventName().equalsIgnoreCase("EsmBkg0999Event")) {
			  if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				  eventResponse = searchKorDoAttorneyList(e);
			  }else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				  eventResponse = manageKorDoAttorney(e);
			  }else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				  eventResponse = searchKorDoAttorneyDtl(e);
			  }
		  // Korea D/O Published target B/L info handle.
		  }else if (e.getEventName().equalsIgnoreCase("EsmBkg0682Event")) {
			  if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				  eventResponse = searchKorDo(e);
			  }else if(e.getFormCommand().isCommand(FormCommand.MODIFY)){
				  eventResponse = this.manageKorDo(e);
			  }else if(e.getFormCommand().isCommand(FormCommand.MULTI04)){
				  eventResponse = this.assignDo(e);
			  }else if(e.getFormCommand().isCommand(FormCommand.MULTI05)){
				  eventResponse = this.cancelKorDo(e);
			  }else if(e.getFormCommand().isCommand(FormCommand.MULTI06)){
				  eventResponse = this.releaseKorDo(e);
			  }else if(e.getFormCommand().isCommand(FormCommand.MULTI07)){
				  eventResponse = this.holdDo(e);
			  }else if(e.getFormCommand().isCommand(FormCommand.MULTI08)){
				  eventResponse = transmitEdiKorDo(e); //S/T Cancel
			  }else if(e.getFormCommand().isCommand(FormCommand.COMMAND06)){
				  eventResponse = searchBkgNoByBlNo(e); //search BKG No in Using BL NO
			  }else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				  eventResponse = this.receiptEdoRqstAck(e);
			  }else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				  eventResponse = receiptEdo(e);
			  }else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){
				  eventResponse = receiptEdoLog(e);
			  }else{
				eventResponse = getComIntgCodes(new String[]{"CD02101"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C", "X"}});
			  }
		  }else if (e.getEventName().equalsIgnoreCase("EsmBkg0737Event")) {
			  if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				  eventResponse = this.transmitEdiByEdo(e);
			  }
		  //// Japan D/O Published target B/L info handle.
		  }else if (e.getEventName().equalsIgnoreCase("EsmBkg0326Event")) {
			  if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				  eventResponse = this.searchJapDo(e);
			  }else if(e.getFormCommand().isCommand(FormCommand.MODIFY)){
				  eventResponse = this.manageJapDo(e);
			  }else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				  eventResponse = this.issueJapDo(e);
			  }else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				  eventResponse = this.cancelDo(e);
			  }else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){
				  eventResponse = this.transmitEdiJapDor(e);
			  }else if(e.getFormCommand().isCommand(FormCommand.MULTI06)){
				  eventResponse = this.transmitEdiJapDorCancel(e);
			  }else if(e.getFormCommand().isCommand(FormCommand.MULTI05)){
				  eventResponse = this.modifyJapDoId(e);
			  }else if(e.getFormCommand().isCommand(FormCommand.MULTI04)){
				  eventResponse = this.holdDo(e);
			  }else{
				eventResponse = getComIntgCodes(new String[]{"CD02101"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C", "X"}});
			  }
		}
		//0909
		else if  (e.getEventName().equalsIgnoreCase("EsmBkg0909Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {//Master retrieve
				eventResponse = this.searchUsCgoRlseList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {//Detail retrieve
				eventResponse = this.searchUsCgoRlseFoc(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {//OTS,DEM info retrieve
				eventResponse = this.searchErpOtsInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {//Original Bill of Lading Status info retrieve
				eventResponse = this.searchUsCgoRlseBlStatus(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH05)) {//Batch (from SAR module)
				eventResponse = this.receiveOtsInfo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {//manage
				eventResponse = this.manageUsCgoRlse(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI03)) {//Hold
				eventResponse = this.manageUsCgoRlseHold(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI04)) {//Multi EDI Sending (Start Back End Job)
				eventResponse = this.startBackEndJobSendBlTdc315EdiMulti(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {    // (Get status of Back End Job)
				eventResponse = this.getBackEndJobStatus(e.getAttribute("backEndJob_Key").toString());
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {    // (Result return)
				eventResponse = this.resultBackEndJobSendBlTdc315EdiMulti(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI09)) {//C/S info manage
				eventResponse = this.manageDoHldRmk(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI16)) {//FRT call test
				eventResponse = this.setupFocByFreight(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI17)) {//OBL call test
				eventResponse = this.setupFocByObl(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI18)) {//CSTMS call test
				eventResponse = this.setupFocByCstms(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI20)) {//REMARK SAVE
				eventResponse = this.manageDoHldRmk(e);
			}else{
				eventResponse = getComIntgCodesWithEvent(new String[]{"CD02101"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C", "X"}},eventResponse);
				eventResponse = getComIntgCodesWithEvent(new String[]{"CD02155"}, new String[]{"customs_code"}, new String[]{"customs_value"}, new String[]{"|"}, new String[][]{{"D", "E","H","I","P","T","V","W"}},eventResponse);
				eventResponse = getComIntgCodesWithEvent(new String[]{"CD02155"}, new String[]{"clearance_code"}, new String[]{"clearance_value"}, new String[]{"|"}, new String[][]{{"",""}},eventResponse);
			}
		}
		// eDO info manage.
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0132Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEdoRqstList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = this.removeEdoErrData(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchEdoCntrRqstList(e);
			}else{
				eventResponse = getComIntgCodes(new String[]{"CD01612"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C", "X"}});
			}
		// eDO Issue Application info manage.
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0133Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEdoByDoRqst(e);
			}
		//D/O EDI Transmit Log List Inquiry info manage.
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0134Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEdoTransLog(e);
			}
		//In-bond Transportation Application info manage(EDI through KT-Net).
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0135Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEdoByIbdTrspRqst(e);
			}
		// Merchant Haulage Application  info manage(EDI through KT-Net).
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0136Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEdoBySelfTrspRqst(e);
			}
		//Office Default From Setup  info of Cargo Release Order manage.
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0137Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDoForm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {
				eventResponse = removeDoForm(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = setupDoForm(e);
			}
		//
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0937Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchEuDoRcvrInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = setupEuDoRcvrInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = sendEuDoByEmail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = sendEuDoByFax(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)){
				eventResponse = setupEuDoTruckerInfo(e);
			}
			// EU D/O Published target B/L info handle.
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0938Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchEuDo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY)){
				eventResponse = this.manageEuDo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = this.releaseEuDo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = this.cancelEuDo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){
				eventResponse = this.holdDo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI04)){
				eventResponse = this.holdbyCntr(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI05)){
				eventResponse = this.holdRemovalbyCntr(e);
			}else{
				eventResponse = getComIntgCodes(new String[]{"CD02101"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C", "X"}});
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0128Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchGenDo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY)){
				eventResponse = this.manageGenDo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = this.releaseGenDo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = this.cancelDo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI04)){
				eventResponse = this.holdDo(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg1035Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){
				eventResponse = searchVetnamPrnCd(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = this.setupVetnamPrnCd(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0954Event")) {
			if(e.getFormCommand().isCommand(FormCommand.MODIFY)){
				eventResponse = this.createDoHistory(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0936Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIdaDoRcvrInfo (e);
			}else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = setupIdaDoRcvrInfo(e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0694Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchJapDoHistory (e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0131Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDoCheckReport (e);
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0939Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchIdaDoRlseReport (e);
			} else {
				eventResponse = getComIntgCodes(new String[]{"CD02209",}, new String[]{"dmdt_code"}, new String[]{"dmdt_value"});
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0680Event")) {
			if(e.getFormCommand().isCommand(FormCommand.SEARCH)){  // Retrieve
				eventResponse = searchIdaDo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY)){ // Save
				eventResponse = this.manageIdaDo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){ // Release
				eventResponse = this.releaseIdaDo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){ // Hold
				eventResponse = holdDo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){ // Un-Hold
				eventResponse = holdDo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.REMOVE)){ // Cancel
				eventResponse = cancelIdaDo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND06)){
				EsmBkg0682Event event = new EsmBkg0682Event();
				event.setBlNo(((EsmBkg0680Event)e).getBlNo());
				eventResponse = searchBkgNoByBlNo((Event)event); //search Bkg No
			}else{
				eventResponse = getComIntgCodes(new String[]{"CD02209"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C", "X"}});
			}
		}
		else if (e.getEventName().equalsIgnoreCase("EsmBkg0923Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUsCgoRlseHis (e);
			}
		}

		else if (e.getEventName().equalsIgnoreCase("EsmBkg1018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDoPrnRmk(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = modifyDoPrnRmk(e);
			}
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg0272Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFullCntrRlseOrderList (e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)){
				eventResponse = transmitEdiFullCntrRlseOrder(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI02)){
				eventResponse = sendFullCntrRlseOrderByEmail(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI03)){
				eventResponse = manageBkgEuPinNo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND03)){
				eventResponse = searchFullCntrRlseOrdMailCtnt(e);
			}else{
				eventResponse = getComIntgCodes(new String[]{"CD01662"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"N", "V", "W"}});
			}
		   /******************************************************************************************
				Canada Cargo Release
			******************************************************************************************/
		}else if (e.getEventName().equalsIgnoreCase("EsmBkg1167Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {// 조회
				eventResponse = searchCaCgoRlseList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {//Container 조회
				eventResponse = searchCaCgoRlseCntr(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {//OTS,DEM 정보가져오기
				eventResponse = searchCaErpOtsInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {//Original Bill of Lading Status 정보 가져오기
				eventResponse = searchCaCgoRlseBlStatus(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI01)) {//저장(SAVE) 0909용
				eventResponse =  manageCaCgoRlse(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI03)) {//Hold
				eventResponse = manageCaCgoRlseHold(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI04)) {//Multi EDI Sending
				eventResponse = this.startBackEndJobSendCaBlTdc315EdiMulti(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {    // (Get status of Back End Job)
				eventResponse = this.getBackEndJobStatus(e.getAttribute("backEndJob_Key").toString());
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {    // (Result return)
				eventResponse = this.resultBackEndJobSendCaBlTdc315EdiMulti(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI20)) {//저장(SAVE)
				eventResponse = manageCaCgoHldRmk(e);
			}else{
				eventResponse = getComIntgCodesWithEvent(new String[]{"CD02101"}, new String[]{"code"}, new String[]{"value"}, new String[]{"|"}, new String[][]{{"C", "X"}},eventResponse);
			}
		}else if(e.getEventName().equalsIgnoreCase("EsmBkg0273Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFullReleaseHistory(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EsmBkg0271Event")){
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBkgEuPinNoHistory(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EsmBkg1052Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyFullCntrRlseRmk(e);
			}
		}else if(e.getEventName().equalsIgnoreCase("EsmBkg0130Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchDoRcvrInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = setupDoRcvrInfo(e);
			}
		}
		return eventResponse;
	}

	/**
	 * Back End Job 공통<br>
	 *  - Back End Job Status 조회 (동일 BCImpl에 Back End Job이 여러개일때 공통으로 사용)
	 *
	 * @param String backEndJobKey
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse getBackEndJobStatus(String backEndJobKey) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

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
	 * VARIABLE UI - Code Selection<br>
	 * TODO: can move Booking Utility
	 * @param String[] intgCdIds
	 * @param String[] intgCdValCtntNames ETC DATA set Key Ex 'intg_code' in Response
	 * @param String[] intgCdValDpDescNames  ETC DATA set Key 'intg_value' in Response
	 * @exception EventException
	 * @return EventResponse
	 * @author
	 */
	private EventResponse getComIntgCodes(String[] intgCdIds, String[] intgCdValCtntNames, String[] intgCdValDpDescNames ) throws EventException {
		String[] concatStrs = new String[]{"|"}; // default concat value
		//String[][] excludeCodeList = null;
		return getComIntgCodes(intgCdIds, intgCdValCtntNames, intgCdValDpDescNames, concatStrs, null);
	}

	/**
	 * VARIABLE UI - Code Selection<br>
	 * TODO: can move Booking Utility
	 * @param String[] intgCdIds Code No EX- 'CD01655'
	 * @param String[] intgCdValCtntNames  ETC DATA set Key Ex 'intg_code' in Response
	 * @param String[] intgCdValDpDescNames   ETC DATA set Key 'intg_value' in Response
	 * @param String[] concatStrs
	 * @param String[][] excludeCodeList
	 * @exception EventException
	 * @return EventResponse
	 * @author
	 */
	@SuppressWarnings({ "unchecked" })
	private EventResponse getComIntgCodes(String[] intgCdIds, String[] intgCdValCtntNames, String[] intgCdValDpDescNames, String[] concatStrs, String[][] excludeCodeList ) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			CodeUtil codeUtil = com.clt.framework.component.util.code.CodeUtil.getInstance();

//            if (!(intgCdIds == null || intgCdIds.length == 0
//                    || intgCdValCtntNames == null || intgCdValCtntNames.length == 0
//                    || intgCdValDpDescNames == null || intgCdValDpDescNames.length == 0)
//                && (intgCdIds.length == intgCdValCtntNames.length
//                        && intgCdIds.length == intgCdValDpDescNames.length)
//               ) {

			if (!(intgCdIds.length == 0 || intgCdValCtntNames.length == 0 || intgCdValDpDescNames.length == 0)
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

					eventResponse.setETCData(intgCdValCtntNames[idx], sbCode.toString());
					eventResponse.setETCData(intgCdValDpDescNames[idx], sbValue.toString());

					sbCode.delete(0, sbCode.length() );
					sbValue.delete(0, sbValue.length());
				}
			}

		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// BKG00450 : retrieve failed.
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * VARIABLE UI - Code Selection<br>
	 * TODO: can move Booking Utility
	 * @param String[] intgCdIds Code No
	 * @param String[] intgCdValCtntNames  ETC DATA set Key Ex 'intg_code' in Response
	 * @param String[] intgCdValDpDescNames   ETC DATA set Key 'intg_value' in Response
	 * @param String[] concatStrs
	 * @param String[][] excludeCodeList
	 * @exception EventException
	 * @return EventResponse
	 * @author
	 */
	@SuppressWarnings("unchecked")
	private EventResponse getComIntgCodesWithEvent(String[] intgCdIds, String[] intgCdValCtntNames, String[] intgCdValDpDescNames, String[] concatStrs, String[][] excludeCodeList, EventResponse eventResponse ) throws EventException {
		try {

			if (eventResponse == null) {
				eventResponse = new GeneralEventResponse();
			}

			CodeUtil codeUtil = com.clt.framework.component.util.code.CodeUtil.getInstance();

//            if (!(intgCdIds == null || intgCdIds.length == 0
//                    || intgCdValCtntNames == null || intgCdValCtntNames.length == 0
//                    || intgCdValDpDescNames == null || intgCdValDpDescNames.length == 0)
//                && (intgCdIds.length == intgCdValCtntNames.length
//                        && intgCdIds.length == intgCdValDpDescNames.length)
//               ) {
			if (!(intgCdIds.length == 0 || intgCdValCtntNames.length == 0 || intgCdValDpDescNames.length == 0)
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

					eventResponse.setETCData(intgCdValCtntNames[idx], sbCode.toString());
					eventResponse.setETCData(intgCdValDpDescNames[idx], sbValue.toString());

					sbCode.delete(0, sbCode.length() );
					sbValue.delete(0, sbValue.length());
				}
			}

		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// BKG00450 : retrieve failed
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1000 : retrieve event handling<br>
	 * FullReleaseOrder list retrieve<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKorDoCustList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1001Event event1 = null;
		EsmBkg1000Event event0 = null;
//        String mdtrNm = null;
//        String mdtrNo = null;

		String mdtrNm = "";
		String mdtrNo = "";

		if (e.getEventName().equalsIgnoreCase("EsmBkg1001Event")) {
			event1 = (EsmBkg1001Event)e;
			mdtrNm = event1.getBkgKorDoAttorneyVO().getAttyCustNm();
			mdtrNo = event1.getBkgKorDoAttorneyVO().getAttyBizNo();
		} else if (e.getEventName().equalsIgnoreCase("EsmBkg1000Event")) {
			event0 = (EsmBkg1000Event)e;
			mdtrNm = event0.getBkgKorDoAttorneyVO().getAttyCustNm();
			mdtrNo = event0.getBkgKorDoAttorneyVO().getAttyBizNo();
		}

		try {
			CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
			List<KorDoAttorneyVO> list = command.searchKorDoCustList(mdtrNm, mdtrNo);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0711 : retrieve event handling<br>
	 * Cargo Release Order History info retrieve<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDoHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0711Event event = (EsmBkg0711Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try {
			List<DoHisVO> list = command.searchDoHistory( event.getDoHisVO().getBkgNo());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1000 : manage<br>
	 * Cargo Release Order History info manage<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageKorDoCust(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1000Event event = (EsmBkg1000Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			begin();
			command.manageKorDoCust(event.getBkgKorDoAttorneyVOs(),account);

			// input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0999 : retrieve event handling<br>
	 * Attorney Register Pop-up info retrieve<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKorDoAttorneyList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0999Event event = (EsmBkg0999Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try {
			List<KorDoAttorneyDtlVO> list = command.searchKorDoAttorneyList( event.getBkgKorDoAttorneyDtlVO().getCustType(),
																			 event.getBkgKorDoAttorneyDtlVO().getCustName(),
																			 event.getBkgKorDoAttorneyDtlVO().getCustBizNo());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0999 : manage<br>
	 * Attorney Register Pop-up info manage<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageKorDoAttorney(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0999Event event = (EsmBkg0999Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			begin();
			command.manageKorDoAttorney(event.getBkgKorDoAttorneyDtlVOs(),account);
			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0999 : retrieve event handling<br>
	 * Attorney Register Pop-up info retrieve<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchKorDoAttorneyDtl(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0999Event event = (EsmBkg0999Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			String dupCnt = command.searchKorDoAttorneyDtl( event.getBkgKorDoAttorneyDtlVO().getFmAttyBizNo(),
															event.getBkgKorDoAttorneyDtlVO().getToAttyBizNo()
														  );
			eventResponse.setETCData("dupCnt", ""+dupCnt);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0682 : retrieve event handling<br>
	 * Korea D/O Published target B/L info retrieve.
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */

	private EventResponse searchKorDo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmBkg0682Event event = (EsmBkg0682Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		BookingUtil bookingUtil = null;
		//received data to DEM/DET
//        DmtChargeVO dmtChargeVo  = null;
		DmtChargeVO dmtChargeVo = new DmtChargeVO();
		try {
			bookingUtil = new BookingUtil();

			//if be not Bkg_No, retrieve over B/L No
			if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
				String bkgNo = bookingUtil.searchBkgNoByBlNo(event.getBlNo());
				if(! "".equals(bkgNo)){
					event.setBkgNo(bkgNo);
				}else{
					String[] msg = new String[]{event.getBlNo()};
					throw new EventException(new ErrorHandler("BKG40031", msg).getMessage());
				}
			}

			//List<ToTBilAmtVO> bilAmtVOList = new ArrayList<ToTBilAmtVO>();
			String tpbStatus = ""; //TPB Status

			//Korea D/O Published target B/L info retrieve.
			KorDoMstVO korDoMst = command.searchKorDo(event.getBkgNo(), account);

			if(korDoMst.getKorDoBlInfo() != null){
				try {
					// DEM/DET I/F interface
					dmtChargeVo = this.searchDemDetChargeInfo(event.getBkgNo(),korDoMst.getKorDoBlInfo().getPodCd(),event.getDemurType(),event.getExpDelDt());
				} catch (Exception ex) {
					log.error("err : " + ex.toString(), ex);
					//Tty method using reason: Business Logic Exception can not handle
				}

				StatusInquiryBC tpbIF = new StatusInquiryBCImpl();
				SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO = new SearchTPBStatusByBkgNoVO();
				searchTpbStatusByBkgNoVO.setSbkgno(event.getBkgNo());
				tpbStatus = tpbIF.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
			}

			//Korea D/O Release info retrieve
			eventResponse.setRsVo(korDoMst.getKorDoBlInfo());

			//STATUS(ASSIGN, RELEASE, ISSUE) detail info retrieve
			eventResponse.setRsVoList(korDoMst.getDoRlseSts());
			// Outstanding Amounts info retrieve
			eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerCntrVOS());
			eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerInvVOS());
			eventResponse.setRsVoList(dmtChargeVo.getBilAmtVOList());



			eventResponse.setETCData("demurType"  , dmtChargeVo.getDemurType() == null ?"": dmtChargeVo.getDemurType());
			eventResponse.setETCData("mrdId"      , JSPUtil.getNull(korDoMst.getMrdId(), ""));
			eventResponse.setETCData("tpbStatus"  , tpbStatus);


		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	/**
	 * Common : DEM/DET Charge Info retrieve<br>
	 * D/O Published target B/L DEM/DET Charge Info info retrieve.
	 *
	 * @param bkgNo    String
	 * @param podCd    String
	 * @param dmdtTp   String
	 * @param expDelDt String
	 * @return dmtChargeVo DmtChargeVO
	 * @exception EventException
	 */
	private DmtChargeVO searchDemDetChargeInfo( String bkgNo,String podCd,String dmdtTp,String expDelDt ) throws EventException {

		CargoReleaseOrderBC cargoReleaseOrder = null;
		ChargeCalculationBC chargeCalculation = null;
		BookingUtil bookingUtil               = null;

		ChargeByBookingCustomerParmVO chargeByBookingCustomerParmVo = null;
		ChargeByBookingCustomerGrpVO chargeByBookingCustomerGrpVo   = null;
		DmtChargeVO dmtChargeVo                                     = null;
		try{
			cargoReleaseOrder = new CargoReleaseOrderBCImpl();

			// For DEM.DET I/F, Container Number retrieve
			String[] cntrs =  cargoReleaseOrder.searchDemDetCntrList(bkgNo);

			chargeByBookingCustomerParmVo = new ChargeByBookingCustomerParmVO();

			chargeByBookingCustomerParmVo.setBkgNo(bkgNo);
			chargeByBookingCustomerParmVo.setPodCd(podCd);
			chargeByBookingCustomerParmVo.setDmdtTp(dmdtTp);
			chargeByBookingCustomerParmVo.setExpDelDt(expDelDt);
			chargeByBookingCustomerParmVo.setCntrNo(cntrs);

			chargeCalculation = new ChargeCalculationBCImpl();

			chargeByBookingCustomerGrpVo = chargeCalculation.searchChargeByCustomer(chargeByBookingCustomerParmVo);

			bookingUtil = new BookingUtil();
			dmtChargeVo = bookingUtil.searchChargeByCustomer(chargeByBookingCustomerGrpVo);
		}catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return dmtChargeVo;
	}

	/**
	 * ESM_BKG_0682 : one's only suit input event handling<br>
	 * Korea Cargo Release (D/O) info manage<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageKorDo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0682Event event = (EsmBkg0682Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		// call interface
		BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();

		try{
			begin();

			if(null != event.getBlIssVOs()){
				event.getBlIssVOs()[0].setOblRdemFlg(event.getAftOblRdemFlg());
				event.getBlIssVOs()[0].setOblRdemOfcCd(account.getOfc_cd());
				event.getBlIssVOs()[0].setOblRdemUsrId(account.getUsr_id());
				event.getBlIssVOs()[0].setOtrDocRcvOfcCd(account.getOfc_cd());
				event.getBlIssVOs()[0].setOtrDocRcvUsrId(account.getUsr_id());
				event.getBlIssVOs()[0].setCreUsrId(account.getUsr_id());
				event.getBlIssVOs()[0].setUpdUsrId(account.getUsr_id());
				//call manageOBLIssue
				bLIssuanceBC.manageOblRcv(event.getBlIssVOs()[0]);
			}

			if(null != event.getKorDoSave()){
				//whether OBL Change or not
				event.getKorDoSave()[0].setOblCngFlg(event.getOblCngFlg());
				//session info setting
				event.getKorDoSave()[0].setCreUsrId(account.getUsr_id());
				event.getKorDoSave()[0].setUpdUsrId(account.getUsr_id());
				event.getKorDoSave()[0].setAcount(account);
				event.getKorDoSave()[0].setOldOblRdemKnt(event.getOldOblRdemKnt());
				event.getKorDoSave()[0].setNewOblRdemKnt(event.getNewOblRdemKnt());
				event.getKorDoSave()[0].setDoCngEvntCd(event.getDoCngEvntCd());
				event.getKorDoSave()[0].setDoSplitFlg("N");
				//call manageKorDo
				command.manageKorDo(event.getKorDoSave()[0]);
			}


			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
			commit();
		}catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0682 <br>
	 * Korea Cargo Release (D/O) info manage<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse assignDo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			begin();

			if(e.getEventName().equalsIgnoreCase("EsmBkg0682Event")){

				EsmBkg0682Event korEvent = (EsmBkg0682Event)e;
				korEvent.getDoAsign()[0].setAcount(account);
				command.assignDo(korEvent.getDoAsign()[0]);

			}

			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00653").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0682 : D/O Release handling<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author
	 */
	private EventResponse releaseKorDo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0682Event event = (EsmBkg0682Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			begin();
			KorDoRlseVO korDoRlse = null;
			if(null != event.getDoBlInfo()){
				korDoRlse = new KorDoRlseVO();
				korDoRlse.setBkgNo(event.getDoBlInfo()[0].getBkgNo());

				if(event.getDoRlseSts() !=null){
					korDoRlse.setDoNo(event.getDoRlseSts()[0].getDoNo());
					korDoRlse.setRlseSeq(event.getDoRlseSts()[0].getRlseSeq());
				}

				korDoRlse.setCreUsrId(account.getUsr_id());
				korDoRlse.setUpdUsrId(account.getUsr_id());
				korDoRlse.setAcount(account);
				korDoRlse.setCgorRmk(event.getReleaseRemark());
				korDoRlse.setDiscLocCd(event.getDiscLocCd());
				korDoRlse.setRlseStsCd(event.getRlseStsCd());
				korDoRlse.setSelfTrnsFlg(event.getSelfTrnsFlg());

				korDoRlse.setBlInfo(event.getDoBlInfo()[0]);
				korDoRlse.setDoRef(event.getRefInfos()[0]);

				command.releaseKorDo(korDoRlse);

			}
			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00669").getUserMessage());
			commit();
		}catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0682 : D/O Assign or Cancel Release Status.<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author     *
	 */
	private EventResponse cancelKorDo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = null;
		KorDoCancelVO korDoCancel          = null;
		CargoReleaseOrderBC command        = null;
		EsmBkg0682Event korEvent           = (EsmBkg0682Event)e;

		try{
			begin();

			eventResponse = new GeneralEventResponse();
			korDoCancel = new KorDoCancelVO();
			command = new CargoReleaseOrderBCImpl();


			korDoCancel.setBkgNo(korEvent.getBkgNo());
			korDoCancel.setDoNo(korEvent.getDoRlseSts()[0].getDoNo());
			korDoCancel.setCreUsrId(account.getUsr_id());
			korDoCancel.setUpdUsrId(account.getUsr_id());
			korDoCancel.setEvntOfcCd(account.getOfc_cd());
			korDoCancel.setAcount(account);
			korDoCancel.setDiscLocCd(korEvent.getDiscLocCd());
			korDoCancel.setRlseStsCd(korEvent.getRlseStsCd());
			korDoCancel.setRlseSeq(korEvent.getDoRlseSts()[0].getRlseSeq());
			korDoCancel.setSelfTrnsFlg(korEvent.getSelfTrnsFlg());

			command.cancelKorDo(korDoCancel);

			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00674").getUserMessage());
			commit();
		}catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : D/O Assign or Cancel Release Status..<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author     *
	 */
	private EventResponse cancelDo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		DoCancelVO doCancel = new DoCancelVO();

		if(e.getEventName().equalsIgnoreCase("EsmBkg0326Event")){

			EsmBkg0326Event japEvent = (EsmBkg0326Event)e;

			doCancel.setDoNo(japEvent.getDoRlseSts()[0].getDoNo());
			doCancel.setRlseStsCd("'I','C'");
			doCancel.setCreUsrId(account.getUsr_id());
			doCancel.setUpdUsrId(account.getUsr_id());
			doCancel.setEvntOfcCd(account.getOfc_cd());
		}

//        else if(e.getEventName().equalsIgnoreCase("EsmBkg0128Event")){
//            doCancel.setDoNo(geEvent.getDoRlseSts()[0].getDoNo());
//            doCancel.setRlseStsCd("'R','C'");
//            doCancel.setRlseSeq(geEvent.getResetFlg());

//            EsmBkg0128Event geEvent = (EsmBkg0128Event)e;
//            doCancel.setBkgNo(geEvent.getBkgNo());
//            doCancel.setDoNo(geEvent.getDoNo());
//            doCancel.setRlseStsCd("'R','C'");
//            doCancel.setRlseSeq(geEvent.getResetFlg());
//            doCancel.setSplitFlg(geEvent.getSplitFlg());
//            doCancel.setCreUsrId(account.getUsr_id());
//            doCancel.setUpdUsrId(account.getUsr_id());
//            doCancel.setEvntOfcCd(account.getOfc_cd());
//        }

		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			begin();
			if(e.getEventName().equalsIgnoreCase("EsmBkg0326Event")){
				command.cancelDo(doCancel);
			} else if(e.getEventName().equalsIgnoreCase("EsmBkg0128Event")){
				EsmBkg0128Event geEvent = (EsmBkg0128Event)e;

				if ("Y".equals(geEvent.getSplitFlg())) {
					log.debug("============================== Cntr Length : " + geEvent.getdoCntrRlseSts().length);

					EuDoCntrRlseStsVO[] doCntrs = geEvent.getdoCntrRlseSts();

					for(int i=0;i<doCntrs.length;i++){
						doCancel.setBkgNo(geEvent.getBkgNo());
						doCancel.setDoNo(doCntrs[i].getDoNo());
						doCancel.setRlseStsCd("'R','C'");
						doCancel.setRlseSeq(geEvent.getResetFlg());
						doCancel.setSplitFlg(geEvent.getSplitFlg());
						doCancel.setCreUsrId(account.getUsr_id());
						doCancel.setUpdUsrId(account.getUsr_id());
						doCancel.setEvntOfcCd(account.getOfc_cd());

						command.cancelEuDo(doCancel);
					}
				} else {
					doCancel.setBkgNo(geEvent.getBkgNo());
					doCancel.setDoNo(geEvent.getDoNo());
					doCancel.setRlseStsCd("'R','C'");
					doCancel.setRlseSeq(geEvent.getResetFlg());
					doCancel.setSplitFlg(geEvent.getSplitFlg());
					doCancel.setCreUsrId(account.getUsr_id());
					doCancel.setUpdUsrId(account.getUsr_id());
					doCancel.setEvntOfcCd(account.getOfc_cd());

					command.cancelEuDo(doCancel);
				}
			}
//            command.cancelDo(doCancel);
			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00674").getUserMessage());
			commit();
		}catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : D/O hold setting.<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author     *
	 */
	private EventResponse holdDo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		DoHoldVO doHold = new DoHoldVO();
		String evntFlag = "";
		if(e.getEventName().equalsIgnoreCase("EsmBkg0682Event")){

			EsmBkg0682Event korEvent = (EsmBkg0682Event)e;

			doHold.setBkgNo(korEvent.getDoBlInfo()[0].getBkgNo());
			doHold.setUpdUsrId(account.getUsr_id());
			doHold.setCreUsrId(account.getUsr_id());
			doHold.setAcount(account);

			evntFlag = korEvent.getEvntFlag();
			doHold.setEvntFlag(evntFlag);

		}else if(e.getEventName().equalsIgnoreCase("EsmBkg0326Event")){

			EsmBkg0326Event japEvent = (EsmBkg0326Event)e;

			doHold.setBkgNo(japEvent.getDoBlInfo()[0].getBkgNo());
			doHold.setUpdUsrId(account.getUsr_id());
			doHold.setCreUsrId(account.getUsr_id());
			doHold.setAcount(account);

			evntFlag = japEvent.getEvntFlag();
			doHold.setEvntFlag(evntFlag);

		}else if(e.getEventName().equalsIgnoreCase("EsmBkg0680Event")){

			EsmBkg0680Event idaEvent = (EsmBkg0680Event)e;
			doHold.setBkgNo(idaEvent.getBkgNo());
			doHold.setAcount(account);
			evntFlag = idaEvent.getEvntFlag();
			doHold.setUpdUsrId(account.getUsr_id());
			doHold.setCreUsrId(account.getUsr_id());
			doHold.setEvntFlag(evntFlag);

		}else if(e.getEventName().equalsIgnoreCase("EsmBkg0938Event")){

			EsmBkg0938Event euEvent = (EsmBkg0938Event)e;
			doHold.setBkgNo(euEvent.getDoBlInfo()[0].getBkgNo());
			doHold.setUpdUsrId(account.getUsr_id());
			doHold.setCreUsrId(account.getUsr_id());
			doHold.setAcount(account);
			evntFlag = euEvent.getEvntFlag();
			doHold.setEvntFlag(evntFlag);
		}else if(e.getEventName().equalsIgnoreCase("EsmBkg0128Event")){

			EsmBkg0128Event geEvent = (EsmBkg0128Event)e;
			doHold.setBkgNo(geEvent.getGenBlInfos()[0].getBkgNo());
			doHold.setUpdUsrId(account.getUsr_id());
			doHold.setCreUsrId(account.getUsr_id());
			doHold.setAcount(account);
			evntFlag = geEvent.getEvntFlag();
			doHold.setEvntFlag(evntFlag);
		}else if(e.getEventName().equalsIgnoreCase("EsmBkg0909Event")){

			EsmBkg0909Event geEvent = (EsmBkg0909Event)e;

			doHold.setBkgNo(geEvent.getBkgNo());
			doHold.setUpdUsrId(account.getUsr_id());
			doHold.setCreUsrId(account.getUsr_id());
			doHold.setAcount(account);
			evntFlag = geEvent.getDoRefVOs()[0].getDoHldFlg();
			doHold.setEvntFlag(evntFlag);
		}

		try{
			begin();

			command.holdDo(doHold);
			//input success massage key to errorHandler
			String msg = "";
			if("H".equals(evntFlag)){
				msg = "BKG00660";
			}else if("R".equals(evntFlag)){
				msg = "BKG00661";
			}
			eventResponse.setUserMessage(new ErrorHandler(msg).getUserMessage());
			commit();
		}catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0682 : Transmit EDI by E-DO <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitEdiByEdo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0737Event event = (EsmBkg0737Event)e;
		//CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			begin();
			if(null != event.getEdoEdiTrans()){
				for(int idx = 0; idx<event.getEdoEdiTrans().length; idx++){
					event.getEdoEdiTrans()[idx].setAcount(account);
				}
			}
//            command.transmitEdiByEdo(event.getEdoEdiTrans());
			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0682 : after request receipt EDO, transmission result info manage.<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse receiptEdoRqstAck(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0682Event event = (EsmBkg0682Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			begin();
			command.receiptEdoRqstAck(event.getRqstNo(), event.getAckInd());
			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0682 : received data to E-Service center manage<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse receiptEdo(Event e) throws EventException {

		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0682Event event = (EsmBkg0682Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			begin();
			command.receiptEdo(event.getEdoRqstVO(), account);
			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0682 : EDO Log info save.<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse receiptEdoLog(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0682Event event = (EsmBkg0682Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			begin();
			command.receiptEdoLog(event.getBkgEdoLogVO());
			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0682 <br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitEdiKorDo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0682Event event = (EsmBkg0682Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			begin();
			event.getKorDoEdiTrans()[0].setAcount(account);
			event.getKorDoEdiTrans()[0].setDoType("KDS");
			event.getKorDoEdiTrans()[0].setSelfTrnsFlg(event.getSelfTrnsFlg());
			event.getKorDoEdiTrans()[0].setDiscLocCd(event.getDiscLocCd());

			command.transmitEdiByKorDo(event.getKorDoEdiTrans()[0]);

			//input success massage key to errorHandler
			String msgId = "";
			if("Y".equals(event.getSelfTrnsFlg())){
				msgId = "BKG00693";  //EDI Send
			}else{
				msgId = "BKG00692";  //S/T Cancel
			}
			eventResponse.setUserMessage(new ErrorHandler(msgId).getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0682 : BKG NO retrieve over BL No<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBkgNoByBlNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmBkg0682Event event = (EsmBkg0682Event)e;
		BookingUtil bookingUtilBC = new BookingUtil();

		try{
			String bkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());
			DoBlInfoVO doRefVO = new DoBlInfoVO();
			doRefVO.setBkgNo(bkgNo);
			doRefVO.setBlNo(event.getBlNo());
			eventResponse.setRsVo(doRefVO);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : retrieve event handling<br>
	 * Japan Published target B/L Info info retrieve.
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchJapDo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmBkg0326Event event = (EsmBkg0326Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		BookingUtil bookingUtil = null;
		//received data to DEM/DET
		DmtChargeVO dmtChargeVo  = null;

		try{
			bookingUtil = new BookingUtil();

			if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
				//if be not Bkg_No, retrieve over B/L No
				String bkgNo = bookingUtil.searchBkgNoByBlNo(event.getBlNo());
				if(! "".equals(bkgNo)){
					event.setBkgNo(bkgNo);
				}else{
					String[] msg = new String[]{event.getBlNo()};
					throw new EventException(new ErrorHandler("BKG40031", msg).getMessage());
				}
			}
			//received data to DEM/DET


			String tpbStatus = ""; //TPB Status

			JapDoMstVO japDoMst = command.searchJapDo(event.getBkgNo(), account);

			dmtChargeVo = new DmtChargeVO();

			if(japDoMst.getBlInfo() != null){

				// DEM/DET I/F
				dmtChargeVo = this.searchDemDetChargeInfo(event.getBkgNo(),japDoMst.getBlInfo().getPodCd(),event.getDemurType(),event.getExpDelDt());

				StatusInquiryBC tpbIF = new StatusInquiryBCImpl(); //TPB BC creation
				SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO = new SearchTPBStatusByBkgNoVO();
				searchTpbStatusByBkgNoVO.setSbkgno(event.getBkgNo());
				tpbStatus = tpbIF.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
			}

			//get Japan D/O Release info
			eventResponse.setRsVo(japDoMst.getBlInfo());

			//get Japan D/O Release Reference info
			eventResponse.setRsVo(japDoMst.getDoRef());

			//get Japan Customs B/L INFO
			eventResponse.setRsVo(japDoMst.getJapCstms());

			//get each B/L of D/O that STATUS(ASSIGN, RELEASE, ISSUE) detail info
			eventResponse.setRsVoList(japDoMst.getDoRlseSts());

			//when retrieve, get retrieved Original B/L whether collect or not and detail info
			eventResponse.setRsVo(japDoMst.getBlIss());

			//get Outstanding Amounts info
			eventResponse.setRsVo(japDoMst.getOtsRcvInfoVO());
			eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerCntrVOS());
			eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerInvVOS());
			eventResponse.setRsVoList(dmtChargeVo.getBilAmtVOList());

			//get Dor Interface status info and Jap Do ID info
			eventResponse.setRsVo(japDoMst.getJapDorStatus());
		   //ETC DATA handling
			if(japDoMst.getBlInfo() != null){
				eventResponse.setETCData("demurType"    , dmtChargeVo.getDemurType() == null ?"": dmtChargeVo.getDemurType());
				eventResponse.setETCData("dorStowage"   , japDoMst.getDorStowage());
				eventResponse.setETCData("tpbStatus"    , tpbStatus);
				eventResponse.setETCData("mrdId"        , JSPUtil.getNull(japDoMst.getMrdId(), ""));
			} else {
				eventResponse.setETCData("demurType"    , "");
				eventResponse.setETCData("dorStowage"   , "");
				eventResponse.setETCData("tpbStatus"    , "");
				eventResponse.setETCData("mrdId"        , "");
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : manage event handling<br>
	 * Japan Cargo Release (D/O) manage<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageJapDo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0326Event event = (EsmBkg0326Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		//differ module interface
		BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();

		try{
			begin();

			if(null != event.getBlIssVOs()){
				event.getBlIssVOs()[0].setOblRdemFlg(event.getAftOblRdemFlg());
				event.getBlIssVOs()[0].setOblRdemOfcCd(account.getOfc_cd());
				event.getBlIssVOs()[0].setOblRdemUsrId(account.getUsr_id());
				event.getBlIssVOs()[0].setOtrDocRcvOfcCd(account.getOfc_cd());
				event.getBlIssVOs()[0].setOtrDocRcvUsrId(account.getUsr_id());
				event.getBlIssVOs()[0].setCreUsrId(account.getUsr_id());
				event.getBlIssVOs()[0].setUpdUsrId(account.getUsr_id());

				//set IbdDocRcv info
				event.getBlIssVOs()[0].setIbdDocRcvOfcCd(account.getOfc_cd());
				event.getBlIssVOs()[0].setIbdDocRcvUsrId(account.getUsr_id());

				//call manageOBLIssue
				bLIssuanceBC.manageOblRcv(event.getBlIssVOs()[0]);
			}

			if(null != event.getJapDoSave()){
				//set whether or change not to OBL
				event.getJapDoSave()[0].setOblCngFlg(event.getOblCngFlg());

				//session info setting
				event.getJapDoSave()[0].setCreUsrId(account.getUsr_id());
				event.getJapDoSave()[0].setUpdUsrId(account.getUsr_id());
				event.getJapDoSave()[0].setAcount(account);
				event.getJapDoSave()[0].setOldOblRdemKnt(event.getOldOblRdemKnt());
				event.getJapDoSave()[0].setNewOblRdemKnt(event.getNewOblRdemKnt());
				event.getJapDoSave()[0].setDoCngEvntCd(event.getDoCngEvntCd());
				event.getJapDoSave()[0].setDoSplitFlg("N");
				//manageJapDo call
				command.manageJapDo(event.getJapDoSave()[0]);
			}
			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : D/O Assign / Issue action handling.<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse issueJapDo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0326Event event = (EsmBkg0326Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			begin();

			//issueJapDo call
			JapDoIssueVO japDoIssue = new JapDoIssueVO();

			japDoIssue.setBkgNo(event.getBkgNo());
			japDoIssue.setRlseStsCd(event.getRlseStsCd());
			japDoIssue.setLastRlseStsCd(event.getLastRlseStsCd());
			japDoIssue.setCntrPrtFlg(event.getCntrPrtFlg());
			japDoIssue.setAcount(account);
			japDoIssue.setOldOblRdemKnt(event.getOldOblRdemKnt());
			japDoIssue.setNewOblRdemKnt(event.getNewOblRdemKnt());
			japDoIssue.setDoCngEvntCd(event.getDoCngEvntCd());
			japDoIssue.setCgorRmk(event.getReleaseRemark());
			if(event.getRefInfos() != null){
				japDoIssue.setRefInfo(event.getRefInfos()[0]);
			}

			if(event.getDoRlseSts() != null){
				japDoIssue.setDoRlseSts(event.getDoRlseSts()[0]);
			}
			command.issueJapDo(japDoIssue);

			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00653").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : DOR transmission : transmit D/O ID and Detail info.
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitEdiJapDor(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0326Event event = (EsmBkg0326Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			begin();

			JapDorEdiTransVO japDorEdiTrans = new JapDorEdiTransVO();

			String doNo = event.getDoNo() == null ? event.getDoRlseSts()[0].getDoNo() : event.getDoNo();

			japDorEdiTrans.setBkgNo(event.getDoRlseSts()[0].getBkgNo());
			japDorEdiTrans.setRlseSeq(event.getDoRlseSts()[0].getRlseSeq());
			japDorEdiTrans.setEvntUsrId(account.getUsr_id());
			japDorEdiTrans.setEvntOfcCd(account.getOfc_cd());
			japDorEdiTrans.setCreUsrId(account.getUsr_id());
			japDorEdiTrans.setUpdUsrId(account.getUsr_id());
			japDorEdiTrans.setPreCtnt(event.getPreCtnt());
			japDorEdiTrans.setSvcCd(event.getSvcCd());
			japDorEdiTrans.setBlNo(event.getBlNo());
			japDorEdiTrans.setEvntCd("9");

			japDorEdiTrans.setDoNo(doNo);
			japDorEdiTrans.setUsrId(account.getUsr_id());
			japDorEdiTrans.setOfcCd(account.getOfc_cd());

			command.transmitEdiByJapDor(japDorEdiTrans);

			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00730").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : DOR cancel : transmit D/O ID and detail info.
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse transmitEdiJapDorCancel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0326Event event = (EsmBkg0326Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			begin();

			JapDorEdiTransVO japDorEdiTrans = new JapDorEdiTransVO();

			String doNo = event.getDoNo() == null ? event.getDoRlseSts()[0].getDoNo() : event.getDoNo();

			japDorEdiTrans.setBkgNo(event.getDoRlseSts()[0].getBkgNo());
			japDorEdiTrans.setRlseSeq(event.getDoRlseSts()[0].getRlseSeq());
			japDorEdiTrans.setEvntUsrId(account.getUsr_id());
			japDorEdiTrans.setEvntOfcCd(account.getOfc_cd());
			japDorEdiTrans.setCreUsrId(account.getUsr_id());
			japDorEdiTrans.setUpdUsrId(account.getUsr_id());
			japDorEdiTrans.setPreCtnt(event.getPreCtnt());
			japDorEdiTrans.setSvcCd(event.getSvcCd());
			japDorEdiTrans.setBlNo(event.getBlNo());
			japDorEdiTrans.setEvntCd("1");

			japDorEdiTrans.setDoNo(doNo);
			japDorEdiTrans.setUsrId(account.getUsr_id());
			japDorEdiTrans.setOfcCd(account.getOfc_cd());

			command.transmitEdiByJapDorCancel(japDorEdiTrans);

			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG40109").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : event manage handling<br>
	 * Japan Cargo Release (D/O) manage<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyJapDoId(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0326Event event = (EsmBkg0326Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			begin();

			if(null != event.getJapDorStatus()){
				command.modifyJapDoId(event.getJapDorStatus()[0]);
			}
			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : retrieve event handling<br>
	 * INQUIRY OF eDO info retrieve event handling<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEdoRqstList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0132Event event = (EsmBkg0132Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try {
			List<EdoRqstsVO> list = command.searchEdoRqstList(event.getEdoSearchVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// BKG00450 : retrieve fail
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : remove event handling<br>
	 * InboundNotice manage<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeEdoErrData(Event e) throws EventException {
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try{
			begin();

			EsmBkg0132Event event = (EsmBkg0132Event )e;
			CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

			EdoRqstsVO[] edoRqstsVOs = event.getEdoRqstsVOs();

			command.removeEdoErrData(edoRqstsVOs, e.getSignOnUserAccount());
			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : retrieve event handling<br>
	 * eDO Issue Application Inquiry info retrieve event handling<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEdoByDoRqst(Event e) throws EventException {

		//PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0133Event event = (EsmBkg0133Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try {
			EdoRqstVO edoRqstVO = command.searchEdoByDoRqst(event.getRqstNo(), event.getTpCd());
			// info
			eventResponse.setRsVo(edoRqstVO.getBkgEdoMstVO());

			//get transfer business info
			eventResponse.setRsVo(edoRqstVO.getBkgEdoDoVO());

			//get EdoPtyTrsp info
			eventResponse.setRsVoList(edoRqstVO.getBkgEdoPtyTrspVOs());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : retrieve event handling<br>
	 * D/O EDI Transmit Log List Inquiry info retrieve event handling<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEdoTransLog(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0134Event event = (EsmBkg0134Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try {

			List<BkgEdoLogVO> list = command.searchEdoTransLog(event.getRcvToDt(), event.getRcvFmDt(), event.getBlNo());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : retrieve event handling<br>
	 * In-bond Transportation Application info retrieve event handling<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEdoByIbdTrspRqst(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0135Event event = (EsmBkg0135Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try {

			EdoRqstVO edoRqstVO = command.searchEdoByIbdTrspRqst(event.getRqstNo(), event.getTpCd());

			// info
			eventResponse.setRsVo(edoRqstVO.getBkgEdoMstVO());
			//
			eventResponse.setRsVo(edoRqstVO.getBkgEdoIbdTrspVO());
			//
			eventResponse.setRsVoList(edoRqstVO.getBkgEdoPtyTrspVOs());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : retrieve event handling
	 * KT-Net으로 들어온 EDI로 들어온 Merchant Haulage Application 화면의 event에 대한 특정 리스트 조회 이벤트 처리
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEdoBySelfTrspRqst(Event e) throws EventException {

		//PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0136Event event = (EsmBkg0136Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try {
			EdoRqstVO edoRqstVO = command.searchEdoBySelfTrspRqst(event.getRqstNo(), event.getTpCd());
			// info
			eventResponse.setRsVo(edoRqstVO.getBkgEdoMstVO());
			//
			eventResponse.setRsVo(edoRqstVO.getBkgEdoSelfTrspVO());
			//
			eventResponse.setRsVoList(edoRqstVO.getBkgEdoPtyTrspVOs());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : retrieve event handling<br>
	 * Cargo Release Order의 Office Default From Setup 화면의 event에 대한 특정 리스트 조회 이벤트 처리
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDoForm(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0137Event event = (EsmBkg0137Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try {

			List<BkgDoFomVO> list = command.searchDoForm(event.getOffice());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : remove event handling<br>
	 * InboundNotice manage<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse removeDoForm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0137Event event = (EsmBkg0137Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			begin();
			command.removeDoForm(event.getOffice(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : setup event handling<br>
	 * InboundNotice manage<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse setupDoForm(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0137Event event = (EsmBkg0137Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			begin();
			command.setupDoForm(event.getBkgDoFomVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : retrieve event handling<br>
	 * retrieve Pop-Up that D/O Receiver Set, release and Send of EU_Cargo Release Order <br>
	 *
	 * @param e EsmBkg0937Event
	 * @return EventResponse EsmBkg0937EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEuDoRcvrInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0937Event event = (EsmBkg0937Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try {
			EuDoRcvrVO euDoRcvrVO = command.searchEuDoRcvrInfo(event.getDoNo(), event.getDoNoSplit());
			eventResponse.setRsVoList(euDoRcvrVO.getDoCntrVos());
			eventResponse.setRsVo(euDoRcvrVO.getBkgDoVO());
			eventResponse.setRsVoList(euDoRcvrVO.getBkgDoCntrVOs());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * ESM_BKG_0326 : setup event handling<br>
	 * D/O Receiver Setting of EU_Cargo Release Order manage.<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse setupEuDoRcvrInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0937Event event = (EsmBkg0937Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			begin();
			command.setupEuDoRcvrInfo(event.getBkgDoVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : setup event handling<br>
	 * D/O Receiver Setting of EU_Cargo Release Order manage.<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse setupEuDoTruckerInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0937Event event = (EsmBkg0937Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			begin();
			command.setupEuDoTruckerInfo(event.getBkgDoCntrVOs(), account);
			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : send mail event handling<br>
	 * D/O Receiver Setting info of EU_Cargo Release Order manage and send Email.<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse sendEuDoByEmail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0937Event event = (EsmBkg0937Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();

		try{
			begin();
			String uiId = "ESM_BKG_0937";

			List<BkgNtcHisVO> bkgNtcHisVOs = command.sendEuDoByEmail(event.getBkgDoVOs(), account);
			hisBC.createBkgNtcHis(bkgNtcHisVOs, uiId);
			eventResponse.setUserMessage(new ErrorHandler("BKG40054").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("BKG00243").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0326 : send Fax event handling<br>
	 * Receiver Setting of EU_Cargo Release Order manage and send Fax.<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse sendEuDoByFax(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0937Event event = (EsmBkg0937Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		BookingHistoryMgtBC hisBC = new BookingHistoryMgtBCImpl();

		try{
			begin();
			String uiId = "ESM_BKG_0937";
			List<BkgNtcHisVO> bkgNtcHisVOs = command.sendEuDoByFax(event.getBkgDoVOs(), account);
			hisBC.createBkgNtcHis(bkgNtcHisVOs, uiId);
			eventResponse.setUserMessage(new ErrorHandler("BKG40053").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("BKG00242").getMessage(), ex);
		}
		return eventResponse;
	}



	/**
	 * ESM_BKG_0938 retrieve event handling<br>
	 * EU Cargo Release (D/O) info retrieve event handling<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEuDo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmBkg0938Event event = (EsmBkg0938Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		BookingUtil bookingUtilBC = new BookingUtil();

		try {
			//if be not Bkg_No, retrieve over B/L No
			if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
				String bkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());
				if(! "".equals(bkgNo)){
					event.setBkgNo(bkgNo);
				}else{
					String[] msg = new String[]{event.getBlNo()};
					throw new EventException(new ErrorHandler("BKG40031", msg).getMessage());
				}
			}

			EuDoMstVO euDoMst = command.searchEuDo(event.getBkgNo(), account);

			DmtChargeVO dmtChargeVo = new DmtChargeVO();

			String tpbStatus = ""; //TPB Status

		  //received data to DEM/DET
			if(euDoMst.getBlInfo() != null){

				  dmtChargeVo = this.searchDemDetChargeInfo(event.getBkgNo(),euDoMst.getBlInfo().getPodCd(),event.getDemurType(),event.getExpDelDt());

				  StatusInquiryBC tpbIF = new StatusInquiryBCImpl(); //TPB BC creation
				  SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO = new SearchTPBStatusByBkgNoVO();
				  searchTpbStatusByBkgNoVO.setSbkgno(event.getBkgNo());
				  tpbStatus = tpbIF.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
			}
			//get EU D/O Release info
			eventResponse.setRsVo(euDoMst.getBlInfo());

			//get EU D/O Release Reference info
			eventResponse.setRsVo(euDoMst.getBkgDoRefVO());

			//get B/L INFO info
			eventResponse.setRsVo(euDoMst.getEuCstms());

			//get Container STATUS(ASSIGN, RELEASE, ISSUE) detail info
			eventResponse.setRsVoList(euDoMst.getEuDoCntrRlseStsVOs());

			//get B/L STATUS(ASSIGN, RELEASE, ISSUE) detail info
			eventResponse.setRsVoList(euDoMst.getEuDoRlseStsVOs());


			eventResponse.setRsVo(euDoMst.getBlIss());

			//get Outstanding Amounts info
			eventResponse.setRsVo(euDoMst.getOtsRcvInfoVO());
			eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerCntrVOS());
			eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerInvVOS());
			eventResponse.setRsVoList(dmtChargeVo.getBilAmtVOList());

			//ETC DATA handling
			eventResponse.setETCData("demurType"  , dmtChargeVo.getDemurType());
			eventResponse.setETCData("tpbStatus"  , tpbStatus);
			//get SplitFlg
			eventResponse.setETCData("splitFlg", euDoMst.getSplitFlg());

			eventResponse.setETCData("remainCntrCnt", Integer.toString(euDoMst.getCntrCnt()));
			eventResponse.setETCData("mrdId"       , JSPUtil.getNull(euDoMst.getMrdId(), ""));
			eventResponse.setETCData("localLangFlg", JSPUtil.getNull(euDoMst.getLocalLangFlg(), ""));

		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0938 : manage event handling<br>
	 * EU Cargo Release manage<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageEuDo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0938Event event = (EsmBkg0938Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		// call differ module
		BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();

		try{
			begin();
			if(null != event.getEuDoSave()){
				log.debug("=======================================");
				log.debug("    manageEuDo call");
				log.debug("=======================================");

				//session info setting
				event.getEuDoSave().setUserId(account.getUsr_id());
				event.getEuDoSave().setAcount(account);
				event.getEuDoSave().setOblCngFlg(event.getOblCngFlg());
				event.getEuDoSave().setDoCngEvntCd(event.getDoCngEvntCd());

				command.manageEuDo(event.getEuDoSave());
			}

			if(null != event.getBlIssVOs() && "U".equals(event.getBlIssVOs()[0].getIbflag())){
				log.debug("=======================================");
				log.debug("    manageOBLIssue call                ");
				log.debug("=======================================");
				//set Original Bill of Lading Status
				event.getBlIssVOs()[0].setBkgNo(event.getBkgNo());
				event.getBlIssVOs()[0].setOblIssOfcCd(account.getOfc_cd());
				event.getBlIssVOs()[0].setOblIssUsrId(account.getUsr_id());
				event.getBlIssVOs()[0].setOblRdemOfcCd(account.getOfc_cd());
				event.getBlIssVOs()[0].setOblRdemUsrId(account.getUsr_id());
				event.getBlIssVOs()[0].setOtrDocRcvOfcCd(account.getOfc_cd());
				event.getBlIssVOs()[0].setOtrDocRcvUsrId(account.getUsr_id());
				event.getBlIssVOs()[0].setCreUsrId(account.getUsr_id());
				event.getBlIssVOs()[0].setUpdUsrId(account.getUsr_id());

				bLIssuanceBC.manageOblRcv(event.getBlIssVOs()[0]);
			}

			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0938 : B/L Release action<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse releaseEuDo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0938Event event = (EsmBkg0938Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		//call differ module

		try{
			begin();
			event.getEuDoRlse().setUsrId(account.getUsr_id());
			event.getEuDoRlse().setUsrOfcCd(account.getOfc_cd());

			if ("Y".equals(event.getEuDoRlse().getDoSplitFlg())) {
				log.debug("============================== Cntr Length : " + event.getDoCntrs().length);

				DoCntrVO[] doCntrs = event.getDoCntrs();

				for(int i=0;i<doCntrs.length;i++){
					command.releaseEuDo(event.getEuDoRlse(), doCntrs[i]);
				}
			} else {
				command.releaseEuDo(event.getEuDoRlse(), null);
			}

//            command.releaseEuDo(event.getEuDoRlse(), event.getDoCntrs());
			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00669").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0938 :  Release Status Cancel handling.<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author
	 */
	private EventResponse cancelEuDo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();


		EsmBkg0938Event event = (EsmBkg0938Event)e;

		event.getDoCancel().setCreUsrId(account.getUsr_id());
		event.getDoCancel().setUpdUsrId(account.getUsr_id());
		event.getDoCancel().setEvntOfcCd(account.getOfc_cd());

		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			begin();

			if ("Y".equals(event.getDoCancel().getSplitFlg())) {
				log.debug("============================== Cntr Length : " + event.getEuDoCntrRlseSts().length);

				EuDoCntrRlseStsVO[] doCntrs = event.getEuDoCntrRlseSts();
				DoCancelVO doCancel = new DoCancelVO();

				for(int i=0;i<doCntrs.length;i++){
					doCancel.setBkgNo(event.getDoCancel().getBkgNo());
					doCancel.setDoNo(doCntrs[i].getDoNo());
					doCancel.setRlseStsCd("'R','C'");
					doCancel.setRlseSeq(doCntrs[i].getRlseSeq());
					doCancel.setSplitFlg(event.getDoCancel().getSplitFlg());
					doCancel.setCreUsrId(account.getUsr_id());
					doCancel.setUpdUsrId(account.getUsr_id());
					doCancel.setEvntOfcCd(account.getOfc_cd());

					command.cancelEuDo(doCancel);
				}
			} else {
				command.cancelEuDo(event.getDoCancel());
			}

			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00674").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * ESM_BKG_0128 : retrieve event handling<br>
	 * In situation CY Delivery and CY Unstuffing,  D/O Preview print code retrieve.<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchVetnamPrnCd(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1035Event event = (EsmBkg1035Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try {
			BkgDoVO bkgDoVo = command.searchVetnamPrnCd(event.getBkgNo());
			eventResponse.setRsVo(bkgDoVo);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0128 : setup event handling<br>
	 * EU_Cargo Release Order D/O Receiver Setting manage.<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse setupVetnamPrnCd(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1035Event event = (EsmBkg1035Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			begin();
			String bkgNo = event.getBkgDoVo().getBkgNo();
			String rlseSeq = event.getBkgDoVo().getRlseSeq();
			String vnCgoDeCd = event.getBkgDoVo().getVnCgoDeCd();
			command.setupVetnamPrnCd(bkgNo, rlseSeq, vnCgoDeCd, account.getUsr_id());

			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * ESM_BKG_0954 : setup event handling<br>
	 * History save.<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createDoHistory(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0954Event event = (EsmBkg0954Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			begin();

			event.getBkgDoHis().setCreUsrId(account.getUsr_id());
			event.getBkgDoHis().setUpdUsrId(account.getUsr_id());
			event.getBkgDoHis().setEvntOfcCd(account.getOfc_cd());
			event.getBkgDoHis().setEvntUsrId(account.getUsr_id());

			command.createDoHistory(event.getBkgDoHis());
			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());

			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * ESM_BKG_0128 :  retrieve event handling<br>
	 * Cargo Release info retrieve event handling<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGenDo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmBkg0128Event event = (EsmBkg0128Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		BookingUtil bookingUtilBC = new BookingUtil();
		try {
			//if be not Bkg_No, retrieve over B/L No
			if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
				String bkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());
				if(! "".equals(bkgNo)){
					event.setBkgNo(bkgNo);
				}else{
					String[] msg = new String[]{event.getBlNo()};
					throw new EventException(new ErrorHandler("BKG40031", msg).getMessage());
				}
			}

			DoMstVO doMst = command.searchGenDo(event.getBkgNo(), account);

			//received data to DEM/DET
			DmtChargeVO dmtChargeVo = new DmtChargeVO();
			String tpbStatus = ""; //TPB Status

			if(doMst.getBlInfo() != null){

						// DEM/DET I/F
				  dmtChargeVo = this.searchDemDetChargeInfo(event.getBkgNo(),doMst.getBlInfo().getPodCd(),event.getDemurType(),event.getExpDelDt());

				  StatusInquiryBC tpbIF = new StatusInquiryBCImpl(); //TPB BC creation
				  SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO = new SearchTPBStatusByBkgNoVO();
				  searchTpbStatusByBkgNoVO.setSbkgno(event.getBkgNo());
				  tpbStatus = tpbIF.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
			}

			//set D/O Release info
			eventResponse.setRsVo(doMst.getGenBlInfo());

			//set STATUS(ASSIGN, RELEASE, ISSUE)detail info
//            eventResponse.setRsVoList(doMst.getDoRlseStsVOs());
			eventResponse.setRsVoList(doMst.getGenDoCntrRlseStsVOs());
			eventResponse.setRsVoList(doMst.getGenDoRlseStsVOs());
			eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerCntrVOS());
			eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerInvVOS());

			eventResponse.setRsVoList(dmtChargeVo.getBilAmtVOList());

			//ETC DATA handling
			eventResponse.setETCData("demurType"    , dmtChargeVo.getDemurType());
			eventResponse.setETCData("mrdId"        , JSPUtil.getNull(doMst.getMrdId(), ""));
			eventResponse.setETCData("localLangFlg" , JSPUtil.getNull(doMst.getLocalLangFlg(), ""));
			eventResponse.setETCData("tpbStatus"    , tpbStatus);
			eventResponse.setETCData("splitFlg"     , doMst.getSplitFlg());
			eventResponse.setETCData("remainCntrCnt", Integer.toString(doMst.getCntrCnt()));
			//
			BkgHrdCdgCtntListCondVO hrdVO = new BkgHrdCdgCtntListCondVO();
			hrdVO.setHrdCdgId("DUBAI_DO_MRD_ID");
			hrdVO.setAttrCtnt1(doMst.getBlInfo().getDelCd());
			List<BkgHrdCdgCtntVO> hrdList = bookingUtilBC.searchHardCoding(hrdVO);
			if (hrdList.size() > 0) {
				eventResponse.setETCData("DUBAI_MRD_ID", hrdList.get(0).getAttrCtnt2());
			} else {
				eventResponse.setETCData("DUBAI_MRD_ID", "");
			}

		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0128 :  manage event handling<br>
	 * Cargo Release (D/O) manage<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse manageGenDo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0128Event event = (EsmBkg0128Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		//call differ module
		BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();

		try{
			begin();

			if(null != event.getDoSave()){
				log.debug("=======================================");
				log.debug("    manageDo call");
				log.debug("=======================================");
				log.debug("SC  Split Flg : " + event.getDoSave().getDoSplitFlg());

				//session info setting
				event.getDoSave().setUserId(account.getUsr_id());
				event.getDoSave().setAcount(account);
				event.getDoSave().setOblCngFlg(event.getOblCngFlg());
				event.getDoSave().setDoCngEvntCd(event.getDoCngEvntCd());

				command.manageGenDo(event.getDoSave());
			}

			if(null != event.getBlIssVOs() && "U".equals(event.getBlIssVOs()[0].getIbflag())){
				log.debug("=======================================");
				log.debug("    manageOBLIssue call                ");
				log.debug("=======================================");
				//set Original Bill of Lading Status
				event.getBlIssVOs()[0].setOblRdemFlg(event.getAftOblRdemFlg());
				event.getBlIssVOs()[0].setOblRdemOfcCd(account.getOfc_cd());
				event.getBlIssVOs()[0].setOblRdemUsrId(account.getUsr_id());
				event.getBlIssVOs()[0].setOtrDocRcvOfcCd(account.getOfc_cd());
				event.getBlIssVOs()[0].setOtrDocRcvUsrId(account.getUsr_id());
				event.getBlIssVOs()[0].setCreUsrId(account.getUsr_id());
				event.getBlIssVOs()[0].setUpdUsrId(account.getUsr_id());

				//set IbdDocRcv info
				event.getBlIssVOs()[0].setIbdDocRcvOfcCd(account.getOfc_cd());
				event.getBlIssVOs()[0].setIbdDocRcvUsrId(account.getUsr_id());

				bLIssuanceBC.manageOblRcv(event.getBlIssVOs()[0]);
			}

			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0128 : D/O Release handling.<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 * @author
	 */
	private EventResponse releaseGenDo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0128Event event = (EsmBkg0128Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			begin();
//            DoRlseVO doRlse = null;
//            if(null != event.getGenBlInfos()){
//                doRlse = new DoRlseVO();
//
//                doRlse.setBkgNo(event.getBkgNo());
//                doRlse.setCgorRmk(event.getReleaseRemark());
//                doRlse.setCreUsrId(account.getUsr_id());
//                doRlse.setUpdUsrId(account.getUsr_id());
//                doRlse.setAcount(account);
//                doRlse.setRlseStsCd(event.getRlseStsCd());
//
//                doRlse.setGenBlInfos(event.getGenBlInfos()[0]);
//                doRlse.setDoSplitFlg("N");
//
//                command.releaseGenDo(doRlse);
//            }
			//input success massage key to errorHandler

			event.getGenDoRlse().setCreUsrId(account.getUsr_id());
			event.getGenDoRlse().setUsrOfcCd(account.getOfc_cd());

			if ("Y".equals(event.getGenDoRlse().getDoSplitFlg())) {
				log.debug("============================== Cntr Length : " + event.getDoCntrs().length);

				DoCntrVO[] doCntrs = event.getDoCntrs();

				for(int i=0;i<doCntrs.length;i++){
					command.releaseGenDo(event.getGenDoRlse(), doCntrs[i]);
				}
			} else {
				command.releaseGenDo(event.getGenDoRlse(), null);
			}

			eventResponse.setUserMessage(new ErrorHandler("BKG00669").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0936 : Retrieve D/O Receiver And Ultimate Consignee(Incl. House B/L no) Setting<br>
	 * Indian DO Rcvr info retrieve.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author
	 */
	private EventResponse searchIdaDoRcvrInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		try {
			EsmBkg0936Event event = (EsmBkg0936Event)e;
			CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
			DoRcvrVO doRcvrVO = event.getDoRcvrVO();
			DoRcvrVO doRcvr = command.searchIdaDoRcvrInfo(doRcvrVO.getDoNo(), doRcvrVO.getDoNoSplit());

			if (doRcvr != null) {
				eventResponse.setETCData("do_no_split"   ,doRcvr.getDoNoSplit());
				eventResponse.setETCData("hbl_no"        ,doRcvr.getHblNo());
				eventResponse.setETCData("rcvr_cnee_nm"  ,doRcvr.getRcvrCneeNm());
				eventResponse.setETCData("rcvr_co_nm"    ,doRcvr.getRcvrCoNm());
				eventResponse.setETCData("rcvr_phn_no"   ,doRcvr.getRcvrPhnNo());
				eventResponse.setETCData("pic_nm"        ,doRcvr.getPicNm());
				eventResponse.setETCData("rcvr_eml"      ,doRcvr.getRcvrEml());
				eventResponse.setETCData("cust_to_ord_flg"      ,doRcvr.getCustToOrdFlg());
				eventResponse.setETCData("ERR_MSG", "");
			} else {
				eventResponse.setETCData("ERR_MSG", "BKG01058");
			}

		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0936 : Save  D/O Receiver And Ultimate Consignee(Incl. House B/L no) Setting<br>
	 * Indian DO Rcvr Info manage.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author
	 */
	private EventResponse setupIdaDoRcvrInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			begin();
			EsmBkg0936Event event = (EsmBkg0936Event)e;
			CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
			DoRcvrVO doRcvrVO = event.getDoRcvrVO();
			command.setupIdaDoRcvrInfo(doRcvrVO, account);
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage()); // TODO: 성공 message key
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0694 : Retrieve - Cargo Delivery - DO LIST CHECK REPORT(JAPAN)<br>
	 * Japan Cargo Release Report retrieve.<br>
	 *  @param Event e
	 *  @return EventResponse
	 *  @exception EventException
	 *  @author
	 */
	private EventResponse searchJapDoHistory(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0694Event event = (EsmBkg0694Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try {
			JapDoHisSearchVO japDoHisSearch = event.getJapDoHisSearchVO();
			List<JapDoHisListVO> list = command.searchJapDoHistory(japDoHisSearch);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0131 : Retrieve Cargo Release Order List Check Report<br>
	 * do check list retrieve.<br>
	 *  @param Event e
	 *  @return EventResponse
	 *  @author
	 */
	private EventResponse searchDoCheckReport (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0131Event event = (EsmBkg0131Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try {
			DoCheckListSearchVO chkListSearch = event.getDoCheckListSearchVO();
			List<DoCheckListVO> chkList = command.searchDoCheckReport(chkListSearch);
			eventResponse.setRsVoList(chkList);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0939 : Retrieve - India Cargo Release Order list Inquery<br>
	 *  @param Event e
	 *  @return EventResponse
	 *  @exception EventException
	 *  @author
	 */
	private EventResponse searchIdaDoRlseReport (Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0939Event event = (EsmBkg0939Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try {
			IdaDoRlseSearchVO idaDoRlseSearch = event.getIdaDoRlseSearchVO();
			IdaDoRlseReportVO idaDoRlseReport = command.searchIdaDoRlseReport(idaDoRlseSearch);
			eventResponse.setRsVoList(idaDoRlseReport.getIdaDoWeeklyReportVO());
			eventResponse.setRsVoList(idaDoRlseReport.getIdaDoRlseListVO());
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM-BKG-0680 : Retrieve - retrieve event handling<br>
	 * India Cargo Release (D/O) info retrieve event handling<br>
	 * @param Event e
	 * @return EventResponse response
	 * @exception EventException
	 * @author
	 */
	private EventResponse searchIdaDo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();

		EsmBkg0680Event event = (EsmBkg0680Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		BookingUtil bookingUtilBC = new BookingUtil();

		try {
			//if be not Bkg_No, retrieve over B/L No
			if("".equals(event.getBkgNo()) || null == event.getBkgNo()){
				String bkgNo = bookingUtilBC.searchBkgNoByBlNo(event.getBlNo());
				if(! "".equals(bkgNo)){
					event.setBkgNo(bkgNo);
				}else{
					String[] msg = new String[]{event.getBlNo()};
					throw new EventException(new ErrorHandler("BKG40031", msg).getMessage());
				}
			}

			IdaDoMstVO doMstVO = command.searchIdaDo(event.getBkgNo(), account);

			DmtChargeVO dmtChargeVo  = new DmtChargeVO();
			String tpbStatus = ""; //TPB Status

			//received data to DEM/DET
			if(doMstVO.getDoBlInfoVO() != null){

					// DEM/DET I/F
				 dmtChargeVo = this.searchDemDetChargeInfo(event.getBkgNo(),doMstVO.getDoBlInfoVO().getPodCd(),event.getDemurType(),event.getExpDelDt());

				 StatusInquiryBC tpbIF = new StatusInquiryBCImpl(); //TPB BC creation
				 SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO = new SearchTPBStatusByBkgNoVO();
				 searchTpbStatusByBkgNoVO.setSbkgno(event.getBkgNo());
				 tpbStatus = tpbIF.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
			}

			//get India D/O Release info
			eventResponse.setRsVo(doMstVO.getDoBlInfoVO());

			//set D/O Reference info (refInfo_)
			eventResponse.setRsVo(doMstVO.getBkgDoRefVO());

			eventResponse.setRsVo(doMstVO.getIdaCstmsVO());

			eventResponse.setRsVoList(doMstVO.getIdaDoCntrRlseStsVOList());

			eventResponse.setRsVoList(doMstVO.getIdaDoRlseStsVOList());

			eventResponse.setRsVo(doMstVO.getBlIssVO());

			eventResponse.setRsVo(doMstVO.getOtsRcvInfoVO());
			eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerCntrVOS()); //(demInfo_)
			eventResponse.setRsVoList(dmtChargeVo.getChargeByBookingCustomerInvVOS());  //(demDtl_)
			eventResponse.setRsVoList(dmtChargeVo.getBilAmtVOList()); //(totBlbAmt)

			// ETC Data handling
			eventResponse.setETCData("demurType" , dmtChargeVo.getDemurType());
			eventResponse.setETCData("remain_cnt", Integer.valueOf(doMstVO.getRemainCnt()).toString());
			eventResponse.setETCData("tpbStatus" , tpbStatus);
			eventResponse.setETCData("mrdId"     , JSPUtil.getNull(doMstVO.getMrdId(), ""));

		} catch (EventException ee) {
			throw ee;
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0680 : Save - India Cargo Release<br>
	 * India Cargo BL level info manage.<br>
	 * bkg_do_ref를 변경한다.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author
	 */
	private EventResponse manageIdaDo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0680Event event = (EsmBkg0680Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		//call differ module
		BLIssuanceBC bLIssuanceBC = new BLIssuanceBCImpl();

		try{
			begin();
			IdaDoSaveVO idaDoSave = event.getIdaDoSave();

			if(null != event.getBlIssVOs() && "U".equals(event.getBlIssVOs()[0].getIbflag())){
				log.debug("=======================================");
				log.debug("    manageOBLIssue call                ");
				log.debug("=======================================");
				//set Original Bill of Lading Status.
				event.getBlIssVOs()[0].setOblRdemFlg(event.getAftOblRdemFlg());
				event.getBlIssVOs()[0].setCreUsrId(account.getUsr_id());
				event.getBlIssVOs()[0].setUpdUsrId(account.getUsr_id());

				// set blIss_bl_otr_doc_rcv_cd otr_doc_rcv_ofc_cd, otr_doc_rcv_usr_cd info
				if (event.getBlIssVOs()[0].getBlOtrDocRcvCd() == null || event.getBlIssVOs()[0].getBlOtrDocRcvCd().equals("")) {
					event.getBlIssVOs()[0].setOtrDocCgorFlg("");
					event.getBlIssVOs()[0].setOtrDocRcvDt("");
					event.getBlIssVOs()[0].setOtrDocRcvOfcCd("");
					event.getBlIssVOs()[0].setOtrDocRcvUsrId("");
				} else {
					event.getBlIssVOs()[0].setOtrDocRcvOfcCd(account.getOfc_cd());
					event.getBlIssVOs()[0].setOtrDocRcvUsrId(account.getUsr_id());
				}

				// set enter rcv info
				event.getBlIssVOs()[0].setIbdDocRcvOfcCd(account.getOfc_cd());
				event.getBlIssVOs()[0].setIbdDocRcvUsrId(account.getUsr_id());

				// set OBL RDEM info
				event.getBlIssVOs()[0].setOblRdemOfcCd(account.getOfc_cd());
				event.getBlIssVOs()[0].setOblRdemUsrId(account.getUsr_id());

				bLIssuanceBC.manageOblRcv(event.getBlIssVOs()[0]);
			}

			if(null != event.getIdaDoSave()){

				/*****************************************
					DO RELEASE STATUS CODE
				******************************************
				AS  Assigned
				CR  Cancelled O/BL Received
				DC  DOR Cancel
				DF  DOR I/F
				DT  DOR Transmit
				HC  Cancelled Cargo Hold
				PD  Printed D/O
				RB  Received O. B/L
				RE  Released
				RI  Received In bond Doc
				RO  Received Other Doc
				RR  Remark for Release
				SF  Sent Fax/E-Mail
				XX  Canceled
				******************************************/

				//set OBL Change
				idaDoSave.setOblCngFlg(event.getOblCngFlg());

				idaDoSave.setDoCngEvntCd(event.getDoCngEvntCd());
				idaDoSave.setPreCtnt(event.getPreCtnt());
				idaDoSave.setCrntCtnt(event.getCrntCtnt());
			}else{
				log.debug("=================================================================");
				log.debug("    ori_obl_rdem_flg : "+event.getOriOblRdemFlg());
				log.debug("    aft_obl_rdem_flg : "+event.getAftOblRdemFlg());
				log.debug("=================================================================");
			}
			log.debug("=======================================");
			log.debug("    manageIdaDo call");
			log.debug("=======================================");

			//session info setting
			idaDoSave.setUsrId(account.getUsr_id());
			idaDoSave.setOfcCd(account.getOfc_cd());
			command.manageIdaDo(idaDoSave);
			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0680 : Release - India Cargo Release<br>
	 * India Cargo Release <br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author
	 */
	private EventResponse releaseIdaDo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0680Event event = (EsmBkg0680Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		//call differ module

		try{
			begin();
			IdaDoRlseVO idaDoRlse = event.getIdaDoRlse();

			//session info setting
			idaDoRlse.setCreUsrId(account.getUsr_id());
			idaDoRlse.setUpdUsrId(account.getUsr_id());
			idaDoRlse.setEvntOfcCd(account.getOfc_cd());

			if (idaDoRlse.getDoSplitFlg().equals("Y")) {
				log.debug("============================== Cntr Length : " + event.getDoCntrs().length);

				DoCntrVO[] doCntrs = event.getDoCntrs();

				for(int i=0;i<doCntrs.length;i++){
					command.releaseIdaDo(idaDoRlse, doCntrs[i], account);
				}

			} else {
				command.releaseIdaDo(idaDoRlse, null, account);
			}


			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0923 : Retrieve - Us Cargo release Order for POD Office Pop-up history<br>
	 *  @author
	 *  @param Event e
	 *  @return EventResponse
	 *  @exception EventException
	 */
	private EventResponse searchUsCgoRlseHis(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0923Event event = (EsmBkg0923Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			String blNo = event.getBlNo();
			List<UsCgoRlseHisVO> list = command.searchUsCgoRlseHis(blNo);
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1018 : Retrieve - Cargo Release Remark Pop-up<br>
	 *  Cargo Release Remark retrieve<br>
	 * @author
	 *  @param Event e
	 *  @return EventResponse
	 *  @exception EventException
	 */
	private EventResponse searchDoPrnRmk(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1018Event event = (EsmBkg1018Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			DoPrnRmkVO doPrnRmkVO = event.getDoPrnRmkVO();
			List<DoPrnRmkVO> doPrnRmkVOResults = command.searchDoPrnRmk(doPrnRmkVO.getDoNo(), account);
			eventResponse.setRsVoList(doPrnRmkVOResults);


		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1018 : Save - Cargo Release Remark Pop-up<br>
	 *  Cargo Release Remark manage<br>
	 * @author
	 *  @param Event e
	 *  @return EventResponse
	 *  @exception EventException
	 */
	private EventResponse modifyDoPrnRmk(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1018Event event = (EsmBkg1018Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			begin();
			DoPrnRmkVO doPrnRmkVO = event.getDoPrnRmkVO();
			command.modifyDoPrnRmk(doPrnRmkVO, account);
			eventResponse.setETCData("status", "ok");
			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00102").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * EMS_BKG0272 : Retrieve - Full CNTR Release Order<br>
	 *  Full CNTR Release Order retrieve<br>
	 * @author
	 *  @param Event e
	 *  @return EventResponse
	 *  @exception EventException
	 */
	private EventResponse searchFullCntrRlseOrderList(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0272Event event = (EsmBkg0272Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			FullCntrRlseOrderSearchVO fullCntrRlseOrderSearch  = event.getFullCntrRlseOrderSearchVO();

			//set Login user info
			fullCntrRlseOrderSearch.setUsrOfcCd(account.getOfc_cd());


			List<FullCntrRlseOrdVO> list = command.searchFullCntrRlseOrderList(fullCntrRlseOrderSearch );
			if(list == null){
				eventResponse.setETCData("status", "no_data");
			}else if(list.size() > 0){
				eventResponse.setETCData("status", "ok");
				eventResponse.setRsVoList(list);
			}else{
				eventResponse.setETCData("status", "no_data");
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0272 : Send - Full CNTR Release Order<br>
	 *  Full CNTR Release Order Email, EDI Trans History Add<br>
	 * @author
	 *  @param Event e
	 *  @return EventResponse
	 *  @exception EventException
	 */
	private EventResponse sendFullCntrRlseOrderByEmail(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0272Event event = (EsmBkg0272Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			begin();

			command.sendEmailFullCntrRlseOrder(event.getCargoSendEmailVOs(), event.getFullCntrRlseOrdVOs(), event.getBkgEuPinNoVOs(), account);
			eventResponse.setUserMessage( new ErrorHandler("BKG40054").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00243").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0272 : E-Mail - Full CNTR Release Order<br>
	 *  Full CNTR Release Order Email, Yard validation check<br>
	 * @author
	 *  @param Event e
	 *  @return EventResponse
	 *  @exception EventException
	 */
	private EventResponse searchFullCntrRlseOrdMailCtnt(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0272Event event = (EsmBkg0272Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{

			FullCntrRlseOrderMailVO fullCntrRlseOrderMailVo = command.searchFullCntrRlseOrdMailCtnt(event.getFullCntrRlseOrdVOs(), account);

			eventResponse.setRsVoList(fullCntrRlseOrderMailVo.getFullCntrRlseOrdVos());
			eventResponse.setRsVoList(fullCntrRlseOrderMailVo.getFullCntrRlseOrderMailSendVos());

		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0272 : EDI - Full CNTR Release Order<br>
	 *  Full CNTR Release Order Email, Yard validation check<br>
	 * @author
	 *  @param Event e
	 *  @return EventResponse
	 *  @exception EventException
	 */
	private EventResponse transmitEdiFullCntrRlseOrder(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0272Event event = (EsmBkg0272Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			begin();

			FullCntrRlseOrderEdiSendVO[] list = event.getFullCntrRlseOrderEdiSendVOs();

			command.transmitEdiFullCntrRlseOrder(list, event.getBkgEuPinNoVOs(), account);

			eventResponse.setUserMessage( new ErrorHandler("BKG06070").getUserMessage());
			commit();
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
	 * ESM_BKG_0272 : Save - Bkg EU Pin No<br>
	 *  Full CNTR Release Order Bkg EU Pin No Save<br>
	 * @author
	 *  @param Event e
	 *  @return EventResponse
	 *  @exception EventException
	 */
	private EventResponse manageBkgEuPinNo(Event e) throws EventException{

		log.debug("SC manageBkgEuPinNo 시작");

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0272Event event = (EsmBkg0272Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			begin();

			command.manageBkgEuPinNo(event.getBkgEuPinNoVOs(),  account);
			eventResponse.setUserMessage( new ErrorHandler("BKG00166").getUserMessage());
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

	/**
	 * ESM_BKG_1052 : Setup - Full CNTR Release Order Remark Pop-up<br>
	 * Full CNTR Release Order Remark Save<br>
	 * @author
	 *  @param Event e
	 *  @return EventResponse
	 *  @exception EventException
	 *  @author
	 */
	private EventResponse modifyFullCntrRlseRmk(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1052Event event = (EsmBkg1052Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			begin();
			int rtn = command.modifyFullCntrRlseRmk(event.getBkgFullCntrRemarkVO(), account);
			if(rtn > 0){
				eventResponse.setETCData("status", "ok");
			}else{
				eventResponse.setETCData("status", "no");
			}
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0273 : Retrieve - Full CNTR Release History<br>
	 * Full CNTR Release Order History<br>
	 * @author
	 *  @param Event e
	 *  @return EventResponse
	 *  @exception EventException
	 */
	private EventResponse searchFullReleaseHistory(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0273Event event = (EsmBkg0273Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			FullCntrRlseOrderHisSearchVO fullCntrRlseOrderHisSearchVO = event.getFullCntrRlseOrderHisSearchVO();
			List<FullCntrRlseOrderHisVO> list = command.searchFullCntrRlseOrderHis(fullCntrRlseOrderHisSearchVO);
			if(list == null){
				eventResponse.setETCData("status", "no_data");
			}else if(list.size() > 0){
				eventResponse.setETCData("status", "ok");
				eventResponse.setRsVoList(list);
			}else{
				eventResponse.setETCData("status", "no_data");
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0271 : Retrieve - Pin Number History<br>
	 * Pin Number History<br>
	 * @author
	 *  @param Event e
	 *  @return EventResponse
	 *  @exception EventException
	 */
	private EventResponse searchBkgEuPinNoHistory(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0271Event event = (EsmBkg0271Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			BkgEuPinNoVO bkgEuPinNoSearchVO = event.getBkgEuPinNoVO();
			List<BkgEuPinNoVO> list = command.searchBkgEuPinNoHis(bkgEuPinNoSearchVO);
			if(list == null){
				eventResponse.setETCData("status", "no_data");
			}else if(list.size() > 0){
				eventResponse.setETCData("status", "ok");
				eventResponse.setRsVoList(list);
			}else{
				eventResponse.setETCData("status", "no_data");
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * ESM_BKG_0130 : Retrieve - Cargo Release Order_D/O Receiver and Actual Consignee information<br>
	 * Receiver Info retrieve<br>
	 * @author
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchDoRcvrInfo(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0130Event event = (EsmBkg0130Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			DoRcvrInfoVO searchRcvrInfoVO = event.getDoRcvrInfoVO();
			String doNo = searchRcvrInfoVO.getDoNo();
			DoRcvrInfoVO doRcvrInfoVO = null;
			doRcvrInfoVO = command.searchDoRcvrInfo(doNo);
			if(doRcvrInfoVO == null){
				eventResponse.setETCData("status", "no_data");
			}else{
				eventResponse.setETCData("status", "ok");
				eventResponse.setETCData("bkg_no",      doRcvrInfoVO.getBkgNo());
				eventResponse.setETCData("do_no",       doRcvrInfoVO.getDoNo());
				eventResponse.setETCData("rcvr_co_nm",  doRcvrInfoVO.getRcvrCoNm());
				eventResponse.setETCData("cntc_phn_no", doRcvrInfoVO.getCntcPhnNo());
				eventResponse.setETCData("pic",         doRcvrInfoVO.getPic());
				eventResponse.setETCData("act_cnee_nm", doRcvrInfoVO.getActCneeNm());
				eventResponse.setETCData("cust_ref_nm", doRcvrInfoVO.getCustRefNm());
				eventResponse.setETCData("order_flg",   doRcvrInfoVO.getOrderFlg());
			}
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0130 : Save - Cargo Release Order_D/O Receiver and Actual Consignee information<br>
	 * Receiver Info manage<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author
	 */
	private EventResponse setupDoRcvrInfo(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0130Event event = (EsmBkg0130Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			begin();
			int updateCount = command.setupDoRcvrInfo(event.getDoRcvrInfoVO(), account);
			if(updateCount == 1){
				eventResponse.setETCData("status", "ok");
			}else{
				eventResponse.setETCData("status", "no");
			}
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [0909]  조회 Master
	 * Inbound Cargo Release List retrieve.
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsCgoRlseList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0909Event event = (EsmBkg0909Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		BookingUtil bookingUtilBC = new BookingUtil();
		try {
			UsCgoRlseSearchVO searchVO = event.getSearchVO();

			//if be not Bkg_No, retrieve over B/L No
			if(searchVO.getBlNo().trim().length() > 0){
				String bkgNo = bookingUtilBC.searchBkgNoByBlNo(searchVO.getBlNo());
				if(CheckUtils.isNullAndNullString(bkgNo)){
					String[] msg = new String[]{event.getBlNo()};
					throw new EventException(new ErrorHandler("BKG40031", msg).getMessage());
				}
			}

			eventResponse.setRsVoList(command.searchUsCgoRlseList(searchVO));
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [0909] 조회 Detail
	 * after USA Inbound Cargo Release List retrieve,
	 * the B/L FOC value and HOLD, Remark retrieve.
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUsCgoRlseFoc(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0909Event event = (EsmBkg0909Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			String bkgNo = event.getBkgNo();
			eventResponse.setRsVoList(command.searchUsCgoRlseFoc(bkgNo));


		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [0909] ERP,DEM DET info retrieve
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchErpOtsInfo(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0909Event event = (EsmBkg0909Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		log.debug("-------------------------------------------------------");
		log.debug("ERP DEM DET 가져오기 시작");
		log.debug("-------------------------------------------------------");

		String bkgNo = event.getBkgNo();
		String blNo = event.getBlNo();
		String podCd = event.getPodCd();

		log.debug("------------------------ bkgNo "+bkgNo);
		log.debug("------------------------ blNo "+blNo);
		log.debug("------------------------ podCd "+podCd);
		try{
			//------------------------------------------------------
			//ERP
			//sum group-CURR unit.
			//------------------------------------------------------
			OtsRcvInfoVO oriVO = command.searchErpOtsInfo(blNo);

			log.debug("---------- oriVO "+oriVO.getColumnValues());
			Map<String,String> map = oriVO.getColumnValues();




			Map<String,Float> groupMap = new HashMap<String, Float>();
			Vector<String> vec = new Vector<String>();
			log.debug("-------------------- map " + map);
			for(int i=0;i<5;i++){

				String currKey = map.get("tot_ots_curr_cd"+(i+1));

				if(map.get("tot_ots_curr_cd"+(i+1)) == null || map.get("tot_ots_curr_cd"+(i+1)).trim().equals("")){
					continue;
				}
				String amtValue = map.get("tot_ots_amt"+(i+1));

				if(groupMap.containsKey(currKey)){//if be key value, sum
					groupMap.put( currKey, Float.parseFloat(groupMap.get(currKey).toString())
							+ Float.parseFloat(amtValue));
				}else{
					groupMap.put(currKey, Float.parseFloat(amtValue));
					vec.add(currKey);
				}
			}
			log.debug("------------ groupMap  "+groupMap);
			log.debug("------------ vec  "+vec);

			//credit consignee
			if(oriVO.getTotOtsStsCd() != null && oriVO.getTotOtsStsCd().equals("C")){
				eventResponse.setETCData("otsCnt"  , "1");
				eventResponse.setETCData("ots0", "CREDIT");

			//No-credit consignee
			}else{
				//값이 없거나, 0 이라도 USD 를 넣어준다.
				if(vec.size() == 0){
					eventResponse.setETCData("otsCnt"  , "1");
					eventResponse.setETCData("ots0", ""+ " " + oriVO.getTotOtsAmt1() );
				}else{
					eventResponse.setETCData("otsCnt"  , ""+vec.size());
					for(int x=0;x<vec.size();x++){
						eventResponse.setETCData("ots"+x, vec.get(x)+ " " +groupMap.get(vec.get(x)) );
					}
				}
			}

			//------------------------------------------------------
			//DEM DET Container info
			//------------------------------------------------------
			String[] demDetChargeInfo = null;

			demDetChargeInfo = command.searchDemDetCntrList(bkgNo);

			//------------------------------------------------------
			//Charge By Customer
			//outstanding searchKorDo .
			//status ; if outstanding sum same 0, 'Y', differ 'N'
			//------------------------------------------------------
			//ChargeCalculationBC ccBc = new ChargeCalculationBCImpl();
			ChargeByBookingCustomerParmVO chargeByBookingCustomerParmVO = new ChargeByBookingCustomerParmVO();
			chargeByBookingCustomerParmVO.setBkgNo(bkgNo);
			chargeByBookingCustomerParmVO.setPodCd(podCd);
			chargeByBookingCustomerParmVO.setCntrNo(demDetChargeInfo);
			chargeByBookingCustomerParmVO.setDmdtTp("");
			chargeByBookingCustomerParmVO.setExpDelDt("");

			// if DEM error

			//received data to DEM/DET
			DmtChargeVO dmtChargeVO = new DmtChargeVO();
			ChargeCalculationBC commandIF = new ChargeCalculationBCImpl(); //DEM.DET BC creation
			BookingUtil bookingUtilBC = new BookingUtil();
			try {
				ChargeByBookingCustomerGrpVO chargeByBookingCustomerGrpVO;
				chargeByBookingCustomerGrpVO = commandIF.searchChargeByCustomer(chargeByBookingCustomerParmVO);
				dmtChargeVO = bookingUtilBC.searchChargeByCustomer(chargeByBookingCustomerGrpVO);
				//grpVO = ccBc.searchChargeByCustomer(chargeByBookingCustomerParmVO);
			} catch (Exception ex) {
				log.error("err : " + ex.toString(), ex);
				//Business Logic Exception

			}

			log.debug("------------- chargeByBookingCustomerParmVO "+chargeByBookingCustomerParmVO);
			log.debug("------------- dmtChargeVO "+dmtChargeVO);
			//if grpVO not null
			if (dmtChargeVO != null) {
				List<ToTBilAmtVO> totBilAmtVOList = dmtChargeVO.getBilAmtVOList();

				ToTBilAmtVO totBilAmtVO;
				String currCd = "";
				String demAmt = "";
				float demAmtTmp = 0;
				String demType = "";

				log.debug("---------- totBilAmtVOList "+totBilAmtVOList);

				if(totBilAmtVOList != null && totBilAmtVOList.size() > 0){
					log.debug("---------- totBilAmtVOList.size() "+totBilAmtVOList.size());
					totBilAmtVO = totBilAmtVOList.get(0);
					currCd = totBilAmtVO.getCurrCd();
					demAmt = totBilAmtVO.getTotBilAmt();
					demAmtTmp = Float.parseFloat(demAmt);
					demType = dmtChargeVO.getDemurType();
				}

				eventResponse.setETCData("demAMT"  , currCd + " "+ demAmt);

				log.debug("--------------------- demAmtTmp "+demAmtTmp);

				if(demAmtTmp > 0){
					eventResponse.setETCData("demStatus"  , "N");
				}else{
					eventResponse.setETCData("demStatus"  , "Y");
				}
				eventResponse.setETCData("demurType"  , demType);
			} else {
				//grpVO is null
				eventResponse.setETCData("demAMT"     , "");
				eventResponse.setETCData("demStatus"  , "");
				eventResponse.setETCData("demurType"  , "");
			}

			//------------------------------------------------------
			//TPB
			//------------------------------------------------------
			StatusInquiryBC tpbIF = new StatusInquiryBCImpl(); //TPB BC creation
			SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO = new SearchTPBStatusByBkgNoVO();
			searchTpbStatusByBkgNoVO.setSbkgno(event.getBkgNo());
			String tpbStatus = tpbIF.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
			log.debug("---------- tpbStatus     "+tpbStatus);
			eventResponse.setETCData("tpbStatus"  , tpbStatus);

		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [0909_01] save manage
	 * U.S. Cargo Release F.O.C manage.
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUsCgoRlse(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0909Event event = (EsmBkg0909Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		BLIssuanceBC command2 = new BLIssuanceBCImpl();
		try{
			begin();
			BkgCgoRlseVO[] bkgCgoRlseVOs = event.getBkgCgoRlseVOs();
			BkgBlIssVO[] blIssVOs = event.getBlIssVOs();

			//1.Obl save
			if(blIssVOs != null){
				command2.manageOblRcvByUsCgo(blIssVOs, this.getSignOnUserAccount());
			}
			//2. Remark save
			if(bkgCgoRlseVOs != null){
				command.manageUsCgoRlse(bkgCgoRlseVOs[0],this.getSignOnUserAccount());
			}

			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			log.error("----------------err.toString [" + ex.toString()+"]", ex);
			log.error("----------------err.getMessage [" + ex.getMessage()+"]", ex);

			if(ex.getMessage().indexOf("BKG40085") > -1){
				commit();
				log.debug("---------------- commit 했음 msg번호" + ex.getMessage());
			  throw new EventException(new ErrorHandler("BKG40085").getMessage());
			}else if(ex.getMessage().indexOf("BKG40086") > -1){
				commit();
				log.debug("---------------- commit 했음 msg번호 " + ex.getMessage());
			  throw new EventException(new ErrorHandler("BKG40086").getMessage());
			}else if(ex.getMessage().indexOf("BKG40087") > -1){
				commit();
				log.debug("---------------- commit 했음 msg번호 " + ex.getMessage());
			  throw new EventException(new ErrorHandler("BKG40087").getMessage());
			}else if(ex.getMessage().indexOf("BKG40108") > -1){
				commit();
				log.debug("---------------- commit 했음 msg번호 " + ex.getMessage());
			  throw new EventException(new ErrorHandler("BKG40108").getMessage());
			}else{
				rollback();
				throw ex;
			}

		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * ESM_BKG_0909 : Multi TDC315 - Complete IVC click [Back End Job 시작]<br>
	 * transmit Customer information Flat File as EDI
	 *
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse startBackEndJobSendBlTdc315EdiMulti(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		EsmBkg0909Event event = (EsmBkg0909Event)e;

		try{
			begin();
			String backEndJobKey = command.startBackEndJobSendBlTdc315EdiMulti(event.getBkgCgoRlseVOs(), account);
			eventResponse.setETCData("backEndJob_Key", backEndJobKey);
			commit();
		} catch(EventException ex){
			log.error("----------------err.toString [" + ex.toString()+"]", ex);
			log.error("----------------err.getMessage [" + ex.getMessage()+"]", ex);

			if(ex.getMessage().indexOf("BKG40085") > -1){
				commit();
				log.debug("---------------- commit 했음 msg번호" + ex.getMessage());
			  throw new EventException(new ErrorHandler("BKG40085").getMessage());
			}else if(ex.getMessage().indexOf("BKG40086") > -1){
				commit();
				log.debug("---------------- commit 했음 msg번호 " + ex.getMessage());
			  throw new EventException(new ErrorHandler("BKG40086").getMessage());
			}else if(ex.getMessage().indexOf("BKG40087") > -1){
				commit();
				log.debug("---------------- commit 했음 msg번호 " + ex.getMessage());
			  throw new EventException(new ErrorHandler("BKG40087").getMessage());
			}else if(ex.getMessage().indexOf("BKG40108") > -1){
				commit();
				log.debug("---------------- commit 했음 msg번호 " + ex.getMessage());
			  throw new EventException(new ErrorHandler("BKG40108").getMessage());
			}else{
				rollback();
				throw ex;
			}
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0909 : Multi TDC315 - Complete IVC click [Back End Job 결과]<br>
	 * transmit Customer information Flat File as EDI
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse resultBackEndJobSendBlTdc315EdiMulti(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		EsmBkg0909Event event = (EsmBkg0909Event)e;

		try {
			begin();
			command.resultBackEndJobSendBlTdc315EdiMulti(event.getAttribute("backEndJob_Key").toString());
			commit();
			eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1167 : Complete IVC (Canada cargo release multi B/L sending) [Back End Job 시작]<br>
	 * Multi BL sending to terminal TDC 315 EDI <br>
	 *
	 * @param 	Event e
	 * @return  EventResponse
	 * @exception 	EventException
	 */
	private EventResponse startBackEndJobSendCaBlTdc315EdiMulti(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		EsmBkg1167Event event = (EsmBkg1167Event)e;

		try{
			begin();
			String backEndJobKey = command.startBackEndJobSendCaBlTdc315EdiMulti(event.getBkgCgoRlseVOs(), account);
			eventResponse.setETCData("backEndJob_Key", backEndJobKey);
			commit();
		} catch(EventException ex){
			log.error("----------------err.toString [" + ex.toString()+"]", ex);
			log.error("----------------err.getMessage [" + ex.getMessage()+"]", ex);

			if(ex.getMessage().indexOf("BKG40085") > -1){
				commit();
				log.debug("---------------- commit 했음 msg번호" + ex.getMessage());
			  throw new EventException(new ErrorHandler("BKG40085").getMessage());
			}else if(ex.getMessage().indexOf("BKG40086") > -1){
				commit();
				log.debug("---------------- commit 했음 msg번호 " + ex.getMessage());
			  throw new EventException(new ErrorHandler("BKG40086").getMessage());
			}else if(ex.getMessage().indexOf("BKG40087") > -1){
				commit();
				log.debug("---------------- commit 했음 msg번호 " + ex.getMessage());
			  throw new EventException(new ErrorHandler("BKG40087").getMessage());
			}else if(ex.getMessage().indexOf("BKG40108") > -1){
				commit();
				log.debug("---------------- commit 했음 msg번호 " + ex.getMessage());
			  throw new EventException(new ErrorHandler("BKG40108").getMessage());
			}else{
				rollback();
				throw ex;
			}

		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1167 : Complete IVC (Canada cargo release multi B/L sending) [Back End Job 결과]<br>
	 * Multi BL sending to terminal TDC 315 EDI <br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse resultBackEndJobSendCaBlTdc315EdiMulti(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		EsmBkg1167Event event = (EsmBkg1167Event)e;

		try {
			begin();
			command.resultBackEndJobSendCaBlTdc315EdiMulti(event.getAttribute("backEndJob_Key").toString());
			commit();
			eventResponse.setUserMessage(new ErrorHandler("BKG00204").getUserMessage());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [0909_01] hold save
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageUsCgoRlseHold(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0909Event event = (EsmBkg0909Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			begin();
			DoRefVO[] vos = event.getDoRefVOs();
			command.manageUsCgoRlseHold(vos,this.getSignOnUserAccount());

			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [0668_09] remark manage
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageDoHldRmk(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0909Event event = (EsmBkg0909Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			begin();
			DoRefVO[] doRefVOs = event.getDoRefVOs();

			BkgDoRefVO bkgDoRefVO = new BkgDoRefVO();

			ObjectCloner.build(doRefVOs[0], bkgDoRefVO);
			bkgDoRefVO.setCreUsrId(this.getSignOnUserAccount().getUsr_id());
			bkgDoRefVO.setUpdUsrId(this.getSignOnUserAccount().getUsr_id());
			command.manageDoHldRmk(bkgDoRefVO);

			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 *  F.O.C info setup.
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse setupFocByFreight(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0909Event event = (EsmBkg0909Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			begin();

			FrtCltLstVO frtCltLst = new FrtCltLstVO();
			frtCltLst.setBlNo((String) event.getAttribute("test_bl_no"));
			frtCltLst.setFrtCltFlg((String) event.getAttribute("test_foc"));
			frtCltLst.setEvntOfcCd((String) event.getAttribute("test_evnt_ofc_cd"));
			frtCltLst.setEvntUsrId((String) event.getAttribute("test_evnt_usr_id"));
			frtCltLst.setEvntDt((String) event.getAttribute("test_evnt_dt"));
			frtCltLst.setCgorTeamCd((String) event.getAttribute("test_cgor_team_cd"));
			frtCltLst.setCgoEvntNm((String) event.getAttribute("test_cgor_evnt_nm"));

			log.debug("-------------   FRT   ------------");
			log.debug(""+frtCltLst.getColumnValues());

			command.setupFocByFreight(frtCltLst);

			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			//ERP data
			//not rollback, commit
			commit();
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * F.O.C info setup
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse setupFocByObl(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0909Event event = (EsmBkg0909Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			begin();
			OblRdemVO oblRdem = new OblRdemVO();
			oblRdem.setBlNo((String) event.getAttribute("test_bl_no"));
			oblRdem.setOblRdemFlg((String) event.getAttribute("test_foc"));
			oblRdem.setEvntOfcCd((String) event.getAttribute("test_evnt_ofc_cd"));
			oblRdem.setEvntUsrId((String) event.getAttribute("test_evnt_usr_id"));
			oblRdem.setEvntDt((String) event.getAttribute("test_evnt_dt"));
			oblRdem.setCgorTeamCd((String) event.getAttribute("test_cgor_team_cd"));
			oblRdem.setCgoEvntNm((String) event.getAttribute("test_cgor_evnt_nm"));

			log.debug("-------------   OBL   ------------");
			log.debug(""+oblRdem.getColumnValues());


			command.setupFocByObl(oblRdem);

			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			log.error("----------------err.toString [" + ex.toString()+"]", ex);
			log.error("----------------err.getMessage [" + ex.getMessage()+"]", ex);

			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [0909] F.O.C info setup.
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse setupFocByCstms(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0909Event event = (EsmBkg0909Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			begin();

			CstmsClrVO cstmsClr = new CstmsClrVO();
			cstmsClr.setBlNo((String) event.getAttribute("test_bl_no"));
			cstmsClr.setCstmsClrCd((String) event.getAttribute("test_foc"));
			cstmsClr.setEvntOfcCd((String) event.getAttribute("test_evnt_ofc_cd"));
			cstmsClr.setEvntUsrId((String) event.getAttribute("test_evnt_usr_id"));
			cstmsClr.setEvntDt((String) event.getAttribute("test_evnt_dt"));
			cstmsClr.setCgorTeamCd((String) event.getAttribute("test_cgor_team_cd"));
			cstmsClr.setCgoEvntNm((String) event.getAttribute("test_cgor_evnt_nm"));
			cstmsClr.setCstmsLocCd((String) event.getAttribute("test_cstms_loc_cd"));
			cstmsClr.setCstmsDsPoCd((String) event.getAttribute("test_cstms_ds_po_cd"));

			log.debug("-------------   CSTMS   ------------");
			log.debug(""+cstmsClr.getColumnValues());

			command.setupFocByCstms(cstmsClr);

			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [0909]Original Bill of Lading Status
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchUsCgoRlseBlStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0909Event event = (EsmBkg0909Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			String bkgNo = event.getBkgNo();
			String blNo = event.getBlNo();
			//Container List
			eventResponse.setRsVoList(command.searchUsCgoRlseBlStatus(bkgNo,this.getSignOnUserAccount()));

			UsCgoRlseBkbcBlVO usCgoRlseBkbc = new UsCgoRlseBkbcBlVO();
			usCgoRlseBkbc.setBlNo(blNo);
			usCgoRlseBkbc = command.searchPrtlBl(usCgoRlseBkbc);
			if(Integer.parseInt(usCgoRlseBkbc.getPartialCnt()) == 0){
				eventResponse.setETCData("prt_ind", "N" );
			}else if(Integer.parseInt(usCgoRlseBkbc.getPartialCnt()) > 0){
				eventResponse.setETCData("prt_ind", "Y" );
			}

		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
			//throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_0132 : retrieve event handling<br>
	 * INQUIRY OF eDO self-transportation retrieve event handling<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchEdoCntrRqstList(Event e) throws EventException {

		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0132Event event = (EsmBkg0132Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try {
			List<EdoCntrRqstsVO> list = command.searchEdoCntrRqstList(event.getEdoSearchVO());
			eventResponse.setRsVoList(list);
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			// BKG00450 : retrieve failed
			throw new EventException(new ErrorHandler("BKG00450").getMessage(), ex);
		}
		return eventResponse;
	}


	/**
	 * ESM_BKG_0680 : Cancel - D/O Release info cancle.<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 * @author
	 */
	private EventResponse cancelIdaDo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0680Event event = (EsmBkg0680Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		DoCancelVO doCancel = new DoCancelVO();
		try{
			begin();
//            IdaDoCancelVO idaDoCancelVo = new IdaDoCancelVO();
//            idaDoCancelVo.setBkgNo(event.getBkgNo());
//
//            command.cancelIdaDo(idaDoCancelVo, account);

			if ("Y".equals(event.getSplitFlg())) {
				log.debug("============================== Cntr Length : " + event.getdoCntrRlseSts().length);

				EuDoCntrRlseStsVO[] doCntrs = event.getdoCntrRlseSts();

				for(int i=0;i<doCntrs.length;i++){
					doCancel.setBkgNo(event.getBkgNo());
					doCancel.setDoNo(doCntrs[i].getDoNo());
					doCancel.setRlseStsCd("'R','C'");
					doCancel.setRlseSeq(event.getResetFlg());
					doCancel.setSplitFlg(event.getSplitFlg());
					doCancel.setCreUsrId(account.getUsr_id());
					doCancel.setUpdUsrId(account.getUsr_id());
					doCancel.setEvntOfcCd(account.getOfc_cd());

					command.cancelEuDo(doCancel);
				}
			} else {
				doCancel.setBkgNo(event.getBkgNo());
				doCancel.setDoNo(event.getDoNo());
				doCancel.setRlseStsCd("'R','C'");
				doCancel.setRlseSeq(event.getResetFlg());
				doCancel.setSplitFlg(event.getSplitFlg());
				doCancel.setCreUsrId(account.getUsr_id());
				doCancel.setUpdUsrId(account.getUsr_id());
				doCancel.setEvntOfcCd(account.getOfc_cd());

				command.cancelEuDo(doCancel);
			}
			//input success massage key to errorHandler
			eventResponse.setUserMessage(new ErrorHandler("BKG00674").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_B010]
	 * I/F I/F 3분 배치를 trigger 로 이용해 SAR에서 미수금이 BKG_OUTSTANDING 테이블로 신규, 갱신 될때마다 값을 가져와  US backendjob 실행함.
	 * @param e
	 * @return EventResponse
	 */
	private EventResponse receiveOtsInfo(Event e)  throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0909Event event = (EsmBkg0909Event)e;
		//CargoReleaseOrderBC command = null;

		try{
			// Us cargo release 배치
			this.searchOtsUsCgo(event.getBkgOutstandingVO());

		} catch(Exception ex) {
			log.error("receiveOtsInfo err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * [ESM_BKG_B010]
	 * I/F 3분 배치를 trigger 로 이용해 SAR에서 미수금이 BKG_OUTSTANDING 테이블로 신규, 갱신 될때마다 값을 가져와  US backendjob 실행함.
	 * @param BkgOutstandingVO ots
	 * @param String chkFlg
	 * @return void
	 */
	private void searchOtsUsCgo(BkgOutstandingVO ots) throws EventException {
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			// Inbound
			begin();
			command.searchOtsUsCgo(ots);
			//	}
			commit();
		}catch(EventException ex) {
			if(ex.getMessage().indexOf("BKG40085") > -1){
				commit();
			}else if(ex.getMessage().indexOf("BKG40086") > -1){
				commit();
			}else if(ex.getMessage().indexOf("BKG40087") > -1){
				commit();
			}else if(ex.getMessage().indexOf("BKG40108") > -1){
				commit();
			}else{
				rollback();
				throw ex;
			}
		}catch(Exception ex){
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * ESM_BKG_1167 조회
	 * Canada Cargo Release에 대한 List를 Item별로 조회한다.
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCaCgoRlseList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1167Event event = (EsmBkg1167Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			CaCgoRlseSearchVO searchVO = event.getSearchVO();
			eventResponse.setRsVoList(command.searchCaCgoRlseList(searchVO));
		} catch(EventException ex) {
			throw ex;
		} catch(Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1167 조회 Detail
	 * Canada Cargo Release에 대한 List 조회 후,
	 * 해당 B/L의 FOC 값 및 HOLD, Remark를 조회한다.
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCaCgoRlseCntr(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1167Event event = (EsmBkg1167Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			String bkgNo = event.getBkgNo();
			eventResponse.setRsVoList(command.searchCaCgoRlseFoc(bkgNo));


		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1167 ERP,DEM DET 정보 조회
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCaErpOtsInfo(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1167Event event = (EsmBkg1167Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		String bkgNo = event.getBkgNo();
		String blNo = event.getBlNo();
		String podCd = event.getPodCd();

		try{
			//------------------------------------------------------
			//ERP
			//CURR 개수만큼 그룹지어서 합계.
			//------------------------------------------------------
			OtsRcvInfoVO oriVO = command.searchErpOtsInfo(blNo);

			Map<String,String> map = oriVO.getColumnValues();

			Map<String,Float> groupMap = new HashMap<String, Float>();
			Vector<String> vec = new Vector<String>();
			for(int i=0;i<5;i++){

				String currKey = map.get("tot_ots_curr_cd"+(i+1));
				//CURRENCY 가 없을경우 통과.
				if(map.get("tot_ots_curr_cd"+(i+1)) == null || map.get("tot_ots_curr_cd"+(i+1)).trim().equals("")){
					continue;
				}
				String amtValue = map.get("tot_ots_amt"+(i+1));

				if(groupMap.containsKey(currKey)){//key값 존재시 합계
					groupMap.put( currKey, Float.parseFloat(groupMap.get(currKey).toString())
							+ Float.parseFloat(amtValue));
				}else{
					groupMap.put(currKey, Float.parseFloat(amtValue));
					vec.add(currKey);
				}
			}

			//신용화주일경우 2010.04.01
			if(oriVO.getTotOtsStsCd() != null && oriVO.getTotOtsStsCd().equals("C")){
				eventResponse.setETCData("otsCnt"  , "1");
				eventResponse.setETCData("ots0", "CREDIT");

			//비신용화주일경우   2010.04.01
			}else{
				//값이 없거나, 0 이라도 USD 를 넣어준다.
				if(vec.size() == 0){
					eventResponse.setETCData("otsCnt"  , "1");
					eventResponse.setETCData("ots0", ""+ " " + oriVO.getTotOtsAmt1() );
					//eventResponse.setETCData("ots0", ""+ " " + "N/A" );
				}else{
					eventResponse.setETCData("otsCnt"  , ""+vec.size());
					for(int x=0;x<vec.size();x++){
						eventResponse.setETCData("ots"+x, vec.get(x)+ " " +groupMap.get(vec.get(x)) );
					}
				}
			}

			//------------------------------------------------------
			//DEM DET Container 정보
			//------------------------------------------------------
			String[] demDetChargeInfo = null;

			demDetChargeInfo = command.searchDemDetCntrList(bkgNo);

			//------------------------------------------------------
			//Charge By Customer
			//outstanding 합계는 searchKorDo 참조.
			//status ; outstanding 합계가 0 이면 'Y' 아니면 'N'
			//------------------------------------------------------
			//ChargeCalculationBC ccBc = new ChargeCalculationBCImpl();
			ChargeByBookingCustomerParmVO chargeByBookingCustomerParmVO = new ChargeByBookingCustomerParmVO();
			chargeByBookingCustomerParmVO.setBkgNo(bkgNo);
			chargeByBookingCustomerParmVO.setPodCd(podCd);
			chargeByBookingCustomerParmVO.setCntrNo(demDetChargeInfo);
			chargeByBookingCustomerParmVO.setDmdtTp("");
			chargeByBookingCustomerParmVO.setExpDelDt("");


			//DEM/DET 에서 받아서 가공한 데이터
			DmtChargeVO dmtChargeVO = new DmtChargeVO();
			ChargeCalculationBC commandIF = new ChargeCalculationBCImpl(); //DEM.DET BC 선언
			BookingUtil bookingUtilBC = new BookingUtil();
			try {
				//dmtChargeVO = this.searchChargeByCustomer(chargeByBookingCustomerParmVO);
				ChargeByBookingCustomerGrpVO chargeByBookingCustomerGrpVO;
				chargeByBookingCustomerGrpVO = commandIF.searchChargeByCustomer(chargeByBookingCustomerParmVO);
				dmtChargeVO = bookingUtilBC.searchChargeByCustomer(chargeByBookingCustomerGrpVO);
			} catch (Exception ex) {
				log.warn("warring : " + ex.toString(), ex);
				log.error(ex.getMessage()); // 2011.07.15

			}
			//grpVO의 값이 Null이 아닌경우에 대해서만 처리함
			if (dmtChargeVO != null) {
				//log.debug("------------------- gMap "+cntrVO.getBzcTrfCurrCd() + " "+ gMap.get(cntrVO.getBzcTrfCurrCd()));
				List<ToTBilAmtVO> totBilAmtVOList = dmtChargeVO.getBilAmtVOList();

				ToTBilAmtVO totBilAmtVO;
				String currCd = "";
				String demAmt = "";
				float demAmtTmp = 0;
				String demType = "";

				if(totBilAmtVOList != null && totBilAmtVOList.size() > 0){
					log.debug("---------- totBilAmtVOList.size() "+totBilAmtVOList.size());
					totBilAmtVO = totBilAmtVOList.get(0);
					currCd = totBilAmtVO.getCurrCd();
					demAmt = totBilAmtVO.getTotBilAmt();
					demAmtTmp = Float.parseFloat(demAmt);
					demType = dmtChargeVO.getDemurType();
				}

				eventResponse.setETCData("demAMT"  , currCd + " "+ demAmt);

				if(demAmtTmp > 0){
					eventResponse.setETCData("demStatus"  , "N");
				}else{
					eventResponse.setETCData("demStatus"  , "Y");
				}
				eventResponse.setETCData("demurType"  , demType);
			} else {
				//grpVO의 값이 Null인 경우에 대해서만 처리함
				eventResponse.setETCData("demAMT"     , "");
				eventResponse.setETCData("demStatus"  , "");
				eventResponse.setETCData("demurType"  , "");
			}

			//------------------------------------------------------
			//TPB 구하기
			//------------------------------------------------------
			StatusInquiryBC tpbIF = new StatusInquiryBCImpl(); //TPB BC 선언
			SearchTPBStatusByBkgNoVO searchTpbStatusByBkgNoVO = new SearchTPBStatusByBkgNoVO();
			searchTpbStatusByBkgNoVO.setSbkgno(event.getBkgNo());
			String tpbStatus = tpbIF.searchTpbStatusByBkgNo(searchTpbStatusByBkgNoVO);
			log.debug("---------- tpbStatus     "+tpbStatus);
			eventResponse.setETCData("tpbStatus"  , tpbStatus);

		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1167 Original Bill of Lading Status
	 * @param e
	 * @return EventResponse
	 * @throws EventException
	 */
	private EventResponse searchCaCgoRlseBlStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1167Event event = (EsmBkg1167Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();

		try{
			String bkgNo = event.getBkgNo();
			String blNo = event.getBlNo();
			//Container List
			eventResponse.setRsVoList(command.searchCaCgoRlseBlStatus(bkgNo,this.getSignOnUserAccount()));

			CaCgoRlseBkbcBlVO caCgoRlseBkbc = new CaCgoRlseBkbcBlVO();
			caCgoRlseBkbc.setBlNo(blNo);
			caCgoRlseBkbc = command.searchCaPrtlBl(caCgoRlseBkbc);
			if(Integer.parseInt(caCgoRlseBkbc.getPartialCnt()) == 0){
				eventResponse.setETCData("prt_ind", "N" );
			}else if(Integer.parseInt(caCgoRlseBkbc.getPartialCnt()) > 0){
				eventResponse.setETCData("prt_ind", "Y" );
			}

		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw ex;
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("BKG00391").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1167 Remark 저장
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCaCgoHldRmk(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1167Event event = (EsmBkg1167Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			begin();
			DoRefVO[] doRefVOs = event.getDoRefVOs();

			BkgDoRefVO bkgDoRefVO = new BkgDoRefVO();

			ObjectCloner.build(doRefVOs[0], bkgDoRefVO);
			bkgDoRefVO.setCreUsrId(this.getSignOnUserAccount().getUsr_id());
			bkgDoRefVO.setUpdUsrId(this.getSignOnUserAccount().getUsr_id());
			//String blNo = event.getBlNo();
			command.manageDoHldRmk(bkgDoRefVO);

			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1167 save 저장
	 * Canada Cargo Release에서 F.O.C 변경 내역에 대한 저장을 수행한다.
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCaCgoRlse(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1167Event event = (EsmBkg1167Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		BLIssuanceBC command2 = new BLIssuanceBCImpl();
		try{
			begin();
			BkgCgoRlseVO[] bkgCgoRlseVOs = event.getBkgCgoRlseVOs();
			BkgBlIssVO[] blIssVOs = event.getBlIssVOs();

			// OBL 저장은 US 와 CA 동일
			//1.Obl 저장
			if(blIssVOs != null){
				command2.manageOblRcvByUsCgo(blIssVOs, this.getSignOnUserAccount());
			}
			//2. Remark 저장
			if(bkgCgoRlseVOs != null){
				command.manageCaCgoRlse(bkgCgoRlseVOs[0],this.getSignOnUserAccount());
			}

			//에러 핸들러에 해당하는 메세지 키를 찾아서 넣자.\
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());

			commit();
		} catch(EventException ex) {

			if(ex.getMessage().indexOf("BKG40085") > -1){
				commit();
				throw new EventException(new ErrorHandler("BKG40085").getMessage());

			}else if(ex.getMessage().indexOf("BKG40086") > -1){
				commit();
			  throw new EventException(new ErrorHandler("BKG40086").getMessage());
			}else if(ex.getMessage().indexOf("BKG40087") > -1){
				commit();
			  throw new EventException(new ErrorHandler("BKG40087").getMessage());
			}else if(ex.getMessage().indexOf("BKG40108") > -1){
				commit();
			  throw new EventException(new ErrorHandler("BKG40108").getMessage());
			}else{
				rollback();
				throw ex;
			}

		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_BKG_1167 hold 저장
	 *
	 * @param e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageCaCgoRlseHold(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg1167Event event = (EsmBkg1167Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		try{
			begin();
			DoRefVO[] vos = event.getDoRefVOs();
			command.manageCaCgoRlseHold(vos,this.getSignOnUserAccount());
			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0938 : Container 단위로 hold<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse holdbyCntr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0938Event event = (EsmBkg0938Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		//call differ module

		try{
			begin();
			event.getEuDoRlse().setUsrId(account.getUsr_id());
			event.getEuDoRlse().setUsrOfcCd(account.getOfc_cd());

				log.debug("============================== Cntr Length : " + event.getDoCntrs().length);

				DoCntrVO[] doCntrs = event.getDoCntrs();

				for(int i=0;i<doCntrs.length;i++){
					command.holdbyCntr(event.getEuDoRlse(), doCntrs[i]);
				}

			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_BKG_0938 : Container 단위로 Hold removal<br>
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse holdRemovalbyCntr(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmBkg0938Event event = (EsmBkg0938Event)e;
		CargoReleaseOrderBC command = new CargoReleaseOrderBCImpl();
		//call differ module

		try{
			begin();
			event.getEuDoRlse().setUsrId(account.getUsr_id());
			event.getEuDoRlse().setUsrOfcCd(account.getOfc_cd());


				log.debug("============================== Cntr Length : " + event.getDoCntrs().length);

				DoCntrVO[] doCntrs = event.getDoCntrs();

				for(int i=0;i<doCntrs.length;i++){
					command.holdRemovalbyCntr(event.getEuDoRlse(), doCntrs[i]);
				}

			eventResponse.setUserMessage(new ErrorHandler("BKG00166").getUserMessage());
			commit();
		} catch(EventException ex) {
			rollback();
			throw ex;
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			//COM12240 : Unexpected system error took place during data processing. Please try again later.
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

}
