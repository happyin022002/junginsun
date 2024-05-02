/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2001HTMLAction.java
*@FileTitle : DEM/DET Exception - S/C Exception Terms Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.05.25 이성훈
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ChssScExceptionVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.SCExceptionParmVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CHSSSCExceptionVersionVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.ees.cgm.cgmcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DMTExceptionMgtSC로 실행요청<br>
 * - CgmCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kyoungwan, Cho
 * @see EesCgm1209Event 참조
 * @since J2EE 1.4
 */

public class EES_CGM_1209HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ees_dmt_2014HTMLAction 객체를 생성
	 */
	public EES_CGM_1209HTMLAction() {}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DMTExceptionMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand 		command 	= FormCommand.fromRequest(request);
    	EesCgm1209Event 	event 		= new EesCgm1209Event();
    	
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}	
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}	
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}	
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}	
			
		else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH10)) {
			event.setsCExceptionVersionVO((CHSSSCExceptionVersionVO)getVO(request, CHSSSCExceptionVersionVO .class));
		}	
		else if(command.isCommand(FormCommand.SEARCH11)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}	
		else if(command.isCommand(FormCommand.SEARCH12)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}	
		else if(command.isCommand(FormCommand.SEARCH13)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}		
		else if(command.isCommand(FormCommand.SEARCH14)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCH15)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}
		//S/C Exception Tariff 의 Group Seq.에 대한 하위 항목들을 모두 조회한다.
		else if(command.isCommand(FormCommand.SEARCH16)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}
		//S/C Exception Tariff 의 현재 선택되어진 Group Seq. 정보만 조회한다.
		else if(command.isCommand(FormCommand.SEARCH17)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}
		//화면에서 입력한 S/C 정보와 기등록된 S/C 정보중 중복된 데이터가 있는지 조회 합니다.
		else if(command.isCommand(FormCommand.SEARCH18)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}		
		//화면에서 입력한 PROP_NO에 대한 CUSTOMER 정보가 중복인지 조회한다.
		else if(command.isCommand(FormCommand.SEARCH19)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}		
		//페이지 로드시 초기화 시켜야할 컨트롤들에 대한 정보를 조회한다.
		else if(command.isCommand(FormCommand.COMMAND01)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}
		//S/C Exception Tariff 의 선택한 Group Seq. 와 그 하위 모든 항목을 삭제한다.
		else if(command.isCommand(FormCommand.MULTI01)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}
		//Update 버튼 클릭시 'Live'상태의 S/C Exception Tariff 정보를 새로운 버전으로 생성한다.
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}	
		//S/C Exception Tariff History 팝업화면에서 Copy 버튼 클릭시 현재 버전에 있는 정보를 삭제하고 현재 버전에 선택한 버전의 정보로  생성한다.
		else if(command.isCommand(FormCommand.MULTI03)) {
			event.setSCExceptionParmVO((SCExceptionParmVO)getVO(request, SCExceptionParmVO .class));
		}		
		else if(command.isCommand(FormCommand.MULTI)) {
//			//현재 Requested 상태의 버전정보를 Update 한 후 2103 번 팝업화면에서 복사한 정보로 Save 를 수행한 경우,
//			//버전의 기존정보를 삭제하기 위한 정보를 담고 있는 VO 객체
//			event.setSCExceptionDeleteVO((SCExceptionDeleteVO)getVO(request, SCExceptionDeleteVO .class));
//			
			//Version
			event.setsCExceptionVersionVO((CHSSSCExceptionVersionVO)getVO(request, CHSSSCExceptionVersionVO .class));
			
			//Group
			ChssScExceptionVO chssScExceptionVO = new ChssScExceptionVO();
			event.setChssScExceptionVOS(chssScExceptionVO.fromRequestGrid(request, "scGrp"));

		} else if(command.isCommand(FormCommand.SEARCH20)) {
            String cmdt_cd =  JSPUtil.getParameter(request, "cmdt_cd".trim(), "");
            event.setAttribute("cmdt_cd", cmdt_cd);
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
