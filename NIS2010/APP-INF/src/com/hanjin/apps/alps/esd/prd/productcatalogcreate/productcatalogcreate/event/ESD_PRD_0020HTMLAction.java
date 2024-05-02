/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESD_PRD_020HTMLAction.java
*@FileTitle : Product Catalog 생성결과 조회 화면
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.12
*@LastModifier : 노승배
*@LastVersion : 1.0
* 2009.10.12 노승배
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.event;

import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCnstRemarkVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.hanjin.apps.alps.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdQuantityVO;
import javax.servlet.http.HttpServletRequest;

//import com.hanjin.apps.enis.esd.prd.common.PrdConstants;
//import com.hanjin.apps.enis.esd.prd.common.prdcommon.basic.PrdRequestEvent;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.CommonWebKeys;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.enis.esd.prd.productcatalogcreate 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ProductCatalogCreateSC로 실행요청<br>
 * - ProductCatalogCreateSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author seung bae noh
 * @see HTMLActionSupport 클래스 참조
 * @since J2EE 1.6
 */
public class ESD_PRD_0020HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_PRD_020HTMLAction 객체를 생성
	 */
	public ESD_PRD_0020HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_PRD_020Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
		EsdPrd0080Event event = new EsdPrd0080Event();
		event.setAttribute("pgmNo", request.getServletPath().substring(1,13));
		event.setEventName("EsdPrd0020Event"); // 0080Event 를 사용하지만 0020Event 로직을 타야 하기 땜시
		
		if(command.isCommand(FormCommand.SEARCHLIST)||command.isCommand(FormCommand.SEARCHLIST01)) {
			PrdCreateParamVO vo = (PrdCreateParamVO)getVO(request, PrdCreateParamVO.class );
			vo.setPcMode("T"); // pc 생성 모듈을 같이 쓰는데 PcMode 값을 "N"으로 하면 Internal 분기 실행
			event.setPrdCreateParamVO(vo);

			PrdQuantityVO[] voQ = (PrdQuantityVO[]) getVOs(request, PrdQuantityVO.class);
			event.setPrdQuantityVOs(voQ);

			event.setPrdQuantityVOs((PrdQuantityVO[])getVOs(request,PrdQuantityVO.class    ));

		} else if(command.isCommand(FormCommand.SEARCH)||command.isCommand(FormCommand.SEARCH01)) {
			event.setAttribute("search_pctl_no", request.getParameter("search_pctl_no"));
			
			PrdCreateParamVO vo = (PrdCreateParamVO)getVO(request, PrdCreateParamVO.class );
			vo.setPcMode("T"); // pc 생성 모듈을 같이 쓰는데 PcMode 값을 "N"으로 하면 Internal 분기 실행
			event.setPrdCreateParamVO(vo);

			PrdQuantityVO[] voQ = (PrdQuantityVO[]) getVOs(request, PrdQuantityVO.class);
			event.setPrdQuantityVOs(voQ);

			event.setPrdQuantityVOs((PrdQuantityVO[])getVOs(request,PrdQuantityVO.class    ));
		} else if(command.isCommand(FormCommand.SEARCH10)){
			PrdCnstRemarkVO vo = (PrdCnstRemarkVO)getVO(request, PrdCnstRemarkVO.class );
			event.setPrdCnstRemarkVO(vo);
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