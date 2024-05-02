/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0045HTMLAction.java
*@FileTitle : Rail Transit Report
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-22
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-22 Seong-mun Kang
* 1.0 최초 생성
==========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.event;

import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRCountVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRInfoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRListVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRSmmyInfoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRSmmyDtlVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.sce 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ExceptionManageSC로 실행요청<br>
 * - ExceptionManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Seong-mun Kang
 * @see EsdSce0045Event , EsdSce0045EventResponse 참조
 * @since J2EE 1.4 
 */
public class ESD_SCE_0045HTMLAction extends HTMLActionSupport {
	
	private static final long serialVersionUID = 1L;
    /**
     * ESD_SCE_0045HTMLAction 객체를 생성
     */
    public ESD_SCE_0045HTMLAction() {
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsdSce0045Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
		EsdSce0045Event event = new EsdSce0045Event();
        FormCommand f_cmd = FormCommand.fromRequest(request);
        if (f_cmd.isCommand(FormCommand.SEARCHLIST)) {
        	SearchRTRInfoVO condition = new SearchRTRInfoVO();
        	condition.setSearchtype("single");
        	condition.setDateKind(JSPUtil.getParameter(request, "date_kind", ""));
        	condition.setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
        	condition.setToDt(JSPUtil.getParameter(request, "to_dt", ""));
        	condition.setFmNodCd(JSPUtil.getParameter(request, "fmNodCd", ""));
        	condition.setToNodCd(JSPUtil.getParameter(request, "toNodCd", ""));
        	condition.setCgoTpCd(JSPUtil.getParameter(request, "cgo_tp_cd", ""));
        	condition.setTrspBndCd(JSPUtil.getParameter(request, "trsp_bnd_cd"));
        	condition.setBkgNo(JSPUtil.getParameter(request, "bkgNo"));
        	condition.setBlNo(JSPUtil.getParameter(request, "blNo"));
        	condition.setEqNo(JSPUtil.getParameter(request, "eqNo"));
        	condition.setVvd(JSPUtil.getParameter(request, "vvdCd"));
        	condition.setDwellKind(JSPUtil.getParameter(request, "dwellKind"));
        	condition.setDwellTime(JSPUtil.getParameter(request, "dwellTime"));
        	condition.setTDep(JSPUtil.getParameter(request, "tDep"));
        	condition.setRailcomp(JSPUtil.getParameter(request, "railcompVal"));
        	condition.setBkgOfcCd(JSPUtil.getParameter(request, "bkgOfcCd"));
        	condition.setCustCntSeq(JSPUtil.getParameter(request, "custCntSeq"));
        	condition.setPodPol(JSPUtil.getParameter(request, "podPol"));
        	condition.setScNo(JSPUtil.getParameter(request, "scNo"));
        	condition.setCstmsAcptFlg(JSPUtil.getParameter(request, "cstmsAcptFlg"));
        	condition.setCustomerLoc(JSPUtil.getParameter(request, "customerLoc"));
        	condition.setCntrTpsz(JSPUtil.getParameter(request, "cntr_tpsz"));
        	event.setSearchRTRInfo(condition);
			event.setSearchRTRCnt((SearchRTRCountVO) getVO(request, SearchRTRCountVO.class));
		} else if (f_cmd.isCommand(FormCommand.SEARCH02)) {
        	SearchRTRInfoVO condition = new SearchRTRInfoVO();
        	condition.setSearchtype("single");
        	condition.setDateKind(JSPUtil.getParameter(request, "date_kind", ""));
        	condition.setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
        	condition.setToDt(JSPUtil.getParameter(request, "to_dt", ""));
        	condition.setFmNodCd(JSPUtil.getParameter(request, "fmNodCd", ""));
        	condition.setToNodCd(JSPUtil.getParameter(request, "toNodCd", ""));
        	condition.setCgoTpCd(JSPUtil.getParameter(request, "cgo_tp_cd", ""));
        	condition.setTrspBndCd(JSPUtil.getParameter(request, "trsp_bnd_cd"));
        	condition.setBkgNo(JSPUtil.getParameter(request, "bkgNo"));
        	condition.setBlNo(JSPUtil.getParameter(request, "blNo"));
        	condition.setEqNo(JSPUtil.getParameter(request, "eqNo"));
        	condition.setVvd(JSPUtil.getParameter(request, "vvdCd"));
        	condition.setDwellKind(JSPUtil.getParameter(request, "dwellKind"));
        	condition.setDwellTime(JSPUtil.getParameter(request, "dwellTime"));
        	condition.setTDep(JSPUtil.getParameter(request, "tDep"));
        	condition.setRailcomp(JSPUtil.getParameter(request, "railcompVal"));
        	condition.setBkgOfcCd(JSPUtil.getParameter(request, "bkgOfcCd"));
        	condition.setCustCntSeq(JSPUtil.getParameter(request, "custCntSeq"));
        	condition.setPodPol(JSPUtil.getParameter(request, "podPol"));
        	condition.setScNo(JSPUtil.getParameter(request, "scNo"));
        	condition.setCstmsAcptFlg(JSPUtil.getParameter(request, "cstmsAcptFlg"));
        	condition.setCustomerLoc(JSPUtil.getParameter(request, "customerLoc"));
        	condition.setCurPage(JSPUtil.getParameter(request, "cur_page"));
        	condition.setCntrTpsz(JSPUtil.getParameter(request, "cntr_tpsz"));
        	condition.setODep(JSPUtil.getParameter(request, "oDep"));
        	event.setSearchRTRInfo(condition);
			event.setSearchRTRList((SearchRTRListVO) getVO(request, SearchRTRListVO.class));
		} else if (f_cmd.isCommand(FormCommand.MULTI)) {
        	SearchRTRInfoVO condition = new SearchRTRInfoVO();
        	condition.setSearchtype("multi");
        	condition.setDateKind(JSPUtil.getParameter(request, "date_kind", ""));
        	condition.setFmDt(JSPUtil.getParameter(request, "fm_dt", ""));
        	condition.setToDt(JSPUtil.getParameter(request, "to_dt", ""));
        	condition.setFmNodCd(JSPUtil.getParameter(request, "fmNodCd", ""));
        	condition.setToNodCd(JSPUtil.getParameter(request, "toNodCd", ""));
        	condition.setCgoTpCd(JSPUtil.getParameter(request, "cgo_tp_cd", ""));
        	condition.setTrspBndCd(JSPUtil.getParameter(request, "trsp_bnd_cd"));
        	condition.setBkgNo(JSPUtil.getParameter(request, "bkgNo"));
        	condition.setBlNo(JSPUtil.getParameter(request, "blNo"));
        	condition.setEqNo(JSPUtil.getParameter(request, "eqNo"));
        	condition.setVvd(JSPUtil.getParameter(request, "vvdCd"));
        	condition.setDwellKind(JSPUtil.getParameter(request, "dwellKind"));
        	condition.setDwellTime(JSPUtil.getParameter(request, "dwellTime"));
        	condition.setTDep(JSPUtil.getParameter(request, "tDep"));
        	condition.setRailcomp(JSPUtil.getParameter(request, "railcompVal"));
        	condition.setBkgOfcCd(JSPUtil.getParameter(request, "bkgOfcCd"));
        	condition.setCustCntSeq(JSPUtil.getParameter(request, "custCntSeq"));
        	condition.setPodPol(JSPUtil.getParameter(request, "podPol"));
        	condition.setScNo(JSPUtil.getParameter(request, "scNo"));
        	condition.setCstmsAcptFlg(JSPUtil.getParameter(request, "cstmsAcptFlg"));
        	condition.setCustomerLoc(JSPUtil.getParameter(request, "customerLoc"));
        	condition.setCurPage(JSPUtil.getParameter(request, "cur_page"));
        	condition.setCntrTpsz(JSPUtil.getParameter(request, "cntr_tpsz"));
        	event.setSearchRTRInfo(condition);
			event.setSearchRTRLists((SearchRTRListVO[]) getVOs(request, SearchRTRListVO.class, "r_"));
		} else if (f_cmd.isCommand(FormCommand.MODIFY) || f_cmd.isCommand(FormCommand.MODIFY02)) {
			event.setSearchRTRLists((SearchRTRListVO[]) getVOs(request, SearchRTRListVO.class, ""));
		} else if (f_cmd.isCommand(FormCommand.SEARCH10)) {
			event.setSearchRTRSmmyInfos((SearchRTRSmmyInfoVO[]) getVOs(request, SearchRTRSmmyInfoVO.class, ""));
			event.setFmDate(request.getParameter("fm_date"));
			event.setToDate(request.getParameter("to_date"));
			event.setDateKind(request.getParameter("date_kind"));
			event.setChkPeriod(request.getParameter("f_chkprd"));
			event.setScNo(request.getParameter("sc_no"));
		} else if (f_cmd.isCommand(FormCommand.SEARCH11)) {
			event.setSearchRTRSmmyDtls((SearchRTRSmmyDtlVO[]) getVOs(request, SearchRTRSmmyDtlVO.class, ""));
			event.setDateKind(request.getParameter("date_kind"));
			event.setCurPage(request.getParameter("cur_page"));
			event.setParentScNo(request.getParameter("parentScNo"));
			
		}
        
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