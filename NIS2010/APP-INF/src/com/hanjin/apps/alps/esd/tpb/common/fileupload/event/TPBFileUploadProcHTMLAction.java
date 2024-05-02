/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TPBFileUploadHTMLAction.java
*@FileTitle : 3자구상 파일업로드 공통팝업
*Open Issues :
*Change history :
*@LastModifyDate : 2009-12-02
*@LastModifier : Sun, CHOI
*@LastVersion : 1.1
* 2009-08-20 O Wan-Ki  1.0 최초 생성
* 2009-12-02 Sun, CHOI 1.1 ALPS Migration
=========================================================*/
package com.hanjin.apps.alps.esd.tpb.common.fileupload.event;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.StringTokenizer;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.tpb.common.TPBUtils;
import com.hanjin.apps.alps.esd.tpb.common.fileupload.vo.CreateUploadFileInfoVO;
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
public class TPBFileUploadProcHTMLAction extends HTMLActionSupport {

	/**
	 * TPBFileUploadHTMLAction 객체를 생성
	 */
	public TPBFileUploadProcHTMLAction() {
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
		FormCommand f_cmd = null;
		
		///----- -----
		Collection tpb_ttl_file_mgmts = null;
		TPBFileUploadEvent event = null; //new TPBFileUploadEvent(tpb_ttl_file_mgmt); // table value object

		///----- -----
		String filePath = null; // 파일 저장 경로 (directory)
		//String fileParameterNames = null; // 파일 input-file 개체명 문자열 ('|'구분자)
		
		MultipartRequest multiReq = null; // 화일업로드 처리객체
//		int fileSizeLimit = 0;
		
		try {
			// 저장경로 가져오기 
//			FileMetaData fmd = TPBUtils.getFileMetaData(request); // parsing file-description.xml 
			ModuleMetaData fmd = FileMetaDataManager.getInstance().getFileMetaData(context, "TPB");
//			fileSizeLimit = Integer.parseInt(fmd.getMax_size());
			filePath = fmd.getWork_dir();
//			log.debug( "filePath_fmd.getWork_dir()=====================>>>>>>>>>>>>>>>>>"+filePath);
//			filePath = "D:\\Temp\\TPB";  // test path
//			log.debug( "filePath=====================>>>>>>>>>>>>>>>>>"+filePath);

			/// directory check 
			if ( !FileUtils.fileExists(filePath) ){
				FileUtils.mkdir(filePath);
				log.info(" make directory : " + filePath);
			}
			
			// HttpServletRequest 객체를 받아서 업로드를 처리 ( request, 저장경로, 제한용량, 파일명 );			
			multiReq = new MultipartRequest(request, filePath, Integer.parseInt(fmd.getMax_size()), new ByTimestampFileRenamePolicy()); 
//			multiReq = new MultipartRequest(request, filePath, fileSizeLimit, new ByTimestampFileRenamePolicy());
//			String fileName = multiReq.getFilesystemName("TPB");
//			String fileNameOrg = multiReq.getOriginalFileName("TPB");
//			log.debug( "fileName=====================>>>>>>>>>>>>>>>>>"+fileName);
//			log.debug( "fileNameOrg=====================>>>>>>>>>>>>>>>>>"+fileNameOrg);
			// 파일 input-file 개체명 얻기 
//			fileParameterNames = multiReq.getParameter("fileParameterNames");
			///----- -----
			f_cmd = FormCommand.fromRequest(multiReq);
			
			// 게시판 첨부파일 Collection 생성
			tpb_ttl_file_mgmts = fromRequestMulti(multiReq, filePath);

			//리로드 방지 - 이 경우 필요없음 
			//processTransactonToken(request, multiReq);
			
		} catch (NumberFormatException e) {
            throw new HTMLActionException(e.getMessage());
		} catch (FileMetaDataManagerException e) {
            throw new HTMLActionException(e.getMessage());
		} catch (IOException e) {
            throw new HTMLActionException(e.getMessage());
		} 

		///----- -----
		switch ( f_cmd.getCommand() ) {
			case FormCommand.ADD : //----- Save Button Clicked ------
				event = new TPBFileUploadEvent(tpb_ttl_file_mgmts);
				event.setEventParams(TPBUtils.getParams(multiReq));
				event.setFormCommand(f_cmd);
				break;
			case FormCommand.REMOVE : //----- Delete Button Clicked ------
				event = new TPBFileUploadEvent();
				event.setEventParams(TPBUtils.getParams(multiReq));
				event.setFormCommand(f_cmd);
				break;
			default : //----- default ------
				break; 
		}
		
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

	/** MultipartRequest를 이용한 파일정보 
	 * @param multiReq
	 * @param filePath 
	 * @return Collection (TPB_TTL_FILE_MGMT 묶음)
	 */
	public Collection fromRequestMulti(MultipartRequest multiReq, String filePath) {

		CreateUploadFileInfoVO model	= null;
		Collection models = null; 

		String fileParameterNames = null; 
		
		if ( multiReq != null ) {
			fileParameterNames = multiReq.getParameter("fileParameterNames");
			log.debug(" fileParameterNames : " + fileParameterNames); 
		
			if ( fileParameterNames != null ) {
			
				models = new ArrayList();
				
				StringTokenizer st = new StringTokenizer(fileParameterNames, "|");
				String temp; 
				int k = 0;
				while ( st!=null && st.hasMoreElements()){
					temp = st.nextToken();
					if ( temp!=null && temp.length()!=0 ) {

						log.debug(" fileParameterName["+k+"] : " + temp); 
						model = new CreateUploadFileInfoVO();
						model.setFile_lgc_nm( multiReq.getOriginalFileName(temp) ); // real file name
						model.setFile_path_nm( filePath ); // physical path  
						model.setFile_phys_nm( multiReq.getFilesystemName(temp) ); // physical file name ( not has path info )
						// model.setFile_sz_capa(multiReq.); // file size
						log.debug( "contentType : " + multiReq.getContentType(temp));
						
//						executeShellCopy(filePath, multiReq.getFilesystemName(temp)); // File Copy for Clustering
//						List list = new ArrayList();
//						models.add( filePath ); // 1st, Directory Path Information // "/sitewlst/DocUp/ENIS/SC"
//						models.add( multiReq.getFilesystemName(temp) ); // 2nd, Physical File Name Information // "SC_Import_templet_v9.0.xls" 
						
						models.add(model);
						k++;
					}
				}        
			}
	
		}

		return models;
	}

	/** Clustering 환경을 위한 파일복제 Shell 호출  
	 * @param dirPath String - Directory Path Information
	 * @param physFileNm String - Physical File Name Information
	 * @return 
	 */
//	private void executeShellCopy(String dirPath, String physFileNm){
//		
//		if ( dirPath!=null && physFileNm!=null){
//			
//			List list = new ArrayList();
//	
//			list.add( dirPath ); // 1st, Directory Path Information // "/sitewlst/DocUp/ENIS/SC"
//			list.add( physFileNm ); // 2nd, Physical File Name Information // "SC_Import_templet_v9.0.xls" 
//
//			log.info( "File copied for Clustering. : " + dirPath + "/" + physFileNm);
//			RcpShellCall.executeShell(list); // execute filecopy shell command 
//			
//		}
//	}
}
