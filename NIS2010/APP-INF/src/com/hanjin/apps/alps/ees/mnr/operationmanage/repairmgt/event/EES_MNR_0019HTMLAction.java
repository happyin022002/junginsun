/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0019HTMLAction.java
*@FileTitle : M&R Estimate Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.06.09 박명신
* 1.0 Creation
* -------------------------------------------------------------
* history
* 2013.05.09 조경완 [CHM-201324479-01][MNR] Repair Estimate 처리시 이미 처리된 Data를 재 Save, Request, Approval 할 경우 발생하는 SQL Error 처리
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateINVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
	
/**
 * 견적서 <br>
 * @author  park myoung sin  
 * @see 	EesMnr0019Event 참조
 * @since 	J2EE 1.6           
 */
 
public class EES_MNR_0019HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0019HTMLAction 객체를 생성
	 */
	public EES_MNR_0019HTMLAction() {}
				
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AgreementManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */	
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EesMnr0019Event event = new EesMnr0019Event();
			
		EstimateGRPVO estimateGRPVO = new EstimateGRPVO();
		//조회 리스트
		if(command.isCommand(FormCommand.SEARCH)) {		  
			estimateGRPVO.setEstimateINVO((EstimateINVO)getVO(request, EstimateINVO .class)); 
		}	 
		//건당 조회  
		else if(command.isCommand(FormCommand.SEARCH01)) { 		  
			estimateGRPVO.setEstimateINVO((EstimateINVO)getVO(request, EstimateINVO.class));
		}
		//바로 REQUEST가능 => UPPR_OFC_CD 구하기  
		else if(command.isCommand(FormCommand.SEARCH02)) {   	  
			//헤더로 받음  rqst_eq_no,cost_ofc_cd,curr_cd 만사용    
			estimateGRPVO.setCustomMnrRprRqstHdrVO((CustomMnrRprRqstHdrVO)getVO(request, CustomMnrRprRqstHdrVO.class));
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
		//Modify SAVE 		 
		else if(command.isCommand(FormCommand.MODIFY)) {  
			//헤더 데이타						 			
			estimateGRPVO.setCustomMnrRprRqstHdrVO((CustomMnrRprRqstHdrVO)getVO(request, CustomMnrRprRqstHdrVO.class));
			//디테일 데이타								 
			estimateGRPVO.setArrCustomMnrRprRqstDtlVOS((CustomMnrRprRqstDtlVO[])getVOs(request, CustomMnrRprRqstDtlVO.class,"rqstDtl_"));
		}	
		//Modify REQUEST 	
		else if(command.isCommand(FormCommand.COMMAND02)) {  
			//헤더 데이타             
			estimateGRPVO.setArrCustomMnrRprRqstHdrVOS((CustomMnrRprRqstHdrVO[])getVOs(request, CustomMnrRprRqstHdrVO.class,"")); 
		} 													    
		//Modify DELETE	  		 
		else if(command.isCommand(FormCommand.REMOVE)) {  
			estimateGRPVO.setCustomMnrRprRqstHdrVO((CustomMnrRprRqstHdrVO)getVO(request, CustomMnrRprRqstHdrVO.class));
		}
		//Approval
		else if(command.isCommand(FormCommand.COMMAND03)) {  
			//헤더 데이타 						 			
			estimateGRPVO.setCustomMnrRprRqstHdrVO((CustomMnrRprRqstHdrVO)getVO(request, CustomMnrRprRqstHdrVO.class));
			//디테일 데이타								 
			estimateGRPVO.setArrCustomMnrRprRqstDtlVOS((CustomMnrRprRqstDtlVO[])getVOs(request, CustomMnrRprRqstDtlVO.class,"rqstDtl_"));
		} 
		//verify
		else if(command.isCommand(FormCommand.COMMAND04)) {  
			//헤더 데이타             
			estimateGRPVO.setArrCustomMnrRprRqstHdrVOS((CustomMnrRprRqstHdrVO[])getVOs(request, CustomMnrRprRqstHdrVO.class,"")); 
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