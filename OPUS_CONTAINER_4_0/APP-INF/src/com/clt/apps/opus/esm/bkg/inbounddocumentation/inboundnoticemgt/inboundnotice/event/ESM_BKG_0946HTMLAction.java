/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0956HTMLAction.java
*@FileTitle : Integrated Customer Data Management
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import java.util.StringTokenizer;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcGrpSendListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcGrpSendVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InboundBLMgtSC로 실행요청<br>
 * - InboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author
 * @see EsmBkg0956Event 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0946HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0956HTMLAction 객체를 생성
	 */
	public ESM_BKG_0946HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InboundNoticeMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0946Event event = new EsmBkg0946Event();
		
		
		//fax 전송
		if(command.isCommand(FormCommand.MULTI01)) {
			
			
			ArrNtcGrpSendListVO[] listVOS = (ArrNtcGrpSendListVO[]) getVOs(request, ArrNtcGrpSendListVO.class,"sheet1_");
			log.debug("-------------- listVOS.length() "+listVOS[0].getColumnValues());
			
			//event.setListVOS(listVOS);
			event.setListVOS(listVOS);
			
			//,로 연결된 fax_no 번호
			String fax_no = request.getParameter("fax_no");
			String bkgNo = request.getParameter("bkg_no");//대표 bkg_no
			String divCd = request.getParameter("div_cd");//Combine or Separate
			String diffRmk = JSPUtil.getNull(request.getParameter("diff_rmk"));
			
			//값 설정
			Vector<String> v = this.commaStr2Vec(fax_no);
			event.setFaxNo(v);
			
			//대표 bkg_no , Combine/Separate 구분자 설정
			ArrNtcGrpSendVO grpSendVO = new ArrNtcGrpSendVO();
			grpSendVO.setBkgNo(bkgNo);
			grpSendVO.setDivCd(divCd);
			grpSendVO.setDiffRmk(diffRmk);
			
			event.setGrpSendVO(grpSendVO);
			
		//email 전송
		}else if(command.isCommand(FormCommand.MULTI02)) {
			ArrNtcGrpSendListVO[] listVOS = (ArrNtcGrpSendListVO[]) getVOs(request, ArrNtcGrpSendListVO.class,"sheet1_");
			
			event.setListVOS(listVOS);
			
			//,로 연결된 email
			String email = request.getParameter("email");
			String bkgNo = request.getParameter("bkg_no");//대표 bkg_no
			String divCd = request.getParameter("div_cd");//Combine or Separate
			String diffRmk = JSPUtil.getNull(request.getParameter("diff_rmk"));
			
			Vector<String> v = this.commaStr2Vec(email);
			event.setEmail(v);
			
			//대표 bkg_no , Combine/Separate 구분자 설정
			ArrNtcGrpSendVO grpSendVO = new ArrNtcGrpSendVO();
			grpSendVO.setBkgNo(bkgNo);
			grpSendVO.setDivCd(divCd);
			grpSendVO.setDiffRmk(diffRmk);
			
			event.setGrpSendVO(grpSendVO);
			
		// 조회
		}else if(command.isCommand(FormCommand.SEARCH01)) {

			ArrNtcGrpSendListVO vo = (ArrNtcGrpSendListVO) getVO(request, ArrNtcGrpSendListVO.class);
			log.debug("--------------" + vo.getColumnValues());
			event.setSearchVO(vo);
		}else if(command.isCommand(FormCommand.MULTI03)){
			ArrNtcGrpSendListVO[] vos = (ArrNtcGrpSendListVO[]) getVOs(request, ArrNtcGrpSendListVO.class,"sheet1_");
			
			
			log.debug("------------- vos " + vos);
			event.setListVOS(vos);
		}else if(command.isCommand(FormCommand.MULTI11)){
			ArrNtcGrpSendListVO[] vos = (ArrNtcGrpSendListVO[]) getVOs(request, ArrNtcGrpSendListVO.class,"sheet1_");
			
			
			log.debug("------------- vos " + vos);
			event.setListVOS(vos);
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
	/**
	 * Comma 문자열을 Vector 로 변환
	 * @param str
	 * @return
	 */
	private Vector<String> commaStr2Vec(String str){
		Vector<String> v = new Vector<String>();
		StringTokenizer st = new StringTokenizer(str,",");
		while(st.hasMoreElements()){
			v.add((String) st.nextElement());
		}
		return v;
	}

}