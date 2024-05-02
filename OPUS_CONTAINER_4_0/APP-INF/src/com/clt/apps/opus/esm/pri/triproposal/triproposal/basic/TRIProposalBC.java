/*=========================================================
 *Copyright(c) 2009 CyberLogitec
 *@FileName : TRIProposalBC.java
 *@FileTitle : TRI Creation & Amendment
 *Open Issues :
 *Change history :
 *@LastModifyDate : 
 *@LastModifier : 
 *@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.triproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.RsltTriPropDtlListVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.RsltTriPropInquiryListVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.RsltTriPropListVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropGRIVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropParamVO;
import com.clt.apps.opus.esm.pri.triproposal.triproposal.vo.TriPropVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriTriMnVO;
import com.clt.syscommon.common.table.PriTriRtVO;

/**
 * Triproposal Business Logic Command Interface<br>
 * - Handling a biz logic about Triproposal<br>
 * 
 * @author SHKIM
 * @see EsmPri3001EventResponse
 * @since J2EE 1.6
 */
public interface TRIProposalBC {

	/**
	 * Retrieving TRI Proposal List.<br>
	 * 
	 * @param TriPropParamVO triPropParamVO
	 * @return List<RsltTriPropListVO>
	 * @exception EventException
	 */
	public List<RsltTriPropListVO> searchTRIProposalList(TriPropParamVO triPropParamVO) throws EventException;

	/**
	 * Retrieving TRI Proposal - Rate and Route information.<br>
	 * 
	 * @param PriTriMnVO priTriMnVO
	 * @return RsltTriPropDtlListVO
	 * @exception EventException
	 */
	public RsltTriPropDtlListVO searchTRIRateProposalList(PriTriMnVO priTriMnVO) throws EventException;
	
	/**
	 * Checking whether duplicated TRI Rate exists or not<br>
	 * 
	 * @param TriPropParamVO triPropParamVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckRateDuplicate(TriPropParamVO triPropParamVO) throws EventException;
	
	/**
	 * Numbering new TRI_PROP_NO<br>
	 * 
	 * @param SignOnUserAccount account
	 * @return String
	 * @exception EventException
	 */
	public String searchNextTRIPropNo(SignOnUserAccount account) throws EventException;

	/**
	 * Handling multi transaction of TRI Proposal & Rate .<br>
	 * 
	 * @param TriPropVO triPropVO
	 * @param SignOnUserAccount account
	 * @param String newTriPropNo
	 * @exception EventException
	 */
	public void manageTRIRateProposal(TriPropVO triPropVO, SignOnUserAccount account, String newTriPropNo) throws EventException;

	/**
	 * Requesting an approval of TRI Proposal data.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Requesting an approval of multi TRI Proposal data.<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void requestMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Amending TRI Proposal data.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * handling C/offer of TRI Proposal data.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cofferTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Approving TRI Proposal data <br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Approving TRI multi Proposal data<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void approveMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Pubplishing TRI Proposal data.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Puplishing multi TRI Proposal data<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void publishMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException;

	/**
	 * Numbering TRI Proposal data.<br>
	 * 
	 * @param PriTriMnVO priTriMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void assignNoTRIRateProposal(PriTriMnVO priTriMnVO, SignOnUserAccount account) throws EventException;

	/**
	 * making TRI Proposal data's status previous status<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelTRIRateProposal(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;

	/**
	 * Making several TRI Proposal data's status previous status다.<br>
	 * 
	 * @param PriTriRtVO[] priTriRtVOs
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelMultiTRIRateProposal(PriTriRtVO[] priTriRtVOs, SignOnUserAccount account) throws EventException;
	
	/**
	 * Checking whether TRI GRI is applicable or not.<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @return String
	 * @exception EventException
	 */
	public String searchCheckGRIApplicable(TriPropGRIVO triPropGRIVO) throws EventException;
	
	/**
	 * Applying GRI Calculation to Rate data.<br>
	 * 
	 * @param TriPropGRIVO triPropGRIVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void applyGRICalculation(TriPropGRIVO triPropGRIVO, SignOnUserAccount account) throws EventException;
	 

	/**
	 * Saving TRI Note Content information.<br>
	 * 
	 * @param PriTriRtVO priTriRtVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageNote(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;
	
	/**
	 * Retrieving TRI Proposal Inquiry List<br>
	 * 
	 * @param TriPropParamVO triPropParamVO
	 * @return List<RsltTriPropListVO>
	 * @exception EventException
	 */
	public List<RsltTriPropInquiryListVO> searchTRIProposalInquiryList(TriPropParamVO triPropParamVO) throws EventException;
 
    /**
     * Sending gw main to PIC when publishing at TRI Proposal <br>
     * 
     * @param PriTriRtVO priTriRtVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void sendMailTRIProposalPublish(PriTriRtVO priTriRtVO, SignOnUserAccount account) throws EventException;	
	
}