/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1041HTMLAction.java
 *@FileTitle : UsWharfageDecMgt
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.31
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.05.20 김민정
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfBlListCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.us.vo.UsWhfBlVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.wharfagemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WharFageMgtSC로 실행요청<br>
 * - WharfageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Kim Min Jeong
 * @see EsmBkg1041Event 참조
 * @since J2EE 1.4
 */
public class ESM_BKG_1041HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;

	/**
	 * ESM_BKG_1041HTMLAction 객체를 생성
	 */
	public ESM_BKG_1041HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 WharfageEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1041Event event = new EsmBkg1041Event();
		if (command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.COMMAND01))
		{
			event.setUsWhfBlListCondVO((UsWhfBlListCondVO) getVO(request, UsWhfBlListCondVO.class));
		}
		else if (command.isCommand(FormCommand.SEARCH02))
		{
			event.setKey(request.getParameter("key"));
		}
		else if (command.isCommand(FormCommand.SEARCH01))
		{
			event.setUsWhfBlListCondVO((UsWhfBlListCondVO) getVO(request, UsWhfBlListCondVO.class));
		}
		else if (command.isCommand(FormCommand.MULTI))
		{
			UsWhfBlVO[] usWhfBlVOs = (UsWhfBlVO[]) getVOs(request, UsWhfBlVO.class);
			for (int i = 0; i < usWhfBlVOs.length; i++)
			{
				usWhfBlVOs[i].setVslCd(request.getParameter("vvd").substring(0, 4));
				usWhfBlVOs[i].setSkdVoyNo(request.getParameter("vvd").substring(4, 8));
				usWhfBlVOs[i].setSkdDirCd(request.getParameter("vvd").substring(8));
				usWhfBlVOs[i].setPortCd(request.getParameter("port"));
				usWhfBlVOs[i].setIoBndCd(request.getParameter("bound"));
			}
			event.setUsWhfBlVOs(usWhfBlVOs);
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