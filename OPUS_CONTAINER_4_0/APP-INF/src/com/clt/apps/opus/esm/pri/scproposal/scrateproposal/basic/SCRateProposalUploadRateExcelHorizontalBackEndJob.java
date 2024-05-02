/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCRateProposalUploadRateExcelHorizontalBackEndJob.java
*@FileTitle : S/C Excel Upload BackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/

package com.clt.apps.opus.esm.pri.scproposal.scrateproposal.basic;

import java.util.ArrayList;

import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.basic.SCProposalMainBC;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.basic.SCProposalMainBCImpl;
import com.clt.apps.opus.esm.pri.scproposal.scrateproposal.vo.RsltRtListHorizontalExcelVO;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpScpAmdtSmryVO;
import com.clt.syscommon.common.table.PriSpScpRtCmdtHdrVO;


/**
 * handling a biz logic about Upload S/C Contract Rate Excel Info
 * 
 * @author 
 * @see SCRateProposalBCImpl
 * @since J2EE 1.6
 */
public class SCRateProposalUploadRateExcelHorizontalBackEndJob extends BackEndCommandSupport{
	private static final long serialVersionUID = -5479624864120463390L;
	
	//private Logger logger = Logger.getLogger(this.getClass().getName());

	private PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO;
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
	 * @param PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO
	 */	
	public void setPriSpScpRtCmdtHdrVO(PriSpScpRtCmdtHdrVO priSpScpRtCmdtHdrVO) {
		this.priSpScpRtCmdtHdrVO = priSpScpRtCmdtHdrVO;
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
	 *  Upload S/C Contract Rate Info Of Excel(Call SCRateProposalBCImpl.uploadRateExcelHorizontal)<br>
	 *  
	 * @return String
	 * @exception Exception
	 */
	 public String doStart() throws Exception {
		 
		 
		 try {
			//-----------------------------------------------------------
			//(1) Save Rate with Excel Info
			//-----------------------------------------------------------
			
			
			SCRateProposalBC cmd = new SCRateProposalBCImpl();
			cmd.uploadRateExcelHorizontal(priSpScpRtCmdtHdrVO, rsltRtListHorizontalExcelVOS, termOrgCodeList, termDestCodeList, trspModCodeList, account);
	         
			 
			//-----------------------------------------------------------
			//(2) Update Summary
			//-----------------------------------------------------------
			SCProposalMainBC cmdMain = new SCProposalMainBCImpl();
			 
			PriSpScpAmdtSmryVO smryVO = new PriSpScpAmdtSmryVO();
	        String sTermTpCd = "";
	        if (priSpScpRtCmdtHdrVO.getGenSpclRtTpCd().equals("G")) {
	        	sTermTpCd = "71";
	        } else if (priSpScpRtCmdtHdrVO.getGenSpclRtTpCd().equals("S")) {
	            sTermTpCd = "72";
	        }
	        smryVO.setPropNo(priSpScpRtCmdtHdrVO.getPropNo());
	        smryVO.setAmdtSeq(priSpScpRtCmdtHdrVO.getAmdtSeq());
	        smryVO.setSvcScpCd(priSpScpRtCmdtHdrVO.getSvcScpCd());
	        smryVO.setPropScpTermTpCd(sTermTpCd);
	        cmdMain.manageScopeAmendmentSummary(smryVO, account);
	        
			 
			 
		 }catch(Exception ex){
			throw new EventException(ex.getMessage(),ex);			
		 }
			
		 return "sucess";
		 
		 

	 }
	 
	 
	 
		


}
