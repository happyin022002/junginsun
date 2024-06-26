/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0456HTMLAction.java
*@FileTitle : ESM_BKG-0456
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

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanManifestListMfrCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.japan.vo.JapanMfrCustModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.MfrCustModificationVO;
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
public class ESM_BKG_0456HTMLAction extends HTMLActionSupport {
	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0456HTMLAction 객체를 생성 
	 */
	public ESM_BKG_0456HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmBkg0456Event event = new EsmBkg0456Event();
    	ManifestListCondVO manifestListCondVO = new ManifestListCondVO();
    	MfrCustModificationVO mfrCustModificationVO = null;
    	String form1_cust_cnt_cd = "";
    	String form1_cust_seq = "";
    	String cust_type = "";    	
    	if(command.isCommand(FormCommand.SEARCH)) {
    		manifestListCondVO = (JapanManifestListMfrCondVO)getVO(request, JapanManifestListMfrCondVO.class);
			event.setJapanManifestListMfrCondVO((JapanManifestListMfrCondVO)manifestListCondVO);
		} else if(command.isCommand(FormCommand.MULTI)) { 
			mfrCustModificationVO = (JapanMfrCustModificationVO)getVO(request, JapanMfrCustModificationVO.class);
			event.setJapanMfrCustModificationVO((JapanMfrCustModificationVO)mfrCustModificationVO);
		} else if(command.isCommand(FormCommand.SEARCH01)) { 
			form1_cust_cnt_cd = request.getParameter("form1_cust_cnt_cd");
			form1_cust_seq = request.getParameter("form1_cust_seq");
			cust_type = request.getParameter("cust_type");
			event.setForm1CustCntCd(form1_cust_cnt_cd);
			event.setForm1CustSeq(form1_cust_seq);
			event.setCustType(cust_type);
		} else if(command.isCommand(FormCommand.SEARCH02)) { 
			form1_cust_cnt_cd = request.getParameter("form1_cust_cnt_cd2");
			form1_cust_seq = request.getParameter("form1_cust_seq2");
			cust_type = request.getParameter("cust_type");
			event.setForm1CustCntCd(form1_cust_cnt_cd);
			event.setForm1CustSeq(form1_cust_seq);
			event.setCustType(cust_type);
		} else if(command.isCommand(FormCommand.SEARCH03)) { 
			form1_cust_cnt_cd = request.getParameter("form1_cust_cnt_cd3");
			form1_cust_seq = request.getParameter("form1_cust_seq3");
			cust_type = request.getParameter("cust_type");
			event.setForm1CustCntCd(form1_cust_cnt_cd);
			event.setForm1CustSeq(form1_cust_seq);		
			event.setCustType(cust_type);
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
