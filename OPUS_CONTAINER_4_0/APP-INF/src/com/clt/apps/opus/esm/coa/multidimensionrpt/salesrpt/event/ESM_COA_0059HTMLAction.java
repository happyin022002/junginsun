/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_COA_0059HTMLAction.java
*@FileTitle : 점소 Weekly 비정형 실적 분석 RPT조회
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.03
*@LastModifier : 김기대
*@LastVersion : 1.0
* 2009.07.03 김기대
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.coa.common.vo.SearchConditionVO;
import com.clt.apps.opus.esm.coa.multidimensionrpt.salesrpt.vo.SalesRPTCommonVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.CoaRptItmInfoDtlVO;
import com.clt.syscommon.common.table.CoaRptItmInfoMstVO;



/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.coa.MultiDimensionRPT 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 MultiDimensionRPTSC로 실행요청<br>
 * - MultiDimensionRPTSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Ki Dae
 * @see EsmCoa0059Event 참조
 * @since J2EE 1.6
 */
public class ESM_COA_0059HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_COA_0059HTMLAction 객체를 생성
	 */
	public ESM_COA_0059HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsmCoa0060Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
    	EsmCoa0059Event event = new EsmCoa0059Event();  		
    	
		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setSalesRPTCommonVO((SalesRPTCommonVO)getVO(request, SalesRPTCommonVO.class));
		}	
		else if(command.isCommand(FormCommand.SEARCHLIST02)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setSalesRPTCommonVO((SalesRPTCommonVO)getVO(request, SalesRPTCommonVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI)) {
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setSalesRPTCommonVO((SalesRPTCommonVO)getVO(request, SalesRPTCommonVO.class));
			event.setSalesRPTCommonVOs((SalesRPTCommonVO[])getVOs(request, SalesRPTCommonVO.class, "NoPrefix#lstatus"));
			event.setCoaRptItmInfoMstVOs((CoaRptItmInfoMstVO[])getVOs(request, CoaRptItmInfoMstVO.class));
			event.setCoaRptItmInfoDtlVOs((CoaRptItmInfoDtlVO[])getVOs(request, CoaRptItmInfoDtlVO.class));
		}		
		else{
			event.setSearchConditionVO((SearchConditionVO)getVO(request, SearchConditionVO.class));
			event.setSalesRPTCommonVO((SalesRPTCommonVO)getVO(request, SalesRPTCommonVO.class));
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