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
package com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchVVDExRateVO;
import com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDExrateVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.fns.inv.accountreceivableinvoicemasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
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
	 * 
	 * @param HttpServletRequest request
	 * @return Event
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
		else if(command.isCommand(FormCommand.SEARCH02)) { // VVD 입력시 
			
			String vvdCd = request.getParameter("vvd_cd").trim();
			event.setVvd(vvdCd);
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {	//search
			
			String bndCd = request.getParameter("bnd_cd").trim();
			String loclCd = request.getParameter("locl_curr_cd").trim();
			String portCd = request.getParameter("vps_port_cd").trim();
			String svcScpCd = request.getParameter("svc_scp_cd").trim();
			String vvdCd = request.getParameter("vvd_cd").trim();
			String xchRtRvsFlg = request.getParameter("xch_rt_rvs_flg").trim();
			String arOfcCd = request.getParameter("ar_ofc_cd2").trim();
			
			SearchVVDExRateVO searchVVDExRateVO = new SearchVVDExRateVO();
			searchVVDExRateVO.setIoBndCd(bndCd);
			searchVVDExRateVO.setPortCd(portCd);
			searchVVDExRateVO.setLoclCurrCd(loclCd);
			searchVVDExRateVO.setSvcScpCd(svcScpCd);
			searchVVDExRateVO.setVvdCd(vvdCd);
			searchVVDExRateVO.setXchRtRvsFlg(xchRtRvsFlg);
			searchVVDExRateVO.setArOfcCd(arOfcCd);

			event.setSearchVVDExRateVO(searchVVDExRateVO);
		}

		request.setAttribute("Event", event);

		return  event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param EventResponse eventResponse
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param HttpServletRequest request
	 * @param Event event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}
}