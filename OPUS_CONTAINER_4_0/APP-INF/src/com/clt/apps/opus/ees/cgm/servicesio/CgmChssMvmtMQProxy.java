/* =========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : CgmChssMvmtMQProxy.java
 *@FileTitle : Receive Estimate IBMMQ Proxy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-08-27
 *@LastModifier : 최민회
 *@LastVersion : 1.0
 * 2009-08-27
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.ees.cgm.servicesio;

import org.apache.log4j.Logger;

import com.clt.apps.opus.ees.cgm.movementmnrhistory.MovementMnrHistorySC;
import com.clt.apps.opus.ees.cgm.movementmnrhistory.chassismovementhistory.event.UbizownOPUSCgmMvmtEvent;
import com.clt.apps.opus.ees.mnr.mnrcommon.MNRCommonSC;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;

/**
 * CgmChssMvmtMQProxy
 *  
 * @author 최민회
 * @see MNRCommonSC
 * @since J2EE 1.4 
 */
   
public class CgmChssMvmtMQProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * MQ Receive(receiveEstimateFromCEDEX)<br>
	 * 
	 * @param eai TransferEAI 
	 * @exception EventException ,EAIException
	 */
	public void poolMvmtReceive( TransferEAI eai ) throws EventException
	{	
	     String str = eai.getMessage();
	      
	     try {
	    	 MovementMnrHistorySC movementMnrHistorySC = new MovementMnrHistorySC();
	    	 if ( !"".equals(JSPUtil.getNullNoTrim(str))) {
	    		 Event event = new UbizownOPUSCgmMvmtEvent();
	 			 FormCommand f = new FormCommand();
	 			 f.setCommand(FormCommand.MULTI01);
	 			 event.setFormCommand(f);
	 			
	 			((UbizownOPUSCgmMvmtEvent) event).setFlatFile(str);
	 			 movementMnrHistorySC.perform(event);
	    		// movementMnrHistorySC.managePoolMovementService(eai);
	    	 }
	    	 eai.commit(str.substring(0,10));   
	     } catch (EventException e) {
             eai.rollback(e);
	         log.error("err "+e.toString(), e);
	         throw new EventException(e.getMessage());
	 	 } catch (EAIException e) {
	 		 eai.rollback(e);  
	 		 log.error("err "+e.toString(), e); 
	 		 throw new EventException(e.getMessage()); 
	     } catch (Exception e) {
			 log.error("err " + e.toString(), e);
			 throw new EventException(e.getMessage());
		 }
	     eai.close();
	}

	/**
	 * MQ Receive(receiveEstimateFromCEDEX)<br>
	 * 
	 * @param eai TransferEAI 
	 * @exception EventException ,EAIException
	 */
	public void poolMnrInvoiceImport( TransferEAI eai ) throws EventException
	{	
	     String str = eai.getMessage();
	      
	     try {
	    	 MovementMnrHistorySC movementMnrHistorySC = new MovementMnrHistorySC();
	    	 
//	    		 movementMnrHistorySC.managePoolMnrInvoiceImport(eai);
	    		Event event = new UbizownOPUSCgmMvmtEvent();
	 			FormCommand f = new FormCommand();
	 			f.setCommand(FormCommand.MULTI02);
	 			event.setFormCommand(f);
	 			
	 			((UbizownOPUSCgmMvmtEvent) event).setFlatFile(str);
	 			movementMnrHistorySC.perform(event);
	    	  
	    	 eai.commit(str.substring(0,10));   
	     } catch (EventException e) {
             eai.rollback(e);
	         log.error("err "+e.toString(), e);
	         throw new EventException(e.getMessage());
	 	 } catch (EAIException e) {
	 		 eai.rollback(e);  
	 		 log.error("err "+e.toString(), e); 
	 		 throw new EventException(e.getMessage()); 
	     } catch (Exception e) {
			 log.error("err " + e.toString(), e);
			 throw new EventException(e.getMessage());
		 }
	     eai.close();
	}
	
	
	
}