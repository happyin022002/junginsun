/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : EES_EQR_1041HTMLAction.java
*@FileTitle : LT ST OW Plan & Approval
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.vo.PlanAndApprovalConditionVO;
import com.clt.apps.opus.ees.eqr.cntrfcstsimul.onhirebalance.vo.PlanAndApprovalVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.eqr.cntrfcstsimul - HTML DOM Value Parsing<br>
 * @author 
 * @see CntrFcstSimulEvent 
 * @since J2EE 1.6
 */

public class EES_EQR_1041HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_1041HTMLAction 
	 */
	public EES_EQR_1041HTMLAction() {}

	/**
	 * HTML DOM Value Parsing<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr1041Event event = new EesEqr1041Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setPlanAndApprovalConditionVO((PlanAndApprovalConditionVO)getVO(request, PlanAndApprovalConditionVO .class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setPlanAndApprovalVOS((PlanAndApprovalVO[])getVOs(request, PlanAndApprovalVO .class,""));
		}else if(command.isCommand(FormCommand.MULTI02)) {
			event.setPlanAndApprovalVOS((PlanAndApprovalVO[])getVOs(request, PlanAndApprovalVO .class,""));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setAttribute("loc_grp_cd", request.getParameter("loc_grp_cd"));
			event.setAttribute("loc_cd", request.getParameter("loc_cd"));
		}

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
	 * HttpRequest attribute<br>
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}