/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_1146HTMLAction.java
 *@FileTitle : ESM_BKG_1146HTMLAction
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2012.05.24
 *@LastModifier : 김보배
 *@LastVersion : 1.0
 * 2012.05.24 김보배
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.eur24.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.eur.vo.EurCrnRcvMsgVO;
import com.hanjin.apps.alps.esm.bkg.terminaldocumentation.specialmanifest.vo.FwdrListVO;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author BOBAE KIM
 * @see EsmBkg1146Event 참조
 * @since J2EE 1.6
 */
public class ESM_BKG_1146HTMLAction extends HTMLActionSupport{
	
	private static final long serialVersionUID = 1L;
	
	public ESM_BKG_1146HTMLAction() {}
	/**
	 * HTML DOM 객체의 Value 를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request 에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface 를 구현한 객체
	 * @exception HTMLActionException
	 */
	@Override
	public Event perform(HttpServletRequest request) throws HTMLActionException{
		FormCommand command = FormCommand.fromRequest(request);
		EsmBkg1146Event event = new EsmBkg1146Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			// 조회
			EurCrnRcvMsgVO eurCrnRcvMsgVO = (EurCrnRcvMsgVO)getVO(request, EurCrnRcvMsgVO.class);
			event.setEurCrnRcvMsgVO(eurCrnRcvMsgVO);
			
		} else if (command.isCommand(FormCommand.MULTI01) || command.isCommand(FormCommand.MULTI02)) {

			// Prev. Doc No append
			EurCrnRcvMsgVO[] eurCrnRcvMsgVOs = (EurCrnRcvMsgVO[])getVOs(request, EurCrnRcvMsgVO.class);
			String polCd = request.getParameter("pol_cd");
			
			if(eurCrnRcvMsgVOs.length > 0){
				for(int i=0; i<eurCrnRcvMsgVOs.length; i++){
					
					if(polCd.startsWith("ES")) {
						eurCrnRcvMsgVOs[i].setCntCd("ES");
						eurCrnRcvMsgVOs[i].setMsgSndOfcCd("VLCSC");
					} else {
						eurCrnRcvMsgVOs[i].setCntCd("PT");
						eurCrnRcvMsgVOs[i].setMsgSndOfcCd("LISBA");
					}
					
					if(command.isCommand(FormCommand.MULTI01)){
						eurCrnRcvMsgVOs[i].setMsgFuncId("F");
					}else if(command.isCommand(FormCommand.MULTI02)){
						eurCrnRcvMsgVOs[i].setMsgFuncId("M");
					}
					
					eurCrnRcvMsgVOs[i].setCreUsrId("M");
					eurCrnRcvMsgVOs[i].setUpdUsrId("M");			
					
				}
			}
			event.setEurCrnRcvMsgVOs(eurCrnRcvMsgVOs);

		}
		request.setAttribute("Event", event);
		return event;
	}
}