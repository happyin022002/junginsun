/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName 		: VesselScheduleReceiveManagementMQProxy.java
*@FileTitle 	: Exchange vessel schedule among Alliance Shipping Company 
*Open Issues 	:
*Change history :
*@LastModifyDate: 2014.02.12
*@LastModifier 	: JEONG SANG-KI
*@LastVersion 	: 1.0
* 2014-02-12 
* 1.0 Initial Generation

==========================================================*/
package com.hanjin.apps.alps.vop.vsk.servicesio;

import org.apache.log4j.Logger;

import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.ScheduleExchangeManagementSC;
import com.hanjin.apps.alps.vop.vsk.scheduleexchangemanagement.schedulereceivemanagement.event.UbizhjsAlpsvskSkdAllianceEvent;
import com.hanjin.bizcommon.erpcom.ReceiveQueueRSC;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.jf.transfer.TransferEAI;

/**
 *  JMS 서버에서 String 메세지를 받아 VesselScheduleReceiveManagementMQProxy 에 넘겨준다. Event 관리를 한다. [주의]queue-mapping.xml에 메서드가 정의 되어 있어야 한다.
 *
 * @author JEONG SANG-KI
 * @see ReceiveQueueRSC
 * @since J2EE 1.6
 */
public class VesselScheduleReceiveManagementMQProxy {
	protected transient Logger log = Logger.getLogger(this.getClass().getName());
	
	/******************************************************************
	* MQ NAME DEFINITION
	* ================================================================
	* >> 1. Live_Inbound <<
	*	MQ 		: UBIZHJS_ALPSVSK_SKD_ALLIANCE
	*	Remote 	: 여의도 UBIZ1
	*	Local 	: ALPSVSK
	*	
	*	>> 2. Live_Outbound <<
	*	MQ 		: ALPSVSK_UBIZHJS_SKD_ALLIANCE
	*	Remote 	: ALPSVSK
	*	Local 	: 여의도 UBIZ1
	*	
	* ----------------------------------------------------------------
	*
	*	>> 3. Test_Inbound <<
	*	MQ 		: UDEVHJS_ALPSVSK_T_SKD_ALLIANCE
	*	Remote 	: 여의도 UDEVVesselScheduleReceiveManagementMQProxy
	*	Local 	: ALPSVSK_T
	*	
	*	>> 4. Test_Outbound <<
	*	MQ 		: ALPSVSK_T_UDEVHJS_SKD_ALLIANCE
	*	Remote 	: ALPSVSK_T
	*	Local 	: 여의도 UDEV
	******************************************************************/
	
	/**
	 * MQ Receive(UBIZHJS_NIS2010VSK_ACTSKD)<br>
	 * 
	 * @param TransferEAI eai
	 * @exception EventException
	 */
	public void receiveExchangeEDICKYHToCoastalSchedule(TransferEAI eai) throws EventException {
		
		String str = eai.getMessage();
		log.debug("\n=====================================================");
		log.debug("\n[VesselScheduleReceiveManagementMQProxy]\n");
		log.debug(str);
		log.debug("\n=====================================================");
		
		Event event = null;
		ScheduleExchangeManagementSC sc = new ScheduleExchangeManagementSC();

		try{
			event = new UbizhjsAlpsvskSkdAllianceEvent();
	
			FormCommand f = new FormCommand();
			f.setCommand(FormCommand.MULTI01);
			event.setFormCommand(f);
			
			((UbizhjsAlpsvskSkdAllianceEvent) event).setFlatFile(str);
			
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
