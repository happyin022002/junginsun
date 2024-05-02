/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : ESM_BKG_1163HTMLAction.java
*@FileTitle : ESM_BKG_1163
*Open Issues :
*Change history :
*@LastModifyDate : 2013.07.04
*@LastModifier : 김보배
*@LastVersion : 1.0
* 2013.07.04 김보배
* 1.0 Creation
* -------------------------------------------------------
* History
* 2013.11.04 김보배 [CHM-201327164] Russia Manifest 기능 보완
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.ModifyCntrInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.russia.vo.RussiaManifestListCondVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
 
/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value 를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event 로 변환, request 에 담아 CustomsDeclarationSC 로 실행요청<br>
 * - CustomsDeclarationSC 에서 View(JSP)로 실행결과를 전송하는 EventResponse 를 request 에 셋팅<br>
 * @author BOBAE KIM
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_1163HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_1163HTMLAction 객체를 생성 
	 */
	public ESM_BKG_1163HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value 를 자바 변수로 Parsing<br>
	 * HttpRequst 의 정보를 CustomsDeclarationEvent로 파싱하여 request 에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface 를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
    	EsmBkg1163Event event = new EsmBkg1163Event();
    	ManifestListCondVO manifestListCondVO = new RussiaManifestListCondVO(); 
		 
		if(command.isCommand(FormCommand.SEARCH)) {
			manifestListCondVO = (RussiaManifestListCondVO)getVO(request, RussiaManifestListCondVO.class);
			event.setRussiaManifestListCondVO((RussiaManifestListCondVO)manifestListCondVO);
		} else if(command.isCommand(FormCommand.MULTI01)) { 
			event.setModifyCntrInfoVOs((ModifyCntrInfoVO[])getVOs(request, ModifyCntrInfoVO.class));
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
