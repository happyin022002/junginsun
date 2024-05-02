/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : FNS_JOO_0011HTMLAction.java
*@FileTitle : Reefer Surcharge Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.13
*@LastModifier : 박희동
*@LastVersion : 1.0
* 2009.07.13 박희동
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.ProcSettlementVO;
import com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement.carriersettlementprocess.vo.SettlementRFVO;
import com.hanjin.apps.alps.fns.joo.joocommon.joofindcodeandcheck.vo.JooCodeParamVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.fns.joo.jointoperationagreementsettlement 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 JointOperationAgreementSettlementSC로 실행요청<br>
 * - JointOperationAgreementSettlementSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Park Hee Dong
 * @see JointOperationAgreementSettlementEvent 참조
 * @since J2EE 1.6
 */

public class FNS_JOO_0011HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * FNS_JOO_0011HTMLAction 객체를 생성
	 */
	public FNS_JOO_0011HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 JointOperationAgreementSettlementEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		FnsJoo0011Event event = new FnsJoo0011Event();
		
		if(command.isCommand(FormCommand.MULTI)||command.isCommand(FormCommand.MULTI01)) {
			SettlementRFVO [] vos  = (SettlementRFVO[])getVOs(request, SettlementRFVO.class,"sheet1_");
			ProcSettlementVO[] vos1 = new ProcSettlementVO[vos.length*2];
			
			for(int inx=0; inx < vos.length; inx++){
				vos1[inx*2  ] = event.setProcSettlementVO(vos[inx]);
				vos1[inx*2+1] = event.setProcSettlementVO(vos[inx]);
				
				//20FT data
				vos1[inx*2  ].setJoStlJbCd   ("301");
				vos1[inx*2  ].setStlSeq      (vos[inx].getStlSeq20      ());
				vos1[inx*2  ].setUsdSltBsaQty(vos[inx].getUsdSltBsaQty20());
				vos1[inx*2  ].setRfScgPrc    (vos[inx].getRfScgPrc20    ());
				vos1[inx*2  ].setStlLoclAmt  (vos[inx].getStlLoclAmt20  ());
				vos1[inx*2  ].setStlAdjFlg   (vos[inx].getStlAdjFlg20   ());
				vos1[inx*2  ].setStlLstFlg   (vos[inx].getStlLstFlg20   ());
				vos1[inx*2  ].setStlDupFlg   (vos[inx].getStlDupFlg20   ());

				//40FT data
				vos1[inx*2+1].setJoStlJbCd   ("302");
				vos1[inx*2+1].setStlSeq      (vos[inx].getStlSeq40      ());
				vos1[inx*2+1].setUsdSltBsaQty(vos[inx].getUsdSltBsaQty40());
				vos1[inx*2+1].setRfScgPrc    (vos[inx].getRfScgPrc40    ());
				vos1[inx*2+1].setStlLoclAmt  (vos[inx].getStlLoclAmt40  ());
				vos1[inx*2+1].setStlAdjFlg   (vos[inx].getStlAdjFlg40   ());
				vos1[inx*2+1].setStlLstFlg   (vos[inx].getStlLstFlg40   ());
				vos1[inx*2+1].setStlDupFlg   (vos[inx].getStlDupFlg40   ());
			}
			event.setSettlementRFVOS(vos);
			event.setProcSettlementVOS(vos1);
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setProcSettlementVO((ProcSettlementVO)getVO(request, ProcSettlementVO .class));
		}
		else if(command.isCommand(FormCommand.REMOVE01)) {
			event.setProcSettlementVO((ProcSettlementVO)getVO(request, ProcSettlementVO .class));
		}
		else if(command.isCommand(FormCommand.SEARCHLIST)) {
			String curRow = request.getParameter("cur_row");
			if (curRow == null || "".equals(curRow)){
				return event;
			}
			ProcSettlementVO[] vos = (ProcSettlementVO[])getVOs(request, ProcSettlementVO .class,"sheet1_");
			//변경된 row를 넘긴다.
			event.setProcSettlementVO((ProcSettlementVO)vos[Integer.parseInt(curRow)]);
		}
		else if(command.isCommand(FormCommand.SEARCHLIST01) || command.isCommand(FormCommand.SEARCHLIST02) || command.isCommand(FormCommand.SEARCHLIST03) || command.isCommand(FormCommand.SEARCHLIST04)) {
			String curRow = request.getParameter("cur_row");
			if (curRow == null || "".equals(curRow)){
				return event;
			}
			ProcSettlementVO[] vos = (ProcSettlementVO[])getVOs(request, ProcSettlementVO .class,"sheet1_");
			//ProcSettlementVO vo1 = (ProcSettlementVO)vos[Integer.parseInt(curRow)];
			//변경된 row를 넘긴다.
			event.setProcSettlementVO((ProcSettlementVO)vos[Integer.parseInt(curRow)]);
			event.setJooCodeParamVO((JooCodeParamVO)getVO(request, JooCodeParamVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH01) || command.isCommand(FormCommand.SEARCH10)) {
			event.setProcSettlementVO((ProcSettlementVO)getVO(request, ProcSettlementVO .class));
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