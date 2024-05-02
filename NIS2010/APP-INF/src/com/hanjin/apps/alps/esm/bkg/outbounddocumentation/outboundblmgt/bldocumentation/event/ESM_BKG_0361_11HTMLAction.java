/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0361_11HTMLAction.java
*@FileTitle : Export/Import Information(Turkey)
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 김용진
*@LastVersion : 1.0
* 2011.12.12 김용진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OutboundBLMgtSC로 실행요청<br>
 * - OutboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Yong Jin
 * @see OutboundBLMgtEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0361_11HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0361_11HTMLAction 객체를 생성
	 */
	public ESM_BKG_0361_11HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 OutboundBLMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg036101Event event = new EsmBkg036101Event();
        log.debug("##### CALL:ESM_BKG_0361_11HTMLAction - " + command.getCommand());

        if(command.isCommand(FormCommand.DEFAULT)) {
			// search MnD
        	String bkgNo      = JSPUtil.getParameter(request, "bkg_no");
            String ioBndCd       = JSPUtil.getParameter(request, "io_bnd_cd");
            String polCd       = JSPUtil.getParameter(request, "pol_cd");
            String podCd       = JSPUtil.getParameter(request, "pod_cd");
            String pkgQty       = JSPUtil.getParameter(request, "pkg_qty");
            String pkgTp       = JSPUtil.getParameter(request, "pkg_tp");
            String wgtQty       = JSPUtil.getParameter(request, "wgt_qty");
            String wgtTp       = JSPUtil.getParameter(request, "wgt_tp");
            String goCntCd       = JSPUtil.getParameter(request, "go_cnt_cd");
            String cntCd       = "TR";

            String popUpTpCd   = JSPUtil.getParameter(request, "popUpTpCd");
            String xterSndrId  = JSPUtil.getParameter(request, "xter_sndr_id");
            String xterRqstNo  = JSPUtil.getParameter(request, "xter_rqst_no");
            String xterRqstSeq = JSPUtil.getParameter(request, "xter_rqst_seq");

            event.setBkgNo(bkgNo);
            event.setIoBndCd(ioBndCd);
            event.setPolCd(polCd);
            event.setPodCd(podCd);
            event.setPkgQty(pkgQty);
            event.setPkgTp(pkgTp);
            event.setWgtQty(wgtQty);
            event.setWgtTp(wgtTp);
            event.setGoCntCd(goCntCd);
            event.setCntCd(cntCd);

            event.setPopUpTpCd(popUpTpCd);
            event.setXterSndrId(xterSndrId);
            event.setXterRqstNo(xterRqstNo);
            event.setXterRqstSeq(xterRqstSeq);

        }if(command.isCommand(FormCommand.SEARCH)) {
			// search MnD
        	String bkgNo      = JSPUtil.getParameter(request, "bkg_no");
            String ioBndCd       = JSPUtil.getParameter(request, "io_bnd_cd");
            String cntCd       = "TR";

            String popUpTpCd   = JSPUtil.getParameter(request, "popUpTpCd");
            String xterSndrId  = JSPUtil.getParameter(request, "xter_sndr_id");
            String xterRqstNo  = JSPUtil.getParameter(request, "xter_rqst_no");
            String xterRqstSeq = JSPUtil.getParameter(request, "xter_rqst_seq");

            event.setBkgNo(bkgNo);
            event.setIoBndCd(ioBndCd);
            event.setCntCd(cntCd);

            event.setPopUpTpCd(popUpTpCd);
            event.setXterSndrId(xterSndrId);
            event.setXterRqstNo(xterRqstNo);
            event.setXterRqstSeq(xterRqstSeq);

        }else if(command.isCommand(FormCommand.MULTI)) {
            //manage Mnd

        	XptImpLicVO[] xptImpLicVOs = (XptImpLicVO[]) getVOs(request, XptImpLicVO.class);

        	String bkgNo      = JSPUtil.getParameter(request, "bkg_no");
            String pkgTp       = JSPUtil.getParameter(request, "pkg_tp");
            String wgtTp       = JSPUtil.getParameter(request, "wgt_tp");

            event.setBkgNo(bkgNo);
            event.setPkgTp(pkgTp);
            event.setWgtTp(wgtTp);

            event.setXptImpLicVOs(xptImpLicVOs);
        	event.setCntCd("TR");
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