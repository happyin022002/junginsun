/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0926HTMLAction.java
*@FileTitle : CM Data Check Set-up
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.23
*@LastModifier : 이수빈
*@LastVersion : 1.0
* 2009.04.23 이수빈
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.ExpRuleSetupVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.ImpRuleSetupVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.usa.vo.RuleSetupCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupKeyVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupListCondVO;
import com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload.vo.SetupListModVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.customsdeclaration.manifestlistdownload 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 manifestlistdownloadSC로 실행요청<br>
 * - manifestlistdownloadSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Lee Subin
 * @see manifestlistdownloadEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0926HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;
    /**
     * ESM_BKG_0926HTMLAction 객체를 생성
     */
    public ESM_BKG_0926HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 manifestlistdownloadEvent로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
        
        FormCommand command = FormCommand.fromRequest(request);
        EsmBkg0926Event event = new EsmBkg0926Event();
        
        if(command.isCommand(FormCommand.MULTI)) {
            SetupListModVO setupListModVO = new SetupListModVO();
            ExpRuleSetupVO[] expVOs = (ExpRuleSetupVO[])getVOs(request, ExpRuleSetupVO.class,"");
            ImpRuleSetupVO[] impVOs = (ImpRuleSetupVO[])getVOs(request, ImpRuleSetupVO.class,"");
            
            List<ExpRuleSetupVO> expRuleSetupVOs = new ArrayList<ExpRuleSetupVO>();
            List<ImpRuleSetupVO> impRuleSetupVOs = new ArrayList<ImpRuleSetupVO>();
            
            for(int i=0; i<expVOs.length; i++) {
                if("E".equals(expVOs[i].getXptImpCd())){
                    expRuleSetupVOs.add(expVOs[i]);
                }
            }
            for(int i=0; i<impVOs.length; i++) {
                if("I".equals(impVOs[i].getXptImpCd())){
                    impRuleSetupVOs.add(impVOs[i]);
                }
            }
            setupListModVO.setExpRuleSetupVOS(expRuleSetupVOs);
            setupListModVO.setImpRuleSetupVOS(impRuleSetupVOs);
            event.setSetupListModVO(setupListModVO);
        }
        else if(command.isCommand(FormCommand.SEARCH)) {
            event.setSetupListCondVO((SetupListCondVO)getVO(request, RuleSetupCondVO.class));
        }
        else if(command.isCommand(FormCommand.SEARCH01)) {
        	event.setComboName(request.getParameter("comboName"));
        	event.setCntCd(request.getParameter("cntCd"));
        }
        else if(command.isCommand(FormCommand.MODIFY)) {
            event.setSetupKeyVO((SetupKeyVO)getVO(request, SetupKeyVO.class));
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