/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_366HTMLAction.java
 *@FileTitle : Marks And Number/Description of Goods
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.07.22
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.07.22 김영출
 * 1.0 Creation
=========================================================*/

package com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblDtlInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.NvoccFileNoVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.BkgCntrMfDescVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OutboundBLMgtSC로 실행요청<br>
 * - OutboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Kim Youngchul
 * @see OutboundBLMgtEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0366HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;

    /**
     * ESM_BKG_366HTMLAction 객체를 생성
     */
    public ESM_BKG_0366HTMLAction() {}

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
        EsmBkg0366Event event = new EsmBkg0366Event();
        log.debug("***** ESM_BKG_366HTMLAction : " + command.getCommand());

        event.setBkgNo(JSPUtil.getParameter(request, "bkg_no",  ""));
        event.setBlNo(JSPUtil.getParameter(request, "bl_no",  ""));
        event.setBlTpCd(JSPUtil.getParameter(request, "bl_tp_cd", ""));
        if(command.isCommand(FormCommand.MULTI)) {
            //HblBkgInfoVO vo1 = (HblBkgInfoVO) getVO(request, HblBkgInfoVO.class);
            BkgCntrMfDescVO[] vo2 = (BkgCntrMfDescVO[]) getVOs(request, BkgCntrMfDescVO.class, "sheet2_");
            HblDtlInfoVO[] vo3 = (HblDtlInfoVO[]) getVOs(request, HblDtlInfoVO.class, "sheet3_");
            log.debug("\n kgCntrMfDescVO[] =====>" + vo2 +
                      "\n HblDtlInfoVO[]   =====>" + vo3);
            
            HblVO hblVO = new HblVO();
            //hblVO.setHblBkgInfoVO(vo1);
            hblVO.setBkgCntrMfDescVOs(getBkgCntrMfDescVOList(vo2));
            hblVO.setHblDtlInfoVOs(getHblDtlInfoVOList(vo3));
            
            event.setHblVO(hblVO);
        }else if(command.isCommand(FormCommand.MULTI01)) {
            NvoccFileNoVO nvoccFileNoVO = (NvoccFileNoVO) getVO(request, NvoccFileNoVO.class);
            event.setNvoccFileNoVO(nvoccFileNoVO);
        }
            
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

    /**
     *
     * @param vos
     * @return
     */
    private List<HblDtlInfoVO> getHblDtlInfoVOList(HblDtlInfoVO[] vos){
        List<HblDtlInfoVO> list = new ArrayList<HblDtlInfoVO>();
        int len = (vos == null) ? 0 : vos.length;
        for(int i=0;i<len; i++){
            list.add(vos[i]);
        }
        return list;
    }

    /**
     *
     * @param vos
     * @return
     */
    private List<BkgCntrMfDescVO> getBkgCntrMfDescVOList(BkgCntrMfDescVO[] vos){
        List<BkgCntrMfDescVO> list = new ArrayList<BkgCntrMfDescVO>();
        int len = (vos == null) ? 0 : vos.length;
        for(int i=0;i<len; i++){
            list.add(vos[i]);
        }
        return list;
    }

}