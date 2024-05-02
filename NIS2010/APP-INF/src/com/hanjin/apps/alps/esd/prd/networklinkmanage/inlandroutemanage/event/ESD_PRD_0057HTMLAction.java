/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_057HTMLAction.java
*@FileTitle : Inland Route 정보관리화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-08-03
*@LastModifier : kim kwijin
*@LastVersion : 1.0
* 2006-09-04 jungsunyong
* 1.0 최초 생성
* 2009-08-03 kimkwijin
* 1.1 수정
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteMsUSVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.InlandRouteUSDetVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.SearchConditionVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.inlandroutemanage.vo.lnlandRouteUSVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.prd.networklinkmanager 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 NetworkLinkManageSC로 실행요청<br>
 * - NetworkLinkManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author jungsunyong
 * @see ESD_PRD_057Event , ESD_PRD_057EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_PRD_0057HTMLAction extends HTMLActionSupport {

    /**
     * ESD_PRD_057HTMLAction 객체를 생성
     */
    public ESD_PRD_0057HTMLAction() {
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 ESD_PRD_057Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     * 
     * 2009/08/03 kim kiwjin 수정
     * 
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
    	EsdPrd0057Event event = new EsdPrd0057Event();
    	event.setAttribute("pgmNo", request.getServletPath().substring(1,13));
		
    	if(command.isCommand(FormCommand.SEARCHLIST)) { //FULL 기본데이타 조회
    		event.setInlandRouteUSVO((lnlandRouteUSVO)getVO(request, lnlandRouteUSVO .class));
    	}else if(command.isCommand(FormCommand.SEARCH)){ //FULL 상세데이타조회
    		event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
    	}else if(command.isCommand(FormCommand.MULTI)){// inland rout master 저장
    		event.setInlandRouteUSVOs((lnlandRouteUSVO[])getVOs(request,lnlandRouteUSVO.class,"" ));
    		event.setInlandRouteUSVO((lnlandRouteUSVO)getVO(request, lnlandRouteUSVO .class));
    	}else if(command.isCommand(FormCommand.MULTI01)){//inlnad rout detail 저장
    		event.setInlandRouteUSDetVOs((InlandRouteUSDetVO[])getVOs(request,InlandRouteUSDetVO.class,"" ));	
    		event.setInlandRouteMsUSVO((InlandRouteMsUSVO)getVO(request, InlandRouteMsUSVO.class));
    		
    	}else if(command.isCommand(FormCommand.MULTI02)){//SAVE AS
    		event.setInlandRouteUSDetVOs((InlandRouteUSDetVO[])getVOs(request,InlandRouteUSDetVO.class,"" ));
    		event.setInlandRouteMsUSVO((InlandRouteMsUSVO)getVO(request, InlandRouteMsUSVO.class));
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
    public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
        request.setAttribute("EventResponse", eventResponse);
    }

    /**
     * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
     * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @param event Event interface를 구현한 객체
     */
    public void doEnd(HttpServletRequest request, Event event) {
        request.setAttribute("Event", event);
    }

}
