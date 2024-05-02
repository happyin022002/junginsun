/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TOTCOMMONHTMLAction.java
*@FileTitle : TOTCommon
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.05.25 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.VslVO;
import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxstandardprofitconclusion.vo.BackEndJobVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.MdmLaneVO;
import com.hanjin.apps.alps.fns.tot.totcommon.totfindcode.vo.TotCodeParamVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.syscommon.common.table.TotStlClzVO;
import com.hanjin.syscommon.common.table.VskVslPortSkdVO;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.fns.tot.totcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TOTCommonSC로 실행요청<br>
 * - TOTCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jang Chang Soo
 * @see TOTCommonEvent 참조
 * @since J2EE 1.6
 */

public class TOTCOMMONHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * TOTCOMMONHTMLAction 객체를 생성
	 */
	public TOTCOMMONHTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TOTCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		TotcommonEvent event = new TotcommonEvent();
		log.debug("TOTCommonAction 시작");
		if(command.isCommand(FormCommand.SEARCHLIST01)) {
			
			event.setVslVO((VslVO)getVO(request, VslVO.class));
			
		}else if(command.isCommand(FormCommand.SEARCHLIST02)) {
			
			event.setTotStlClzVO((TotStlClzVO)getVO(request, TotStlClzVO .class));
			event.setStlYr(event.getTotStlClzVO().getStlYr());
		}else if(command.isCommand(FormCommand.SEARCHLIST03)) {
			event.setTotCodeParamVO((TotCodeParamVO)getVO(request, TotCodeParamVO .class));
		}else if(command.isCommand(FormCommand.SEARCHLIST04)) {
			event.setMdmLaneVO((MdmLaneVO)getVO(request, MdmLaneVO .class));
		}else if(command.isCommand(FormCommand.SEARCHLIST05)) {
			event.setVskVslPortSkdVO((VskVslPortSkdVO)getVO(request, VskVslPortSkdVO .class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setBackEndJobVO((BackEndJobVO)getVO(request, BackEndJobVO.class));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setBackEndJobVO((BackEndJobVO)getVO(request, BackEndJobVO.class));
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