/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0060HTMLAction.java
*@FileTitle : Actual Activity Inquiry 팝업화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-11-04
*@LastModifier : 전병석
*@LastVersion : 1.3
* 2006-09-20 yongcheon_shin
* 1.0 최초 생성
* 2009-11-04 전병석
* 1.3 버전 커밋 
=========================================================*/
package com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.sce.masterdatamanage.customeredidata.vo.SearchEdiActivityInquiryDataOptionsVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 UserManagerSC로 실행요청<br>
 * - UserManagerSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author yong_cheon_shin
 * @see ReserveSendManagerEvent , PNSendManagerEventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0060HTMLAction  extends HTMLActionSupport{
    
    /** Constructor
     * 
     */
	private static final long serialVersionUID = 1L;
    public ESD_SCE_0060HTMLAction(){
        
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
	       EsdSce0060Event event = new EsdSce0060Event();
	       FormCommand f_cmd = FormCommand.fromRequest(request);
	       
	       if (f_cmd.isCommand(FormCommand.SEARCH01)) {
	    	   log.debug("Event 0060 spawn---SEARCH01");
	    	   event.setSearchEdiActivityInquiryDataOptionsVO((SearchEdiActivityInquiryDataOptionsVO) getVO(request,SearchEdiActivityInquiryDataOptionsVO.class));
	       }else{
	    	   
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
