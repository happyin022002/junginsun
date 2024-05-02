/* =========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : XmlEdiMQProxy.java
 *@FileTitle : Receive WebLogic JMS Queue Proxy by XML
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2010-12-30 
 * 1.0 Creation
 * ------------------------------------------------------
=========================================================*/
package com.clt.apps.opus.esm.bkg.servicesio;

import java.io.ByteArrayInputStream;

import org.apache.log4j.Logger;

import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.EBookingConductSC;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkgEBkgReceiptEvent;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;

/**
 * It's XmlEdiMQProxy.java
 * 
 * @author 
 * @see
 * @since J2EE 1.6
 */
public class XmlEdiMQProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * JMS Receive(xml)<br>
	 * 
	 * @param eai TransferEAI
	 * @exception EventException
	 */
	public void receiptXterRqst(TransferEAI eai) throws EventException {
		EBookingConductSC eBookingConductSC = null;
		Event event = null;
		FormCommand f = null;
		try {
	    	eBookingConductSC = new EBookingConductSC();
	    	event = new EsmBkgEBkgReceiptEvent();
	    	f = new FormCommand();
			f.setCommand(FormCommand.MULTI01);
			event.setFormCommand(f);
	    	((EsmBkgEBkgReceiptEvent)event).setRcvXls(new ByteArrayInputStream(eai.getByteMessage()));
	    	eBookingConductSC.perform(event);
		} catch (EventException e) {
			eai.rollback(e);
			throw new EventException(new ErrorHandler(e).getMessage(), e);
		} catch (Exception e) {
			eai.rollback(e);
			throw new EventException(new ErrorHandler(e).getMessage(), e);
		}
		eai.close();
	}

}
