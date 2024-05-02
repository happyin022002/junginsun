/*=========================================================
*Copyright(c) 2006 CyberLogitec 
*@FileName : ESM_PRI_2211HTMLAction.java
*@FileTitle : Master RFA Inquiry (& Copied RFA List) - B/L List
*Open Issues :
*Change history :
*@LastModifyDate : 2016-04-01
*@LastModifier : Jong-Ock Kim
*@LastVersion : 1.0
* 2016-04-01 Jong-Ock Kim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esm.pri.rfareport.rfareport.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.MasterRFAConditionVO;
import com.hanjin.apps.alps.esm.pri.rfareport.rfareport.vo.RsltPriRFABlVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.event.EventSupport;

/**
 * ESM_PRI_2211HTMLAction PDTO(Data Transfer Object including Parameters)<br>
 * @author Jong-Ock Kim
 * @see EventSupport 참조
 * @since J2EE 1.4
 */
public class ESM_PRI_2211HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 6292978124068251371L;

	/**
     * ESM_PRI_2211HTMLAction 객체를 생성
     */
    public ESM_PRI_2211HTMLAction() {
    }

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmPri2211Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsmPri2211Event event = new EsmPri2211Event();
		log.debug("command "+command.getCommand());
		if(command.isCommand(FormCommand.SEARCHLIST01)){ 
			event.setMasterRFAConditionVO((MasterRFAConditionVO)getVO(request, MasterRFAConditionVO.class));
 		} else if(command.isCommand(FormCommand.MODIFY01)){

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
