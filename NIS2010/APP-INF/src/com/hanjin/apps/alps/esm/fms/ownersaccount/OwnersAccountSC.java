/*=========================================================
*Copyright(c) 2016 CyberLogitec
*@FileName : OwnersAccountSC.java
*@FileTitle : Owner's Account
*Open Issues :
*Change history :
*@LastModifyDate : 2016.02.18
*@LastModifier : 손진환
*@LastVersion : 1.0
* 2016.02.18 손진환
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.esm.fms.ownersaccount;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.hanjin.apps.alps.esm.fms.ownersaccount.basic.OwnersAccountBC;
import com.hanjin.apps.alps.esm.fms.ownersaccount.basic.OwnersAccountBCImpl;
import com.hanjin.apps.alps.esm.fms.ownersaccount.event.EsmFms0095Event;
import com.hanjin.apps.alps.esm.fms.ownersaccount.event.EsmFms0101Event;
import com.hanjin.apps.alps.esm.fms.ownersaccount.integration.OwnersAccountDBDAO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.CancelSlipVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.FmsConsultationVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.FmsCsulSlpVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.OwnrCurrVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.SearchOwnrAcctForCnclListVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.searchFinancialVVDForOtherOffcVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic.TCharterIOConsultationBC;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.basic.TCharterIOConsultationBCImpl;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxDtlVO;
import com.hanjin.apps.alps.esm.fms.timecharterinoutaccounting.tcharterioconsultation.vo.CustomTaxVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.Event;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.event.EventResponse;
import com.hanjin.framework.core.layer.event.GeneralEventResponse;
import com.hanjin.framework.support.controller.html.FormCommand;
import com.hanjin.framework.support.layer.service.ServiceCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;
import java.util.Iterator;
import com.hanjin.apps.alps.esm.fms.ownersaccount.event.EsmFms0096Event;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.OwnrAcctListVO;
import com.hanjin.apps.alps.esm.fms.ownersaccount.vo.OwnrAcctVO;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.basic.CanalTransitFeeInvoiceBC;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.basic.CanalTransitFeeInvoiceBCImpl;
import com.hanjin.apps.alps.vop.pso.estimateinvoiceaudit.canaltransitfeeinvoice.vo.CanalTzOwnerAccountInterfaceVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.basic.ConsultationSlipRequestMgtBC;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.basic.ConsultationSlipRequestMgtBCImpl;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.AsaNoVO;
import com.hanjin.bizcommon.csr.consultationsliprequestmgt.consultationsliprequestmgt.vo.CheckAsaVO;
import com.hanjin.framework.component.util.DateTime;

/**
 * ALPS-OwnersAccount Business Logic ServiceCommand - ALPS-OwnersAccount 대한 비지니스 트랜잭션을 처리한다.
 * 
 * @author Son, Jin-Hwan
 * @see OwnersAccountDBDAO
 * @since J2EE 1.6
 */

public class OwnersAccountSC extends ServiceCommandSupport {
	// Login User Information
	private SignOnUserAccount account = null;

	/**
	 * OwnersAccount system 업무 시나리오 선행작업<br>
	 * 업무 시나리오 호출시 관련 내부객체 생성<br> 
	 */
	public void doStart() {
		log.debug("OwnersAccountSC 시작");
		try {
			// 일단 comment --> 로그인 체크 부분
			account = getSignOnUserAccount();
		} catch (Exception e) {
			log.error(e.getLocalizedMessage());
		}
	}

	/**
	 * OwnersAccount system 업무 시나리오 마감작업<br>
	 * 업무 시나리오 종료시 관련 내부객체 해제<br>
	 */
	public void doEnd() {
		log.debug("OwnersAccountSC 종료");
	}

