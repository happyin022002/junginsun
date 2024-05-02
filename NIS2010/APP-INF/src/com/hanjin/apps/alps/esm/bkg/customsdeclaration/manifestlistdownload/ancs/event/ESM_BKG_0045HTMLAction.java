/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : ESM_BKG_0045HTMLAction.java
 *@FileTitle : AncsManifestListDownload
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2009.05.20
 *@LastModifier : 정재엽
 *@LastVersion : 1.0
 * 2009.05.20 정재엽
 * 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlNtfyVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsBlVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsCstmsCntrVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.ancs.vo.AncsManifestTransmitVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgCstmsAnrCmdtVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 
 *   Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청<br>
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * 
 * @author jae yoeb jeong
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0045HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;

	/**
	 * ESM_BKG_0045HTMLAction 객체를 생성
	 */
	public ESM_BKG_0045HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 CustomsDeclarationEvent로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request 
	 *            HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */ 
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);

		EsmBkg0045Event event = new EsmBkg0045Event();

		if (command.isCommand(FormCommand.SEARCH)) {
			
			event.setAncsCstmsBlCondVO((AncsCstmsBlCondVO)getVO(request, AncsCstmsBlCondVO.class) );  
		} else if(command.isCommand(FormCommand.MULTI)) {
			
			event.setAncsCstmsBlVOs    ( (AncsCstmsBlVO[] )getVOs( request, AncsCstmsBlVO.class , "sheet1_" ));
			event.setAncsCstmsBlNtfyVOs( (AncsCstmsBlNtfyVO[])getVOs( request, AncsCstmsBlNtfyVO.class, "sheet1_" ));
			event.setAncsCstmsCntrVOs  ( (AncsCstmsCntrVO[])getVOs(request, AncsCstmsCntrVO.class, "sheet2_" ));
			event.setBkgCstmsAnrCmdtVOs( (BkgCstmsAnrCmdtVO[])getVOs(request, BkgCstmsAnrCmdtVO.class, "sheet3_" ));
			
		} else if (command.isCommand(FormCommand.MULTI01)){
			
			event.setAncsManifestModificationVO( (AncsManifestModificationVO)getVO(request, AncsManifestModificationVO.class) );  
		
		} else if (command.isCommand(FormCommand.MULTI02)) {

			event.setAncsManifestTransmitVOs( (AncsManifestTransmitVO[])getVOs(request, AncsManifestTransmitVO.class, "sheet1_") );  
			
		}
		
		request.setAttribute("Event", event);
		return event;
	}

	/**
	 * HttpRequest의 attribute에 업무시나리오 수행결과 값 저장<br>
	 * ServiceCommand에서 View(JSP)로 실행결과를 전송하는 ResultSet을 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param eventResponse
	 *            EventResponse interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) {
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request
	 *            HttpServletRequest HttpRequest
	 * @param event
	 *            Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) {
		request.setAttribute("Event", event);
	}

}