/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CIM_1027HTMLAction.java
*@FileTitle : Location M/B by Logistics-Wise
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.19
*@LastModifier : 문중철
*@LastVersion : 1.0
* 2009.06.19 문중철
* 1.0 Creation
*======================================================
* 2011.01.20 [CHM-201108210-01] 불필요한 log.debug()로직 제거
=========================================================*/
package com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.cim.cntroperationperformancemgt.eqmatchbacknloadfactormgt.vo.MBSearchOptionInGereralVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.es.cim.cntroperationperformancemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CNTROperatioNPerformanceMgtSC로 실행요청<br>
 * - CNTROperatioNPerformanceMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Mun Jung Cheol
 * @see CNTROperatioNPerformanceMgtEvent 참조
 * @since J2EE 1.4
 */
public class EES_CIM_1027HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * UI_CIM_1027HTMLAction 객체를 생성
	 */
	public EES_CIM_1027HTMLAction() {}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CNTROperatioNPerformanceMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
    	String period         =  JSPUtil.getParameter(request, "period"      .trim(), "");
    	String from           =  JSPUtil.getParameter(request, "from"        .trim(), "");
    	String to             =  JSPUtil.getParameter(request, "to"          .trim(), "");
    	String froms          =  JSPUtil.getParameter(request, "froms"       .trim(), "");
    	String tos            =  JSPUtil.getParameter(request, "tos"         .trim(), "");
    	String locationBy     =  JSPUtil.getParameter(request, "locationBy"  .trim(), "");
    	String location       =  JSPUtil.getParameter(request, "location"    .trim(), "");
    	String cargoType      =  JSPUtil.getParameter(request, "cargoType"   .trim(), "");
    	String company        =  JSPUtil.getParameter(request, "company"     .trim(), "");
    	String tpsz           =  JSPUtil.getParameter(request, "tpsz"        .trim(), "");
    	String rdtype         =  JSPUtil.getParameter(request, "rdtype"      .trim(), "");
    	String enRoute        =  JSPUtil.getParameter(request, "enRoute"     .trim(), "");
    	String soc            =  JSPUtil.getParameter(request, "soc"         .trim(), "");
    	String inquiryLevel   =  JSPUtil.getParameter(request, "inquiryLevel".trim(), "");
		EesCim1027Event event = new EesCim1027Event();

		event.setAttribute("period"      , period      );
        event.setAttribute("from"        , from        );
        event.setAttribute("to"          , to          );
        event.setAttribute("froms"       , froms       );
        event.setAttribute("tos"         , tos         );
        event.setAttribute("locationBy"  , locationBy  );
        event.setAttribute("location"    , location    );
        event.setAttribute("cargoType"   , cargoType   );
        event.setAttribute("company"     , company     );
        event.setAttribute("tpsz"        , tpsz        );
        event.setAttribute("rdtype"      , rdtype      );
        event.setAttribute("enRoute"     , enRoute     );
        event.setAttribute("soc"         , soc         );
        event.setAttribute("inquiryLevel", inquiryLevel);
		event.setPeriod      (period      );
        event.setFrom        (from        );
        event.setTo          (to          );
        event.setFroms       (froms       );
        event.setTos         (tos         );
        event.setLocationBy  (locationBy  );
        event.setLocation    (location    );
        event.setCargoType   (cargoType   );
        event.setCompany     (company     );
        event.setTpsz        (tpsz        );
        event.setRdtype      (rdtype      );
        event.setEnRoute     (enRoute     );
        event.setSoc         (soc         );
        event.setInquiryLevel(inquiryLevel);
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setMBSearchOptionInGereralVO((MBSearchOptionInGereralVO)getVO(request, MBSearchOptionInGereralVO .class));
		}else if(command.isCommand(FormCommand.SEARCH01)){
			event.setMBSearchOptionInGereralVO((MBSearchOptionInGereralVO)getVO(request, MBSearchOptionInGereralVO .class));
		}else if(command.isCommand(FormCommand.SEARCH02)){
			event.setMBSearchOptionInGereralVO((MBSearchOptionInGereralVO)getVO(request, MBSearchOptionInGereralVO .class));
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
