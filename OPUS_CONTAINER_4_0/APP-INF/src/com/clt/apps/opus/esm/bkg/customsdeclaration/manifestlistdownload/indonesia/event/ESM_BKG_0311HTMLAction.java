/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0311HTMLAction.java
*@FileTitle : ESM_BKG-0311
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.29
*@LastModifier : 장지영
*@LastVersion : 1.0
* 2009.09.29 장지영
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.indonesia.vo.IdManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaManifestListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.indonesia.vo.IndonesiaManifestModificationVO;
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
 * @author JI-YOUNG JANG
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0311HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0311HTMLAction 객체를 생성 
	 */
	public ESM_BKG_0311HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
    	EsmBkg0311Event event = new EsmBkg0311Event();
    	ManifestListCondVO manifestListCondVO = new IndonesiaManifestListCondVO(); 
		 
		if(command.isCommand(FormCommand.SEARCH)) {
			manifestListCondVO = (IndonesiaManifestListCondVO)getVO(request, IndonesiaManifestListCondVO.class);
			event.setIndonesiaManifestListCondVO((IndonesiaManifestListCondVO)manifestListCondVO);
			event.setVvd(request.getParameter("vvd"));
			event.setPolCd(request.getParameter("pol_cd"));
			event.setPodCd(request.getParameter("pod_cd"));
		} else if(command.isCommand(FormCommand.SEARCH01)) {
			log.info("FormCommand is SEARCH01");
			event.setIndonesiaManifestListCondVO((IndonesiaManifestListCondVO)getVO(request, IndonesiaManifestListCondVO.class));
        } else if(command.isCommand(FormCommand.MULTI)) {
			event.setIndonesiaManifestModificationVOS((IndonesiaManifestModificationVO[])getVOs(request, IndonesiaManifestModificationVO.class,""));
		} else if(command.isCommand(FormCommand.MULTI02)) {
			log.info("FormCommand is MULTI02");
			IdManifestListCondVO idManifestListCondVO = new IdManifestListCondVO();
			idManifestListCondVO.fromRequest(request);
			idManifestListCondVO.setBoundCd("O");
			log.info("request=[" + request.toString() + "]");
            event.setManifestTransmitVO(idManifestListCondVO);
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
