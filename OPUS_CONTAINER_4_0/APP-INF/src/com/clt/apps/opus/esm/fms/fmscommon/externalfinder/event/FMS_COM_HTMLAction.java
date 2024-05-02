/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FMS_COM_HTMLAction.java
*@FileTitle : Common Code List
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.fms.fmscommon.externalfinder.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.FmsCodeParamVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.FmsCommonVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchContractInfoVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchContractNoVO;
import com.clt.apps.opus.esm.fms.fmscommon.externalfinder.vo.SearchDefaultDateVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.fms.fmscommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 FMSCommonSC로 실행요청<br>
 * - FMSCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see FMSCommonEvent 참조
 * @since J2EE 1.4
 */
public class FMS_COM_HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
	
	/**
	 * MNR_COM_HTMLAction 객체를 생성
	 */  
	public FMS_COM_HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 MNRCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */   
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
    	FmsComEvent event = new FmsComEvent(); 
		  
		//공통코드 콤보용 조회
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchDefaultDateVO((SearchDefaultDateVO)getVO(request, SearchDefaultDateVO.class));
		}else if(command.isCommand(FormCommand.SEARCH01)){//ContractNo Search.
			event.setSearchContractNoVO((SearchContractNoVO)getVO(request, SearchContractNoVO.class));
		}else if(command.isCommand(FormCommand.SEARCH02)){//Contract Info Search.
			event.setSearchContractInfoVO((SearchContractInfoVO)getVO(request, SearchContractInfoVO.class));
		}else if(command.isCommand(FormCommand.SEARCH03)){//Tax Type Search.
			event.setFmsCodeParamVO((FmsCodeParamVO)getVO(request, FmsCodeParamVO.class));
		}else if(command.isCommand(FormCommand.SEARCH04)){//TI/TO VVD Search.
			event.setFmsCommonVO((FmsCommonVO)getVO(request, FmsCommonVO.class));
		}else if(command.isCommand(FormCommand.SEARCH05)){//Service Lane Direction Search.
			event.setFmsCommonVO((FmsCommonVO)getVO(request, FmsCommonVO.class));
		}else if(command.isCommand(FormCommand.SEARCH06)){//Fin Direction Search.
			event.setFmsCommonVO((FmsCommonVO)getVO(request, FmsCommonVO.class));
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