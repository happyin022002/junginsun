/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : EES_CIM_0067HTMLAction.java
*@FileTitle : UC File Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2014.07.04
*@LastModifier : DO-HYUN KIM
*@LastVersion : 1.0
* 2014.07.04
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.event;

import java.util.ArrayList;
import java.io.IOException;
import java.util.Collection;
import java.util.StringTokenizer;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

//import com.hanjin.apps.alps.ees.cim.cimcommon.CIMUtils;
import com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo.vo.CreateUploadFileInfoVO;
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
 * - com.hanjin.apps.alps.ees.cim.longstayingunclaimeqmgt.uncollectedcargo 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 LongstayingUnclaimEQMgtSC로 실행요청<br>
 * - LongstayingUnclaimEQMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author DO-HYUN KIM
 * @see EesCim0065Event, EesCim0067Event 참조
 * @since J2EE 1.4
 */
public class EES_CIM_0067HTMLAction extends HTMLActionSupport {

	/**
	 * EES_CIM_0067HTMLAction 객체를 생성
	 */
	public EES_CIM_0067HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EesCim0067Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand f_cmd = null;
		
		Collection tpb_ttl_file_mgmts = null;
		EesCim0065Event event = null; 		// table value object

		String filePath = null; 			// 파일 저장 경로 (directory)
		
		MultipartRequest multiReq = null; 	// 화일업로드 처리객체
		
		try {
			// 저장경로 가져오기 
//			ModuleMetaData fmd = FileMetaDataManager.getInstance().getFileMetaData(context, "TPB");	//임시
//			System.out.println(" =====> 0067.[AC2]-변경전 - (filePath) : "+fmd);
//			filePath = fmd.getWork_dir();
//			System.out.println(" =====> 0067.[AC2]-변경전 - (filePath) : "+filePath);
			/*
			=====> 0067.[AC2]-변경전 - (filePath) : 
			   id               =TPB
			   desc             =TPB
			   prefix           =
			   work_dir         =/a_upload/FILE/TPB
			   backup_dir       =
			   error_dir        =
			   log_dir          =
			   expired_day      =
			   down_dir_expired_day   =
			   work_dir_expired_day   =-1
			   backup_dir_expired_day =-1
			   error_dir_expired_day  =-1
			   log_dir_expired_day    =-1
			   max_size         =5485760
			   delimiter        =
			   encoding_enable  =false
			   from_encoding    =null
			   to_encoding      =null
			
			 =====> 0067.[AC2]-변경전 - (filePath) : /a_upload/FILE/TPB
			 */
			filePath = "/a_upload/FILE/CIM_UC";	// filePath 추가 : FileMetaDataManager에 추가할 필요 없음 - CIM공통으로 파일업로드를 사용하지 않음.

			/// directory check 
			if ( !FileUtils.fileExists(filePath) ){
				FileUtils.mkdir(filePath);
				log.info(" make directory : " + filePath);
			}
			
			// HttpServletRequest 객체를 받아서 업로드를 처리 ( request, 저장경로, 제한용량, 파일명 );			
//			multiReq = new MultipartRequest(request, filePath, Integer.parseInt(fmd.getMax_size()), new ByTimestampFileRenamePolicy()); 
			multiReq = new MultipartRequest(request, filePath, Integer.parseInt("5485760"), new ByTimestampFileRenamePolicy()); 
			// 파일 input-file 개체명 얻기 
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
				event = new EesCim0065Event(tpb_ttl_file_mgmts);
//				event.setEventParams(CIMUtils.getParams(multiReq));
				event.setEventParams(getParams(multiReq));
				event.setFormCommand(f_cmd);
				break;
			case FormCommand.REMOVE : //----- Delete Button Clicked ------
				event = new EesCim0065Event();
//				event.setEventParams(CIMUtils.getParams(multiReq));
				event.setEventParams(getParams(multiReq));
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
	 * @return Collection (CIM_TTL_FILE_MGMT 묶음)
	 */
	public Collection fromRequestMulti(MultipartRequest multiReq, String filePath) {

		CreateUploadFileInfoVO model	= null;
		Collection models = null; 

		String fileParameterNames = null; 
		
		if ( multiReq != null ) {
			fileParameterNames = multiReq.getParameter("fileParameterNames");
//			log.debug(" fileParameterNames : " + fileParameterNames); 
		
			if ( fileParameterNames != null ) {
			
				models = new ArrayList();
				
				StringTokenizer st = new StringTokenizer(fileParameterNames, "|");
				String temp; 
				int k = 0;
				while ( st!=null && st.hasMoreElements()){
					temp = st.nextToken();
					if ( temp!=null && temp.length()!=0 ) {

//						log.debug(" fileParameterName["+k+"] : " + temp); 
						model = new CreateUploadFileInfoVO();
						model.setFile_lgc_nm( multiReq.getOriginalFileName(temp) ); // real file name
						System.out.println(" =====> 0067.[AC2]02 - (filePath) : "+filePath);
						model.setFile_path_nm( filePath ); // physical path  
						model.setFile_phys_nm( multiReq.getFilesystemName(temp) ); // physical file name ( not has path info )
						System.out.println(" =====> 0067.[AC2]02 - (contentType) : "+ multiReq.getContentType(temp));
						
						models.add(model);
						k++;
					}
				}        
			}
	
		}

		return models;
	}

	
	/**
	 * request의 파리미터 값을 HashMap 으로 구한다. 
	 * @param multiReq MultipartRequest
	 * @return HashMap MultipartRequest parameter 정보를 담고있는  HashMap object
	 */
	@SuppressWarnings("unchecked")
	public static HashMap getParams(MultipartRequest multiReq)  {
		HashMap params = new HashMap();

		Enumeration e = multiReq.getParameterNames();
		while(e.hasMoreElements()){
			String key = (String)e.nextElement();
			params.put(key, multiReq.getParameter(key));
		}
		return params;
	}
	
}
