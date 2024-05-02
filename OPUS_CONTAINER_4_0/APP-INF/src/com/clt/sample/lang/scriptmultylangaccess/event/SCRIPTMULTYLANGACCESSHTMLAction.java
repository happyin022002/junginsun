/*========================================================
 *Copyright(c) 2009 CyberLogitec
 *ProcessChain    : NPI
 *@FileName       : SCRIPTMULTYLANGACCESSHTMLAction.java
 *@FileTitle      : NIS2010
 *Open Issues     :
 *Change history  :
 *@LastModifyDate : Jul 29, 2009
 *@LastModifier   : XXX
 *@LastVersion    : 1.0
=========================================================*/
package com.clt.sample.lang.scriptmultylangaccess.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.view.signon.web.SignOnFilter;
import com.clt.sample.code.event.CodeEvent;
import com.clt.sample.lang.multylangaccess.event.MultyLangEvent;
import com.clt.syscommon.common.table.ComUserVO;

/**
 * 
 * SCRIPTMULTYLANGACCESSHTMLAction.java
 * @author XXX
 * @see 
 * @since J2SE 1.6
 * 2016. 1. 11.
 */
public class SCRIPTMULTYLANGACCESSHTMLAction extends HTMLActionSupport {


	/**
	 * 
	 */
	private static final long serialVersionUID = 6702429447382066717L;

	public SCRIPTMULTYLANGACCESSHTMLAction() {}

	/**
	 * 
	 * perform
	 * @author XXX
	 * @param request
	 * @return
	 * @throws HTMLActionException Event
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		CodeEvent event = new CodeEvent();
		request.setAttribute("Event", event);
		return event;
	}
	
	/**
	 * 
	 * doEnd
	 * @author XXX
	 * @param request
	 * @param eventResponse void
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * 
	 * doEnd
	 * @author XXX
	 * @param request
	 * @param event void
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}
