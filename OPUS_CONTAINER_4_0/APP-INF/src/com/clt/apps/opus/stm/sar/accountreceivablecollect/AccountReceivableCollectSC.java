/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableCollectSC.java
 *@FileTitle : 
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
package com.clt.apps.opus.stm.sar.accountreceivablecollect;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.clt.apps.opus.stm.sap.accountpayableinvoice.AccountPayableInvoiceSC;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.basic.AccountPayableInvoiceBC;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.basic.AccountPayableInvoiceBCImpl;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.SapInvoiceInterfaceDetailVO;
import com.clt.apps.opus.stm.sap.accountpayableinvoice.accountpayableinvoice.vo.SapInvoiceInterfaceHeaderVO;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.basic.AccountReceivableAgentBC;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.basic.AccountReceivableAgentBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.BatHisVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.basic.AccountReceivableAdjustBC;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.basic.AccountReceivableAdjustBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.event.StmSar0241Event;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.event.StmSar0242Event;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.event.StmSar3001Event;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.event.StmSar3002Event;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.event.StmSar3003Event;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.event.StmSar3004Event;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjViewAccountingListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustDtlListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustHdrListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AdjustNoSeqVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.ApIfSetVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AutoSettlementInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AutoSettlementSubInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.AutosettlementCondVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.OffsetAPPopupListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.OffsetARPopupListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.OffsetInfoVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.OtsTypeExcludeListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.SapInvIfDtlVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.SapInvIfHdrVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivableadjust.vo.SarAcctMtxVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.basic.AccountReceivableCollectIFBC;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablecollectif.basic.AccountReceivableCollectIFBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.basic.AccountReceivableReceiptBC;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.basic.AccountReceivableReceiptBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event.StmSar0011Event;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event.StmSar0014Event;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event.StmSar2001Event;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event.StmSar2002Event;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event.StmSar2003Event;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event.StmSar2004Event;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.event.StmSar2005Event;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.integration.AccountReceivableReceiptDBDAO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyDetailVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ApplyHeaderVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.RCTViewAccountingListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByBankDateVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByBankVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByChequeVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptListByDetailVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptMainVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.ReceiptUserListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecollect.accountreceivablereceipt.vo.UnapplyReceiptListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.basic.AccountReceivableCommonBC;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.basic.AccountReceivableCommonBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.ARExrateVO;
import com.clt.apps.opus.stm.sar.accountreceivablecommon.accountreceivablecommon.vo.CurrencyCodeVO;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBC;
import com.clt.apps.opus.stm.sar.accountreceivableoutstanding.accountreceivableoutstanding.basic.AccountReceivableOutstandingBCImpl;
import com.clt.framework.component.backend.support.BackEndJobMetaDataSelector;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.component.rowset.DBRowSet;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.SarAsaMstVO;
import com.clt.syscommon.common.table.SarOffstMstVO;

/**
 * AccountReceivableCollect Business Logic ServiceCommand 
 * - Handling AccountReceivableCollect Business transaction.
 * 
 * @author 
 * @see AccountReceivableReceiptDBDAO
 * @since J2EE 1.6
 */ 

