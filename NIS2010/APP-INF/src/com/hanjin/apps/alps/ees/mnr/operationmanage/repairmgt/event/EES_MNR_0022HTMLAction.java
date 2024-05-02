/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0022HTMLAction.java
*@FileTitle : Repair Group Auditing
*Open Issues :
*Change history :	
*@LastModifyDate : 2009.08.19
*@LastModifier : 박명신
*@LastVersion : 1.0   
* 2009.06.09 박명신
* 1.0 Creation		
* ------------------------------------------------------------------------
* history
* 2013.05.09 조경완 [CHM-201324479-01][MNR] Repair Estimate 처리시 이미 처리된 Data를 재 Save, Request, Approval 할 경우 발생하는 SQL Error 처리
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateINVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
	
/**	
 * Repair Group Auditing <br> 
 * @author  park myoung sin		  
 * @see 	EesMnr0022Event 참조	
 * @since 	J2EE 1.6             
 */
 
public class EES_MNR_0022HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0022HTMLAction 객체를 생성
	 */
	public EES_MNR_0022HTMLAction() {}
				
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AgreementManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */	
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesMnr0022Event event = new EesMnr0022Event();
		
		EstimateGRPVO estimateGRPVO = new EstimateGRPVO();
				
		//조회 리스트
		if(command.isCommand(FormCommand.SEARCH)) {		  
			estimateGRPVO.setEstimateINVO((EstimateINVO)getVO(request, EstimateINVO .class)); 
		}			 	     							    
		//Modify Reject 	
		else if(command.isCommand(FormCommand.COMMAND03)) {  
			estimateGRPVO.setEstimateINVO((EstimateINVO)getVO(request, EstimateINVO .class)); 
			//헤더 데이타  목록	 						 			
			estimateGRPVO.setArrCustomMnrRprRqstHdrVOS((CustomMnrRprRqstHdrVO[])getVOs(request, CustomMnrRprRqstHdrVO.class,"sheet2"));
			estimateGRPVO.setGroupAuditAction("Reject");
		}													    
		//Modify Approval  	
		else if(command.isCommand(FormCommand.COMMAND04)) {  
			estimateGRPVO.setEstimateINVO((EstimateINVO)getVO(request, EstimateINVO .class)); 
			//헤더 데이타  목록					 				 							 			
			estimateGRPVO.setArrCustomMnrRprRqstHdrVOS((CustomMnrRprRqstHdrVO[])getVOs(request, CustomMnrRprRqstHdrVO.class,"sheet2"));
			estimateGRPVO.setGroupAuditAction("Approval");
		}
		//Modify Approval  	
		else if(command.isCommand(FormCommand.COMMAND05)) {  
			estimateGRPVO.setEstimateINVO((EstimateINVO)getVO(request, EstimateINVO .class)); 
			//헤더 데이타  목록					 				 							 			
			estimateGRPVO.setArrCustomMnrRprRqstHdrVOS((CustomMnrRprRqstHdrVO[])getVOs(request, CustomMnrRprRqstHdrVO.class,"sheet2"));
			estimateGRPVO.setGroupAuditAction("Approval");
		}
			
		event.setEstimateGRPVO(estimateGRPVO);     	           
		
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