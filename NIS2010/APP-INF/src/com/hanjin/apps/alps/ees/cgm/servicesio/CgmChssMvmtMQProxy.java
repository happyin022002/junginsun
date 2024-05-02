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
package com.hanjin.apps.alps.ees.cgm.servicesio;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.MovementMnrHistorySC;
import com.hanjin.apps.alps.ees.cgm.movementmnrhistory.chassismovementhistory.event.UbizhjsAlpsCgmMvmtEvent;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.MNRCommonSC;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
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
	    		 Event event = new UbizhjsAlpsCgmMvmtEvent();
	 			 FormCommand f = new FormCommand();
	 			 f.setCommand(FormCommand.MULTI01);
	 			 event.setFormCommand(f);
	 			
	 			((UbizhjsAlpsCgmMvmtEvent) event).setFlatFile(str);
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
	    		Event event = new UbizhjsAlpsCgmMvmtEvent();
	 			FormCommand f = new FormCommand();
	 			f.setCommand(FormCommand.MULTI02);
	 			event.setFormCommand(f);
	 			
	 			((UbizhjsAlpsCgmMvmtEvent) event).setFlatFile(str);
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