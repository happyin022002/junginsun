/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_PRD_0060HTMLAction.java
*@FileTitle : OceanLink 정보관리 (본사관리)
*Open Issues :
*Change history :
*@LastModifyDate : 2006-09-22
*@LastModifier : kimyoungchul
*@LastVersion : 1.0
* 2006-09-22 kimyoungchul
* 1.0 최초 생성
* 2011.09.19 변종건 [CHM-201113069-01] Ocean Route Management상의 Auto & Multi Creation 화면 관련 변경사항
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.prd.common.PrdConstants;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SaveOceanRouteVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteMultiCreationVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchOceanRouteSingleCreationVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.prd.networklinkmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 NetworkLinkManageSC로 실행요청<br>
 * - NetworkLinkManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author kimyoungchul
 * @see EsdPrd0060Event , ESD_PRD_060EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_PRD_0060HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_PRD_0060HTMLAction 객체를 생성
	 */
	public ESD_PRD_0060HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_PRD_060Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		EsdPrd0060Event event = new EsdPrd0060Event();
		event.setAttribute("pgmNo", request.getServletPath().substring(1,13));
		event.setSearchOceanRouteMultiCreationVO((SearchOceanRouteMultiCreationVO)getVO(request, SearchOceanRouteMultiCreationVO .class));
		FormCommand command = FormCommand.fromRequest(request);
		
		if(command.isCommand(FormCommand.MULTI)) {			
			event.setSaveOceanRouteVOs((SaveOceanRouteVO[])getVOs(request, SaveOceanRouteVO .class,""));
				for(int i=0;i<event.getSaveOceanRouteVOs().length;i++){
					     //log.debug("Size ["+ event.getSaveOceanRouteVOs().length + "]");					     
					event.getSaveOceanRouteVOs()[i].setSLane(event.getSaveOceanRouteVOs()[i].getSTs1Lane());
					event.getSaveOceanRouteVOs()[i].setSSvcType(event.getSaveOceanRouteVOs()[i].getSTs1Type());
					event.getSaveOceanRouteVOs()[i].setSTs1Lane(event.getSaveOceanRouteVOs()[i].getSTs2Lane());
					event.getSaveOceanRouteVOs()[i].setSTs1Type(event.getSaveOceanRouteVOs()[i].getSTs2Type());
					event.getSaveOceanRouteVOs()[i].setSTs2Lane(event.getSaveOceanRouteVOs()[i].getSTs3Lane());
					event.getSaveOceanRouteVOs()[i].setSTs2Type(event.getSaveOceanRouteVOs()[i].getSTs3Type());
					event.getSaveOceanRouteVOs()[i].setSTs3Lane(event.getSaveOceanRouteVOs()[i].getSTs4Lane());
					event.getSaveOceanRouteVOs()[i].setSTs3Type(event.getSaveOceanRouteVOs()[i].getSTs4Type());
					if (PrdConstants.PRD_USRRMK_OTHERS.equals(event.getSaveOceanRouteVOs()[i].getSRouteRmk())) {
						event.getSaveOceanRouteVOs()[i].setSRouteRmk(event.getSaveOceanRouteVOs()[i].getSRouteNote());
					}
				}	
		}else if(command.isCommand(FormCommand.SEARCH12)){
			event.setSaveOceanRouteVO((SaveOceanRouteVO) getVO(request, SaveOceanRouteVO.class));
			event.setAttribute("expt_flag",JSPUtil.getParameter(request, "expt_flag".trim(), ""));
//			if (PrdConstants.PRD_USRRMK_OTHERS.equals(event.getSaveOceanRouteVO().getSRouteRmk())) {
//				event.getSaveOceanRouteVO().setSRouteRmk(event.getSaveOceanRouteVO().getSRouteNote());
//			}
//			event.getSaveOceanRouteVO().setSLane(event.getSaveOceanRouteVO().getSTs1Lane());
//			event.getSaveOceanRouteVO().setSTs1Lane(event.getSaveOceanRouteVO().getSTs2Lane());
//			event.getSaveOceanRouteVO().setSTs2Lane(event.getSaveOceanRouteVO().getSTs3Lane());
//			event.getSaveOceanRouteVO().setSTs3Lane(event.getSaveOceanRouteVO().getSTs4Lane());
		}else if(command.isCommand(FormCommand.SEARCH02)){
			event.setSearchOceanRouteSingleCreationVO((SearchOceanRouteSingleCreationVO) getVO(request, SearchOceanRouteSingleCreationVO.class));
			event.getSearchOceanRouteSingleCreationVO().setSPod(event.getSearchOceanRouteSingleCreationVO().getSPod());
			event.getSearchOceanRouteSingleCreationVO().setSPol(event.getSearchOceanRouteSingleCreationVO().getSPol());
			event.getSearchOceanRouteSingleCreationVO().setSTs1Port(event.getSearchOceanRouteSingleCreationVO().getSTs1Port());
			event.getSearchOceanRouteSingleCreationVO().setSTs2Port(event.getSearchOceanRouteSingleCreationVO().getSTs2Port());
			event.getSearchOceanRouteSingleCreationVO().setSTs3Port(event.getSearchOceanRouteSingleCreationVO().getSTs3Port());
			event.getSearchOceanRouteSingleCreationVO().setSTs1Lane(event.getSearchOceanRouteSingleCreationVO().getSTs1Lane());
			event.getSearchOceanRouteSingleCreationVO().setSTs2Lane(event.getSearchOceanRouteSingleCreationVO().getSTs2Lane());
			event.getSearchOceanRouteSingleCreationVO().setSTs3Lane(event.getSearchOceanRouteSingleCreationVO().getSTs3Lane());
			event.getSearchOceanRouteSingleCreationVO().setSTs4Lane(event.getSearchOceanRouteSingleCreationVO().getSTs4Lane());
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
	@Override
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
