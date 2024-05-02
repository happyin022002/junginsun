/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0019HTMLAction.java
*@FileTitle : Maximum L/F Input
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 이현주
*@LastVersion : 1.0
* 2009.08.12 이현주
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.spc.modelconstraintmanage.maxloadfactor.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO; 
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.SpcMaxLodFctrVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.spc.modelconstraintmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ModelConstraintManageSC로 실행요청<br>
 * - ModelConstraintManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author HJ.LEE
 * @see ModelConstraintManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SPC_0019HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SPC_0019HTMLAction 객체를 생성
	 */
	public ESM_SPC_0019HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ModelConstraintManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSpc0019Event event = new EsmSpc0019Event();
		
		SpcMaxLodFctrVO spcMaxLodFctrVO = new SpcMaxLodFctrVO();
		SpcMaxLodFctrVO[] spcMaxLodFctrVOs = null;
				
		if(command.isCommand(FormCommand.MULTI)) {	
						
			//event.setSpcMaxLodFctrVOS((SpcMaxLodFctrVO[])getVOs(request, SpcMaxLodFctrVO .class,""));
			
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
			spcMaxLodFctrVOs = spcMaxLodFctrVO.fromRequestGridArrayList(request, "");
			event.setSpcMaxLodFctrVOS(spcMaxLodFctrVOs);
		}
		else if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
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