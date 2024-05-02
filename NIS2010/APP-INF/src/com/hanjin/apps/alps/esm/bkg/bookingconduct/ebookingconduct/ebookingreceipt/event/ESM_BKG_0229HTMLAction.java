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
* 2011.05.11 이일민 [CHM-201110114] BKG Charge Screen 상 운임회수 점소 pre-paid office was auto-changed as booking office again
* 2011.10.04 정선용 [CHM-201112445] SI Automation System 구축
* 2011.11.14  정선용 [CHM-201114020-01]	(BASF) Dagerous Cargo MIG 로직 요청
* 2012.02.28 정선용 [CHM-201215444-01] [웹 리뉴얼] Rider 및 D/G Rider 항목 보완 (E-bkg/E-SI)
* 2014.08.22 최도순[CHM-201431653] e-BKG cancel request 업로드 시에도 remark란 입력 및 저장 기능 활성화
=========================================================*/
package com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.event;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.hanjin.apps.alps.esm.bkg.bookingcommon.bookingutil.vo.BkgBlNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsAkVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsBbVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsDgVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsRfVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.AlpsXptImpLicListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.BlRiderVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.SIWebServiceVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct.ebookingreceipt.vo.XterRqstNoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgBookingInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BkgClauseLockVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlCustomerInfoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BlDocCustVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.BookingSaveValidationVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.CustEtcVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.generalbookingreceipt.vo.VslSkdVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroDtlVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroMstVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.generalbookingconduct.transferorderissue.vo.TroVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgAwkCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgBbCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.BkgRfCgoVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargoreceipt.vo.DgCgoListVO;
import com.hanjin.apps.alps.esm.bkg.bookingconduct.specialcargobookingconduct.specialcargorider.vo.SpclRiderInVO;
import com.hanjin.apps.alps.esm.bkg.common.WordWarp;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmBkgInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CmVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.CntrEtcInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.ContainerVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblDtlInfoVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.HblVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.MndVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.bldocumentation.vo.XptImpLicVO;
import com.hanjin.apps.alps.esm.bkg.outbounddocumentation.outboundblmgt.blissuance.vo.DocRqstVO;
import com.hanjin.apps.alps.esm.bkg.wharfagemgt.wharfagedecmgt.kr.vo.KrWhfBlExptInfoVO;
import com.hanjin.framework.component.util.JSPUtil;
import com.hanjin.framework.component.util.object.ObjectCloner;
import com.hanjin.framework.core.controller.html.HTMLActionException;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.support.controller.HTMLActionSupport;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.syscommon.common.table.BkgCntrMfDescVO;
import com.hanjin.syscommon.common.table.BkgCntrSealNoVO;
import com.hanjin.syscommon.common.table.BkgImgStoVO;
import com.hanjin.syscommon.common.table.BkgQtyDtlVO;
import com.hanjin.syscommon.common.table.BkgQuantityVO;
import com.hanjin.syscommon.common.table.BkgRefDtlVO;
import com.hanjin.syscommon.common.table.BkgReferenceVO;
import com.hanjin.syscommon.common.table.BkgUsaCstmsFileNoVO;

