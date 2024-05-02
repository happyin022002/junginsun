/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0095HTMLAction.java
*@FileTitle : Booking Fax & EDI
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.25
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.09.25 전용진
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingsearch.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.CustTpIdVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.BkgEmlEdtVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.emptyreleaseorder.vo.SendMtyRlseOrdVO;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 GeneralBookingConductSC로 실행요청<br>
 * - GeneralBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jun Yong Jin
 * @see GeneralBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0095HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0095HTMLAction 객체를 생성
	 */
	public ESM_BKG_0095HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 GeneralBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0095Event event = new EsmBkg0095Event();
		
		String fileDownPath = "http://"+request.getServerName()+":"+request.getServerPort()+request.getContextPath()+"/FileDownload?key=";
		event.setFileDownPath(fileDownPath);
		
		log.debug("[fileDownloadPath]"+fileDownPath);

		if(command.isCommand(FormCommand.DEFAULT)||command.isCommand(FormCommand.SEARCH)) {
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO .class));
			event.setPolCd(JSPUtil.getParameter(request, "pol_cd"));
			event.setDocType(JSPUtil.getParameter(request, "docType"));
			event.setSignFlag(JSPUtil.getParameter(request, "signFlag"));
			if(command.isCommand(FormCommand.SEARCH)){
				int length = request.getParameterValues("sheet1_ibflag").length;
				event.setBkgBlNoVOs((BkgBlNoVO[])getVOs(request, BkgBlNoVO .class,"sheet1_"));
				event.setNtcKndCd(JSPUtil.getParameter(request, "sheet1_ntc_knd_cd", length));
				event.setFrtTerm(JSPUtil.getParameter(request, "sheet1_frt_term", length));
			}
		} else if(command.isCommand(FormCommand.MULTI01)){
			event.setBkgBlNoVOs((BkgBlNoVO[])getVOs(request, BkgBlNoVO .class,"sheet1_"));
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO .class));
			event.setSendMtyRlseOrdVOs((SendMtyRlseOrdVO[])getVOs(request, SendMtyRlseOrdVO .class,"sheet1_"));
			int length = request.getParameterValues("sheet1_ibflag").length;
			event.setNtcKndCd(JSPUtil.getParameter(request, "sheet1_ntc_knd_cd", length));
			event.setFaxNo(JSPUtil.getParameter(request, "sheet1_fax_no", length));
			event.setRemark(JSPUtil.getParameter(request, "sheet1_remark", length));
			event.setFrtTerm(JSPUtil.getParameter(request, "sheet1_frt_term", length));
			event.setFrtCltFlg(JSPUtil.getParameter(request, "sheet1_frt_clt_flg", length));
			event.setReceiveType(JSPUtil.getParameter(request, "receipt_type"));
			event.setPolCd(JSPUtil.getParameter(request, "pol_cd"));
			event.setDocType(JSPUtil.getParameter(request, "docType"));
			event.setSignFlag(JSPUtil.getParameter(request, "signFlag"));
		} else if(command.isCommand(FormCommand.MULTI02)){
			event.setBkgBlNoVOs((BkgBlNoVO[])getVOs(request, BkgBlNoVO .class,"sheet1_"));
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO .class));
			int length = request.getParameterValues("sheet1_ibflag").length;
			event.setNtcKndCd(JSPUtil.getParameter(request, "sheet1_ntc_knd_cd", length));
			event.setEml(JSPUtil.getParameter(request, "sheet1_eml", length));
			event.setRemark(JSPUtil.getParameter(request, "sheet1_remark", length));
			event.setReceiveType(JSPUtil.getParameter(request, "receipt_type"));
			event.setFrtTerm(JSPUtil.getParameter(request, "sheet1_frt_term", length));
			event.setFrtCltFlg(JSPUtil.getParameter(request, "sheet1_frt_clt_flg", length));
			event.setPolCd(JSPUtil.getParameter(request, "pol_cd"));
			event.setDocType(JSPUtil.getParameter(request, "docType"));
			event.setSignFlag(JSPUtil.getParameter(request, "signFlag"));
			event.setBkgEmlEdtVO((BkgEmlEdtVO)getVO(request, BkgEmlEdtVO.class));
		} else if(command.isCommand(FormCommand.MULTI03)){
			event.setBkgBlNoVOs((BkgBlNoVO[])getVOs(request, BkgBlNoVO .class,"sheet1_"));
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO .class));
			event.setPolCd(JSPUtil.getParameter(request, "pol_cd"));
			event.setDocType(JSPUtil.getParameter(request, "docType"));
			event.setSignFlag(JSPUtil.getParameter(request, "signFlag"));
			event.setSignFlag(JSPUtil.getParameter(request, "signFlag"));
			int length =request.getParameterValues("sheet2_ibflag").length;
			String[] ibflag=request.getParameterValues("sheet2_ibflag");
			String[] slctFlg=request.getParameterValues("sheet2_slct_flg");
			String[] refCode=request.getParameterValues("sheet2_ref_code");
			String[] ediReceiveId=request.getParameterValues("sheet2_edi_receive_id");
			String[] groupEdiId=request.getParameterValues("sheet2_group_edi_id");
			String[] ntcKndCd=request.getParameterValues("sheet2_ntc_knd_cd");
			String[] funcCode=request.getParameterValues("sheet2_func_code");
			CustTpIdVO[] custTpIdVOs = new CustTpIdVO[length];
			String[] ntcKndCds= new String[length];
			for(int i=0;i<ibflag.length;i++){
				if (slctFlg[i].equals("1")){
					CustTpIdVO custTpIdVO = new CustTpIdVO();
					custTpIdVO.setRefCode(refCode[i]);
					custTpIdVO.setRcvId(ediReceiveId[i]);
					custTpIdVO.setGroupId(groupEdiId[i]);
					custTpIdVO.setFuncCode(funcCode[i]);
					custTpIdVOs[i]=custTpIdVO;
					ntcKndCds[i]=ntcKndCd[i];
				}
			}
			event.setCustTpIdVOs(custTpIdVOs);
			event.setNtcKndCd(ntcKndCds);
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