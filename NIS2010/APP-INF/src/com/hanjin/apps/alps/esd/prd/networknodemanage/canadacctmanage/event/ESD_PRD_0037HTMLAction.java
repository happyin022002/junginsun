/*=========================================================
*Copyright(c) 2012 CyberLogitec
*@FileName : ESD_PRD_0037HTMLAction.java
*@FileTitle : ESD_PRD_0037HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2012.06.18
*@LastModifier : JunKun Lee
*@LastVersion : 1.0
* 1.0 Creation
* 2012-06-18 JunKun Lee : Rail Receiving (Cut Off) Date 산출 Logic 변경 및 추가 요청
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.prd.networknodemanage.canadacctmanage.vo.CanadaCCTManageVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.prd.canadanetworknodemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 NetworkNodeManageSC로 실행요청<br>
 * - NetworkNodeManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author 2007611
 * @see ESD_PRD_0037Event 참조
 * @since J2EE 1.4
 */
public class ESD_PRD_0037HTMLAction extends HTMLActionSupport{

	/**
	 * ESD_PRD_0037HTMLAction 객체를 생성
	 */
	public ESD_PRD_0037HTMLAction(){
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_PRD_036Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException{

		FormCommand command = FormCommand.fromRequest(request);
		EsdPrd0037Event event = new EsdPrd0037Event();
		event.setAttribute("pgmNo", request.getServletPath().substring(1,13));

		if(command.isCommand(FormCommand.SEARCH)){
			event.setCanadaCCTManageVO((CanadaCCTManageVO) getVO(request, CanadaCCTManageVO.class));
		}else if(command.isCommand(FormCommand.COMMAND01)){
			event.setCanadaCCTManageVOs((CanadaCCTManageVO[]) getVOs(request, CanadaCCTManageVO.class));
		}else if(command.isCommand(FormCommand.SEARCH01)){
			event.setFrmCntCd(JSPUtil.getParameter(request, "frm_cnt_cd"));
			event.setFrmLocCd(JSPUtil.getParameter(request, "frm_loc_cd"));
			
			event.setCanadaCCTManageVOs((CanadaCCTManageVO[]) getVOs(request, CanadaCCTManageVO.class));
		}else if(command.isCommand(FormCommand.SEARCH02)){
			event.setFrmLocCd(JSPUtil.getParameter(request, "frm_loc_cd"));
			
			event.setCanadaCCTManageVOs((CanadaCCTManageVO[]) getVOs(request, CanadaCCTManageVO.class));
		}else if(command.isCommand(FormCommand.SEARCH03)){
			event.setCanadaCCTManageVOs((CanadaCCTManageVO[]) getVOs(request, CanadaCCTManageVO.class));
		}else if(command.isCommand(FormCommand.MULTI)){
			event.setCanadaCCTManageVOs((CanadaCCTManageVO[]) getVOs(request, CanadaCCTManageVO.class));
		}else if(command.isCommand(FormCommand.MULTI02)){
			event.setCanadaCCTManageVOs((CanadaCCTManageVO[]) getVOs(request, CanadaCCTManageVO.class));
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
	@Override
	public void doEnd(HttpServletRequest request, EventResponse eventResponse){
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event){
		request.setAttribute("Event", event);
	}
}
