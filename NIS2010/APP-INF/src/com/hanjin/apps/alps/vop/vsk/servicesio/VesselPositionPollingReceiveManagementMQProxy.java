/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName 		: VesselPositionPollingReceiveManagementMQProxy.java
*@FileTitle 	: Receiving the position polling data
*Open Issues 	:
*Change history :
*@LastModifyDate: 2014.04.30
*@LastModifier 	: LIM YE-JI
*@LastVersion 	: 1.0
* 2014-04-30 
* 1.0 Initial Generation

==========================================================*/
package com.hanjin.apps.alps.vop.vsk.servicesio;
  
import org.apache.log4j.Logger;
import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.ExternalVesselInfoManagementSC;
import com.hanjin.apps.alps.vop.vsk.externalvesselinfomanagement.vesselpositionpollingmanagement.event.UbizhjsAlpsvskPositionPollEvent;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;

/**
 *  JMS 서버에서 String 메세지를 받아 VesselPositionPollingReceiveManagementMQProxy 에 넘겨준다. Event 관리를 한다. [주의]queue-mapping.xml에 메서드가 정의 되어 있어야 한다.
 *
 * @author LIM YE-JI
 * @see VesselPositionPollingReceiveManagementMQProxy
 * @since J2EE 1.6
 */

public class VesselPositionPollingReceiveManagementMQProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/**
	 * MQ Receive(UBIZHJS_ALPSVSK_POSITIONPOLL)<br>
	 * 
	 * @param TransferEAI eai
	 * @exception EventException
	 */
	public void receiveEDIToPositionPolling(TransferEAI eai) throws EventException {
		
		String str = eai.getMessage();
		log.debug("\n=====================================================");
		log.debug("\n[VesselPositionPollingReceiveManagementMQProxy]\n");
		log.debug(str);
		log.debug("\n=====================================================");
		
		Event event = null;
		ExternalVesselInfoManagementSC sc = new ExternalVesselInfoManagementSC();

		try{
			event = new UbizhjsAlpsvskPositionPollEvent();
	
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI01);
			event.setFormCommand(f);
			
			((UbizhjsAlpsvskPositionPollEvent) event).setFlatFile(str);
			
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



