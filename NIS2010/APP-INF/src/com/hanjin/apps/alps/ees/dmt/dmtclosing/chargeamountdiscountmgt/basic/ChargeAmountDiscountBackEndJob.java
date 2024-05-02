/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeAmountDiscountBackEndJob.java
*@FileTitle : Time Clock Stop Creation
*Open Issues :
*Change history :
*@LastModifyDate : 2009.04.30
*@LastModifier : 최성환
*@LastVersion : 1.0
* 2009.04.30 최성환
* 1.0 Creation
* 2010.09.16 김태균 [] [EES-DMT] AFTER BOOKING BACKENDJOB 메시지 수정
* 2011.05.11.김태균 [CHM-201110489-01] [DMT] Balance Charge에 대한 Free Time 적용 배제 요청
* 2013.01.29 김종옥 [CHM-201222168] [DMT] 화면 단에 Exception Cost 계산 Logic 추가
* 2013.02.08 임창빈[CHM-201322395] DMT OP-MT Detention 계산 방법 보완 3차
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.basic;

import java.util.List;
import java.util.Properties;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration.ChargeAmountDiscountMgtDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AftBkgCxlInvCondVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGGRPVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterProgressVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.BackEndJobResultVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.integration.ChargeCalculationDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeStatusNRemarkVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgBkgCntrVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgCalcVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgTmCskStopVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTBalanceChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCancelChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCombinedChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTExceptionChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTGeneralChargeCalculationUtil;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ExceptionChargeCalculationVO;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic.RFAExceptionTariffMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic.RFAExceptionTariffMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration.InvoiceIssueCollectionMgtDBDAO;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.CancelInvoiceParamVO;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.core.layer.integration.DAOException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * APLS-DMTExceptionMgt Business Logic Basic Command implementation<br>
 * - APLS-DMTClosingMgt에 대한 비지니스 로직을 처리한다.<br>
 *
 * @author Sung Hoon Lee
 * @see UI_DMT_2009EventResponse, ChargeAmountDiscountMgtBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountBackEndJob extends BackEndCommandSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Database Access Object
	private 	DMTCalculationUtil 				dmtCalculationUtil 			= null;
	private  	ChargeCalculationDBDAO 			chgCalcDBDAO 				= null;
	private 	ChargeAmountDiscountMgtDBDAO 	chgAmtDisMgtDBDAO 			= null;
	private  	InvoiceIssueCollectionMgtDBDAO 	invIssueCollectMgtDBDAO 	= null;
	
	private 	RFAExceptionTariffMgtBC 		rfaTariffCommand 			= new RFAExceptionTariffMgtBCImpl();
	private 	ChargeAmountDiscountMgtBC		chgAmountCommand			= new ChargeAmountDiscountMgtBCImpl();
	private     InvoiceIssueCollectionMgtBC		invIssuCommand              = new InvoiceIssueCollectionMgtBCImpl();
	
	private		AfterBKGGRPVO					afterBKGGRPVO				= null;
	private		AfterProgressVO					afterProgressVO				= null;
	private		SignOnUserAccount				account						= null;
	
	/**
	 * ChargeCalculationBCImpl 객체 생성<br>
	 * ChargeCalculationDBDAO를 생성한다.<br>
	 */
	public ChargeAmountDiscountBackEndJob() {

		//1) Persistence 처리를 위한 DAO 생성 ======================================================================
		chgCalcDBDAO 				= new ChargeCalculationDBDAO();
		dmtCalculationUtil 			= new DMTCalculationUtil();
		chgAmtDisMgtDBDAO 			= new ChargeAmountDiscountMgtDBDAO();
		invIssueCollectMgtDBDAO 	= new InvoiceIssueCollectionMgtDBDAO();
	}
	
	public void setAfterBKGGRPVO(AfterBKGGRPVO afterBKGGRPVO) {
		this.afterBKGGRPVO 		= afterBKGGRPVO;
		this.afterProgressVO 	= afterBKGGRPVO.getAfterProgressVO();
	}
	
	public void setUserAccount(SignOnUserAccount account) {
		this.account = account;
	}
	
	/**
	 * After Booking 승인요청시 Calculation 을 포함한 일련의 작업을 BackEnd Job 으로 실행후 결과를 반환합니다.<br>
	 * 
	 * @return Object
	 * @exception Exception
	 */
	public Object doStart() throws Exception {
		
		BackEndJobResultVO						backEndJobResultVO		= new BackEndJobResultVO();
		List<ChargeCalculationContainerVO> 		chgCalcContainerVOs 	= null;
		
		try {
			afterBKGGRPVO.getAfterProgressVO().setBackendJobFlag("Y"); //여기에서는 Comment History 를 생성하지 않는다.
			
			String dmdtExptRqstStsCd = afterProgressVO.getDmdtExptRqstStsCd();
			
			if ("A".equals(dmdtExptRqstStsCd)) {
				//>. C,U,D 가 발생된 경우, 각 트랜잭션별 작업을 수행한다.
				chgAmountCommand.approvalAfterBookingDAR(afterBKGGRPVO, account);
				
				//>. 승인번호를 채번한다.
				String approvalNo = rfaTariffCommand.searchNewApprovalNo(afterProgressVO.getCreUsrId(), afterProgressVO.getRhqOfcCd(), "A");
				afterProgressVO.setAftBkgAproNo(approvalNo);
		
				//>. 승인처리한다.
				chgAmountCommand.approveAfterBookingDAR(afterProgressVO);
			} 
			else if ("O".equals(dmdtExptRqstStsCd) || "J".equals(dmdtExptRqstStsCd)) {

				if ("O".equals(dmdtExptRqstStsCd)) {
					//>. 등록된 After Booking DAR 를 Counter Offered 상태로 수정
					chgAmountCommand.counterofferAfterBookingDAR(afterProgressVO);
				}
				else {
					//>. 등록된 After Booking DAR 를 Reject 상태로 수정
					chgAmountCommand.rejectAfterBookingDAR(afterProgressVO);
				}
				
				//>. 가상Invoice 가 존재할 경우, 가상Invoice 상태를 해제해준다.
				//>. KOR 지역에서 발생된 Charge 에 대해서만 처리하도록 수정함. 2015-01-26
				chgAmountCommand.cancelVirtualInvoice(afterProgressVO.getAftExptDarNo(), account.getUsr_id(), account.getOfc_cd());
			}

			chgAmtDisMgtDBDAO.modifyAfterBookingApprovalStatus(afterProgressVO);
			
			//> A/R I/F 처리되지 않은 Invoice 정보가 존재한다면 Invoice 취소처리를 한다.
			//> KOR, USA 지역에서 발생된 Charge 에 대해서만 처리하도록 수정함. 2015-01-26
			//cancelInvoiceList = chgAmountCommand.cancelInvoiceNotInferfaced(afterProgressVO.getAftExptDarNo(), dmdtExptRqstStsCd, account);
			//>=============================================================================================================================
			//> A/R I/F 처리된 INV. 정보도 취소처리를 한다. 2018.04.02 ( AUTO A/R I/F 개발 요건에 포함 )
			//> AFT BKG 에 적용되는 내용이기 때문에, Manual Invoice 가 아닌 General Invoice 만 대상이 됩니다.
			//>=============================================================================================================================			
			// 1. AFT BKG 승인 및 승인취소시 관련 INV. 가 존재할 경우 취소처리해 줍니다.
			// 1) INV. 취소 처리를 위한 매개변수 설정
			AftBkgCxlInvCondVO cxlInvCondVO = new AftBkgCxlInvCondVO();
			cxlInvCondVO.setAftExptDarNo(afterProgressVO.getAftExptDarNo());
			cxlInvCondVO.setDmdtExptRqstStsCd(afterProgressVO.getDmdtExptRqstStsCd());
			// 2) INV. 취소 실행 (A/R I/F 가 완료된 경우, Credit INV. 발행해서 취소처리를 합니다.)
			List<CancelInvoiceParamVO> cxlInvList = invIssuCommand.cancelInvoiceByAftBkg(cxlInvCondVO, account);
			//>=============================================================================================================================
			
			//> 2. D/C 가 적용되는 CHG 에 대해서 Calculation 실행
			chgCalcContainerVOs = processCalculation();
			
			//> AfterBooking 승인처리 후, Calculation 실행결과 Cancel 된 Invoice 에 Charge 가 발생되었다면 가상 Invoice 를 생성한다.
			//> KOR, USA 지역에서 발생된 Charge 에 대해서만 처리하도록 수정함. 2015-01-26
			//>=============================================================================================================================			
			//> 3. Virtual INV. 생성 (모든 지역에서 발생된 CHG 대상) 2018-04-03 ( AUTO A/R I/F 개발 요건에 포함 )
			//>=============================================================================================================================
			if (cxlInvList != null && cxlInvList.size() > 0) {
				invIssuCommand.modifyInvStsToVtByAftBkg(cxlInvList);
			}
			//>.=============================================================================================================================
			
			backEndJobResultVO.setAfterProgressVO(afterProgressVO);
			backEndJobResultVO.setChargeCalculationContainerVOs(chgCalcContainerVOs);
		}
		catch (EventException ex) {
			log.error("[EventException]"+ex.getMessage());
			throw ex;
		}
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
		return backEndJobResultVO;
	}

	/**
	 * After Booking 에 대한 승인처리시 Calculation 을 실행 합니다. <br>
	 * 
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */	
	public List<ChargeCalculationContainerVO> processCalculation() throws EventException {
		
		List<ChargeCalculationContainerVO> 		chgCalcContainerVOs 	= null;
		
		try {
			//승인처리시 Calculation 처리를 해준다 ############################################################################################
			DMTGeneralChargeCalculationUtil 	dmtGeneralChargeCalcUtil 		= new DMTGeneralChargeCalculationUtil();
			DMTCombinedChargeCalculationUtil 	dmtCombinedChargeCalcUtil 		= new DMTCombinedChargeCalculationUtil();
			DMTCancelChargeCalculationUtil		dmtCancelChargeCalculationUtil 	= new DMTCancelChargeCalculationUtil();
			DMTBalanceChargeCalculationUtil		dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
			
			String 								darNo 							= null;
			ChargeArgumentVO 					chargeArgumentVO				= null;
			ChargeCalculationParmVO 			chgCalcParmVO 					= null;
			ChargeCalculationContainerVO 		chgCalcContainerVO 				= null;
			List<ChargeBookingContainerVO> 		chgBKGContainerVOS 				= null;
			
			com.hanjin.apps.alps.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			
			//1. 대상조회
			chgCalcContainerVOs = chgAmtDisMgtDBDAO.searchChargeCalculationList(afterProgressVO.getAftExptDarNo());
			
			//1-1. 대상조회 후 FOR문으로 대상처리 --------------------------------------------------------------------------------------------
			if (chgCalcContainerVOs != null && chgCalcContainerVOs.size() > 0) {
				for (int i = 0 ; i < chgCalcContainerVOs.size() ; i++) {
					
					chgCalcContainerVO 	= chgCalcContainerVOs.get(i);
					darNo		 		= chgCalcContainerVO.getAftExptDarNo();
					
					//매개변수로 사용될 객체 설정.
					chgCalcParmVO 		= new ChargeCalculationParmVO();
					chgCalcParmVO.setSvrId(				chgCalcContainerVO.getSvrId()			);
					chgCalcParmVO.setCntrNo(			chgCalcContainerVO.getCntrNo()			);
					chgCalcParmVO.setCntrCycNo(			chgCalcContainerVO.getCntrCycNo()		);
					chgCalcParmVO.setDmdtTrfCd(			chgCalcContainerVO.getDmdtTrfCd()		);
					chgCalcParmVO.setDmdtChgLocDivCd(	chgCalcContainerVO.getDmdtChgLocDivCd()	);
					chgCalcParmVO.setChgSeq(			chgCalcContainerVO.getChgSeq()			);
					chgCalcParmVO.setBkgNo(				chgCalcContainerVO.getBkgNo()			);
					chgCalcParmVO.setCntrTpszCd(		chgCalcContainerVO.getCntrTpszCd()		);
					chgCalcParmVO.setFmMvmtDt(			chgCalcContainerVO.getFmMvmtDt()		);
					chgCalcParmVO.setFmMvmtStsCd(		chgCalcContainerVO.getFmMvmtStsCd()		);
					chgCalcParmVO.setFmMvmtYdCd(		chgCalcContainerVO.getFmMvmtYdCd()		);
					chgCalcParmVO.setToMvmtDt(			chgCalcContainerVO.getToMvmtDt()		);
					chgCalcParmVO.setToMvmtStsCd(		chgCalcContainerVO.getToMvmtStsCd()		);
					chgCalcParmVO.setToMvmtYdCd(		chgCalcContainerVO.getToMvmtYdCd()		);
					chgCalcParmVO.setCustCntCd(			chgCalcContainerVO.getCustCntCd()		);
					chgCalcParmVO.setCustSeq(			chgCalcContainerVO.getCustSeq()			);
					chgCalcParmVO.setActCntCd(			chgCalcContainerVO.getActCntCd()		);
					chgCalcParmVO.setActCustSeq(		chgCalcContainerVO.getActCustSeq()		);
					chgCalcParmVO.setIoBndCd(			chgCalcContainerVO.getIoBndCd()			);
					// ------------------------------------------------------------------------------------------------------------------
					
					String checkScRfaExptApltDt = "";
					
					if ("1".equals(chgCalcContainerVO.getChgSeq())) {
						ChargeStatusNRemarkVO checkScRfaExptApltDtVO = null;
						ChargeArgumentVO checkArgumentVO = new ChargeArgumentVO();
					
						checkArgumentVO.setSvrId(chgCalcContainerVO.getSvrId());
						checkArgumentVO.setCntrNo(chgCalcContainerVO.getCntrNo());
						checkArgumentVO.setCntrCycNo(chgCalcContainerVO.getCntrCycNo());
						checkArgumentVO.setDmdtTrfCd(chgCalcContainerVO.getDmdtTrfCd());
						checkArgumentVO.setDmdtChgLocDivCd(chgCalcContainerVO.getDmdtChgLocDivCd());
						checkArgumentVO.setChgSeq(chgCalcContainerVO.getChgSeq());
		
						checkScRfaExptApltDtVO = chgCalcDBDAO.searchChargeStatusNRemark(checkArgumentVO);
						checkScRfaExptApltDt = checkScRfaExptApltDtVO.getScRfaExptApltDt();
					}
					
					//2. Dual Type Exception 여부 비교 ------------------------------------------------------------------------------------
					//2-1) "Y" 이면					
					if ("Y".equals(chgCalcContainerVO.getDulTpExptFlg())) {
//						retChgCalcCntrVO = dmtCombinedChargeCalcUtil.combinedChargeCalculation(chgCalcParmVO);
						//2011.04.29. 추가 ("DR"일때 아닐때 구분)
						if(!chgCalcContainerVO.getFmMvmtStsCd().equals("DR")){
							retChgCalcCntrVO = dmtCombinedChargeCalcUtil.combinedChargeCalculation(chgCalcParmVO);
							if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
								log.error("\n\n combinedChargeCalculation ERROR [Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
								throw new EventException(retChgCalcCntrVO.getMsgDesc());
							}
						}else{
							dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
							retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
							
							if (retChgCalcCntrVO.getMsgCd().equals("-1")) {
								log.error("\n\n[DMT02036][Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
								throw new EventException(retChgCalcCntrVO.getMsgDesc());
							}
						}
					}
					//2-2) "Y"가 아니면
					else {
						if((chgCalcContainerVO.getCxlBkgChgFlg().equals("Y")) ||
							((chgCalcContainerVO.getDmdtTrfCd().equals("DTOC") || chgCalcContainerVO.getDmdtTrfCd().equals("CTOC") ) && chgCalcContainerVO.getFmMvmtStsCd().equals("OP") && chgCalcContainerVO.getToMvmtStsCd().equals("MT"))
							) {
							
							// CxlBkgChgFlg = "Y" : 이미 Booking Cancel 되었음을 의미한다. (배치 프로그램.)
							// TRF CD("DTOC", "CTOC") && FM ("OP") && To ("MT") 현재 Booking Canecl인 아니지만, 곧 Cancel 된다고 생각하면 된다.(화면에서 입력된 경우)
							
							retChgCalcCntrVO = dmtCancelChargeCalculationUtil.cancelChargeCalculation(chgCalcParmVO);
							
							if (retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
								log.error("\n\n[DMT02036][Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
								throw new EventException(retChgCalcCntrVO.getMsgDesc());
							}
						} 
						else {
							if(!("DR").equals(chgCalcContainerVO.getFmMvmtStsCd())) {
								//RETURN = generalChargeCalculation
								retChgCalcCntrVO = dmtGeneralChargeCalcUtil.generalChargeCalculation(chgCalcParmVO);
								
								if (retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
									log.error("\n\n[DMT02036][Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
									throw new EventException(retChgCalcCntrVO.getMsgDesc());
								}
							} else {
								dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
								retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
								
								if (retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
									log.error("\n\n[DMT02036][Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
									throw new EventException(retChgCalcCntrVO.getMsgDesc());
								}
							}
					    }
					}
					
					//위 실행된 Process 가 정상처리가 되지 않았다면 Exception 처리를 해준다.
					if (!"0".equals(retChgCalcCntrVO.getMsgCd())) {
						retChgCalcCntrVO.setDmdtChgStsCd("E");
						chgCalcContainerVO.setCorrRmk(retChgCalcCntrVO.getMsgDesc());
					}
					// ------------------------------------------------------------------------------------------------------------------
					
					//3. DMT_BKG_CNTR TABLE UPDATE --------------------------------------------------------------------------------------
					// ------------ DmtChgBkgCntrVO 객체 구성 -----------------
					DmtChgBkgCntrVO dmtChgBkgCntrVO = new DmtChgBkgCntrVO();
					dmtChgBkgCntrVO.setSvrId(			chgCalcContainerVO.getSvrId()			);
					dmtChgBkgCntrVO.setCntrNo(			chgCalcContainerVO.getCntrNo()			);
					dmtChgBkgCntrVO.setCntrCycNo(		chgCalcContainerVO.getCntrCycNo()		);
					dmtChgBkgCntrVO.setBlNo(			chgCalcContainerVO.getBlNo()			);
					//--------------- ChargePartialPaymentVO -------------------
					dmtChgBkgCntrVO.setVslCd(			chgCalcContainerVO.getVslCd()			);
					dmtChgBkgCntrVO.setSkdVoyNo(		chgCalcContainerVO.getSkdVoyNo()		);
					dmtChgBkgCntrVO.setSkdDirCd(		chgCalcContainerVO.getSkdDirCd()		);
					//--------------------------------------------------------
					dmtChgBkgCntrVO.setVpsEtaDt(		retChgCalcCntrVO.getVpsEtaDt()			);
					dmtChgBkgCntrVO.setScNo(			retChgCalcCntrVO.getBrhScNo()			);
					dmtChgBkgCntrVO.setRfaNo(			retChgCalcCntrVO.getBrhRfaNo()			);
					dmtChgBkgCntrVO.setCmdtCd(			retChgCalcCntrVO.getCmdtCd()			);
					dmtChgBkgCntrVO.setRepCmdtCd(		retChgCalcCntrVO.getRepCmdtCd()			);
					dmtChgBkgCntrVO.setDcgoFlg(			retChgCalcCntrVO.getDcgoFlg()			);
					dmtChgBkgCntrVO.setRcFlg(			retChgCalcCntrVO.getRcFlg()				);
					dmtChgBkgCntrVO.setBbCgoFlg(		retChgCalcCntrVO.getBbCgoFlg()			);
					dmtChgBkgCntrVO.setAwkCgoFlg(		retChgCalcCntrVO.getAwkCgoFlg()			);
					dmtChgBkgCntrVO.setRdCgoFlg(		retChgCalcCntrVO.getRdCgoFlg()			);
					dmtChgBkgCntrVO.setSocFlg(			retChgCalcCntrVO.getSocFlg()			);
					dmtChgBkgCntrVO.setCntrPrtFlg(		retChgCalcCntrVO.getCntrPrtFlg()		);
					dmtChgBkgCntrVO.setAdvShtgCd(		retChgCalcCntrVO.getAdvShtgCd()			);
					dmtChgBkgCntrVO.setDmdtCntrTpCd(	retChgCalcCntrVO.getCntrTp()			);
					dmtChgBkgCntrVO.setDmdtBkgCgoTpCd(	retChgCalcCntrVO.getDmdtCgoTpCd()		);
					dmtChgBkgCntrVO.setPorCd(			retChgCalcCntrVO.getPorCd()				);
					dmtChgBkgCntrVO.setPolCd(			retChgCalcCntrVO.getPolCd()				);
					dmtChgBkgCntrVO.setPodCd(			retChgCalcCntrVO.getPodCd()				);
					dmtChgBkgCntrVO.setDelCd(			retChgCalcCntrVO.getDelCd()				);
					dmtChgBkgCntrVO.setBkgRcvTermCd(	retChgCalcCntrVO.getBbRcvTermCd()		);
					dmtChgBkgCntrVO.setBkgDeTermCd(		retChgCalcCntrVO.getBbDeTermCd()		);
					dmtChgBkgCntrVO.setBkgCntrQty(		retChgCalcCntrVO.getBkgQty()			);
					dmtChgBkgCntrVO.setSlsOfcCd(		retChgCalcCntrVO.getSalOfc()			);
					dmtChgBkgCntrVO.setRhqCd(			retChgCalcCntrVO.getSalRhq()			);
					dmtChgBkgCntrVO.setUpdUsrId(		afterProgressVO.getUpdUsrId()			);
					dmtChgBkgCntrVO.setUpdOfcCd(		afterProgressVO.getUpdOfcCd()			);
	
					chgCalcDBDAO.modifyBookingContainer(dmtChgBkgCntrVO);
					// ------------------------------------------------------------------------------------------------------------------
	
					// ************* DmtChgCalcVO 객체 구성 *****************
					DmtChgCalcVO dmtChgCalcVO = new DmtChgCalcVO();
					
					//4. DMT_CHG_CALC TABLE UPDATE --------------------------------------------------------------------------------------
					dmtChgCalcVO.setSvrId(				chgCalcContainerVO.getSvrId()			);
					dmtChgCalcVO.setCntrNo(				chgCalcContainerVO.getCntrNo()			);
					dmtChgCalcVO.setCntrCycNo(			chgCalcContainerVO.getCntrCycNo()		);
					dmtChgCalcVO.setDmdtTrfCd(			chgCalcContainerVO.getDmdtTrfCd()		);
					dmtChgCalcVO.setDmdtChgLocDivCd(	chgCalcContainerVO.getDmdtChgLocDivCd()	);
					dmtChgCalcVO.setChgSeq(				chgCalcContainerVO.getChgSeq()			);
					
					dmtChgCalcVO.setFmMvmtStsCd(		chgCalcContainerVO.getFmMvmtStsCd()		);
					dmtChgCalcVO.setFmMvmtDt(			chgCalcContainerVO.getFmMvmtDt()		);
					dmtChgCalcVO.setFmMvmtYdCd(			chgCalcContainerVO.getFmMvmtYdCd()		);
					dmtChgCalcVO.setToMvmtStsCd(		chgCalcContainerVO.getToMvmtStsCd()		);
					dmtChgCalcVO.setToMvmtDt(			chgCalcContainerVO.getToMvmtDt()		);
					dmtChgCalcVO.setToMvmtYdCd(			chgCalcContainerVO.getToMvmtYdCd()		);
					dmtChgCalcVO.setNotCreBalFlg(		"N"										);
					dmtChgCalcVO.setFtDys(				retChgCalcCntrVO.getFtDys()				);
					dmtChgCalcVO.setFtCmncDt(			retChgCalcCntrVO.getFtCmncDt()			);
					dmtChgCalcVO.setFtEndDt(			retChgCalcCntrVO.getFtEndDt()			);
					dmtChgCalcVO.setFxFtOvrDys(			retChgCalcCntrVO.getFxFtOvrDys()		);
					dmtChgCalcVO.setOrgFtOvrDys(		retChgCalcCntrVO.getOrgFtOvrDys()		);
					dmtChgCalcVO.setScRfaExptOvrDys(	retChgCalcCntrVO.getScRfaExptOvrDys()	);
					dmtChgCalcVO.setAftExptOvrDys(		retChgCalcCntrVO.getAftExptOvrDys()		);
					dmtChgCalcVO.setBzcTrfCurrCd(		retChgCalcCntrVO.getBzcTrfCurrCd()		);
					dmtChgCalcVO.setDmdtTrfAplyTpCd(	retChgCalcCntrVO.getDmdtTrfAplyTpCd()	);
					dmtChgCalcVO.setOrgChgAmt(			retChgCalcCntrVO.getOrgChgAmt()			);
					dmtChgCalcVO.setScRfaExptAmt(		retChgCalcCntrVO.getScRfaExptAmt()		);
					dmtChgCalcVO.setAftExptDcAmt(		retChgCalcCntrVO.getAftExptDcAmt()		);
					dmtChgCalcVO.setBilAmt(				retChgCalcCntrVO.getBilAmt()			);
					
					//"I"(ISSUED)인 경우 계산후 생성된 STATUS를 "I"로 변경한다. =======================
					if ("I".equals(chgCalcContainerVO.getDmdtChgStsCd())) {
						dmtChgCalcVO.setDmdtChgStsCd("I");
					}
					else {
						dmtChgCalcVO.setDmdtChgStsCd(retChgCalcCntrVO.getDmdtChgStsCd());
					}
					//============================================================================
					
					dmtChgCalcVO.setScRfaAmt(			retChgCalcCntrVO.getScRfaAmt()			);
					dmtChgCalcVO.setAftExptAmt(			retChgCalcCntrVO.getAftExptAmt()		);
					dmtChgCalcVO.setBzcTrfSeq(			retChgCalcCntrVO.getBzcTrfSeq()			);
					dmtChgCalcVO.setBzcTrfGrpSeq(		retChgCalcCntrVO.getBzcTrfGrpSeq()		);
					dmtChgCalcVO.setBzcTrfAplyDt(		retChgCalcCntrVO.getBzcTrfAplyDt()		);		
					dmtChgCalcVO.setRfaExptAproNo(		retChgCalcCntrVO.getRfaExptAproNo()		);
					dmtChgCalcVO.setRfaExptDarNo(		retChgCalcCntrVO.getRfaExptDarNo()		);
					dmtChgCalcVO.setRfaExptMapgSeq(		retChgCalcCntrVO.getRfaExptMapgSeq()	);		
					dmtChgCalcVO.setRfaExptVerSeq(		retChgCalcCntrVO.getRfaExptVerSeq()		);
					dmtChgCalcVO.setRfaRqstDtlSeq(		retChgCalcCntrVO.getRfaRqstDtlSeq()		);
					dmtChgCalcVO.setAftExptAproNo(		retChgCalcCntrVO.getAftExptAproNo()		);
					dmtChgCalcVO.setAftExptDarNo(		retChgCalcCntrVO.getAftExptDarNo()		);
					dmtChgCalcVO.setAftExptAdjSeq(		retChgCalcCntrVO.getAftExptAdjSeq()		);
					dmtChgCalcVO.setScNo(				retChgCalcCntrVO.getScNo()				);
					dmtChgCalcVO.setScExptVerSeq(		retChgCalcCntrVO.getScExptVerSeq()		);
					dmtChgCalcVO.setScExptGrpSeq(		retChgCalcCntrVO.getScExptGrpSeq()		);
					dmtChgCalcVO.setScRfaExptAplyDt(	retChgCalcCntrVO.getScRfaExptAplyDt()	);
					dmtChgCalcVO.setCorrRmk(			chgCalcContainerVO.getCorrRmk()			);
					
					//OFC_CD, OFC_RHQ_CD, DMDT_INV_NO 는 기존 값(DMT_CHG_CALC)을 그대로 설정한다. ========
					dmtChgCalcVO.setOfcCd(				chgCalcContainerVO.getOfcCd()			);
					dmtChgCalcVO.setOfcRhqCd(			chgCalcContainerVO.getOfcRhqCd()		);
					dmtChgCalcVO.setDmdtInvNo(			chgCalcContainerVO.getDmdtInvNo()		);
					//================================================================================
	
					dmtChgCalcVO.setUpdUsrId(			afterProgressVO.getUpdUsrId()			);
					dmtChgCalcVO.setUpdOfcCd(			afterProgressVO.getUpdOfcCd()			);
					dmtChgCalcVO.setCmdtCd(				retChgCalcCntrVO.getCmdtCd()			);
					dmtChgCalcVO.setCmdtTrfSeq(			retChgCalcCntrVO.getCmdtTrfSeq()		);
					dmtChgCalcVO.setCmdtExptAplyDt(		retChgCalcCntrVO.getCmdtExptAplyDt()	);
					dmtChgCalcVO.setCmdtOvrDys(			retChgCalcCntrVO.getCmdtOvrDys()		);
					dmtChgCalcVO.setCmdtExptAmt(		retChgCalcCntrVO.getCmdtExptAmt()		);
					dmtChgCalcVO.setWebMtyDt(			chgCalcContainerVO.getWebMtyDt()		);
					
					dmtChgCalcVO.setBzcDmdtDeTermCd(	retChgCalcCntrVO.getBzcDmdtDeTermCd() );
					dmtChgCalcVO.setUclmFlg(	chgCalcContainerVO.getUclmFlg() );
					
					chgCalcDBDAO.modifyChargeCalculation(dmtChgCalcVO);
					
					if (chgCalcContainerVO.getDulTpExptFlg().equals("Y")) {
						
						chargeArgumentVO = new ChargeArgumentVO();
						chargeArgumentVO.setSvrId(				chgCalcContainerVO.getSvrId()			);
						chargeArgumentVO.setCntrNo(				chgCalcContainerVO.getCntrNo()			);
						chargeArgumentVO.setCntrCycNo(			chgCalcContainerVO.getCntrCycNo()		);
						chargeArgumentVO.setDmdtTrfCd(			chgCalcContainerVO.getDmdtTrfCd()		);
						chargeArgumentVO.setDmdtChgLocDivCd(	chgCalcContainerVO.getDmdtChgLocDivCd()	);
						chargeArgumentVO.setChgSeq(				chgCalcContainerVO.getChgSeq()			);
						chargeArgumentVO.setFmMvmtDt(			chgCalcContainerVO.getFmMvmtDt()		);
						chargeArgumentVO.setToMvmtDt(			chgCalcContainerVO.getToMvmtDt()		);
						
						// Dual Exception Charge의 ORG_CHG_AMT, SC_RFA_EXPT_AMT 필드값 수정
						chgCalcDBDAO.modifyOrgChgAmt(chargeArgumentVO);
					}					
					// ------------------------------------------------------------------------------------------------------------------
					
					// 2 번에서 조회된 결과가 에러일 경우 DMT_CHG_CALC TABLE UPDATE 까지만 마치고 그 이하 프로세스는 태우지 않는다.
					if ("E".equals(retChgCalcCntrVO.getDmdtChgStsCd())) {
						continue;
					}
					
					//7. CLOCK STOP HISTORY 를 저장한다. ----------------------------------------------------------------------------------
					//   Clock Stop이 하루이상 적용되었으면(cStopNoList.size() > 0) addClockStopHistory 실행
					List<String> cStopNoList = retChgCalcCntrVO.getCStopNoList();
					if(cStopNoList != null && cStopNoList.size() > 0) {
						DmtChgTmCskStopVO dmtChgTmCskStopVO = new DmtChgTmCskStopVO();
						dmtChgTmCskStopVO.setSvrId(				chgCalcContainerVO.getSvrId()			);
						dmtChgTmCskStopVO.setCntrNo(			chgCalcContainerVO.getCntrNo()			);
						dmtChgTmCskStopVO.setCntrCycNo(			chgCalcContainerVO.getCntrCycNo()		);
						dmtChgTmCskStopVO.setDmdtTrfCd(			chgCalcContainerVO.getDmdtTrfCd()		);
						dmtChgTmCskStopVO.setDmdtChgLocDivCd(	chgCalcContainerVO.getDmdtChgLocDivCd()	);
						dmtChgTmCskStopVO.setChgSeq(			chgCalcContainerVO.getChgSeq()			);
	
						// 기 생성된 Clock Stop History 를 삭제한다.
						chgCalcDBDAO.deleteClockStopHistory(dmtChgTmCskStopVO);
						
						// 적용된 Clock Stop 갯수만큼 반복문을 실행하며 Insert 한다.
						for (int j = 0 ; j < cStopNoList.size() ; j++) {
							String clkStopNo = cStopNoList.get(j);
							dmtChgTmCskStopVO.setClkStopNo(clkStopNo);
							
							chgCalcDBDAO.addClockStopHistory(dmtChgTmCskStopVO);
						}						
					}
					// ------------------------------------------------------------------------------------------------------------------
					
					//8. DMT_INV_MN TABLE을 UPDATE한다. ----------------------------------------------------------------------------------
					invIssueCollectMgtDBDAO.modifyInvoiceAdjustAmount(darNo);
					// ------------------------------------------------------------------------------------------------------------------
					
					//9. "KOR"지역인 경우 터미널에 EDI를 전송한다. ( 차후 구현 예정) ----------------------------------------------------------
					//9-1) 대상을 조회한 후 FOR문으로 대상처리	(9 - (1 )
					List<String> list = chgAmtDisMgtDBDAO.searchBKGListByDARNo(darNo);
					if (list != null && list.size() > 0) {
						for (int j = 0 ; j <  list.size() ; j++) {
					
							//9-2) Booking에 속한 Container 중, After Exception 적용된 Container를 조회한 후 FOR문으로 대상 처리 	(9 - (2 )
							chgBKGContainerVOS = chgAmtDisMgtDBDAO.searchContainerListAppliedAfterExceptionByDARNo(darNo, list.get(j));
							if (chgBKGContainerVOS != null && chgBKGContainerVOS.size() > 0) {
								for (int k = 0 ; k < chgBKGContainerVOS.size(); k++) {
									
									//9-3) DMDT_TRF_CD == 'DMIF'인 경우 searchDTICFreeTimeEndDate를 호출하여 FREE TIME END DATE 및 FREE TIME OVER DAY를 조회한다
									if ("DMIF".equals(chgBKGContainerVOS.get(k).getDmdtTrfCd())) {
										dmtCalculationUtil.searchDTICFreeTimeEndDate(
														  chgCalcContainerVO.getSvrId()
														, chgCalcContainerVO.getCntrNo()
														, Long.parseLong(chgCalcContainerVO.getCntrCycNo())
														, chgCalcContainerVO.getDmdtTrfCd()
														, chgCalcContainerVO.getDmdtChgLocDivCd()
														, Long.parseLong(chgCalcContainerVO.getChgSeq()));
									}
									//9-4) DMDT_TRF_CD == 'DMIC'인 경우 searchDMIFFreeTimeEndDate를 호출하여 FREE TIME END DATE를 조회한다.
									//     DTIC FREE TIME OVER DAY를 조회한다	(9 - (4 )
									else if ("DTIC".equals(chgBKGContainerVOS.get(k).getDmdtTrfCd())) {
										dmtCalculationUtil.searchDMIFFreeTimeEndDate(
													  	  chgCalcContainerVO.getSvrId()
														, chgCalcContainerVO.getCntrNo()
														, Long.parseLong(chgCalcContainerVO.getCntrCycNo())
														, chgCalcContainerVO.getDmdtTrfCd()
														, chgCalcContainerVO.getDmdtChgLocDivCd()
														, Long.parseLong(chgCalcContainerVO.getChgSeq()));												
									}
								}
							}
						}
					}
					
					log.debug("\n[Exception Cost] --------------------------------------------[Start]"  );
					log.debug("\n[Exception Cost] checkScRfaExptApltDt : " + checkScRfaExptApltDt);
					log.debug("\n[Exception Cost] getScRfaExptAplyDt : " + retChgCalcCntrVO.getScRfaExptAplyDt());
					log.debug("\n[Exception Cost] getCntrTpszCd : " + chgCalcParmVO.getCntrTpszCd().substring(0, 1) );
					log.debug("\n[Exception Cost] getDmdtChgStsCd : " + dmtChgCalcVO.getDmdtChgStsCd() );
					log.debug("\n[Exception Cost] getDmdtTrfCd : " + dmtChgCalcVO.getDmdtTrfCd());
					log.debug("\n[Exception Cost] getDulTpExptFlg : " + "Y".equals(dmtChgCalcVO.getDulTpExptFlg()) );
					log.debug("\n[Exception Cost] getChgSeq : " + dmtChgCalcVO.getChgSeq() );
					log.debug("\n[Exception Cost] --------------------------------------------[End]"  );
					
					//Exception Cost를 재계산 로직 추가
					if( (checkScRfaExptApltDt != null || retChgCalcCntrVO.getScRfaExptAplyDt() != null)
						&& ("USA".equals(chgCalcContainerVO.getSvrId()) || "EUR".equals(chgCalcContainerVO.getSvrId()))
						&& chgCalcContainerVO.getCntrTpszCd().substring(0, 1).equals("D") 
						&& (    "C".equals(dmtChgCalcVO.getDmdtChgStsCd())
							 || "F".equals(dmtChgCalcVO.getDmdtChgStsCd())
						     || "I".equals(dmtChgCalcVO.getDmdtChgStsCd())
						     || "L".equals(dmtChgCalcVO.getDmdtChgStsCd())
						     || "N".equals(dmtChgCalcVO.getDmdtChgStsCd())
						     || "U".equals(dmtChgCalcVO.getDmdtChgStsCd())
						     || "D".equals(dmtChgCalcVO.getDmdtChgStsCd())
						    )
						&& (    "DMIF".equals(dmtChgCalcVO.getDmdtTrfCd())
						     || "DTIC".equals(dmtChgCalcVO.getDmdtTrfCd())
						     || "CTIC".equals(dmtChgCalcVO.getDmdtTrfCd())
						    )							     
						&& !("Y".equals(dmtChgCalcVO.getDulTpExptFlg()) && "D".equals(dmtChgCalcVO.getDmdtTrfCd().substring(0, 1)))
                        && (dmtChgCalcVO.getChgSeq().equals("1"))
					  )
					{
						DMTExceptionChargeCalculationUtil exceptionChargeCalculationUtil = new DMTExceptionChargeCalculationUtil();
						ChargeCalculationParmVO chargeCalculationParmVO = new ChargeCalculationParmVO();

						chargeCalculationParmVO.setBkgNo(chgCalcParmVO.getBkgNo());
						chargeCalculationParmVO.setSvrId(chgCalcContainerVO.getSvrId());
						chargeCalculationParmVO.setCntrNo(chgCalcParmVO.getCntrNo());
						chargeCalculationParmVO.setCntrCycNo(String.valueOf(chgCalcParmVO.getCntrCycNo()));
						chargeCalculationParmVO.setDmdtTrfCd(chgCalcParmVO.getDmdtTrfCd());
						chargeCalculationParmVO.setDmdtChgLocDivCd(chgCalcParmVO.getDmdtChgLocDivCd());
						chargeCalculationParmVO.setChgSeq(String.valueOf(chgCalcParmVO.getChgSeq()));
						chargeCalculationParmVO.setDmdtChgStsCd(dmtChgCalcVO.getDmdtChgStsCd());
						
						chargeCalculationParmVO.setFmMvmtDt(chgCalcParmVO.getFmMvmtDt());
						chargeCalculationParmVO.setFmMvmtYdCd(chgCalcParmVO.getFmMvmtYdCd());
						chargeCalculationParmVO.setFmMvmtStsCd(chgCalcParmVO.getFmMvmtStsCd());
						chargeCalculationParmVO.setToMvmtDt(retChgCalcCntrVO.getToMvmtDt());
						chargeCalculationParmVO.setToMvmtYdCd(retChgCalcCntrVO.getToMvmtYdCd());
						chargeCalculationParmVO.setToMvmtStsCd(retChgCalcCntrVO.getToMvmtStsCd());
						chargeCalculationParmVO.setDmdtTrfAplyTpCd(retChgCalcCntrVO.getDmdtTrfAplyTpCd());
						chargeCalculationParmVO.setBzcTrfSeq(String.valueOf(retChgCalcCntrVO.getBzcTrfSeq()));
						chargeCalculationParmVO.setBzcTrfGrpSeq(String.valueOf(retChgCalcCntrVO.getBzcTrfGrpSeq()));
						chargeCalculationParmVO.setRfaExptDarNo(retChgCalcCntrVO.getRfaExptDarNo());
						chargeCalculationParmVO.setRfaExptMapgSeq(String.valueOf(retChgCalcCntrVO.getRfaExptMapgSeq()));
						chargeCalculationParmVO.setRfaExptVerSeq(String.valueOf(retChgCalcCntrVO.getRfaExptVerSeq()));
						chargeCalculationParmVO.setRfaRqstDtlSeq(String.valueOf(retChgCalcCntrVO.getRfaRqstDtlSeq()));
						chargeCalculationParmVO.setScNo(retChgCalcCntrVO.getScNo());
						chargeCalculationParmVO.setScExptVerSeq(String.valueOf(retChgCalcCntrVO.getScExptVerSeq()));
						chargeCalculationParmVO.setScExptGrpSeq(String.valueOf(retChgCalcCntrVO.getScExptGrpSeq()));
						chargeCalculationParmVO.setCntrTpszCd(chgCalcParmVO.getCntrTpszCd());
						chargeCalculationParmVO.setIoBndCd(chgCalcParmVO.getIoBndCd());
						chargeCalculationParmVO.setOfcCd(retChgCalcCntrVO.getOfcCd());
						chargeCalculationParmVO.setDulTpExptFlg(chgCalcParmVO.getDulTpExptFlg());
						chargeCalculationParmVO.setCgoTpCd(chgCalcParmVO.getCgoTpCd());

						ExceptionChargeCalculationVO exceptionChargeCalculationVO = null;
						exceptionChargeCalculationVO = exceptionChargeCalculationUtil.exceptionChargeCalculation(chargeCalculationParmVO);

						exceptionChargeCalculationVO.setBkgNo(chgCalcParmVO.getBkgNo());
						exceptionChargeCalculationVO.setCntrNo(chgCalcParmVO.getCntrNo());
						exceptionChargeCalculationVO.setCntrCycNo(String.valueOf(chgCalcParmVO.getCntrCycNo()));
						exceptionChargeCalculationVO.setDmdtTrfCd(chgCalcParmVO.getDmdtTrfCd());
						exceptionChargeCalculationVO.setDmdtChgLocDivCd(chgCalcParmVO.getDmdtChgLocDivCd());
						exceptionChargeCalculationVO.setChgSeq(String.valueOf(chgCalcParmVO.getChgSeq()));
						exceptionChargeCalculationVO.setDmdtChgStsCd(dmtChgCalcVO.getDmdtChgStsCd());
						
						exceptionChargeCalculationVO.setOfcCd(retChgCalcCntrVO.getOfcCd());
						exceptionChargeCalculationVO.setCntrTpszCd(chgCalcParmVO.getCntrTpszCd());
						exceptionChargeCalculationVO.setUpdUsrId(account.getUsr_id());
						exceptionChargeCalculationVO.setUpdOfcCd(account.getOfc_cd());

						chgCalcDBDAO.mergeDmtExceptionChargeCalculation(exceptionChargeCalculationVO);
					}
				}
			}

			//##############################################################################################################################
		} 
		catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} 
		catch (EventException ex) {
			log.error("[EventException]"+ex.getMessage());
			throw ex;
		} 
		catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}
		return chgCalcContainerVOs;
	}
}
