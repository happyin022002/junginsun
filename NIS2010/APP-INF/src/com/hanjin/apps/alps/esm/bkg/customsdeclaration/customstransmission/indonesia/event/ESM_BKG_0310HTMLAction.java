/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0310HTMLAction.java
*@FileTitle : Indonesian Customs EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 민동진
*@LastVersion : 1.0
* 2009.09.29 민동진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IdManifestListCondVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.customstransmissionsc 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsTransmissionSCSC로 실행요청<br>
 * - CustomsTransmissionSCSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Min, DongJin
 * @see CustomsTransmissionSCEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0310HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0310HTMLAction 객체를 생성
	 */
	public ESM_BKG_0310HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsTransmissionSCEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0310Event event = new EsmBkg0310Event();
    	ManifestListCondVO manifestListCondVO = new IndonesiaManifestListCondVO(); 

		if(command.isCommand(FormCommand.SEARCH)) {
			manifestListCondVO = (IndonesiaManifestListCondVO)getVO(request, IndonesiaManifestListCondVO.class);
			event.setIndonesiaManifestListCondVO((IndonesiaManifestListCondVO)manifestListCondVO);
			event.setPolCd(request.getParameter("vvd"));
			event.setPolCd(request.getParameter("pol_cd"));
			event.setPodCd(request.getParameter("pod_cd"));
		} else if(command.isCommand(FormCommand.MULTI)) {
			log.info("FormCommand is MULTI");
			IdManifestListCondVO idManifestListCondVO = new IdManifestListCondVO();
			idManifestListCondVO.fromRequest(request);
			idManifestListCondVO.setBoundCd("I");
			log.info("request=[" + request.toString() + "]");
            event.setManifestTransmitVO(idManifestListCondVO);
		}
		request.setAttribute("Event", event);
		return event;
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