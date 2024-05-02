/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESM_BKG_1141HTMLAction.java
*@FileTitle : ESM_BKG-1141
*Open Issues :
*Change history :
*@LastModifyDate : 2012.02.07
*@LastModifier : 변종건
*@LastVersion : 1.0
* 2012.02.07 변종건
* 1.0 Creation
* 2012.02.02 변종건 [CHM-201215473-01] Malaysis (MYTPP) Customs Manifest 전송 기능 추가 요청
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandVvdInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.thailand.vo.ThailandVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.CstmsVvdInfoVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_1147HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_1141HTMLAction 객체를 생성
	 */
	public ESM_BKG_1147HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
    	EsmBkg1147Event event = new EsmBkg1147Event();
    	CstmsVvdInfoCondVO cstmsVvdInfoCondVO = new ThailandVvdInfoCondVO();
    	ThailandManifestListCondVO manifestListCondVO = new ThailandManifestListCondVO();

		if(command.isCommand(FormCommand.SEARCH)) {
			cstmsVvdInfoCondVO = (ThailandVvdInfoCondVO)getVO(request, ThailandVvdInfoCondVO.class);
			event.setThailandVvdInfoCondVO((ThailandVvdInfoCondVO)cstmsVvdInfoCondVO);
		} else if(command.isCommand(FormCommand.SEARCH01)) {
			manifestListCondVO = (ThailandManifestListCondVO)getVO(request, ThailandManifestListCondVO.class);
			event.setThailandManifestListCondVO((ThailandManifestListCondVO)manifestListCondVO);
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
