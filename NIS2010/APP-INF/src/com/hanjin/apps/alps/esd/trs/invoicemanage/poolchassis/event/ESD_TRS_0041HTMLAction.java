/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_041HTMLAction.java
*@FileTitle : Pool Chassis reposition cost 처리
*Open Issues :
*Change history :
*@LastModifyDate : 2008-12-04
*@LastModifier : ah young Han
*@LastVersion : 1.0
* 2008-12-04 ah young Han
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.invoicemanage.poolchassis.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.invoicemanage.poolchassis.event.EsdTrs0041Event;
import com.hanjin.apps.alps.esd.trs.invoicemanage.poolchassis.vo.SearchInvoicePoolChassisVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TrsTrspPoolChssInvVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.invoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InvoiceManageSC로 실행요청<br>
 * - InvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author ah young Han
 * @see EsdTrs0041Event , ESD_TRS_041EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0041HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_041HTMLAction 객체를 생성
	 */
	public ESD_TRS_0041HTMLAction() {  
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_041Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
	  	EsdTrs0041Event event = new EsdTrs0041Event();
	  		  	
	    if(command.isCommand(FormCommand.SEARCH10)){
	    	event.setSearchInvoicePoolChassisVo((SearchInvoicePoolChassisVO)getVO(request, SearchInvoicePoolChassisVO.class));  		
	  	}else if(command.isCommand(FormCommand.SEARCH01)){
	  		event.setSearchInvoicePoolChassisVo((SearchInvoicePoolChassisVO)getVO(request, SearchInvoicePoolChassisVO.class));
  	    }else if(command.isCommand(FormCommand.SEARCH03)){
	  		event.setSearchInvoicePoolChassisVo((SearchInvoicePoolChassisVO)getVO(request, SearchInvoicePoolChassisVO.class));
  	    }else if(command.isCommand(FormCommand.MULTI01)){
  	    	event.setSearchInvoicePoolChassisVo((SearchInvoicePoolChassisVO)getVO(request, SearchInvoicePoolChassisVO.class));
	  		event.setTrsTrspPoolChssInvVOs((TrsTrspPoolChssInvVO[])getVOs(request, TrsTrspPoolChssInvVO.class, ""));
  	    }else if(command.isCommand(FormCommand.MULTI02)){
  	    	event.setSearchInvoicePoolChassisVo((SearchInvoicePoolChassisVO)getVO(request, SearchInvoicePoolChassisVO.class));
	  		event.setTrsTrspPoolChssInvVOs((TrsTrspPoolChssInvVO[])getVOs(request, TrsTrspPoolChssInvVO.class, ""));
  	    }else if(command.isCommand(FormCommand.MULTI03)){
  	    	event.setSearchInvoicePoolChassisVo((SearchInvoicePoolChassisVO)getVO(request, SearchInvoicePoolChassisVO.class));
	  		event.setTrsTrspPoolChssInvVOs((TrsTrspPoolChssInvVO[])getVOs(request, TrsTrspPoolChssInvVO.class, ""));
  	    }else if(command.isCommand(FormCommand.MULTI04)){
  	    	event.setSearchInvoicePoolChassisVo((SearchInvoicePoolChassisVO)getVO(request, SearchInvoicePoolChassisVO.class));
	  		event.setTrsTrspPoolChssInvVOs((TrsTrspPoolChssInvVO[])getVOs(request, TrsTrspPoolChssInvVO.class, ""));
  	    }else if(command.isCommand(FormCommand.MODIFY02)){
  	    	event.setSearchInvoicePoolChassisVo((SearchInvoicePoolChassisVO)getVO(request, SearchInvoicePoolChassisVO.class));
	  		
  	    }else if(command.isCommand(FormCommand.REMOVE01)){
  	    	event.setSearchInvoicePoolChassisVo((SearchInvoicePoolChassisVO)getVO(request, SearchInvoicePoolChassisVO.class));
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