/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_2100HTMLAction.java
*@FileTitle : Container Type Size Division
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.cim.cimcommon.cimcommon.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.event.EesCim2001Event;
import com.clt.apps.opus.ees.cim.cimcommon.cimcommon.vo.OscarBookingSearchVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchMovementListByContainerVO;
import com.clt.apps.opus.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchEDIMovementListVO;
import com.clt.apps.opus.ees.mst.equipmentleasehistory.leasesublease.vo.CntrStatusOptionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * parsing value from com.clt.apps.opus.ees.cim.cimcommon  screen as java variables
 * converting parsed information to Event, requesting to execute CimCommonSC with request
 * setting EvenetResponse transmitting result from CimCommonSC to View(JSP)as request
 * @author 
 * @see EesCim2100Event reference
 * @since J2EE 1.4
 */

public class EES_CIM_2001HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * creating EES_CIM_2100HTMLAction object
	 */
	public EES_CIM_2001HTMLAction() {}

	/**
	 * parsing value of HTML DOM object as java variables
	 * setting HttpRequst information parsed EesCim2100Event as request
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event 
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EesCim2001Event event = new EesCim2001Event();
		
		if(command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCH01) || command.isCommand(FormCommand.SEARCH02) || command.isCommand(FormCommand.SEARCH06)) {
			event.setOscarBookingSearchVO((OscarBookingSearchVO)getVO(request, OscarBookingSearchVO.class));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setSearchMovementListByContainerVO((SearchMovementListByContainerVO)getVO(request, SearchMovementListByContainerVO.class));
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setSearchEDIMovementListVO((SearchEDIMovementListVO)getVO(request, SearchEDIMovementListVO.class));
		}else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setContainerConditionVO((CntrStatusOptionVO)getVO(request, CntrStatusOptionVO .class));
		}else if(command.isCommand(FormCommand.MULTI) ){
			event.setOscarBookingSearchVOs((OscarBookingSearchVO[])getVOs(request, OscarBookingSearchVO .class,""));		
		}else if(command.isCommand(FormCommand.MULTI01) ){
			event.setOscarBookingSearchVOs((OscarBookingSearchVO[])getVOs(request, OscarBookingSearchVO .class,""));		
		}

		request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * saving business scenario result in attribute of HttpRequest
	 * setting ResultSet to request to transmit executing result from ServiceCommand to View(JSP)
	 * 
	 * @param request HttpServletRequest 
	 * @param eventResponse EventResponse 
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * setting HttpRequest parsing result as request
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event 
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}