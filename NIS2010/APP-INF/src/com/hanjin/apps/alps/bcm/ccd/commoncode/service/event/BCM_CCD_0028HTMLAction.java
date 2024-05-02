/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BCM_CCD_0028HTMLAction.java
*@FileTitle : vessel service lane
*Open Issues :
*Change history :
*@LastModifyDate : 2011.02.15
*@LastModifier : 
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.service.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.SLaneGroupVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.SLaneVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.service.vo.SLaneDirVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.bcm.ccd.commoncode 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 commoncodeSC로 실행요청<br>
 * - commoncodeSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see commoncodeEvent 참조
 * @since J2EE 1.6
 */

public class BCM_CCD_0028HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * BCM_CCD_0028HTMLAction 객체를 생성
	 */
	public BCM_CCD_0028HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 commoncodeEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		BcmCcd0028Event event = new BcmCcd0028Event();
		

		if(command.isCommand(FormCommand.SEARCH02)) {
			event.setSlaneCd(request.getParameter("vsl_slan_cd"));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			SLaneGroupVO sLaneGroupVO = new SLaneGroupVO();
			
			sLaneGroupVO.setSLaneDirVOS((SLaneDirVO[])getVOs(request, SLaneDirVO .class, "sheet1_"));
			sLaneGroupVO.setSLaneVO((SLaneVO)getVO(request, SLaneVO .class));
			SLaneDirVO[] sLaneDirVOs = sLaneGroupVO.getSLaneDirVOs();
			
			if(sLaneDirVOs != null){
				for(int i = 0; i < sLaneDirVOs.length; i++){
					sLaneDirVOs[i].setUserId(sLaneGroupVO.getSLaneVO().getUserId());
					sLaneDirVOs[i].setVslSlanCd(sLaneGroupVO.getSLaneVO().getVslSlanCd());
				}
				sLaneGroupVO.setSLaneDirVOS(sLaneDirVOs);
			}
			
			event.setSLaneGroupVO(sLaneGroupVO);

		}else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setRqstNo(request.getParameter("rqst_no"));
		}else if(command.isCommand(FormCommand.MULTI02)) {
			SLaneGroupVO sLaneGroupVO = new SLaneGroupVO();
			
			sLaneGroupVO.setSLaneDirVOS((SLaneDirVO[])getVOs(request, SLaneDirVO .class, "sheet1_"));
			sLaneGroupVO.setSLaneVO((SLaneVO)getVO(request, SLaneVO .class));
			SLaneDirVO[] sLaneDirVOs = sLaneGroupVO.getSLaneDirVOs();
			
			if(sLaneDirVOs != null){
				for(int i = 0; i < sLaneDirVOs.length; i++){
					sLaneDirVOs[i].setUserId(sLaneGroupVO.getSLaneVO().getUserId());
					sLaneDirVOs[i].setVslSlanCd(sLaneGroupVO.getSLaneVO().getVslSlanCd());
				}
				sLaneGroupVO.setSLaneDirVOS(sLaneDirVOs);
			}
			
			event.setSLaneGroupVO(sLaneGroupVO);
			
			event.setMdmDatProcVO((MdmDatProcVO)getVO(request, MdmDatProcVO .class,""));

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