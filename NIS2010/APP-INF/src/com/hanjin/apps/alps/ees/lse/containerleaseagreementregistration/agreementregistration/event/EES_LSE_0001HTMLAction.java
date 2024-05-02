/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_LSE_0001HTMLAction.java
*@FileTitle : Lease Agreement Creation & Update
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.22
*@LastModifier : 노정용
*@LastVersion : 1.0
* 2009.05.22 노정용
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.LseAgmtRtVO;
import com.hanjin.syscommon.common.table.LseDrpOffDescVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementFileUploadVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementGeneralRateVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementRatesVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementRegistrationVO;
import com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration.agreementregistration.vo.AgreementVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.lse.containerleaseagreementregistration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ContainerLeaseAgreementRegistrationSC로 실행요청<br>
 * - ContainerLeaseAgreementRegistrationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Nho Jung Yong
 * @see ContainerLeaseAgreementRegistrationEvent 참조
 * @since J2EE 1.6 
 */

public class EES_LSE_0001HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_LSE_0001HTMLAction 객체를 생성
	 */
	public EES_LSE_0001HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ContainerLeaseAgreementRegistrationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		EesLse0001Event event = new EesLse0001Event();
		AgreementRegistrationVO agmtRegVO = new AgreementRegistrationVO();
		FormCommand command = FormCommand.fromRequest(request);

    	if ( command.isCommand(FormCommand.SEARCH)
		  || command.isCommand(FormCommand.SEARCH01)
		  || command.isCommand(FormCommand.SEARCH02)
		  || command.isCommand(FormCommand.SEARCH03)
		  || command.isCommand(FormCommand.SEARCH04)
		  || command.isCommand(FormCommand.SEARCH05)
		  || command.isCommand(FormCommand.COMMAND01) ) {

    		agmtRegVO.setAgreementVO((AgreementVO)getVO(request, AgreementVO.class));

    	} else if ( command.isCommand(FormCommand.ADD) 
				 || command.isCommand(FormCommand.MODIFY) ) {

			// Lease Agreement Master Data
			agmtRegVO.setAgreementVO((AgreementVO)getVO(request, AgreementVO.class));
			// Lease Agreement General Data
			agmtRegVO.setAgreementGeneralVOs((AgreementGeneralRateVO[])getVOs(request, AgreementGeneralRateVO.class, "t1sheet1_"));
			// Lease Agreement Per-diem Data
			agmtRegVO.setAgreementPerDiemVOs((AgreementRatesVO[])getVOs(request, AgreementRatesVO.class, "t2sheet1_"));
			// Lease Agreement Lifting Charges Data
			agmtRegVO.setAgreementLiftChargeVOs((AgreementRatesVO[])getVOs(request, AgreementRatesVO.class, "t3sheet1_"));
			// Lease Agreement DOL/DOC Data
			agmtRegVO.setAgreementDolDocVOs((AgreementRatesVO[])getVOs(request, AgreementRatesVO.class, "t4sheet1_"));
			// Lease Agreement Drop Office Desc. Data
			agmtRegVO.setAgreementDropOfficeVOs((LseDrpOffDescVO[])getVOs(request, LseDrpOffDescVO.class, "t4sheet2_"));
			// Lease Agreement Penalty Data
			agmtRegVO.setAgreementPenaltyVOs((AgreementRatesVO[])getVOs(request, AgreementRatesVO.class, "t5sheet1_"));
			// Lease Agreement DPP Data
			agmtRegVO.setAgreementDppVOs((LseAgmtRtVO[])getVOs(request, LseAgmtRtVO.class, "t6sheet1_"));
			// Lease Agreement file Upload Data
			agmtRegVO.setAgreementFileUploadVO((AgreementFileUploadVO[])getVOs(request, AgreementFileUploadVO.class, "t7sheet1_"));

    	}

		event.setAgreementRegistrationVO(agmtRegVO);
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