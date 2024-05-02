/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TPBFileUploadHTMLAction.java
*@FileTitle : 3자구상 파일업로드 공통팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2009-12-02
*@LastModifier : Sun, CHOI
*@LastVersion : 1.1
* 2009-08-20 O Wan-Ki  1.0 최초생성
* 2009-12-02 Sun, CHOI 1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.fileupload.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.tpb.common.TPBUtils;
import com.hanjin.framework.component.util.file.FileMetaDataManager;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.tpb.common.fileupload 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TPBFileUploadSC로 실행요청<br>
 * - TPBFileUploadSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Sun, CHOI
 * @see TPBFileUploadEvent , TPBFileUploadEventResponse 참조
 * @since J2EE 1.4
 */
public class TPBFileUploadHTMLAction extends HTMLActionSupport {

	/**
	 * TPBFileUploadHTMLAction 객체를 생성
	 */
	public TPBFileUploadHTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TPBFileUploadEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		///----- -----
		FormCommand f_cmd = FormCommand.fromRequest(request);
		//log.debug( this.getClass().getName() + " - f_cmd.getCommand() : " + f_cmd.getCommand() );
		///----- -----
		/// Collection tpb_ttl_file_mgmts = null;
		TPBFileUploadEvent event = null; 

		///----- -----
		switch ( f_cmd.getCommand() ) {
			case FormCommand.SEARCH : //----- Delete Button Clicked ------
				event = new TPBFileUploadEvent();
				event.setEventParams(TPBUtils.getParams(request));
//				log.debug( "FileMetaDataManager.getInstance().getFileMetaData(getWork_dir()======>>>>>>" + FileMetaDataManager.getInstance().getFileMetaData(context, "TPB").getWork_dir());
//				log.debug( "TPBUtils.getFileMetaData(request).getWork_dir()======>>>>>>" + TPBUtils.getFileMetaData(request).getWork_dir());
				event.getEventParams().put("filePath", FileMetaDataManager.getInstance().getFileMetaData(context, "TPB").getWork_dir()); /// filePath 추가 
//				event.getEventParams().put("filePath", TPBUtils.getFileMetaData(request).getWork_dir()); /// filePath 추가 
//				log.debug( "FormCommand.SEARCH==============================>>>>>>>>>>>>>>>>>222222");
//					
//				event.getTPBEdiSoFileVO().setSavPathNm(filePath);
//				event.getTPBEdiSoFileVO().setSavFileNm(fileName);
				
				break;
//				case FormCommand.MODIFY01 : //----- Save FileNo For Invoice No. ------
//				event = new TPBFileUploadEvent();
//				event.setEventParams(TPBUtils.getParams(request));
//				break;
			default : //----- default ------
				break; 
		}
	
//		event.setFormCommand(f_cmd);
		request.setAttribute("Event", event);

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
