/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0965HTMLAction.java
*@FileTitle :
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.30
*@LastModifier :
*@LastVersion : 1.0
* 2009.07.30
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgEdiVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgListModiVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.DgValidationCondVO;
import com.clt.apps.opus.esm.bkg.terminaldocumentation.specialmanifest.vo.SpecialContainerSaveVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.terminaldocumentation 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - TerminalDocumentationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kyoung Jong Yun
 * @see EsmBkg0965Event 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_0965HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_FMS_0965HTMLAction 객체를 생성
	 */
	public ESM_BKG_0965HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);

		EsmBkg0965Event event = new EsmBkg0965Event();

		if(command.isCommand(FormCommand.SEARCH01)
				|| command.isCommand(FormCommand.SEARCH02)
				|| command.isCommand(FormCommand.SEARCH03)
				|| command.isCommand(FormCommand.SEARCH04)
				|| command.isCommand(FormCommand.SEARCH05)
				|| command.isCommand(FormCommand.SEARCH06)
//				|| command.isCommand(FormCommand.SEARCH13) // BL No.로 booking쪽 dg데이타를 조회한다.
				|| command.isCommand(FormCommand.SEARCH14) // 추가할 booking쪽 dg데이타를 조회한다.
				|| command.isCommand(FormCommand.MODIFY) // close scg
				) {

			event.setDgListCondVO((DgListCondVO) getVO(request, DgListCondVO.class));

		} else if(command.isCommand(FormCommand.MULTI)) {

			SpecialContainerSaveVO containerVO = new SpecialContainerSaveVO();	// 다건의 vo를 담을 Container VO

			DgListModiVO[] vslInfoList 	= (DgListModiVO[])getVOs(request, DgListModiVO.class, "sheet1_"); // 상단 Master 정보
			DgListModiVO[] dgList 		= (DgListModiVO[])getVOs(request, DgListModiVO.class, "sheet2_"); // 그리드 정보

			containerVO.setVslInfoList(vslInfoList);
			containerVO.setDgMOdiList(dgList);
			containerVO.setDType(request.getParameter("d_type"));
			containerVO.setVvdCd(request.getParameter("vvd_cd"));
			containerVO.setPortCd(request.getParameter("port_cd"));

			containerVO.setDgListLocalYn(request.getParameter("dg_list_local_yn"));

			DgListModiVO vo[] = new DgListModiVO[1];
			vo[0] = containerVO;

			event.setDgListModiVOs(vo);

		} else if(command.isCommand(FormCommand.MULTI01)) {  // Flat File 생성 및 EDI 전송
			//event.setDgEdiVOs((DgEdiVO[])getVOs(request, DgEdiVO.class, "sheet2_")); // 그리드 정보
			event.setDgEdiVOs((DgEdiVO[]) getVOs(request, DgEdiVO.class));
			event.setEdiPreview(request.getParameter("edi_preview"));

		} else if(command.isCommand(FormCommand.SEARCH11)
				|| command.isCommand(FormCommand.SEARCH12)
				|| command.isCommand(FormCommand.SEARCH13)) { // Input Validation
			event.setDgValidationCondVO((DgValidationCondVO) getVO(request, DgValidationCondVO.class));
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
