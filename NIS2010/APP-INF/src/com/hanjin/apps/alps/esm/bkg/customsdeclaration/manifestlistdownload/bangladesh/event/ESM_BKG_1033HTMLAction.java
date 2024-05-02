/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1033HTMLAction.java
*@FileTitle : Bangladesh Cargo Manifest
*Open Issues :
*Change history :
*@LastModifyDate : 2009.10.06
*@LastModifier : 전창현
*@LastVersion : 1.0
* 2009.10.06 전창현
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListCondVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListInboundVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestListOutboundVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.bangladesh.vo.BangladeshManifestModificationVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.customstransmission.bangladesh.vo.BangladeshManifestTransmitVO;
import com.hanjin.apps.alps.esm.bkg.customsdeclaration.manifestlistdownload.vo.ManifestListCondVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 *  HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.customsdeclaration 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing
 * - Parsing 한 정보를 Event로 변환, request에 담아 CustomsDeclarationSC로 실행요청
 * - CustomsDeclarationSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅
 * 
 * @author 전창현
 * @see CustomsDeclarationEvent 참조
 * @since J2EE 1.4
 */
public class ESM_BKG_1033HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 2792293631096541043L;
    /**
     * ESM_BKG_0152HTMLAction 객체를 생성
     */
	public ESM_BKG_1033HTMLAction() {}

    /**
     * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
     * HttpRequst의 정보를 manifestlistdownloadEvent로 파싱하여 request에 셋팅<br>
     * @param request HttpServletRequest HttpRequest
     * @return Event Event interface를 구현한 객체
     * @exception HTMLActionException
     */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
		// FormCommand 처리
		FormCommand command = FormCommand.fromRequest(request);
		// EVENT 생성
		EsmBkg1033Event event = new EsmBkg1033Event();

		// 조회의 경우 처리 (SEARCH01 ~ SEARCH04 에 대해서 공통으로 사용)
		event.setManifestListCondVO((ManifestListCondVO)getVO(request, BangladeshManifestListCondVO.class));
		
		// COMMAND 구분에 따른 처리
		if(command.isCommand(FormCommand.MULTI)) 
    	{
			BangladeshManifestModificationVO modiVO = new BangladeshManifestModificationVO();
			modiVO.setIoFlag(request.getParameter("io_flag"));
			
			if(request.getParameter("io_flag").equals("I")){
				BangladeshManifestListInboundVO[] inboundVOs = (BangladeshManifestListInboundVO[])getVOs(request, BangladeshManifestListInboundVO.class);
				modiVO.setBangladeshManifestListInboundVOs(inboundVOs);
			}else{
				BangladeshManifestListOutboundVO[] outboundVOs = (BangladeshManifestListOutboundVO[])getVOs(request, BangladeshManifestListOutboundVO.class);
				modiVO.setBangladeshManifestListOutboundVOs(outboundVOs);
			}
			
			event.setManifestModificationVO(modiVO);
			
    	}
		if(command.isCommand(FormCommand.MULTI01))  
		{ 	
			//manifestListCondVOs = (SrilankaManifestTransmitVO[])getVOs(request, SrilankaManifestTransmitVO.class,"sheet1_");
			 
			event.setBangladeshManifestTransmitVOs((BangladeshManifestTransmitVO[])getVOs(request, BangladeshManifestTransmitVO.class,"sheet1"));
			//event.setSrilankaManifestTransmitVOS(manifestListCondVOs);
		}  
		
		// 응답결과에 event 할당
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
	public void doEnd(HttpServletRequest request, EventResponse eventResponse) 
	{
		request.setAttribute("EventResponse", eventResponse);
	}

	/**
	 * HttpRequest의 attribute에 HttpRequest 파싱 수행결과 값 저장<br>
	 * HttpRequest 파싱 수행결과 값 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @param event Event interface를 구현한 객체
	 */
	public void doEnd(HttpServletRequest request, Event event) 
	{
		request.setAttribute("Event", event);
	}

}
