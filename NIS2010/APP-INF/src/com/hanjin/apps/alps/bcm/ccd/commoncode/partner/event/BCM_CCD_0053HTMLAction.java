package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event;
 
import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorVO;
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
 * - BizCommonSC에서 View(JSP)로 실행결과를 전송하는 EventReponse를 request
 * 
 * @author HA DAE SUNG
 *
 */
public class BCM_CCD_0053HTMLAction extends HTMLActionSupport {
	
	/**
	 * BCM_CCD_0053HTMLAction 객체를 생성 
	 */
	public BCM_CCD_0053HTMLAction() {
		
	}
	
	
	/** 
	 * @see com.hanjin.framework.core.controller.html.HTMLAction#perform(javax.servlet.http.HttpServletRequest)
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand command = FormCommand.fromRequest(request);
		BcmCcd0053Event event = new BcmCcd0053Event();
		
		if(command.isCommand(FormCommand.SEARCH)) {
			String rqst_no		= JSPUtil.getParameter(request, "rqst_no".trim(), "");
			String vndr_nm		= JSPUtil.getParameter(request, "vndr_nm".trim(), "");
			String ofc_cd		= JSPUtil.getParameter(request, "ofc_cd".trim(), "");
			String delt_flg		= JSPUtil.getParameter(request, "delt_flg".trim(), "");
			String rqst_fm_dt	= JSPUtil.getParameter(request, "rqst_fm_dt".trim(), "");
			String rqst_to_dt	= JSPUtil.getParameter(request, "rqst_to_dt".trim(), "");
			int iPage			= JSPUtil.getParameterAsInt(request, "iPage", 1);

			event.setRqstNo(rqst_no);
			event.setVndrNm(vndr_nm);
			event.setOfcCd(ofc_cd);
			event.setDeltFlg(delt_flg);
			event.setRqstFmDt(rqst_fm_dt);
			event.setRqstToDt(rqst_to_dt);
			event.setIPage(iPage);
		} else if(command.isCommand(FormCommand.MULTI01)) {
			event.setMdmVendorVOs((VendorVO[])getVOs(request, VendorVO.class));
		} else if(command.isCommand(FormCommand.MULTI02)) {
			event.setMdmVendorVOs((VendorVO[])getVOs(request, VendorVO.class));
		}
		request.setAttribute("Event", event);
		
		return event;
	}
	
	/** 
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest
	 * @param eventResponse EventResponse 
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}
	
	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest
	 * @param event Event
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}
