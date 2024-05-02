/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : CommonSC.java
*@FileTitle      : Common
*Open Issues     :
*Change history  :
*@LastModifyDate : 
*@LastModifier   : 
*@LastVersion    : 1.0

=========================================================*/

package com.clt.apps.opus.esm.spc.common;

import com.clt.apps.opus.esm.spc.common.common.basic.CommonBC;
import com.clt.apps.opus.esm.spc.common.common.basic.CommonBCImpl;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * Common Business Logic ServiceCommand
 * - Handling business transaction for Common.
 * 
 * @author 
 * @see ComboxEventResponse,CommonDBDAO
 * @since J2EE 1.4
 */

public class CommonSC extends ServiceCommandSupport {

	SignOnUserAccount account = null;


	/**
	 * Common preceding process for biz scenario<br>
	 * Common Creating related object by calling work scenario<br>
	 */
	public void doStart() {
		try {
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error("CommonSC Error by preceding process  " + e.toString(), e);
		}
	}

	/**
	 * Common Handling for the end of working scenario<br>
	 * Common Romoving object by the end of work scenario<br>
	 */	
	public void doEnd() {
		log.debug("CommonSC End");
	}

	/**
	 * Handling working scenario of each event<br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */	
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;
		if (e.getEventName().equalsIgnoreCase("EsmSpcCodEvent")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCHLIST01)
				|| e.getFormCommand().isCommand(FormCommand.SEARCHLIST02)) {
				eventResponse = searchCommonCodeList(e);
			}
		}
		return eventResponse;
	}


	/**
	 * EsmSpcCodEvent retrieve event process<br>
	 * BSAManage  common code retrieve <br>
	 * 
     * @author
     * @param e Event
     * @return EventResponse
     * @exception EventException
     */		
	private EventResponse searchCommonCodeList(Event e) throws EventException {
		// Object including the result for user's request(DB Result set, object, parameter and etc)
		EventResponse eventResponse = null;

		try {
			CommonBC command = new CommonBCImpl();
			eventResponse = command.searchCommonCodeList(e);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}
}