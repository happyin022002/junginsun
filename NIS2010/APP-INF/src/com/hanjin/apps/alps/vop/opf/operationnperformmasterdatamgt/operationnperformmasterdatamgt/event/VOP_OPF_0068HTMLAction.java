/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0068HTMLAction.java
*@FileTitle : TPR Target Ports Register
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 장석현
*@LastVersion : 1.0
* 2009.05.19 장석현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

import com.hanjin.syscommon.common.table.MdmLocationVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.vop.opf.operationnperformmasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OperationNPerformMasterDataMgtSC로 실행요청<br>
 * - OperationNPerformMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jang Suk Hyun
 * @see OperationNPerformMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class VOP_OPF_0068HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_OPF_0068HTMLAction 객체를 생성
	 */
	public VOP_OPF_0068HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 OperationNPerformMasterDataMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopOpf0068Event event = new VopOpf0068Event();
		if(command.isCommand(FormCommand.MULTI)) {
			MdmLocationVO[] listTo = null; 
			MdmLocationVO[] list1 = (MdmLocationVO[])getVOs(request, MdmLocationVO.class,"sheet1_");
			MdmLocationVO[] list2 = (MdmLocationVO[])getVOs(request, MdmLocationVO.class,"sheet2_");
			
			listTo = new MdmLocationVO[(list1 == null ? 0 : list1.length) + (list2 == null ? 0 : list2.length)];
			
			int first = 0;
			int second = 0;
			for(int cnt = 0; cnt < listTo.length; cnt++){
				if(list1 != null && cnt < list1.length){
					listTo[cnt] = list1[first];
					++first;
				}else if(list1 != null && cnt >= listTo.length){
					listTo[cnt] = list2[second];
					++second;
				}else if(list2 != null){
					listTo[cnt] = list2[second];
					++second;
				}
			}
			
			event.setMdmLocationVOS(listTo);
			/*
			event.setMdmLocationVOS((MdmLocationVO[])getVOs(request, MdmLocationVO.class,"sheet1_"));
			event.setMdmLocationVOS((MdmLocationVO[])getVOs(request, MdmLocationVO.class,"sheet2_"));
			*/
		}
		else if(command.isCommand(FormCommand.SEARCH)) {
			event.setMdmLocationVO((MdmLocationVO)getVO(request, MdmLocationVO.class));
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