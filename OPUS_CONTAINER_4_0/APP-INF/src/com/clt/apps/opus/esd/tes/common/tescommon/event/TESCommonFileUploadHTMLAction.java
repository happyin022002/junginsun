/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : TESCommonFileUploadHTMLAction.java
*@FileTitle : TES Common 관리
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-31
*@LastModifier : byungheeyoo
*@LastVersion : 1.0
* 2006-10-31 byungheeyoo
* 1.0 최초 생성
* 2009-03-11: 주석 추가
=========================================================*/
package com.clt.apps.opus.esd.tes.common.tescommon.event;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.clt.framework.component.attachment.file.upload.ByTimestampFileRenamePolicy;
import com.clt.framework.component.util.MultipartRequest;
import com.clt.framework.component.util.file.FileMetaDataManager;
import com.clt.framework.component.util.file.FileMetaDataManagerException;
import com.clt.framework.component.util.file.ModuleMetaData;
import com.clt.framework.component.util.io.FileUtils;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.TesJbExePerfLogVO;
import com.clt.syscommon.common.table.TesTmlSoHdrVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esd.tes.common 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 TESCommonSC로 실행요청<br>
 * - TESCommonSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author byungheeyoo
 * @see TESCommonEvent , TESCommonEventResponse 참조
 * @since J2EE 1.4
 */
public class TESCommonFileUploadHTMLAction extends HTMLActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * TESCommonFileUploadHTMLAction 객체를 생성
	 */
	public TESCommonFileUploadHTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 TESCommonEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request 
	 * @return Event 
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		log.debug("\n\n TESCommonFileUploadHTMLAction - ADD FILE  \n\n\n\n");
		
		ModuleMetaData fmd = null; 
		MultipartRequest mulreq = null;
		FormCommand f_cmd = null;
		String filePath = null;
		String fileName = null;
		String fileNameOrg = null;
		int fileSizeLimit = 0;

		HttpSession 	session	= request.getSession(false);
		ServletContext 	context	= session.getServletContext();

		TESCommonEvent		event		= new TESCommonEvent();
		
		try {
//			2009.12.10 파일 업로드 설정 변경으로 인한 수정
			fmd = FileMetaDataManager.getInstance().getFileMetaData(context, "TES");
			fileSizeLimit = Integer.parseInt(fmd.getMax_size());
//			fileSizeLimit = 1 * 1024 * 1024 ; // 1MB 제한
			filePath = fmd.getWork_dir();
//			filePath = "C:\\Temp\\TES";  // test path
			if (!FileUtils.fileExists(filePath)){
				FileUtils.mkdir(filePath);
			}
			mulreq = new MultipartRequest(request, filePath, fileSizeLimit, new ByTimestampFileRenamePolicy());
			fileName = mulreq.getFilesystemName("uploadfile");
			fileNameOrg = mulreq.getOriginalFileName("uploadfile");
			log.debug("\n ### filePath / fileName / fileNameOrg / fileSizeLimit : "+filePath+" / "+fileName+" / "+fileNameOrg + " / " + fileSizeLimit);

//			2009.12.10 파일 업로드 설정 변경으로 인한 수정
//			List list = new ArrayList();
//			list.add(filePath);
//			list.add(fileName); 
//			RcpShellCall.executeShell(list);
			
			event.setTesTmlSoHdrVO		((TesTmlSoHdrVO)getVO(request, TesTmlSoHdrVO .class));
			event.setTesJbExePerfLogVO	((TesJbExePerfLogVO)getVO(request, TesJbExePerfLogVO .class));

			f_cmd = FormCommand.fromRequest(mulreq);

			event.getTesTmlSoHdrVO().setTmlSoOfcCtyCd( (String)mulreq.getParameter("tml_so_ofc_cty_cd") );
			event.getTesTmlSoHdrVO().setTmlSoSeq((String)mulreq.getParameter("tml_so_seq") );

		} catch (NumberFormatException e) {
			log.error("NumberFormatException : "+e.toString());
             throw new HTMLActionException(e.getMessage());
		} catch (FileMetaDataManagerException e) {
			log.error("FileMetaDataManagerException : "+e.toString());
			throw new HTMLActionException(e.getMessage());
		} catch (IOException e) {
			log.error("IOException : "+e.toString());
			throw new HTMLActionException(e.getMessage());
		}
		

		event.setFormCommand(f_cmd);
		
		request.setAttribute("Event", event);

		return  event;
	}

	/**	
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request 
	 * @param eventResponse 
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request 
	 * @param event 
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}