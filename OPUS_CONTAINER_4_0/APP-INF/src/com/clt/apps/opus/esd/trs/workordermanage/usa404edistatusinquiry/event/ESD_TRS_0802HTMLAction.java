 /*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESD_TRS_0802HTMLAction.java
*@FileTitle : TRS STCC Manage
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.trs.workordermanage.usa404edistatusinquiry.vo.TrsStccVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author YoungHeon Lee
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.6
 */
public class ESD_TRS_0802HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_2003HTMLAction 객체를 생성
	 */
	public ESD_TRS_0802HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0802Event event = new EsdTrs0802Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setFrmStccCd(JSPUtil.getParameter(request, "frm_stcc_cd"));
			event.setFrmStccSeq(JSPUtil.getParameter(request, "frm_stcc_seq"));
			event.setFrmUnCmdtCd(JSPUtil.getParameter(request, "frm_un_cmdt_cd"));
			event.setTrsStccVO((TrsStccVO)getVO(request, TrsStccVO .class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setTrsStccVOs((TrsStccVO[])getVOs(request, TrsStccVO .class));
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
