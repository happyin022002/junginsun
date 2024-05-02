/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFATransportationAdditionalChargeProposalUploadArbiExcelBackEndJob.java
*@FileTitle : Upload Arbi Info with Excel
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfatransportationadditionalchargeproposal.basic;

import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBC;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBCImpl;

import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpScpAmdtSmryVO;
import com.clt.syscommon.common.table.PriRpScpTrspAddChgVO;

/**
 * handling a biz logic about Upload RFA Charge Excel Info
 * 
 * @author 
 * @see RFATransportationAdditionalChargeProposalBCImpl 참조
 * @since J2EE 1.6
 */
public class RFATransportationAdditionalChargeProposalUploadArbiExcelBackEndJob   extends BackEndCommandSupport{
	private static final long serialVersionUID = -5479624864120463390L;
	
	private PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOS;
	private SignOnUserAccount account;
	
	/**
	 * login user Info  <br>
	 *  
	 * @param SignOnUserAccount account
	 */	
	public void setSignOnUserAccount(SignOnUserAccount account) {
		this.account = account;
	}
	
	/**
	 * Upload Excel Info <br>
	 *  
	 * @param PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOS
	 */	
	public void setPriRpScpTrspAddChgVOS(PriRpScpTrspAddChgVO[] priRpScpTrspAddChgVOS) {
		if (priRpScpTrspAddChgVOS != null) {
			PriRpScpTrspAddChgVO[] tmpVOs = new PriRpScpTrspAddChgVO[priRpScpTrspAddChgVOS.length];
			System.arraycopy(priRpScpTrspAddChgVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.priRpScpTrspAddChgVOS = tmpVOs;
		}
	}
	
	/**
	 *  Upload S/C Contract Rate Info Of Excel(Call SCRateProposalBCImpl.uploadRateExcelHorizontal)<br>
	 *  
	 * @return String
	 * @exception Exception
	 */
	 public String doStart() throws Exception {
		 
		 try {
				//-----------------------------------------------------------
				//(1) Save Excel Info
				//-----------------------------------------------------------
				
				
			 	RFATransportationAdditionalChargeProposalBC cmd = new RFATransportationAdditionalChargeProposalBCImpl();
				cmd.uploadArbitraryChargeProposal(priRpScpTrspAddChgVOS, account);
		         
				 
				//-----------------------------------------------------------
				//(2) Update Summary
				//-----------------------------------------------------------
				RFAProposalMainBC command2 = new RFAProposalMainBCImpl();
				
				PriRpScpAmdtSmryVO priRpScpAmdtSmryVO = new PriRpScpAmdtSmryVO();
	            priRpScpAmdtSmryVO.setPropNo(priRpScpTrspAddChgVOS[0].getPropNo());
	            priRpScpAmdtSmryVO.setAmdtSeq(priRpScpTrspAddChgVOS[0].getAmdtSeq());
	            priRpScpAmdtSmryVO.setSvcScpCd(priRpScpTrspAddChgVOS[0].getSvcScpCd());
	            if("O".equals(priRpScpTrspAddChgVOS[0].getOrgDestTpCd())) {
	            	priRpScpAmdtSmryVO.setPropScpTermTpCd("51");
	            } else if("D".equals(priRpScpTrspAddChgVOS[0].getOrgDestTpCd())) {
	            	priRpScpAmdtSmryVO.setPropScpTermTpCd("52");
	            }

	            command2.manageScopeAmendmentSummary(priRpScpAmdtSmryVO, account);
		        
				 
				 
			 }catch(Exception ex){
				log.error("err " + ex.toString(), ex);
				throw new EventException(ex.getMessage(),ex);			
			 }
			
		 return "success";
		 
		 

	 }
	
	
}
