/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0070HTMLAction.java
*@FileTitle : compare
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.28
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.09.28 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.ees.eqr.repoplanmanage.cntrrepoplancompare.vo.EesEqr0070ConditionVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.repoplanmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 RepoPlanManageSC로 실행요청<br>
 * - RepoPlanManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Chae Change Ho
 * @see RepoPlanManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0070HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0070HTMLAction 객체를 생성
	 */
	public EES_EQR_0070HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 RepoPlanManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0070Event event = new EesEqr0070Event();
		EesEqr0070ConditionVO conditionVO = new EesEqr0070ConditionVO();

//		SCNR_ID
		conditionVO.setYyyyww(JSPUtil.getParameter(request, "yyyyww".trim(), ""));
		conditionVO.setSeq(JSPUtil.getParameter(request, "seq".trim(), ""));
		conditionVO.setStatustype(JSPUtil.getParameter(request, "status_type".trim(), ""));
		conditionVO.setCompared(JSPUtil.getParameter(request, "compared".trim(),""));
		conditionVO.setMatched(JSPUtil.getParameter(request, "matched".trim(),""));
		conditionVO.setPlanid(JSPUtil.getParameter(request, "planID".trim(),""));
		
    	// FM/TO, At
    	conditionVO.setFmtoat(JSPUtil.getParameter(request, "fmToAt".trim(), ""));
    	
    	// FM/TO
    	conditionVO.setFmtype(JSPUtil.getParameter(request, "fmType".trim(), ""));
    	conditionVO.setFmecccd(JSPUtil.getParameter(request, "fmEccCd".trim(), ""));
    	conditionVO.setFmtypeby(JSPUtil.getParameter(request, "fmTypeBy".trim(), ""));
    	conditionVO.setFmplnyr(JSPUtil.getParameter(request, "fmPlnYr".trim(), ""));
    	conditionVO.setFmplnmn(JSPUtil.getParameter(request, "fmPlnMm".trim(), ""));
    	conditionVO.setFmplnwk(JSPUtil.getParameter(request, "fmPlnWk".trim(), ""));
    	
    	conditionVO.setToplnyr(JSPUtil.getParameter(request, "toPlnYr".trim(), "")); 
    	conditionVO.setToplnmn(JSPUtil.getParameter(request, "toPlnMm".trim(), "")); 
    	conditionVO.setToplnwk(JSPUtil.getParameter(request, "toPlnWk".trim(), ""));
    	
    	conditionVO.setFmtoplnyr(JSPUtil.getParameter(request, "fmToPlnYr".trim(), ""));
    	conditionVO.setFmtoplnmn(JSPUtil.getParameter(request, "fmToPlnMm".trim(), ""));
    	conditionVO.setFmtoplnwk(JSPUtil.getParameter(request, "fmToPlnWk".trim(), ""));
     	
    	conditionVO.setTotoplnyr(JSPUtil.getParameter(request, "toToPlnYr".trim(), "")); 
    	conditionVO.setTotoplnmn(JSPUtil.getParameter(request, "toToPlnMm".trim(), "")); 
    	conditionVO.setTotoplnwk(JSPUtil.getParameter(request, "toToPlnWk".trim(), ""));
    	
    	
    	conditionVO.setTotype(JSPUtil.getParameter(request, "toType".trim(), ""));
    	conditionVO.setToecccd(JSPUtil.getParameter(request, "toEccCd".trim(), ""));
    	conditionVO.setTotypeby(JSPUtil.getParameter(request, "toTypeBy".trim(), ""));   
    	
    	// At
    	conditionVO.setAttype(JSPUtil.getParameter(request, "atType".trim(), ""));
    	conditionVO.setAtecccd(JSPUtil.getParameter(request, "atEccCd".trim(), ""));
    	conditionVO.setAttypeby(JSPUtil.getParameter(request, "atTypeBy".trim(), ""));
    	conditionVO.setAtfmplnyr(JSPUtil.getParameter(request, "atFmPlnYr".trim(), ""));
    	conditionVO.setAtfmplnmn(JSPUtil.getParameter(request, "atFmPlnMm".trim(), ""));
    	conditionVO.setAtfmplnwk(JSPUtil.getParameter(request, "atFmPlnWk".trim(), ""));
    	conditionVO.setAttoplnyr(JSPUtil.getParameter(request, "atToPlnYr".trim(), ""));
    	conditionVO.setAttoplnmn(JSPUtil.getParameter(request, "atToPlnMm".trim(), ""));
    	conditionVO.setAttoplnwk(JSPUtil.getParameter(request, "atToPlnWk".trim(), ""));
    	
    	// TP/SZ
    	conditionVO.setCntrtpszcd(JSPUtil.getParameter(request, "cntrTpszCd".trim(), ""));
    	conditionVO.setOddtype(JSPUtil.getParameter(request,"oddtpsz".trim(),""));
    	conditionVO.setItem(JSPUtil.getParameter(request, "item".trim(),""));
    	conditionVO.setLane(JSPUtil.getParameter(request, "lane".trim() ,""));
    	conditionVO.setVvd(JSPUtil.getParameter(request,"vvd".trim() , ""));
    	
    	event.setEesEqr0070ConditionVO(conditionVO);
    	log.debug("==========cntrTpszCd : "+JSPUtil.getParameter(request, "cntrTpszCd".trim(), ""));
    	log.debug("==========cntrTpszCd : "+JSPUtil.getParameter(request,"oddtpsz".trim(),""));
        event.setCommandClassName("RepoPlanManageSC");
        event.setFormCommand(command);

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