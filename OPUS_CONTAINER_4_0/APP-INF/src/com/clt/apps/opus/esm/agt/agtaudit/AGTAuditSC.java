/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : AGTAuditSC.java
*@FileTitle : Agent Commission Audit Management Service Command
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.agt.agtaudit;

import java.util.Calendar;
import java.util.List;

import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.basic.AGTAuditBC;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.basic.AGTAuditBCImpl;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event.EsmAgt0010Event;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event.EsmAgt0011Event;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event.EsmAgt0012Event;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event.EsmAgt0016Event;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event.EsmAgt0017Event;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event.EsmAgt0036Event;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event.EsmAgt0039Event;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event.EsmAgt0042Event;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event.EsmAgt0043Event;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event.EsmAgt0047Event;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.event.EsmAgt0051Event;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.integration.AGTAuditDBDAO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AGTCommInfoForPrint2VO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AGTCommInfoForPrintVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AGTVVDRateVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.APActualInterfaceDetailVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.APActualInterfaceMasterVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgtCommBasicInformationVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.AgtCommListVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.BkgAgnCommDeductionRatingVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.BkgAgtChgDdctVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.CSRDetailforCommissionDtrbVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.CSRDetailforCommissionHdrVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.DeductionChargeVO;
import com.clt.apps.opus.esm.agt.agtaudit.agtaudit.vo.GrsNetCDVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.basic.BRKGAuditBC;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.basic.BRKGAuditBCImpl;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.event.EsmAgt0013Event;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.event.EsmAgt0014Event;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.event.EsmAgt0018Event;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.AGTBRKGRateInfoVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceDetailForBRKGVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceMasterForBRKGVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.APActualInterfaceVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailBasicbyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailChargebyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGCommDetailHistorybyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoForPrint2VO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoForPrintVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BRKGInfoListForPrintVO;
import com.clt.apps.opus.esm.agt.agtaudit.brkgaudit.vo.BrkgCommVO;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.basic.FACAuditBC;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.basic.FACAuditBCImpl;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.event.EsmAgt0015Event;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.event.EsmAgt0033Event;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo.AGTFACRateInfoVO;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo.FACCommDetailBasicbyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo.FACCommDetailChargebyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo.FACCommDetailHistorybyBLVO;
import com.clt.apps.opus.esm.agt.agtaudit.facaudit.vo.FACCommVO;
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
import com.clt.syscommon.common.table.AgtAgnCommVO;
import com.clt.syscommon.common.table.ApPayInvDtlVO;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.BkgQuantityVO;


/**
 * OPUS-AGTAudit Business Logic ServiceCommand - OPUS-AGTAudit handling business transaction
 * 
 * @author 
 * @see AGTAuditDBDAO
 * @since J2EE 1.6
 */

