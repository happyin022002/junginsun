/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1029HTMLAction.java
*@FileTitle : Cargo Flow Map
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.24
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.06.24 문중철
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.SearchOptionByFromToVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.es.cim.cntroperationperformancemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CNTROperatioNPerformanceMgtSC로 실행요청<br>
 * - CNTROperatioNPerformanceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author MUN JUNG CHEOL
 * @see CNTROperatioNPerformanceMgtEvent 참조
 * @since J2EE 1.4
 */
public class EES_CIM_1029HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * UI_CIM_1023HTMLAction 객체를 생성
	 */
	public EES_CIM_1029HTMLAction() {}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CNTROperatioNPerformanceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
    	EesCim1029Event event = new EesCim1029Event();
    	log.debug("#################  EES_CIM_1029HTMLAction");
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchOptionByFromToVO((SearchOptionByFromToVO)getVO(request, SearchOptionByFromToVO .class));
		}
		request.setAttribute("Event", event);
		return  event;
	}
}