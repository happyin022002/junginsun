/*========================================================
*Copyright(c) 2009 CyberLogitec
*@FileName : TAAProposalBC.java
*@FileTitle : TAA Creation & Amendment
*Open Issues :
*Change history :
*@LastModifyDate :
*@LastModifier : 
*@LastVersion : 1.0
=========================================================*/
package com.clt.apps.opus.esm.pri.triproposal.taaproposal.basic;

import java.util.List;

import com.clt.apps.opus.esm.pri.pricommon.pricommon.vo.RsltCdListVO;
import com.clt.apps.opus.esm.pri.rfaproposal.rfaproposalmain.vo.RsltPropCustInfoVO;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.vo.RsltTaaListVO;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.vo.RsltTaaMnVO;
import com.clt.apps.opus.esm.pri.triproposal.taaproposal.vo.RsltTaaTriListVO;
import com.clt.framework.core.layer.event.EventException;
import com.clt.framework.support.view.signon.SignOnUserAccount;
import com.clt.syscommon.common.table.PriAuthorizationVO;
import com.clt.syscommon.common.table.PriSpCtrtPtyVO;
import com.clt.syscommon.common.table.PriTriMnVO;

/**
 * Triproposal Business Logic Command Interface<br>
 * - Handling a biz logic about Triproposal<br>
 *
 * @author SHKIM
 * @see EsmPri3004EventResponse
 * @since J2EE 1.6
 */
public interface TAAProposalBC {

    /**
     * Retrieving TRI Proposal TAA Main , TRI List.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return RsltTaaListVO
     * @exception EventException
     */
    public RsltTaaListVO searchTRIProposalTAAList (RsltTaaMnVO rsltTaaMnVO) throws EventException;

    /**
     * Retrieving TRI Proposal TAA Main's Amdt Seq Combo Item <br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return List<RsltCdListVO>
     * @exception EventException
     */
    public List<RsltCdListVO> searchTRIProposalTAAAmdtSeqList (RsltTaaMnVO rsltTaaMnVO) throws EventException;

    /**
     * Retrieving Customer information<br>
     * 
     * @param PriSpCtrtPtyVO priSpCtrtPtyVO
     * @return List<RsltPropCustInfoVO>
     * @exception EventException
     */
    public List<RsltPropCustInfoVO> searchProposalCustomerInfo(PriSpCtrtPtyVO priSpCtrtPtyVO) throws EventException;

    /**
     * Retrieving TRI Proposal new TAA Proposal Number<br>
     * 
     * @param String ofcCd
     * @return String
     * @exception EventException
     */
    public String searchTRIProposalTAAPropNo(String ofcCd) throws EventException;

    /**
     * Retrieving TRI Proposal new TAA Number <br>
     * 
     * @param String ofcCd
     * @return String
     * @exception EventException
     */
    public String searchTRIProposalTAANo(String ofcCd) throws EventException;

    /**
     * Saving TRI Proposal TAA Header information<br>
     * 
     * @param RsltTaaMnVO[] rsltTaaMnVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageTRIProposalTAAHeader (RsltTaaMnVO[] rsltTaaMnVOs, SignOnUserAccount account) throws EventException;

    /**
     * Saving TRI Proposal TAA Main information.<br>
     * 
     * @param RsltTaaMnVO[] rsltTaaMnVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageTRIProposalTAAMain (RsltTaaMnVO[] rsltTaaMnVOs, SignOnUserAccount account) throws EventException;

    /**
     * Saving TRI Proposal TAA TRI List information<br>
     * 
     * @param RsltTaaTriListVO[] rsltTaaTriListVOs
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void manageTRIProposalTAAList (RsltTaaTriListVO[] rsltTaaTriListVOs, SignOnUserAccount account) throws EventException;
    
    /**
     * Confirming TRI Proposal TAA information<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void confirmTRIProposalTAA (RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException;

    /**
     * Canceling confirmation of TRI Proposal TAA information<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void confirmCancelTRIProposalTAA (RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException;

    /**
     * Deleting information of current TRI Proposal TAA .<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void cancelTRIProposalTAA (RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException;

    /**
     * Amending TRI Proposal TAA information.<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @param SignOnUserAccount account
     * @exception EventException
     */
    public void amendTRIProposalTAA (RsltTaaMnVO rsltTaaMnVO, SignOnUserAccount account) throws EventException;
    
    /**
     * Retrieving TRI Inquiry List <br>
     * 
     * @param PriTriMnVO priTriMnVO
     * @return List<RsltTaaMnVO>
     * @exception EventException
     */
    public List<RsltTaaMnVO> searchTRIProposalTAAInquiryList (PriTriMnVO priTriMnVO) throws EventException;

    /**
     * Retrieving TRI Proposal Select List<br>
     * 
     * @param RsltTaaTriListVO rsltTaaTriListVO
     * @return List<RsltTaaTriListVO>
     * @exception EventException
     */
    public List<RsltTaaTriListVO> searchTRIProposalSelectList(RsltTaaTriListVO rsltTaaTriListVO) throws EventException;

    /**
     * Retrieving TRI Proposal TAA No List  <br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return List<RsltTaaMnVO>
     * @exception EventException
     */
    public List<RsltTaaMnVO> searchTRIProposalTAANoList(RsltTaaMnVO rsltTaaMnVO) throws EventException;

    /**
     * Checking whether TRI Proposal TAA information is in use at Booking .<br>
     * 
     * @param RsltTaaMnVO rsltTaaMnVO
     * @return String[]
     * @exception EventException
     */
    public String[] searchTRIProposalTAACheckUseBkg(RsltTaaMnVO rsltTaaMnVO) throws EventException;

    /**
     * Retrieving TRI Proposal TAA 's approval authority<br>
     * 
     * @param PriAuthorizationVO priAuthorizationVO
     * @return String
     * @exception EventException
     */
    public String searchTRIProposalTAAApprovalAuth(PriAuthorizationVO priAuthorizationVO) throws EventException;
}