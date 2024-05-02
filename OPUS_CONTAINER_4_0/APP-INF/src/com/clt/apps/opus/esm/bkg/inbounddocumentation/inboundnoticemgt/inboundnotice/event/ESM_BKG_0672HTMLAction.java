/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0672HTMLAction.java
*@FileTitle : Integrated Customer Data Management (Arrival Notice Code Validation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.05.21
*@LastModifier : 
*@LastVersion : 1.0
* 2009.05.21 
* 1.0 Creation
=========================================================*/
package com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.event;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcCustUploadListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcInfoListVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.ArrNtcSearchVO;
import com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt.inboundnotice.vo.CustCdEvaluationVO;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.BkgArrNtcVO;


/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.inbounddocumentation.inboundnoticemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InboundBLMgtSC로 실행요청<br>
 * - InboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author
 * @see EsmBkg0672Event 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0672HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0672HTMLAction 객체를 생성
	 */
	public ESM_BKG_0672HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InboundNoticeMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0672Event event = new EsmBkg0672Event();
		int iSize = 0;
		if(command.isCommand(FormCommand.SEARCH01)) {
			// Customer Code Validation을 수행한다.
			ArrNtcSearchVO arrNtcSearchVO = (ArrNtcSearchVO)getVO(request,ArrNtcSearchVO.class);
			arrNtcSearchVO.setVpsEtaDtStart(arrNtcSearchVO.getVpsEtaDtStart().replaceAll("-", ""));
			arrNtcSearchVO.setVpsEtaDtEnd(arrNtcSearchVO.getVpsEtaDtEnd().replaceAll("-", ""));
			if(arrNtcSearchVO.getBlNo() !=null && arrNtcSearchVO.getBlNo().equals("")) {
				iSize = arrNtcSearchVO.getBlNo().length(); 
				if (iSize > 12) {
					arrNtcSearchVO.setBlTpCd(arrNtcSearchVO.getBlNo().substring(12, 13));	
					arrNtcSearchVO.setBlNo(arrNtcSearchVO.getBlNo().substring(0, 12));
				}
			}
			event.setArrNtcSearchVO(arrNtcSearchVO);
		}
		else if(command.isCommand(FormCommand.SEARCH05)) {
			// Customer Code Validation 결과를 요청한다.
			ArrNtcSearchVO arrNtcSearchVO = (ArrNtcSearchVO)getVO(request,ArrNtcSearchVO.class);
			arrNtcSearchVO.setVpsEtaDtStart(arrNtcSearchVO.getVpsEtaDtStart().replaceAll("-", ""));
			arrNtcSearchVO.setVpsEtaDtEnd(arrNtcSearchVO.getVpsEtaDtEnd().replaceAll("-", ""));

			event.setArrNtcSearchVO(arrNtcSearchVO);
		}
		else if(command.isCommand(FormCommand.SEARCH06)) {
			// Customer Code Validation 결과를 요청한다.
			ArrNtcSearchVO arrNtcSearchVO = (ArrNtcSearchVO)getVO(request,ArrNtcSearchVO.class);
			arrNtcSearchVO.setVpsEtaDtStart(arrNtcSearchVO.getVpsEtaDtStart().replaceAll("-", ""));
			arrNtcSearchVO.setVpsEtaDtEnd(arrNtcSearchVO.getVpsEtaDtEnd().replaceAll("-", ""));

			event.setArrNtcSearchVO(arrNtcSearchVO);
		}
		//---------------------------------------------
		// [672-1] modify
		// Arrival Date 저장
		//---------------------------------------------
		else if(command.isCommand(FormCommand.MULTI02)) {
			//검색조건
			ArrNtcSearchVO anv = (ArrNtcSearchVO)getVO(request,ArrNtcSearchVO.class);
			event.setArrNtcSearchVO(anv);
			//저장실행
			
			BkgArrNtcVO[] vos = (BkgArrNtcVO[]) getVOs(request, BkgArrNtcVO.class,"t2sheet1_");		
			ArrNtcInfoListVO[] arrNtcInfos = (ArrNtcInfoListVO[]) getVOs(request, ArrNtcInfoListVO.class,"t2sheet1_");	
			
			event.setVos(vos);
			event.setArrNtcInfos(arrNtcInfos);
		}	
		//---------------------------------------------
		// [672-2] modify
		// Customer 저장
		//---------------------------------------------
		else if(command.isCommand(FormCommand.MULTI03)) {
			//검색조건
			ArrNtcSearchVO anv = (ArrNtcSearchVO)getVO(request,ArrNtcSearchVO.class);
			event.setArrNtcSearchVO(anv);
			//저장실행
			ArrNtcCustListVO[] arrntcCustListVOS =(ArrNtcCustListVO[])getVOs(request, ArrNtcCustListVO.class,"t3sheet1_");
			event.setArrNtcCustListVOS(arrntcCustListVOS);
		}	
		//---------------------------------------------
		// [672-3] 
		// Upload Match 저장
		//---------------------------------------------
		else if(command.isCommand(FormCommand.MULTI04)) {
			//검색조건
			ArrNtcSearchVO anv = (ArrNtcSearchVO)getVO(request,ArrNtcSearchVO.class);
			event.setArrNtcSearchVO(anv);
			//저장실행
			ArrNtcCustUploadListVO[] vos =(ArrNtcCustUploadListVO[])getVOs(request, ArrNtcCustUploadListVO.class,"t4sheet1_");
			event.setArrNtcCustUploadListVOS(vos);
		}	
		//---------------------------------------------
		//[672-1] retrieve
		// Arrival Date 조회
		//---------------------------------------------
		else if(command.isCommand(FormCommand.SEARCH02)) {
			ArrNtcSearchVO anv = (ArrNtcSearchVO)getVO(request,ArrNtcSearchVO.class);
			event.setArrNtcSearchVO(anv);
		}
		//---------------------------------------------
		//[672-2] Customer
		// Customer 조회
		//---------------------------------------------
		else if(command.isCommand(FormCommand.SEARCH03)) {
			ArrNtcSearchVO anv = (ArrNtcSearchVO)getVO(request,ArrNtcSearchVO.class);
			
			event.setArrNtcSearchVO(anv);
			log.debug("--------------------------- anv "+anv.getColumnValues());
			
		}
		// Upload & Match 조회
		else if(command.isCommand(FormCommand.SEARCH04)) {
			ArrNtcSearchVO anv = (ArrNtcSearchVO)getVO(request,ArrNtcSearchVO.class);
			event.setArrNtcSearchVO(anv);
			
		}
		else if(command.isCommand(FormCommand.MODIFY01)) {
			event.setCustCdEvaluationVO((CustCdEvaluationVO[])getVOs(request, CustCdEvaluationVO.class, ""));
		}
		else if(command.isCommand(FormCommand.MODIFY02)) {
			CustCdEvaluationVO[] custCdEvaluationVO = (CustCdEvaluationVO[])getVOs(request,CustCdEvaluationVO.class, "");
			event.setCustCdEvaluationVO(custCdEvaluationVO);
		}
		
		
		//---------------------------------------------
		//[672-2] retrieve
		// Customer 조회
		//---------------------------------------------
		
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