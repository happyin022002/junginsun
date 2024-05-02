/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateProposalUploadRateExcelHorizontalBackEndJob.java
*@FileTitle : RFA Excel Upload BackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/


package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.basic;

import java.util.ArrayList;


import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBC;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.basic.RFAProposalMainBCImpl;
import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalExcelVO;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpScpAmdtSmryVO;
import com.clt.syscommon.common.table.PriRpScpRtCmdtHdrVO;

/**
 * handling a biz logic about Upload RFA Contract Rate Excel Info
 * 
 * @author 
 * @see RFARateProposalBCImpl
 * @since J2EE 1.6
 */
public class RFARateProposalUploadRateExcelHorizontalBackEndJob extends BackEndCommandSupport{
	private static final long serialVersionUID = -5479624864120463390L;
	
	//private Logger logger = Logger.getLogger(this.getClass().getName());

	private PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO;
	private RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS;
	private SignOnUserAccount account;
	private ArrayList<CodeInfo> termOrgCodeList;
	private ArrayList<CodeInfo> termDestCodeList;
	private ArrayList<CodeInfo> trspModCodeList;

	/**
	 * login user Info  <br>
	 *  
	 * @param SignOnUserAccount account
	 */	
	public void setSignOnUserAccount(SignOnUserAccount account) {
		this.account = account;
	}
	
	/**
	 * Commodity Header Info <br>
	 *  
	 * @param PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO
	 */	
	public void setPriRpScpRtCmdtHdrVO(PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO) {
		this.priRpScpRtCmdtHdrVO = priRpScpRtCmdtHdrVO;
	}
	

	/**
	 * Upload Excel Info <br>
	 *  
	 * @param RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS
	 */	
	public void setRsltRtListHorizontalExcelVO(RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS) {
		if (rsltRtListHorizontalExcelVOS != null) {
			RsltRtListHorizontalExcelVO[] tmpVOs = new RsltRtListHorizontalExcelVO[rsltRtListHorizontalExcelVOS.length];
			System.arraycopy(rsltRtListHorizontalExcelVOS, 0, tmpVOs, 0, tmpVOs.length);
			this.rsltRtListHorizontalExcelVOS = tmpVOs;
		}
	}
	
	/**
	 * Origination areas Code List <br>
	 *  
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 */	
	public void setTermOrg(ArrayList<CodeInfo> termOrgCodeList) {
		this.termOrgCodeList = termOrgCodeList;
	}
	
	/**
	 * Destination areas Code List <br>
	 *  
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 */	
	public void setTermDest(ArrayList<CodeInfo> termDestCodeList) {
		this.termDestCodeList = termDestCodeList;
	}
	
	/**
	 * Trans Mode Code List  <br>
	 *  
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 */	
	public void setTrspMod(ArrayList<CodeInfo> trspModCodeList) {
		this.trspModCodeList = trspModCodeList;
	}
	
	
	
	
	/**
	 *  Upload RFA Contract Rate Info Of Excel(Call SCRateProposalBCImpl.uploadRateExcelHorizontal)<br>
	 *  
	 * @return String
	 * @exception Exception
	 */
	 public String doStart() throws Exception {
		 
		 
		 try {
			//-----------------------------------------------------------
			//(1) Save Rate with Excel Info
			//-----------------------------------------------------------
			
			
			RFARateProposalBC cmd = new RFARateProposalBCImpl();
			cmd.uploadRateExcelHorizontal(priRpScpRtCmdtHdrVO, rsltRtListHorizontalExcelVOS, termOrgCodeList, termDestCodeList, trspModCodeList, account);
	         
			 
			//-----------------------------------------------------------
			//(2) Update Summary
			//-----------------------------------------------------------
			RFAProposalMainBC cmdMain = new RFAProposalMainBCImpl();
			 
			PriRpScpAmdtSmryVO smryVO = new PriRpScpAmdtSmryVO();

	        smryVO.setPropNo(priRpScpRtCmdtHdrVO.getPropNo());
	        smryVO.setAmdtSeq(priRpScpRtCmdtHdrVO.getAmdtSeq());
	        smryVO.setSvcScpCd(priRpScpRtCmdtHdrVO.getSvcScpCd());
	        smryVO.setPropScpTermTpCd("71");
	        cmdMain.manageScopeAmendmentSummary(smryVO, account);
	        
			 
			 
		 }catch(Exception ex){
			throw new EventException(ex.getMessage(),ex);			
		 }
			
		 return "sucess";
		 
		 

	 }
}
