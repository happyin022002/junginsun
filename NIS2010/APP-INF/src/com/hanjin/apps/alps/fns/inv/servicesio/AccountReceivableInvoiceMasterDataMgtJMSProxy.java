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

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.AccountReceivableInvoiceMasterDataMgtSC;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event.Fns0430001Event;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.irep.erp.FNS0430001Document;
import com.jf.transfer.TransferEAI;

/**
 * It's AccountReceivableInvoiceMasterDataMgtJMSProxy.java
 * 
 * @author Hyunsu, Ryu
 * @see
 * @since J2EE 1.6 May 25, 2009
 */
public class AccountReceivableInvoiceMasterDataMgtJMSProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * JMS Receive(FNS043-0001)<br>
	 * 
	 * @param TransferEAI eai
	 * @exception EventException, XmlException, Exception
	 */
	public void createRevenueAccountList(TransferEAI eai) throws EventException {

		log.debug("<<<<<<<<<< createRevenueAccountList Start >>>>>>>>>>>>>>>>");		
		
		String str = eai.getMessage();
		
		Event event = null;
		AccountReceivableInvoiceMasterDataMgtSC accountReceivableInvoiceMasterDataMgt = new AccountReceivableInvoiceMasterDataMgtSC();
		
		try {
			event = new Fns0430001Event();
			
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.SEARCH01);
			event.setFormCommand(f);

			FNS0430001Document doc = FNS0430001Document.Factory.parse(str);
			((Fns0430001Event) event).setXmlObject(doc);
			accountReceivableInvoiceMasterDataMgt.perform(event);
			
			log.debug("<<<<<<<<<< createRevenueAccountList End >>>>>>>>>>>>>>>>");
			
			eai.commit(doc.getFNS0430001().getEAIHeader().getInstanceId());
			
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
