/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ESM_BKG_0229_01HTMLAction.java
*@FileTitle : e-Booking & SI Process Top
*Open Issues :
*Change history :
*@LastModifyDate : 2009.06.15
*@LastModifier : 전용진
*@LastVersion : 1.0
* 2009.06.15 전용진
* 1.0 Creation
* -------------------------------------------------------
* HISTORY
* 2010.11.04 김영철 [] Booking Creation / Update / Cancel시, Vessel Operation 모듈의 Final CBF 생성 여부를 체크해서 경고 메시지
* 2012.12.28 이재위 [CLT-121108456-01] [BKG] E-BKG 화면에서 Special Cargo 삭제 후 Upload 시 오류 발생 건
=========================================================*/
package com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.clt.apps.opus.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusAkVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusDgVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusRfVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.OpusXptImpLicListVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.EurTroMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroDtlVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMstVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkCgoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgRfCgoVO;
import com.clt.apps.opus.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoListVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.BkgCntrShpVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmBkgInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblDtlInfoVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.clt.apps.opus.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DocRqstVO;
import com.clt.bizcommon.util.BizComUtil;
import com.clt.framework.component.util.JSPUtil;
import com.clt.framework.component.util.object.ObjectCloner;
import com.clt.framework.core.controller.html.HTMLActionException;
import com.clt.framework.core.layer.event.Event;
import com.clt.framework.core.layer.event.EventResponse;
import com.clt.framework.support.controller.HTMLActionSupport;
import com.clt.framework.support.controller.html.FormCommand;
import com.clt.syscommon.common.table.BkgCntrMfDescVO;
import com.clt.syscommon.common.table.BkgCntrSealNoVO;
import com.clt.syscommon.common.table.BkgImgStoVO;
import com.clt.syscommon.common.table.BkgQtyDtlVO;
import com.clt.syscommon.common.table.BkgQuantityVO;
import com.clt.syscommon.common.table.BkgRefDtlVO;
import com.clt.syscommon.common.table.BkgReferenceVO;
import com.clt.syscommon.common.table.BkgUsaCstmsFileNoVO;

/**
 * HTTP Parser<br>
 * - com.clt.apps.opus.esm.bkg.bookingconduct.ebookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
 * - Parsing 한 정보를 Event로 변환, request에 담아 EBookingConductSC로 실행요청<br>
 * - EBookingConductSC에서 View(JSP)로 실행결과를 전송하는 EventResponse를 request에 셋팅<br>
 * @author Jun Yong Jin
 * @see EBookingConductEvent 참조
 * @since J2EE 1.6
 */

public class ESM_BKG_0229HTMLAction extends HTMLActionSupport {

	private static final long serialVersionUID = 1L;
	/**
	 * ESM_BKG_0229_01HTMLAction 객체를 생성
	 */
	public ESM_BKG_0229HTMLAction() {}

