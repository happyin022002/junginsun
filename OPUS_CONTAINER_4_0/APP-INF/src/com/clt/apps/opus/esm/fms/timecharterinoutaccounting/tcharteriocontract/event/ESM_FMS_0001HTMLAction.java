/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_FMS_0001HTMLAction.java
*@FileTitle : Agreement Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.03.05
*@LastModifier : 정윤태
*@LastVersion : 1.0
* 2009.03.05 정윤태
* 1.0 최초 생성
=========================================================*/
package com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomChtrPtyCfFileVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomChtrPtyFileVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomContractVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomHireVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomIdVslVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomOtrExpnVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.CustomPayTermVO;
import com.clt.apps.opus.esm.fms.timecharterinoutaccounting.tcharteriocontract.vo.TCharterIOContractVO;
import com.clt.framework.component.attachment.file.upload.FileUpload;
import com.clt.framework.component.attachment.file.upload.FileUploadException;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.config.SiteConfigFactory;
import com.clt.framework.core.config.SubSystemConfigFactory;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - OPUS.src.com.clt.apps.opus.esm.fms.timecharterinoutaccounting 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TimeCharterInOutAccountingSC로 실행요청<br>
 * - TimeCharterInOutAccountingSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author JUNGYOONTAE
 * @see EsmFms0001Event 참조
 * @since J2EE 1.5
 */
 
