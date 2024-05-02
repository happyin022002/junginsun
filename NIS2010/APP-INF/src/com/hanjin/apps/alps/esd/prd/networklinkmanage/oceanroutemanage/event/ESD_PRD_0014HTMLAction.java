/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_PRD_0014HTMLAction.java
 *@FileTitle : OceanLink 정보관리 (본사관리)
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2006-09-22
 *@LastModifier : kimyoungchul
 *@LastVersion : 1.0
 * 2006-09-22 kimyoungchul
 * 1.0 최초 생성
 * 2011.09.19 변종건 [CHM-201113069-01] Ocean Route Management상의 Auto & Multi Creation 화면 관련 변경사항
=========================================================*/
package com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SaveOceanRouteVO;
import com.hanjin.apps.alps.esd.prd.networklinkmanage.oceanroutemanage.vo.SearchConditionVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.prd.networklinkmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 NetworkLinkManageSC로 실행요청<br>
 * - NetworkLinkManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author kimyoungchul
 * @see EsdPrd0014Event , ESD_PRD_014EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_PRD_0014HTMLAction extends HTMLActionSupport{

	/**
	 * ESD_PRD_0014HTMLAction 객체를 생성
	 */
	public ESD_PRD_0014HTMLAction(){
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_PRD_014Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException{		
//		SignOnUserAccount account = (SignOnUserAccount) request.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
//		String userId = account.getUsr_id();
//		String[] userAuth = account.getUserAuth();
		EsdPrd0014Event event = new EsdPrd0014Event();
		event.setAttribute("pgmNo", request.getServletPath().substring(1,13));
		FormCommand command = FormCommand.fromRequest(request);
		event.setSearchConditionVO((SearchConditionVO) getVO(request, SearchConditionVO.class));
		SaveOceanRouteVO[] saveOceanRouteVOs = null;
		if(command.isCommand(FormCommand.MULTI)){
//			event.setSaveOceanRouteVOs((SaveOceanRouteVO[]) getVOs(request, SaveOceanRouteVO.class, ""));
			saveOceanRouteVOs  = (SaveOceanRouteVO[]) getVOs(request, SaveOceanRouteVO.class, "");
// jsy 201301 tmp_rmk 추가 			
//			if (saveOceanRouteVOs != null && saveOceanRouteVOs.length > 0) {
//				for (int i= 0; i <saveOceanRouteVOs.length; i ++ ) {
//					if (PrdConstants.PRD_USRRMK_OTHERS.equals(saveOceanRouteVOs[i].getSRouteRmk())) {											
//						saveOceanRouteVOs[i].setSRouteRmk(saveOceanRouteVOs[i].getSRouteNote());
//
//					}
//				}
//			}
			event.setSaveOceanRouteVOs(saveOceanRouteVOs);
		} else if(command.isCommand(FormCommand.SEARCH)) {
			int iPage = JSPUtil.getParameterAsInt(request, "iPage", 1);
			event.setIPage(iPage);		
		}
		/*
		event.putValue("pol_cont_cd", request.getParameter("pol_cont_cd"));
		event.putValue("pol_cnty_cd", request.getParameter("pol_cnty_cd"));
		event.putValue("pol_port_cd", request.getParameter("pol_port_cd"));
		event.putValue("pod_cont_cd", request.getParameter("pod_cont_cd"));
		event.putValue("pod_cnty_cd", request.getParameter("pod_cnty_cd"));
		event.putValue("pod_port_cd", request.getParameter("pod_port_cd"));
		event.putValue("tnk_lane_cd", request.getParameter("tnk_lane_cd"));
		event.putValue("ts_port_cd" , request.getParameter("ts_port_cd" ));
		event.putValue("ts_lane_cd" , request.getParameter("ts_lane_cd" ));
		event.putValue("ts_type"    , request.getParameter("ts_type"    ));
		//		event.putValue("stay_time"  , request.getParameter("stay_time"  ));
		event.putValue("userId",      userId);
		event.putValue("userDept",    account.getOfc_cd());
		event.putValue("i_del_flg", JSPUtil.getParameter(request, "i_del_flg".trim(), ""));
		log.debug("\n >>> i_del_flg : " + event.getString("i_del_flg"    ));
		
		/* case of MULTI 
		 * -1 - null
		 *  0 -
		 *  1 -
		 *  2 - SEARCH /w Event 
		 *  3 -
		 *  4 - MODIFY
		 *  5 - 
		 *  6 -
		 *  7 - MULTI
		 *  8 -
		 *  9 - 
		 */
//		if ("7".equals(request.getParameter("f_cmd"))) {
		/*
		FormCommand f_cmd = FormCommand.fromRequest(request);
		if (f_cmd.isCommand(FormCommand.MULTI)) {
		event.putValue("sDel",      request.getParameterValues("sDel"     ));
		event.putValue("sStatus",   request.getParameterValues("sStatus"  ));
		event.putValue("sPol",      request.getParameterValues("sPol"     ));
		event.putValue("sLane",     request.getParameterValues("sLane"    ));
		event.putValue("sSvcType",  request.getParameterValues("sSvcType" ));
		event.putValue("sTs1Port",  request.getParameterValues("sTs1Port" ));
		event.putValue("sTs1Lane",  request.getParameterValues("sTs1Lane" ));
		event.putValue("sTs1Type",  request.getParameterValues("sTs1Type" ));
		event.putValue("sTs2Port",  request.getParameterValues("sTs2Port" ));
		event.putValue("sTs2Lane",  request.getParameterValues("sTs2Lane" ));
		event.putValue("sTs2Type",  request.getParameterValues("sTs2Type" ));

		event.putValue("sTs3Port",  request.getParameterValues("sTs3Port" ));
		event.putValue("sTs3Lane",  request.getParameterValues("sTs3Lane" ));
		event.putValue("sTs3Type",  request.getParameterValues("sTs3Type" ));

		event.putValue("sPod",      request.getParameterValues("sPod"     ));
		event.putValue("sTTime",    request.getParameterValues("sTTime"   ));
		event.putValue("sSTime",    request.getParameterValues("sSTime"   ));
		event.putValue("sPrior",    request.getParameterValues("sPrior"   ));
		event.putValue("sFU",       request.getParameterValues("sFU"      ));
		event.putValue("sRouteFlg", request.getParameterValues("sRouteFlg"));

		//Hidden Field
		event.putValue("sRoutSeq",   request.getParameterValues("sRoutSeq"  ));
		event.putValue("sTsInd",     request.getParameterValues("sTsInd"    ));
		event.putValue("sPfInd",     request.getParameterValues("sPfInd"    ));
		event.putValue("sTs1Tztm",   request.getParameterValues("sTs1Tztm"  ));
		event.putValue("sTs2Tztm",   request.getParameterValues("sTs2Tztm"  ));
		event.putValue("sTs3Tztm",   request.getParameterValues("sTs3Tztm"  ));
		event.putValue("sTs1StayTm", request.getParameterValues("sTs1StayTm"));
		event.putValue("sTs2StayTm", request.getParameterValues("sTs2StayTm"));
		event.putValue("sRouteRmk",  request.getParameterValues("sRmk" ));
		event.putValue("sLnkCnt",  request.getParameterValues("sLnkCnt" ));

		event.putValue("sPol1"   ,  request.getParameterValues("sPol1"    ));
		event.putValue("sPod1"   ,  request.getParameterValues("sPod1"    ));
		event.putValue("sDir1"   ,  request.getParameterValues("sDir1"    ));
		event.putValue("sFdrFlg1",  request.getParameterValues("sFdrFlg1" ));
		event.putValue("sPol2"   ,  request.getParameterValues("sPol2"    ));
		event.putValue("sPod2"   ,  request.getParameterValues("sPod2"    ));
		event.putValue("sDir2"   ,  request.getParameterValues("sDir2"    ));
		event.putValue("sFdrFlg2",  request.getParameterValues("sFdrFlg2" ));
		event.putValue("sPol3"   ,  request.getParameterValues("sPol3"    ));
		event.putValue("sPod3"   ,  request.getParameterValues("sPod3"    ));
		event.putValue("sDir3"   ,  request.getParameterValues("sDir3"    ));
		event.putValue("sFdrFlg3",  request.getParameterValues("sFdrFlg3" ));
		event.putValue("sPol4"   ,  request.getParameterValues("sPol4"    ));
		event.putValue("sPod4"   ,  request.getParameterValues("sPod4"    ));
		event.putValue("sDir4"   ,  request.getParameterValues("sDir4"    ));
		event.putValue("sFdrFlg4",  request.getParameterValues("sFdrFlg4" ));

		event.putValue("sN1stTztmHrs"  ,  request.getParameterValues("sN1stTztmHrs"  ));
		event.putValue("sN2ndTztmHrs"  ,  request.getParameterValues("sN2ndTztmHrs"  ));
		event.putValue("sN3rdTztmHrs"  ,  request.getParameterValues("sN3rdTztmHrs"  ));
		event.putValue("sN4thTztmHrs"  ,  request.getParameterValues("sN4thTztmHrs"  ));
		event.putValue("sN1stStayTmHrs",  request.getParameterValues("sN1stStayTmHrs"));
		event.putValue("sN2ndStayTmHrs",  request.getParameterValues("sN2ndStayTmHrs"));
		event.putValue("sN3rdStayTmHrs",  request.getParameterValues("sN3rdStayTmHrs"));
		event.putValue("sDupAllow",  request.getParameterValues("sDupAllow"));
		String[] sN1stStayTmHrs  = (String[])event.getObject( "sN1stStayTmHrs");
		log.debug("\n\n sN1stStayTmHrs:"+sN1stStayTmHrs[0]);
		} 

		//		PrdRequestEvent prdEv = PrdRequestEvent.getInstance(request) ;
		
		 */
		request.setAttribute("Event", event);
		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param eventResponse EventResponse interface를 구현한 객체
	 */
	@Override
	public void doEnd(HttpServletRequest request, EventResponse eventResponse){
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event){
		request.setAttribute("Event", event);
	}
}
