/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0100HTMLAction.java
*@FileTitle : VVD Ex.Rate Creation by S/A Date
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 김세일
*@LastVersion : 1.0
* 2009.07.07 김세일
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.event;

import java.util.Arrays;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.ExchangeRateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.SearchVVDPortVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDExrateVO;
import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoiceexratemgt.vo.VVDandPortListVO;
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

public class FNS_INV_0100HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0100HTMLAction 객체를 생성
	 */
	public FNS_INV_0100HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMasterDataMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0100Event event = new FnsInv0100Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			VVDandPortListVO[] vvdAndPortListVOs = (VVDandPortListVO[]) getVOs(request, VVDandPortListVO.class , "sheet1_");
			VVDExrateVO[] vVDExrateVOs = (VVDExrateVO[]) getVOs(request, VVDExrateVO.class , "sheet2_");
			
			event.setVvdAndPortListVOs(Arrays.asList(vvdAndPortListVOs));
			event.setVvdExrateVOs(Arrays.asList(vVDExrateVOs));
			
			ExchangeRateVO[] exchangeRateVOs = (ExchangeRateVO[])getVOs(request, ExchangeRateVO .class,"sheet2_");
			
			event.setExchangeRateVOs(exchangeRateVOs);
			
			String ofcCd = request.getParameter("ofc_cd").trim();
			String svrId = request.getParameter("svr_id").trim();
			String triYn = request.getParameter("tri_yn").trim();
			
			event.setOfcCd(ofcCd);	
			event.setTriYn(triYn);	
			event.setSvrId(svrId);
			
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {	//open
			
			String ofcCd = request.getParameter("ofc_cd").trim();
			String svrId = request.getParameter("svr_id").trim();
			event.setOfcCd(ofcCd);	
			event.setSvrId(svrId);
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {	//retrieve I/O
			
			String bndCd = request.getParameter("bnd_cd").trim();
			String svrId = request.getParameter("svr_id").trim();
			String ofcCd = request.getParameter("ofc_cd").trim();
			String loclCd = request.getParameter("locl_curr_cd").trim();
			String portCd = request.getParameter("vps_port_cd").trim();
			String svcScpCd = request.getParameter("svc_scp_cd").trim();
			String etdDt = request.getParameter("etd_dt2").trim();
			String xchRtRvsFlg = request.getParameter("xch_rt_rvs_flg").trim();
			
			SearchVVDPortVO searchVVDPortVO = new SearchVVDPortVO();
			searchVVDPortVO.setIoBndCd(bndCd);
			searchVVDPortVO.setSvrId(svrId);
			searchVVDPortVO.setOfcCd(ofcCd);
			searchVVDPortVO.setVpsPortCd(portCd);
			searchVVDPortVO.setSvcScpCd(svcScpCd);
			searchVVDPortVO.setEtdaDt(etdDt);
			searchVVDPortVO.setLoclCurrCd(loclCd);
			searchVVDPortVO.setXchRtRvsFlg(xchRtRvsFlg);
			
			event.setSearchVVDPortVO(searchVVDPortVO);
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {	//retrieve triangle
			
			String bndCd = request.getParameter("bnd_cd").trim();
			String svrId = request.getParameter("svr_id").trim();
			String ofcCd = request.getParameter("ofc_cd").trim();
			String loclCd = request.getParameter("locl_curr_cd").trim();
			String portCd = request.getParameter("vps_port_cd").trim();
			String svcScpCd = request.getParameter("svc_scp_cd").trim();
			String etdDt = request.getParameter("etd_dt2").trim();
			String xchRtRvsFlg = request.getParameter("xch_rt_rvs_flg").trim();
			
			SearchVVDPortVO searchVVDPortVO = new SearchVVDPortVO();
			searchVVDPortVO.setIoBndCd(bndCd);
			searchVVDPortVO.setSvrId(svrId);
			searchVVDPortVO.setOfcCd(ofcCd);
			searchVVDPortVO.setVpsPortCd(portCd);
			searchVVDPortVO.setSvcScpCd(svcScpCd);
			searchVVDPortVO.setEtdaDt(etdDt);
			searchVVDPortVO.setLoclCurrCd(loclCd);
			searchVVDPortVO.setXchRtRvsFlg(xchRtRvsFlg);

			event.setSearchVVDPortVO(searchVVDPortVO);
		}else if(command.isCommand(FormCommand.SEARCH04)) {	//retrieve I/O
			
			String svrId = request.getParameter("svr_id").trim();
			String ofcCd = request.getParameter("ofc_cd").trim();
			String loclCd = request.getParameter("locl_curr_cd").trim();
			String etdDt = request.getParameter("etd_dt2").trim();
			String xchRtRvsFlg = request.getParameter("xch_rt_rvs_flg").trim();
			
			SearchVVDPortVO searchVVDPortVO = new SearchVVDPortVO();
			searchVVDPortVO.setSvrId(svrId);
			searchVVDPortVO.setOfcCd(ofcCd);
			searchVVDPortVO.setEtdaDt(etdDt);
			searchVVDPortVO.setLoclCurrCd(loclCd);
			searchVVDPortVO.setXchRtRvsFlg(xchRtRvsFlg);
			
			event.setSearchVVDPortVO(searchVVDPortVO);
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