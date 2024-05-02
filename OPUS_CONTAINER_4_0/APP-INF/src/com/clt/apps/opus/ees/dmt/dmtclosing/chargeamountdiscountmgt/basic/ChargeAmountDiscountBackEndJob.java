/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeAmountDiscountBackEndJob.java
*@FileTitle : Time Clock Stop Creation
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.integration.ChargeAmountDiscountMgtDBDAO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterBKGGRPVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.AfterProgressVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.BackEndJobResultVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeamountdiscountmgt.vo.ChargeBookingContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.integration.ChargeCalculationDBDAO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgBkgCntrVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgCalcVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtChgTmCskStopVO;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTBalanceChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCancelChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTCombinedChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.DMTGeneralChargeCalculationUtil;
import com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationParmVO;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic.RFAExceptionTariffMgtBC;
import com.clt.apps.opus.ees.dmt.dmtexceptionmgt.rfaexceptiontariffmgt.basic.RFAExceptionTariffMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.integration.InvoiceIssueCollectionMgtDBDAO;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-DMTExceptionMgt Business Logic Basic Command implementation<br>
 * - handling business transaction of  OPUS-DMTClosingMgt<br>
 * @author
 * @see reference DAO class UI_DMT_2009EventResponse, ChargeAmountDiscountMgtBC
 * @since J2EE 1.6
 */

