/*=========================================================
*Copyright(c) 2009 CyberLogitec 
*@FileName : EES_CIM_0065HTMLAction.java
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

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.HashMap;
import com.hanjin.framework.component.util.JSPUtil;

import com.hanjin.framework.component.util.MultipartRequest;
import com.hanjin.framework.component.util.file.FileMetaDataManager;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;



/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.cim.cimcommon.fileupload 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 LongstayingUnclaimEQMgtSC로 실행요청<br>
 * - LongstayingUnclaimEQMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author Sun, CHOI
 * @see EesCim0065Event, EesCim0066Event 참조
 * @since J2EE 1.4
 */
public class EES_CIM_0065HTMLAction extends HTMLActionSupport {

	/**
	 * EES_CIM_0065HTMLAction 객체를 생성
	 */
	public EES_CIM_0065HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EesCim0065Event 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		FormCommand f_cmd = FormCommand.fromRequest(request);
		//log.debug( this.getClass().getName() + " - f_cmd.getCommand() : " + f_cmd.getCommand() );
		EesCim0065Event event = null; 

		switch ( f_cmd.getCommand() ) {
			case FormCommand.SEARCH : 
				event = new EesCim0065Event();
				event.setEventParams(getParams(request));
				
//				event.getEventParams().put("filePath", FileMetaDataManager.getInstance().getFileMetaData(context, "TPB").getWork_dir()); // filePath 추가
//				System.out.println( "CIMUtils.getFileMetaData(request).getWork_dir()======>>>>>>" + CIMUtils.getFileMetaData(request).getWork_dir());				
//				System.out.println(" =====> 0065.[AC1] - (TPB)"+ FileMetaDataManager.getInstance().getFileMetaData(context, "TPB").getWork_dir());	
				event.getEventParams().put("filePath", "/a_upload/FILE/CIM_UC"); // filePath 추가 : FileMetaDataManager에 추가할 필요 없음 - CIM공통으로 파일업로드를 사용하지 않음.
				
				break;
			default :
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

	
	/**
	 * request의 파라미터 값을 HashMap 으로 구한다. 
	 * @param req HttpServletRequest HttpRequest
	 * @return HashMap request parameter 정보를 담고있는  HashMap object
	 */
	@SuppressWarnings("unchecked")
	public static HashMap getParams(HttpServletRequest req)  {
		HashMap params = new HashMap();

		Enumeration e = req.getParameterNames();
		while(e.hasMoreElements()){
			String key = (String)e.nextElement();
			params.put(key, JSPUtil.getParameter(req,key));
		}
		return params;
	}
	
}
