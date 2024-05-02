/*=========================================================
*Copyright(c) 2015 CyberLogitec
*@FileName : EsdTss0290Event.java
*@FileTitle : D/O notification Setting
*Open Issues :
*Change history :
*@LastModifyDate : 2016-05-30
*@LastModifier : geun hwan park
*@LastVersion : 1.0
* 2016-05-30 geun hwan park
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.event;

import javax.servlet.http.HttpServletRequest;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting.vo.DoNotificationSettingListVO;
import com.hanjin.apps.alps.esd.trs.codemanage.specialcargoavailable.vo.SpecialCargoAvailableSpListVO;
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.codemanage.donotificationsetting 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CodeManageSC로 실행요청<br>
 * - CodeManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author SHIN DONG IL
 * @see EsdTrs0290Event , ESD_TRS_0290EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0290HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_0290HTMLAction 객체를 생성 
	 */
	public ESD_TRS_0290HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EsdTrs0290Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);
	  	EsdTrs0290Event event = new EsdTrs0290Event();
	  	 
		if(command.isCommand(FormCommand.SEARCH01)) {
			String f_ctrt_tp_cd = JSPUtil.getParameter(request, "f_ctrt_tp_cd", "");
			String f_sc_no 	= JSPUtil.getParameter(request, "f_sc_no", "");
			String f_eff_dt 	= JSPUtil.getParameter(request, "f_eff_dt", "");
			String f_dor_nod_cd = JSPUtil.getParameter(request, "f_dor_nod_cd", "");
			String f_dor_nod_yd = JSPUtil.getParameter(request, "f_dor_nod_yd", "");
			String f_act_flg 	= JSPUtil.getParameter(request, "f_act_flg", "");
			
			event.setF_ctrt_tp_cd(f_ctrt_tp_cd);
			event.setF_sc_no(f_sc_no);
			event.setF_eff_dt(f_eff_dt);
			event.setF_dor_nod_cd(f_dor_nod_cd);
			event.setF_dor_nod_yd(f_dor_nod_yd);
			event.setF_act_flg(f_act_flg);
		}else if(command.isCommand(FormCommand.SEARCH02)) {	
			String sc_no = JSPUtil.getParameter(request, "sc_no", "");
			event.setSc_no(sc_no);
		}else if(command.isCommand(FormCommand.SEARCH03)) {	
			String dest_nod_cd = JSPUtil.getParameter(request, "dest_nod_cd", "");
			String dest_nod_yd = JSPUtil.getParameter(request, "dest_nod_yd", "");
			event.setDest_nod_cd(dest_nod_cd);
			event.setDest_nod_yd(dest_nod_yd);
		}else if(command.isCommand(FormCommand.MULTI)||command.isCommand(FormCommand.REMOVE)) {	
			DoNotificationSettingListVO[] doNotificationSettingListVOs = (new DoNotificationSettingListVO()).fromRequestGrid(request);
			event.setDoNotificationSettingListVOs(doNotificationSettingListVOs);
		}
		request.setAttribute("Event", event);
  	  	return  event;
		
	}
}
		