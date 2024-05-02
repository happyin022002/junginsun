/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_0063HTMLAction.java
*@FileTitle : VVD Inquiry  팝업화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-22
*@LastModifier : 전병석
*@LastVersion : 1.3
* 2009-08-13 전병석
* 1.0 최초 생성
* 2009-09-22 전병석
* 1.3 버전 커밋
=========================================================*/
package com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.masterdatamanage.customeredidata.vo.SearchVesselSkdOptionsVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 UserManagerSC로 실행요청<br>
 * - UserManagerSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author yong_cheon_shin
 * @see ReserveSendManagerEvent , PNSendManagerEventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0063HTMLAction  extends HTMLActionSupport{
    
    /** Constructor
     * 
     */
	private static final long serialVersionUID = 1L;
    public ESD_SCE_0063HTMLAction(){
        
    }
    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 IbatchVisibilityEvent로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		log.debug("Event 0063 spawn.");
		EsdSce0063Event e = new EsdSce0063Event();
		FormCommand command = FormCommand.fromRequest(request);
	    //int iPage           = JSPUtil.getParameterAsInt(request, "iPage", 1);  
	      log.debug("Event 0063 spawn");
	       e.setSchVSlVO((SearchVesselSkdOptionsVO) getVO(request,SearchVesselSkdOptionsVO.class));
    	   e.setCommandClassName("BizCommonSC");
	       e.setFormCommand(command);

	       request.setAttribute("Event", e);
		return  e;
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