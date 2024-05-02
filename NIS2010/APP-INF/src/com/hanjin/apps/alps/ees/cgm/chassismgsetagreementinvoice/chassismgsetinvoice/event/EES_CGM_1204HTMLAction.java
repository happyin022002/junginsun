/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_CGM_1204HTMLAction.java
*@FileTitle : CPS Invoice Import & Audit
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.31
*@LastModifier : Chang Young Kim
*@LastVersion : 1.01
* 2013.03.21 조경완
* 1.0 Creation
*Change history :
* 2015.03.27 Modified by Chang Young Kim
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.cgm.chassismgsetagreementinvoice.chassismgsetinvoice.vo.CHSInvoiceImportAuditINVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.ees.cgm.chassismgsetagreementinvoice 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ChassisMgsetAgreementInvoiceSC로 실행요청<br>
 * - ChassisMgsetAgreementInvoiceSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM CHANG SIK
 * @see ChassisMgsetAgreementInvoiceEvent 참조
 * @since J2EE 1.4   
 */

public class EES_CGM_1204HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_CGM_1030HTMLAction 객체를 생성
	 */
	public EES_CGM_1204HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ChassisMgsetAgreementInvoiceEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EesCgm1204Event event = new EesCgm1204Event();
		
		// Verify
		if(command.isCommand(FormCommand.MULTI01)) {	
			CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO = (CHSInvoiceImportAuditINVO)getVO(request, CHSInvoiceImportAuditINVO.class);
			chsInvoiceImportAuditINVO.setCostYrmon(chsInvoiceImportAuditINVO.getCostYrmon().replaceAll("-", ""));
			
			event.setChsInvoiceImportAuditINVO(chsInvoiceImportAuditINVO);
			event.setChsInvoiceImportAuditINVOS((CHSInvoiceImportAuditINVO[])getVOs(request, CHSInvoiceImportAuditINVO.class, ""));
		
		// Save
		} else if(command.isCommand(FormCommand.MULTI02)) {
			CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO = (CHSInvoiceImportAuditINVO)getVO(request, CHSInvoiceImportAuditINVO.class);
			chsInvoiceImportAuditINVO.setCostYrmon(chsInvoiceImportAuditINVO.getCostYrmon().replaceAll("-", ""));
			
			event.setChsInvoiceImportAuditINVO(chsInvoiceImportAuditINVO);
			event.setChsInvoiceImportAuditINVOS((CHSInvoiceImportAuditINVO[])getVOs(request, CHSInvoiceImportAuditINVO.class, "sheet1_"));
			
		// INVOICE NO 중복 체크
		} else if(command.isCommand(FormCommand.SEARCH)) {
			CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO = (CHSInvoiceImportAuditINVO)getVO(request, CHSInvoiceImportAuditINVO.class);
			chsInvoiceImportAuditINVO.setCostYrmon(chsInvoiceImportAuditINVO.getCostYrmon().replaceAll("-", ""));
			
			event.setChsInvoiceImportAuditINVO(chsInvoiceImportAuditINVO);
			
		}		
		// Verify Insert
		else if(command.isCommand(FormCommand.MULTI03)) {	
			CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO = (CHSInvoiceImportAuditINVO)getVO(request, CHSInvoiceImportAuditINVO.class);
			chsInvoiceImportAuditINVO.setCostYrmon(chsInvoiceImportAuditINVO.getCostYrmon().replaceAll("-", ""));
			
			event.setChsInvoiceImportAuditINVO(chsInvoiceImportAuditINVO);
			event.setChsInvoiceImportAuditINVOS((CHSInvoiceImportAuditINVO[])getVOs(request, CHSInvoiceImportAuditINVO.class, "sheet1_"));
		
		} 
		// Verify Search
		else if(command.isCommand(FormCommand.MULTI04)) {	
			CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO = (CHSInvoiceImportAuditINVO)getVO(request, CHSInvoiceImportAuditINVO.class);
			chsInvoiceImportAuditINVO.setCostYrmon(chsInvoiceImportAuditINVO.getCostYrmon().replaceAll("-", ""));
			
			event.setChsInvoiceImportAuditINVO(chsInvoiceImportAuditINVO);
		}
		// To Save Type of Invoice  except for Usage/Rebill : Only CGM_LSE_CHG_HDR
		else if(command.isCommand(FormCommand.MULTI05)) {	
			CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO = (CHSInvoiceImportAuditINVO)getVO(request, CHSInvoiceImportAuditINVO.class);
			chsInvoiceImportAuditINVO.setCostYrmon(chsInvoiceImportAuditINVO.getCostYrmon().replaceAll("-", ""));
			
			event.setChsInvoiceImportAuditINVO(chsInvoiceImportAuditINVO);
		}
		// BackEndJob Check
		else if(command.isCommand(FormCommand.COMMAND01)) {
			event.setAttribute("KEY", request.getParameter("backendjob_key"));
			
			CHSInvoiceImportAuditINVO chsInvoiceImportAuditINVO = (CHSInvoiceImportAuditINVO)getVO(request, CHSInvoiceImportAuditINVO.class);
			chsInvoiceImportAuditINVO.setCostYrmon(chsInvoiceImportAuditINVO.getCostYrmon().replaceAll("-", ""));
			
			event.setChsInvoiceImportAuditINVO(chsInvoiceImportAuditINVO);
			event.setChsInvoiceImportAuditINVOS((CHSInvoiceImportAuditINVO[])getVOs(request, CHSInvoiceImportAuditINVO.class, "sheet1_"));
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