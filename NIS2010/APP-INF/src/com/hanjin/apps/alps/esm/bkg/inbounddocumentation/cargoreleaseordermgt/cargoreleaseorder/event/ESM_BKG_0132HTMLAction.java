/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : esm_bkg_0132HTMLAction.java
*@FileTitle : 
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.17
*@LastModifier : 안진응
*@LastVersion : 1.0
* 2009.06.17 안진응
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoEdiTransVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoRqstsVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.EdoSearchVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.nis2010.esm.bkg.inboundblmgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InboundBLMgtSC로 실행요청<br>
 * - InboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author An Jin Eung
 * @see InboundBLMgtEvent 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0132HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * esm_bkg_0132HTMLAction 객체를 생성
	 */
	public ESM_BKG_0132HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InboundBLMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmBkg0132Event event = new EsmBkg0132Event();
		if(command.isCommand(FormCommand.SEARCH)|| command.isCommand(FormCommand.SEARCH02)) {
			log.debug("0132 Event 호출 ===> setEdoSearchVO");
			EdoSearchVO edoSearchVO = (EdoSearchVO)getVO(request,EdoSearchVO.class);
			edoSearchVO.setEdoRqstDtS(edoSearchVO.getEdoRqstDtS().replaceAll("-", ""));
			edoSearchVO.setEdoRqstDtE(edoSearchVO.getEdoRqstDtE().replaceAll("-", ""));
			
			if (edoSearchVO.getDoNo().length() > 0 ) {
				if (edoSearchVO.getDoNo().length() > 10) {
					edoSearchVO.setDoNoSplit(edoSearchVO.getDoNo().substring(10));
					edoSearchVO.setDoNo(edoSearchVO.getDoNo().substring(0, 10));
				} else {
					edoSearchVO.setDoNoSplit("00");
				}
			}
			
			event.setEdoSearchVO(edoSearchVO);
		}else if(command.isCommand(FormCommand.SEARCH03)) {
			 event.setEdoEdiTrans((EdoEdiTransVO[])getVOs(request, EdoEdiTransVO.class, "sheet1_"));
            
		}else if(command.isCommand(FormCommand.SEARCH04)) {

			 event.setEdoEdiTrans((EdoEdiTransVO[])getVOs(request, EdoEdiTransVO.class, "sheet1_"));
		}
		else if(command.isCommand(FormCommand.REMOVE)) {
            log.debug("===================================");
            log.debug("    REMOVE EVENT                   ");
            log.debug("===================================");

//			event.setRqstNo(JSPUtil.getParameter(request, "frm_sheet2_edo_rqst_no", ""));
//			event.setTpCd(JSPUtil.getParameter(request, "frm_sheet2_edo_tp_cd", ""));
			
//			log.debug("getRqstNo  ==> " + event.getRqstNo() + " getTpCd ===>  " + event.getTpCd());
            
            EdoRqstsVO[] edoRqstsVO = (EdoRqstsVO[])getVOs(request,EdoRqstsVO.class, "sheet1_");
            
            log.debug("======= " + edoRqstsVO);
			event.setEdoRqstsVOs(edoRqstsVO);
            
		} else {
			log.debug("===================================");
            log.debug(command.getCommand());
            log.debug("===================================");
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