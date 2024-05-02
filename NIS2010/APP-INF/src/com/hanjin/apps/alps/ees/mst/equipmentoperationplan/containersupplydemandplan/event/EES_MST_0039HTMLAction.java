/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MST_0039HTMLAction.java
*@FileTitle : Container Purchasing Trend by Year inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.12
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.12 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.EqPriceOptionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.mst.equipmentoperationplan 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EquipmentOperationPlanSC로 실행요청<br>
 * - EquipmentOperationPlanSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Ho Sun
 * @see EquipmenttoManagementEvent 참조
 * @since J2EE 1.6
 */

public class EES_MST_0039HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MST_0039HTMLAction 객체를 생성
	 */
	public EES_MST_0039HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EquipmenttoManagementEvent 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesMst0039Event event = new EesMst0039Event();

		if(command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.SEARCH01)) {
			event.setEqPriceOptionVO((EqPriceOptionVO)getVO(request, EqPriceOptionVO .class));
			String bseyrmon0 = event.getEqPriceOptionVO().getBseYrmon0();
			String bseyrmon1 = event.getEqPriceOptionVO().getBseYrmon1();
			//From Date Setting
			int idx = bseyrmon0.indexOf("-");
			if (idx != 0 && idx != -1) {
				String tmpyrmon = bseyrmon0.substring(0, idx);
				tmpyrmon = tmpyrmon + bseyrmon0.substring(idx+1, bseyrmon0.length());
				event.getEqPriceOptionVO().setBseYrmon0(tmpyrmon);
			} else if (bseyrmon0.length()  ==  6){
				event.getEqPriceOptionVO().setBseYrmon0(bseyrmon0);
			}
			
			//To Date Setting
			idx = bseyrmon0.indexOf("-");
			if (idx != 0 && idx != -1) {
				String tmpyrmon = bseyrmon1.substring(0, idx);
				tmpyrmon = tmpyrmon + bseyrmon1.substring(idx+1, bseyrmon1.length());
				event.getEqPriceOptionVO().setBseYrmon1(tmpyrmon);
			} else if (bseyrmon1.length()  ==  6){
				event.getEqPriceOptionVO().setBseYrmon1(bseyrmon1);
			}
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