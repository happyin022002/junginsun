/*=========================================================
 *Copyright(c) 2006 CyberLogitec
 *@FileName : ESD_TRS_0002HTMLAction.java
 *@FileTitle : CY & Door S/O Creation
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2011.11.29
 *@LastModifier : 민정호
 *@LastVersion : 1.3
 * 2006.09.29 김상근
 * 1.0 최초 생성
 *----------------------------------------------------------
 * History
 * 2009.02.18 조풍연  1.1 [N200902170001]  TRS SO 대상 삭제시 COA 비용 제거 기능 추가 
 * 2010.10.08 최 선     1.2 [CHM-201006411] S/O DOOR NODE 팝업창의 RETURN VALUE 오류 수정
 * 2011.11.29 민정호   1.3 [CHM-201114644] [TRS] S/O Correction 시 Delete flag 체크로직 추가요청
 * 2011.12.12 민정호   1.4 [CHM-201115019] [TRS] S/O creation 시 BKG cancel 여부 체크 로직 추가요청
 * 2012.01.09 김보배 [CHM-201215479] [TRS] Dup. S/O 사전 보완기능 요청
=========================================================*/
package com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.event;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esd.trs.cydoorsomanage.singletransportationsomanage.vo.SingleTransportationVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esd.trs.cydoorsomanage 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 CYDoorSOManageSC로 실행요청<br>
 * - CYDoorSOManageSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 *
 * @author z_kim_sang_geun
 * @see EsdTrs0002Event , ESD_TRS_0002EventResponse 참조
 * @since J2EE 1.4
 */
public class ESD_TRS_0002HTMLAction extends HTMLActionSupport {

	/**
	 * ESD_TRS_002HTMLAction 객체를 생성
	 */
	public ESD_TRS_0002HTMLAction() {
	}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 ESD_TRS_002Event로 파싱하여 request에 셋팅<br>
	 * 
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
		FormCommand command = FormCommand.fromRequest(request);


		SingleTransportationVO singleTransportationVO   = new SingleTransportationVO();
		SingleTransportationVO[] tcz = null; 
		EsdTrs0002Event event = new EsdTrs0002Event();
		
		if(command.isCommand(FormCommand.REMOVE01) || command.isCommand(FormCommand.SEARCH20) 
				|| command.isCommand(FormCommand.SEARCH13) || command.isCommand(FormCommand.MODIFY01)
				|| command.isCommand(FormCommand.MODIFY01) || command.isCommand(FormCommand.REMOVE)
				|| command.isCommand(FormCommand.MODIFY02)
				|| command.isCommand(FormCommand.SEARCH18)
				|| command.isCommand(FormCommand.SEARCH17)	
				) {
			singleTransportationVO.fromRequest(request);
			tcz = singleTransportationVO.fromRequestGrid(request);
		} else if (command.isCommand(FormCommand.SEARCH16)||command.isCommand(FormCommand.SEARCH22)||command.isCommand(FormCommand.SEARCH23)){
			event.setSingleTransportationVO((SingleTransportationVO)getVO(request, SingleTransportationVO.class));
		}

