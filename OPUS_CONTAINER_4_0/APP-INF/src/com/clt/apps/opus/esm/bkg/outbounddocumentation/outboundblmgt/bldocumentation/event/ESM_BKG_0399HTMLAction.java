/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_399HTMLAction.java
 *@FileTitle : NVOCC House B/L Information
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

import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblTmpltVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.BkgNvoccProfCntrMfVO;
import com.clt.syscommon.common.table.BkgNvoccProfVO;

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

public class ESM_BKG_0399HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;

    /**
     * ESM_BKG_399HTMLAction 객체를 생성
     */
    public ESM_BKG_0399HTMLAction() {}

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
        EsmBkg0399Event event = new EsmBkg0399Event();
        log.debug("***** ESM_BKG_399HTMLAction : " + command.getCommand());

        event.setShprNm(JSPUtil.getParameter(request, "shpr_nm", ""));
        event.setCneeNm(JSPUtil.getParameter(request, "cnee_nm", ""));
        if(command.isCommand(FormCommand.MULTI)) {
            HblTmpltVO hblTmpltVO = new HblTmpltVO();
            BkgNvoccProfVO[] vo1 = (BkgNvoccProfVO[])getVOs(request, BkgNvoccProfVO.class, "sheet1_");
            BkgNvoccProfCntrMfVO[] vo2 = (BkgNvoccProfCntrMfVO[])getVOs(request, BkgNvoccProfCntrMfVO.class, "sheet2_");
            log.debug("BkgNvoccProfVO ===========================>" + vo1);
            log.debug("BkgNvoccProfCntrMfVO =====================>" + vo2);
            
            hblTmpltVO.setBkgNvoccProfVOs(getProfList(vo1));
            hblTmpltVO.setBkgNvoccProfCntrMfVOs(getProfMfList(vo2));
            
            event.setHblTmpltVO(hblTmpltVO);
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
     * @param vo1s
     * @return
     */
    private List<BkgNvoccProfVO> getProfList(BkgNvoccProfVO[] vos) {
        List<BkgNvoccProfVO> list = new ArrayList<BkgNvoccProfVO>();
        int cnt = vos == null ? 0 : vos.length;
        for(int i=0;i<cnt;i++){
            //log.debug("sheet1_BkgNvoccProfVO : " + vos[i].getIbflag());
            list.add(vos[i]);
        }
        return list;
    }
    
    /**
     * @param vo2s
     * @return
     */
    private List<BkgNvoccProfCntrMfVO> getProfMfList(BkgNvoccProfCntrMfVO[] vos) {
        List<BkgNvoccProfCntrMfVO> list = new ArrayList<BkgNvoccProfCntrMfVO>();
        int cnt = vos == null ? 0 : vos.length;
        for(int i=0;i<cnt;i++){
            //log.debug("sheet2_BkgNvoccProfCntrMfVO : " + vos[i].getIbflag());
            list.add(vos[i]);
        }
        return list;
    }

}