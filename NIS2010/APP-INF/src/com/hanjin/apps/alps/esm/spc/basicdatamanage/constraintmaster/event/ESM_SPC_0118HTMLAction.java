/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : ESM_SPC_0118HTMLAction.java
*@FileTitle : Set Customized RPT Form 
*Open Issues :
*Change history :
*@LastModifyDate : 2015.01.23
*@LastModifier : Seung-Man KIM
*@LastVersion : 1.0
* 2015.01.23 Seung-Man KIM
* 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.ReportFormVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SalesRPTCommonVO;
import com.hanjin.apps.alps.esm.spc.basicdatamanage.constraintmaster.vo.SearchConditionVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
//import com.hanjin.syscommon.common.table.CoaRptItmInfoDtlVO;
//import com.hanjin.syscommon.common.table.CoaRptItmInfoMstVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.coa.MultiDimensionRPT 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MultiDimensionRPTSC로 실행요청<br>
 * - MultiDimensionRPTSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Ki Dae
 * @see EsmSpc0118Event 참조
 * @since J2EE 1.6
 */
public class ESM_SPC_0118HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_0060HTMLAction 객체를 생성
	 */
	public ESM_SPC_0118HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmSpc0118Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
    	EsmSpc0118Event event = new EsmSpc0118Event();  		
    	
		 if(command.isCommand(FormCommand.SEARCHLIST12)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setSalesRPTCommonVO((SalesRPTCommonVO)getVO(request, SalesRPTCommonVO.class));
			event.setmReportFormVO((ReportFormVO)getVO(request,ReportFormVO.class));
			event.setAttribute("KEY", request.getParameter("backendjob_key")); 
		}else if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setSalesRPTCommonVO((SalesRPTCommonVO)getVO(request, SalesRPTCommonVO.class));
			event.setmReportFormVO((ReportFormVO)getVO(request,ReportFormVO.class));
		}else if(command.isCommand(FormCommand.SEARCHLIST02)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
//			event.setSalesRPTCommonVO((SalesRPTCommonVO)getVO(request, SalesRPTCommonVO.class));
			event.setmReportFormVO((ReportFormVO)getVO(request,ReportFormVO.class));
		}else if(command.isCommand(FormCommand.SEARCHLIST03)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setmReportFormVO((ReportFormVO)getVO(request,ReportFormVO.class));
		}else if(command.isCommand(FormCommand.MULTI)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setSalesRPTCommonVO((SalesRPTCommonVO)getVO(request, SalesRPTCommonVO.class));
			event.setSalesRPTCommonVOs((SalesRPTCommonVO[])getVOs(request, SalesRPTCommonVO.class, "NoPrefix#lstatus"));
			event.setmReportFormVOs((ReportFormVO[])getVOs(request, ReportFormVO.class));
			event.setmReportFormVO((ReportFormVO)getVO(request,ReportFormVO.class));
//			event.setCoaRptItmInfoDtlVOs((CoaRptItmInfoDtlVO[])getVOs(request, CoaRptItmInfoDtlVO.class));
		}	

		request.setAttribute("Event", event);

		return event;
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
