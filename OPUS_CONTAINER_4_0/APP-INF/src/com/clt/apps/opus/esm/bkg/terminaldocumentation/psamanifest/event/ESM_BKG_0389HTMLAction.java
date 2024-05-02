/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0389HTMLAction.java
*@FileTitle : ESM_BKG_0389HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 4.
*@LastModifier :
*@LastVersion : 1.0
* 2009. 9. 4.
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.event;


import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImportVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaJurongIfVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.psamanifest.vo.PsaUnmatchListVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * ESM_BKG_0389 의 HTML Action Class
 *
 * @author
 * @see HTMLActionSupport
 * @since J2EE 1.6
 */
public class ESM_BKG_0389HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	public ESM_BKG_0389HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param HttpServletRequest request
	 * @return Event
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		EsmBkg0389Event event = new EsmBkg0389Event();
		FormCommand command = FormCommand.fromRequest(request);

		if(command.isCommand(FormCommand.SEARCH)) {
			// 조회 처리
			PsaUnmatchListVO condVO = (PsaUnmatchListVO)getVO(request, PsaUnmatchListVO.class);
			event.setPsaUnmatchListVO(condVO);
		}else if(command.isCommand(FormCommand.MULTI)) {
			// 저장 처리
			PsaJurongIfVO[] psaJurongIfVOs = (PsaJurongIfVO[])getVOs(request, PsaJurongIfVO.class);

			PsaImportVO condVO = new PsaImportVO();
			condVO.setPsaJurongIfVOs(psaJurongIfVOs						);
			condVO.setVvd			(request.getParameter("vvd")		);
			condVO.setRlyPort		(request.getParameter("rly_port")	);
			condVO.setTransTpCd		(request.getParameter("trans_tp_cd"));

			event.setPsaImportVO(condVO);

		}else if(command.isCommand(FormCommand.SEARCH01)) {
			// VVD 조회
			event.setRlyPort	(request.getParameter("rly_port")	);
			event.setEtdDt		(request.getParameter("eta_etd")	);
			event.setTransTp	(request.getParameter("trans_tp_cd"));
		}else if(command.isCommand(FormCommand.COMMAND01)) {
			// Jurong I/F Upload된 파일 처리
			event.setFileKey(request.getParameter("file_key"));
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
