/*=========================================================
 *Copyright(c) 2009 CyberLogitec 
 *@FileName : UI_CTM_0406HTMLAction.java
 *@FileTitle : International MVMT
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.12
 *@LastModifier : 우경민
 *@LastVersion : 1.0
 * 2009.06.12 우경민
 * 1.0 Creation
 * --------------------------------------------------------
 * History
 * 2010.12.28 김상수 [CHM-201007850-01] [CTM] 업무 고도화 관련 소스 보완
 *                    Log 확인용 표준 출력 로그 제거
 *                    관련 대상 : 16개 file
 *                    변경 사항 : System.out.println => log.info 또는 제거
 * 2011.10.28 신자영 [CHM-201114074-01] [CTM] VL/VD시 Origin Yard code 입력오류 확인 기능 추가
=========================================================*/
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.CtmCntrMovInfoVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchBkgCntrListVO;
import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementmgt.vo.SearchCLMInfoVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.ees.ctm.equipmentmovementmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EquipmentMovementMgtSC로 실행요청<br>
 * - EquipmentMovementMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KMWoo
 * @see EquipmentMovementMgtEvent 참조
 * @since J2EE 1.6
 */
public class EES_CTM_0406HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * UI_CTM_0406HTMLAction 객체를 생성
	 */
	public EES_CTM_0406HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EquipmentMovementMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EesCtm0406Event event = new EesCtm0406Event();

		if(command.isCommand(FormCommand.MULTI)) {
			event.setCtmCntrMovInfoVOS((CtmCntrMovInfoVO[])getVOs(request, CtmCntrMovInfoVO .class,""));
		} else if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchCLMInfoVO((SearchCLMInfoVO)getVO(request, SearchCLMInfoVO .class));
		} else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setSearchBkgCntrListVO((SearchBkgCntrListVO)getVO(request, SearchBkgCntrListVO .class));
		} else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setSearchCLMInfoVO((SearchCLMInfoVO)getVO(request, SearchCLMInfoVO .class));
		} else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setCtmCntrMovInfoVOS((CtmCntrMovInfoVO[])getVOs(request, CtmCntrMovInfoVO .class,""));
		} else if(command.isCommand(FormCommand.SEARCH04)) {
			//event.setSearchCLMInfoVO((SearchCLMInfoVO)getVO(request, SearchCLMInfoVO .class));
			log.info("MVMT PARAM ::::" + request.getParameter("mvmt_sts_cd"));
			event.setCtmCntrMovInfoVO((CtmCntrMovInfoVO)getVO(request, CtmCntrMovInfoVO .class));
			log.info("MVMT PARAM ::::" + ((CtmCntrMovInfoVO)getVO(request, CtmCntrMovInfoVO .class)).getMvmtStsCd());
		}else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setCtmCntrMovInfoVO((CtmCntrMovInfoVO)getVO(request, CtmCntrMovInfoVO .class));
		} else if(command.isCommand(FormCommand.MODIFY01)) {
			event.setCtmCntrMovInfoVOS((CtmCntrMovInfoVO[])getVOs(request, CtmCntrMovInfoVO .class,""));

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