/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VSK_COM_HTMLAction.java
*@FileTitle : Port Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2009.05.21 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.vsk.vskcommon.vskcodefinder.vo.YardVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.MdmVslCntrVO;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.nis2010.vop.vsk.vskcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 VSKCommonSC로 실행요청<br>
 * - VSKCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Ryu Hyuk
 * @see VSKCommonEvent 참조
 * @since J2EE 1.4
 */

public class VSK_COM_HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VSK_COM_HTMLAction 객체를 생성
	 */
	public VSK_COM_HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VskComEvent 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VskComEvent event = new VskComEvent();
		
		//Lane SVC Type
		if(command.isCommand(FormCommand.SEARCH)){
			event.setMdmVslSvcLaneVO((MdmVslSvcLaneVO)getVO(request, MdmVslSvcLaneVO.class));
		//0003,0066 Vsl Class 콤보
		}else if(command.isCommand(FormCommand.SEARCH)){
			event.setMdmVslCntrVO((MdmVslCntrVO)getVO(request, MdmVslCntrVO.class));
		}else if(command.isCommand(FormCommand.SEARCH03)){
			event.setMdmVslSvcLaneVO((MdmVslSvcLaneVO)getVO(request, MdmVslSvcLaneVO.class));
		}else if(command.isCommand(FormCommand.SEARCH04)){
			event.setYardVO((YardVO)getVO(request, YardVO.class));
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