/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_9001HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2013-12-06
*@LastModifier : parkeunjung
*@LastVersion : 1.0
* 2013-12-05 parkeunjung
* 1.0 최초 생성
* 2013-12-06 :  
=========================================================*/
package com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.tes.common.vo.TesCommonVO;
import com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage.marineterminalinvoicemanage.vo.SearchCostCodeDetailListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.HTMLActionSupport;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.tes.serviceproviderinvoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ServiceProviderInvoiceManageSC로 실행요청<br>
 * - ServiceProviderInvoiceManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author parkyeonjin
 * @see EsdTes9001Event , ESD_TES_901EventResponse 참조
 * @since J2EE 1.4 
 */
public class ESD_TES_9001HTMLAction  extends HTMLActionSupport {

	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdTes9010Event로 파싱하여 request에 셋팅<br>
	 *
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		EsdTes9001Event event = new EsdTes9001Event();
		
		SearchCostCodeDetailListVO infoVO = (SearchCostCodeDetailListVO)getVO(request, SearchCostCodeDetailListVO.class);
		TesCommonVO cmnVO = (TesCommonVO)getVO(request, TesCommonVO.class);
		
		event.setInfoVO(infoVO);
		event.setCmnVO(cmnVO);
		event.setCost_cd_inv_tp_cd(request.getParameter("cost_cd_inv_tp_cd"));
		
		request.setAttribute("Event", event);	
		return  event; 
	}

}
