/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0178HTMLAction.java
 *@FileTitle : C/M by Container
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.06.11
 *@LastModifier : 김영출
 *@LastVersion : 1.0
 * 2009.06.11 김영출
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmByCntrVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmDescInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrCmEtcInfoVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OutboundBLMgtSC로 실행요청<br>
 * - OutboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author Kim Youngchul
 * @see OutboundBLMgtEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0178HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;

    /**
     * ESM_BKG_0178HTMLAction 객체를 생성
     */
    public ESM_BKG_0178HTMLAction() {}

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
        EsmBkg0178Event event = new EsmBkg0178Event();
        log.debug("::CALL:: ESM_BKG_0178HTMLAction : " + command.getCommand());

        event.setCntrNo(JSPUtil.getParameter(request, "cntr_no", ""));
        event.setTVvd(JSPUtil.getParameter(request, "t_vvd", ""));
        if(command.isCommand(FormCommand.MULTI)) {
            CntrCmEtcInfoVO vo0 = (CntrCmEtcInfoVO) getVO(request, CntrCmEtcInfoVO.class);
            CntrCmBkgInfoVO[] vo1 = (CntrCmBkgInfoVO[]) getVOs(request, CntrCmBkgInfoVO.class, "sheet1_");
            CntrCmDescInfoVO[] vo2 = (CntrCmDescInfoVO[]) getVOs(request, CntrCmDescInfoVO.class, "sheet2_");
            
            CmByCntrVO cmVO = new CmByCntrVO();
            cmVO.setCntrCmEtcInfoVO(vo0);
            cmVO.setCntrCmBkgInfoVOs(getCntrCmBkgInfoVOList(vo1));
            cmVO.setCntrCmDescInfoVOs(getCntrCmDescInfoVOList(vo2));
            
            event.setCmByCntrVO(cmVO);
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
    
    /**
     * 
     * @param vos
     * @return
     */
    private List<CntrCmBkgInfoVO> getCntrCmBkgInfoVOList(CntrCmBkgInfoVO[] vos){
        List<CntrCmBkgInfoVO> list = new ArrayList<CntrCmBkgInfoVO>();
        int len = (vos == null) ? 0 : vos.length;
        for(int i=0;i<len; i++){
            log.debug(i + ". ===========>" + vos[i].getBkgNo() + "|" + vos[i].getCntrNo() + "|" + vos[i].getIbflag());
            list.add(vos[i]);
        }
        return list;
    }    
    
    /**
     * 
     * @param vos
     * @return
     */
    private List<CntrCmDescInfoVO> getCntrCmDescInfoVOList(CntrCmDescInfoVO[] vos){
        List<CntrCmDescInfoVO> list = new ArrayList<CntrCmDescInfoVO>();
        int len = (vos == null) ? 0 : vos.length;
        for(int i=0;i<len; i++){
            log.debug(i + ". ===========>" + vos[i].getBkgNo() + "|" + vos[i].getCntrNo() + "|" + vos[i].getIbflag());
            list.add(vos[i]);
        }
        return list;
    }
}