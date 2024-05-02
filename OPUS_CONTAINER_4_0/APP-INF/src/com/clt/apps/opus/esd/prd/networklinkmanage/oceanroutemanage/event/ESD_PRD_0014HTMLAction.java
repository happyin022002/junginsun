/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_PRD_0014HTMLAction.java
 *@FileTitle : OceanLink 정보관리 (본사관리)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-22
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-09-22 kimyoungchul
 * 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.prd.common.PrdConstants;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SaveOceanRouteVO;
import com.clt.apps.opus.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchConditionVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.prd.networklinkmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 NetworkLinkManageSC로 실행요청<br>
 * - NetworkLinkManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author kimyoungchul
 * @see EsdPrd0014Event , ESD_PRD_014EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_PRD_0014HTMLAction extends HTMLActionSupport{
	private static final long serialVersionUID = 1L;

	/**
	 * ESD_PRD_0014HTMLAction 객체를 생성
	 */
	public ESD_PRD_0014HTMLAction(){
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_PRD_014Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException{
		EsdPrd0014Event event = new EsdPrd0014Event();
		event.setAttribute("pgmNo", request.getServletPath().substring(1,13));
		FormCommand command = FormCommand.fromRequest(request);
		event.setSearchConditionVO((SearchConditionVO) getVO(request, SearchConditionVO.class));
		SaveOceanRouteVO[] saveOceanRouteVOs = null;
		if(command.isCommand(FormCommand.MULTI)){
			saveOceanRouteVOs  = (SaveOceanRouteVO[]) getVOs(request, SaveOceanRouteVO.class, "");
			if (saveOceanRouteVOs != null && saveOceanRouteVOs.length > 0) {
				for (int i= 0; i <saveOceanRouteVOs.length; i ++ ) {
					if (PrdConstants.PRD_USRRMK_OTHERS.equals(saveOceanRouteVOs[i].getSRouteRmk())) {											
						saveOceanRouteVOs[i].setSRouteRmk(saveOceanRouteVOs[i].getSRouteNote());

					}
				}
				event.setSaveOceanRouteVOs(saveOceanRouteVOs);
			}
		}
		request.setAttribute("Event", event);
		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface를 구현한 객체
	 */
	@Override
	public void doEnd(HttpServletRequest request, EventResponse eventResponse){
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event){
		request.setAttribute("Event", event);
	}
}
