/* =========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ReceiveEstimateFromCEDEXMQProxy.java
 *@FileTitle : Receive Estimate IBMMQ Proxy
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-08-27
 *@LastModifier : 박명신
 *@LastVersion : 1.0
 * 2009-08-27
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.servicesio;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.ees.mnr.mnrcommon.MNRCommonSC;
import com.hanjin.apps.alps.ees.mnr.mnrcommon.interfacemgt.event.MnrEDIInterfaceEvent;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;
import com.jf.transfer.eai.exception.EAIException;

/**
 * [UDEVHJS_ALPSMNR_T_WESTIM] ReceiveEstimateFromCEDEXMQProxy
 *  
 * @author 박명신 
 * @see MNRCommonSC
 * @since J2EE 1.4  
 */
   
public class ReceiveEstimateFromCEDEXMQProxy {

	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * MQ Receive(receiveEstimateFromCEDEX)<br>
	 * 
	 * @param transferEAI eai
	 * @author 박명신
	 * @exception EventException, EAIException
	 */
	public void receiveEstimateFromCEDEX( TransferEAI transferEAI ) throws EventException
	{	
	     String str = transferEAI.getMessage();
	     log.debug("\n===========================================" +
				   "\n[receiveEstimateFromCEDEX] : " + str +	
				   "\n===========================================\n");	
	     try {		 
	    	 Event event = new MnrEDIInterfaceEvent();
	    	 MNRCommonSC mNRCommonSC = new MNRCommonSC();
	    	 
	    	 if ( !"".equals(JSPUtil.getNullNoTrim(str))) {
	    		 FormCommand formCommand = new FormCommand(); 
	    		 formCommand.setCommand(FormCommand.COMMAND01); 
				 event.setFormCommand(formCommand);  
				 		
				 ((MnrEDIInterfaceEvent)event).setEdi_msg(str);
				 //MNRCommonSC -> COMMAND01
				 //manageMQEstimateService 
				 mNRCommonSC.perform(event);  
	    	 }			
			 transferEAI.commit(str.substring(0,10)); 
	     } catch (EventException e) {
             transferEAI.rollback(e);
	         log.error("err "+e.toString(), e);
	         throw new EventException(e.getMessage());
	 	 } catch (EAIException e) {
	 		 transferEAI.rollback(e);  
	 		 log.error("err "+e.toString(), e); 
	 		 throw new EventException(e.getMessage()); 
	     }
	     transferEAI.close();
	}
}