	/**
	 * 각 이벤트에 해당하는 업무 시나리오 수행<br>
	 * ALPS-OwnersAccount system 업무에서 발생하는 모든 이벤트의 분기처리<br>
	 * 
	 * @param e Event
	 * @return EventResponse
	 * @exception EventException
	 */
	public EventResponse perform(Event e) throws EventException {
		// RDTO(Data Transfer Object including Parameters)
		EventResponse eventResponse = null;

		// SC가 여러 이벤트를 처리하는 경우 사용해야 할 부분
		if (e.getEventName().equalsIgnoreCase("EsmFms0095Event")) { // Owner's Account Entry
			if (e.getFormCommand().isCommand(FormCommand.MULTI)) {// Save
				eventResponse = manageOwnersAccountSlip(e);
			}else if (e.getFormCommand().isCommand(FormCommand.REMOVE)) {// Delete
				eventResponse = removeOwnersAccountSlip(e);
			}else if (e.getFormCommand().isCommand(FormCommand.MULTI01)) {// Save AP_INV_HDR & DTRB
				eventResponse = manageApprovalSlip(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {// Owner's Account Inquiry or (New) Owner's Account에서 호출 시
				eventResponse = searchOwnersAccountSlip(e);
			}else if (e.getFormCommand().isCommand(FormCommand.SEARCH01)) {// O/A Cancellation에서 호출 시
				eventResponse = searchOwnersAccountCancellationSlip(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH10)) {// Approval Type
				eventResponse = searchApprovalType(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH11)) {// G/L Date
				eventResponse = searchGlDate(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH14)) {// G/L Date  Payments Slip
				eventResponse = searchGlDate2(e);	
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH12)) {// Local Currency
				eventResponse = searchLocalCurrency(e);
			}else if(e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchOwnCurrList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND01)) {// Invoice No.
				eventResponse = checkInvNo(e);
			}else if(e.getFormCommand().isCommand(FormCommand.SEARCH13)) {	
				eventResponse = searchCanalTzOwnerAccountInterface(e);								
			}else if(e.getFormCommand().isCommand(FormCommand.COMMAND02)) {	
				eventResponse = searchFinancialVVDForOtherOffc(e);
			}
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0096Event")) { // Owner's Account Entry
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOwnersAccountList(e);
			}else if(e.getFormCommand().isCommand(FormCommand.DEFAULT)) {
				eventResponse = searchOwnOffice(e);
			}			
		} else if (e.getEventName().equalsIgnoreCase("EsmFms0101Event")) { // O/A Inquiry for Cancellation
			if (e.getFormCommand().isCommand(FormCommand.SEARCH)) {
				eventResponse = searchOwnrsAccntForCnclList(e);
			}
		}
		return eventResponse;
	}
	
	/**
	 * ESM_FMS_0095 : [MULTI]<br>
	 * [전표]을 [생성]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageOwnersAccountSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0095Event event = (EsmFms0095Event)e;
		OwnersAccountBC command = new OwnersAccountBCImpl();
		
		try{
			FmsConsultationVO fmsConsultationVO = event.getFmsConsultationVO();
			FmsCsulSlpVO[] fmsCsulSlpVOs = event.getFmsCsulSlpVOS();
			
			// 세금계산서 / 계산서 Master VO
			CustomTaxVO[] customTaxVOs = event.getCustomTaxVOS();			
			// 세금계산서 / 계산서 Detail VO
			CustomTaxDtlVO[] customTaxDtlVOs = event.getCustomTaxDtlVOS();
			
						
			begin();
			
			String csr_no = "";
			String SLP_ISS_DT = "";			
			csr_no =  event.getCsrNo();
			log.debug("csr_no = "+csr_no);
			log.debug("getsFlg = "+fmsConsultationVO.getsFlg());
			
			if(!"".equals(fmsConsultationVO.getsFlg())){
				
				log.debug("csr_no.length() = "+csr_no.length());
				
				if(csr_no.length() == 19){
					SLP_ISS_DT = csr_no.substring(8, 14);
				}else{
					SLP_ISS_DT = csr_no.substring(9, 15);
				}															
				log.debug("SLP_ISS_DT= "+SLP_ISS_DT);				
				fmsConsultationVO.setSlpIssDt(SLP_ISS_DT);
			}
			
			String slpSerNo = command.manageOwnersAccountSlip(fmsConsultationVO, fmsCsulSlpVOs, account, customTaxVOs, customTaxDtlVOs);			
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001", new String[]{}).getUserMessage());			
			log.debug(fmsConsultationVO.getSlpIssDt());			
			String csrNo = fmsConsultationVO.getSlpTpCd() + 
					fmsConsultationVO.getSlpFuncCd() + 
					fmsConsultationVO.getSlpOfcCd() + 
					fmsConsultationVO.getSlpIssDt() + slpSerNo; 			
						
			//CSR No.
			Map<String,String> etcData = new HashMap<String,String>();
			etcData.put("csr_no", csrNo);			
			eventResponse.setETCData(etcData);
			
			//---------------------------------------------------------------
			// PUSMOV만 파일 저장
			if("PUSMOV".equals(fmsConsultationVO.getSlpOfcCd())){
				if(fmsCsulSlpVOs != null){				
					command.manageFileSav(csrNo, fmsCsulSlpVOs, account);
				}
			}
			//---------------------------------------------------------------				
			commit();
			
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}

	/**
	 * ESM_FMS_0095 : [REMOVE]<br>
	 * [전표]을 [삭제]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse removeOwnersAccountSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0095Event event = (EsmFms0095Event)e;
		OwnersAccountBC command = new OwnersAccountBCImpl();
		
		try{
			begin();
			
			String csrNo = event.getCsrNo();
			
			log.debug("S --- removeOwnersAccountSlip : csr_no : " + csrNo);
			
			command.removeOwnersAccountSlip(csrNo);
			
			log.debug("E --- removeOwnersAccountSlip : csr_no : " + csrNo);
			eventResponse.setUserMessage((String) new ErrorHandler("FMS00001", new String[]{}).getUserMessage());		

			commit();
			
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_FMS_0095 : [MULTI01]<br>
	 * [전표 AP_INV_HDR / AP_INV_DTRB 저장]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	/**
	 * ESM_FMS_0095 : [MULTI01]<br>
	 * [전표 AP_INV_HDR / AP_INV_DTRB 저장]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse manageApprovalSlip(Event e) throws EventException {	
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0095Event event = (EsmFms0095Event)e;
		OwnersAccountBC command = new OwnersAccountBCImpl();
		TCharterIOConsultationBC tCharterIOConsultationBC = new TCharterIOConsultationBCImpl();
		
		try{
			FmsConsultationVO fmsConsultationVO = event.getFmsConsultationVO();
			//FmsCsulSlpVO[] fmsCsulSlpVOs = event.getFmsCsulSlpVOS();			
			// 세금계산서 / 계산서 Master VO
			//CustomTaxVO[] customTaxVOs = event.getCustomTaxVOS();			
			// 세금계산서 / 계산서 Detail VO
			//CustomTaxDtlVO[] customTaxDtlVOs = event.getCustomTaxDtlVOS();
			String csrNo = "";			
			//String slpSerNo = "";
			String asaNo = fmsConsultationVO.getAsaNo();
			
			begin();			
			
			// 3만불 이상인지 확인
			String aproType = command.searchApprovalType(fmsConsultationVO.getCsrCurrCd(), fmsConsultationVO.getCsrAmt());
			
			if("GW".equalsIgnoreCase(aproType)) {
				log.debug(aproType + " : 3만불 넘었네?");
			}else if("ALPS".equalsIgnoreCase(aproType)) {
				log.debug(aproType + " : 3만불 안 넘었네?");
			}
			
			log.debug("fmsConsultationVO.getsCsrNo() = "+fmsConsultationVO.getsCsrNo());
			log.debug("aproType= "+aproType);
			log.debug("csrNo= "+csrNo);			
			log.debug("asa No = "+asaNo);			
			this.fncApro(fmsConsultationVO.getsCsrNo(), aproType, command, tCharterIOConsultationBC, asaNo, "1");			
//=================================================================================================================================					
//			String taxPicCd = "";			
//			
//			if(fmsCsulSlpVOs != null){
//				for(int i=0; i<fmsCsulSlpVOs.length; i++){
//					log.debug(i);
//					log.debug("fmsCsulSlpVOs[0].getAcctCd() = "+fmsCsulSlpVOs[i].getAcctCd());
//					if("421211".equals(fmsCsulSlpVOs[i].getAcctCd()) || "580111".equals(fmsCsulSlpVOs[i].getAcctCd())){
//						log.debug(i);					
//						taxPicCd = "2";
//					}
//				}
//			}
			
//			log.debug("taxPicCd = "+taxPicCd);			
										
//			if(customTaxVOs != null){
//				if("2".equals(taxPicCd)){				
//					if(!"KRW".equals(fmsConsultationVO.getCsrCurrCd())){
//
//						fmsConsultationVO.setsFlg("");	
//						fmsConsultationVO.setEvidTpCd("5");		// evid_type_cd [1|4|5|]  TAX|CI|ETC
//						fmsConsultationVO.setSlpFuncCd("S");
//						fmsConsultationVO.setCsrAmt("0");			// Pay Group : ZERO Payment			
//						fmsConsultationVO.setOaInvDt("");			// TAX 관련 자동 환대치 전표 생성시에 fms_consultation  테이블 의 OA_INV_DT 에 값이 NULL 해 주세요
//						fmsConsultationVO.setCsrCurrCd("KRW");		// 과세는 KRW
//						
//						String sCsrNo = fmsConsultationVO.getsCsrNo();
//						String SLP_TP_CD   = sCsrNo.substring(0, 2);
//						String SLP_FUNC_CD = sCsrNo.substring(2, 3);
//						String SLP_OFC_CD = "";
//						String SLP_ISS_DT = "";
//						String SLP_SER_NO = "";
//						
//						if(sCsrNo.length() == 19){
//							SLP_OFC_CD = sCsrNo.substring(3, 8);
//						}else{
//							SLP_OFC_CD = sCsrNo.substring(3, 9);
//						}	
//						if(sCsrNo.length() == 19){
//							SLP_ISS_DT = sCsrNo.substring(8, 14);
//						}else{
//							SLP_ISS_DT = sCsrNo.substring(9, 15);
//						}		
//						if(sCsrNo.length() == 19){
//							SLP_SER_NO = sCsrNo.substring(14, 19);
//						}else{
//							SLP_SER_NO = sCsrNo.substring(15, 20);
//						}							
//												
//						log.debug("SLP_TP_CD= "+SLP_TP_CD);
//						log.debug("SLP_FUNC_CD= "+SLP_FUNC_CD);
//						log.debug("SLP_OFC_CD= "+SLP_OFC_CD);
//						log.debug("SLP_ISS_DT= "+SLP_ISS_DT);
//						log.debug("SLP_SER_NO= "+SLP_SER_NO);						
//												
//						fmsConsultationVO.setVatSlpTpCd(SLP_TP_CD);						
//						fmsConsultationVO.setVatSlpFuncCd(SLP_FUNC_CD);
//						fmsConsultationVO.setVatSlpOfcCd(SLP_OFC_CD);						
//						fmsConsultationVO.setVatSlpIssDt(SLP_ISS_DT);
//						fmsConsultationVO.setVatSlpSerNo(SLP_SER_NO);
//						fmsConsultationVO.setsFlg("");						
//									
//						if(fmsCsulSlpVOs != null){						
//							for(int i= 0; i<fmsCsulSlpVOs.length; i++){
//								fmsCsulSlpVOs[i].setSlpIssDt("");
//								fmsCsulSlpVOs[i].setSlpSeqNo("");
//							}
//						}
//						
////						customTaxVOs = null;
////						customTaxDtlVOs = null;			
//						slpSerNo = command.manageOwnersAccountSlipTax(fmsConsultationVO, fmsCsulSlpVOs, account, null, null);					
//						csrNo = fmsConsultationVO.getSlpTpCd() + 
//									fmsConsultationVO.getSlpFuncCd() + 
//									fmsConsultationVO.getSlpOfcCd() + 
//									fmsConsultationVO.getSlpIssDt() + slpSerNo; 			
//					}
//				}				
//			}
//			
//			log.debug("fmsConsultationVO.getsCsrNo() = "+fmsConsultationVO.getsCsrNo());
//			log.debug("aproType= "+aproType);
//			log.debug("csrNo= "+csrNo);			
//			log.debug("asa No = "+asaNo);
//			
//														
//			if(!"".equals(csrNo)){
//				this.fncApro(csrNo, aproType, command, tCharterIOConsultationBC, asaNo, "2");
//				command.updateApInvHdr(csrNo);
//			}			
			
			eventResponse.setETCData("apro_type", aproType);
			
			commit();			
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;		
	}	
	
	/**
	 * 결재 실행<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */	
	private void fncApro(String csrNo, String aproType, OwnersAccountBC command, TCharterIOConsultationBC tCharterIOConsultationBC, String asaNo, String taxGubun) throws EventException {
		try{
		//		String csrNo = event.getCsrNo();
		//		String aproType = event.getAproType();
				
				String aproFlgUpdateYn = "N";
				String slipAproFlg = ""; // manageSlipApproval 호출시 결재타입 구분 값 > Y : ALPS | N : GW
				
				log.debug("\r\n aproType : " + aproType);
				
				if("ALPS".equals(aproType)) {
					slipAproFlg = "Y";
				}else{
					slipAproFlg = "N";
				}
				
				if("GW".equals(aproType)) {// GW결재일때 첨부파일 복사한다
					log.debug("S ----- Owner's Account Attach Files Copy to GroupWare Path");
					command.sendOwnersAccountAtchFile(csrNo);
					
					log.debug("E ----- Owner's Account Attach Files Copy to GroupWare Path");
					
				}
				
				log.debug("S ----- intert AP_INV_HDR / AP_INV_DTRB ");
		
				String fletCtrtTpCd = "";				  
				if("1".equals(taxGubun)){
					tCharterIOConsultationBC.manageSlipApproval(fletCtrtTpCd, csrNo, "Y", "", account.getUsr_id(), "", "",
							aproFlgUpdateYn, account.getOfc_cd(), slipAproFlg, asaNo);					
				}else{
					tCharterIOConsultationBC.manageSlipApproval(fletCtrtTpCd, csrNo, "Y", "", account.getUsr_id(), "", "",
							aproFlgUpdateYn, account.getOfc_cd(), "N", asaNo);										
				}		
				log.debug("E ----- intert AP_INV_HDR / AP_INV_DTRB ");	
		} catch(EventException ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			rollback();
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}		
	}
	
	/**
	 * ESM_FMS_0095 : [SEARCH]<br>
	 * [전표]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOwnersAccountSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0095Event event = (EsmFms0095Event)e;
		OwnersAccountBC command = new OwnersAccountBCImpl();

		try{
			String sFlg = event.getsFlg();
			log.debug("sFlg : " + sFlg);
			
			FmsConsultationVO fmsConsultationVO = command.searchOwnersAccountConsultation(event.getCsrNo(), sFlg);
			
			List<FmsCsulSlpVO> list = command.searchOwnersAccountCsulSlps(event.getCsrNo(), sFlg);
			List<CustomTaxVO> listTax = command.searchCustomTax(event.getCsrNo());
			List<CustomTaxDtlVO> listTaxDtl = command.searchCustomTaxDtl(event.getCsrNo());			
								
			fmsConsultationVO.setsFlg(sFlg);
			
			if("C".equals(sFlg) || "D".equals(sFlg)) { // Cancel CSR or Delete & Resubmit
				begin();
				
				CancelSlipVO cancelSlipVO = command.cancelOwnersAccountSlip(fmsConsultationVO, list, account);
				
				if(cancelSlipVO.getFmsConsultationVO() == null) {
					eventResponse.setETCData("ofc_chk" , "ERR");
					rollback();
					return eventResponse;
				}
				
				fmsConsultationVO = cancelSlipVO.getFmsConsultationVO();
				
				String newCsrNo = fmsConsultationVO.getSlpTpCd() + 
								  fmsConsultationVO.getSlpFuncCd() + 
								  fmsConsultationVO.getSlpOfcCd() + 
								  fmsConsultationVO.getSlpIssDt() +
								  fmsConsultationVO.getSlpSerNo();
				
				command.manageCancelFileSav(event.getCsrNo(), newCsrNo, 0, account);
				
				commit();

				list = cancelSlipVO.getFmsCsulSlpVOs();
			}
									
			eventResponse.setRsVoList(list);			
			eventResponse.setRsVoList(listTax);
			eventResponse.setRsVoList(listTaxDtl);
			eventResponse.setRsVo(fmsConsultationVO);						
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_FMS_0095 : [SEARCH]<br>
	 * [O/A Cancellation에서 취소를 위해 선택한 전표]을 [조회]합니다.<br>
	 * 
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOwnersAccountCancellationSlip(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0095Event event = (EsmFms0095Event)e;
		OwnersAccountBC command = new OwnersAccountBCImpl();

		try{
			log.debug("### searchOwnersAccountCancellationSlip-1");
			List<FmsCsulSlpVO> list = command.searchOwnersAccountCancellationSlip(event.getCsrNo());
			
			begin();
			log.debug("### searchOwnersAccountCancellationSlip-2");			
			CancelSlipVO cancelSlipVO = command.manageOwnersAccountCancellationSlip(list, account);
			
			if(cancelSlipVO.getFmsConsultationVO() == null) {
				eventResponse.setETCData("ofc_chk" , "ERR");
				rollback();
				return eventResponse;
			}
				
			
			log.debug("### searchOwnersAccountCancellationSlip-3");			
			FmsConsultationVO fmsConsultationVO = cancelSlipVO.getFmsConsultationVO();
			
			log.debug("### searchOwnersAccountCancellationSlip-4");			
			String newCsrNo = fmsConsultationVO.getSlpTpCd() + 
						      fmsConsultationVO.getSlpFuncCd() + 
						      fmsConsultationVO.getSlpOfcCd() + 
						      fmsConsultationVO.getSlpIssDt() +
						      fmsConsultationVO.getSlpSerNo();
	
			String[] arrCsrNo = event.getCsrNo().split(",");
			
			log.debug("arrCsrNo.length = "+arrCsrNo.length);
			for(int j = 0; j < arrCsrNo.length; j++) {
				log.debug("arrCsrNo = "+arrCsrNo[j]);
			}
			log.debug("newCsrNo = "+newCsrNo);
		
			for(int i = 0; i < arrCsrNo.length; i++) {
				command.manageCancelFileSav(arrCsrNo[i], newCsrNo, i+1, account);
			}
			
			commit();
			
//			list = cancelSlipVO.getFmsCsulSlpVOs();
			
			log.debug("### csr_no = "+newCsrNo);						
			list = command.searchOwnersAccountCsulSlps(newCsrNo, "");			
									
			eventResponse.setRsVoList(list);
			eventResponse.setRsVo(fmsConsultationVO);	
		}catch(EventException ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}catch(Exception ex){
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}	
		return eventResponse;
	}
	
	/**
	 * ESM_FMS_0095 : [SEARCH10]<br>
	 * [결재 타입]을 [조회]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchApprovalType(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0095Event event = (EsmFms0095Event)e;
		OwnersAccountBC command = new OwnersAccountBCImpl();
		
		try{
			FmsConsultationVO fmsConsultationVO = event.getFmsConsultationVO();
			
			// 3만불 이상인지 확인
			String aproType = command.searchApprovalType(fmsConsultationVO.getCsrCurrCd(), fmsConsultationVO.getCsrAmt());
			
			if("GW".equalsIgnoreCase(aproType)) {
				log.debug(aproType + " : 3만불 넘었네?");
			}else if("ALPS".equalsIgnoreCase(aproType)) {
				log.debug(aproType + " : 3만불 안 넘었네?");
			}
	
			eventResponse.setETCData("apro_type", aproType);

		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_FMS_0095 : [SEARCH11]<br>
	 * [G/L Date]을 [조회]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGlDate(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0095Event event = (EsmFms0095Event)e;
		OwnersAccountBC command = new OwnersAccountBCImpl();
		
		try{
			FmsConsultationVO fmsConsultationVO = event.getFmsConsultationVO();
			
			String effDt = command.searchGlDate(fmsConsultationVO.getSlpOfcCd());
	
			eventResponse.setETCData("effDt", effDt);

		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_FMS_0095 : [SEARCH13]<br>
	 * [G/L Date]을 [조회]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchGlDate2(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0095Event event = (EsmFms0095Event)e;
		OwnersAccountBC command = new OwnersAccountBCImpl();
		
		try{
			FmsConsultationVO fmsConsultationVO = event.getFmsConsultationVO();
			
			String effDt = command.searchGlDate2(fmsConsultationVO.getSlpOfcCd());
	
			eventResponse.setETCData("effDt", effDt);

		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	
	/**
	 * ESM_FMS_0095 : [SEARCH12]<br>
	 * [Local Currency]을 [조회]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchLocalCurrency(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0095Event event = (EsmFms0095Event)e;
		OwnersAccountBC command = new OwnersAccountBCImpl();
		
		try{
			FmsConsultationVO fmsConsultationVO = event.getFmsConsultationVO();
			
			String currCd = command.searchLocalCurrency(fmsConsultationVO.getSlpOfcCd());
	
			eventResponse.setETCData("currCd", currCd);

		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * Owner's Account 정보를 조회한다<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOwnersAccountList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0096Event event = (EsmFms0096Event)e;
		OwnersAccountBC command = new OwnersAccountBCImpl();
		
		try {
			List<OwnrAcctListVO> ownrAcctList = command.searchOwnersAccountList(event.getOwnrAcctVO(), account.getOfc_cd());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(ownrAcctList);
			return eventResponse;
		
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler("FMS01800",new String[]{}).getMessage(), ex);
		}
	}	
	
	
    /**
     * Owner's Account Office Combo조회
     * 
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	private EventResponse searchOwnOffice(Event e) throws EventException {
		OwnersAccountBC command = new OwnersAccountBCImpl();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		/*
		조건 Office  : 본사심사팀(SELADG) 로긴시에 ALL, 지역본부 Office 보여주고, 
        지역본부 밑에 있는 Office 다 조회되게 처리
        */		
		List<OwnrAcctVO> list = command.searchOwnOfficeList(account.getOfc_cd());			

		String officeCombo = makeOwnOfficeString(list);

		eventResponse.setETCData("office", officeCombo);
		return eventResponse;
	}		
	
	/**
	 * OwnrAcctVO list를 IBSheet내에서 사용할 수 있도록 String으로 변환
	 * @param List<OwnrAcctVO> list
	 * @return String
	 * @throws EventException
	 */
	private String makeOwnOfficeString(List<OwnrAcctVO> list) throws EventException{
		String rtnVal = null;

		StringBuilder sb = new StringBuilder();

		Iterator iterator = (Iterator) list.iterator();

		while(iterator.hasNext()){
			OwnrAcctVO ownrAcctVO = (OwnrAcctVO)iterator.next();
			sb.append(ownrAcctVO.getOffice()+"|");
		}

		rtnVal = sb.toString();

		if (rtnVal.length() > 0){
			rtnVal = rtnVal.substring(0,rtnVal.length()-1);
		}

		return rtnVal;
	}
	
    /**
     * Owner's Account Currency조회
     * 
     * @param Event e
     * @return EventResponse
     * @throws Exception
     */
	private EventResponse searchOwnCurrList(Event e) throws EventException {
		try{
			OwnersAccountBC command = new OwnersAccountBCImpl();		
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			List<OwnrCurrVO> list = command.searchOwnCurrList(account.getOfc_cd());			
			String officeCombo = makeOwnCurrListString(list);
			eventResponse.setETCData("currList", officeCombo);
			
	// ASA		
			ConsultationSlipRequestMgtBC command2 = new ConsultationSlipRequestMgtBCImpl();			
			CheckAsaVO     vo = new CheckAsaVO();							
			vo.setAsaGubun("X");
			vo.setInvOfcCd(account.getOfc_cd());						
			CheckAsaVO checkAsaVO2 = command2.checkAsaOffice(vo);
			eventResponse.setETCData("so_if_cd",checkAsaVO2.getSoIfCd());		

	//ASA List		
			String invOfcCd  =  account.getOfc_cd(); 
			String apOfcCd 	 =  account.getOfc_cd(); 						
			String issDt 	 =   DateTime.getShortDateString();
													
			List<AsaNoVO> list2 = command2.searchAsaNoList(invOfcCd, apOfcCd, issDt);
			
			
			String comboList = makeComboString(list2, 0);			
			eventResponse.setETCData("asa_no" ,comboList);		
			
	//국내 오피스 판단			
			String cntCd = command.searchCountryCodeByOfcCd(account.getOfc_cd());
			eventResponse.setETCData("cnt_cd" ,cntCd);			
			
			return eventResponse;
        } catch (EventException ex) {
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        } catch (Exception ex) {

        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }  		
	}		
	
	/**
	 * 공통 : combo용 String
	 * List를 combo용 String으로 만들어준다. 
	 * @param List<AsaNoVO> list
	 * @param int flg
	 * @return String
	 * @throws EventException
	 */
	private String makeComboString(List<AsaNoVO> list, int flg) throws Exception{
        try{
			String rtnVal = null;
			StringBuilder sb = new StringBuilder();
			
			Iterator iterator = (Iterator) list.iterator();
	
			while(iterator.hasNext()){
				AsaNoVO vo = (AsaNoVO)iterator.next();
				//일반적인 IBCombo용(name, code|)
				if (flg==0){
					sb.append(vo.getName()+","+vo.getCode()+"|");
				//IBCombo (code, code|)
				}else if (flg==1){
					sb.append(vo.getName()+","+vo.getName()+"|");
				//IBSheet의 코드부분(code|)
				}else if (flg==2){ 
					sb.append(vo.getCode()+"|");
				//IBSheet의 코드명부분(name|)
				}else if (flg==3){
					sb.append(vo.getName()+"|"); 
				}
			}
			rtnVal = sb.toString();
	
			if (rtnVal.length() > 0){
				rtnVal = rtnVal.substring(0,rtnVal.length()-1);
			}
			
			return rtnVal;
        } catch (Exception ex) {
//            ex.printStackTrace();
        	log.error("err"+ex.toString(),ex);
            throw new EventException(ex.getMessage(), ex);
        }
	}	
	
	/**
	 * OwnrAcctVO list를 IBSheet내에서 사용할 수 있도록 String으로 변환
	 * @param List<OwnrCurrVO> list
	 * @return String
	 * @throws EventException
	 */
	private String makeOwnCurrListString(List<OwnrCurrVO> list) throws EventException{
		String rtnVal = null;

		StringBuilder sb = new StringBuilder();

		Iterator iterator = (Iterator) list.iterator();

		while(iterator.hasNext()){
			OwnrCurrVO ownrCurrVO = (OwnrCurrVO)iterator.next();
			sb.append(ownrCurrVO.getCurrCd() + "|");
		}

		rtnVal = sb.toString();

		if (rtnVal.length() > 0){
			rtnVal = rtnVal.substring(0,rtnVal.length()-1);
		}

		return rtnVal;
	}
	
 	/**
	 * Invoice No 중복 체크<br>
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	public EventResponse checkInvNo(Event e) throws EventException {
		OwnersAccountBC command = new OwnersAccountBCImpl();		
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		
		EsmFms0095Event event = (EsmFms0095Event)e;
		
		try {

			boolean dup = command.checkInvNo(event.getVndrSeq(), event.getToInvNo(), event.getCsrNo(), event.getVvd());
			
			if(dup) {
				//eventResponse.setUserMessage((String) new ErrorHandler("FMS01479",new String[]{}).getUserMessage());
				eventResponse.setETCData("INV_CHK", "D");
			}
			
			return eventResponse;
			
		} catch(EventException ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch(Exception ex) {
			rollback();
			log.error("err " + ex.toString(), ex);
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		}
	}
	
	/**
	 * Owner's Account For Cancellation 정보를 조회한다<br>
	 * [ESM_FMS_0101] O/A Inquiry for Cancellation
	 * 
	 * @param e Event
	 * @return response EventResponse
	 * @exception EventException
	 */
	private EventResponse searchOwnrsAccntForCnclList(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		EsmFms0101Event event = (EsmFms0101Event)e;
		OwnersAccountBC command = new OwnersAccountBCImpl();
		
		try {
			List<SearchOwnrAcctForCnclListVO> ownrAcctList = command.searchOwnrsAccntForCnclList(event.getCondOwnrAcctForCnclVO());
			GeneralEventResponse eventResponse = new GeneralEventResponse();
			eventResponse.setRsVoList(ownrAcctList);
			return eventResponse;
		
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(), ex);
		} catch (Exception ex) {
			log.error("err " + ex.toString(), ex);
			// [FMS01115] Failed to retrieve Owner's Account. : Owner Account 조회 실패
			throw new EventException(new ErrorHandler("FMS01115",new String[]{}).getMessage(), ex);
		}
	}
	
	/**
	 * ESM_FMS_0095 : [SEARCH13]<br>
	 * [운항팀(PUSMOV)의 Owner's Account조회]을 [조회]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException
	 */
	private EventResponse searchCanalTzOwnerAccountInterface(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0095Event event = (EsmFms0095Event)e;
		CanalTransitFeeInvoiceBC  command = new CanalTransitFeeInvoiceBCImpl();
		
		try{
			String vvd = event.getVvd();			
			List<CanalTzOwnerAccountInterfaceVO> olist = command.searchCanalTzOwnerAccountInterface(vvd);	// Retrun이 List이지만 무조건 1건 조회된다.			
			eventResponse.setRsVoList(olist);
			
			if(olist.size() > 0){				
				eventResponse.setETCData("vsl_cd", olist.get(0).getVslCd());				
				eventResponse.setETCData("skd_voy_no", olist.get(0).getSkdVoyNo());
				eventResponse.setETCData("skd_dir_cd", olist.get(0).getSkdDirCd());
				eventResponse.setETCData("yd_cd", olist.get(0).getYdCd());
				eventResponse.setETCData("rlane_dir_cd", olist.get(0).getRlaneDirCd());
				eventResponse.setETCData("rqst_amt", olist.get(0).getRqstAmt());
				eventResponse.setETCData("file_sav_id", olist.get(0).getFileSavId());
				eventResponse.setETCData("rmk", olist.get(0).getRmk());
				eventResponse.setETCData("invoice_dt", olist.get(0).getInvoiceDt());
				eventResponse.setETCData("inv_no", olist.get(0).getInvNo());				
				eventResponse.setETCData("size", "1");				
			}else{
				eventResponse.setETCData("size", "0");
			}
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
	
	/**
	 * ESM_FMS_0095 : [COMMAND02]<br>
	 * [운항팀(PUSMOV)을 제외한 Office의 재무항차와 ETD를 [조회]합니다.<br>
	 *
	 * @param Event e
	 * @return EventResponse
	 * @exception EventException searchFinancialVVDForOtherOffc
	 */
	private EventResponse searchFinancialVVDForOtherOffc(Event e) throws EventException {
		// PDTO(Data Transfer Object including Parameters)
		GeneralEventResponse eventResponse = new GeneralEventResponse();
		EsmFms0095Event event = (EsmFms0095Event)e;
		OwnersAccountBC  command = new OwnersAccountBCImpl();
		
		try{
			String vvd = event.getVvd();
			String oaLocCd = event.getOaLocCd();
			searchFinancialVVDForOtherOffcVO rsVo = command.searchFinancialVVDForOtherOffc(vvd, oaLocCd);	// Retrun이 List이지만 무조건 1건 조회된다.
			
			eventResponse.setETCData("vsl_cd", rsVo.getVslCd());				
			eventResponse.setETCData("skd_voy_no", rsVo.getSkdVoyNo());
			eventResponse.setETCData("skd_dir_cd", rsVo.getSkdDirCd());
			eventResponse.setETCData("rlane_dir_cd", rsVo.getRlaneDirCd());
			eventResponse.setETCData("vps_etd_dt", rsVo.getVpsEtdDt());
		} catch(EventException ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		} catch(Exception ex) {
			throw new EventException(new ErrorHandler(ex).getMessage(),ex);
		}
		return eventResponse;
	}
}