/*=========================================================
 *Copyright(c) 2014 CyberLogitec
 *@FileName : AccountPayablePaymentBackEndJob.java
 *@FileTitle : 
 *Open Issues :
 *Change history :
 *@LastModifyDate : 2014.05.20
 *@LastModifier : KIM OK RYE
 *@LastVersion : 0.1
 * 2014.05.20
 * 1.0 Creation
=========================================================*/
package com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.basic;

//import java.math.BigDecimal;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.core.layer.integration.DAOException;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.basic.AccountPayableCommonBC;
import com.clt.apps.opus.stm.sap.accountpayablecommon.accountpayablecommon.basic.AccountPayableCommonBCImpl;
import com.clt.apps.opus.stm.sap.accountpayablepayment.accountpayablepayment.integration.AccountPayablePaymentDBDAO;

/**
 * It's AccountPayablePaymentBackEndJob.java
 * @author ORKIM
 * @see BackEndCommandSupport
 * @since J2EE 1.6
 */
public class AccountPayablePaymentBackEndJob extends BackEndCommandSupport  {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Backend job을 위한 DAO
	 */
	private AccountPayablePaymentDBDAO dbDao;
	private	AccountPayableCommonBC	   comCommand;
	private	AccountPayablePaymentBC	   payCommand;
	private String capturePeriod;
	private String usrId;
	private String accounting_request_id; 
	private String functional_currency_code;
	

	public AccountPayablePaymentBackEndJob() {		
		comCommand = new AccountPayableCommonBCImpl();	
		payCommand = new AccountPayablePaymentBCImpl();
		dbDao = new AccountPayablePaymentDBDAO();
	}
	
    /**
	 * doStart
	 * 
	 * @return String[]
	 * @see com.clt.framework.support.layer.backend.BackEndCommandSupport#doStart()
	 * @exception Exception
    */	
	public String[] doStart() throws Exception {

			dbDao = new AccountPayablePaymentDBDAO();
			
			String resultMsg = "";			
		
			String[] arrChkAcctExist = new String[3];
			String[] arrAcctParams = new String[5];
			
			try {
				
				
				functional_currency_code = comCommand.searchFunctionalCurrencyCode().get(0).getValue0();
				//SEARCH SAP_ACCTG_REQ_SEQ.NEXTVAL 
				accounting_request_id = dbDao.searchAccountingRequestIdInfo();
			
				
				arrAcctParams[0] = capturePeriod;
				arrAcctParams[1] = "";	//csrNo
				arrAcctParams[2] = functional_currency_code;
				arrAcctParams[3] = accounting_request_id;
				arrAcctParams[4] = usrId;
				
				//SETUP 정보(AP ACCOUNT SETUP) 체크
				String[] ccidChk = payCommand.checkAPAccountSetup("INIT", null, arrAcctParams);
				if( !"OK".equals(ccidChk[0])) {
					resultMsg =new ErrorHandler("SAP00048",new String[]{ccidChk[0]}).getUserMessage();
					throw new EventException(resultMsg);
				}
				
				//해당 조건일자까지의 자료중 지불 Batch 작업중인 자료에 대해서 점검한 후 대상이 존재하는 경우에는 에러 처리 
				arrChkAcctExist = dbDao.searchAccountingExistsCheck(capturePeriod);
				
				if(arrChkAcctExist != null && !arrChkAcctExist[0].equals("")){
					resultMsg =new ErrorHandler("SAP00028",new String[]{arrChkAcctExist[1], arrChkAcctExist[0], arrChkAcctExist[2]}).getUserMessage();
					throw new EventException(resultMsg);
				}
				
				payCommand.processInvoice(arrAcctParams);
				payCommand.processInvoiceCancellation(arrAcctParams);
				payCommand.processPayment(arrAcctParams);
				payCommand.processPaymentCancel(arrAcctParams);
				payCommand.processPrepaymentApply(arrAcctParams);
				payCommand.processPrepaymentUnapply(arrAcctParams);
				payCommand.processErrorCheck(arrAcctParams);
				
				
			} catch (DAOException ex) {
				log.error("[DAOException]"+ex.getMessage());
				throw new EventException(new ErrorHandler(ex).getMessage());
			} catch (EventException ex) {
				log.error("[EventException]"+ex.getMessage());
				throw ex;
			} catch (Exception ex) {
				log.error("[Exception]"+ex.getMessage());
				throw new EventException(ex.getMessage(),ex);
			}
			return arrChkAcctExist;
	}
	
	
	/**
	 * It's a getter of capturePeriod.
	 * @return String
	 */
	public String getCapturePeriod() {
		return capturePeriod;
	}
	
	/**
	 * It's a setter of capturePeriod.
	 * @param String capturePeriod
	 */
	public void setCapturePeriod(String capturePeriod) {
		this.capturePeriod = capturePeriod;
	}
	
	/**
	 * It's a getter of usrId.
	 * @return String
	 */
	public String getUsrId() {
		return usrId;
	}
	
