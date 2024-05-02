/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0023HTMLAction.java
*@FileTitle : M&R Agreement
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.05
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.06.09 박명신
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.EstimateINVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
	
/**
 * 견적서 <br>
 * @author  park myoung sin  
 * @see 	EesMnr0023Event 참조
 * @since 	J2EE 1.6           
 */
 
public class EES_MNR_0023HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0023HTMLAction 객체를 생성
	 */
	public EES_MNR_0023HTMLAction() {}
				
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AgreementManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */	
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesMnr0023Event event = new EesMnr0023Event();
		
		EstimateGRPVO estimateGRPVO = new EstimateGRPVO();
		
		//조회 리스트
		if(command.isCommand(FormCommand.SEARCH)) {		  
			estimateGRPVO.setEstimateINVO((EstimateINVO)getVO(request, EstimateINVO .class)); 
		}	 
		//건당 조회  
		else if(command.isCommand(FormCommand.SEARCH01)) { 		  
			estimateGRPVO.setEstimateINVO((EstimateINVO)getVO(request, EstimateINVO.class));
		}		     
		//verify  		 
		else if(command.isCommand(FormCommand.COMMAND01)) { 
			CustomMnrRprRqstDtlVO customMnrRprRqstDtlVO = new CustomMnrRprRqstDtlVO();
			//헤더 데이타 
			estimateGRPVO.setCustomMnrRprRqstHdrVO((CustomMnrRprRqstHdrVO)getVO(request, CustomMnrRprRqstHdrVO.class));
			//VO을 변경, 디테일 데이타	 
			CustomMnrDatVrfyVO[] customMnrDatVrfyVOS = customMnrRprRqstDtlVO.fromDatVrfyVORequestGrid(request,"rqstDtl_"); 
			estimateGRPVO.setCustomMnrDatVrfyVOS(customMnrDatVrfyVOS);	  
		}											    
		//Modify Counteroffer 		 
		else if(command.isCommand(FormCommand.COMMAND02)) {  
			//헤더 데이타							 			
			estimateGRPVO.setCustomMnrRprRqstHdrVO((CustomMnrRprRqstHdrVO)getVO(request, CustomMnrRprRqstHdrVO.class));
			//디테일 데이타									 
			estimateGRPVO.setArrCustomMnrRprRqstDtlVOS((CustomMnrRprRqstDtlVO[])getVOs(request, CustomMnrRprRqstDtlVO.class,"rqstDtl_"));
		}		
		//Modify Reject 	
		else if(command.isCommand(FormCommand.COMMAND03)) {  
			//헤더 데이타 						 			
			estimateGRPVO.setCustomMnrRprRqstHdrVO((CustomMnrRprRqstHdrVO)getVO(request, CustomMnrRprRqstHdrVO.class));
			//디테일 데이타								 
			estimateGRPVO.setArrCustomMnrRprRqstDtlVOS((CustomMnrRprRqstDtlVO[])getVOs(request, CustomMnrRprRqstDtlVO.class,"rqstDtl_"));
		}													    
		//Modify Approval  	
		else if(command.isCommand(FormCommand.COMMAND04)) {  
			//헤더 데이타		 							 			
			estimateGRPVO.setCustomMnrRprRqstHdrVO((CustomMnrRprRqstHdrVO)getVO(request, CustomMnrRprRqstHdrVO.class));
			//디테일 데이타								 
			estimateGRPVO.setArrCustomMnrRprRqstDtlVOS((CustomMnrRprRqstDtlVO[])getVOs(request, CustomMnrRprRqstDtlVO.class,"rqstDtl_"));
		}															    
		//Modify Audit it Later  	
		else if(command.isCommand(FormCommand.COMMAND05)) {  
			//헤더 데이타		 							 			
			estimateGRPVO.setCustomMnrRprRqstHdrVO((CustomMnrRprRqstHdrVO)getVO(request, CustomMnrRprRqstHdrVO.class));
			//디테일 데이타										 
			estimateGRPVO.setArrCustomMnrRprRqstDtlVOS((CustomMnrRprRqstDtlVO[])getVOs(request, CustomMnrRprRqstDtlVO.class,"rqstDtl_"));
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