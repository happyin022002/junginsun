/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualScheduleManagementJMSProxy.java
*@FileTitle : ENIS Interface Link
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
 =========================================================*/
package com.clt.apps.opus.vop.vsk.servicesio;

import org.apache.log4j.Logger;

import com.clt.apps.opus.vop.vsk.actualschedulemanagement.ActualScheduleManagementSC;
import com.clt.apps.opus.vop.vsk.actualschedulemanagement.actualschedulemgt.event.UdevVskTActskdEvent;
import com.clt.bizcommon.erpcom.ReceiveQueueRSC;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;

/**
 *  Getting String Message from JMS, over to ActualScheduleManagementJMSProxy. [Warn] Define method in queue-mapping.xml
 *
 * @author 
 * @see ReceiveQueueRSC
 * @since J2EE 1.4
 */
public class ActualScheduleManagementMQProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * MQ Receive(OPUSVSK_UBIZCOM_VENDOR_VSK)<br>
	 * 
	 * @param TransferEAI eai
	 * @exception EventException
	 */
	public void receiveEDIToTerminal(TransferEAI eai) throws EventException {
		String str = eai.getMessage();
		log.debug("=====================================================");
		log.debug("[ActualScheduleManagementMQProxy]");
		log.debug(str);
		log.debug("=====================================================");
		Event event = null;
		ActualScheduleManagementSC sc = new ActualScheduleManagementSC();

		try{
			event = new UdevVskTActskdEvent();
	
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI01);
			event.setFormCommand(f);
			
			((UdevVskTActskdEvent) event).setFlatFile(str);
			sc.perform(event);
			eai.commit(str.substring(0,10));
		} catch (EventException e) {
			eai.rollback(e);			
			log.error("err " + e.toString(), e);
			throw new EventException(e.getMessage());
		} catch (Exception e) {
			eai.rollback(e);
			log.error(" Exception e : " + e.toString() );	
			throw new EventException(e.getMessage());
		}
		eai.close();
	}
}
