/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_SCE_0006HTMLAction.java
*@FileTitle : COP Main Search
*Open Issues :
*Change history :
*@LastModifyDate : 2006-08-30
*@LastModifier : Seong-mun Kang
*@LastVersion : 1.0
* 2006-08-30 Seong-mun Kang
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.sce.copmanage.copsearch.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.COPDetailVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchCOPMainListVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copsearch.vo.SearchSOCostInfoVO;
import com.hanjin.apps.alps.esd.sce.copmanage.copupdate.vo.COPUpdateInfoVO;
import com.hanjin.apps.alps.esd.sce.dwellnotification.vo.DwllNtfcSrchVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.CommonWebKeys;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.sce 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 COPManageSC로 실행요청<br>
 * - COPManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Seong-mun Kang
 * @see EsdSce0006Event , EsdSce0006EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_SCE_0006HTMLAction extends HTMLActionSupport {

    /**
     * ESD_SCE_0006HTMLAction 객체를 생성
     */
    public ESD_SCE_0006HTMLAction() {
    }

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 EsdSce0006Event로 파싱하여 request에 셋팅<br>
     * 
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
    public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
        EsdSce0006Event event   = new EsdSce0006Event() ;    
        if(command.isCommand(FormCommand.MODIFY)) {
    		SignOnUserAccount account = (SignOnUserAccount) request.getSession().getAttribute(CommonWebKeys.SIGN_ON_USER_ACCOUNT);
    		String userId = account.getUsr_id(); 
    		
    		//EsdSce0006Event event = new EsdSce0006Event() ;
    		event.setCOPUpdateInfoVO(((COPUpdateInfoVO)getVO(request, COPUpdateInfoVO .class)), userId);
    		        	
        }else{
            event.setClickBtnNm(JSPUtil.getParameter(request, "clickBtnNm".trim(), ""));
            event.setCopNo(JSPUtil.getParameter(request, "cop_no".trim(), ""));        
    		event.setCOPDetailVO((COPDetailVO)getVO(request, COPDetailVO .class));
    		event.setSearchSOCostInfoVO((SearchSOCostInfoVO)getVO(request, SearchSOCostInfoVO .class));
    		
    		if(command.isCommand(FormCommand.SEARCHLIST05)){
	    			SearchSOCostInfoVO soCostInfovo = new SearchSOCostInfoVO();
	    			event.setSearchSOCostInfoVOs(soCostInfovo.fromRequestGrid(request, ""));    		
    		}
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