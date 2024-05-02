/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_048HTMLAction.java
*@FileTitle : Multi Input
*Open Issues :
*Change history :
*@LastModifyDate : 2006-11-28
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-11-28 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.event;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.common.util.basic.RequestDataSetBC;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputBKGNoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputBLNoVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputCntrVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchMultiInputVVDVO;
import com.hanjin.apps.alps.esd.sce.visibilitymanage.railtransitreport.vo.SearchRTRInfoVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.sce 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 ExceptionManageSC로 실행요청<br>
 * - ExceptionManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Seong-mun Kang
 * @see EsdSce048Event , EsdSce048EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0048HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
    /**
     * ESD_SCE_048HTMLAction 객체를 생성
     */
    public ESD_SCE_0048HTMLAction() {
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsdSce048Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	log.debug("Event 0048 생성!!");
    	EsdSce0048Event event   = new EsdSce0048Event();
//    	HashMap map = null;
        FormCommand f_cmd = FormCommand.fromRequest(request);
        if (f_cmd.isCommand(FormCommand.SEARCHLIST)) {
        	log.debug("SEARCHLIST 를 위한 호출");
        	SearchRTRInfoVO condition = new SearchRTRInfoVO();
        	condition.setType(JSPUtil.getParameter(request, "type", ""));
        	//condition.setRCntrNo(JSPUtil.getParameter(request, "r_cntr_no", ""));
        	event.setSearchRTRInfo(condition);
        	log.debug("type==" + request.getParameter("type"));
			log.debug("r_cntr_no==" + request.getParameter("r_cntr_no"));
			log.debug("r_bkg_no==" + request.getParameter("r_bkg_no"));
			log.debug("r_bl_no==" + request.getParameter("r_bl_no"));
			log.debug("r_vvd==" + request.getParameter("r_vvd"));
			log.debug("r_polpod==" + request.getParameter("r_polpod"));
			log.debug("r_origin==" + request.getParameter("r_origin"));
			log.debug("r_dest==" + request.getParameter("r_dest"));
			log.debug("r_scno==" + request.getParameter("r_scno"));
			log.debug("r_custcd==" + request.getParameter("r_custcd"));
        	event.setCntrVos((SearchMultiInputCntrVO[]) getVOs(request, SearchMultiInputCntrVO.class, "r_"));
        	event.setBkgVos((SearchMultiInputBKGNoVO[]) getVOs(request, SearchMultiInputBKGNoVO.class, "r_"));
        	event.setBlNoVos((SearchMultiInputBLNoVO[]) getVOs(request, SearchMultiInputBLNoVO.class, "r_"));
        	event.setVvdVos((SearchMultiInputVVDVO[]) getVOs(request, SearchMultiInputVVDVO.class, "r_"));
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