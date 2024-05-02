/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName 		: EES_EQR_1026HTMLAction.java
*@FileTitle 	:Discharging result
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :  
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1026ConditionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
//import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * @author 
 * @see RepoPlanManageEvent 참조
 * @since J2EE 1.6
 */
public class EES_EQR_1026HTMLAction extends HTMLActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * EES_EQR_1026HTMLAction 
	 */
	public EES_EQR_1026HTMLAction() {}

	/**
	 * HTML DOM 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
//    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr1026Event event = new EesEqr1026Event();
		
		EesEqr1026ConditionVO eesEqr1026ConditionVO = new EesEqr1026ConditionVO(); 
		
		eesEqr1026ConditionVO = (EesEqr1026ConditionVO)getVO(request, EesEqr1026ConditionVO.class);
		
		event.setEesEqr1026ConditionVO(eesEqr1026ConditionVO);

		
		return  event;
	}

	/**
	 * HttpRequest attribute<br>
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}