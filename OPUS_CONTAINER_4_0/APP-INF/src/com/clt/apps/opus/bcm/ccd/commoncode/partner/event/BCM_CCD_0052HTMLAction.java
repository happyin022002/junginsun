/*=========================================================
*Copyright(c) 2014 CyberLogitec
*@FileName : BCM_CCD_0052HTMLAction.java
*@FileTitle : Customer Integration 
*Open Issues :
*Change history :
*@LastModifyDate : 2014.01.22
*@LastModifier : 
*@LastVersion : 1.0
* 2014.01.22 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.bcm.ccd.commoncode.partner.event;
 
import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustomerAddressVO;
import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustomerVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgSalesRepVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MdmCustomerVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.bcm.ccd.commoncode 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 commoncodeSC로 실행요청<br>
 * - commoncodeSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see commoncodeEvent 참조
 * @since J2EE 1.6
 */

public class BCM_CCD_0052HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * BCM_CCD_0052HTMLAction 객체를 생성
	 */
	public BCM_CCD_0052HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 commoncodeEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	
    	/*--035 Customer-------------------------------*/
    	
		BcmCcd0052Event event = new BcmCcd0052Event();
		 log.debug("getIsNewYn0================================"+request.getParameter("is_new_yn"));
		event.setIsNewYn(request.getParameter("is_new_yn"));
		 log.debug("getIsNewYn1================================"+(JSPUtil.getNull(event.getIsNewYn())));

		if(command.isCommand(FormCommand.SEARCH)) {
			event.setCustSeq(request.getParameter("cust_seq"));
			event.setCustCntCd(request.getParameter("cust_cnt_cd"));
		}else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setCustCntCd(request.getParameter("cust_cnt_cd"));
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setLocCd(request.getParameter("loc_cd"));
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setOfcCd(request.getParameter("ofc_cd"));
		}else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setVndrSeq(request.getParameter("vndr_seq"));
		}else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setCapiCurrCd(request.getParameter("capi_curr_cd"));
		}else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setPrfRepCmdtCd(request.getParameter("prf_rep_cmdt_cd"));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setCustomerVOS((CustomerVO[])getVOs(request, CustomerVO.class,""));
			event.setMdmCustomerVOS((MdmCustomerVO[])getVOs(request, MdmCustomerVO.class,""));
			event.setBkgSalesRepVOS((BkgSalesRepVO[])getVOs(request, BkgSalesRepVO .class));
		}else if(command.isCommand(FormCommand.MULTI01)) {	// Authoriy Process 
			event.setMdmDatProcVO((MdmDatProcVO)getVO(request, MdmDatProcVO .class,""));
			event.setCustomerVOS((CustomerVO[])getVOs(request, CustomerVO.class,""));
		}else if(command.isCommand(FormCommand.SEARCH08)) {
			event.setCustCntCd(request.getParameter("cust_cnt_cd"));
	    }else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setCustCd(request.getParameter("cust_cnt_cd")+request.getParameter("cust_seq"));
		}else if(command.isCommand(FormCommand.SEARCH10)) {
			event.setSrepCd(request.getParameter("srep_cd"));
	    }else if(command.isCommand(FormCommand.SEARCH11)) {
			event.setCustGrpId(request.getParameter("cust_grp_id"));
	    }else if(command.isCommand(FormCommand.SEARCH12)) {	// Authoriy Process
	    	event.setMdmDatProcVO((MdmDatProcVO)getVO(request, MdmDatProcVO .class,""));
	    }
		
		
		/*--036 Customer Address-------------------------------*/

		if(command.isCommand(FormCommand.SEARCH20)) {	   //SEARCH 
			event.setCustomerAddressVO((CustomerAddressVO)getVO(request, CustomerAddressVO .class,""));
		}else if(command.isCommand(FormCommand.MULTI)) {   //MULTI20
				event.setCustomerAddressVOS((CustomerAddressVO[])getVOs(request, CustomerAddressVO .class,"sheet2_"));
				event.setAMdmCustomerVOS((MdmCustomerVO[])getVOs(request, MdmCustomerVO.class,"sheet2_"));
				String custCntCd = JSPUtil.getParameter(request, "acust_cnt_cd");
				event.setACustCntCd(custCntCd);	
				String custSeq = JSPUtil.getParameter(request, "acust_seq");
				event.setACustSeq(custSeq);
				String addrTpCd = JSPUtil.getParameter(request, "aaddr_tp_cd");
				event.setAAddrTpCd(addrTpCd);
		}else if(command.isCommand(FormCommand.SEARCH24)) {		//SEARCH04
			event.setACustCd(request.getParameter("cust_cd"));
		}else if(command.isCommand(FormCommand.SEARCH22)) {		//SEARCH02
			event.setACntCd(request.getParameter("cnt_cd"));
		}else if(command.isCommand(FormCommand.SEARCH23)) {		//SEARCH03
			event.setASteCd(request.getParameter("ste_cd"));
		}		
		
		
		/*--037 Customer Contact Point -------------------------------*/
		
		
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