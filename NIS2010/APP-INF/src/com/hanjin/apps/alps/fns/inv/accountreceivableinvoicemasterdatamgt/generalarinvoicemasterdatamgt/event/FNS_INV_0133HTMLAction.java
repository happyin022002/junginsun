/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : FNS_INV_0133HTMLAction.java
 * @FileTitle : EDI Submission (Philips)
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2012.12.03
 * @LastModifier : 9011620
 * @LastVersion : 1.0
 * 1.0 Creation 2012.12.03 9011620.
 */
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.PHILSLocationListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * Honey Well EDI에 대한 logic 처리
 * 
 * @author 9011620
 * @see 각 DAO Class 참조.
 * @since J2EE 1.4
 */
public class FNS_INV_0133HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Creating FNS_INV_0133HTMLAction's object
	 */
	public FNS_INV_0133HTMLAction() {}

	/**
	 * Get parameters from request.
	 * 
	 * @param request
	 * @return Event
	 * @exception HTMLActionException
	 */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		FnsInv0133Event event = new FnsInv0133Event();

		
		if(command.isCommand(FormCommand.MULTI)) {
            event.setPhilsLocationListVO((PHILSLocationListVO[])getVOs(request, PHILSLocationListVO.class, "sheet1_"));
	    } 
		
		request.setAttribute("Event", event);		
		return event;
	}

	/**
	 * Set logic process result to request.
	 * 
	 * @param request
	 * @param eventResponse
	 */
	@Override
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * Set value objects from request.
	 * 
	 * @param request
	 * @param event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}
