	/*=========================================================
	*Copyright(c) 2006 CyberLogitec
	*@FileName : ESD_TES_0001HTMLAction.java
	*@FileTitle : Marine Terminal Invoice FIO Pop-Up 화면
	*Open Issues :
	*Change history :
	*@LastModifyDate : 2011-07-20
	*@LastModifier : parkjungil
	*@LastVersion : 1.0
	* 2007-02-20 kimjinjoo
	* 2011.08.10 박정일 [CHM-201112119-1] [TES] MR Invoice 입력시 FIO 조건 CNTR verification 결과 보완 요청 
	=========================================================*/
	package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

	import javax.servlet.http.HttpServletRequest;

	import com.hanjin.apps.alps.esd.tes.common.vo.TesCommonVO;
	import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.MarineTerminalInvoiceCommonVO;
	import com.hanjin.framework.core.controller.html.HTMLActionException;
	import com.hanjin.framework.core.layer.event.Event;
	import com.hanjin.framework.core.layer.event.EventResponse;
	import com.hanjin.framework.support.controller.HTMLActionSupport;
	import com.hanjin.syscommon.common.table.TesN3rdPtyIfVO;
	import com.hanjin.syscommon.common.table.TesTmlSoAccmVO;
	import com.hanjin.syscommon.common.table.TesTmlSoCntrListVO;
	import com.hanjin.syscommon.common.table.TesTmlSoDtlVO;
	import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;
	import com.hanjin.syscommon.common.table.TesTmlSoRvisListVO;
	import com.hanjin.syscommon.common.table.TesTmlSoVvdListVO;


	/**
	 * HTTP Parser<br>
	 * - com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * - Parsing 한 정보를 Event로 변환, request에 담아 ServiceProviderInvoiceManageSC로 실행요청<br>
	 * - ServiceProviderInvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
	 *
	 * @author parkyeonjin
	 * @see EsdTes0001Event , EventResponse 참조
	 * @since J2EE 1.4
	 */
	public class ESD_TES_9400HTMLAction extends HTMLActionSupport {

		/**
		 * ESD_TES_0001HTMLAction 객체를 생성
		 */
		public ESD_TES_9400HTMLAction() {
			if(log.isDebugEnabled())log.debug("==========ESD_TES_9400HTMLAction============");
		}

		/**
		 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
		 * HttpRequst의 정보를 ESD_TES_0001Event로 파싱하여 request에 셋팅<br>
		 *
		 * @param request HttpServletRequest HttpRequest
		 * @return Event Event interface를 구현한 객체
		 * @exception HTMLActionException
		 */
		public Event perform(HttpServletRequest request) throws HTMLActionException {
			if(log.isDebugEnabled())log.debug("==========start ESD_TES_9400HTMLAction    perform ============");
			
			EsdTes0001Event event = new EsdTes0001Event(); // table value object	
			
			
			event.setTesTmlSoHdrVO((TesTmlSoHdrVO)getVO(request, TesTmlSoHdrVO .class));
			event.setTesTmlSoVvdListVO((TesTmlSoVvdListVO)getVO(request, TesTmlSoVvdListVO .class));
			event.setTesCommonVo((TesCommonVO)getVO(request, TesCommonVO .class));
		
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