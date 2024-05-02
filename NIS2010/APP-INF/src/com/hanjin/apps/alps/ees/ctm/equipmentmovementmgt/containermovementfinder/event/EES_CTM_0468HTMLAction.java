/**
 * Copyright(c) 2016 CyberLogitec
 * @FileName : EES_CTM_0468HTMLAction.java
 * @FileTitle : Terminal e-VGM Received Monitoring
 * Open Issues :
 * Change history :
 * @LastModifyDate :
 * @LastModifier :
 * @LastVersion :
 * 2016.07.17 김상현 1.0 Creation.
 */
package com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.ctm.equipmentmovementmgt.containermovementfinder.vo.SearchVermasListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser.
 * - 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing.
 * - Parsing 한 정보를 Event로 변환, request에 담아 EquipmentMovementMgtSC로 실행요청
 * @author
 * @see
 * @since J2EE 1.6
 */
public class EES_CTM_0468HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing.
	 * HttpRequst의 정보를 EquipmentMovementMgtEvent로 파싱하여 request에 셋팅
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EesCtm0468Event event = new EesCtm0468Event();

		if (command.isCommand(FormCommand.SEARCHLIST)) {
			event.setSearchVermasListVO((SearchVermasListVO)getVO(request, SearchVermasListVO.class));
		}

		return event;
	}

}
