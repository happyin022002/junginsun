/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESD_TRS_0243HTMLAction.java
*@FileTitle : Contract Attach
*Open Issues :
*Change history :
*@LastModifyDate : 2014.09.23
*@LastModifier : CHOI JONG HYEK
*@LastVersion : 1.0
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.agreementmanage.contractattach.vo.SearchContractVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.codemanage.cnt.basic.CustomerNominatedTruckerRgstBC 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CodeManageSC로 실행요청<br>
 * - CodeManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author CHOI JONG HYEK
 * @see EsdTrs0243Event , ESD_TRS_243EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0243HTMLAction extends HTMLActionSupport {
	/**
	 * ESD_TRS_0243HTMLAction 객체를 생성
	 */
	public ESD_TRS_0243HTMLAction() {}
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_243Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0243Event event = new EsdTrs0243Event(); // table value object
		
		SearchContractVO searchContractVO = new SearchContractVO();
		SearchContractVO[] searchContractVOs = null;
		
		String sAgmtNo = JSPUtil.getParameter(request, "agmt_no ", "");
		String sFCtrtMnFlg = JSPUtil.getParameter(request, "f_ctrt_mn_flg ", "");
		event.setAgmtNo(sAgmtNo);
		event.setfCtrtMnFlg(sFCtrtMnFlg);
		
		if(command.isCommand(FormCommand.MULTI01) || command.isCommand(FormCommand.REMOVE) )  {			
			searchContractVO.fromRequest(request);
			searchContractVOs = searchContractVO.fromRequestGrid(request);
			event.setSearchContractVOs(searchContractVOs);
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

