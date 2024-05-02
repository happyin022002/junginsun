/*=========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : SCContractPartyProposalBC.java
*@FileTitle : Contract Parties Information
*Open Issues :
*Change history :
*@LastModifyDate : 
*@LastModifier :
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.vo.PriSpCtrtPtyInqVO;
import com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.vo.RsltPriSpCtrtCustTpVO;
import com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.vo.RsltPriSpCtrtPtyTypeVO;
import com.clt.apps.opus.esm.pri.scproposal.sccontractpartyproposal.vo.RsltPriSpCtrtPtyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.RsltPropCopyVO;
import com.clt.apps.opus.esm.pri.scproposal.scproposalmain.vo.ScPropMnVO;
//import com.clt.apps.opus.esm.pri.scquotation.scquotationmain.vo.RsltCopyToProposalVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriSpCtrtCustTpVO;
import com.clt.syscommon.common.table.PriSpCtrtPtyVO;
import com.clt.syscommon.common.table.PriSpMnVO;

/**
 * Scproposal Business Logic Command Interface<br>
 * - Handling a biz logic about Scproposal<br>
 *
 * @author 
 * @see Esm_pri_0022EventResponse 
 * @since J2EE 1.4
 */

public interface SCContractPartyProposalBC {

	
	/**
	 * Requesting Amend<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void amendProposal(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;		
	
	
	
	
	/**
	 * Retrieving Contract Customer Type  List<br>
	 * 
	 * @param PriSpCtrtCustTpVO priSpCtrtCustTpVO
	 * @return List<RsltPriSpCtrtCustTpVO>
	 * @exception EventException
	 */
	public List<RsltPriSpCtrtCustTpVO> searchProposalContractCustomerTypeList(PriSpCtrtCustTpVO priSpCtrtCustTpVO) throws EventException;	
	
	/**
	 * Accepting Contract Customer Type data<br>
	 * 
	 * @param PriSpCtrtCustTpVO priSpCtrtCustTpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalContractCustomerType(PriSpCtrtCustTpVO priSpCtrtCustTpVO,SignOnUserAccount account) throws EventException;
	/**
	 * Cancelling an acceptance of Contract Customer Type data<br>
	 * 
	 * @param PriSpCtrtCustTpVO priSpCtrtCustTpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalContractCustomerType(PriSpCtrtCustTpVO priSpCtrtCustTpVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Saving Contract Customer Type data<br>
	 * 
	 * @param PriSpCtrtCustTpVO[] priSpCtrtCustTpVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalContractCustomerType(PriSpCtrtCustTpVO[] priSpCtrtCustTpVO,SignOnUserAccount account) throws EventException;	
	
	
	
	/**
	 * Retrieving Contract Parties List<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPriSpCtrtPtyVO>
	 * @exception EventException
	 */
	public List<RsltPriSpCtrtPtyVO> searchProposalContractPartyList(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException;	
	
	/**
	 *  Retrieving Contract Party Type<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPriSpCtrtPtyTypeVO>
	 * @exception EventException
	 */
	public List<RsltPriSpCtrtPtyTypeVO> searchProposalContractPartyTypeList(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException;		
	/**
	 * Accepting Contract Parties data<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void acceptProposalContractParty(PriSpCtrtPtyVO priSpCtrtPtyVO,SignOnUserAccount account) throws EventException;
	/**
	 * Cancelling an acceptance of Contract Parties data.<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void cancelProposalContractParty(PriSpCtrtPtyVO priSpCtrtPtyVO,SignOnUserAccount account) throws EventException;
	
	/**
	 * Saving Contract Parties data<br>
	 * 
	 * @param PriSpCtrtPtyVO[] priSpCtrtPtyVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalContractParty(PriSpCtrtPtyVO[] priSpCtrtPtyVO,SignOnUserAccount account) throws EventException;

	/**
	 * Saving Contract Parties,Customer Type data<br>
	 * 
	 * @param ScPropMnVO scPropMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposal(ScPropMnVO scPropMnVO,SignOnUserAccount account) throws EventException;
	
    /**
     * Copying Proposal Contract Party information<br>
     * 
     * @param RsltPropCopyVO vo
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void copyProposalContractParty(RsltPropCopyVO vo, SignOnUserAccount account) throws EventException;
    
	/**
	 * Deleting all data of related Amend Seq No when cancelling Init status of Main<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
	 * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void removeProposal(PriSpMnVO priSpMnVO, SignOnUserAccount account) throws EventException;	
	
	/**
	 * Modifying accepted datas to Init status when cancelling request<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancel(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;  	

	/**
	 *Modifying Cust Type Accepted datas to Init status when cancelling request<br>
	 * 
	 * @param PriSpMnVO priSpMnVO
     * @param SignOnUserAccount account
	 * @exception EventException
	 */
	public void manageProposalRequestCancelCustType(PriSpMnVO priSpMnVO,SignOnUserAccount account) throws EventException;  		
	
	/**
	 *Handling Option's Font<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalContractPartyFont(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException;	
	
	/**
	 * Retrieving Contract Parties Amend History List를<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltPriSpCtrtPtyVO>
	 * @exception EventException
	 */
	public List<RsltPriSpCtrtPtyVO> searchProposalContractPartyHistoryList(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException;
	
	/**
	 * Handling SC Contract Party History Option's Font<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalContractPartyHistoryFont(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException;
	
	/**
   * Retrieving Contract Parties Information Inquiry List<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<PriSpCtrtPtyInqVO>
	 * @exception EventException
	 */
	public List<PriSpCtrtPtyInqVO> searchProposalContractPartyInquiryList(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException;	
	

	
	/**
	 * Retrieving Inquiry - Option's Font<br>
	 * 
	 * @param PriSpCtrtPtyVO priSpCtrtPtyVO
	 * @return List<RsltCdListVO>
	 * @exception EventException
	 */
	public List<RsltCdListVO> searchProposalContractPartyFontInquiry(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException;		
	
}