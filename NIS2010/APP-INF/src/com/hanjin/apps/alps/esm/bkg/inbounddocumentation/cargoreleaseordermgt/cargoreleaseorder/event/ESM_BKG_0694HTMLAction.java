/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0694HTMLAction.java
*@FileTitle : DO LIST CHECK REPORT(JAPAN)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.12
*@LastModifier : 박만건
*@LastVersion : 1.0
* 2009.08.12 박만건
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDoHisSearchVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.JapDorEdiTransVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.inboundblmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InboundBLMgtSC로 실행요청<br>
 * - InboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Park Mangeon
 * @see InboundBLMgtEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0694HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * esm_bkg_0694HTMLAction 객체를 생성
	 */
	public ESM_BKG_0694HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InboundBLMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmBkg0694Event event = new EsmBkg0694Event();
    	
		if(command.isCommand(FormCommand.SEARCH)) {
			
			//event.setBkgJapDoIssueListVO((BkgJapDoIssueListVO)getVO(request, BkgJapDoIssueListVO .class));
			JapDoHisSearchVO searchVo = (JapDoHisSearchVO)getVO(request, JapDoHisSearchVO .class);
			if (searchVo.getEvntDtStart() !=null) {
				searchVo.setEvntDtStart(searchVo.getEvntDtStart().replaceAll("-", ""));
			}
			if (searchVo.getEvntDtEnd() !=null) {
				searchVo.setEvntDtEnd(searchVo.getEvntDtEnd().replaceAll("-", ""));
			}
			event.setJapDoHisSearchVO(searchVo);
		}else if(command.isCommand(FormCommand.SEARCH09)) {
			   // BackEndJob 으로 돌린 후 결과코드 조회
			   event.setKey(request.getParameter("key"));  

		}else if(command.isCommand(FormCommand.MULTI01)) {
            log.debug("===================================");
            log.debug("    DOR/IF EVENT                   ");
            log.debug("===================================");
            
            //DOR /IF 관련 값 세팅
            event.setSvcCd(request.getParameter("svc_cd"));
            event.setJapDorEdiTransVOs((JapDorEdiTransVO[])getVOs(request, JapDorEdiTransVO.class));
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