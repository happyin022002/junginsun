/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_1002HTMLAction.java
*@FileTitle : Basic Tariff Creation - Group (PopUp)
*Open Issues :
*Change history :
*@LastModifyDate : 2009. 6. 19.
*@LastModifier : 김태균
*@LastVersion : 1.0
* 2009. 6. 19. 김태균
* 1.0 Creation
=========================================================*/

package com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.BasicTariffVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.DmtTariffTypeVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffCombinationVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffFreeTimeVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffGroupVO;
import com.clt.apps.opus.ees.dmt.dmtmasterdatamgt.demdettariffmgt.vo.TariffRateVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.dmt.dmtmasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DMTMasterDataMgtSC로 실행요청<br>
 * - DMTMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Tae Kyun
 * @see DMTMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */
public class EES_DMT_1002HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
	/**
	 * EES_DMT_1002HTMLAction 객체를 생성
	 */
	public EES_DMT_1002HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EesDmt1001Event로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
    	EesDmt1002Event event = new EesDmt1002Event();
    	
    	log.debug("::CALL::> EES_DMT_1002HTMLAction - " + command.getCommand());
		if(command.isCommand(FormCommand.SEARCH)) {
			//event.setBasicTarriffVO((BasicTariffVO)getVO(request,BasicTariffVO.class));
			event.setDmtTariffTypeVO((DmtTariffTypeVO)getVO(request, DmtTariffTypeVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) {
			event.setBasicTarriffVO((BasicTariffVO)getVO(request,BasicTariffVO.class));
			
		}
		else if(command.isCommand(FormCommand.SEARCH02)) {
			event.setDmtTariffTypeVO((DmtTariffTypeVO)getVO(request, DmtTariffTypeVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setDmtTariffTypeVO((DmtTariffTypeVO)getVO(request, DmtTariffTypeVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setDmtTariffTypeVO((DmtTariffTypeVO)getVO(request, DmtTariffTypeVO.class));
		}
		else if(command.isCommand(FormCommand.MULTI) || command.isCommand(FormCommand.MULTI01)
				|| command.isCommand(FormCommand.MULTI02)) {
			//Tariff Group
			event.setTariffGroupVO((TariffGroupVO)getVO(request, TariffGroupVO.class));
			//DmtTariffType
			event.setDmtTariffTypeVO((DmtTariffTypeVO)getVO(request, DmtTariffTypeVO.class));
			
			//Tariff Combination		
			TariffCombinationVO tariffCombinationVO = new TariffCombinationVO();
			event.setTariffCombinationVOs(tariffCombinationVO.fromRequestGrid(request, "grid1"));
			              
			//Tariff FreeTime
			TariffFreeTimeVO tariffFreeTimeVO = new TariffFreeTimeVO();
			event.setTariffFreeTimeVOs(tariffFreeTimeVO.fromRequestGrid(request, "grid2"));
			
			//Tariff Rate
			TariffRateVO tariffRateVO = new TariffRateVO();
			event.setTariffRateVOs(tariffRateVO.fromRequestGrid(request, "grid3"));
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
