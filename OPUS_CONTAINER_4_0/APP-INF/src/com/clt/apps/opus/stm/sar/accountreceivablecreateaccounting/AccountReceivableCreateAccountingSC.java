/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableCreateAccountingSC.java
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
package com.clt.apps.opus.stm.sar.accountreceivablecreateaccounting;

import java.util.List;

import com.clt.apps.opus.stm.sar.accountreceivablecreateaccounting.accountreceivablecreateaccounting.vo.CreateOtsLedgerListVO;
import com.clt.apps.opus.stm.sar.accountreceivablecreateaccounting.accountreceivablecreateaccounting.basic.AccountReceivableCreateAccountingBC;
import com.clt.apps.opus.stm.sar.accountreceivablecreateaccounting.accountreceivablecreateaccounting.basic.AccountReceivableCreateAccountingBCImpl;
import com.clt.apps.opus.stm.sar.accountreceivablecreateaccounting.accountreceivablecreateaccounting.event.StmSar4003Event;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * AccountReceivableCreateAccounting Business Logic ServiceCommand 
 * - Handling AccountReceivableCreateAccounting Business transaction.
 * 
 * @author 
 * @see AccountReceivableCreateAccountingDBDAO
 * @since J2EE 1.6
 */ 

public class AccountReceivableCreateAccountingSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Precede AccountReceivableCreateAccounting system <br>
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
	 * Follow AccountReceivableCreateAccounting system<br>
	 * Release Object when STM_SAR job end<br>
	 */
	public void doEnd() {
		log.debug("AccountReceivableCreateAccountingSC 종료");
	}

	/**
	 * proceeding job each Even<br>
	 *  Handling every Event on  AccountReceivableCreateAccounting system<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("StmSar4003Event")) {
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {
				manageCreateOtsLedgerInfo(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchCreateOtsLedgerList(e);
			}
			if (e.getFormCommand().isCommand(FormCommand.SEARCH02)) {
				eventResponse = searchLedgerFunctionCurrency(e);
			}
		} 

		return eventResponse;
	}
	
	/**
	 * StmSar4003Event : Ledger OTS Creation <br>
	 * Create Ledger OTS Data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private String manageCreateOtsLedgerInfo(Event e) throws EventException {
		AccountReceivableCreateAccountingBC command = new AccountReceivableCreateAccountingBCImpl();
		StmSar4003Event event = (StmSar4003Event) e;
		
		String params = "";
		String result = "";
		
		try {
			params = event.getGlMon() + "#" + event.getFlgCd() + "#" + account.getUsr_id();

			result = command.manageCreateOtsLedgerInfo(params);			
		}catch(Exception ex){
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex); 
		}
		return result; 
	}
	
	/**
	 * StmSar4003Event : Ledger OTS Creation <br>
	 * search Ledger OTS Data <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCreateOtsLedgerList(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar4003Event event = (StmSar4003Event) e;
		AccountReceivableCreateAccountingBC command = new AccountReceivableCreateAccountingBCImpl();
		
	try { 
			List<CreateOtsLedgerListVO> list = command.searchCreateOtsLedgerList(event.getCreateOtsLedgerListVO());
			eventResponse.setRsVoList(list);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}	
	
	/**
	 * StmSar4003Event : Ledger OTS Creation <br>
	 * search Ledger Function currency <br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLedgerFunctionCurrency(Event e) throws EventException {
		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		StmSar4003Event event = (StmSar4003Event) e;
		AccountReceivableCreateAccountingBC command = new AccountReceivableCreateAccountingBCImpl();
		
	try {
			String rtnVal = command.searchLedgerFunctionCurrency(event.getCreateOtsLedgerListVO());
			eventResponse.setETCData("func_curr", rtnVal);
		} catch (EventException ex) {
			throw ex;
		} catch (Exception ex) {
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
		return eventResponse;
	}

}