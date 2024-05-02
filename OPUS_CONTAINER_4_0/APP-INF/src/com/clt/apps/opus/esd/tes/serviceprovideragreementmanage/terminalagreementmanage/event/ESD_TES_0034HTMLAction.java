/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_034HTMLAction.java
*@FileTitle : Terminal Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-08
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-09-08 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.tes.serviceprovideragreementmanage.terminalagreementmanage.vo.TesAgreementManageCommonVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.syscommon.common.table.TesTmlAgmtAplyDyVO;
import com.clt.syscommon.common.table.TesTmlAgmtDgCgoClssVO;
import com.clt.syscommon.common.table.TesTmlAgmtDtlVO;
import com.clt.syscommon.common.table.TesTmlAgmtHdrVO;
import com.clt.syscommon.common.table.TesTmlAgmtThrpCostVO;
import com.clt.syscommon.common.table.TesTmlAgmtTpSzVO;
import com.clt.syscommon.common.table.TesTmlAgmtVrfyMzdVO;
import com.clt.syscommon.common.table.TesTmlSoAccmCostVO;
import com.clt.syscommon.common.table.TesTmlSoAccmMzdVO;
import com.clt.syscommon.common.table.TesTmlSoAccmYdVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tes.serviceprovideragreementmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ServiceProviderAgreementManageSC로 실행요청<br>
 * - ServiceProviderAgreementManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author jongbaemoon
 * @see EsdTes0034Event , EsdTes0034EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TES_0034HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_TES_034HTMLAction 객체를 생성
	 */
	public ESD_TES_0034HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdTes0034Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		EsdTes0034Event	event	= new EsdTes0034Event();
		
		String			selectTab	= JSPUtil.getParameter(request, "select_tab".trim(), "");
		String			prefix		= "";
		
		event.setTesAgreementManageCommonVO	((TesAgreementManageCommonVO)	getVO(request, TesAgreementManageCommonVO .class));

		event.setTesTmlAgmtHdrVO			((TesTmlAgmtHdrVO)				getVO(request, TesTmlAgmtHdrVO .class));
		event.setTesTmlAgmtDtlVO			((TesTmlAgmtDtlVO)				getVO(request, TesTmlAgmtDtlVO .class));
		event.setTesTmlAgmtDgCgoClssVO		((TesTmlAgmtDgCgoClssVO)		getVO(request, TesTmlAgmtDgCgoClssVO .class));
		event.setTesTmlAgmtAplyDyVO			((TesTmlAgmtAplyDyVO)			getVO(request, TesTmlAgmtAplyDyVO .class));
		event.setTesTmlAgmtThrpCostVO		((TesTmlAgmtThrpCostVO)			getVO(request, TesTmlAgmtThrpCostVO .class));
		event.setTesTmlAgmtTpSzVO			((TesTmlAgmtTpSzVO)				getVO(request, TesTmlAgmtTpSzVO .class));
		event.setTesTmlAgmtVrfyMzdVO		((TesTmlAgmtVrfyMzdVO)			getVO(request, TesTmlAgmtVrfyMzdVO .class));
		event.setTesTmlSoAccmMzdVO			((TesTmlSoAccmMzdVO)			getVO(request, TesTmlSoAccmMzdVO .class));
		event.setTesTmlSoAccmCostVO			((TesTmlSoAccmCostVO)			getVO(request, TesTmlSoAccmCostVO .class));
		event.setTesTmlSoAccmYdVO			((TesTmlSoAccmYdVO)				getVO(request, TesTmlSoAccmYdVO .class));
		event.setTesTmlSoHdrVO				((TesTmlSoHdrVO)getVO(request, TesTmlSoHdrVO .class));

		
		if( "1".equals( selectTab ) ) {
			prefix	= "3";
		}
		if( "3".equals( selectTab ) ) {
			prefix	= "5";
		}
		if( "4".equals( selectTab ) ) {
			prefix	= "9";
		}
		event.setTesTmlAgmtDtlVOs			((TesTmlAgmtDtlVO[])			getVOs(request, TesTmlAgmtDtlVO			.class	, prefix) );
		event.setTesTmlAgmtDgCgoClssVOs		((TesTmlAgmtDgCgoClssVO[])		getVOs(request, TesTmlAgmtDgCgoClssVO	.class	, prefix) );
		event.setTesTmlAgmtAplyDyVOs		((TesTmlAgmtAplyDyVO[])			getVOs(request, TesTmlAgmtAplyDyVO		.class	, prefix) );
		event.setTesTmlAgmtVrfyMzdVOs		((TesTmlAgmtVrfyMzdVO[])		getVOs(request, TesTmlAgmtVrfyMzdVO		.class	, prefix) );
		event.setTesAgreementManageCommonVOs((TesAgreementManageCommonVO[])	getVOs(request, TesAgreementManageCommonVO .class	, prefix) );
		
		event.getTesAgreementManageCommonVO().setAmendCd		( JSPUtil.getParameter(request, "amend_flg"				.trim(), "") );
		event.getTesAgreementManageCommonVO().setTmlAgmtOfcNo	( JSPUtil.getParameter(request, "tml_agmt_ofc_cty_cd"	.trim(), "") );

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