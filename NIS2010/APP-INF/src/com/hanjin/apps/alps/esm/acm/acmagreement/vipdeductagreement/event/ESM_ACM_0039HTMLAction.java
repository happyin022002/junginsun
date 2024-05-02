/**
 * Copyright(c) 2016 CyberLogitec
 * @FileName : ESM_ACM_0039HTMLAction.java
 * @FileTitle : Compensation VIP Agreement Creation
 * Open Issues :
 * Change history :
 * @LastModifyDate :
 * @LastModifier :
 * @LastVersion :
 * 2016.05.18 김상현 1.0 Creation.
 */
package com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.acm.acmagreement.vipdeductagreement.vo.VIPAgreementVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser
 * - com.hanjin.apps.alps.esm.acm.acmagreement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing
 * - Parsing 한 정보를 Event로 변환, request에 담아 ACMAgreementSC로 실행요청
 * - ACMAgreementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅
 * @author 김상현
 * @see EsmAcm0039Event 참조
 * @since J2EE 1.6
 */
public class ESM_ACM_0039HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing
	 * @param request
	 * @return Event
	 * @exception HTMLActionException
	 */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmAcm0039Event event = new EsmAcm0039Event();

    	if (command.isCommand(FormCommand.SEARCHLIST) || command.isCommand(FormCommand.SEARCH01)) {
    		event.setVipAgreementVO((VIPAgreementVO)getVO(request, VIPAgreementVO.class));
    	} else if (command.isCommand(FormCommand.MULTI)) {
    		event.setVipAgreementVO((VIPAgreementVO)getVO(request, VIPAgreementVO.class));
    		event.setVipAgreementVOs((VIPAgreementVO[])getVOs(request, VIPAgreementVO.class, ""));
    	}

		return event;
	}

}
