/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0272HTMLAction.java
*@FileTitle : Full CNTR Release Order
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.14
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.07.14 손윤석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.BlIssVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrdVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderEdiSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderMailSendVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.FullCntrRlseOrderSearchVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.inboundnoticemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InboundBLMgtSC로 실행요청<br>
 * - InboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Park Changjune
 * @see EsmBkg0272Event 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0272HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0272HTMLAction 객체를 생성
	 */
	public ESM_BKG_0272HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InboundNoticeMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException 
	{
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0272Event event = new EsmBkg0272Event();
		
		if(command.isCommand(FormCommand.SEARCH)) 
		{
			event.setFullCntrRlseOrderSearchVO((FullCntrRlseOrderSearchVO) getVO(request, FullCntrRlseOrderSearchVO.class));
		}
		if(command.isCommand(FormCommand.SEARCH01)) 
		{
			event.setFullCntrRlseOrderEdiSendVOs((FullCntrRlseOrderEdiSendVO[]) getVOs(request, FullCntrRlseOrderEdiSendVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI01))  // EDI 전송
		{ 
			event.setFullCntrRlseOrderEdiSendVOs((FullCntrRlseOrderEdiSendVO[]) getVOs(request, FullCntrRlseOrderEdiSendVO.class));
	    }
		else if(command.isCommand(FormCommand.MULTI02))  // EMAIL 전송
		{ 				 
			log.debug("MULTI02 호출");
			event.setFullCntrRlseOrdVOs((FullCntrRlseOrdVO[]) getVOs(request, FullCntrRlseOrdVO.class,"sheet1_"));	
			event.setCargoSendEmailVOs((FullCntrRlseOrderMailSendVO[]) getVOs(request, FullCntrRlseOrderMailSendVO.class,"sheet2_"));
			event.setEmlDiff(request.getParameter("eml_diff"));
		}
		else if(command.isCommand(FormCommand.COMMAND03) || command.isCommand(FormCommand.COMMAND04))  // EMAIL 전송할 데이터를 검색
		{ 				 
			log.debug("COMMAND03 호출");
			
			event.setFullCntrRlseOrdVOs((FullCntrRlseOrdVO[]) getVOs(request, FullCntrRlseOrdVO.class,"sheet1_"));	
			
			
			log.debug("FullCntrRlseOrdVO : " + event.getFullCntrRlseOrdVOs());
	    }if(command.isCommand(FormCommand.SEARCH02)) 
		{
			event.setFullCntrRlseOrderEdiSendVOs((FullCntrRlseOrderEdiSendVO[]) getVOs(request, FullCntrRlseOrderEdiSendVO.class));
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