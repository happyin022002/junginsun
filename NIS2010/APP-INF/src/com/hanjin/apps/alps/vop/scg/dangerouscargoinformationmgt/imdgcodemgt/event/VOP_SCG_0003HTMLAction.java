/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0003HTMLAction.java
*@FileTitle : Segregation Table (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.27
*@LastModifier : 이도형
*@LastVersion : 1.0
* 2009.05.27 이도형
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgClssSegrListVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.ScgImdgCompGrpSegrListVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt.imdgcodemgt.vo.SegregationTableGrpVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.ScgImdgClssSegrVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.scg.dangerouscargoinformationmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DangerousCargoInformationMgtSC로 실행요청<br>
 * - DangerousCargoInformationMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Dohyoung Lee
 * @see DangerousCargoInformationMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_SCG_0003HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_SCG_0003HTMLAction 객체를 생성
	 */
	public VOP_SCG_0003HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DangerousCargoInformationMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopScg0003Event event = new VopScg0003Event();
		
		//containerVO--------------------------------------->
		SegregationTableGrpVO segregationTableGrpVO = new SegregationTableGrpVO();
		event.setSegregationTableGrpVO(segregationTableGrpVO);
		//<--------------------------------------------------

		if(command.isCommand(FormCommand.MULTI)) {
			event.getSegregationTableGrpVO().setScgImdgClssSegrListVOs((ScgImdgClssSegrListVO[])getVOs(request, ScgImdgClssSegrListVO .class, "sheet1_"));
			event.getSegregationTableGrpVO().setScgImdgCompGrpSegrListVOs((ScgImdgCompGrpSegrListVO[])getVOs(request, ScgImdgCompGrpSegrListVO .class, "sheet2_"));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setScgImdgClssSegrVO((ScgImdgClssSegrVO)getVO(request, ScgImdgClssSegrVO .class));
		}

		request.setAttribute("Event", event);

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