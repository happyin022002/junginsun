/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0420HTMLAction.java
*@FileTitle : ESM_BKG_0420HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 9. 4.
*@LastModifier : 박상훈
*@LastVersion : 1.0
* 2009. 9. 4. 박상훈 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.psamanifest.vo.PsaImpStsVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * ESM_BKG_0420 의 HTML Action Class
 * 
 * @author 박상훈
 * @see HTMLActionSupport
 * @since J2EE 1.6
 */
public class ESM_BKG_0420HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	public ESM_BKG_0420HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		EsmBkg0420Event event = new EsmBkg0420Event();
		FormCommand command = FormCommand.fromRequest(request);
		
		if(command.isCommand(FormCommand.SEARCH)) {
			// 조회 처리
			PsaImpStsVO psaImpStsVO = (PsaImpStsVO)getVO(request, PsaImpStsVO.class);
			
			event.setPsaImpStsVO(psaImpStsVO);
		}else if(command.isCommand(FormCommand.MULTI)) {
			// 수정 처리
			PsaImpStsVO[] psaImpStsVOs = (PsaImpStsVO[])getVOs(request, PsaImpStsVO.class);
			
			event.setPsaImpStsVOs	(psaImpStsVOs						);
			event.setVslCd			(request.getParameter("vsl_cd")		);
			event.setSkdVoyNo		(request.getParameter("skd_voy_no")	);
			event.setSkdDirCd		(request.getParameter("skd_dir_cd")	);
		}else if(command.isCommand(FormCommand.COMMAND01)) {
			// Transmit 전송 처리 
			PsaImpStsVO psaImpStsVO = (PsaImpStsVO)getVO(request, PsaImpStsVO.class);
			
			event.setPsaImpStsVO(psaImpStsVO);
		}	else if (command.isCommand(FormCommand.SEARCH03)){
			// BackEndJob 으로 돌린 후 결과코드 조회
			event.setKey(request.getParameter("key"));		
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
