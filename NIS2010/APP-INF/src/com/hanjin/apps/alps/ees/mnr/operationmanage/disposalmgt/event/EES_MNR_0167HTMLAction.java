package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalNVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

public class EES_MNR_0167HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0160HTMLAction 객체를 생성
	 */
	public EES_MNR_0167HTMLAction() {}
				
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 OperationManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */	
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesMnr0167Event event = new EesMnr0167Event();
		
		DisposalGRPVO disposalGRPVO = new DisposalGRPVO();
		
		if(command.isCommand(FormCommand.SEARCH01)) { 
			disposalGRPVO.setDisposalNVO((DisposalNVO)getVO(request, DisposalNVO .class));
			
			//HDR	 	
			disposalGRPVO.setCustomMnrDispHdrVO((CustomMnrDispHdrVO)getVO(request, CustomMnrDispHdrVO .class));
			
			if(!"G".equals(request.getParameter("Buyer_Global"))){
				disposalGRPVO.setBuyerGlobal("");	
			}
			
			if(!"R".equals(request.getParameter("Buyer_RHQ"))){
				disposalGRPVO.setBuyerRHQ("");	
			}
			
			if(!"L".equals(request.getParameter("Buyer_Local"))){
				disposalGRPVO.setBuyerLocal("");	
			}
		} 

		event.setDisposalGRPVO(disposalGRPVO);
		
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