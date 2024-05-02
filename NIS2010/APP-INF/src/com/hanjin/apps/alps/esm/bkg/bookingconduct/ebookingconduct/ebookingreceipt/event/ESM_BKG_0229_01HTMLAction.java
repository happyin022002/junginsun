/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0229HTMLAction.java
*@FileTitle : e-Booking & SI Process Detail(BOOKING)
*Open Issues :
*Change history :
*@LastModifyDate : 2009.07.02
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.07.02 전용진
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

//import java.util.ArrayList;
//import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;

// 이전 import
//import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
//import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsAkVO;
//import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsDgVO;
//import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsRfVO;
//import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
//import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
//import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO;
//import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
//import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroDtlVO;
//import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMstVO;
//import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroVO;
//import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkCgoVO;
//import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgRfCgoVO;
//import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoListVO;
//import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmBkgInfoVO;
//import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmVO;
//import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
//import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
//import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblVO;
//import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
//import com.hanjin.framework.component.util.JSPUtil;
//import com.hanjin.framework.component.util.object.ObjectCloner;
//import com.hanjin.syscommon.common.table.BkgCntrMfDescVO;
//import com.hanjin.syscommon.common.table.BkgCntrSealNoVO;
//import com.hanjin.syscommon.common.table.BkgQuantityVO;
//import com.hanjin.syscommon.common.table.BkgUsaCstmsFileNoVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EBookingConductSC로 실행요청<br>
 * - EBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jun Yong Jin
 * @see EBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0229_01HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0229HTMLAction 객체를 생성
	 */
	public ESM_BKG_0229_01HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg022901Event event = new EsmBkg022901Event();

		if(command.isCommand(FormCommand.DEFAULT)||command.isCommand(FormCommand.SEARCH)) {// 기본 조회
			event.setXterRqstNoVO((XterRqstNoVO)getVO(request, XterRqstNoVO.class));
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request,BkgBlNoVO.class));
		}
		else if(command.isCommand(FormCommand.SEARCH01)) { // cmdt_name
			event.setCmdtCd(request.getParameter("cmdt_cd"));
		}
		else if(command.isCommand(FormCommand.SEARCH02)) { // vessel name
			event.setBkgTrunkVvd(request.getParameter("bkg_trunk_vvd"));	
		}
