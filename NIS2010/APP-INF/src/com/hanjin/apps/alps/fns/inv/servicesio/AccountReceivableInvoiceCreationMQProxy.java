/* =========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : AccountReceivableInvoiceMasterDataMgtJMSProxy.java
 *@FileTitle : Receive WebLogic JMS Queue Proxy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-07-20
 *@LastModifier : Jung Hwi Taek
 *@LastVersion : 1.0
 * 2009-06-19 
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.fns.inv.servicesio;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.AccountReceivableInvoiceCreationSC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.event.UbizhjsAlpsinvInvoicEvent;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;

/**
 * It's AccountReceivableInvoiceCreationMQProxy.java
 * 
 * @author Hyunsu, Ryu
 * @see
 * @since J2EE 1.6 May 25, 2009
 */
public class AccountReceivableInvoiceCreationMQProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * MQ Receive(터미널 Invoice Interface - UBIZHJS_ALPSINV_INVOIC)<br>
	 * 
	 * @param TransferEAI eai
	 * @exception EventException, Exception
	 */
	public void interfaceTerminalARInvoiceToINV(TransferEAI eai) throws EventException {

		log.debug("<<<<<<<<<< interfaceTerminalARInvoiceToINV Start >>>>>>>>>>>>>>>>");		
		
		Event event = null;
		AccountReceivableInvoiceCreationSC accountReceivableInvoiceCreation = new AccountReceivableInvoiceCreationSC();
		try {
			
			String str = eai.getMessage();
			String integrationId = eai.getIntegrationID(); 
			
			event = new UbizhjsAlpsinvInvoicEvent();			
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI);
			event.setFormCommand(f);

			((UbizhjsAlpsinvInvoicEvent) event).setFlatFile(str);
			((UbizhjsAlpsinvInvoicEvent) event).setIntegrationId(integrationId);
			accountReceivableInvoiceCreation.perform(event);
			
			log.debug("<<<<<<<<<< interfaceTerminalARInvoiceToINV End >>>>>>>>>>>>>>>>");
			
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
