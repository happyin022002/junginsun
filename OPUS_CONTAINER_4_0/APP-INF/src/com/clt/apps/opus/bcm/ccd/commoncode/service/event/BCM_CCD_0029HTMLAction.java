/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BCM_CCD_0029HTMLAction.java
*@FileTitle : vessel service scope
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.service.event;
 
import javax.servlet.http.HttpServletRequest;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

import com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.clt.apps.opus.bcm.ccd.commoncode.service.vo.ScopeGroupVO;
import com.clt.apps.opus.bcm.ccd.commoncode.service.vo.ScopeLaneVO;
import com.clt.apps.opus.bcm.ccd.commoncode.service.vo.ScopeLimitVO;
import com.clt.apps.opus.bcm.ccd.commoncode.service.vo.ScopeVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.bcm.ccd.commoncode 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 commoncodeSC로 실행요청<br>
 * - commoncodeSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see commoncodeEvent 참조
 * @since J2EE 1.6
 */

public class BCM_CCD_0029HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * BCM_CCD_0029HTMLAction 객체를 생성
	 */
	public BCM_CCD_0029HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 commoncodeEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		BcmCcd0029Event event = new BcmCcd0029Event();
		

		if(command.isCommand(FormCommand.SEARCH02)) {
			event.setScpCd(request.getParameter("svc_scp_cd"));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			ScopeGroupVO scpGroupVO = new ScopeGroupVO();
			scpGroupVO.setScopeVO((ScopeVO)getVO(request, ScopeVO .class));
			scpGroupVO.setScopeLaneVOS((ScopeLaneVO[])getVOs(request, ScopeLaneVO .class, "sheet1_"));
			scpGroupVO.setScopeLimitVOS((ScopeLimitVO[])getVOs(request, ScopeLimitVO .class, "sheet2_"));
			
			ScopeLaneVO[] scopeLaneVOs = scpGroupVO.getScopeLaneVOs();
			ScopeLimitVO[] scopeLimitVOs = scpGroupVO.getScopeLimitVOs();
			
			if(scopeLaneVOs != null){
				for(int i = 0; i < scopeLaneVOs.length; i++){
					scopeLaneVOs[i].setUserId(scpGroupVO.getScopeVO().getUserId());
					scopeLaneVOs[i].setSvcScpCd(scpGroupVO.getScopeVO().getSvcScpCd());
				}
				scpGroupVO.setScopeLaneVOS(scopeLaneVOs);
			}
			if(scopeLimitVOs != null){
				for(int i = 0; i < scopeLimitVOs.length; i++){
					scopeLimitVOs[i].setUserId(scpGroupVO.getScopeVO().getUserId());
					scopeLimitVOs[i].setSvcScpCd(scpGroupVO.getScopeVO().getSvcScpCd());
				}
				scpGroupVO.setScopeLimitVOS(scopeLimitVOs);
			}
			
			event.setScopeGroupVO(scpGroupVO);
		}else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setRqstNo(request.getParameter("rqst_no"));
		}else if(command.isCommand(FormCommand.MULTI02)) {
			ScopeGroupVO scpGroupVO = new ScopeGroupVO();
			scpGroupVO.setScopeVO((ScopeVO)getVO(request, ScopeVO .class));
			scpGroupVO.setScopeLaneVOS((ScopeLaneVO[])getVOs(request, ScopeLaneVO .class, "sheet1_"));
			scpGroupVO.setScopeLimitVOS((ScopeLimitVO[])getVOs(request, ScopeLimitVO .class, "sheet2_"));
			
			ScopeLaneVO[] scopeLaneVOs = scpGroupVO.getScopeLaneVOs();
			ScopeLimitVO[] scopeLimitVOs = scpGroupVO.getScopeLimitVOs();
			
			if(scopeLaneVOs != null){
				for(int i = 0; i < scopeLaneVOs.length; i++){
					scopeLaneVOs[i].setUserId(scpGroupVO.getScopeVO().getUserId());
					scopeLaneVOs[i].setSvcScpCd(scpGroupVO.getScopeVO().getSvcScpCd());
				}
				scpGroupVO.setScopeLaneVOS(scopeLaneVOs);
			}
			if(scopeLimitVOs != null){
				for(int i = 0; i < scopeLimitVOs.length; i++){
					scopeLimitVOs[i].setUserId(scpGroupVO.getScopeVO().getUserId());
					scopeLimitVOs[i].setSvcScpCd(scpGroupVO.getScopeVO().getSvcScpCd());
				}
				scpGroupVO.setScopeLimitVOS(scopeLimitVOs);
			}
			event.setScopeGroupVO(scpGroupVO);
			event.setMdmDatProcVO((MdmDatProcVO)getVO(request, MdmDatProcVO .class,""));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setSlanCd(request.getParameter("vsl_slan_cd"));
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setRgnCd(request.getParameter("rgn_cd"));
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