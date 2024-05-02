/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0457HTMLAction.java
*@FileTitle : ESM_BKG-0457
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 김승민
*@LastVersion : 1.0
* 2009.05.26 김승민
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanBlKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanCmfModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.BlKeyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestModificationVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author KIM SEUNG MIN
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */
public class ESM_BKG_0457HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0457HTMLAction 객체를 생성 
	 */
	public ESM_BKG_0457HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmBkg0457Event event = new EsmBkg0457Event();
    	ManifestListCondVO manifestListCondVO = new ManifestListCondVO();
    	ManifestModificationVO manifestModificationVO = new ManifestModificationVO();
    	BlKeyVO blKeyVO = new BlKeyVO();
    	String form1CustCntCd = "";
    	String form1CustSeq = "";
    	String custType = "";
    	if(command.isCommand(FormCommand.SEARCH)) {
    		manifestListCondVO = (JapanManifestListCondVO)getVO(request, JapanManifestListCondVO.class);
			event.setJapanManifestListCondVO((JapanManifestListCondVO)manifestListCondVO);
		} else if(command.isCommand(FormCommand.SEARCH01)) { 
			form1CustCntCd = request.getParameter("form1_cust_cnt_cd");
			form1CustSeq = request.getParameter("form1_cust_seq");
			custType = request.getParameter("cust_type");
			event.setForm1CustCntCd(form1CustCntCd);
			event.setForm1CustSeq(form1CustSeq);
			event.setCustType(custType);
		} else if(command.isCommand(FormCommand.SEARCH02)) { 
			form1CustCntCd = request.getParameter("form1_cust_cnt_cd2");
			form1CustSeq = request.getParameter("form1_cust_seq2");
			custType = request.getParameter("cust_type");
			event.setForm1CustCntCd(form1CustCntCd);
			event.setForm1CustSeq(form1CustSeq);
			event.setCustType(custType);
		} else if(command.isCommand(FormCommand.SEARCH03)) { 
			form1CustCntCd = request.getParameter("form1_cust_cnt_cd3");
			form1CustSeq = request.getParameter("form1_cust_seq3");
			custType = request.getParameter("cust_type");
			event.setForm1CustCntCd(form1CustCntCd);
			event.setForm1CustSeq(form1CustSeq);		
			event.setCustType(custType);
		} else if(command.isCommand(FormCommand.MULTI)) { 
			manifestModificationVO = (JapanCmfModificationVO)getVO(request, JapanCmfModificationVO.class);
			event.setJapanCmfModificationVO((JapanCmfModificationVO)manifestModificationVO);
		} else if(command.isCommand(FormCommand.MULTI01)) { 
    		blKeyVO = (JapanBlKeyVO)getVO(request, JapanBlKeyVO.class);
			event.setJapanBlKeyVO((JapanBlKeyVO)blKeyVO);
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
