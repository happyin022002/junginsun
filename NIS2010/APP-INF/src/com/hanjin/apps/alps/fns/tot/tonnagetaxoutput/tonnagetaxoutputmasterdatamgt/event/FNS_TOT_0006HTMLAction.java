
/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_TOT_0006HTMLAction.java
*@FileTitle : TOT
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.04
*@LastModifier : 장창수
*@LastVersion : 1.0
* 2009.06.04 장창수
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.fns.tot.tonnagetaxoutput.tonnagetaxoutputmasterdatamgt.vo.BsaVO;
import com.hanjin.syscommon.common.table.TotBsaVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.fns.tot.tonnagetaxoutput 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TonnageTaxOutputSC로 실행요청<br>
 * - TonnageTaxOutputSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jang Chang Soo
 * @see TonnageTaxOutputEvent 참조
 * @since J2EE 1.4
 */

public class FNS_TOT_0006HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_TOT_0006HTMLAction 객체를 생성
	 */
	public FNS_TOT_0006HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TonnageTaxOutputEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsTot0006Event event = new FnsTot0006Event();
        log.debug("::CALL::> FNS_TOT_0006HTMLAction - " + command.getCommand());
		
		if(command.isCommand(FormCommand.MULTI)) {
			 log.debug("::CALL::> MULTI ::::::::: ");
			event.setTotBsaVOs((TotBsaVO[])getVOs(request, TotBsaVO.class,"sheet1_"));
			 
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setBsaVO((BsaVO)getVO(request, BsaVO.class));
			
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setBsaVO((BsaVO)getVO(request, BsaVO.class));
			
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setTotBsaVO((TotBsaVO)getVO(request, TotBsaVO.class));
			
		}
		else if(command.isCommand(FormCommand.REMOVE01)) {
			event.setBsaVO((BsaVO)getVO(request, BsaVO.class));
			
		}
		else if(command.isCommand(FormCommand.MULTI01)) {
			event.setTotBsaVO((TotBsaVO)getVO(request, TotBsaVO.class));
			
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.setTotBsaVO((TotBsaVO)getVO(request, TotBsaVO.class));
			
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setBsaVO((BsaVO)getVO(request, BsaVO.class));
			
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