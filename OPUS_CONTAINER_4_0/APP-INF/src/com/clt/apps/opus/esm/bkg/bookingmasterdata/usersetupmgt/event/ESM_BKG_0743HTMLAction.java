/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0743HTMLAction.java
*@FileTitle : B/L Print Option 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2009.05.25 김경섭
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingmasterdata.usersetupmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BlIssInfoVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.BkgUsrDfltSetVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingreport.statusreport 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BookingReportSC로 실행요청<br>
 * - BookingReportSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Gyoung Sub
 * @see EsmBkg0743Event 참조
 * @since J2EE 1.5
 */

public class ESM_BKG_0743HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;
    /**
     * ESM_BKG_0743HTMLAction 객체를 생성
     */
    public ESM_BKG_0743HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsmBkg0743Event로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);

		EsmBkg0743Event event = new EsmBkg0743Event();
		
		if (command.isCommand(FormCommand.SEARCH)){
			event.setInfoVO((BkgUsrDfltSetVO) getVO(request, BkgUsrDfltSetVO.class));
			event.setBkgNo(JSPUtil.getParameter(request,"bkg_no"));
			event.setBlNo(JSPUtil.getParameter(request,"bl_no"));
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
		}else if (command.isCommand(FormCommand.MODIFY03)){
			event.setInfoVO2((BlIssInfoVO) getVO(request, BlIssInfoVO.class));
		}else if (command.isCommand(FormCommand.MODIFY04)){
			event.setInfoVO((BkgUsrDfltSetVO) getVO(request, BkgUsrDfltSetVO.class));
			
			int length = request.getParameterValues("mrd_file").length;
			event.setMrdFiles(JSPUtil.getParameter(request,"mrd_file", length));
			length = request.getParameterValues("mrd_param").length;
			event.setMrdParams(JSPUtil.getParameter(request,"mrd_param", length));
			event.setCaYn(JSPUtil.getNull(request.getParameter("ca_yn")));
		}else if (command.isCommand(FormCommand.MODIFY05)){
			event.setInfoVO((BkgUsrDfltSetVO) getVO(request, BkgUsrDfltSetVO.class));

			int length = request.getParameterValues("mrd_file").length;
			event.setMrdFiles(JSPUtil.getParameter(request,"mrd_file", length));
			length = request.getParameterValues("mrd_param").length;
			event.setMrdParams(JSPUtil.getParameter(request,"mrd_param", length));
			length = request.getParameterValues("param_bkg_no").length;
			event.setPBkgNo(JSPUtil.getParameter(request,"param_bkg_no", length));
			length = request.getParameterValues("param_bl_no").length;
			event.setPBlNo(JSPUtil.getParameter(request,"param_bl_no", length));
			event.setCaYn(JSPUtil.getNull(request.getParameter("ca_yn")));
			event.setFormType(JSPUtil.getNull(request.getParameter("form_type")));
		}else if (command.isCommand(FormCommand.SEARCH03)){
			event.setInfoVO((BkgUsrDfltSetVO) getVO(request, BkgUsrDfltSetVO.class));
			event.setFileKey(JSPUtil.getParameter(request,"file_key"));
		}else if (command.isCommand(FormCommand.SEARCH04)){
			event.setInfoVO((BkgUsrDfltSetVO) getVO(request, BkgUsrDfltSetVO.class));
			event.setKey(JSPUtil.getParameter(request,"backendjob_key"));
		}else if (command.isCommand(FormCommand.SEARCH05)){
			event.setInfoVO((BkgUsrDfltSetVO) getVO(request, BkgUsrDfltSetVO.class));
			event.setKey(JSPUtil.getParameter(request,"backendjob_key"));
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