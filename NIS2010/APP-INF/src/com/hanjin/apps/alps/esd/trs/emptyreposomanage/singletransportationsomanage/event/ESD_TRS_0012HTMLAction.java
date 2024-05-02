/*=========================================================
*Copyright(c) 2006 CyberLogitec
*@FileName : ESD_TRS_012HTMLAction.java
*@FileTitle : Empty Repo & S/T On/Off Hire S/O Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2006-10-30
*@LastModifier : kim_sang_geun
*@LastVersion : 1.0
* 2006-10-30 kim_sang_geun
* 1.0 최초 생성
=========================================================*/
package com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.vo.SingleTransportationSOManageSearchVO;
import com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.vo.SingleTransportationSOManageVO;
import com.hanjin.apps.alps.esd.trs.emptyreposomanage.singletransportationsomanage.vo.SingleTransportationSOManageHdrVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;


/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.emptyreposomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EmptyRepoSOManageSC로 실행요청<br>
 * - EmptyRepoSOManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author kim_sang_geun
 * @see EsdTrs0012Event , ESD_TRS_012EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0012HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_012HTMLAction 객체를 생성
	 */
	public ESD_TRS_0012HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_012Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {

		FormCommand command = FormCommand.fromRequest(request);
		EsdTrs0012Event event = null;
		event = new EsdTrs0012Event();
		// JSP PARAMETERS VALUES Getting ----------------------------------
		// USE IN ESD_TRS_0012.JS
		if(command.isCommand(FormCommand.SEARCH)){
			SingleTransportationSOManageSearchVO singleTransportationSOManageSearchVO   = new SingleTransportationSOManageSearchVO();
			singleTransportationSOManageSearchVO.fromRequest(request);
			event.setSingleTransportationSOManageSearchVO(singleTransportationSOManageSearchVO);
		// USE IN ESD_TRS_0951.JS [ Container File Import Search ] PopUp
		}else if(command.isCommand(FormCommand.SEARCH01)){
			SingleTransportationSOManageSearchVO singleTransportationSOManageSearchVO   = new SingleTransportationSOManageSearchVO();
			singleTransportationSOManageSearchVO.fromRequest(request);
			event.setSingleTransportationSOManageSearchVO(singleTransportationSOManageSearchVO);
		// USE IN ESD_TRS_0951.JS [ Container File Import Search ] PopUp
		}else if(command.isCommand(FormCommand.SEARCH02)){
			String sHidEqNo = JSPUtil.getNull(request.getParameter("hid_eq_no"));
			event.setHidEqNo(sHidEqNo);
		// USE IN ESD_TRS_0052.JS [Empty Repo & S/T On/Off Hire]	
		}else if(command.isCommand(FormCommand.SEARCH03)){ //retrieve
			String rad_date       = JSPUtil.getParameter(request,"rad_date", "");
			String hid_frmreqdate = JSPUtil.getParameter(request,"hid_frmreqdate", "");
			String hid_toreqdate  = JSPUtil.getParameter(request,"hid_toreqdate", "");
			String sel_kind       = JSPUtil.getParameter(request,"sel_kind", "");
			String sel_transmode  = JSPUtil.getParameter(request,"sel_transmode", "");
			String frm_node       = JSPUtil.getParameter(request,"frm_node", "");
			String frm_yard       = JSPUtil.getParameter(request,"frm_yard", "");
			String to_node        = JSPUtil.getParameter(request,"to_node", "");
			String to_yard        = JSPUtil.getParameter(request,"to_yard", "");
			String cntr_no        = JSPUtil.getParameter(request,"cntr_no", "");
			String reference_no   = JSPUtil.getParameter(request,"reference_no", "");
			String ctrl_ofc_cd    = JSPUtil.getParameter(request,"ctrl_ofc_cd", "");
			String spotBidFlg     = JSPUtil.getParameter(request,"spot_bid_flg", "");
			String spotBidNo      = JSPUtil.getParameter(request,"spot_bid_no", "");
			
			event.setRadDate(rad_date);
			event.setHidFrmreqdate(hid_frmreqdate);
			event.setHidToreqdate(hid_toreqdate);
			event.setSelKind(sel_kind);
			event.setSelTransmode(sel_transmode);
			event.setFrmYard(frm_yard);
			event.setFrmNode(frm_node);
			event.setToNode(to_node);
			event.setToYard(to_yard);
			event.setCntrNo(cntr_no);
			event.setReferenceNo(reference_no);
			event.setCtrlOfcCd(ctrl_ofc_cd);
			event.setSpotBidFlg(spotBidFlg);
			event.setSpotBidNo(spotBidNo);
		}if(command.isCommand(FormCommand.SEARCH04)){
			String hid_cntr_no = JSPUtil.getParameter(request,"hid_cntr_no", "");
			event.setHidCntrNo(hid_cntr_no);
		}else if(command.isCommand(FormCommand.SEARCH05)){ //verify
			String eq_no_verify = JSPUtil.getParameter(request,"eq_no_verify", "");
			String frm_node_verify = JSPUtil.getParameter(request,"frm_node_verify", "");
			event.setEqNoVerify(eq_no_verify);
			event.setFrmNodeVerify(frm_node_verify);
		}if(command.isCommand(FormCommand.SEARCH06)){//searchNodCdForOffHire
			String locCd 	  = JSPUtil.getParameter(request,"locCd", "");
			event.setLocCd(locCd);	
		}else if(command.isCommand(FormCommand.MODIFY)){ //S/O Correction
			String cbstatus = JSPUtil.getParameter(request,"cbstatus", "");
			event.setCbstatus(cbstatus);
			
			SingleTransportationSOManageVO singleTransportationSOManageVO   = new SingleTransportationSOManageVO();
			SingleTransportationSOManageVO[] svo = null; 
			svo = singleTransportationSOManageVO.fromRequestGrid(request);
			event.setSingleTransportationSOManageVOs(svo);
			
		}else if(command.isCommand(FormCommand.MODIFY01) || command.isCommand(FormCommand.REMOVE)){ //Separate,S/O Delete
			SingleTransportationSOManageVO singleTransportationSOManageVO   = new SingleTransportationSOManageVO();
			
			SingleTransportationSOManageVO[] svo = null; 
			svo = singleTransportationSOManageVO.fromRequestGrid(request);
			
			SingleTransportationVO singleTransportationVO   = new SingleTransportationVO();
			SingleTransportationVO[] singleTransportationVOs=null;
			singleTransportationVOs = singleTransportationVO.fromRequestGrid(request);
			
			event.setSingleTransportationVOs(singleTransportationVOs);
			event.setSingleTransportationSOManageVOs(svo);
		}else if(command.isCommand(FormCommand.MULTI)){ // so creation
			String cbstatus = JSPUtil.getParameter(request,"cbstatus", "");
			String ctrl_ofc_cd    = JSPUtil.getParameter(request,"ctrl_ofc_cd", "");
			SingleTransportationVO stVO   = new SingleTransportationVO();
			SingleTransportationVO[] singleTransportationVOs = null; 
			singleTransportationVOs = stVO.fromRequestGrid(request);
			event.setCbstatus(cbstatus);
			event.setCtrlOfcCd(ctrl_ofc_cd);
			event.setSingleTransportationVOs(singleTransportationVOs);
		}else if(command.isCommand(FormCommand.MULTI01)|| command.isCommand(FormCommand.REMOVE01)){//MULTI01 : SAVE, REMOVE01:DELETE
			SingleTransportationSOManageHdrVO hdrVo = new SingleTransportationSOManageHdrVO();
			SingleTransportationSOManageHdrVO[] singleTransportationSOManageHdrVOs = null; 
			singleTransportationSOManageHdrVOs = hdrVo.fromRequestGrid(request);
			event.setSingleTransportationSOManageHdrVOs(singleTransportationSOManageHdrVOs);
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