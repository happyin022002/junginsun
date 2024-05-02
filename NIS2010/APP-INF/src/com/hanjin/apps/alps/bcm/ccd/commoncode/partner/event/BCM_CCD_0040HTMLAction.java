/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : BCM_CCD_0040HTMLAction.java
*@FileTitle : credit customer
*Open Issues : 
*Change history :
*@LastModifyDate : 2011.03.06
*@LastModifier : SEO MI JIN
*@LastVersion : 1.0
* 2011.02.15 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.bcm.ccd.commoncode.partner.event;
 
import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.bcm.ccd.commoncode.mstmgmt.vo.MdmDatProcVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorClassificationVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorContactVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorGroupVO;
import com.hanjin.apps.alps.bcm.ccd.commoncode.partner.vo.VendorVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.bcm.ccd.commoncode 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 commoncodeSC로 실행요청<br>
 * - commoncodeSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author 
 * @see commoncodeEvent 참조
 * @since J2EE 1.6
 */

public class BCM_CCD_0040HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * BCM_CCD_0040HTMLAction 객체를 생성
	 */
	public BCM_CCD_0040HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 commoncodeEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		BcmCcd0040Event event = new BcmCcd0040Event();
		
		if(command.isCommand(FormCommand.SEARCH01)) {
			event.setVndrSeq(request.getParameter("vndr_seq"));
			event.setVndrCntCd(request.getParameter("vndr_cnt_cd"));
		}else if(command.isCommand(FormCommand.MULTI)) {
			VendorGroupVO vendorGroupVO = new VendorGroupVO();
			vendorGroupVO.setVendorVO((VendorVO)getVO(request, VendorVO.class));
			vendorGroupVO.setVendorPhnContactVOs((VendorContactVO[])getVOs(request, VendorContactVO.class, "sheet1_1_"));
			vendorGroupVO.setVendorEmailContactVOs((VendorContactVO[])getVOs(request, VendorContactVO.class, "sheet1_2_"));
			vendorGroupVO.setVendorClassificationVOs((VendorClassificationVO[])getVOs(request, VendorClassificationVO.class, "sheet2_"));
			
			VendorContactVO[] vendorContactVOs = vendorGroupVO.getVendorContactVOs();
			VendorClassificationVO[] vendorClassificationVOs = vendorGroupVO.getVendorClassificationVOs();

			vendorGroupVO.setVendorContactVOs(vendorContactVOs);
			vendorGroupVO.setVendorClassificationVOs(vendorClassificationVOs);
			
			event.setVendorGroupVO(vendorGroupVO);
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			event.setCheckCd(request.getParameter("check_cd"));
		}else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setCheckCd(request.getParameter("check_cd"));
		}else if(command.isCommand(FormCommand.SEARCH05)) {
			event.setCheckCd(request.getParameter("check_cd"));
		}else if(command.isCommand(FormCommand.SEARCH06)) {
			event.setCheckCd(request.getParameter("check_cd"));
		}else if(command.isCommand(FormCommand.SEARCH07)) {
			event.setCheckCd(request.getParameter("check_cd"));
		}else if(command.isCommand(FormCommand.MULTI01)) {
			VendorGroupVO vendorGroupVO = new VendorGroupVO();
			vendorGroupVO.setVendorVO((VendorVO)getVO(request, VendorVO.class));
			vendorGroupVO.setVendorPhnContactVOs((VendorContactVO[])getVOs(request, VendorContactVO.class, "sheet1_1_"));
			vendorGroupVO.setVendorEmailContactVOs((VendorContactVO[])getVOs(request, VendorContactVO.class, "sheet1_2_"));
			vendorGroupVO.setVendorClassificationVOs((VendorClassificationVO[])getVOs(request, VendorClassificationVO.class, "sheet2_"));
			
			VendorContactVO[] vendorContactVOs = vendorGroupVO.getVendorContactVOs();
			VendorClassificationVO[] vendorClassificationVOs = vendorGroupVO.getVendorClassificationVOs();

			vendorGroupVO.setVendorContactVOs(vendorContactVOs);
			vendorGroupVO.setVendorClassificationVOs(vendorClassificationVOs);
			
			event.setMdmDatProcVO((MdmDatProcVO)getVO(request, MdmDatProcVO .class,""));
			event.setVendorGroupVO(vendorGroupVO);
		}else if(command.isCommand(FormCommand.MULTI03)) {
			event.setRqstNo(request.getParameter("rqst_no"));
		}else if(command.isCommand(FormCommand.SEARCH08)) {
			event.setRqstNo(request.getParameter("rqst_no"));
			event.setVndrCntCd(request.getParameter("vndr_cnt_cd"));
			event.setCheckCd(request.getParameter("check_cd"));
		}else if(command.isCommand(FormCommand.SEARCH09)) {
			event.setCheckDeCntCd(request.getParameter("check_de_cnt_cd"));
			event.setCheckCd(request.getParameter("check_cd"));
		}else if(command.isCommand(FormCommand.SEARCH10)) {
			event.setCheckCd(request.getParameter("check_cd"));
			event.setVndrSeq(request.getParameter("vndr_seq"));
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