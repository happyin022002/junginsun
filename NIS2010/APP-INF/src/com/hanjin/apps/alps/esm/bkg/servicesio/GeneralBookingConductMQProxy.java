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

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookinghistorymgt.event.EsmBkgUsaTmlEdiAckEvent;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.GeneralBookingConductSC;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.event.EsmBkg007902bEvent;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;

/**
 * It's GeneralBookingConductMQProxy.java
 * 
 * @author 
 * @see
 * @since J2EE 1.6 May 25, 2009
 */
public class GeneralBookingConductMQProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());

	/**
	 * JMS Receive(UBIZHJS_ALPSBKG_HJTBKG)<br>
	 * 
	 * @author Lee NamKyung
	 * @param  TransferEAI eai
	 * @exception EventException 
	 */
	public void receiptHjtTroEdiAck( TransferEAI eai ) throws EventException
	{
	     String str = eai.getMessage();
	     Event event = null;
	     GeneralBookingConductSC generalBookingConductSC = null;
	     
	     try {
	    	 event = new EsmBkg007902bEvent();
	    	 generalBookingConductSC = new GeneralBookingConductSC();
	    	 
	    	 FormCommand f = new FormCommand();
			 f.setCommand(FormCommand.MULTI02);
			 event.setFormCommand(f);
	    	 	    	 
	    	 if ( !"".equals(JSPUtil.getNullNoTrim(str)) ) {
		    	 ((EsmBkg007902bEvent)event).setFlatFile(str);
		    	 generalBookingConductSC.perform(event);
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
	 * MQ Receive(UBIZHJS_ALPSBKG_USTMNL_ACK)<br>
	 * 
	 * @param TransferEAI eai
	 * @author Jun Yong Jin
	 * @exception EventException, EAIException
	 */
	public void receiptUsaTmlEdiAck( TransferEAI eai ) throws EventException
	{
	     String str = eai.getMessage();
	     Event event = null;
	     GeneralBookingConductSC generalBookingConductSC = null;
	     try {
	    	 event = new EsmBkgUsaTmlEdiAckEvent();
	    	 generalBookingConductSC = new GeneralBookingConductSC();
	    	 
	    	 FormCommand f = new FormCommand();
			 f.setCommand(FormCommand.SEARCH);
			 event.setFormCommand(f);
	    	 	    	 
	    	 if ( !"".equals(JSPUtil.getNullNoTrim(str)) ) {
		    	 ((EsmBkgUsaTmlEdiAckEvent)event).setRcvMsg(str);
		    	 generalBookingConductSC.perform(event);
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

}