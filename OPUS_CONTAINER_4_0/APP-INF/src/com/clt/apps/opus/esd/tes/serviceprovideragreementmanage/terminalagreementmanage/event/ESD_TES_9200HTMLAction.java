/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_TES_9200HTMLAction.java
*@FileTitle : Volume Accumulate Method
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.24
*@LastModifier : yOng hO lEE
*@LastVersion : 1.0
* 2009.09.24 yOng hO lEE
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo.TesAgreementManageCommonVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.syscommon.common.table.TesTmlSoAccmCostVO;
import com.clt.syscommon.common.table.TesTmlSoAccmMzdVO;
import com.clt.syscommon.common.table.TesTmlSoAccmYdVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tes.serviceprovideragreementmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ServiceProviderAgreementManageSC로 실행요청<br>
 * - ServiceProviderAgreementManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author yOng hO lEE
 * @see EsdTes9170Event 참조
 * @since J2EE 1.6
 */
public class ESD_TES_9200HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TES_9200HTMLAction 객체를 생성
	 */
	public ESD_TES_9200HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdTes9200Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		EsdTes9200Event	event	= new EsdTes9200Event();
		
		event.setTesAgreementManageCommonVO	((TesAgreementManageCommonVO)	getVO(request, TesAgreementManageCommonVO .class));

		event.setTesTmlSoAccmYdVO			((TesTmlSoAccmYdVO)				getVO(request, TesTmlSoAccmYdVO		.class) );
		event.setTesTmlSoAccmCostVO			((TesTmlSoAccmCostVO)			getVO(request, TesTmlSoAccmCostVO	.class) );
		event.setTesTmlSoAccmMzdVO			((TesTmlSoAccmMzdVO)			getVO(request, TesTmlSoAccmMzdVO	.class) );

		event.setTesTmlSoAccmYdVOs			((TesTmlSoAccmYdVO[])			getVOs(request, TesTmlSoAccmYdVO	.class	, "3") );
		event.setTesTmlSoAccmCostVOs		((TesTmlSoAccmCostVO[])			getVOs(request, TesTmlSoAccmCostVO	.class	, "2") );
		event.setTesTmlSoAccmMzdVOs			((TesTmlSoAccmMzdVO[])			getVOs(request, TesTmlSoAccmMzdVO	.class	, "1") );

		
		event.getTesAgreementManageCommonVO().setVndrSeq(request.getParameter("vndr_seq"));
		event.getTesAgreementManageCommonVO().setAccmSeq("1");
		event.getTesAgreementManageCommonVO().setAccmCostSeq(request.getParameter("accm_cost_seq"));
		event.getTesAgreementManageCommonVO().setAccmDtlSeq(request.getParameter("accm_dtl_seq"));

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