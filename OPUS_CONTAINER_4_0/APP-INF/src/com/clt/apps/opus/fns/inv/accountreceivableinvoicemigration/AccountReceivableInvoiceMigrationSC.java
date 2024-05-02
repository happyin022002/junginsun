/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : AccountReceivableInvoiceMigrationSC.java
 *@FileTitle : AccountReceivableInvoiceMigrationSC
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
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration;

import java.util.ArrayList;
import java.util.List;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.basic.AccountReceivableInvoiceMigrationBC;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.basic.AccountReceivableInvoiceMigrationBCImpl;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.event.FnsInv9001Event;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ARBkgInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.ARInterfaceCreationVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArIfChgVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemigration.accountreceivableinvoicemigration.vo.InvArIfMnVO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.core.layer.event.GeneralEventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * AccountReceivableInvoiceMigration Business Logic ServiceCommand 
 * - Handling AccountReceivableInvoiceMigration Business transaction.
 * 
 * @author 
 * @see AccountReceivableInvoiceMigrationDBDAO
 * @since J2EE 1.6
 */ 
 
public class AccountReceivableInvoiceMigrationSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * Precede AccountReceivableInvoiceMigration system <br>
	 *  Create Object when FNS_INV job call<br>
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
	 * Follow AccountReceivableInvoiceMigration system<br>
	 * Release Object when FNS_INV job end<br>
	 */
	public void doEnd() {
		log.debug("AccountReceivableInvoiceMigrationtSC 종료");
	}

	/**
	 * proceeding job each Even<br>
	 *  Handling every Event on  AccountReceivableInvoiceMigration system<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		
		if (e.getEventName().equalsIgnoreCase("FnsInv9001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.COMMAND01)) {
				eventResponse = executeBookingMigration(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND02)) {
				eventResponse = executeOtherMigration(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND03)) {
				eventResponse = createDailyUSDExchangeRate(e);
			} else if (e.getFormCommand().isCommand(FormCommand.COMMAND04)) {
				eventResponse = createVVDExchangeRate(e);
			}
		}
		
		return eventResponse;
	}
	
	/**
	 * BKG Migration Interface<br>
	 * 
	 * @author SYPARK
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse executeBookingMigration(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv9001Event event = (FnsInv9001Event) e;
		AccountReceivableInvoiceMigrationBC command = new AccountReceivableInvoiceMigrationBCImpl();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try {
			command.executeBookingMigration(event.getFmCtrtOfcCd(), event.getToCtrtOfcCd(), event.getBkgNo());
			
			/*
			List<ARBkgInterfaceCreationVO> bkgIfVo = command.searchBKGMigrationList(event.getCtrtOfcCd(), event.getBkgNo()); //임시로직
			
			for(int p = 0; p < bkgIfVo.size(); p++) { //임시로직
				begin(); //임시로직
				command.executeInterfaceBKGARInvoiceToINV(bkgIfVo.get(p)); //임시로직
				commit(); //임시로직
			} //임시로직
			*/
			
			return eventResponse;
		} catch (EventException ex) {
			//rollback(); //임시로직
			throw ex;
		} catch (Exception ex) {
			//rollback(); //임시로직
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}	
	
	/**
	 * Other Migration Interface<br>
	 * 
	 * @author SYPARK
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse executeOtherMigration(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv9001Event event = (FnsInv9001Event) e;
		AccountReceivableInvoiceMigrationBC command = new AccountReceivableInvoiceMigrationBCImpl();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try {
			command.executeOtherMigration(event.getOfcCd(), event.getFmSrcIfSeq(), event.getToSrcIfSeq());
			
			/*
			List<ARInterfaceCreationVO> genIfVos = new ArrayList<ARInterfaceCreationVO>(); //임시로직
			
			List<InvArIfMnVO> invArIfMnVOs = command.searchInvArIfMain(event.getOfcCd(), event.getSrcIfDt(), event.getSrcIfSeq()); //임시로직
			
			for(int i = 0; i < invArIfMnVOs.size(); i++){ //임시로직
				List<InvArIfChgVO> invArIfChgVOs = command.searchInvArIfChg(invArIfMnVOs.get(i).getSrcIfDt(), invArIfMnVOs.get(i).getSrcIfSeq()); //임시로직
				
				ARInterfaceCreationVO generalIfVo = new ARInterfaceCreationVO(); //임시로직
				
				generalIfVo.setInvArIfMnVO(invArIfMnVOs.get(i)); //임시로직
				generalIfVo.setInvArIfChgVOs(invArIfChgVOs); //임시로직
				genIfVos.add(generalIfVo); //임시로직
			} //임시로직

			// genIfVos looping start
			for (int rowNum = 0; rowNum < genIfVos.size(); rowNum++) {  //임시로직
				begin(); //임시로직
				command.interfaceGeneralARInvoiceToINV(genIfVos.get(rowNum)); //임시로직
				commit(); //임시로직
			} //임시로직
			*/
			
			return eventResponse;
		} catch (EventException ex) {
			//rollback(); //임시로직
			throw ex;
		} catch (Exception ex) {
			//rollback(); //임시로직
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * VVD Ex. Rate Creation<br>
	 * 
	 * @author SYPARK
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createVVDExchangeRate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv9001Event event = (FnsInv9001Event) e;
		AccountReceivableInvoiceMigrationBC command = new AccountReceivableInvoiceMigrationBCImpl();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try {
			command.createVVDExchangeRate(event.getArOfcCd(), event.getVvdCd());
			
			/*
			begin(); //임시로직
			command.createVVDExRate(event.getArOfcCd(), event.getVvdCd()); //임시로직
			commit(); //임시로직
			*/
			
			return eventResponse;
		} catch (EventException ex) {
			//rollback(); //임시로직
			throw ex;
		} catch (Exception ex) {
			//rollback(); //임시로직
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
	/**
	 * Daily USD Ex. Rate Creation<br>
	 * 
	 * @author SYPARK
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse createDailyUSDExchangeRate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		FnsInv9001Event event = (FnsInv9001Event) e;
		AccountReceivableInvoiceMigrationBC command = new AccountReceivableInvoiceMigrationBCImpl();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();		
		
		try {
			command.createDailyUSDExchangeRate(event.getArOfcCd());
			
			/*
			begin(); //임시로직
			command.createDailyUSDExRate(event.getArOfcCd()); //임시로직
			commit(); //임시로직
			*/
			
			return eventResponse;
		} catch (EventException ex) {
			//rollback(); //임시로직
			throw ex;
		} catch (Exception ex) {
			//rollback(); //임시로직
			throw new EventException(new ErrorHandler("COM12240").getMessage(), ex);
		}
	}
	
}