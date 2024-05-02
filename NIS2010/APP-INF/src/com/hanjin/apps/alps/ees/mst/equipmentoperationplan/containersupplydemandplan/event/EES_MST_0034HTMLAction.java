/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MST_0034HTMLAction.java
*@FileTitle : Container Purchasing Trend by Year & input & update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 이호선
*@LastVersion : 1.0
* 2009.06.11 이호선
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.EqPriceDetailVO;
import com.hanjin.apps.alps.ees.mst.equipmentoperationplan.containersupplydemandplan.vo.EqPriceOptionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.mst.equipmentleasehistory 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EquipmentLeaseHistorySC로 실행요청<br>
 * - EquipmentLeaseHistorySC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Ho Sun
 * @see EquipmentLeaseHistoryEvent 참조
 * @since J2EE 1.6
 */

public class EES_MST_0034HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MST_0034HTMLAction 객체를 생성
	 */
	public EES_MST_0034HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EquipmentLeaseHistoryEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesMst0034Event event = new EesMst0034Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setEqPriceOptionVO((EqPriceOptionVO)getVO(request, EqPriceOptionVO .class));
			String bseyrmon = event.getEqPriceOptionVO().getBseYrmon();
			int idx = bseyrmon.indexOf("-");
			if (idx != 0 && idx != -1) {
				String tmpyrmon = bseyrmon.substring(0, idx);
				tmpyrmon = tmpyrmon + bseyrmon.substring(idx+1, bseyrmon.length());
				event.getEqPriceOptionVO().setBseYrmon(tmpyrmon);
			} else if (bseyrmon.length()  ==  6){
				event.getEqPriceOptionVO().setBseYrmon(bseyrmon);
			}
		} 
		else if(command.isCommand(FormCommand.MULTI)  || command.isCommand(FormCommand.SEARCH02)) {
			event.setEqPriceDetailVos((EqPriceDetailVO[])getVOs(request, EqPriceDetailVO .class,""));
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