/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : VOP_OPF_0046_05HTMLAction.java
*@FileTitle : RDR Creation – VSL Alloc
*Open Issues :
*Change history :
*@LastModifyDate : 2010.03.03
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2010.03.03 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRCrtListOptionVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RDRVslMvmtVO;
import com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt.regiondeparturereport.vo.RdrCreatInfoVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.opf.cargoloadingresultmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CargoLoadingResultMgtSC로 실행요청<br>
 * - CargoLoadingResultMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author jang kang cheol
 * @see CargoLoadingResultMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_OPF_0046_05HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_OPF_0046_05HTMLAction 객체를 생성
	 */
	public VOP_OPF_0046_05HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CargoLoadingResultMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopOpf004605Event event = new VopOpf004605Event();
		
        if(command.isCommand(FormCommand.SEARCHLIST01)) {//Retrieve
            event.setRDRCrtListOptionVO( (RDRCrtListOptionVO)getVO(request, RDRCrtListOptionVO .class));
        }
        if(command.isCommand(FormCommand.SEARCHLIST02)) {//Import 
            event.setRDRCrtListOptionVO( (RDRCrtListOptionVO)getVO(request, RDRCrtListOptionVO .class));
        }
        if(command.isCommand(FormCommand.MULTI01)) {//SAVE
            event.setRDRCrtListOptionVO( (RDRCrtListOptionVO)getVO(request, RDRCrtListOptionVO .class));
            event.setRdrCreatInfoVOs( (RdrCreatInfoVO[])getVOs(request, RdrCreatInfoVO .class,"sheet1_")  );
        }
        if(command.isCommand(FormCommand.REMOVE)) {//Delete
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