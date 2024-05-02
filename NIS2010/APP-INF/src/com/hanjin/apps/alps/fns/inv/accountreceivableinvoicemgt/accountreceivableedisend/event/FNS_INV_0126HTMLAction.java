/**
 * Copyright(c) 2012 CyberLogitec
 * @FileName : FNS_INV_0126HTMLAction.java
 * @FileTitle : EDI Submission (Honey Well)
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2012.05.17
 * @LastModifier : Sang-Hyun Kim
 * @LastVersion : 1.0
 * 1.0 Creation 2012.05.17 Sang-Hyun Kim.
 */
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemgt.accountreceivableedisend.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * Honey Well EDI에 대한 logic 처리
 * 
 * @author Sang-Hyun Kim
 * @see 각 DAO Class 참조.
 * @since J2EE 1.4
 */
public class FNS_INV_0126HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Get parameters from request.
	 * 
	 * @param request
	 * @return Event
	 * @exception HTMLActionException
	 */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FnsInv0126Event event = new FnsInv0126Event();

		event.setRow(request.getParameter("row"));
		event.setOrderNos(request.getParameter("orderNos"));

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
