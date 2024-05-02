/**
 * Copyright(c) 2013 CyberLogitec
 * @FileName : FNS_INV_0134HTMLAction.java
 * @FileTitle : Surcharge Description on Invoice
 * Open Issues :
 * Change history :
 * @LastModifyDate : 2013.05.14
 * @LastModifier : 김준호
 * @LastVersion : 1.0
 * 1.0 Creation 2013.05.14.
 */
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.generalarinvoicemasterdatamgt.vo.InvChgDescConvVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * Surcharge Description 등록,조회 처리
 * 
 * @author 김준호
 * @see 각 DAO Class 참조.
 * @since J2EE 1.4
 */
public class FNS_INV_0134HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * Creating FNS_INV_0134HTMLAction's object
	 */
	public FNS_INV_0134HTMLAction() {}

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
		FnsInv0134Event event = new FnsInv0134Event();

		
		if(command.isCommand(FormCommand.MULTI)) {
//			event.setInvChgDescConvVOs((InvChgDescConvVO[])getVOs(request, InvChgDescConvVO.class));
			event.setInvChgDescConvVOs((InvChgDescConvVO[])getVOs(request, InvChgDescConvVO.class, "sheet1_"));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setArHdQtrOfcCd(request.getParameter("ar_hd_qtr_ofc_cd"));
			event.setArOfcCd(request.getParameter("ar_ofc_cd"));
			event.setChgCd(request.getParameter("chg_cd"));
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
