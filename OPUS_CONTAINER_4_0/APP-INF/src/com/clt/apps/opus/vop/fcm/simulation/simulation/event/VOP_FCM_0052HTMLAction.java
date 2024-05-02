/*=========================================================
*Copyright(c) 2011 CyberLogitec
*@FileName : VOP_FCM_8888HTMLAction.java
*@FileTitle : VOP_FCM_8888HTMLAction
*Open Issues :
*Change history :
*@LastModifyDate : 2011.10.04
*@LastModifier : 유혁
*@LastVersion : 1.0
* 2011.10.04 유혁
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.vop.fcm.simulation.simulation.event;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.vop.fcm.simulation.simulation.vo.FcmBnkCsmPfDtlSimVO;
import com.clt.apps.opus.vop.fcm.simulation.simulation.vo.FcmBnkCsmPfSimVO;
import com.clt.apps.opus.vop.fcm.simulation.simulation.vo.SmlPfSkdVO;
import com.clt.apps.opus.vop.fcm.trendline.trendline.vo.FcmTrndLineVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - VOP_FCM_8888 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 Temp1SC로 실행요청<br>
 * - Temp1SC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Ryu Hyuk
 * @see VSKCommonEvent 참조
 * @since J2EE 1.4
 */

public class VOP_FCM_0052HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * VOP_VSK_0244HTMLAction 객체를 생성
	 */
	public VOP_FCM_0052HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 VSKCommonEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		VopFcm0052Event event = new VopFcm0052Event();

		if(command.isCommand(FormCommand.SEARCH)) {
			  event.setSmlPfSkdVO((SmlPfSkdVO)getVO(request, SmlPfSkdVO.class));
		}else if(command.isCommand(FormCommand.SEARCH01)){
			event.setFcmTrndLineVO((FcmTrndLineVO)getVO(request, FcmTrndLineVO.class));
		}else if(command.isCommand(FormCommand.MULTI)){
			 event.setSmlPfSkdVO((SmlPfSkdVO)getVO(request, SmlPfSkdVO.class));
			 event.setFcmBnkCsmPfSimVO((FcmBnkCsmPfSimVO)getVO(request, FcmBnkCsmPfSimVO.class));
			 //FcmBnkCsmPfSimVO fcmBnkCsmPfSimVO = new FcmBnkCsmPfSimVO();
			 
			 FcmBnkCsmPfDtlSimVO[] dtlVOs =  (FcmBnkCsmPfDtlSimVO[])getVOs(request, FcmBnkCsmPfDtlSimVO.class,"sheet3_");
			 FcmBnkCsmPfDtlSimVO[] dtlVO2s = (FcmBnkCsmPfDtlSimVO[])getVOs(request, FcmBnkCsmPfDtlSimVO.class,"sheet4_");
			 FcmBnkCsmPfDtlSimVO[] dtlVO3s = (FcmBnkCsmPfDtlSimVO[])getVOs(request, FcmBnkCsmPfDtlSimVO.class,"sheet5_");
			 List<List<FcmBnkCsmPfDtlSimVO>> list = new ArrayList<List<FcmBnkCsmPfDtlSimVO>>();
			 if(dtlVOs != null){ 
				 List<FcmBnkCsmPfDtlSimVO> fcmBnkCsmPfDtlSimVOs = Arrays.asList(dtlVOs);
				 list.add(fcmBnkCsmPfDtlSimVOs);
			 }
			 if(dtlVO2s != null){ 
				 List<FcmBnkCsmPfDtlSimVO> fcmBnkCsmPfDtlSimVO2s = Arrays.asList(dtlVO2s);
				 list.add(fcmBnkCsmPfDtlSimVO2s);
			 }
			 if(dtlVO3s != null){ 
				 List<FcmBnkCsmPfDtlSimVO> fcmBnkCsmPfDtlSimVO3s = Arrays.asList(dtlVO3s);
				 list.add(fcmBnkCsmPfDtlSimVO3s);
			 }
			 
			 event.getFcmBnkCsmPfSimVO().setFcmBnkCsmPfDtlSimVOs(list);
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