/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_3004HTMLAction.java
 *@FileTitle : BKG Interface Management
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.19
 *@LastModifier : 
 *@LastVersion : 1.0
 * 2009.05.19 
 * 1.0 Creation
=========================================================*/

package com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.BkgCopManageVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.ManRplnRsltVO;
import com.hanjin.apps.alps.esd.sce.bkgcopmanage.vo.SceActTmlRtvVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsplitcombine.vo.CombineByBkgInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrAdjVolVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManageInVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManageListVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgIfManagerEdiInputVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DblWblVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgCntrSealNoVO;
import com.hanjin.syscommon.common.table.SceBkgOpHisVO;
import com.hanjin.syscommon.common.table.SceCopHdrVO;

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

public class ESM_BKG_3004HTMLAction extends HTMLActionSupport {

    private static final long serialVersionUID = 1L;

    /**
     * ESM_BKG_3004HTMLAction 객체를 생성
     */
    public ESM_BKG_3004HTMLAction() {}

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
        EsmBkg3004Event event = new EsmBkg3004Event();
        if (command.isCommand(FormCommand.SEARCH01)){
			event.setBkgIfManageInVO((BkgIfManageInVO) getVO(request, BkgIfManageInVO.class));
        }else if (command.isCommand(FormCommand.SEARCH02)){
			event.setBkgIfManagerEdiInputVO((BkgIfManagerEdiInputVO) getVO(request, BkgIfManagerEdiInputVO.class));
		}else if (command.isCommand(FormCommand.MULTI01)){
			event.setBkgIfManageInVOs((BkgIfManageInVO[])getVOs(request, BkgIfManageInVO.class, "t1sheet1_"));
		}else if (command.isCommand(FormCommand.MULTI02)){
			event.setBkgIfManageInVOs((BkgIfManageInVO[])getVOs(request, BkgIfManageInVO.class, "t2sheet1_"));
		}else if (command.isCommand(FormCommand.MULTI03)){
			event.setBkgIfManageInVOs((BkgIfManageInVO[])getVOs(request, BkgIfManageInVO.class, "t3sheet1_"));
		}else if (command.isCommand(FormCommand.MULTI04)){
			event.setBkgIfManageInVOs((BkgIfManageInVO[])getVOs(request, BkgIfManageInVO.class, "t4sheet1_"));
			event.setBkgBlNoVOs((BkgBlNoVO[])getVOs(request, BkgBlNoVO .class,"t4sheet1_"));
			event.setCustTpIdVOs((CustTpIdVO[])getVOs(request, CustTpIdVO .class,"t4sheet1_"));
		}
		else if(command.isCommand(FormCommand.SEARCH03)){
        	event.setAttribute("key",JSPUtil.getParameter(request, "key"));
		}
		else if(command.isCommand(FormCommand.SEARCH04)){
        	event.setAttribute("key",JSPUtil.getParameter(request, "key"));
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