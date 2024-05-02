/*=========================================================
*Copyright(c) 2018 SM Lines
*@FileName : BCM_CMS_0312HTMLAction.java
*@FileTitle : Customer Approval
*Open Issues :
*Change history :
*@LastModifyDate : 2018-01-19
*@LastModifier : jklim
*@LastVersion : 1.0
* 2018-01-19 jklim
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.bcm.cms.custmanage.custrequest.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.event.BcmCcd0033Event;
import com.hanjin.apps.alps.bcm.ccd.commoncode.salesrepresentative.vo.SalesRepVO;
import com.hanjin.apps.alps.bcm.cms.custmanage.custrequest.event.BcmCms0310Event;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.bizcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 BizCommonSC로 실행요청<br>
 * - BizCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Lim Jaekwan
 * @see BcmCms0301Event , BcmCms0301EventResponse 참조
 * @since J2EE 1.4
 */
public class BCM_CMS_0312HTMLAction extends HTMLActionSupport {

    /**
     * BCM_CMS_0301HTMLAction 객체를 생성
     */
    public BCM_CMS_0312HTMLAction() {
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 BCM_CMS_0310Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	
    	FormCommand command = FormCommand.fromRequest(request);
    	BcmCms0312Event event = new BcmCms0312Event();
		
    	if(command.isCommand(FormCommand.MULTI01)) {
    		String rqstNo = request.getParameter("rqst_no");
    		String grpIndivDiv = request.getParameter("grp_indiv_div");
			event.setRqstNo(rqstNo);
			event.setGrpIndivDiv(grpIndivDiv);
		} else if(command.isCommand(FormCommand.MULTI02)) {
    		String rqstNo = request.getParameter("rqst_no");
    		String rjctRsnRmk = request.getParameter("rjct_rsn_rmk");
    		String rjctRsnCd = request.getParameter("rjct_rsn_cd");
			event.setRqstNo(rqstNo);
			event.setRjctRsnRmk(rjctRsnRmk);
			event.setRjctRsnCd(rjctRsnCd);
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