/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0127HTMLAction.java
*@FileTitle : ManifestListDownload
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.18
*@LastModifier : 경종윤
*@LastVersion : 1.0
* 2009.05.18 경종윤
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.brazil.vo.BrManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrCmModiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrCnpiNcmByCntrModiVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.brazil.vo.BrManifestListCondVO;
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
 * @author Kyoung Jong Yun
 * @see EsmBkg0127Event 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0127HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0127HTMLAction 객체를 생성
	 */
	public ESM_BKG_0127HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
    	
		EsmBkg0127Event event = new EsmBkg0127Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			
			event.setBrManifestListCondVO((BrManifestListCondVO)getVO(request, BrManifestListCondVO.class));
			
		} else if(command.isCommand(FormCommand.SEARCH02)) { // NCM desc 조회
			
			event.setBrManifestListCondVO((BrManifestListCondVO)getVO(request, BrManifestListCondVO.class));

		} else if(command.isCommand(FormCommand.MODIFY)) { // 브라질 세관정보 등록
			
			event.setBrCmModiVOs( (BrCmModiVO[]) getVOs(request, BrCmModiVO.class));

		} else if(command.isCommand(FormCommand.MODIFY01)) { // 브라질 Container Manifest정보를 업데이트 한다.
			
			event.setBrCnpiNcmByCntrModiVOs( (BrCnpiNcmByCntrModiVO[]) getVOs(request, BrCnpiNcmByCntrModiVO.class));

		} else if(command.isCommand(FormCommand.MULTI)) { // 브라질 EDI flat file 생성 및 전송
			
			event.setBrManifestTransmitVOs( (BrManifestTransmitVO[]) getVOs(request, BrManifestTransmitVO.class));

		} else if (command.isCommand(FormCommand.SEARCH03)) {
			// BackEndJob 으로 돌린 후 결과코드 조회
			event.setKey(request.getParameter("key"));		
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