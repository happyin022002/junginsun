/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0093HTMLAction.java
*@FileTitle : Scrapping/Donation Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.07
*@LastModifier : 김완규
*@LastVersion : 1.0
* 2009.09.07 김완규
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.vo.CustomMnrXtraDispVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.vo.ExtraDisposalMgtGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.extradisposalmgt.vo.ExtraDisposalMgtINVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
	
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.mnr.operationmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OperationManageSC로 실행요청<br>
 * - OperationManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author WanGyu Kim 
 * @see OperationManageEvent 참조
 * @since J2EE 1.6           
 */
 
public class EES_MNR_0093HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0093HTMLAction 객체를 생성
	 */
	public EES_MNR_0093HTMLAction() {}
				
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 OperationManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */	
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesMnr0093Event event = new EesMnr0093Event();
			
		ExtraDisposalMgtGRPVO extraDisposalMgtGRPVO = new ExtraDisposalMgtGRPVO();
		
		//조회
		if(command.isCommand(FormCommand.SEARCH)) {	
			extraDisposalMgtGRPVO.setExtraDisposalMgtINVO((ExtraDisposalMgtINVO)getVO(request, ExtraDisposalMgtINVO .class));
		}
		//중복체크 조회
		else if(command.isCommand(FormCommand.SEARCH01)) {	
			extraDisposalMgtGRPVO.setExtraDisposalMgtINVO((ExtraDisposalMgtINVO)getVO(request, ExtraDisposalMgtINVO .class));
		}
		//저장		 
		else if(command.isCommand(FormCommand.MULTI)) {  
			extraDisposalMgtGRPVO.setArrayCustomMnrXtraDispVOs((CustomMnrXtraDispVO[])getVOs(request, CustomMnrXtraDispVO.class));
		}	
		event.setExtraDisposalMgtGRPVO(extraDisposalMgtGRPVO);     	           
		 				
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