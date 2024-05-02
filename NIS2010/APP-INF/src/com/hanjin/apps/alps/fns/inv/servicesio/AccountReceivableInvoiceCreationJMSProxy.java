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
import org.apache.xmlbeans.XmlException;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.AccountReceivableInvoiceCreationSC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.bookingarcreation.event.Fns012R001Event;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicecreation.generalarinvoicecreation.event.Esm0670001Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.enisEsm.ESM0670001Document;
import com.hanjin.irep.erp.FNS012R001Document;
import com.jf.transfer.TransferEAI;

/**
 * It's AccountReceivableInvoiceCreationJMSProxy.java
 * 
 * @author Hyunsu, Ryu
 * @see
 * @since J2EE 1.6 May 25, 2009
 */
public class AccountReceivableInvoiceCreationJMSProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * JMS Receive(FNS012-R001)<br>
	 * 
	 * @param TransferEAI eai
	 * @exception EventException, XmlException, Exception
	 */
	public void modifyARInvoiceERPReturn(TransferEAI eai) throws EventException {

		log.debug("<<<<<<<<<< modifyARInvoiceERPReturn Start >>>>>>>>>>>>>>>>");		
		
		String str = eai.getMessage();
//		log.debug("======================================");
//		log.debug("xml : " + str);
//		log.debug("======================================");
		
		Event event = null;
		AccountReceivableInvoiceCreationSC accountReceivableInvoiceCreation = new AccountReceivableInvoiceCreationSC();
		
		try {
			event = new Fns012R001Event();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);

			FNS012R001Document doc = FNS012R001Document.Factory.parse(str);
			((Fns012R001Event) event).setXmlObject(doc);
			accountReceivableInvoiceCreation.perform(event);
			
			log.debug("<<<<<<<<<< modifyARInvoiceERPReturn End >>>>>>>>>>>>>>>>");
			
			eai.commit(doc.getFNS012R001().getEAIHeader().getInstanceId());
			
		} catch (EventException ee) {
			log.error("EventException ee : " + ee.toString(), ee);
			eai.rollback(ee);
			throw new EventException(new ErrorHandler("INV00066").getMessage(), ee);
		} catch (XmlException ex) {
			log.error("XmlException ex : " + ex.toString(), ex);
			eai.rollback(ex);
			throw new EventException(new ErrorHandler("INV00066").getMessage(), ex);
		} catch (Exception e){
			log.error("Exception e : " + e.toString());
			eai.rollback(e);
			throw new EventException(new ErrorHandler("INV00066").getMessage(), e);
		}
		eai.close();
	}
	
	/**
	 * JMS Receive(ESM067_0001)<br>
	 * 
	 * @param TransferEAI eai
	 * @exception EventException, XmlException, Exception
	 */
	public void interfaceDomesticARInvoiceToINV(TransferEAI eai) throws EventException {

		log.debug("<<<<<<<<<< modifyARInvoiceERPReturn Start >>>>>>>>>>>>>>>>");		
		
		String str = eai.getMessage();
//		log.debug("======================================");
//		log.debug("xml : " + str);
//		log.debug("======================================");
		
		Event event = null;
		AccountReceivableInvoiceCreationSC accountReceivableInvoiceCreation = new AccountReceivableInvoiceCreationSC();
		
		try {
			event = new Esm0670001Event();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);

			ESM0670001Document doc = ESM0670001Document.Factory.parse(str);
			((Esm0670001Event) event).setXmlObject(doc);
			accountReceivableInvoiceCreation.perform(event);
			
			log.debug("<<<<<<<<<< interfaceDomesticARInvoiceToINV End >>>>>>>>>>>>>>>>");
			
			eai.commit(doc.getESM0670001().getEAIHeader().getInstanceId());
			
		} catch (EventException ee) {
			log.error("EventException ee : " + ee.toString(), ee);
			eai.rollback(ee);
			throw new EventException(new ErrorHandler("INV00066").getMessage(), ee);
		} catch (XmlException ex) {
			log.error("XmlException ex : " + ex.toString(), ex);
			eai.rollback(ex);
			throw new EventException(new ErrorHandler("INV00066").getMessage(), ex);
		} catch (Exception e){
			log.error("Exception e : " + e.toString());
			eai.rollback(e);
			throw new EventException(new ErrorHandler("INV00066").getMessage(), e);
		}
		eai.close();
	}
	
}
