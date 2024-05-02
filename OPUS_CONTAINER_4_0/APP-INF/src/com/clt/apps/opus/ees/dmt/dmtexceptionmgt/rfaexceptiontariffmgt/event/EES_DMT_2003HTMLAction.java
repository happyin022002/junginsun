/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2003HTMLAction.java
*@FileTitle : DEM/DET Adjustment Request - Before Booking Request
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.11
*@LastModifier : 이성훈
*@LastVersion : 1.0
* 2009.06.11 이성훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionDeleteVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.BeforeExceptionVersionVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCommodityVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionCoverageVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAExceptionRateAdjustVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.vo.RFAProgressVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.dmt.dmtexceptionmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DMTExceptionMgtSC로 실행요청<br>
 * - DMTExceptionMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author SungHoon, Lee
 * @see DMTExceptionMgtEvent 참조
 * @since J2EE 1.4
 */

public class EES_DMT_2003HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ees_dmt_2003HTMLAction 객체를 생성
	 */
	public EES_DMT_2003HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DMTExceptionMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EesDmt2003Event event = new EesDmt2003Event();
		
		//Request Detail 조회
		if(command.isCommand(FormCommand.SEARCH)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Dar No. 목록 조회(Proposal No. 에 해당되는)
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Ver No. 목록 조회(Dar No. 에 해당되는)
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}	
		//Actual Customer. 목록 조회(Prop No. 에 해당되는)
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}	
		//Affiliate 목록 조회(Prop No. 에 해당되는)
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//새로운 DAR No. 조회
		else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Comment History 목록 조회
		else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Before Booking Request 의 상태를 Cancel 처리
		else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Before Booking Request 의 상태를 Approval 처리
		else if(command.isCommand(FormCommand.SEARCH08)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Before Booking Request 의 상태를 Counter Offer 처리
		else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Before Booking Request 의 상태를 Reject 처리
		else if(command.isCommand(FormCommand.SEARCH10)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Approval NO. 조회
		else if(command.isCommand(FormCommand.SEARCH11)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Proposal No. 로 해당 Customer 정보를 조회
		else if(command.isCommand(FormCommand.SEARCH12)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}	
		//Proposal No. 로 해당 RFA No. 정보를 조회
		else if(command.isCommand(FormCommand.SEARCH13)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Proposal No. 로 해당 RFA No. 정보를 조회
		else if(command.isCommand(FormCommand.SEARCH14)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Before Booking Request 의 Request Detail. 에 대한 하위 항목들을 모두 조회한다.
		else if (command.isCommand(FormCommand.SEARCH15)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}
		//Before Booking Request 의 현재 선택되어진 Request Detail. 정보만 조회한다.
		else if (command.isCommand(FormCommand.SEARCH16)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}	
		//Before Booking Request 의 현재 선택되어진 Request Detail. 정보만 조회한다.
		else if (command.isCommand(FormCommand.SEARCH17)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}	
		//Before Booking의 APVL No. 에 해당되는 APVL OFC, DAR No., Version, Status 를 조회한다.
		else if (command.isCommand(FormCommand.SEARCH18)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}			
		//페이지 로드시 초기화 시켜야할 컨트롤들에 대한 정보를 조회한다.
		else if(command.isCommand(FormCommand.COMMAND01)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}	
		//Before Booking Request 의 선택한 Detail Seq. 와 그 하위 모든 항목을 삭제한다.
		else if(command.isCommand(FormCommand.MULTI01)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}	
		//Update 버튼 클릭시 'Approved', 'Rejected' 상태의 Before Booking Request 정보를 새로운 버전으로 생성한다.
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}	
		//DAR History 팝업화면에서 Copy 버튼 클릭시 현재 버전에 있는 정보를 삭제하고 현재 버전에 선택한 버전의 정보로  생성한다.
		else if(command.isCommand(FormCommand.MULTI03)) {
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
		}	
		else if(command.isCommand(FormCommand.MULTI)) {
			//현재 Requested, Counter Offered, Temp. Saved 상태의 버전정보를 Update 한 후 2105 번 팝업화면에서 복사한 정보로 Save 를 수행한 경우,
			//버전의 기존정보를 삭제하기 위한 정보를 담고 있는 VO 객체
			event.setBeforeExceptionDeleteVO((BeforeExceptionDeleteVO)getVO(request, BeforeExceptionDeleteVO .class));
			
			//Comment History
			event.setRFAProgressVO((RFAProgressVO)getVO(request, RFAProgressVO .class));
			
			//Version
			event.setBeforeExceptionVersionVO((BeforeExceptionVersionVO)getVO(request, BeforeExceptionVersionVO .class));

			//Before Booking Request Detail
			BeforeExceptionVO beforeVO = new BeforeExceptionVO();
			event.setBeforeExceptionVOS(beforeVO.fromRequestGrid(request, "subBKGREQDTL"));
			
			//Multi Origin or Destination
			RFAExceptionCoverageVO coverageVO = new RFAExceptionCoverageVO();
			event.setRFAExceptionCoverageVOS(coverageVO.fromRequestGrid(request, "subORGDEST"));
			
			//Rate Adjustment
			RFAExceptionRateAdjustVO rateAdjustVO = new RFAExceptionRateAdjustVO();
			event.setRFAExceptionRateAdjustVOS(rateAdjustVO.fromRequestGrid(request, "subRT"));
			
			//Tiered Free Time 
			RFAExceptionFreeTimeVO rfaExceptionFreeTimeVO = new RFAExceptionFreeTimeVO();
			event.setRFAExceptionFreeTimeVOS(rfaExceptionFreeTimeVO.fromRequestGrid(request, "subFT"));
			
			//Commodity
			RFAExceptionCommodityVO rfaExceptionCommodityVO = new RFAExceptionCommodityVO();
			event.setRFAExceptionCommodityVOS(rfaExceptionCommodityVO.fromRequestGrid(request, "subCM"));
			
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
