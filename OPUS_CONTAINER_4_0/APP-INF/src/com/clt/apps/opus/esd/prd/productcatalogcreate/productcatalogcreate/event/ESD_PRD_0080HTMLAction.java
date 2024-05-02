/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESD_PRD_0080HTMLAction.java
 *@FileTitle : ProductCatalogCreate
 *Open Issues :
 *Change history :
 *@LastModifyDate :
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.prd.common.prdcreate.vo.PrdPcCreateVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdCreateParamVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdQuantityVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSearchParamVO;
import com.clt.apps.opus.esd.prd.productcatalogcreate.productcatalogcreate.vo.PrdSubQuantityVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.prd.productcatalogcreate 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ProductCatalogCreateSC로 실행요청<br>
 * - ProductCatalogCreateSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author sun yong Jung
 * @see ProductCatalogCreateEvent 참조
 * @since J2EE 1.6
 */

public class ESD_PRD_0080HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESD_PRD_0080HTMLAction 객체를 생성
	 */
	public ESD_PRD_0080HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ProductCatalogCreateEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsdPrd0080Event event = new EsdPrd0080Event();
		event.setAttribute("pgmNo", request.getServletPath().substring(1, 13));
		event.setPrdCreateParamVO((PrdCreateParamVO) getVO(request, PrdCreateParamVO.class));
		event.setPrdQuantityVOs((PrdQuantityVO[]) getVOs(request, PrdQuantityVO.class, ""));
		event.setPrdSubQuantityVOs((PrdSubQuantityVO[]) getVOs(request, PrdSubQuantityVO.class, ""));

		double sumBkgQty = 0;
		StringBuilder sumCTpSz = new StringBuilder();
		PrdQuantityVO[] prdQuantityVoList = event.getPrdQuantityVOs();
		if (prdQuantityVoList != null) {
			for (int i = 0; i < prdQuantityVoList.length; i++) {
				sumBkgQty += Double.parseDouble(prdQuantityVoList[i].getCQty());
				String tpSz = prdQuantityVoList[i].getCTpsz().substring(0, 1);
				sumCTpSz.append(sumCTpSz.indexOf(tpSz) > 0 ? "" : tpSz);
			}
		}
		event.getPrdCreateParamVO().setSumBkgQty(Double.toString(sumBkgQty));
		event.getPrdCreateParamVO().setSumCTpSz(sumCTpSz.toString());
		event.setAttribute("request", request);
		if (command.isCommand(FormCommand.SEARCH01) || command.isCommand(FormCommand.SEARCH02)) {
			event.setPrdSearchParamVO((PrdSearchParamVO) getVO(request, PrdSearchParamVO.class));
		} else if (command.isCommand(FormCommand.SEARCHLIST03)) {
			event.setPrdPcCreateVO((PrdPcCreateVO) getVO(request, PrdPcCreateVO.class));
		}

		if (command.isCommand(FormCommand.MODIFY)) {
			event.getPrdCreateParamVO().setMoreCnt(null);
		} else if (!command.isCommand(FormCommand.SEARCHLIST02)) {
			event.getPrdCreateParamVO().setMoreCnt("0");
		}
		return event;
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