		String frm_plandate          = request.getParameter("hid_frmdate")!=null?request.getParameter("hid_frmdate"):"";
		String to_plandate           = request.getParameter("hid_todate")!=null?request.getParameter("hid_todate"):"";
		String transmode             = request.getParameter("sel_transmode")!=null?request.getParameter("sel_transmode"):"";
		String costmode              = request.getParameter("sel_costmode")!=null?request.getParameter("sel_costmode"):"";
		String bound                 = request.getParameter("sel_bound")!=null?request.getParameter("sel_bound"):"";
		String search_fm_loc   	     = request.getParameter("search_fm_loc")!=null?request.getParameter("search_fm_loc"):"";
		String search_fm_yard        = request.getParameter("search_fm_yard")!=null?request.getParameter("search_fm_yard"):"";
		String search_via_loc        = request.getParameter("search_via_loc")!=null?request.getParameter("search_via_loc"):"";
		String search_via_yard       = request.getParameter("search_via_yard")!=null?request.getParameter("search_via_yard"):"";
		String search_to_loc         = request.getParameter("search_to_loc")!=null?request.getParameter("search_to_loc"):"";
		String search_to_yard        = request.getParameter("search_to_yard")!=null?request.getParameter("search_to_yard"):"";
		String search_door_loc       = request.getParameter("search_door_loc")!=null?request.getParameter("search_door_loc"):"";
		String search_door_yard      = request.getParameter("search_door_yard")!=null?request.getParameter("search_door_yard"):"";
		String trunkvvd              = request.getParameter("trunk_vvd")!=null?request.getParameter("trunk_vvd"):"";
		String bkgno                 = request.getParameter("bkg_no")!=null?request.getParameter("bkg_no"):"";
		String billno                = request.getParameter("bill_no")!=null?request.getParameter("bill_no"):"";
		String cntrno                = request.getParameter("cntr_no")!=null?request.getParameter("cntr_no"):"";
		String contract_tp_cd        = request.getParameter("contract_tp_cd")!=null?request.getParameter("contract_tp_cd"):"";
		String contract_no           = request.getParameter("contract_no")!=null?request.getParameter("contract_no"):"";
		String sUnplannedShuttleFlag = request.getParameter("unplan_shuttle")!=null?request.getParameter("unplan_shuttle"):"";
		String sTroUnConfirmDoor     = request.getParameter("tro_unconfirm_dr")!=null?request.getParameter("tro_unconfirm_dr"):"";
		String susa_rail             = request.getParameter("incl_usa_rail")!=null?request.getParameter("incl_usa_rail"):"";
		String rad_dateSep           = request.getParameter("rad_dateSep")!=null?request.getParameter("rad_dateSep"):"";
		String ctrl_so_office        = request.getParameter("ctrl_so_office")!=null?request.getParameter("ctrl_so_office"):"";
		String feeder_vvd            = request.getParameter("feeder_vvd")!=null?request.getParameter("feeder_vvd"):"";
		String txt_feeder_vvd        = request.getParameter("txt_feeder_vvd")!=null?request.getParameter("txt_feeder_vvd"):"";
		String zip_code              = request.getParameter("zip_code")!=null?request.getParameter("zip_code"):"";
		String cydoor_div            = request.getParameter("cydoor_div")!=null?request.getParameter("cydoor_div"):"";
		String ui_conti_cd           = request.getParameter("ui_conti_cd")!=null?request.getParameter("ui_conti_cd"):"";
		String form_usr_ofc_cd       = request.getParameter("FORM_USR_OFC_CD")!=null?request.getParameter("FORM_USR_OFC_CD"):"";
		String form_cre_usr_id       = request.getParameter("FORM_CRE_USR_ID")!=null?request.getParameter("FORM_CRE_USR_ID"):"";
		String cbstatus         = request.getParameter("cbstatus")!=null?request.getParameter("cbstatus"):"";
		String prnt_ofc_cd       = request.getParameter("prnt_ofc_cd")!=null?request.getParameter("prnt_ofc_cd"):"";
		String cnt_flg       = request.getParameter("cnt_flg")!=null?request.getParameter("cnt_flg"):"";
		
		String spot_bid_flg       = request.getParameter("spot_bid_flg")!=null?request.getParameter("spot_bid_flg"):"";
		String spot_bid_no       = request.getParameter("spot_bid_no")!=null?request.getParameter("spot_bid_no"):"";
		

		String  sFmLocContiCd   = request.getParameter("FM_LOC_CONTI_CD")!=null?request.getParameter("FM_LOC_CONTI_CD"):"";
		String  sBoundCd        = request.getParameter("BOUND_CD")!=null?request.getParameter("BOUND_CD"):"";
		String  sCneeCustCntCd  = request.getParameter("CNEE_CUST_CNT_CD")!=null?request.getParameter("CNEE_CUST_CNT_CD"):"";
		String  sCneeCustSeq    = request.getParameter("CNEE_CUST_SEQ")!=null?request.getParameter("CNEE_CUST_SEQ"):"";
		String  sShprCustCntCd  = request.getParameter("SHPR_CUST_CNT_CD")!=null?request.getParameter("SHPR_CUST_CNT_CD"):"";
		String  sShprCustSeq    = request.getParameter("SHPR_CUST_SEQ")!=null?request.getParameter("SHPR_CUST_SEQ"):"";
		String  sDoorNodCd      = request.getParameter("DOOR_NOD_CD")!=null?request.getParameter("DOOR_NOD_CD"):"";

		String  rad_wo_issued      = request.getParameter("rad_wo_issued")!=null?request.getParameter("rad_wo_issued"):"";
		String  combo_svc_provider = request.getParameter("combo_svc_provider")!=null?request.getParameter("combo_svc_provider"):"";
		String  so_no              = request.getParameter("so_no")!=null?request.getParameter("so_no"):"";
		String  wo_no              = request.getParameter("wo_no")!=null?request.getParameter("wo_no"):"";
       
		String  sCopNo              = request.getParameter("s_cop_no")!=null?request.getParameter("s_cop_no"):"";
		String  sCostActGrpSeq     = request.getParameter("s_cost_act_grp_seq")!=null?request.getParameter("s_cost_act_grp_seq"):"";
		
