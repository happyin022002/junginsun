/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : ChargeCalculationBackEndJob.java
*@FileTitle : ChargeCalculation BackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 2010.02.04
*@LastModifier : Hwang HyoKeun
*@LastVersion : 1.0
* 2010.02.04 Hwang HyoKeun
* 1.0 Creation
=========================================================*/
package com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.basic;

import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeArgumentVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.ChargeCalculationContainerVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargecalculation.vo.DmtResultVO;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.basic.ChargeOfficeTransferMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtclosing.chargeofficetransfermgt.basic.ChargeOfficeTransferMgtBCImpl;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBC;
import com.hanjin.apps.alps.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic.InvoiceIssueCollectionMgtBCImpl;
import com.hanjin.framework.component.message.ErrorHandler;
import com.hanjin.framework.core.layer.event.EventException;
import com.hanjin.framework.support.layer.backend.BackEndCommandSupport;
import com.hanjin.framework.support.view.signon.SignOnUserAccount;

/**
 * NIS2010-DMTClosing BackEnd Command implementation<br>
 * - NIS2010-DMTClosing에 대한 BackEnd Job을 처리한다.<br>
 *
 * @author Hwang HyoKeun
 * @see ChargeCalculationBC 각 DAO 클래스 참조
 * @since J2EE 1.6
 */
public class ChargeCalculationBackEndJob extends BackEndCommandSupport {

	private static final long serialVersionUID = 1L;

	// Login User Information
	private SignOnUserAccount account = null;
	
	/** Table Value Object 조회 조건 및 단건 처리  */
	private ChargeArgumentVO chargeArgumentVO = null;
	
	/** Table Value Object Multi Data 처리 */
	private ChargeCalculationContainerVO[] chargeCalculationContainerVOs = null;
	
	
	private ChargeCalculationBC chgCalcCommand = null;
	
	private String jobCommand = ""; 
	
	
	public ChargeCalculationBackEndJob() {
		chgCalcCommand = new ChargeCalculationBCImpl();
	}
	
	
	/**
	 * 각각의 BackEnd Job을 실행시켜서 처리된 결과를 리턴한다.
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
				
			} else if(jobCommand.equals("RECALC")) {
				resultVO = chgCalcCommand.modifyChargeByBooking(chargeCalculationContainerVOs, account);
			}

			
			if(resultVO.getResultCode() != null) {
				if(resultVO.getResultMsg() != null)
					resultMsg = resultVO.getResultMsg();
				else
					resultMsg = new ErrorHandler(resultVO.getResultCode()).getUserMessage();
				
				// 해당 사용자 지정 오류 메세지가 COM_BAK_END_JB 테이블의 JB_USR_ERR_MSG 필드에 저장된다.
				throw new EventException(resultMsg);
			}
// BCImple에서 설정하도록 변경함 2011.11.30 			
//			if(jobCommand.equals("DRSAVE") || jobCommand.equals("BALANCE")|| jobCommand.equals("RECALC")) {
//				// EDI 전송할 데이터 설정
//				resultVO.setChargeCalculationContainerVOArray(chargeCalculationContainerVOs);
//				
//			} else if(jobCommand.equals("PARTIAL")) {
			
			if(jobCommand.equals("PARTIAL")) {	
				// EDI 전송할 데이터
				ChargeCalculationContainerVO[] retChgCalcVOs = resultVO.getChargeCalculationContainerVOArray();
				
				InvoiceIssueCollectionMgtBC invIssCommand = new InvoiceIssueCollectionMgtBCImpl();
				resultVO = invIssCommand.modifyInvoiceByPartialPayment(retChgCalcVOs, account);
				
				if(resultVO.getResultCode() != null) {
					if(resultVO.getResultMsg() != null)
						resultMsg = resultVO.getResultMsg();
					else
						resultMsg = new ErrorHandler(resultVO.getResultCode()).getUserMessage();
					
					// 해당 사용자 지정 오류 메세지가 COM_BAK_END_JB 테이블의 JB_USR_ERR_MSG 필드에 저장된다.
					throw new EventException(resultMsg);
				}
				
				
				ChargeOfficeTransferMgtBC otMgtCommand = new ChargeOfficeTransferMgtBCImpl();
				resultVO = otMgtCommand.createOfficeTransferHistoryByPartialPayment(retChgCalcVOs, account);
				
				if(resultVO.getResultCode() != null) {
					if(resultVO.getResultMsg() != null)
						resultMsg = resultVO.getResultMsg();
					else
						resultMsg = new ErrorHandler(resultVO.getResultCode()).getUserMessage();
					
					// 해당 사용자 지정 오류 메세지가 COM_BAK_END_JB 테이블의 JB_USR_ERR_MSG 필드에 저장된다.
					throw new EventException(resultMsg);
				}
				
				// EDI 전송할 데이터 설정
				resultVO.setChargeCalculationContainerVOArray(retChgCalcVOs);
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
		return chargeCalculationContainerVOs;
	}


	/**
	 * @param chargeCalculationContainerVOs the chargeCalculationContainerVOs to set
	 */
	public void setChargeCalculationContainerVOs(
			ChargeCalculationContainerVO[] chargeCalculationContainerVOs) {
		this.chargeCalculationContainerVOs = chargeCalculationContainerVOs;
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
