/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : RFARateProposalCheckRateExcelHorizontalBackEndJob.java
*@FileTitle : RFA Excel Check BackEndJob
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.basic;

import java.util.ArrayList;
import java.util.List;


import com.clt.apps.opus.esm.pri.rfaproposal.rfarateproposal.vo.RsltRtListHorizontalExcelVO;
import com.clt.framework.component.util.code.CodeInfo;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.layer.backend.BackEndCommandSupport;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriRpScpRtCmdtHdrVO;


/**
 * handling a biz logic about Check RFA Contract Rate Excel Info
 * 
 * @author 
 * @see SCRateProposalBCImpl
 * @since J2EE 1.6
 */
public class RFARateProposalCheckRateExcelHorizontalBackEndJob extends BackEndCommandSupport{
	private static final long serialVersionUID = -5479624864120463390L;
	
	//private Logger logger = Logger.getLogger(this.getClass().getName());

	private PriRpScpRtCmdtHdrVO priRpScpRtCmdtHdrVO;
	private RsltRtListHorizontalExcelVO[] rsltRtListHorizontalExcelVOS;
	private SignOnUserAccount account;
	private ArrayList<CodeInfo> termOrgCodeList;
	private ArrayList<CodeInfo> termDestCodeList;
	private ArrayList<CodeInfo> trspModCodeList;

	/**
	 *  login user Info <br>
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
	 * Destination areas Code List  <br>
	 *  
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 */	
	public void setTermDest(ArrayList<CodeInfo> termDestCodeList) {
		this.termDestCodeList = termDestCodeList;
	}
	
	/**
	 *  <br>
	 *  
	 * @param ArrayList<CodeInfo> termOrgCodeList
	 */	
	public void setTrspMod(ArrayList<CodeInfo> trspModCodeList) {
		this.trspModCodeList = trspModCodeList;
	}
	
	
	
	
	/**
	 * Check RFA Contract Rate Info Of Excel(Call RFARateProposalBCImpl.checkRateExcelHorizontal) <br>
	 *  
	 * @return List<RsltRtListHorizontalExcelVO>
	 * @exception Exception
	 */
	 public List<RsltRtListHorizontalExcelVO> doStart() throws Exception {
		 
		 List<RsltRtListHorizontalExcelVO> resultVOS = new ArrayList<RsltRtListHorizontalExcelVO>();
		 try {
			//-----------------------------------------------------------
			//(1) Check Rate with Excel Info
			//-----------------------------------------------------------
			RFARateProposalBC cmd = new RFARateProposalBCImpl();
			resultVOS = cmd.checkRateExcelHorizontal(priRpScpRtCmdtHdrVO, rsltRtListHorizontalExcelVOS, termOrgCodeList, termDestCodeList, trspModCodeList, account);

		 }catch(Exception ex){
			throw new EventException(ex.getMessage(),ex);			
		 }
			
		 return resultVOS;
		 
		 

	 }
}
