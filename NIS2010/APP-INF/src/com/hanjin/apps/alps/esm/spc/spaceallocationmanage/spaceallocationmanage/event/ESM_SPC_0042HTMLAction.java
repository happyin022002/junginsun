/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_SPC_0042HTMLAction.java
*@FileTitle : Allocation Change by VVD
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.29
*@LastModifier : 최윤성
*@LastVersion : 1.0
* 2009.07.29 최윤성
* 1.0 Creation
=========================================================
* History
* 2011.08.08 이행지 [CHM-201112741-01] Control by HO/RHQ 화면 보완 - 주차별 CMB 항목 조회되도록 수정
* 2013.01.23 [CHM-201322502-01] SPC 프로젝트 - 성수기 선복운영 개선을 위한 T/F추진
* 2015.03.25 박은주 [CHM-201534916] Allocation by HO/RHQ 의 Edit기능에 Yield Group추가 요청 ->Sync 옵션추가
=========================================================
*/
package com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.spc.common.common.vo.ConditionVO;
import com.hanjin.apps.alps.esm.spc.spaceallocationmanage.spaceallocationmanage.vo.SearchSpaceAllocation0042MListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.SpcAlocCtrlOptVO;
import com.hanjin.syscommon.common.table.SpcAlocCustPolPodVO;
import com.hanjin.syscommon.common.table.SpcAlocPolPodVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.spc.spaceallocationmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 SpaceAllocationManageSC로 실행요청<br>
 * - SpaceAllocationManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 2014.04.15 BKG Standby 컬럼 추가 [김성욱]
 * 2015.06.11 김성욱 [CHM-201535211] SPC BKG 연동
 * 
 * @author CHOI Yun Sung
 * @see SpaceAllocationManageEvent 참조
 * @since J2EE 1.6
 */


public class ESM_SPC_0042HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_SPC_0042HTMLAction 객체를 생성--
	 */
	public ESM_SPC_0042HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 SpaceAllocationManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmSpc0042Event event = new EsmSpc0042Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			SpcAlocPolPodVO[] vos = (SpcAlocPolPodVO[])getVOs(request, SpcAlocPolPodVO .class,"");
			String ctrl = "";
			String ctrl_wgt = "";
			
			for( int i=0 ; i<vos.length ; i++ ) {
				SpcAlocPolPodVO v = vos[i];
				if( "".equals(ctrl) ){
					ctrl = v.getCtrlLvl();
				}
				if( "".equals(ctrl_wgt)){
					ctrl_wgt = v.getCtrlWt();
				}
				if( i > 0) {
					vos[i].setCtrlLvl( ctrl );
					vos[i].setCtrlWt( ctrl_wgt );
				}
			}
			event.setSpcAlocPolPodVOS( vos );
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class)); //--- 임시 추가........2015.06.08
		}
		else if(command.isCommand(FormCommand.MULTI01)) {
			event.setSpcAlocCtrlOptVOS((SpcAlocCtrlOptVO[])getVOs(request, SpcAlocCtrlOptVO .class,""));
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			SpcAlocCustPolPodVO[] vos = (SpcAlocCustPolPodVO[])getVOs(request, SpcAlocCustPolPodVO .class,"");
			String ctrl_wgt = "";
			for( int i=0 ; i<vos.length ; i++ ) {
				SpcAlocCustPolPodVO v = vos[i];
				if( "".equals(ctrl_wgt)){
					ctrl_wgt = v.getCtrlWt();
				}
				if( i > 0) {
					vos[i].setCtrlWt( ctrl_wgt );
				}
			}
			event.setSpcAlocCustPolPodVOS( vos );
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI03)) {
			event.setSpcAlocCustPolPodVOS((SpcAlocCustPolPodVO[])getVOs(request, SpcAlocCustPolPodVO .class,""));
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST01)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST02) || command.isCommand(FormCommand.SEARCHLIST03) || command.isCommand(FormCommand.SEARCH)) {
			event.setSearchSpaceAllocation0042MListVO((SearchSpaceAllocation0042MListVO)getVO(request, SearchSpaceAllocation0042MListVO .class));
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
			
		}else if(command.isCommand(FormCommand.MULTI04)) {
			event.setConditionVO((ConditionVO)getVO(request, ConditionVO .class));
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