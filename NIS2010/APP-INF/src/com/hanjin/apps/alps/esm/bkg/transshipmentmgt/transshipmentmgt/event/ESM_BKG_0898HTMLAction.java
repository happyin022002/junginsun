/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0898HTMLAction.java
*@FileTitle : Vessel/Port Group Assign by VVD, Port
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.22
*@LastModifier : 최영희
*@LastVersion : 1.0
* 2009.09.22 최영희
* 1.0 Creation
* -------------------------------------------------------
* History
* 2012.01.09 금병주 [CHM-201115389-01] bkg 화면에 Port skip일 경우 표기 요청
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgListForPortAssignInputVO;
import com.hanjin.apps.alps.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdPortAssinVO;
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

public class ESM_BKG_0898HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0898HTMLAction 객체를 생성
	 */
	public ESM_BKG_0898HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TransshipmentMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0898Event event = new EsmBkg0898Event();
		
		String[] ibflag=null;
		String[] chk = null;
		String[] polCd = null;
		String[] podCd = null;
		String[] tvvd = null;
		String[] preVvd = null;
		String[] postVvd = null;
		String[] bkgNo = null;
		String[] polNodCd = null;
		BkgBlNoVO bkgBlNoVO =null;
		
		if(command.isCommand(FormCommand.SEARCH)) {
			 event.setVvd(JSPUtil.getParameter(request, "vvd"));
			 event.setPortCd(JSPUtil.getParameter(request, "port"));
			 event.setYardCd(JSPUtil.getParameter(request, "yard"));
			 event.setBkgOfcCd(JSPUtil.getParameter(request, "bkgOfcCd"));
			 event.setPol(JSPUtil.getParameter(request,"pol"));
			 event.setPod(JSPUtil.getParameter(request,"pod"));
		}else if(command.isCommand(FormCommand.COMMAND01)) {
			
//			event.setBkgListForPortAssignInputVO((BkgListForPortAssignInputVO)getVO(request, BkgListForPortAssignInputVO.class, "sheet1_"));
			
			ibflag= request.getParameterValues("sheet1_ibflag");
			chk= request.getParameterValues("sheet1_chk");
			polCd = request.getParameterValues("sheet1_pol_cd");
			podCd = request.getParameterValues("sheet1_pod_cd");
			tvvd = request.getParameterValues("sheet1_tvvd");
			preVvd = request.getParameterValues("sheet1_pre_vvd");
			postVvd = request.getParameterValues("sheet1_post_vvd");
			polNodCd = request.getParameterValues("sheet1_pol_nod_cd");
			event.setBkgListForPortAssignInputVO((BkgListForPortAssignInputVO)getVO(request, BkgListForPortAssignInputVO.class));
			for(int i=0;i<ibflag.length;i++){
				if (chk[i].equals("1")){
					 event.getBkgListForPortAssignInputVO().setPolCd(polCd[i]);
					 event.getBkgListForPortAssignInputVO().setPodCd(podCd[i]);
					 event.getBkgListForPortAssignInputVO().setTvvd(tvvd[i]);
					 event.getBkgListForPortAssignInputVO().setPreVvd(preVvd[i]);
					 event.getBkgListForPortAssignInputVO().setPostVvd(postVvd[i]);
					 event.getBkgListForPortAssignInputVO().setPolNodCd(polNodCd[i]);
					 event.getBkgListForPortAssignInputVO().setVvd(JSPUtil.getParameter(request, "vvd"));
					 event.getBkgListForPortAssignInputVO().setPort(JSPUtil.getParameter(request, "port"));
					 event.getBkgListForPortAssignInputVO().setYard(JSPUtil.getParameter(request, "yard"));
					 event.getBkgListForPortAssignInputVO().setBkgOfcCd(JSPUtil.getParameter(request, "bkgOfcCd"));
					 break;
				}
			}
		}else if(command.isCommand(FormCommand.COMMAND02)) {
			bkgBlNoVO = new BkgBlNoVO();
			ibflag= request.getParameterValues("sheet2_ibflag");
			chk= request.getParameterValues("sheet2_chk");
			bkgNo = request.getParameterValues("sheet2_bkg_no");
			for(int i=0;i<ibflag.length;i++){
				if (chk[i].equals("1")){
					bkgBlNoVO.setBkgNo(bkgNo[i]);
					event.setBkgBlNoVO(bkgBlNoVO);
					break;
				}
			}
			
		}else if(command.isCommand(FormCommand.COMMAND03)) {
			bkgBlNoVO = new BkgBlNoVO(); 
			event.setVvdPortAssinVOs((VvdPortAssinVO[])getVOs(request,VvdPortAssinVO.class,"sheet4_"));
			event.setPortSkpFlg(request.getParameter("port_skp_flg"));
			event.setClosedVvds(JSPUtil.getParameter(request, "closed_vvds"));
			bkgBlNoVO.setBkgNo(event.getVvdPortAssinVOs()[0].getBkgNo());
			event.setBkgBlNoVO(bkgBlNoVO);
		}else if(command.isCommand(FormCommand.COMMAND04)) {
			event.setBkgBlNoVOs((BkgBlNoVO[]) getVOs(request, BkgBlNoVO.class, ""));
			event.setVslCngRsn(JSPUtil.getParameter(request, "vsl_cng_rsn"));			
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