/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_PRD_0086HTMLAction.java
 *@FileTitle : Upload Validation Result
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011-12-06
 *@LastModifier : 변종건
 *@LastVersion : 1.0 
 * 1.0 최초 생성
 * 2011.12.06 변종건 [CHM-201114917-01] Ocean Route Upload Excel 신규 기능 추가건
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.prd.common.PrdConstants;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SaveOceanRouteVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.CommonWebKeys;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.prd.networklinkmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 NetworkLinkManageSC로 실행요청<br>
 * - NetworkLinkManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author kimyoungchul
 * @see EsdPrd0086Event , ESD_PRD_086EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_PRD_0086HTMLAction extends HTMLActionSupport{

	/**
	 * ESD_PRD_0086HTMLAction 객체를 생성
	 */
	public ESD_PRD_0086HTMLAction(){
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_PRD_032Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException{
		log.debug("\n**********************************************************************"
				+ "\n[CALL] HTML Action ----------------------------- ");

		/* Login User's Identification */
		SignOnUserAccount account = (SignOnUserAccount) request.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
//		String userId = account.getUsr_id();
		String[] userAuth = account.getUserAuth();
		log.debug("\n >>> userAuth : " + userAuth);

		EsdPrd0086Event event = new EsdPrd0086Event();
		event.setAttribute("pgmNo", request.getServletPath().substring(1,13));
		FormCommand f_cmd = FormCommand.fromRequest(request);

		if( f_cmd.isCommand(FormCommand.SEARCH) || f_cmd.isCommand(FormCommand.SEARCH01) ){
//			event.setSearchOceanRouteVerifyVOs((SearchOceanRouteVerifyVO[]) getVOs(request, SearchOceanRouteVerifyVO .class,""));
			event.setSaveOceanRouteVO((SaveOceanRouteVO)getVO(request, SaveOceanRouteVO .class));
			event.setSaveOceanRouteVOs((SaveOceanRouteVO[])getVOs(request, SaveOceanRouteVO .class,""));
			
			log.debug("event.setSaveOceanRouteVO=1111=>"+event.getSaveOceanRouteVO().toString());
			
		} else if( f_cmd.isCommand(FormCommand.MULTI) ) {
			event.setSaveOceanRouteVOs((SaveOceanRouteVO[])getVOs(request, SaveOceanRouteVO .class,""));
			for(int i=0;i<event.getSaveOceanRouteVOs().length;i++){
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
		}
//		} else if( f_cmd.isCommand(FormCommand.SEARCH01) ){
//			event.setSaveOceanRouteVO((SaveOceanRouteVO)getVO(request, SaveOceanRouteVO .class));
//		}

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