public class ESM_FMS_0001HTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8449596129869893675L;

	/**
	 * ESM_FMS_0001HTMLAction 객체를 생성
	 */
	public ESM_FMS_0001HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TCharterIOContractEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	@SuppressWarnings("unchecked")
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		EsmFms0001Event event = new EsmFms0001Event();	// table value object
		
		//FILE UPLOAD하기
		if(request.getContentType()!=null && request.getContentType().toLowerCase().startsWith(SubSystemConfigFactory.get("COM.CONTENTS.TYPE.MULTIPART").trim())){
			
			try {
				FileUpload fileUpload = new FileUpload(request,SubSystemConfigFactory.get("FMS.MODULE.ID"), SubSystemConfigFactory.get("COM.ENCODING.EUCKR"), event);
				request = fileUpload.getRequest();
				
			} catch(FileUploadException ex) {
				this.log.error("[FileUploadException] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			} catch(Exception ex) {
				this.log.error("[Exception] : "+ex.getMessage());
				throw new HTMLActionException(new ErrorHandler(ex).getMessage());
			}
			
			event.setCpfFileCnt(request.getParameter("cpf_file_cnt"));
			event.setCefFileCnt(request.getParameter("cef_file_cnt"));

			event.setKeys((List<String>)request.getAttribute(SiteConfigFactory.get("COM.FILE.UPLOAD.KEYS")));
        }
		
		/**
         ibSheet 사용시 fromRequestGrid를 사용하는데 
         prefix는 주로 멀티 Sheet 처리시에 사용하게 된다. (  sheet ID 형태의 prefix 구분자 ) 
         String hir_prefix = "hir_"; 
         String pay_prefix = "pay_"; 
         String otr_prefix = "otr_";	
         String vsl_prefix = "vsl_";
         String cpf_prefix = "cpf_";
         String cef_prefix = "cef_";
         
         customContractVO       = (CustomContractVO)getVO(request, CustomContractVO.class);
		 customHireVOs 		    = (CustomHireVO[])getVOs(request, CustomHireVO.class, hir_prefix);
		 customPayTermVOs 	    = (CustomPayTermVO[])getVOs(request, CustomPayTermVO.class, pay_prefix);
		 customOtrExpnVOs 	    = (CustomOtrExpnVO[])getVOs(request, CustomOtrExpnVO.class, otr_prefix);
		 customIdVslVOs 		= (CustomIdVslVO[])getVOs(request, CustomIdVslVO.class, vsl_prefix);
		 customChtrPtyFileVOs   = (CustomChtrPtyFileVO[])getVOs(request, CustomChtrPtyFileVO.class, cpf_prefix);
		 customChtrPtyCfFileVOs = (CustomChtrPtyCfFileVO[])getVOs(request, CustomChtrPtyCfFileVO.class, cef_prefix);
        */ 
    	
		TCharterIOContractVO tCharterIOContractVO = new TCharterIOContractVO();
		
		FormCommand command = FormCommand.fromRequest(request);
        
		String hir_prefix = "hir_";
		String pay_prefix = "pay_";	
		String otr_prefix = "otr_";	
		String vsl_prefix = "vsl_";
		String cpf_prefix = "cpf_";
		String cef_prefix = "cef_";
		
		CustomContractVO 		customContractVO 	   = null;
		CustomHireVO[] 			customHireVOs 	       = null;
		CustomPayTermVO[] 		customPayTermVOs       = null;
		CustomOtrExpnVO[] 		customOtrExpnVOs 	   = null;
		CustomIdVslVO[] 		customIdVslVOs         = null;
		CustomChtrPtyFileVO[] 	customChtrPtyFileVOs   = null;
		CustomChtrPtyCfFileVO[] customChtrPtyCfFileVOs = null;
		
		if(   command.isCommand(FormCommand.SEARCH)
		   || command.isCommand(FormCommand.SEARCH01)
		   || command.isCommand(FormCommand.SEARCH02)
		   || command.isCommand(FormCommand.SEARCH05)
		   || command.isCommand(FormCommand.SEARCH06)
		   || command.isCommand(FormCommand.REMOVE)) {
			event.setFletCtrtNo(request.getParameter("flet_ctrt_no"));
			
		} else if(command.isCommand(FormCommand.SEARCH01)){
			event.setFletCtrtTpCd(request.getParameter("flet_ctrt_tp_cd"));
			//event.setVslCd(request.getParameter("vsl_cd"));
			
		} else if(command.isCommand(FormCommand.SEARCH03)){
			event.setFletCtrtTpCd(request.getParameter("flet_ctrt_tp_cd"));
			event.setCustCntCd(request.getParameter("cust_cnt_cd"));
			event.setCustSeq(request.getParameter("cust_seq"));
			event.setVndrSeq(request.getParameter("vndr_seq"));
			
		} else if(   command.isCommand(FormCommand.MODIFY) 
				  || command.isCommand(FormCommand.MULTI)) {
			
			customContractVO       = (CustomContractVO)getVO(request, CustomContractVO.class);
			customHireVOs 		   = (CustomHireVO[])getVOs(request, CustomHireVO.class, hir_prefix);
			customPayTermVOs 	   = (CustomPayTermVO[])getVOs(request, CustomPayTermVO.class, pay_prefix);
			customOtrExpnVOs 	   = (CustomOtrExpnVO[])getVOs(request, CustomOtrExpnVO.class, otr_prefix);
			customIdVslVOs 		   = (CustomIdVslVO[])getVOs(request, CustomIdVslVO.class, vsl_prefix);
			customChtrPtyFileVOs   = (CustomChtrPtyFileVO[])getVOs(request, CustomChtrPtyFileVO.class, cpf_prefix);
			customChtrPtyCfFileVOs = (CustomChtrPtyCfFileVO[])getVOs(request, CustomChtrPtyCfFileVO.class, cef_prefix);

			tCharterIOContractVO.setCustomContract(customContractVO);
			tCharterIOContractVO.setCustomHires(customHireVOs);
			tCharterIOContractVO.setCustomPayTerms(customPayTermVOs);
			tCharterIOContractVO.setCustomOtrExpns(customOtrExpnVOs);
			tCharterIOContractVO.setCustomIdVsls(customIdVslVOs);
			tCharterIOContractVO.setCustomChtrPtyFiles(customChtrPtyFileVOs);
			tCharterIOContractVO.setCustomChtrPtyCfFiles(customChtrPtyCfFileVOs);
			
			event.setFletCtrtNo(request.getParameter("flet_ctrt_no"));
			
			//MultiPart시 command 를 반드시  event에 재 설정해줘야 함
			//event.setFormCommand(command);
			
			//FILE UPLOAD하기
			//FileUpload fileUpload = new FileUpload(request,SubSystemConfigFactory.get("FMS.MODULE.ID"));
			//MultipartRequest multipartRequest = fileUpload.getMultipartRequest();
	
			//FILE UPLOAD된 KEY값 SETTING하기
			//System.out.println("@@multipartRequest.getKeys()=>"+multipartRequest.getKeys());
			//event.setKeys(multipartRequest.getKeys());
			//event.setKeys((List<String>)multipartRequest.getAttribute("keys"));
			//System.out.println("@@keys=>"+(List<String>)multipartRequest.getAttribute("keys"));

		}
		
		event.setVO("voContract", tCharterIOContractVO);
		
		request.setAttribute("Event", event);

		return event;
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
