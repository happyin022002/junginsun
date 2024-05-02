/*=========================================================
*Copyright(c) 2013 CyberLogitec
*@FileName : VOP_SCG_0105HTMLAction.java
*@FileTitle : Proper IBC Code
*@LastModifyDate : 2013.02.25
*@LastModifier : CHLOE MIJIN SEO
*@LastVersion : 1.0
* 2013.02.25 CHLOE MIJIN SEO
* 1.0 Creation
=========================================================
* History
=========================================================*/
package com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.RsltCdListVO;
import com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt.specialcargomasterdatamgt.vo.ScgPckReguPkgIbcCdVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.scg.specialcargomasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SpecialCargoMasterDataMgtSC로 실행요청<br>
 * - SpecialCargoMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author CHLOE MIJIN SEO
 * @see SpecialCargoMasterDataMgtEvent 참조
 * @since J2EE 1.6
 */

public class VOP_SCG_0105HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_AOM_0105HTMLAction 객체를 생성
	 */
	public VOP_SCG_0105HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SpecialCargoMasterDataMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopScg0105Event event = new VopScg0105Event();
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setRsltCdListVO((RsltCdListVO)getVO(request, RsltCdListVO.class));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setPkgCd(JSPUtil.getParameter(request, "pck_cd"));
			event.setPkgCdSeq(JSPUtil.getParameter(request, "pck_cd_seq"));
			event.setDispNo(JSPUtil.getParameter(request, "disp_no"));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setScgPckReguPkgIbcCdVO((ScgPckReguPkgIbcCdVO)getVO(request, ScgPckReguPkgIbcCdVO.class));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			event.setScgPckReguPkgIbcCdVOs((ScgPckReguPkgIbcCdVO[])getVOs(request, ScgPckReguPkgIbcCdVO.class,""));
		}
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