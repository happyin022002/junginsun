/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0005HTMLAction.java
*@FileTitle : Entry and Inquiry of Target Voyage Choose by Settlement Item
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.05.21 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.syscommon.common.table.JooStlVvdVO;
import com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt.jointoperationmasterdatamgt.vo.TargetVVDVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.fns.joo.jointoperationmasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 JointOperationMasterDataMgtSC로 실행요청<br>
 * - JointOperationMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Park Hee Dong
 * @see JointOperationMasterDataMgtEvent 참조
 * @since J2EE 1.6
 */

public class FNS_JOO_0005HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_JOO_0005HTMLAction 객체를 생성
	 */
	public FNS_JOO_0005HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 JointOperationMasterDataMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsJoo0005Event event = new FnsJoo0005Event();

		event.setTargetVVDVO((TargetVVDVO )getVO(request, TargetVVDVO .class));
		event.setJooCodeParamVO((JooCodeParamVO)getVO(request, JooCodeParamVO.class));
		event.setJoStlOptCd(request.getParameter("jo_stl_opt_cd"));

		if(command.isCommand(FormCommand.MULTI)) {
			JooStlVvdVO[] vos  = (JooStlVvdVO[])getVOs(request, JooStlVvdVO.class,"sheet1_");
			event.setJooStlVvdVOS(vos);
		}else if (command.isCommand(FormCommand.SEARCH01)){
			String currRow = request.getParameter("curr_row");
			
			JooStlVvdVO[] vos  = (JooStlVvdVO[])getVOs(request, JooStlVvdVO.class,"sheet1_");
			
			event.setJooStlVvdVO(vos[Integer.parseInt(currRow)]);
		}else if (command.isCommand(FormCommand.REMOVE)){
			JooStlVvdVO[] vos  = (JooStlVvdVO[])getVOs(request, JooStlVvdVO.class,"sheet1_");
			event.setJooStlVvdVOS(vos);
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