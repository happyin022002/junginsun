/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : EES_DOD_0009HTMLAction.java   
*@FileTitle : Collection Summary
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-20
*@LastModifier : Won-Ki Eo
*@LastVersion : 1.0
* 2016-05-20 Won-Ki Eo
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionaudit.vo.CollectionAuditINVO;
import com.hanjin.apps.alps.ees.dod.dodreport.collectionsummary.vo.SumbyOfcVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * EES_DOD_0009HTMLAction PDTO(Data Transfer Object including Parameters)<br>
 * @author Jeong-Min Park
 * @see EventSupport 참조
 * @since J2EE 1.4 
 */
public class EES_DOD_0009HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 7291304329715313988L;

	/**
     * EES_DOD_0009HTMLAction 객체를 생성
     */
    public EES_DOD_0009HTMLAction() {
    }

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EesDod0009Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EesDod0009Event event = new EesDod0009Event();
		event.setAttribute("KEY", request.getParameter("backendjob_key"));

		if(command.isCommand(FormCommand.SEARCHLIST01)){ 
			event.setSumbyOfcVO((SumbyOfcVO)getVO(request, SumbyOfcVO.class));
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
