/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1020_01HTMLAction.java
*@FileTitle : Lease Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.26 김창식
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSAgreementINVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.cgm.chassismgsetagreementinvoice 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ChassisMgsetAgreementInvoiceSC로 실행요청<br>
 * - ChassisMgsetAgreementInvoiceSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM CHANG SIK
 * @see ChassisMgsetAgreementInvoiceEvent 참조
 * @since J2EE 1.6
 */

public class EES_CGM_1020HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CGM_1020_01HTMLAction 객체를 생성
	 */
	public EES_CGM_1020HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ChassisMgsetAgreementInvoiceEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesCgm1020Event event = new EesCgm1020Event();
		
		CHSAgreementINVO chsAgreementINVO1 = new CHSAgreementINVO();
		CHSAgreementINVO chsAgreementINVO2 = new CHSAgreementINVO();
		CHSAgreementINVO chsAgreementINVO3 = new CHSAgreementINVO();
		CHSAgreementINVO chsAgreementINVO4 = new CHSAgreementINVO();
		CHSAgreementINVO chsAgreementINVO5 = new CHSAgreementINVO();
		
		if(command.isCommand(FormCommand.MULTI)) {
			CHSAgreementINVO chsAgreementINVO = (CHSAgreementINVO)getVO(request, CHSAgreementINVO.class);

			// Parameter
			chsAgreementINVO.setAgmtDt(chsAgreementINVO.getAgmtDt().replaceAll("-", ""));
			chsAgreementINVO.setEffDt(chsAgreementINVO.getEffDt().replaceAll("-", ""));
			chsAgreementINVO.setExpDt(chsAgreementINVO.getExpDt().replaceAll("-", ""));
			chsAgreementINVO.setAgmtEffDt(chsAgreementINVO.getAgmtEffDt().replaceAll("-", ""));
			chsAgreementINVO.setAgmtExpDt(chsAgreementINVO.getAgmtExpDt().replaceAll("-", ""));
			
			event.setChsAgreementINVO(chsAgreementINVO);
			event.setChsAgreementINVOS1(chsAgreementINVO1.fromRequestGrid(request,"t1sheet1_"));
			event.setChsAgreementINVOS2(chsAgreementINVO2.fromRequestGrid(request,"t2sheet1_"));
			event.setChsAgreementINVOS3(chsAgreementINVO3.fromRequestGrid(request,"t3sheet1_"));
			event.setChsAgreementINVOS4(chsAgreementINVO4.fromRequestGrid(request,"t3sheet2_"));
			event.setChsAgreementINVOS5(chsAgreementINVO5.fromRequestGrid(request,"t3sheet3_"));
			
		}
		else if(command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.REMOVE)) {
			CHSAgreementINVO chsAgreementINVO = (CHSAgreementINVO)getVO(request, CHSAgreementINVO.class);
			
			chsAgreementINVO.setEffDt(chsAgreementINVO.getEffDt().replaceAll("-", ""));
			chsAgreementINVO.setExpDt(chsAgreementINVO.getExpDt().replaceAll("-", ""));
			
			String agmtNo = chsAgreementINVO.getAgmtNo();
			String agmtOfcCtyCd = agmtNo.substring(0, 3);
			String agmtSeq = agmtNo.substring(3);
			
			chsAgreementINVO.setAgmtOfcCtyCd(agmtOfcCtyCd);
			chsAgreementINVO.setAgmtSeq(agmtSeq);
			
			event.setChsAgreementINVO(chsAgreementINVO);
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