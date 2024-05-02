/* =========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableInvoiceMasterDataMgtJMSProxy.java
 *@FileTitle : Receive WebLogic MQ Queue Proxy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.11.25
 *@LastModifier : 이석준
 *@LastVersion : 1.0
 * 2009-06-19 
 * 1.0 최초 생성
-------------------------------------------------------------
 * History
 * 2011.02.14 최도순 [CHM-201006644] NIKE, Invoice EDI 신규 개발 요청
=========================================================*/
package com.hanjin.apps.alps.fns.inv.servicesio;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.AccountReceivableInvoiceMgtSC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedireceive.event.UbizhjsAlpsinvGlovisEvent;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedireceive.event.UbizhjsAlpsinvCommonEvent;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;

/**
 * It's AccountReceivableInvoiceMgtMQProxy.java
 * 
 * @author 이석준
 * @see 
 * @since J2EE 1.6 May 25, 2009
 */
public class AccountReceivableInvoiceMgtMQProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());	
	
	/**
	 * MQ Receive(INV.ALPSINV_UBIZHJS_APERAK.IBMMQ.QUEUE)<br>
	 * @param TransferEAI eai
	 * @exception EventException, Exception
	 */
	public void receiveEdiFromGlovis(TransferEAI eai) throws EventException {

		log.error("<<<<<<<<<< receiveCommonEdi Start >>>>>>>>>>>>>>>>");	
		try {
			
			String str = eai.getMessage();
			log.error("Flat File=["+str);		
			
			if (str.startsWith("$$$MSGSTART:GLOVIS")) {
				receiveEdiGlovis(eai);
			} else if (str.startsWith("$$$MSGSTART:EURINV")) {
				receiveEdiFromEurEmailServer(eai);
			} else {
				receiveEdiOthers(eai);
			}
			
			log.error("<<<<<<<<<< receiveCommonEdi End >>>>>>>>>>>>>>>>");
			
		} catch (EventException ee) {
			log.error("EventException ee : " + ee.toString(), ee);
			eai.rollback(ee);
			throw new EventException(new ErrorHandler("INV00066").getMessage(), ee);
		} catch (Exception e){
			log.error("Exception e : " + e.toString());
			eai.rollback(e);
			throw new EventException(new ErrorHandler("INV00066").getMessage(), e);
		}
		eai.close();
	}

	/**
	 * MQ Receive(Glovis EDI - INV.ALPSINV_UBIZHJS_APERAK.IBMMQ.QUEUE)<br>
	 * @param TransferEAI eai
	 * @exception EventException, Exception
	 */
	public void receiveEdiGlovis(TransferEAI eai) throws EventException {

		log.error("<<<<<<<<<< interfaceGlovisInvoiceToINV Start >>>>>>>>>>>>>>>>");	
		Event event = null;
		AccountReceivableInvoiceMgtSC accountReceivableInvoiceMgtSC = new AccountReceivableInvoiceMgtSC();
		try {
			
			String str = eai.getMessage();
			String integrationId = eai.getIntegrationID(); 
			log.error("Flat File=["+str);
			event = new UbizhjsAlpsinvGlovisEvent();			
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);

			((UbizhjsAlpsinvGlovisEvent) event).setFlatFile(str);
			((UbizhjsAlpsinvGlovisEvent) event).setIntegrationId(integrationId);
			accountReceivableInvoiceMgtSC.perform(event);
			
			log.error("<<<<<<<<<< interfaceGlovisInvoiceToINV End >>>>>>>>>>>>>>>>");
			
		} catch (EventException ee) {
			log.error("EventException ee : " + ee.toString(), ee);
			eai.rollback(ee);
			throw new EventException(new ErrorHandler("INV00066").getMessage(), ee);
		} catch (Exception e){
			log.error("Exception e : " + e.toString());
			eai.rollback(e);
			throw new EventException(new ErrorHandler("INV00066").getMessage(), e);
		}
		eai.close();
	}
	
	
	/**
	 * MQ Receive(EurEmailServer EDI - INV.ALPSINV_UBIZHJS_APERAK.IBMMQ.QUEUE)<br>
	 * @param eai
	 * @throws EventException
	 */
	public void receiveEdiFromEurEmailServer(TransferEAI eai) throws EventException {
		
		log.error("<<<<<<<<<< interfaceEurEmailServerInvoiceToINV Start >>>>>>>>>>>>>>>>");	
		Event event = null;
		AccountReceivableInvoiceMgtSC accountReceivableInvoiceMgtSC = new AccountReceivableInvoiceMgtSC();
		try {
			
			String str = eai.getMessage();
			String integrationId = eai.getIntegrationID(); 
			log.error("Flat File=["+str);
			event = new UbizhjsAlpsinvCommonEvent();			
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);
			
			((UbizhjsAlpsinvCommonEvent) event).setFlatFile(str);
			((UbizhjsAlpsinvCommonEvent) event).setIntegrationId(integrationId);
			accountReceivableInvoiceMgtSC.perform(event);
			
			log.error("<<<<<<<<<< interfaceEurEmailServerInvoiceToINV End >>>>>>>>>>>>>>>>");
			
		} catch (EventException ee) {
			log.error("EventException ee : " + ee.toString(), ee);
			eai.rollback(ee);
			throw new EventException(new ErrorHandler("INV00066").getMessage(), ee);
		} catch (Exception e){
			log.error("Exception e : " + e.toString());
			eai.rollback(e);
			throw new EventException(new ErrorHandler("INV00066").getMessage(), e);
		}
		eai.close();
	}
	
	
	/**
	 * MQ Receive(INV.ALPSINV_UBIZHJS_APERAK.IBMMQ.QUEUE)<br>
	 * @param TransferEAI eai
	 * @exception EventException, Exception
	 */
	public void receiveEdiOthers(TransferEAI eai) throws EventException {

		log.error("<<<<<<<<<< receiveEdiFromOthers Start >>>>>>>>>>>>>>>>");	
		Event event = null;
		AccountReceivableInvoiceMgtSC accountReceivableInvoiceMgtSC = new AccountReceivableInvoiceMgtSC();
		try {
			
			String str = eai.getMessage();
			String integrationId = eai.getIntegrationID(); 
			log.error("Flat File=["+str);
			event = new UbizhjsAlpsinvCommonEvent();			
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);

			((UbizhjsAlpsinvCommonEvent) event).setFlatFile(str);
			((UbizhjsAlpsinvCommonEvent) event).setIntegrationId(integrationId);
			accountReceivableInvoiceMgtSC.perform(event);
			
			log.error("<<<<<<<<<< receiveEdiFromOthers End >>>>>>>>>>>>>>>>");
			
		} catch (EventException ee) {
			log.error("EventException ee : " + ee.toString(), ee);
			eai.rollback(ee);
			throw new EventException(new ErrorHandler("INV00066").getMessage(), ee);
		} catch (Exception e){
			log.error("Exception e : " + e.toString());
			eai.rollback(e);
			throw new EventException(new ErrorHandler("INV00066").getMessage(), e);
		}
		eai.close();
	}
	
		
}
