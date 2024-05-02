/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UI_SCG_0033HTMLAction.java
*@FileTitle : Loading Port for RSO(Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.05.19 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgRgnShpOprPortListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.SearchRsoComboListVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SpecialCargoMasterDataMgtSC로 실행요청<br>
 * - SpecialCargoMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author jang kang cheol
 * @see SpecialCargoMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class VOP_SCG_0033HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * UI_SCG_0033HTMLAction 객체를 생성
	 */
	public VOP_SCG_0033HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SpecialCargoMasterDataMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	VopScg0033Event event = new VopScg0033Event();
 
		if(command.isCommand(FormCommand.MULTI)) {
			event.setScgRgnShpOprPortListVOs( (ScgRgnShpOprPortListVO[])getVOs(request, ScgRgnShpOprPortListVO .class,"sheet1_"));
 		
		} 
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchRsoComboListVO((SearchRsoComboListVO)getVO(request, SearchRsoComboListVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			  event.setSearchRsoComboListVO(   (SearchRsoComboListVO)getVO(request, SearchRsoComboListVO.class ) );
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
		   event.setAttribute("loc_cd", JSPUtil.getParameter(request, "loc_cd", "") );
		}		
		else if(command.isCommand(FormCommand.SEARCH03)) {
			   event.setAttribute("cnt_cd", JSPUtil.getParameter(request, "cnt_cd", "") );
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