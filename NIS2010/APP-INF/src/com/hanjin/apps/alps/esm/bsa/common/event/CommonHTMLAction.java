/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName 		: CommonHTMLAction.java
*@FileTitle 	:  
*Open Issues 	:
*Change history :
*@LastModifyDate: 2006-09-
*@LastModifier 	: Park Eun Ju
*@LastVersion 	: 1.0
* 2006-09-07 Park Eun Ju
* 1.0 최초 생성
=========================================================
* History :
* 2010.10.04 이행지 [CHM-201005758-01] BSA  Architecture 위배사항 수정 (CommonSC)
* 2015.06.08 김용습 [CHM-201536164] 주간 MAS Open에 따른 타모듈 프로그램 적용 요청
=========================================================
*/

package com.hanjin.apps.alps.esm.bsa.common.event;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bsa.common.Utils;
import com.hanjin.apps.alps.esm.bsa.common.vo.ComboVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.enis.esm.coa 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 LaneSimulationSC로 실행요청<br>
 * - LaneSimulationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Park Eun Ju
 * @see CommonEvent , ESM_BSA_CommonEventResponse 참조
 * @since J2EE 1.4
 */
@SuppressWarnings("serial")
public class CommonHTMLAction extends HTMLActionSupport {

    /**
     * ESM_BSA_CommonHTMLAction 객체를 생성
     */
    public CommonHTMLAction() {
    	//
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 ESM_BSA_053Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    @SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
        // 화면에 있는 컨트롤 변수들
    	FormCommand f_cmd = FormCommand.fromRequest(request);
    	CommonEvent event = new CommonEvent();   

    	HashMap hash = new HashMap();
    	hash = Utils.requestToHashMap(request);
    	event.setAttribute("fRequest", hash);
    	
        //event.setCommandClassName("CommonSC");
        event.setFormCommand(f_cmd);
        request.setAttribute("Event", event);
        

		event.setComboVO((ComboVO)getVO(request, ComboVO.class));
        
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