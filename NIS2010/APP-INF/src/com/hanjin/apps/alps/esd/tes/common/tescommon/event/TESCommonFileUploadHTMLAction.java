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
package com.hanjin.apps.alps.esd.tes.common.tescommon.event;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.hanjin.framework.component.attachment.file.upload.ByTimestampFileRenamePolicy;
import com.hanjin.framework.component.util.MultipartRequest;
import com.hanjin.framework.component.util.file.FileMetaDataManager;
import com.hanjin.framework.component.util.file.FileMetaDataManagerException;
import com.hanjin.framework.component.util.file.ModuleMetaData;
import com.hanjin.framework.component.util.io.FileUtils;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.TesEdiSoFileVO;
import com.hanjin.syscommon.common.table.TesJbExePerfLogVO;
import com.hanjin.syscommon.common.table.TesTmlSoHdrVO;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.tes.common 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
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
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
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
			event.setTesEdiSoFileVO		((TesEdiSoFileVO)getVO(request, TesEdiSoFileVO .class));
			event.setTesJbExePerfLogVO	((TesJbExePerfLogVO)getVO(request, TesJbExePerfLogVO .class));

			f_cmd = FormCommand.fromRequest(mulreq);
			event.getTesEdiSoFileVO().setSavPathNm(filePath);
			event.getTesEdiSoFileVO().setSavFileNm(fileName);
			event.getTesEdiSoFileVO().setOrgFileNm(fileNameOrg);

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