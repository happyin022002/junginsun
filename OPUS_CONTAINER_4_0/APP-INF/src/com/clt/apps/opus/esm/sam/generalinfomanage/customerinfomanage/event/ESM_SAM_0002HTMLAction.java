/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : ESM_SAM_0002HTMLAction.java
*@FileTitle : Customer Information
*Open Issues :
*Change history :
*@LastModifyDate : 2011.05.09
*@LastModifier : 남궁진호
*@LastVersion : 1.0
* 2011.05.09 남궁진호
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.bcm.ccd.commoncode.partner.vo.CustomerAddressVO;
import com.clt.apps.opus.esm.bkg.bookingmasterdata.bookingmastermgt.vo.BkgSalesRepVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.MdmCustomerVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.CustCoverTeamVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.MoreInfoVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SamCustHistVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SamCustPreInfoVO;
import com.clt.apps.opus.esm.sam.generalinfomanage.customerinfomanage.vo.SearchCustomerVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.MdmCustAddrVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.sam.generalinfomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralInfoManageSC로 실행요청<br>
 * - GeneralInfoManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author NAMKOONGJINHO
 * @see GeneralInfoManageEvent 참조
 * @since J2EE 1.6
 */

public class ESM_SAM_0002HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SAM_0002HTMLAction 객체를 생성
	 */
	public ESM_SAM_0002HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralInfoManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSam0002Event event = new EsmSam0002Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchCustomerVO((SearchCustomerVO)getVO(request, SearchCustomerVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setSearchCustomerVO((SearchCustomerVO)getVO(request, SearchCustomerVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setSearchCustomerVO((SearchCustomerVO)getVO(request, SearchCustomerVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setSearchCustomerVO((SearchCustomerVO)getVO(request, SearchCustomerVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setSearchCustomerVO((SearchCustomerVO)getVO(request, SearchCustomerVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setSearchCustomerVO((SearchCustomerVO)getVO(request, SearchCustomerVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setSearchCustomerVO((SearchCustomerVO)getVO(request, SearchCustomerVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setSearchCustomerVO((SearchCustomerVO)getVO(request, SearchCustomerVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH08)) {
			event.setSearchCustomerVO((SearchCustomerVO)getVO(request, SearchCustomerVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setSearchCustomerVO((SearchCustomerVO)getVO(request, SearchCustomerVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH10)) {
			event.setCustCoverTeamVO((CustCoverTeamVO)getVO(request, CustCoverTeamVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH11)) {
			event.setSearchCustomerVO((SearchCustomerVO)getVO(request, SearchCustomerVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH12)) {
			event.setMoreInfoVO((MoreInfoVO)getVO(request, MoreInfoVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH14)) {
			event.setCheck_String(request.getParameter("Check_String"));
		}	
		else if(command.isCommand(FormCommand.SEARCH15)) {
			event.setCheck_String(request.getParameter("Check_String"));
		}
		else if(command.isCommand(FormCommand.SEARCH16)) {
			event.setCheck_String(request.getParameter("Check_String"));
		}
		else if(command.isCommand(FormCommand.SEARCH17)) {
			event.setCheck_String(request.getParameter("Check_String"));
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			event.setSearchCustomerVOS((SearchCustomerVO[])getVOs(request, SearchCustomerVO .class));
			event.setSearchCustomerVO((SearchCustomerVO)getVO(request, SearchCustomerVO .class));
			event.setSamCustHistVO((SamCustHistVO)getVO(request, SamCustHistVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.setMdmCustAddrVOS((MdmCustAddrVO[])getVOs(request, MdmCustAddrVO .class));
			event.setCustomerAddressVOs((CustomerAddressVO[])getVOs(request, CustomerAddressVO .class));
			event.setMdmCustomerVOs((MdmCustomerVO[])getVOs(request, MdmCustomerVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI03)) {
			event.setSamCustPreInfoVOS((SamCustPreInfoVO[])getVOs(request, SamCustPreInfoVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI04)) {
			event.setCustCoverTeamVOS((CustCoverTeamVO[])getVOs(request, CustCoverTeamVO .class));
			event.setBkgSalesRepVOS((BkgSalesRepVO[])getVOs(request, BkgSalesRepVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI05)) {
			event.setMoreInfoVOS((MoreInfoVO[])getVOs(request, MoreInfoVO .class));
		}
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