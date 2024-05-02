/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationBackEndJob.java
*@FileTitle : ChargeCalculation BackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.basic.ChargeOfficeTransferMgtBC;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargeofficetransfermgt.basic.ChargeOfficeTransferMgtBCImpl;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBC;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBCImpl;
import com.clt.framework.component.message.ErrorHandler;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * OPUS-DMTClosing BackEnd Command implementation<br>
 * @author
 * @see reference DAO of ChargeCalculationBC 
 * @since J2EE 1.6
 */
public class ChargeCalculationBackEndJob extends BackEndCommandSupport {

	private static final long serialVersionUID = 1L;

	// Login User Information
	private SignOnUserAccount account = null;
	
	/** Table Value Object search comdition and single process  */
	private ChargeArgumentVO chargeArgumentVO = null;
	
	/** Table Value Object Multi Data */
	private ChargeCalculationContainerVO[] chargeCalculationContainerVOs = null;
	
	
	private ChargeCalculationBC chgCalcCommand = null;
	
	private String jobCommand = ""; 
	
	
	public ChargeCalculationBackEndJob() {
		chgCalcCommand = new ChargeCalculationBCImpl();
	}
	
	
	/**
	 * return result BackEnd Job
	 * 
	 * @return Object
	 * @exception Exception
	 */
	@Override
	public Object doStart() throws Exception {
		
		DmtResultVO resultVO = null;
		String resultMsg = null;
		
		try {
			if(jobCommand.equals("PRECAL")) {
				resultVO = chgCalcCommand.precalDRDateCharge(chargeArgumentVO, chargeCalculationContainerVOs, account);
				
			} else if(jobCommand.equals("DRSAVE")) {
				resultVO = chgCalcCommand.modifyCharge(chargeArgumentVO, chargeCalculationContainerVOs, account);
				
			} else if(jobCommand.equals("BALANCE")) {
				resultVO = chgCalcCommand.createBalanceCharge(chargeCalculationContainerVOs, account);
					
			} else if(jobCommand.equals("PARTIAL")) {
				resultVO = chgCalcCommand.createPartialPayment(chargeCalculationContainerVOs, account);
				
			} else if(jobCommand.equals("MPODETA")) {
				resultVO = chgCalcCommand.createManualCharge(chargeCalculationContainerVOs, account);
				
			} else if(jobCommand.equals("CALCULATE")) {
				resultVO = chgCalcCommand.createChargeBySZPBB(chargeCalculationContainerVOs, account);
			
			//choi - Recalculation
			} else if(jobCommand.equals("RECALC")) {
				resultVO = chgCalcCommand.modifyChargeByBooking(chargeCalculationContainerVOs, account);
			}
			
			if(resultVO != null) {
				if(resultVO.getResultCode() != null) {
					if(resultVO.getResultMsg() != null)
						resultMsg = resultVO.getResultMsg();
					else
						resultMsg = new ErrorHandler(resultVO.getResultCode()).getUserMessage();
					
					// user define error message save to JB_USR_ERR_MSG of COM_BAK_END_JB table
					throw new EventException(resultMsg);
				}
			}
			
			if(jobCommand.equals("DRSAVE") || jobCommand.equals("BALANCE") || jobCommand.equals("RECALC")) {
				// setting to send data fot EDI 
				if(resultVO != null) resultVO.setChargeCalculationContainerVOArray(chargeCalculationContainerVOs);
				
			} else if(jobCommand.equals("PARTIAL")) {
				// send data fot EDI 
				ChargeCalculationContainerVO[] retChgCalcVOs = null;
				if(resultVO != null) {
					retChgCalcVOs = resultVO.getChargeCalculationContainerVOArray();
				}
				
				InvoiceIssueCollectionMgtBC invIssCommand = new InvoiceIssueCollectionMgtBCImpl();
				if(retChgCalcVOs != null) {
					resultVO = invIssCommand.modifyInvoiceByPartialPayment(retChgCalcVOs, account);
				}
				//[2015.05.28]소스품질 Modify
				if(null != resultVO && resultVO.getResultCode() != null) {
					if(resultVO.getResultMsg() != null)
						resultMsg = resultVO.getResultMsg();
					else
						resultMsg = new ErrorHandler(resultVO.getResultCode()).getUserMessage();
					
					//  user define error message save to JB_USR_ERR_MSG of COM_BAK_END_JB table
					throw new EventException(resultMsg);
				}
				
				
				ChargeOfficeTransferMgtBC otMgtCommand = new ChargeOfficeTransferMgtBCImpl();
				if(retChgCalcVOs != null) {
					resultVO = otMgtCommand.createOfficeTransferHistoryByPartialPayment(retChgCalcVOs, account);
				}
				//[2015.05.28]소스품질 Modify
				if(null != resultVO && resultVO.getResultCode() != null) {
					if(resultVO.getResultMsg() != null)
						resultMsg = resultVO.getResultMsg();
					else
						resultMsg = new ErrorHandler(resultVO.getResultCode()).getUserMessage();
					
					//  user define error message save to JB_USR_ERR_MSG of COM_BAK_END_JB table
					throw new EventException(resultMsg);
				}
				
				// setting to send data fot EDI 
				if(retChgCalcVOs != null) resultVO.setChargeCalculationContainerVOArray(retChgCalcVOs);
			}
			
		}catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}
		
		return resultVO;
	}




	/**
	 * @return the chargeArgumentVO
	 */
	public ChargeArgumentVO getChargeArgumentVO() {
		return chargeArgumentVO;
	}


	/**
	 * @param chargeArgumentVO the chargeArgumentVO to set
	 */
	public void setChargeArgumentVO(ChargeArgumentVO chargeArgumentVO) {
		this.chargeArgumentVO = chargeArgumentVO;
	}


	/**
	 * @return the chargeCalculationContainerVOs
	 */
	public ChargeCalculationContainerVO[] getChargeCalculationContainerVOs() {
		ChargeCalculationContainerVO[] tmpVOs = null;
		if (this.chargeCalculationContainerVOs != null) {
			tmpVOs = new ChargeCalculationContainerVO[chargeCalculationContainerVOs.length];
			System.arraycopy(chargeCalculationContainerVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}


	/**
	 * @param chargeCalculationContainerVOs the chargeCalculationContainerVOs to set
	 */
	public void setChargeCalculationContainerVOs(
			ChargeCalculationContainerVO[] chargeCalculationContainerVOs) {
		if (chargeCalculationContainerVOs != null) {
			ChargeCalculationContainerVO[] tmpVOs = new ChargeCalculationContainerVO[chargeCalculationContainerVOs.length];
			System.arraycopy(chargeCalculationContainerVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.chargeCalculationContainerVOs = tmpVOs;
		}
	}




	/**
	 * @return the account
	 */
	public SignOnUserAccount getSignOnUserAccount() {
		return account;
	}




	/**
	 * @param account the account to set
	 */
	public void setSignOnUserAccount(SignOnUserAccount account) {
		this.account = account;
	}


	/**
	 * @return the jobCommand
	 */
	public String getJobCommand() {
		return jobCommand;
	}


	/**
	 * @param jobCommand the jobCommand to set
	 */
	public void setJobCommand(String jobCommand) {
		this.jobCommand = jobCommand;
	}

}
