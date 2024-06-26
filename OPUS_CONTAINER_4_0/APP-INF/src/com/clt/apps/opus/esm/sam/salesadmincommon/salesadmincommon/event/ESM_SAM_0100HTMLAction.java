/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_SAM_0100HTMLAction.java
*@FileTitle : Sales Activity Item
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.11
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2011.05.11 김보배
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.vo.SamActTpMstVO;
import com.clt.apps.opus.esm.sam.salesadmincommon.salesadmincommon.vo.SearchActItemMstVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.SamSlsActTpDtlVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.sam.salesadmincommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SalesAdminCommonSC로 실행요청<br>
 * - SalesAdminCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author NAMKOONGJINHO
 * @see SalesAdminCommonEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SAM_0100HTMLAction extends HTMLActionSupport { 

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SAM_0100HTMLAction 객체를 생성
	 */
	public ESM_SAM_0100HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SalesAdminCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param HttpServletRequest request
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSam0100Event event = new EsmSam0100Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			if((SamActTpMstVO[])getVOs(request, SamActTpMstVO.class,"sheet1_")!=null){
				event.setSamActTpMstVOS((SamActTpMstVO[])getVOs(request, SamActTpMstVO.class,"sheet1_"));
			}
			if((SamSlsActTpDtlVO[])getVOs(request, SamSlsActTpDtlVO.class,"sheet2_")!=null){
				event.setSamSlsActTpDtlVOS((SamSlsActTpDtlVO[])getVOs(request, SamSlsActTpDtlVO.class,"sheet2_"));
			}
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setSearchActItemMstVO((SearchActItemMstVO)getVO(request, SearchActItemMstVO .class));
			
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setSearchActItemMstVO((SearchActItemMstVO)getVO(request, SearchActItemMstVO .class));
		}

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param EventResponse eventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param Event event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}