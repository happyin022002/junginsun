/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_SCE_0038HTMLAction.java
*@FileTitle : ESD_SCE_0038HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2009-09-18
*@LastModifier : 전병석
*@LastVersion : 1.4
* 2006-11-16 Seong-mun Kang
* 1.0 최초 생성
* 2009-09-18
* 1.4 버전 커밋
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.visibilitymanage.cargotracking.vo.CargoTrackingOptionsVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchCLMListOptionsVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.sce 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ExceptionManageSC로 실행요청<br>
 * - ExceptionManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Seong-mun Kang
 * @see EsdSce038Event , EsdSce038EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0038HTMLAction extends HTMLActionSupport{
	private static final long serialVersionUID = 1L;
	/**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsdSce0038Event로 파싱하여 request에 셋팅<br>
     * 
     * @param HttpServletRequest request
     * @return Event
     * @exception HTMLActionException
     */
	public Event perform (HttpServletRequest request) throws HTMLActionException {
		log.debug("Event 0038 생성");
    	FormCommand command = FormCommand.fromRequest(request);
		EsdSce0038Event event = new EsdSce0038Event();
		
        if (command.isCommand(FormCommand.SEARCHLIST)) {
			log.debug("VO(CargoTrackingOptionsVO) 정의하였습니다.");
			event.setCtopt((CargoTrackingOptionsVO) getVO(request,CargoTrackingOptionsVO.class));
		}else if(command.isCommand(FormCommand.SEARCH)) {
			log.debug("VO(CargoTrackingOptionsVO) 정의하였습니다.");
			event.setCtopt((CargoTrackingOptionsVO) getVO(request,CargoTrackingOptionsVO.class));			
		}//if
		request.setAttribute("Event", event);
		return  event;
    }
	 
    /**
     * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
     * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
     * 
     * @param HttpServletRequest request
     * @param EventResponse eventResponse
     */
    public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
        request.setAttribute("EventResponse", eventResponse);
    }
    /** HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
     * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
     * 
     * @param HttpServletRequest request
     * @param Event event
     */
    public void doEnd(HttpServletRequest request, Event event) {
        request.setAttribute("Event", event);
    }
}
