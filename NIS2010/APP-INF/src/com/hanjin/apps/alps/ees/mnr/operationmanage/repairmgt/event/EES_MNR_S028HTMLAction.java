/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0028HTMLAction.java
*@FileTitle : M&R Repair Inquiry
*Open Issues :
*Change history :	
*@LastModifyDate : 2009.08.20
*@LastModifier : 박명신
*@LastVersion : 1.0    
* 2009.06.09 박명신 
* 1.0 Creation 		
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.RepairCollectionGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.RepairCollectionINVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
	
/**	
 * Repair Cancellation and Deletion <br> 
 * @author  park myoung sin		  
 * @see 	EesMnr0028Event 참조	
 * @since 	J2EE 1.6             
 */		
		
public class EES_MNR_S028HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_S028HTMLAction 객체를 생성
	 */
	public EES_MNR_S028HTMLAction() {}
				
	/** 
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AgreementManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */	 	
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesMnrS028Event event = new EesMnrS028Event();
			
		RepairCollectionGRPVO repairCollectionGRPVO = new RepairCollectionGRPVO();
		
		//조회 리스트
		if(command.isCommand(FormCommand.SEARCH)) {		  
			repairCollectionGRPVO.setRepairCollectionINVO((RepairCollectionINVO)getVO(request, RepairCollectionINVO .class)); 
		}			 	     							    
		
		event.setRepairCollectionGRPVO(repairCollectionGRPVO);     	           
		
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