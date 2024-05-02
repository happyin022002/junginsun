/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : AccountReceivableAgentSC.java
 *@FileTitle : AccountReceivableAgentSC
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2014.03.03 authorName
 * 1.0 Creation
 * --------------------------------------------------------
 * History
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.basic.AccountPayableInvoiceBC;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.basic.AccountPayableInvoiceBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.basic.AccountReceivableAgentBC;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.basic.AccountReceivableAgentBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.event.StmSar0200Event;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.event.StmSar5001Event;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.event.StmSar5002Event;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.event.StmSar5003Event;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.event.StmSar5004Event;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.event.StmSar5005Event;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.event.StmSar5901Event;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.integration.AccountReceivableAgentDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ASAInfoByOfcAgnVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ASAInquiryListVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ASAnoListVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.AgentCollectionListVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.BatHisVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.CheckASAperiodVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.CheckPreASAStausVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.UnreportedOtsReportVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SarAsaDtlVO;
import com.clt.syscommon.common.table.SarAsaMstVO;

/**
 * AccountReceivableAgent Business Logic ServiceCommand 
 * - Handling AccountReceivableAgent Business transaction.
 * 
 * @author 
 * @see AccountReceivableAgentDBDAO
 * @since J2EE 1.6
 */ 

public class AccountReceivableAgentSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Precede AccountReceivableAgent system <br>
	 *  Create Object when STM_SAR job call<br>
	 */
	public void doStart() {
		try {
			//Checking login
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());

		}
	}

	/**
	 * Follow AccountReceivableAgent system<br>
	 * Release Object when STM_SAR job end<br>
	 */
	public void doEnd() {
		log.debug("AccountReceivableAgentSC 종료");
	}

	/**
	 * proceeding job each Even<br>
	 *  Handling every Event on  AccountReceivableAgent system<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("StmSar0200Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchASAnoList(e);
			}
		} 
		
		else if (e.getEventName().equalsIgnoreCase("StmSar5001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgentCollectionList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAgentCollectionList(e);
			} /*else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				
			}*/
		}
		
		else if (e.getEventName().equalsIgnoreCase("StmSar5005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgentCollectionListInqiry(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("StmSar5901Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAgentCollectionListPOPUP(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageAgentCollectionList(e);
			} /*else if (e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
			}*/
		}
		
		else if (e.getEventName().equalsIgnoreCase("StmSar5004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUnreportedOtsReportList(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("StmSar5003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchASAInquiryList(e);
			}
		}
		
		else if (e.getEventName().equalsIgnoreCase("StmSar5002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = newASA(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = createASA(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = finishASA(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = reopenASA(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND05)) {
				eventResponse = approveASA(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchASA(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND06)) {
				eventResponse = checkASAperiod(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND07)) {
				eventResponse = checkPreASAStatus(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {  
			    eventResponse = searchIfBackEndJobStatus(e);   
			}
		}
		
		return eventResponse;
	}
	
	/**
	 * Retrieve ASA NO Pop up event<br>
	 * 
	 * @author YJLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchASAnoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar0200Event event = (StmSar0200Event) e;
		AccountReceivableAgentBC command = new AccountReceivableAgentBCImpl();
		
	try {
			List<ASAnoListVO> list = command.searchASAnoList(event.getAsaNo(),event.getAsaOfcCd(),event.getFlag_cd());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

	/**
	 * STM_SAR_5001 : Retrieve
	 * Agent Collection Entry event<br>
	 * 
	 * @author YJLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgentCollectionList(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar5001Event event = (StmSar5001Event) e;
		AccountReceivableAgentBC command = new AccountReceivableAgentBCImpl();
		
	try { 
			begin();	
			List<AgentCollectionListVO> list = command.searchAgentCollectionList(event.getAgentCollectionListVO(),account);
			command.addAgentCollectionTempListBasic(list);
			eventResponse.setETCData("OTSCNT", String.valueOf(list.size())); 
			List<AgentCollectionListVO> list2 = command.searchAgentCollectionListFOREntry(event.getAgentCollectionListVO());
			if(list2.size() > 0){
				list.addAll(list2);
			} 
			eventResponse.setRsVoList(list); 
			commit(); 
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * STM_SAR_5005 : Retrieve
	 * Agent Collection Inquiry event<br>
	 * 
	 * @author YJLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgentCollectionListInqiry(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar5005Event event = (StmSar5005Event) e;
		AccountReceivableAgentBC command = new AccountReceivableAgentBCImpl();
		
	try {
			List<AgentCollectionListVO> list = command.searchAgentCollectionListInquiry(event.getAgentCollectionListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * STM_SAR_5001 : insert, update, delete
	 * Agent Collection Entry event<br>
	 * 
	 * @author YJLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageAgentCollectionList(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar5001Event event = (StmSar5001Event) e;
		AccountReceivableAgentBC command = new AccountReceivableAgentBCImpl();
		try {
			begin();
			command.manageAgentCollectionListBasic(event.getManageAgentCollectionListVOs(), account);
			//Asa DTL update 2015-05-29
			if(event.getManageAgentCollectionListVOs().length > 0){
				command.updateASADtlForCall(event.getManageAgentCollectionListVOs()[0].getAsaNo(), account.getUsr_id()); 
			} 
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * STM_SAR_5901 : Retrieve
	 * Agent Collection Entry event<br>
	 * 
	 * @author YJLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAgentCollectionListPOPUP(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar5901Event event = (StmSar5901Event) e;
		AccountReceivableAgentBC command = new AccountReceivableAgentBCImpl();
		
	try {
			List<AgentCollectionListVO> list = command.searchAgentCollectionList(event.getAgentCollectionListVO(),account);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * STM_SAR_5004 : Retrieve
	 * Unreported OTS Report event<br>
	 * 
	 * @author YJLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnreportedOtsReportList(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar5004Event event = (StmSar5004Event) e;
		AccountReceivableAgentBC command = new AccountReceivableAgentBCImpl();
		
	try {
			List<UnreportedOtsReportVO> list = command.searchUnreportedOtsReportList(event.getUnreportedOtsReportVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * STM_SAR_5003 : Retrieve
	 * Agent Statement of Account Inquiry event<br>
	 * 
	 * @author YJLEE
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchASAInquiryList(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar5003Event event = (StmSar5003Event) e;
		AccountReceivableAgentBC command = new AccountReceivableAgentBCImpl();
		
	try {
			List<ASAInquiryListVO> list = command.searchASAInquiryList(event.getASAInquiryListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
		
	/**
	 * init NewASA
	 * @author jinyoonoh 2014. 5. 12. 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse newASA(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar5002Event event = (StmSar5002Event) e;
		// command
		AccountReceivableAgentBC command = new AccountReceivableAgentBCImpl();		
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try {
			
			ASAInfoByOfcAgnVO paramVO = event.getAsaInfoByOfcAgnVO();
			paramVO.setUserId(account.getUsr_id());
			
			// ------------------------------------------------
			// 1. check ASA open
			// ------------------------------------------------
			paramVO.setOpenAsaYn("Y");			
			ASAInfoByOfcAgnVO asaOpen = command.searchASAInfoByOfcAgn(paramVO, account.getOfc_cd());			
			if (asaOpen != null) {
				int cnt = Integer.parseInt(asaOpen.getCntAsaNo());	
				//opened ASA NO can only be a maximum of two
				if (cnt == 2)  {
					eventResponse.setETCData("ERROR", "SAR00033");
					eventResponse.setUserMessage("Closed already opened ASA!");
					return eventResponse;
				}
			}
			
			// ------------------------------------------------
			// 2. get ASA info
			// ------------------------------------------------
			paramVO.setOpenAsaYn("N");			
			ASAInfoByOfcAgnVO asaInfo = command.searchASAInfoByOfcAgn(paramVO, account.getOfc_cd());	
			eventResponse.setRsVo(asaInfo);
		
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}		
	
	/**
	 * Create new ASA
	 * @author jinyoonoh 2014. 5. 12. 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse createASA(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar5002Event event = (StmSar5002Event) e;
		// command
		AccountReceivableAgentBC command = new AccountReceivableAgentBCImpl();		
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try {
			begin();
			ASAInfoByOfcAgnVO paramVO = event.getAsaInfoByOfcAgnVO();
			
			 
			// ------------------------------------------------
			// check ASA period
			// ------------------------------------------------
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			Date sDate = formatter.parse(paramVO.getAsaPrdFmDt()); // 시작일
																	// (Date타입)
			Date toDate = formatter.parse(paramVO.getAsaPrdToDt()); // 오늘날짜
																	// (Date타입)
			Calendar csDate = Calendar.getInstance();
			csDate.setTime(sDate);
			Calendar ctoDate = Calendar.getInstance();
			ctoDate.setTime(toDate);

			if (csDate.compareTo(ctoDate) > 0) {
				String errMsg = new ErrorHandler("COM12133", new String[] {"To date", "From date", "greater"}).getMessage();
				eventResponse.setETCData("ERROR", "COM12133");
				eventResponse.setUserMessage(errMsg);
				return eventResponse;
			}
			
			
			// ------------------------------------------------
			// check ASA open
			// ------------------------------------------------
			paramVO.setOpenAsaYn("Y");
			ASAInfoByOfcAgnVO asaOpen = command.searchASAInfoByOfcAgn(paramVO, account.getOfc_cd());		
			//opened ASA NO can only be a maximum of two
			if (asaOpen != null) {
				int cnt = Integer.parseInt(asaOpen.getCntAsaNo());				
				if (cnt == 2)  {
					eventResponse.setETCData("ERROR", "SAR00033");
					eventResponse.setUserMessage("Closed already opened ASA!");
					return eventResponse;
				}
			}
			
			// ------------------------------------------------
			// create ASA
			// ------------------------------------------------
			SarAsaMstVO paramSarAsaMstVO = new SarAsaMstVO();
			paramSarAsaMstVO.setAgnCd(paramVO.getAgnCd());
			paramSarAsaMstVO.setOfcCd(paramVO.getOfcCd());			
			paramSarAsaMstVO.setCurrCd(paramVO.getCurrCd());//input currency
			paramSarAsaMstVO.setCreUsrId(account.getUsr_id());
			paramSarAsaMstVO.setUpdUsrId(account.getUsr_id());
			paramSarAsaMstVO.setAsaPrdFmDt(paramVO.getAsaPrdFmDt());
			paramSarAsaMstVO.setAsaPrdToDt(paramVO.getAsaPrdToDt());	
			// Create ASA
			eventResponse.setRsVo(command.createASA(paramSarAsaMstVO, account.getOfc_cd()));
			
			eventResponse.setUserMessage(new ErrorHandler("SAR00004", new String[] {}).getUserMessage());
			
			commit();			
			return eventResponse;
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}			
	
		
	/**
	 * search ASA
	 * udpate ASA Detail => select ASA Detail 
	 * @author jinyoonoh 2014. 5. 12. 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchASA(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar5002Event event = (StmSar5002Event) e;
		// command
		AccountReceivableAgentBC command = new AccountReceivableAgentBCImpl();		
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try {
			begin();
	
			ASAInfoByOfcAgnVO paramVO = event.getAsaInfoByOfcAgnVO();
			
			String asaNo = paramVO.getAsaNo();//ASA No.
			
			if(StringUtils.isEmpty(asaNo)) {
				// ---------------------------------	---------------
				// get max ASA no
				// ------------------------------------------------
				paramVO.setOpenAsaYn("N");
				ASAInfoByOfcAgnVO asaInfo = command.searchASAInfoByOfcAgn(paramVO, account.getOfc_cd());				
				asaNo = asaInfo.getMaxAsaNo();				
			}
		
			if (StringUtils.isEmpty(asaNo)) {
				eventResponse.setRsVo(null);
				eventResponse.setRsVoList(null);				
				return eventResponse;
			}
			
			// ------------------------------------------------
			// get ASA master
			// ------------------------------------------------
			SarAsaMstVO paramSarAsaMstVO = new SarAsaMstVO();
			paramSarAsaMstVO.setAsaNo(asaNo);
			SarAsaMstVO sarAsaMstVO = command.searchASAMst(paramSarAsaMstVO);
			
			if (sarAsaMstVO == null) {
				eventResponse.setRsVo(null);
				eventResponse.setRsVoList(null);
				return eventResponse;
			}
			
			// ------------------------------------------------
			// Update ASA Detail(Only ASA Status is Open)
			// ------------------------------------------------
			
			//command.updateASADtl(asaNo, account.getUsr_id());			
			SarAsaMstVO sarAsaMstVO2 = command.searchASAMst(paramSarAsaMstVO);
			eventResponse.setRsVo(sarAsaMstVO2);
			// ------------------------------------------------
			// get ASA Detail
			// ------------------------------------------------
			SarAsaDtlVO paramSarAsaDtlVO = new SarAsaDtlVO();
			paramSarAsaDtlVO.setAsaNo(asaNo);			
			List<SarAsaDtlVO> asaDtlList = command.searchASADtl(paramSarAsaDtlVO);
			eventResponse.setRsVoList(asaDtlList);
			commit();
			return eventResponse;
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}		
	
		
		
	/**
	 * finish ASA 
	 * udpate ASA Detail => master upate => select ASA Detail 
	 * @author jinyoonoh 2014. 5. 12. 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse finishASA(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar5002Event event = (StmSar5002Event) e;
		// command
		AccountReceivableAgentBC command = new AccountReceivableAgentBCImpl();	
		AccountPayableInvoiceBC apcommand = new AccountPayableInvoiceBCImpl();
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		String noInterfaceCount = "";
		
		try {
			
			begin();
			ASAInfoByOfcAgnVO paramVO = event.getAsaInfoByOfcAgnVO();		
			String asaNo = paramVO.getAsaNo();//ASA No.
			
			
			// ------------------------------------------------
			// Update ASA To Date (원본과 비교후 다르면 업데이트)
			// ------------------------------------------------
			SarAsaMstVO paramAsaMstVO = new SarAsaMstVO();
			paramAsaMstVO.setAsaNo(asaNo);
			SarAsaMstVO orgAsaMstVO = command.searchASAMst(paramAsaMstVO);
			if(!(paramVO.getAsaPrdToDt().equals(orgAsaMstVO.getAsaPrdToDt()))) {
				paramAsaMstVO.setAsaPrdToDt(paramVO.getAsaPrdToDt());
				command.modifyASAMst(paramAsaMstVO);
			}
			
			// check office limit ots amount
			if (!command.checkUnreportedAmount(asaNo)) {
				//msgs['SAR00036'] = 'Please Check Overdue Unreported OTS';
				eventResponse.setETCData("ERROR", "SAR00036");
				return eventResponse;
			}
			
			// Before finish, Exists no interface with ASA Invoice in SAP module
			noInterfaceCount = apcommand.searchASAInvoiceUnInterfaceCheck(asaNo);
			if(Integer.parseInt(noInterfaceCount) > 0) {
				//msgs['SAR00068'] = 'You cannot finish this ASA No. Because there are no interface with this ASA in SAP module.';
				eventResponse.setETCData("ERROR", "SAR00068");
				return eventResponse;
			}
			
			String dupBLList = command.searchDuplicateColRfnd(asaNo);
			
			if(!("").equals(dupBLList)) {
				eventResponse.setETCData("ERROR", "SAR00069");
				eventResponse.setETCData("ERROR_MSG", "["+dupBLList+"]");
				return eventResponse;
			}
			
			// update master asa status finish			
			eventResponse.setRsVo(command.finishASA(asaNo, account.getUsr_id(), account.getOfc_cd()));
			eventResponse.setUserMessage(new ErrorHandler("SAR00004", new String[] {}).getUserMessage());
			commit();			
			return eventResponse;
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}		
	
	
	/**
	 * reopen ASA 
	 * udpate ASA Detail => master upate => select ASA Detail 
	 * @author jinyoonoh 2014. 5. 12. 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse reopenASA(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar5002Event event = (StmSar5002Event) e;
		// command
		AccountReceivableAgentBC command = new AccountReceivableAgentBCImpl();		
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try {
			begin();
			ASAInfoByOfcAgnVO paramVO = event.getAsaInfoByOfcAgnVO();		
			String asaNo = paramVO.getAsaNo();//ASA No.
			
			// update master asa status finish			
			eventResponse.setRsVo(command.reopenASA(asaNo, account.getUsr_id()));
			eventResponse.setUserMessage(new ErrorHandler("SAR00004", new String[] {}).getUserMessage());
			commit();			
			return eventResponse;
			
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	
	
	/**
	 * approve ASA 
	 * udpate ASA Detail => master upate => select ASA Detail 
	 * @author jinyoonoh 2014. 5. 12. 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse approveASA(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar5002Event event = (StmSar5002Event) e;
		// command
		AccountReceivableAgentBC command = new AccountReceivableAgentBCImpl();		
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try {
			ASAInfoByOfcAgnVO paramVO = event.getAsaInfoByOfcAgnVO();	
			String asaNo = paramVO.getAsaNo();//ASA No.	
			
			String batRsltCd = command.searchASAApprovalCheck(asaNo);
			 
			if(!"N".equals(batRsltCd)){
				eventResponse.setETCData("ERROR_STATUS", batRsltCd); 
				return eventResponse;
			}
			
			begin();
			String result = "";
			String batSeq = command.createApproveASABat(asaNo,account); 
			commit();
			log.error("ASA Approval Batch Sequence(After Creation):"+batSeq+"\n");
			
			begin();
			// ------------------------------------------------
			// Update ASA To Date (원본과 비교후 다르면 업데이트)
			// ------------------------------------------------
			SarAsaMstVO paramAsaMstVO = new SarAsaMstVO();
			paramAsaMstVO.setAsaNo(asaNo);
			SarAsaMstVO orgAsaMstVO = command.searchASAMst(paramAsaMstVO);
			if(!(paramVO.getAsaPrdToDt().equals(orgAsaMstVO.getAsaPrdToDt()))) {
				paramAsaMstVO.setAsaPrdToDt(paramVO.getAsaPrdToDt());
				command.modifyASAMst(paramAsaMstVO);
			}
			commit();
			
			
			if(!batSeq.equals("")){
				//check batch status
				String pgmNo = "STM_SAR_B5002";
				String batStsCd = command.searchBatStsCd(pgmNo);
				
				if("S".equals(batStsCd)){
					//call batch
					result = command.approveASABat(batSeq);					
			    }else if("R".equals(batStsCd)){	// Running
					begin();
					// sco_bat_his 에 E로 업데이트
					command.manageCancelASABat(batSeq, account);
					eventResponse.setETCData("batStsCd", batStsCd); 
					commit();		
				}
				
			}
			eventResponse.setETCData("BackEndJobKey", result);
			return eventResponse;
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	
	
	/**
	 * STM_SAR_5002 : checkASAperiod
	 * Agent Statement of Account Entry check period<br>
	 * 
	 * @author myoungsin park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkASAperiod(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		StmSar5002Event event = (StmSar5002Event) e;
		// command
		AccountReceivableAgentBC command = new AccountReceivableAgentBCImpl();	
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
	try {
			CheckASAperiodVO checkASAperiodVO = command.searchASAperiod(event.getAsaInfoByOfcAgnVO());
			
			String validResult = "N";
			if(checkASAperiodVO.getNewEffDt().equals(event.getAsaInfoByOfcAgnVO().getAsaPrdToDt().replaceAll("-", ""))){
				validResult = "Y";
			}
			eventResponse.setETCData("valid_result", validResult); 
			eventResponse.setETCData("new_eff_dt", checkASAperiodVO.getNewEffDt());
			
			// ------------------------------------------------
			// 2. get ASA info
			// ------------------------------------------------
			ASAInfoByOfcAgnVO paramVO = new ASAInfoByOfcAgnVO();
			paramVO.setOfcCd(event.getAsaInfoByOfcAgnVO().getOfcCd());
			paramVO.setAgnCd(event.getAsaInfoByOfcAgnVO().getAgnCd());
			paramVO.setCurrCd(event.getAsaInfoByOfcAgnVO().getCurrCd());
			paramVO.setOpenAsaYn("N");			
			ASAInfoByOfcAgnVO asaInfo = command.searchASAInfoByOfcAgn(paramVO, account.getOfc_cd());	
			eventResponse.setRsVo(asaInfo);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * STM_SAR_5002 : checkASAperiod
	 * Agent Statement of Account Entry check pre asa status<br>
	 * 
	 * @author myoungsin park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse checkPreASAStatus(Event e) throws EventException {
		
		// PDTO(Data Transfer Object including Parameters)
		StmSar5002Event event = (StmSar5002Event) e;
		// command
		AccountReceivableAgentBC command = new AccountReceivableAgentBCImpl();	
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();	
		try {
			CheckPreASAStausVO checkPreASAStausVO = command.checkPreASAStatus(event.getAsaInfoByOfcAgnVO());
			eventResponse.setETCData("previous_asa_status", checkPreASAStausVO.getPreviousAsaStatus());
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Secast BackEndJobKey status<br>
	 * 
	 * @author myoungsin park
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIfBackEndJobStatus(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AccountReceivableAgentBC command = new AccountReceivableAgentBCImpl();	
		
		StmSar5002Event event = (StmSar5002Event) e;
		try {

			ASAInfoByOfcAgnVO paramVO = event.getAsaInfoByOfcAgnVO();	
			if (paramVO != null) {
				String backEndJobKey = paramVO.getBackendjobKey();
				
				BatHisVO batHisVO = command.searchBatHisStatus(backEndJobKey);
				if(batHisVO == null){
					eventResponse.setETCData("jb_sts_flg", "4");
				} else {
					if(batHisVO.getBatRsltCd().equals("W") || batHisVO.getBatRsltCd().equals("B")){
						eventResponse.setETCData("jb_sts_flg", "1");
					} else if(batHisVO.getBatRsltCd().equals("S")){
						eventResponse.setETCData("jb_sts_flg", "3");
					} else if(batHisVO.getBatRsltCd().equals("E")){
						eventResponse.setETCData("jb_sts_flg", "4");
					}
				}
			} else {
				eventResponse.setETCData("jb_sts_flg", "4");
			}
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("SCO00003",
					new String[] {}).getMessage());
		}
		return eventResponse;
	}
	
}