public class ChargeAmountDiscountBackEndJob extends BackEndCommandSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private  	ChargeCalculationDBDAO 			chgCalcDBDAO 				= null;
	private 	ChargeAmountDiscountMgtDBDAO 	chgAmtDisMgtDBDAO 			= null;
	private  	InvoiceIssueCollectionMgtDBDAO 	invIssueCollectMgtDBDAO 	= null;
	
	private 	RFAExceptionTariffMgtBC 		rfaTariffCommand 			= new RFAExceptionTariffMgtBCImpl();
	private 	ChargeAmountDiscountMgtBC		chgAmountCommand			= new ChargeAmountDiscountMgtBCImpl();
	
	private		AfterBKGGRPVO					afterBKGGRPVO				= null;
	private		AfterProgressVO					afterProgressVO				= null;
	private		SignOnUserAccount				account						= null;
	
	/**
	 * ChargeCalculationBCImpl create object<br>
	 * create ChargeCalculationDBDAO<br>
	 */
	public ChargeAmountDiscountBackEndJob() {
		//1) Create BC for process business logic ===================================================================
		rfaTariffCommand			= new RFAExceptionTariffMgtBCImpl();
		chgAmountCommand			= new ChargeAmountDiscountMgtBCImpl();

		//2) Create DAO for process Persistence ======================================================================
		chgCalcDBDAO 				= new ChargeCalculationDBDAO();
		new DMTCalculationUtil();
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
	 * Run BackEnd Job and return result at Requst Approval After Booking Calculation<br>
	 * 
	 * @return Object
	 * @exception Exception
	 */
	public Object doStart() throws Exception {
		
		BackEndJobResultVO						backEndJobResultVO		= new BackEndJobResultVO();
		List<ChargeCalculationContainerVO> 		chgCalcContainerVOs 	= null;

		try {
			//1) process  modified data
			afterBKGGRPVO.getAfterProgressVO().setBackendJobFlag("Y"); //not create Comment History
			
			
			String dmdtExptRqstStsCd = afterProgressVO.getDmdtExptRqstStsCd();
			
			if("A".equals(dmdtExptRqstStsCd)) {
				chgAmountCommand.requestAfterBookingDAR(afterBKGGRPVO, account);
				
				//2) make aprroval no 
				String approvalNo = rfaTariffCommand.searchNewApprovalNo(afterProgressVO.getCreUsrId(), afterProgressVO.getRhqOfcCd(), "A");
				afterProgressVO.setAftBkgAproNo(approvalNo);
		
				//3)agree aprroval
				chgAmountCommand.approveAfterBookingDAR(afterProgressVO);
				
			} else if("O".equals(dmdtExptRqstStsCd)) {
				// Counter Offered modify After Booking DAR
				chgAmountCommand.counterofferAfterBookingDAR(afterProgressVO);
				
			} else if("J".equals(dmdtExptRqstStsCd)) {
				// After Booking DAR Change to Reject
				chgAmountCommand.rejectAfterBookingDAR(afterProgressVO);
			}
			
			//4)Do Calculation.
			chgCalcContainerVOs = processCalculation();
			
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
	 *  Calculation Aprroval After Booking <br>
	 * 
	 * @return List<ChargeCalculationContainerVO>
	 * @exception EventException
	 */	
	public List<ChargeCalculationContainerVO> processCalculation() throws EventException {
		
		List<ChargeCalculationContainerVO> 		chgCalcContainerVOs 	= null;
		
		try {
			// Calculation Aprroval ############################################################################################
			DMTGeneralChargeCalculationUtil 	dmtGeneralChargeCalcUtil 		= new DMTGeneralChargeCalculationUtil();
			DMTCombinedChargeCalculationUtil 	dmtCombinedChargeCalcUtil 		= new DMTCombinedChargeCalculationUtil();
			DMTCancelChargeCalculationUtil		dmtCancelChargeCalculationUtil 	= new DMTCancelChargeCalculationUtil();
			
			String 								darNo 							= null;
			ChargeArgumentVO 					chargeArgumentVO				= null;
			ChargeCalculationParmVO 			chgCalcParmVO 					= null;
			ChargeCalculationContainerVO 		chgCalcContainerVO 				= null;
			//List<ChargeBookingContainerVO> 		chgBKGContainerVOS 				= null;
			
			com.clt.apps.opus.ees.dmt.dmtcommonutil.dmtcalculationutil.vo.ChargeCalculationContainerVO retChgCalcCntrVO = null;
			
			//search target.
			chgCalcContainerVOs = chgAmtDisMgtDBDAO.searchChargeCalculationList(afterProgressVO.getAftExptDarNo());
			
			//1-1.  handling target ------------------------------------------------------------------------------------------
			if (chgCalcContainerVOs != null && chgCalcContainerVOs.size() > 0) {
				for (int i = 0 ; i < chgCalcContainerVOs.size() ; i++) {
					
					chgCalcContainerVO 	= chgCalcContainerVOs.get(i);
					darNo		 		= chgCalcContainerVO.getAftExptDarNo();
					
			
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

					
					//2. comparing Dual Type Exception------------------------------------------------------------------------------------
					//2-1) "Y" 이면     
				     if ("Y".equals(chgCalcContainerVO.getDulTpExptFlg())) {
//				       retChgCalcCntrVO = dmtCombinedChargeCalcUtil.combinedChargeCalculation(chgCalcParmVO);
				       //2011.04.29. 추가 ("DR"일때 아닐때 구분)
				       if(!chgCalcContainerVO.getFmMvmtStsCd().equals("DR")){
				        retChgCalcCntrVO = dmtCombinedChargeCalcUtil.combinedChargeCalculation(chgCalcParmVO);
				        if(retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
				         log.error("\n\n combinedChargeCalculation ERROR [Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
				         throw new EventException(retChgCalcCntrVO.getMsgDesc());
				        }
				       }else{
				    	DMTBalanceChargeCalculationUtil dmtBalanceChargeCalculationUtil = new DMTBalanceChargeCalculationUtil();
				        retChgCalcCntrVO = dmtBalanceChargeCalculationUtil.balanceChargeCalculation(chgCalcParmVO);
				        
				        if (retChgCalcCntrVO.getMsgCd().equals("-1")) {
				         log.error("\n\n[DMT02036][Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
				         throw new EventException(retChgCalcCntrVO.getMsgDesc());
				        }
				       }
				      }

					//2-2)  if !"Y" then	
					else {
						if (chgCalcContainerVO.getCxlBkgChgFlg().equals("Y")) {
							retChgCalcCntrVO = dmtCancelChargeCalculationUtil.cancelChargeCalculation(chgCalcParmVO);
							
							if (retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
								log.error("\n\n[DMT02036][Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
								throw new EventException(retChgCalcCntrVO.getMsgDesc());
							}
						} 
						else {
							//RETURN = generalChargeCalculation
							retChgCalcCntrVO = dmtGeneralChargeCalcUtil.generalChargeCalculation(chgCalcParmVO);
							
							if (retChgCalcCntrVO.getMsgCd().equals("-1") || retChgCalcCntrVO.getMsgCd().equals("88")) {
								log.error("\n\n[DMT02036][Code]: " + retChgCalcCntrVO.getMsgCd() + "\n[Message]: " + retChgCalcCntrVO.getMsgDesc() + "\n");
								throw new EventException(retChgCalcCntrVO.getMsgDesc());
							}
					    }
					}
					
					//Exception of failure Process
					if (!"0".equals(retChgCalcCntrVO.getMsgCd())) {
						retChgCalcCntrVO.setDmdtChgStsCd("E");
						chgCalcContainerVO.setCorrRmk(retChgCalcCntrVO.getMsgDesc());
					}
					// ------------------------------------------------------------------------------------------------------------------
					
					//3. DMT_BKG_CNTR TABLE UPDATE --------------------------------------------------------------------------------------
					// ------------ DmtChgBkgCntrVO create object-----------------
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
	
					// ************* DmtChgCalcVO create object *****************
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
					
					//Change STATUS to "I" case in "I"(ISSUED) After Calculate=====================
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
					
					//OFC_CD, OFC_RHQ_CD, DMDT_INV_NO are setting to Origin values ========
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
						
						// Change value of fields  ORG_CHG_AMT, SC_RFA_EXPT_AMT of Dual Exception Charge
						chgCalcDBDAO.modifyOrgChgAmt(chargeArgumentVO);
					}					
					// ------------------------------------------------------------------------------------------------------------------
					
					// Stop Porcess after DMT_CHG_CALC TABLE UPDATE Case in return error in porcess 2 .
					if ("E".equals(retChgCalcCntrVO.getDmdtChgStsCd())) {
						continue;
					}
					
					//7. save CLOCK STOP HISTORY ----------------------------------------------------------------------------------
					//   addClockStopHistory case in Clock Stop is over ond day Clock Stop (cStopNoList.size() > 0) 
					List<String> cStopNoList = retChgCalcCntrVO.getCStopNoList();
					if(cStopNoList != null && cStopNoList.size() > 0) {
						DmtChgTmCskStopVO dmtChgTmCskStopVO = new DmtChgTmCskStopVO();
						dmtChgTmCskStopVO.setSvrId(				chgCalcContainerVO.getSvrId()			);
						dmtChgTmCskStopVO.setCntrNo(			chgCalcContainerVO.getCntrNo()			);
						dmtChgTmCskStopVO.setCntrCycNo(			chgCalcContainerVO.getCntrCycNo()		);
						dmtChgTmCskStopVO.setDmdtTrfCd(			chgCalcContainerVO.getDmdtTrfCd()		);
						dmtChgTmCskStopVO.setDmdtChgLocDivCd(	chgCalcContainerVO.getDmdtChgLocDivCd()	);
						dmtChgTmCskStopVO.setChgSeq(			chgCalcContainerVO.getChgSeq()			);
	
						// delete Clock Stop History.
						chgCalcDBDAO.deleteClockStopHistory(dmtChgTmCskStopVO);
						
						// Insert for loop until Clock Stop count
						for (int j = 0 ; j < cStopNoList.size() ; j++) {
							String clkStopNo = cStopNoList.get(j);
							dmtChgTmCskStopVO.setClkStopNo(clkStopNo);
							
							chgCalcDBDAO.addClockStopHistory(dmtChgTmCskStopVO);
						}						
					}
					// ------------------------------------------------------------------------------------------------------------------
					
					//8. UPDATE DMT_INV_MN TABLE---------------------------------------------------------------------------------
					invIssueCollectMgtDBDAO.modifyInvoiceAdjustAmount(darNo);
					// ------------------------------------------------------------------------------------------------------------------
					
				
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
