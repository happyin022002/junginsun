/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0909_01HTMLAction.java
*@FileTitle : Integrated Customer Data Management (Arrival Notice Code Validation)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.09.21
*@LastModifier : 곽영범
*@LastVersion : 1.0
* 2009.09.21 곽영범
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.DoRefVO;
import com.hanjin.apps.alps.esm.bkg.inbounddocumentation.cargoreleaseordermgt.cargoreleaseorder.vo.UsCgoRlseSearchVO;
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
 * @see EsmBkg0909Event 참조
 * @since J2EE 1.4
 */

public class ESM_BKG_0909HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * esm_bkg_0909_01HTMLAction 객체를 생성
	 */
	public ESM_BKG_0909HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 InboundBLMgtEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
    	EsmBkg0909Event event = new EsmBkg0909Event();
		if(command.isCommand(FormCommand.SEARCH)) {
			UsCgoRlseSearchVO searchVO = (UsCgoRlseSearchVO)getVO(request,UsCgoRlseSearchVO.class);
			
			event.setSearchVO(searchVO);
			//event.setEdoSearchVO(edoSearchVO);
		}else if(command.isCommand(FormCommand.SEARCH02)) {//Container 조회
			//UsCgoRlseSearchVO searchVO = (UsCgoRlseSearchVO)getVO(request,UsCgoRlseSearchVO.class);
			event.setBkgNo(request.getParameter("bkg_no"));
			
			//event.setEdoSearchVO(edoSearchVO);
		}else if(command.isCommand(FormCommand.SEARCH03)) {//OTS,DEM
			//UsCgoRlseSearchVO searchVO = (UsCgoRlseSearchVO)getVO(request,UsCgoRlseSearchVO.class);
			event.setBkgNo(request.getParameter("bkg_no"));
			event.setBlNo(request.getParameter("bl_no"));
			event.setPodCd(request.getParameter("req_pod_cd"));

		}else if(command.isCommand(FormCommand.SEARCH05)) {//Cargo Release CR 조회
			event.setBlNo(request.getParameter("bl_no").substring(0,12));

			//event.setEdoSearchVO(edoSearchVO);
		}else if(command.isCommand(FormCommand.MULTI01)) {//SAVE
			//DoRefVO[] doRefVOs = (DoRefVO[])getVOs(request,DoRefVO.class,"bkg_do_ref_");
			BkgCgoRlseVO[] bkgCgoRlseVOs = (BkgCgoRlseVO[])getVOs(request,BkgCgoRlseVO.class,"bkg_cgo_rlse_");
			BkgBlIssVO[] blIssVOs = (BkgBlIssVO[])getVOs(request,BkgBlIssVO.class,"sheet_bl_status_");
			//넘어오는 변수명과 VO가 일치하지 않으므로
			//blIssVOs[0].setOblRdemKnt(request.getParameter("bl_rece"));
			//blIssVOs[0].setBlOtrDocRcvCd(request.getParameter("bl_otr"));
			if(blIssVOs !=null){
				blIssVOs[0].setBkgNo(request.getParameter("bkg_no"));
				event.setBlIssVOs(blIssVOs);
			}
			
			
			
			event.setBlNo(request.getParameter("bl_no"));
			//event.setBkgNo(request.getParameter("bkg_no"));
			
			//log.debug("--------------- bkgDoRefVOs    "+doRefVOs);
			//log.debug("--------------- bkgCgoRlseVOs    "+bkgCgoRlseVOs[0].getColumnValues());
			//log.debug("--------------- blIssVOs    "+blIssVOs);
			//log.debug("--------------- bkg_no    "+request.getParameter("bkg_no"));
			//log.debug("--------------- bl_no    "+request.getParameter("bl_no"));
			//log.debug("--------------- bl_rece    "+request.getParameter("bl_rece"));
			//log.debug("--------------- bl_otr    "+request.getParameter("bl_otr"));
			
			//event.setDoRefVOs(doRefVOs);
			event.setBkgCgoRlseVOs(bkgCgoRlseVOs);
			
			//event.setEdoSearchVO(edoSearchVO);
		}else if(command.isCommand(FormCommand.MULTI02)) {//TRANSMIT
			BkgCgoRlseVO[] bkgCgoRlseVOs = new BkgCgoRlseVO[1];
			bkgCgoRlseVOs[0] = new BkgCgoRlseVO();
			bkgCgoRlseVOs[0].setBlNo(request.getParameter("bl_no").substring(0,12));
			bkgCgoRlseVOs[0].setNewPodCd(request.getParameter("new_pod_cd"));
			bkgCgoRlseVOs[0].setOldPodCd(request.getParameter("old_pod_cd"));
			bkgCgoRlseVOs[0].setNewPodYdCd(request.getParameter("new_pod_yd_cd"));
			bkgCgoRlseVOs[0].setOldPodYdCd(request.getParameter("old_pod_yd_cd"));
			bkgCgoRlseVOs[0].setEventId(request.getParameter("event_id"));
			event.setBkgCgoRlseVOs(bkgCgoRlseVOs);
			
		}else if(command.isCommand(FormCommand.MULTI03)) {//HOLD
			DoRefVO[] doRefVOs = (DoRefVO[])getVOs(request,DoRefVO.class,"bkg_do_ref_");
			
			event.setDoRefVOs(doRefVOs);
			//event.setEdoSearchVO(edoSearchVO);
		}else if(command.isCommand(FormCommand.SEARCH03)) {//데머리지 가꼬 오기 
			//UsCgoRlseSearchVO searchVO = (UsCgoRlseSearchVO)getVO(request,UsCgoRlseSearchVO.class);
			event.setBkgNo(request.getParameter("bkg_no"));
			 
			//event.setEdoSearchVO(edoSearchVO);
		}else if(command.isCommand(FormCommand.SEARCH04)) {//Original Bill of Lading Status 정보 가져오기			
			event.setBkgNo(request.getParameter("bkg_no"));
			event.setBlNo(request.getParameter("curr_bl_no"));//검색용 BL_NO
			
		}else if(command.isCommand(FormCommand.MULTI09)) {//SAVE ; C/S 쪽 저장
			DoRefVO[] doRefVOs = (DoRefVO[])getVOs(request,DoRefVO.class,"bkg_do_ref_");			
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
			DoRefVO[] doRefVOs = (DoRefVO[])getVOs(request,DoRefVO.class, "bkg_do_ref_");			
			event.setDoRefVOs(doRefVOs);
			
		//WEB B/L Printed Checked			
		}else if(command.isCommand(FormCommand.MULTI05) || command.isCommand(FormCommand.SEARCH06)) { 
			event.setBkgNo(request.getParameter("bkg_no"));			
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