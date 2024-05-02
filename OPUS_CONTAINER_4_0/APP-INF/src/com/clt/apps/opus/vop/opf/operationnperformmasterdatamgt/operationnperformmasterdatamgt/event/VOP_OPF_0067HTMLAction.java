/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : VOP_OPF_0067HTMLAction.java
*@FileTitle : TPR Target Lanes Register
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.19
*@LastModifier : 김종옥
*@LastVersion : 1.0
* 2009.05.19 김종옥
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt.operationnperformmasterdatamgt.event;

import javax.servlet.http.HttpServletRequest;

import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.MdmVslSvcLaneVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.vop.opf.operationnperformmasterdatamgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OperationNPerformMasterDataMgtSC로 실행요청<br>
 * - OperationNPerformMasterDataMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Kim Jong Ock
 * @see OperationNPerformMasterDataMgtEvent 참조
 * @since J2EE 1.4
 */

public class VOP_OPF_0067HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_OPF_0067HTMLAction 객체를 생성
	 */
	public VOP_OPF_0067HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 OperationNPerformMasterDataMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		
    	FormCommand command = FormCommand.fromRequest(request);
		VopOpf0067Event event = new VopOpf0067Event();
		
		if(command.isCommand(FormCommand.MULTI)) {

			MdmVslSvcLaneVO[] listTo = null; 
			MdmVslSvcLaneVO[] list1 = (MdmVslSvcLaneVO[])getVOs(request, MdmVslSvcLaneVO.class,"sheet1_");
			MdmVslSvcLaneVO[] list2 = (MdmVslSvcLaneVO[])getVOs(request, MdmVslSvcLaneVO.class,"sheet2_");
			
			int size1 = 0;
			if(list1!=null) {
				size1 = list1.length;
			}
//			listTo = new MdmVslSvcLaneVO[(list1 == null ? 0 : list1.length) + (list2 == null ? 0 : list2.length)];
			listTo = new MdmVslSvcLaneVO[size1 + (list2 == null ? 0 : list2.length)];
			   
			int first = 0;
			int second = 0;
			
			for(int cnt=0 ; cnt<listTo.length ; cnt++){
//			    if(list1 != null && cnt < list1.length){
				if(list1 != null && cnt < size1){
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
			
		    event.setMdmVslSvcLaneVOS(listTo);
		}
		else if(command.isCommand(FormCommand.SEARCH)) {			
			event.setMdmVslSvcLaneVO((MdmVslSvcLaneVO)getVO(request, MdmVslSvcLaneVO .class));
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