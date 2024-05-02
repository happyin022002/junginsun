/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0037HTMLAction.java
*@FileTitle : B/L INQUIRY: Container Information
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.07.02 이수빈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaCntrListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.UsaCntrSealNoListRsltVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ContainerListRsltVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Subin
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0037HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0037HTMLAction 객체를 생성
	 */
	public ESM_BKG_0037HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0037Event event = new EsmBkg0037Event();

		if( command.isCommand(FormCommand.SEARCH))	{	// Container 정보 조회
			event.setContainerListCondVO((ContainerListCondVO)getVO(request, ContainerListCondVO.class));
		}
		else if( command.isCommand(FormCommand.SEARCH01))	{	// Container Type/Size Code 조회
			ContainerListCondVO[] condVOs = (ContainerListCondVO[])getVOs(request, ContainerListCondVO.class);
			for (int i=0; i<condVOs.length; i++) {
				if("I".equals(condVOs[i].getIbflag()) || "U".equals(condVOs[i].getIbflag())){
					event.setContainerListCondVO(condVOs[i]);
				}
			}
		}
		else if( command.isCommand(FormCommand.MULTI))	{		// Container 정보 수정 ,등록 및 삭제
			String sheetId = request.getParameter("sheet_id");
			String cntCd = request.getParameter("cnt_cd");
			
			ContainerListRsltVO[] containerListRsltVOs = null;
			
			if("sheet3".equals(sheetId)){
				containerListRsltVOs = (ContainerListRsltVO[])getVOs(request, UsaCntrSealNoListRsltVO.class);
				containerListRsltVOs[0].setCntCd(cntCd);
				event.setContainerListRsltVOs(containerListRsltVOs);
			}else{
				containerListRsltVOs = (ContainerListRsltVO[])getVOs(request, UsaCntrListRsltVO.class);
				containerListRsltVOs[0].setCntCd(cntCd);
				event.setContainerListRsltVOs(containerListRsltVOs);
			}
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