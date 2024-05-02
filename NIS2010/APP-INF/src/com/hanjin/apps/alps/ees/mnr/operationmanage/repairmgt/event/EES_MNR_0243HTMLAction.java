/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : EES_MNR_0243HTMLAction.java
*@FileTitle : EDI & Excel Estimate Upload
*Open Issues :
*Change history :
*@LastModifyDate : 2010.08.19
*@LastModifier : 장준우
*@LastVersion : 1.0
* 2010.08.19 장준우
* 1.0 Creation
--------------------------------------------------------
* History
* 2011.12.12 김상수 [CHM-201115107-01] MNR Repair SPP Upload 기능 Verify Result 기능 강화
*                                      - Excel Upload 직후 MST에서 EQ No 존재유무 확인 로직 추가
*                                      - Error 발생시 사용자 메세지 팝업창 수정
*                                      - Confirm시 Fail일때, 원인내용 표기
* 2012.06.26 신혜정 [CHM-201218436] Estimate Creation > EDI Upload 에 [Calculation] 기능 추가
*                                   - EQ No로 EQ Type, TP/SZ 조회, EDI ID, EQ Type로 Service Provider 정보 조회                                     
=========================================================*/
package com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.ees.mnr.mnrcommon.generalcodecheckmgt.vo.CustomMnrDatVrfyVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstDtlVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.CustomMnrRprRqstHdrVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateGRPVO;
import com.hanjin.apps.alps.ees.mnr.operationmanage.repairmgt.vo.EstimateUploadVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.ees.mnr.operationmanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 OperationManageSC로 실행요청<br>
 * - OperationManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jang Jun-Woo
 * @see EesMnr0243Event 참조
 * @since J2EE 1.6
 */
public class EES_MNR_0243HTMLAction extends HTMLActionSupport {
	/*
	 * 객체직렬화 버젼 UID
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * EES_MNR_0243HTMLAction 객체를 생성
	 */
	public EES_MNR_0243HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 AgreementManageEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

    	FormCommand command = FormCommand.fromRequest(request);
    	EesMnr0243Event event = new EesMnr0243Event();

		switch(command.getCommand()) {
			case FormCommand.SEARCH :	// Load Excel
				event.setEstimateUploadVOs((EstimateUploadVO[])getVOs(request, EstimateUploadVO.class));
				break;

			case FormCommand.MULTI :	// Confirm
				event.setReqUi(request.getParameter("req_ui"));	
				event.setEstimateUploadVOs((EstimateUploadVO[])getVOs(request, EstimateUploadVO.class));
				break;

			case FormCommand.SEARCH01 :	// Calculation					
				event.setEstimateUploadVOs((EstimateUploadVO[])getVOs(request, EstimateUploadVO.class));				
				break;			
				//verify  		 
			case FormCommand.COMMAND01 : 
				CustomMnrRprRqstDtlVO customMnrRprRqstDtlVO = new CustomMnrRprRqstDtlVO();
				EstimateGRPVO estimateGRPVO = new EstimateGRPVO();
				//헤더 데이타 
				estimateGRPVO.setCustomMnrRprRqstHdrVO((CustomMnrRprRqstHdrVO)getVO(request, CustomMnrRprRqstHdrVO.class));
				//VO을 변경, 디테일 데이타	 
				CustomMnrDatVrfyVO[] customMnrDatVrfyVOS = customMnrRprRqstDtlVO.fromDatVrfyVORequestGrid(request,"rqstDtl_"); 
				estimateGRPVO.setCustomMnrDatVrfyVOS(customMnrDatVrfyVOS);	
				event.setEstimateGRPVO(estimateGRPVO); 
				EstimateUploadVO estimateUploadVO = new EstimateUploadVO();
				EstimateUploadVO[] estimateUploadVOS = estimateUploadVO.fromRequestGrid(request, "rqstDtl_");
				event.setEstimateUploadVOs(estimateUploadVOS);
			
				break;
				
			default :	//do nothing
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