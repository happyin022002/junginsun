/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0122HTMLAction.java
*@FileTitle : HJL Domestic
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.20
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.20 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0122ConditionVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchDefaultYearDomesticPlanVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.EqrDmstPlnVO;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.defaultmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DefaultManageSC로 실행요청<br>
 * - DefaultManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Chae Change Ho
 * @see DefaultManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0122HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0122HTMLAction 객체를 생성
	 */
	public EES_EQR_0122HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DefaultManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0122Event event = new EesEqr0122Event();
		EesEqr0122ConditionVO contionVO = new EesEqr0122ConditionVO();
		EqrDmstPlnVO  eqrDmstPlnVO = new EqrDmstPlnVO();
		EqrDmstPlnVO[]  eqrDmstPlnVOs = null;
		
		// Retrieve 버튼 클릭시    	
    	// FM/TO, At
    	contionVO.setFmToAt(JSPUtil.getParameter(request, "fmToAt".trim(), ""));
    	
    	// FM/TO
    	contionVO.setFmType(JSPUtil.getParameter(request, "fmType".trim(), ""));
    	contionVO.setFmEccCd(JSPUtil.getParameter(request, "fmEccCd".trim(), ""));
    	contionVO.setFmTypeBy(JSPUtil.getParameter(request, "fmTypeBy".trim(), ""));
    	contionVO.setFmPlnYr(JSPUtil.getParameter(request, "fmPlnYr".trim(), ""));
    	contionVO.setToType(JSPUtil.getParameter(request, "toType".trim(), ""));
    	contionVO.setToEccCd(JSPUtil.getParameter(request, "toEccCd".trim(), ""));
    	contionVO.setToTypeBy(JSPUtil.getParameter(request, "toTypeBy".trim(), ""));    	
    	
    	// At
    	contionVO.setAtType(JSPUtil.getParameter(request, "atType".trim(), ""));
    	contionVO.setAtEccCd(JSPUtil.getParameter(request, "atEccCd".trim(), ""));
    	contionVO.setAtTypeBy(JSPUtil.getParameter(request, "atTypeBy".trim(), ""));
    	contionVO.setAtPlnYr(JSPUtil.getParameter(request, "atPlnYr".trim(), ""));
    	
    	// TP/SZ
    	contionVO.setCntrTpszCd(JSPUtil.getParameter(request, "cntrTpszCd".trim(), ""));
    	
    	// Monthly, Weekly
    	contionVO.setMonthWeek(JSPUtil.getParameter(request, "monthWeek".trim(), ""));
    	
    	List<String>   month  = null;
    	
		if(command.isCommand(FormCommand.SEARCHLIST)) {
			event.setsearchDefaultYearDomesticPlan((SearchDefaultYearDomesticPlanVO)getVO(request, SearchDefaultYearDomesticPlanVO .class));
			event.setEesEqr0122ConditionVO(contionVO);
		}else if (command.isCommand(FormCommand.MULTI)){
			month = eqrDmstPlnVO.fromRequestGrid3(request, "s1_");
			event.setMonth(month);
			event.setEesEqr0122ConditionVO(contionVO);
		}else if (command.isCommand(FormCommand.MULTI01)){
			eqrDmstPlnVOs = eqrDmstPlnVO.fromRequestGrid1(request, "s3_");
			event.setEqrDmstPlnVOs(eqrDmstPlnVOs);
			event.setEesEqr0122ConditionVO(contionVO);
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
