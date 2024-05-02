/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESM_PRI_3502HTMLAction.java
*@FileTitle : Tariff Code Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2010.10.12
*@LastModifier : 서미진
*@LastVersion : 1.0
* 2010.10.12 서미진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.pri.tariff.tariffcode.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.InPriTariffVO;
import com.clt.apps.opus.esm.pri.tariff.tariffcode.vo.RsltSvcScpCdVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.PriTariffVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.pri.tariff 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TariffSC로 실행요청<br>
 * - TariffSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SEO MIJIN
 * @see TariffEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_3502HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_PRI_3502HTMLAction 객체를 생성
	 */
	public ESM_PRI_3502HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TariffEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri3502Event event = new EsmPri3502Event();
		
		if(command.isCommand(FormCommand.SEARCH01)) { 
			event.setPriTariffVO((PriTariffVO)getVO(request, PriTariffVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setRsltSvcScpCdVO((RsltSvcScpCdVO)getVO(request, RsltSvcScpCdVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI01)) { 
			event.setInPriTariffVO((InPriTariffVO)getVO(request, InPriTariffVO .class));
			event.setRsltSvcScpCdVOs((RsltSvcScpCdVO[])getVOs(request, RsltSvcScpCdVO.class,""));
		}
		else if(command.isCommand(FormCommand.MODIFY01)) { 
			event.setPriTariffVO((PriTariffVO)getVO(request, PriTariffVO .class));
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