public class AccountReceivableCollectSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Precede AccountReceivableCollect system <br>
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
	 * Follow AccountReceivableCollect system<br>
	 * Release Object when STM_SAR job end<br>
	 */
	public void doEnd() {
		log.debug("AccountReceivableCollectSC End");
	}

	/**
	 * proceeding job each Even<br>
	 *  Handling every Event on  AccountReceivableCollect system<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		if (e.getEventName().equalsIgnoreCase("StmSar0014Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReceiptUserList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSar2001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReceiptInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOTSHeaderForApply(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchOTSChargeForApply(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchOpenASAList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageReceipt(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {
				eventResponse = searchOutstandingReceiptTempInfo(e);
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH05)) {
				eventResponse = searchReceiptBackEndJobStatus(e);	
			} else if (e.getFormCommand().isCommand(FormCommand.SEARCH06)) {
				eventResponse = searchReceiptBackEndJobFile(e);	
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSar0011Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchUnapplyReceiptList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSar0241Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOffsetARPopupList(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("StmSar0242Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOffsetAPPopupList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSar2004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReceiptListByBank(e); 
			}
		}  else if (e.getEventName().equalsIgnoreCase("StmSar0161Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOtsTypeExcludeList(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("StmSar2002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReceiptListByDetail(e);
			}
		}  else if (e.getEventName().equalsIgnoreCase("StmSar3002Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchOffsetList(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = manageOffset(e);
			} else if (e.getFormCommand().isCommand(FormCommand.MODIFY)) {
				eventResponse = reverseOffset(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("StmSar2003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchReceiptListByCheque(e); 
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSar3001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAdjustList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchOtsAdjustList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = modifyAdjustInfo(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {
				eventResponse = modifyAdjustInfoRvs(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLegrXchRtList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) {
				eventResponse = searchAsaNoList(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSar3003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchAutoSettlementList(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {
				eventResponse = searchAutosettlementSetupDate(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				eventResponse = createAutoSettlementBat(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH04)) {  
			    eventResponse = searchIfBackEndJobStatus(e);   
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSar3004Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchAdjViewAccountingList(e);			
			}
		} else if (e.getEventName().equalsIgnoreCase("StmSar2005Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST)) {
				eventResponse = searchRCTViewAccountingList(e);			
			}			
		}	 	 		
		
		

		return eventResponse;
	}

	/**
	 * Retrieve Invoice Remark(s) event<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceiptUserList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar0014Event event = (StmSar0014Event) e;
		AccountReceivableReceiptBC command = new AccountReceivableReceiptBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ReceiptUserListVO> list = command.searchReceiptUserList(event.getReceiptUserListConditionVO());
			eventResponse.setRsVoList(list);       
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Search OTS Header by B/L No, Invoice No <br>
	 * 
	 * @author SungYong Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOTSHeaderForApply(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar2001Event event = (StmSar2001Event) e;
		AccountReceivableReceiptBC command = new AccountReceivableReceiptBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ApplyHeaderVO> applyHeaderVO = command.searchOTSHeaderForApply(event.getApplyListCondVO());
			
			eventResponse.setRsVoList(applyHeaderVO);
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Search OTS Charge by B/L No, Invoice No <br>
	 * 
	 * @author SungYong Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOTSChargeForApply(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar2001Event event = (StmSar2001Event) e;
		AccountReceivableReceiptBC command = new AccountReceivableReceiptBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ApplyDetailVO> applyDetailVO = command.searchOTSChargeForApply(event.getApplyListCondVO());
			
			eventResponse.setRsVoList(applyDetailVO);
			
			if(applyDetailVO.size() > 0) eventResponse.setETCData("ttl_aply_amt", applyDetailVO.get(0).getTtlAplyAmt());
			else eventResponse.setETCData("ttl_aply_amt", "0");
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Search Unapply Receipt List <br>
	 * 
	 * @author SungYong Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchUnapplyReceiptList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar0011Event event = (StmSar0011Event) e;
		AccountReceivableReceiptBC command = new AccountReceivableReceiptBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<UnapplyReceiptListVO> unapplyReceiptListVO = command.searchUnapplyReceiptList(event.getUnapplyReceiptCondVO());
			
			eventResponse.setRsVoList(unapplyReceiptListVO);
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Search Receipt Info<br>
	 * 
	 * @author SungYong Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceiptInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar2001Event event = (StmSar2001Event) e;
		AccountReceivableReceiptBC command = new AccountReceivableReceiptBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			
			ReceiptMainVO receiptMainVO = command.searchReceiptMain(event.getRctOfcCd(), event.getRctNo());
			List<ApplyHeaderVO> applyHeaderVO = command.searchApplyHeader(event.getRctOfcCd(), event.getRctNo());
			List<ApplyDetailVO> applyDetailVO = command.searchApplyDetail(event.getRctOfcCd(), event.getRctNo());
			
			String ttlAplyAmt = command.searchApplyTotalAmount(event.getRctOfcCd(), event.getRctNo());
			
			if(receiptMainVO != null){
				eventResponse.setETCData(receiptMainVO.getColumnValues());
				eventResponse.setRsVoList(applyHeaderVO);
				eventResponse.setRsVoList(applyDetailVO);
				eventResponse.setETCData("ttl_aply_amt", ttlAplyAmt);
				
			} else {
				eventResponse.setUserMessage(new ErrorHandler("COM12198").getUserMessage());
			}
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Save Receipt Info<br>
	 * 
	 * @author SungYong Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageReceipt(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar2001Event event = (StmSar2001Event) e;
		AccountReceivableReceiptBC command = new AccountReceivableReceiptBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			
			begin();
			String backEndJobKey = command.manageReceipt(event.getReceiptMainVO(), event.getApplyHeaderVOs(), event.getApplyDetailVOs(), account.getUsr_id(), account.getOfc_cd());
			eventResponse.setETCData("BackEndJobKey", backEndJobKey);
			commit();	
		
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage()); 
		}
		
		return eventResponse;
	}

	/**
	 * searchReceiptListByBankDate <br>
	 * 
	 * @author SHIN
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceiptListByBank(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar2004Event event = (StmSar2004Event) e;
		AccountReceivableReceiptBC command = new AccountReceivableReceiptBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ReceiptListByBankDateVO> list1 = command.searchReceiptListByBankDate(event.getReceiptListByBankConditionVO());
			List<ReceiptListByBankVO> list2 = command.searchReceiptListByBank(event.getReceiptListByBankConditionVO());
			eventResponse.setRsVoList(list1);       
			eventResponse.setRsVoList(list2);
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}		

	/**
	 * searchReceiptListByCheque <br>
	 * 
	 * @author SHIN
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceiptListByCheque(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar2003Event event = (StmSar2003Event) e;
		AccountReceivableReceiptBC command = new AccountReceivableReceiptBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<ReceiptListByChequeVO> list = command.searchReceiptListByCheque(event.getReceiptListByChequeCondVO());
			eventResponse.setRsVoList(list);       
			
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}				
	
	/**
	 * Retrieve Invoice Remark(s) event<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOtsTypeExcludeList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		//StmSar0161Event event = (StmSar0161Event) e;
		
		AccountReceivableAdjustBC command = new AccountReceivableAdjustBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<OtsTypeExcludeListVO> list = command.searchOtsTypeExcludeList();
			eventResponse.setRsVoList(list);       
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}

	
	
	
	
	
	/**
	 * AP Search Popup
	 * @author jinyoonoh 2014. 4. 7. 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchOffsetAPPopupList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar0242Event event = (StmSar0242Event) e;
		AccountReceivableAdjustBC command = new AccountReceivableAdjustBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<OffsetAPPopupListVO> invListVOs = command.searchOffsetAPPopupList(event.getOffsetAPPopupListVO());	
			
			// ExRates obtained
			AccountReceivableCommonBC commonBC = new AccountReceivableCommonBCImpl();
					
			for (OffsetAPPopupListVO vo : invListVOs) {
				ARExrateVO rateVO = new ARExrateVO();				
				rateVO.setChgCurrCd(vo.getInvCurrCd());
				rateVO.setLclCurrCd(event.getOffsetAPPopupListVO().getOffstCurrCd());
				
				String exRate = "0.00";
				
				if (vo.getInvCurrCd().equals(vo.getOffstCurrCd())) {
					exRate = "1.00";
				} else  {					
					rateVO.setXchRtDt(vo.getGlDt());
					exRate = commonBC.searchAccountExrate(rateVO);	
					if (StringUtils.isEmpty(exRate)) {
						exRate = "0.00";
					}
				}
				
				vo.setApXchRt(exRate);
			}			
			
			
			eventResponse.setRsVoList(invListVOs);
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	
	
	
	/**
	 * AR Search Popup
	 * @author jinyoonoh 2014. 4. 7. 
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchOffsetARPopupList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar0241Event event = (StmSar0241Event) e;
		AccountReceivableAdjustBC command = new AccountReceivableAdjustBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<OffsetARPopupListVO> invListVOs = 
					command.searchOffsetARPopupList(event.getArOfficeListVO(),  event.getOffsetARPopupListVO());			
			
			// ExRates obtained
			//AccountReceivableCommonBC commonBC = new AccountReceivableCommonBCImpl();
			
			
			/*for (OffsetARPopupListVO vo : invListVOs) {
				String xchRtTpCd = vo.getXchRtTpCd();
				ARExrateVO rateVO = new ARExrateVO();
				rateVO.setChgCurrCd(vo.getBlCurrCd());
				rateVO.setLclCurrCd(vo.getOffstCurrCd());
				rateVO.setXchRtTpCd(vo.getXchRtTpCd());				
				rateVO.setXchRtDt(vo.getGlDt());				
				rateVO.setVslCd(vo.getVslCd());
				rateVO.setSkdVoyNo(vo.getSkdVoyNo());
				rateVO.setSkdDirCd(vo.getDirCd());
				rateVO.setSvcScpCd(vo.getSvcScpCd());
				rateVO.setIoBndCd(vo.getBkgIoBndCd());
				rateVO.setPolCd(vo.getPolCd());
				rateVO.setPodCd(vo.getPodCd());
				rateVO.setInvCustCntCd(vo.getBilToCustCntCd());
				rateVO.setInvCustSeq(vo.getBilToCustSeq());
				rateVO.setRvsFlg("N");
				
				String exRate = "0.00";
				
				if (vo.getBlCurrCd().equals(vo.getOffstCurrCd())) {
					exRate = "1.00";
				} else  {
					if (xchRtTpCd.equals("V")) {					
						exRate = commonBC.searchVVDExrate(rateVO);
					} else if (xchRtTpCd.equals("I")) {					
						exRate = commonBC.searchIndExrate(rateVO);
					} else if (xchRtTpCd.equals("D")) {
						exRate = commonBC.searchDailyExrate(rateVO);
					} else if (xchRtTpCd.equals("A")) {
						exRate = commonBC.searchAccountExrate(rateVO);
					} else {
						exRate = commonBC.searchAccountExrate(rateVO);
					}
					
					// if  exRate empty then set account rate
					// max(sar_ots_chg.gl_dt) 
					if (StringUtils.isEmpty(exRate)) {
						exRate = commonBC.searchAccountExrate(rateVO);
					}					
				}
				
				vo.setArXchRt(exRate);  
			}
			*/
			
			eventResponse.setRsVoList(invListVOs);
						
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}		
	
	
	/**
	 * Save SAR offset mster<br>
	 * 
	 * @author jinyoonoh 2014. 4. 17.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOffset(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar3002Event event = (StmSar3002Event) e;
		AccountReceivableAdjustBC command = new AccountReceivableAdjustBCImpl();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AccountPayableInvoiceSC commandAp = new AccountPayableInvoiceSC();
		
		try {
			begin();
			OffsetInfoVO offsetInfoVO = event.getOffsetInfoCondVO();
			// sheet parameter
			OffsetInfoVO[] vos =  event.getOffsetInfoVOs();
			
			if (vos == null || vos.length == 0) {
				return eventResponse;
			}
	
			List<SarOffstMstVO> offstList = new ArrayList<SarOffstMstVO>();
			
			// OFF, OFFC
			String adjTpCd = "OFF";
			String apOfcCd = "";
			
			// Data edit process
			for (int i = 0; i < vos.length; i++) {				
				OffsetInfoVO param = vos[i]; 
				
				SarOffstMstVO vo = new SarOffstMstVO();
				
				if ("AP".equals(param.getOffstTpCd())) {
					vo.setBilToCntCd("");
					vo.setBilToCustSeq("");
					vo.setVndrNo(param.getVndrNo());
					vo.setApInvNo(param.getApInvNo());
					if(apOfcCd.equals("")){
						apOfcCd = param.getOfcCd();
					}
				} else if ("AR".equals(param.getOffstTpCd())) {
					vo.setRhqCd(param.getRhqCd());
					vo.setBilToCntCd(param.getBilToCntCd());
					vo.setBilToCustSeq(param.getBilToCustSeq());
					vo.setVndrNo("");
					vo.setApInvNo("");
					vo.setBlNo(param.getBlNo());
					vo.setInvNo(param.getInvNo());		
					vo.setChgTpCd(param.getChgTpCd());
					vo.setMaxArIfNo(param.getMaxArIfNo());
					
					if (!"OFFC".equals(adjTpCd) && 
							!param.getCurrCd().equals(param.getOffstCurrCd())) {
						adjTpCd = "OFFC";
					} 
					
				}
				
				// AR, AP common setting value
				
				vo.setOtsOfcCd(param.getOtsOfcCd());
				vo.setOfcCd(param.getOfcCd());
				vo.setOffstCurrCd(param.getOffstCurrCd());
				vo.setOffstTpCd(param.getOffstTpCd());
				vo.setCurrCd(param.getCurrCd());
				
				vo.setOtsBalAmt(param.getOtsBalAmt());
				vo.setOffstAmt(param.getOffstAmt());
				vo.setOffstXchRt(param.getOffstXchRt());
				vo.setOffstXchAmt(param.getOffstXchAmt());
				vo.setOffstOfcCd(offsetInfoVO.getOffstOfcCd());
				vo.setGlDt(param.getGlDt());
				
				vo.setCreUsrId(account.getUsr_id());
				vo.setUpdUsrId(account.getUsr_id());
				vo.setApInvTermDt(param.getApDuDt().replaceAll("-", ""));
				vo.setApRmk(param.getApRemark());
				offstList.add(vo);
				
			}
			
			
			// --------------------------------------
			// update OFFSET
			// --------------------------------------
			String arOffstNo = command.manageOffset(offstList, adjTpCd);
			eventResponse.setETCData("ar_offst_no", arOffstNo);
			eventResponse.setUserMessage(new ErrorHandler("SAR00004", new String[] {}).getUserMessage());	
			
			// --------------------------------------
			// transfer AP OFFSET 
			// --------------------------------------
			
			List<SapInvoiceInterfaceHeaderVO> apValidationVO = new ArrayList<SapInvoiceInterfaceHeaderVO>();
			
			// Processing AP IF......			 
			List<SapInvoiceInterfaceHeaderVO>  returnApIfVO = 
					 manageApIf(apOfcCd,arOffstNo, adjTpCd, "N", account.getUsr_id(), vos[0].getOffstCurrCd(), "OFF", arOffstNo);
			
			for(int n=0; n<returnApIfVO.size(); n++){
				apValidationVO.add(returnApIfVO.get(n));
			}
		
			// retrieve saved offset
			OffsetInfoVO  offsetInfoCondVO = new OffsetInfoVO();
			offsetInfoCondVO.setArOffstNo(arOffstNo);	
			offsetInfoCondVO.setOffstOfcCd(offsetInfoVO.getOffstOfcCd());	
			
			List<OffsetInfoVO> offsetList = command.searchOffsetList(offsetInfoCondVO);
			eventResponse.setRsVoList(offsetList);			
			
			if(apValidationVO.size() > 0){
				// Processing AP IF Validation...... 
				for(int i = 0; i < apValidationVO.size(); i++){
					EventResponse apEventResponse = new GeneralEventResponse();					
					apEventResponse = commandAp.manageSapIfValidateImportCheck("A/P", apValidationVO.get(i).getInvNo(), account.getUsr_id());
					Map<String, String> mapVO = apEventResponse.getETCData();					
					if( "FAIL".equals(mapVO.get("SUCCESS_FLG")) ){
						throw new EventException(new ErrorHandler("SAR00041", new String[]{mapVO.get("RESULT_MSG")}).getMessage());
					}
				}
			} 
			eventResponse.setUserMessage(new ErrorHandler("SAR00004", new String[] {}).getUserMessage());
			commit();
			return eventResponse;
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	
	
	/**
	 * reverse SAR offset master<br>
	 * 
	 * @author jinyoonoh 2014. 4. 17.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse reverseOffset(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar3002Event event = (StmSar3002Event) e;
		AccountReceivableAdjustBC command = new AccountReceivableAdjustBCImpl();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AccountPayableInvoiceSC commandAp = new AccountPayableInvoiceSC();
		
		try {
			begin();
			// form parameter
			OffsetInfoVO formVO = event.getOffsetInfoCondVO();
			
			// --------------------------------------
			// update OFFSET
			// --------------------------------------
			SarOffstMstVO paramVO = new SarOffstMstVO();
			paramVO.setArOffstNo(formVO.getArOffstNo());
			paramVO.setCreUsrId(account.getUsr_id());
			paramVO.setUpdUsrId(account.getUsr_id());
			paramVO.setOfcCd(formVO.getOffstOfcCd());
			
			String arOffstNo = command.reverseOffset(paramVO);
			eventResponse.setETCData("ar_offst_no", arOffstNo);
			eventResponse.setUserMessage(new ErrorHandler("SAR00004", new String[] {}).getUserMessage());	
			
			// retrieve saved offset
			OffsetInfoVO  offsetInfoCondVO = new OffsetInfoVO();
			offsetInfoCondVO.setArOffstNo(arOffstNo);
			offsetInfoCondVO.setOffstOfcCd(formVO.getOffstOfcCd());
			List<OffsetInfoVO> offsetList = command.searchOffsetList(offsetInfoCondVO);
			eventResponse.setRsVoList(offsetList);
			
		
			if (offsetList == null || offsetList.isEmpty()) {
				return eventResponse;
			}
				
			String offstCurrCd = "";
			String apOfcCd = "";
			
			
			String adjTpCd = "OFF"; //OFF, OFFC
			for (OffsetInfoVO offsetInfoVO : offsetList) {
				if ("AP".equals(offsetInfoVO.getOffstTpCd())) {
					offstCurrCd = offsetInfoVO.getOffstCurrCd();
					apOfcCd = offsetInfoVO.getOfcCd();
					break;
				} else {					
					if (!"OFFC".equals(adjTpCd) && 
							!offsetInfoVO.getCurrCd().equals(offsetInfoVO.getOffstCurrCd())) {
						adjTpCd = "OFFC";
					} 
				}
			}  
			
			// Processing AP IF......
			List<SapInvoiceInterfaceHeaderVO> apValidationVO = new ArrayList<SapInvoiceInterfaceHeaderVO>();
			List<SapInvoiceInterfaceHeaderVO>  returnApIfVO = 
					 manageApIf(apOfcCd,arOffstNo, adjTpCd, "Y", account.getUsr_id(), offstCurrCd, "OFF", arOffstNo);
			
			for(int n=0; n<returnApIfVO.size(); n++){
				apValidationVO.add(returnApIfVO.get(n));
			}
			
			if(apValidationVO.size() > 0){
				// Processing AP IF Validation...... 
				for(int i = 0; i < apValidationVO.size(); i++){
					EventResponse apEventResponse = new GeneralEventResponse();					
					apEventResponse = commandAp.manageSapIfValidateImportCheck("A/P", apValidationVO.get(i).getInvNo(), account.getUsr_id());
					Map<String, String> mapVO = apEventResponse.getETCData();					
					if( "FAIL".equals(mapVO.get("SUCCESS_FLG")) ){
						throw new EventException(new ErrorHandler("SAR00041", new String[]{mapVO.get("RESULT_MSG")}).getMessage());
					}
				}
			}			
			eventResponse.setUserMessage(new ErrorHandler("SAR00004", new String[] {}).getUserMessage());
			commit();			
			return eventResponse;
		} catch (EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	
	
	/**
	 * Save SAR offset mster<br>
	 * 
	 * @author jinyoonoh 2014. 4. 17.
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOffsetList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar3002Event event = (StmSar3002Event) e;
		AccountReceivableAdjustBC command = new AccountReceivableAdjustBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		try {
			List<OffsetInfoVO> list = 
					command.searchOffsetList(event.getOffsetInfoCondVO());
			eventResponse.setRsVoList(list);
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}

	/**
	 * STM_SAR_3001 : RETRIEVE<br>
	 * Retrieve Outstanding Adjustment <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAdjustList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSar3001Event event = (StmSar3001Event)e;
		AccountReceivableAdjustBC command = new AccountReceivableAdjustBCImpl();

		try{
			List<AdjustHdrListVO> hdrList = command.searchAdjustHdrList(event.getAdjustCondVO());
			List<AdjustDtlListVO> dtlList = command.searchAdjustDtlList(event.getAdjustCondVO());
			
			//2014.08.18 add adj_dt
			if(hdrList.size() > 0) eventResponse.setETCData("adj_dt", hdrList.get(0).getAdjDt());
			
			eventResponse.setRsVoList(hdrList);
			eventResponse.setRsVoList(dtlList);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * STM_SAR_3001 : RETRIEVE<br>
	 * Retrieve Outstanding Adjustment <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOtsAdjustList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSar3001Event event = (StmSar3001Event)e;
		AccountReceivableAdjustBC command = new AccountReceivableAdjustBCImpl();

		try{
			List<AdjustHdrListVO> hdrOtsList = command.searchOtsAdjustHdrList(event.getAdjustCondVO());
			List<AdjustDtlListVO> dtlOtsList = command.searchOtsAdjustDtlList(event.getAdjustCondVO());
			
			eventResponse.setRsVoList(hdrOtsList);
			eventResponse.setRsVoList(dtlOtsList);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * STM_SAR_3001 : save <br>
	 * save Outstanding Data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyAdjustInfo(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSar3001Event event = (StmSar3001Event) e;
		AccountReceivableAdjustBC command = new AccountReceivableAdjustBCImpl();
		AccountReceivableCommonBC commandCom = new AccountReceivableCommonBCImpl();
		AccountPayableInvoiceSC commandAp = new AccountPayableInvoiceSC();
		
		try {
			
			List<AdjustNoSeqVO> adjustNoSeqVOs = new ArrayList<AdjustNoSeqVO>();
			List<SapInvoiceInterfaceHeaderVO> returnApIfVO = new ArrayList<SapInvoiceInterfaceHeaderVO>();
			List<SapInvoiceInterfaceHeaderVO> apValidationVO = new ArrayList<SapInvoiceInterfaceHeaderVO>();
			
			String adjNoHdr = "";
			int cngAdjTpCdCnt = 0;
			
			AdjustCondVO adjustCondVO = event.getAdjustCondVO();
			String ofcCd = adjustCondVO.getAdjtOfcCd();
			String adjTjTpCd = adjustCondVO.getAdjTjTpCd();
			String adjTjTpKeyCd = adjustCondVO.getAdjTjTpKeyCd();
			
			String adjKeyNo = commandCom.searchAdjustReceiptNo(adjTjTpKeyCd, account.getOfc_cd(), account.getUsr_id(), account.getOfc_cd());
			
			String glDt = commandCom.searchEffectiveDate(adjustCondVO.getAdjDt(), ofcCd, "27");
			
			if(glDt == null || glDt.equals("") || !glDt.equals(adjustCondVO.getAdjDt().replaceAll("-", ""))){
				throw new EventException(new ErrorHandler("SAR00003",new String[]{"Adjust date"}).getMessage());
			}
			
			adjustCondVO.setGlDt(glDt);
			
			for(int i=0; i<event.getAdjustHdrListVOs().length; i++){
				AdjustNoSeqVO adjustNoSeqVO = new AdjustNoSeqVO();
				String adjSeq = command.searchAdjustSeqNo();
				adjustNoSeqVO.setOtsAdjSeq(adjSeq);
				
				begin();
				String adjNo = commandCom.searchAdjustReceiptNo(adjTjTpCd, ofcCd, account.getUsr_id(), account.getOfc_cd());
				commit();
				
				adjustNoSeqVO.setAdjKeyNo(adjKeyNo);
				adjustNoSeqVO.setAdjNo(adjNo);
				
				adjustNoSeqVOs.add(adjustNoSeqVO);
				
				if(i == 0){
					adjNoHdr = adjNo;					
				}else{
					adjNoHdr = adjNoHdr + "|" + adjNo;
				}
				event.getAdjustHdrListVOs()[i].setAdjNo(adjNo);
				
				for(int j=0; j<event.getAdjustDtlListVOs().length; j++){
					if( event.getAdjustHdrListVOs()[i].getOtsHdrKey().equals(event.getAdjustDtlListVOs()[j].getOtsDtlKey()) ){
						if( !"".equals(event.getAdjustHdrListVOs()[i].getPayAcctCd())
								&& !"".equals(event.getAdjustDtlListVOs()[j].getOtsAdjBalAmt())
								&& !event.getAdjustDtlListVOs()[j].getBlCurrCd().equals(event.getAdjustDtlListVOs()[j].getAdjCrsCurrCd()) ){
							cngAdjTpCdCnt++;
						}
					}
				}
				
				if(cngAdjTpCdCnt > 0){
					event.getAdjustHdrListVOs()[i].setChgAdjTpCd(event.getAdjustHdrListVOs()[i].getAdjTpCd()+"C");
					cngAdjTpCdCnt = 0;
				}else{
					event.getAdjustHdrListVOs()[i].setChgAdjTpCd(event.getAdjustHdrListVOs()[i].getAdjTpCd());
				}
			}
			begin();
			command.modifyAdjustList(event.getAdjustHdrListVOs(), event.getAdjustDtlListVOs(), event.getAdjustCondVO(), adjustNoSeqVOs, account.getUsr_id(), account.getOfc_cd());
			
			// Processing AP IF...... 
			for(int m=0; m<event.getAdjustHdrListVOs().length; m++){
				if( !"".equals(event.getAdjustHdrListVOs()[m].getPayAcctCd()) ){
					String attrCtnt1 = "";
					if(event.getAdjustCondVO().getOtsSmryCd().equals("BL")){
						//attrCtnt1 = event.getAdjustHdrListVOs()[m].getBlNo();
						attrCtnt1 = event.getAdjustHdrListVOs()[m].getAdjNo();
					} else {
						//attrCtnt1 = event.getAdjustHdrListVOs()[m].getInvNo();
						attrCtnt1 = event.getAdjustHdrListVOs()[m].getAdjNo();
					} 
					returnApIfVO = manageApIf(adjustCondVO.getApOfcCd(),adjustNoSeqVOs.get(m).getAdjNo(), event.getAdjustHdrListVOs()[m].getChgAdjTpCd(), event.getAdjustHdrListVOs()[m].getRvsFlg(), account.getUsr_id(), event.getAdjustHdrListVOs()[m].getApCurrCd(), "ADJ",attrCtnt1);
					
					for(int n=0; n<returnApIfVO.size(); n++){
						apValidationVO.add(returnApIfVO.get(n));
					}
				}else{
					eventResponse.setUserMessage(new ErrorHandler("SAR00004", new String[] {}).getUserMessage());
				}
			}
			
			if(apValidationVO.size() > 0){
				// Processing AP IF Validation...... 
				for(int z=0; z<apValidationVO.size(); z++){
					EventResponse apEventResponse = new GeneralEventResponse();
					
					apEventResponse = commandAp.manageSapIfValidateImportCheck("A/P", apValidationVO.get(z).getInvNo(), account.getUsr_id());
					Map<String, String> mapVO = apEventResponse.getETCData();
					
					if( "FAIL".equals(mapVO.get("SUCCESS_FLG")) ){
						throw new EventException(new ErrorHandler("SAR00041", new String[]{mapVO.get("RESULT_MSG")}).getMessage()); 
					}
				}
			}
			eventResponse.setUserMessage(new ErrorHandler("SAR00004", new String[] {}).getUserMessage());
			
			//SakuraIfData
			AccountReceivableCollectIFBC sakuraIfBC = new AccountReceivableCollectIFBCImpl();
			for (int j = 0; j < adjustNoSeqVOs.size(); j++) {
				sakuraIfBC.createAdjustSakuraIFdata(adjustNoSeqVOs.get(j).getAdjNo(),"P");
			}
			
			eventResponse.setETCData("adj_no_hdr", adjNoHdr);
			
			//ASA DTL UPDATE
			for(int i=0; i<event.getAdjustHdrListVOs().length; i++){  
				if(!event.getAdjustHdrListVOs()[i].getAsaNo().equals("") && event.getAdjustHdrListVOs()[i].getAsaNo() != null){
					AccountReceivableAgentBCImpl commandAgt = new AccountReceivableAgentBCImpl();
					commandAgt.updateASADtlForCall(event.getAdjustHdrListVOs()[i].getAsaNo(), account.getUsr_id());
				}
			}
			commit();
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * STM_SAR_3001 : Reverse <br>
	 * Reverse Outstanding Data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse modifyAdjustInfoRvs(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSar3001Event event = (StmSar3001Event) e;
		AccountReceivableAdjustBC command = new AccountReceivableAdjustBCImpl();
		AccountPayableInvoiceSC commandAp = new AccountPayableInvoiceSC();
		
		try {
			List<SapInvoiceInterfaceHeaderVO> returnApIfVO = new ArrayList<SapInvoiceInterfaceHeaderVO>();
			List<SapInvoiceInterfaceHeaderVO> apValidationVO = new ArrayList<SapInvoiceInterfaceHeaderVO>();
			
			int cngAdjTpCdCnt = 0;
			
			for(int i=0; i<event.getAdjustHdrListVOs().length; i++){
				for(int j=0; j<event.getAdjustDtlListVOs().length; j++){
					if( event.getAdjustHdrListVOs()[i].getOtsHdrKey().equals(event.getAdjustDtlListVOs()[j].getOtsDtlKey()) ){
						if( !"".equals(event.getAdjustHdrListVOs()[i].getPayAcctCd())
								&& !"".equals(event.getAdjustDtlListVOs()[j].getOtsAdjBalAmt())
								&& !event.getAdjustDtlListVOs()[j].getBlCurrCd().equals(event.getAdjustDtlListVOs()[j].getAdjCrsCurrCd()) ){
							cngAdjTpCdCnt++;
						}
					}
				}
				
				if(cngAdjTpCdCnt > 0){
					event.getAdjustHdrListVOs()[i].setChgAdjTpCd(event.getAdjustHdrListVOs()[i].getAdjTpCd()+"C");
					cngAdjTpCdCnt = 0;
				}else{
					event.getAdjustHdrListVOs()[i].setChgAdjTpCd(event.getAdjustHdrListVOs()[i].getAdjTpCd());
				}
			}
			begin();
			command.modifyAdjustInfoRvs(event.getAdjustHdrListVOs(), event.getAdjustDtlListVOs(), event.getAdjustCondVO(), account.getUsr_id(), account.getOfc_cd());
			
			// Processing AP IF......
			for(int m=0; m<event.getAdjustHdrListVOs().length; m++){
				if( !"".equals(event.getAdjustHdrListVOs()[m].getPayAcctCd()) ){ 
					String attrCtnt1 = "";
					if(event.getAdjustCondVO().getOtsSmryCd().equals("BL")){
						//attrCtnt1 = event.getAdjustHdrListVOs()[m].getBlNo();
						attrCtnt1 = event.getAdjustCondVO().getAdjNo();
					} else {
						//attrCtnt1 = event.getAdjustHdrListVOs()[m].getInvNo();
						attrCtnt1 = event.getAdjustCondVO().getAdjNo();
					} 
					returnApIfVO = manageApIf(event.getAdjustCondVO().getApOfcCd(),event.getAdjustCondVO().getAdjNo(), event.getAdjustHdrListVOs()[m].getChgAdjTpCd(), "Y", account.getUsr_id(), event.getAdjustHdrListVOs()[m].getApCurrCd(), "ADJ", attrCtnt1);
					
					for(int n=0; n<returnApIfVO.size(); n++){
						apValidationVO.add(returnApIfVO.get(n));
					}
				}else{
					eventResponse.setUserMessage(new ErrorHandler("SAR00004", new String[] {}).getUserMessage());
				}
			}
			
			if(apValidationVO.size() > 0){
				// Processing AP IF Validation...... 
				for(int z=0; z<apValidationVO.size(); z++){
					EventResponse apEventResponse = new GeneralEventResponse();
					
					apEventResponse = commandAp.manageSapIfValidateImportCheck("A/P", apValidationVO.get(z).getInvNo(), account.getUsr_id());
					Map<String, String> mapVO = apEventResponse.getETCData();
					
					if( "FAIL".equals(mapVO.get("SUCCESS_FLG")) ){
						throw new EventException(new ErrorHandler("SAR00041", new String[]{mapVO.get("RESULT_MSG")}).getMessage());
					}
				}
			}
			eventResponse.setUserMessage(new ErrorHandler("SAR00004", new String[] {}).getUserMessage());
			
			//SakuraInterFace
			AccountReceivableCollectIFBC sakuraIfBC = new AccountReceivableCollectIFBCImpl();
			sakuraIfBC.createAdjustSakuraIFdata(event.getAdjustCondVO().getAdjNo(),"P");
			
			//ASA DTL UPDATE
			for(int i=0; i<event.getAdjustHdrListVOs().length; i++){  
				if(!event.getAdjustHdrListVOs()[i].getAsaNo().equals("") && event.getAdjustHdrListVOs()[i].getAsaNo() != null){
					AccountReceivableAgentBCImpl commandAgt = new AccountReceivableAgentBCImpl();
					commandAgt.updateASADtlForCall(event.getAdjustHdrListVOs()[i].getAsaNo(), account.getUsr_id());
				} 
			}
			commit(); 
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}
	
	/**
	 * Search Ledger exchange Rate <br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLegrXchRtList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar3001Event event = (StmSar3001Event) e;
		AccountReceivableAdjustBC command = new AccountReceivableAdjustBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			String legrXchRt = "";
			
			legrXchRt = command.searchLegrXchRtList(event.getAdjustDtlListVOs(), event.getAdjustCondVO());
			
			eventResponse.setETCData("legr_xch_rt", legrXchRt);
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	
	/**
	 * Search Sail Arrival Date, GL Date, Balance Update Date <br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAutosettlementSetupDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		AccountReceivableAdjustBC command = new AccountReceivableAdjustBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {			
			List<AutosettlementCondVO> list = command.searchAutosettlementSetupDate(account.getOfc_cd());
			
			String sailArrDt = "";
			String adjDt = "";
			String balUpdDt = "";
			
			for (int i = 0; i < list.size(); i++) {
				sailArrDt = list.get(i).getSailArrDt();
				adjDt = list.get(i).getAdjDt();
				balUpdDt = list.get(i).getBalUpdDt();
			}

			eventResponse.setETCData("sail_arr_dt", sailArrDt);
			eventResponse.setETCData("adj_dt", adjDt);
			eventResponse.setETCData("bal_upd_dt", balUpdDt);
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	
	/**
	 * STM_SAR_3003 : RETRIEVE<br>
	 * Retrieve Autosettlement Entry <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAutoSettlementList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		StmSar3003Event event = (StmSar3003Event)e;
		AccountReceivableAdjustBC command = new AccountReceivableAdjustBCImpl();
		String batSeq = "";
		try{
			event.getAutosettlementCondVO().setCreUsrId(account.getUsr_id());
			begin();
			batSeq = command.createAutoSettlementList(event.getAutosettlementCondVO());
			commit();
			List<AutoSettlementInfoVO> list = command.searchAutoSettlementTemporaryList(batSeq);			
			List<AutoSettlementSubInfoVO> subList = command.searchAutoSettlementSummaryList(batSeq);
			
			eventResponse.setRsVoList(list);
			eventResponse.setRsVoList(subList);
			eventResponse.setETCData("BackEndJobKey", batSeq);
			
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * STM_SAR_B3003 BAT: save <br>
	 * save Autosettlement Data <br>
	 * 
	 * @param AutosettlementCondVO autosettlementCondVO
	 * @return List<AdjustNoSeqVO>
	 * @exception EventException
	 */
	public List<AdjustNoSeqVO> createAutoSettlement(AutosettlementCondVO autosettlementCondVO) throws EventException {
		AccountReceivableAdjustBC command = new AccountReceivableAdjustBCImpl();
		AccountReceivableCommonBC commandCom = new AccountReceivableCommonBCImpl();
		try {
			
			List<AdjustNoSeqVO> adjustNoSeqVOs = new ArrayList<AdjustNoSeqVO>();
			String adjTjTpCd = autosettlementCondVO.getAdjTjTpCd();
			String adjTjTpKeyCd = autosettlementCondVO.getAdjTjTpKeyCd();
			
			String adjKeyNo = commandCom.searchAdjustReceiptNo(adjTjTpKeyCd, autosettlementCondVO.getAccoutOfcCd(), autosettlementCondVO.getCreUsrId(), autosettlementCondVO.getAccoutOfcCd());
			
			String adjNo = "";
			String adjSeq = "";
			String ofcCd = "";
			List<AutoSettlementInfoVO> list = command.searchAutoSettlementTemporaryList(autosettlementCondVO.getBackendjobKey());
			
			for(int i=0; i < list.size(); i++){
				AdjustNoSeqVO adjustNoSeqVO = new AdjustNoSeqVO();
				
				String glDt = commandCom.searchEffectiveDate(autosettlementCondVO.getAdjDt(), list.get(i).getCltOfcCd(), "29");
				
				if(glDt == null || glDt.equals("") || !glDt.equals(autosettlementCondVO.getAdjDt().replaceAll("-", ""))){
					throw new EventException(new ErrorHandler("SAR00003",new String[]{"Adjust date"}).getMessage());
				}
				
				adjSeq = command.searchAdjustSeqNo();					
				ofcCd = list.get(i).getCltOfcCd();
				
				adjNo = commandCom.searchAdjustReceiptNo(adjTjTpCd, ofcCd, autosettlementCondVO.getCreUsrId(), autosettlementCondVO.getAccoutOfcCd());
				
				adjustNoSeqVO.setOtsAdjSeq(adjSeq);
				adjustNoSeqVO.setAdjNo(adjNo);	
				adjustNoSeqVO.setAdjKeyNo(adjKeyNo);
				adjustNoSeqVOs.add(adjustNoSeqVO);
			}
			
			command.createAutoSettlementInfo(list, autosettlementCondVO, adjustNoSeqVOs, autosettlementCondVO.getCreUsrId(), autosettlementCondVO.getAccoutOfcCd());
			return adjustNoSeqVOs;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
	}
	
	/**
	 * AP INTERFACE <br>
	 * 
	 * @param String adjNo, String adjTpcd, String rvsFlg, String usrId, String apCurrCd, String sysTpCd
	 * @return List<SapInvoiceInterfaceHeaderVO>
	 * @exception EventException
	 */
	private List<SapInvoiceInterfaceHeaderVO> manageApIf(String apOfcCd, String adjNo, String adjTpcd, String rvsFlg, String usrId, String apCurrCd, String sysTpCd,String attrCtnt1) throws EventException {
		AccountReceivableAdjustBC command = new AccountReceivableAdjustBCImpl();
		AccountReceivableCommonBC commandCom = new AccountReceivableCommonBCImpl();
		AccountPayableInvoiceBC commandAp = new AccountPayableInvoiceBCImpl();
		
		List<SapInvIfHdrVO> sapInvIfHdrVO = new ArrayList<SapInvIfHdrVO>();
		List<SapInvIfHdrVO> sapInvIfHdrTmpVO = new ArrayList<SapInvIfHdrVO>();
		List<SapInvIfDtlVO> sapInvIfDtlVO = new ArrayList<SapInvIfDtlVO>();
		List<SapInvoiceInterfaceHeaderVO> insertSapInvoiceInterfaceHeaderVO = new ArrayList<SapInvoiceInterfaceHeaderVO>();
		List<SapInvoiceInterfaceDetailVO> insertSapInvoiceInterfaceDetailVO = new ArrayList<SapInvoiceInterfaceDetailVO>();
		
		ApIfSetVO apIfSetVO = new ApIfSetVO();
		
		try {
			String funcCurr = "";
			
			funcCurr = commandCom.searchFunctionalCurrency("FUNCTIONAL CURRENCY");
			List<CurrencyCodeVO> list = commandCom.searchCurrencyCode(apCurrCd);
			String dpPrcsKnt = list.get(0).getDpPrcsKnt();
						
			String apGlDt = command.searchApGlDtList(adjNo, rvsFlg, "G");
			String apExDt = command.searchApGlDtList(adjNo, rvsFlg, "E");
			
			apIfSetVO.setAdjNo(adjNo);
			apIfSetVO.setRvsFlg(rvsFlg);
			apIfSetVO.setUsrId(usrId);
			apIfSetVO.setApCurrCd(apCurrCd);
			apIfSetVO.setFuncCurrCd(funcCurr);
			apIfSetVO.setApGlDt(apGlDt);
			apIfSetVO.setApExDt(apExDt);
			apIfSetVO.setSysTpCd(sysTpCd);
			apIfSetVO.setDpPrcsKnt(dpPrcsKnt);
			
			// AP HEADER SETTING
			sapInvIfHdrVO = command.searchSapInvIfHdrList(apIfSetVO);
			
			if(sapInvIfHdrVO.size() > 0 ){
				for(int i=0; i<sapInvIfHdrVO.size(); i++){
					SapInvoiceInterfaceHeaderVO sapInvoiceInterfaceHeaderVO = new SapInvoiceInterfaceHeaderVO();
					
					String invHdrIfSeq = command.searchSapInvHdrIfSeqNo();
					String liabCdCmbSeq = command.searchSapInvHdrIfCdCmbSeq(sapInvIfHdrVO.get(i), adjTpcd, sysTpCd);
					
					// 2014.06.19 �꾩떆 濡쒖쭅 異붽� 
					// CODE COMBINATION SEQUENCE �놁쑝硫���옣�섍퀬 議고쉶 濡쒖쭅
					if(liabCdCmbSeq == null || liabCdCmbSeq.equals("")){
						command.addSapInvHdrIfCdCmbSeq(sapInvIfHdrVO.get(i), adjTpcd, sysTpCd);
						liabCdCmbSeq = command.searchSapInvHdrIfCdCmbSeq(sapInvIfHdrVO.get(i), adjTpcd, sysTpCd);
					}
					// 2014.06.19 �꾩떆 濡쒖쭅 異붽� 
					
					if("".equals(liabCdCmbSeq)){
						throw new EventException(new ErrorHandler("SAR00035",new String[]{""}).getMessage());
					}
					
					// Setting INV NO of Offset
					if("OFF".equals(sysTpCd)){
						sapInvIfHdrTmpVO = command.searchOffSapInvNoList(apIfSetVO, sapInvIfHdrVO.get(i).getInvAmt(), sapInvIfHdrVO.get(i).getOfcCd());
						sapInvIfHdrVO.get(i).setInvNo(sapInvIfHdrTmpVO.get(0).getInvNo()); 
						sapInvIfHdrVO.get(i).setInvTpLuCd(sapInvIfHdrTmpVO.get(0).getInvTpLuCd());
					}
					
					sapInvoiceInterfaceHeaderVO.setInvIfSeq(invHdrIfSeq);
					sapInvoiceInterfaceHeaderVO.setInvNo(sapInvIfHdrVO.get(i).getInvNo());
					sapInvoiceInterfaceHeaderVO.setInvTpLuCd(sapInvIfHdrVO.get(i).getInvTpLuCd());
					sapInvoiceInterfaceHeaderVO.setInvDt(sapInvIfHdrVO.get(i).getInvDt());
					sapInvoiceInterfaceHeaderVO.setVndrNo(sapInvIfHdrVO.get(i).getVndrNo());
					sapInvoiceInterfaceHeaderVO.setInvAmt(sapInvIfHdrVO.get(i).getInvAmt());
					sapInvoiceInterfaceHeaderVO.setInvCurrCd(sapInvIfHdrVO.get(i).getInvCurrCd());
					sapInvoiceInterfaceHeaderVO.setInvXchRt(sapInvIfHdrVO.get(i).getInvXchRt());
					sapInvoiceInterfaceHeaderVO.setInvXchRtTpCd(sapInvIfHdrVO.get(i).getInvXchRtTpCd());
					sapInvoiceInterfaceHeaderVO.setInvXchDt(sapInvIfHdrVO.get(i).getInvXchDt());
					sapInvoiceInterfaceHeaderVO.setInvTermNm(sapInvIfHdrVO.get(i).getInvTermNm());
					sapInvoiceInterfaceHeaderVO.setInvDesc(sapInvIfHdrVO.get(i).getInvDesc());
					sapInvoiceInterfaceHeaderVO.setAttrCateNm(sapInvIfHdrVO.get(i).getAttrCateNm());
					sapInvoiceInterfaceHeaderVO.setAttrCtnt2(sapInvIfHdrVO.get(i).getAttrCtnt2());
					sapInvoiceInterfaceHeaderVO.setAttrCtnt4(sapInvIfHdrVO.get(i).getAttrCtnt4());
					sapInvoiceInterfaceHeaderVO.setAttrCtnt7(sapInvIfHdrVO.get(i).getAttrCtnt7());
					sapInvoiceInterfaceHeaderVO.setInvIfStsCd(sapInvIfHdrVO.get(i).getInvIfStsCd());
					sapInvoiceInterfaceHeaderVO.setIfSrcNm(sapInvIfHdrVO.get(i).getIfSrcNm());
					sapInvoiceInterfaceHeaderVO.setInvPayCurrCd(sapInvIfHdrVO.get(i).getInvPayCurrCd());
					sapInvoiceInterfaceHeaderVO.setApPayMzdLuCd(sapInvIfHdrVO.get(i).getApPayMzdLuCd());
					sapInvoiceInterfaceHeaderVO.setPayGrpLuCd(sapInvIfHdrVO.get(i).getPayGrpLuCd());
					sapInvoiceInterfaceHeaderVO.setInvRcvDt(sapInvIfHdrVO.get(i).getInvRcvDt());
					sapInvoiceInterfaceHeaderVO.setGlDt(sapInvIfHdrVO.get(i).getGlDt());
					sapInvoiceInterfaceHeaderVO.setOfcCd(sapInvIfHdrVO.get(i).getOfcCd());
					sapInvoiceInterfaceHeaderVO.setInvTermDt(sapInvIfHdrVO.get(i).getInvTermDt());
					sapInvoiceInterfaceHeaderVO.setUsrId(usrId);
					sapInvoiceInterfaceHeaderVO.setLiabCdCmbSeq(liabCdCmbSeq);
					
					
					insertSapInvoiceInterfaceHeaderVO.add(sapInvoiceInterfaceHeaderVO);
					
					
					// AP DETAIL SETTING
					apIfSetVO.setVndrNo(sapInvIfHdrVO.get(i).getVndrNo());
					sapInvIfDtlVO = command.searchSapInvIfDtlList(apIfSetVO);

					// 2014.09.17 ADD OFFSET CROSS CURRENCY LOGIC START					
					String offArAcctCd = "";
					String offGainAndLssAcctCd = "";
					BigDecimal offApLineAmt = new BigDecimal(0);
					BigDecimal offGainAndLssAmt = new BigDecimal(0);
					
					if("OFF".equals(sysTpCd)){
						// 1. Search offset functional exchange rate
						String offApFuncExRt = command.searchSarGetGlXchRtFncList(apIfSetVO);
						
						// 2. Search Sum of adjust account amount in adjust history table
						String offAdjAcctAmt = command.searchAdjAcctAmtSumList(sapInvIfHdrVO.get(i).getAttrCtnt2(), rvsFlg);
						
						// 3. Search sum of offset amount in offset master table
						String offMstSumAmt = command.searchOffsetAmtSumList(sapInvIfHdrVO.get(i).getAttrCtnt2());
						
						// 4. Search invoice amount in sap hearder table
						String offApHdrAmt = sapInvIfHdrVO.get(i).getInvAmt();
						
						// 5. Search line account code						
						SarAcctMtxVO sarAcctMtx= command.searchSarAcctCodeList(adjTpcd);
						
						// 6. Search sap line/gain and loss amount
						SapInvoiceInterfaceDetailVO apLineAmt = command.searchApLineAmtCalcList(offApFuncExRt, offAdjAcctAmt, offMstSumAmt, offApHdrAmt, apIfSetVO.getDpPrcsKnt(), adjTpcd, rvsFlg);
						
						if("OFF".equals(adjTpcd)){
							offApLineAmt  = new BigDecimal(apLineAmt.getDtrbAmt());						
							offGainAndLssAmt = new BigDecimal(apLineAmt.getLInvRoundAmount());
							
							offArAcctCd = sarAcctMtx.getArAcctCd();
						}else if("OFFC".equals(adjTpcd)){
							offApLineAmt = new BigDecimal(apLineAmt.getDtrbAmt());						
							offGainAndLssAmt = new BigDecimal(apLineAmt.getLInvRoundAmount());
							
							offArAcctCd = sarAcctMtx.getArAcctCd();
							
							if("N".equals(rvsFlg)){
								if(offGainAndLssAmt.compareTo(new BigDecimal(0)) > 0){
									offGainAndLssAcctCd = sarAcctMtx.getLegrXchDiffIncmAcctCd();
								}else if(offGainAndLssAmt.compareTo(new BigDecimal(0)) < 0){
									offGainAndLssAcctCd = sarAcctMtx.getLegrXchDiffLssAcctCd();
								}
							} else{
								if(offGainAndLssAmt.compareTo(new BigDecimal(0)) < 0){
									offGainAndLssAcctCd = sarAcctMtx.getLegrXchDiffIncmAcctCd();
								}else if(offGainAndLssAmt.compareTo(new BigDecimal(0)) > 0){
									offGainAndLssAcctCd = sarAcctMtx.getLegrXchDiffLssAcctCd();
								}
							}
						}						
					}
					// 2014.09.17 ADD OFFSET CROSS CURRENCY LOGIC END
										
					for(int j=0; j<sapInvIfDtlVO.size(); j++){
						SapInvoiceInterfaceDetailVO sapInvoiceInterfaceDetailVO = new SapInvoiceInterfaceDetailVO();
						
						String invDtlIfSeq = command.searchSapInvDtlIfSeqNo();
						// 2014.08.18	String dtrbCdCmbSeq = command.searchSapInvDtlIfCdCmbSeq(sapInvIfDtlVO.get(j), adjTpcd, sysTpCd);
						String dtrbCdCmbSeq = command.searchSapInvDtlIfCdCmbSeq(sapInvIfDtlVO.get(j), adjTpcd, sysTpCd, adjNo, offArAcctCd, sapInvIfHdrVO.get(i).getInterCoCd());
						
						// 2014.06.19 �꾩떆 濡쒖쭅 異붽� 
						// CODE COMBINATION SEQUENCE �놁쑝硫���옣�섍퀬 議고쉶 濡쒖쭅
						if(dtrbCdCmbSeq == null || dtrbCdCmbSeq.equals("")){
							command.addSapInvDtlIfCdCmbSeq(sapInvIfDtlVO.get(j), adjTpcd, sysTpCd, adjNo, offArAcctCd, sapInvIfHdrVO.get(i).getInterCoCd());  // 2014.08.18 add adjNo
							dtrbCdCmbSeq = command.searchSapInvDtlIfCdCmbSeq(sapInvIfDtlVO.get(j), adjTpcd, sysTpCd, adjNo, offArAcctCd, sapInvIfHdrVO.get(i).getInterCoCd());  // 2014.08.18 add adjNo
						}
						// 2014.06.19 �꾩떆 濡쒖쭅 異붽� 
						
						if("".equals(dtrbCdCmbSeq)){
							throw new EventException(new ErrorHandler("SAR00035",new String[]{""}).getMessage());
						}
						
						sapInvoiceInterfaceDetailVO.setInvIfLineSeq(invDtlIfSeq);
						sapInvoiceInterfaceDetailVO.setInvIfSeq(invHdrIfSeq);
						sapInvoiceInterfaceDetailVO.setInvLineNo(sapInvIfDtlVO.get(j).getInvLineNo());
						sapInvoiceInterfaceDetailVO.setLineTpLuCd(sapInvIfDtlVO.get(j).getLineTpLuCd());

						if("ADJ".equals(sysTpCd)){
							sapInvoiceInterfaceDetailVO.setDtrbAmt(sapInvIfDtlVO.get(j).getDtrbAmt());
							
						}else if("OFF".equals(sysTpCd)){
							sapInvoiceInterfaceDetailVO.setDtrbAmt(offApLineAmt.toString());	
						}
						sapInvoiceInterfaceDetailVO.setAttrCtnt1(attrCtnt1);
						sapInvoiceInterfaceDetailVO.setAttrCtnt11(apExDt);
						sapInvoiceInterfaceDetailVO.setAttrCtnt12(apOfcCd);
						sapInvoiceInterfaceDetailVO.setAttrCtnt14("COM");
						
						sapInvoiceInterfaceDetailVO.setAcctgDt(sapInvIfDtlVO.get(j).getAcctgDt());
						sapInvoiceInterfaceDetailVO.setDtrbDesc(sapInvIfDtlVO.get(j).getDtrbDesc());
						sapInvoiceInterfaceDetailVO.setDtrbVatCd(sapInvIfDtlVO.get(j).getDtrbVatCd());
						sapInvoiceInterfaceDetailVO.setFnlMtchStsCd(sapInvIfDtlVO.get(j).getFnlMtchStsCd());
						sapInvoiceInterfaceDetailVO.setAttrCtnt3(sapInvIfDtlVO.get(j).getAttrCtnt3());
						sapInvoiceInterfaceDetailVO.setIfSrcNm(sapInvIfDtlVO.get(j).getIfSrcNm());
						sapInvoiceInterfaceDetailVO.setOfcCd(sapInvIfDtlVO.get(j).getOfcCd());
						sapInvoiceInterfaceDetailVO.setUsrId(usrId);
						sapInvoiceInterfaceDetailVO.setDtrbCdCmbSeq(dtrbCdCmbSeq);
						sapInvoiceInterfaceDetailVO.setInvNo(sapInvIfHdrVO.get(i).getInvNo());
						
						insertSapInvoiceInterfaceDetailVO.add(sapInvoiceInterfaceDetailVO);
						
						
						if( "ADJ".equals(sysTpCd) && !"0".equals(sapInvIfDtlVO.get(j).getGainAndLssAmt()) ){
							SapInvoiceInterfaceDetailVO sapInvoiceInterfaceDetailNextVO = new SapInvoiceInterfaceDetailVO();
							
							String invDtlIfNextSeq = command.searchSapInvDtlIfSeqNo();
							String dtrbCdCmbNextSeq = command.searchSapInvDtlIfCdCmbNextSeq(sapInvIfDtlVO.get(j), adjTpcd, dtrbCdCmbSeq, offGainAndLssAcctCd, sysTpCd, rvsFlg); //2014.08.18 add dtrbCdCmbSeq
							
							// 2014.06.19 �꾩떆 濡쒖쭅 異붽� 
							// CODE COMBINATION SEQUENCE �놁쑝硫���옣�섍퀬 議고쉶 濡쒖쭅
							if(dtrbCdCmbNextSeq == null || dtrbCdCmbNextSeq.equals("")){
								command.addSapInvDtlIfCdCmbNextSeq(sapInvIfDtlVO.get(j), adjTpcd, sysTpCd, dtrbCdCmbSeq, offGainAndLssAcctCd, rvsFlg); //2014.08.18 add dtrbCdCmbSeq
								dtrbCdCmbNextSeq = command.searchSapInvDtlIfCdCmbNextSeq(sapInvIfDtlVO.get(j), adjTpcd, dtrbCdCmbSeq, offGainAndLssAcctCd, sysTpCd, rvsFlg); //2014.08.18 add dtrbCdCmbSeq
							}
							// 2014.06.19 �꾩떆 濡쒖쭅 異붽� 
							
							if("".equals(dtrbCdCmbNextSeq)){
								throw new EventException(new ErrorHandler("SAR00035",new String[]{""}).getMessage());
							}
							
							sapInvoiceInterfaceDetailNextVO.setInvIfLineSeq(invDtlIfNextSeq);
							sapInvoiceInterfaceDetailNextVO.setInvIfSeq(invHdrIfSeq);
							sapInvoiceInterfaceDetailNextVO.setInvLineNo("2");
							sapInvoiceInterfaceDetailNextVO.setLineTpLuCd(sapInvIfDtlVO.get(j).getLineTpLuCd());
							sapInvoiceInterfaceDetailNextVO.setDtrbAmt(sapInvIfDtlVO.get(j).getGainAndLssAmt());
							sapInvoiceInterfaceDetailNextVO.setAttrCtnt11(apExDt);
							sapInvoiceInterfaceDetailNextVO.setAttrCtnt12(apOfcCd);
							sapInvoiceInterfaceDetailNextVO.setAttrCtnt14("COM");
							sapInvoiceInterfaceDetailNextVO.setAcctgDt(sapInvIfDtlVO.get(j).getAcctgDt());
							sapInvoiceInterfaceDetailNextVO.setDtrbDesc(sapInvIfDtlVO.get(j).getDtrbDesc());
							sapInvoiceInterfaceDetailNextVO.setDtrbVatCd(sapInvIfDtlVO.get(j).getDtrbVatCd());
							sapInvoiceInterfaceDetailNextVO.setFnlMtchStsCd(sapInvIfDtlVO.get(j).getFnlMtchStsCd());
							sapInvoiceInterfaceDetailNextVO.setAttrCtnt3(sapInvIfDtlVO.get(j).getAttrCtnt3());
							sapInvoiceInterfaceDetailNextVO.setIfSrcNm(sapInvIfDtlVO.get(j).getIfSrcNm());
							sapInvoiceInterfaceDetailNextVO.setOfcCd(sapInvIfDtlVO.get(j).getOfcCd());
							sapInvoiceInterfaceDetailNextVO.setUsrId(usrId);
							sapInvoiceInterfaceDetailNextVO.setDtrbCdCmbSeq(dtrbCdCmbNextSeq);
							sapInvoiceInterfaceDetailNextVO.setInvNo(sapInvIfHdrVO.get(i).getInvNo());
							sapInvoiceInterfaceDetailNextVO.setAttrCtnt1(attrCtnt1);
							
							insertSapInvoiceInterfaceDetailVO.add(sapInvoiceInterfaceDetailNextVO);
						}else if( "OFF".equals(sysTpCd) && offGainAndLssAmt.compareTo(new BigDecimal(0)) != 0 ){
							SapInvoiceInterfaceDetailVO sapInvoiceInterfaceDetailNextVO = new SapInvoiceInterfaceDetailVO();
							
							String invDtlIfNextSeq = command.searchSapInvDtlIfSeqNo();
							String dtrbCdCmbNextSeq = command.searchSapInvDtlIfCdCmbNextSeq(sapInvIfDtlVO.get(j), adjTpcd, dtrbCdCmbSeq, offGainAndLssAcctCd, sysTpCd, rvsFlg); //2014.08.18 add dtrbCdCmbSeq
							
							// 2014.06.19 �꾩떆 濡쒖쭅 異붽� 
							// CODE COMBINATION SEQUENCE �놁쑝硫���옣�섍퀬 議고쉶 濡쒖쭅
							if(dtrbCdCmbNextSeq == null || dtrbCdCmbNextSeq.equals("")){
								command.addSapInvDtlIfCdCmbNextSeq(sapInvIfDtlVO.get(j), adjTpcd, sysTpCd, dtrbCdCmbSeq, offGainAndLssAcctCd, rvsFlg); //2014.08.18 add dtrbCdCmbSeq
								dtrbCdCmbNextSeq = command.searchSapInvDtlIfCdCmbNextSeq(sapInvIfDtlVO.get(j), adjTpcd, dtrbCdCmbSeq, offGainAndLssAcctCd, sysTpCd, rvsFlg); //2014.08.18 add dtrbCdCmbSeq
							}
							// 2014.06.19 �꾩떆 濡쒖쭅 異붽� 
							
							if("".equals(dtrbCdCmbNextSeq)){
								throw new EventException(new ErrorHandler("SAR00035",new String[]{""}).getMessage());
							}
							
							sapInvoiceInterfaceDetailNextVO.setInvIfLineSeq(invDtlIfNextSeq);
							sapInvoiceInterfaceDetailNextVO.setInvIfSeq(invHdrIfSeq);
							sapInvoiceInterfaceDetailNextVO.setInvLineNo("2");
							sapInvoiceInterfaceDetailNextVO.setLineTpLuCd(sapInvIfDtlVO.get(j).getLineTpLuCd());
							offGainAndLssAmt = offGainAndLssAmt.multiply(new BigDecimal(-1));
							sapInvoiceInterfaceDetailNextVO.setDtrbAmt(offGainAndLssAmt.toString());
							sapInvoiceInterfaceDetailNextVO.setAttrCtnt11(apExDt);
							sapInvoiceInterfaceDetailNextVO.setAttrCtnt12(apOfcCd);
							sapInvoiceInterfaceDetailNextVO.setAttrCtnt14("COM");
							sapInvoiceInterfaceDetailNextVO.setAcctgDt(sapInvIfDtlVO.get(j).getAcctgDt());
							sapInvoiceInterfaceDetailNextVO.setDtrbDesc(sapInvIfDtlVO.get(j).getDtrbDesc());
							sapInvoiceInterfaceDetailNextVO.setDtrbVatCd(sapInvIfDtlVO.get(j).getDtrbVatCd());
							sapInvoiceInterfaceDetailNextVO.setFnlMtchStsCd(sapInvIfDtlVO.get(j).getFnlMtchStsCd());
							sapInvoiceInterfaceDetailNextVO.setAttrCtnt3(sapInvIfDtlVO.get(j).getAttrCtnt3());
							sapInvoiceInterfaceDetailNextVO.setIfSrcNm(sapInvIfDtlVO.get(j).getIfSrcNm());
							sapInvoiceInterfaceDetailNextVO.setOfcCd(sapInvIfDtlVO.get(j).getOfcCd());
							sapInvoiceInterfaceDetailNextVO.setUsrId(usrId);
							sapInvoiceInterfaceDetailNextVO.setDtrbCdCmbSeq(dtrbCdCmbNextSeq);
							sapInvoiceInterfaceDetailNextVO.setInvNo(sapInvIfHdrVO.get(i).getInvNo());
							sapInvoiceInterfaceDetailNextVO.setAttrCtnt1(attrCtnt1);
							
							insertSapInvoiceInterfaceDetailVO.add(sapInvoiceInterfaceDetailNextVO);
						}
					}
				}
				
				commandAp.addInvoiceHeaderIF(insertSapInvoiceInterfaceHeaderVO);
				commandAp.addInvoiceLineIF(insertSapInvoiceInterfaceDetailVO);
			}
		} catch (EventException ex) {
			rollback();
			throw ex;
		} catch (Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		
		return insertSapInvoiceInterfaceHeaderVO;
	}
	

	/**
	 * Retrieve Invoice Remark(s) event<br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchReceiptListByDetail(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar2002Event event = (StmSar2002Event) e;
		
		AccountReceivableReceiptBC command = new AccountReceivableReceiptBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<ReceiptListByDetailVO> list = command.searchReceiptListByDetail(event.getReceiptListByDetailCondVO());
			eventResponse.setRsVoList(list);       
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * Search open ASA List <br>
	 * 
	 * @author SungYong Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOpenASAList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar2001Event event = (StmSar2001Event) e;
		AccountReceivableReceiptBC command = new AccountReceivableReceiptBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<String> list = command.searchOpenASAList(event.getAgnOfcCd(), event.getRctNo());
			
			StringBuilder asaNo = new StringBuilder("");
			StringBuilder currCd = new StringBuilder("");
			
			for (int i = 0; i < list.size(); i++) {
				String[] arrStr = list.get(i).split(",");
				
				asaNo.append("|").append(arrStr[0]);
				currCd.append("|").append(arrStr[1]);
			}

			eventResponse.setETCData("asa_no", asaNo.toString());
			eventResponse.setETCData("curr_cd", currCd.toString());
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	
	
	/**
	 * Search ASA No, Currency List <br>
	 * 
	 * @author 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchAsaNoList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar3001Event event = (StmSar3001Event) e;
		AccountReceivableAdjustBC command = new AccountReceivableAdjustBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			List<SarAsaMstVO> list = command.searchAsaNoList(event.getAdjustCondVO());
			
			StringBuilder asaNoCurrCd = new StringBuilder("");
			
			for (int i = 0; i < list.size(); i++) {
				asaNoCurrCd.append("|").append(list.get(i).getAsaNo()).append("\t").append(list.get(i).getCurrCd());
			}

			eventResponse.setETCData("p_asa_no_curr_cd", asaNoCurrCd.toString());
			
			return eventResponse;
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * STM_SAR_1008 : Retrieve
	 * Search Receipts view accounting
	 * @author jinyoonoh 2014. 7. 16.
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchRCTViewAccountingList(Event e) throws EventException {		
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		StmSar2005Event event = (StmSar2005Event) e;
		AccountReceivableReceiptBC command = new AccountReceivableReceiptBCImpl();
		try {
			RCTViewAccountingListVO paramVO = event.getRctViewAccountingListVO();
			List<RCTViewAccountingListVO> list = command.searchRCTViewAccountingList(paramVO);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		return eventResponse;
	}		
	
	/**
	 * STM_SAR_3004 : Retrieve
	 * Search Adjust View Accounting
	 * @author jinyoonoh 2014. 7. 16.
	 * @param e
	 * @return
	 * @throws EventException
	 */
	private EventResponse searchAdjViewAccountingList(Event e) throws EventException {		
		GeneralEventResponse eventResponse = new GeneralEventResponse(); 
		StmSar3004Event event = (StmSar3004Event) e;
		AccountReceivableAdjustBC command = new AccountReceivableAdjustBCImpl();
		try {
			AdjViewAccountingListVO paramVO = event.getAdjViewAccountingListVO();
			List<AdjViewAccountingListVO> list = command.searchAdjViewAccountingList(paramVO);
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(),ex);
		}
		return eventResponse;
	}		
	
	/**
	 * Secast BackEndJobKey status<br>
	 * 
	 * @author Myoungsin Park
	 * @param Event
	 *            e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchIfBackEndJobStatus(Event e)
			throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AccountReceivableAgentBC command = new AccountReceivableAgentBCImpl();
		
		StmSar3003Event event = (StmSar3003Event)e;
		try {
			AutosettlementCondVO paramVO = event.getAutosettlementCondVO();
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
	
	
	/**
	 * STM_SAR_3003 : run bat <br>
	 * save Autosettlement Data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createAutoSettlementBat(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AccountReceivableAdjustBC command = new AccountReceivableAdjustBCImpl();
		StmSar3003Event event = (StmSar3003Event)e;
		try {
			AutosettlementCondVO paramVO = event.getAutosettlementCondVO();
			begin();
			if(event.getAutoSettlementInfoVOs() != null && event.getAutoSettlementInfoVOs().length > 0){
				command.removeAutoSettlementDelCheckList(event.getAutoSettlementInfoVOs());
			}
			 
			String batSeq = paramVO.getBackendjobKey(); 
			command.createAutoSettlementBat(batSeq,account,paramVO); 
			commit();
			if(!batSeq.equals("")){
				//check batch status
				String pgmNo = "STM_SAR_B3003";
				String batStsCd = command.searchAutoSettlementBatStsCd(pgmNo);		
				
				if("S".equals(batStsCd)){
					command.excuteAutoSettlementBat(batSeq);	
				}else if("R".equals(batStsCd)){	// Running
					begin();
					// sco_bat_his 에 E로 업데이트
					command.manageCancelAutoSettlementBat(batSeq, account);
					eventResponse.setETCData("batStsCd", batStsCd); 
					commit();
				}
			
			}
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
	 * Search OTS Temp Info<br>
	 * 
	 * @author SungYong Park
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOutstandingReceiptTempInfo(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		StmSar2001Event event = (StmSar2001Event) e;
		AccountReceivableReceiptBC     command  = new AccountReceivableReceiptBCImpl();
		AccountReceivableOutstandingBC command1 = new AccountReceivableOutstandingBCImpl();
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		try {
			
			String otsRctTmpSeq = event.getApplyListCondVO().getOtsRctTmpSeq();
			
			List<ApplyHeaderVO> applyHeaderVO = command.searchOutstandingReceiptHdrTemp(otsRctTmpSeq);
			List<ApplyDetailVO> applyDetailVO = command.searchOutstandingReceiptDtlTemp(otsRctTmpSeq);
			
			String ttlAplyAmt = command.searchOTSTempTotalAmount(otsRctTmpSeq);
			
			eventResponse.setRsVoList(applyHeaderVO);
			eventResponse.setRsVoList(applyDetailVO);
			eventResponse.setETCData("ttl_aply_amt", ttlAplyAmt);
			
			begin();
			command1.removeOutstandingReceiptTemp(otsRctTmpSeq);
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
     * Receipt 의 BackEndJob의 Key 조회.<br>
	 * @author SYPARK
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchReceiptBackEndJobStatus(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar2001Event event = (StmSar2001Event) e;
    	try {    		
	    	
    		//SeaCastIfCondVO seaCastIfCondVO = event.getSeaCastIfCondVO();
    		String backEndJobKey = event.getBackendjobKey();
	    		
    		if ( backEndJobKey != null && !backEndJobKey.equals("")) {
	    		
    			// Backend job이 완료되었는지 검사한다.
		    	BackEndJobMetaDataSelector backEndJobMetaDataSelector = new BackEndJobMetaDataSelector(backEndJobKey);

		    	DBRowSet rowSet = backEndJobMetaDataSelector.getDbRowset();
		    	
		    	String jb_sts_flg = "0"; // Background job framework가 정상적으로 동작하지 않을 경우 발생하는 오류를 회피하기 위함
		    	String jb_usr_err_msg = "";
		    	
				if(rowSet.next()) {
					//Thread.sleep(1000);
					jb_sts_flg = rowSet.getString("jb_sts_flg");
					jb_usr_err_msg = rowSet.getString("jb_usr_err_msg");
				}
				
				eventResponse.setETCData("jb_sts_flg", jb_sts_flg);
		    	eventResponse.setETCData("jb_usr_err_msg", jb_usr_err_msg);
		    	/*
		    	List<ComBakEndJbVO> dbRowSetlist = (List)RowSetUtil.rowSetToVOs(rowSet, ComBakEndJbVO.class);
		    	
		    	ComBakEndJbVO jobVo = new ComBakEndJbVO();
		    	if (dbRowSetlist.size() == 0) {
		    		// Background job framework가 정상적으로 동작하지 않을 경우 발생하는 오류를 회피하기 위함
		    	  jobVo.setJbStsFlg("0");
		    	} else {
		    		jobVo = (ComBakEndJbVO)dbRowSetlist.get(0);	
		    	}
		    	
		    	eventResponse.setETCData("jb_sts_flg", jobVo.getJbStsFlg());
		    	*/
    		}
	    	
    	} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("COM12240",new String[]{}).getMessage());
		}
    	return eventResponse;
    }
	
	/**
     * Receipt 의 BackEndJob의 File 조회.<br>
	 * @author SYPARK
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	@SuppressWarnings("unchecked")
	private EventResponse searchReceiptBackEndJobFile(Event e) throws EventException {
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		AccountReceivableReceiptBC command = new AccountReceivableReceiptBCImpl();
		StmSar2001Event event = (StmSar2001Event) e;
		
    	try {    		
	    	
    		String rctNo = command.searchReceiptBackEndJobFile(event.getBackendjobKey());
    		
		    eventResponse.setETCData("rct_no", rctNo);
	    	
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
    	return eventResponse;
    }
}
