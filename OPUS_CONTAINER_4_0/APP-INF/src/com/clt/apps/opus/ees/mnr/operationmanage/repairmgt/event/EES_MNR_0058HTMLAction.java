/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0058HTMLAction.java
*@FileTitle : M&R Extra Expense W/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.03
*@LastModifier : 정영훈
*@LastVersion : 1.0
* 2009.06.03 정영훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.mnr.operationmanage.eqflagmgt.vo.EQFlagListINVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdDtlVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.CustomMnrOrdHdrVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.GeneralWOGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.GeneralWOINVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.mnr.generalmanage 화면을 통해 서버로 전송되는
 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OperationManageSC로 실행요청<br>
 * - OperationManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 정영훈
 * @see GeneralManageEvent 참조
 * @since J2EE 1.4
 */

public class EES_MNR_0058HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0058HTMLAction 객체를 생성
	 */
	public EES_MNR_0058HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EesMnr0058Event event = new EesMnr0058Event();
		GeneralWOGRPVO extraWOGRPVO = new GeneralWOGRPVO();
		GeneralWOINVO extraWOINVO = new GeneralWOINVO();

		//조회
		if(command.isCommand(FormCommand.SEARCH)) {

			extraWOGRPVO.setGeneralWOINVO((GeneralWOINVO)getVO(request, GeneralWOINVO.class));

		//Modify SAVE
		}else if(command.isCommand(FormCommand.MULTI)) {
			extraWOGRPVO.setGeneralWOINVO((GeneralWOINVO)getVO(request, GeneralWOINVO.class));

			extraWOGRPVO.setEQFlagListINVO((EQFlagListINVO)getVO(request, EQFlagListINVO.class));

			//헤더 데이타
			extraWOGRPVO.setCustomMnrOrdHdrVO((CustomMnrOrdHdrVO)getVO(request, CustomMnrOrdHdrVO.class));
			//디테일 데이타
			extraWOGRPVO.setArrCustomMnrOrdDtlVOS((CustomMnrOrdDtlVO[])getVOs(request, CustomMnrOrdDtlVO.class,"sheet1_"));


		}else if(command.isCommand(FormCommand.SEARCH01)){
			extraWOINVO = (GeneralWOINVO)getVO(request, GeneralWOINVO.class);
			extraWOINVO.setAgmtSeq(String.valueOf(Integer.parseInt(extraWOINVO.getAgmtSeq())));
			extraWOGRPVO.setGeneralWOINVO(extraWOINVO);

		//삭제
		}else if(command.isCommand(FormCommand.REMOVE)){
			extraWOGRPVO.setGeneralWOINVO((GeneralWOINVO)getVO(request, GeneralWOINVO.class));

			//헤더 데이타
			extraWOGRPVO.setCustomMnrOrdHdrVO((CustomMnrOrdHdrVO)getVO(request, CustomMnrOrdHdrVO.class));
			//디테일 데이타
			extraWOGRPVO.setArrCustomMnrOrdDtlVOS((CustomMnrOrdDtlVO[])getVOs(request, CustomMnrOrdDtlVO.class,"sheet1_"));

		}

		event.setExtraWOGRPVO(extraWOGRPVO);
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