/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_PSO_0017HTMLAction.java
*@FileTitle : Canal Invoice
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.29
*@LastModifier : 김진일
*@LastVersion : 1.0
* 2009.05.29 김진일
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.pso.estimateinvoiceaudit.canaltransitfeeestimate.vo.CanalTzFeeSumVO;
import com.clt.apps.opus.vop.pso.psocommon.psocodefinder.vo.VendorListVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.PsoMsaVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.vop.pso.estimateinvoiceaudit 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EstimateInvoiceAuditSC로 실행요청<br>
 * - EstimateInvoiceAuditSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Jin Ihl
 * @see EstimateInvoiceAuditEvent 참조
 * @since J2EE 1.6
 */

public class VOP_PSO_0017HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_PSO_0017HTMLAction 객체를 생성
	 */
	public VOP_PSO_0017HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EstimateInvoiceAuditEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopPso0017Event event = new VopPso0017Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setPsoMsaVOS((PsoMsaVO[])getVOs(request, PsoMsaVO .class,""));
		}
		else if(command.isCommand(FormCommand.SEARCH)) {//Retrieve Button Click시 조회 사용 VO설정
			event.setCanalTzFeeSumVO((CanalTzFeeSumVO)getVO(request, CanalTzFeeSumVO .class));
		}
		else if(command.isCommand(FormCommand.COMMAND01)){//searchVendorList사용VO설정
			//event.setMdmVendorVO((MdmVendorVO)getVO(request, MdmVendorVO .class));
			event.setVendorListVO((VendorListVO)getVO(request, VendorListVO.class));
			//Port_CD를 전달하기 위해 Mdm_vendor의 필드LOC_CD 에 설정 2009.07.30.add for Query
			event.getVendorListVO().setLocCd((String)request.getParameter("port_cd"));//
			event.getVendorListVO().setCnlAgnFlg("Y");//운항 통항에 관련된 Vendor를 쿼리하기 위해 추가 2009.09.07
//			event.getMdmVendorVO().setLocCd((String)request.getParameter("port_cd"));//
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