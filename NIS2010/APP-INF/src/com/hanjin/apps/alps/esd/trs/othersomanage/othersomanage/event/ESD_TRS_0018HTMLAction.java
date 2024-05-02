/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TRS_018HTMLAction.java
*@FileTitle : Other SO 생성화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009-10-01
*@LastModifier : kimjin
*@LastVersion : 1.0
* 2009-10-01 kimjin
* 1.0 최초 생성
* -----------------------------------------------------------------
* History
* 2012.05.08 김종호 [CHM-201217449] [TRS] Additional 칼럼, Other S/O creation 화면 입력기능 일부 변경 
=========================================================*/
package com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.chassisgensetsomanage.chassisgensetsomanage.vo.ChassisGensetVO;
import com.hanjin.apps.alps.esd.trs.invoicemanage.surchargeinputinquiry.vo.SurchargeVO;
import com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.vo.OtherSOVO;
import com.hanjin.apps.alps.esd.trs.othersomanage.othersomanage.vo.OtherSearchVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TrsTrspSvcOrdVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.othersomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OtherSOManageSCSC로 실행요청<br>
 * - OtherSOManageSCSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author kimjin
 * @see EsdTrs0018Event , ESD_TRS_018EventResponse 참조
 * @since J2EE 1.6
 */
public class ESD_TRS_0018HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_018HTMLAction 객체를 생성
	 */
	public ESD_TRS_0018HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_018Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */

	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		/* 
        ibSheet 사용시 fromRequestGrid를 사용하는데 
        prefix는 주로 멀티 Sheet 처리시에 사용하게 된다. (  sheet ID 형태의 prefix 구분자 ) 
        String prefix = "" ;  
        TRS_TRSP_SVC_ORD trs_trsp_svc_ord = TRS_TRSP_SVC_ORD.fromRequestGrid(request, prefix);
       */ 

		FormCommand command = FormCommand.fromRequest(request);
		
		String prefix = "surcharge_" ;

		EsdTrs0018Event event = new EsdTrs0018Event(); 

		event.setTrsTrspSvcOrdVOS	((TrsTrspSvcOrdVO[])getVOs(request, TrsTrspSvcOrdVO.class, ""));
		event.setSurchargeVOS		((SurchargeVO[])	getVOs(request, SurchargeVO.class, prefix));
		event.setChassisGensetVOS	((ChassisGensetVO[])getVOs(request, ChassisGensetVO.class, ""));
		event.setOtherSOVOS			((OtherSOVO[])		getVOs(request, OtherSOVO.class, ""));
		event.setWo_grs_wgt_meas_ut_cd(JSPUtil.getParameter(request, "SURCHARGE_WO_GRS_WGT_MEAS_UT_CD", ""));
 		if(command.isCommand(FormCommand.SEARCH09)){
 		 	event.setOtherSearchVO((OtherSearchVO)getVO(request, OtherSearchVO.class));
		}
	
		event.setRow				(JSPUtil.getParameter(request, "row", ""));
		event.setTrspOtrCostMonDt	(JSPUtil.getParameter(request, "TRSP_SO_COST_MONTH", ""));
		event.setFormUsrOfcCd		(JSPUtil.getParameter(request, "FORM_USR_OFC_CD", ""));
		event.setFormCreUsrId		(JSPUtil.getParameter(request, "FORM_CRE_USR_ID", ""));
		event.setTrspSoTpCd			(JSPUtil.getParameter(request, "TRSP_SO_TP_CD", ""));
		event.setTrspSoStsCd		(JSPUtil.getParameter(request, "TRSP_SO_STS_CD", ""));
		
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