/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BIS_0743HTMLAction.java
*@FileTitle : B/L Print Option 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bis.blinformationmgt.blinformationmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgUsrDfltSetVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingreport.statusreport 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingReportSC로 실행요청<br>
 * - BookingReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Gyoung Sub
 * @see EsmBis0743Event 참조
 * @since J2EE 1.5
 */

public class ESM_BIS_0743HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;
    /**
     * ESM_BKG_0743HTMLAction 객체를 생성
     */
    public ESM_BIS_0743HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsmBis0743Event로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);

		EsmBis0743Event event = new EsmBis0743Event();
		
		if (command.isCommand(FormCommand.SEARCH)){
			event.setInfoVO((BkgUsrDfltSetVO) getVO(request, BkgUsrDfltSetVO.class));
			event.setBkgNo(JSPUtil.getParameter(request,"bkg_no"));
			event.setCorrNo(JSPUtil.getParameter(request,"corr_no"));
			event.setChargeTp(JSPUtil.getParameter(request,"form_Rate"));
			event.setContainerTp(JSPUtil.getParameter(request,"form_Cntr"));
			event.setHiddenData(JSPUtil.getParameter(request,"hiddenData"));
			
		}else if (command.isCommand(FormCommand.SEARCH01)){
			event.setInfoVO((BkgUsrDfltSetVO) getVO(request, BkgUsrDfltSetVO.class));
			event.setBkgNo(JSPUtil.getParameter(request,"bkg_no"));
			event.setCorrNo(JSPUtil.getParameter(request,"corr_no"));
			event.setChargeTp(JSPUtil.getParameter(request,"form_Rate"));
			event.setContainerTp(JSPUtil.getParameter(request,"form_Cntr"));
			event.setHiddenData(JSPUtil.getParameter(request,"hiddenData"));
			
		}else if (command.isCommand(FormCommand.SEARCH02)){
			event.setInfoVO((BkgUsrDfltSetVO) getVO(request, BkgUsrDfltSetVO.class));
			event.setBkgNo(JSPUtil.getParameter(request,"bkg_no"));
		}else if (command.isCommand(FormCommand.MODIFY01)){
			event.setInfoVO((BkgUsrDfltSetVO) getVO(request, BkgUsrDfltSetVO.class));
			if(!JSPUtil.getNull(request.getParameter("form_type")).equals("")){
				event.getInfoVO().setBlPrnSetup(JSPUtil.getNull(request.getParameter("form_type"))
						                   +">"+JSPUtil.getNull(request.getParameter("form_Rate"))
						                   +">"+JSPUtil.getNull(request.getParameter("form_Cntr"))
						                   +">"+JSPUtil.getNull(request.getParameter("face_print_cnt"))
						                   +">"+JSPUtil.getNull(request.getParameter("rider_print_cnt"))
						                   +">"+JSPUtil.getNull(request.getParameter("bl_face_prn_dvc_nm"))
						                   +">"+JSPUtil.getNull(request.getParameter("bl_ridr_prn_dvc_nm"))
						                       );			
			} 
		}else if (command.isCommand(FormCommand.MODIFY02)){
			event.setInfoVO2((BlIssInfoVO) getVO(request, BlIssInfoVO.class));
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