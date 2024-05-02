/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : UI_GEM_0010HTMLAction.java
*@FileTitle : Expense Code Inquiry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.21
*@LastModifier : 최정미
*@LastVersion : 1.0
* 2009.04.21 최정미
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.event;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.ExpenseInfoMgtVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.GemAcctExptVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.GemAcctMtxVO;
import com.hanjin.apps.alps.cps.gem.gemcommon.gemmastercodemgt.vo.GemExpenseVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * UI_GEM-0007 Expense Code Maintenance
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.gae.gaecommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GEMCommonSC로 실행요청<br>
 * - GEMCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author choijungmi
 * @see GEMCommonEvent 참조
 * @since J2EE 1.4
 */

public class CPS_GEM_0007HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	
	/**
	 * CPS_GEM_0007HTMLAction 객체를 생성
	 */
	public CPS_GEM_0007HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GEMCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		
		//이벤트 객체 생성 
		CpsGem0007Event event = new CpsGem0007Event();
		ExpenseInfoMgtVO expenseInfoMgtVO = new ExpenseInfoMgtVO();

		// ----------------------------------------------------
		// 화면 취득값  공통 정보 설정 
		// ----------------------------------------------------		

		//Expense 정보 VO취득
		GemExpenseVO gemExpenseVO = (GemExpenseVO)getVO(request, GemExpenseVO.class);
		
		//삭제 플래그 설정
		String deltFlg = gemExpenseVO.getDeltFlg();			
		if (deltFlg == null || deltFlg.equals("")) {
			gemExpenseVO.setDeltFlg("N");
		}
		
		String acctMtxDeltFlg = gemExpenseVO.getAcctMtxDeltFlg();			
		if (acctMtxDeltFlg == null || acctMtxDeltFlg.equals("")) {
			gemExpenseVO.setAcctMtxDeltFlg("N");
		}

		String acctExptDeltFlg = gemExpenseVO.getAcctExptDeltFlg();			
		if (acctExptDeltFlg == null || acctExptDeltFlg.equals("")) {
			gemExpenseVO.setAcctExptDeltFlg("N");
		}

		// 컨테이너 VO에 취득값 설정
		expenseInfoMgtVO.setGemExpenseVO(gemExpenseVO);
		event.setExpenseInfoMgtVO(expenseInfoMgtVO);		    		
		
		// ----------------------------------------------------
		// 이벤트 처리 
		// ----------------------------------------------------		
		//[Grid_Account Information] account code 이름 취득및 존재유무 체크
		if(command.isCommand(FormCommand.SEARCHLIST04)) {
			String acctCd = JSPUtil.getParameter(request, "acct_cd","");
			event.setAcctCd(acctCd);
		//[Grid_Divided by Office]  office code check
		} else if(command.isCommand(FormCommand.SEARCHLIST07)) {
				String ofcCd = JSPUtil.getParameter(request, "ofc_cd","");
				event.setOfcCd(ofcCd);
		//[Grid_Divided by Office]  account code check
		} else if(command.isCommand(FormCommand.SEARCHLIST08)) {
			String acctCd = JSPUtil.getParameter(request, "acct_cd","");
			event.setAcctCd(acctCd);
			String ofcCd = JSPUtil.getParameter(request, "ofc_cd","");
			event.setOfcCd(ofcCd);							
	    //[Save]
		} else if(command.isCommand(FormCommand.MULTI)) {
			
			// [Grid_Account Information] 정보설정
			GemAcctMtxVO[] arrGaeAcctMtxVOs = (GemAcctMtxVO[]) getVOs(request,
					GemAcctMtxVO.class , "sheet1_");			
			if(arrGaeAcctMtxVOs != null) {
				List<GemAcctMtxVO> gemAcctMtxVOs = Arrays.asList(arrGaeAcctMtxVOs);
				expenseInfoMgtVO.setGemAcctMtxVOs(gemAcctMtxVOs);
			}
			
			// [Grid_Divided by Office] 정보설정
			GemAcctExptVO[] arrGaeAcctExptVO = (GemAcctExptVO[]) getVOs(
					request, GemAcctExptVO.class, "sheet2_");
			
			if(arrGaeAcctExptVO != null) {
				List<GemAcctExptVO> gemAcctExptVOs = Arrays.asList(arrGaeAcctExptVO);
				expenseInfoMgtVO.setGemAcctExptVOs(gemAcctExptVOs );	
			}
						
			//컨테이너 설정
			event.setExpenseInfoMgtVO(expenseInfoMgtVO);
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