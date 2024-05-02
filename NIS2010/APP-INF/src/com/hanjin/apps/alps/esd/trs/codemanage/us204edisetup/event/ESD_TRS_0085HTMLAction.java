/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_085HTMLAction.java
*@FileTitle : US 204 EDI Setup
*Open Issues :
*Change history :
*@LastModifyDate : 2012-04-22
*@LastModifier : 조인영
*@LastVersion : 1.0
* 2012-04-22 조인영
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.codemanage.us204edisetup.event.EsdTrs0085Event;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TrsEdiUsaRcvrDtlVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.codemanage.usaactualcustomercodemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CodeManageSC로 실행요청<br>
 * - CodeManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author 조인영
 * @see EsdTrs0085Event , ESD_TRS_085EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0085HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_085HTMLAction 객체를 생성 
	 */
	public ESD_TRS_0085HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_085Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		 FormCommand command = FormCommand.fromRequest(request);
	  	  EsdTrs0085Event event = new EsdTrs0085Event();
	  	  
	  	TrsEdiUsaRcvrDtlVO trsEdiUsaRcvrDtlVO   = new TrsEdiUsaRcvrDtlVO();
	  	TrsEdiUsaRcvrDtlVO[] trsEdiUsaRcvrDtlVOs = null;
	  	
			if(command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCH01)) {
			  	String vndrSeq = JSPUtil.getParameter(request, "combo_svc_provider", "");
			  	String deltFlg = JSPUtil.getParameter(request, "delt_flg", "");
			  	event.setVndrSeq(vndrSeq);
			  	event.setDeltFlg(deltFlg);
			}else if(command.isCommand(FormCommand.MULTI))  {
				trsEdiUsaRcvrDtlVO.fromRequest(request);
				trsEdiUsaRcvrDtlVOs = trsEdiUsaRcvrDtlVO.fromRequestGrid(request);
				event.setTrsEdiUsaRcvrDtlVOs(trsEdiUsaRcvrDtlVOs);
				String login_ofc_cd = request.getParameter("login_ofc_cd")!=null?request.getParameter("login_ofc_cd"):"";
				String login_usr_id = request.getParameter("login_usr_id")!=null?request.getParameter("login_usr_id"):"";
				event.setLogin_ofc_cd(login_ofc_cd);
				event.setLogin_usr_id(login_usr_id);
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