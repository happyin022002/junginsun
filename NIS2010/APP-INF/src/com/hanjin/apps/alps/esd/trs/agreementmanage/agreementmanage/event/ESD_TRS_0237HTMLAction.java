/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : ESD_TRS_0237HTMLAction.java
 *@FileTitle : Agreement Confirm 권한 등록
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014-05-27
 *@LastModifier : 최종혁
 *@LastVersion : 1.1
 * 1.0 최초 생성
 * 
=========================================================*/

package com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.agreementmanage.agreementmanage.vo.SearchApprovalMgmtVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.agreementmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * @author jong hyek choi
 * @see EsdTrs0237Event , ESD_TRS_0237EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0237HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_0237Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);

		SearchApprovalMgmtVO searchApprovalMgmtVO   = new SearchApprovalMgmtVO();
		SearchApprovalMgmtVO[] tcz = null; 
		if(command.isCommand(FormCommand.MULTI01) || command.isCommand(FormCommand.REMOVE) ) {
			tcz = searchApprovalMgmtVO.fromRequestGrid(request);
		}
		EsdTrs0237Event event = new EsdTrs0237Event();
		String fmCfmUsrId          = request.getParameter("fm_cfm_usr_id")!=null?request.getParameter("fm_cfm_usr_id"):"";
		event.setFmCfmUsrId(fmCfmUsrId);
		
		String cfmUsrId          = request.getParameter("cfm_usr_id")!=null?request.getParameter("cfm_usr_id"):"";

		event.setCfmUsrId(cfmUsrId);

		event.setSearchApprovalMgmtVOs(tcz);
		
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
