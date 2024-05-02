/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0164HTMLAction.java
*@FileTitle : Disposal Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 함형석
*@LastVersion : 1.0
* 2009.09.28 함형석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispBuyerPartVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.DisposalNVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
		
/**
 * HTTP Parser<br>  
 * - EES_MNR_0164 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OperationManageSC로 실행요청<br>
 * - OperationManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 함형석  
 * @see EesMnr0164Event.java 참조 
 * @since J2EE 1.6           
 */ 

public class EES_MNR_0164HTMLAction extends HTMLActionSupport {
	
	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0164HTMLAction 객체를 생성
	 */	 
	public EES_MNR_0164HTMLAction() {}
	  
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EesMnr0164Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest 
	 * @return Event Event interface를 구현한 객체 
	 * @exception HTMLActionException
	 */ 
	public Event perform(HttpServletRequest request) throws HTMLActionException {
			
    	FormCommand command = FormCommand.fromRequest(request);
		EesMnr0164Event event = new EesMnr0164Event();
			
		DisposalGRPVO disposalGRPVO = new DisposalGRPVO();
		
		//초기화 바이어 조회      
		if(command.isCommand(FormCommand.INIT)) {  
			disposalGRPVO.setDisposalNVO((DisposalNVO)getVO(request, DisposalNVO .class));
		}        
		//헤더 리스트 조회      
		else if(command.isCommand(FormCommand.SEARCH)) {
			disposalGRPVO.setDisposalNVO((DisposalNVO)getVO(request, DisposalNVO .class));
		}    	 
		//저장 
		else if(command.isCommand(FormCommand.MODIFY)) { 
			disposalGRPVO.setDisposalNVO((DisposalNVO)getVO(request, DisposalNVO .class));
			
			//HDR 
			disposalGRPVO.setCustomMnrDispHdrVO((CustomMnrDispHdrVO)getVO(request, CustomMnrDispHdrVO .class));
			//DTL 
			disposalGRPVO.setArrCustomMnrDispDtlVOS((CustomMnrDispDtlVO[])getVOs(request, CustomMnrDispDtlVO.class,"rqstDtl_"));
			//PARTNER   
			disposalGRPVO.setArrCustomMnrDispBuyerPartVOS((CustomMnrDispBuyerPartVO[])getVOs(request, CustomMnrDispBuyerPartVO.class,"rqstPart_"));
		}    		 
		//상세 조회  
		else if(command.isCommand(FormCommand.SEARCH01)) { 
			disposalGRPVO.setDisposalNVO((DisposalNVO)getVO(request, DisposalNVO .class));
			//HDR	 	
			disposalGRPVO.setCustomMnrDispHdrVO((CustomMnrDispHdrVO)getVO(request, CustomMnrDispHdrVO .class));
		}   	 	
		//삭제 
		else if(command.isCommand(FormCommand.REMOVE01)) { 
			disposalGRPVO.setDisposalNVO((DisposalNVO)getVO(request, DisposalNVO .class));
			//HDR 	 	
			disposalGRPVO.setCustomMnrDispHdrVO((CustomMnrDispHdrVO)getVO(request, CustomMnrDispHdrVO .class));
		}   	 	
		//Delete(Reject)
		else if(command.isCommand(FormCommand.REMOVE02)) { 
			disposalGRPVO.setDisposalNVO((DisposalNVO)getVO(request, DisposalNVO .class));
			
			CustomMnrDispHdrVO[] customMnrDispHdrVO = (CustomMnrDispHdrVO[]) getVOs(request, CustomMnrDispHdrVO.class , "");
			if(customMnrDispHdrVO != null) {
				List<CustomMnrDispHdrVO> customMnrDispHdrVOS = Arrays.asList(customMnrDispHdrVO);
				disposalGRPVO.setCustomMnrDispHdrVOS(customMnrDispHdrVOS);
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