public class AGTAuditSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * AGTAudit system preceding process for biz scenario<br>
	 * related objects creation<br>
	 */
	public void doStart() {
		log.debug("AGTAuditSC 시작");
		try {
			// checking Login user ID
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * AGTAudit system biz scenario closing<br>
	 * biz scenario closing<br>
	 */
	public void doEnd() {
		log.debug("AGTAuditSC 종료");
	}

	/**
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("EsmAgt0010Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {			//Retrieve
				eventResponse = searchAGTCommForRequest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REPLY)) { 	//Re-calculate
				eventResponse = createAGTCommByRequest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) {//ex.Rate Input
				eventResponse = modifyAGTCommExRateByRequest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) { 	//Request
				eventResponse = modifyAGTCommForRequest(e);
			} 
		}

		if (e.getEventName().equalsIgnoreCase("EsmAgt0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAGTCommDetailHistory(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsmAgt0012Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAGTCommDeductionDetail(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsmAgt0013Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { // Retrieve
				eventResponse = searchBRKGCommForAudit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) { // Request
				eventResponse = modifyBRKGCommForAudit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REPLY)) {
				//Re-calculate
				eventResponse = createBRKGCommByRequest(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsmAgt0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchBRKGCommDetailBasicbyBL(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchBRKGCommDetailChargebyBL(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchBRKGCommDetailHistorybyBL(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchAGTBRKGRateInfo(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsmAgt0015Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchFACCommDetailBasicbyBL(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchFACCommDetailChargebyBL(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchFACCommDetailHistorybyBL(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchAGTFACRateInfo(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsmAgt0016Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOtherCommforApproval(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MULTI)){
				eventResponse = multiOtherCommforApproval(e);
				eventResponse = multiOtherCommforApprovalDtl(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY)){
				//Reject
				eventResponse = multiOtherCommforApprovalReject(e);
			}else if(e.getFormCommand().isCommand(FormCommand.REMOVE)){
				//Cancel
				eventResponse = multiOtherCommforApprovalCancel(e);
			}
		}
		
	    if (e.getEventName().equalsIgnoreCase("EsmAgt0017Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Master Retrieve
				eventResponse = searchAPActualInterfaceMaster(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {	//Detail Retrieve 
				eventResponse = searchAPActualInterfaceDetail(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		//Approval Request
				eventResponse = createAgentActualINFtoAP(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {		//Cancel
				eventResponse = createCancelAgentActualINFtoAP(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI03)) {		//Cancel
				eventResponse = modifyAGTCommIFBack(e);
			} else if (e.getFormCommand().isCommand(FormCommand.PRINT)) {		//Cancel
				eventResponse = searchAGTCommInfoForPrint(e);
			}
	    }
		
	    if (e.getEventName().equalsIgnoreCase("EsmAgt0018Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {				//Master Retrieve
				eventResponse = searchAPActualInterfaceMasterForBRKG(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {	//Detail Retrieve 
				eventResponse = searchAPActualInterfaceDetailForBRKG(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {		//Approval Request
				eventResponse = createBRKGActualINFtoAP(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI02)) {		//Cancel
				eventResponse = createCancelBRKGActualINFtoAP(e);
			}else if (e.getFormCommand().isCommand(FormCommand.PRINT)) {		//CSR Print
				eventResponse = searchBRKGInfoForPrint(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {	//Print
				eventResponse = searchBRKGInfoListForPrint(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {	//Excel Download
				eventResponse = searchAPActualInterfaceMasterDetailDownExcel(e);
			}
	    }
		if (e.getEventName().equalsIgnoreCase("EsmAgt0033Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {			//Retrieve
				eventResponse = searchFACCommList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) { 	//Re-calculate
				eventResponse = recalcFACComm(e);
			} 
		}
		if (e.getEventName().equalsIgnoreCase("EsmAgt0036Event")) {
			log.info("\n <<<<S1>>>>>>");
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAGTCommApprovalNo(e);
//				eventResponse = searchAGTCommTobeApproved(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH01)){
				eventResponse = searchAGTCommTobeApproved(e);
			}else if(e.getFormCommand().isCommand(FormCommand.MODIFY)){
				eventResponse = modifyAGTCommTobeApproved(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsmAgt0039Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) { 		//Retrieve
				eventResponse = searchAGTCommForAudit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) { //Save
				eventResponse = modifyAGTCommForAudit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY01)) { //Cancel
				eventResponse = modifyCancelAGTCommForAudit(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY02)) { //Reject
				eventResponse = modifyRejectAGTCommForAudit(e);
			}
		}

		if (e.getEventName().equalsIgnoreCase("EsmAgt0042Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {	//retrieve
				eventResponse = searchOtherCommForRequest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {	//save
				eventResponse = multiOtherCommForRequest(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {	//request
				eventResponse = modifyOtherCommForRequest(e);
			}
		}
		
		if (e.getEventName().equalsIgnoreCase("EsmAgt0043Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCSRDetailforCommissionHdr(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchCSRDetailforCommissionDtrb(e);
			}
		}
		if (e.getEventName().equalsIgnoreCase("EsmAgt0051Event")) {
			log.debug(e.getFormCommand());
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {			//Retrieve
				eventResponse = searchBKGList(e);
			}
			else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {	//Retrieve
				eventResponse = searchAGTCommList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.REPLY)) { 	//Re-calculate
				eventResponse = createAGTCommByRequestFor0051(e);
			} 
		}
		if (e.getEventName().equalsIgnoreCase("EsmAgt0047Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchVvdRateList(e);
			}
		}

		return eventResponse;
	}
	
	

	/**
	* EsmAgt0010 : retrieve event process<br>
	* (ESM_AGT_0010) Agent Commission retrieve event process<br>
	* 
	* @param Event e
	* @return EventResponse
	* @exception EventException
	*/
	private EventResponse searchAGTCommForRequest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0010Event event = (EsmAgt0010Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();
		
		try{
			List<AgtCommListVO> list = command.searchAGTCommForRequest(event.getAgtCommListVO());
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
		 * EsmAgt0010 : modify event process<br>
		 * (ESM_AGT_0010) Agent Commission modify event process<br>
		 * 
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse modifyAGTCommForRequest(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmAgt0010Event event = (EsmAgt0010Event)e;
			AGTAuditBC command = new AGTAuditBCImpl();
			AgtCommListVO selectParam = event.getAgtCommListVO();
			try{
				begin();
				command.modifyAGTCommForRequest(event.getAgtCommListVOS(), account);
				commit();
//				if(dbRowSet != null){
//					if(dbRowSet.getRowCount() > 0){
//						command.sendChnPantoEDIIF(dbRowSet);
//					}				
//				}
				selectParam.setBlNo("");
				selectParam.setVvd("");
				List<AgtCommListVO> list = command.searchAGTCommForRequest(selectParam);

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
		 * EsmAgt0010 : modify event process<br>
		 * (ESM_AGT_0010) Agent Commission ExRate input event process<br>
		 * 
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse modifyAGTCommExRateByRequest(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmAgt0010Event event = (EsmAgt0010Event)e;
			AGTAuditBC command = new AGTAuditBCImpl();
			AgtCommListVO selectParam = event.getAgtCommListVO();
			try{
				command.modifyAGTCommExRateByRequest(event.getAgtCommListVOS(), account);
				selectParam.setBlNo("");
				selectParam.setVvd("");
				List<AgtCommListVO> list = command.searchAGTCommForRequest(selectParam);
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
		 * ESM_AGT_033 Agent Commission recalculate retrieve event process<br>
		 * 
		 * @param e Event
		 * @return response EventResponse
		 * @exception EventException
		 */
		private EventResponse createAGTCommByRequest(Event e) throws EventException {

			EventResponse eventResponse = null;
			EsmAgt0010Event event = (EsmAgt0010Event)e;

			try {
				AGTAuditBC command = new AGTAuditBCImpl();
				command.createAGTCommByRequest(event.getAgtCommListVOS());
				
				eventResponse = this.searchAGTCommForRequest(e);
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			
			return eventResponse;
		}
		


		
		/**
		 * ESM_AGT_0011 retrieving Calculation History information 
		 * @param Event e
		 * @return EventResponse
		 * @throws EventException
		 */
		private EventResponse searchAGTCommDetailHistory(Event e) throws EventException{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmAgt0011Event event = (EsmAgt0011Event)e;
			AGTAuditBC command = new AGTAuditBCImpl();
			try{
				List<AgtAgnCommVO> list1 = command.searchAGTCommCalculationHistory(event.getAgtAgnCommVO());
				List<AgtAgnCommVO> list2 = command.searchAGTCommCommissionDetailAmount(event.getAgtAgnCommVO());
				List<BkgQuantityVO> list3 = command.searchAGTCommDetailTypeSizeQty(event.getAgtAgnCommVO());
				List<AgtCommBasicInformationVO> list4 = command.searchAGTCommBasicInformation(event.getAgtAgnCommVO());
				
				eventResponse.setRsVoList(list1);
				eventResponse.setRsVoList(list2);
				eventResponse.setRsVoList(list3);
				eventResponse.setRsVoList(list4);
				
			}catch (EventException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler(ex).getMessage());
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler(ex).getMessage());
			}
			return eventResponse;			
		}
		/**
		 * ESM_AGT_0012 retrieving Rating information
		 * @param Event e
		 * @return EventResponse
		 * @throws EventException
		 */
		private EventResponse searchAGTCommDeductionDetail(Event e) throws EventException{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmAgt0012Event event = (EsmAgt0012Event)e;
			AGTAuditBC command = new AGTAuditBCImpl();
			try{
				List<BkgAgnCommDeductionRatingVO> list1 = command.searchAGTCommDeductionRating(event.getAgtAgnCommVO());
				List<BkgAgnCommDeductionRatingVO> list2 = command.searchAGTCommDeductionTotal(event.getAgtAgnCommVO());
				List<BkgAgnCommDeductionRatingVO> list3 = command.searchAGTCommDeductionTotalInfo(event.getAgtAgnCommVO());
				List<BkgAgtChgDdctVO> list4 = command.searchAGTCommDeductionCharge(event.getAgtAgnCommVO());
				List<DeductionChargeVO> list5 = command.searchAGTCommDeductionTrspCost(event.getAgtAgnCommVO());
				List<GrsNetCDVO> list6 = command.searchAGTCommGrsNetCD(event.getAgtAgnCommVO());
				
				eventResponse.setRsVoList(list1);
				eventResponse.setRsVoList(list2);
				eventResponse.setRsVoList(list3);
				eventResponse.setRsVoList(list4);
				eventResponse.setRsVoList(list5);
				eventResponse.setRsVoList(list6);
			}catch (EventException ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler(ex).getMessage());
			} catch (Exception ex) {
				log.error("err " + ex.toString(), ex);
				throw new EventException(new ErrorHandler(ex).getMessage());
			}
			return eventResponse;
	    }

		/**
		 * EsmAgt0013 : retrieve event process<br>
		 * (ESM_AGT_0013) Brokerage Approval retrieve event process.<br>
		 * 
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchBRKGCommForAudit(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmAgt0013Event event = (EsmAgt0013Event) e;
			BRKGAuditBC command = new BRKGAuditBCImpl();

			try {
				List<BrkgCommVO> list = command.searchBRKGCommforAudit(event.getBrkgCommVO());
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
		 * EsmAgt0013 : modify event process<br>
		 * (ESM_AGT_0013) Brokerage Approval modify event process<br>
		 * 
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse modifyBRKGCommForAudit(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmAgt0013Event event = (EsmAgt0013Event) e;
			BRKGAuditBC command = new BRKGAuditBCImpl();
			BrkgCommVO selectParam = event.getBrkgCommVO();
			try {
				begin();
				command.modifyBRKGCommforAudit(event.getBrkgCommVOS(), account);
				commit();
				selectParam.setBlNo("");
				selectParam.setVvd("");
				List<BrkgCommVO> list = command.searchBRKGCommforAudit(selectParam);
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
		 * ESM_AGT_013 Brokerage recalculate event process<br>
		 * 
		 * @param Event e
		 * @return response EventResponse
		 * @exception EventException
		 */
		private EventResponse createBRKGCommByRequest(Event e) throws EventException {
			// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
			EventResponse eventResponse = null;
			EsmAgt0013Event event = (EsmAgt0013Event)e;

			try {
				BRKGAuditBC command = new BRKGAuditBCImpl();
				command.createBRKGCommByRequest(event.getBrkgCommVOS());
				
				eventResponse = this.searchBRKGCommForAudit(e);
			} catch (EventException de) {
				log.error("err " + de.toString(), de);
				throw new EventException(de.getMessage());
			}
			
			return eventResponse;
		}
		

		/**
		 * ESM_AGT_0014) Brokerage Commission Basic information retrieve event process
		 * @param Event e
		 * @return EventResponse
		 * @throws EventException
		 */
		private EventResponse searchBRKGCommDetailBasicbyBL(Event e) throws EventException{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmAgt0014Event event = (EsmAgt0014Event)e;
			BRKGAuditBC command = new BRKGAuditBCImpl();
			try{
				List<BRKGCommDetailBasicbyBLVO> list = command.searchBRKGCommDetailBasicbyBL(event.getBrkgCommDetailBasicbyBLVO());
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
		 * (ESM_AGT_0014) Brokerage Charge Detail information retrieve event process<br>
		 * @param Event e
		 * @return EventResponse
		 * @throws EventException
		 */
		private EventResponse searchBRKGCommDetailChargebyBL(Event e) throws EventException{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmAgt0014Event event = (EsmAgt0014Event)e;
			BRKGAuditBC command = new BRKGAuditBCImpl();
			try{
				List<BRKGCommDetailChargebyBLVO> list = command.searchBRKGCommDetailChargebyBL(event.getBrkgCommDetailChargebyBLVO());
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
		 * (ESM_AGT_0014) Brokerage Commission History Detail information retrieve event process<br>
		 * @param Event e
		 * @return EventResponse
		 * @throws EventException
		 */
		private EventResponse searchBRKGCommDetailHistorybyBL(Event e) throws EventException{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmAgt0014Event event = (EsmAgt0014Event)e;
			BRKGAuditBC command = new BRKGAuditBCImpl();
			try{
				List<BRKGCommDetailHistorybyBLVO> list = command.searchBRKGCommDetailHistorybyBL(event.getBrkgCommDetailHistorybyBLVO());
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
		 * (ESM_AGT_0014) Actually calculated Brokerage Agreement rate information retrieve event process<br>
		 * @param Event e
		 * @return EventResponse
		 * @throws EventException
		 */
		private EventResponse searchAGTBRKGRateInfo(Event e) throws EventException{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmAgt0014Event event = (EsmAgt0014Event)e;
			BRKGAuditBC command = new BRKGAuditBCImpl();
			try{
				List<AGTBRKGRateInfoVO> list = command.searchAGTBRKGRateInfo(event.getAgtBRKGRateInfoVO());
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
		 * ESM_AGT_0015) FAC Commission의 Basic information retrieve event process
		 * @param Event e
		 * @return EventResponse
		 * @throws EventException
		 */
		private EventResponse searchFACCommDetailBasicbyBL(Event e) throws EventException{
		    GeneralEventResponse eventResponse = new GeneralEventResponse();
		    EsmAgt0015Event event = (EsmAgt0015Event)e;
		    FACAuditBC command = new FACAuditBCImpl();
		    try{
		    	List<FACCommDetailBasicbyBLVO> list = command.searchFACCommDetailBasicbyBL(event.getFacCommDetailBasicbyBLVO());
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
		 * (ESM_AGT_0015) Charge Detail information retrieve event process<br>
		 * @param Event e
		 * @return EventResponse
		 * @throws EventException
		 */
		private EventResponse searchFACCommDetailChargebyBL(Event e) throws EventException{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
		    EsmAgt0015Event event = (EsmAgt0015Event)e;
		    FACAuditBC command = new FACAuditBCImpl();
		    try{
		    	List<FACCommDetailChargebyBLVO> list = command.searchFACCommDetailChargebyBL(event.getFacCommDetailChargebyBLVO());
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
		 * (ESM_AGT_0015) FAC Commission History Detail information retrieve event process<br>
		 * @param Event e
		 * @return EventResponse
		 * @throws EventException
		 */
		private EventResponse searchFACCommDetailHistorybyBL(Event e) throws EventException{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
		    EsmAgt0015Event event = (EsmAgt0015Event)e;
		    FACAuditBC command = new FACAuditBCImpl();
		    try{
		    	List<FACCommDetailHistorybyBLVO> list = command.searchFACCommDetailHistorybyBL(event.getFacCommDetailHistorybyBLVO());
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
		 * (ESM_AGT_0015)  Actually calculated FAC Agreement rate information retrieve event process<br>
		 * @param Event e
		 * @return EventResponse
		 * @throws EventException
		 */
		private EventResponse searchAGTFACRateInfo(Event e) throws EventException{
			GeneralEventResponse eventResponse = new GeneralEventResponse();
		    EsmAgt0015Event event = (EsmAgt0015Event)e;
		    FACAuditBC command = new FACAuditBCImpl();
		    try{
		    	List<AGTFACRateInfoVO> list = command.searchAGTFACRateInfo(event.getAgtFacRateInfoVO());
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
		 * EsmAgt016 : retrieve event process<br>
		 * (ESM_AGT_016) Other Commission Approval retrieve event process<br>
		 * 
		 * @param Event e
		 * @return EventResponse
		 * @exception EventException
		 */
		private EventResponse searchOtherCommforApproval(Event e) throws EventException {
			// PDTO(Data Transfer Object including Parameters)
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			EsmAgt0016Event event = (EsmAgt0016Event)e;
			AGTAuditBC command = new AGTAuditBCImpl();

			try{
				List<AgtAgnCommVO> list = command.searchOtherCommforApproval(event.getAgtAgnCommVO());
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
	 * EsmAgt016 : multi event process<br>
	 * (ESM_AGT_016) Other Commission Approval multi event process<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOtherCommforApproval(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0016Event event = (EsmAgt0016Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();
		try{
			begin();
			command.multiOtherCommforApproval(event.getAgtAgnCommVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
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
	 * EsmAgt016 : multi event process<br>
	 * (ESM_AGT_016) Other Commission Approval Detail multi event process<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOtherCommforApprovalDtl(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0016Event event = (EsmAgt0016Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();
		try{
			begin();
			command.multiOtherCommforApprovalDtl(event.getAgtAgnCommVOS(), event.getAgtAgnCommDtlVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
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
	 * EsmAgt016 : reject event process<br>
	 * (ESM_AGT_016) Other Commission Approval reject event process<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOtherCommforApprovalReject(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0016Event event = (EsmAgt0016Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();
		try{
			begin();
			command.multiOtherCommforApprovalReject(event.getAgtAgnCommVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
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
	 * EsmAgt016 :  cancel event process<br>
	 * (ESM_AGT_016) Other Commission Approval cancel event process<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse multiOtherCommforApprovalCancel(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0016Event event = (EsmAgt0016Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();
		try{
			begin();
			command.multiOtherCommforApprovalCancel(event.getAgtAgnCommVOS(), account);
			eventResponse.setUserMessage(new ErrorHandler("").getUserMessage());
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
	 * EsmAgt017 :  retrieve event process<br>
	 * (ESM_AGT_017) Agent Commission AP Interface retrieve event process
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAPActualInterfaceMaster(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0017Event event = (EsmAgt0017Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();

		try{
			List<APActualInterfaceMasterVO> list = command.searchAPActualInterfaceMaster(event.getAPActualInterfaceMasterVO());
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
	 * EsmAgt017 : retrieve event process<br>
	 * (ESM_AGT_017) Agent Commission AP Interface Detail retrieve event process
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAPActualInterfaceDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0017Event event = (EsmAgt0017Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();

		try{
			List<APActualInterfaceDetailVO> list = command.searchAPActualInterfaceDetail(event.getAPActualInterfaceDetailVO());
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
	 * EsmAgt017 : Interface event process<br>
	 * (ESM_AGT_017) Agent Commission AP Interface Detail Interface event process
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createAgentActualINFtoAP(Event e) throws EventException{
		
		
		EsmAgt0017Event event = (EsmAgt0017Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();
		CSRExternalFinderBC commandCSR 	= new CSRExternalFinderBCImpl();
		
		try{
			begin();
						
			APActualInterfaceMasterVO[] apActualInterfaceMasterVOs = event.getAPActualInterfaceMasterVOS();
			
			for(int i=0;i<apActualInterfaceMasterVOs.length;i++){
				apActualInterfaceMasterVOs[i].setInvDt(apActualInterfaceMasterVOs[0].getInvDt());
				apActualInterfaceMasterVOs[i].setAproStep(apActualInterfaceMasterVOs[0].getAproStep());
				apActualInterfaceMasterVOs[i].setSearchDtTo(apActualInterfaceMasterVOs[0].getSearchDtTo());
				apActualInterfaceMasterVOs[i].setExpType(apActualInterfaceMasterVOs[0].getExpType());
				apActualInterfaceMasterVOs[i].setSearchDtFr(apActualInterfaceMasterVOs[0].getSearchDtFr());
				apActualInterfaceMasterVOs[i].setInvTaxRt(apActualInterfaceMasterVOs[0].getInvTaxRt());
				apActualInterfaceMasterVOs[i].setArOfcCd(apActualInterfaceMasterVOs[0].getArOfcCd());
				apActualInterfaceMasterVOs[i].setIfOption(apActualInterfaceMasterVOs[0].getIfOption());
			}
			for(int i=0;i<apActualInterfaceMasterVOs.length;i++){		
					ApPayInvVO apPayInvVO  = command.searchAgtApPayInv(apActualInterfaceMasterVOs[i]);//getTesTmlSoHdrVO());
					
					ApPayInvDtlVO[] apPayInvDtlVOs = command.searchAgtApPayInvDtl(apActualInterfaceMasterVOs[i]);

					//2012.03.23  권상준
					command.createAgentActualINFtoAP(event.getAPActualInterfaceMasterVOS(), event.getAPActualInterfaceMasterVO(), account);
					//log.debug("apPayInvVO.getInvNo()---------->>"+apPayInvVO.getInvNo());
					//log.debug("apPayInvDtlVOs.getInvNo[]--------->"+apPayInvDtlVOs[i].());
					String strInvRgstNo = commandCSR.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);
					//log.debug("strInvRgstNo--------->"+strInvRgstNo);
					command.modifyAGTCommProcStsCd(apPayInvVO);
					
//2011.03.10 이정수
//			command.createAgentActualINFtoAP(event.getAPActualInterfaceMasterVOS(), event.getAPActualInterfaceMasterVO(), account);

			}
			
			commit();

//			List<APActualInterfaceMasterVO> list = command.searchAPActualInterfaceMaster(event.getAPActualInterfaceMasterVO());
//			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return searchAPActualInterfaceMaster(e);
		
	} 
	

	
	/**
	 * EsmAgt017 : Cancel event process<br>
	 * (ESM_AGT_017) Agent Commission AP Interface Detail Cancel event process
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse createCancelAgentActualINFtoAP(Event e) throws EventException{
		//GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0017Event event = (EsmAgt0017Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();
		CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl();
		
		try{
			APActualInterfaceMasterVO[] apActualInterfaceMasterVOs = event.getAPActualInterfaceMasterVOS();
			for(int i=0;i<apActualInterfaceMasterVOs.length;i++){
				begin();
				ApPayInvVO apPayInvVO = new ApPayInvVO();
				ApPayInvDtlVO[] apPayInvDtlVOs = new ApPayInvDtlVO[0];

				apPayInvVO.setUpdUsrId(account.getUsr_id());
				apPayInvVO.setInvOfcCd(account.getOfc_cd());
				apPayInvVO.setDeltFlg("Y");
				apPayInvVO.setInvRgstNo(apActualInterfaceMasterVOs[i].getInvRgstNo());
				// CSR method
				command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);
				
				command.createCancelAgentActualINFtoAP(apActualInterfaceMasterVOs[i], account);
				commit();
			}

		}catch(EventException ex){  
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return searchAPActualInterfaceMaster(e);
	} 
	
	/**
	 * ESM_AGT_017 printing Report event process<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAGTCommInfoForPrint(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0017Event event = (EsmAgt0017Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();

		try{
			List<AGTCommInfoForPrintVO> list1 = command.searchAGTCommInfoForPrint1(event.getAgtCommInfoForPrintVO());
			List<AGTCommInfoForPrint2VO> list2 = command.searchAGTCommInfoForPrint2(event.getAgtCommInfoForPrint2VO());
			
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
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
	 * ESM_AGT_0017 Interface BAck event process<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse modifyAGTCommIFBack(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0017Event event = (EsmAgt0017Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();
		try{
			begin();
			command.modifyAGTCommIFBack(event.getCsrCd());
			commit();
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
	 * EsmAgt0018 : retrieve event process<br>
	 * (ESM_AGT_0018) Agent Commission AP Interface retrieve event process
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAPActualInterfaceMasterForBRKG(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0018Event event = (EsmAgt0018Event)e;
		BRKGAuditBC command = new BRKGAuditBCImpl();

		try{
			List<APActualInterfaceMasterForBRKGVO> list = command.searchAPActualInterfaceMasterForBRKG(event.getAPActualInterfaceMasterForBRKGVO());
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
	 * EsmAgt0018 : retrieve event process<br>
	 * (ESM_AGT_0018) Agent Commission AP Interface Detail retrieve event process
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAPActualInterfaceDetailForBRKG(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0018Event event = (EsmAgt0018Event)e;
		BRKGAuditBC command = new BRKGAuditBCImpl();

		try{
			List<APActualInterfaceDetailForBRKGVO> list = command.searchAPActualInterfaceDetailForBRKG(event.getAPActualInterfaceDetailForBRKGVO());
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
	 * ESM_AGT_0018 Approval Request  
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createBRKGActualINFtoAP(Event e) throws EventException {
	    // TODO Auto-generated method stub
/*		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0018Event event = (EsmAgt0018Event)e;
		BRKGAuditBC command = new BRKGAuditBCImpl();
		CSRExternalFinderBC commandCSR 	= new CSRExternalFinderBCImpl();
		String fwdrvndrSeqapOfcCd = "";
		try{
			APActualInterfaceMasterForBRKGVO[] actualInterfaceMasterForBRKGVOs = event.getAPActualInterfaceMasterForBRKGVOs();
			APActualInterfaceMasterForBRKGVO   actualInterfaceMasterForBRKGVO  = event.getAPActualInterfaceMasterForBRKGVO();
//			if (actualInterfaceMasterForBRKGVOs.length > 0)
//			{
//				for (int i=0 ;i < actualInterfaceMasterForBRKGVOs.length; i++)
//				{
//					if ( "U".equals(actualInterfaceMasterForBRKGVOs[i].getIbflag()))
//					{
					fwdrvndrSeqapOfcCd = "'";
					fwdrvndrSeqapOfcCd = fwdrvndrSeqapOfcCd + actualInterfaceMasterForBRKGVOs[i].getFwdr()+
					actualInterfaceMasterForBRKGVOs[i].getVndrSeq()+
					actualInterfaceMasterForBRKGVOs[i].getApOfcCd();
					fwdrvndrSeqapOfcCd = fwdrvndrSeqapOfcCd + "'";
					actualInterfaceMasterForBRKGVO.setFwdrVndrSeqApOfcCd(fwdrvndrSeqapOfcCd);

					begin();
					//command.createBRKGActualRequestINFtoAP(actualInterfaceMasterForBRKGVOs, actualInterfaceMasterForBRKGVO, account);
					ApPayInvVO apPayInvVO = command.searchBrogApPayInv(((EsmAgt0018Event)e).getBrogApPayInvVO());//getTesTmlSoHdrVO());
					ApPayInvDtlVO[] apPayInvDtlVOs = command.searchBrogApPayInvDtl(((EsmAgt0018Event)e).getBrogApPayInvVO(), ((EsmAgt0018Event)e).getApPayInvVO());
					String strInvRgstNo = commandCSR.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);
					
					commit();
//					}
//				}
//			}
		}catch(EventException ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}
//	    return searchAPActualInterfaceMasterForBRKG(e);
		return eventResponse;
*/    
		EsmAgt0018Event event = (EsmAgt0018Event)e;
		BRKGAuditBC command = new BRKGAuditBCImpl();
		CSRExternalFinderBC commandCSR 	= new CSRExternalFinderBCImpl();
		
		try{
			begin();
						
			APActualInterfaceMasterForBRKGVO[] actualInterfaceMasterForBRKGVOs = event.getAPActualInterfaceMasterForBRKGVOs();
			APActualInterfaceMasterForBRKGVO   actualInterfaceMasterForBRKGVO  = event.getAPActualInterfaceMasterForBRKGVO();
			log.debug("apActualInterfaceMasterVOs.length===>"+actualInterfaceMasterForBRKGVOs.length);

			
			for(int i=0;i<actualInterfaceMasterForBRKGVOs.length;i++){
				actualInterfaceMasterForBRKGVOs[i].setEffDate(actualInterfaceMasterForBRKGVOs[0].getEffDate());
				actualInterfaceMasterForBRKGVOs[i].setAproStep(actualInterfaceMasterForBRKGVOs[0].getAproStep());
				actualInterfaceMasterForBRKGVOs[i].setSearchDtTo(actualInterfaceMasterForBRKGVOs[0].getSearchDtTo());
				actualInterfaceMasterForBRKGVOs[i].setSearchDtFr(actualInterfaceMasterForBRKGVOs[0].getSearchDtFr());
				actualInterfaceMasterForBRKGVOs[i].setIfOption(actualInterfaceMasterForBRKGVOs[0].getIfOption());
				actualInterfaceMasterForBRKGVOs[i].setInvOfcCd(account.getOfc_cd());
			}
			
			for(int i=0;i<actualInterfaceMasterForBRKGVOs.length;i++){
				ApPayInvVO apPayInvVO  = command.searchBrogApPayInv(actualInterfaceMasterForBRKGVOs[i],event.getSignOnUserAccount().getUsr_id());//getTesTmlSoHdrVO());
				//log.debug("apPayInvVO.getInvNo()---------->>"+apPayInvVO.getColumnValues());
				ApPayInvDtlVO[] apPayInvDtlVOs = command.searchBrogApPayInvDtl(actualInterfaceMasterForBRKGVOs[i]);
				//log.debug("apPayInvDtlVOs.getColumnValues[]--------->"+apPayInvDtlVOs[i].getColumnValues());
				String strInvRgstNo = commandCSR.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);
				//log.debug("strInvRgstNo--------->"+strInvRgstNo);
				command.modifyBrogCommProcStsCd(apPayInvVO);	
			}
			
			command.createBRKGActualRequestINFtoAP(actualInterfaceMasterForBRKGVOs, actualInterfaceMasterForBRKGVO, account);
			
			commit();

//			List<APActualInterfaceMasterVO> list = command.searchAPActualInterfaceMaster(event.getAPActualInterfaceMasterVO());
//			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return searchAPActualInterfaceMasterForBRKG(e);	
	}
	/**
	 * ESM_AGT_0018 Approval Request  
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createCancelBRKGActualINFtoAP(Event e) throws EventException{

		EsmAgt0018Event event = (EsmAgt0018Event)e;
		BRKGAuditBC command = new BRKGAuditBCImpl();
		CSRExternalFinderBC command2 = new CSRExternalFinderBCImpl();
		
		try{
			begin();
			APActualInterfaceMasterForBRKGVO[] apActualInterfaceMasterVOs = event.getAPActualInterfaceMasterForBRKGVOs();
			//command.createCancelBRKGActualINFtoAP(event.getAPActualInterfaceMasterVOS(), account);
			ApPayInvVO apPayInvVO = new ApPayInvVO();
			ApPayInvDtlVO[] apPayInvDtlVOs = new ApPayInvDtlVO[0];

			apPayInvVO.setUpdUsrId(account.getUsr_id());
			apPayInvVO.setInvOfcCd(account.getOfc_cd());
			apPayInvVO.setDeltFlg("Y");
			apPayInvVO.setInvRgstNo(apActualInterfaceMasterVOs[0].getInvRgstNo());
			// CSR 메소드 실행
			command2.createApPayInvInfo(apPayInvVO, apPayInvDtlVOs, account);
			
			command.createCancelBRKGActualINFtoAP(event.getAPActualInterfaceMasterForBRKGVO(), account);
			commit();

		}catch(EventException ex){
			rollback();
			throw ex;
		}catch(Exception ex){
			throw new EventException(ex.getMessage(), ex);
		}
		return searchAPActualInterfaceMasterForBRKG(e);
	}
	/**
	 * EsmAgt0018 : retrieve event process<br>
	 * (ESM_AGT_0018) Agent Commission AP Interface retrieve event process to print excel file
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAPActualInterfaceMasterDetailDownExcel(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0018Event event = (EsmAgt0018Event)e;
		BRKGAuditBC command = new BRKGAuditBCImpl();

		try{
			List<APActualInterfaceVO> list = command.searchAPActualInterfaceMasterDetailDownExcel(event.getAPActualInterfaceVO());
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
	 * ESM_AGT_0018 CSR Print event process
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBRKGInfoForPrint(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0018Event event = (EsmAgt0018Event)e;
		BRKGAuditBC command = new BRKGAuditBCImpl();

		try{
			List<BRKGInfoForPrintVO> list1 = command.searchBRKGInfoForPrint1(event.getBrkgInfoForPrintVO());
			List<BRKGInfoForPrint2VO> list2 = command.searchBRKGInfoForPrint2(event.getBrkgInfoForPrint2VO());
			
			eventResponse.setRsVoList(list1);
			eventResponse.setRsVoList(list2);
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
	 * ESM_AGT_0018 Print event process
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchBRKGInfoListForPrint (Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0018Event event = (EsmAgt0018Event)e;
		BRKGAuditBC command = new BRKGAuditBCImpl();

		try{
			List<BRKGInfoListForPrintVO> list1 = command.searchBRKGInfoListForPrint(event.getBrkgInfoListForPrintVO());
						
			eventResponse.setRsVoList(list1);
			
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
	 * ESM_AGT_0033 retrieve event process<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchFACCommList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0033Event event = (EsmAgt0033Event)e;
		FACAuditBC command = new FACAuditBCImpl();
		
		try{
			List<FACCommVO> list = command.searchFACCommList(event.getFACCommVO());
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
	 * FAC Commission reCalculate event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse recalcFACComm(Event e) throws EventException {
		EventResponse eventResponse = null;

        try {
        	FACAuditBC command = new FACAuditBCImpl();
        	eventResponse = command.reCalcFACComm(e);
//            begin();
            
            Calendar cal	= Calendar.getInstance();
	        long time1	= cal.getTimeInMillis();

	        cal	= Calendar.getInstance();
	        long time2 = cal.getTimeInMillis();
	        long time3 = time2 - time1;

			EsmAgt0033Event event=(EsmAgt0033Event)e;
			FACCommVO[] facCommVOs = event.getFACCommVOS();
			//SignOnUserAccount account = event.getSignOnUserAccount();
			for(int i=0; i<facCommVOs.length; i++)
			{
				if ( facCommVOs[i].getIbflag().equals("U"))
				{
					command.recalcFACComm(facCommVOs[i].getBkgNo(), event.getSignOnUserAccount());
				}
			}            
	        log.debug("\n 처리 시간 millisecond :: " + time3);
	        log.debug("\n 처리 시간 초 :: " + time3/1000);
	        log.debug("\n 처리 시간  :: " + time3/1000/60 + "분 " + (time3/1000)%60 + " 초 " + time3%1000 + "ms");

//            commit();
			eventResponse = this.searchFACCommList(e);
        } catch (EventException de) {
//        	rollback();
            log.error("err " + de.toString(), de);
            throw new EventException(de.getMessage());
        }
        
        return eventResponse;
	}	
	
	
	/**
	 * ESM_AGT_033 화면에서 Agreement Commission recalculate event process.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/*
	private EventResponse reCalcFACComm(Event e) throws EventException {
		// 사용자 요청의 결과(DB Result Set, 객체, 값 등)을 담은 객체
		EventResponse eventResponse = null;

		try {
			FACAuditBC command = new FACAuditBCImpl();
			eventResponse = command.reCalcFACComm(e);
			
			eventResponse = this.searchFACCommList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
	}
	*/

	/**
	 * ESM_AGT_0036 ApprovalNo retrieve event process<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAGTCommApprovalNo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0036Event event = (EsmAgt0036Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();
		
		try{
			List<AgtAgnCommVO> list = command.searchAGTCommApprovalNo(event.getAgtAgnCommVO());
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
	 * ESM_AGT_0036 Approved retrieve event process<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAGTCommTobeApproved(Event e) throws EventException{
		// TODO Auto-generated method stub
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0036Event event = (EsmAgt0036Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();
		
		try{
			List<AgtAgnCommVO> list = command.searchAGTCommTobeApproved(event.getAgtAgnCommVO());
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
	 * ESM_AGT_0036 Approved retrieve event process<br>
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyAGTCommTobeApproved(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0036Event event = (EsmAgt0036Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();
		try{
			command.modifyAGTCommTobeApproved(event.getAgtAgnCommVOS(), account);
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
	 * EsmAgt0039 : retrieve event process<br>
	 * (ESM_AGT_0039) Agent Commission Maintenance & Audit retrieve event process<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAGTCommForAudit(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0039Event event = (EsmAgt0039Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();

		try{
			List<AgtCommListVO> list = command.searchAGTCommForAudit(event.getAgtCommListVO());
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
	 * EsmAgt0039 : modify event process<br>
	 * (ESM_AGT_0039) Agent Commission Maintenance & Audit retrieve event process<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyAGTCommForAudit(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0039Event event = (EsmAgt0039Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();
		AgtCommListVO selectParam = event.getAgtCommListVO();
		try{
			begin();
			command.modifyAGTCommForAudit(event.getAgtCommListVOS(), account);
			commit();
			selectParam.setBlNo("");
			selectParam.setVvd("");
			List<AgtCommListVO> list = command.searchAGTCommForAudit(selectParam);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}




	/**
	 * EsmAgt0039 : Cancel event process<br>
	 * (ESM_AGT_0039) Agent Commission Maintenance & Audit Cancel event process<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyCancelAGTCommForAudit(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0039Event event = (EsmAgt0039Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();
		AgtCommListVO selectParam = event.getAgtCommListVO();
		try{
			begin();
			command.modifyCancelAGTCommForAudit(event.getAgtCommListVOS(), account);
			commit();
			selectParam.setBlNo("");
			selectParam.setVvd("");
			List<AgtCommListVO> list = command.searchAGTCommForAudit(selectParam);
			eventResponse.setRsVoList(list);
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}		
		return eventResponse;
	}



	/**
	 * EsmAgt0039 : Reject event process<br>
	 * (ESM_AGT_0039) Agent Commission Maintenance & Audit Reject event process<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyRejectAGTCommForAudit(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0039Event event = (EsmAgt0039Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();
		AgtCommListVO selectParam = event.getAgtCommListVO();
		try{
			command.modifyRejectAGTCommForAudit(event.getAgtCommListVOS(), account);
			selectParam.setBlNo("");
			selectParam.setVvd("");
			List<AgtCommListVO> list = command.searchAGTCommForAudit(selectParam);
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
	 * EsmAgt0042 : retrieve event process<br>
	 * (ESM_AGT_0042) Other Commission Approval retrieve event process<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOtherCommForRequest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0042Event event = (EsmAgt0042Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();

		try{
			List<AgtAgnCommVO> list = command.searchOtherCommForRequest(event.getAgtAgnCommVO());
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
	 * ESM_AGT_0042) Other Commission Maintenance & Request Master information Request event process<br> 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyOtherCommForRequest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0042Event event = (EsmAgt0042Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();

		try{
			command.modifyOtherCommForRequest(event.getAgtAgnCommVOS(), account);
			List<AgtAgnCommVO> list = command.searchOtherCommForRequest(event.getAgtAgnCommVO());
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
	 * ESM_AGT_0042) Other Commission Maintenance & Request multi event process<br> 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse multiOtherCommForRequest(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0042Event event = (EsmAgt0042Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();
		log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+event.getAgtAgnCommVOS()==null?"1":"0");
		log.debug("\n>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+event.getAgtAgnCommVOS().toString());

		try{
			begin();
			//AgtAgnCommVO[] agtAgnCommVOs= event.getAgtAgnCommVOS();
			command.multiOtherCommForRequest(event.getAgtAgnCommVOS(), account);
			List<AgtAgnCommVO> list = command.searchOtherCommForRequest(event.getAgtAgnCommVO());
			eventResponse.setRsVoList(list);
			commit();
		}catch(EventException ex){
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}catch(Exception ex){
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage());
		}	
		return eventResponse;
	}
	/**
	 * ESM_AGT_0043 retrieve event process
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRDetailforCommissionHdr(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0043Event event = (EsmAgt0043Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();
		try{
			List<CSRDetailforCommissionHdrVO> list = command.searchCSRDetailforCommissionHdr(event.getCsrDetailforCommissionHdrVO());
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
	 * ESM_AGT_0043 retrieve event process
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCSRDetailforCommissionDtrb(Event e) throws EventException{
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0043Event event = (EsmAgt0043Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();
		try{
			List<CSRDetailforCommissionDtrbVO> list = command.searchCSRDetailforCommissionDtrb(event.getCsrDetailforCommissionDtrbVO());
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
	 * EsmAgt0051 : retrieve event process<br>
	 * (ESM_AGT_0051) Agent Commission Approval retrieve event process<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException 
	 */
	private EventResponse searchBKGList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0051Event event = (EsmAgt0051Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();

		try{
			List<AgtCommListVO> list = command.searchBKGList(event.getAgtCommListVO());
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
	 * EsmAgt0051 : retrieve event process<br>
	 * (ESM_AGT_0051) Agent Commission Approval retrieve event process<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAGTCommList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmAgt0051Event event = (EsmAgt0051Event)e;
		AGTAuditBC command = new AGTAuditBCImpl();

		try{
			List<AgtCommListVO> list = command.searchAGTCommList(event.getAgtCommListVO());
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
	 * ESM_AGT_051 Agreement Commission recalculate event process<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse createAGTCommByRequestFor0051(Event e) throws EventException {

		EventResponse eventResponse = null;
		EsmAgt0051Event event = (EsmAgt0051Event)e;

		try {
			AGTAuditBC command = new AGTAuditBCImpl();
			command.createAGTCommByRequest(event.getAgtCommListVOS());
			
			eventResponse = this.searchBKGList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		
		return eventResponse;
	}	
	
    /**
     * retrieve event process<br>
     * VVD Chart retrieve event process<br>
     * @param e 
     * @return response EventResponse
     * @exception EventException
     */
    private EventResponse searchVvdRateList(Event e) throws EventException {

        GeneralEventResponse eventResponse = new GeneralEventResponse();
        EsmAgt0047Event event = (EsmAgt0047Event)e;
        AGTAuditBC command = new AGTAuditBCImpl();
        try {
            //eventResponse.setRs(command.searchVVDRateList(event.getAgtVVDRateVOs()));
            List<AGTVVDRateVO> list = command.searchVVDRateList(event.getAgtVVDRateVO());
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
	


}