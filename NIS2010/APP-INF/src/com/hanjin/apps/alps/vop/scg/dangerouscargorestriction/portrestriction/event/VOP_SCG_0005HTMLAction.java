/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_SCG_0005HTMLAction.java
*@FileTitle : DG Restriction by Port (Creation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.26
*@LastModifier : 장강철
*@LastVersion : 1.0
* 2009.05.26 장강철
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.PortRestrictonOptionVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.SearchScgImdgPortRstrDtlVO;
import com.hanjin.apps.alps.vop.scg.dangerouscargorestriction.portrestriction.vo.VopScg004ContainVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.vop.scg.dangerouscargorestriction 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 DangerousCargoRestrictionSC로 실행요청<br>
 * - DangerousCargoRestrictionSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author jang kang cheol
 * @see DangerousCargoRestrictionEvent 참조
 * @since J2EE 1.6
 */

public class VOP_SCG_0005HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_SCG_0005HTMLAction 객체를 생성
	 */
	public VOP_SCG_0005HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 DangerousCargoRestrictionEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopScg0005Event event = new VopScg0005Event();
		
		/**
		 * Retrieve Button 처리 
		 */		
		if(command.isCommand(FormCommand.SEARCH01 )) {
 
			
			VopScg004ContainVO vopScg004ContainVO = new VopScg004ContainVO();
			vopScg004ContainVO.setCondition(  (PortRestrictonOptionVO)getVO(request, PortRestrictonOptionVO .class ));
			event.setAttribute("optClass", request.getParameter("optClass"));
			event.setVopScg004ContainVO( vopScg004ContainVO  );
			
		}		
		/**
		 * Save Button 처리 
		 */		
		if(command.isCommand(FormCommand.MULTI01)) {
			 
			VopScg004ContainVO vopScg004ContainVO = new VopScg004ContainVO();
			vopScg004ContainVO.setCondition(                    (PortRestrictonOptionVO)getVO(request, PortRestrictonOptionVO .class ));			
			vopScg004ContainVO.setProhscgImdgPortRstrVOs(       (PortRestrictionVO[])getVOs(request, PortRestrictionVO .class,         "sheet1_"));
			vopScg004ContainVO.setCompetScgImdgPortRstrDtlVOs(  (SearchScgImdgPortRstrDtlVO[])getVOs( request, SearchScgImdgPortRstrDtlVO .class,  "sheet2_"));
			vopScg004ContainVO.setQuantiScgImdgPortRstrDtlVOs(  (SearchScgImdgPortRstrDtlVO[])getVOs( request, SearchScgImdgPortRstrDtlVO .class,  "sheet3_"));
			vopScg004ContainVO.setExplanScgImdgPortRstrDtlVOs(  (SearchScgImdgPortRstrDtlVO[])getVOs( request, SearchScgImdgPortRstrDtlVO .class,  "sheet4_"));
			vopScg004ContainVO.setDirectLosdScgImdgPortRstrVOs( (PortRestrictionVO[])getVOs   ( request, PortRestrictionVO    .class,  "sheet5_"));
			vopScg004ContainVO.setRstrRmk( request.getParameter("rstr_rmk")==null?"":request.getParameter("rstr_rmk") );
			event.setVopScg004ContainVO( vopScg004ContainVO  );
 
		}
		/**
		 * Delete  Button 처리
		 */			
		if(command.isCommand(FormCommand.REMOVE)) {
			VopScg004ContainVO vopScg004ContainVO = new VopScg004ContainVO();
			vopScg004ContainVO.setCondition( (PortRestrictonOptionVO)getVO(request, PortRestrictonOptionVO .class ));			
			event.setVopScg004ContainVO( vopScg004ContainVO  );
		}
		/**
		 * port_cd로 조회 
		 */
		if(command.isCommand(FormCommand.SEARCH02)) {
			event.setAttribute("port_cd", request.getParameter("port_cd") );
		}
 	
		/**
		 * Un No 조회
		 */
		if(command.isCommand(FormCommand.SEARCH03)) {
			event.setAttribute("imdg_un_no", request.getParameter("imdg_un_no") );
			event.setAttribute("imdg_un_no_seq", request.getParameter("imdg_un_no_seq") );			
			
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
}