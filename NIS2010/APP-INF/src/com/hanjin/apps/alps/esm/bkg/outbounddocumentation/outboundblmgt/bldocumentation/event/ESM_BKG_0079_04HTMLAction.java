/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0079_04HTMLAction.java
 *@FileTitle : Container Information - Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.19
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.05.19 김영출
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineByBkgInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrAdjVolVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgCntrSealNoVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의
 * Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OutboundBLMgtSC로 실행요청<br>
 * - OutboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Kim Youngchul
 * @see OutboundBLMgtEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0079_04HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;

    /**
     * ESM_BKG_0079_04HTMLAction 객체를 생성
     */
    public ESM_BKG_0079_04HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 OutboundBLMgtEvent로 파싱하여 request에 셋팅<br>
     *
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {

        FormCommand command = FormCommand.fromRequest(request);
        EsmBkg007904Event event = new EsmBkg007904Event();
        log.debug("::CALL::> ESM_BKG_0079_04HTMLAction - " + command.getCommand());

        if(command.isCommand(FormCommand.DEFAULT)) {
            String uri = request.getRequestURI();
            log.debug("***** getRequestURI : " + uri);
            if (uri.endsWith("_Q.do")){ 
                //event.setScrnAuth("R");
                event.setAttribute("SCRN_AUTH", "R");
            }else{
                //event.setScrnAuth("W");
                event.setAttribute("SCRN_AUTH", "W");
            }
            
            
            event.setBkgNo(JSPUtil.getParameter(request, "bkg_no",   ""));
            event.setBlNo(JSPUtil.getParameter(request, "bl_no",    ""));
        } else if(command.isCommand(FormCommand.SEARCH)) {
            event.setBkgNo(JSPUtil.getParameter(request, "bkg_no",  ""));
            event.setBlNo(JSPUtil.getParameter(request, "bl_no",  ""));
        } else if(command.isCommand(FormCommand.SEARCH01)) {
            event.setBkgNo(JSPUtil.getParameter(request, "bkg_no",  ""));
            event.setCntrNo(JSPUtil.getParameter(request, "cntr_no",  ""));
        } else if(command.isCommand(FormCommand.SEARCH02)) {
            event.setBkgNo(JSPUtil.getParameter(request, "bkg_no",  ""));
            event.setCntrNo(JSPUtil.getParameter(request, "cntr_no",  ""));
        }else if(command.isCommand(FormCommand.SEARCH03)) {
            event.setBkgNo(JSPUtil.getParameter(request, "bkg_no",  ""));
            event.setCntrNo(JSPUtil.getParameter(request, "cntr_no",  ""));
            event.setContainerVOs((ContainerVO[]) getVOs(request, ContainerVO.class, "sheet1_"));
        }else if(command.isCommand(FormCommand.SEARCH04)) {
            event.setBkgNo(JSPUtil.getParameter(request, "bkg_no",  ""));
            event.setCntrNo(JSPUtil.getParameter(request, "cntr_no",  ""));
            event.setContainerVOs((ContainerVO[]) getVOs(request, ContainerVO.class, "sheet1_"));            
        } else if(command.isCommand(FormCommand.MULTI)) {
            event.setBkgNo(JSPUtil.getParameter(request, "bkg_no",  ""));

            CntrEtcInfoVO bkgEtcInfoVO = (CntrEtcInfoVO) getVO(request, CntrEtcInfoVO.class);
            ContainerVO[] containerVOs = (ContainerVO[]) getVOs(request, ContainerVO.class, "sheet1_");
            BkgCntrSealNoVO[] bkgCntrSealNoVOs = (BkgCntrSealNoVO[]) getVOs(request, BkgCntrSealNoVO.class, "sheet2_");
            CntrAdjVolVO[] cntrAdjVolVOs = (CntrAdjVolVO[]) getVOs(request, CntrAdjVolVO.class, "sheet3_");
            CmBkgInfoVO cmBkgInfoVO = (CmBkgInfoVO) getVO(request, CmBkgInfoVO.class);
            
            event.setBkgEtcInfoVO(bkgEtcInfoVO);
            event.setContainerVOs(containerVOs);
            event.setBkgCntrSealNoVOs(bkgCntrSealNoVOs);
            event.setCntrAdjVolVOs(cntrAdjVolVOs);
            event.setCmBkgInfoVO(cmBkgInfoVO);

            log.debug(">>>bkgNo      : " + bkgEtcInfoVO.getBkgNo());
            log.debug(">>>fnlCfmFlg  : " + bkgEtcInfoVO.getFnlCfmFlg());
            log.debug(">>>evntDt     : " + bkgEtcInfoVO.getEvntDt());
        } else if(command.isCommand(FormCommand.MULTI02)) {
            event.setBkgNo(JSPUtil.getParameter(request, "bkg_no",  ""));
            event.setBlNo(JSPUtil.getParameter(request, "bl_no",    ""));
        } else if(command.isCommand(FormCommand.MODIFY01)) {
            CntrEtcInfoVO bkgEtcInfoVO = (CntrEtcInfoVO) getVO(request, CntrEtcInfoVO.class);
            ContainerVO[] containerVOs = (ContainerVO[]) getVOs(request, ContainerVO.class, "sheet1_");
            event.setBkgEtcInfoVO(bkgEtcInfoVO);
            event.setContainerVOs(containerVOs);
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