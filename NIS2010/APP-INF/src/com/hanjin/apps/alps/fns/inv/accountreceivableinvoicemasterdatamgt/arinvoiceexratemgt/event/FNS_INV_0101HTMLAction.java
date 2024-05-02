/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0101HTMLAction.java
*@FileTitle : VVD Ex.Rate Creation by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.07.07 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchVVDExRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDExrateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.fns.inv.accountreceivableinvoicemasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author saeil kim
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.6
 */

public class FNS_INV_0101HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0101HTMLAction 객체를 생성
	 */
	public FNS_INV_0101HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMasterDataMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0101Event event = new FnsInv0101Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			event.setExchangeRateVOs((ExchangeRateVO[])getVOs(request, ExchangeRateVO .class,"sheet1_"));
			event.setVvdExrateVOs((VVDExrateVO[])getVOs(request, VVDExrateVO .class,"sheet1_"));
		}
		else if(command.isCommand(FormCommand.REMOVE)) {
			event.setExchangeRateVO((ExchangeRateVO)getVO(request, ExchangeRateVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {	//open
			
			String ofcCd = request.getParameter("ofc_cd").trim();
			String svrId = request.getParameter("svr_id").trim();
			event.setOfcCd(ofcCd);	
			event.setSvrId(svrId);
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {	//search
			
			String bndCd = request.getParameter("bnd_cd").trim();
			String loclCd = request.getParameter("locl_curr_cd").trim();
			String portCd = request.getParameter("vps_port_cd").trim();
			String svcScpCd = request.getParameter("svc_scp_cd").trim();
			String vvdCd = request.getParameter("vvd_cd").trim();
			String xchRtRvsFlg = request.getParameter("xch_rt_rvs_flg").trim();
			
			SearchVVDExRateVO searchVVDExRateVO = new SearchVVDExRateVO();
			searchVVDExRateVO.setIoBndCd(bndCd);
			searchVVDExRateVO.setPortCd(portCd);
			searchVVDExRateVO.setLoclCurrCd(loclCd);
			searchVVDExRateVO.setSvcScpCd(svcScpCd);
			searchVVDExRateVO.setVvdCd(vvdCd);
			searchVVDExRateVO.setXchRtRvsFlg(xchRtRvsFlg);

			event.setSearchVVDExRateVO(searchVVDExRateVO);
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			
			String from_currCd = request.getParameter("curr_cd");
			String to_currCd = request.getParameter("locl_curr_cd");
			String vvdCd = request.getParameter("vvd_cd").trim();
			String portCd = request.getParameter("port_cd").trim();
			String bndCd = request.getParameter("io_bnd_cd").trim();
			
			event.setFromCurrCd(from_currCd);
			event.setToCurrCd(to_currCd);			
			event.setVvd(vvdCd);	
			event.setPort(portCd);	
			event.setBnd(bndCd);	
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