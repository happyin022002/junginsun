/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_EQR_0117HTMLAction.java
*@FileTitle : ssss
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 채창호
*@LastVersion : 1.0
* 2009.07.07 채창호
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.event.EesEqr0117Event;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.SearchSafetyStockVO;
import com.hanjin.apps.alps.ees.eqr.defaultmanage.scenariodefaultmanage.vo.EesEqr0117ConditionVO;
import com.hanjin.syscommon.common.table.EqrEccSftStkVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.eqr.defaultmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DefaultManageSC로 실행요청<br>
 * - DefaultManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Chae Change Ho
 * @see DefaultManageEvent 참조
 * @since J2EE 1.6
 */

public class EES_EQR_0117HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_EQR_0117HTMLAction 객체를 생성
	 */
	public EES_EQR_0117HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DefaultManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesEqr0117Event event = new EesEqr0117Event();
		EesEqr0117ConditionVO conditionVO = new EesEqr0117ConditionVO();
		EqrEccSftStkVO eqrEccSftStkVO = new EqrEccSftStkVO();
		
		
	   	String loc     = JSPUtil.getParameter(request, "LOC".trim(),"");
	   	String locType = JSPUtil.getParameter(request, "loctype ".trim(), "");
	   	String tpsz    = JSPUtil.getParameter(request,"TPSZ".trim(),"");
	   	String tpsztype = JSPUtil.getParameter(request, "TPSZtype".trim(),"");
	   	String lvlCD = JSPUtil.getParameter(request, "LVLCD".trim(),"");
	   	//String TPSZtypeS = JSPUtil.getParameter(request, "TPSZtypeS".trim(),"");//
	   	
	   	String maxInfoTable = "EQR_ECC_SFT_STK";
	   	//String maxInfoCondition = "";
	   	String cntp_sz_mame  = "";
	   	
	   	event.setLoc(loc);
	   	event.setLoctype(locType);
	   	event.setTpsztype(tpsztype);
	   	event.setTpze(tpsz);
	   	event.setLvlcd(lvlCD);
	   	event.setMaxInfoTable(maxInfoTable);
	   	
	   	
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setSearchSafetyStockVO((SearchSafetyStockVO)getVO(request, SearchSafetyStockVO .class));
		}else if(command.isCommand(FormCommand.SEARCHLIST01)) {
		//	event.setEesEqr0117ConditionVO((EesEqr0117ConditionVO)getVO(request,EesEqr0117ConditionVO .class));
			cntp_sz_mame = JSPUtil.getParameter(request, "col".trim(),"");
			conditionVO.setCol(cntp_sz_mame);
			conditionVO.setSfstk_lvl_cd(JSPUtil.getParameter(request, "sfstk_lvl_cd".trim(),""));
			conditionVO.setEcc_cd(JSPUtil.getParameter(request, "ecc_cd".trim(),""));
			conditionVO.setF_cmd(JSPUtil.getParameter(request, "f_cmd".trim(),""));
			conditionVO.setRow(JSPUtil.getParameter(request, "row".trim(),""));
			conditionVO.setCntr_tpsz_cd(cntp_sz_mame.substring(0,2).toUpperCase());
			event.setEesEqr0117ConditionVO(conditionVO);
			log.debug("==ecc_cd " + conditionVO.getEcc_cd());
		}else if (command.isCommand(FormCommand.MULTI)) {
			//event.setEqrEccSftStkVOs((EqrEccSftStkVO[])getVOs(request ,EqrEccSftStkVO .class));
			eqrEccSftStkVO.fromRequestGrid(request ,tpsztype , loc);
			conditionVO.setLvl_cd(lvlCD);
			event.setEesEqr0117ConditionVO(conditionVO); 
			event.setEqrEccSftStkVOs(eqrEccSftStkVO.getEqrEccSftStkVOs());
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
