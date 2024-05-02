/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName 			: ESM_BKG_1053HTMLAction.java
*@FileTitle 		: ESM_BKG-1053
*Open Issues 		:
*Change history 	:
*@LastModifyDate 	: 2014.09.01
*@LastModifier 		: OH DONG HYUN
*@LastVersion 		: 1.0
* 2014.09.01 OH DONG HYUN
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.BkgCstmsCCAMCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.china.vo.ChinaTransmitHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customsreport.vo.TransmitHistCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24EnsListVO;
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
 * @author OH DONG HYUN
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_1053HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_1120HTMLAction 객체를 생성 
	 */
	public ESM_BKG_1053HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmBkg1053Event event = new EsmBkg1053Event();
    	BkgCstmsCCAMCondVO bkgCstmsCCAMCondVO = new BkgCstmsCCAMCondVO(); 
    	//ManifestTransmitVO manifestTransmitVO = new ManifestTransmitVO();
		if(command.isCommand(FormCommand.SEARCH)) {
			bkgCstmsCCAMCondVO = (BkgCstmsCCAMCondVO)getVO(request, BkgCstmsCCAMCondVO.class);
			event.setBkgCstmsCCAMCondVO((BkgCstmsCCAMCondVO)bkgCstmsCCAMCondVO);
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
