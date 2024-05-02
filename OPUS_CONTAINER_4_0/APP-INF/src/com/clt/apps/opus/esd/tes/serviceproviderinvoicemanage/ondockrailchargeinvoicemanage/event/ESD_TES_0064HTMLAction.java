/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_0064HTMLAction.java
*@FileTitle : On-dock Rail Charge Invoice 등록 및 Confirm화면-Coincidence
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-28
*@LastModifier : parkyeonjin
*@LastVersion : 1.0
* 2006-11-28 parkyeonjin
* 1.0 최초 생성
* 2009-03-12 [R200903110001] : TES_TML_SO_PAY_DYS 테이블 미사용 제거 주석처리
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.bcm.fin.fincommon.fincommon.vo.CheckInvoiceNoVO;
import com.clt.apps.opus.esd.tes.common.vo.TesCommonVO;
import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.ondockrailchargeinvoicemanage.vo.OndockRailChargeInvoiceCommonVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.syscommon.common.table.ApPayInvVO;
import com.clt.syscommon.common.table.TesTmlSoCntrListVO;
import com.clt.syscommon.common.table.TesTmlSoDtlVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ServiceProviderInvoiceManageSC로 실행요청<br>
 * - ServiceProviderInvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author parkyeonjin
 * @see EsdTes0064Event , ESD_TES_0064EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TES_0064HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TES_0064HTMLAction 객체를 생성
	 */
	public ESD_TES_0064HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TES_0064Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		if(log.isDebugEnabled())log.debug("==========ESD_TES_0064HTMLAction    perform ============");
		
		EsdTes0064Event event = new EsdTes0064Event();
		
		event.setTesTmlSoHdrVO((TesTmlSoHdrVO)getVO(request, TesTmlSoHdrVO .class));
		event.setOndockRailChargeInvoiceCommonVO((OndockRailChargeInvoiceCommonVO)getVO(request, OndockRailChargeInvoiceCommonVO .class));
		event.setApPayInvVO((ApPayInvVO)getVO(request, ApPayInvVO .class));
		
		event.setTesCommonVO((TesCommonVO)getVO(request, TesCommonVO .class));
		event.setTesTmlSoCntrListVO((TesTmlSoCntrListVO)getVO(request, TesTmlSoCntrListVO .class));
		
		event.setTesTmlSoCntrListVOs((TesTmlSoCntrListVO[])getVOs(request, TesTmlSoCntrListVO.class,""));
		event.setTesTmlSoDtlVOs((TesTmlSoDtlVO[])getVOs(request, TesTmlSoDtlVO.class,""));
		
		event.setCheckInvoiceNoVO((CheckInvoiceNoVO)getVO(request, CheckInvoiceNoVO .class));

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