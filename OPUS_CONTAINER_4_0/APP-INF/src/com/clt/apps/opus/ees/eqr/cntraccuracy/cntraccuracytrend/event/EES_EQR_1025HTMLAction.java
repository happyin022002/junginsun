/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName 		: EES_EQR_1025HTMLAction.java
*@FileTitle 	: Loading Trend by Lane
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :  
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.eqr.cntraccuracy.cntraccuracytrend.vo.EesEqr1025ConditionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * @author 
 * @see RepoPlanManageEvent 
 * @since J2EE 1.6
 */
public class EES_EQR_1025HTMLAction extends HTMLActionSupport {
	/*
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	/**
	 * EES_EQR_1025HTMLAction 객체를 생성
	 */
	public EES_EQR_1025HTMLAction() {}

	/**
	 * HTML DOM Parsing<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr1025Event event = new EesEqr1025Event();
		
		EesEqr1025ConditionVO eesEqr1025ConditionVO = new EesEqr1025ConditionVO(); 
		
		eesEqr1025ConditionVO = (EesEqr1025ConditionVO)getVO(request, EesEqr1025ConditionVO .class);
		

		
		event.setEesEqr1025ConditionVO(eesEqr1025ConditionVO);

		if(command.isCommand(FormCommand.SEARCHLIST)){
			eesEqr1025ConditionVO.setEtaFmDt(eesEqr1025ConditionVO.getEtaFmDt().replaceAll("-",""));
			eesEqr1025ConditionVO.setEtaToDt(eesEqr1025ConditionVO.getEtaToDt().replaceAll("-",""));
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
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}