/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : STM_SAR_5002HTMLAction.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
*
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.stm.sar.accountreceivableagent.accountreceivableagent.vo.ASAInfoByOfcAgnVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;



/**
 * HTTP Parser<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableAgentSC로 실행요청<br>
 * - AccountReceivableAgentSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author
 * @see StmSar5002Event 참조
 * @since J2EE 1.4
 */

public class STM_SAR_5002HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * STM_SAR_5002HTMLAction 객체를 생성
	 */
	public STM_SAR_5002HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * 
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	//FormCommand command = FormCommand.fromRequest(request);
    	StmSar5002Event event = new StmSar5002Event();

    	ASAInfoByOfcAgnVO paramVO = (ASAInfoByOfcAgnVO)getVO(request, ASAInfoByOfcAgnVO.class);
    	paramVO.setAsaPrdFmDt(paramVO.getAsaPrdFmDt().replaceAll("\\-", ""));
    	paramVO.setAsaPrdToDt(paramVO.getAsaPrdToDt().replaceAll("\\-", ""));

		event.setAsaInfoByOfcAgnVO(paramVO);

		/*if(command.isCommand(FormCommand.SEARCH)) {

		}*/

		request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param EventResponse eventResponse
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param Event event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}