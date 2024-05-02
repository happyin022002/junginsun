/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : InvoiceIssueCollectionMgtBackEndJob.java
*@FileTitle : Invoice Creation & Issue
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion :
=========================================================*/
package com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.basic;

import java.util.List;

import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBC;
import com.clt.apps.opus.ees.dmt.dmtclosing.chargecalculation.basic.ChargeCalculationBCImpl;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.ConfirmChargeListVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceGroupMgtVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceGroupParamVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.InvoiceIssueVO;
import com.clt.apps.opus.ees.dmt.dmtinvoicemgt.invoiceissuecollectionmgt.vo.VVDCheckDataVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;

/**
 * It's InvoiceIssueCollectionMgtBackEndJob.java
 * @author 
 * @see BackEndCommandSupport
 * @since J2EE 1.6

 */

public class InvoiceIssueCollectionMgtBackEndJob extends BackEndCommandSupport {
	
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 3268528797245615253L;

	// Login User Information
	private SignOnUserAccount account = null;
	
	private InvoiceGroupParamVO invoiceGroupParamVO = null;
	
	private ConfirmChargeListVO[] confirmChargeListVOs = null;
	
	private InvoiceIssueCollectionMgtBC command = null;
	
	private ChargeCalculationBC commandChrge = null;
	
	private String jobCommand = ""; 
	
	public InvoiceIssueCollectionMgtBackEndJob () {
		command = new InvoiceIssueCollectionMgtBCImpl();
		commandChrge = new ChargeCalculationBCImpl();
		
	}

	/**
	 * in Save Group Invoice BackEnd Job return result .<br>
	 * 
	 * @return Object
	 * @exception Exception
	 */
	public Object doStart() throws Exception {
		
		InvoiceGroupMgtVO invoiceGroupMgtVO = new InvoiceGroupMgtVO();
        List<InvoiceIssueVO> chargeList			= null;
        List<VVDCheckDataVO> vVDCheckDataVOs = null;
        String resultMsg = null;
        
        try{
            ///////////////////////////////////////////////////////////////////////////////////////////////
            //if DMDT_CHG_LOC_DIV_CD is not 'TSP', 'SZP', then CALL searchVVDNEta and Setting VVD CD.
            ///////////////////////////////////////////////////////////////////////////////////////////////
        	vVDCheckDataVOs = command.searchChargeBookingGroupInvoiceVVDDetail(invoiceGroupParamVO, confirmChargeListVOs);
        	for( int i = 0; i < vVDCheckDataVOs.size(); i++) {
        		VVDCheckDataVO vVDCheckDataVO = (VVDCheckDataVO) vVDCheckDataVOs.get(i);
        		
        		//save.
        		if(i == 0) {
        			commandChrge.modifyBookingContainerVVD(vVDCheckDataVO);	//DMT_CHG_BKG_CNTR update
        		}
        		//dusplication SKIP
        		boolean checkflag = false;
        		for( int j = i; j > 0; j--) {
        			VVDCheckDataVO vVDCheckDataVO2 = (VVDCheckDataVO) vVDCheckDataVOs.get(j);
        			//dusplication SKIP
        			if(vVDCheckDataVO.getBkgNo().equals(vVDCheckDataVO2.getBkgNo()) && vVDCheckDataVO.getPodCd().equals(vVDCheckDataVO2.getPodCd())
        					&& vVDCheckDataVO.getPolCd().equals(vVDCheckDataVO2.getPolCd()) && vVDCheckDataVO.getIoBnd().equals(vVDCheckDataVO2.getIoBnd()))
        			{
        				checkflag = true;
        				break;
        			}
        		}
        		if(!checkflag){
        			commandChrge.modifyBookingContainerVVD(vVDCheckDataVO);	//DMT_CHG_BKG_CNTR update
        		}
        	}
       		confirmChargeListVOs = command.searchIssueInvoiceByGroupVVD(invoiceGroupParamVO, confirmChargeListVOs);
            ///////////////////////////////////////////////////////////////////////////////////////////////
       		
        	//invoice group save
			invoiceGroupMgtVO = command.issueInvoiceByGroup(invoiceGroupParamVO, confirmChargeListVOs, account);
			
	        if(!invoiceGroupMgtVO.getInvoiceGroupParamVO().getErrCode().equals("")) {//user error
	        	//resultMsg = new ErrorHandler(invoiceGroupMgtVO.getInvoiceGroupParamVO().getErrCode()).getUserMessage();
	        	resultMsg = invoiceGroupMgtVO.getInvoiceGroupParamVO().getErrMsg();
	        	throw new EventException(resultMsg);
	        }else{
	        	//create charge data.
            	chargeList = command.searchChargeBookingGroupInvoiceDetail(invoiceGroupMgtVO);
            	
                //change charge status
            	commandChrge.changeChargeStatusForInvoiceByGroup(chargeList, account);
	        }
        }catch(Exception ex){
			log.error(ex.getMessage(),ex);
			throw ex;
		}
        return invoiceGroupMgtVO;
	}

	public InvoiceGroupParamVO getInvoiceGroupParamVO() {
		return invoiceGroupParamVO;
	}

	public void setInvoiceGroupParamVO(InvoiceGroupParamVO invoiceGroupParamVO) {
		this.invoiceGroupParamVO = invoiceGroupParamVO;
	}

	public ConfirmChargeListVO[] getConfirmChargeListVOs() {
		ConfirmChargeListVO[] tmpVOs = null;
		if (this.confirmChargeListVOs != null) {
			tmpVOs = new ConfirmChargeListVO[confirmChargeListVOs.length];
			System.arraycopy(confirmChargeListVOs, 0, tmpVOs, 0, tmpVOs.length);
		}
		return tmpVOs;
	}

	public void setConfirmChargeListVOs(ConfirmChargeListVO[] confirmChargeListVOs) {
		if (confirmChargeListVOs != null) {
			ConfirmChargeListVO[] tmpVOs = new ConfirmChargeListVO[confirmChargeListVOs.length];
			System.arraycopy(confirmChargeListVOs, 0, tmpVOs, 0, tmpVOs.length);
			this.confirmChargeListVOs = tmpVOs;
		}
	}

	public SignOnUserAccount getSignOnUserAccount() {
		return account;
	}

	public void setSignOnUserAccount(SignOnUserAccount account) {
		this.account = account;
	}

	public String getJobCommand() {
		return jobCommand;
	}

	public void setJobCommand(String jobCommand) {
		this.jobCommand = jobCommand;
	}
}