	/**
	 * HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
	 * HttpRequst의 정보를 EBookingConductEvent로 파싱하여 request에 셋팅<br>
	 * @param request HttpServletRequest HttpRequest
	 * @return Event Event interface를 구현한 객체
	 * @exception HTMLActionException
	 */
	public Event perform(HttpServletRequest request) throws HTMLActionException {
    	FormCommand command = FormCommand.fromRequest(request);
		EsmBkg0229Event event = new EsmBkg0229Event();

		if(command.isCommand(FormCommand.SEARCH)) {//미사용
			event.setXterRqstNoVO((XterRqstNoVO)getVO(request, XterRqstNoVO .class));
		}
		else if (command.isCommand(FormCommand.COMMAND03)) { // cancel
			// BKG_XTER_RQST_MST의 PK 정보, completeUpload 시 필요
			event.setXterRqstNoVO((XterRqstNoVO)getVO(request, XterRqstNoVO .class));			
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setCloseBkgFlag(request.getParameter("close_bkg_flag"));
			event.setCbfBkgFlag(request.getParameter("cbf_bkg_flag"));
			
			EsmBkg022901Event esmBkg022901Event = new EsmBkg022901Event();
//			esmBkg022901Event.setAutoNotification(request.getParameter("t1_auto_notification"));
			esmBkg022901Event.setAutoNotification(request.getParameter("auto_notification"));
			esmBkg022901Event.setBkgCntcPsonEml(request.getParameter("bkg_cntc_pson_eml"));
			esmBkg022901Event.setDocTpCd(request.getParameter("doc_tp_cd"));
			
			event.setEsmBkg022901Event(esmBkg022901Event);
		}
		else if (command.isCommand(FormCommand.COMMAND02)) {
			
			log.error("\n [[[ ESM_BKG_0229HTMLAction COMMAND02 ]]]");
			log.error("\n [[[ " + BizComUtil.getRequestParameteToString(request)  + " ]]]");
			
			// 각 탭별 SAVE 여부 Flag
			event.setSaveBkgFlag (request.getParameter("save_bkg_flag"));
			event.setSaveCustFlag(request.getParameter("save_cust_flag"));
			event.setSaveCntrFlag(request.getParameter("save_cntr_flag"));
			event.setSaveMndFlag (request.getParameter("save_mnd_flag"));
			event.setSaveCmFlag  (request.getParameter("save_cm_flag"));
			event.setSaveTroFlag (request.getParameter("save_tro_flag"));
			event.setSaveRfFlag  (request.getParameter("save_rf_flag"));
			event.setSaveDgFlag  (request.getParameter("save_dg_flag"));
			event.setSaveAkFlag  (request.getParameter("save_ak_flag"));
			event.setSaveHblFlag (request.getParameter("save_hbl_flag"));
			event.setSaveHbl2Flag(request.getParameter("save_hbl2_flag"));
			
			// BKG_XTER_RQST_MST의 PK 정보, completeUpload 시 필요
			XterRqstNoVO xterRqstNoVO = (XterRqstNoVO)getVO(request, XterRqstNoVO .class);
			event.setXterRqstNoVO(xterRqstNoVO);
			
			BkgBlNoVO bkgBlNoVO = (BkgBlNoVO)getVO(request, BkgBlNoVO .class);
			event.setBkgBlNoVO(bkgBlNoVO);
			
			BkgBookingInfoVO t1BkgBookingInfoVO = new BkgBookingInfoVO();
			
//			ContainerVO[] containerVOs = null;
			ContainerVO[] containerVOs = (ContainerVO[]) getVOs(request, ContainerVO.class, "t3_sheet1_");

			String actWgt ="";
			String wgtUtCd = "";
			String pckQty = "";
			String pckTpCd = "";
			String podCd = "";
			// Booking ESM_BKG_0229
			if (request.getParameter("save_bkg_flag").equals("Y")) {
				EsmBkg022901Event esmBkg022901Event = new EsmBkg022901Event();
				
//				FormCommand fcmd = new FormCommand();
				command.setCommand(Integer.parseInt(JSPUtil.getParameter(request, "t1_f_cmd", "-1")));
				esmBkg022901Event.setFormCommand(command);				
				esmBkg022901Event.setXterRqstViaCd(JSPUtil.getParameter(request, "t1_xter_rqst_via_cd"));
				esmBkg022901Event.setMstBkgNo(request.getParameter("t1_mst_bkg_no"));
				esmBkg022901Event.setXerRqstSeq(request.getParameter("t1_rqst_seq"));
				esmBkg022901Event.setDocTpCd(request.getParameter("t1_doc_tp_cd"));
				esmBkg022901Event.setPctlNo(request.getParameter("t1_pctl_no"));
				esmBkg022901Event.setCaRsnCd(request.getParameter("t1_ca_rsn_cd"));
				esmBkg022901Event.setBkgCorrRmk(request.getParameter("t1_bkg_corr_rmk"));
				esmBkg022901Event.setBdrFlg(request.getParameter("t1_bdr_flg"));
				esmBkg022901Event.setAutoNotification(request.getParameter("t1_auto_notification"));
				esmBkg022901Event.setBkgPolCd(request.getParameter("t1_bkg_pol_cd"));

//				event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
//				BkgBlNoVO bkgBlNoVO = new BkgBlNoVO();
//				bkgBlNoVO.fromRequest(request, "t1_");
				esmBkg022901Event.setBkgBlNoVO(bkgBlNoVO);
				
//				event.setXterRqstNoVO((XterRqstNoVO)getVO(request, XterRqstNoVO .class));
//				XterRqstNoVO xterRqstNoVO = new XterRqstNoVO();
//				xterRqstNoVO.fromRequest(request, "t1_");
				esmBkg022901Event.setXterRqstNoVO(xterRqstNoVO);
				
				esmBkg022901Event.setVslSkdVOs((VslSkdVO[])getVOs(request, VslSkdVO.class,"t1_sheet3_"));							

				esmBkg022901Event.setDocRqstVO((DocRqstVO)getVO(request, DocRqstVO .class));
				
//				esmBkg022901Event.setBkgBookingInfoVO((BkgBookingInfoVO)getVO(request, BkgBookingInfoVO.class));
				t1BkgBookingInfoVO.fromRequest(request, "t1_");
				t1BkgBookingInfoVO.setModifyCargoFlg(request.getParameter("modify_cargo_flg"));
				esmBkg022901Event.setBkgBookingInfoVO(t1BkgBookingInfoVO);
				podCd = t1BkgBookingInfoVO.getBkgPodCd();
				
				BookingSaveValidationVO bookingSaveValidationVO = new BookingSaveValidationVO();
				bookingSaveValidationVO.fromRequest(request, "t1_");
				esmBkg022901Event.setBookingSaveValidationVO(bookingSaveValidationVO);
						
				esmBkg022901Event.setBkgQuantityVOs((BkgQuantityVO[])getVOs(request, BkgQuantityVO.class,"t1_sheet1_"));
				esmBkg022901Event.setBkgQtyDtlVOs((BkgQtyDtlVO[])getVOs(request, BkgQtyDtlVO.class,"t1_sheet5_"));
				
//				esmBkg022901Event.setBlCustomerInfoVO((BlCustomerInfoVO)getVO(request, BlCustomerInfoVO.class));
				BlCustomerInfoVO blCustomerInfoVO = new BlCustomerInfoVO();
				blCustomerInfoVO.fromRequest(request, "t1_");
				esmBkg022901Event.setBlCustomerInfoVO(blCustomerInfoVO);
				
				event.setEsmBkg022901Event(esmBkg022901Event);
			}
			
			// Customer ESM_BKG_0229_02
			if (request.getParameter("save_cust_flag").equals("Y")) {
				EsmBkg022902Event esmBkg022902Event = new EsmBkg022902Event();
				
//				esmBkg022902Event.setXterRqstNoVO((XterRqstNoVO)getVO(request, XterRqstNoVO.class));				
//				esmBkg022902Event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
//				esmBkg022902Event.setCustEtcVO((CustEtcVO)getVO(request, CustEtcVO.class, "t2_"));
//				esmBkg022902Event.setBlDocCustVO((BlDocCustVO)getVO(request, BlDocCustVO.class, "t2_"));
//				esmBkg022902Event.setBlDocCustVOs((BlDocCustVO[])getVOs(request, BlDocCustVO.class, "t2_"));
//				esmBkg022902Event.setCustEtcVOs((CustEtcVO[])getVOs(request, CustEtcVO.class, "t2_"));
				
				esmBkg022902Event.setXterRqstNoVO(xterRqstNoVO);
//				esmBkg022902Event.setBkgBlNoVO(bkgBlNoVO);//sc에서 넘겨줌
				BlDocCustVO blDocCustVO = new BlDocCustVO();
				blDocCustVO.fromRequest(request, "t2_");
				esmBkg022902Event.setBlDocCustVO(blDocCustVO);
				XterRqstMstVO xterRqstMstVO = new XterRqstMstVO();
				xterRqstMstVO.fromRequest(request, "t1_");
				esmBkg022902Event.setXterRqstMstVO(xterRqstMstVO);
				
				CustEtcVO custEtcVO = new CustEtcVO();
				custEtcVO.fromRequest(request, "t2_");
				esmBkg022902Event.setCustEtcVO(custEtcVO);
				event.setEsmBkg022902Event(esmBkg022902Event);
			}
			// Container ESM_BKG_0229_03
			if (request.getParameter("save_cntr_flag").equals("Y")) {
				EsmBkg022903Event esmBkg022903Event = new EsmBkg022903Event();
				
//				esmBkg022903Event.setBkgNo(JSPUtil.getParameter(request, "bkg_no",  ""));//sc에서 넘겨줌

//				BkgBookingInfoVO bkgBookingInfoVO = new BkgBookingInfoVO();
//				bkgBookingInfoVO.fromRequest(request, "t1_");
//				esmBkg022903Event.setBkgBookingInfoVO(t1BkgBookingInfoVO);//불필요		
		        CntrEtcInfoVO bkgEtcInfoVO = (CntrEtcInfoVO) getVO(request, CntrEtcInfoVO.class);
//		        containerVOs = (ContainerVO[]) getVOs(request, ContainerVO.class, "t3_sheet1_");
		        BkgCntrSealNoVO[] bkgCntrSealNoVOs = (BkgCntrSealNoVO[]) getVOs(request, BkgCntrSealNoVO.class, "t3_sheet2_");

		        esmBkg022903Event.setBkgEtcInfoVO(bkgEtcInfoVO);
		        esmBkg022903Event.setContainerVOs(containerVOs);
		        esmBkg022903Event.setBkgCntrSealNoVOs(bkgCntrSealNoVOs);
		        
		        event.setEsmBkg022903Event(esmBkg022903Event);
			}
			// M&D ESM_BKG_0229_04
			if (request.getParameter("save_mnd_flag").equals("Y")) {
				EsmBkg022904Event esmBkg022904Event = new EsmBkg022904Event();
				
				MndVO mndVO = new MndVO();
				mndVO.fromRequest(request, "t4_");
				esmBkg022904Event.setMndVO(mndVO);
		        
				actWgt = mndVO.getActWgt();
				wgtUtCd = mndVO.getWgtUtCd();
				pckQty = mndVO.getPckQty();
				pckTpCd = mndVO.getPckTpCd();

				BkgReferenceVO[] poOtherBkgRefVOs 	= (BkgReferenceVO[])getVOs(request, BkgReferenceVO.class,"t4_sheet2_");
				BkgReferenceVO[] poOtherCntrVOs 	= (BkgReferenceVO[])getVOs(request, BkgReferenceVO.class,"t4_sheet3_");
				BkgRefDtlVO[] 	 poOtherCmVOs 		= (BkgRefDtlVO[])getVOs(request, BkgRefDtlVO.class,"t4_sheet4_");
				BkgRefDtlVO[]  	 poOtherShipVOs		= (BkgRefDtlVO[])getVOs(request, BkgRefDtlVO.class,"t4_sheet5_");
				
				esmBkg022904Event.setPoOtherNoBkgVOs(poOtherBkgRefVOs);
				esmBkg022904Event.setPoOtherCntrVOs(poOtherCntrVOs);
				esmBkg022904Event.setPoOtherCmVOs(poOtherCmVOs);
				esmBkg022904Event.setPoOtherShipVOs(poOtherShipVOs);
				esmBkg022904Event.setOpusXptImpLicListVOs((OpusXptImpLicListVO[]) getVOs(request, OpusXptImpLicListVO.class, "t4_sheet1_"));
		        event.setEsmBkg022904Event(esmBkg022904Event);
			}
			// C/M ESM_BKG_0229_05
			if (request.getParameter("save_cm_flag").equals("Y")) {
				EsmBkg022905Event esmBkg022905Event = new EsmBkg022905Event();
				
				// Continer 정보를 가지고 Delete 해야 할 Container를 찾기 위하여 
				// 0229_03 처리시 미리 찾아놓은 containerVOs
				if (!"Y".equals(request.getParameter("save_cntr_flag"))) {
					esmBkg022905Event.setContainerVOs(null);					
				}else{
					esmBkg022905Event.setContainerVOs(containerVOs);
				}
				CmBkgInfoVO cmBkgInfoVO = new CmBkgInfoVO();
				cmBkgInfoVO.fromRequest(request, "t5_");
		        
	            // M&D에서 PCK, WGT 값을 가지고 오기 위해서
				cmBkgInfoVO.setBkgNo(bkgBlNoVO.getBkgNo());
				cmBkgInfoVO.setBkgWgtQty(actWgt);
				cmBkgInfoVO.setBkgWgtUnit(wgtUtCd);
				cmBkgInfoVO.setBkgPckQty(pckQty);
				cmBkgInfoVO.setBkgPckUnit(pckTpCd);
				cmBkgInfoVO.setPodCd(podCd);
	            
	            CmVO cmVO = new CmVO();
	            cmVO.setCmBkgInfoVO(cmBkgInfoVO);

	            BkgCntrMfDescVO[] bkgCntrMfDescVOs = (BkgCntrMfDescVO[]) getVOs(request, BkgCntrMfDescVO.class, "t5_sheet1_");
	            List<BkgCntrMfDescVO> bkgCntrMfDescVoList = new ArrayList<BkgCntrMfDescVO>();
	            int len = (bkgCntrMfDescVOs == null) ? 0 : bkgCntrMfDescVOs.length;
	            for(int i=0;i<len; i++){
	            	bkgCntrMfDescVoList.add(bkgCntrMfDescVOs[i]);
	            }
	            cmVO.setCntrMfDescVOs(bkgCntrMfDescVoList);
	            esmBkg022905Event.setCmVO(cmVO);	            
	            
	            BkgCntrShpVO[] bkgCntrShpVOs = (BkgCntrShpVO[]) getVOs(request, BkgCntrShpVO.class, "t5_sheet3_");
	            esmBkg022905Event.setBkgCntrShpVOs(bkgCntrShpVOs);
	            
	            event.setEsmBkg022905Event(esmBkg022905Event);
			}
			// TRO ESM_BKG_0229_06
			if (request.getParameter("save_tro_flag").equals("Y")) {
				EsmBkg022906Event esmBkg022906Event = new EsmBkg022906Event();

				//화면고정용 Key Value : (io_bnd_cd, rtn_tro_seq)
				esmBkg022906Event.setIsEurFlg(request.getParameter("t6_is_eur_flg"));
				
				String ioBndCd   = request.getParameter("t6_io_bnd_cd");
				String rtnTroFlg = request.getParameter("t6_rtn_tro_flg");
				String delFlg    = request.getParameter("t6_f_del_flg");
				esmBkg022906Event.setBoundCd  (ioBndCd);    //'O'
				esmBkg022906Event.setRtnTroFlg(rtnTroFlg);  //'N'
				esmBkg022906Event.setDelFlg   (delFlg);     //'N'
				
				//CurrSeq 초기화
				esmBkg022906Event.setCurrTroSeq(JSPUtil.getNullNoTrim(request.getParameter("t6_curr_tro_seq")));
											
				//다중처리 : containerVO 사용
				TroVO troVO = new TroVO();		
				
				if(request.getParameter("t6_is_eur_flg").equals("Y")){
//					troVO.setArrTroMstVO((TroMstVO[])getVOs(request, TroMstVO.class, "t6_sheet4_"));
//					troVO.setArrTroDtlVO((TroDtlVO[])getVOs(request, TroDtlVO.class, "t6_sheet5_"));
					troVO.setArrEurTroMstVO((EurTroMstVO[])getVOs(request, EurTroMstVO.class, "t6_sheet4_"));
					troVO.setArrEurTroDtlVO((EurTroDtlVO[])getVOs(request, EurTroDtlVO.class, "t6_sheet5_"));
				}else{
					troVO.setArrTroMstVO((TroMstVO[])getVOs(request, TroMstVO.class, "t6_sheet3_"));
					troVO.setArrTroDtlVO((TroDtlVO[])getVOs(request, TroDtlVO.class, "t6_sheet1_"));
				}
				troVO.setEBkgFlg  ("Y");     //eBooking 여부 : 현재 사용되지않음.
				troVO.setBkgNo    (event.getBkgBlNoVO().getBkgNo());
				troVO.setIoBndCd  (ioBndCd);
				troVO.setRtnTroFlg(rtnTroFlg);				
				esmBkg022906Event.setTroVO(troVO);	
				
				event.setEsmBkg022906Event(esmBkg022906Event);
			}
			// RF ESM_BKG_0229_07
			if (request.getParameter("save_rf_flag").equals("Y")) {
				EsmBkg022907Event esmBkg022907Event = new EsmBkg022907Event();
				
				// Reefer
				OpusRfVO[] opusRfVOs = (OpusRfVO[]) getVOs(request, OpusRfVO .class,"t7_t7sheet1_");
				if(opusRfVOs != null && opusRfVOs.length > 0){
					int iMaxRcSeq = 0;
					int iDataCnt = 0;
					if (!"".equals(opusRfVOs[0].getMaxRcSeq())) {
						iMaxRcSeq = Integer.parseInt(opusRfVOs[0].getMaxRcSeq());
					}
					for (int i=0; i<opusRfVOs.length; i++) {
						if ("I".equals(opusRfVOs[i].getIbflag())) {
							opusRfVOs[i].setRcSeq((iMaxRcSeq + 1) + "");
							iMaxRcSeq++;
							iDataCnt++;
						} else if ("U".equals(opusRfVOs[i].getIbflag()) || "D".equals(opusRfVOs[i].getIbflag())) {
							iDataCnt++;
						}
					}
					BkgRfCgoVO[] bkgRfCgoVO = new BkgRfCgoVO[iDataCnt];
					for (int i=0, j=0; i<opusRfVOs.length; i++) {
						if (!"R".equals(opusRfVOs[i].getIbflag())) {
							bkgRfCgoVO[j] = new BkgRfCgoVO();
							ObjectCloner.build(opusRfVOs[i], bkgRfCgoVO[j]);
							bkgRfCgoVO[j].setRfDcgoSeq("");
							bkgRfCgoVO[j].setPckTpCd("");
							
							if(opusRfVOs[i].getPwrSplCblFlg().equals("Y")){
								bkgRfCgoVO[j].setPwrSplCblFlg("1");
							}
							
							j++;
						}
					}
					esmBkg022907Event.setBkgRfCgoVOs(bkgRfCgoVO);				
					event.setEsmBkg022907Event(esmBkg022907Event);
				}
			}
			// DG ESM_BKG_0229_08
			if (request.getParameter("save_dg_flag").equals("Y")) {
				EsmBkg022908Event esmBkg022908Event = new EsmBkg022908Event();
				
				// DG
				boolean bCntrCgoSeq = false;
				int iMaxDgCntrSeq = 0;
				OpusDgVO[] opusDgVOs = (OpusDgVO[]) getVOs(request, OpusDgVO.class, "t8_t8sheet1_");
				BkgImgStoVO[] bkgImgStoVO = (BkgImgStoVO[]) getVOs(request, BkgImgStoVO.class, "t8_t8sheet2_");
				
				if(opusDgVOs != null && opusDgVOs.length > 0){
					int iDataCnt = 0;
					for (int i = 0; i < opusDgVOs.length; i++){
						// 신규일때
						if ("I".equals(opusDgVOs[i].getIbflag()) || "U".equals(opusDgVOs[i].getIbflag())){
							//
							if (!"".equals(opusDgVOs[i].getCntrNo())){
								for (int j = 0; j < opusDgVOs.length; j++){
									if (opusDgVOs[i].getCntrNo().equals(opusDgVOs[j].getCntrNo())){
//										opusDgVOs[i].setCntrCgoSeq((Integer.parseInt(opusDgVOs[j].getMaxCntrCgoSeq()) + 1) + "");
										opusDgVOs[j].setMaxCntrCgoSeq((Integer.parseInt(opusDgVOs[j].getMaxCntrCgoSeq()) + 1) + "");
//										opusDgVOs[i].setDgCntrSeq(opusDgVOs[j].getDgCntrSeq());
										bCntrCgoSeq = true;
										break;
									}
								}
								if (!bCntrCgoSeq){
//									opusDgVOs[i].setCntrCgoSeq("1");
									for (int j = 0; j < opusDgVOs.length; j++){
										if (iMaxDgCntrSeq < Integer.parseInt(opusDgVOs[j].getMaxDgCntrSeq())){
											iMaxDgCntrSeq = Integer.parseInt(opusDgVOs[j].getMaxDgCntrSeq());
										}
									}
//									opusDgVOs[i].setDgCntrSeq((iMaxDgCntrSeq + 1) + "");
									bCntrCgoSeq = false;
								}
							} else {
//								opusDgVOs[i].setCntrCgoSeq("1");
								for (int j = 0; j < opusDgVOs.length; j++){
									if (!"".equals(opusDgVOs[j].getMaxDgCntrSeq())
											&& iMaxDgCntrSeq < Integer.parseInt(opusDgVOs[j].getMaxDgCntrSeq())){
										iMaxDgCntrSeq = Integer.parseInt(opusDgVOs[j].getMaxDgCntrSeq());
										opusDgVOs[j].setMaxDgCntrSeq((iMaxDgCntrSeq + 1) + "");
									}
								}
//								opusDgVOs[i].setDgCntrSeq((iMaxDgCntrSeq + 1) + "");
							}
							iDataCnt++;
						} else if ("D".equals(opusDgVOs[i].getIbflag())) {
							iDataCnt++;
						}
						if ("".equals(opusDgVOs[i].getGrsWgt())){
							opusDgVOs[i].setGrsWgt("0");
						}
					}
					DgCgoListVO[] dgCgoListVOs = new DgCgoListVO[iDataCnt];
					for (int i = 0, j = 0; i < opusDgVOs.length; i++){
						if (!"R".equals(opusDgVOs[i].getIbflag())){
							dgCgoListVOs[j] = new DgCgoListVO();
							ObjectCloner.build(opusDgVOs[i], dgCgoListVOs[j]);
							dgCgoListVOs[j].setInImdgPckCd1("");
							dgCgoListVOs[j].setInImdgPckCd2("");
							dgCgoListVOs[j].setOutImdgPckCd1("");
							dgCgoListVOs[j].setOutImdgPckCd2("");
							j++;
						}
					}
					esmBkg022908Event.setBkgImgStoVO(bkgImgStoVO);
					esmBkg022908Event.setDgCgoListVOs(dgCgoListVOs);	
					
					event.setEsmBkg022908Event(esmBkg022908Event);
				}
			}
			// AK ESM_BKG_0229_09
			if (request.getParameter("save_ak_flag").equals("Y")) {
				EsmBkg022909Event esmBkg022909Event = new EsmBkg022909Event();
					
				// AWK
				OpusAkVO[] opusAkVO = (OpusAkVO[]) getVOs(request, OpusAkVO.class, "t9_t9sheet1_");
				if(opusAkVO != null && opusAkVO.length > 0){
					int iMaxAwkSeq = 0;
					int iDataCnt = 0;
					if (!"".equals(opusAkVO[0].getMaxAwkCgoSeq())){
						iMaxAwkSeq = Integer.parseInt(opusAkVO[0].getMaxAwkCgoSeq());
					}
					for (int i = 0; i < opusAkVO.length; i++){
						if ("I".equals(opusAkVO[i].getIbflag())){
							opusAkVO[i].setAwkCgoSeq((iMaxAwkSeq + 1) + "");
							iMaxAwkSeq++;
							iDataCnt++;
						} else if ("U".equals(opusAkVO[i].getIbflag()) || "D".equals(opusAkVO[i].getIbflag())){
							iDataCnt++;
						}
					}
					BkgAwkCgoVO[] bkgAwkCgoVO = new BkgAwkCgoVO[iDataCnt];
					for (int i = 0, j = 0; i < opusAkVO.length; i++){
						if (!"R".equals(opusAkVO[i].getIbflag())){
							bkgAwkCgoVO[j] = new BkgAwkCgoVO();
							ObjectCloner.build(opusAkVO[i], bkgAwkCgoVO[j]);
							bkgAwkCgoVO[j].setAwkDcgoSeq("");
							j++;
						}
					}
					
					esmBkg022909Event.setBkgAwkCgoVOs(bkgAwkCgoVO);
					event.setEsmBkg022909Event(esmBkg022909Event);
				}
			}
			// HBL1 ESM_BKG_0229_10
			if (request.getParameter("save_hbl_flag").equals("Y")) {
				EsmBkg022910Event esmBkg022910Event = new EsmBkg022910Event();
				
				// EBookingConduct에 manageHbl 에서 사용할 parameter를 HblVO Container VO에 담기 시작한다
				esmBkg022910Event.setXterRqstNoVO(xterRqstNoVO);
				esmBkg022910Event.setBkgBlNoVO(bkgBlNoVO);
				
	            HblDtlInfoVO[] hblDtlVO = (HblDtlInfoVO[]) getVOs(request, HblDtlInfoVO.class, "t10_sheet1_");

	            List<HblDtlInfoVO> hblDtlInfoVOs = new ArrayList<HblDtlInfoVO>();
	            for (int i = 0; i < hblDtlVO.length; i++) {
	            	hblDtlInfoVOs.add(hblDtlVO[i]);
	            }
	            
	            HblVO hblVO = new HblVO();
	            hblVO.setHblDtlInfoVOs(hblDtlInfoVOs);
	            esmBkg022910Event.setHblVO(hblVO);	            
	            event.setEsmBkg022910Event(esmBkg022910Event);
			}
			// HBL2 ESM_BKG_0229_11
			if (request.getParameter("save_hbl2_flag").equals("Y")) {
				EsmBkg022911Event esmBkg022911Event = new EsmBkg022911Event();
				
				// EBookingConduct에 manageHbl 에서 사용할 parameter를 HblVO Container VO에 담기 시작한다
				esmBkg022911Event.setXterRqstNoVO(xterRqstNoVO);
				esmBkg022911Event.setBkgBlNoVO(bkgBlNoVO);
				esmBkg022911Event.setBkgUsaCstmsFileNoVOs((BkgUsaCstmsFileNoVO[])getVOs(request, BkgUsaCstmsFileNoVO.class, "t11_"));				
				event.setEsmBkg022911Event(esmBkg022911Event);
			}
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
	
   /**
    * 미사용
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
}