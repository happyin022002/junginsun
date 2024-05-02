/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0416HTMLAction.java
 *@FileTitle : ESM_BKG_0416HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.05.20 정재엽
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischCoCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischCoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.korea.vo.KorDischLocCondVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBerthCdVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.wharfage 화면을 통해 서버로 전송되는 HTML DOM 객체의 
 *   Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 WharFageMgtSC로 실행요청<br>
 * - WharfageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author jae yoeb jeong
 * @see WharfageEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0347HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_BKG_0416HTMLAction 객체를 생성
	 */
	public ESM_BKG_0347HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 WharfageEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request 
	 *            HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */ 
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		// FormCommand 처리
		FormCommand command = FormCommand.fromRequest(request);
		// EVENT 생성
		EsmBkg0347Event event = new EsmBkg0347Event();
		
		// COMMAND 구분에 따른 처리
		if(command.isCommand(FormCommand.SEARCH)) 
    	{
			// 조회의 경우 처리
			KorDischCoCondVO korDischCoCondVO = (KorDischCoCondVO)getVO(request, KorDischCoCondVO.class);
			event.setKorDischCoCondVO(korDischCoCondVO);
    	}else if( command.isCommand(FormCommand.MULTI))	{
    		// 입력/수정/삭제의 경우 처리
    		event.setKorDischCoCondVOs((KorDischCoCondVO[])getVOs(request, KorDischCoCondVO.class, "sheet1_"));  
    		
    		//event.setKrWhfBerthCdVOs2((KrWhfBerthCdVO[])getVOs(request, KrWhfBerthCdVO.class, "sheet1_") );  
    		
    	}
		
		// 응답결과에 event 할당
		request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param eventResponse
	 *            EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param event
	 *            Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}