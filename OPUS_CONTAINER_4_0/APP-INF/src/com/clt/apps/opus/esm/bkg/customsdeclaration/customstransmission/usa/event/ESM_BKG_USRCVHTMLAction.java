/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ESM_BKG_USRCVHTMLAction.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.06.17
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.usa.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.ancs.event.EsmBkgUbizcomOpusbkgAnrackEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.event.UbizcomOpusBkgCancusAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.canada.vo.CndCstmsRcvLogVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur.event.OpusbkgUbizcomEurcusAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.eur24.basic.OpusbkgUbizcomEur24cusAckEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.customstransmission.panama.event.OpusbkgPanamaReceiveEvent;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.rocs.event.EsmBkgOpusbkgUdevcomEvent;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;

/**
 * US Customs Rcv Message Test를 위한 Temp Class
 * 
 * @author Kim Minjung
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */
public class ESM_BKG_USRCVHTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_BKG_USRCVHTMLAction 객체를 생성
	 */
	public ESM_BKG_USRCVHTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		String cntCd = request.getParameter("cnt_cd");
		if ("US".equals(cntCd)) {
			Ubiz2comOpusbkgAmsAckEvent event = new Ubiz2comOpusbkgAmsAckEvent();
			event.setFlatFile(request.getParameter("flat_file"));
			request.setAttribute("Event", event);
			return event;
		} else if ("EU".equals(cntCd)) {
			OpusbkgUbizcomEurcusAckEvent event = new OpusbkgUbizcomEurcusAckEvent();
			event.setFlatFile(request.getParameter("flat_file"));
			request.setAttribute("Event", event);
			return event;
		} else if ("EU24".equals(cntCd)) {
			OpusbkgUbizcomEur24cusAckEvent event = new OpusbkgUbizcomEur24cusAckEvent();
			event.setFlatFile(request.getParameter("flat_file"));
			request.setAttribute("Event", event);
			return event;
		} else if ("BE".equals(cntCd)) {
			EsmBkgUbizcomOpusbkgAnrackEvent event = new EsmBkgUbizcomOpusbkgAnrackEvent();
			event.setFlatFile(request.getParameter("flat_file"));
			request.setAttribute("Event", event);
			return event;
		} else if ("PA".equals(cntCd)) {
			OpusbkgPanamaReceiveEvent event = new OpusbkgPanamaReceiveEvent();
			event.setFlatFile(request.getParameter("flat_file"));
			request.setAttribute("Event", event);
			return event;
		} else if ("NL".equals(cntCd)) {
			EsmBkgOpusbkgUdevcomEvent event = new EsmBkgOpusbkgUdevcomEvent();
			event.setFlatFile(request.getParameter("flat_file"));
			request.setAttribute("Event", event);
			return event;
		} else if ("CA".equals(cntCd)) {
			UbizcomOpusBkgCancusAckEvent event = new UbizcomOpusBkgCancusAckEvent();
			CndCstmsRcvLogVO cndCstmsRcvLogVO = new CndCstmsRcvLogVO();
			cndCstmsRcvLogVO.setFlatFile(request.getParameter("flat_file"));
			event.setCstmsRcvLogVO(cndCstmsRcvLogVO);
			request.setAttribute("Event", event);
			return event;
		}
		return null;
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