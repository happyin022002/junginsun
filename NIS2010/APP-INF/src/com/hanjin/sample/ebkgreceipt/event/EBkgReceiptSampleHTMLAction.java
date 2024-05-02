/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : CodeHTMLAction.java
*@FileTitle : Common code inquiry sample HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.25
*@LastModifier : Seungyol Lee
*@LastVersion : 1.0
* 2009.05.25 Seungyol Lee
* 1.0 최초 생성
=========================================================*/
package com.hanjin.sample.ebkgreceipt.event;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.openjpa.lib.util.Files;

import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event.EsmBkgEBkgReceiptEvent;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLAction;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * Common code inquiry sample HTMLAction class
 * Inquiry common code list
 *
 * @author Seungyol Lee
 * @see 
 * @since J2EE 1.4
 */
public class EBkgReceiptSampleHTMLAction extends HTMLActionSupport implements HTMLAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 864687597860455947L;

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CodeEvent 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		EsmBkgEBkgReceiptEvent event = new EsmBkgEBkgReceiptEvent();
		FormCommand command = FormCommand.fromRequest(request);
		if (command.isCommand(FormCommand.SEARCH)){
			try {
				event.setRcvMsg(FileUtils.readFileToString(new File("C:\\alps_workspace\\NIS2010\\APP-INF\\src\\com\\hanjin\\sample\\ebkgreceipt\\msg\\message.txt")));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else if (command.isCommand(FormCommand.MULTI)){
			InputStream bis = null;
	    	byte[] byteArray = null;
	    	try {
				bis = new BufferedInputStream(new FileInputStream("C:/alps_workspace/NIS2010/APP-INF/src/com/hanjin/sample/ebkgreceipt/xls/SZP700488700.xlsx"));
				byteArray = new byte[bis.available()]; 
				bis.read(byteArray);
				event.setRcvXls(new ByteArrayInputStream(byteArray));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
