/*=========================================================
*Copyright(c) 2010 CyberLogitec
*@FileName : ESD_SCE_0127HTMLAction.java
*@FileTitle : Edi 323 Adjustment 관리 pop up 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2013.10.02
*@LastModifier : 박은정
*@LastVersion : 1.0
* 2013.10.02 박은정
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.event;

import javax.servlet.http.HttpServletRequest;


import com.hanjin.apps.alps.esd.sce.customerscheduleedi.portpairexception.vo.Edi323AdjustmentLaneVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.sce.visibilitymanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 Edi323AdjustmentLaneVO로 실행요청<br>
 * - Edi323AdjustmentLaneVO에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Park Eunjung
 * @see VisibilityManageEvent 참조
 * @since J2EE 1.6
 */

public class ESD_SCE_0127HTMLAction  extends HTMLActionSupport {

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdSce0127Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsdSce0127Event event = new EsdSce0127Event();
		
		if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setEdi323AdjustmentLaneVO((Edi323AdjustmentLaneVO)getVO(request,Edi323AdjustmentLaneVO.class));
		}if(command.isCommand(FormCommand.SEARCH01)) {

			event.setAttribute("slan_cd", request.getParameter("slan_cds"));
			
			
			
		}

		return  event;
	}

}
