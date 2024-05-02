/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CGMCODEMGTHTMLAction.java
*@FileTitle : CgmCodeMgt
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.12
*@LastModifier : 김창식
*@LastVersion : 1.0
* 2009.05.12 김창식
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.AgreementINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.ComboINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.CustomerVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.EqOrzChtINVO;
import com.hanjin.apps.alps.ees.cgm.cgmcommon.cgmcodemgt.vo.MdmOrganizationINVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.ees.cgm.cgmcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CgmCommonSC로 실행요청<br>
 * - CgmCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM CHANG SIK
 * @see CgmCommonEvent 참조
 * @since J2EE 1.4
 */

public class CGM_COM_HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * CGMCODEMGTHTMLAction 객체를 생성
	 */
	public CGM_COM_HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CgmCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		CgmComEvent event = new CgmComEvent();
		FormCommand command = FormCommand.fromRequest(request);
		
		if (event.getEventName().equalsIgnoreCase("CgmComEvent")) {
			
			AgreementINVO agreementINVO = (AgreementINVO)getVO(request, AgreementINVO .class);
			
			if(agreementINVO != null){
				if(agreementINVO.getAgmtNo() != null && !agreementINVO.getAgmtNo().equals("")){
					
					String agmtNo = agreementINVO.getAgmtNo();
					String agmtOfcCtyCd = agmtNo.substring(0, 3);
					String agmtSeq = agmtNo.substring(3);
					
					agreementINVO.setAgmtOfcCtyCd(agmtOfcCtyCd);
					agreementINVO.setAgmtSeq(agmtSeq);
				}
			}

			event.setMdmOranizationINVO((MdmOrganizationINVO)getVO(request, MdmOrganizationINVO .class));
			event.setComboINVO((ComboINVO)getVO(request, ComboINVO .class));
			event.setAgreementINVO(agreementINVO);
			
			// chungpa 20090828 RCC,LCC,SCC Validation
			EqOrzChtINVO eqOrzChtINVO = (EqOrzChtINVO)getVO(request, EqOrzChtINVO .class);
			event.setEqOrzChtINVO(eqOrzChtINVO);
			
		} else {
			event.setComboINVO((ComboINVO)getVO(request, ComboINVO .class));
		}
		
		if(command.isCommand(FormCommand.SEARCH22)) {
			event.setCustomerVO((CustomerVO)getVO(request, CustomerVO .class));
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