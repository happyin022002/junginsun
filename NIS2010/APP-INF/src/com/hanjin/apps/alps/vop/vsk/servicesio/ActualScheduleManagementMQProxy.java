/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ActualScheduleManagementJMSProxy.java
*@FileTitle : ENIS Interface 연동 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.28
*@LastModifier : 서창열
*@LastVersion : 1.1
* 2007-04-10 
* 1.0 최초 생성
* 2009.08.26 서창열
* 1.1 Creation (NIS2010 new F/W 전환작업)
 =========================================================*/
package com.hanjin.apps.alps.vop.vsk.servicesio;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.ActualScheduleManagementSC;
import com.hanjin.apps.alps.vop.vsk.actualschedulemanagement.actualschedulemgt.event.UdevhjsAlpsvskTActskdEvent;
import com.hanjin.bizcommon.erpcom.ReceiveQueueRSC;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;

/**
 *  JMS 서버에서 String 메세지를 받아 ActualScheduleManagementJMSProxy 에 넘겨준다. Event 관리를 한다. [주의]queue-mapping.xml에 메서드가 정의 되어 있어야 한다.
 *
 * @author 서창열
 * @see ReceiveQueueRSC
 * @since J2EE 1.4
 */
public class ActualScheduleManagementMQProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * MQ Receive(UBIZHJS_NIS2010VSK_ACTSKD)<br>
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
			event = new UdevhjsAlpsvskTActskdEvent();
	
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI01);
			event.setFormCommand(f);
			
			((UdevhjsAlpsvskTActskdEvent) event).setFlatFile(str);
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
