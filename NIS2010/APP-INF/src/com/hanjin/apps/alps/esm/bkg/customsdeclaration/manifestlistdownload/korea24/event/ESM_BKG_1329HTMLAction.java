/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1329HTMLAction.java
*@FileTitle : ESM_BKG_1329HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : 손윤석
*@LastVersion : 1.0
* 2009.05.25 손윤석
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24BkgCntrQtyInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManifestCrsChkInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24ManifestInfoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24MrnNoVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.korea24.vo.Kor24MsnNoCondVO;
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
 * @author Kim Min Jeong
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */
public class ESM_BKG_1329HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**************************************************************************
	 * ESM_BKG_1329HTMLAction 객체를 생성
	 **************************************************************************/
	public ESM_BKG_1329HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
    	EsmBkg1329Event event = new EsmBkg1329Event();
    	Kor24ManifestCrsChkInfoVO[] kor24ManifestCrsChkInfoVOs = null;

    	if(command.isCommand(FormCommand.SEARCH)) {
    		//MrnNo를 찾는다.
    		Kor24MrnNoVO mrnNoVO = (Kor24MrnNoVO)getVO(request, Kor24MrnNoVO.class);
    		event.setKor24MrnNoVO(mrnNoVO);

    	} else if(command.isCommand(FormCommand.SEARCH04)){
    		//MrnNo를 찾는다.
    		Kor24MrnNoVO mrnNoVO = (Kor24MrnNoVO)getVO(request, Kor24MrnNoVO.class);
    		event.setKor24MrnNoVO(mrnNoVO);

    	} else if(command.isCommand(FormCommand.TRANS)) {
    		//Transmit Button Click
    		Kor24MrnNoVO mrnNoVO = (Kor24MrnNoVO)getVO(request, Kor24MrnNoVO.class);
    		Kor24ManifestInfoVO[] list = (Kor24ManifestInfoVO[]) getVOs(request, Kor24ManifestInfoVO.class);
    		Kor24BkgCntrQtyInfoVO[] cont = (Kor24BkgCntrQtyInfoVO[]) getVOs(request, Kor24BkgCntrQtyInfoVO.class);
    		event.setKor24MrnNoVO(mrnNoVO);
    		event.setKor24ManifestInfoVOs(list);
    		event.setKor24BkgCntrQtyInfoVOs(cont);

    	} else if(command.isCommand(FormCommand.MULTI) || command.isCommand(FormCommand.REMOVE)) {
    		Kor24MrnNoVO             mrnNoVO = (Kor24MrnNoVO)getVO(request, Kor24MrnNoVO.class);
    		Kor24ManifestInfoVO[]   infoList = (Kor24ManifestInfoVO[]) getVOs(request, Kor24ManifestInfoVO.class, "sheet1_");
    		Kor24BkgCntrQtyInfoVO[] contList = (Kor24BkgCntrQtyInfoVO[]) getVOs(request, Kor24BkgCntrQtyInfoVO.class, "sheet2_");
    		event.setKor24MrnNoVO(mrnNoVO);
    		event.setKor24ManifestInfoVOs(infoList);
    		event.setKor24BkgCntrQtyInfoVOs(contList);

    	} else if (command.isCommand(FormCommand.SEARCH03)) {
			// BackEndJob 으로 돌린 후 결과코드 조회
			event.setKey(request.getParameter("key"));

    	} else if (command.isCommand(FormCommand.COMMAND01)) {
			// MSN Save 처리
			Kor24MsnNoCondVO[] kor24MsnNoCondVOs = (Kor24MsnNoCondVO[])getVOs(request, Kor24MsnNoCondVO.class, "sheet1_");
			if (kor24MsnNoCondVOs!=null) {
				for(int i=0; i < kor24MsnNoCondVOs.length; i++) {
					kor24MsnNoCondVOs[i].setInVvd(request.getParameter("in_vvd"));
					kor24MsnNoCondVOs[i].setInPod(request.getParameter("in_pod"));
					kor24MsnNoCondVOs[i].setMsnStartNum(request.getParameter("msn_start_num"));
				}
			}
			event.setKor24MsnNoCondVOs(kor24MsnNoCondVOs);

    	} else if (command.isCommand(FormCommand.COMMAND02)) {

			kor24ManifestCrsChkInfoVOs =(Kor24ManifestCrsChkInfoVO[])getVOs (request, Kor24ManifestCrsChkInfoVO.class, "sheet4_");
			event.setKor24ManifestCrsChkInfoVOs((Kor24ManifestCrsChkInfoVO[])kor24ManifestCrsChkInfoVOs);

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