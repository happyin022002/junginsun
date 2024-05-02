/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : ESM_BKG_1518HTMLAction.java
*@FileTitle : ESM_BKG_1518HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier :
*@LastVersion : 1.0
* 2014.06.28
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.newzealand.vo.NewZealandManifestVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsMfDtl2VO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsMfDtlCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.newzealand.vo.NewZealandCstmsVvdInfoCondVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * ESM_BKG_1518에 대한 PDTO(Data Transfer Object including Parameters)<br>
 * -  ESM_BKG_1518HTMLAction에서 작성<br>
 * - ServiceCommand Layer로 전달하는 PDTO로 사용<br>
 *
 * @author
 * @see ESM_BKG_1518HTMLAction 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_1518HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_BKG_1518HTMLAction 객체를 생성
	 */
	public ESM_BKG_1518HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 *
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);

		EsmBkg1518Event event = new EsmBkg1518Event();

		if (command.isCommand(FormCommand.SEARCH)) {   // VSL Name
			event.setNewZealandCstmsVvdInfoCondVO((NewZealandCstmsVvdInfoCondVO)getVO(request, NewZealandCstmsVvdInfoCondVO.class) );

		} else if (command.isCommand(FormCommand.SEARCH01)) {    // Retrieve
			event.setNewZealandCstmsMfDtlCondVO( (NewZealandCstmsMfDtlCondVO)getVO(request, NewZealandCstmsMfDtlCondVO.class) );

		} else if (command.isCommand(FormCommand.SEARCH03)) {    // Back End Job
			event.setKey(request.getParameter("key"));

		} else if (command.isCommand(FormCommand.MULTI03)) {    // Transmit
			NewZealandManifestVO newZealandManifestVO = new NewZealandManifestVO();
			newZealandManifestVO.setNewZealandCstmsVvdInfoCondVO((NewZealandCstmsVvdInfoCondVO) getVO(request, NewZealandCstmsVvdInfoCondVO.class));
			newZealandManifestVO.setNewZealandCstmsMfDtl2VOs((NewZealandCstmsMfDtl2VO[]) getVOs(request,NewZealandCstmsMfDtl2VO.class, "sheet4_"));
			event.setNewZealandManifestVO(newZealandManifestVO);

		} else if (command.isCommand(FormCommand.SEARCH04)) {    // 1518_01 Error Report
			event.setNewZealandCstmsMfDtl2VO( (NewZealandCstmsMfDtl2VO)getVO(request, NewZealandCstmsMfDtl2VO.class) );

		}
		request.setAttribute("Event", event);
		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 *
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param eventResponse
	 *            EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 *
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param event
	 *            Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}