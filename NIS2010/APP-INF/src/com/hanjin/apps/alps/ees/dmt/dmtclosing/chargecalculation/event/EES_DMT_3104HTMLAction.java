/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_DMT_3104HTMLAction.java
*@FileTitle : Exemption Reason Entry
*Open Issues :
*Change history :
*@LastModifyDate : 2009.08.16
*@LastModifier : 황효근
*@LastVersion : 1.0
* 2009.08.16 황효근
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBookingFileListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeDeletionRequstVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeInactivDetailVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeInactivFileVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchDeleteMultiReasonListVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.SearchInactiveCheckVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.framework.component.attachment.file.upload.FileUpload;
import com.hanjin.framework.component.attachment.file.upload.FileUploadException;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.component.util.JSPUtil;
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

public class EES_DMT_3104HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * EES_DMT_3104HTMLAction 객체를 생성
	 */
	public EES_DMT_3104HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DMTClosingEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		

		EesDmt3104Event event = new EesDmt3104Event();
		
		StringBuilder sbFileKeys = new StringBuilder();
		
		//FILE UPLOAD하기
		if (!StringUtils.isEmpty(request.getContentType()) 
				&& request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim()) ) {
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
	        }	

    	FormCommand command = FormCommand.fromRequest(request);
		
		if (command.isCommand(FormCommand.SEARCH01)) {
			event.setSearchDeleteMultiReasonListVO((SearchDeleteMultiReasonListVO)getVO(request, SearchDeleteMultiReasonListVO .class,""));
		} else if (command.isCommand(FormCommand.SEARCH02)) {
			event.setChargeCalculationContainerVO((ChargeCalculationContainerVO)getVO(request, ChargeCalculationContainerVO .class,""));
		}  else if (command.isCommand(FormCommand.SEARCH03)) {
			event.setChargeCalculationContainerVO((ChargeCalculationContainerVO)getVO(request, ChargeCalculationContainerVO .class,""));
		}   else if (command.isCommand(FormCommand.SEARCH10)) {
			event.setChargeInactivDetailVO((ChargeInactivDetailVO)getVO(request, ChargeInactivDetailVO .class,""));
		}  			
		else if (command.isCommand(FormCommand.MULTI)) {
			ChargeInactivDetailVO[] chargeInactivDetailVOs = (ChargeInactivDetailVO[])getVOs(request, ChargeInactivDetailVO.class, "");
			
			ChargeInactivFileVO[] chargeInactivFileVOs = (ChargeInactivFileVO[])getVOs(request, ChargeInactivFileVO.class,"sheet3_");		
			
			// 첨부파일이 존재할 경우
			if (sbFileKeys.length() > 0) {
				for (ChargeInactivDetailVO chgCalcCntrVO : chargeInactivDetailVOs) {
					chgCalcCntrVO.setFileSavId(sbFileKeys.toString());
				}
			}
			
			event.setChargeInactivDetailVOS(chargeInactivDetailVOs);
			event.setChargeInactivFileVOS(chargeInactivFileVOs);
		} 
		else if (command.isCommand(FormCommand.COMMAND01)) {
		
			
			// 첨부파일이 존재할 경우
			if (sbFileKeys.length() > 0) {
				ChargeInactivFileVO chargeInactivFileVO = new ChargeInactivFileVO();
				String[] arrSplitNo = null;

				log.error( "=======sbFileKeys========" + sbFileKeys );

				arrSplitNo = sbFileKeys.toString().split(",");
				chargeInactivFileVO.setFileSavId(arrSplitNo[0]);
	  			log.error( "=======FileListVO========" +chargeInactivFileVO );
				event.setChargeInactivFileVO(chargeInactivFileVO);
				
			}

		}
		else if(command.isCommand(FormCommand.MULTI01)) {
			event.setChargeCalculationContainerVOS((ChargeCalculationContainerVO[])getVOs(request, ChargeCalculationContainerVO .class, ""));
		} else if(command.isCommand(FormCommand.MULTI02)) {
			event.setChargeCalculationContainerVOS((ChargeCalculationContainerVO[])getVOs(request, ChargeCalculationContainerVO .class,""));
		} else if(command.isCommand(FormCommand.SEARCH04)) {
			event.setSearchInactiveCheckVO((SearchInactiveCheckVO)getVO(request, SearchInactiveCheckVO .class));
		} else if(command.isCommand(FormCommand.SEARCH20)) {
			event.setAttribute("sc_no", JSPUtil.getParameter(request, "sc_no"));
		} else if(command.isCommand(FormCommand.SEARCH21)) {
			event.setAttribute("inv_no", JSPUtil.getParameter(request, "inv_no"));
		// SLIKRG 코드에서의 OP_DT 조회를 위해 추가 (2016.08.31 Won Ki Eo)
		}  else if(command.isCommand(FormCommand.SEARCH22)) {
			event.setAttribute("temp_bkg_no", JSPUtil.getParameter(request, "temp_bkg_no"));
			event.setAttribute("temp_cntr_no", JSPUtil.getParameter(request, "temp_cntr_no"));
			event.setAttribute("temp_cntr_cyc_no", JSPUtil.getParameter(request, "temp_cntr_cyc_no"));
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