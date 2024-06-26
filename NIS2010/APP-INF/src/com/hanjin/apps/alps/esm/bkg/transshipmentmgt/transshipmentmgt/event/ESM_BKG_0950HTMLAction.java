/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0950HTMLAction.java
*@FileTitle : Relay Vessel Group Assign by Relay Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.15
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.15 최영희
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.RlyVslGrpAssignInputVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.transshipmentmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TransshipmentMgtSC로 실행요청<br>
 * - TransshipmentMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Choi Yeoung Hee
 * @see TransshipmentMgtEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0950HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0950HTMLAction 객체를 생성
	 */
	public ESM_BKG_0950HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TransshipmentMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0950Event event = new EsmBkg0950Event();
		

		if(command.isCommand(FormCommand.SEARCH)) {
			RlyVslGrpAssignInputVO rlyVslGrpAssignInputVO = new RlyVslGrpAssignInputVO();
			rlyVslGrpAssignInputVO.setRelayportCd(JSPUtil.getParameter(request, "loc_cd"));
			rlyVslGrpAssignInputVO.setRelayportYardCd(JSPUtil.getParameter(request, "loc_yd_cd"));
			rlyVslGrpAssignInputVO.setEtbFrom(JSPUtil.getParameter(request, "dur_from"));
			rlyVslGrpAssignInputVO.setEtbTo(JSPUtil.getParameter(request, "dur_to"));
			rlyVslGrpAssignInputVO.setFormerVvd(JSPUtil.getParameter(request, "formerVVD"));
			rlyVslGrpAssignInputVO.setNextVvd(JSPUtil.getParameter(request, "nextVVD"));
			rlyVslGrpAssignInputVO.setNextPort(JSPUtil.getParameter(request, "nextPort"));
			rlyVslGrpAssignInputVO.setPolCd(JSPUtil.getParameter(request, "pol_cd"));
			rlyVslGrpAssignInputVO.setPodCd(JSPUtil.getParameter(request, "pod_cd"));
			rlyVslGrpAssignInputVO.setBlankFormerVvd(JSPUtil.getParameter(request, "blankFormerVVD"));
			rlyVslGrpAssignInputVO.setBlankPostVvd(JSPUtil.getParameter(request, "blankPostVVD"));
			
			event.setRlyVslGrpAssignInputVO(rlyVslGrpAssignInputVO);
		}else if (command.isCommand(FormCommand.COMMAND01)){
			String[] bkgNo = request.getParameterValues("sheet3_bkg_no"); 
			String[] formerVvd= request.getParameterValues("sheet3_former_vvd");
			String[] nextVvd= request.getParameterValues("sheet3_next_vvd");
			String[] oldVvd= request.getParameterValues("sheet3_old_vvd");

			event.setClosedVvds(JSPUtil.getParameter(request, "closed_vvds"));
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request,  BkgBlNoVO.class));
			event.setAssignFlag(JSPUtil.getParameter(request, "assignFlag"));
			event.setRelay(JSPUtil.getParameter(request, "loc_cd"));
			
			if (event.getAssignFlag().equals("F")){
				event.setNewVVD((formerVvd[0]!=null)?formerVvd[0]:"");
			}else{
				event.setNewVVD((nextVvd[0]!=null)?nextVvd[0]:"");
			}
			event.getBkgBlNoVO().setBkgNo(bkgNo[0]); 
			event.setOrgVVD((oldVvd[0]!=null)?oldVvd[0]:"");
			
		}

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