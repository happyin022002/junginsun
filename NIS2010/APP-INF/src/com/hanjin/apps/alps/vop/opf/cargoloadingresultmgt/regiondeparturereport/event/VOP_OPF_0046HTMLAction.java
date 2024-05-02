/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_OPF_0046HTMLAction.java
*@FileTitle : RDR Creation – Main
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.03 장강철
* 1.0 Creation
* --------------------------------------------------------------
* History
* 2011.06.29 이준범 [CHM-201111792-01]
* 제 목 : Cargo Handling Performance + RDR CREATION 화면 보완
* 내 용 : 1)Cargo Handling Performance - region Check 로직삭제
*       2) RDR CREATION - Region 선택 칼럼 삭제 요하며, Port 칼럼은 해당 VVD의 Turning port및 Normal Port check하여
*                      해당 Port의 Region의 last Port만 Select Box로 표시될수 있도록 처리 
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRCrtListOptionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CargoLoadingResultMgtSC로 실행요청<br>
 * - CargoLoadingResultMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author jang kang cheol
 * @see CargoLoadingResultMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_OPF_0046HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_OPF_0046HTMLAction 객체를 생성
	 */
	public VOP_OPF_0046HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CargoLoadingResultMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopOpf0046Event event = new VopOpf0046Event();
		

		if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setRDRCrtListOptionVO( (RDRCrtListOptionVO)getVO(request, RDRCrtListOptionVO .class));
		}
		if(command.isCommand(FormCommand.SEARCHLIST02)) {
			event.setRDRCrtListOptionVO( (RDRCrtListOptionVO)getVO(request, RDRCrtListOptionVO .class));
		}		
        if(command.isCommand(FormCommand.REMOVELIST )) {
            event.setRDRCrtListOptionVO( (RDRCrtListOptionVO)getVO(request, RDRCrtListOptionVO .class));
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