/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_2021HTMLAction.java
*@FileTitle : Lease Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.10
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.06.10 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetagreement.vo.MGSAgreementINVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.ees.cgm.chassismgsetagreementinvoice 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ChassisMgsetAgreementInvoiceSC로 실행요청<br>
 * - ChassisMgsetAgreementInvoiceSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM CHANG SIK
 * @see ChassisMgsetAgreementInvoiceEvent 참조
 * @since J2EE 1.6
 */

public class EES_CGM_2021HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CGM_2021HTMLAction 객체를 생성
	 */
	public EES_CGM_2021HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ChassisMgsetAgreementInvoiceEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EesCgm2021Event event = new EesCgm2021Event();
		
		if(command.isCommand(FormCommand.MULTI)) {
			MGSAgreementINVO mgsAgreementINVO = (MGSAgreementINVO)getVO(request, MGSAgreementINVO.class);

			// Parameter
			mgsAgreementINVO.setAgmtDt(mgsAgreementINVO.getAgmtDt().replaceAll("-", ""));
			mgsAgreementINVO.setEffDt(mgsAgreementINVO.getEffDt().replaceAll("-", ""));
			mgsAgreementINVO.setExpDt(mgsAgreementINVO.getExpDt().replaceAll("-", ""));
			mgsAgreementINVO.setAgmtEffDt(mgsAgreementINVO.getAgmtEffDt().replaceAll("-", ""));
			mgsAgreementINVO.setAgmtExpDt(mgsAgreementINVO.getAgmtExpDt().replaceAll("-", ""));
			
			mgsAgreementINVO.setPayTermDys(mgsAgreementINVO.getPayTermDys().replaceAll(",", ""));
			mgsAgreementINVO.setOnhHndlRtAmt(mgsAgreementINVO.getOnhHndlRtAmt().replaceAll(",", ""));
			mgsAgreementINVO.setOffhHndlRtAmt(mgsAgreementINVO.getOffhHndlRtAmt().replaceAll(",", ""));
			mgsAgreementINVO.setMonDpcRtAmt(mgsAgreementINVO.getMonDpcRtAmt().replaceAll(",", ""));
			mgsAgreementINVO.setMaxDpcRtAmt(mgsAgreementINVO.getMaxDpcRtAmt().replaceAll(",", ""));
			mgsAgreementINVO.setInitDpcRtAmt(mgsAgreementINVO.getInitDpcRtAmt().replaceAll(",", ""));
			
			mgsAgreementINVO.setOnhInitValAmtClg(mgsAgreementINVO.getOnhInitValAmtClg().replaceAll(",", ""));
			mgsAgreementINVO.setMgstPotcScgRtAmtClg(mgsAgreementINVO.getMgstPotcScgRtAmtClg().replaceAll(",", ""));
			mgsAgreementINVO.setMgstPrtcScgRtAmtClg(mgsAgreementINVO.getMgstPrtcScgRtAmtClg().replaceAll(",", ""));
			mgsAgreementINVO.setMgstBldpRtAmtClg(mgsAgreementINVO.getMgstBldpRtAmtClg().replaceAll(",", ""));
			mgsAgreementINVO.setMgstLseFxRtAmtClg(mgsAgreementINVO.getMgstLseFxRtAmtClg().replaceAll(",", ""));
			
			mgsAgreementINVO.setOnhInitValAmtUmg(mgsAgreementINVO.getOnhInitValAmtUmg().replaceAll(",", ""));
			mgsAgreementINVO.setMgstPotcScgRtAmtUmg(mgsAgreementINVO.getMgstPotcScgRtAmtUmg().replaceAll(",", ""));
			mgsAgreementINVO.setMgstPrtcScgRtAmtUmg(mgsAgreementINVO.getMgstPrtcScgRtAmtUmg().replaceAll(",", ""));
			mgsAgreementINVO.setMgstBldpRtAmtUmg(mgsAgreementINVO.getMgstBldpRtAmtUmg().replaceAll(",", ""));
			mgsAgreementINVO.setMgstLseFxRtAmtUmg(mgsAgreementINVO.getMgstLseFxRtAmtUmg().replaceAll(",", ""));
			
			event.setMgsAgreementINVO(mgsAgreementINVO);
			
		} else if(command.isCommand(FormCommand.SEARCH) || command.isCommand(FormCommand.REMOVE)) {
			MGSAgreementINVO mgsAgreementINVO = (MGSAgreementINVO)getVO(request, MGSAgreementINVO.class);
			
			mgsAgreementINVO.setEffDt(mgsAgreementINVO.getEffDt().replaceAll("-", ""));
			mgsAgreementINVO.setExpDt(mgsAgreementINVO.getExpDt().replaceAll("-", ""));
			
			String agmtNo = mgsAgreementINVO.getAgmtNo();
			String agmtOfcCtyCd = agmtNo.substring(0, 3);
			String agmtSeq = agmtNo.substring(3);
			
			mgsAgreementINVO.setAgmtOfcCtyCd(agmtOfcCtyCd);
			mgsAgreementINVO.setAgmtSeq(agmtSeq);
			
			event.setMgsAgreementINVO(mgsAgreementINVO);
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