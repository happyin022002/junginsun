/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : EES_MNR_0253HTMLAction.java
*@FileTitle : Container Seal No-Creation
*Open Issues :	ALPS [EES_MNR_0253]Container Seal No-Creation 를 조회, 등록,수정,삭제하는 화면
*Change history :
*@LastModifyDate : 2011.06.20
*@LastModifier : 김영오
*@LastVersion : 1.0
* 2011.03.30 김영오
* 1.0 Creation
* --------------------------------------------------------
* History
* 2011.11.29 김상수 [CHM-201114696-01] ALPS > MNR > Seal management creation 화면과 inquiry 화면 - Seal No의 prefix만 별도 컬럼으로 분리
*                                      - MNR_SEAL_PLN 테이블에 Serial Range 값을 분리하여 저장, 조회
*                                      - 해당 컬럼명을 사용하는 js및 쿼리, VO 전면수정
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.generalmanage.dvfactormgt.vo.ContainerSealNoCreationVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - EES_MNR_0253 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OperationManageSC로 실행요청<br>
 * - OperationManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 김영오
 * @see EesMnr0253Event.java 참조
 * @since J2EE 1.6
 */

public class EES_MNR_0253HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0253HTMLAction 객체를 생성
	 */
	public EES_MNR_0253HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EesMnr0253Event event = new EesMnr0253Event();
		//저장
		if(command.isCommand(FormCommand.MULTI)) {
			event.setContainerSealNoCreationVOs((ContainerSealNoCreationVO[])getVOs(request, ContainerSealNoCreationVO.class));
		}
		//조회
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setContainerSealNoCreationVO((ContainerSealNoCreationVO)getVO(request, ContainerSealNoCreationVO.class));
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