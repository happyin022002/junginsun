/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MST_0046HTMLAction.java
*@FileTitle : Manufacture Date & Manufacturer Inquiry and Update
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.18
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2010.02.18 이호선
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrManufactureInfoVO;
import com.clt.apps.opus.ees.mst.equipmentmanagement.containeronoffhire.vo.CntrManufactureListVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.opus.ees.mst.equipmentmanagement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EquipmentManagementSC로 실행요청<br>
 * - EquipmentManagementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Ho Sun
 * @see EquipmentManagementEvent 참조
 * @since J2EE 1.6
 */

public class EES_MST_0046HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MST_00046HTMLAction 객체를 생성
	 */
	public EES_MST_0046HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EquipmentManagementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesMst0046Event event = new EesMst0046Event();
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setCntrManufactureListVO((CntrManufactureListVO)getVO(request, CntrManufactureListVO .class));
			CntrManufactureListVO[] cntrManufactureListVOs = new CntrManufactureListVO[1];
			cntrManufactureListVOs[0] = event.getCntrManufactureListVO();
			event.setCntrManufactureListVOs(cntrManufactureListVOs);			
		} else if(command.isCommand(FormCommand.SEARCH)) {
			event.setCntrManufactureListVOs((CntrManufactureListVO[])getVOs(request, CntrManufactureListVO .class,""));
		} else if (command.isCommand(FormCommand.MULTI)){
			event.setCntrManufactureInfoVOs((CntrManufactureInfoVO[])getVOs(request, CntrManufactureInfoVO .class,""));			
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