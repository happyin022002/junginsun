/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName       : ESM_MAS_167HTMLActon.java
*@FileTitle      : 
*Open Issues     :
*Change history  :
*@LastModifyDate : 2009-02
*@LastModifier   : eunju park
*@LastVersion    : 1.0
* 2009-02 eunju park
* 1.0 최초 생성
* History
* 2009.03.31 박은주 S2K-09U-002(Lane Simulation System 개선)
* 2010.02.18 serialVersionUID 선언
=========================================================*/
package com.hanjin.apps.alps.esm.mas.lanesimulation.event;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.mas.common.Utils;
import com.hanjin.apps.alps.esm.mas.lanesimulation.vo.SearchTocHireListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.MasTmChtrOutHirVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.mas 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 LaneSimulationSC로 실행요청<br>
 * - LaneSimulationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author eunju park
 * @see EsmMas0167Event 참조
 * @since J2EE 1.6
 */
public class ESM_MAS_0167HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
    /**
     * ESM_MAS_0167HTMLAction 객체를 생성
     */
    public ESM_MAS_0167HTMLAction() {
    	//
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 ESM_MAS_167Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmMas0167Event event = new EsmMas0167Event();
  	
    	HashMap hash = new HashMap();
    	hash = Utils.requestToHashMap(request);
    	
        if(command.isCommand(FormCommand.MULTI01)){
  	    	event.setTmChtrOutHirVos((MasTmChtrOutHirVO[])getVOs(request, MasTmChtrOutHirVO .class));
  	    	event.setSearchTocHireListVOs((SearchTocHireListVO[])getVOs(request, SearchTocHireListVO .class));
  	    } 

        return  event;
    }

    /**
     * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
     * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @param eventResponse EventResponse interface를 구현한 객체
     */
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