	/**
	 * It's a setter of usrId.
	 * @param String usrId
	 */
	public void setUsrId(String usrId) {
		this.usrId = usrId;
	}
	
/*	private String[] checkAPAccountSetup(String callFlag, String[] argParam) throws Exception {
		String strResult[] = new String[2];
		String[] coaArr;
		
		strResult[0]= "ERROR";
		
		//coaArr[0]  company
		//coaArr[1]  region 
		//coaArr[2]  center  
		//coaArr[3]  account
		//coaArr[4]  intercompany
		//coaArr[5]  vvd
		//coaArr[6]  cd_cmb_seq
		
		if ("INIT".equals(callFlag)) { 
		
			//LOSS ACCOUNT
			coaArr = dbDao.searchAccountingPaymentInvLossInfoCheck();
			
			if(JSPUtil.getNull(coaArr[6]).equals("")) {
				 LedgerCodeCombinationListVO ccidVO = new LedgerCodeCombinationListVO();
				 ccidVO.setSgmCtnt1( coaArr[0] );
				 ccidVO.setSgmCtnt2( coaArr[1] );
				 ccidVO.setSgmCtnt3( coaArr[2] );
				 ccidVO.setSgmCtnt4( coaArr[3] );
				 ccidVO.setSgmCtnt5( coaArr[4] );
				 ccidVO.setSgmCtnt6( coaArr[5] );
				 
				 String ccidChk[] = scoCommand.manageLedgerCodeCombinationBiz(ccidVO, usrId);
				 
				 if(!ccidChk[0].equals("OK")) {
					 strResult[0] = ccidChk[0];
					 return strResult;					 
				 } 			
			}
			
			//GAIN ACCOUNT
			coaArr = dbDao.searchAccountingPaymentInvGainInfoCheck();
			if(JSPUtil.getNull(coaArr[6]).equals("")) {
				 LedgerCodeCombinationListVO ccidVO = new LedgerCodeCombinationListVO();
				 ccidVO.setSgmCtnt1( coaArr[0] );
				 ccidVO.setSgmCtnt2( coaArr[1] );
				 ccidVO.setSgmCtnt3( coaArr[2] );
				 ccidVO.setSgmCtnt4( coaArr[3] );
				 ccidVO.setSgmCtnt5( coaArr[4] );
				 ccidVO.setSgmCtnt6( coaArr[5] );
				 
				 String ccidChk[] = scoCommand.manageLedgerCodeCombinationBiz(ccidVO, usrId);
				 
				 if(!ccidChk[0].equals("OK")) {
					 strResult[0] = ccidChk[0];
					 return strResult;					 
				 } 			
			}	
			
			//ROUNDING ACCOUNT
			coaArr = dbDao.searchAccountingPaymentInvRoundInfoCheck();
			if(JSPUtil.getNull(coaArr[6]).equals("")) {
				 LedgerCodeCombinationListVO ccidVO = new LedgerCodeCombinationListVO();
				 ccidVO.setSgmCtnt1( coaArr[0] );
				 ccidVO.setSgmCtnt2( coaArr[1] );
				 ccidVO.setSgmCtnt3( coaArr[2] );
				 ccidVO.setSgmCtnt4( coaArr[3] );
				 ccidVO.setSgmCtnt5( coaArr[4] );
				 ccidVO.setSgmCtnt6( coaArr[5] );
				 
				 String ccidChk[] = scoCommand.manageLedgerCodeCombinationBiz(ccidVO, usrId);
				 
				 if(!ccidChk[0].equals("OK")) {
					 strResult[0] = ccidChk[0];
					 return strResult;					 
				 } 			
			}
		} else {
			LedgerCodeCombinationListVO ccidVO = new LedgerCodeCombinationListVO();
			ccidVO.setSgmCtnt1( argParam[0] );
			ccidVO.setSgmCtnt2( argParam[1] );
			ccidVO.setSgmCtnt3( argParam[2] );
			ccidVO.setSgmCtnt4( argParam[3] );
			ccidVO.setSgmCtnt5( argParam[4] );
			ccidVO.setSgmCtnt6( argParam[5] );
			
			String ccidChk[] = scoCommand.manageLedgerCodeCombinationBiz(ccidVO, usrId);
			 
			if(!ccidChk[0].equals("OK")) {
				strResult[0] = ccidChk[0];
				return strResult;					 
			} else {
				strResult[0] = "OK";
				strResult[1] = ccidChk[1];
				return strResult;					 
			}
		}
		
		strResult[0] = "OK";
		return strResult;
	}
	
	private void processInvoice() throws Exception {
		try { 
			List<AccountingInvoiceCheckVO> accountingInvoiceCheckVOs = dbDao.searchAccountingInvoiceCheck(capturePeriod);
			
			if(accountingInvoiceCheckVOs != null && accountingInvoiceCheckVOs.size() > 0 ) {
				for(int i=0; i < accountingInvoiceCheckVOs.size(); i++ ) {
					accountingInvoiceCheckVOs.get(i).setUsrId(usrId);
					accountingInvoiceCheckVOs.get(i).setAccountingRequestId(accounting_request_id);
					accountingInvoiceCheckVOs.get(i).setAccountingHeaderId(dbDao.searchAccountingHeaderIdInfo());
					accountingInvoiceCheckVOs.get(i).setAccountingEventId(dbDao.searchAccountingEventIdInfo());
					accountingInvoiceCheckVOs.get(i).setFunctionalCurrency(functional_currency_code);
				}
			
				 dbDao.addAccountingEventInvInfo(accountingInvoiceCheckVOs);
				 dbDao.addAccountingHeaderInvInfo(accountingInvoiceCheckVOs);
				 dbDao.addAccountingDetailInvLineInfo(accountingInvoiceCheckVOs);
				 invCommand.modifyAccountingDetailInvLineFlag(accountingInvoiceCheckVOs);
				 dbDao.addAccountingDetailInvHeaderInfo(accountingInvoiceCheckVOs);
			}	
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}	
	}

	private void processInvoiceCancellation() throws Exception {
		try { 
			List<AccountingInvoiceCancelCheckVO> accountingInvoiceCancelCheckVOs = dbDao.searchAccountingInvoiceCancelCheck(capturePeriod);
			
			if(accountingInvoiceCancelCheckVOs != null && accountingInvoiceCancelCheckVOs.size() > 0 ) {
				for(int i=0; i < accountingInvoiceCancelCheckVOs.size(); i++ ) {
					accountingInvoiceCancelCheckVOs.get(i).setUsrId(usrId);
					accountingInvoiceCancelCheckVOs.get(i).setAccountingRequestId(accounting_request_id);
					accountingInvoiceCancelCheckVOs.get(i).setAccountingHeaderId(dbDao.searchAccountingHeaderIdInfo());
					accountingInvoiceCancelCheckVOs.get(i).setAccountingEventId(dbDao.searchAccountingEventIdInfo());
					accountingInvoiceCancelCheckVOs.get(i).setFunctionalCurrency(functional_currency_code);
				}
			
				 dbDao.addAccountingEventInvCancelInfo(accountingInvoiceCancelCheckVOs);
				 dbDao.addAccountingHeaderInvCancelInfo(accountingInvoiceCancelCheckVOs);
				 dbDao.addAccountingDetailInvLineCancelInfo(accountingInvoiceCancelCheckVOs);
				 invCommand.modifyAccountingDetailInvLineCancelFlag(accountingInvoiceCancelCheckVOs);
				 dbDao.addAccountingDetailInvHeaderCancelInfo(accountingInvoiceCancelCheckVOs);
				
			}	
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}	
	}

	private void processPayment() throws Exception {
		try { 
			List<AccountingPaymentCheckVO> accountingPaymentCheckVOs = dbDao.searchAccountingPaymentCheck(capturePeriod);
			
			if(accountingPaymentCheckVOs != null && accountingPaymentCheckVOs.size() > 0 ) {
				
				List<AccountingPaymentLineCheckVO> accountingPaymentLineCheckVOs  = null;
				List<AccountingPaymentLineCheckVO> accountingPaymentLineCheckFullVOs  = new ArrayList<AccountingPaymentLineCheckVO>();
				List<AccountingPaymentLineCheckVO> detailPaymentVOs = null;
				List<AccountingPaymentLineCheckVO> gainPaymentVOs = null;
				List<AccountingPaymentLineCheckVO> lossPaymentVOs = null;
				List<AccountingPaymentCheckVO> roundPaymentHVOs = new ArrayList<AccountingPaymentCheckVO>();
				List<AccountingPaymentCheckVO> roundPaymentDVOs = new ArrayList<AccountingPaymentCheckVO>();
				
				AccountingPaymentLineCheckVO gainLossPaymentVO;
				
				String gain_loss_type = "";
				String[] gainLossChkArr;
				String[] coaCtnt;
				String[] coaArr;
				String[] paramCoaArr;
				
				String inv_gl_yymm;
				String pay_gl_yymm;
				String inv_xch_rt;
				String pay_xch_rt;
				String pay_amt;
				
				String coa_seq;
				String gain_loss_amt;
				
				int accounting_line_no = 0;
				String accounting_header_id = ""; 
				String accounting_event_id = ""; 
				
				for(int i=0; i < accountingPaymentCheckVOs.size(); i++ ) {
					
					accounting_header_id = dbDao.searchAccountingHeaderIdInfo();
					accounting_event_id = dbDao.searchAccountingEventIdInfo();
					
					accountingPaymentCheckVOs.get(i).setUsrId(usrId);
					accountingPaymentCheckVOs.get(i).setAccountingRequestId(accounting_request_id);
					accountingPaymentCheckVOs.get(i).setAccountingHeaderId(accounting_header_id);
					accountingPaymentCheckVOs.get(i).setAccountingEventId(accounting_event_id);
				}
					
				dbDao.addAccountingEventPayInfo(accountingPaymentCheckVOs);
				dbDao.addAccountingHeaderPayInfo(accountingPaymentCheckVOs);
				
				for(int i=0; i < accountingPaymentCheckVOs.size(); i++ ) {	
					accountingPaymentLineCheckVOs = dbDao.searchAccountingPaymentLineCheck(accountingPaymentCheckVOs.get(i).getPaySeq());
					
					if(accountingPaymentLineCheckVOs != null && accountingPaymentLineCheckVOs.size() > 0 ) {
						accounting_line_no = 0;
						for(int j=0; j < accountingPaymentLineCheckVOs.size(); j++ ) {
							accounting_line_no += 1;
							accounting_header_id = accountingPaymentCheckVOs.get(i).getAccountingHeaderId();
							accounting_event_id  = accountingPaymentCheckVOs.get(i).getAccountingEventId();
							
							accountingPaymentLineCheckVOs.get(j).setUsrId(usrId);
							accountingPaymentLineCheckVOs.get(j).setAccountingRequestId(accounting_request_id);
							accountingPaymentLineCheckVOs.get(j).setAccountingHeaderId(accounting_header_id);
							accountingPaymentLineCheckVOs.get(j).setAccountingEventId(accounting_event_id);
							accountingPaymentLineCheckVOs.get(j).setAccountingLineNo(accounting_line_no+"");
							accountingPaymentLineCheckVOs.get(j).setFunctionalCurrency(functional_currency_code);
							
							
							accountingPaymentLineCheckFullVOs.add(accountingPaymentLineCheckVOs.get(j));
							
							detailPaymentVOs = new ArrayList<AccountingPaymentLineCheckVO>();
							detailPaymentVOs.add(accountingPaymentLineCheckVOs.get(j));
							dbDao.addAccountingDetailPayDetailInfo(detailPaymentVOs);
							accounting_line_no = Integer.parseInt(accountingPaymentLineCheckVOs.get(j).getAccountingLineNo());
							gainLossChkArr = dbDao.searchAccountingPaymentLineGainLossCheck(accountingPaymentLineCheckVOs.get(j));
							inv_gl_yymm = gainLossChkArr[0];
							pay_gl_yymm = gainLossChkArr[1];
							inv_xch_rt  = gainLossChkArr[2];
							pay_xch_rt  = gainLossChkArr[3];
							pay_amt     = gainLossChkArr[4];
							
							if(gainLossChkArr != null) {
								if (!(inv_gl_yymm.equals(pay_gl_yymm)) && !(inv_xch_rt.equals(pay_xch_rt))) {
									accounting_line_no += 1;
									
									coaCtnt = dbDao.searchAccountingPaymentInvLiabilityInfoCheck(accountingPaymentLineCheckVOs.get(j).getInvSeq());
									
									//if(Float.parseFloat(pay_xch_rt) > Float.parseFloat(inv_xch_rt)) {
									if(Float.valueOf(pay_xch_rt).compareTo(Float.valueOf(inv_xch_rt)) > 0 ) {
										if(Integer.parseInt(pay_amt) >= 0 ) {
											gain_loss_type = "LOSS";
										} else {
											gain_loss_type = "GAIN";
										}
									} else {
										if(Integer.parseInt(pay_amt) >= 0 ) {
											gain_loss_type = "GAIN";
										} else {
											gain_loss_type = "LOSS";
										}
									}
									
									if("LOSS".equals(gain_loss_type)) {
										coaArr = dbDao.searchAccountingPaymentInvLossInfoCheck();
										paramCoaArr = new String[6];
										paramCoaArr[0] = coaArr[0];  //company
										paramCoaArr[1] = coaCtnt[0];  //region **
										paramCoaArr[2] = coaCtnt[1];  //center ** 
										paramCoaArr[3] = coaArr[3];  //account
										paramCoaArr[4] = coaArr[4];  //intercompany
										paramCoaArr[5] = coaArr[5];  //vvd
										coa_seq = dbDao.searchAccountingPaymentInvLossCoaInfo(paramCoaArr);
										
										String[] ccidChk = new String[2];
										if("".equals(JSPUtil.getNull(coa_seq))) {
											ccidChk = checkAPAccountSetup("", paramCoaArr);
											if(!ccidChk[0].equals("OK")) {												
												String resultMsg =new ErrorHandler("COM12241",new String[]{"LOSS CCID"}).getUserMessage();
												throw new EventException(resultMsg);
											} else {
												coa_seq = ccidChk[1]; 
											}											
										}
										
										gain_loss_amt = dbDao.searchAccountingPaymentInvGainLossAmtInfo(accountingPaymentLineCheckVOs.get(j));
										
										gainLossPaymentVO = new AccountingPaymentLineCheckVO();
										
										ObjectCloner.build(accountingPaymentLineCheckVOs.get(j), gainLossPaymentVO);
										
										gainLossPaymentVO.setAccountingLineNo(accounting_line_no+"");
										gainLossPaymentVO.setCoaSeq(coa_seq);
										gainLossPaymentVO.setGainLossAmt(gain_loss_amt);
										
										lossPaymentVOs = new ArrayList<AccountingPaymentLineCheckVO>();
										lossPaymentVOs.add(gainLossPaymentVO);
										dbDao.addAccountingDetailInvLossInfo(lossPaymentVOs);
										
									} else if("GAIN".equals(gain_loss_type)) {
										coaArr = dbDao.searchAccountingPaymentInvGainInfoCheck();
										paramCoaArr = new String[6];
										paramCoaArr[0] = coaArr[0];  //company
										paramCoaArr[1] = coaCtnt[0];  //region **
										paramCoaArr[2] = coaCtnt[1];  //center ** 
										paramCoaArr[3] = coaArr[3];  //account
										paramCoaArr[4] = coaArr[4];  //intercompany
										paramCoaArr[5] = coaArr[5];  //vvd
										coa_seq = dbDao.searchAccountingPaymentInvGainCoaInfo(paramCoaArr);
										
										String[] ccidChk = new String[2];
										if("".equals(JSPUtil.getNull(coa_seq))) {
											ccidChk = checkAPAccountSetup("", paramCoaArr);
											if(!ccidChk[0].equals("OK")) {												
												String resultMsg =new ErrorHandler("COM12241",new String[]{"GAIN CCID"}).getUserMessage();
												throw new EventException(resultMsg);
											} else {
												coa_seq = ccidChk[1]; 
											}											
										}
										
										gain_loss_amt = dbDao.searchAccountingPaymentInvGainLossAmtInfo(accountingPaymentLineCheckVOs.get(j));
										
										gainLossPaymentVO = new AccountingPaymentLineCheckVO();
										
										ObjectCloner.build(accountingPaymentLineCheckVOs.get(j), gainLossPaymentVO);
										
										gainLossPaymentVO.setAccountingLineNo(accounting_line_no+"");
										gainLossPaymentVO.setCoaSeq(coa_seq);
										gainLossPaymentVO.setGainLossAmt(gain_loss_amt);
										
										gainPaymentVOs = new ArrayList<AccountingPaymentLineCheckVO>();
										gainPaymentVOs.add(gainLossPaymentVO);
										dbDao.addAccountingDetailInvGainInfo(gainPaymentVOs);
									
									}
								}
							}
						}
					}
				}
				
				for(int i=0; i < accountingPaymentCheckVOs.size(); i++ ) {	
					String pay_accounted_cr = dbDao.searchAccountingDetailPayFunctionalAmtInfo(accountingPaymentCheckVOs.get(i).getPaySeq());
					String[] drCrSumArr = dbDao.searchAccountingDetailPayAccountedSumInfo(accounting_header_id);
					String accounted_dr_sum = drCrSumArr[0];
					String accounted_cr_sum = drCrSumArr[1];
					String accounted_round_dr = "";
					String accounted_round_cr = "";
					
					if (Float.valueOf(accounted_dr_sum).compareTo(( Float.valueOf(Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr))) ) > 0 ) {
						accounted_round_dr = ( Float.parseFloat(accounted_dr_sum) - (Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr)) ) + ""; 
					} else if (Float.valueOf(accounted_dr_sum).compareTo(Float.valueOf ( Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr) )) < 0 ) {
						accounted_round_cr = (Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr) - Float.parseFloat(accounted_dr_sum) ) + "";
					} else {
						accounted_round_dr = "0";
						accounted_round_cr = "0";
					}
					
					
					if (accounted_round_dr.equals("0") || accounted_round_cr.equals("0")) {
						accounting_line_no += 1;
						
						String[] paramCoaArr2 = dbDao.searchAccountingPaymentInvRoundInfoCheck();
						coa_seq = paramCoaArr2[6];
						
						String[] ccidChk = new String[2];
						if("".equals(JSPUtil.getNull(coa_seq))) {
							ccidChk = checkAPAccountSetup("", paramCoaArr2);
							if(!ccidChk[0].equals("OK")) {												
								String resultMsg =new ErrorHandler("COM12241",new String[]{"ROUNDING CCID"}).getUserMessage();
								throw new EventException(resultMsg);
							} else {
								coa_seq = ccidChk[1]; 
							}											
						}
						
						AccountingPaymentCheckVO tempCheckVO = new AccountingPaymentCheckVO();
						ObjectCloner.build(accountingPaymentCheckVOs.get(i), tempCheckVO);
						tempCheckVO.setAccountingLineNo(accounting_line_no + "");
						tempCheckVO.setCoaSeq(coa_seq);
						roundPaymentHVOs.add(tempCheckVO);
					}
					accounting_line_no += 1;
					AccountingPaymentCheckVO tempCheckVO = new AccountingPaymentCheckVO();
					ObjectCloner.build(accountingPaymentCheckVOs.get(i), tempCheckVO);
					tempCheckVO.setAccountingLineNo(accounting_line_no + "");						
					roundPaymentDVOs.add(tempCheckVO);
					
					
				} // end of accountingPaymentCheckVOs loop
				 
				dbDao.modifyAccountingDetailPayLineFlag(accountingPaymentLineCheckFullVOs);
				 
				//round
				if (roundPaymentHVOs.size() > 0) {
					dbDao.addAccountingDetailInvRoundInfo(roundPaymentHVOs);
				}
				if (roundPaymentDVOs.size() > 0) {
					dbDao.addAccountingDetailPayHeaderInfo(roundPaymentDVOs);
				}
				
			} // end of accountingPaymentCheckVOs if 
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}	
	}	
	

	private void processPaymentCancel() throws Exception {
		try { 
			List<AccountingPaymentCheckVO> accountingPaymentCancelCheckVO = dbDao.searchAccountingPaymentCancelCheck(capturePeriod);
			
			if(accountingPaymentCancelCheckVO != null && accountingPaymentCancelCheckVO.size() > 0 ) {
				
				List<AccountingPaymentLineCheckVO> accountingPaymentCancelLineCheckVOs = null;
				List<AccountingPaymentLineCheckVO> accountingPaymentCancelLineCheckFullVOs  = new ArrayList<AccountingPaymentLineCheckVO>();
				List<AccountingPaymentLineCheckVO> detailPaymentVOs = null;
				List<AccountingPaymentLineCheckVO> gainPaymentVOs = null;
				List<AccountingPaymentLineCheckVO> lossPaymentVOs = null;
				List<AccountingPaymentCheckVO> roundPaymentHVOs = new ArrayList<AccountingPaymentCheckVO>();
				List<AccountingPaymentCheckVO> roundPaymentDVOs = new ArrayList<AccountingPaymentCheckVO>();
				
				AccountingPaymentLineCheckVO gainLossPaymentVO;
				
				String gain_loss_type = "";
				String[] gainLossChkArr;

				String[] coaCtnt;
				String[] coaArr;
				String[] paramCoaArr;
				
				String inv_gl_yymm;
				String pay_gl_yymm;
				String inv_xch_rt;
				String pay_xch_rt;
				String pay_amt;
				
				String coa_seq;
				String gain_loss_amt;
				
				int accounting_line_no = 0;
				String accounting_header_id = ""; 
				String accounting_event_id = ""; 
				
				for(int i=0; i < accountingPaymentCancelCheckVO.size(); i++ ) {
					
					accounting_header_id = dbDao.searchAccountingHeaderIdInfo();
					accounting_event_id = dbDao.searchAccountingEventIdInfo();
					
					accountingPaymentCancelCheckVO.get(i).setUsrId(usrId);
					accountingPaymentCancelCheckVO.get(i).setAccountingRequestId(accounting_request_id);
					accountingPaymentCancelCheckVO.get(i).setAccountingHeaderId(accounting_header_id);
					accountingPaymentCancelCheckVO.get(i).setAccountingEventId(accounting_event_id);
				}
				
				dbDao.addAccountingEventPayCancelInfo(accountingPaymentCancelCheckVO);
				dbDao.addAccountingHeaderPayCancelInfo(accountingPaymentCancelCheckVO);
				
				
				for(int i=0; i < accountingPaymentCancelCheckVO.size(); i++ ) {	                                            
					accountingPaymentCancelLineCheckVOs = dbDao.searchAccountingPaymentCancelLineCheck(accountingPaymentCancelCheckVO.get(i).getPaySeq());
					
					if(accountingPaymentCancelLineCheckVOs != null && accountingPaymentCancelLineCheckVOs.size() > 0 ) {
						for(int j=0; j < accountingPaymentCancelLineCheckVOs.size(); j++ ) {
							accounting_line_no += 1;
							accounting_header_id = accountingPaymentCancelCheckVO.get(i).getAccountingHeaderId();
							accounting_event_id  = accountingPaymentCancelCheckVO.get(i).getAccountingEventId();
							
							accountingPaymentCancelLineCheckVOs.get(j).setUsrId(usrId);
							accountingPaymentCancelLineCheckVOs.get(j).setAccountingRequestId(accounting_request_id);
							accountingPaymentCancelLineCheckVOs.get(j).setAccountingHeaderId(accounting_header_id);
							accountingPaymentCancelLineCheckVOs.get(j).setAccountingEventId(accounting_event_id);
							accountingPaymentCancelLineCheckVOs.get(j).setAccountingLineNo(accounting_line_no+"");
							accountingPaymentCancelLineCheckVOs.get(j).setFunctionalCurrency(functional_currency_code);
							
							accountingPaymentCancelLineCheckFullVOs.add(accountingPaymentCancelLineCheckVOs.get(j));
							
							detailPaymentVOs = new ArrayList<AccountingPaymentLineCheckVO>();
							detailPaymentVOs.add(accountingPaymentCancelLineCheckVOs.get(j));
							dbDao.addAccountingDetailPayCancelDetailInfo(detailPaymentVOs);
							
							
							gainLossChkArr = dbDao.searchAccountingPaymentCancelLineGainLossCheck(accountingPaymentCancelLineCheckVOs.get(j));
							inv_gl_yymm = gainLossChkArr[0];
							pay_gl_yymm = gainLossChkArr[1];
							inv_xch_rt  = gainLossChkArr[2];
							pay_xch_rt  = gainLossChkArr[3];
							pay_amt     = gainLossChkArr[4];
							
							if(gainLossChkArr != null) {
								if (!(inv_gl_yymm.equals(pay_gl_yymm)) && !(inv_xch_rt.equals(pay_xch_rt))) {
									accounting_line_no += 1;
									
									coaCtnt = dbDao.searchAccountingPaymentInvLiabilityInfoCheck(accountingPaymentCancelLineCheckVOs.get(j).getInvSeq());
									if(Float.valueOf(pay_xch_rt).compareTo(Float.valueOf(inv_xch_rt)) > 0 ) {
										if(Integer.parseInt(pay_amt) >= 0 ) {
											gain_loss_type = "LOSS";
										} else {
											gain_loss_type = "GAIN";
										}
									} else {
										if(Integer.parseInt(pay_amt) >= 0 ) {
											gain_loss_type = "GAIN";
										} else {
											gain_loss_type = "LOSS";
										}
									}
									
									if("LOSS".equals(gain_loss_type)) {
										coaArr = dbDao.searchAccountingPaymentInvLossInfoCheck();
										paramCoaArr = new String[6];
										paramCoaArr[0] = coaArr[0];  //company
										paramCoaArr[1] = coaCtnt[0];  //region **
										paramCoaArr[2] = coaCtnt[1];  //center ** 
										paramCoaArr[3] = coaArr[3];  //account
										paramCoaArr[4] = coaArr[4];  //intercompany
										paramCoaArr[5] = coaArr[5];  //vvd
										coa_seq = dbDao.searchAccountingPaymentInvLossCoaInfo(paramCoaArr);
										
										String[] ccidChk = new String[2];
										if("".equals(JSPUtil.getNull(coa_seq))) {
											ccidChk = checkAPAccountSetup("", paramCoaArr);
											if(!ccidChk[0].equals("OK")) {												
												String resultMsg =new ErrorHandler("COM12241",new String[]{"LOSS CCID"}).getUserMessage();
												throw new EventException(resultMsg);
											} else {
												coa_seq = ccidChk[1]; 
											}											
										}
										gain_loss_amt = dbDao.searchAccountingPaymentInvGainLossAmtInfo(accountingPaymentCancelLineCheckVOs.get(j));
										
										gainLossPaymentVO = new AccountingPaymentLineCheckVO();
										
										ObjectCloner.build(accountingPaymentCancelLineCheckVOs.get(j), gainLossPaymentVO);
										
										gainLossPaymentVO.setAccountingLineNo(accounting_line_no+"");
										gainLossPaymentVO.setCoaSeq(coa_seq);
										gainLossPaymentVO.setGainLossAmt(gain_loss_amt);
										lossPaymentVOs = new ArrayList<AccountingPaymentLineCheckVO>();
										lossPaymentVOs.add(gainLossPaymentVO);
										dbDao.addAccountingDetailPayCancelLossInfo(lossPaymentVOs);
										
									} else if("GAIN".equals(gain_loss_type)) {
										coaArr = dbDao.searchAccountingPaymentInvGainInfoCheck();
										paramCoaArr = new String[6];
										paramCoaArr[0] = coaArr[0];  //company
										paramCoaArr[1] = coaCtnt[0];  //region **
										paramCoaArr[2] = coaCtnt[1];  //center ** 
										paramCoaArr[3] = coaArr[3];  //account
										paramCoaArr[4] = coaArr[4];  //intercompany
										paramCoaArr[5] = coaArr[5];  //vvd
										coa_seq = dbDao.searchAccountingPaymentInvGainCoaInfo(paramCoaArr);
										
										String[] ccidChk = new String[2];
										if("".equals(JSPUtil.getNull(coa_seq))) {
											ccidChk = checkAPAccountSetup("", paramCoaArr);
											if(!ccidChk[0].equals("OK")) {												
												String resultMsg =new ErrorHandler("COM12241",new String[]{"GAIN CCID"}).getUserMessage();
												throw new EventException(resultMsg);
											} else {
												coa_seq = ccidChk[1]; 
											}											
										}
										
										gain_loss_amt = dbDao.searchAccountingPaymentInvGainLossAmtInfo(accountingPaymentCancelLineCheckVOs.get(j));
										
										gainLossPaymentVO = new AccountingPaymentLineCheckVO();
										
										ObjectCloner.build(accountingPaymentCancelLineCheckVOs.get(j), gainLossPaymentVO);
										
										gainLossPaymentVO.setAccountingLineNo(accounting_line_no+"");
										gainLossPaymentVO.setCoaSeq(coa_seq);
										gainLossPaymentVO.setGainLossAmt(gain_loss_amt);
										gainPaymentVOs = new ArrayList<AccountingPaymentLineCheckVO>();
										gainPaymentVOs.add(gainLossPaymentVO);
										dbDao.addAccountingDetailPayCancelGainInfo(gainPaymentVOs);
									
										
									}
								}
							}
						}
						
					}
				}
				
				for(int i=0; i < accountingPaymentCancelCheckVO.size(); i++ ) {	
					String pay_accounted_cr = dbDao.searchAccountingDetailPayFunctionalAmtInfo(accountingPaymentCancelCheckVO.get(i).getPaySeq());
					String[] drCrSumArr = dbDao.searchAccountingDetailPayAccountedSumInfo(accounting_header_id);
					String accounted_dr_sum = drCrSumArr[0];
					String accounted_cr_sum = drCrSumArr[1];
					String accounted_round_dr = "";
					String accounted_round_cr = "";
					
					if (Float.valueOf(accounted_dr_sum).compareTo(( Float.valueOf(Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr))) ) > 0 ) {
						accounted_round_dr = ( Float.parseFloat(accounted_dr_sum) - (Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr)) ) + ""; 
					} else if (Float.valueOf(accounted_dr_sum).compareTo(Float.valueOf ( Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr) )) < 0 ) {
						accounted_round_cr = (Float.parseFloat(accounted_cr_sum) + Float.parseFloat(pay_accounted_cr) - Float.parseFloat(accounted_dr_sum) ) + "";
					} else {
						accounted_round_dr = "0";
						accounted_round_cr = "0";
					}
					
					if (accounted_round_dr.equals("0") || accounted_round_cr.equals("0")) {
						accounting_line_no += 1;
						String[] paramCoaArr2 = dbDao.searchAccountingPaymentInvRoundInfoCheck();
						coa_seq = paramCoaArr2[6];
						
						String[] ccidChk = new String[2];
						if("".equals(JSPUtil.getNull(coa_seq))) {
							ccidChk = checkAPAccountSetup("", paramCoaArr2);
							if(!ccidChk[0].equals("OK")) {												
								String resultMsg =new ErrorHandler("COM12241",new String[]{"ROUNDING CCID"}).getUserMessage();
								throw new EventException(resultMsg);
							} else {
								coa_seq = ccidChk[1]; 
							}											
						}
						AccountingPaymentCheckVO tempCheckVO = new AccountingPaymentCheckVO();
						ObjectCloner.build(accountingPaymentCancelCheckVO.get(i), tempCheckVO);
						tempCheckVO.setAccountingLineNo(accounting_line_no + "");
						tempCheckVO.setCoaSeq(coa_seq);
						roundPaymentHVOs.add(tempCheckVO);
					}
					accounting_line_no += 1;
					AccountingPaymentCheckVO tempCheckVO = new AccountingPaymentCheckVO();
					ObjectCloner.build(accountingPaymentCancelCheckVO.get(i), tempCheckVO);
					tempCheckVO.setAccountingLineNo(accounting_line_no + "");						
					roundPaymentDVOs.add(tempCheckVO);	
				}

				dbDao.modifyAccountingDetailPayLineFlag(accountingPaymentCancelLineCheckFullVOs);
				 
				//round
				if (roundPaymentHVOs.size() > 0) {
					dbDao.addAccountingDetailPayCancelRoundInfo(roundPaymentHVOs);
				}
				if (roundPaymentDVOs.size() > 0) {
					dbDao.addAccountingDetailPayHeaderCancelInfo(roundPaymentDVOs);
				}
				
			} // end of accountingPaymentCancelCheckVO if 					
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}	
	}	
	
	private void processPrepaymentApply() throws Exception {
		try { 
			List<AccountingPaymentCheckVO> accountingPrepayApplyCheckVOs = dbDao.searchAccountingPrepayApplyCheck(capturePeriod);
			
			if(accountingPrepayApplyCheckVOs != null && accountingPrepayApplyCheckVOs.size() > 0 ) {
				
				List<AccountingPaymentCheckVO> gainPaymentVOs = new ArrayList<AccountingPaymentCheckVO>();
				List<AccountingPaymentCheckVO> lossPaymentVOs = new ArrayList<AccountingPaymentCheckVO>();
				
				AccountingPaymentCheckVO gainLossPaymentVO;
				
				String gain_loss_type = "";
				String[] gainLossChkArr;
				String[] coaCtnt;
				String[] coaArr;
				String[] paramCoaArr;
				
				String inv_gl_yymm;
				String pay_gl_yymm;
				String inv_xch_rt;
				String pay_xch_rt;
				String pay_amt;
				
				String coa_seq;
				String gain_loss_amt;
				
				int accounting_line_no = 0;
				String accounting_header_id = ""; 
				String accounting_event_id = ""; 
				
				for(int i=0; i < accountingPrepayApplyCheckVOs.size(); i++ ) {
					
					accounting_header_id = dbDao.searchAccountingHeaderIdInfo();
					accounting_event_id = dbDao.searchAccountingEventIdInfo();
					
					accountingPrepayApplyCheckVOs.get(i).setUsrId(usrId);
					accountingPrepayApplyCheckVOs.get(i).setAccountingRequestId(accounting_request_id);
					accountingPrepayApplyCheckVOs.get(i).setAccountingHeaderId(accounting_header_id);
					accountingPrepayApplyCheckVOs.get(i).setAccountingEventId(accounting_event_id);
					accountingPrepayApplyCheckVOs.get(i).setFunctionalCurrency(functional_currency_code);
				}
				
				dbDao.addAccountingEventPrepayApplyInfo(accountingPrepayApplyCheckVOs);
				dbDao.addAccountingHeaderPrepayApplyInfo(accountingPrepayApplyCheckVOs);
				dbDao.addAccountingDetailPrepayApplyLineInfo(accountingPrepayApplyCheckVOs);
				dbDao.addAccountingDetailPrepayApplyLiabilityInfo(accountingPrepayApplyCheckVOs);
				
				for(int i=0; i < accountingPrepayApplyCheckVOs.size(); i++ ) {	
							
					gainLossChkArr = dbDao.searchAccountingPrepayApplyGainLossCheck(accountingPrepayApplyCheckVOs.get(i).getInvDtrbSeq());
					inv_gl_yymm = gainLossChkArr[0];
					pay_gl_yymm = gainLossChkArr[1];
					inv_xch_rt  = gainLossChkArr[2];
					pay_xch_rt  = gainLossChkArr[3];
					pay_amt     = gainLossChkArr[4];
					
					if(gainLossChkArr != null) {
						if (!(inv_xch_rt.equals(pay_xch_rt))) {
							accounting_line_no += 1;
							
							coaCtnt = dbDao.searchAccountingPrepayApplyLiabilityInfoCheck(accountingPrepayApplyCheckVOs.get(i).getInvDtrbSeq());
							if(Float.valueOf(pay_xch_rt).compareTo(Float.valueOf(inv_xch_rt)) > 0 ) {
								if(Integer.parseInt(pay_amt) < 0 ) {
									gain_loss_type = "LOSS";
								} else {
									gain_loss_type = "GAIN";
								}
							} else {
								if(Integer.parseInt(pay_amt) < 0 ) {
									gain_loss_type = "GAIN";
								} else {
									gain_loss_type = "LOSS";
								}
							}
							
							if("LOSS".equals(gain_loss_type)) {
								coaArr = dbDao.searchAccountingPaymentInvLossInfoCheck();
								paramCoaArr = new String[6];
								paramCoaArr[0] = coaArr[0];  //company
								paramCoaArr[1] = coaCtnt[0];  //region **
								paramCoaArr[2] = coaCtnt[1];  //center ** 
								paramCoaArr[3] = coaArr[3];  //account
								paramCoaArr[4] = coaArr[4];  //intercompany
								paramCoaArr[5] = coaArr[5];  //vvd
								coa_seq = dbDao.searchAccountingPaymentInvLossCoaInfo(paramCoaArr);
								
								String[] ccidChk = new String[2];
								if("".equals(JSPUtil.getNull(coa_seq))) {
									ccidChk = checkAPAccountSetup("", paramCoaArr);
									if(!ccidChk[0].equals("OK")) {												
										String resultMsg =new ErrorHandler("COM12241",new String[]{"LOSS CCID"}).getUserMessage();
										throw new EventException(resultMsg);
									} else {
										coa_seq = ccidChk[1]; 
									}											
								}
								
								gain_loss_amt = dbDao.searchAccountingPrepayApplyGainLossAmtInfo(accountingPrepayApplyCheckVOs.get(i).getInvDtrbSeq(), accountingPrepayApplyCheckVOs.get(i).getFunctionalCurrency());
								
								gainLossPaymentVO = new AccountingPaymentCheckVO();
								
								ObjectCloner.build(accountingPrepayApplyCheckVOs.get(i), gainLossPaymentVO);
								
								gainLossPaymentVO.setAccountingLineNo(accounting_line_no+"");
								gainLossPaymentVO.setCoaSeq(coa_seq);
								gainLossPaymentVO.setGainLossAmt(gain_loss_amt);
								
								lossPaymentVOs.add(gainLossPaymentVO);
								
							} else if("GAIN".equals(gain_loss_type)) {
								coaArr = dbDao.searchAccountingPaymentInvGainInfoCheck();
								paramCoaArr = new String[6];
								paramCoaArr[0] = coaArr[0];  //company
								paramCoaArr[1] = coaCtnt[0];  //region **
								paramCoaArr[2] = coaCtnt[1];  //center ** 
								paramCoaArr[3] = coaArr[3];  //account
								paramCoaArr[4] = coaArr[4];  //intercompany
								paramCoaArr[5] = coaArr[5];  //vvd
								coa_seq = dbDao.searchAccountingPaymentInvGainCoaInfo(paramCoaArr);
								
								String[] ccidChk = new String[2];
								if("".equals(JSPUtil.getNull(coa_seq))) {
									ccidChk = checkAPAccountSetup("", paramCoaArr);
									if(!ccidChk[0].equals("OK")) {												
										String resultMsg =new ErrorHandler("COM12241",new String[]{"GAIN CCID"}).getUserMessage();
										throw new EventException(resultMsg);
									} else {
										coa_seq = ccidChk[1]; 
									}											
								}
								
								gain_loss_amt = dbDao.searchAccountingPrepayApplyGainLossAmtInfo(accountingPrepayApplyCheckVOs.get(i).getInvDtrbSeq(), accountingPrepayApplyCheckVOs.get(i).getFunctionalCurrency());
								
								gainLossPaymentVO = new AccountingPaymentCheckVO();
								
								ObjectCloner.build(accountingPrepayApplyCheckVOs.get(i), gainLossPaymentVO);
								
								gainLossPaymentVO.setAccountingLineNo(accounting_line_no+"");
								gainLossPaymentVO.setCoaSeq(coa_seq);
								gainLossPaymentVO.setGainLossAmt(gain_loss_amt);
								
								gainPaymentVOs.add(gainLossPaymentVO);
							
							}
						}
					}
					
				} // end of accountingPrepayApplyCheckVOs loop
				 
				// loss & gain 
				if (lossPaymentVOs.size() > 0) {
					dbDao.addAccountingDetailPrepayApplyLossInfo(lossPaymentVOs);
				}
				if (gainPaymentVOs.size() > 0) {
					dbDao.addAccountingDetailPrepayApplyGainInfo(gainPaymentVOs);
				}
				invCommand.modifyAccountingDetailPrepayApplyLineFlag(accountingPrepayApplyCheckVOs);
				
			} // end of accountingPrepayApplyCheckVOs if 	
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}	
	}	
	
	private void processPrepaymentUnapply() throws Exception {
		try { 
			List<AccountingPaymentCheckVO> accountingPrepayUnapplyCheckVOs = dbDao.searchAccountingPrepayUnApplyCheck(capturePeriod);
			
			if(accountingPrepayUnapplyCheckVOs != null && accountingPrepayUnapplyCheckVOs.size() > 0 ) {
				
				List<AccountingPaymentCheckVO> gainPaymentVOs = new ArrayList<AccountingPaymentCheckVO>();
				List<AccountingPaymentCheckVO> lossPaymentVOs = new ArrayList<AccountingPaymentCheckVO>();
				
				AccountingPaymentCheckVO gainLossPaymentVO;
				
				String gain_loss_type = "";
				String[] gainLossChkArr;
				String[] coaCtnt;
				String[] coaArr;
				String[] paramCoaArr;
				
				String inv_gl_yymm;
				String pay_gl_yymm;
				String inv_xch_rt;
				String pay_xch_rt;
				String pay_amt;
				
				String coa_seq;
				String gain_loss_amt;
				
				int accounting_line_no = 0;
				String accounting_header_id = ""; 
				String accounting_event_id = ""; 
				
				for(int i=0; i < accountingPrepayUnapplyCheckVOs.size(); i++ ) {
					
					accounting_header_id = dbDao.searchAccountingHeaderIdInfo();
					accounting_event_id = dbDao.searchAccountingEventIdInfo();
					
					accountingPrepayUnapplyCheckVOs.get(i).setUsrId(usrId);
					accountingPrepayUnapplyCheckVOs.get(i).setAccountingRequestId(accounting_request_id);
					accountingPrepayUnapplyCheckVOs.get(i).setAccountingHeaderId(accounting_header_id);
					accountingPrepayUnapplyCheckVOs.get(i).setAccountingEventId(accounting_event_id);
					accountingPrepayUnapplyCheckVOs.get(i).setFunctionalCurrency(functional_currency_code);
				}
				
				dbDao.addAccountingEventPrepayUnApplyInfo(accountingPrepayUnapplyCheckVOs);
				dbDao.addAccountingHeaderPrepayUnApplyInfo(accountingPrepayUnapplyCheckVOs);
				dbDao.addAccountingDetailPrepayUnApplyLineInfo(accountingPrepayUnapplyCheckVOs);
				dbDao.addAccountingDetailPrepayUnApplyLiabilityInfo(accountingPrepayUnapplyCheckVOs);
				
				for(int i=0; i < accountingPrepayUnapplyCheckVOs.size(); i++ ) {	
							
					gainLossChkArr = dbDao.searchAccountingPrepayApplyGainLossCheck(accountingPrepayUnapplyCheckVOs.get(i).getInvDtrbSeq());
					inv_gl_yymm = gainLossChkArr[0];
					pay_gl_yymm = gainLossChkArr[1];
					inv_xch_rt  = gainLossChkArr[2];
					pay_xch_rt  = gainLossChkArr[3];
					pay_amt     = gainLossChkArr[4];
					
					if(gainLossChkArr != null) {
						if (!(inv_xch_rt.equals(pay_xch_rt))) {
							accounting_line_no += 1;
							
							coaCtnt = dbDao.searchAccountingPrepayApplyLiabilityInfoCheck(accountingPrepayUnapplyCheckVOs.get(i).getInvDtrbSeq());
							if(Float.valueOf(pay_xch_rt).compareTo(Float.valueOf(inv_xch_rt)) > 0 ) {
								if(Integer.parseInt(pay_amt) > 0 ) {
									gain_loss_type = "LOSS";
								} else {
									gain_loss_type = "GAIN";
								}
							} else {
								if(Integer.parseInt(pay_amt) > 0 ) {
									gain_loss_type = "GAIN";
								} else {
									gain_loss_type = "LOSS";
								}
							}
							
							if("LOSS".equals(gain_loss_type)) {
								coaArr = dbDao.searchAccountingPaymentInvLossInfoCheck();
								paramCoaArr = new String[6];
								paramCoaArr[0] = coaArr[0];  //company
								paramCoaArr[1] = coaCtnt[0];  //region **
								paramCoaArr[2] = coaCtnt[1];  //center ** 
								paramCoaArr[3] = coaArr[3];  //account
								paramCoaArr[4] = coaArr[4];  //intercompany
								paramCoaArr[5] = coaArr[5];  //vvd
								coa_seq = dbDao.searchAccountingPaymentInvLossCoaInfo(paramCoaArr);
								
								String[] ccidChk = new String[2];
								if("".equals(JSPUtil.getNull(coa_seq))) {
									ccidChk = checkAPAccountSetup("", paramCoaArr);
									if(!ccidChk[0].equals("OK")) {												
										String resultMsg =new ErrorHandler("COM12241",new String[]{"LOSS CCID"}).getUserMessage();
										throw new EventException(resultMsg);
									} else {
										coa_seq = ccidChk[1]; 
									}											
								}
								
								gain_loss_amt = dbDao.searchAccountingPrepayApplyGainLossAmtInfo(accountingPrepayUnapplyCheckVOs.get(i).getInvDtrbSeq(), accountingPrepayUnapplyCheckVOs.get(i).getFunctionalCurrency());
								
								gainLossPaymentVO = new AccountingPaymentCheckVO();
								
								ObjectCloner.build(accountingPrepayUnapplyCheckVOs.get(i), gainLossPaymentVO);
								
								gainLossPaymentVO.setAccountingLineNo(accounting_line_no+"");
								gainLossPaymentVO.setCoaSeq(coa_seq);
								gainLossPaymentVO.setGainLossAmt(gain_loss_amt);
								
								lossPaymentVOs.add(gainLossPaymentVO);
								
							} else if("GAIN".equals(gain_loss_type)) {
								coaArr = dbDao.searchAccountingPaymentInvGainInfoCheck();
								paramCoaArr = new String[6];
								paramCoaArr[0] = coaArr[0];  //company
								paramCoaArr[1] = coaCtnt[0];  //region **
								paramCoaArr[2] = coaCtnt[1];  //center ** 
								paramCoaArr[3] = coaArr[3];  //account
								paramCoaArr[4] = coaArr[4];  //intercompany
								paramCoaArr[5] = coaArr[5];  //vvd
								coa_seq = dbDao.searchAccountingPaymentInvGainCoaInfo(paramCoaArr);
								
								String[] ccidChk = new String[2];
								if("".equals(JSPUtil.getNull(coa_seq))) {
									ccidChk = checkAPAccountSetup("", paramCoaArr);
									if(!ccidChk[0].equals("OK")) {												
										String resultMsg =new ErrorHandler("COM12241",new String[]{"GAIN CCID"}).getUserMessage();
										throw new EventException(resultMsg);
									} else {
										coa_seq = ccidChk[1]; 
									}											
								}
								
								gain_loss_amt = dbDao.searchAccountingPrepayApplyGainLossAmtInfo(accountingPrepayUnapplyCheckVOs.get(i).getInvDtrbSeq(),accountingPrepayUnapplyCheckVOs.get(i).getFunctionalCurrency());
								
								gainLossPaymentVO = new AccountingPaymentCheckVO();
								
								ObjectCloner.build(accountingPrepayUnapplyCheckVOs.get(i), gainLossPaymentVO);
								
								gainLossPaymentVO.setAccountingLineNo(accounting_line_no+"");
								gainLossPaymentVO.setCoaSeq(coa_seq);
								gainLossPaymentVO.setGainLossAmt(gain_loss_amt);
								
								gainPaymentVOs.add(gainLossPaymentVO);
							
							}
						}
					}
					
				} // end of accountingPrepayUnapplyCheckVOs loop
				 
				// loss & gain 
				if (lossPaymentVOs.size() > 0) {
					dbDao.addAccountingDetailPrepayUnApplyLossInfo(lossPaymentVOs);
				}
				if (gainPaymentVOs.size() > 0) {
					dbDao.addAccountingDetailPrepayUnApplyGainInfo(gainPaymentVOs);
				}
				invCommand.modifyAccountingDetailPrepayApplyLineFlag(accountingPrepayUnapplyCheckVOs);
				
			} // end of accountingPrepayUnapplyCheckVOs if 		
	
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}	
	}	
	
	private void processErrorCheck() throws Exception {
		try { 
			List<AccountingDetailValidateInfoVO> accountingDetailValidateInfoVOs = dbDao.searchAccountingDetailValidateInfo(accounting_request_id);
			
			if(accountingDetailValidateInfoVOs != null && accountingDetailValidateInfoVOs.size() > 0 ) {
				String[] chkValidtAmtArr = new String[4];
				String coa_null_cnt = "";
				String[] chkCoaArr = new String[2]; 
				String tempErrMsg = "";
				boolean isErr = false;
				
				List<AccountingDetailValidateInfoVO> updateAccountingErrVOs = new ArrayList<AccountingDetailValidateInfoVO>();
				AccountingDetailValidateInfoVO accountingDetailValidateInfoVO = null;
				
				for(int i=0; i < accountingDetailValidateInfoVOs.size(); i++ ) {
					tempErrMsg = "";
					chkValidtAmtArr = dbDao.searchAccountingDetailAmountValidate(accountingDetailValidateInfoVOs.get(i));
					//if (( Float.parseFloat(chkValidtAmtArr[0]) != Float.parseFloat(chkValidtAmtArr[1]) ) || ( Float.parseFloat(chkValidtAmtArr[2]) != Float.parseFloat(chkValidtAmtArr[3]) )) {
					if (( Float.valueOf(chkValidtAmtArr[0]).compareTo(Float.valueOf(chkValidtAmtArr[1])) != 0 ) || ( Float.valueOf(chkValidtAmtArr[2]).compareTo(Float.valueOf(chkValidtAmtArr[3])) != 0 )) {
						tempErrMsg = "DR CR Amount is Different";
						isErr = true;
					}
					
					if (!isErr) {
						coa_null_cnt    = dbDao.searchAccountingDetailCoaValidate(accountingDetailValidateInfoVOs.get(i));
						if (Integer.parseInt(coa_null_cnt) > 0) {
							tempErrMsg = "Accounting COA is Null";
							isErr = true;						
						}
					}
					
					chkCoaArr       = dbDao.searchAccountingDetailCoaValueValidate(accountingDetailValidateInfoVOs.get(i));
					if (Integer.parseInt(chkCoaArr[0]) != Integer.parseInt(chkCoaArr[1])) {
						tempErrMsg = "COA is Not Available";
						isErr = true;							
					}
					
					if (isErr) {
						accountingDetailValidateInfoVO = new AccountingDetailValidateInfoVO();
						ObjectCloner.build(accountingDetailValidateInfoVOs.get(i), accountingDetailValidateInfoVO);
						accountingDetailValidateInfoVO.setAcctgErrCd(tempErrMsg);
						accountingDetailValidateInfoVO.setUsrId(usrId);
						updateAccountingErrVOs.add(accountingDetailValidateInfoVO);
					}
					
				} //end of accountingDetailValidateInfoVOs for
				
				
				if (isErr && updateAccountingErrVOs.size() > 0) {
					dbDao.modifyAccountingDetailValidateResultInfo(updateAccountingErrVOs);
				}
				
			} // end of accountingDetailValidateInfoVOs if 
		} catch (DAOException ex) {
			log.error("[DAOException]"+ex.getMessage());
			throw new EventException(new ErrorHandler(ex).getMessage());
		} catch (Exception ex) {
			log.error("[Exception]"+ex.getMessage());
			throw new EventException(ex.getMessage(),ex);
		}	
	}	*/
}