		String[] ibflag = request.getParameterValues("ibflag");
		String[] bkgNoList        =  request.getParameterValues("bkg_no");
		String[] cntrNoList       =  request.getParameterValues("cntr_no");
		String[] sel_cntr_no       =  request.getParameterValues("sel_cntr_no");

		String bkg_no = request.getParameter("bkg_no");
		String fm_nod_cd = request.getParameter("fm_nod_cd");
		String to_nod_cd = request.getParameter("to_nod_cd");
		String trsp_bnd_cd = request.getParameter("trsp_bnd_cd");

		
		event.setCopNo(request.getParameter("cop_no"));
		event.setCopNo(request.getParameter("trsp_cost_dtl_mod_cd"));
		event.setCopNo(request.getParameter("trsp_crr_mod_cd"));
		event.setFmNodYard(request.getParameter("fm_nod_yard"));
		event.setToNodYard(request.getParameter("to_nod_yard"));
		event.setViaNodCd(request.getParameter("via_nod_cd"));
		event.setViaNodYard(request.getParameter("via_nod_yard"));

		
		event.setIbflagList(ibflag);
		event.setBkg_noList(bkgNoList);
		event.setCntr_noList(cntrNoList);
		event.setSel_cntr_noList(sel_cntr_no);
		event.setVvdBkgNo(bkg_no);
		event.setFmNodCd(fm_nod_cd);
		event.setToNodCd(to_nod_cd);
		event.setTrspBndCd(trsp_bnd_cd);
		event.setCntFlg(cnt_flg);
		event.setSpotBidFlg(spot_bid_flg);
		event.setSpotBidNo(spot_bid_no);
		

		event.setFrm_plandate           (frm_plandate);
		event.setTo_plandate            (to_plandate);
		event.setTransmode              (transmode);
		event.setCostmode               (costmode);
		event.setBound                  (bound);
		event.setSearchFmLoc           (search_fm_loc);
		event.setSearchFmYard           (search_fm_yard);
		event.setSearchViaLoc          (search_via_loc);
		event.setSearchViaYard          (search_via_yard);
		event.setSearchDoorLoc          (search_door_loc);
		event.setSearchDoorYard          (search_door_yard);
		event.setSearchToLoc           (search_to_loc);
		event.setSearchToYard           (search_to_yard);
		event.setTrunkvvd               (trunkvvd);
		event.setBkgno                  (bkgno);
		event.setBillno                 (billno);
		event.setCntrno                 (cntrno);
		event.setContract_tp_cd         (contract_tp_cd);
		event.setContract_no            (contract_no);
		event.setSUnplannedShuttleFlag  (sUnplannedShuttleFlag);
		event.setSTroUnConfirmDoor      (sTroUnConfirmDoor);
		event.setSusa_rail              (susa_rail);
		event.setRad_dateSep            (rad_dateSep);
		event.setCtrl_so_office         (ctrl_so_office);
		event.setFeeder_vvd             (feeder_vvd);
		event.setTxt_feeder_vvd         (txt_feeder_vvd);
		event.setZip_code               (zip_code);
		event.setCydoor_div             (cydoor_div);
		event.setUi_conti_cd            (ui_conti_cd);
		event.setForm_usr_ofc_cd        (form_usr_ofc_cd);
		event.setForm_cre_usr_id        (form_cre_usr_id);
		event.setPrnt_ofc_cd        (prnt_ofc_cd);
		event.setCbstatus               (cbstatus);

		event.setSFmLocContiCd   (sFmLocContiCd);
		event.setSBoundCd        (sBoundCd);
		event.setSCneeCustCntCd  (sCneeCustCntCd);
		event.setSCneeCustSeq    (sCneeCustSeq);
		event.setSShprCustCntCd  (sShprCustCntCd);
		event.setSShprCustSeq    (sShprCustSeq);
		event.setSDoorNodCd      (sDoorNodCd);

		event.setRad_wo_issued      (rad_wo_issued);
		event.setCombo_svc_provider (combo_svc_provider);
		event.setSo_no              (so_no);
		event.setWo_no              (wo_no);
		
		event.setsCopNo(sCopNo);
		event.setsCostActGrpSeq(sCostActGrpSeq);

		event.setSingleTransportationVOs(tcz);	
		return  event;

		/* 
         ibSheet 사용시 fromRequestGrid를 사용하는데 
         prefix는 주로 멀티 Sheet 처리시에 사용하게 된다. (  sheet ID 형태의 prefix 구분자 ) 
         String prefix = "" ;  
         SINGLE_TRANSPORTATION_VO single_transportation_vo = SINGLE_TRANSPORTATION_VO.fromRequest(request);
		 */
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