/**
 * HTTP Parser<br>
 * - com.hanjin.apps.alps.esm.bkg.bookingconduct.ebookingconduct 화면을 통해 서버로 전송되는 HTML DOM 객체의 Value를 자바 변수로 Parsing<br>
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

		System.out.println(request.getParameter("f_cmd"));
		if(command.isCommand(FormCommand.SEARCH)) {//미사용
			event.setXterRqstNoVO((XterRqstNoVO)getVO(request, XterRqstNoVO .class));
		}
		else if(command.isCommand(FormCommand.MULTI02)) {
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
		}
		else if (command.isCommand(FormCommand.MULTI01)) { // WEB SI Audit
			SIWebServiceVO sIWebServiceVO =  new SIWebServiceVO();
			sIWebServiceVO.setXterSndrId(request.getParameter("xter_sndr_id"));
			sIWebServiceVO.setXterRqstNo(request.getParameter("xter_rqst_no"));
			sIWebServiceVO.setXterRqstSeq(request.getParameter("xter_rqst_seq"));
			sIWebServiceVO.setSiAudFlg(request.getParameter("si_aud_flg"));
			sIWebServiceVO.setBkgNo(request.getParameter("bkg_no"));
			sIWebServiceVO.setBlNo(request.getParameter("bl_no"));
			
			event.setSIWebServiceVO(sIWebServiceVO);
			event.setSiCntcPsonEml(request.getParameter("si_cntc_pson_eml"));
		}
		else if (command.isCommand(FormCommand.COMMAND03)) { // cancel
			// BKG_XTER_RQST_MST의 PK 정보, completeUpload 시 필요
			event.setXterRqstNoVO((XterRqstNoVO)getVO(request, XterRqstNoVO .class));			
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
			event.setCloseBkgFlag(request.getParameter("close_bkg_flag"));
			event.setCbfBkgFlag(request.getParameter("cbf_bkg_flag"));
			event.setInterRmk(request.getParameter("inter_rmk"));
			event.setXterRmk(request.getParameter("xter_rmk"));
			
			EsmBkg022901Event esmBkg022901Event = new EsmBkg022901Event();
			esmBkg022901Event.setAutoNotification(request.getParameter("t1_auto_notification"));
			event.setEsmBkg022901Event(esmBkg022901Event);
		}
		else if (command.isCommand(FormCommand.COMMAND02)) {
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
			event.setSaveBbFlag  (request.getParameter("save_bb_flag"));
			event.setSaveHblFlag (request.getParameter("save_hbl_flag"));
			event.setSaveHbl2Flag(request.getParameter("save_hbl2_flag"));
			
			// 2011.08.30 EML 에 대한 bkg_sr_fax의 SR_PROC_TP_CD 에 대한 업데이트시
			event.setRqstNo(request.getParameter("rqst_no"));
			event.setFaxLogRefNo(request.getParameter("fax_log_ref_no"));
			event.setSenderId(request.getParameter("sender_id"));
			event.setBccExistFlg(JSPUtil.getParameter(request, "bcc_exist_flg"));
			
			// BKG_XTER_RQST_MST의 PK 정보, completeUpload 시 필요
			XterRqstNoVO xterRqstNoVO = (XterRqstNoVO)getVO(request, XterRqstNoVO .class);
			event.setXterRqstNoVO(xterRqstNoVO);
			
			BkgBlNoVO bkgBlNoVO = (BkgBlNoVO)getVO(request, BkgBlNoVO .class);
			event.setBkgBlNoVO(bkgBlNoVO);
			
			BkgBookingInfoVO t1BkgBookingInfoVO = new BkgBookingInfoVO();
			
			ContainerVO[] containerVOs = null;
			
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
				
				//CHM-201217382 BKG main의 Reference넘버 창 생성
				esmBkg022901Event.setBkgReferenceVOs((BkgReferenceVO[])getVOs(request, BkgReferenceVO.class,"t1_"));
								
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
		        containerVOs = (ContainerVO[]) getVOs(request, ContainerVO.class, "t3_sheet1_");
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
				
				mndVO.setMkDesc(WordWarp.wrap2(mndVO.getMkDesc(), 22));
				
				actWgt = mndVO.getActWgt();
				wgtUtCd = mndVO.getWgtUtCd();
				pckQty = mndVO.getPckQty();
				pckTpCd = mndVO.getPckTpCd();

				BkgReferenceVO[] poOtherBkgRefVOs 	= (BkgReferenceVO[])getVOs(request, BkgReferenceVO.class,"t4_sheet2_");
				BkgReferenceVO[] poOtherCntrVOs 	= (BkgReferenceVO[])getVOs(request, BkgReferenceVO.class,"t4_sheet3_");
				BkgRefDtlVO[] 	 poOtherCmVOs 		= (BkgRefDtlVO[])getVOs(request, BkgRefDtlVO.class,"t4_sheet4_");
				BkgRefDtlVO[]    poOtherShipVOs 	= (BkgRefDtlVO[])getVOs(request, BkgRefDtlVO.class,"t4_sheet9_");
				BlRiderVO[] 	 blRiderVOs 		= (BlRiderVO[])getVOs(request, BlRiderVO.class,"t4_sheet5_");  //B/L rider
				KrWhfBlExptInfoVO[] krWhfBlExptInfoVOs = (KrWhfBlExptInfoVO[])getVOs(request, KrWhfBlExptInfoVO.class,"t4_sheet6_");  //Wharfage
				BkgClauseLockVO[]    bkgClauseLockVOs 	= (BkgClauseLockVO[])getVOs(request, BkgClauseLockVO.class,"t4_sheet10_");
				
				esmBkg022904Event.setPoOtherNoBkgVOs(poOtherBkgRefVOs);
				esmBkg022904Event.setPoOtherCntrVOs(poOtherCntrVOs);
				esmBkg022904Event.setPoOtherCmVOs(poOtherCmVOs);
				esmBkg022904Event.setPoOtherShipVOs(poOtherShipVOs);
				esmBkg022904Event.setBlRiderVOs(blRiderVOs);
				esmBkg022904Event.setKrWhfBlExptInfoVOs(krWhfBlExptInfoVOs);
				esmBkg022904Event.setAlpsXptImpLicListVOs((AlpsXptImpLicListVO[]) getVOs(request, AlpsXptImpLicListVO.class, "t4_sheet1_"));
	        	esmBkg022904Event.setIdXptImpLicVOs((XptImpLicVO[]) getVOs(request, XptImpLicVO.class, "t4_sheet7_"));
	        	esmBkg022904Event.setBkgClauseLockVOs(bkgClauseLockVOs);
		        event.setEsmBkg022904Event(esmBkg022904Event);
			}
			// C/M ESM_BKG_0229_05
			if (request.getParameter("save_cm_flag").equals("Y")) {
				EsmBkg022905Event esmBkg022905Event = new EsmBkg022905Event();
				
				// Continer 정보를 가지고 Delete 해야 할 Container를 찾기 위하여 
				// 0229_03 처리시 미리 찾아놓은 containerVOs
		        esmBkg022905Event.setContainerVOs(containerVOs);
		        
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
		        
		        event.setEsmBkg022905Event(esmBkg022905Event);
			}
			// TRO ESM_BKG_0229_06
			if (request.getParameter("save_tro_flag").equals("Y")) {
				EsmBkg022906Event esmBkg022906Event = new EsmBkg022906Event();

				//화면고정용 Key Value : (io_bnd_cd, rtn_tro_seq)
				esmBkg022906Event.setIsEurFlg  (request.getParameter("t6_is_eur_flg"));
				
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
				troVO.setArrTroMstVO((TroMstVO[])getVOs(request, TroMstVO.class, "t6_sheet3_"));
				troVO.setArrTroDtlVO((TroDtlVO[])getVOs(request, TroDtlVO.class, "t6_sheet1_"));
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
				AlpsRfVO[] nisRfVOs = (AlpsRfVO[]) getVOs(request, AlpsRfVO .class,"t7_t7sheet1_");
				if(nisRfVOs != null && nisRfVOs.length > 0){
					int iMaxRcSeq = 0;
					int iDataCnt = 0;
					if (!"".equals(nisRfVOs[0].getMaxRcSeq())) {
						iMaxRcSeq = Integer.parseInt(nisRfVOs[0].getMaxRcSeq());
					}
					for (int i=0; i<nisRfVOs.length; i++) {
						if ("I".equals(nisRfVOs[i].getIbflag())) {
							nisRfVOs[i].setRcSeq((iMaxRcSeq + 1) + "");
							iMaxRcSeq++;
							iDataCnt++;
						} else if ("U".equals(nisRfVOs[i].getIbflag()) || "D".equals(nisRfVOs[i].getIbflag())) {
							iDataCnt++;
						}
					}
					BkgRfCgoVO[] bkgRfCgoVO = new BkgRfCgoVO[iDataCnt];
					for (int i=0, j=0; i<nisRfVOs.length; i++) {
						if (!"R".equals(nisRfVOs[i].getIbflag())) {
							bkgRfCgoVO[j] = new BkgRfCgoVO();
							ObjectCloner.build(nisRfVOs[i], bkgRfCgoVO[j]);
							bkgRfCgoVO[j].setRfDcgoSeq("");
							bkgRfCgoVO[j].setPckTpCd("");
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
				AlpsDgVO[] nisDgVOs = (AlpsDgVO[]) getVOs(request, AlpsDgVO.class, "t8_t8sheet1_");
				
				if(nisDgVOs != null && nisDgVOs.length > 0){
					int iDataCnt = 0;
					for (int i = 0; i < nisDgVOs.length; i++){
						// 신규일때
						if ("I".equals(nisDgVOs[i].getIbflag()) || "U".equals(nisDgVOs[i].getIbflag())){
							//
							if (!"".equals(nisDgVOs[i].getCntrNo())){
								for (int j = 0; j < nisDgVOs.length; j++){
									if (nisDgVOs[i].getCntrNo().equals(nisDgVOs[j].getCntrNo())){
										nisDgVOs[i].setCntrCgoSeq((Integer.parseInt(nisDgVOs[j].getMaxCntrCgoSeq()) + 1) + "");
										nisDgVOs[j].setMaxCntrCgoSeq((Integer.parseInt(nisDgVOs[j].getMaxCntrCgoSeq()) + 1) + "");
										nisDgVOs[i].setDgCntrSeq(nisDgVOs[j].getDgCntrSeq());
										bCntrCgoSeq = true;
										break;
									}
								}
								if (!bCntrCgoSeq){
									if( "".equals(nisDgVOs[i].getCntrCgoSeq())) { //add jsy
										
										nisDgVOs[i].setCntrCgoSeq("1");
									}
									for (int j = 0; j < nisDgVOs.length; j++){
										if (iMaxDgCntrSeq < Integer.parseInt(nisDgVOs[j].getMaxDgCntrSeq())){
											iMaxDgCntrSeq = Integer.parseInt(nisDgVOs[j].getMaxDgCntrSeq());
										}
									}
									if( "".equals(nisDgVOs[i].getDgCntrSeq())) { //add jsy 
										nisDgVOs[i].setDgCntrSeq((iMaxDgCntrSeq + 1) + "");
									}
									bCntrCgoSeq = false;
								}
							} else {
// 2011.10.27 jsy 
								if( "".equals(nisDgVOs[i].getCntrCgoSeq())) { //add jsy
									nisDgVOs[i].setCntrCgoSeq("1");
								}
								for (int j = 0; j < nisDgVOs.length; j++){
									if (!"".equals(nisDgVOs[j].getMaxDgCntrSeq())
											&& iMaxDgCntrSeq < Integer.parseInt(nisDgVOs[j].getMaxDgCntrSeq())){
										iMaxDgCntrSeq = Integer.parseInt(nisDgVOs[j].getMaxDgCntrSeq());
										nisDgVOs[j].setMaxDgCntrSeq((iMaxDgCntrSeq + 1) + "");
									}
								}
								if( "".equals(nisDgVOs[i].getDgCntrSeq())) { //add jsy
									nisDgVOs[i].setDgCntrSeq((iMaxDgCntrSeq + 1) + "");
								}
							}
							iDataCnt++;
						} else if ("D".equals(nisDgVOs[i].getIbflag())) {
							iDataCnt++;
						}
						if ("".equals(nisDgVOs[i].getGrsWgt())){
							nisDgVOs[i].setGrsWgt("0");
						}
					}
					DgCgoListVO[] dgCgoListVOs = new DgCgoListVO[iDataCnt];
					for (int i = 0, j = 0; i < nisDgVOs.length; i++){
						if (!"R".equals(nisDgVOs[i].getIbflag())){
							dgCgoListVOs[j] = new DgCgoListVO();
							ObjectCloner.build(nisDgVOs[i], dgCgoListVOs[j]);
							dgCgoListVOs[j].setInImdgPckCd1("");
							dgCgoListVOs[j].setInImdgPckCd2("");
							dgCgoListVOs[j].setOutImdgPckCd1("");
							dgCgoListVOs[j].setOutImdgPckCd2("");
							j++;
						}
					}
					esmBkg022908Event.setDgCgoListVOs(dgCgoListVOs);				
					event.setEsmBkg022908Event(esmBkg022908Event);
					
					// DG Rider 처리 
					SpclRiderInVO spclRiderInVO 	= (SpclRiderInVO)getVO(request, SpclRiderInVO.class);
					BkgImgStoVO[] bkgImgStoVOs 	= (BkgImgStoVO[])getVOs(request, BkgImgStoVO.class, "t8_dg_rider_");
					log.debug("request.getParameter(t8_ridr_tp_cd)"+request.getParameter("t8_ridr_tp_cd"));
					spclRiderInVO.setBkgImgStoVOs(bkgImgStoVOs);
					spclRiderInVO.setRidrTpCd(request.getParameter("t8_ridr_tp_cd"));
					esmBkg022908Event.setSpclRiderInVO(spclRiderInVO);
					
				}
				
			}
			// AK ESM_BKG_0229_09
			if (request.getParameter("save_ak_flag").equals("Y")) {
				EsmBkg022909Event esmBkg022909Event = new EsmBkg022909Event();
					
				// AWK
				AlpsAkVO[] nisAkVO = (AlpsAkVO[]) getVOs(request, AlpsAkVO.class, "t9_t9sheet1_");
				if(nisAkVO != null && nisAkVO.length > 0){
					int iMaxAwkSeq = 0;
					int iDataCnt = 0;
					if (!"".equals(nisAkVO[0].getMaxAwkCgoSeq())){
						iMaxAwkSeq = Integer.parseInt(nisAkVO[0].getMaxAwkCgoSeq());
					}
					for (int i = 0; i < nisAkVO.length; i++){
						if ("I".equals(nisAkVO[i].getIbflag())){
							nisAkVO[i].setAwkCgoSeq((iMaxAwkSeq + 1) + "");
							iMaxAwkSeq++;
							iDataCnt++;
						} else if ("U".equals(nisAkVO[i].getIbflag()) || "D".equals(nisAkVO[i].getIbflag())){
							iDataCnt++;
						}
					}
					BkgAwkCgoVO[] bkgAwkCgoVO = new BkgAwkCgoVO[iDataCnt];
					for (int i = 0, j = 0; i < nisAkVO.length; i++){
						if (!"R".equals(nisAkVO[i].getIbflag())){
							bkgAwkCgoVO[j] = new BkgAwkCgoVO();
							ObjectCloner.build(nisAkVO[i], bkgAwkCgoVO[j]);
							bkgAwkCgoVO[j].setAwkDcgoSeq("");
							j++;
						}
					}
					
					esmBkg022909Event.setBkgAwkCgoVOs(bkgAwkCgoVO);
					event.setEsmBkg022909Event(esmBkg022909Event);
					
					// AK Rider 처리 
					SpclRiderInVO spclRiderInVO 	= (SpclRiderInVO)getVO(request, SpclRiderInVO.class);
					BkgImgStoVO[] bkgImgStoVOs 	= (BkgImgStoVO[])getVOs(request, BkgImgStoVO.class, "t9_ak_rider_");
					log.debug("request.getParameter(t9_ridr_tp_cd)"+request.getParameter("t9_ridr_tp_cd"));
					spclRiderInVO.setBkgImgStoVOs(bkgImgStoVOs);
					spclRiderInVO.setRidrTpCd(request.getParameter("t9_ridr_tp_cd"));
					esmBkg022909Event.setSpclRiderInVO(spclRiderInVO);
				}
			}
			
			// BB ESM_BKG_0229_12
			if (request.getParameter("save_bb_flag").equals("Y")) {
				EsmBkg022912Event esmBkg022912Event = new EsmBkg022912Event();
					
				// BB
				AlpsBbVO[] nisBbVO = (AlpsBbVO[]) getVOs(request, AlpsBbVO.class, "t12_t12sheet1_");
				if(nisBbVO != null && nisBbVO.length > 0){
					int iMaxBbSeq = 0;
					int iDataCnt = 0;
					if (!"".equals(nisBbVO[0].getMaxBbCgoSeq())){
						iMaxBbSeq = Integer.parseInt(nisBbVO[0].getMaxBbCgoSeq());
					}
					for (int i = 0; i < nisBbVO.length; i++){
						if ("I".equals(nisBbVO[i].getIbflag())){
							nisBbVO[i].setBbCgoSeq((iMaxBbSeq + 1) + "");
							iMaxBbSeq++;
							iDataCnt++;
						} else if ("U".equals(nisBbVO[i].getIbflag()) || "D".equals(nisBbVO[i].getIbflag())){
							iDataCnt++;
						}
					}
					BkgBbCgoVO[] bkgBbCgoVO = new BkgBbCgoVO[iDataCnt];
					for (int i = 0, j = 0; i < nisBbVO.length; i++){
						if (!"R".equals(nisBbVO[i].getIbflag())){
							bkgBbCgoVO[j] = new BkgBbCgoVO();
							ObjectCloner.build(nisBbVO[i], bkgBbCgoVO[j]);
							bkgBbCgoVO[j].setBbDcgoSeq("");
							j++;
						}
					}
					
					esmBkg022912Event.setBkgBbCgoVOs(bkgBbCgoVO);
					event.setEsmBkg022912Event(esmBkg022912Event);
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
		} else if (command.isCommand(FormCommand.SEARCH02) || command.isCommand(FormCommand.MODIFY07)) {
			event.setBkgBlNoVO((BkgBlNoVO)getVO(request, BkgBlNoVO.class));
		} else if(command.isCommand(FormCommand.TRANS)) {
			event.setSIWebServiceVO((SIWebServiceVO)getVO(request, SIWebServiceVO.class));
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