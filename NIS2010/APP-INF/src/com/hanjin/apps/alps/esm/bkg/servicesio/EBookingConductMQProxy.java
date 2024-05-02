/* =========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : EBookingConductMQProxy.java
 *@FileTitle : Receive WebLogic JMS Queue Proxy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-07-01
 *@LastModifier : Jun Yong Jin
 *@LastVersion : 1.0
 * 2009-07-01 
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.servicesio;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.EBookingConductSC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkgEBkgReceiptEvent;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;


/**
 * It's EBookingConductMQProxy.java
 * 
 * @author 
 * @see
 * @since J2EE 1.6 May 25, 2009
 */
public class EBookingConductMQProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * JMS Receive(FNS009-0001)<br>
	 * 
	 * @param eai TransferEAI
	 * @exception EventException, XmlException, Exception
	 */
	public void receiptXterRqst( TransferEAI eai ) throws EventException
	{
	     String str = eai.getMessage();
	     Event event = null;
	     try {
	    	 EBookingConductSC eBookingConductSC = new EBookingConductSC();
	    	 event = new EsmBkgEBkgReceiptEvent();
	    	 eBookingConductSC = new EBookingConductSC();
	    	 
	    	 FormCommand f = new FormCommand();
			 f.setCommand(FormCommand.SEARCH);
			 event.setFormCommand(f);
	    	 	    	 
	    	 if ( !"".equals(JSPUtil.getNullNoTrim(str)) ) {
		    	 ((EsmBkgEBkgReceiptEvent)event).setRcvMsg(str);
		    	 eBookingConductSC.perform(event);
	    	 }

	    	 eai.commit(str.substring(0,10));
	     } catch (EventException e) {
             eai.rollback(e);
	         throw new EventException(new ErrorHandler(e).getMessage(), e);
	 	 } catch (EAIException e) {
	 		 eai.rollback(e);
			 //throw new EAIException(e.getMessage());
	 		throw new EventException(new ErrorHandler(e).getMessage(), e);
	     }
	     eai.close();
	}

	/**
	 * isNull<br>
	 * 
	 * @param str String
	 * @return boolean
	 */
	public boolean isNull(String str) {
        return (str==null || str.trim().length()==0 || "null".equals(str));
    }
}