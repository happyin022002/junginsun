/*=========================================================
 *Copyright(c) 2017 SM Line
 *@FileName : ESM_BKG_1085HTMLAction.java
 *@FileTitle : DubaiManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2010.02.16
 *@LastModifier : 김민정
 *@LastVersion : 1.0
 * 2009.04.29 김민정
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.dubai.vo.DubaiManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiBlManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiCntrManifestListVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.dubai.vo.DubaiManifestListVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgCstmsCdConvCtntVO;
  
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Kim Min Jeong
 * @see EsmBkg1085Event 참조
 * @since J2EE 1.4
 */
public class ESM_BKG_1085HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
  
	/**
	 * ESM_BKG_1085HTMLAction 객체를 생성
	 */
	public ESM_BKG_1085HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1085Event event = new EsmBkg1085Event();
		if (command.isCommand(FormCommand.SEARCH))
		{
			event.setManifestListCondVO((DubaiManifestListCondVO) getVO(request, DubaiManifestListCondVO.class));
		}
		else if (command.isCommand(FormCommand.MULTI01) || command.isCommand(FormCommand.MULTI02))
		{
			DubaiManifestListCondVO dubaiManifestListCondVO = (DubaiManifestListCondVO) getVO(request,
					DubaiManifestListCondVO.class);
			DubaiBlManifestListVO[] dubaiBlManifestListVOs = (DubaiBlManifestListVO[]) getVOs(request,
					DubaiBlManifestListVO.class, "s1_");
			DubaiCntrManifestListVO[] dubaiCntrManifestListVOs = (DubaiCntrManifestListVO[]) getVOs(request,
					DubaiCntrManifestListVO.class, "s2_");

			List<DubaiBlManifestListVO> listDubaiBlManifestListVO = new ArrayList<DubaiBlManifestListVO>();
			List<DubaiCntrManifestListVO> listDubaiCntrManifestListVO = new ArrayList<DubaiCntrManifestListVO>();
			if (dubaiBlManifestListVOs != null)
			{
				for (int i = 0; i < dubaiBlManifestListVOs.length; i++)
				{
					listDubaiBlManifestListVO.add(dubaiBlManifestListVOs[i]);
				}
			}
			if (dubaiCntrManifestListVOs != null)
			{
				for (int i = 0; i < dubaiCntrManifestListVOs.length; i++)
				{
					listDubaiCntrManifestListVO.add(dubaiCntrManifestListVOs[i]);
				}
			}
			DubaiManifestListVO dubaiManifestListVOs[] = new DubaiManifestListVO[1];
			dubaiManifestListVOs[0] = new DubaiManifestListVO();
			dubaiManifestListVOs[0].setDubaiManifestListCondVO(dubaiManifestListCondVO);
			dubaiManifestListVOs[0].setDubaiBlManifestListVOs(listDubaiBlManifestListVO);
			dubaiManifestListVOs[0].setDubaiCntrManifestListVOs(listDubaiCntrManifestListVO);
			event.setManifestListDetailVOs(dubaiManifestListVOs);
		}
		else if (command.isCommand(FormCommand.COMMAND01)) // EDI File Download
		{
			event.setManifestTransmitVOs((DubaiManifestTransmitVO[]) getVOs(request, DubaiManifestTransmitVO.class,
					"s1_"));
		}
		else if (command.isCommand(FormCommand.SEARCH02))
		{
			// PKG TP Check
			event.setBkgCstmsCdConvCtntVO((BkgCstmsCdConvCtntVO) getVO(request, BkgCstmsCdConvCtntVO.class));
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