/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_INV_0122HTMLAction.java
*@FileTitle : SVAT Reg. NO for CMBBB
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.11
*@LastModifier : 권 민
*@LastVersion : 1.0
* 2011.10.11 권 민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.fns.inv.accountreceivableinvoicemasterdatamgt.arinvoicecustomermgt.vo.SearchSVATNoVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.InvArSpndVatRgstNoVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.fns.inv.accountreceivableinvoicemasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 AccountReceivableInvoiceMasterDataMgtSC로 실행요청<br>
 * - AccountReceivableInvoiceMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kwon Min
 * @see AccountReceivableInvoiceMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */
 
public class FNS_INV_0123HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_INV_0123HTMLAction 객체를 생성
	 */
	public FNS_INV_0123HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AccountReceivableInvoiceMasterDataMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		log.info("########## FNS_INV_0123HTMLAction");
    	FormCommand command = FormCommand.fromRequest(request);
		FnsInv0123Event event = new FnsInv0123Event();
		SearchSVATNoVO searchSVATNoVo	= new SearchSVATNoVO();
		
		String gubun			= request.getParameter("chkGubun");
		String custCntCd		= null;
		String custSeq			= null;
		String spndVatRgstNo	= null;
		log.info(" gubun ==================> " + gubun);
		log.info(" 1command ==================> " + command.isCommand(FormCommand.MULTI));
		if(command.isCommand(FormCommand.MULTI)) {
			log.info(" 2command ==================> " + command.isCommand(FormCommand.MULTI));
			event.setInvArSpndVatRgstNoVO((InvArSpndVatRgstNoVO)getVO(request, InvArSpndVatRgstNoVO .class,"sheet1_"));
			
		}else if(command.isCommand(FormCommand.SEARCH)) {			
			
			// 검색 항목이 Customer Code 이면 gubun => 0, SVAT Reg. No. 이면 gubun => 1
			if(gubun.equals("0")){
				custCntCd		= request.getParameter("cust_cnt_cd");
				custSeq			= request.getParameter("cust_seq");
			}else if(gubun.equals("1")){
				spndVatRgstNo	= request.getParameter("svat_rgs_no");
			}
			
			int tempCustSeq			= 0;

			if(custSeq != null && !custSeq.equals("")){
				//	사용자에 따라 custSeq 앞 두자리 00 을 붙이는 경우가 있으므로 int 변환으로 00 이 있으면 제거.
				tempCustSeq	= Integer.parseInt(custSeq);
				custSeq		= String.valueOf(tempCustSeq);
			}
			
			searchSVATNoVo.setCustCntCd(custCntCd);
			searchSVATNoVo.setCustSeq(custSeq);
			searchSVATNoVo.setSpndVatRgstNo(spndVatRgstNo);
			searchSVATNoVo.setGubun(gubun);
			
			event.setSearchSVATNoVO(searchSVATNoVo);
			
			log.info("==================> " + event.getSearchSVATNoVO().getCustCntCd());
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