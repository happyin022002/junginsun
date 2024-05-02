/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName       : ESD_TRS_0237HTMLAction.java
*@FileTitle      : Common Surcharge Management
*Open Issues     : 
*Change history  : 
*@LastModifyDate : 2014-11-05
*@LastModifier   : Hyungwook Choi
*@LastVersion    : 1.0
* 2014-11-05 Hyungwook Choi
* 1.0 최초 생성
=========================================================*/

package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.TrsComScgMgmtTpSzVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.agreementmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing
 * @author Hyungwook Choi
 * @see EsdTrs0237Event , ESD_TRS_0237EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0237HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
     * ESD_TRS_0220HTMLAction 객체를 생성
     */
    public ESD_TRS_0237HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 ESD_TRS_002Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
        FormCommand command = FormCommand.fromRequest(request);

        EsdTrs0237Event event = new EsdTrs0237Event();

        if(command.isCommand(FormCommand.SEARCH01)) {
            event.setTrsComScgMgmtTpSzVO((TrsComScgMgmtTpSzVO)getVO(request, TrsComScgMgmtTpSzVO.class));
        } else if(command.isCommand(FormCommand.MULTI01)) {
            event.setTrsComScgMgmtTpSzVOs((TrsComScgMgmtTpSzVO[])getVOs(request, TrsComScgMgmtTpSzVO.class, "sheet1_"));
        } else if(command.isCommand(FormCommand.REMOVE01)) {
            event.setTrsComScgMgmtTpSzVOs((TrsComScgMgmtTpSzVO[])getVOs(request, TrsComScgMgmtTpSzVO.class, "sheet1_"));
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
    public void doEnd(HttpServletRequest request, EventResponse eventResponse)
    {
        request.setAttribute("EventResponse", eventResponse);
    }

    /**
     * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
     * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @param event Event interface를 구현한 객체
     */
    public void doEnd(HttpServletRequest request, Event event)
    {
        request.setAttribute("Event", event);
    }

}