/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0079_06HTMLAction.java
*@FileTitle : Marks & Number/Description of Goods
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.28
*@LastModifier : 김영출
*@LastVersion : 1.0
* 2009.04.28 김영출
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OutboundBLMgtSC로 실행요청<br>
 * - OutboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Youngchul
 * @see OutboundBLMgtEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0079_06HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0079_06HTMLAction 객체를 생성
	 */
	public ESM_BKG_0079_06HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 OutboundBLMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg007906Event event = new EsmBkg007906Event();
        log.debug("##### CALL:ESM_BKG_0079_06HTMLAction : " + command.getCommand());

        if(command.isCommand(FormCommand.DEFAULT)) {
            // search Init
            event.setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
            event.setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
            event.setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
        }else if(command.isCommand(FormCommand.SEARCH)) {
			// search MnD

            event.setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
            event.setBlNo(JSPUtil.getParameter(request, "bl_no", ""));
        //}else if(command.isCommand(FormCommand.SEARCH01)) {
            // search word template
        }else if(command.isCommand(FormCommand.SEARCH02)) {
            // search DG
            event.setBkgNo(JSPUtil.getParameter(request, "bkg_no", ""));
        }else if(command.isCommand(FormCommand.SEARCH03)) {
            // search Pcakgate
            event.setPckTpCd(JSPUtil.getParameter(request, "pck_tp_cd", ""));
        }else if(command.isCommand(FormCommand.MULTI)) {
            //manage Mnd
            /* 프레임워크에서 뒷부분 트림을 하기 때문에..
             * 프레임워크에 영향을 받지 않도록 수정.
             */
            String cmdtDesc = request.getParameter("dg_cmdt_desc");
            String mkDesc = request.getParameter("mk_desc");
            MndVO mndVO = (MndVO)getVO(request, MndVO.class);
            mndVO.setDgCmdtDesc(cmdtDesc == null ? "" : cmdtDesc);
            mndVO.setMkDesc(mkDesc == null ? "" : mkDesc);
            //log.debug("\n111111111111111111111111111111\n" +mndVO.getDgCmdtDesc()+ "\n111111111111111111111111111111\n");
            event.setMndVO(mndVO);
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