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
=========================================================*/
package com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.BkgListForPortAssignInputVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.SearchCondForPortAssignVO;
import com.clt.apps.opus.esm.bkg.transshipmentmgt.transshipmentmgt.vo.VvdPortAssinVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.transshipmentmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
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
		String[] porCd = null;
		String[] delCd = null;
		String[] tvvd = null;
		String[] preVvd = null;
		String[] postVvd = null;
		String[] bkgNo = null;
		BkgBlNoVO bkgBlNoVO =null;
		
//		if(command.isCommand(FormCommand.SEARCH)) {
		if((command.isCommand(FormCommand.SEARCH))||(command.isCommand(FormCommand.SEARCH01))) {
//			 event.setVvd(JSPUtil.getParameter(request, "vvd"));
//			 event.setPortCd(JSPUtil.getParameter(request, "port"));
//			 event.setBkgOfcCd(JSPUtil.getParameter(request, "bkgOfcCd"));
//			 event.setPol(JSPUtil.getParameter(request,"pol"));
//			 event.setPod(JSPUtil.getParameter(request,"pod"));
			 
			 event.setSearchCondForPortAssignVO((SearchCondForPortAssignVO)getVO(request, SearchCondForPortAssignVO.class));
			 event.getSearchCondForPortAssignVO().setBkgOfcCd(JSPUtil.getParameter(request, "bkgOfcCd"));
			 
			 if("".equals(event.getSearchCondForPortAssignVO().getBkgNo())){
				 event.getSearchCondForPortAssignVO().setBkgNos(event.getSearchCondForPortAssignVO().getMultBkgNo());
			 }else if("".equals(event.getSearchCondForPortAssignVO().getMultBkgNo())){
				 event.getSearchCondForPortAssignVO().setBkgNos(event.getSearchCondForPortAssignVO().getBkgNo());
			 }else{
				 event.getSearchCondForPortAssignVO().setBkgNos(event.getSearchCondForPortAssignVO().getBkgNo()+"\n"+event.getSearchCondForPortAssignVO().getMultBkgNo());
			 }
			 
			 
		}else if(command.isCommand(FormCommand.COMMAND01)) {
			ibflag= request.getParameterValues("sheet1_ibflag");
			chk= request.getParameterValues("sheet1_chk");
			polCd = request.getParameterValues("sheet1_pol_cd");
			podCd = request.getParameterValues("sheet1_pod_cd");
			tvvd = request.getParameterValues("sheet1_tvvd");
			preVvd = request.getParameterValues("sheet1_pre_vvd");
			postVvd = request.getParameterValues("sheet1_post_vvd");
			porCd = request.getParameterValues("sheet1_por_cd");
			delCd = request.getParameterValues("sheet1_del_cd");
			event.setBkgListForPortAssignInputVO((BkgListForPortAssignInputVO)getVO(request, BkgListForPortAssignInputVO.class));
			for(int i=0;i<ibflag.length;i++){
				if (chk[i].equals("1")){
					 event.getBkgListForPortAssignInputVO().setPolCd(polCd[i]);
					 event.getBkgListForPortAssignInputVO().setPodCd(podCd[i]);
					 event.getBkgListForPortAssignInputVO().setPorCd(porCd[i]);
					 event.getBkgListForPortAssignInputVO().setDelCd(delCd[i]);
					 event.getBkgListForPortAssignInputVO().setTvvd(tvvd[i]);
					 event.getBkgListForPortAssignInputVO().setPreVvd(preVvd[i]);
					 event.getBkgListForPortAssignInputVO().setPostVvd(postVvd[i]);
					 event.getBkgListForPortAssignInputVO().setVvd(JSPUtil.getParameter(request, "vvd"));
					 event.getBkgListForPortAssignInputVO().setPort(JSPUtil.getParameter(request, "port"));
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
			 
			bkgBlNoVO.setBkgNo(event.getVvdPortAssinVOs()[0].getBkgNo());
			event.setBkgBlNoVO(bkgBlNoVO);
			
			event.setMtPkupDt(request.getParameterValues("sheet4_mt_pickup_dt")[0]);
			event.setMPu(request.getParameterValues("sheet4_m_pu")[0]);
			event.setFRt(request.getParameterValues("sheet4_f_ru")[0]);
			event.setPor(request.getParameterValues("sheet4_por_cd")[0]);
			event.setPorNodCd(request.getParameterValues("sheet4_por_nod_cd")[0]);
			event.setDel(request.getParameterValues("sheet4_del_cd")[0]);
			event.setDelNodCd(request.getParameterValues("sheet4_del_nod_cd")[0]);
			event.setPolNodCd(request.getParameterValues("sheet4_pol_nod_cd")[0]);
			event.setPodNodCd(request.getParameterValues("sheet4_pod_nod_cd")[0]);
			event.setOrgTrnsModCd(request.getParameterValues("sheet4_org_trns_mod_cd")[0]);
			event.setDestTrnsModCd(request.getParameterValues("sheet4_dest_trns_mod_cd")[0]);
			event.setPrevTvvd(request.getParameterValues("sheet4_prev_tvvd")[0]);
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