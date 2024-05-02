/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EMS_PRI_4009HTMLAction.java
*@FileTitle : E-Service Compensation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 김대호
*@LastVersion : 1.0
* 2009.07.29 김대호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.PriRpHdrVO;
import com.hanjin.syscommon.common.table.PriSpHdrVO;
import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.vo.PriCmpnEsvcVO;
import com.hanjin.apps.alps.esm.pri.surcharge.eservicecompensation.vo.MdmSvcScpLmtVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.pri.eservicecompensation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SurchargeSC로 실행요청<br>
 * - SurchargeSC로에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author day-hoh Kim
 * @see EServiceCompensationEvent 참조
 * @since J2EE 1.6
 */

public class ESM_PRI_4009HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EMS_PRI_4009HTMLAction 객체를 생성
	 */
	public ESM_PRI_4009HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EServiceCompensationEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmPri4009Event event = new EsmPri4009Event();

		if(command.isCommand(FormCommand.SEARCH)) { // 리스트 조회
			event.setPriCmpnEsvcVO((PriCmpnEsvcVO)getVO(request, PriCmpnEsvcVO.class)); // 리스트조회
		} else if(command.isCommand(FormCommand.SEARCH01)) { // Origin, dest 콤보 조회
			event.setMdmSvcScpLmtVO((MdmSvcScpLmtVO)getVO(request, MdmSvcScpLmtVO.class));
		} else if(command.isCommand(FormCommand.SEARCH04)) { // sc no 조회
			event.setPriSpHdrVO((PriSpHdrVO)getVO(request, PriSpHdrVO.class));
		} else if(command.isCommand(FormCommand.SEARCH05)) { // rfa no 콤보 조회
			event.setPriRpHdrVO((PriRpHdrVO)getVO(request, PriRpHdrVO.class));
		} else if(command.isCommand(FormCommand.MULTI)) { // 저장
			event.setPriCmpnEsvcVOS((PriCmpnEsvcVO[])getVOs(request, PriCmpnEsvcVO.class, ""));
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