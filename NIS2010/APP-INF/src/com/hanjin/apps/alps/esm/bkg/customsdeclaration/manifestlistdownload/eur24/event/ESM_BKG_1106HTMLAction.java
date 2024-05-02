/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1106HTMLAction.java
*@FileTitle : ESM_BKG-1106
*Open Issues :
*Change history :
*@LastModifyDate : 2010.09.03
*@LastModifier : 김경섭
*@LastVersion : 1.0
* 2010.09.03 김경섭
* 1.0 Creation
* -------------------------------------------------------
* History
* 2013.06.25 김보배 [CHM-201324814] [ENS FI] Finland 세관 ENS 개발 요청 (IE344, IE347)
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24ManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.EurManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.vo.Eu24CountryListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur24.vo.Eu24ManifestTransmitVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
 
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM GYOUNG SUB
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_1106HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_1106HTMLAction 객체를 생성 
	 */
	public ESM_BKG_1106HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1106Event event = new EsmBkg1106Event();
//		ManifestListCondVO manifestListCondVO = new EurManifestListCondVO(); 
		Eu24CountryListVO eu24CountryListVO  = new Eu24CountryListVO();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			
//			manifestListCondVO = (EurManifestListCondVO)getVO(request, EurManifestListCondVO.class);
//			event.setManifestListCondVO(manifestListCondVO);
			EurManifestListCondVO condVO = (EurManifestListCondVO)getVO(request, EurManifestListCondVO.class);
			
			if("ENS".equals(condVO.getPType())){
				event.setManifestListCondVO(condVO);
			}else{
				condVO.setPVvdCd(condVO.getPFiVvdCd());
				condVO.setPPolCd(condVO.getPFiPolCd());
				condVO.setPPolYardCd(condVO.getPFiPolYardCd());
				condVO.setPPodCd(condVO.getPFiPodCd());
				condVO.setPPodYardCd(condVO.getPFiPodCd()+condVO.getPFiPodYardCd());
				condVO.setPSearchPofeYardCd(condVO.getPFiPodCd());
				condVO.setPBlNo(condVO.getPFiBlNo());
				condVO.setPLt(condVO.getPFiLt());
				condVO.setPAckStatus(condVO.getPFiAckStatus());
				
				event.setManifestListCondVO(condVO);
			}
			
		// vvd로 pofe찾거나, BL로 해당 VVD와 POFE개수를 리턴한다. 
		} else if(command.isCommand(FormCommand.SEARCH01) || command.isCommand(FormCommand.SEARCH04) 
				|| command.isCommand(FormCommand.SEARCH06) || command.isCommand(FormCommand.SEARCH07)) { 
			
//			manifestListCondVO = (EurManifestListCondVO)getVO(request, EurManifestListCondVO.class);
//			event.setManifestListCondVO(manifestListCondVO);

			EurManifestListCondVO condVO = (EurManifestListCondVO)getVO(request, EurManifestListCondVO.class);
			if("ENS".equals(condVO.getPType())){
				event.setManifestListCondVO(condVO);
			}else{
				condVO.setPVvdCd(condVO.getPFiVvdCd());
				condVO.setPBlNo(condVO.getPFiBlNo());

				event.setManifestListCondVO(condVO);
			}
				
		} else if(command.isCommand(FormCommand.SEARCH05)) {
			//Load시 EU Port조회
			eu24CountryListVO = (Eu24CountryListVO)getVO(request, Eu24CountryListVO.class);
			event.setEu24CountryListVO(eu24CountryListVO);
		} else if(command.isCommand(FormCommand.MULTI)) {
			event.setEu24ManifestListVOs((Eu24ManifestListVO[])getVOs(request, Eu24ManifestListVO.class,""));
		}  else if(command.isCommand(FormCommand.MULTI01 ) || command.isCommand(FormCommand.MULTI03 ) ) { 
			event.setEu24ManifestTransmitVOs((Eu24ManifestTransmitVO[])getVOs(request, Eu24ManifestTransmitVO.class,""));
		}
		else if (command.isCommand(FormCommand.SEARCH03))
		{
			// BackEndJob 으로 돌린 후 결과코드 조회
			event.setKey(request.getParameter("key"));		
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
