/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TES_0025HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : jongbaemoon
*@LastVersion : 1.0
* 2006-10-30 jongbaemoon
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage.carissuetransferslipmanage.vo.CARIssueTransferSlipManageCommonVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.syscommon.common.table.ApInvHdrVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tes.serviceproviderinvoicemanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CARIssueTransferSlipManageSC로 실행요청<br>
 * - CARIssueTransferSlipManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author byungheeyoo
 * @see EsdTes0025Event , ESD_TES_025EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TES_0025HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TES_025HTMLAction 객체를 생성
	 */
	public ESD_TES_0025HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TES_025Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		log.debug("\n#####################################\nESD_TES_0025HTMLAction\n#####################################\n");
		
//		FormCommand f_cmd = FormCommand.fromRequest(request);
		
		EsdTes0025Event event = new EsdTes0025Event(); 
		
		event.setTesTmlSoHdrVO((TesTmlSoHdrVO)getVO(request, TesTmlSoHdrVO.class));
		event.setApInvHdrVO((ApInvHdrVO)getVO(request, ApInvHdrVO.class));
		event.setTesTmlSoHdrVOs((TesTmlSoHdrVO[])getVOs(request, TesTmlSoHdrVO.class, ""));
		event.setCARIssueTransferSlipManageCommonVOs((CARIssueTransferSlipManageCommonVO[])getVOs(request, CARIssueTransferSlipManageCommonVO.class, ""));
		
		
//		Collection tes_tml_so_hdrs = null; 
//		
//		int codeLength = 0;
//        
//		HashMap param_map = new HashMap();
//		String param_name = null;
//		Enumeration enums = request.getParameterNames();
//		while (enums.hasMoreElements()){
//			param_name = (String)enums.nextElement();
//			param_map.put(param_name,request.getParameter(param_name));
//			log.debug("[param_name:" + param_name + "] - value:" + request.getParameter(param_name));
//		}         
//		
//		log.debug("\n------------------------------------------------------------\n");
//		String[] chks = request.getParameterValues("chk");
//		for (int i=0; chks!=null && i<chks.length; i++){
//			log.debug("\n - chks["+i+"]:"+chks[i]);
//		}
//		log.debug("\n - chks.length:"+(chks!=null?chks.length:0)+"\n------------------------------------------------------------\n");
//		
//		codeLength = request.getParameterValues("ibflag")!=null?request.getParameterValues("ibflag").length:0;
//		tes_tml_so_hdrs	= TES_TML_SO_HDR.fromRequest(request,codeLength);
//		log.debug("\n - codeLength:"+codeLength + " / tes_tml_so_hdrs.size:"+(tes_tml_so_hdrs!=null?tes_tml_so_hdrs.size():0)+"\n");
//		
//		event = new EsdTes0025Event(
//				tes_tml_so_hdrs, 
//				param_map,
//				chks
//				);			
//
//		request.setAttribute("Event", event);
		
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