//		else if(command.isCommand(FormCommand.SEARCH03)) { //find bkg -> search04로 변경
//			event.setXterRqstNoVO((XterRqstNoVO)getVO(request, XterRqstNoVO.class));
//			event.setBkgBlNoVO((BkgBlNoVO)getVO(request,BkgBlNoVO.class));
//		}
		else if(command.isCommand(FormCommand.SEARCH04)) {//find bkg
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request,BkgBlNoVO.class));
		}
		else if(command.isCommand(FormCommand.MODIFY01) || command.isCommand(FormCommand.MODIFY02)) {//reinstate/ cancel
			event.setXterRqstNoVOs((XterRqstNoVO[])getVOs(request, XterRqstNoVO.class, "sheet4_"));
		} 
		else if(command.isCommand(FormCommand.COMMAND04) || command.isCommand(FormCommand.COMMAND09)) { // black customer check
			event.setBlCustomerInfoVO((BlCustomerInfoVO)getVO(request, BlCustomerInfoVO.class));
			event.setBkgBookingInfoVO	((BkgBookingInfoVO)	getVO (request, BkgBookingInfoVO.class));
		}
		else if(command.isCommand(FormCommand.COMMAND05)) { //2011.07.18 추가(중국 Solid Waste 관련 bkg commodity validation 추가)
			event.setCmdtCd(request.getParameter("cmdt_cd"));
		}
		else if(command.isCommand(FormCommand.COMMAND06)) { //2015.06.10 추가 
			event.setLocCd(request.getParameter("loc_cd"));
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
		// 이전에 022901에서 한번에 upload 할려고 했을 때의 source -> 0229로 이동돼었음
//		else if(command.isCommand(FormCommand.MULTI01) || //bkg tab에서 바로 저장시(test 용) -> //사용 중지
//				command.isCommand(FormCommand.MULTI02) ||
//				command.isCommand(FormCommand.MULTI03) ||
//				command.isCommand(FormCommand.MULTI04)) {
//		event.setSaveBkgFlag(request.getParameter("save_bkg_flag"));
//		event.setSaveCustFlag(request.getParameter("save_cust_flag"));
//		event.setSaveCntrFlag(request.getParameter("save_cntr_flag"));
//		event.setSaveMndFlag(request.getParameter("save_mnd_flag"));
//		event.setSaveCmFlag(request.getParameter("save_cm_flag"));
//		event.setSaveTroFlag(request.getParameter("save_tro_flag"));
//		event.setSaveRfFlag(request.getParameter("save_rf_flag"));
//		event.setSaveDgFlag(request.getParameter("save_dg_flag"));
//		event.setSaveAkFlag(request.getParameter("save_ak_flag"));
//		event.setSaveHblFlag(request.getParameter("save_hbl_flag"));
//		event.setSaveHbl2Flag(request.getParameter("save_hbl2_flag"));

		// Booking
//			event.setXterRqstViaCd(JSPUtil.getParameter(request, "xter_rqst_via_cd"));
//			event.setMstBkgNo(request.getParameter("mst_bkg_no"));
//			event.setXerRqstSeq(request.getParameter("rqst_seq"));
//			event.setDocTpCd(request.getParameter("rqst_seq"));
//			event.setDocTpCd(request.getParameter("doc_tp_cd"));
//			event.setPctlNo(request.getParameter("pctl_no"));
//			event.setXterRqstNoVO((XterRqstNoVO)getVO(request, XterRqstNoVO .class));
//			event.setVslSkdVOs((VslSkdVO[])getVOs(request, VslSkdVO.class,"sheet3_"));
//			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
//			event.setBkgBookingInfoVO((BkgBookingInfoVO)getVO(request, BkgBookingInfoVO.class));
//			event.setBkgQuantityVOs((BkgQuantityVO[])getVOs(request, BkgQuantityVO.class,"sheet1_"));
//			event.setBlCustomerInfoVO((BlCustomerInfoVO)getVO(request, BlCustomerInfoVO.class));	
//		}
//		else if (command.isCommand(FormCommand.COMMAND02)) { // 저장 -> 0229로 이동 
			// 각 탭별 SAVE 여부 Flag -> 0229에서 전체 저장되는 것으로 바뀌면서 사용 중지(data가 이중으로 전달되는 것 방지)
//			event.setSaveBkgFlag(request.getParameter("save_bkg_flag"));
//			event.setSaveCustFlag(request.getParameter("save_cust_flag"));
//			event.setSaveCntrFlag(request.getParameter("save_cntr_flag"));
//			event.setSaveMndFlag(request.getParameter("save_mnd_flag"));
//			event.setSaveCmFlag(request.getParameter("save_cm_flag"));
//			event.setSaveTroFlag(request.getParameter("save_tro_flag"));
//			event.setSaveRfFlag(request.getParameter("save_rf_flag"));
//			event.setSaveDgFlag(request.getParameter("save_dg_flag"));
//			event.setSaveAkFlag(request.getParameter("save_ak_flag"));
//			event.setSaveHblFlag(request.getParameter("save_hbl_flag"));
//			event.setSaveHbl2Flag(request.getParameter("save_hbl2_flag"));
			
			// BKG_XTER_RQST_MST의 PK 정보, completeUpload 시 필요
//			event.setXterRqstNoVO((XterRqstNoVO)getVO(request, XterRqstNoVO .class));
//			event.setBkgBlNoVO((BkgBlNoVO) getVO(request, BkgBlNoVO.class));
			
			// Booking ESM_BKG_0229
//			if (request.getParameter("save_bkg_flag").equals("Y")) {
//				EsmBkg022901Event esmBkg022901Event = new EsmBkg022901Event();
//				
//				FormCommand fcmd = new FormCommand();
//				fcmd.setCommand(Integer.parseInt(JSPUtil.getParameter(request, "t1_f_cmd", "-1")));
//				esmBkg022901Event.setFormCommand(fcmd);
//				
//				esmBkg022901Event.setXterRqstViaCd(JSPUtil.getParameter(request, "t1_xter_rqst_via_cd"));
//				esmBkg022901Event.setMstBkgNo(request.getParameter("t1_mst_bkg_no"));
//				esmBkg022901Event.setXerRqstSeq(request.getParameter("t1_rqst_seq"));
//				esmBkg022901Event.setDocTpCd(request.getParameter("t1_doc_tp_cd"));
//				esmBkg022901Event.setPctlNo(request.getParameter("t1_pctl_no"));
//				event.setXterRqstNoVO((XterRqstNoVO)getVO(request, XterRqstNoVO .class));
//				XterRqstNoVO xterRqstNoVO = new XterRqstNoVO();
//				xterRqstNoVO.fromRequest(request, "t1_");
//				esmBkg022901Event.setXterRqstNoVO(xterRqstNoVO);
				
//				esmBkg022901Event.setVslSkdVOs((VslSkdVO[])getVOs(request, VslSkdVO.class,"t1_sheet3_"));
//				event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
				
//				BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
//				bkgBlNoVO.fromRequest(request, "t1_");
//				esmBkg022901Event.setBkgBlNoVO(bkgBlNoVO);
//				
//				esmBkg022901Event.setBkgBookingInfoVO((BkgBookingInfoVO)getVO(request, BkgBookingInfoVO.class));
//				BkgBookingInfoVO bkgBookingInfoVO = new BkgBookingInfoVO();
//				bkgBookingInfoVO.fromRequest(request, "t1_");
				
				// Booking 이 eBKG을 통해 생성되었음을 표시
//				bkgBookingInfoVO.setXterBkgRqstCd(JSPUtil.getParameter(request, "t1_xter_rqst_via_cd"));
//				bkgBookingInfoVO.setXterBkgRqstRefNo(JSPUtil.getParameter(request, "t1_rqst_no2"));
				
				// Customer 부터 ~ House B/L 2 중 하나라도 eBKG & eSI를 통해 업데이트 되면
				// 어떤 경로를 통해 Update 되었는지 표시
//				if (event.getSaveCustFlag().equals("Y") ||
//					event.getSaveCntrFlag().equals("Y") ||
//					event.getSaveMndFlag().equals("Y") ||
//					event.getSaveCmFlag().equals("Y") ||
//					event.getSaveTroFlag().equals("Y") ||
//					event.getSaveRfFlag().equals("Y") ||
//					event.getSaveDgFlag().equals("Y") ||
//					event.getSaveAkFlag().equals("Y") ||
//					event.getSaveHblFlag().equals("Y") ||
//					event.getSaveHbl2Flag().equals("Y")) {
//				if("S".equals(esmBkg022901Event.getDocTpCd())){
//					bkgBookingInfoVO.setSiFlg("Y");
//					bkgBookingInfoVO.setXterSiCd(JSPUtil.getParameter(request, "t1_xter_rqst_via_cd"));
//					bkgBookingInfoVO.setXterSiRefNo(JSPUtil.getParameter(request, "t1_rqst_no2"));
//				}
			
//				esmBkg022901Event.setBkgBookingInfoVO(bkgBookingInfoVO);
				
//				esmBkg022901Event.setBkgQuantityVOs((BkgQuantityVO[])getVOs(request, BkgQuantityVO.class,"t1_sheet1_"));
				
//				esmBkg022901Event.setBlCustomerInfoVO((BlCustomerInfoVO)getVO(request, BlCustomerInfoVO.class));
//				BlCustomerInfoVO blCustomerInfoVO = new BlCustomerInfoVO();
//				blCustomerInfoVO.fromRequestGrid(request, "t1_");
//				esmBkg022901Event.setBlCustomerInfoVO(blCustomerInfoVO);
				
//				event.setEsmBkg022901Event(esmBkg022901Event);
//			}
			
			// Customer ESM_BKG_0229_02
//			if (request.getParameter("save_cust_flag").equals("Y")) {
//				EsmBkg022902Event esmBkg022902Event = new EsmBkg022902Event();
//				
//				esmBkg022902Event.setXterRqstNoVO((XterRqstNoVO)getVO(request, XterRqstNoVO.class));
//				esmBkg022902Event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
//				esmBkg022902Event.setBlDocCustVOs((BlDocCustVO[])getVOs(request, BlDocCustVO.class, "t2_sheet1_"));
//				esmBkg022902Event.setCustEtcVOs((CustEtcVO[])getVOs(request, CustEtcVO.class, "t2_sheet1_"));
//				
//				event.setEsmBkg022902Event(esmBkg022902Event);
//			}
			// Container ESM_BKG_0229_03
//			if (request.getParameter("save_cntr_flag").equals("Y")) {
//				EsmBkg022903Event esmBkg022903Event = new EsmBkg022903Event();
//				
//				esmBkg022903Event.setBkgNo(JSPUtil.getParameter(request, "bkg_no",  ""));
//
//		        CntrEtcInfoVO bkgEtcInfoVO = (CntrEtcInfoVO) getVO(request, CntrEtcInfoVO.class);
//		        ContainerVO[] containerVOs = (ContainerVO[]) getVOs(request, ContainerVO.class, "t3_sheet1_");
//		        BkgCntrSealNoVO[] bkgCntrSealNoVOs = (BkgCntrSealNoVO[]) getVOs(request, BkgCntrSealNoVO.class, "t3_sheet2_");
//
//		        esmBkg022903Event.setBkgEtcInfoVO(bkgEtcInfoVO);
//		        esmBkg022903Event.setContainerVOs(containerVOs);
//		        esmBkg022903Event.setBkgCntrSealNoVOs(bkgCntrSealNoVOs);
//		        
//		        event.setEsmBkg022903Event(esmBkg022903Event);
//			}
			// M&D ESM_BKG_0229_04
//			if (request.getParameter("save_mnd_flag").equals("Y")) {
//				EsmBkg022904Event esmBkg022904Event = new EsmBkg022904Event();
//				
//				MndVO mndVO = new MndVO();
//				mndVO.fromRequest(request, "t4_");
//				esmBkg022904Event.setMndVO(mndVO);
//		        
//		        event.setEsmBkg022904Event(esmBkg022904Event);
//			}
			// C/M ESM_BKG_0229_05
//			if (request.getParameter("save_cm_flag").equals("Y")) {
//				EsmBkg022905Event esmBkg022905Event = new EsmBkg022905Event();
//				
//				CmBkgInfoVO cmBkgInfoVO = new CmBkgInfoVO();
//				cmBkgInfoVO.fromRequest(request, "t5_");
//	            BkgCntrMfDescVO[] bkgCntrMfDescVOs = (BkgCntrMfDescVO[]) getVOs(request, BkgCntrMfDescVO.class, "t5_sheet1_");
//
//	            CmVO cmVO = new CmVO();
//	            cmVO.setCmBkgInfoVO(cmBkgInfoVO);
//	            cmVO.setCntrMfDescVOs(getBkgCntrMfDescVOList(bkgCntrMfDescVOs));
//
//	            esmBkg022905Event.setCmVO(cmVO);
//		        
//		        event.setEsmBkg022905Event(esmBkg022905Event);
//			}
			// TRO ESM_BKG_0229_06
//			if (request.getParameter("save_tro_flag").equals("Y")) {
//				EsmBkg022906Event esmBkg022906Event = new EsmBkg022906Event();
//
//				//화면고정용 Key Value : (io_bnd_cd, rtn_tro_seq)
//				esmBkg022906Event.setIsEurFlg  (request.getParameter("t6_is_eur_flg"));
//				
//				String ioBndCd   = request.getParameter("t6_io_bnd_cd");
//				String rtnTroFlg = request.getParameter("t6_rtn_tro_flg");
//				String delFlg    = request.getParameter("t6_f_del_flg");
//				esmBkg022906Event.setBoundCd  (ioBndCd);    //'O'
//				esmBkg022906Event.setRtnTroFlg(rtnTroFlg);  //'N'
//				esmBkg022906Event.setDelFlg   (delFlg);     //'N'
//				
//				//CurrSeq 초기화
//				esmBkg022906Event.setCurrTroSeq(JSPUtil.getNullNoTrim(request.getParameter("t6_curr_tro_seq")));
//				
//				//BkgBlNoVO setting	
//				BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
//				bkgBlNoVO.fromRequest(request, "t6_");
//				
//				esmBkg022906Event.setBkgBlNoVO(bkgBlNoVO);
//			
//				//다중처리 : containerVO 사용
//				TroVO troVO = new TroVO();
//				
//				troVO.setArrTroMstVO((TroMstVO[])getVOs(request, TroMstVO.class, "t6_sheet3_"));
//				troVO.setArrTroDtlVO((TroDtlVO[])getVOs(request, TroDtlVO.class, "t6_sheet1_"));
//				troVO.setEBkgFlg  ("Y");     //eBooking 여부 : 현재 사용되지않음.
//				troVO.setBkgNo    (event.getBkgBlNoVO().getBkgNo());
//				troVO.setIoBndCd  (ioBndCd);
//				troVO.setRtnTroFlg(rtnTroFlg);
//				
//				esmBkg022906Event.setTroVO(troVO);
//				
//				event.setEsmBkg022906Event(esmBkg022906Event);
//			}
			// RF ESM_BKG_0229_07
//			if (request.getParameter("save_rf_flag").equals("Y")) {
//				EsmBkg022907Event esmBkg022907Event = new EsmBkg022907Event();
//				
//				// Reefer
//				AlpsRfVO[] nisRfVOs = (AlpsRfVO[]) getVOs(request, AlpsRfVO .class,"t7_t7sheet1_");
//				int iMaxRcSeq = 0;
//				int iDataCnt = 0;
//				if (!"".equals(nisRfVOs[0].getMaxRcSeq())) {
//					iMaxRcSeq = Integer.parseInt(nisRfVOs[0].getMaxRcSeq());
//				}
//				for (int i=0; i<nisRfVOs.length; i++) {
//					if ("I".equals(nisRfVOs[i].getIbflag())) {
//						nisRfVOs[i].setRcSeq((iMaxRcSeq + 1) + "");
//						iMaxRcSeq++;
//						iDataCnt++;
//					} else if ("U".equals(nisRfVOs[i].getIbflag()) || "D".equals(nisRfVOs[i].getIbflag())) {
//						iDataCnt++;
//					}
//				}
//				BkgRfCgoVO[] bkgRfCgoVO 	= new BkgRfCgoVO[iDataCnt];
//				for (int i=0, j=0; i<nisRfVOs.length; i++) {
//					if (!"R".equals(nisRfVOs[i].getIbflag())) {
//						bkgRfCgoVO[j] = new BkgRfCgoVO();
//						ObjectCloner.build(nisRfVOs[i], bkgRfCgoVO[j]);
//						bkgRfCgoVO[j].setRfDcgoSeq("");
//						bkgRfCgoVO[j].setPckTpCd("");
//
//						j++;
//					}
//				}
//				esmBkg022907Event.setBkgRfCgoVOs(bkgRfCgoVO);
//				
//				event.setEsmBkg022907Event(esmBkg022907Event);
//			}
			// DG ESM_BKG_0229_08
//			if (request.getParameter("save_dg_flag").equals("Y")) {
//				EsmBkg022908Event esmBkg022908Event = new EsmBkg022908Event();
//				
//				// DG
//				boolean bCntrCgoSeq = false;
//				int iMaxDgCntrSeq = 0;
//				AlpsDgVO[] nisDgVOs = (AlpsDgVO[]) getVOs(request, AlpsDgVO.class, "t8_t8sheet1_");
//				int iDataCnt = 0;
//				for (int i = 0; i < nisDgVOs.length; i++)
//				{
//					// 신규일때
//					if ("I".equals(nisDgVOs[i].getIbflag()) || "U".equals(nisDgVOs[i].getIbflag()))
//					{
//						//
//						if (!"".equals(nisDgVOs[i].getCntrNo()))
//						{
//							for (int j = 0; j < nisDgVOs.length; j++)
//							{
//								if (nisDgVOs[i].getCntrNo().equals(nisDgVOs[j].getCntrNo()))
//								{
//									nisDgVOs[i].setCntrCgoSeq((Integer.parseInt(nisDgVOs[j].getMaxCntrCgoSeq()) + 1) + "");
//									nisDgVOs[j].setMaxCntrCgoSeq((Integer.parseInt(nisDgVOs[j].getMaxCntrCgoSeq()) + 1)
//											+ "");
//									nisDgVOs[i].setDgCntrSeq(nisDgVOs[j].getDgCntrSeq());
//									bCntrCgoSeq = true;
//									break;
//								}
//							}
//							if (!bCntrCgoSeq)
//							{
//								nisDgVOs[i].setCntrCgoSeq("1");
//								for (int j = 0; j < nisDgVOs.length; j++)
//								{
//									if (iMaxDgCntrSeq < Integer.parseInt(nisDgVOs[j].getMaxDgCntrSeq()))
//									{
//										iMaxDgCntrSeq = Integer.parseInt(nisDgVOs[j].getMaxDgCntrSeq());
//									}
//								}
//								nisDgVOs[i].setDgCntrSeq((iMaxDgCntrSeq + 1) + "");
//								bCntrCgoSeq = false;
//							}
//						}
//						else
//						{
//							nisDgVOs[i].setCntrCgoSeq("1");
//							for (int j = 0; j < nisDgVOs.length; j++)
//							{
//								if (!"".equals(nisDgVOs[j].getMaxDgCntrSeq())
//										&& iMaxDgCntrSeq < Integer.parseInt(nisDgVOs[j].getMaxDgCntrSeq()))
//								{
//									iMaxDgCntrSeq = Integer.parseInt(nisDgVOs[j].getMaxDgCntrSeq());
//									nisDgVOs[j].setMaxDgCntrSeq((iMaxDgCntrSeq + 1) + "");
//								}
//							}
//							nisDgVOs[i].setDgCntrSeq((iMaxDgCntrSeq + 1) + "");
//						}
//						iDataCnt++;
//					}
//					else if ("D".equals(nisDgVOs[i].getIbflag()))
//					{
//						iDataCnt++;
//					}
//					if ("".equals(nisDgVOs[i].getGrsWgt()))
//					{
//						nisDgVOs[i].setGrsWgt("0");
//					}
//				}
//				DgCgoListVO[] dgCgoListVOs = new DgCgoListVO[iDataCnt];
//				for (int i = 0, j = 0; i < nisDgVOs.length; i++)
//				{
//					if (!"R".equals(nisDgVOs[i].getIbflag()))
//					{
//						dgCgoListVOs[j] = new DgCgoListVO();
//						ObjectCloner.build(nisDgVOs[i], dgCgoListVOs[j]);
//						dgCgoListVOs[j].setInImdgPckCd1("");
//						dgCgoListVOs[j].setInImdgPckCd2("");
//						dgCgoListVOs[j].setOutImdgPckCd1("");
//						dgCgoListVOs[j].setOutImdgPckCd2("");
//						j++;
//					}
//				}
//				esmBkg022908Event.setDgCgoListVOs(dgCgoListVOs);
//				
//				event.setEsmBkg022908Event(esmBkg022908Event);
//			}
			// AK ESM_BKG_0229_09
//			if (request.getParameter("save_ak_flag").equals("Y")) {
//				EsmBkg022909Event esmBkg022909Event = new EsmBkg022909Event();
//					
//				// AWK
//				AlpsAkVO[] nisAkVO = (AlpsAkVO[]) getVOs(request, AlpsAkVO.class, "t9_t9sheet1_");
//				int iMaxAwkSeq = 0;
//				int iDataCnt = 0;
//				if (!"".equals(nisAkVO[0].getMaxAwkCgoSeq()))
//				{
//					iMaxAwkSeq = Integer.parseInt(nisAkVO[0].getMaxAwkCgoSeq());
//				}
//				for (int i = 0; i < nisAkVO.length; i++)
//				{
//					if ("I".equals(nisAkVO[i].getIbflag()))
//					{
//						nisAkVO[i].setAwkCgoSeq((iMaxAwkSeq + 1) + "");
//						iMaxAwkSeq++;
//						iDataCnt++;
//					}
//					else if ("U".equals(nisAkVO[i].getIbflag()) || "D".equals(nisAkVO[i].getIbflag()))
//					{
//						iDataCnt++;
//					}
//				}
//				BkgAwkCgoVO[] bkgAwkCgoVO = new BkgAwkCgoVO[iDataCnt];
//				for (int i = 0, j = 0; i < nisAkVO.length; i++)
//				{
//					if (!"R".equals(nisAkVO[i].getIbflag()))
//					{
//						bkgAwkCgoVO[j] = new BkgAwkCgoVO();
//						ObjectCloner.build(nisAkVO[i], bkgAwkCgoVO[j]);
//						bkgAwkCgoVO[j].setAwkDcgoSeq("");
//						j++;
//					}
//				}
//				
//				esmBkg022909Event.setBkgAwkCgoVOs(bkgAwkCgoVO);
//				event.setEsmBkg022909Event(esmBkg022909Event);
//			}
			// HBL1 ESM_BKG_0229_10
//			if (request.getParameter("save_hbl_flag").equals("Y")) {
//				EsmBkg022910Event esmBkg022910Event = new EsmBkg022910Event();
//				
///*	            BkgCntrMfDescVO[] vo2 = null;
//	            HblDtlInfoVO[] vo3 = (HblDtlInfoVO[]) getVOs(request, HblDtlInfoVO.class, "t10_t10sheet1_");*/
//
//	            HblVO hblVO = new HblVO();
//	            
//	            esmBkg022910Event.setHblVO(hblVO);
//	            event.setEsmBkg022910Event(esmBkg022910Event);
//	            
//			}
//			// HBL2 ESM_BKG_0229_11
//			if (request.getParameter("save_hbl2_flag").equals("Y")) {
//				EsmBkg022911Event esmBkg022911Event = new EsmBkg022911Event();
//
//				esmBkg022911Event.setBkgUsaCstmsFileNoVOs((BkgUsaCstmsFileNoVO[])getVOs(request, BkgUsaCstmsFileNoVO.class, "t11_t11sheet1_"));
//				
//				event.setEsmBkg022911Event(esmBkg022911Event);
//			}
//		}
//		else if(command.isCommand(FormCommand.MULTI01) ||
//				command.isCommand(FormCommand.MULTI02) ||
//				command.isCommand(FormCommand.MULTI03) ||
//				command.isCommand(FormCommand.MULTI04) ||
//				command.isCommand(FormCommand.MULTI05)) {//<-- createPctlNo()
//		}

    /**
    *
    * @param vos
    * @return
    */
/*
   private List<CmCntrInfoVO> getCmCntrInfoVOList(CmCntrInfoVO[] vos){
       List<CmCntrInfoVO> list = new ArrayList<CmCntrInfoVO>();
       int len = (vos == null) ? 0 : vos.length;
       for(int i=0;i<len; i++){
           list.add(vos[i]);
       }
       return list;
   }
*/

   /**
    *
    * @param vos
    * @return
    */
//   private List<BkgCntrMfDescVO> getBkgCntrMfDescVOList(BkgCntrMfDescVO[] vos){
//       List<BkgCntrMfDescVO> list = new ArrayList<BkgCntrMfDescVO>();
//       int len = (vos == null) ? 0 : vos.length;
//       for(int i=0;i<len; i++){
//           list.add(vos[i]);
//       }
//       return list;
//   }

   /**
   *
   * @param vos
   * @return
   */
/*  private List<HblDtlInfoVO> getHblDtlInfoVOList(HblDtlInfoVO[] vos){
      List<HblDtlInfoVO> list = new ArrayList<HblDtlInfoVO>();
      int len = (vos == null) ? 0 : vos.length;
      for(int i=0;i<len; i++){
          list.add(vos[i]);
      }
      return list;
  }*/

}