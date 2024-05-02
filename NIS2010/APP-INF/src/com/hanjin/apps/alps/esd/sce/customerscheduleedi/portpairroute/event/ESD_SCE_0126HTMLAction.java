/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_SCE_0126HTMLAction.java
 *@FileTitle : Ocean Route Information
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009-09-17
 *@LastModifier : 
 *@LastVersion : 1.0
 * 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchConditionVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteConditionVO;
import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairroute.vo.PortPairRouteDetailVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.prd.networklinkmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 NetworkLinkManageSC로 실행요청<br>
 * - NetworkLinkManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author kimyoungchul
 * @see EsdSce0126Event , ESD_SCE_0126EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0126HTMLAction extends HTMLActionSupport{

	/**
	 * ESD_SCE_0126HTMLAction 객체를 생성
	 */
	public ESD_SCE_0126HTMLAction(){
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_SCE_0126Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException{		
		EsdSce0126Event event = new EsdSce0126Event();
//		event.setAttribute("pgmNo", request.getServletPath().substring(1,13));
		FormCommand command = FormCommand.fromRequest(request);
        if(command.isCommand(FormCommand.SEARCH)) {
        	event.setPortPairRouteConditionVO((PortPairRouteConditionVO) getVO(request,
					PortPairRouteConditionVO.class));
//			event.setPortPairRouteDetailVOs((PortPairRouteDetailVO[]) getVOs(request, PortPairRouteDetailVO.class, ""));
			event.setPortPairRouteDetailVO((PortPairRouteDetailVO) getVO(request, PortPairRouteDetailVO.class));
        	
		}
		 
		request.setAttribute("Event", event);
		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface를 구현한 객체
	 */
	@Override
	public void doEnd(HttpServletRequest request, EventResponse eventResponse){
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event){
		request.setAttribute("Event", event);
	}
}
