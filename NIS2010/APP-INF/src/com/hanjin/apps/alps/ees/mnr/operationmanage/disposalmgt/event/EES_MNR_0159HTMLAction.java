/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0159HTMLAction.java
*@FileTitle : Disposal Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.16
*@LastModifier : 박명신
*@LastVersion : 1.0
* 2009.07.20 박명신
* 1.0 Creation
* --------------------------------------------------------
* History
* 2012.01.12 신혜정 [CHM-201215612-01] Bidding 프로세싱중인 데이터 Confirm 불가토록 로직 수정  
* 2012.11.29 조경완 [CHM-201221414-01] ALPS-MNR-DISPOSAL-MANAGEMENT-MANAGEMENT INQUIRY 화면에서 수정 건
* 2013.09.27 조경완 [CHM-201326609-01] ALPS MNR-Disposal-Disposal Management에서 비딩 결과를 이메일로 통보해주는 기능           
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispBuyerPartVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.disposalmgt.vo.CustomMnrDispBuyrDtlPartVO;
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
 * - EES_MNR_0159 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OperationManageSC로 실행요청<br>
 * - OperationManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 박명신  
 * @see EesMnr0159Event.java 참조 
 * @since J2EE 1.6           
 */ 

public class EES_MNR_0159HTMLAction extends HTMLActionSupport {
	
	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0159HTMLAction 객체를 생성
	 */	 
	public EES_MNR_0159HTMLAction() {}
	  
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EesMnr0159Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */ 
	public Event perform(HttpServletRequest request) throws HTMLActionException {
			
    	FormCommand command = FormCommand.fromRequest(request);
		EesMnr0159Event event = new EesMnr0159Event();
			
		DisposalGRPVO disposalGRPVO = new DisposalGRPVO();
		
		//초기화 바이어 조회      
		if(command.isCommand(FormCommand.INIT)) {  
			disposalGRPVO.setDisposalNVO((DisposalNVO)getVO(request, DisposalNVO .class));
		}        
		//헤더 리스트 조회       
		else if(command.isCommand(FormCommand.SEARCH)) {
			disposalGRPVO.setDisposalNVO((DisposalNVO)getVO(request, DisposalNVO .class));
		}    	 
		//RE-bidding   
		else if(command.isCommand(FormCommand.MODIFY)) { 
			disposalGRPVO.setDisposalNVO((DisposalNVO)getVO(request, DisposalNVO .class));
			 
			//HDR 
			disposalGRPVO.setCustomMnrDispHdrVO((CustomMnrDispHdrVO)getVO(request, CustomMnrDispHdrVO .class));
			//DTL 
			disposalGRPVO.setArrCustomMnrDispDtlVOS((CustomMnrDispDtlVO[])getVOs(request, CustomMnrDispDtlVO.class,"rqstDtl_"));
			//PARTNER   
			disposalGRPVO.setArrCustomMnrDispBuyerPartVOS((CustomMnrDispBuyerPartVO[])getVOs(request, CustomMnrDispBuyerPartVO.class,"rqstPart_"));
		}   
		//Confirm   
		else if(command.isCommand(FormCommand.MODIFY01)) { 
			disposalGRPVO.setDisposalNVO((DisposalNVO)getVO(request, DisposalNVO .class));
			//HDR 	
			disposalGRPVO.setCustomMnrDispHdrVO((CustomMnrDispHdrVO)getVO(request, CustomMnrDispHdrVO .class));
			//DTL 	
			disposalGRPVO.setArrCustomMnrDispDtlVOS((CustomMnrDispDtlVO[])getVOs(request, CustomMnrDispDtlVO.class,"rqstDtl_"));
			//PARTNER   	
			disposalGRPVO.setArrCustomMnrDispBuyerPartVOS((CustomMnrDispBuyerPartVO[])getVOs(request, CustomMnrDispBuyerPartVO.class,"rqstPart_"));
			//Buyer Dtl		
			disposalGRPVO.setArrCustomMnrDispBuyrDtlPartVOS((CustomMnrDispBuyrDtlPartVO[])getVOs(request, CustomMnrDispBuyrDtlPartVO.class,"rqstPartDtl_"));
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
		// disp_end_dt 종료 여부 조회 
		else if(command.isCommand(FormCommand.SEARCH02)) { 

			disposalGRPVO.setCustomMnrDispHdrVO((CustomMnrDispHdrVO)getVO(request, CustomMnrDispHdrVO .class));
		}
		// disp_no_list 체크
		else if(command.isCommand(FormCommand.SEARCH03)) {
			disposalGRPVO.setDisposalNVO((DisposalNVO)getVO(request, DisposalNVO .class));
		}  	
		//Email Send 
		else if(command.isCommand(FormCommand.COMMAND01)) { 
			disposalGRPVO.setDisposalNVO((DisposalNVO)getVO(request, DisposalNVO .class));
			 
			//HDR 
			disposalGRPVO.setCustomMnrDispHdrVO((CustomMnrDispHdrVO)getVO(request, CustomMnrDispHdrVO .class));
			//DTL 
			disposalGRPVO.setArrCustomMnrDispDtlVOS((CustomMnrDispDtlVO[])getVOs(request, CustomMnrDispDtlVO.class,"rqstDtl_"));
			//PARTNER   
			disposalGRPVO.setArrCustomMnrDispBuyerPartVOS((CustomMnrDispBuyerPartVO[])getVOs(request, CustomMnrDispBuyerPartVO.class,"rqstPart_"));
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