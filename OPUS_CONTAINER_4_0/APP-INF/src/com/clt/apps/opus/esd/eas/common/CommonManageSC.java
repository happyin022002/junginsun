/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : 
*@FileTitle : Common PopUp
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.eas.common;

import com.clt.apps.opus.esd.eas.common.popup.basic.CommonPopUpManageBC;
import com.clt.apps.opus.esd.eas.common.popup.basic.CommonPopUpManageBCImpl;
import com.clt.apps.opus.esd.eas.common.popup.event.EsdEasCom0001Event;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.framework.support.layer.service.ServiceCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;


/**
 * ESD-EAS Business Logic ServiceCommand<br>
 * - ESD-EAS handling business transaction.<br>
 */
public class CommonManageSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;
	private String sofficeCd = "";

	/**
	 * EAS preceding process for biz scenario<br>
	 * CommonManage related objects creation<br>
	 */
	public void doStart() {
		try {

			account=getSignOnUserAccount();
			sofficeCd = account.getOfc_cd();
		} catch (Exception e) {
			log.error("CommonManageSC Operation error" + e.toString(), e);
		}
	}

	/**
	 * EAS biz scenario closing<br>
	 * CommonManageSC clearing related objects<br>
	 */
	public void doEnd() {
		// command.doEnd();
		log.debug("CommonManageSC End");
	}

	/**
	 *
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;


		if (e.getEventName().equalsIgnoreCase("EsdEasCom0001Event")) {
			if (e.getFormCommand().isCommand(FormCommand.SEARCH03)) { 
				eventResponse = searchOfcManage(e);
			}
		} else {
			eventResponse = null;
		}
		
		return eventResponse;
	}

	/**
	 * Handling Search event about CommonManageSC <br>
	 * Request Corretion Container Check<br>
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOfcManage(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsdEasCom0001Event event = (EsdEasCom0001Event)e;
		EventResponse eventResponse = null;
		
		try {
			CommonPopUpManageBC command = new CommonPopUpManageBCImpl();
			eventResponse = command.searchServiceOfficeCodeManage(event);
		} catch (EventException de) {
			log.error("err " + de.toString(), de);
			throw new EventException(de.getMessage());
		}
		return eventResponse;
	}

}
