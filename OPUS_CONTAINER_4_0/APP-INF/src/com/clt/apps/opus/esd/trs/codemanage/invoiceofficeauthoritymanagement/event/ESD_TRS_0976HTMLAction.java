/*=========================================================
 *Copyright(c) 2011 CyberLogitec
 *@FileName : ESD_TRS_0976HTMLAction.java
 *@FileTitle : TRS Invoice Authority
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.11.16
 *@LastModifier : 유선오
 *@LastVersion : 1.2
 * 2011.11.09 SunOh,You
 * 1.0 Creation
-------------------------------------------------------------------
* History
* 2011.11.09 유선오 1.1 [CHM-201114273][TRS] Invoice 권한등록 프로그램 개발
* 2011.11.16 유선오 1.2 [CHM-201114273][TRS] R4J 소스 품질 조치 내역 수정 : Line No.30 클래스의 주석을 기술/Line No.52 메소드의 주석을 기술
=========================================================*/
package com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.event;
import javax.servlet.http.HttpServletRequest;
import com.clt.apps.opus.esd.trs.codemanage.invoiceofficeauthoritymanagement.vo.InvoiceOfficeAuthorityManagementVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.codemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 USADeliveryOrderManageSC로 실행요청<br>
 * - USADeliveryOrderManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Yoo,SunOh
 * @see EsdTrs0976Event , ESD_TRS_976EventResponse 참조
 * @since J2EE 1.6
 */
public class ESD_TRS_0976HTMLAction extends HTMLActionSupport {

	/**
	 *serialVersionUID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_976HTMLAction 객체를 생성
	 */
	public ESD_TRS_0976HTMLAction() {
	}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_0976Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event Interface 를 구현한 객체
	 * @exception HTMLActionException
	 */	
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		@SuppressWarnings("unused")
		int codeLength = 0;
		String[] ibflag = request.getParameterValues("ibflag");
		if (ibflag != null)
			codeLength = ibflag.length;
		InvoiceOfficeAuthorityManagementVO invoiceOfficeAuthorityManagementVO   = new InvoiceOfficeAuthorityManagementVO();
		InvoiceOfficeAuthorityManagementVO [] invoiceOfficeAuthorityManagementVOs = (new InvoiceOfficeAuthorityManagementVO()).fromRequestGrid(request);
		EsdTrs0976Event event = new EsdTrs0976Event();
		event.setInvoiceOfficeAuthorityManagementVOs(invoiceOfficeAuthorityManagementVOs);
		event.setInvoiceOfficeAuthorityManagementVO(invoiceOfficeAuthorityManagementVO);
		String creUsrId = request.getParameter("cre_usr_id");
		String creDt = request.getParameter("cre_dt");
		String updUsrId = request.getParameter( "upd_usr_id");
		String updDt =request.getParameter("upd_dt");
		String ofcEngNm = request.getParameter("ofc_eng_nm");
		String invOfcEngNm = request.getParameter("inv_ofc_eng_nm");
		String ofcCd = request.getParameter("ofc_cd");
		ofcCd = (ofcCd !=null)?ofcCd.toUpperCase():ofcCd;
		String invOfcCd = request.getParameter("inv_ofc_cd");
		invOfcCd = (invOfcCd !=null)?invOfcCd.toUpperCase():invOfcCd;
		event.setCreUsrId(creUsrId);
		event.setCreDt(creDt);
		event.setUpdUsrId(updUsrId);
		event.setUpdDt(updDt);
		event.setOfcEngNm(ofcEngNm);
		event.setInvOfcEngNm(invOfcEngNm);
		event.setOfcCd(ofcCd);
		event.setInvOfcCd(invOfcCd);

		if (command.isCommand(FormCommand.SEARCH20)) {
			event.setInvoiceOfficeAuthorityManagementVO((InvoiceOfficeAuthorityManagementVO)getVO(request,
					InvoiceOfficeAuthorityManagementVO.class));
		} else if (command.isCommand(FormCommand.SEARCH18)) {
			event.setInvoiceOfficeAuthorityManagementVO((InvoiceOfficeAuthorityManagementVO) getVO(request,
					InvoiceOfficeAuthorityManagementVO.class));
		} else if (command.isCommand(FormCommand.MULTI)) {
			event.setInvoiceOfficeAuthorityManagementVO((InvoiceOfficeAuthorityManagementVO) getVO(request,
					InvoiceOfficeAuthorityManagementVO.class));
		} else if (command.isCommand(FormCommand.REMOVE)) {
			event.setInvoiceOfficeAuthorityManagementVO((InvoiceOfficeAuthorityManagementVO) getVO(request,
					InvoiceOfficeAuthorityManagementVO.class));
		}else {
			//
		}
		event.setRow(JSPUtil.getParameter(request, "row",""));
		request.setAttribute("Event", event);
		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request
	 * @param eventResponse         
	 */

	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request
	 * @param event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}
