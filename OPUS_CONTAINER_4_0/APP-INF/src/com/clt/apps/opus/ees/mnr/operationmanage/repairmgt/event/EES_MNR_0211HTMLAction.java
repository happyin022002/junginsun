/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0211HTMLAction.java
*@FileTitle : Tire Purchase W/O Inquiry - Popup
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.07
*@LastModifier : 정영훈 
*@LastVersion : 1.0
* 2009.07.07 정영훈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.event;
 
import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.WONoInquiryListGRPVO;
import com.clt.apps.opus.ees.mnr.operationmanage.repairmgt.vo.WONoInquiryListINVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
  
/** 
 * HTTP Parser<br>
 * - com.clt.apps.opus.ees.mnr.generalmanage 화면을 통해 서버로 전송되는 
 *  HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OperationManageSC로 실행요청<br>
 * - OperationManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 정영훈
 * @see GeneralManageEvent 참조
 * @since J2EE 1.4
 */    
   
public class EES_MNR_0211HTMLAction extends HTMLActionSupport {
 
	private static final long serialVersionUID = 1L;
	/**
	 * EES_MNR_0211HTMLAction 객체를 생성
	 */
	public EES_MNR_0211HTMLAction() {}
    
	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		EesMnr0211Event event = new EesMnr0211Event();
		WONoInquiryListGRPVO  wONoInquiryListGRPVO    = new WONoInquiryListGRPVO();
		WONoInquiryListINVO   wONoInquiryListINVO     = new WONoInquiryListINVO();
		//wONoInquiryListINVO = (WONoInquiryListINVO)getVO(request, WONoInquiryListINVO.class);
		
		String combo1 = nvl(request.getParameter("combo1"));
		if(combo1.equals("ALL")){
			combo1 = "%";
		}
		String combo2 = nvl(request.getParameter("combo2"));
		if(combo2.equals("ALL")){
			combo2 = "%";
		}
		wONoInquiryListINVO.setWotype(combo1);
		wONoInquiryListINVO.setEqtype(combo2);
		wONoInquiryListINVO.setFromcal(nvl(request.getParameter("fromcal")));
		wONoInquiryListINVO.setTocal(nvl(request.getParameter("tocal")));
		wONoInquiryListINVO.setCurrofccd(nvl(request.getParameter("currOfcCd")));
		
		wONoInquiryListGRPVO.setWONoInquiryListINVO(wONoInquiryListINVO);
		
        event.setWONoInquiryListGRPVO(wONoInquiryListGRPVO);
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
	
	 /*
     * 변수에 값을 검사하여 null값이면 ""를 반환한다.
     */
    private String nvl(String str){
    	String rtn = "";
    	if(str == null) rtn = "";
    	else rtn = str;
    	
    	return rtn;
    }

}