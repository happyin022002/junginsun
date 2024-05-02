/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0052HTMLAction.java
*@FileTitle : M&R Simple W/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.11
*@LastModifier : 권영법 
*@LastVersion : 1.0
* 2009.08.11 권영법
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event;
 
import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.GeneralWOGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.GeneralWOINVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/** 
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.mnr.generalmanage 화면을 통해 서버로 전송되는 
 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OperationManageSC로 실행요청<br>
 * - OperationManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 권영법
 * @see GeneralManageEvent 참조
 * @since J2EE 1.4
 */    
   
public class EES_MNR_0052HTMLAction extends HTMLActionSupport {
 
	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0052HTMLAction 객체를 생성
	 */
	public EES_MNR_0052HTMLAction() {}
    
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EesMnr0052Event event = new EesMnr0052Event();
		GeneralWOGRPVO generalWOGRPVO = new GeneralWOGRPVO();
		GeneralWOINVO extraWOINVO = new GeneralWOINVO();
				
		//조회  	
		if(command.isCommand(FormCommand.SEARCH)) {
		
			generalWOGRPVO.setGeneralWOINVO((GeneralWOINVO)getVO(request, GeneralWOINVO.class)); 

		//Modify SAVE 			
		}else if(command.isCommand(FormCommand.MULTI)) {
			generalWOGRPVO.setGeneralWOINVO((GeneralWOINVO)getVO(request, GeneralWOINVO.class)); 
			
			//헤더 데이타						 			
			generalWOGRPVO.setCustomMnrOrdHdrVO((CustomMnrOrdHdrVO)getVO(request, CustomMnrOrdHdrVO.class));
			//디테일 데이타								 
			generalWOGRPVO.setArrCustomMnrOrdDtlVOS((CustomMnrOrdDtlVO[])getVOs(request, CustomMnrOrdDtlVO.class,"sheet1_"));
			
		
		}else if(command.isCommand(FormCommand.SEARCH01)){
			extraWOINVO = (GeneralWOINVO)getVO(request, GeneralWOINVO.class);
			extraWOINVO.setAgmtSeq(String.valueOf(Integer.parseInt(extraWOINVO.getAgmtSeq())));
			generalWOGRPVO.setGeneralWOINVO(extraWOINVO);
			
		//삭제	
		}else if(command.isCommand(FormCommand.REMOVE)){
			generalWOGRPVO.setGeneralWOINVO((GeneralWOINVO)getVO(request, GeneralWOINVO.class)); 
			
			//헤더 데이타						 			
			generalWOGRPVO.setCustomMnrOrdHdrVO((CustomMnrOrdHdrVO)getVO(request, CustomMnrOrdHdrVO.class));
			//디테일 데이타								 
			generalWOGRPVO.setArrCustomMnrOrdDtlVOS((CustomMnrOrdDtlVO[])getVOs(request, CustomMnrOrdDtlVO.class,"sheet1_"));
	
		}
		
		event.setGeneralWOGRPVO(generalWOGRPVO);
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