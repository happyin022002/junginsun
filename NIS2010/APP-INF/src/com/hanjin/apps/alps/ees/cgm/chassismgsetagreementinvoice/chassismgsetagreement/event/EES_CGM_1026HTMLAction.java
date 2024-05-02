/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1026HTMLAction.java
*@FileTitle : Lease Term Change
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.22
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.06.22 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.CHSTermStatusINVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.ees.cgm.chassismgsetagreementinvoice 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ChassisMgsetAgreementInvoiceSC로 실행요청<br>
 * - ChassisMgsetAgreementInvoiceSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM CHANG SIK
 * @see ChassisMgsetAgreementInvoiceEvent 참조
 * @since J2EE 1.6
 */

public class EES_CGM_1026HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CGM_1026HTMLAction 객체를 생성
	 */
	public EES_CGM_1026HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ChassisMgsetAgreementInvoiceEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EesCgm1026Event event = new EesCgm1026Event();
		CHSTermStatusINVO chsTermStatusINVO = null;

		switch(command.getCommand()) {
			case FormCommand.SEARCH :	//조회
				chsTermStatusINVO = (CHSTermStatusINVO)getVO(request, CHSTermStatusINVO.class);

				String agmtNo = chsTermStatusINVO.getAgmtNo();
				String agmtOfcCtyCd = agmtNo.substring(0, 3);
				String agmtSeq = agmtNo.substring(3);
				chsTermStatusINVO.setAgmtOfcCtyCd(agmtOfcCtyCd);
				chsTermStatusINVO.setAgmtSeq(agmtSeq);

				event.setChsTermStatusINVO(chsTermStatusINVO);
				break;
			case FormCommand.SEARCH01 :	//조회
				event.setChsTermStatusINVO((CHSTermStatusINVO)getVO(request, CHSTermStatusINVO.class));
				break;
			case FormCommand.MULTI :	//저장
				// Form Object 를 VO에 저장
				chsTermStatusINVO = (CHSTermStatusINVO)getVO(request, CHSTermStatusINVO.class);
				chsTermStatusINVO.setStsEvntDt(chsTermStatusINVO.getStsEvntDt().replaceAll("-", ""));
				event.setChsTermStatusINVO(chsTermStatusINVO);

				// Sheet Object 정보를 VO에 저장
				CHSTermStatusINVO chsTermStatusINVO1 = new CHSTermStatusINVO();
				event.setChsTermStatusINVOS(chsTermStatusINVO1.fromRequestGrid(request,"sheet1"));
				break;
			case FormCommand.COMMAND01 :	//BackEndJob - 작업요청
			case FormCommand.COMMAND02 :	//BackEndJob - 상태조회
			case FormCommand.COMMAND03 :	//BackEndJob - 결과로드
				event.setAttribute("KEY", request.getParameter("backendjob_key"));
				// Form Object 를 VO에 저장
				chsTermStatusINVO = (CHSTermStatusINVO)getVO(request, CHSTermStatusINVO.class);
				chsTermStatusINVO.setStsEvntDt(chsTermStatusINVO.getStsEvntDt().replaceAll("-", ""));
				event.setChsTermStatusINVO(chsTermStatusINVO);

				// Sheet Object 정보를 VO에 저장
				CHSTermStatusINVO chsTermStatusINVO2 = new CHSTermStatusINVO();
				event.setChsTermStatusINVOS(chsTermStatusINVO2.fromRequestGrid(request,"sheet1"));
				break;
			default :	//do nothing
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