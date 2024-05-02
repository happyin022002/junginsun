/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName 		: EES_EQR_1066HTMLAction.java
*@FileTitle 	: Loading Trend by Port
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :  
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1066ConditionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.eqr.repoplanmanage 
 * @author 
 * @see RepoPlanManageEvent 
 * @since J2EE 1.6
 */
public class EES_EQR_1066HTMLAction extends HTMLActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * EES_EQR_1066HTMLAction 
	 */
	public EES_EQR_1066HTMLAction() {}

	/**
	 * HTML DOM <br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr1066Event event = new EesEqr1066Event();
		
		EesEqr1066ConditionVO eesEqr1066ConditionVO = new EesEqr1066ConditionVO(); 
		
		eesEqr1066ConditionVO = (EesEqr1066ConditionVO)getVO(request, EesEqr1066ConditionVO .class);
		
		event.setEesEqr1066ConditionVO(eesEqr1066ConditionVO);

		if(command.isCommand(FormCommand.SEARCHLIST)){
			eesEqr1066ConditionVO.setEtaFmDt(eesEqr1066ConditionVO.getEtaFmDt().replaceAll("-",""));
			eesEqr1066ConditionVO.setEtaToDt(eesEqr1066ConditionVO.getEtaToDt().replaceAll("-",""));
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