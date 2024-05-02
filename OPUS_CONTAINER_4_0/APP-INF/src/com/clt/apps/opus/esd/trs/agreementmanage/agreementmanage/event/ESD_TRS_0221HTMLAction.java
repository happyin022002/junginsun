/*=========================================================
 *Copyright(c) 2010 CyberLogitec
 *@FileName : ESD_TRS_0221HTMLAction.java
 *@FileTitle : Agreement Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010-03-26
 *@LastModifier : jong hyek choi
 *@LastVersion : 1.0
 * 2010-03-26 jong hyek choi
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.trs.agreementmanage.agreementmanage.vo.DummyAgmtRateVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.trs.agreementmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CYDoorSOManageSC로 실행요청<br>
 * - CYDoorSOManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author jong hyek choi
 * @see EsdTrs0221Event , ESD_TRS_0221EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0221HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TRS_0220HTMLAction 객체를 생성
	 */
	public ESD_TRS_0221HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_002Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0221Event event = new EsdTrs0221Event();
		
		DummyAgmtRateVO dummyAgmtRateVO   = new DummyAgmtRateVO();
		if(command.isCommand(FormCommand.SEARCH01) 
				|| command.isCommand(FormCommand.SEARCH02) 
				|| command.isCommand(FormCommand.MULTI)
				|| command.isCommand(FormCommand.MULTI01)
				|| command.isCommand(FormCommand.REMOVE)
				|| command.isCommand(FormCommand.REMOVE01)
		  ) 
		{
			event.setDummyAgmtRateVOs(dummyAgmtRateVO.fromRequestGrid(request));
		}

		String fm_agmtno          = request.getParameter("fm_agmtno")!=null?request.getParameter("fm_agmtno"):"";
		String fm_trsp_agmt_rt_tp_cd   = request.getParameter("fm_trsp_agmt_rt_tp_cd")!=null?request.getParameter("fm_trsp_agmt_rt_tp_cd"):"";
		String header_row         = request.getParameter("header_row")!=null?request.getParameter("header_row"):"";
		String fm_account_ofc_cd  = request.getParameter("fm_account_ofc_cd")!=null?request.getParameter("fm_account_ofc_cd"):"";
		String fm_account_usr_id  = request.getParameter("fm_account_usr_id")!=null?request.getParameter("fm_account_usr_id"):"";
		String fm_ctrt_ofc_cd     = request.getParameter("fm_ctrt_ofc_cd")!=null?request.getParameter("fm_ctrt_ofc_cd"):"";
		String fm_eq_knd_cd     = request.getParameter("fm_eq_knd_cd")!=null?request.getParameter("fm_eq_knd_cd"):"";
		String trsp_tmp_seq     = request.getParameter("trsp_tmp_seq")!=null?request.getParameter("trsp_tmp_seq"):"";

		event.setFm_agmtno           (fm_agmtno);
		event.setFm_trsp_agmt_rt_tp_cd    (fm_trsp_agmt_rt_tp_cd);
		event.setFm_account_ofc_cd(fm_account_ofc_cd);
		event.setFm_account_usr_id(fm_account_usr_id);
		event.setHeaderRow			 (header_row);
		event.setFm_ctrt_ofc_cd      (fm_ctrt_ofc_cd);
		event.setFm_eq_knd_cd        (fm_eq_knd_cd);
		event.setTrspAgmtTmpSeq(trsp_tmp_seq);



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		String fm_vndr_prmry_seq         = request.getParameter("fm_vndr_prmry_seq")!=null?request.getParameter("fm_vndr_prmry_seq"):"";
		String fm_agmt_ref_no            = request.getParameter("fm_agmt_ref_no")!=null?request.getParameter("fm_agmt_ref_no"):"";
		String fm_trsp_agmt_rt_tp_ser_no = request.getParameter("fm_trsp_agmt_rt_tp_ser_no")!=null?request.getParameter("fm_trsp_agmt_rt_tp_ser_no"):"";
		event.setFmVndrPrmrySeq(fm_vndr_prmry_seq);
		event.setFmAgmtRefNo(fm_agmt_ref_no);
		event.setFmTrspAgmtRtTpSerNo(fm_trsp_agmt_rt_tp_ser_no);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        // 2015.02.06    Hyungwook Choi
		String custCode = request.getParameter("custCode")!=null?request.getParameter("custCode"):"";
		event.setCustCode(custCode);

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