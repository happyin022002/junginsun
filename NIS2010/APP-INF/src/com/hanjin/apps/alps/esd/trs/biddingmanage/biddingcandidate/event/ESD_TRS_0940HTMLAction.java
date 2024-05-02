/*=========================================================
 *Copyright(c) 2015 CyberLogitec
 *@FileName : ESD_TRS_0940HTMLAction.java
 *@FileTitle :Bidding Candidate
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2015.06.01
 *@LastModifier : SHIN DONG IL
 *@LastVersion : 1.0
 * 2015.06.01 SHIN DONG IL
 * 1.0 최초 생성
 *----------------------------------------------------------
 * History
=========================================================*/
package com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.vo.SpotBidSoVO;
import com.hanjin.apps.alps.esd.trs.biddingmanage.biddingcandidate.vo.SpotBidVndrVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 *  - Parsing 한 정보를 Event로 변환, request에 담아 CodeManageSC로 실행요청<br>
 *  
 * @author SHIN DONG IN 
 * @see EsdTrs0940Event ,ESD_TRS_940EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0940HTMLAction extends HTMLActionSupport {
	/**
	 * HTML Action 객체 생성
	 */
	public ESD_TRS_0940HTMLAction(){		
	}
	
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_0940Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		
		EsdTrs0940Event event = new EsdTrs0940Event();
		
		if(command.isCommand(FormCommand.MULTI)){

			SpotBidVndrVO[] spotBidVndrVOs = (SpotBidVndrVO[])getVOs(request, SpotBidVndrVO.class, "");
			SpotBidSoVO[]   spotBidSoVOs   = (SpotBidSoVO[])getVOs(request, SpotBidSoVO.class, "so_");
			
			event.setSpotBidVndrVOs(spotBidVndrVOs);
			event.setSpotBidSoVOs(spotBidSoVOs);
		}else if(command.isCommand(FormCommand.SEARCH01)){
			SpotBidSoVO[]   spotBidSoVOs   = (SpotBidSoVO[])getVOs(request, SpotBidSoVO.class, "so_");
			event.setSel_transmode(request.getParameter("sel_transmode"));
			event.setSpotBidSoVOs(spotBidSoVOs);
		}else if(command.isCommand(FormCommand.SEARCH02)){
			event.setVndr_seq(request.getParameter("vndr_seq"));
		}
		
		event.setUsr_id(request.getParameter("usr_id"));
		event.setUsr_ofc_cd(request.getParameter("usr_ofc_cd"));		
		request.setAttribute("Event", event);
		return  event;
	}
}