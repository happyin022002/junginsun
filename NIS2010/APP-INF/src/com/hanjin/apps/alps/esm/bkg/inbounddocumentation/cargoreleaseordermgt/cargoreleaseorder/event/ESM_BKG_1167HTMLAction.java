/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_1167HTMLAction.java
*@FileTitle : Canada Cargo Release
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
* 2009.09.21 
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRefVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.CaCgoRlseSearchVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgBlIssVO;
import com.hanjin.syscommon.common.table.BkgCgoRlseVO;

 
/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.inbounddocumentation.inboundnoticemgt 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 InboundBLMgtSC로 실행요청<br>
 * - InboundBLMgtSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Park Mangeon
 * @see EsmBkg1167Event 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_1167HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * esm_bkg_1167_01HTMLAction 객체를 생성
	 */
	public ESM_BKG_1167HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InboundBLMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmBkg1167Event event = new EsmBkg1167Event();
		if(command.isCommand(FormCommand.SEARCH)) {
			CaCgoRlseSearchVO searchVO = (CaCgoRlseSearchVO)getVO(request,CaCgoRlseSearchVO.class);
			
			event.setSearchVO(searchVO);
		}else if(command.isCommand(FormCommand.SEARCH02)) {//Container 조회
			event.setBkgNo(request.getParameter("bkg_no"));
			
			//event.setEdoSearchVO(edoSearchVO);
		}else if(command.isCommand(FormCommand.SEARCH03)) {//OTS,DEM
			event.setBkgNo(request.getParameter("bkg_no"));
			event.setBlNo(request.getParameter("bl_no"));
			event.setPodCd(request.getParameter("req_pod_cd"));
			
		}else if(command.isCommand(FormCommand.MULTI01)) {//SAVE
			BkgCgoRlseVO[] bkgCgoRlseVOs = (BkgCgoRlseVO[])getVOs(request,BkgCgoRlseVO.class,"t6sheet4_");
			BkgBlIssVO[] blIssVOs = (BkgBlIssVO[])getVOs(request,BkgBlIssVO.class,"t6sheet7_");
			if(blIssVOs !=null){
				blIssVOs[0].setBkgNo(request.getParameter("bkg_no"));
				event.setBlIssVOs(blIssVOs);
			}
			
			event.setBlNo(request.getParameter("bl_no"));
			event.setBkgCgoRlseVOs(bkgCgoRlseVOs);
			
			//event.setEdoSearchVO(edoSearchVO);
		}else if(command.isCommand(FormCommand.MULTI02)) {//TRANSMIT
			DoRefVO[] doRefVOs = (DoRefVO[])getVOs(request,DoRefVO.class,"t6sheet3_");
			BkgCgoRlseVO[] bkgCgoRlseVOs = (BkgCgoRlseVO[])getVOs(request,BkgCgoRlseVO.class,"t6sheet4_");
			event.setBlNo(request.getParameter("bl_no"));
			
			log.debug("--------------- bkgDoRefVOs    "+doRefVOs);
			log.debug("--------------- bkgCgoRlseVOs    "+bkgCgoRlseVOs);
			
			event.setDoRefVOs(doRefVOs);
			event.setBkgCgoRlseVOs(bkgCgoRlseVOs);
			
			//event.setEdoSearchVO(edoSearchVO);
		}else if(command.isCommand(FormCommand.MULTI03)) {//HOLD
			DoRefVO[] doRefVOs = (DoRefVO[])getVOs(request,DoRefVO.class,"t6sheet3_");
			
			event.setDoRefVOs(doRefVOs);
			//event.setEdoSearchVO(edoSearchVO);
		}else if(command.isCommand(FormCommand.SEARCH03)) {//데머리지 가꼬 오기 
			event.setBkgNo(request.getParameter("bkg_no"));
			
			//event.setEdoSearchVO(edoSearchVO);
		}else if(command.isCommand(FormCommand.SEARCH04)) {//Original Bill of Lading Status 정보 가져오기			
			event.setBkgNo(request.getParameter("bkg_no"));
			event.setBlNo(request.getParameter("curr_bl_no"));//검색용 BL_NO
			
		}else if(command.isCommand(FormCommand.MULTI09)) {//SAVE ; C/S 쪽 저장
			DoRefVO[] doRefVOs = (DoRefVO[])getVOs(request,DoRefVO.class,"t6sheet3_");			
			event.setBlNo(request.getParameter("curr_bl_no"));			
			log.debug("--------------- bkgDoRefVOs    "+doRefVOs);
			
			event.setDoRefVOs(doRefVOs);
			
			
			//event.setEdoSearchVO(edoSearchVO);
		}else if(       command.isCommand(FormCommand.MULTI16)
					||  command.isCommand(FormCommand.MULTI17)
					||  command.isCommand(FormCommand.MULTI18)
				) {//FRT,OBL,CSTMS 쪽 시뮬레이션
			String[] colNames = new String[]{"test_bl_no","test_foc","test_evnt_ofc_cd","test_evnt_usr_id"
				,"test_evnt_dt","test_cgor_team_cd","test_cgor_evnt_nm","test_cstms_loc_cd"
				,"test_cstms_ds_po_cd"};
			for(int i=0;i<colNames.length;i++){
				event.setAttribute(colNames[i], request.getParameter(colNames[i]));
			}			
		} else if (command.isCommand(FormCommand.MULTI20)) { // Remark 저장
			DoRefVO[] doRefVOs = (DoRefVO[])getVOs(request,DoRefVO.class, "t6sheet3_");			
			event.setDoRefVOs(doRefVOs);
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