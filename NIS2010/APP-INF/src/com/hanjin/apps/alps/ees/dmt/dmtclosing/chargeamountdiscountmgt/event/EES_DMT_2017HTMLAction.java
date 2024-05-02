/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_2017HTMLAction.java
*@FileTitle : SZPBB DEM Calculation &amp; Issue
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.13
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.10.13 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ActualCostListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListInputVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingAproItmVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingExptClrRqstVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingFileListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingFullHistoryVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingMasListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingPfmcListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingReasonDescVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingReasonDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterProgressVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerVO;
import com.hanjin.framework.component.attachment.file.upload.FileUpload;
import com.hanjin.framework.component.attachment.file.upload.FileUploadException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.config.SiteConfigFactory;
import com.hanjin.framework.core.config.SubSystemConfigFactory;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.dmt.dmtclosing 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DMTClosingSC로 실행요청<br>
 * - DMTClosingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Hwang HyoKeun
 * @see DMTClosingEvent 참조
 * @since J2EE 1.6
 */

public class EES_DMT_2017HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_DMT_2017HTMLAction 객체를 생성
	 */
	public EES_DMT_2017HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DMTClosingEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		EesDmt2017Event event = new EesDmt2017Event();		

		StringBuilder sbFileKeys = new StringBuilder();		

		this.log.error("FILE UPLOAD -> EES_DMT_2017");
		//FILE UPLOAD하기
		if (!StringUtils.isEmpty(request.getContentType()) 
				&& request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim()) ) {

			this.log.error("FILE UPLOAD -> EES_DMT_2017 START");
			try {
				FileUpload fileUpload = new FileUpload(request, SubSystemConfigFactory.get("DMT.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
				request = fileUpload.getRequest();
				
				@SuppressWarnings("unchecked")
				List<String> keyList = (List<String>) request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS"));
				
				for (String fileKey : keyList) {
					if (sbFileKeys.length() > 0) sbFileKeys.append(",");
					sbFileKeys.append(fileKey);
				}
			} 
			catch(FileUploadException ex) {
				this.log.error("[FileUploadException] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			} 
			catch(Exception ex) {
				this.log.error("[Exception] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			}
			this.log.error("FILE UPLOAD -> EES_DMT_2017 - END");
        }	
		
    	FormCommand command = FormCommand.fromRequest(request);		

		if(command.isCommand(FormCommand.SEARCH01)) {			
			AfterBKGListVO[] afterBKGListVOs = (AfterBKGListVO[]) getVOs(request, AfterBKGListVO.class, "opnSheetObj");			
			event.setAfterBKGListVOs(afterBKGListVOs);
			event.setInputVO((AfterBKGListInputVO)getVO(request, AfterBKGListInputVO .class));
		} else if (command.isCommand(FormCommand.SEARCH03) || command.isCommand(FormCommand.SEARCH04) || command.isCommand(FormCommand.SEARCH06) || command.isCommand(FormCommand.SEARCH08)) {
			event.setInputVO((AfterBKGListInputVO)getVO(request, AfterBKGListInputVO .class));
		} else if (command.isCommand(FormCommand.SEARCH05)) {
			event.setAfterBookingReasonDescVO((AfterBookingReasonDescVO)getVO(request, AfterBookingReasonDescVO .class,""));
		} else if (command.isCommand(FormCommand.SEARCH02)) {
			event.setAfterBookingPfmcListVO((AfterBookingPfmcListVO)getVO(request, AfterBookingPfmcListVO.class,""));
		} else if (command.isCommand(FormCommand.SEARCH07)) {
			event.setChargeBookingContainerVO((ChargeBookingContainerVO)getVO(request, ChargeBookingContainerVO.class,""));
		} else if (command.isCommand(FormCommand.SEARCH09)) {
			event.setAfterBookingMasListVO((AfterBookingMasListVO)getVO(request, AfterBookingMasListVO.class,""));
		} else if (command.isCommand(FormCommand.SEARCH10)) {
			String vvd_cd	= request.getParameter("vvd_cd");
			event.setVvdCd(vvd_cd);
		} else if(command.isCommand(FormCommand.MULTI)) {
			event.setInputVO((AfterBKGListInputVO)getVO(request, AfterBKGListInputVO .class));
			event.setAfterBookingReasonDescVO((AfterBookingReasonDescVO)getVO(request, AfterBookingReasonDescVO .class,"t4sheet1_"));
			
			ActualCostListVO[] actualCostListVOs = (ActualCostListVO[]) getVOs(request, ActualCostListVO.class, "t1sheet2_");
			AfterBookingPfmcListVO[] afterBookingPfmcListVOs = (AfterBookingPfmcListVO[]) getVOs(request, AfterBookingPfmcListVO.class, "t2sheet1_");
			AfterBookingMasListVO[] afterBookingMasListVOs = (AfterBookingMasListVO[]) getVOs(request, AfterBookingMasListVO.class, "t2sheet2_");
			
			AfterBookingFullHistoryVO[] afterBookingFullHistoryVOs = (AfterBookingFullHistoryVO[]) getVOs(request, AfterBookingFullHistoryVO.class, "t3sheet1_");
			AfterBookingReasonDetailVO[] afterBookingReasonDetailVOs = (AfterBookingReasonDetailVO[]) getVOs(request, AfterBookingReasonDetailVO.class, "t4sheet3_");

			AfterBookingExptClrRqstVO[] afterBookingExptClrRqstVOs = (AfterBookingExptClrRqstVO[]) getVOs(request, AfterBookingExptClrRqstVO.class, "t1sheet6_");
			
			AfterBookingFileListVO[] afterBookingFileListVOs = (AfterBookingFileListVO[]) getVOs(request, AfterBookingFileListVO.class, "");
			AfterBookingAproItmVO[] afterBookingAproItmVOs = (AfterBookingAproItmVO[]) getVOs(request, AfterBookingAproItmVO.class, "t5sheet1_");

			event.setAfterProgressVO((AfterProgressVO)getVO(request, AfterProgressVO.class,""));
			
//			// 첨부파일이 존재할 경우
//			if (sbFileKeys.length() > 0) {
//				String[] arrSplitNo = null;
//				int i = 0;
//				arrSplitNo = sbFileKeys.toString().split(",");
//				for (AfterBookingFileListVO afterBookingFileListVO : afterBookingFileListVOs) {
//					if ( "I".equals(afterBookingFileListVO.getIbflag())){
//						afterBookingFileListVO.setFileSavId(arrSplitNo[i]);
//						i++;
//					}
//				}
//			}
						
	        event.setActualCostListVOs(actualCostListVOs);
	        event.setAfterBookingPfmcListVOs(afterBookingPfmcListVOs);
	        event.setAfterBookingMasListVOs(afterBookingMasListVOs);
	        
	        event.setAfterBookingFullHistoryVOs(afterBookingFullHistoryVOs);
	        event.setAfterBookingReasonDetailVOs(afterBookingReasonDetailVOs);
	        event.setAfterBookingFileListVOs(afterBookingFileListVOs);

	        event.setAfterBookingExptClrRqstVOs(afterBookingExptClrRqstVOs);
	        event.setAfterBookingAproItmVOs(afterBookingAproItmVOs);

		} else if(command.isCommand(FormCommand.COMMAND01)) {

			// 첨부파일이 존재할 경우
			if (sbFileKeys.length() > 0) {
				AfterBookingFileListVO afterBookingFileListVO = new AfterBookingFileListVO();
				String[] arrSplitNo = null;
				arrSplitNo = sbFileKeys.toString().split(",");
				afterBookingFileListVO.setFileSavId(arrSplitNo[0]);
				event.setAfterBookingFileListVO(afterBookingFileListVO);
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