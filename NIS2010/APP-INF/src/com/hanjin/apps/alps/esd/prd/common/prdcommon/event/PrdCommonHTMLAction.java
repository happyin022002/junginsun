/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : HTMLAction.java
*@FileTitle : PRD 공통관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-16
*@LastModifier : jungsunyoung
*@LastVersion : 1.0 
* 2006-10-16 jungsunyoung
* 1.0 최초 생성
* 2009.08.03 NohSeungBae alps f/w 로 구조 변경
=========================================================*/
package com.hanjin.apps.alps.esd.prd.common.prdcommon.event;

import com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ContinentVO;
import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.prd.common.prdcommon.vo.ValidationVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.prd.common.prdcommon 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 PrdCommonManageSC로 실행요청<br>
 * - PrdCommonManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author jungsunyoung
 * @see Event , EventResponse 참조
 * @since J2EE 1.4
 */
public class PrdCommonHTMLAction extends HTMLActionSupport {

	/**
	 * HTMLAction 객체를 생성
	 */
	public PrdCommonHTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
        
        FormCommand command = FormCommand.fromRequest(request);
        PrdCommonEvent event = new PrdCommonEvent();

        if(command.isCommand(FormCommand.SEARCH01)) { // port cd validation 조회 
            event.setValidationVO((ValidationVO)getVO(request, ValidationVO .class));
        }else if(command.isCommand(FormCommand.SEARCH02)) { // location cd validation 조회 
            event.setValidationVO((ValidationVO)getVO(request, ValidationVO .class));
        }else if(command.isCommand(FormCommand.SEARCH03)) { // location cd validation 조회 
            event.setValidationVO((ValidationVO)getVO(request, ValidationVO .class));
        }else if(command.isCommand(FormCommand.SEARCH04)) { // node cd validation 조회★ 2009-08-14 KIMKWIJIN수정
            event.setValidationVO((ValidationVO)getVO(request, ValidationVO .class));
        }else if(command.isCommand(FormCommand.SEARCH05)) { // terminal cd validation 조회 
            event.setValidationVO((ValidationVO)getVO(request, ValidationVO .class));
        }else if(command.isCommand(FormCommand.SEARCH06)) { // country cd validation 조회 
            event.setValidationVO((ValidationVO)getVO(request, ValidationVO .class));
        }else if(command.isCommand(FormCommand.SEARCH07)) { // lane cd validation 조회 
            event.setValidationVO((ValidationVO)getVO(request, ValidationVO .class));
        }else if(command.isCommand(FormCommand.SEARCH08)) { // VENDER cd validation 조회 
            event.setValidationVO((ValidationVO)getVO(request, ValidationVO .class));
        }else if(command.isCommand(FormCommand.SEARCH09)) { // FDR lane cd validation 조회 
            event.setValidationVO((ValidationVO)getVO(request, ValidationVO .class));
        }else if(command.isCommand(FormCommand.SEARCH10)) { // Calling Tml Mtx lane cd validation 조회 
            event.setValidationVO((ValidationVO)getVO(request, ValidationVO .class));
        }else if(command.isCommand(FormCommand.SEARCH11)) { // Calling Tml Mtx Tml cd validation 조회 
            event.setValidationVO((ValidationVO)getVO(request, ValidationVO .class));
        }else if(command.isCommand(FormCommand.SEARCH12)) { // Lane, VVD cd validation 조회
            event.setValidationVO((ValidationVO)getVO(request, ValidationVO .class));
        }
//        else if(command.isCommand(FormCommand.SEARCH12)) {
//            
//        }else if(command.isCommand(FormCommand.SEARCH13)) {
//        }
        else if(command.isCommand(FormCommand.SEARCH20)) { // searchContinent
            event.setContinentVO((ContinentVO) getVO(request, ContinentVO .class));
        }else if(command.isCommand(FormCommand.SEARCH19)) { // searchSubContinent
            event.setContinentVO((ContinentVO) getVO(request, ContinentVO .class));
			log.debug("%%%% : "+event.getContinentVO().getContiCode());
        }
//        else if(command.isCommand(FormCommand.MULTI)) {
//            
//        }

        request.setAttribute("Event", event);

        return  event;
        /*
		PrdCommonEvent event = new PrdCommonEvent();
        FormCommand f_cmd = FormCommand.fromRequest(request);
        String uid          = JSPUtil.getParameter(request, "uid", "");
        String chkData      = JSPUtil.getParameter(request, "chkData", "");
        log.debug("\n @@@@@@ validateData :"+ chkData);

        if(uid.equals("ESD_PRD_004")) {
            log.debug("\n @@@@@@ ESD_PRD_004 :");
        }else if(uid.equals("ESD_PRD_005")) {
            log.debug("\n @@@@@@ ESD_PRD_005 :");
        }else if (f_cmd.isCommand(FormCommand.COMMAND01)) { // port cd validation 조회 
	        event.setChkData(chkData ); // form tag name
		}else if (f_cmd.isCommand(FormCommand.COMMAND02)) { // location cd validation 조회 
	        event.setChkData(chkData ); // form tag name
		}else if (f_cmd.isCommand(FormCommand.COMMAND03)) { // location cd validation 조회 
	        event.setChkData(chkData ); // form tag name
		}else if (f_cmd.isCommand(FormCommand.COMMAND04)) { // node cd validation 조회 
	        event.setChkData(chkData ); // form tag name
		}else if (f_cmd.isCommand(FormCommand.COMMAND05)) { // terminal cd validation 조회 
	        event.setChkData(chkData ); // form tag name
		}else if (f_cmd.isCommand(FormCommand.COMMAND06)) { // country cd validation 조회 
	        event.setChkData(chkData ); // form tag name
		}else if (f_cmd.isCommand(FormCommand.COMMAND07)) { // lane cd validation 조회 
	        event.setChkData(chkData ); // form tag name
		}else if (f_cmd.isCommand(FormCommand.COMMAND08)) { // VENDER cd validation 조회 
	        event.setChkData(chkData ); // form tag name
		}else if (f_cmd.isCommand(FormCommand.COMMAND09)) { // FDR lane cd validation 조회 
	        event.setChkData(chkData ); // form tag name
		}else if (f_cmd.isCommand(FormCommand.COMMAND10)) { // Calling Tml Mtx lane cd validation 조회 
	        event.setChkData(chkData ); // form tag name
		}else if (f_cmd.isCommand(FormCommand.COMMAND11)) { // Calling Tml Mtx Tml cd validation 조회 

		}		
     
		request.setAttribute("Event", event);

		return  event;
		*/
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